package c.k.d;

import android.util.SparseArray;
import c.k.d.j;

/* loaded from: classes.dex */
public class l extends j.b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7333b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, j.a aVar) {
        super(aVar);
        this.f7333b = jVar;
    }

    @Override // c.k.d.j.b
    public void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.f7333b.f7269c;
        synchronized (obj) {
            sparseArray = this.f7333b.f7268b;
            sparseArray.remove(this.f7271a.a());
        }
    }
}
