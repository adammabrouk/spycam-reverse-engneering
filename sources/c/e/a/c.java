package c.e.a;

import android.util.SparseArray;

/* compiled from: ItemDelegateManager.kt */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<b<T>> f6179a = new SparseArray<>();

    public final int a() {
        return this.f6179a.size();
    }

    public final c<T> a(b<T> bVar) {
        f.j.b.f.d(bVar, "delegate");
        this.f6179a.put(this.f6179a.size(), bVar);
        return this;
    }

    public final int a(T t, int i2) {
        for (int size = this.f6179a.size() - 1; size >= 0; size--) {
            if (this.f6179a.valueAt(size).a(t, i2)) {
                return this.f6179a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i2 + " in data source");
    }

    public final void a(e eVar, T t, int i2) {
        f.j.b.f.d(eVar, "holder");
        int size = this.f6179a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b<T> valueAt = this.f6179a.valueAt(i3);
            if (valueAt.a(t, i2)) {
                valueAt.a(eVar, t, i2);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i2 + " in data source");
    }

    public final b<T> a(int i2) {
        b<T> bVar = this.f6179a.get(i2);
        if (bVar != null) {
            return bVar;
        }
        f.j.b.f.b();
        throw null;
    }
}
