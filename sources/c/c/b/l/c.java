package c.c.b.l;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class c implements d0 {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5913c = new Object();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("lock")
    public static l0 f5914d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5915a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f5916b;

    public c(Context context, ExecutorService executorService) {
        this.f5915a = context;
        this.f5916b = executorService;
    }

    public static c.c.a.b.j.h<Integer> b(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return a(context, "com.google.firebase.MESSAGING_EVENT").a(intent).a(t0.a(), r0.f5995a);
    }

    @Override // c.c.b.l.d0
    public final c.c.a.b.j.h<Integer> a(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = this.f5915a;
        return (!(c.c.a.b.c.s.n.i() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? c.c.a.b.j.k.a(this.f5916b, new Callable(context, intent) { // from class: c.c.b.l.p0

            /* renamed from: a, reason: collision with root package name */
            public final Context f5983a;

            /* renamed from: b, reason: collision with root package name */
            public final Intent f5984b;

            {
                this.f5983a = context;
                this.f5984b = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(z.b().a(this.f5983a, this.f5984b));
                return valueOf;
            }
        }).b(this.f5916b, new c.c.a.b.j.a(context, intent) { // from class: c.c.b.l.o0

            /* renamed from: a, reason: collision with root package name */
            public final Context f5981a;

            /* renamed from: b, reason: collision with root package name */
            public final Intent f5982b;

            {
                this.f5981a = context;
                this.f5982b = intent;
            }

            @Override // c.c.a.b.j.a
            public final Object a(c.c.a.b.j.h hVar) {
                return c.a(this.f5981a, this.f5982b, hVar);
            }
        }) : b(context, intent);
    }

    public static final /* synthetic */ Integer b(c.c.a.b.j.h hVar) throws Exception {
        return 403;
    }

    public static l0 a(Context context, String str) {
        l0 l0Var;
        synchronized (f5913c) {
            if (f5914d == null) {
                f5914d = new l0(context, str);
            }
            l0Var = f5914d;
        }
        return l0Var;
    }

    public static final /* synthetic */ Integer a(c.c.a.b.j.h hVar) throws Exception {
        return -1;
    }

    public static final /* synthetic */ c.c.a.b.j.h a(Context context, Intent intent, c.c.a.b.j.h hVar) throws Exception {
        return (c.c.a.b.c.s.n.i() && ((Integer) hVar.b()).intValue() == 402) ? b(context, intent).a(t0.a(), q0.f5989a) : hVar;
    }
}
