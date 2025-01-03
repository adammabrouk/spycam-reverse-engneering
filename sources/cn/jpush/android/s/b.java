package cn.jpush.android.s;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import cn.jpush.android.w.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f9853a;

    /* renamed from: h, reason: collision with root package name */
    public int f9860h;

    /* renamed from: i, reason: collision with root package name */
    public int f9861i;
    public int j;

    /* renamed from: c, reason: collision with root package name */
    public String f9855c = Build.VERSION.RELEASE;

    /* renamed from: d, reason: collision with root package name */
    public String f9856d = d.a();

    /* renamed from: e, reason: collision with root package name */
    public String f9857e = Build.BRAND;

    /* renamed from: f, reason: collision with root package name */
    public String f9858f = Build.MODEL;

    /* renamed from: b, reason: collision with root package name */
    public String f9854b = Build.MANUFACTURER;

    /* renamed from: g, reason: collision with root package name */
    public String f9859g = Build.PRODUCT;

    public b(Context context) {
        this.f9853a = context;
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        this.f9860h = a2.widthPixels;
        this.f9861i = a2.heightPixels;
        this.j = a2.densityDpi;
    }

    public String a() {
        return this.f9858f;
    }

    public String b() {
        return this.f9855c;
    }

    public String c() {
        return this.f9856d;
    }

    public String d() {
        return this.f9857e;
    }

    public int e() {
        return this.f9860h;
    }

    public int f() {
        return this.f9861i;
    }

    public String g() {
        return c.a.a.j.a.o;
    }
}
