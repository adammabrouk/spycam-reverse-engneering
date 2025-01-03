package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class y6 implements i8<y6, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f8040b = new y8("ClientUploadData");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f8041c = new q8("", (byte) 15, 1);

    /* renamed from: a, reason: collision with root package name */
    public List<z6> f8042a;

    public int a() {
        List<z6> list = this.f8042a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(y6 y6Var) {
        int a2;
        if (!y6.class.equals(y6Var.getClass())) {
            return y6.class.getName().compareTo(y6Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m537a()).compareTo(Boolean.valueOf(y6Var.m537a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m537a() || (a2 = j8.a(this.f8042a, y6Var.f8042a)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m536a() {
        if (this.f8042a != null) {
            return;
        }
        throw new u8("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m536a();
                return;
            }
            if (mo343a.f7786c == 1 && b2 == 15) {
                r8 mo344a = t8Var.mo344a();
                this.f8042a = new ArrayList(mo344a.f7822b);
                for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                    z6 z6Var = new z6();
                    z6Var.a(t8Var);
                    this.f8042a.add(z6Var);
                }
                t8Var.i();
            } else {
                w8.a(t8Var, b2);
            }
            t8Var.g();
        }
    }

    public void a(z6 z6Var) {
        if (this.f8042a == null) {
            this.f8042a = new ArrayList();
        }
        this.f8042a.add(z6Var);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m537a() {
        return this.f8042a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m538a(y6 y6Var) {
        if (y6Var == null) {
            return false;
        }
        boolean m537a = m537a();
        boolean m537a2 = y6Var.m537a();
        if (m537a || m537a2) {
            return m537a && m537a2 && this.f8042a.equals(y6Var.f8042a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m536a();
        t8Var.a(f8040b);
        if (this.f8042a != null) {
            t8Var.a(f8041c);
            t8Var.a(new r8((byte) 12, this.f8042a.size()));
            Iterator<z6> it = this.f8042a.iterator();
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
        if (obj != null && (obj instanceof y6)) {
            return m538a((y6) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<z6> list = this.f8042a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
