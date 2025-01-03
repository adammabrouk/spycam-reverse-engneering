package c.c.b;

import android.content.Context;
import android.text.TextUtils;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.u;
import c.c.a.b.c.s.p;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5817c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5818d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5819e;

    /* renamed from: f, reason: collision with root package name */
    public final String f5820f;

    /* renamed from: g, reason: collision with root package name */
    public final String f5821g;

    public e(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        r.b(!p.a(str), "ApplicationId must be set.");
        this.f5816b = str;
        this.f5815a = str2;
        this.f5817c = str3;
        this.f5818d = str4;
        this.f5819e = str5;
        this.f5820f = str6;
        this.f5821g = str7;
    }

    public static e a(Context context) {
        u uVar = new u(context);
        String a2 = uVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new e(a2, uVar.a("google_api_key"), uVar.a("firebase_database_url"), uVar.a("ga_trackingId"), uVar.a("gcm_defaultSenderId"), uVar.a("google_storage_bucket"), uVar.a("project_id"));
    }

    public String b() {
        return this.f5816b;
    }

    public String c() {
        return this.f5819e;
    }

    public String d() {
        return this.f5821g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return q.a(this.f5816b, eVar.f5816b) && q.a(this.f5815a, eVar.f5815a) && q.a(this.f5817c, eVar.f5817c) && q.a(this.f5818d, eVar.f5818d) && q.a(this.f5819e, eVar.f5819e) && q.a(this.f5820f, eVar.f5820f) && q.a(this.f5821g, eVar.f5821g);
    }

    public int hashCode() {
        return q.a(this.f5816b, this.f5815a, this.f5817c, this.f5818d, this.f5819e, this.f5820f, this.f5821g);
    }

    public String toString() {
        q.a a2 = q.a(this);
        a2.a("applicationId", this.f5816b);
        a2.a("apiKey", this.f5815a);
        a2.a("databaseUrl", this.f5817c);
        a2.a("gcmSenderId", this.f5819e);
        a2.a("storageBucket", this.f5820f);
        a2.a("projectId", this.f5821g);
        return a2.toString();
    }

    public String a() {
        return this.f5815a;
    }
}
