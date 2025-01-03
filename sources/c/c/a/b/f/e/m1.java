package c.c.a.b.f.e;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m1 implements q1 {

    /* renamed from: g, reason: collision with root package name */
    public static final Map<Uri, m1> f4290g = new a.e.a();

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f4291h = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f4292a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f4293b;

    /* renamed from: e, reason: collision with root package name */
    public volatile Map<String, String> f4296e;

    /* renamed from: c, reason: collision with root package name */
    public final ContentObserver f4294c = new o1(this, null);

    /* renamed from: d, reason: collision with root package name */
    public final Object f4295d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final List<r1> f4297f = new ArrayList();

    public m1(ContentResolver contentResolver, Uri uri) {
        this.f4292a = contentResolver;
        this.f4293b = uri;
        contentResolver.registerContentObserver(uri, false, this.f4294c);
    }

    public static m1 a(ContentResolver contentResolver, Uri uri) {
        m1 m1Var;
        synchronized (m1.class) {
            m1Var = f4290g.get(uri);
            if (m1Var == null) {
                try {
                    m1 m1Var2 = new m1(contentResolver, uri);
                    try {
                        f4290g.put(uri, m1Var2);
                    } catch (SecurityException unused) {
                    }
                    m1Var = m1Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return m1Var;
    }

    public static synchronized void e() {
        synchronized (m1.class) {
            for (m1 m1Var : f4290g.values()) {
                m1Var.f4292a.unregisterContentObserver(m1Var.f4294c);
            }
            f4290g.clear();
        }
    }

    public final void b() {
        synchronized (this.f4295d) {
            this.f4296e = null;
            a2.c();
        }
        synchronized (this) {
            Iterator<r1> it = this.f4297f.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    public final /* synthetic */ Map c() {
        Cursor query = this.f4292a.query(this.f4293b, f4291h, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map aVar = count <= 256 ? new a.e.a(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                aVar.put(query.getString(0), query.getString(1));
            }
            return aVar;
        } finally {
            query.close();
        }
    }

    public final Map<String, String> d() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) t1.a(new s1(this) { // from class: c.c.a.b.f.e.p1

                    /* renamed from: a, reason: collision with root package name */
                    public final m1 f4353a;

                    {
                        this.f4353a = this;
                    }

                    @Override // c.c.a.b.f.e.s1
                    public final Object zza() {
                        return this.f4353a.c();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public final Map<String, String> a() {
        Map<String, String> map = this.f4296e;
        if (map == null) {
            synchronized (this.f4295d) {
                map = this.f4296e;
                if (map == null) {
                    map = d();
                    this.f4296e = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    @Override // c.c.a.b.f.e.q1
    public final /* synthetic */ Object a(String str) {
        return a().get(str);
    }
}
