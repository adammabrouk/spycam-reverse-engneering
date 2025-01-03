package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f3751a;

    public l(long j) {
        this.f3751a = j;
    }

    public static z.b a(long j) {
        return new l(j);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f3751a)}));
        return valueOf;
    }
}
