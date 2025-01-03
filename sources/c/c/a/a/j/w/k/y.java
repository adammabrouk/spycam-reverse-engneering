package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f3767a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3768b;

    public y(z zVar, c.c.a.a.j.l lVar) {
        this.f3767a = zVar;
        this.f3768b = lVar;
    }

    public static z.b a(z zVar, c.c.a.a.j.l lVar) {
        return new y(zVar, lVar);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3767a, this.f3768b, (SQLiteDatabase) obj);
    }
}
