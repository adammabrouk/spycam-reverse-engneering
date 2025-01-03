package c.c.a.a.j.w;

import c.c.a.a.j.l;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final c f3632a;

    /* renamed from: b, reason: collision with root package name */
    public final l f3633b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.h f3634c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.h f3635d;

    public a(c cVar, l lVar, c.c.a.a.h hVar, c.c.a.a.j.h hVar2) {
        this.f3632a = cVar;
        this.f3633b = lVar;
        this.f3634c = hVar;
        this.f3635d = hVar2;
    }

    public static Runnable a(c cVar, l lVar, c.c.a.a.h hVar, c.c.a.a.j.h hVar2) {
        return new a(cVar, lVar, hVar, hVar2);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.a(this.f3632a, this.f3633b, this.f3634c, this.f3635d);
    }
}
