package c.k.d.p9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class k1 {

    /* renamed from: e, reason: collision with root package name */
    public static k1 f7635e;

    /* renamed from: a, reason: collision with root package name */
    public Context f7636a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f7637b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f7638c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f7639d = new ArrayList();

    public k1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f7636a = applicationContext;
        if (applicationContext == null) {
            this.f7636a = context;
        }
        SharedPreferences sharedPreferences = this.f7636a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f7637b.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f7638c.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f7639d.add(str3);
            }
        }
    }

    public static k1 a(Context context) {
        if (f7635e == null) {
            f7635e = new k1(context);
        }
        return f7635e;
    }

    public void a(String str) {
        synchronized (this.f7637b) {
            if (!this.f7637b.contains(str)) {
                this.f7637b.add(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", c.k.d.k0.a(this.f7637b, ",")).commit();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m398a(String str) {
        boolean contains;
        synchronized (this.f7637b) {
            contains = this.f7637b.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f7638c) {
            if (!this.f7638c.contains(str)) {
                this.f7638c.add(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", c.k.d.k0.a(this.f7638c, ",")).commit();
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m399b(String str) {
        boolean contains;
        synchronized (this.f7638c) {
            contains = this.f7638c.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.f7639d) {
            if (!this.f7639d.contains(str)) {
                this.f7639d.add(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", c.k.d.k0.a(this.f7639d, ",")).commit();
            }
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m400c(String str) {
        boolean contains;
        synchronized (this.f7639d) {
            contains = this.f7639d.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f7637b) {
            if (this.f7637b.contains(str)) {
                this.f7637b.remove(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", c.k.d.k0.a(this.f7637b, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f7638c) {
            if (this.f7638c.contains(str)) {
                this.f7638c.remove(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", c.k.d.k0.a(this.f7638c, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f7639d) {
            if (this.f7639d.contains(str)) {
                this.f7639d.remove(str);
                this.f7636a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", c.k.d.k0.a(this.f7639d, ",")).commit();
            }
        }
    }
}
