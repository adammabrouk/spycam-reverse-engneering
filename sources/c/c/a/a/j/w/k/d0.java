package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.e0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements e0.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f3734a = new d0();

    public static e0.a a() {
        return f3734a;
    }

    @Override // c.c.a.a.j.w.k.e0.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
