package com.shix.shixipc.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AppUtils {
    public static boolean checkApkExist(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList.contains(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (checkApkExist(r4, "com.android.vending") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return "com.android.vending";
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (checkApkExist(r4, "com.android.vending") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMarketPkg(android.content.Context r4) {
        /*
            r0 = 2131689549(0x7f0f004d, float:1.9008117E38)
            java.lang.String r0 = r4.getString(r0)
            java.lang.String r1 = "HDWIFI"
            boolean r0 = r0.equalsIgnoreCase(r1)
            java.lang.String r1 = "com.huawei.appmarket"
            java.lang.String r2 = "com.tencent.android.qqdownloader"
            java.lang.String r3 = "com.android.vending"
            if (r0 == 0) goto L2b
            boolean r0 = checkApkExist(r4, r2)
            if (r0 == 0) goto L1d
            r1 = r2
            goto L35
        L1d:
            boolean r0 = checkApkExist(r4, r1)
            if (r0 == 0) goto L24
            goto L35
        L24:
            boolean r4 = checkApkExist(r4, r3)
            if (r4 == 0) goto L33
            goto L31
        L2b:
            boolean r4 = checkApkExist(r4, r3)
            if (r4 == 0) goto L33
        L31:
            r1 = r3
            goto L35
        L33:
            java.lang.String r1 = ""
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.AppUtils.getMarketPkg(android.content.Context):java.lang.String");
    }

    public static String getMarketPkgGoogle(Context context) {
        return checkApkExist(context, "com.android.vending") ? "com.android.vending" : "";
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public static boolean isPackageExist(Context context, String str) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setPackage(str), 32);
        return queryIntentActivities != null && queryIntentActivities.size() >= 1;
    }
}
