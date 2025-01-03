package cn.jiguang.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static f f9031e = new f();

    /* renamed from: a, reason: collision with root package name */
    public String f9032a;

    /* renamed from: b, reason: collision with root package name */
    public String f9033b;

    /* renamed from: c, reason: collision with root package name */
    public String f9034c;

    /* renamed from: d, reason: collision with root package name */
    public String f9035d;

    public static f a() {
        return f9031e;
    }

    public String a(Context context) {
        if (!cn.jiguang.h.a.a().e(2009)) {
            return "";
        }
        if (!TextUtils.isEmpty(this.f9032a)) {
            return this.f9032a;
        }
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.ac());
        this.f9032a = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f9032a;
        }
        if (!cn.jiguang.l.b.a(2009)) {
            return "";
        }
        this.f9032a = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ac().a((cn.jiguang.f.a<String>) this.f9032a)});
        return this.f9032a;
    }

    public void a(Context context, String str) {
        this.f9033b = str;
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ae().a((cn.jiguang.f.a<String>) this.f9035d)});
    }

    public String b(Context context) {
        if (!cn.jiguang.h.a.a().e(2008)) {
            return "";
        }
        if (!TextUtils.isEmpty(this.f9034c)) {
            return this.f9034c;
        }
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.ad());
        this.f9034c = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f9034c;
        }
        if (!cn.jiguang.l.b.a(2008)) {
            return "";
        }
        this.f9034c = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ad().a((cn.jiguang.f.a<String>) this.f9034c)});
        return this.f9034c;
    }

    public void b(Context context, String str) {
        this.f9035d = str;
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ae().a((cn.jiguang.f.a<String>) str)});
    }

    public void c(Context context, String str) {
        this.f9032a = str;
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ac().a((cn.jiguang.f.a<String>) str)});
    }

    public void d(Context context, String str) {
        this.f9034c = str;
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.ad().a((cn.jiguang.f.a<String>) str)});
    }
}
