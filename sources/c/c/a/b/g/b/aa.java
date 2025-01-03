package c.c.a.b.g.b;

import java.util.BitSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class aa extends i9 {

    /* renamed from: d, reason: collision with root package name */
    public String f4589d;

    /* renamed from: e, reason: collision with root package name */
    public Set<Integer> f4590e;

    /* renamed from: f, reason: collision with root package name */
    public Map<Integer, ca> f4591f;

    /* renamed from: g, reason: collision with root package name */
    public Long f4592g;

    /* renamed from: h, reason: collision with root package name */
    public Long f4593h;

    public aa(l9 l9Var) {
        super(l9Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<c.c.a.b.f.e.v0> a(java.lang.String r47, java.util.List<c.c.a.b.f.e.x0> r48, java.util.List<c.c.a.b.f.e.f1> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            Method dump skipped, instructions count: 1743
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.aa.a(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    @Override // c.c.a.b.g.b.i9
    public final boolean s() {
        return false;
    }

    public final ca a(int i2) {
        if (this.f4591f.containsKey(Integer.valueOf(i2))) {
            return this.f4591f.get(Integer.valueOf(i2));
        }
        ca caVar = new ca(this, this.f4589d, null);
        this.f4591f.put(Integer.valueOf(i2), caVar);
        return caVar;
    }

    public final boolean a(int i2, int i3) {
        BitSet bitSet;
        if (this.f4591f.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        bitSet = this.f4591f.get(Integer.valueOf(i2)).f4646d;
        return bitSet.get(i3);
    }
}
