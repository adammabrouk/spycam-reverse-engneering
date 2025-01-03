package c.k.c.a;

import android.content.Context;
import c.k.d.a7;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class t0 implements a {

    /* renamed from: e, reason: collision with root package name */
    public static volatile t0 f6921e;

    /* renamed from: a, reason: collision with root package name */
    public Context f6922a;

    /* renamed from: b, reason: collision with root package name */
    public q f6923b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6924c = false;

    /* renamed from: d, reason: collision with root package name */
    public Map<s0, a> f6925d = new HashMap();

    public t0(Context context) {
        this.f6922a = context.getApplicationContext();
    }

    public static t0 a(Context context) {
        if (f6921e == null) {
            synchronized (t0.class) {
                if (f6921e == null) {
                    f6921e = new t0(context);
                }
            }
        }
        return f6921e;
    }

    public a a(s0 s0Var) {
        return this.f6925d.get(s0Var);
    }

    @Override // c.k.c.a.a
    public void a() {
        c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : assemble push unregister");
        for (a aVar : this.f6925d.values()) {
            if (aVar != null) {
                aVar.a();
            }
        }
        this.f6925d.clear();
    }

    public void a(q qVar) {
        this.f6923b = qVar;
        this.f6924c = c.k.d.p9.m.a(this.f6922a).a(a7.AggregatePushSwitch.a(), true);
        if (this.f6923b.d() || this.f6923b.b() || this.f6923b.a()) {
            c.k.d.p9.m.a(this.f6922a).a(new u0(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m59a(s0 s0Var) {
        this.f6925d.remove(s0Var);
    }

    public void a(s0 s0Var, a aVar) {
        if (aVar != null) {
            if (this.f6925d.containsKey(s0Var)) {
                this.f6925d.remove(s0Var);
            }
            this.f6925d.put(s0Var, aVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m60a(s0 s0Var) {
        return this.f6925d.containsKey(s0Var);
    }

    @Override // c.k.c.a.a
    public void b() {
        c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : assemble push register");
        if (this.f6925d.size() <= 0) {
            c();
        }
        if (this.f6925d.size() > 0) {
            for (a aVar : this.f6925d.values()) {
                if (aVar != null) {
                    aVar.b();
                }
            }
            w0.a(this.f6922a);
        }
    }

    public boolean b(s0 s0Var) {
        int i2 = v0.f6928a[s0Var.ordinal()];
        boolean z = false;
        if (i2 == 1) {
            q qVar = this.f6923b;
            if (qVar != null) {
                return qVar.d();
            }
            return false;
        }
        if (i2 == 2) {
            q qVar2 = this.f6923b;
            if (qVar2 != null) {
                return qVar2.b();
            }
            return false;
        }
        if (i2 == 3) {
            q qVar3 = this.f6923b;
            if (qVar3 != null) {
                z = qVar3.a();
            }
        } else if (i2 != 4) {
            return false;
        }
        q qVar4 = this.f6923b;
        return qVar4 != null ? qVar4.c() : z;
    }

    public final void c() {
        a a2;
        a a3;
        a a4;
        a a5;
        q qVar = this.f6923b;
        if (qVar != null) {
            if (qVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f6923b.d() + " HW online switch : " + w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + a0.HUAWEI.equals(b1.a(this.f6922a)));
                c.k.a.a.a.c.m6a(sb.toString());
            }
            if (this.f6923b.d() && w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_HUAWEI) && a0.HUAWEI.equals(b1.a(this.f6922a))) {
                if (!m60a(s0.ASSEMBLE_PUSH_HUAWEI)) {
                    s0 s0Var = s0.ASSEMBLE_PUSH_HUAWEI;
                    a(s0Var, d0.a(this.f6922a, s0Var));
                }
                c.k.a.a.a.c.c("hw manager add to list");
            } else if (m60a(s0.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(s0.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m59a(s0.ASSEMBLE_PUSH_HUAWEI);
                a2.a();
            }
            if (this.f6923b.b()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f6923b.b() + " FCM online switch : " + w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + b1.m18a(this.f6922a));
                c.k.a.a.a.c.m6a(sb2.toString());
            }
            if (this.f6923b.b() && w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_FCM) && b1.m18a(this.f6922a)) {
                if (!m60a(s0.ASSEMBLE_PUSH_FCM)) {
                    s0 s0Var2 = s0.ASSEMBLE_PUSH_FCM;
                    a(s0Var2, d0.a(this.f6922a, s0Var2));
                }
                c.k.a.a.a.c.c("fcm manager add to list");
            } else if (m60a(s0.ASSEMBLE_PUSH_FCM) && (a3 = a(s0.ASSEMBLE_PUSH_FCM)) != null) {
                m59a(s0.ASSEMBLE_PUSH_FCM);
                a3.a();
            }
            if (this.f6923b.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f6923b.a() + " COS online switch : " + w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_COS) + " COS isSupport : " + b1.b(this.f6922a));
                c.k.a.a.a.c.m6a(sb3.toString());
            }
            if (this.f6923b.a() && w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_COS) && b1.b(this.f6922a)) {
                s0 s0Var3 = s0.ASSEMBLE_PUSH_COS;
                a(s0Var3, d0.a(this.f6922a, s0Var3));
            } else if (m60a(s0.ASSEMBLE_PUSH_COS) && (a4 = a(s0.ASSEMBLE_PUSH_COS)) != null) {
                m59a(s0.ASSEMBLE_PUSH_COS);
                a4.a();
            }
            if (this.f6923b.c() && w0.m61a(this.f6922a, s0.ASSEMBLE_PUSH_FTOS) && b1.c(this.f6922a)) {
                s0 s0Var4 = s0.ASSEMBLE_PUSH_FTOS;
                a(s0Var4, d0.a(this.f6922a, s0Var4));
            } else {
                if (!m60a(s0.ASSEMBLE_PUSH_FTOS) || (a5 = a(s0.ASSEMBLE_PUSH_FTOS)) == null) {
                    return;
                }
                m59a(s0.ASSEMBLE_PUSH_FTOS);
                a5.a();
            }
        }
    }
}
