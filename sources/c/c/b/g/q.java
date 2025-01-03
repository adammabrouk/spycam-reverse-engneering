package c.c.b.g;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f5867a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.b.j.a f5868b;

    public q(Map.Entry entry, c.c.b.j.a aVar) {
        this.f5867a = entry;
        this.f5868b = aVar;
    }

    public static Runnable a(Map.Entry entry, c.c.b.j.a aVar) {
        return new q(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((c.c.b.j.b) this.f5867a.getKey()).a(this.f5868b);
    }
}
