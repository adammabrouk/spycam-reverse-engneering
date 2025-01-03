package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class d7 implements i8<d7, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f7070b = new y8("DataCollectionItem");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f7071c = new q8("", (byte) 10, 1);

    /* renamed from: d, reason: collision with root package name */
    public static final q8 f7072d = new q8("", (byte) 8, 2);

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7073e = new q8("", (byte) 11, 3);

    /* renamed from: a, reason: collision with root package name */
    public long f7074a;

    /* renamed from: a, reason: collision with other field name */
    public x6 f14a;

    /* renamed from: a, reason: collision with other field name */
    public String f15a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f16a = new BitSet(1);

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d7 d7Var) {
        int a2;
        int a3;
        int a4;
        if (!d7.class.equals(d7Var.getClass())) {
            return d7.class.getName().compareTo(d7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m132a()).compareTo(Boolean.valueOf(d7Var.m132a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m132a() && (a4 = j8.a(this.f7074a, d7Var.f7074a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(d7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = j8.a(this.f14a, d7Var.f14a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(d7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = j8.a(this.f15a, d7Var.f15a)) == 0) {
            return 0;
        }
        return a2;
    }

    public d7 a(long j) {
        this.f7074a = j;
        a(true);
        return this;
    }

    public d7 a(x6 x6Var) {
        this.f14a = x6Var;
        return this;
    }

    public d7 a(String str) {
        this.f15a = str;
        return this;
    }

    public String a() {
        return this.f15a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m131a() {
        if (this.f14a == null) {
            throw new u8("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f15a != null) {
            return;
        }
        throw new u8("Required field 'content' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                break;
            }
            short s = mo343a.f7786c;
            if (s == 1) {
                if (b2 == 10) {
                    this.f7074a = t8Var.mo342a();
                    a(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 11) {
                    this.f15a = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 8) {
                    this.f14a = x6.a(t8Var.mo341a());
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
        t8Var.f();
        if (m132a()) {
            m131a();
            return;
        }
        throw new u8("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f16a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m132a() {
        return this.f16a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m133a(d7 d7Var) {
        if (d7Var == null || this.f7074a != d7Var.f7074a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = d7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f14a.equals(d7Var.f14a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = d7Var.c();
        if (c2 || c3) {
            return c2 && c3 && this.f15a.equals(d7Var.f15a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m131a();
        t8Var.a(f7070b);
        t8Var.a(f7071c);
        t8Var.a(this.f7074a);
        t8Var.b();
        if (this.f14a != null) {
            t8Var.a(f7072d);
            t8Var.mo352a(this.f14a.a());
            t8Var.b();
        }
        if (this.f15a != null) {
            t8Var.a(f7073e);
            t8Var.a(this.f15a);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f14a != null;
    }

    public boolean c() {
        return this.f15a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d7)) {
            return m133a((d7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f7074a);
        sb.append(", ");
        sb.append("collectionType:");
        x6 x6Var = this.f14a;
        if (x6Var == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(x6Var);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f15a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
