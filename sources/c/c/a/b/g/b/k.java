package c.c.a.b.g.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzal;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f4841a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4842b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4843c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4844d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4845e;

    /* renamed from: f, reason: collision with root package name */
    public final zzal f4846f;

    public k(a5 a5Var, String str, String str2, String str3, long j, long j2, zzal zzalVar) {
        c.c.a.b.c.o.r.b(str2);
        c.c.a.b.c.o.r.b(str3);
        c.c.a.b.c.o.r.a(zzalVar);
        this.f4841a = str2;
        this.f4842b = str3;
        this.f4843c = TextUtils.isEmpty(str) ? null : str;
        this.f4844d = j;
        this.f4845e = j2;
        if (j2 != 0 && j2 > j) {
            a5Var.c().w().a("Event created with reverse previous/current timestamps. appId, name", w3.a(str2), w3.a(str3));
        }
        this.f4846f = zzalVar;
    }

    public final k a(a5 a5Var, long j) {
        return new k(a5Var, this.f4843c, this.f4841a, this.f4842b, this.f4844d, j, this.f4846f);
    }

    public final String toString() {
        String str = this.f4841a;
        String str2 = this.f4842b;
        String valueOf = String.valueOf(this.f4846f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    public k(a5 a5Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzal zzalVar;
        c.c.a.b.c.o.r.b(str2);
        c.c.a.b.c.o.r.b(str3);
        this.f4841a = str2;
        this.f4842b = str3;
        this.f4843c = TextUtils.isEmpty(str) ? null : str;
        this.f4844d = j;
        this.f4845e = j2;
        if (j2 != 0 && j2 > j) {
            a5Var.c().w().a("Event created with reverse previous/current timestamps. appId", w3.a(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    a5Var.c().t().a("Param name can't be null");
                    it.remove();
                } else {
                    Object a2 = a5Var.v().a(next, bundle2.get(next));
                    if (a2 == null) {
                        a5Var.c().w().a("Param value can't be null", a5Var.w().b(next));
                        it.remove();
                    } else {
                        a5Var.v().a(bundle2, next, a2);
                    }
                }
            }
            zzalVar = new zzal(bundle2);
        } else {
            zzalVar = new zzal(new Bundle());
        }
        this.f4846f = zzalVar;
    }
}
