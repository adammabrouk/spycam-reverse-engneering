package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class y implements s {

    /* renamed from: c, reason: collision with root package name */
    public static volatile y f8026c;

    /* renamed from: a, reason: collision with root package name */
    public s f8027a;

    /* renamed from: b, reason: collision with root package name */
    public int f8028b = x.f7996a;

    public y(Context context) {
        this.f8027a = x.a(context);
        c.k.a.a.a.c.m6a("create id manager is: " + this.f8028b);
    }

    public static y a(Context context) {
        if (f8026c == null) {
            synchronized (y.class) {
                if (f8026c == null) {
                    f8026c = new y(context.getApplicationContext());
                }
            }
        }
        return f8026c;
    }

    @Override // c.k.d.s
    public String a() {
        return a(this.f8027a.a());
    }

    public final String a(String str) {
        return str == null ? "" : str;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            map.put("oaid", b2);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            map.put("aaid", d2);
        }
        map.put("oaid_type", String.valueOf(this.f8028b));
    }

    @Override // c.k.d.s
    /* renamed from: a */
    public boolean mo415a() {
        return this.f8027a.mo415a();
    }

    @Override // c.k.d.s
    public String b() {
        return a(this.f8027a.b());
    }

    public final String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 5 ? str.substring(str.length() - 5) : str;
    }

    @Override // c.k.d.s
    public String c() {
        return a(this.f8027a.c());
    }

    @Override // c.k.d.s
    public String d() {
        return a(this.f8027a.d());
    }

    public String e() {
        return "t:" + this.f8028b + " s:" + mo415a() + " d:" + b(a()) + " | " + b(b()) + " | " + b(c()) + " | " + b(d());
    }
}
