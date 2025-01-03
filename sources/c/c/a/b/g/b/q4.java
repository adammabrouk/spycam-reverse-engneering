package c.c.a.b.g.b;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5013a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5014b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5015c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5016d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j4 f5017e;

    public q4(j4 j4Var, String str, long j) {
        this.f5017e = j4Var;
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(j > 0);
        this.f5013a = String.valueOf(str).concat(":start");
        this.f5014b = String.valueOf(str).concat(":count");
        this.f5015c = String.valueOf(str).concat(":value");
        this.f5016d = j;
    }

    public final void a(String str, long j) {
        this.f5017e.g();
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f5017e.s().getLong(this.f5014b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.f5017e.s().edit();
            edit.putString(this.f5015c, str);
            edit.putLong(this.f5014b, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.f5017e.j().t().nextLong() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j3;
        SharedPreferences.Editor edit2 = this.f5017e.s().edit();
        if (z) {
            edit2.putString(this.f5015c, str);
        }
        edit2.putLong(this.f5014b, j3);
        edit2.apply();
    }

    public final void b() {
        this.f5017e.g();
        long a2 = this.f5017e.b().a();
        SharedPreferences.Editor edit = this.f5017e.s().edit();
        edit.remove(this.f5014b);
        edit.remove(this.f5015c);
        edit.putLong(this.f5013a, a2);
        edit.apply();
    }

    public final long c() {
        return this.f5017e.s().getLong(this.f5013a, 0L);
    }

    public final Pair<String, Long> a() {
        long abs;
        this.f5017e.g();
        this.f5017e.g();
        long c2 = c();
        if (c2 == 0) {
            b();
            abs = 0;
        } else {
            abs = Math.abs(c2 - this.f5017e.b().a());
        }
        long j = this.f5016d;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            b();
            return null;
        }
        String string = this.f5017e.s().getString(this.f5015c, null);
        long j2 = this.f5017e.s().getLong(this.f5014b, 0L);
        b();
        if (string != null && j2 > 0) {
            return new Pair<>(string, Long.valueOf(j2));
        }
        return j4.E;
    }
}
