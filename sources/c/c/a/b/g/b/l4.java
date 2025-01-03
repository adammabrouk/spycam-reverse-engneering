package c.c.a.b.g.b;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4883a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4884b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4885c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4886d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j4 f4887e;

    public l4(j4 j4Var, String str, boolean z) {
        this.f4887e = j4Var;
        c.c.a.b.c.o.r.b(str);
        this.f4883a = str;
        this.f4884b = z;
    }

    public final boolean a() {
        if (!this.f4885c) {
            this.f4885c = true;
            this.f4886d = this.f4887e.s().getBoolean(this.f4883a, this.f4884b);
        }
        return this.f4886d;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.f4887e.s().edit();
        edit.putBoolean(this.f4883a, z);
        edit.apply();
        this.f4886d = z;
    }
}
