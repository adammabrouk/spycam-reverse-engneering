package c.c.a.b.g.b;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4856a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4857b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4858c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f4859d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4860e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f4861f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f4862g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f4863h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h6 f4864i;

    public k6(h6 h6Var, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f4864i = h6Var;
        this.f4856a = str;
        this.f4857b = str2;
        this.f4858c = j;
        this.f4859d = bundle;
        this.f4860e = z;
        this.f4861f = z2;
        this.f4862g = z3;
        this.f4863h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4864i.a(this.f4856a, this.f4857b, this.f4858c, this.f4859d, this.f4860e, this.f4861f, this.f4862g, this.f4863h);
    }
}
