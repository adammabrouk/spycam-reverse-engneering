package cn.jpush.android.api;

import android.os.Bundle;

/* loaded from: classes.dex */
public class CmdMessage {
    public int cmd;
    public int errorCode;
    public Bundle extra;
    public String msg;

    public CmdMessage(int i2, int i3) {
        this.cmd = i2;
        this.errorCode = i3;
    }

    public CmdMessage(int i2, int i3, String str) {
        this.cmd = i2;
        this.errorCode = i3;
        this.msg = str;
    }

    public CmdMessage(int i2, int i3, String str, Bundle bundle) {
        this.cmd = i2;
        this.errorCode = i3;
        this.msg = str;
        this.extra = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd=" + this.cmd + ", errorCode=" + this.errorCode + ", msg='" + this.msg + "', extra=" + this.extra + '}';
    }
}
