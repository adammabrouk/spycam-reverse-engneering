package c.c.a.b.f.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.tencent.bugly.Bugly;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    public static volatile c f4098h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f4099i = null;
    public static Boolean j = null;
    public static boolean k = false;
    public static Boolean l = null;
    public static String m = "use_dynamite_api";
    public static String n = "allow_remote_dynamite";
    public static boolean o = true;

    /* renamed from: a, reason: collision with root package name */
    public final String f4100a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.b.c.s.e f4101b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f4102c;

    /* renamed from: d, reason: collision with root package name */
    public List<Pair<c.c.a.b.g.b.f6, b>> f4103d;

    /* renamed from: e, reason: collision with root package name */
    public int f4104e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4105f;

    /* renamed from: g, reason: collision with root package name */
    public xc f4106g;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    public abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f4107a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4108b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4109c;

        public a(c cVar) {
            this(true);
        }

        public abstract void a() throws RemoteException;

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4105f) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                c.this.a(e2, false, this.f4109c);
                b();
            }
        }

        public a(boolean z) {
            this.f4107a = c.this.f4101b.a();
            this.f4108b = c.this.f4101b.b();
            this.f4109c = z;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    public static class b extends cd {

        /* renamed from: a, reason: collision with root package name */
        public final c.c.a.b.g.b.f6 f4111a;

        public b(c.c.a.b.g.b.f6 f6Var) {
            this.f4111a = f6Var;
        }

        @Override // c.c.a.b.f.e.dd
        public final void a(String str, String str2, Bundle bundle, long j) {
            this.f4111a.a(str, str2, bundle, j);
        }

        @Override // c.c.a.b.f.e.dd
        public final int zza() {
            return System.identityHashCode(this.f4111a);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    /* renamed from: c.c.a.b.f.e.c$c, reason: collision with other inner class name */
    public class C0094c implements Application.ActivityLifecycleCallbacks {
        public C0094c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            c.this.a(new z(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            c.this.a(new e0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            c.this.a(new d0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            c.this.a(new a0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            vc vcVar = new vc();
            c.this.a(new f0(this, activity, vcVar));
            Bundle b2 = vcVar.b(50L);
            if (b2 != null) {
                bundle.putAll(b2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            c.this.a(new b0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            c.this.a(new c0(this, activity));
        }
    }

    public c(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !b(str2, str3)) {
            this.f4100a = "FA";
        } else {
            this.f4100a = str;
        }
        this.f4101b = c.c.a.b.c.s.h.d();
        this.f4102c = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new c.c.a.b.g.a.a(this);
        if (!(!f(context) || g())) {
            this.f4105f = true;
            Log.w(this.f4100a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!b(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f4100a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f4100a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        a(new f(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f4100a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C0094c());
        }
    }

    public static c a(Context context) {
        return a(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static boolean b(String str, String str2) {
        return (str2 == null || str == null || g()) ? false : true;
    }

    public static boolean f(Context context) {
        return new c.c.a.b.c.o.u(context).a("google_app_id") != null;
    }

    public static int g(Context context) {
        return DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
    }

    public static int h(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    public static void i(Context context) {
        synchronized (c.class) {
            try {
            } catch (Exception e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                f4099i = Boolean.valueOf(o);
                j = false;
            }
            if (f4099i == null || j == null) {
                if (a(context, "app_measurement_internal_disable_startup_flags")) {
                    f4099i = Boolean.valueOf(o);
                    j = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f4099i = Boolean.valueOf(sharedPreferences.getBoolean(m, o));
                j = Boolean.valueOf(sharedPreferences.getBoolean(n, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(m);
                edit.remove(n);
                edit.apply();
            }
        }
    }

    public final long c() {
        vc vcVar = new vc();
        a(new n(this, vcVar));
        Long l2 = (Long) vc.a(vcVar.b(500L), Long.class);
        if (l2 != null) {
            return l2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f4101b.a()).nextLong();
        int i2 = this.f4104e + 1;
        this.f4104e = i2;
        return nextLong + i2;
    }

    public final String d() {
        vc vcVar = new vc();
        a(new m(this, vcVar));
        return vcVar.a(500L);
    }

    public final String e() {
        vc vcVar = new vc();
        a(new p(this, vcVar));
        return vcVar.a(500L);
    }

    public static c a(Context context, String str, String str2, String str3, Bundle bundle) {
        c.c.a.b.c.o.r.a(context);
        if (f4098h == null) {
            synchronized (c.class) {
                if (f4098h == null) {
                    f4098h = new c(context, str, str2, str3, bundle);
                }
            }
        }
        return f4098h;
    }

    public static boolean g() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void b(c.c.a.b.g.b.f6 f6Var) {
        c.c.a.b.c.o.r.a(f6Var);
        a(new u(this, f6Var));
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(new e(this, str, str2, bundle));
    }

    public final void b(String str) {
        a(new j(this, str));
    }

    public final String b() {
        vc vcVar = new vc();
        a(new k(this, vcVar));
        return vcVar.a(50L);
    }

    public final int c(String str) {
        vc vcVar = new vc();
        a(new r(this, str, vcVar));
        Integer num = (Integer) vc.a(vcVar.b(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public static boolean b(Context context) {
        i(context);
        synchronized (c.class) {
            if (!k) {
                try {
                    try {
                        String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", "");
                        if ("true".equals(str)) {
                            l = true;
                        } else if (Bugly.SDK_IS_DEV.equals(str)) {
                            l = false;
                        } else {
                            l = null;
                        }
                        k = true;
                    } catch (Exception e2) {
                        Log.e("FA", "Unable to call SystemProperties.get()", e2);
                        l = null;
                    }
                } finally {
                    k = true;
                }
            }
        }
        Boolean bool = l;
        if (bool == null) {
            bool = f4099i;
        }
        return bool.booleanValue();
    }

    public final void a(a aVar) {
        this.f4102c.execute(aVar);
    }

    public final xc a(Context context, boolean z) {
        DynamiteModule.b bVar;
        try {
            if (z) {
                bVar = DynamiteModule.k;
            } else {
                bVar = DynamiteModule.f10179i;
            }
            return wc.asInterface(DynamiteModule.a(context, bVar, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e2) {
            a((Exception) e2, true, false);
            return null;
        }
    }

    public final void a(Exception exc, boolean z, boolean z2) {
        this.f4105f |= z;
        if (z) {
            Log.w(this.f4100a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.f4100a, "Error with data collection. Data lost.", exc);
    }

    public final void a(c.c.a.b.g.b.f6 f6Var) {
        c.c.a.b.c.o.r.a(f6Var);
        a(new t(this, f6Var));
    }

    public final void a(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, null);
    }

    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        a(new x(this, l2, str, str2, bundle, z, z2));
    }

    public final void a(String str, String str2, Object obj) {
        a(str, str2, obj, true);
    }

    public final void a(String str, String str2, Object obj, boolean z) {
        a(new w(this, str, str2, obj, z));
    }

    public final void a(Bundle bundle) {
        a(new y(this, bundle));
    }

    public final List<Bundle> a(String str, String str2) {
        vc vcVar = new vc();
        a(new g(this, str, str2, vcVar));
        List<Bundle> list = (List) vc.a(vcVar.b(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void a(Activity activity, String str, String str2) {
        a(new h(this, activity, str, str2));
    }

    public final void a(String str) {
        a(new i(this, str));
    }

    public final String a() {
        vc vcVar = new vc();
        a(new l(this, vcVar));
        return vcVar.a(500L);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        vc vcVar = new vc();
        a(new o(this, str, str2, z, vcVar));
        Bundle b2 = vcVar.b(5000L);
        if (b2 != null && b2.size() != 0) {
            HashMap hashMap = new HashMap(b2.size());
            for (String str3 : b2.keySet()) {
                Object obj = b2.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void a(int i2, String str, Object obj, Object obj2, Object obj3) {
        a(new q(this, false, 5, str, obj, null, null));
    }

    public final void a(boolean z) {
        a(new v(this, z));
    }

    public static boolean a(Context context, String str) {
        c.c.a.b.c.o.r.b(str);
        try {
            ApplicationInfo a2 = c.c.a.b.c.t.c.b(context).a(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE);
            if (a2 != null && a2.metaData != null) {
                return a2.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
