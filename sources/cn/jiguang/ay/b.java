package cn.jiguang.ay;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f8492a;

    /* renamed from: b, reason: collision with root package name */
    public int f8493b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f8494c = -1;

    public b(byte[] bArr) {
        this.f8492a = ByteBuffer.wrap(bArr);
    }

    private void c(int i2) {
        if (i2 > b()) {
            throw new IOException("end of input");
        }
    }

    public int a() {
        return this.f8492a.position();
    }

    public void a(int i2) {
        if (i2 > this.f8492a.capacity() - this.f8492a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f8492a;
        byteBuffer.limit(byteBuffer.position() + i2);
    }

    public void a(byte[] bArr, int i2, int i3) {
        c(i3);
        this.f8492a.get(bArr, i2, i3);
    }

    public int b() {
        return this.f8492a.remaining();
    }

    public void b(int i2) {
        if (i2 >= this.f8492a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f8492a.position(i2);
        ByteBuffer byteBuffer = this.f8492a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void c() {
        ByteBuffer byteBuffer = this.f8492a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d() {
        this.f8493b = this.f8492a.position();
        this.f8494c = this.f8492a.limit();
    }

    public void e() {
        int i2 = this.f8493b;
        if (i2 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f8492a.position(i2);
        this.f8492a.limit(this.f8494c);
        this.f8493b = -1;
        this.f8494c = -1;
    }

    public int f() {
        c(1);
        return this.f8492a.get() & ThreadUtils.TYPE_SINGLE;
    }

    public int g() {
        c(2);
        return this.f8492a.getShort() & 65535;
    }

    public long h() {
        c(4);
        return this.f8492a.getInt() & 4294967295L;
    }
}
