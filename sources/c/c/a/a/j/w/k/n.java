package c.c.a.a.j.w.k;

import android.database.Cursor;
import c.c.a.a.j.w.k.z;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f3754a;

    public n(Map map) {
        this.f3754a = map;
    }

    public static z.b a(Map map) {
        return new n(map);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3754a, (Cursor) obj);
    }
}
