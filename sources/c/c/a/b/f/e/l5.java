package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class l5 extends e3<String> implements k5, RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public static final l5 f4280c;

    /* renamed from: b, reason: collision with root package name */
    public final List<Object> f4281b;

    static {
        l5 l5Var = new l5();
        f4280c = l5Var;
        l5Var.c();
    }

    public l5() {
        this(10);
    }

    @Override // c.c.a.b.f.e.k5
    public final void a(k3 k3Var) {
        b();
        this.f4281b.add(k3Var);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        b();
        this.f4281b.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f4281b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f4281b.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof k3) {
            k3 k3Var = (k3) obj;
            String zzb = k3Var.zzb();
            if (k3Var.zzc()) {
                this.f4281b.set(i2, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = u4.b(bArr);
        if (u4.a(bArr)) {
            this.f4281b.set(i2, b2);
        }
        return b2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        Object remove = this.f4281b.remove(i2);
        ((AbstractList) this).modCount++;
        return a(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        b();
        return a(this.f4281b.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4281b.size();
    }

    @Override // c.c.a.b.f.e.z4
    public final /* synthetic */ z4 zza(int i2) {
        if (i2 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(this.f4281b);
        return new l5((ArrayList<Object>) arrayList);
    }

    @Override // c.c.a.b.f.e.k5
    public final Object zzb(int i2) {
        return this.f4281b.get(i2);
    }

    public l5(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        b();
        if (collection instanceof k5) {
            collection = ((k5) collection).zzb();
        }
        boolean addAll = this.f4281b.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // c.c.a.b.f.e.k5
    public final List<?> zzb() {
        return Collections.unmodifiableList(this.f4281b);
    }

    public l5(ArrayList<Object> arrayList) {
        this.f4281b = arrayList;
    }

    public static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof k3) {
            return ((k3) obj).zzb();
        }
        return u4.b((byte[]) obj);
    }

    @Override // c.c.a.b.f.e.k5
    public final k5 a() {
        return zza() ? new p7(this) : this;
    }
}
