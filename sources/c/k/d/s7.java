package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: classes.dex */
public class s7 implements i8<s7, Object>, Serializable, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final y8 f7843c = new y8("XmPushActionContainer");

    /* renamed from: d, reason: collision with root package name */
    public static final q8 f7844d = new q8("", (byte) 8, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7845e = new q8("", (byte) 2, 2);

    /* renamed from: f, reason: collision with root package name */
    public static final q8 f7846f = new q8("", (byte) 2, 3);

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7847g = new q8("", (byte) 11, 4);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7848h = new q8("", (byte) 11, 5);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7849i = new q8("", (byte) 11, 6);
    public static final q8 j = new q8("", (byte) 12, 7);
    public static final q8 k = new q8("", (byte) 12, 8);

    /* renamed from: a, reason: collision with root package name */
    public j7 f7850a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f93a;

    /* renamed from: a, reason: collision with other field name */
    public v6 f94a;

    /* renamed from: a, reason: collision with other field name */
    public String f95a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f96a;

    /* renamed from: b, reason: collision with root package name */
    public String f7851b;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f97a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f98a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f99b = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s7 s7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!s7.class.equals(s7Var.getClass())) {
            return s7.class.getName().compareTo(s7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m473a()).compareTo(Boolean.valueOf(s7Var.m473a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m473a() && (a9 = j8.a(this.f94a, s7Var.f94a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(s7Var.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a8 = j8.a(this.f98a, s7Var.f98a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(s7Var.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a7 = j8.a(this.f99b, s7Var.f99b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(s7Var.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a6 = j8.a(this.f96a, s7Var.f96a)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(s7Var.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a5 = j8.a(this.f95a, s7Var.f95a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(s7Var.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a4 = j8.a(this.f7851b, s7Var.f7851b)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(s7Var.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a3 = j8.a(this.f93a, s7Var.f93a)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(s7Var.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!i() || (a2 = j8.a(this.f7850a, s7Var.f7850a)) == 0) {
            return 0;
        }
        return a2;
    }

    public j7 a() {
        return this.f7850a;
    }

    public s7 a(j7 j7Var) {
        this.f7850a = j7Var;
        return this;
    }

    public s7 a(l7 l7Var) {
        this.f93a = l7Var;
        return this;
    }

    public s7 a(v6 v6Var) {
        this.f94a = v6Var;
        return this;
    }

    public s7 a(String str) {
        this.f95a = str;
        return this;
    }

    public s7 a(ByteBuffer byteBuffer) {
        this.f96a = byteBuffer;
        return this;
    }

    public s7 a(boolean z) {
        this.f98a = z;
        m472a(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public v6 m469a() {
        return this.f94a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m470a() {
        return this.f95a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m471a() {
        if (this.f94a == null) {
            throw new u8("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f96a == null) {
            throw new u8("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f93a != null) {
            return;
        }
        throw new u8("Required field 'target' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                if (!c()) {
                    throw new u8("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (d()) {
                    m471a();
                    return;
                }
                throw new u8("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 8) {
                        this.f94a = v6.a(t8Var.mo341a());
                        break;
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f98a = t8Var.mo353a();
                        m472a(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f99b = t8Var.mo353a();
                        m476b(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f96a = t8Var.mo349a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f95a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f7851b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f93a = l7Var;
                        l7Var.a(t8Var);
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        j7 j7Var = new j7();
                        this.f7850a = j7Var;
                        j7Var.a(t8Var);
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m472a(boolean z) {
        this.f97a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m473a() {
        return this.f94a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m474a(s7 s7Var) {
        if (s7Var == null) {
            return false;
        }
        boolean m473a = m473a();
        boolean m473a2 = s7Var.m473a();
        if (((m473a || m473a2) && (!m473a || !m473a2 || !this.f94a.equals(s7Var.f94a))) || this.f98a != s7Var.f98a || this.f99b != s7Var.f99b) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = s7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f96a.equals(s7Var.f96a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = s7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f95a.equals(s7Var.f95a))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = s7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7851b.equals(s7Var.f7851b))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = s7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f93a.m287a(s7Var.f93a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = s7Var.i();
        if (i2 || i3) {
            return i2 && i3 && this.f7850a.m250a(s7Var.f7850a);
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m475a() {
        a(j8.a(this.f96a));
        return this.f96a.array();
    }

    public s7 b(String str) {
        this.f7851b = str;
        return this;
    }

    public s7 b(boolean z) {
        this.f99b = z;
        m476b(true);
        return this;
    }

    public String b() {
        return this.f7851b;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m471a();
        t8Var.a(f7843c);
        if (this.f94a != null) {
            t8Var.a(f7844d);
            t8Var.mo352a(this.f94a.a());
            t8Var.b();
        }
        t8Var.a(f7845e);
        t8Var.a(this.f98a);
        t8Var.b();
        t8Var.a(f7846f);
        t8Var.a(this.f99b);
        t8Var.b();
        if (this.f96a != null) {
            t8Var.a(f7847g);
            t8Var.a(this.f96a);
            t8Var.b();
        }
        if (this.f95a != null && f()) {
            t8Var.a(f7848h);
            t8Var.a(this.f95a);
            t8Var.b();
        }
        if (this.f7851b != null && g()) {
            t8Var.a(f7849i);
            t8Var.a(this.f7851b);
            t8Var.b();
        }
        if (this.f93a != null) {
            t8Var.a(j);
            this.f93a.b(t8Var);
            t8Var.b();
        }
        if (this.f7850a != null && i()) {
            t8Var.a(k);
            this.f7850a.b(t8Var);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m476b(boolean z) {
        this.f97a.set(1, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m477b() {
        return this.f98a;
    }

    public boolean c() {
        return this.f97a.get(0);
    }

    public boolean d() {
        return this.f97a.get(1);
    }

    public boolean e() {
        return this.f96a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof s7)) {
            return m474a((s7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f95a != null;
    }

    public boolean g() {
        return this.f7851b != null;
    }

    public boolean h() {
        return this.f93a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7850a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        v6 v6Var = this.f94a;
        if (v6Var == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(v6Var);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f98a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f99b);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.f96a;
        if (byteBuffer == null) {
            sb.append(LogUtils.NULL);
        } else {
            j8.a(byteBuffer, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f95a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f7851b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        l7 l7Var = this.f93a;
        if (l7Var == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(l7Var);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            j7 j7Var = this.f7850a;
            if (j7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(j7Var);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
