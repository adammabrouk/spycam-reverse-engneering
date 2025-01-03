package cn.jpush.android.bi;

import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.android.helper.Logger;
import com.google.zxing.view.ViewfinderView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f9597d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f9598a;

    /* renamed from: b, reason: collision with root package name */
    public int f9599b;

    /* renamed from: c, reason: collision with root package name */
    public int f9600c;

    public d() {
        this(32);
    }

    public d(int i2) {
        this.f9598a = new byte[i2];
        this.f9599b = 0;
        this.f9600c = -1;
    }

    private void a(long j, int i2) {
        long j2 = 1 << i2;
        if (j < 0 || j > j2) {
            Logger.w(OutputDataUtil.TAG, j + " out of range for " + i2 + " bit value max:" + j2);
        }
    }

    private void c(int i2) {
        byte[] bArr = this.f9598a;
        int length = bArr.length;
        int i3 = this.f9599b;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f9598a, 0, bArr2, 0, this.f9599b);
        this.f9598a = bArr2;
    }

    public void a(int i2) {
        a(i2, 8);
        c(1);
        byte[] bArr = this.f9598a;
        int i3 = this.f9599b;
        this.f9599b = i3 + 1;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void a(long j) {
        c(8);
        byte[] bArr = this.f9598a;
        int i2 = this.f9599b;
        int i3 = i2 + 1;
        this.f9599b = i3;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        this.f9599b = i4;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        this.f9599b = i5;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        this.f9599b = i6;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        this.f9599b = i7;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        this.f9599b = i8;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        this.f9599b = i9;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        this.f9599b = i9 + 1;
        bArr[i9] = (byte) (j & 255);
    }

    public void a(String str) {
        byte[] b2 = b.b(str);
        b(b2.length);
        a(b2, 0, b2.length);
    }

    public void a(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) {
        c(i3);
        System.arraycopy(bArr, i2, this.f9598a, this.f9599b, i3);
        this.f9599b += i3;
    }

    public byte[] a() {
        int i2 = this.f9599b;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f9598a, 0, bArr, 0, i2);
        return bArr;
    }

    public void b(int i2) {
        a(i2, 16);
        c(2);
        byte[] bArr = this.f9598a;
        int i3 = this.f9599b;
        int i4 = i3 + 1;
        this.f9599b = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        this.f9599b = i4 + 1;
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
    }
}
