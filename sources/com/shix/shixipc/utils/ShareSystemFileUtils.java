package com.shix.shixipc.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class ShareSystemFileUtils {
    public static final String[][] MATCH_ARRAY = {new String[]{".3gp", "video/3gpp"}, new String[]{".apk", "application/vnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{".avi", "video/x-msvideo"}, new String[]{".bin", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE}, new String[]{".bmp", "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".exe", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{".gz", "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "text/html"}, new String[]{".html", "text/html"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{".jpg", "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", AacPcmCoder.AUDIO_MIME}, new String[]{".m4b", AacPcmCoder.AUDIO_MIME}, new String[]{".m4p", AacPcmCoder.AUDIO_MIME}, new String[]{".m4u", "video/vnd.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{".mp3", "audio/x-mpeg"}, new String[]{".mp4", "video/mp4"}, new String[]{".mpc", "application/vnd.mpohun.certificate"}, new String[]{".mpe", "video/mpeg"}, new String[]{".mpeg", "video/mpeg"}, new String[]{".mpg", "video/mpeg"}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "application/vnd.ms-outlook"}, new String[]{".ogg", "audio/ogg"}, new String[]{".pdf", "application/pdf"}, new String[]{".png", "image/png"}, new String[]{".pps", "application/vnd.ms-powerpoint"}, new String[]{".ppt", "application/vnd.ms-powerpoint"}, new String[]{".prop", "text/plain"}, new String[]{".rar", "application/x-rar-compressed"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{CrashHandler.FILE_NAME_SUFFIX, "text/plain"}, new String[]{".wav", "audio/x-wav"}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "application/vnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/zip"}, new String[]{"", "*/*"}};
    public static final String PACKAGE_WECHAT = "com.tencent.mm";
    public static final int VERSION_CODE_FOR_WEI_XIN_VER7 = 1380;

    public static int getVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean isInstallApp(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (str.equals(installedPackages.get(i2).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void shareWechatFriend(Context context, File file) {
        String str;
        Uri fromFile;
        if (!isInstallApp(context, PACKAGE_WECHAT)) {
            Toast.makeText(context, "您需要安装微信客户端", 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(PACKAGE_WECHAT);
        intent.setAction("android.intent.action.SEND");
        int i2 = 0;
        while (true) {
            if (i2 >= MATCH_ARRAY.length) {
                str = "*/*";
                break;
            } else {
                if (file.getAbsolutePath().toString().contains(MATCH_ARRAY[i2][0].toString())) {
                    str = MATCH_ARRAY[i2][1];
                    break;
                }
                i2++;
            }
        }
        intent.setType(str);
        Uri uri = null;
        if (file != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24) {
                    fromFile = Uri.fromFile(file);
                } else {
                    fromFile = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".fileprovider", file);
                }
                uri = fromFile;
                intent.putExtra("android.intent.extra.STREAM", uri);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        intent.setFlags(268435456);
        if (getVersionCode(context, PACKAGE_WECHAT) > 1380) {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        context.startActivity(Intent.createChooser(intent, "分享文件"));
    }
}
