package cn.jiguang.q;

import com.google.zxing.view.ViewfinderView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f9042d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f9043a;

    /* renamed from: b, reason: collision with root package name */
    public int f9044b;

    /* renamed from: c, reason: collision with root package name */
    public int f9045c;

    public a() {
        this(32);
    }

    public a(int i2) {
        this.f9043a = new byte[i2];
        this.f9044b = 0;
        this.f9045c = -1;
    }

    private void a(long j, int i2) {
        long j2 = 1 << i2;
        if (j < 0 || j > j2) {
            cn.jiguang.ai.a.d("JCommonPackager", j + " out of range for " + i2 + " bit value max:" + j2);
        }
    }

    private void b(int i2) {
        byte[] bArr = this.f9043a;
        int length = bArr.length;
        int i3 = this.f9044b;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f9043a, 0, bArr2, 0, this.f9044b);
        this.f9043a = bArr2;
    }

    public void a(int i2) {
        a(i2, 16);
        b(2);
        byte[] bArr = this.f9043a;
        int i3 = this.f9044b;
        int i4 = i3 + 1;
        this.f9044b = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        this.f9044b = i4 + 1;
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void a(long j) {
        b(8);
        byte[] bArr = this.f9043a;
        int i2 = this.f9044b;
        int i3 = i2 + 1;
        this.f9044b = i3;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        this.f9044b = i4;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        this.f9044b = i5;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        this.f9044b = i6;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        this.f9044b = i7;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        this.f9044b = i8;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        this.f9044b = i9;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        this.f9044b = i9 + 1;
        bArr[i9] = (byte) (j & 255);
    }

    public void a(byte[] bArr) {
        a(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) {
        b(i3);
        System.arraycopy(bArr, i2, this.f9043a, this.f9044b, i3);
        this.f9044b += i3;
    }

    public byte[] a() {
        int i2 = this.f9044b;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f9043a, 0, bArr, 0, i2);
        return bArr;
    }
}
