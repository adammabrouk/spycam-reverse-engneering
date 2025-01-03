package cn.jiguang.l;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: cn.jiguang.l.a$a, reason: collision with other inner class name */
    public class C0141a extends e {

        /* renamed from: c, reason: collision with root package name */
        public Context f8934c;

        /* renamed from: d, reason: collision with root package name */
        public String f8935d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f8936e;

        public C0141a(Context context, String str, Bundle bundle) {
            this.f8934c = context;
            this.f8935d = str;
            this.f8936e = bundle;
            this.f8954b = str + "#BundleAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            try {
                a.this.a(this.f8934c, this.f8935d, this.f8936e);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommon", "BundleAction failed:" + th.getMessage());
            }
        }
    }

    public class b extends e {

        /* renamed from: c, reason: collision with root package name */
        public Context f8938c;

        /* renamed from: d, reason: collision with root package name */
        public String f8939d;

        public b(Context context, String str) {
            this.f8938c = context;
            this.f8939d = str;
            this.f8954b = str + "#CommonAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            try {
                cn.jiguang.h.a.a().a(this.f8939d);
                a.this.e(this.f8938c, this.f8939d);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommon", "dealAction failed:" + th.getMessage());
            }
        }
    }

    public class c extends e {

        /* renamed from: c, reason: collision with root package name */
        public Context f8941c;

        /* renamed from: d, reason: collision with root package name */
        public String f8942d;

        /* renamed from: e, reason: collision with root package name */
        public JSONObject f8943e;

        public c(Context context, String str, JSONObject jSONObject) {
            this.f8941c = context;
            this.f8942d = str;
            this.f8943e = jSONObject;
            this.f8954b = str + "#JsonAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            try {
                a.this.a(this.f8941c, this.f8942d, this.f8943e);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommon", "JsonAction-deal failed:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle) {
        a(str, bundle);
        boolean d2 = d();
        cn.jiguang.ai.a.a("JCommon", str + " isActionBundleEnable:" + d2);
        if (d2) {
            b(context, str);
            d(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, JSONObject jSONObject) {
        a(str, jSONObject);
        if (jSONObject.optInt("cmd") != 45) {
            boolean b2 = b();
            cn.jiguang.ai.a.a("JCommon", str + " isActionCommandEnable:" + b2);
            if (b2) {
                b(context, str);
                d(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, String str) {
        boolean a2 = a(context, str);
        cn.jiguang.ai.a.a("JCommon", str + " isBusinessEnable:" + a2);
        if (a2) {
            b(context, str);
        }
        boolean c2 = c(context, str);
        cn.jiguang.ai.a.a("JCommon", str + " isReportEnable:" + c2);
        if (c2) {
            d(context, str);
        }
    }

    private boolean f(Context context, String str) {
        boolean c2 = c();
        boolean b2 = b();
        boolean c3 = c(context);
        boolean z = c2 && b2 && c3;
        cn.jiguang.ai.a.a("JCommon", str + " isActionEnable:" + z + ",actionUserEnable:" + c2 + ",actionCommandEnable:" + b2 + ",actionUidEnable:" + c3);
        return z;
    }

    public abstract String a(Context context);

    public void a(Context context, int i2) {
        String a2 = a(context);
        cn.jiguang.ai.a.a("JCommon", "executeActionSingle: [" + a2 + "] from heartBeat, will delay " + i2 + "ms execute");
        boolean f2 = f(context, a2);
        boolean a3 = a(context, a2);
        cn.jiguang.ai.a.a("JCommon", a2 + " isActionEnable:" + f2 + ", isBusinessEnable:" + a3);
        if (f2 && a3) {
            d.a(new b(context, a2), i2);
        }
    }

    public void a(Context context, Bundle bundle) {
        String a2 = a(context);
        cn.jiguang.ai.a.a("JCommon", "executeBundleAction: [" + a2 + "] from bundle");
        boolean c2 = c();
        cn.jiguang.ai.a.a("JCommon", a2 + " isActionUserEnable:" + c2);
        if (c2) {
            d.a(new C0141a(context, a2, bundle));
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        String a2 = a(context);
        cn.jiguang.ai.a.a("JCommon", "executeCommandActionSingle: [" + a2 + "] from cmd");
        boolean c2 = c();
        cn.jiguang.ai.a.a("JCommon", a2 + " isActionUserEnable:" + c2);
        if (c2) {
            d.a(new c(context, a2, jSONObject));
        }
    }

    public void a(String str, Bundle bundle) {
        if (bundle != null) {
            cn.jiguang.ai.a.a("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    public void a(String str, JSONObject jSONObject) {
    }

    public boolean a(Context context, String str) {
        return cn.jiguang.l.b.a(context, str);
    }

    public void b(Context context) {
        try {
            String a2 = a(context);
            cn.jiguang.ai.a.a("JCommon", "executeAction: [" + a2 + "] from heartBeat");
            boolean f2 = f(context, a2);
            boolean a3 = a(context, a2);
            cn.jiguang.ai.a.a("JCommon", a2 + " - isActionEnable:" + f2 + ", isBusinessEnable:" + a3);
            if (f2 && a3) {
                d.a(new b(context, a2));
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.a("JCommon", "executeAction failed, error:" + th);
        }
    }

    public void b(Context context, String str) {
        cn.jiguang.l.b.d(context, str);
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public boolean c(Context context) {
        return d.c(context) > 0;
    }

    public boolean c(Context context, String str) {
        return cn.jiguang.l.b.b(context, str);
    }

    public Object d(Context context) {
        return null;
    }

    public void d(Context context, String str) {
        cn.jiguang.l.b.f(context, str);
    }

    public boolean d() {
        return true;
    }
}
