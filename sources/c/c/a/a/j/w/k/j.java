package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f3748a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3749b;

    public j(z zVar, c.c.a.a.j.l lVar) {
        this.f3748a = zVar;
        this.f3749b = lVar;
    }

    public static z.b a(z zVar, c.c.a.a.j.l lVar) {
        return new j(zVar, lVar);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.b(this.f3748a, this.f3749b, (SQLiteDatabase) obj);
    }
}
