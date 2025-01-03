package c.a.a.k;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: LZWEncoder.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f3021a;

    /* renamed from: b, reason: collision with root package name */
    public int f3022b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3023c;

    /* renamed from: d, reason: collision with root package name */
    public int f3024d;

    /* renamed from: e, reason: collision with root package name */
    public int f3025e;

    /* renamed from: f, reason: collision with root package name */
    public int f3026f;

    /* renamed from: g, reason: collision with root package name */
    public int f3027g;

    /* renamed from: i, reason: collision with root package name */
    public int f3029i;
    public int p;
    public int q;
    public int r;
    public int v;

    /* renamed from: h, reason: collision with root package name */
    public int f3028h = 12;
    public int j = 4096;
    public int[] k = new int[5003];
    public int[] l = new int[5003];
    public int m = 5003;
    public int n = 0;
    public boolean o = false;
    public int s = 0;
    public int t = 0;
    public int[] u = {0, 1, 3, 7, 15, 31, 63, 127, ViewfinderView.OPAQUE, 511, 1023, 2047, 4095, 8191, 16383, 32767, ContentCommon.INVALID_OPTION};
    public byte[] w = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];

    public b(int i2, int i3, byte[] bArr, int i4) {
        this.f3021a = i2;
        this.f3022b = i3;
        this.f3023c = bArr;
        this.f3024d = Math.max(2, i4);
    }

    public final int a(int i2) {
        return (1 << i2) - 1;
    }

    public void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.w;
        int i2 = this.v;
        int i3 = i2 + 1;
        this.v = i3;
        bArr[i2] = b2;
        if (i3 >= 254) {
            c(outputStream);
        }
    }

    public void b(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3] = -1;
        }
    }

    public void c(OutputStream outputStream) throws IOException {
        int i2 = this.v;
        if (i2 > 0) {
            outputStream.write(i2);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.f3024d);
        this.f3025e = this.f3021a * this.f3022b;
        this.f3026f = 0;
        a(this.f3024d + 1, outputStream);
        outputStream.write(0);
    }

    public void a(OutputStream outputStream) throws IOException {
        b(this.m);
        int i2 = this.q;
        this.n = i2 + 2;
        this.o = true;
        b(i2, outputStream);
    }

    public void a(int i2, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.p = i2;
        int i3 = 0;
        this.o = false;
        this.f3027g = i2;
        this.f3029i = a(i2);
        int i4 = 1 << (i2 - 1);
        this.q = i4;
        this.r = i4 + 1;
        this.n = i4 + 2;
        this.v = 0;
        int a2 = a();
        for (int i5 = this.m; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.m;
        b(i7);
        b(this.q, outputStream);
        while (true) {
            int a3 = a();
            if (a3 != -1) {
                int i8 = (a3 << this.f3028h) + a2;
                int i9 = (a3 << i6) ^ a2;
                int[] iArr2 = this.k;
                if (iArr2[i9] == i8) {
                    a2 = this.l[i9];
                } else {
                    if (iArr2[i9] >= 0) {
                        int i10 = i7 - i9;
                        if (i9 == 0) {
                            i10 = 1;
                        }
                        do {
                            i9 -= i10;
                            if (i9 < 0) {
                                i9 += i7;
                            }
                            iArr = this.k;
                            if (iArr[i9] == i8) {
                                a2 = this.l[i9];
                                break;
                            }
                        } while (iArr[i9] >= 0);
                    }
                    b(a2, outputStream);
                    int i11 = this.n;
                    if (i11 < this.j) {
                        int[] iArr3 = this.l;
                        this.n = i11 + 1;
                        iArr3[i9] = i11;
                        this.k[i9] = i8;
                    } else {
                        a(outputStream);
                    }
                    a2 = a3;
                }
            } else {
                b(a2, outputStream);
                b(this.r, outputStream);
                return;
            }
        }
    }

    public void b(int i2, OutputStream outputStream) throws IOException {
        int i3 = this.s;
        int[] iArr = this.u;
        int i4 = this.t;
        int i5 = i3 & iArr[i4];
        this.s = i5;
        if (i4 > 0) {
            this.s = i5 | (i2 << i4);
        } else {
            this.s = i2;
        }
        this.t += this.f3027g;
        while (this.t >= 8) {
            a((byte) (this.s & ViewfinderView.OPAQUE), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.f3029i || this.o) {
            if (this.o) {
                int i6 = this.p;
                this.f3027g = i6;
                this.f3029i = a(i6);
                this.o = false;
            } else {
                int i7 = this.f3027g + 1;
                this.f3027g = i7;
                if (i7 == this.f3028h) {
                    this.f3029i = this.j;
                } else {
                    this.f3029i = a(i7);
                }
            }
        }
        if (i2 == this.r) {
            while (this.t > 0) {
                a((byte) (this.s & ViewfinderView.OPAQUE), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            c(outputStream);
        }
    }

    public final int a() {
        int i2 = this.f3025e;
        if (i2 == 0) {
            return -1;
        }
        this.f3025e = i2 - 1;
        byte[] bArr = this.f3023c;
        int i3 = this.f3026f;
        this.f3026f = i3 + 1;
        return bArr[i3] & ThreadUtils.TYPE_SINGLE;
    }
}
