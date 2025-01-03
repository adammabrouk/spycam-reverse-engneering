package c.c.a.b.c.l;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.c.a.b.c.l.a;
import c.c.a.b.c.l.a.d;
import c.c.a.b.c.l.m.b;
import c.c.a.b.c.l.m.e0;
import c.c.a.b.c.l.m.w;
import c.c.a.b.c.o.d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public class e<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3830a;

    /* renamed from: b, reason: collision with root package name */
    public final a<O> f3831b;

    /* renamed from: c, reason: collision with root package name */
    public final O f3832c;

    /* renamed from: d, reason: collision with root package name */
    public final e0<O> f3833d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3834e;

    /* JADX WARN: Type inference failed for: r9v1, types: [c.c.a.b.c.l.a$f] */
    public a.f a(Looper looper, b.a<O> aVar) {
        return this.f3831b.b().a(this.f3830a, looper, a().a(), this.f3832c, aVar, aVar);
    }

    public final int b() {
        return this.f3834e;
    }

    public final e0<O> c() {
        return this.f3833d;
    }

    public d.a a() {
        Account e2;
        Set<Scope> emptySet;
        GoogleSignInAccount r;
        GoogleSignInAccount r2;
        d.a aVar = new d.a();
        O o = this.f3832c;
        if ((o instanceof a.d.b) && (r2 = ((a.d.b) o).r()) != null) {
            e2 = r2.e();
        } else {
            O o2 = this.f3832c;
            e2 = o2 instanceof a.d.InterfaceC0084a ? ((a.d.InterfaceC0084a) o2).e() : null;
        }
        aVar.a(e2);
        O o3 = this.f3832c;
        if ((o3 instanceof a.d.b) && (r = ((a.d.b) o3).r()) != null) {
            emptySet = r.B();
        } else {
            emptySet = Collections.emptySet();
        }
        aVar.a(emptySet);
        aVar.a(this.f3830a.getClass().getName());
        aVar.b(this.f3830a.getPackageName());
        return aVar;
    }

    public w a(Context context, Handler handler) {
        return new w(context, handler, a().a());
    }
}
