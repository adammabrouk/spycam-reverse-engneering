package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class p7 implements i8<p7, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f7507b = new y8("XmPushActionCollectData");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f7508c = new q8("", (byte) 15, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<d7> f7509a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(p7 p7Var) {
        int a2;
        if (!p7.class.equals(p7Var.getClass())) {
            return p7.class.getName().compareTo(p7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m338a()).compareTo(Boolean.valueOf(p7Var.m338a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m338a() || (a2 = j8.a(this.f7509a, p7Var.f7509a)) == 0) {
            return 0;
        }
        return a2;
    }

    public p7 a(List<d7> list) {
        this.f7509a = list;
        return this;
    }

    public void a() {
        if (this.f7509a != null) {
            return;
        }
        throw new u8("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                a();
                return;
            }
            if (mo343a.f7786c == 1 && b2 == 15) {
                r8 mo344a = t8Var.mo344a();
                this.f7509a = new ArrayList(mo344a.f7822b);
                for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                    d7 d7Var = new d7();
                    d7Var.a(t8Var);
                    this.f7509a.add(d7Var);
                }
                t8Var.i();
            } else {
                w8.a(t8Var, b2);
            }
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m338a() {
        return this.f7509a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m339a(p7 p7Var) {
        if (p7Var == null) {
            return false;
        }
        boolean m338a = m338a();
        boolean m338a2 = p7Var.m338a();
        if (m338a || m338a2) {
            return m338a && m338a2 && this.f7509a.equals(p7Var.f7509a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7507b);
        if (this.f7509a != null) {
            t8Var.a(f7508c);
            t8Var.a(new r8((byte) 12, this.f7509a.size()));
            Iterator<d7> it = this.f7509a.iterator();
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
        if (obj != null && (obj instanceof p7)) {
            return m339a((p7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<d7> list = this.f7509a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
