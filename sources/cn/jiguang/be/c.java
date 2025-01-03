package cn.jiguang.be;

import android.util.SparseArray;
import com.shix.shixipc.utilcode.NotificationUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<String> f8692a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f8692a = sparseArray;
        sparseArray.put(0, "OK");
        f8692a.put(-1001, "Exceed buffer size. Please contact support.");
        f8692a.put(NotificationUtils.IMPORTANCE_UNSPECIFIED, "Connection failed. Please check your connection and retry later!");
        f8692a.put(-998, "Sending failed or timeout. Please Retry later!");
        f8692a.put(-997, "Receiving failed or timeout. Please Retry later!");
        f8692a.put(-996, "Connection is closed. Please Retry later!");
        f8692a.put(-994, "Response timeout. Please Retry later!");
        f8692a.put(-993, "Invalid socket. Please Retry later!");
        f8692a.put(11, "Failed to register!");
        f8692a.put(1005, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        f8692a.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        f8692a.put(1007, "Invalid Imei, Register again.");
        f8692a.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        f8692a.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        f8692a.put(10000, "Receiver data parse error");
        f8692a.put(102, "102 - Incorrect password");
        f8692a.put(108, "108 - Incorrect uid");
        f8692a.put(1012, "Server reject this connection, will clear cache and restart connect.");
    }

    public static String a(int i2) {
        if (f8692a.get(i2) != null) {
            return f8692a.get(i2);
        }
        cn.jiguang.as.d.c("StatusCode", "Unknown error code - " + i2);
        return null;
    }
}
