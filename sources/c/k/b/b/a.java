package c.k.b.b;

import android.content.Context;
import android.os.Process;
import c.k.d.d5;

/* loaded from: classes.dex */
public class a {
    public static void a(Context context, c.k.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        b.a(context).a(aVar.e(), aVar.f(), aVar.a(), aVar.c());
    }

    public static void a(Context context, c.k.b.a.a aVar, c.k.b.c.a aVar2, c.k.b.c.b bVar) {
        c.k.a.a.a.c.c("init in process " + d5.a(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        b.a(context).a(aVar, aVar2, bVar);
        if (d5.m128a(context)) {
            c.k.a.a.a.c.c("init in process\u3000start scheduleJob");
            b.a(context).m11a();
        }
    }

    public static void a(Context context, c.k.b.a.b bVar) {
        if (bVar != null) {
            b.a(context).a(bVar);
        }
    }

    public static void a(Context context, c.k.b.a.c cVar) {
        if (cVar != null) {
            b.a(context).a(cVar);
        }
    }
}
