package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f3761a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3762b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.h f3763c;

    public u(z zVar, c.c.a.a.j.l lVar, c.c.a.a.j.h hVar) {
        this.f3761a = zVar;
        this.f3762b = lVar;
        this.f3763c = hVar;
    }

    public static z.b a(z zVar, c.c.a.a.j.l lVar, c.c.a.a.j.h hVar) {
        return new u(zVar, lVar, hVar);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3761a, this.f3762b, this.f3763c, (SQLiteDatabase) obj);
    }
}
