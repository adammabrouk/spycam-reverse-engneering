package c.c.a.b.g.b;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class p4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4996a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4997b;

    /* renamed from: c, reason: collision with root package name */
    public String f4998c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j4 f4999d;

    public p4(j4 j4Var, String str, String str2) {
        this.f4999d = j4Var;
        c.c.a.b.c.o.r.b(str);
        this.f4996a = str;
    }

    public final String a() {
        if (!this.f4997b) {
            this.f4997b = true;
            this.f4998c = this.f4999d.s().getString(this.f4996a, null);
        }
        return this.f4998c;
    }

    public final void a(String str) {
        if (this.f4999d.l().a(r.y0) || !s9.c(str, this.f4998c)) {
            SharedPreferences.Editor edit = this.f4999d.s().edit();
            edit.putString(this.f4996a, str);
            edit.apply();
            this.f4998c = str;
        }
    }
}
