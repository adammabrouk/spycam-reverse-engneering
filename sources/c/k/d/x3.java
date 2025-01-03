package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class x3 {

    /* renamed from: g, reason: collision with root package name */
    public static volatile x3 f7999g;

    /* renamed from: a, reason: collision with root package name */
    public Context f8000a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<z3, a4> f8001b;

    /* renamed from: c, reason: collision with root package name */
    public String f8002c;

    /* renamed from: d, reason: collision with root package name */
    public String f8003d;

    /* renamed from: e, reason: collision with root package name */
    public int f8004e;

    /* renamed from: f, reason: collision with root package name */
    public b4 f8005f;

    public x3(Context context) {
        HashMap<z3, a4> hashMap = new HashMap<>();
        this.f8001b = hashMap;
        this.f8000a = context;
        hashMap.put(z3.SERVICE_ACTION, new e4());
        this.f8001b.put(z3.SERVICE_COMPONENT, new f4());
        this.f8001b.put(z3.ACTIVITY, new v3());
        this.f8001b.put(z3.PROVIDER, new c4());
    }

    public static x3 a(Context context) {
        if (f7999g == null) {
            synchronized (x3.class) {
                if (f7999g == null) {
                    f7999g = new x3(context);
                }
            }
        }
        return f7999g;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m523a(Context context) {
        return c.k.d.p9.b.m358a(context, context.getPackageName());
    }

    public int a() {
        return this.f8004e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public b4 m524a() {
        return this.f8005f;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m525a() {
        return this.f8002c;
    }

    public void a(int i2) {
        this.f8004e = i2;
    }

    public void a(Context context, String str, int i2, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i2);
            j.a(this.f8000a).a(new y3(this, str, context, str2, str3));
        } else {
            t3.a(context, "" + str, 1008, "A receive a incorrect message");
        }
    }

    public void a(b4 b4Var) {
        this.f8005f = b4Var;
    }

    public void a(z3 z3Var, Context context, Intent intent, String str) {
        if (z3Var != null) {
            this.f8001b.get(z3Var).a(context, intent, str);
        } else {
            t3.a(context, LogUtils.NULL, 1008, "A receive a incorrect message with empty type");
        }
    }

    public final void a(z3 z3Var, Context context, w3 w3Var) {
        this.f8001b.get(z3Var).a(context, w3Var);
    }

    public void a(String str) {
        this.f8002c = str;
    }

    public void a(String str, String str2, int i2, b4 b4Var) {
        a(str);
        b(str2);
        a(i2);
        a(b4Var);
    }

    public String b() {
        return this.f8003d;
    }

    public void b(String str) {
        this.f8003d = str;
    }
}
