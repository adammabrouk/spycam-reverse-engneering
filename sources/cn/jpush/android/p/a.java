package cn.jpush.android.p;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f9828a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9829b = false;

    /* renamed from: c, reason: collision with root package name */
    public c f9830c = new c();

    public static a a() {
        if (f9828a == null) {
            synchronized (a.class) {
                f9828a = new a();
            }
        }
        return f9828a;
    }

    public void a(Context context) {
        if (f9829b) {
            cn.jpush.android.r.b.b("JLifecycleBusiness", "lifecycle init already");
            return;
        }
        f9829b = true;
        ((Application) context).registerActivityLifecycleCallbacks(new b());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(Context context, String str) {
        if (!(context instanceof Activity) || f9829b) {
            cn.jpush.android.r.b.b("JLifecycleBusiness", "Push lifecycle need not handle, isInit: " + f9829b);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1897185151:
                if (str.equals("started")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1884319283:
                if (str.equals("stopped")) {
                    c2 = 3;
                    break;
                }
                break;
            case -995321554:
                if (str.equals("paused")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1097547223:
                if (str.equals("resumed")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1986762265:
                if (str.equals("destroyed")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            this.f9830c.b((Activity) context);
            return;
        }
        if (c2 == 1) {
            this.f9830c.c((Activity) context);
            return;
        }
        if (c2 == 2) {
            this.f9830c.d((Activity) context);
        } else if (c2 == 3) {
            this.f9830c.e((Activity) context);
        } else {
            if (c2 != 4) {
                return;
            }
            this.f9830c.f((Activity) context);
        }
    }
}
