package cn.jiguang.y;

import android.content.Context;
import android.net.Uri;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f9073a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f9074b;

    public b(Context context) {
        this.f9073a = context;
        String g2 = d.g("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr");
        cn.jiguang.ai.a.a("NubiaOpenIDHelper", "url: " + g2);
        this.f9074b = Uri.parse(g2);
    }

    public String a() {
        try {
            return a.a(this.f9073a, this.f9073a.getPackageName(), this.f9074b);
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("NubiaOpenIDHelper", "get Ids-aa error: " + e2.getMessage());
            return "";
        }
    }

    public String b() {
        try {
            return a.a(this.f9073a, this.f9074b);
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("NubiaOpenIDHelper", "get Ids-oa error: " + e2.getMessage());
            return "";
        }
    }

    public String c() {
        try {
            return a.b(this.f9073a, this.f9073a.getPackageName(), this.f9074b);
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("NubiaOpenIDHelper", "get Ids-va error: " + e2.getMessage());
            return "";
        }
    }
}
