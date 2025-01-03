package a.h.g;

import a.h.g.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.e.e<String, Typeface> f1032a = new a.e.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1033b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1034c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final a.e.g<String, ArrayList<a.h.i.a<C0021e>>> f1035d = new a.e.g<>();

    /* compiled from: FontRequestWorker.java */
    public class a implements Callable<C0021e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1036a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1037b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.h.g.d f1038c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1039d;

        public a(String str, Context context, a.h.g.d dVar, int i2) {
            this.f1036a = str;
            this.f1037b = context;
            this.f1038c = dVar;
            this.f1039d = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C0021e call() {
            return e.a(this.f1036a, this.f1037b, this.f1038c, this.f1039d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    public class b implements a.h.i.a<C0021e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.h.g.a f1040a;

        public b(a.h.g.a aVar) {
            this.f1040a = aVar;
        }

        @Override // a.h.i.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(C0021e c0021e) {
            this.f1040a.a(c0021e);
        }
    }

    /* compiled from: FontRequestWorker.java */
    public class c implements Callable<C0021e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1041a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1042b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.h.g.d f1043c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1044d;

        public c(String str, Context context, a.h.g.d dVar, int i2) {
            this.f1041a = str;
            this.f1042b = context;
            this.f1043c = dVar;
            this.f1044d = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C0021e call() {
            return e.a(this.f1041a, this.f1042b, this.f1043c, this.f1044d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    public class d implements a.h.i.a<C0021e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1045a;

        public d(String str) {
            this.f1045a = str;
        }

        @Override // a.h.i.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(C0021e c0021e) {
            synchronized (e.f1034c) {
                ArrayList<a.h.i.a<C0021e>> arrayList = e.f1035d.get(this.f1045a);
                if (arrayList == null) {
                    return;
                }
                e.f1035d.remove(this.f1045a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).accept(c0021e);
                }
            }
        }
    }

    public static Typeface a(Context context, a.h.g.d dVar, a.h.g.a aVar, int i2, int i3) {
        String a2 = a(dVar, i2);
        Typeface b2 = f1032a.b(a2);
        if (b2 != null) {
            aVar.a(new C0021e(b2));
            return b2;
        }
        if (i3 == -1) {
            C0021e a3 = a(a2, context, dVar, i2);
            aVar.a(a3);
            return a3.f1046a;
        }
        try {
            C0021e c0021e = (C0021e) g.a(f1033b, new a(a2, context, dVar, i2), i3);
            aVar.a(c0021e);
            return c0021e.f1046a;
        } catch (InterruptedException unused) {
            aVar.a(new C0021e(-3));
            return null;
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: a.h.g.e$e, reason: collision with other inner class name */
    public static final class C0021e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f1046a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1047b;

        public C0021e(int i2) {
            this.f1046a = null;
            this.f1047b = i2;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f1047b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public C0021e(Typeface typeface) {
            this.f1046a = typeface;
            this.f1047b = 0;
        }
    }

    public static Typeface a(Context context, a.h.g.d dVar, int i2, Executor executor, a.h.g.a aVar) {
        String a2 = a(dVar, i2);
        Typeface b2 = f1032a.b(a2);
        if (b2 != null) {
            aVar.a(new C0021e(b2));
            return b2;
        }
        b bVar = new b(aVar);
        synchronized (f1034c) {
            ArrayList<a.h.i.a<C0021e>> arrayList = f1035d.get(a2);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<a.h.i.a<C0021e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            f1035d.put(a2, arrayList2);
            c cVar = new c(a2, context, dVar, i2);
            if (executor == null) {
                executor = f1033b;
            }
            g.a(executor, cVar, new d(a2));
            return null;
        }
    }

    public static String a(a.h.g.d dVar, int i2) {
        return dVar.c() + "-" + i2;
    }

    public static C0021e a(String str, Context context, a.h.g.d dVar, int i2) {
        Typeface b2 = f1032a.b(str);
        if (b2 != null) {
            return new C0021e(b2);
        }
        try {
            f.a a2 = a.h.g.c.a(context, dVar, (CancellationSignal) null);
            int a3 = a(a2);
            if (a3 != 0) {
                return new C0021e(a3);
            }
            Typeface a4 = a.h.c.d.a(context, null, a2.a(), i2);
            if (a4 != null) {
                f1032a.a(str, a4);
                return new C0021e(a4);
            }
            return new C0021e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0021e(-1);
        }
    }

    @SuppressLint({"WrongConstant"})
    public static int a(f.a aVar) {
        int i2 = 1;
        if (aVar.b() != 0) {
            return aVar.b() != 1 ? -3 : -2;
        }
        f.b[] a2 = aVar.a();
        if (a2 != null && a2.length != 0) {
            i2 = 0;
            for (f.b bVar : a2) {
                int a3 = bVar.a();
                if (a3 != 0) {
                    if (a3 < 0) {
                        return -3;
                    }
                    return a3;
                }
            }
        }
        return i2;
    }
}
