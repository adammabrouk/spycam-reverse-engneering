package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class v7 implements i8<v7, Object>, Serializable, Cloneable {
    public static final y8 j = new y8("XmPushActionNotification");
    public static final q8 k = new q8("", (byte) 11, 1);
    public static final q8 l = new q8("", (byte) 12, 2);
    public static final q8 m = new q8("", (byte) 11, 3);
    public static final q8 n = new q8("", (byte) 11, 4);
    public static final q8 o = new q8("", (byte) 11, 5);
    public static final q8 p = new q8("", (byte) 2, 6);
    public static final q8 q = new q8("", (byte) 11, 7);
    public static final q8 r = new q8("", (byte) 13, 8);
    public static final q8 t = new q8("", (byte) 11, 9);
    public static final q8 u = new q8("", (byte) 11, 10);
    public static final q8 v = new q8("", (byte) 11, 12);
    public static final q8 w = new q8("", (byte) 11, 13);
    public static final q8 x = new q8("", (byte) 11, 14);
    public static final q8 y = new q8("", (byte) 10, 15);
    public static final q8 z = new q8("", (byte) 2, 20);

    /* renamed from: a, reason: collision with root package name */
    public long f7960a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f101a;

    /* renamed from: a, reason: collision with other field name */
    public String f102a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f103a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f104a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f105a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f106a;

    /* renamed from: b, reason: collision with root package name */
    public String f7961b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f107b;

    /* renamed from: c, reason: collision with root package name */
    public String f7962c;

    /* renamed from: d, reason: collision with root package name */
    public String f7963d;

    /* renamed from: e, reason: collision with root package name */
    public String f7964e;

    /* renamed from: f, reason: collision with root package name */
    public String f7965f;

    /* renamed from: g, reason: collision with root package name */
    public String f7966g;

    /* renamed from: h, reason: collision with root package name */
    public String f7967h;

    /* renamed from: i, reason: collision with root package name */
    public String f7968i;

    public v7() {
        this.f104a = new BitSet(3);
        this.f106a = true;
        this.f107b = false;
    }

    public v7(String str, boolean z2) {
        this();
        this.f7961b = str;
        this.f106a = z2;
        m506a(true);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v7 v7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        if (!v7.class.equals(v7Var.getClass())) {
            return v7.class.getName().compareTo(v7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m507a()).compareTo(Boolean.valueOf(v7Var.m507a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m507a() && (a16 = j8.a(this.f102a, v7Var.f102a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(m510b()).compareTo(Boolean.valueOf(v7Var.m510b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m510b() && (a15 = j8.a(this.f101a, v7Var.f101a)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(m511c()).compareTo(Boolean.valueOf(v7Var.m511c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m511c() && (a14 = j8.a(this.f7961b, v7Var.f7961b)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(v7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a13 = j8.a(this.f7962c, v7Var.f7962c)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(v7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a12 = j8.a(this.f7963d, v7Var.f7963d)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(v7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a11 = j8.a(this.f106a, v7Var.f106a)) != 0) {
            return a11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(v7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a10 = j8.a(this.f7964e, v7Var.f7964e)) != 0) {
            return a10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(v7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a9 = j8.a(this.f105a, v7Var.f105a)) != 0) {
            return a9;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(v7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a8 = j8.a(this.f7965f, v7Var.f7965f)) != 0) {
            return a8;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(v7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a7 = j8.a(this.f7966g, v7Var.f7966g)) != 0) {
            return a7;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(v7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a6 = j8.a(this.f7967h, v7Var.f7967h)) != 0) {
            return a6;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(v7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a5 = j8.a(this.f7968i, v7Var.f7968i)) != 0) {
            return a5;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(v7Var.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a4 = j8.a(this.f103a, v7Var.f103a)) != 0) {
            return a4;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(v7Var.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a3 = j8.a(this.f7960a, v7Var.f7960a)) != 0) {
            return a3;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(v7Var.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (a2 = j8.a(this.f107b, v7Var.f107b)) == 0) {
            return 0;
        }
        return a2;
    }

    public v7 a(String str) {
        this.f7961b = str;
        return this;
    }

    public v7 a(ByteBuffer byteBuffer) {
        this.f103a = byteBuffer;
        return this;
    }

    public v7 a(Map<String, String> map) {
        this.f105a = map;
        return this;
    }

    public v7 a(boolean z2) {
        this.f106a = z2;
        m506a(true);
        return this;
    }

    public v7 a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f7961b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m504a() {
        return this.f105a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m505a() {
        if (this.f7961b != null) {
            return;
        }
        throw new u8("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                if (f()) {
                    m505a();
                    return;
                }
                throw new u8("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f102a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f101a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7961b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7962c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7963d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f106a = t8Var.mo353a();
                        m506a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7964e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f105a = new HashMap(mo345a.f7854c * 2);
                        for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                            this.f105a.put(t8Var.mo348a(), t8Var.mo348a());
                        }
                        t8Var.h();
                        break;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7965f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7966g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f7967h = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f7968i = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f103a = t8Var.mo349a();
                        continue;
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f7960a = t8Var.mo342a();
                        b(true);
                        break;
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f107b = t8Var.mo353a();
                        c(true);
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f105a == null) {
            this.f105a = new HashMap();
        }
        this.f105a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m506a(boolean z2) {
        this.f104a.set(0, z2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m507a() {
        return this.f102a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m508a(v7 v7Var) {
        if (v7Var == null) {
            return false;
        }
        boolean m507a = m507a();
        boolean m507a2 = v7Var.m507a();
        if ((m507a || m507a2) && !(m507a && m507a2 && this.f102a.equals(v7Var.f102a))) {
            return false;
        }
        boolean m510b = m510b();
        boolean m510b2 = v7Var.m510b();
        if ((m510b || m510b2) && !(m510b && m510b2 && this.f101a.m287a(v7Var.f101a))) {
            return false;
        }
        boolean m511c = m511c();
        boolean m511c2 = v7Var.m511c();
        if ((m511c || m511c2) && !(m511c && m511c2 && this.f7961b.equals(v7Var.f7961b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = v7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7962c.equals(v7Var.f7962c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = v7Var.e();
        if (((e2 || e3) && !(e2 && e3 && this.f7963d.equals(v7Var.f7963d))) || this.f106a != v7Var.f106a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = v7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7964e.equals(v7Var.f7964e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = v7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f105a.equals(v7Var.f105a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = v7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7965f.equals(v7Var.f7965f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = v7Var.j();
        if ((j2 || j3) && !(j2 && j3 && this.f7966g.equals(v7Var.f7966g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = v7Var.k();
        if ((k2 || k3) && !(k2 && k3 && this.f7967h.equals(v7Var.f7967h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = v7Var.l();
        if ((l2 || l3) && !(l2 && l3 && this.f7968i.equals(v7Var.f7968i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = v7Var.m();
        if ((m2 || m3) && !(m2 && m3 && this.f103a.equals(v7Var.f103a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = v7Var.n();
        if ((n2 || n3) && !(n2 && n3 && this.f7960a == v7Var.f7960a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = v7Var.o();
        if (o2 || o3) {
            return o2 && o3 && this.f107b == v7Var.f107b;
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m509a() {
        a(j8.a(this.f103a));
        return this.f103a.array();
    }

    public v7 b(String str) {
        this.f7962c = str;
        return this;
    }

    public String b() {
        return this.f7962c;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m505a();
        t8Var.a(j);
        if (this.f102a != null && m507a()) {
            t8Var.a(k);
            t8Var.a(this.f102a);
            t8Var.b();
        }
        if (this.f101a != null && m510b()) {
            t8Var.a(l);
            this.f101a.b(t8Var);
            t8Var.b();
        }
        if (this.f7961b != null) {
            t8Var.a(m);
            t8Var.a(this.f7961b);
            t8Var.b();
        }
        if (this.f7962c != null && d()) {
            t8Var.a(n);
            t8Var.a(this.f7962c);
            t8Var.b();
        }
        if (this.f7963d != null && e()) {
            t8Var.a(o);
            t8Var.a(this.f7963d);
            t8Var.b();
        }
        t8Var.a(p);
        t8Var.a(this.f106a);
        t8Var.b();
        if (this.f7964e != null && g()) {
            t8Var.a(q);
            t8Var.a(this.f7964e);
            t8Var.b();
        }
        if (this.f105a != null && h()) {
            t8Var.a(r);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f105a.size()));
            for (Map.Entry<String, String> entry : this.f105a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (this.f7965f != null && i()) {
            t8Var.a(t);
            t8Var.a(this.f7965f);
            t8Var.b();
        }
        if (this.f7966g != null && j()) {
            t8Var.a(u);
            t8Var.a(this.f7966g);
            t8Var.b();
        }
        if (this.f7967h != null && k()) {
            t8Var.a(v);
            t8Var.a(this.f7967h);
            t8Var.b();
        }
        if (this.f7968i != null && l()) {
            t8Var.a(w);
            t8Var.a(this.f7968i);
            t8Var.b();
        }
        if (this.f103a != null && m()) {
            t8Var.a(x);
            t8Var.a(this.f103a);
            t8Var.b();
        }
        if (n()) {
            t8Var.a(y);
            t8Var.a(this.f7960a);
            t8Var.b();
        }
        if (o()) {
            t8Var.a(z);
            t8Var.a(this.f107b);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z2) {
        this.f104a.set(1, z2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m510b() {
        return this.f101a != null;
    }

    public v7 c(String str) {
        this.f7963d = str;
        return this;
    }

    public String c() {
        return this.f7965f;
    }

    public void c(boolean z2) {
        this.f104a.set(2, z2);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m511c() {
        return this.f7961b != null;
    }

    public v7 d(String str) {
        this.f7965f = str;
        return this;
    }

    public boolean d() {
        return this.f7962c != null;
    }

    public boolean e() {
        return this.f7963d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof v7)) {
            return m508a((v7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f104a.get(0);
    }

    public boolean g() {
        return this.f7964e != null;
    }

    public boolean h() {
        return this.f105a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7965f != null;
    }

    public boolean j() {
        return this.f7966g != null;
    }

    public boolean k() {
        return this.f7967h != null;
    }

    public boolean l() {
        return this.f7968i != null;
    }

    public boolean m() {
        return this.f103a != null;
    }

    public boolean n() {
        return this.f104a.get(1);
    }

    public boolean o() {
        return this.f104a.get(2);
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z3 = false;
        if (m507a()) {
            sb.append("debug:");
            String str = this.f102a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m510b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f101a;
            if (l7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(l7Var);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f7961b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f7962c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f7963d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f106a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f7964e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f105a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7965f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7966g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f7967h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f7968i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f103a;
            if (byteBuffer == null) {
                sb.append(LogUtils.NULL);
            } else {
                j8.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f7960a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f107b);
        }
        sb.append(")");
        return sb.toString();
    }
}
