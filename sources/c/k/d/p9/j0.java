package c.k.d.p9;

import android.content.Context;
import android.content.SharedPreferences;
import c.k.d.n9;
import cn.jiguang.internal.JConstants;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class j0 implements g {

    /* renamed from: f, reason: collision with root package name */
    public static volatile j0 f7618f;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f7619a;

    /* renamed from: b, reason: collision with root package name */
    public long f7620b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f7621c = false;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<String, a> f7622d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public Context f7623e;

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f7624a;

        /* renamed from: b, reason: collision with root package name */
        public long f7625b;

        public a(String str, long j) {
            this.f7624a = str;
            this.f7625b = j;
        }

        public abstract void a(j0 j0Var);

        @Override // java.lang.Runnable
        public void run() {
            if (j0.f7618f != null) {
                Context context = j0.f7618f.f7623e;
                if (c.k.d.e0.c(context)) {
                    if (System.currentTimeMillis() - j0.f7618f.f7619a.getLong(":ts-" + this.f7624a, 0L) > this.f7625b || c.k.d.g.a(context)) {
                        n9.a(j0.f7618f.f7619a.edit().putLong(":ts-" + this.f7624a, System.currentTimeMillis()));
                        a(j0.f7618f);
                    }
                }
            }
        }
    }

    public j0(Context context) {
        this.f7623e = context.getApplicationContext();
        this.f7619a = context.getSharedPreferences("sync", 0);
    }

    public static j0 a(Context context) {
        if (f7618f == null) {
            synchronized (j0.class) {
                if (f7618f == null) {
                    f7618f = new j0(context);
                }
            }
        }
        return f7618f;
    }

    public String a(String str, String str2) {
        return this.f7619a.getString(str + ":" + str2, "");
    }

    @Override // c.k.d.p9.g
    /* renamed from: a, reason: collision with other method in class */
    public void mo388a() {
        if (this.f7621c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7620b < JConstants.HOUR) {
            return;
        }
        this.f7620b = currentTimeMillis;
        this.f7621c = true;
        c.k.d.j.a(this.f7623e).a(new k0(this), (int) (Math.random() * 10.0d));
    }

    public void a(a aVar) {
        if (this.f7622d.putIfAbsent(aVar.f7624a, aVar) == null) {
            c.k.d.j.a(this.f7623e).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        n9.a(f7618f.f7619a.edit().putString(str + ":" + str2, str3));
    }
}
