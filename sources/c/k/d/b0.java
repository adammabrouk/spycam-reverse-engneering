package c.k.d;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f6977a;

    /* renamed from: b, reason: collision with root package name */
    public int f6978b;

    /* renamed from: c, reason: collision with root package name */
    public int f6979c;

    /* renamed from: d, reason: collision with root package name */
    public int f6980d;

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f6981e;

    /* renamed from: f, reason: collision with root package name */
    public int f6982f;

    /* renamed from: g, reason: collision with root package name */
    public int f6983g;

    /* renamed from: h, reason: collision with root package name */
    public int f6984h;

    /* renamed from: i, reason: collision with root package name */
    public int f6985i;
    public int j;
    public int k;

    public b0(InputStream inputStream) {
        this.f6984h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.f6977a = new byte[4096];
        this.f6978b = 0;
        this.f6980d = 0;
        this.f6981e = inputStream;
    }

    public b0(byte[] bArr, int i2, int i3) {
        this.f6984h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.f6977a = bArr;
        this.f6978b = i3 + i2;
        this.f6980d = i2;
        this.f6981e = null;
    }

    public static b0 a(InputStream inputStream) {
        return new b0(inputStream);
    }

    public static b0 a(byte[] bArr, int i2, int i3) {
        return new b0(bArr, i2, i3);
    }

    public byte a() {
        if (this.f6980d == this.f6978b) {
            a(true);
        }
        byte[] bArr = this.f6977a;
        int i2 = this.f6980d;
        this.f6980d = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m78a() {
        if (m89b()) {
            this.f6982f = 0;
            return 0;
        }
        int d2 = d();
        this.f6982f = d2;
        if (d2 != 0) {
            return d2;
        }
        throw r1.d();
    }

    public int a(int i2) {
        if (i2 < 0) {
            throw r1.b();
        }
        int i3 = i2 + this.f6983g + this.f6980d;
        int i4 = this.f6984h;
        if (i3 > i4) {
            throw r1.a();
        }
        this.f6984h = i3;
        m88b();
        return i4;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m79a() {
        return m90c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m80a() {
        int d2 = d();
        int i2 = this.f6978b;
        int i3 = this.f6980d;
        if (d2 > i2 - i3 || d2 <= 0) {
            return a.a(m86a(d2));
        }
        a a2 = a.a(this.f6977a, i3, d2);
        this.f6980d += d2;
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m81a() {
        int d2 = d();
        if (d2 > this.f6978b - this.f6980d || d2 <= 0) {
            return new String(m86a(d2), "UTF-8");
        }
        String str = new String(this.f6977a, this.f6980d, d2, "UTF-8");
        this.f6980d += d2;
        return str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m82a() {
        int m78a;
        do {
            m78a = m78a();
            if (m78a == 0) {
                return;
            }
        } while (m85a(m78a));
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m83a(int i2) {
        if (this.f6982f != i2) {
            throw r1.e();
        }
    }

    public void a(s2 s2Var) {
        int d2 = d();
        if (this.f6985i >= this.j) {
            throw r1.g();
        }
        int a2 = a(d2);
        this.f6985i++;
        s2Var.a(this);
        m83a(0);
        this.f6985i--;
        b(a2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m84a() {
        return d() != 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m85a(int i2) {
        int a2 = d4.a(i2);
        if (a2 == 0) {
            b();
            return true;
        }
        if (a2 == 1) {
            m91d();
            return true;
        }
        if (a2 == 2) {
            c(d());
            return true;
        }
        if (a2 == 3) {
            m82a();
            m83a(d4.a(d4.b(i2), 4));
            return true;
        }
        if (a2 == 4) {
            return false;
        }
        if (a2 != 5) {
            throw r1.f();
        }
        e();
        return true;
    }

    public final boolean a(boolean z) {
        int i2 = this.f6980d;
        int i3 = this.f6978b;
        if (i2 < i3) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i4 = this.f6983g;
        if (i4 + i3 == this.f6984h) {
            if (z) {
                throw r1.a();
            }
            return false;
        }
        this.f6983g = i4 + i3;
        this.f6980d = 0;
        InputStream inputStream = this.f6981e;
        int read = inputStream == null ? -1 : inputStream.read(this.f6977a);
        this.f6978b = read;
        if (read == 0 || read < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f6978b + "\nThe InputStream implementation is buggy.");
        }
        if (read == -1) {
            this.f6978b = 0;
            if (z) {
                throw r1.a();
            }
            return false;
        }
        m88b();
        int i5 = this.f6983g + this.f6978b + this.f6979c;
        if (i5 > this.k || i5 < 0) {
            throw r1.h();
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m86a(int i2) {
        if (i2 < 0) {
            throw r1.b();
        }
        int i3 = this.f6983g;
        int i4 = this.f6980d;
        int i5 = i3 + i4 + i2;
        int i6 = this.f6984h;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw r1.a();
        }
        int i7 = this.f6978b;
        if (i2 <= i7 - i4) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f6977a, i4, bArr, 0, i2);
            this.f6980d += i2;
            return bArr;
        }
        if (i2 >= 4096) {
            this.f6983g = i3 + i7;
            this.f6980d = 0;
            this.f6978b = 0;
            int i8 = i7 - i4;
            int i9 = i2 - i8;
            Vector vector = new Vector();
            while (i9 > 0) {
                int min = Math.min(i9, 4096);
                byte[] bArr2 = new byte[min];
                int i10 = 0;
                while (i10 < min) {
                    InputStream inputStream = this.f6981e;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i10, min - i10);
                    if (read == -1) {
                        throw r1.a();
                    }
                    this.f6983g += read;
                    i10 += read;
                }
                i9 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.f6977a, i4, bArr3, 0, i8);
            for (int i11 = 0; i11 < vector.size(); i11++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i11);
                System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                i8 += bArr4.length;
            }
            return bArr3;
        }
        byte[] bArr5 = new byte[i2];
        int i12 = i7 - i4;
        System.arraycopy(this.f6977a, i4, bArr5, 0, i12);
        this.f6980d = this.f6978b;
        while (true) {
            a(true);
            int i13 = i2 - i12;
            int i14 = this.f6978b;
            if (i13 <= i14) {
                System.arraycopy(this.f6977a, 0, bArr5, i12, i13);
                this.f6980d = i13;
                return bArr5;
            }
            System.arraycopy(this.f6977a, 0, bArr5, i12, i14);
            int i15 = this.f6978b;
            i12 += i15;
            this.f6980d = i15;
        }
    }

    public int b() {
        return d();
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m87b() {
        return m90c();
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m88b() {
        int i2 = this.f6978b + this.f6979c;
        this.f6978b = i2;
        int i3 = this.f6983g + i2;
        int i4 = this.f6984h;
        if (i3 <= i4) {
            this.f6979c = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f6979c = i5;
        this.f6978b = i2 - i5;
    }

    public void b(int i2) {
        this.f6984h = i2;
        m88b();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m89b() {
        return this.f6980d == this.f6978b && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m90c() {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i2;
            if ((a() & 128) == 0) {
                return j;
            }
        }
        throw r1.c();
    }

    public void c(int i2) {
        if (i2 < 0) {
            throw r1.b();
        }
        int i3 = this.f6983g;
        int i4 = this.f6980d;
        int i5 = i3 + i4 + i2;
        int i6 = this.f6984h;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw r1.a();
        }
        int i7 = this.f6978b;
        if (i2 <= i7 - i4) {
            this.f6980d = i4 + i2;
            return;
        }
        int i8 = i7 - i4;
        this.f6983g = i3 + i7;
        this.f6980d = 0;
        this.f6978b = 0;
        while (i8 < i2) {
            InputStream inputStream = this.f6981e;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
            if (skip <= 0) {
                throw r1.a();
            }
            i8 += skip;
            this.f6983g += skip;
        }
    }

    public int d() {
        int i2;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i3 = a2 & Byte.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i2 = a3 << 7;
        } else {
            i3 |= (a3 & Byte.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i2 = a4 << 14;
            } else {
                i3 |= (a4 & Byte.MAX_VALUE) << 14;
                byte a5 = a();
                if (a5 < 0) {
                    int i4 = i3 | ((a5 & Byte.MAX_VALUE) << 21);
                    byte a6 = a();
                    int i5 = i4 | (a6 << 28);
                    if (a6 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (a() >= 0) {
                            return i5;
                        }
                    }
                    throw r1.c();
                }
                i2 = a5 << 21;
            }
        }
        return i3 | i2;
    }

    /* renamed from: d, reason: collision with other method in class */
    public long m91d() {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & ThreadUtils.TYPE_SINGLE) | ((a() & ThreadUtils.TYPE_SINGLE) << 8) | ((a() & ThreadUtils.TYPE_SINGLE) << 16) | ((a() & ThreadUtils.TYPE_SINGLE) << 24);
    }
}
