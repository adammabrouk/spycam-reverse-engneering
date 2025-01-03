package c.c.a.b.f.e;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class g2 {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f4184a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4185b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4186c;

    public g2(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final a2<Long> a(String str, long j) {
        a2<Long> b2;
        b2 = a2.b(this, str, j, false);
        return b2;
    }

    public g2(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable l2<Context, Boolean> l2Var) {
        this.f4184a = uri;
        this.f4185b = str2;
        this.f4186c = str3;
    }

    public final a2<Boolean> a(String str, boolean z) {
        a2<Boolean> b2;
        b2 = a2.b(this, str, z, false);
        return b2;
    }

    public final a2<Double> a(String str, double d2) {
        a2<Double> b2;
        b2 = a2.b(this, str, -3.0d, false);
        return b2;
    }

    public final a2<String> a(String str, String str2) {
        a2<String> b2;
        b2 = a2.b(this, str, str2, false);
        return b2;
    }
}
