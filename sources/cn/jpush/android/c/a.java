package cn.jpush.android.c;

import android.os.Bundle;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f9685a;

    /* renamed from: b, reason: collision with root package name */
    public int f9686b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f9687c;

    public a(String str, int i2) {
        this.f9685a = str;
        this.f9686b = i2;
    }

    public int a() {
        return this.f9686b;
    }

    public void a(Bundle bundle) {
        this.f9687c = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd='" + this.f9685a + "', errorCode=" + this.f9686b + ", extra=" + this.f9687c + '}';
    }
}
