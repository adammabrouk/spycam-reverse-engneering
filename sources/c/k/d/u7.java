package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class u7 implements i8<u7, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f7935b = new y8("XmPushActionNormalConfig");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f7936c = new q8("", (byte) 15, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<e7> f7937a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(u7 u7Var) {
        int a2;
        if (!u7.class.equals(u7Var.getClass())) {
            return u7.class.getName().compareTo(u7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m500a()).compareTo(Boolean.valueOf(u7Var.m500a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m500a() || (a2 = j8.a(this.f7937a, u7Var.f7937a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<e7> a() {
        return this.f7937a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m499a() {
        if (this.f7937a != null) {
            return;
        }
        throw new u8("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m499a();
                return;
            }
            if (mo343a.f7786c == 1 && b2 == 15) {
                r8 mo344a = t8Var.mo344a();
                this.f7937a = new ArrayList(mo344a.f7822b);
                for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                    e7 e7Var = new e7();
                    e7Var.a(t8Var);
                    this.f7937a.add(e7Var);
                }
                t8Var.i();
            } else {
                w8.a(t8Var, b2);
            }
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m500a() {
        return this.f7937a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m501a(u7 u7Var) {
        if (u7Var == null) {
            return false;
        }
        boolean m500a = m500a();
        boolean m500a2 = u7Var.m500a();
        if (m500a || m500a2) {
            return m500a && m500a2 && this.f7937a.equals(u7Var.f7937a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m499a();
        t8Var.a(f7935b);
        if (this.f7937a != null) {
            t8Var.a(f7936c);
            t8Var.a(new r8((byte) 12, this.f7937a.size()));
            Iterator<e7> it = this.f7937a.iterator();
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
        if (obj != null && (obj instanceof u7)) {
            return m501a((u7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<e7> list = this.f7937a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
