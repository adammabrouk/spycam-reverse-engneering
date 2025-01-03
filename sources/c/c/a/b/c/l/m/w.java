package c.c.a.b.c.l.m;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.c.a.b.c.l.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import java.util.Set;

/* loaded from: classes.dex */
public final class w extends c.c.a.b.h.b.c implements c.c.a.b.c.l.f, c.c.a.b.c.l.g {

    /* renamed from: h, reason: collision with root package name */
    public static a.AbstractC0083a<? extends c.c.a.b.h.f, c.c.a.b.h.a> f3901h = c.c.a.b.h.c.f5244c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3902a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3903b;

    /* renamed from: c, reason: collision with root package name */
    public final a.AbstractC0083a<? extends c.c.a.b.h.f, c.c.a.b.h.a> f3904c;

    /* renamed from: d, reason: collision with root package name */
    public Set<Scope> f3905d;

    /* renamed from: e, reason: collision with root package name */
    public c.c.a.b.c.o.d f3906e;

    /* renamed from: f, reason: collision with root package name */
    public c.c.a.b.h.f f3907f;

    /* renamed from: g, reason: collision with root package name */
    public z f3908g;

    public w(Context context, Handler handler, c.c.a.b.c.o.d dVar) {
        this(context, handler, dVar, f3901h);
    }

    public final void a(z zVar) {
        c.c.a.b.h.f fVar = this.f3907f;
        if (fVar != null) {
            fVar.h();
        }
        this.f3906e.a(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0083a<? extends c.c.a.b.h.f, c.c.a.b.h.a> abstractC0083a = this.f3904c;
        Context context = this.f3902a;
        Looper looper = this.f3903b.getLooper();
        c.c.a.b.c.o.d dVar = this.f3906e;
        this.f3907f = abstractC0083a.a(context, looper, dVar, dVar.h(), this, this);
        this.f3908g = zVar;
        Set<Scope> set = this.f3905d;
        if (set == null || set.isEmpty()) {
            this.f3903b.post(new x(this));
        } else {
            this.f3907f.i();
        }
    }

    @Override // c.c.a.b.c.l.f
    public final void b(Bundle bundle) {
        this.f3907f.a(this);
    }

    public final void f() {
        c.c.a.b.h.f fVar = this.f3907f;
        if (fVar != null) {
            fVar.h();
        }
    }

    public w(Context context, Handler handler, c.c.a.b.c.o.d dVar, a.AbstractC0083a<? extends c.c.a.b.h.f, c.c.a.b.h.a> abstractC0083a) {
        this.f3902a = context;
        this.f3903b = handler;
        c.c.a.b.c.o.r.a(dVar, "ClientSettings must not be null");
        this.f3906e = dVar;
        this.f3905d = dVar.g();
        this.f3904c = abstractC0083a;
    }

    public final void b(zaj zajVar) {
        ConnectionResult u = zajVar.u();
        if (u.y()) {
            ResolveAccountResponse v = zajVar.v();
            ConnectionResult v2 = v.v();
            if (!v2.y()) {
                String valueOf = String.valueOf(v2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f3908g.b(v2);
                this.f3907f.h();
                return;
            }
            this.f3908g.a(v.u(), this.f3905d);
        } else {
            this.f3908g.b(u);
        }
        this.f3907f.h();
    }

    @Override // c.c.a.b.c.l.f
    public final void a(int i2) {
        this.f3907f.h();
    }

    @Override // c.c.a.b.c.l.g
    public final void a(ConnectionResult connectionResult) {
        this.f3908g.b(connectionResult);
    }

    @Override // c.c.a.b.h.b.d
    public final void a(zaj zajVar) {
        this.f3903b.post(new y(this, zajVar));
    }
}
