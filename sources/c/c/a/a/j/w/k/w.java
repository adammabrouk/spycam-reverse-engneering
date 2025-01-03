package c.c.a.a.j.w.k;

import android.database.sqlite.SQLiteDatabase;
import c.c.a.a.j.w.k.z;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3765a;

    public w(String str) {
        this.f3765a = str;
    }

    public static z.b a(String str) {
        return new w(str);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3765a, (SQLiteDatabase) obj);
    }
}
