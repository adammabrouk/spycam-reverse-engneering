package c.c.b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.c.a.b.c.l.m.a;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.r;
import c.c.a.b.c.s.n;
import c.c.a.b.c.s.o;
import c.c.b.g.f;
import c.c.b.g.h;
import c.c.b.g.l;
import c.c.b.g.s;
import c.c.b.q.g;
import com.google.firebase.components.ComponentDiscoveryService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f5802i = new Object();
    public static final Executor j = new d();

    @GuardedBy("LOCK")
    public static final Map<String, c> k = new a.e.a();

    /* renamed from: a, reason: collision with root package name */
    public final Context f5803a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5804b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.b.e f5805c;

    /* renamed from: d, reason: collision with root package name */
    public final l f5806d;

    /* renamed from: g, reason: collision with root package name */
    public final s<c.c.b.o.a> f5809g;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f5807e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f5808f = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    public final List<b> f5810h = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(14)
    /* renamed from: c.c.b.c$c, reason: collision with other inner class name */
    public static class C0112c implements a.InterfaceC0086a {

        /* renamed from: a, reason: collision with root package name */
        public static AtomicReference<C0112c> f5811a = new AtomicReference<>();

        public static void b(Context context) {
            if (n.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f5811a.get() == null) {
                    C0112c c0112c = new C0112c();
                    if (f5811a.compareAndSet(null, c0112c)) {
                        c.c.a.b.c.l.m.a.a(application);
                        c.c.a.b.c.l.m.a.b().a(c0112c);
                    }
                }
            }
        }

        @Override // c.c.a.b.c.l.m.a.InterfaceC0086a
        public void a(boolean z) {
            synchronized (c.f5802i) {
                Iterator it = new ArrayList(c.k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f5807e.get()) {
                        cVar.a(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public static class d implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public static final Handler f5812a = new Handler(Looper.getMainLooper());

        public d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f5812a.post(runnable);
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(24)
    public static class e extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static AtomicReference<e> f5813b = new AtomicReference<>();

        /* renamed from: a, reason: collision with root package name */
        public final Context f5814a;

        public e(Context context) {
            this.f5814a = context;
        }

        public static void b(Context context) {
            if (f5813b.get() == null) {
                e eVar = new e(context);
                if (f5813b.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (c.f5802i) {
                Iterator<c> it = c.k.values().iterator();
                while (it.hasNext()) {
                    it.next().f();
                }
            }
            a();
        }

        public void a() {
            this.f5814a.unregisterReceiver(this);
        }
    }

    public c(Context context, String str, c.c.b.e eVar) {
        new CopyOnWriteArrayList();
        r.a(context);
        this.f5803a = context;
        r.b(str);
        this.f5804b = str;
        r.a(eVar);
        this.f5805c = eVar;
        List<h> a2 = f.a(context, ComponentDiscoveryService.class).a();
        String a3 = c.c.b.q.e.a();
        Executor executor = j;
        c.c.b.g.d[] dVarArr = new c.c.b.g.d[8];
        dVarArr[0] = c.c.b.g.d.a(context, Context.class, new Class[0]);
        dVarArr[1] = c.c.b.g.d.a(this, c.class, new Class[0]);
        dVarArr[2] = c.c.b.g.d.a(eVar, c.c.b.e.class, new Class[0]);
        dVarArr[3] = g.a("fire-android", "");
        dVarArr[4] = g.a("fire-core", "19.3.0");
        dVarArr[5] = a3 != null ? g.a("kotlin", a3) : null;
        dVarArr[6] = c.c.b.q.c.b();
        dVarArr[7] = c.c.b.k.b.a();
        this.f5806d = new l(executor, a2, dVarArr);
        this.f5809g = new s<>(c.c.b.b.a(this, context));
    }

    public static c j() {
        c cVar;
        synchronized (f5802i) {
            cVar = k.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + o.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    public String c() {
        a();
        return this.f5804b;
    }

    public c.c.b.e d() {
        a();
        return this.f5805c;
    }

    public String e() {
        return c.c.a.b.c.s.c.c(c().getBytes(Charset.defaultCharset())) + "+" + c.c.a.b.c.s.c.c(d().b().getBytes(Charset.defaultCharset()));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f5804b.equals(((c) obj).c());
        }
        return false;
    }

    public final void f() {
        if (!a.h.f.d.a(this.f5803a)) {
            e.b(this.f5803a);
        } else {
            this.f5806d.a(h());
        }
    }

    public boolean g() {
        a();
        return this.f5809g.get().a();
    }

    public boolean h() {
        return "[DEFAULT]".equals(c());
    }

    public int hashCode() {
        return this.f5804b.hashCode();
    }

    public String toString() {
        q.a a2 = q.a(this);
        a2.a("name", this.f5804b);
        a2.a("options", this.f5805c);
        return a2.toString();
    }

    public Context b() {
        a();
        return this.f5803a;
    }

    public static c a(Context context) {
        synchronized (f5802i) {
            if (k.containsKey("[DEFAULT]")) {
                return j();
            }
            c.c.b.e a2 = c.c.b.e.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return a(context, a2);
        }
    }

    public static c a(Context context, c.c.b.e eVar) {
        return a(context, eVar, "[DEFAULT]");
    }

    public static c a(Context context, c.c.b.e eVar, String str) {
        c cVar;
        C0112c.b(context);
        String a2 = a(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f5802i) {
            r.b(!k.containsKey(a2), "FirebaseApp name " + a2 + " already exists!");
            r.a(context, "Application context cannot be null.");
            cVar = new c(context, a2, eVar);
            k.put(a2, cVar);
        }
        cVar.f();
        return cVar;
    }

    public <T> T a(Class<T> cls) {
        a();
        return (T) this.f5806d.a(cls);
    }

    public static /* synthetic */ c.c.b.o.a a(c cVar, Context context) {
        return new c.c.b.o.a(context, cVar.e(), (c.c.b.j.c) cVar.f5806d.a(c.c.b.j.c.class));
    }

    public final void a() {
        r.b(!this.f5808f.get(), "FirebaseApp was deleted");
    }

    public final void a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<b> it = this.f5810h.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public static String a(String str) {
        return str.trim();
    }
}
