package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class j7 implements i8<j7, Object>, Serializable, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final y8 f7292f = new y8("PushMetaInfo");

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7293g = new q8("", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7294h = new q8("", (byte) 10, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7295i = new q8("", (byte) 11, 3);
    public static final q8 j = new q8("", (byte) 11, 4);
    public static final q8 k = new q8("", (byte) 11, 5);
    public static final q8 l = new q8("", (byte) 8, 6);
    public static final q8 m = new q8("", (byte) 11, 7);
    public static final q8 n = new q8("", (byte) 8, 8);
    public static final q8 o = new q8("", (byte) 8, 9);
    public static final q8 p = new q8("", (byte) 13, 10);
    public static final q8 q = new q8("", (byte) 13, 11);
    public static final q8 r = new q8("", (byte) 2, 12);
    public static final q8 t = new q8("", (byte) 13, 13);

    /* renamed from: a, reason: collision with root package name */
    public int f7296a;

    /* renamed from: a, reason: collision with other field name */
    public long f43a;

    /* renamed from: a, reason: collision with other field name */
    public String f44a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f45a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f46a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f47a;

    /* renamed from: b, reason: collision with root package name */
    public int f7297b;

    /* renamed from: b, reason: collision with other field name */
    public String f48b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f49b;

    /* renamed from: c, reason: collision with root package name */
    public int f7298c;

    /* renamed from: c, reason: collision with other field name */
    public String f50c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f51c;

    /* renamed from: d, reason: collision with root package name */
    public String f7299d;

    /* renamed from: e, reason: collision with root package name */
    public String f7300e;

    public j7() {
        this.f45a = new BitSet(5);
        this.f47a = false;
    }

    public j7(j7 j7Var) {
        BitSet bitSet = new BitSet(5);
        this.f45a = bitSet;
        bitSet.clear();
        this.f45a.or(j7Var.f45a);
        if (j7Var.m249a()) {
            this.f44a = j7Var.f44a;
        }
        this.f43a = j7Var.f43a;
        if (j7Var.m255c()) {
            this.f48b = j7Var.f48b;
        }
        if (j7Var.m256d()) {
            this.f50c = j7Var.f50c;
        }
        if (j7Var.e()) {
            this.f7299d = j7Var.f7299d;
        }
        this.f7296a = j7Var.f7296a;
        if (j7Var.g()) {
            this.f7300e = j7Var.f7300e;
        }
        this.f7297b = j7Var.f7297b;
        this.f7298c = j7Var.f7298c;
        if (j7Var.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : j7Var.f46a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f46a = hashMap;
        }
        if (j7Var.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : j7Var.f49b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f49b = hashMap2;
        }
        this.f47a = j7Var.f47a;
        if (j7Var.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : j7Var.f51c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f51c = hashMap3;
        }
    }

    public int a() {
        return this.f7296a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j7 j7Var) {
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
        if (!j7.class.equals(j7Var.getClass())) {
            return j7.class.getName().compareTo(j7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m249a()).compareTo(Boolean.valueOf(j7Var.m249a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m249a() && (a14 = j8.a(this.f44a, j7Var.f44a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(m253b()).compareTo(Boolean.valueOf(j7Var.m253b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m253b() && (a13 = j8.a(this.f43a, j7Var.f43a)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(m255c()).compareTo(Boolean.valueOf(j7Var.m255c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m255c() && (a12 = j8.a(this.f48b, j7Var.f48b)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(m256d()).compareTo(Boolean.valueOf(j7Var.m256d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m256d() && (a11 = j8.a(this.f50c, j7Var.f50c)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(j7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a10 = j8.a(this.f7299d, j7Var.f7299d)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(j7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a9 = j8.a(this.f7296a, j7Var.f7296a)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(j7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a8 = j8.a(this.f7300e, j7Var.f7300e)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(j7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a7 = j8.a(this.f7297b, j7Var.f7297b)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(j7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a6 = j8.a(this.f7298c, j7Var.f7298c)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(j7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a5 = j8.a(this.f46a, j7Var.f46a)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(j7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a4 = j8.a(this.f49b, j7Var.f49b)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(j7Var.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a3 = j8.a(this.f47a, j7Var.f47a)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(j7Var.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (a2 = j8.a(this.f51c, j7Var.f51c)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m244a() {
        return this.f43a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public j7 m245a() {
        return new j7(this);
    }

    public j7 a(int i2) {
        this.f7296a = i2;
        b(true);
        return this;
    }

    public j7 a(String str) {
        this.f44a = str;
        return this;
    }

    public j7 a(Map<String, String> map) {
        this.f46a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m246a() {
        return this.f44a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m247a() {
        return this.f46a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m248a() {
        if (this.f44a != null) {
            return;
        }
        throw new u8("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                if (m253b()) {
                    m248a();
                    return;
                }
                throw new u8("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f44a = t8Var.mo348a();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f43a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f48b = t8Var.mo348a();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f50c = t8Var.mo348a();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7299d = t8Var.mo348a();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f7296a = t8Var.mo341a();
                        b(true);
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7300e = t8Var.mo348a();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f7297b = t8Var.mo341a();
                        c(true);
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f7298c = t8Var.mo341a();
                        d(true);
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f46a = new HashMap(mo345a.f7854c * 2);
                        while (i2 < mo345a.f7854c) {
                            this.f46a.put(t8Var.mo348a(), t8Var.mo348a());
                            i2++;
                        }
                        t8Var.h();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        s8 mo345a2 = t8Var.mo345a();
                        this.f49b = new HashMap(mo345a2.f7854c * 2);
                        while (i2 < mo345a2.f7854c) {
                            this.f49b.put(t8Var.mo348a(), t8Var.mo348a());
                            i2++;
                        }
                        t8Var.h();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f47a = t8Var.mo353a();
                        e(true);
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        s8 mo345a3 = t8Var.mo345a();
                        this.f51c = new HashMap(mo345a3.f7854c * 2);
                        while (i2 < mo345a3.f7854c) {
                            this.f51c.put(t8Var.mo348a(), t8Var.mo348a());
                            i2++;
                        }
                        t8Var.h();
                        break;
                    }
                    w8.a(t8Var, b2);
                    break;
                default:
                    w8.a(t8Var, b2);
                    break;
            }
            t8Var.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f46a == null) {
            this.f46a = new HashMap();
        }
        this.f46a.put(str, str2);
    }

    public void a(boolean z) {
        this.f45a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m249a() {
        return this.f44a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m250a(j7 j7Var) {
        if (j7Var == null) {
            return false;
        }
        boolean m249a = m249a();
        boolean m249a2 = j7Var.m249a();
        if (((m249a || m249a2) && !(m249a && m249a2 && this.f44a.equals(j7Var.f44a))) || this.f43a != j7Var.f43a) {
            return false;
        }
        boolean m255c = m255c();
        boolean m255c2 = j7Var.m255c();
        if ((m255c || m255c2) && !(m255c && m255c2 && this.f48b.equals(j7Var.f48b))) {
            return false;
        }
        boolean m256d = m256d();
        boolean m256d2 = j7Var.m256d();
        if ((m256d || m256d2) && !(m256d && m256d2 && this.f50c.equals(j7Var.f50c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = j7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7299d.equals(j7Var.f7299d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = j7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7296a == j7Var.f7296a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = j7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7300e.equals(j7Var.f7300e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = j7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7297b == j7Var.f7297b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = j7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7298c == j7Var.f7298c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = j7Var.j();
        if ((j2 || j3) && !(j2 && j3 && this.f46a.equals(j7Var.f46a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = j7Var.k();
        if ((k2 || k3) && !(k2 && k3 && this.f49b.equals(j7Var.f49b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = j7Var.m();
        if ((m2 || m3) && !(m2 && m3 && this.f47a == j7Var.f47a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = j7Var.n();
        if (n2 || n3) {
            return n2 && n3 && this.f51c.equals(j7Var.f51c);
        }
        return true;
    }

    public int b() {
        return this.f7297b;
    }

    public j7 b(int i2) {
        this.f7297b = i2;
        c(true);
        return this;
    }

    public j7 b(String str) {
        this.f48b = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m251b() {
        return this.f48b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m252b() {
        return this.f49b;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m248a();
        t8Var.a(f7292f);
        if (this.f44a != null) {
            t8Var.a(f7293g);
            t8Var.a(this.f44a);
            t8Var.b();
        }
        t8Var.a(f7294h);
        t8Var.a(this.f43a);
        t8Var.b();
        if (this.f48b != null && m255c()) {
            t8Var.a(f7295i);
            t8Var.a(this.f48b);
            t8Var.b();
        }
        if (this.f50c != null && m256d()) {
            t8Var.a(j);
            t8Var.a(this.f50c);
            t8Var.b();
        }
        if (this.f7299d != null && e()) {
            t8Var.a(k);
            t8Var.a(this.f7299d);
            t8Var.b();
        }
        if (f()) {
            t8Var.a(l);
            t8Var.mo352a(this.f7296a);
            t8Var.b();
        }
        if (this.f7300e != null && g()) {
            t8Var.a(m);
            t8Var.a(this.f7300e);
            t8Var.b();
        }
        if (h()) {
            t8Var.a(n);
            t8Var.mo352a(this.f7297b);
            t8Var.b();
        }
        if (i()) {
            t8Var.a(o);
            t8Var.mo352a(this.f7298c);
            t8Var.b();
        }
        if (this.f46a != null && j()) {
            t8Var.a(p);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f46a.size()));
            for (Map.Entry<String, String> entry : this.f46a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (this.f49b != null && k()) {
            t8Var.a(q);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f49b.size()));
            for (Map.Entry<String, String> entry2 : this.f49b.entrySet()) {
                t8Var.a(entry2.getKey());
                t8Var.a(entry2.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (m()) {
            t8Var.a(r);
            t8Var.a(this.f47a);
            t8Var.b();
        }
        if (this.f51c != null && n()) {
            t8Var.a(t);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f51c.size()));
            for (Map.Entry<String, String> entry3 : this.f51c.entrySet()) {
                t8Var.a(entry3.getKey());
                t8Var.a(entry3.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(String str, String str2) {
        if (this.f49b == null) {
            this.f49b = new HashMap();
        }
        this.f49b.put(str, str2);
    }

    public void b(boolean z) {
        this.f45a.set(1, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m253b() {
        return this.f45a.get(0);
    }

    public int c() {
        return this.f7298c;
    }

    public j7 c(int i2) {
        this.f7298c = i2;
        d(true);
        return this;
    }

    public j7 c(String str) {
        this.f50c = str;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m254c() {
        return this.f50c;
    }

    public void c(boolean z) {
        this.f45a.set(2, z);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m255c() {
        return this.f48b != null;
    }

    public j7 d(String str) {
        this.f7299d = str;
        return this;
    }

    public String d() {
        return this.f7299d;
    }

    public void d(boolean z) {
        this.f45a.set(3, z);
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m256d() {
        return this.f50c != null;
    }

    public void e(boolean z) {
        this.f45a.set(4, z);
    }

    public boolean e() {
        return this.f7299d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof j7)) {
            return m250a((j7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f45a.get(1);
    }

    public boolean g() {
        return this.f7300e != null;
    }

    public boolean h() {
        return this.f45a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f45a.get(3);
    }

    public boolean j() {
        return this.f46a != null;
    }

    public boolean k() {
        return this.f49b != null;
    }

    public boolean l() {
        return this.f47a;
    }

    public boolean m() {
        return this.f45a.get(4);
    }

    public boolean n() {
        return this.f51c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f44a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f43a);
        if (m255c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f48b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
        }
        if (m256d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f50c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f7299d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f7296a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f7300e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f7297b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f7298c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f46a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f49b;
            if (map2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f47a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f51c;
            if (map3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
