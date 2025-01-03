package c.c.a.b.g.b;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4947a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4948b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4949c;

    /* renamed from: d, reason: collision with root package name */
    public long f4950d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j4 f4951e;

    public n4(j4 j4Var, String str, long j) {
        this.f4951e = j4Var;
        c.c.a.b.c.o.r.b(str);
        this.f4947a = str;
        this.f4948b = j;
    }

    public final long a() {
        if (!this.f4949c) {
            this.f4949c = true;
            this.f4950d = this.f4951e.s().getLong(this.f4947a, this.f4948b);
        }
        return this.f4950d;
    }

    public final void a(long j) {
        SharedPreferences.Editor edit = this.f4951e.s().edit();
        edit.putLong(this.f4947a, j);
        edit.apply();
        this.f4950d = j;
    }
}
