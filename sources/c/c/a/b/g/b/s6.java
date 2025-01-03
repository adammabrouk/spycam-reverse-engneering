package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5063a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5064b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5065c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5066d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5067e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h6 f5068f;

    public s6(h6 h6Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f5068f = h6Var;
        this.f5063a = atomicReference;
        this.f5064b = str;
        this.f5065c = str2;
        this.f5066d = str3;
        this.f5067e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5068f.f5160a.E().a(this.f5063a, this.f5064b, this.f5065c, this.f5066d, this.f5067e);
    }
}
