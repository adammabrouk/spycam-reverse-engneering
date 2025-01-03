package c.k.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class h1 {

    /* renamed from: f, reason: collision with root package name */
    public static volatile h1 f7191f;

    /* renamed from: a, reason: collision with root package name */
    public Context f7192a;

    /* renamed from: b, reason: collision with root package name */
    public g1 f7193b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, f1> f7194c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f7195d = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<a> f7196e = new ArrayList<>();

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f7197a;

        /* renamed from: b, reason: collision with root package name */
        public f1 f7198b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f7199c;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<Context> f7200d;

        /* renamed from: e, reason: collision with root package name */
        public a f7201e;

        public a(String str) {
            new Random();
            this.f7199c = str;
        }

        public SQLiteDatabase a() {
            return this.f7198b.getWritableDatabase();
        }

        /* renamed from: a, reason: collision with other method in class */
        public Object mo187a() {
            return null;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m188a() {
            return this.f7199c;
        }

        public void a(Context context) {
            a aVar = this.f7201e;
            if (aVar != null) {
                aVar.a(context, mo187a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            h1.a(context).a(this);
        }

        public void a(f1 f1Var, Context context) {
            this.f7198b = f1Var;
            this.f7197a = f1Var.a();
            this.f7200d = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f7201e = aVar;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m189a() {
            return this.f7198b == null || TextUtils.isEmpty(this.f7197a) || this.f7200d == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f7200d;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f7198b == null || TextUtils.isEmpty(this.f7199c)) {
                return;
            }
            File file = new File(this.f7199c);
            s9.a(context, new File(file.getParentFile(), j0.b(file.getAbsolutePath())), new j1(this, context));
        }
    }

    public static abstract class b<T> extends a {

        /* renamed from: f, reason: collision with root package name */
        public List<String> f7202f;

        /* renamed from: g, reason: collision with root package name */
        public String f7203g;

        /* renamed from: h, reason: collision with root package name */
        public String[] f7204h;

        /* renamed from: i, reason: collision with root package name */
        public String f7205i;
        public String j;
        public String k;
        public int l;
        public List<T> m;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.m = new ArrayList();
            this.f7202f = list;
            this.f7203g = str2;
            this.f7204h = strArr;
            this.f7205i = str3;
            this.j = str4;
            this.k = str5;
            this.l = i2;
        }

        @Override // c.k.d.h1.a
        public SQLiteDatabase a() {
            return this.f7198b.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // c.k.d.h1.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.m.clear();
            List<String> list = this.f7202f;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f7202f.size()];
                this.f7202f.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.l;
            Cursor query = sQLiteDatabase.query(this.f7197a, strArr, this.f7203g, this.f7204h, this.f7205i, this.j, this.k, i2 > 0 ? String.valueOf(i2) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.m.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.m);
        }

        public abstract void a(Context context, List<T> list);
    }

    public static class c extends a {

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<a> f7206f;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f7206f = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // c.k.d.h1.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f7206f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // c.k.d.h1.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f7206f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    public static class d extends a {

        /* renamed from: f, reason: collision with root package name */
        public String f7207f;

        /* renamed from: g, reason: collision with root package name */
        public String[] f7208g;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f7207f = str2;
            this.f7208g = strArr;
        }

        @Override // c.k.d.h1.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f7197a, this.f7207f, this.f7208g);
        }
    }

    public static class e extends a {

        /* renamed from: f, reason: collision with root package name */
        public ContentValues f7209f;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f7209f = contentValues;
        }

        @Override // c.k.d.h1.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f7197a, null, this.f7209f);
        }
    }

    public h1(Context context) {
        this.f7192a = context;
    }

    public static h1 a(Context context) {
        if (f7191f == null) {
            synchronized (h1.class) {
                if (f7191f == null) {
                    f7191f = new h1(context);
                }
            }
        }
        return f7191f;
    }

    public final f1 a(String str) {
        f1 f1Var = this.f7194c.get(str);
        if (f1Var == null) {
            synchronized (this.f7194c) {
                if (f1Var == null) {
                    f1Var = this.f7193b.a(this.f7192a, str);
                    this.f7194c.put(str, f1Var);
                }
            }
        }
        return f1Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m186a(String str) {
        return a(str).a();
    }

    public final void a() {
        j.a(this.f7192a).b(new i1(this), c.k.d.p9.m.a(this.f7192a).a(a7.StatDataProcessFrequency.a(), 5));
    }

    public void a(a aVar) {
        f1 f1Var;
        if (aVar == null) {
            return;
        }
        if (this.f7193b == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m188a = aVar.m188a();
        synchronized (this.f7194c) {
            f1Var = this.f7194c.get(m188a);
            if (f1Var == null) {
                f1Var = this.f7193b.a(this.f7192a, m188a);
                this.f7194c.put(m188a, f1Var);
            }
        }
        if (this.f7195d.isShutdown()) {
            return;
        }
        aVar.a(f1Var, this.f7192a);
        synchronized (this.f7196e) {
            this.f7196e.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f7195d.isShutdown()) {
            return;
        }
        this.f7195d.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f7193b == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f7195d.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m189a()) {
                next.a(a(next.m188a()), this.f7192a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m188a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m188a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f7198b, this.f7192a);
                this.f7195d.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        f1 f1Var;
        if (aVar == null) {
            return;
        }
        if (this.f7193b == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m188a = aVar.m188a();
        synchronized (this.f7194c) {
            f1Var = this.f7194c.get(m188a);
            if (f1Var == null) {
                f1Var = this.f7193b.a(this.f7192a, m188a);
                this.f7194c.put(m188a, f1Var);
            }
        }
        if (this.f7195d.isShutdown()) {
            return;
        }
        aVar.a(f1Var, this.f7192a);
        a((Runnable) aVar);
    }
}
