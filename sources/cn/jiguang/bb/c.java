package cn.jiguang.bb;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f8635a;

    /* renamed from: b, reason: collision with root package name */
    public int f8636b;

    /* renamed from: c, reason: collision with root package name */
    public int f8637c;

    /* renamed from: d, reason: collision with root package name */
    public byte f8638d;

    /* renamed from: e, reason: collision with root package name */
    public long f8639e;

    /* renamed from: f, reason: collision with root package name */
    public int f8640f;

    /* renamed from: g, reason: collision with root package name */
    public long f8641g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8642h;

    public c(boolean z, byte[] bArr) {
        this.f8642h = false;
        try {
            this.f8642h = z;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            short s = wrap.getShort();
            this.f8635a = s;
            this.f8635a = s & Short.MAX_VALUE;
            this.f8636b = wrap.get();
            this.f8637c = wrap.get();
            this.f8638d = wrap.get();
            wrap.get();
            wrap.getInt();
            this.f8639e = wrap.getShort();
            if (z) {
                this.f8640f = wrap.getInt();
            }
            this.f8641g = wrap.getLong();
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f8635a);
        sb.append(", version:");
        sb.append(this.f8636b);
        sb.append(", command:");
        sb.append(this.f8637c);
        sb.append(", rid:");
        sb.append(this.f8639e);
        if (this.f8642h) {
            str = ", sid:" + this.f8640f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f8641g);
        return sb.toString();
    }
}
