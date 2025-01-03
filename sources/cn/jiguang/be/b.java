package cn.jiguang.be;

import cn.jiguang.e.f;
import com.google.zxing.view.ViewfinderView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f8688d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8689a;

    /* renamed from: b, reason: collision with root package name */
    public int f8690b;

    /* renamed from: c, reason: collision with root package name */
    public int f8691c;

    public b() {
        this(32);
    }

    public b(int i2) {
        this.f8689a = new byte[i2];
        this.f8690b = 0;
        this.f8691c = -1;
    }

    private void a(long j, int i2) {
        long j2 = 1 << i2;
        if (j < 0 || j > j2) {
            cn.jiguang.as.d.g("Outputer", j + " out of range for " + i2 + " bit value max:" + j2);
        }
    }

    private void c(int i2) {
        byte[] bArr = this.f8689a;
        int length = bArr.length;
        int i3 = this.f8690b;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f8689a, 0, bArr2, 0, this.f8690b);
        this.f8689a = bArr2;
    }

    public int a() {
        return this.f8690b;
    }

    public void a(int i2) {
        a(i2, 8);
        c(1);
        byte[] bArr = this.f8689a;
        int i3 = this.f8690b;
        this.f8690b = i3 + 1;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void a(int i2, int i3) {
        a(i2, 8);
        if (i3 > this.f8690b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f8689a[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void a(long j) {
        a(j, 32);
        c(4);
        byte[] bArr = this.f8689a;
        int i2 = this.f8690b;
        int i3 = i2 + 1;
        this.f8690b = i3;
        bArr[i2] = (byte) ((j >>> 24) & 255);
        int i4 = i3 + 1;
        this.f8690b = i4;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        int i5 = i4 + 1;
        this.f8690b = i5;
        bArr[i4] = (byte) ((j >>> 8) & 255);
        this.f8690b = i5 + 1;
        bArr[i5] = (byte) (j & 255);
    }

    public void a(String str) {
        byte[] i2 = f.i(str);
        b(i2.length);
        a(i2, 0, i2.length);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) {
        c(i3);
        System.arraycopy(bArr, i2, this.f8689a, this.f8690b, i3);
        this.f8690b += i3;
    }

    public void b(int i2) {
        a(i2, 16);
        c(2);
        byte[] bArr = this.f8689a;
        int i3 = this.f8690b;
        int i4 = i3 + 1;
        this.f8690b = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        this.f8690b = i4 + 1;
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void b(int i2, int i3) {
        a(i2, 16);
        if (i3 > this.f8690b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f8689a;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        bArr[i3 + 1] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void b(long j) {
        c(8);
        byte[] bArr = this.f8689a;
        int i2 = this.f8690b;
        int i3 = i2 + 1;
        this.f8690b = i3;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        this.f8690b = i4;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        this.f8690b = i5;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        this.f8690b = i6;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        this.f8690b = i7;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        this.f8690b = i8;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        this.f8690b = i9;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        this.f8690b = i9 + 1;
        bArr[i9] = (byte) (j & 255);
    }

    public byte[] b() {
        int i2 = this.f8690b;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f8689a, 0, bArr, 0, i2);
        return bArr;
    }
}
