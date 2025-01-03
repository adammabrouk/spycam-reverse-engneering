package cn.jiguang.ay;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class i implements Serializable, Cloneable, Comparable {

    /* renamed from: e, reason: collision with root package name */
    public static final DecimalFormat f8527e;

    /* renamed from: a, reason: collision with root package name */
    public g f8528a;

    /* renamed from: b, reason: collision with root package name */
    public int f8529b;

    /* renamed from: c, reason: collision with root package name */
    public int f8530c;

    /* renamed from: d, reason: collision with root package name */
    public long f8531d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f8527e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public static i a(b bVar, int i2) {
        g gVar = new g(bVar);
        int g2 = bVar.g();
        int g3 = bVar.g();
        return i2 == 0 ? a(gVar, g2, g3) : a(gVar, g2, g3, bVar.h(), bVar.g(), bVar);
    }

    public static i a(g gVar, int i2, int i3) {
        return a(gVar, i2, i3, 0L);
    }

    public static i a(g gVar, int i2, int i3, long j) {
        if (gVar.a()) {
            return a(gVar, i2, i3, j, false);
        }
        throw new j(gVar);
    }

    public static i a(g gVar, int i2, int i3, long j, int i4, b bVar) {
        i a2 = a(gVar, i2, i3, j, bVar != null);
        if (bVar != null) {
            if (bVar.b() < i4) {
                throw new IOException("truncated record");
            }
            bVar.a(i4);
            a2.a(bVar);
            if (bVar.b() > 0) {
                throw new IOException("invalid record length");
            }
            bVar.c();
        }
        return a2;
    }

    public static final i a(g gVar, int i2, int i3, long j, boolean z) {
        m mVar = new m();
        mVar.f8528a = gVar;
        mVar.f8529b = i2;
        mVar.f8530c = i3;
        mVar.f8531d = j;
        return mVar;
    }

    private void a(c cVar, boolean z) {
        this.f8528a.a(cVar);
        cVar.c(this.f8529b);
        cVar.c(this.f8530c);
        cVar.a(z ? 0L : this.f8531d);
        int a2 = cVar.a();
        cVar.c(0);
        a(cVar, (a) null, true);
        cVar.a((cVar.a() - a2) - 2, a2);
    }

    private byte[] a(boolean z) {
        c cVar = new c();
        a(cVar, z);
        return cVar.b();
    }

    public void a(long j) {
        this.f8531d = j;
    }

    public abstract void a(b bVar);

    public void a(c cVar, int i2, a aVar) {
        this.f8528a.a(cVar, aVar);
        cVar.c(this.f8529b);
        cVar.c(this.f8530c);
    }

    public abstract void a(c cVar, a aVar, boolean z);

    public boolean a(i iVar) {
        return f() == iVar.f() && this.f8530c == iVar.f8530c && this.f8528a.equals(iVar.f8528a);
    }

    public byte[] a() {
        c cVar = new c();
        a(cVar, (a) null, true);
        return cVar.b();
    }

    public abstract String b();

    public String c() {
        return b();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        i iVar = (i) obj;
        if (this == iVar) {
            return 0;
        }
        int compareTo = this.f8528a.compareTo(iVar.f8528a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i2 = this.f8530c - iVar.f8530c;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f8529b - iVar.f8529b;
        if (i3 != 0) {
            return i3;
        }
        byte[] a2 = a();
        byte[] a3 = iVar.a();
        for (int i4 = 0; i4 < a2.length && i4 < a3.length; i4++) {
            int i5 = (a2[i4] & ThreadUtils.TYPE_SINGLE) - (a3[i4] & ThreadUtils.TYPE_SINGLE);
            if (i5 != 0) {
                return i5;
            }
        }
        return a2.length - a3.length;
    }

    public g d() {
        return this.f8528a;
    }

    public int e() {
        return this.f8529b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f8529b == iVar.f8529b && this.f8530c == iVar.f8530c && this.f8528a.equals(iVar.f8528a)) {
                return Arrays.equals(a(), iVar.a());
            }
        }
        return false;
    }

    public int f() {
        return this.f8529b;
    }

    public int g() {
        return this.f8530c;
    }

    public long h() {
        return this.f8531d;
    }

    public int hashCode() {
        int i2 = 0;
        for (byte b2 : a(true)) {
            i2 += (i2 << 3) + (b2 & ThreadUtils.TYPE_SINGLE);
        }
        return i2;
    }

    public i i() {
        try {
            return (i) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f8528a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String b2 = b();
        if (!b2.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(b2);
        }
        return stringBuffer.toString();
    }
}
