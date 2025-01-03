package c.k.c.a;

import c.k.c.a.p;
import c.k.d.z6;

/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z6 f6929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p.a.C0128a f6930b;

    public w(p.a.C0128a c0128a, z6 z6Var) {
        this.f6930b = c0128a;
        this.f6929a = z6Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6930b.f6887b.add(this.f6929a);
        this.f6930b.a();
    }
}
