package c.a.a.k;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;

/* compiled from: NeuQuant.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f3030a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f3031b;

    /* renamed from: c, reason: collision with root package name */
    public int f3032c;

    /* renamed from: d, reason: collision with root package name */
    public int f3033d;

    /* renamed from: f, reason: collision with root package name */
    public int[] f3035f = new int[RecyclerView.c0.FLAG_TMP_DETACHED];

    /* renamed from: g, reason: collision with root package name */
    public int[] f3036g = new int[RecyclerView.c0.FLAG_TMP_DETACHED];

    /* renamed from: h, reason: collision with root package name */
    public int[] f3037h = new int[RecyclerView.c0.FLAG_TMP_DETACHED];

    /* renamed from: i, reason: collision with root package name */
    public int[] f3038i = new int[32];

    /* renamed from: e, reason: collision with root package name */
    public int[][] f3034e = new int[RecyclerView.c0.FLAG_TMP_DETACHED][];

    public c(byte[] bArr, int i2, int i3) {
        this.f3031b = bArr;
        this.f3032c = i2;
        this.f3033d = i3;
        for (int i4 = 0; i4 < 256; i4++) {
            int[][] iArr = this.f3034e;
            iArr[i4] = new int[4];
            int[] iArr2 = iArr[i4];
            int i5 = (i4 << 12) / RecyclerView.c0.FLAG_TMP_DETACHED;
            iArr2[2] = i5;
            iArr2[1] = i5;
            iArr2[0] = i5;
            this.f3037h[i4] = 256;
            this.f3036g[i4] = 0;
        }
    }

    public byte[] a() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[RecyclerView.c0.FLAG_TMP_DETACHED];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[this.f3034e[i2][3]] = i2;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < 256) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int[][] iArr2 = this.f3034e;
            bArr[i4] = (byte) iArr2[i5][0];
            int i7 = i6 + 1;
            bArr[i6] = (byte) iArr2[i5][1];
            bArr[i7] = (byte) iArr2[i5][2];
            i3++;
            i4 = i7 + 1;
        }
        return bArr;
    }

    public void b() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 256) {
            int[] iArr = this.f3034e[i2];
            int i5 = iArr[1];
            int i6 = i2 + 1;
            int i7 = i2;
            for (int i8 = i6; i8 < 256; i8++) {
                int[] iArr2 = this.f3034e[i8];
                if (iArr2[1] < i5) {
                    i5 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.f3034e[i7];
            if (i2 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i5 != i3) {
                this.f3035f[i3] = (i4 + i2) >> 1;
                while (true) {
                    i3++;
                    if (i3 >= i5) {
                        break;
                    } else {
                        this.f3035f[i3] = i2;
                    }
                }
                i4 = i2;
                i3 = i5;
            }
            i2 = i6;
        }
        this.f3035f[i3] = (i4 + ViewfinderView.OPAQUE) >> 1;
        for (int i13 = i3 + 1; i13 < 256; i13++) {
            this.f3035f[i13] = 255;
        }
    }

    public void c() {
        if (this.f3032c < 1509) {
            this.f3033d = 1;
        }
        int i2 = this.f3033d;
        this.f3030a = ((i2 - 1) / 3) + 30;
        byte[] bArr = this.f3031b;
        int i3 = this.f3032c;
        int i4 = i3 / (i2 * 3);
        int i5 = i4 / 100;
        for (int i6 = 0; i6 < 32; i6++) {
            this.f3038i[i6] = 1024 * (((1024 - (i6 * i6)) * RecyclerView.c0.FLAG_TMP_DETACHED) / 1024);
        }
        int i7 = this.f3032c;
        int i8 = i7 < 1509 ? 3 : i7 % 499 != 0 ? 1497 : i7 % 491 != 0 ? 1473 : i7 % 487 != 0 ? 1461 : 1509;
        int i9 = i5;
        int i10 = 0;
        int i11 = 2048;
        int i12 = 32;
        int i13 = 1024;
        int i14 = 0;
        while (i10 < i4) {
            int i15 = (bArr[i14 + 0] & ThreadUtils.TYPE_SINGLE) << 4;
            int i16 = (bArr[i14 + 1] & ThreadUtils.TYPE_SINGLE) << 4;
            int i17 = (bArr[i14 + 2] & ThreadUtils.TYPE_SINGLE) << 4;
            int a2 = a(i15, i16, i17);
            int i18 = i10;
            b(i13, a2, i15, i16, i17);
            if (i12 != 0) {
                a(i12, a2, i15, i16, i17);
            }
            int i19 = i14 + i8;
            if (i19 >= i3) {
                i19 -= this.f3032c;
            }
            i14 = i19;
            i10 = i18 + 1;
            if (i9 == 0) {
                i9 = 1;
            }
            if (i10 % i9 == 0) {
                i13 -= i13 / this.f3030a;
                i11 -= i11 / 30;
                int i20 = i11 >> 6;
                i12 = i20 <= 1 ? 0 : i20;
                for (int i21 = 0; i21 < i12; i21++) {
                    int i22 = i12 * i12;
                    this.f3038i[i21] = (((i22 - (i21 * i21)) * RecyclerView.c0.FLAG_TMP_DETACHED) / i22) * i13;
                }
            }
        }
    }

    public byte[] d() {
        c();
        e();
        b();
        return a();
    }

    public void e() {
        for (int i2 = 0; i2 < 256; i2++) {
            int[][] iArr = this.f3034e;
            int[] iArr2 = iArr[i2];
            iArr2[0] = iArr2[0] >> 4;
            int[] iArr3 = iArr[i2];
            iArr3[1] = iArr3[1] >> 4;
            int[] iArr4 = iArr[i2];
            iArr4[2] = iArr4[2] >> 4;
            iArr[i2][3] = i2;
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3 - i2;
        if (i7 < -1) {
            i7 = -1;
        }
        int i8 = i3 + i2;
        if (i8 > 256) {
            i8 = RecyclerView.c0.FLAG_TMP_DETACHED;
        }
        int i9 = i3 + 1;
        int i10 = i3 - 1;
        int i11 = 1;
        while (true) {
            if (i9 >= i8 && i10 <= i7) {
                return;
            }
            int i12 = i11 + 1;
            int i13 = this.f3038i[i11];
            if (i9 < i8) {
                int i14 = i9 + 1;
                int[] iArr = this.f3034e[i9];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i4) * i13) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i5) * i13) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i6) * i13) / 262144);
                } catch (Exception unused) {
                }
                i9 = i14;
            }
            if (i10 > i7) {
                int i15 = i10 - 1;
                int[] iArr2 = this.f3034e[i10];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i4) * i13) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i5) * i13) / 262144);
                    iArr2[2] = iArr2[2] - ((i13 * (iArr2[2] - i6)) / 262144);
                } catch (Exception unused2) {
                }
                i11 = i12;
                i10 = i15;
            } else {
                i11 = i12;
            }
        }
    }

    public int a(int i2, int i3, int i4) {
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < 256; i9++) {
            int[] iArr = this.f3034e[i9];
            int i10 = iArr[0] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = iArr[1] - i3;
            if (i11 < 0) {
                i11 = -i11;
            }
            int i12 = i10 + i11;
            int i13 = iArr[2] - i4;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            if (i14 < i5) {
                i7 = i9;
                i5 = i14;
            }
            int i15 = i14 - (this.f3036g[i9] >> 12);
            if (i15 < i6) {
                i8 = i9;
                i6 = i15;
            }
            int[] iArr2 = this.f3037h;
            int i16 = iArr2[i9] >> 10;
            iArr2[i9] = iArr2[i9] - i16;
            int[] iArr3 = this.f3036g;
            iArr3[i9] = iArr3[i9] + (i16 << 10);
        }
        int[] iArr4 = this.f3037h;
        iArr4[i7] = iArr4[i7] + 64;
        int[] iArr5 = this.f3036g;
        iArr5[i7] = iArr5[i7] - 65536;
        return i8;
    }

    public int b(int i2, int i3, int i4) {
        int i5 = this.f3035f[i3];
        int i6 = i5 - 1;
        int i7 = 1000;
        int i8 = -1;
        while (true) {
            if (i5 >= 256 && i6 < 0) {
                return i8;
            }
            if (i5 < 256) {
                int[] iArr = this.f3034e[i5];
                int i9 = iArr[1] - i3;
                if (i9 >= i7) {
                    i5 = RecyclerView.c0.FLAG_TMP_DETACHED;
                } else {
                    i5++;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = iArr[0] - i2;
                    if (i10 < 0) {
                        i10 = -i10;
                    }
                    int i11 = i9 + i10;
                    if (i11 < i7) {
                        int i12 = iArr[2] - i4;
                        if (i12 < 0) {
                            i12 = -i12;
                        }
                        int i13 = i11 + i12;
                        if (i13 < i7) {
                            i8 = iArr[3];
                            i7 = i13;
                        }
                    }
                }
            }
            if (i6 >= 0) {
                int[] iArr2 = this.f3034e[i6];
                int i14 = i3 - iArr2[1];
                if (i14 >= i7) {
                    i6 = -1;
                } else {
                    i6--;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = iArr2[0] - i2;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = i14 + i15;
                    if (i16 < i7) {
                        int i17 = iArr2[2] - i4;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i17 + i16;
                        if (i18 < i7) {
                            i8 = iArr2[3];
                            i7 = i18;
                        }
                    }
                }
            }
        }
    }

    public void b(int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.f3034e[i3];
        iArr[0] = iArr[0] - (((iArr[0] - i4) * i2) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i5) * i2) / 1024);
        iArr[2] = iArr[2] - ((i2 * (iArr[2] - i6)) / 1024);
    }
}
