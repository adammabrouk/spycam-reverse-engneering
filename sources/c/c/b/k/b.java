package c.c.b.k;

import android.content.Context;
import c.c.b.g.d;
import c.c.b.g.e;
import c.c.b.g.n;
import c.c.b.k.c;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public d f5899a;

    public b(Context context) {
        this.f5899a = d.a(context);
    }

    @Override // c.c.b.k.c
    public c.a a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f5899a.a(str, currentTimeMillis);
        boolean a3 = this.f5899a.a(currentTimeMillis);
        return (a2 && a3) ? c.a.COMBINED : a3 ? c.a.GLOBAL : a2 ? c.a.SDK : c.a.NONE;
    }

    public static c.c.b.g.d<c> a() {
        d.b a2 = c.c.b.g.d.a(c.class);
        a2.a(n.b(Context.class));
        a2.a(a.a());
        return a2.b();
    }

    public static /* synthetic */ c a(e eVar) {
        return new b((Context) eVar.a(Context.class));
    }
}
