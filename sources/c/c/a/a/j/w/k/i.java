package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f3746a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3747b;

    public i(long j, c.c.a.a.j.l lVar) {
        this.f3746a = j;
        this.f3747b = lVar;
    }

    public static z.b a(long j, c.c.a.a.j.l lVar) {
        return new i(j, lVar);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3746a, this.f3747b, (SQLiteDatabase) obj);
    }
}
