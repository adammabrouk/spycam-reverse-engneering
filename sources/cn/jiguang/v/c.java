package cn.jiguang.v;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f9067a = "";

    /* renamed from: b, reason: collision with root package name */
    public Context f9068b;

    public c(Context context) {
        this.f9068b = context;
    }

    public String a() {
        String b2 = b.a(this.f9068b).b(this.f9067a);
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    public String b() {
        String c2 = b.a(this.f9068b).c();
        return c2 == null ? "" : c2;
    }

    public String c() {
        String a2 = b.a(this.f9068b).a(this.f9067a);
        return a2 == null ? "" : a2;
    }
}
