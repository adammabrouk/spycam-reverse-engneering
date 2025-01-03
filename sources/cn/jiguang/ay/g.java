package cn.jiguang.ay;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class g implements Serializable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8515a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f8516b;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f8517f = {0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f8518g = {1, 42};

    /* renamed from: h, reason: collision with root package name */
    public static final DecimalFormat f8519h;

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f8520i;
    public static final g j;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f8521c;

    /* renamed from: d, reason: collision with root package name */
    public long f8522d;

    /* renamed from: e, reason: collision with root package name */
    public int f8523e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f8519h = decimalFormat;
        f8520i = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
        decimalFormat.setMinimumIntegerDigits(3);
        int i2 = 0;
        while (true) {
            byte[] bArr = f8520i;
            if (i2 >= bArr.length) {
                g gVar = new g();
                f8515a = gVar;
                gVar.b(f8517f, 0, 1);
                g gVar2 = new g();
                f8516b = gVar2;
                gVar2.f8521c = new byte[0];
                g gVar3 = new g();
                j = gVar3;
                gVar3.b(f8518g, 0, 1);
                return;
            }
            if (i2 < 65 || i2 > 90) {
                f8520i[i2] = (byte) i2;
            } else {
                bArr[i2] = (byte) ((i2 - 65) + 97);
            }
            i2++;
        }
    }

    public g() {
    }

    public g(b bVar) {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int f2 = bVar.f();
            int i2 = f2 & 192;
            if (i2 != 0) {
                if (i2 != 192) {
                    throw new IOException("bad label type");
                }
                int f3 = bVar.f() + ((f2 & (-193)) << 8);
                if (f3 >= bVar.a() - 2) {
                    throw new IOException("bad compression");
                }
                if (!z2) {
                    bVar.d();
                    z2 = true;
                }
                bVar.b(f3);
            } else {
                if (d() >= 128) {
                    throw new IOException("too many labels");
                }
                if (f2 == 0) {
                    a(f8517f, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) f2;
                    bVar.a(bArr, 1, f2);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            bVar.e();
        }
    }

    public g(g gVar, int i2) {
        int b2 = gVar.b();
        if (i2 > b2) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.f8521c = gVar.f8521c;
        int i3 = b2 - i2;
        b(i3);
        for (int i4 = 0; i4 < 7 && i4 < i3; i4++) {
            a(i4, gVar.a(i4 + i2));
        }
    }

    public g(String str, g gVar) {
        int i2;
        boolean z;
        int i3;
        if (str.equals("")) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (gVar == null) {
                b(f8516b, this);
                return;
            } else {
                b(gVar, this);
                return;
            }
        }
        if (str.equals(".")) {
            b(f8515a, this);
            return;
        }
        byte[] bArr = new byte[64];
        int i4 = 0;
        boolean z2 = false;
        int i5 = -1;
        int i6 = 1;
        int i7 = 0;
        for (int i8 = 0; i8 < str.length(); i8++) {
            byte charAt = (byte) str.charAt(i8);
            if (z2) {
                if (charAt >= 48 && charAt <= 57 && i4 < 3) {
                    i4++;
                    i7 = (i7 * 10) + (charAt - 48);
                    if (i7 > 255) {
                        throw a(str, "bad escape");
                    }
                    if (i4 < 3) {
                        continue;
                    } else {
                        charAt = (byte) i7;
                    }
                } else if (i4 > 0 && i4 < 3) {
                    throw a(str, "bad escape");
                }
                if (i6 > 63) {
                    throw a(str, "label too long");
                }
                i3 = i6 + 1;
                bArr[i6] = charAt;
                i5 = i6;
                z2 = false;
                i6 = i3;
            } else {
                if (charAt == 92) {
                    i4 = 0;
                    z2 = true;
                    i7 = 0;
                } else if (charAt != 46) {
                    i5 = i5 == -1 ? i8 : i5;
                    if (i6 > 63) {
                        throw a(str, "label too long");
                    }
                    i3 = i6 + 1;
                    bArr[i6] = charAt;
                    i6 = i3;
                } else {
                    if (i5 == -1) {
                        throw a(str, "invalid empty label");
                    }
                    bArr[0] = (byte) (i6 - 1);
                    a(str, bArr, 0, 1);
                    i5 = -1;
                    i6 = 1;
                }
            }
        }
        if (i4 > 0 && i4 < 3) {
            throw a(str, "bad escape");
        }
        if (z2) {
            throw a(str, "bad escape");
        }
        if (i5 == -1) {
            z = true;
            i2 = 0;
            a(str, f8517f, 0, 1);
        } else {
            i2 = 0;
            bArr[0] = (byte) (i6 - 1);
            a(str, bArr, 0, 1);
            z = false;
        }
        if (gVar == null || z) {
            return;
        }
        a(str, gVar.f8521c, gVar.a(i2), gVar.d());
    }

    private final int a(int i2) {
        if (i2 == 0 && d() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= d()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 7) {
            return ((int) (this.f8522d >>> ((7 - i2) * 8))) & ViewfinderView.OPAQUE;
        }
        int a2 = a(6);
        for (int i3 = 6; i3 < i2; i3++) {
            a2 += this.f8521c[a2] + 1;
        }
        return a2;
    }

    public static g a(g gVar, g gVar2) {
        if (gVar.a()) {
            return gVar;
        }
        g gVar3 = new g();
        b(gVar, gVar3);
        gVar3.a(gVar2.f8521c, gVar2.a(0), gVar2.d());
        return gVar3;
    }

    public static g a(String str) {
        return a(str, (g) null);
    }

    public static g a(String str, g gVar) {
        return (!str.equals("@") || gVar == null) ? str.equals(".") ? f8515a : new g(str, gVar) : gVar;
    }

    public static IOException a(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & ThreadUtils.TYPE_SINGLE;
            if (i6 <= 32 || i6 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(f8519h.format(i6));
            } else {
                if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                    stringBuffer.append('\\');
                }
                stringBuffer.append((char) i6);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i2, int i3) {
        if (i2 >= 7) {
            return;
        }
        int i4 = (7 - i2) * 8;
        long j2 = this.f8522d & ((255 << i4) ^ (-1));
        this.f8522d = j2;
        this.f8522d = (i3 << i4) | j2;
    }

    private final void a(String str, byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (Exception unused) {
            throw a(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f8521c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4];
            if (i7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = i7 + 1;
            i4 += i8;
            i5 += i8;
        }
        int i9 = length + i5;
        if (i9 > 255) {
            throw new IOException();
        }
        int d2 = d();
        int i10 = d2 + i3;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i9];
        if (length != 0) {
            System.arraycopy(this.f8521c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i2, bArr3, length, i5);
        this.f8521c = bArr3;
        for (int i11 = 0; i11 < i3; i11++) {
            a(d2 + i11, length);
            length += bArr3[length] + 1;
        }
        b(i10);
    }

    private final void b(int i2) {
        long j2 = this.f8522d & (-256);
        this.f8522d = j2;
        this.f8522d = j2 | i2;
    }

    public static final void b(g gVar, g gVar2) {
        if (gVar.a(0) == 0) {
            gVar2.f8521c = gVar.f8521c;
            gVar2.f8522d = gVar.f8522d;
            return;
        }
        int a2 = gVar.a(0);
        int length = gVar.f8521c.length - a2;
        int b2 = gVar.b();
        byte[] bArr = new byte[length];
        gVar2.f8521c = bArr;
        System.arraycopy(gVar.f8521c, a2, bArr, 0, length);
        for (int i2 = 0; i2 < b2 && i2 < 7; i2++) {
            gVar2.a(i2, gVar.a(i2) - a2);
        }
        gVar2.b(b2);
    }

    private final void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (Exception unused) {
        }
    }

    private final boolean b(byte[] bArr, int i2) {
        int b2 = b();
        int a2 = a(0);
        int i3 = 0;
        while (i3 < b2) {
            byte[] bArr2 = this.f8521c;
            if (bArr2[a2] != bArr[i2]) {
                return false;
            }
            int i4 = a2 + 1;
            byte b3 = bArr2[a2];
            i2++;
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i5 = 0;
            while (i5 < b3) {
                byte[] bArr3 = f8520i;
                int i6 = i4 + 1;
                int i7 = i2 + 1;
                if (bArr3[this.f8521c[i4] & ThreadUtils.TYPE_SINGLE] != bArr3[bArr[i2] & ThreadUtils.TYPE_SINGLE]) {
                    return false;
                }
                i5++;
                i2 = i7;
                i4 = i6;
            }
            i3++;
            a2 = i4;
        }
        return true;
    }

    private final int d() {
        return (int) (this.f8522d & 255);
    }

    public String a(boolean z) {
        int b2 = b();
        if (b2 == 0) {
            return "@";
        }
        int i2 = 0;
        if (b2 == 1 && this.f8521c[a(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a2 = a(0);
        while (true) {
            if (i2 >= b2) {
                break;
            }
            byte b3 = this.f8521c[a2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b3 != 0) {
                if (i2 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.f8521c, a2));
                a2 += b3 + 1;
                i2++;
            } else if (!z) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public void a(c cVar) {
        cVar.a(c());
    }

    public void a(c cVar, a aVar) {
        int b2 = b();
        int i2 = 0;
        while (i2 < b2 - 1) {
            g gVar = i2 == 0 ? this : new g(this, i2);
            int a2 = aVar != null ? aVar.a(gVar) : -1;
            if (a2 >= 0) {
                cVar.c(49152 | a2);
                return;
            }
            if (aVar != null) {
                aVar.a(cVar.a(), gVar);
            }
            int a3 = a(i2);
            byte[] bArr = this.f8521c;
            cVar.a(bArr, a3, bArr[a3] + 1);
            i2++;
        }
        cVar.b(0);
    }

    public void a(c cVar, a aVar, boolean z) {
        if (z) {
            a(cVar);
        } else {
            a(cVar, aVar);
        }
    }

    public boolean a() {
        int b2 = b();
        return b2 != 0 && this.f8521c[a(b2 - 1)] == 0;
    }

    public int b() {
        return d();
    }

    public byte[] c() {
        int b2 = b();
        if (b2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.f8521c.length - a(0)];
        int a2 = a(0);
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            byte[] bArr2 = this.f8521c;
            byte b3 = bArr2[a2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            bArr[i2] = bArr2[a2];
            i2++;
            a2++;
            int i4 = 0;
            while (i4 < b3) {
                bArr[i2] = f8520i[this.f8521c[a2] & ThreadUtils.TYPE_SINGLE];
                i4++;
                i2++;
                a2++;
            }
        }
        return bArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        g gVar = (g) obj;
        if (this == gVar) {
            return 0;
        }
        int b2 = b();
        int b3 = gVar.b();
        int i2 = b2 > b3 ? b3 : b2;
        for (int i3 = 1; i3 <= i2; i3++) {
            int a2 = a(b2 - i3);
            int a3 = gVar.a(b3 - i3);
            byte b4 = this.f8521c[a2];
            byte b5 = gVar.f8521c[a3];
            for (int i4 = 0; i4 < b4 && i4 < b5; i4++) {
                byte[] bArr = f8520i;
                int i5 = bArr[this.f8521c[(i4 + a2) + 1] & ThreadUtils.TYPE_SINGLE] - bArr[gVar.f8521c[(i4 + a3) + 1] & ThreadUtils.TYPE_SINGLE];
                if (i5 != 0) {
                    return i5;
                }
            }
            if (b4 != b5) {
                return b4 - b5;
            }
        }
        return b2 - b3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f8523e == 0) {
            gVar.hashCode();
        }
        if (this.f8523e == 0) {
            hashCode();
        }
        if (gVar.f8523e == this.f8523e && gVar.b() == b()) {
            return b(gVar.f8521c, gVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f8523e;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        int a2 = a(0);
        while (true) {
            byte[] bArr = this.f8521c;
            if (a2 >= bArr.length) {
                this.f8523e = i3;
                return i3;
            }
            i3 += (i3 << 3) + f8520i[bArr[a2] & ThreadUtils.TYPE_SINGLE];
            a2++;
        }
    }

    public String toString() {
        return a(false);
    }
}
