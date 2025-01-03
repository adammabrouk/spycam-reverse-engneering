package c.a.a.l.i.n;

import android.util.Log;
import c.a.a.i.a;
import c.a.a.l.i.n.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: f, reason: collision with root package name */
    public static e f3161f;

    /* renamed from: a, reason: collision with root package name */
    public final c f3162a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final j f3163b = new j();

    /* renamed from: c, reason: collision with root package name */
    public final File f3164c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3165d;

    /* renamed from: e, reason: collision with root package name */
    public c.a.a.i.a f3166e;

    public e(File file, int i2) {
        this.f3164c = file;
        this.f3165d = i2;
    }

    public static synchronized a a(File file, int i2) {
        e eVar;
        synchronized (e.class) {
            if (f3161f == null) {
                f3161f = new e(file, i2);
            }
            eVar = f3161f;
        }
        return eVar;
    }

    @Override // c.a.a.l.i.n.a
    public File b(c.a.a.l.c cVar) {
        try {
            a.d c2 = a().c(this.f3163b.a(cVar));
            if (c2 != null) {
                return c2.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    public final synchronized c.a.a.i.a a() throws IOException {
        if (this.f3166e == null) {
            this.f3166e = c.a.a.i.a.a(this.f3164c, 1, 1, this.f3165d);
        }
        return this.f3166e;
    }

    @Override // c.a.a.l.i.n.a
    public void a(c.a.a.l.c cVar, a.b bVar) {
        String a2 = this.f3163b.a(cVar);
        this.f3162a.a(cVar);
        try {
            try {
                a.b b2 = a().b(a2);
                if (b2 != null) {
                    try {
                        if (bVar.a(b2.a(0))) {
                            b2.c();
                        }
                        b2.b();
                    } catch (Throwable th) {
                        b2.b();
                        throw th;
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
        } finally {
            this.f3162a.b(cVar);
        }
    }

    @Override // c.a.a.l.i.n.a
    public void a(c.a.a.l.c cVar) {
        try {
            a().e(this.f3163b.a(cVar));
        } catch (IOException e2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e2);
            }
        }
    }
}
