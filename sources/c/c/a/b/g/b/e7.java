package c.c.a.b.g.b;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class e7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f4698b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4699c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4700d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a7 f4701e;

    public e7(a7 a7Var, boolean z, Uri uri, String str, String str2) {
        this.f4701e = a7Var;
        this.f4697a = z;
        this.f4698b = uri;
        this.f4699c = str;
        this.f4700d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4701e.a(this.f4697a, this.f4698b, this.f4699c, this.f4700d);
    }
}
