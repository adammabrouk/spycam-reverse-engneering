package cn.jpush.android.ay;

import cn.jiguang.union.ads.api.JUnionAdError;
import com.shix.shixipc.utilcode.LogUtils;
import com.tencent.bugly.CrashModule;

/* loaded from: classes.dex */
public class a extends JUnionAdError {
    static {
        JUnionAdError.map.put(996, "Message JSON parsing failed");
        JUnionAdError.map.put(997, "Message already received, give up");
        JUnionAdError.map.put(998, "Message already received, still process");
        JUnionAdError.map.put(1028, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        JUnionAdError.map.put(1069, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        JUnionAdError.map.put(1001, "Message download succeed");
        JUnionAdError.map.put(1002, "Message received succeed");
        JUnionAdError.map.put(1003, "Message silence download succeed");
        JUnionAdError.map.put(CrashModule.MODULE_ID, "Video silence downlaod succeed");
        JUnionAdError.map.put(1005, "User clicked video and jumped to url Message (browser)");
        JUnionAdError.map.put(1008, "Video is force closed by user");
        JUnionAdError.map.put(1007, "User clicked 'OK'");
        JUnionAdError.map.put(1006, "User clicked 'Cancel'");
        JUnionAdError.map.put(1011, "Download failed");
        JUnionAdError.map.put(1012, "User clicked to download again");
        JUnionAdError.map.put(1013, "The file already exist and same size. Don't download again.");
        JUnionAdError.map.put(LogUtils.MAX_LEN, "Invalid param or unexpected result.");
        JUnionAdError.map.put(1014, "Failed to preload required resource");
        JUnionAdError.map.put(1015, "User clicked install alert on status bar after downloading finished.");
        JUnionAdError.map.put(1016, "User clicked the webview's url");
        JUnionAdError.map.put(1017, "User clicked call action");
        JUnionAdError.map.put(1019, "Click applist and show the Message");
        JUnionAdError.map.put(1020, "Down image failed");
        JUnionAdError.map.put(1021, "Down html failed");
        JUnionAdError.map.put(1022, "Down Message failed");
        JUnionAdError.map.put(1030, "Discard the message because it is not in the push time");
        JUnionAdError.map.put(1031, "Stop push service");
        JUnionAdError.map.put(1032, "Resume push service");
        JUnionAdError.map.put(1106, "the custom message show");
        JUnionAdError.map.put(1060, "need not show notification by foreground");
        JUnionAdError.map.put(1061, "need not show notification by isNeedShowNotification return false");
        JUnionAdError.map.put(1050, "ssp buildId error");
        JUnionAdError.map.put(1051, "ssp but no alert");
        JUnionAdError.map.put(1032, "MSG already cancle");
        JUnionAdError.map.put(1033, "overide msg already cancle");
        JUnionAdError.map.put(1034, "MSG already end");
        JUnionAdError.map.put(1035, "msg delay show");
        JUnionAdError.map.put(1036, "notification disabled");
        JUnionAdError.map.put(1037, "notification channel disabled");
        JUnionAdError.map.put(972, "Deep link set small icon failed");
        JUnionAdError.map.put(973, "Deep link set large icon failed");
        JUnionAdError.map.put(974, "Deep link- device in blacklist");
        JUnionAdError.map.put(975, "Deep link source error");
        JUnionAdError.map.put(976, "Deep link jump success");
        JUnionAdError.map.put(977, "Deep link jump failed");
        JUnionAdError.map.put(978, "Fail Deep link jump success");
        JUnionAdError.map.put(979, "Fail Deep link jump failed");
        JUnionAdError.map.put(981, "Deep link notify not show");
        JUnionAdError.map.put(980, "Deep link notify show");
        JUnionAdError.map.put(983, "wrong with resource file push_notification.xml");
        JUnionAdError.map.put(984, "unsupport night mode style, please check v21/push_notification.xml");
        JUnionAdError.map.put(993, "target app uninstall,not found target app small icon");
        JUnionAdError.map.put(985, "Deep link source is not empty and pkgname is empty but deeplink error");
        JUnionAdError.map.put(986, "Message is not in push time");
        JUnionAdError.map.put(988, "Deep link target app uninstalled");
        JUnionAdError.map.put(995, "Message JSON parsing succeed");
        JUnionAdError.map.put(1000, "User clicked and opened the Message");
        JUnionAdError.map.put(1068, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        JUnionAdError.map.put(1018, "The Message show in the status bar");
        JUnionAdError.map.put(1052, "Message count limit");
        JUnionAdError.map.put(1053, "Message interval limit");
        JUnionAdError.map.put(1054, "Message google limit");
        JUnionAdError.map.put(1070, "WX app is not original or not installed");
        JUnionAdError.map.put(1072, "WX appid does not match local");
        JUnionAdError.map.put(1071, "APP keystore sign not match");
        JUnionAdError.map.put(1073, "WX version too low to support mini");
        JUnionAdError.map.put(1074, "ssp wx miniprogram param error");
        JUnionAdError.map.put(1075, "Open WX miniprogram failed");
        JUnionAdError.map.put(1090, "User Click ssp notification Feedback -- button id is 1.");
        JUnionAdError.map.put(1091, "User Click ssp notification Feedback -- button id is 2.");
        JUnionAdError.map.put(1092, "User Click ssp notification Feedback -- button id is 3.");
        JUnionAdError.map.put(1093, "User Click ssp notification Feedback -- button id is 4.");
        JUnionAdError.map.put(1094, "User Click ssp notification Feedback - Show feed back");
        JUnionAdError.map.put(1096, "Current diy layout version is not support required ssp layout version");
        JUnionAdError.map.put(LogUtils.MAX_LEN, "missing resource file push_notification_middle.xml");
        JUnionAdError.map.put(1101, "missing  resource file push_notification_large.xml");
        JUnionAdError.map.put(1102, "device is not support larger notification");
        JUnionAdError.map.put(1097, "Same content in-app message display recently, ssp notification need not show.");
        JUnionAdError.map.put(1098, "in-app message display recently, ssp need delay to show");
        JUnionAdError.map.put(1080, "show notification make unknown error");
        JUnionAdError.map.put(1105, "ssp notification will not show by user");
    }

    public a() {
        super(0);
    }
}
