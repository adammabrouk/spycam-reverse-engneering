package cn.jiguang.ay;

import com.google.zxing.view.ViewfinderView;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8495a;

    /* renamed from: b, reason: collision with root package name */
    public int f8496b;

    /* renamed from: c, reason: collision with root package name */
    public int f8497c;

    public c() {
        this(32);
    }

    public c(int i2) {
        this.f8495a = new byte[i2];
        this.f8496b = 0;
        this.f8497c = -1;
    }

    private void a(long j, int i2) {
        long j2 = 1 << i2;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + " out of range for " + i2 + " bit value");
        }
    }

    private void d(int i2) {
        byte[] bArr = this.f8495a;
        int length = bArr.length;
        int i3 = this.f8496b;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f8495a, 0, bArr2, 0, this.f8496b);
        this.f8495a = bArr2;
    }

    public int a() {
        return this.f8496b;
    }

    public void a(int i2) {
        if (i2 > this.f8496b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f8496b = i2;
    }

    public void a(int i2, int i3) {
        a(i2, 16);
        if (i3 > this.f8496b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f8495a;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        bArr[i3 + 1] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.f8495a;
        int i2 = this.f8496b;
        int i3 = i2 + 1;
        this.f8496b = i3;
        bArr[i2] = (byte) ((j >>> 24) & 255);
        int i4 = i3 + 1;
        this.f8496b = i4;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        int i5 = i4 + 1;
        this.f8496b = i5;
        bArr[i4] = (byte) ((j >>> 8) & 255);
        this.f8496b = i5 + 1;
        bArr[i5] = (byte) (j & 255);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) {
        d(i3);
        System.arraycopy(bArr, i2, this.f8495a, this.f8496b, i3);
        this.f8496b += i3;
    }

    public void b(int i2) {
        a(i2, 8);
        d(1);
        byte[] bArr = this.f8495a;
        int i3 = this.f8496b;
        this.f8496b = i3 + 1;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public byte[] b() {
        int i2 = this.f8496b;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f8495a, 0, bArr, 0, i2);
        return bArr;
    }

    public void c(int i2) {
        a(i2, 16);
        d(2);
        byte[] bArr = this.f8495a;
        int i3 = this.f8496b;
        int i4 = i3 + 1;
        this.f8496b = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        this.f8496b = i4 + 1;
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
    }
}
