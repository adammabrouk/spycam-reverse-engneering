package c.j.a.j;

import android.content.Context;
import c.j.a.z.f0;
import c.j.a.z.v;
import java.lang.reflect.Method;

/* compiled from: ConfigManagerFactory.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f6562b;

    /* renamed from: a, reason: collision with root package name */
    public e f6563a;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f6562b == null) {
                f6562b = new c();
            }
            cVar = f6562b;
        }
        return cVar;
    }

    public final e a(Context context) {
        e eVar = this.f6563a;
        if (eVar != null) {
            return eVar;
        }
        try {
            String str = f0.a(context) ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
            Method method = Class.forName(str).getMethod("getInstance", Context.class);
            v.d("ConfigManagerFactory", "createConfig success is ".concat(str));
            e eVar2 = (e) method.invoke(null, context);
            this.f6563a = eVar2;
            return eVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            v.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
