package c.k.d;

import android.text.TextUtils;

/* loaded from: classes.dex */
public enum n4 {
    COMMAND_REGISTER("register"),
    COMMAND_UNREGISTER("unregister"),
    COMMAND_SET_ALIAS("set-alias"),
    COMMAND_UNSET_ALIAS("unset-alias"),
    COMMAND_SET_ACCOUNT("set-account"),
    COMMAND_UNSET_ACCOUNT("unset-account"),
    COMMAND_SUBSCRIBE_TOPIC("subscribe-topic"),
    COMMAND_UNSUBSCRIBE_TOPIC("unsubscibe-topic"),
    COMMAND_SET_ACCEPT_TIME("accept-time"),
    COMMAND_CHK_VDEVID("check-vdeviceid");


    /* renamed from: a, reason: collision with other field name */
    public final String f67a;

    n4(String str) {
        this.f67a = str;
    }

    public static int a(String str) {
        int i2 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (n4 n4Var : values()) {
            if (n4Var.f67a.equals(str)) {
                i2 = i4.a(n4Var);
            }
        }
        return i2;
    }
}
