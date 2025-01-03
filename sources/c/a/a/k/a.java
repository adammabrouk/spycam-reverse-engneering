package c.a.a.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: AnimatedGifEncoder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f3012a;

    /* renamed from: b, reason: collision with root package name */
    public int f3013b;

    /* renamed from: d, reason: collision with root package name */
    public int f3015d;

    /* renamed from: h, reason: collision with root package name */
    public OutputStream f3019h;

    /* renamed from: i, reason: collision with root package name */
    public Bitmap f3020i;
    public byte[] j;
    public byte[] k;
    public int l;
    public byte[] m;
    public boolean u;

    /* renamed from: c, reason: collision with root package name */
    public Integer f3014c = null;

    /* renamed from: e, reason: collision with root package name */
    public int f3016e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f3017f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3018g = false;
    public boolean[] n = new boolean[RecyclerView.c0.FLAG_TMP_DETACHED];
    public int o = 7;
    public int p = -1;
    public boolean q = false;
    public boolean r = true;
    public boolean s = false;
    public int t = 10;

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.f3018g) {
            return false;
        }
        try {
            if (!this.s) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f3020i = bitmap;
            c();
            a();
            if (this.r) {
                f();
                h();
                if (this.f3016e >= 0) {
                    g();
                }
            }
            d();
            e();
            if (!this.r) {
                h();
            }
            i();
            this.r = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void b(int i2) {
        this.f3017f = Math.round(i2 / 10.0f);
    }

    public final void c() {
        int width = this.f3020i.getWidth();
        int height = this.f3020i.getHeight();
        if (width != this.f3012a || height != this.f3013b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f3012a, this.f3013b, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.f3020i = createBitmap;
        }
        int i2 = width * height;
        int[] iArr = new int[i2];
        this.f3020i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.j = new byte[i2 * 3];
        this.u = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = iArr[i3];
            if (i6 == 0) {
                i4++;
            }
            byte[] bArr = this.j;
            int i7 = i5 + 1;
            bArr[i5] = (byte) (i6 & ViewfinderView.OPAQUE);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i6 >> 8) & ViewfinderView.OPAQUE);
            bArr[i8] = (byte) ((i6 >> 16) & ViewfinderView.OPAQUE);
            i3++;
            i5 = i8 + 1;
        }
        double d2 = i4 * 100;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        this.u = d4 > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + d4 + "% transparent pixels");
        }
    }

    public final void d() throws IOException {
        int i2;
        int i3;
        this.f3019h.write(33);
        this.f3019h.write(249);
        this.f3019h.write(4);
        if (this.f3014c != null || this.u) {
            i2 = 1;
            i3 = 2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i4 = this.p;
        if (i4 >= 0) {
            i3 = i4 & 7;
        }
        this.f3019h.write(i2 | (i3 << 2) | 0 | 0);
        c(this.f3017f);
        this.f3019h.write(this.f3015d);
        this.f3019h.write(0);
    }

    public final void e() throws IOException {
        this.f3019h.write(44);
        c(0);
        c(0);
        c(this.f3012a);
        c(this.f3013b);
        if (this.r) {
            this.f3019h.write(0);
        } else {
            this.f3019h.write(this.o | RecyclerView.c0.FLAG_IGNORE);
        }
    }

    public final void f() throws IOException {
        c(this.f3012a);
        c(this.f3013b);
        this.f3019h.write(this.o | 240);
        this.f3019h.write(0);
        this.f3019h.write(0);
    }

    public final void g() throws IOException {
        this.f3019h.write(33);
        this.f3019h.write(ViewfinderView.OPAQUE);
        this.f3019h.write(11);
        a("NETSCAPE2.0");
        this.f3019h.write(3);
        this.f3019h.write(1);
        c(this.f3016e);
        this.f3019h.write(0);
    }

    public final void h() throws IOException {
        OutputStream outputStream = this.f3019h;
        byte[] bArr = this.m;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.m.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f3019h.write(0);
        }
    }

    public final void i() throws IOException {
        new b(this.f3012a, this.f3013b, this.k, this.l).b(this.f3019h);
    }

    public boolean b() {
        boolean z;
        if (!this.f3018g) {
            return false;
        }
        this.f3018g = false;
        try {
            this.f3019h.write(59);
            this.f3019h.flush();
            if (this.q) {
                this.f3019h.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.f3015d = 0;
        this.f3019h = null;
        this.f3020i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.q = false;
        this.r = true;
        return z;
    }

    public void a(int i2, int i3) {
        if (!this.f3018g || this.r) {
            this.f3012a = i2;
            this.f3013b = i3;
            if (i2 < 1) {
                this.f3012a = 320;
            }
            if (this.f3013b < 1) {
                this.f3013b = 240;
            }
            this.s = true;
        }
    }

    public final void c(int i2) throws IOException {
        this.f3019h.write(i2 & ViewfinderView.OPAQUE);
        this.f3019h.write((i2 >> 8) & ViewfinderView.OPAQUE);
    }

    public boolean a(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.q = false;
        this.f3019h = outputStream;
        try {
            a("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.f3018g = z;
        return z;
    }

    public final void a() {
        byte[] bArr = this.j;
        int length = bArr.length;
        int i2 = length / 3;
        this.k = new byte[i2];
        c cVar = new c(bArr, length, this.t);
        this.m = cVar.d();
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.m;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i3];
            int i4 = i3 + 2;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b2;
            this.n[i3 / 3] = false;
            i3 += 3;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            byte[] bArr3 = this.j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int b3 = cVar.b(bArr3[i6] & ThreadUtils.TYPE_SINGLE, bArr3[i7] & ThreadUtils.TYPE_SINGLE, bArr3[i8] & ThreadUtils.TYPE_SINGLE);
            this.n[b3] = true;
            this.k[i5] = (byte) b3;
            i5++;
            i6 = i8 + 1;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        Integer num = this.f3014c;
        if (num != null) {
            this.f3015d = a(num.intValue());
        } else if (this.u) {
            this.f3015d = a(0);
        }
    }

    public final int a(int i2) {
        if (this.m == null) {
            return -1;
        }
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        int i3 = 16777216;
        int length = this.m.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            byte[] bArr = this.m;
            int i6 = i4 + 1;
            int i7 = red - (bArr[i4] & ThreadUtils.TYPE_SINGLE);
            int i8 = i6 + 1;
            int i9 = green - (bArr[i6] & ThreadUtils.TYPE_SINGLE);
            int i10 = blue - (bArr[i8] & ThreadUtils.TYPE_SINGLE);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            if (this.n[i12] && i11 < i3) {
                i3 = i11;
                i5 = i12;
            }
            i4 = i8 + 1;
        }
        return i5;
    }

    public final void a(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.f3019h.write((byte) str.charAt(i2));
        }
    }
}
