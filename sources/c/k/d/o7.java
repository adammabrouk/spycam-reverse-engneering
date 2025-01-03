package c.k.d;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class o7 implements i8<o7, Object>, Serializable, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final y8 f7470c = new y8("XmPushActionCheckClientInfo");

    /* renamed from: d, reason: collision with root package name */
    public static final q8 f7471d = new q8("", (byte) 8, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7472e = new q8("", (byte) 8, 2);

    /* renamed from: a, reason: collision with root package name */
    public int f7473a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f73a = new BitSet(2);

    /* renamed from: b, reason: collision with root package name */
    public int f7474b;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(o7 o7Var) {
        int a2;
        int a3;
        if (!o7.class.equals(o7Var.getClass())) {
            return o7.class.getName().compareTo(o7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m325a()).compareTo(Boolean.valueOf(o7Var.m325a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m325a() && (a3 = j8.a(this.f7473a, o7Var.f7473a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(o7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a2 = j8.a(this.f7474b, o7Var.f7474b)) == 0) {
            return 0;
        }
        return a2;
    }

    public o7 a(int i2) {
        this.f7473a = i2;
        a(true);
        return this;
    }

    public void a() {
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
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f7474b = t8Var.mo341a();
                    b(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 8) {
                    this.f7473a = t8Var.mo341a();
                    a(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
        t8Var.f();
        if (!m325a()) {
            throw new u8("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        if (b()) {
            a();
            return;
        }
        throw new u8("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f73a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m325a() {
        return this.f73a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m326a(o7 o7Var) {
        return o7Var != null && this.f7473a == o7Var.f7473a && this.f7474b == o7Var.f7474b;
    }

    public o7 b(int i2) {
        this.f7474b = i2;
        b(true);
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7470c);
        t8Var.a(f7471d);
        t8Var.mo352a(this.f7473a);
        t8Var.b();
        t8Var.a(f7472e);
        t8Var.mo352a(this.f7474b);
        t8Var.b();
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f73a.set(1, z);
    }

    public boolean b() {
        return this.f73a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof o7)) {
            return m326a((o7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f7473a + ", pluginConfigVersion:" + this.f7474b + ")";
    }
}
