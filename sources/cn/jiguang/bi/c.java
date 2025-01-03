package cn.jiguang.bi;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f8800a;

    /* renamed from: b, reason: collision with root package name */
    public int f8801b;

    /* renamed from: c, reason: collision with root package name */
    public int f8802c;

    /* renamed from: d, reason: collision with root package name */
    public Long f8803d;

    /* renamed from: e, reason: collision with root package name */
    public int f8804e;

    /* renamed from: f, reason: collision with root package name */
    public long f8805f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8806g;

    public c(boolean z, int i2, int i3, int i4, long j, int i5, long j2) {
        this.f8806g = false;
        this.f8806g = z;
        this.f8800a = i2;
        this.f8801b = i3;
        this.f8802c = i4;
        this.f8803d = Long.valueOf(j);
        this.f8804e = i5;
        this.f8805f = j2;
    }

    public c(boolean z, int i2, int i3, long j) {
        this(z, 0, i2, i3, j, 0, 0L);
    }

    public c(boolean z, byte[] bArr) {
        this.f8806g = false;
        this.f8806g = z;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s = wrap.getShort();
        this.f8800a = s;
        this.f8800a = s & Short.MAX_VALUE;
        this.f8801b = wrap.get();
        this.f8802c = wrap.get();
        Long valueOf = Long.valueOf(wrap.getLong());
        this.f8803d = valueOf;
        this.f8803d = Long.valueOf(valueOf.longValue() & 65535);
        if (z) {
            this.f8804e = wrap.getInt();
        }
        this.f8805f = wrap.getLong();
    }

    public int a() {
        return this.f8802c;
    }

    public void a(int i2) {
        this.f8800a = i2;
    }

    public void a(long j) {
        this.f8805f = j;
    }

    public Long b() {
        return this.f8803d;
    }

    public void b(int i2) {
        this.f8804e = i2;
    }

    public long c() {
        return this.f8805f;
    }

    public int d() {
        return this.f8804e;
    }

    public int e() {
        return this.f8801b;
    }

    public byte[] f() {
        if (this.f8800a == 0) {
            throw new IllegalStateException("The head is not initialized yet.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.putShort((short) this.f8800a);
        allocate.put((byte) this.f8801b);
        allocate.put((byte) this.f8802c);
        allocate.putLong(this.f8803d.longValue());
        if (this.f8806g) {
            allocate.putInt(this.f8804e);
        }
        allocate.putLong(this.f8805f);
        allocate.flip();
        return ProtocolUtil.getBytesConsumed(allocate);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f8800a);
        sb.append(", version:");
        sb.append(this.f8801b);
        sb.append(", command:");
        sb.append(this.f8802c);
        sb.append(", rid:");
        sb.append(this.f8803d);
        if (this.f8806g) {
            str = ", sid:" + this.f8804e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f8805f);
        return sb.toString();
    }
}
