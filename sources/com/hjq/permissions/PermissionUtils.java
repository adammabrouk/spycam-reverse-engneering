package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.hjq.permissions.Permission;
import com.shix.shixipc.utils.CommonUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public final class PermissionUtils {
    public static <T> ArrayList<T> asArrayList(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @SafeVarargs
    public static <T> ArrayList<T> asArrayLists(T[]... tArr) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (tArr != null && tArr.length != 0) {
            for (T[] tArr2 : tArr) {
                arrayList.addAll(asArrayList(tArr2));
            }
        }
        return arrayList;
    }

    public static boolean containsSpecialPermission(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (isSpecialPermission(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Activity findActivity(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    @SuppressLint({"PrivateApi"})
    public static int findApkPathCookie(Context context) {
        AssetManager assets = context.getAssets();
        String str = context.getApplicationInfo().sourceDir;
        try {
            return ((Integer) assets.getClass().getDeclaredMethod("addOverlayPath", String.class).invoke(assets, str)).intValue();
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
                String[] strArr = (String[]) assets.getClass().getDeclaredMethod("getApkPaths", new Class[0]).invoke(assets, new Object[0]);
                if (strArr == null) {
                    return 0;
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (strArr[i2].equals(str)) {
                        return i2 + 1;
                    }
                }
                return 0;
            } catch (Exception e3) {
                e3.printStackTrace();
                return 0;
            }
        }
    }

    public static List<String> getDeniedPermissions(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (!isAndroid6()) {
            return arrayList;
        }
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == 0) {
                arrayList.add(strArr[i2]);
            }
        }
        return arrayList;
    }

    public static List<String> getManifestPermissions(Context context) {
        try {
            return asArrayList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getPermissionStatus(Context context, String str) {
        return isGrantedPermission(context, str) ? 0 : -1;
    }

    public static int getRandomRequestCode() {
        return new Random().nextInt((int) Math.pow(2.0d, 8.0d));
    }

    public static boolean isAndroid10() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAndroid6() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isAndroid7() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isAndroid8() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isAndroid9() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isGrantedInstallPermission(Context context) {
        if (isAndroid8()) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    public static boolean isGrantedNotifyPermission(Context context) {
        if (isAndroid7()) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (isAndroid6()) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                return ((Integer) appOpsManager.getClass().getMethod(CommonUtil.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField(CommonUtil.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public static boolean isGrantedPermission(Context context, String str) {
        if (!isAndroid6()) {
            return true;
        }
        if (Permission.MANAGE_EXTERNAL_STORAGE.equals(str)) {
            return isGrantedStoragePermission(context);
        }
        if (Permission.REQUEST_INSTALL_PACKAGES.equals(str)) {
            return isGrantedInstallPermission(context);
        }
        if (Permission.SYSTEM_ALERT_WINDOW.equals(str)) {
            return isGrantedWindowPermission(context);
        }
        if (Permission.NOTIFICATION_SERVICE.equals(str)) {
            return isGrantedNotifyPermission(context);
        }
        if (Permission.WRITE_SETTINGS.equals(str)) {
            return isGrantedSettingPermission(context);
        }
        if (!isAndroid10()) {
            if (Permission.ACCESS_BACKGROUND_LOCATION.equals(str)) {
                return context.checkSelfPermission(Permission.ACCESS_FINE_LOCATION) == 0;
            }
            if (Permission.ACTIVITY_RECOGNITION.equals(str)) {
                return context.checkSelfPermission(Permission.BODY_SENSORS) == 0;
            }
            if (Permission.ACCESS_MEDIA_LOCATION.equals(str)) {
                return true;
            }
        }
        if (!isAndroid9() && Permission.ACCEPT_HANDOVER.equals(str)) {
            return true;
        }
        if (!isAndroid8()) {
            if (Permission.ANSWER_PHONE_CALLS.equals(str)) {
                return true;
            }
            if (Permission.READ_PHONE_NUMBERS.equals(str)) {
                return context.checkSelfPermission(Permission.READ_PHONE_STATE) == 0;
            }
        }
        return context.checkSelfPermission(str) == 0;
    }

    public static boolean isGrantedPermissions(Context context, List<String> list) {
        if (!isAndroid6()) {
            return true;
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isGrantedPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGrantedSettingPermission(Context context) {
        if (isAndroid6()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    public static boolean isGrantedStoragePermission(Context context) {
        return isAndroid11() ? Environment.isExternalStorageManager() : isGrantedPermissions(context, asArrayList(Permission.Group.STORAGE));
    }

    public static boolean isGrantedWindowPermission(Context context) {
        if (isAndroid6()) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public static boolean isPermissionPermanentDenied(Activity activity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (isPermissionPermanentDenied(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecialPermission(String str) {
        return Permission.MANAGE_EXTERNAL_STORAGE.equals(str) || Permission.REQUEST_INSTALL_PACKAGES.equals(str) || Permission.SYSTEM_ALERT_WINDOW.equals(str) || Permission.NOTIFICATION_SERVICE.equals(str) || Permission.WRITE_SETTINGS.equals(str);
    }

    public static boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (!isAndroid6() || isSpecialPermission(str)) {
            return false;
        }
        if (isAndroid10() && Permission.ACCESS_BACKGROUND_LOCATION.equals(str) && !isGrantedPermission(activity, Permission.ACCESS_BACKGROUND_LOCATION) && !isGrantedPermission(activity, Permission.ACCESS_FINE_LOCATION)) {
            return !activity.shouldShowRequestPermissionRationale(Permission.ACCESS_FINE_LOCATION);
        }
        if (!isAndroid10()) {
            if (Permission.ACCESS_BACKGROUND_LOCATION.equals(str)) {
                return (isGrantedPermission(activity, Permission.ACCESS_FINE_LOCATION) || activity.shouldShowRequestPermissionRationale(Permission.ACCESS_FINE_LOCATION)) ? false : true;
            }
            if (Permission.ACTIVITY_RECOGNITION.equals(str)) {
                return (isGrantedPermission(activity, Permission.BODY_SENSORS) || activity.shouldShowRequestPermissionRationale(Permission.BODY_SENSORS)) ? false : true;
            }
            if (Permission.ACCESS_MEDIA_LOCATION.equals(str)) {
                return false;
            }
        }
        if (!isAndroid9() && Permission.ACCEPT_HANDOVER.equals(str)) {
            return false;
        }
        if (!isAndroid8()) {
            if (Permission.ANSWER_PHONE_CALLS.equals(str)) {
                return true;
            }
            if (Permission.READ_PHONE_NUMBERS.equals(str)) {
                return (isGrantedPermission(activity, Permission.READ_PHONE_STATE) || activity.shouldShowRequestPermissionRationale(Permission.READ_PHONE_STATE)) ? false : true;
            }
        }
        return (isGrantedPermission(activity, str) || activity.shouldShowRequestPermissionRationale(str)) ? false : true;
    }

    public static List<String> getDeniedPermissions(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == -1) {
                arrayList.add(strArr[i2]);
            }
        }
        return arrayList;
    }
}
