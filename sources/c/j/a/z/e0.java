package c.j.a.z;

import android.content.Context;
import java.util.HashMap;

/* compiled from: SystemCache.java */
/* loaded from: classes.dex */
public final class e0 implements j {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f6692d;

    /* renamed from: e, reason: collision with root package name */
    public static e0 f6693e;

    /* renamed from: a, reason: collision with root package name */
    public Context f6694a;

    /* renamed from: b, reason: collision with root package name */
    public j f6695b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6696c;

    static {
        new HashMap();
        new HashMap();
        f6692d = new HashMap<>();
    }

    public e0(Context context) {
        this.f6696c = false;
        this.f6694a = context;
        this.f6696c = a(context);
        v.d("SystemCache", "init status is " + this.f6696c + ";  curCache is " + this.f6695b);
    }

    public static synchronized e0 b(Context context) {
        e0 e0Var;
        synchronized (e0.class) {
            if (f6693e == null) {
                f6693e = new e0(context.getApplicationContext());
            }
            e0Var = f6693e;
        }
        return e0Var;
    }

    public final void a() {
        d0 d0Var = new d0();
        if (d0Var.a(this.f6694a)) {
            d0Var.a();
            v.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // c.j.a.z.j
    public final String b(String str, String str2) {
        j jVar;
        String str3 = f6692d.get(str);
        return (str3 != null || (jVar = this.f6695b) == null) ? str3 : jVar.b(str, str2);
    }

    @Override // c.j.a.z.j
    public final boolean a(Context context) {
        b0 b0Var = new b0();
        this.f6695b = b0Var;
        boolean a2 = b0Var.a(context);
        if (!a2) {
            d0 d0Var = new d0();
            this.f6695b = d0Var;
            a2 = d0Var.a(context);
        }
        if (!a2) {
            this.f6695b = null;
        }
        return a2;
    }

    @Override // c.j.a.z.j
    public final void a(String str, String str2) {
        j jVar;
        f6692d.put(str, str2);
        if (!this.f6696c || (jVar = this.f6695b) == null) {
            return;
        }
        jVar.a(str, str2);
    }
}
