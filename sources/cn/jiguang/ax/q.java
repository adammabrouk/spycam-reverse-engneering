package cn.jiguang.ax;

import android.content.Context;

/* loaded from: classes.dex */
public class q extends cn.jiguang.bj.b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8486a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8487b;

    public q(Context context, byte[] bArr) {
        this.f8487b = context;
        this.f8486a = bArr;
        this.f8813h = "TcpRecvAction";
    }

    @Override // cn.jiguang.bj.b
    public void a() {
        try {
            cn.jiguang.az.h.a().a(this.f8487b, "tcp_a22", null);
            cn.jiguang.bb.a.a(this.f8487b, this.f8486a);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
