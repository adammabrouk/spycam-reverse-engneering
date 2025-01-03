package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class t6 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile t6 f7898c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7899a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, u6> f7900b = new HashMap();

    public t6(Context context) {
        this.f7899a = context;
    }

    public static t6 a(Context context) {
        if (context == null) {
            c.k.a.a.a.c.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f7898c == null) {
            synchronized (t6.class) {
                if (f7898c == null) {
                    f7898c = new t6(context);
                }
            }
        }
        return f7898c;
    }

    public u6 a() {
        u6 u6Var = this.f7900b.get("UPLOADER_PUSH_CHANNEL");
        if (u6Var != null) {
            return u6Var;
        }
        u6 u6Var2 = this.f7900b.get("UPLOADER_HTTP");
        if (u6Var2 != null) {
            return u6Var2;
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, u6> m482a() {
        return this.f7900b;
    }

    public void a(u6 u6Var, String str) {
        if (u6Var == null) {
            c.k.a.a.a.c.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            c.k.a.a.a.c.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m482a().put(str, u6Var);
        }
    }

    public boolean a(z6 z6Var, String str) {
        if (TextUtils.isEmpty(str)) {
            c.k.a.a.a.c.m6a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (c.k.d.p9.l0.a(z6Var, false)) {
            return false;
        }
        if (TextUtils.isEmpty(z6Var.d())) {
            z6Var.f(c.k.d.p9.l0.a());
        }
        z6Var.g(str);
        c.k.d.p9.m0.a(this.f7899a, z6Var);
        return true;
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f7899a.getPackageName(), this.f7899a.getPackageName(), str, str2, j, str3);
    }

    public final boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        z6 z6Var = new z6();
        z6Var.d(str3);
        z6Var.c(str4);
        z6Var.a(j);
        z6Var.b(str5);
        z6Var.a(true);
        z6Var.a("push_sdk_channel");
        z6Var.e(str2);
        return a(z6Var, str);
    }
}
