package cn.jiguang.ab;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f8123a = "";

    /* renamed from: b, reason: collision with root package name */
    public Context f8124b;

    public c(Context context) {
        this.f8124b = context;
    }

    public String a() {
        String b2 = b.a(this.f8124b).b(this.f8123a);
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    public void a(String str) {
        this.f8123a = str;
    }

    public String b() {
        String c2 = b.a(this.f8124b).c();
        return c2 == null ? "" : c2;
    }

    public String c() {
        String a2 = b.a(this.f8124b).a(this.f8123a);
        return a2 == null ? "" : a2;
    }
}
