package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.h1;

/* loaded from: classes.dex */
public class u0 {

    /* renamed from: f, reason: collision with root package name */
    public static volatile u0 f7906f;

    /* renamed from: a, reason: collision with root package name */
    public Context f7907a;

    /* renamed from: b, reason: collision with root package name */
    public String f7908b;

    /* renamed from: c, reason: collision with root package name */
    public String f7909c;

    /* renamed from: d, reason: collision with root package name */
    public k1 f7910d;

    /* renamed from: e, reason: collision with root package name */
    public l1 f7911e;

    public u0(Context context) {
        new v0(this);
        new w0(this);
        new x0(this);
        this.f7907a = context;
    }

    public static u0 a(Context context) {
        if (f7906f == null) {
            synchronized (u0.class) {
                if (f7906f == null) {
                    f7906f = new u0(context);
                }
            }
        }
        return f7906f;
    }

    public String a() {
        return this.f7908b;
    }

    public void a(h1.a aVar) {
        h1.a(this.f7907a).a(aVar);
    }

    public void a(z6 z6Var) {
        if (m488a() && c.k.d.p9.l0.a(z6Var.e())) {
            a(e1.a(this.f7907a, c(), z6Var));
        }
    }

    public void a(String str) {
        if (m488a() && !TextUtils.isEmpty(str)) {
            a(m1.a(this.f7907a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f7910d != null) {
            if (bool.booleanValue()) {
                this.f7910d.b(this.f7907a, str2, str);
            } else {
                this.f7910d.a(this.f7907a, str2, str);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m488a() {
        return c.k.d.p9.m.a(this.f7907a).a(a7.StatDataSwitch.a(), true);
    }

    public String b() {
        return this.f7909c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f7907a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        n9.a(edit);
    }

    public final String c() {
        return this.f7907a.getDatabasePath(y0.f8029a).getAbsolutePath();
    }
}
