package c.k.d;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class w implements s {

    /* renamed from: a, reason: collision with root package name */
    public Context f7969a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f7970b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7971c;

    /* renamed from: d, reason: collision with root package name */
    public Method f7972d = null;

    /* renamed from: e, reason: collision with root package name */
    public Method f7973e = null;

    /* renamed from: f, reason: collision with root package name */
    public Method f7974f = null;

    /* renamed from: g, reason: collision with root package name */
    public Method f7975g = null;

    public w(Context context) {
        this.f7969a = context;
        m514a(context);
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // c.k.d.s
    public String a() {
        return a(this.f7969a, this.f7972d);
    }

    public final String a(Context context, Method method) {
        Object obj = this.f7971c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            c.k.a.a.a.c.a("miui invoke error", e2);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m514a(Context context) {
        try {
            Class<?> a2 = q9.a(context, "com.android.id.impl.IdProviderImpl");
            this.f7970b = a2;
            this.f7971c = a2.newInstance();
            this.f7972d = this.f7970b.getMethod("getUDID", Context.class);
            this.f7973e = this.f7970b.getMethod("getOAID", Context.class);
            this.f7974f = this.f7970b.getMethod("getVAID", Context.class);
            this.f7975g = this.f7970b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            c.k.a.a.a.c.a("miui load class error", e2);
        }
    }

    @Override // c.k.d.s
    /* renamed from: a */
    public boolean mo415a() {
        return (this.f7970b == null || this.f7971c == null) ? false : true;
    }

    @Override // c.k.d.s
    public String b() {
        return a(this.f7969a, this.f7973e);
    }

    @Override // c.k.d.s
    public String c() {
        return a(this.f7969a, this.f7974f);
    }

    @Override // c.k.d.s
    public String d() {
        return a(this.f7969a, this.f7975g);
    }
}
