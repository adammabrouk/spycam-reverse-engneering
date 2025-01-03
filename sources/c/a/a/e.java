package c.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import c.a.a.l.j.l;
import c.a.a.l.j.s.a;
import c.a.a.l.j.s.c;
import c.a.a.l.j.s.d;
import c.a.a.l.j.s.e;
import c.a.a.l.j.t.a;
import c.a.a.l.j.t.b;
import c.a.a.l.j.t.c;
import c.a.a.l.j.t.e;
import c.a.a.l.j.t.f;
import c.a.a.l.j.t.g;
import c.a.a.l.j.t.h;
import c.a.a.l.k.e.i;
import c.a.a.l.k.e.j;
import c.a.a.l.k.e.m;
import c.a.a.l.k.e.o;
import c.a.a.m.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class e {
    public static volatile e l;

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.j.c f2915a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.c f2916b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.i.m.c f2917c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.i.n.h f2918d;

    /* renamed from: e, reason: collision with root package name */
    public final c.a.a.p.h.f f2919e = new c.a.a.p.h.f();

    /* renamed from: f, reason: collision with root package name */
    public final c.a.a.l.k.j.d f2920f = new c.a.a.l.k.j.d();

    /* renamed from: g, reason: collision with root package name */
    public final c.a.a.o.c f2921g;

    /* renamed from: h, reason: collision with root package name */
    public final c.a.a.l.k.e.e f2922h;

    /* renamed from: i, reason: collision with root package name */
    public final c.a.a.l.k.i.f f2923i;
    public final i j;
    public final c.a.a.l.k.i.f k;

    public e(c.a.a.l.i.c cVar, c.a.a.l.i.n.h hVar, c.a.a.l.i.m.c cVar2, Context context, c.a.a.l.a aVar) {
        this.f2916b = cVar;
        this.f2917c = cVar2;
        this.f2918d = hVar;
        this.f2915a = new c.a.a.l.j.c(context);
        new Handler(Looper.getMainLooper());
        new c.a.a.l.i.p.a(hVar, cVar2, aVar);
        this.f2921g = new c.a.a.o.c();
        o oVar = new o(cVar2, aVar);
        this.f2921g.a(InputStream.class, Bitmap.class, oVar);
        c.a.a.l.k.e.g gVar = new c.a.a.l.k.e.g(cVar2, aVar);
        this.f2921g.a(ParcelFileDescriptor.class, Bitmap.class, gVar);
        m mVar = new m(oVar, gVar);
        this.f2921g.a(c.a.a.l.j.g.class, Bitmap.class, mVar);
        c.a.a.l.k.h.c cVar3 = new c.a.a.l.k.h.c(context, cVar2);
        this.f2921g.a(InputStream.class, c.a.a.l.k.h.b.class, cVar3);
        this.f2921g.a(c.a.a.l.j.g.class, c.a.a.l.k.i.a.class, new c.a.a.l.k.i.g(mVar, cVar3, cVar2));
        this.f2921g.a(InputStream.class, File.class, new c.a.a.l.k.g.d());
        a(File.class, ParcelFileDescriptor.class, new a.C0072a());
        a(File.class, InputStream.class, new c.a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new c.a());
        a(Integer.TYPE, InputStream.class, new e.a());
        a(Integer.class, ParcelFileDescriptor.class, new c.a());
        a(Integer.class, InputStream.class, new e.a());
        a(String.class, ParcelFileDescriptor.class, new d.a());
        a(String.class, InputStream.class, new f.a());
        a(Uri.class, ParcelFileDescriptor.class, new e.a());
        a(Uri.class, InputStream.class, new g.a());
        a(URL.class, InputStream.class, new h.a());
        a(c.a.a.l.j.d.class, InputStream.class, new a.C0073a());
        a(byte[].class, InputStream.class, new b.a());
        this.f2920f.a(Bitmap.class, j.class, new c.a.a.l.k.j.b(context.getResources(), cVar2));
        this.f2920f.a(c.a.a.l.k.i.a.class, c.a.a.l.k.f.b.class, new c.a.a.l.k.j.a(new c.a.a.l.k.j.b(context.getResources(), cVar2)));
        c.a.a.l.k.e.e eVar = new c.a.a.l.k.e.e(cVar2);
        this.f2922h = eVar;
        this.f2923i = new c.a.a.l.k.i.f(cVar2, eVar);
        i iVar = new i(cVar2);
        this.j = iVar;
        this.k = new c.a.a.l.k.i.f(cVar2, iVar);
    }

    public static e a(Context context) {
        if (l == null) {
            synchronized (e.class) {
                if (l == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<c.a.a.n.a> a2 = new c.a.a.n.b(applicationContext).a();
                    f fVar = new f(applicationContext);
                    Iterator<c.a.a.n.a> it = a2.iterator();
                    while (it.hasNext()) {
                        it.next().a(applicationContext, fVar);
                    }
                    l = fVar.a();
                    Iterator<c.a.a.n.a> it2 = a2.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(applicationContext, l);
                    }
                }
            }
        }
        return l;
    }

    public c.a.a.l.i.m.c b() {
        return this.f2917c;
    }

    public c.a.a.l.k.i.f c() {
        return this.f2923i;
    }

    public c.a.a.l.k.i.f d() {
        return this.k;
    }

    public c.a.a.l.i.c e() {
        return this.f2916b;
    }

    public final c.a.a.l.j.c f() {
        return this.f2915a;
    }

    public <Z, R> c.a.a.l.k.j.c<Z, R> b(Class<Z> cls, Class<R> cls2) {
        return this.f2920f.a(cls, cls2);
    }

    public static <T> l<T, InputStream> b(Class<T> cls, Context context) {
        return a(cls, InputStream.class, context);
    }

    public static h b(Context context) {
        return k.a().a(context);
    }

    public <T, Z> c.a.a.o.b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        return this.f2921g.a(cls, cls2);
    }

    public <R> c.a.a.p.h.j<R> a(ImageView imageView, Class<R> cls) {
        return this.f2919e.a(imageView, cls);
    }

    public void a() {
        this.f2917c.a();
        this.f2918d.a();
    }

    public void a(int i2) {
        this.f2917c.a(i2);
        this.f2918d.a(i2);
    }

    public static void a(c.a.a.p.h.j<?> jVar) {
        c.a.a.r.h.a();
        c.a.a.p.b e2 = jVar.e();
        if (e2 != null) {
            e2.clear();
            jVar.a((c.a.a.p.b) null);
        }
    }

    public <T, Y> void a(Class<T> cls, Class<Y> cls2, c.a.a.l.j.m<T, Y> mVar) {
        c.a.a.l.j.m<T, Y> a2 = this.f2915a.a(cls, cls2, mVar);
        if (a2 != null) {
            a2.a();
        }
    }

    public static <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls == null) {
            if (!Log.isLoggable("Glide", 3)) {
                return null;
            }
            Log.d("Glide", "Unable to load null model, setting placeholder only");
            return null;
        }
        return a(context).f().a(cls, cls2);
    }

    public static <T> l<T, ParcelFileDescriptor> a(Class<T> cls, Context context) {
        return a(cls, ParcelFileDescriptor.class, context);
    }

    public static h a(FragmentActivity fragmentActivity) {
        return k.a().a(fragmentActivity);
    }
}
