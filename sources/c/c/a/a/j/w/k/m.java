package c.c.a.a.j.w.k;

import android.database.Cursor;
import c.c.a.a.j.w.k.z;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f3752a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3753b;

    public m(List list, c.c.a.a.j.l lVar) {
        this.f3752a = list;
        this.f3753b = lVar;
    }

    public static z.b a(List list, c.c.a.a.j.l lVar) {
        return new m(list, lVar);
    }

    @Override // c.c.a.a.j.w.k.z.b
    public Object a(Object obj) {
        return z.a(this.f3752a, this.f3753b, (Cursor) obj);
    }
}
