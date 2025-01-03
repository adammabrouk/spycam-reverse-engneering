package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class XXPermissions {
    public static final int REQUEST_CODE = 1025;
    public static Boolean sDebugMode;
    public static IPermissionInterceptor sPermissionInterceptor;
    public static boolean sScopedStorage;
    public final Context mContext;
    public List<String> mPermissions;

    public XXPermissions(Context context) {
        this.mContext = context;
    }

    public static List<String> getDenied(Context context, String... strArr) {
        return getDenied(context, PermissionUtils.asArrayList(strArr));
    }

    public static IPermissionInterceptor getInterceptor() {
        if (sPermissionInterceptor == null) {
            sPermissionInterceptor = new IPermissionInterceptor() { // from class: com.hjq.permissions.XXPermissions.1
                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void deniedPermissions(Activity activity, OnPermissionCallback onPermissionCallback, List<String> list, boolean z) {
                    onPermissionCallback.onDenied(list, z);
                }

                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void grantedPermissions(Activity activity, OnPermissionCallback onPermissionCallback, List<String> list, boolean z) {
                    onPermissionCallback.onGranted(list, z);
                }

                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void requestPermissions(Activity activity, OnPermissionCallback onPermissionCallback, List<String> list) {
                    PermissionFragment.beginRequest(activity, new ArrayList(list), onPermissionCallback);
                }
            };
        }
        return sPermissionInterceptor;
    }

    public static boolean isDebugMode(Context context) {
        if (sDebugMode == null) {
            sDebugMode = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return sDebugMode.booleanValue();
    }

    public static boolean isGranted(Context context, String... strArr) {
        return isGranted(context, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isPermanentDenied(Activity activity, String... strArr) {
        return isPermanentDenied(activity, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isScopedStorage() {
        return sScopedStorage;
    }

    public static boolean isSpecial(String str) {
        return PermissionUtils.isSpecialPermission(str);
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = Boolean.valueOf(z);
    }

    public static void setInterceptor(IPermissionInterceptor iPermissionInterceptor) {
        sPermissionInterceptor = iPermissionInterceptor;
    }

    public static void setScopedStorage(boolean z) {
        sScopedStorage = z;
    }

    public static void startPermissionActivity(Context context) {
        startPermissionActivity(context, (List<String>) null);
    }

    public static XXPermissions with(Context context) {
        return new XXPermissions(context);
    }

    public XXPermissions permission(String... strArr) {
        return permission(PermissionUtils.asArrayList(strArr));
    }

    public void request(OnPermissionCallback onPermissionCallback) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        boolean isDebugMode = isDebugMode(context);
        Activity findActivity = PermissionUtils.findActivity(this.mContext);
        if (PermissionChecker.checkActivityStatus(findActivity, isDebugMode) && PermissionChecker.checkPermissionArgument(this.mPermissions, isDebugMode)) {
            if (isDebugMode) {
                PermissionChecker.checkStoragePermission(this.mContext, this.mPermissions, isScopedStorage());
                PermissionChecker.checkLocationPermission(this.mPermissions);
                PermissionChecker.checkTargetSdkVersion(this.mContext, this.mPermissions);
            }
            PermissionChecker.optimizeDeprecatedPermission(this.mPermissions);
            if (isDebugMode) {
                PermissionChecker.checkPermissionManifest(this.mContext, this.mPermissions);
            }
            if (!PermissionUtils.isGrantedPermissions(this.mContext, this.mPermissions)) {
                getInterceptor().requestPermissions(findActivity, onPermissionCallback, this.mPermissions);
            } else if (onPermissionCallback != null) {
                onPermissionCallback.onGranted(this.mPermissions, true);
            }
        }
    }

    public static List<String> getDenied(Context context, String[]... strArr) {
        return getDenied(context, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isGranted(Context context, String[]... strArr) {
        return isGranted(context, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isPermanentDenied(Activity activity, String[]... strArr) {
        return isPermanentDenied(activity, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(Context context, String... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayList(strArr));
    }

    public static XXPermissions with(Fragment fragment) {
        return with(fragment.getActivity());
    }

    public XXPermissions permission(String[]... strArr) {
        return permission(PermissionUtils.asArrayLists(strArr));
    }

    public static List<String> getDenied(Context context, List<String> list) {
        return PermissionUtils.getDeniedPermissions(context, list);
    }

    public static boolean isGranted(Context context, List<String> list) {
        return PermissionUtils.isGrantedPermissions(context, list);
    }

    public static boolean isPermanentDenied(Activity activity, List<String> list) {
        return PermissionUtils.isPermissionPermanentDenied(activity, list);
    }

    public static void startPermissionActivity(Context context, String[]... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayLists(strArr));
    }

    public static XXPermissions with(androidx.fragment.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public XXPermissions permission(List<String> list) {
        List<String> list2 = this.mPermissions;
        if (list2 == null) {
            this.mPermissions = list;
        } else {
            list2.addAll(list);
        }
        return this;
    }

    public static void startPermissionActivity(Context context, List<String> list) {
        Activity findActivity = PermissionUtils.findActivity(context);
        if (findActivity != null) {
            startPermissionActivity(findActivity, list);
            return;
        }
        Intent smartPermissionIntent = PermissionSettingPage.getSmartPermissionIntent(context, list);
        if (!(context instanceof Activity)) {
            smartPermissionIntent.addFlags(268435456);
        }
        context.startActivity(smartPermissionIntent);
    }

    public static void startPermissionActivity(Activity activity) {
        startPermissionActivity(activity, (List<String>) null);
    }

    public static void startPermissionActivity(Activity activity, String... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(Activity activity, String[]... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(Activity activity, List<String> list) {
        startPermissionActivity(activity, list, REQUEST_CODE);
    }

    public static void startPermissionActivity(Activity activity, List<String> list, int i2) {
        activity.startActivityForResult(PermissionSettingPage.getSmartPermissionIntent(activity, list), i2);
    }

    public static void startPermissionActivity(Fragment fragment) {
        startPermissionActivity(fragment, (List<String>) null);
    }

    public static void startPermissionActivity(Fragment fragment, String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(Fragment fragment, String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(Fragment fragment, List<String> list) {
        startPermissionActivity(fragment, list, REQUEST_CODE);
    }

    public static void startPermissionActivity(Fragment fragment, List<String> list, int i2) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        fragment.startActivityForResult(PermissionSettingPage.getSmartPermissionIntent(activity, list), i2);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment) {
        startPermissionActivity(fragment, (List<String>) null);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, List<String> list) {
        startPermissionActivity(fragment, list, REQUEST_CODE);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, List<String> list, int i2) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        fragment.startActivityForResult(PermissionSettingPage.getSmartPermissionIntent(activity, list), i2);
    }
}
