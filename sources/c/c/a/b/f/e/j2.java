package c.c.a.b.f.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j2 implements q1 {

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, j2> f4232f = new a.e.a();

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4233a;

    /* renamed from: d, reason: collision with root package name */
    public volatile Map<String, ?> f4236d;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.OnSharedPreferenceChangeListener f4234b = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: c.c.a.b.f.e.i2

        /* renamed from: a, reason: collision with root package name */
        public final j2 f4221a;

        {
            this.f4221a = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.f4221a.a(sharedPreferences, str);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public final Object f4235c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final List<r1> f4237e = new ArrayList();

    public j2(SharedPreferences sharedPreferences) {
        this.f4233a = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f4234b);
    }

    public static j2 a(Context context, String str) {
        j2 j2Var;
        if (!((!n1.a() || str.startsWith("direct_boot:")) ? true : n1.a(context))) {
            return null;
        }
        synchronized (j2.class) {
            j2Var = f4232f.get(str);
            if (j2Var == null) {
                j2Var = new j2(b(context, str));
                f4232f.put(str, j2Var);
            }
        }
        return j2Var;
    }

    public static SharedPreferences b(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return context.getSharedPreferences(str, 0);
            }
            if (n1.a()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return context.getSharedPreferences(str.substring(12), 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @Override // c.c.a.b.f.e.q1
    public final Object a(String str) {
        Map<String, ?> map = this.f4236d;
        if (map == null) {
            synchronized (this.f4235c) {
                map = this.f4236d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f4233a.getAll();
                        this.f4236d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (j2.class) {
            for (j2 j2Var : f4232f.values()) {
                j2Var.f4233a.unregisterOnSharedPreferenceChangeListener(j2Var.f4234b);
            }
            f4232f.clear();
        }
    }

    public final /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f4235c) {
            this.f4236d = null;
            a2.c();
        }
        synchronized (this) {
            Iterator<r1> it = this.f4237e.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
