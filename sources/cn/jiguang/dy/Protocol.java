package cn.jiguang.dy;

import cn.jiguang.as.d;

/* loaded from: classes.dex */
public class Protocol {
    public static final String TAG = "Protocol";
    public static final String soName = "jcore312";

    static {
        try {
            System.loadLibrary("jcore312");
        } catch (Throwable th) {
            d.i("PushProtocol", "System.loadLibrary::jcore312" + th);
        }
    }

    public native int getVersion(int i2);
}
