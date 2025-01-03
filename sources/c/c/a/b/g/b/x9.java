package c.c.a.b.g.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x9 {

    /* renamed from: a, reason: collision with root package name */
    public final a5 f5190a;

    public x9(a5 a5Var) {
        this.f5190a = a5Var;
    }

    public final void a() {
        this.f5190a.a().g();
        if (d()) {
            if (c()) {
                this.f5190a.p().B.a(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f5190a.u().a("auto", "_cmpx", bundle);
            } else {
                String a2 = this.f5190a.p().B.a();
                if (TextUtils.isEmpty(a2)) {
                    this.f5190a.c().u().a("Cache still valid but referrer not found");
                } else {
                    long a3 = ((this.f5190a.p().C.a() / JConstants.HOUR) - 1) * JConstants.HOUR;
                    Uri parse = Uri.parse(a2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", a3);
                    this.f5190a.u().a((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.f5190a.p().B.a(null);
            }
            this.f5190a.p().C.a(0L);
        }
    }

    public final void b() {
        if (d() && c()) {
            this.f5190a.p().B.a(null);
        }
    }

    public final boolean c() {
        return d() && this.f5190a.b().a() - this.f5190a.p().C.a() > this.f5190a.o().a((String) null, r.R0);
    }

    public final boolean d() {
        return this.f5190a.p().C.a() > 0;
    }

    public final void a(String str, Bundle bundle) {
        String str2;
        this.f5190a.a().g();
        if (this.f5190a.g()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5190a.p().B.a(str2);
        this.f5190a.p().C.a(this.f5190a.b().a());
    }
}
