package c.k.d.p9;

import c.k.d.j;

/* loaded from: classes.dex */
public final class c extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7546a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f7547b;

    public c(int i2, k kVar) {
        this.f7546a = i2;
        this.f7547b = kVar;
    }

    @Override // c.k.d.j.a
    public int a() {
        return this.f7546a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7547b.a(this.f7546a);
    }
}
