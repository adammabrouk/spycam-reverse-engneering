package cn.jiguang.bb;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f8643a;

    /* renamed from: b, reason: collision with root package name */
    public int f8644b;

    /* renamed from: c, reason: collision with root package name */
    public int f8645c;

    /* renamed from: d, reason: collision with root package name */
    public int f8646d;

    /* renamed from: e, reason: collision with root package name */
    public final c f8647e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f8648f;

    /* renamed from: g, reason: collision with root package name */
    public int f8649g;

    /* renamed from: h, reason: collision with root package name */
    public String f8650h;

    /* renamed from: i, reason: collision with root package name */
    public String f8651i;

    public d(c cVar, ByteBuffer byteBuffer) {
        this.f8647e = cVar;
        if (byteBuffer == null) {
            cn.jiguang.as.d.g("LoginResponse", "No body to parse.");
        } else {
            this.f8648f = byteBuffer;
            a();
        }
    }

    private void a() {
        try {
            this.f8643a = this.f8648f.getShort();
        } catch (Throwable unused) {
            this.f8643a = 10000;
        }
        if (this.f8643a > 0) {
            cn.jiguang.as.d.i("LoginResponse", "Response error - code:" + this.f8643a);
        }
        ByteBuffer byteBuffer = this.f8648f;
        this.f8646d = -1;
        int i2 = this.f8643a;
        if (i2 != 0) {
            if (i2 == 1012) {
                try {
                    this.f8651i = b.a(byteBuffer);
                } catch (Throwable unused2) {
                    this.f8643a = 10000;
                }
                cn.jiguang.aw.a.a(JCoreManager.getAppContext(null), this.f8651i);
                return;
            }
            return;
        }
        try {
            this.f8644b = byteBuffer.getInt();
            this.f8649g = byteBuffer.getShort();
            this.f8650h = b.a(byteBuffer);
            this.f8645c = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.f8643a = 10000;
        }
        try {
            this.f8646d = byteBuffer.get();
            cn.jiguang.as.d.c("LoginResponse", "idc parse success, value:" + this.f8646d);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("LoginResponse", "parse idc failed, error:" + th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.f8643a + ",sid:" + this.f8644b + ", serverVersion:" + this.f8649g + ", sessionKey:" + this.f8650h + ", serverTime:" + this.f8645c + ", idc:" + this.f8646d + ", connectInfo:" + this.f8651i;
    }
}
