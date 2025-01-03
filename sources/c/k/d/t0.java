package c.k.d;

import java.util.Date;

/* loaded from: classes.dex */
public class t0 implements c5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f7872a;

    public t0(s0 s0Var) {
        this.f7872a = s0Var;
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var) {
        z4 z4Var2;
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.f7872a.f7828a.format(new Date()));
        sb.append(" Connection started (");
        z4Var2 = this.f7872a.f7829b;
        sb.append(z4Var2.hashCode());
        sb.append(")");
        c.k.a.a.a.c.c(sb.toString());
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, int i2, Exception exc) {
        z4 z4Var2;
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.f7872a.f7828a.format(new Date()));
        sb.append(" Connection closed (");
        z4Var2 = this.f7872a.f7829b;
        sb.append(z4Var2.hashCode());
        sb.append(")");
        c.k.a.a.a.c.c(sb.toString());
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, Exception exc) {
        z4 z4Var2;
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.f7872a.f7828a.format(new Date()));
        sb.append(" Reconnection failed due to an exception (");
        z4Var2 = this.f7872a.f7829b;
        sb.append(z4Var2.hashCode());
        sb.append(")");
        c.k.a.a.a.c.c(sb.toString());
        exc.printStackTrace();
    }

    @Override // c.k.d.c5
    public void b(z4 z4Var) {
        z4 z4Var2;
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.f7872a.f7828a.format(new Date()));
        sb.append(" Connection reconnected (");
        z4Var2 = this.f7872a.f7829b;
        sb.append(z4Var2.hashCode());
        sb.append(")");
        c.k.a.a.a.c.c(sb.toString());
    }
}
