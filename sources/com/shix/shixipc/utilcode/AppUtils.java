package com.shix.shixipc.utilcode;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.shix.shixipc.utilcode.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class AppUtils {

    public static class AppInfo {
        public Drawable icon;
        public boolean isSystem;
        public int minSdkVersion;
        public String name;
        public String packageName;
        public String packagePath;
        public int targetSdkVersion;
        public int versionCode;
        public String versionName;

        public AppInfo(String str, String str2, Drawable drawable, String str3, String str4, int i2, int i3, int i4, boolean z) {
            setName(str2);
            setIcon(drawable);
            setPackageName(str);
            setPackagePath(str3);
            setVersionName(str4);
            setVersionCode(i2);
            setMinSdkVersion(i3);
            setTargetSdkVersion(i4);
            setSystem(z);
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public int getMinSdkVersion() {
            return this.minSdkVersion;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public int getTargetSdkVersion() {
            return this.targetSdkVersion;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public void setMinSdkVersion(int i2) {
            this.minSdkVersion = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPackagePath(String str) {
            this.packagePath = str;
        }

        public void setSystem(boolean z) {
            this.isSystem = z;
        }

        public void setTargetSdkVersion(int i2) {
            this.targetSdkVersion = i2;
        }

        public void setVersionCode(int i2) {
            this.versionCode = i2;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public String toString() {
            return "{\n    pkg name: " + getPackageName() + "\n    app icon: " + getIcon() + "\n    app name: " + getName() + "\n    app path: " + getPackagePath() + "\n    app v name: " + getVersionName() + "\n    app v code: " + getVersionCode() + "\n    app v min: " + getMinSdkVersion() + "\n    app v target: " + getTargetSdkVersion() + "\n    is system: " + isSystem() + "\n}";
        }
    }

    public AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void exitApp() {
        UtilsBridge.finishAllActivities();
        System.exit(0);
    }

    public static AppInfo getApkInfo(File file) {
        if (file != null && file.isFile() && file.exists()) {
            return getApkInfo(file.getAbsolutePath());
        }
        return null;
    }

    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getApp().getPackageName());
    }

    public static int getAppIconId() {
        return getAppIconId(Utils.getApp().getPackageName());
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getApp().getPackageName());
    }

    public static int getAppMinSdkVersion() {
        return getAppMinSdkVersion(Utils.getApp().getPackageName());
    }

    public static String getAppName() {
        return getAppName(Utils.getApp().getPackageName());
    }

    public static String getAppPackageName() {
        return Utils.getApp().getPackageName();
    }

    public static String getAppPath() {
        return getAppPath(Utils.getApp().getPackageName());
    }

    public static Signature[] getAppSignatures() {
        return getAppSignatures(Utils.getApp().getPackageName());
    }

    public static List<String> getAppSignaturesHash(String str, String str2) {
        Signature[] appSignatures;
        ArrayList arrayList = new ArrayList();
        if (!UtilsBridge.isSpace(str) && (appSignatures = getAppSignatures(str)) != null && appSignatures.length > 0) {
            for (Signature signature : appSignatures) {
                arrayList.add(UtilsBridge.bytes2HexString(UtilsBridge.hashTemplate(signature.toByteArray(), str2)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0"));
            }
        }
        return arrayList;
    }

    public static List<String> getAppSignaturesMD5() {
        return getAppSignaturesMD5(Utils.getApp().getPackageName());
    }

    public static List<String> getAppSignaturesSHA1() {
        return getAppSignaturesSHA1(Utils.getApp().getPackageName());
    }

    public static List<String> getAppSignaturesSHA256() {
        return getAppSignaturesSHA256(Utils.getApp().getPackageName());
    }

    public static int getAppTargetSdkVersion() {
        return getAppTargetSdkVersion(Utils.getApp().getPackageName());
    }

    public static int getAppUid() {
        return getAppUid(Utils.getApp().getPackageName());
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp().getPackageName());
    }

    public static String getAppVersionName() {
        return getAppVersionName(Utils.getApp().getPackageName());
    }

    public static List<AppInfo> getAppsInfo() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = Utils.getApp().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        Iterator<PackageInfo> it = packageManager.getInstalledPackages(0).iterator();
        while (it.hasNext()) {
            AppInfo bean = getBean(packageManager, it.next());
            if (bean != null) {
                arrayList.add(bean);
            }
        }
        return arrayList;
    }

    public static AppInfo getBean(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i2 = packageInfo.versionCode;
        String str2 = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return new AppInfo(str2, "", null, "", str, i2, -1, -1, false);
        }
        return new AppInfo(str2, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, str, i2, Build.VERSION.SDK_INT >= 24 ? applicationInfo.minSdkVersion : -1, applicationInfo.targetSdkVersion, (applicationInfo.flags & 1) != 0);
    }

    public static void installApp(String str) {
        installApp(UtilsBridge.getFileByPath(str));
    }

    public static boolean isAppDebug() {
        return isAppDebug(Utils.getApp().getPackageName());
    }

    public static boolean isAppForeground() {
        return UtilsBridge.isAppForeground();
    }

    public static boolean isAppInstalled(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isAppRoot() {
        return UtilsBridge.execCmd("echo root", true).result == 0;
    }

    public static boolean isAppRunning(String str) {
        ActivityManager activityManager;
        if (!UtilsBridge.isSpace(str) && (activityManager = (ActivityManager) Utils.getApp().getSystemService("activity")) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            if (runningTasks != null && runningTasks.size() > 0) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().baseActivity;
                    if (componentName != null && str.equals(componentName.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() > 0) {
                Iterator<ActivityManager.RunningServiceInfo> it2 = runningServices.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next().service.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAppSystem() {
        return isAppSystem(Utils.getApp().getPackageName());
    }

    public static boolean isAppUpgraded() {
        try {
            return Utils.getApp().getPackageManager().getPackageInfo(getAppPackageName(), 0).firstInstallTime != Utils.getApp().getPackageManager().getPackageInfo(getAppPackageName(), 0).lastUpdateTime;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFirstTimeInstall() {
        try {
            return Utils.getApp().getPackageManager().getPackageInfo(getAppPackageName(), 0).firstInstallTime == Utils.getApp().getPackageManager().getPackageInfo(getAppPackageName(), 0).lastUpdateTime;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFirstTimeInstalled() {
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(Utils.getApp().getPackageName(), 0);
            return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static void launchApp(String str) {
        if (UtilsBridge.isSpace(str)) {
            return;
        }
        Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(str);
        if (launchAppIntent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
        } else {
            Utils.getApp().startActivity(launchAppIntent);
        }
    }

    public static void launchAppDetailsSettings() {
        launchAppDetailsSettings(Utils.getApp().getPackageName());
    }

    public static void registerAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsBridge.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static void relaunchApp() {
        relaunchApp(false);
    }

    public static void uninstallApp(String str) {
        if (UtilsBridge.isSpace(str)) {
            return;
        }
        Utils.getApp().startActivity(UtilsBridge.getUninstallAppIntent(str));
    }

    public static void unregisterAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsBridge.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static Drawable getAppIcon(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getAppIconId(String str) {
        if (UtilsBridge.isSpace(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static AppInfo getAppInfo(String str) {
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return getBean(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getAppMinSdkVersion(String str) {
        ApplicationInfo applicationInfo;
        if (UtilsBridge.isSpace(str) || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                return applicationInfo.minSdkVersion;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String getAppName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getAppPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Signature[] getAppSignatures(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (Build.VERSION.SDK_INT < 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo2 == null) {
                return null;
            }
            SigningInfo signingInfo = packageInfo2.signingInfo;
            return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<String> getAppSignaturesMD5(String str) {
        return getAppSignaturesHash(str, "MD5");
    }

    public static List<String> getAppSignaturesSHA1(String str) {
        return getAppSignaturesHash(str, "SHA1");
    }

    public static List<String> getAppSignaturesSHA256(String str) {
        return getAppSignaturesHash(str, "SHA256");
    }

    public static int getAppTargetSdkVersion(String str) {
        ApplicationInfo applicationInfo;
        if (UtilsBridge.isSpace(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                return applicationInfo.targetSdkVersion;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int getAppUid(String str) {
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int getAppVersionCode(String str) {
        if (UtilsBridge.isSpace(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String getAppVersionName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void installApp(File file) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(file);
        if (installAppIntent == null) {
            return;
        }
        Utils.getApp().startActivity(installAppIntent);
    }

    public static boolean isAppDebug(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return (Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isAppForeground(String str) {
        return !UtilsBridge.isSpace(str) && str.equals(UtilsBridge.getForegroundProcessName());
    }

    public static boolean isAppSystem(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return (Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void launchAppDetailsSettings(String str) {
        if (UtilsBridge.isSpace(str)) {
            return;
        }
        Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, true);
        if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
            Utils.getApp().startActivity(launchAppDetailsSettingsIntent);
        }
    }

    public static void relaunchApp(boolean z) {
        Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(Utils.getApp().getPackageName());
        if (launchAppIntent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        launchAppIntent.addFlags(335577088);
        Utils.getApp().startActivity(launchAppIntent);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static AppInfo getApkInfo(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (UtilsBridge.isSpace(str) || (packageManager = Utils.getApp().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return getBean(packageManager, packageArchiveInfo);
    }

    public static void installApp(Uri uri) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(uri);
        if (installAppIntent == null) {
            return;
        }
        Utils.getApp().startActivity(installAppIntent);
    }

    public static void launchAppDetailsSettings(Activity activity, int i2) {
        launchAppDetailsSettings(activity, i2, Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(Activity activity, int i2, String str) {
        if (activity == null || UtilsBridge.isSpace(str)) {
            return;
        }
        Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, false);
        if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
            activity.startActivityForResult(launchAppDetailsSettingsIntent, i2);
        }
    }

    public static Signature[] getAppSignatures(File file) {
        if (file == null) {
            return null;
        }
        PackageManager packageManager = Utils.getApp().getPackageManager();
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 134217728);
            if (packageArchiveInfo == null) {
                return null;
            }
            SigningInfo signingInfo = packageArchiveInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                return signingInfo.getApkContentsSigners();
            }
            return signingInfo.getSigningCertificateHistory();
        }
        PackageInfo packageArchiveInfo2 = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 64);
        if (packageArchiveInfo2 == null) {
            return null;
        }
        return packageArchiveInfo2.signatures;
    }
}
