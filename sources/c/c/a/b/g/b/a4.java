package c.c.a.b.g.b;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a4 {

    /* renamed from: a, reason: collision with root package name */
    public String f4568a;

    /* renamed from: b, reason: collision with root package name */
    public String f4569b;

    /* renamed from: c, reason: collision with root package name */
    public long f4570c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f4571d;

    public a4(String str, String str2, Bundle bundle, long j) {
        this.f4568a = str;
        this.f4569b = str2;
        this.f4571d = bundle == null ? new Bundle() : bundle;
        this.f4570c = j;
    }

    public final String toString() {
        String str = this.f4569b;
        String str2 = this.f4568a;
        String valueOf = String.valueOf(this.f4571d);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }
}
