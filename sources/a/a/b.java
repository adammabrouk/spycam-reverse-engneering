package a.a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f142a;

    /* renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList<a> f143b = new CopyOnWriteArrayList<>();

    public b(boolean z) {
        this.f142a = z;
    }

    public abstract void a();

    public final void a(boolean z) {
        this.f142a = z;
    }

    public final boolean b() {
        return this.f142a;
    }

    public final void c() {
        Iterator<a> it = this.f143b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public void a(a aVar) {
        this.f143b.add(aVar);
    }

    public void b(a aVar) {
        this.f143b.remove(aVar);
    }
}
