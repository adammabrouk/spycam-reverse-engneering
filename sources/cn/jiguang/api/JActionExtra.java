package cn.jiguang.api;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class JActionExtra {
    public Object beforLogin(Context context, int i2, String str) {
        return null;
    }

    public Object beforRegister(Context context, int i2, String str) {
        return null;
    }

    public boolean checkAction(int i2) {
        return true;
    }

    public Object onSendData(Context context, long j, long j2, int i2, int i3) {
        return null;
    }
}
