package cn.jiguang.bb;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f8652a;

    /* renamed from: b, reason: collision with root package name */
    public long f8653b;

    /* renamed from: c, reason: collision with root package name */
    public String f8654c;

    /* renamed from: d, reason: collision with root package name */
    public String f8655d;

    /* renamed from: e, reason: collision with root package name */
    public String f8656e;

    /* renamed from: f, reason: collision with root package name */
    public final c f8657f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f8658g;

    /* renamed from: h, reason: collision with root package name */
    public String f8659h;

    /* renamed from: i, reason: collision with root package name */
    public String f8660i;

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f8657f = cVar;
        if (byteBuffer == null) {
            cn.jiguang.as.d.g("RegisterResponse", "No body to parse.");
        } else {
            this.f8658g = byteBuffer;
            a();
        }
    }

    private void a() {
        try {
            this.f8652a = this.f8658g.getShort();
        } catch (Throwable unused) {
            this.f8652a = 10000;
        }
        if (this.f8652a > 0) {
            cn.jiguang.as.d.i("RegisterResponse", "Response error - code:" + this.f8652a);
        }
        ByteBuffer byteBuffer = this.f8658g;
        int i2 = this.f8652a;
        try {
            if (i2 == 0) {
                this.f8653b = byteBuffer.getLong();
                this.f8654c = b.a(byteBuffer);
                this.f8655d = b.a(byteBuffer);
            } else {
                if (i2 != 1007) {
                    if (i2 == 1012) {
                        try {
                            this.f8660i = b.a(byteBuffer);
                        } catch (Throwable unused2) {
                            this.f8652a = 10000;
                        }
                        cn.jiguang.aw.a.a(JCoreManager.getAppContext(null), this.f8660i);
                        return;
                    }
                    return;
                }
                this.f8659h = b.a(byteBuffer);
            }
        } catch (Throwable unused3) {
            this.f8652a = 10000;
        }
    }

    public String toString() {
        return "[RegisterResponse] - code:" + this.f8652a + ", juid:" + this.f8653b + ", password:" + this.f8654c + ", regId:" + this.f8655d + ", deviceId:" + this.f8656e + ", connectInfo:" + this.f8660i;
    }
}
