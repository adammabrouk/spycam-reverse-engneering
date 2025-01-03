package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class t7 implements i8<t7, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f7901b = new y8("XmPushActionCustomConfig");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f7902c = new q8("", (byte) 15, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<h7> f7903a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(t7 t7Var) {
        int a2;
        if (!t7.class.equals(t7Var.getClass())) {
            return t7.class.getName().compareTo(t7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(t7Var.m484a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m484a() || (a2 = j8.a(this.f7903a, t7Var.f7903a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<h7> a() {
        return this.f7903a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m483a() {
        if (this.f7903a != null) {
            return;
        }
        throw new u8("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m483a();
                return;
            }
            if (mo343a.f7786c == 1 && b2 == 15) {
                r8 mo344a = t8Var.mo344a();
                this.f7903a = new ArrayList(mo344a.f7822b);
                for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                    h7 h7Var = new h7();
                    h7Var.a(t8Var);
                    this.f7903a.add(h7Var);
                }
                t8Var.i();
            } else {
                w8.a(t8Var, b2);
            }
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m484a() {
        return this.f7903a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m485a(t7 t7Var) {
        if (t7Var == null) {
            return false;
        }
        boolean m484a = m484a();
        boolean m484a2 = t7Var.m484a();
        if (m484a || m484a2) {
            return m484a && m484a2 && this.f7903a.equals(t7Var.f7903a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m483a();
        t8Var.a(f7901b);
        if (this.f7903a != null) {
            t8Var.a(f7902c);
            t8Var.a(new r8((byte) 12, this.f7903a.size()));
            Iterator<h7> it = this.f7903a.iterator();
            while (it.hasNext()) {
                it.next().b(t8Var);
            }
            t8Var.e();
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof t7)) {
            return m485a((t7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<h7> list = this.f7903a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
