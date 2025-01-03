package cn.jpush.android.helper;

import android.text.TextUtils;
import android.util.SparseArray;
import cn.jiguang.union.ads.api.JUnionAdError;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<String> f9756a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f9756a = sparseArray;
        sparseArray.put(1060, "need not show notification by foreground");
        f9756a.put(1061, "need not show notification by isNeedShowNotification return false");
        f9756a.put(1032, "MSG already cancle");
        f9756a.put(1033, "overide msg already cancle");
        f9756a.put(1034, "MSG already end");
        f9756a.put(1035, "msg delay show");
        f9756a.put(1036, "notification disabled");
        f9756a.put(1037, "notification channel disabled");
        f9756a.put(972, "Deep link set small icon failed");
        f9756a.put(973, "Deep link set large icon failed");
        f9756a.put(976, "Deep link jump success");
        f9756a.put(977, "Deep link jump failed");
        f9756a.put(978, "Fail Deep link jump success");
        f9756a.put(979, "Fail Deep link jump failed");
        f9756a.put(993, "target app uninstall,not found target app small icon");
        f9756a.put(986, "Message is not in push time");
        f9756a.put(988, "Deep link target app uninstalled");
        f9756a.put(995, "Message JSON parsing succeed");
        f9756a.put(996, "Message JSON parsing failed");
        f9756a.put(1000, "User clicked and opened the Message");
        f9756a.put(1028, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        f9756a.put(1068, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        f9756a.put(1069, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        f9756a.put(1006, "User clicked 'Cancel'");
        f9756a.put(LogUtils.MAX_LEN, "Invalid param or unexpected result.");
        f9756a.put(1014, "Failed to preload required resource");
        f9756a.put(1016, "User clicked the webview's url");
        f9756a.put(1018, "The Message show in the status bar");
        f9756a.put(1020, "Down image failed");
        f9756a.put(1021, "Down html failed");
        f9756a.put(1075, "Open WX miniprogram failed");
        f9756a.put(1080, "show notification make unknown error");
        f9756a.put(1106, "the custom message show");
        f9756a.put(1600, "notify in app message show");
        f9756a.put(1601, "notify in app message click");
        f9756a.put(1602, "notify in app message cancel");
        f9756a.put(1603, "notify in app message is expired");
        f9756a.put(1604, "notify in app message display failed");
        f9756a.put(1605, "notify in app message deeplink jump succeed");
        f9756a.put(1606, "notify in app message deeplink jump failed");
    }

    public static String a(int i2) {
        if (f9756a.get(i2) != null) {
            return f9756a.get(i2);
        }
        String message = JUnionAdError.getMessage(i2);
        if (!TextUtils.isEmpty(message)) {
            return message;
        }
        Logger.d("StatusCode", "Unknown report code - " + i2);
        return "";
    }
}
