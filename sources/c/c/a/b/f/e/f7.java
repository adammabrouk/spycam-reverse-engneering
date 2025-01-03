package c.c.a.b.f.e;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class f7<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public int f4165a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4166b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator<Map.Entry<K, V>> f4167c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x6 f4168d;

    public f7(x6 x6Var) {
        this.f4168d = x6Var;
        this.f4165a = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.f4165a + 1;
        list = this.f4168d.f4517b;
        if (i2 >= list.size()) {
            map = this.f4168d.f4518c;
            if (map.isEmpty() || !zza().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.f4166b = true;
        int i2 = this.f4165a + 1;
        this.f4165a = i2;
        list = this.f4168d.f4517b;
        if (i2 >= list.size()) {
            return zza().next();
        }
        list2 = this.f4168d.f4517b;
        return (Map.Entry) list2.get(this.f4165a);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f4166b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f4166b = false;
        this.f4168d.f();
        int i2 = this.f4165a;
        list = this.f4168d.f4517b;
        if (i2 >= list.size()) {
            zza().remove();
            return;
        }
        x6 x6Var = this.f4168d;
        int i3 = this.f4165a;
        this.f4165a = i3 - 1;
        x6Var.b(i3);
    }

    public final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.f4167c == null) {
            map = this.f4168d.f4518c;
            this.f4167c = map.entrySet().iterator();
        }
        return this.f4167c;
    }

    public /* synthetic */ f7(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
