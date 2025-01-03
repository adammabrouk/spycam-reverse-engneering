package c.j.a.j;

import android.content.Context;
import android.text.TextUtils;
import c.j.a.z.c0;
import c.j.a.z.e0;
import c.j.a.z.m;
import c.j.a.z.v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ICacheSettings.java */
/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f6564e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6565a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6566b;

    /* renamed from: c, reason: collision with root package name */
    public List<T> f6567c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public Context f6568d;

    public d(Context context) {
        this.f6568d = c.j.a.z.c.c(context);
        c0 b2 = c0.b();
        b2.a(this.f6568d);
        this.f6565a = b2.c();
        this.f6566b = b2.d();
        c();
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public final String b() {
        return e0.b(this.f6568d).b(a(), null);
    }

    public abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f6564e) {
            m.a(a());
            this.f6567c.clear();
            c(b());
        }
    }

    public final void d(String str) {
        e0.b(this.f6568d).a(a(), str);
    }

    public final byte[] e() {
        byte[] bArr = this.f6565a;
        return (bArr == null || bArr.length <= 0) ? c0.b().c() : bArr;
    }

    public final byte[] f() {
        byte[] bArr = this.f6566b;
        return (bArr == null || bArr.length <= 0) ? c0.b().d() : bArr;
    }

    public final void d() {
        synchronized (f6564e) {
            this.f6567c.clear();
            d("");
            v.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            v.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            v.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            v.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> a2 = a(b(str));
            if (a2 != null) {
                this.f6567c.addAll(a2);
            }
        } catch (Exception e2) {
            d();
            v.d("CacheSettings", v.a(e2));
        }
    }
}
