package c.c.a.a.j.w;

import android.content.Context;
import android.os.Build;
import c.c.a.a.j.w.j.s;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class h {
    public static s a(Context context, c.c.a.a.j.w.k.c cVar, c.c.a.a.j.w.j.g gVar, c.c.a.a.j.y.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new c.c.a.a.j.w.j.e(context, cVar, gVar) : new c.c.a.a.j.w.j.a(context, cVar, aVar, gVar);
    }
}
