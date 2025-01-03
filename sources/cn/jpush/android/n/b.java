package cn.jpush.android.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.union.ads.nativ.sdk.download.service.InAppAIReceiver;
import cn.jpush.android.ar.d;
import cn.jpush.android.ar.f;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f9808a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9809b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9810c = false;

    /* renamed from: d, reason: collision with root package name */
    public InAppAIReceiver f9811d = new InAppAIReceiver();

    /* renamed from: e, reason: collision with root package name */
    public cn.jpush.android.s.b f9812e;

    /* renamed from: f, reason: collision with root package name */
    public cn.jpush.android.s.a f9813f;

    static {
        new cn.jpush.android.ay.a();
        new f();
    }

    public static b a() {
        if (f9808a == null) {
            synchronized (b.class) {
                if (f9808a == null) {
                    f9808a = new b();
                }
            }
        }
        return f9808a;
    }

    private void b(Context context) {
        f9808a.f9812e = new cn.jpush.android.s.b(context);
        f9808a.f9813f = new cn.jpush.android.s.a(context);
        if (((Boolean) Sp.get(context, Key.IgnoreLocalAllowRPConfig())).booleanValue()) {
            boolean booleanValue = ((Boolean) Sp.get(context, Key.AllowRunningProcess())).booleanValue();
            cn.jpush.android.r.b.b("JUnionCoreBusiness", "use remote allowRP config, enable: " + booleanValue);
            cn.jpush.android.u.a.c().setAllowRunningProcess(Boolean.valueOf(booleanValue));
        }
    }

    private void c(Context context) {
        new cn.jpush.android.at.b().a(context);
        cn.jpush.android.at.a.a().b(context);
    }

    private void d(Context context) {
        try {
            cn.jpush.android.r.b.b("JUnionCoreBusiness", "google play not register ir");
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionCoreBusiness", "register apk install receiver failed, " + th.getMessage());
        }
    }

    public void a(Context context) {
        try {
            if (f9810c) {
                cn.jpush.android.r.b.c("JUnionCoreBusiness", "SDK init already in remote");
                return;
            }
            f9810c = true;
            cn.jpush.android.r.b.e("JUnionCoreBusiness", "remote process init...");
            cn.jpush.android.az.c.a().a(context, null, true);
            d(context);
            c(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionCoreBusiness", "init on remote process failed, e: " + th.getMessage());
        }
    }

    public void a(Context context, Map<String, Object> map) {
        if (map == null || context == null) {
            cn.jpush.android.r.b.f("JUnionCoreBusiness", "Unexpected error, configs or context is null");
            return;
        }
        cn.jpush.android.r.b.b("JUnionCoreBusiness", "setSDKConfigs - configs: " + map);
        try {
            String str = (String) map.get("test_black_list_url");
            if (!TextUtils.isEmpty(str)) {
                cn.jpush.android.at.b.a(str);
            }
            String str2 = (String) map.get("test_statistic_url");
            if (!TextUtils.isEmpty(str2)) {
                cn.jpush.android.z.a.f9969a = str2;
            }
            String str3 = (String) map.get("test_event_url");
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            cn.jpush.android.z.a.f9970b = str3;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionCoreBusiness", "setSDKConfigs failed, " + th.getMessage());
        }
    }

    public void a(Context context, boolean z) {
        try {
            cn.jpush.android.r.b.e("JUnionCoreBusiness", "init, configValid: " + z);
            if (!z) {
                cn.jpush.android.r.b.i("JUnionCoreBusiness", "some config wrong, please check your AndroidManifest.xml!");
                return;
            }
            if (f9809b) {
                cn.jpush.android.r.b.c("JUnionCoreBusiness", "SDK init already");
                return;
            }
            f9809b = true;
            cn.jpush.android.u.a.a(context.getApplicationContext());
            b(context);
            cn.jpush.android.o.b.a(context);
            d.b(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionCoreBusiness", "init failed, e: " + th.getMessage());
        }
    }

    public cn.jpush.android.s.b b() {
        if (this.f9812e == null) {
            this.f9812e = new cn.jpush.android.s.b(cn.jpush.android.u.a.a());
        }
        return this.f9812e;
    }

    public cn.jpush.android.s.a c() {
        if (this.f9813f == null) {
            this.f9813f = new cn.jpush.android.s.a(cn.jpush.android.u.a.a());
        }
        return this.f9813f;
    }
}
