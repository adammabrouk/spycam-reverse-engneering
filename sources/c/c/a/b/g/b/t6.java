package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5096b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5097c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5098d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h6 f5099e;

    public t6(h6 h6Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5099e = h6Var;
        this.f5095a = atomicReference;
        this.f5096b = str;
        this.f5097c = str2;
        this.f5098d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5099e.f5160a.E().a(this.f5095a, this.f5096b, this.f5097c, this.f5098d);
    }
}
