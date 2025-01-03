package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class PermissionSettingPage {
    public static boolean areActivityIntent(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    public static Intent getApplicationDetailsIntent(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(getPackageNameUri(context));
        return intent;
    }

    public static Intent getInstallPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid8()) {
            intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(getPackageNameUri(context));
        } else {
            intent = null;
        }
        return (intent == null || !areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    public static Intent getNotifyPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid8()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent = null;
        }
        return (intent == null || !areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    public static Uri getPackageNameUri(Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    public static Intent getSettingPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid6()) {
            intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(getPackageNameUri(context));
        } else {
            intent = null;
        }
        return (intent == null || !areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    public static Intent getSmartPermissionIntent(Context context, List<String> list) {
        if (list == null || list.isEmpty() || !PermissionUtils.containsSpecialPermission(list)) {
            return getApplicationDetailsIntent(context);
        }
        if (PermissionUtils.isAndroid11() && list.size() == 3 && list.contains(Permission.MANAGE_EXTERNAL_STORAGE) && list.contains(Permission.READ_EXTERNAL_STORAGE) && list.contains(Permission.WRITE_EXTERNAL_STORAGE)) {
            return getStoragePermissionIntent(context);
        }
        if (list.size() == 1) {
            String str = list.get(0);
            if (Permission.MANAGE_EXTERNAL_STORAGE.equals(str)) {
                return getStoragePermissionIntent(context);
            }
            if (Permission.REQUEST_INSTALL_PACKAGES.equals(str)) {
                return getInstallPermissionIntent(context);
            }
            if (Permission.SYSTEM_ALERT_WINDOW.equals(str)) {
                return getWindowPermissionIntent(context);
            }
            if (Permission.NOTIFICATION_SERVICE.equals(str)) {
                return getNotifyPermissionIntent(context);
            }
            if (Permission.WRITE_SETTINGS.equals(str)) {
                return getSettingPermissionIntent(context);
            }
        }
        return getApplicationDetailsIntent(context);
    }

    public static Intent getStoragePermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid11()) {
            intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(getPackageNameUri(context));
        } else {
            intent = null;
        }
        return (intent == null || !areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    public static Intent getWindowPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid6()) {
            intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(getPackageNameUri(context));
        } else {
            intent = null;
        }
        return (intent == null || !areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }
}
