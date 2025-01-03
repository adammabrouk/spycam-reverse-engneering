package c.k.d;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7012a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7013b;

    /* renamed from: c, reason: collision with root package name */
    public int f7014c;

    /* renamed from: d, reason: collision with root package name */
    public final OutputStream f7015d;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c1(OutputStream outputStream, byte[] bArr) {
        this.f7015d = outputStream;
        this.f7012a = bArr;
        this.f7014c = 0;
        this.f7013b = bArr.length;
    }

    public c1(byte[] bArr, int i2, int i3) {
        this.f7015d = null;
        this.f7012a = bArr;
        this.f7014c = i2;
        this.f7013b = i2 + i3;
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return d(i2);
        }
        return 10;
    }

    public static int a(int i2, int i3) {
        return c(i2) + a(i3);
    }

    public static int a(int i2, long j) {
        return c(i2) + a(j);
    }

    public static int a(int i2, c.k.d.a aVar) {
        return c(i2) + a(aVar);
    }

    public static int a(int i2, s2 s2Var) {
        return c(i2) + a(s2Var);
    }

    public static int a(int i2, String str) {
        return c(i2) + a(str);
    }

    public static int a(int i2, boolean z) {
        return c(i2) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(c.k.d.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int a(s2 s2Var) {
        int b2 = s2Var.b();
        return d(b2) + b2;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c1 a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c1 a(OutputStream outputStream, int i2) {
        return new c1(outputStream, new byte[i2]);
    }

    public static c1 a(byte[] bArr, int i2, int i3) {
        return new c1(bArr, i2, i3);
    }

    public static int b(int i2) {
        return d(i2);
    }

    public static int b(int i2, int i3) {
        return c(i2) + b(i3);
    }

    public static int b(int i2, long j) {
        return c(i2) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i2) {
        return d(d4.a(i2, 0));
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f7015d == null) {
            return this.f7013b - this.f7014c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m98a() {
        if (this.f7015d != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.f7014c == this.f7013b) {
            c();
        }
        byte[] bArr = this.f7012a;
        int i2 = this.f7014c;
        this.f7014c = i2 + 1;
        bArr[i2] = b2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m99a(int i2) {
        if (i2 >= 0) {
            m118d(i2);
        } else {
            m117c(i2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m100a(int i2, int i3) {
        c(i2, 0);
        m99a(i3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m101a(int i2, long j) {
        c(i2, 0);
        m106a(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m102a(int i2, c.k.d.a aVar) {
        c(i2, 2);
        m107a(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m103a(int i2, s2 s2Var) {
        c(i2, 2);
        m108a(s2Var);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m104a(int i2, String str) {
        c(i2, 2);
        m109a(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m105a(int i2, boolean z) {
        c(i2, 0);
        m110a(z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m106a(long j) {
        m117c(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m107a(c.k.d.a aVar) {
        byte[] m66a = aVar.m66a();
        m118d(m66a.length);
        a(m66a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m108a(s2 s2Var) {
        m118d(s2Var.a());
        s2Var.a(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m109a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m118d(bytes.length);
        a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m110a(boolean z) {
        m116c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m111a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m111a(byte[] bArr, int i2, int i3) {
        int i4 = this.f7013b;
        int i5 = this.f7014c;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f7012a, i5, i3);
            this.f7014c += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f7012a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f7014c = this.f7013b;
        c();
        if (i8 > this.f7013b) {
            this.f7015d.write(bArr, i7, i8);
        } else {
            System.arraycopy(bArr, i7, this.f7012a, 0, i8);
            this.f7014c = i8;
        }
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m112b(int i2) {
        m118d(i2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m113b(int i2, int i3) {
        c(i2, 0);
        m112b(i3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m114b(int i2, long j) {
        c(i2, 0);
        m115b(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m115b(long j) {
        m117c(j);
    }

    public final void c() {
        OutputStream outputStream = this.f7015d;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f7012a, 0, this.f7014c);
        this.f7014c = 0;
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m116c(int i2) {
        a((byte) i2);
    }

    public void c(int i2, int i3) {
        m118d(d4.a(i2, i3));
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m117c(long j) {
        while (((-128) & j) != 0) {
            m116c((((int) j) & 127) | RecyclerView.c0.FLAG_IGNORE);
            j >>>= 7;
        }
        m116c((int) j);
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m118d(int i2) {
        while ((i2 & (-128)) != 0) {
            m116c((i2 & 127) | RecyclerView.c0.FLAG_IGNORE);
            i2 >>>= 7;
        }
        m116c(i2);
    }
}
