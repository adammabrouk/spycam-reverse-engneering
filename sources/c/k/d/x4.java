package c.k.d;

import android.text.TextUtils;
import c.k.d.p9.r;
import c.k.d.z4;
import com.xiaomi.push.service.XMPushService;
import java.util.Iterator;

/* loaded from: classes.dex */
public class x4 extends h5 {
    public byte[] A;
    public Thread x;
    public t4 y;
    public u4 z;

    public x4(XMPushService xMPushService, a5 a5Var) {
        super(xMPushService, a5Var);
    }

    @Override // c.k.d.h5
    /* renamed from: a */
    public synchronized void mo207a() {
        h();
        this.z.a();
    }

    @Override // c.k.d.z4
    public synchronized void a(r.b bVar) {
        r4.a(bVar, c(), this);
    }

    @Override // c.k.d.z4
    @Deprecated
    public void a(r5 r5Var) {
        a(s4.a(r5Var, (String) null));
    }

    @Override // c.k.d.z4
    public void a(s4 s4Var) {
        u4 u4Var = this.z;
        if (u4Var == null) {
            throw new l5("the writer is null.");
        }
        try {
            int a2 = u4Var.a(s4Var);
            this.o = System.currentTimeMillis();
            String e2 = s4Var.e();
            if (!TextUtils.isEmpty(e2)) {
                g6.a(this.m, e2, a2, false, true, System.currentTimeMillis());
            }
            Iterator<z4.a> it = this.f8071g.values().iterator();
            while (it.hasNext()) {
                it.next().a(s4Var);
            }
        } catch (Exception e3) {
            throw new l5(e3);
        }
    }

    @Override // c.k.d.z4
    public synchronized void a(String str, String str2) {
        r4.a(str, str2, this);
    }

    @Override // c.k.d.z4
    public void a(s4[] s4VarArr) {
        for (s4 s4Var : s4VarArr) {
            a(s4Var);
        }
    }

    @Override // c.k.d.z4
    /* renamed from: a */
    public boolean mo545a() {
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized byte[] m526a() {
        if (this.A == null && !TextUtils.isEmpty(this.f8073i)) {
            String m381a = c.k.d.p9.h0.m381a();
            this.A = c.k.d.p9.a0.a(this.f8073i.getBytes(), (this.f8073i.substring(this.f8073i.length() / 2) + m381a.substring(m381a.length() / 2)).getBytes());
        }
        return this.A;
    }

    public final s4 b(boolean z) {
        w4 w4Var = new w4();
        if (z) {
            w4Var.a("1");
        }
        byte[] m337a = p6.m337a();
        if (m337a != null) {
            q3 q3Var = new q3();
            q3Var.a(a.a(m337a));
            w4Var.a(q3Var.m460a(), (String) null);
        }
        return w4Var;
    }

    @Override // c.k.d.h5
    public synchronized void b(int i2, Exception exc) {
        if (this.y != null) {
            this.y.b();
            this.y = null;
        }
        if (this.z != null) {
            try {
                this.z.b();
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
            }
            this.z = null;
        }
        this.A = null;
        super.b(i2, exc);
    }

    public void b(r5 r5Var) {
        if (r5Var == null) {
            return;
        }
        Iterator<z4.a> it = this.f8070f.values().iterator();
        while (it.hasNext()) {
            it.next().a(r5Var);
        }
    }

    public void b(s4 s4Var) {
        if (s4Var == null) {
            return;
        }
        if (s4Var.m464a()) {
            c.k.a.a.a.c.m6a("[Slim] RCV blob chid=" + s4Var.a() + "; id=" + s4Var.d() + "; errCode=" + s4Var.b() + "; err=" + s4Var.m468c());
        }
        if (s4Var.a() == 0) {
            if ("PING".equals(s4Var.m461a())) {
                c.k.a.a.a.c.m6a("[Slim] RCV ping id=" + s4Var.d());
                g();
            } else if ("CLOSE".equals(s4Var.m461a())) {
                c(13, null);
            }
        }
        Iterator<z4.a> it = this.f8070f.values().iterator();
        while (it.hasNext()) {
            it.next().a(s4Var);
        }
    }

    @Override // c.k.d.h5
    /* renamed from: b, reason: collision with other method in class */
    public void mo527b(boolean z) {
        if (this.z == null) {
            throw new l5("The BlobWriter is null.");
        }
        s4 b2 = b(z);
        c.k.a.a.a.c.m6a("[Slim] SND ping id=" + b2.d());
        a(b2);
        f();
    }

    public final void h() {
        try {
            this.y = new t4(this.s.getInputStream(), this);
            this.z = new u4(this.s.getOutputStream(), this);
            y4 y4Var = new y4(this, "Blob Reader (" + this.k + ")");
            this.x = y4Var;
            y4Var.start();
        } catch (Exception e2) {
            throw new l5("Error to init reader and writer", e2);
        }
    }
}
