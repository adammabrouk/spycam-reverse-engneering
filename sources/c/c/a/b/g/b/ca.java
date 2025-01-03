package c.c.a.b.g.b;

import c.c.a.b.f.e.e1;
import c.c.a.b.f.e.w0;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class ca {

    /* renamed from: a, reason: collision with root package name */
    public String f4643a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4644b;

    /* renamed from: c, reason: collision with root package name */
    public c.c.a.b.f.e.d1 f4645c;

    /* renamed from: d, reason: collision with root package name */
    public BitSet f4646d;

    /* renamed from: e, reason: collision with root package name */
    public BitSet f4647e;

    /* renamed from: f, reason: collision with root package name */
    public Map<Integer, Long> f4648f;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, List<Long>> f4649g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ aa f4650h;

    public ca(aa aaVar, String str) {
        this.f4650h = aaVar;
        this.f4643a = str;
        this.f4644b = true;
        this.f4646d = new BitSet();
        this.f4647e = new BitSet();
        this.f4648f = new a.e.a();
        this.f4649g = new a.e.a();
    }

    public final void a(da daVar) {
        int a2 = daVar.a();
        Boolean bool = daVar.f4683c;
        if (bool != null) {
            this.f4647e.set(a2, bool.booleanValue());
        }
        Boolean bool2 = daVar.f4684d;
        if (bool2 != null) {
            this.f4646d.set(a2, bool2.booleanValue());
        }
        if (daVar.f4685e != null) {
            Long l = this.f4648f.get(Integer.valueOf(a2));
            long longValue = daVar.f4685e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f4648f.put(Integer.valueOf(a2), Long.valueOf(longValue));
            }
        }
        if (daVar.f4686f != null) {
            List<Long> list = this.f4649g.get(Integer.valueOf(a2));
            if (list == null) {
                list = new ArrayList<>();
                this.f4649g.put(Integer.valueOf(a2), list);
            }
            if (daVar.b()) {
                list.clear();
            }
            if (c.c.a.b.f.e.p9.a() && this.f4650h.l().d(this.f4643a, r.h0) && daVar.c()) {
                list.clear();
            }
            if (!c.c.a.b.f.e.p9.a() || !this.f4650h.l().d(this.f4643a, r.h0)) {
                list.add(Long.valueOf(daVar.f4686f.longValue() / 1000));
                return;
            }
            long longValue2 = daVar.f4686f.longValue() / 1000;
            if (list.contains(Long.valueOf(longValue2))) {
                return;
            }
            list.add(Long.valueOf(longValue2));
        }
    }

    public ca(aa aaVar, String str, c.c.a.b.f.e.d1 d1Var, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f4650h = aaVar;
        this.f4643a = str;
        this.f4646d = bitSet;
        this.f4647e = bitSet2;
        this.f4648f = map;
        this.f4649g = new a.e.a();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f4649g.put(num, arrayList);
            }
        }
        this.f4644b = false;
        this.f4645c = d1Var;
    }

    public /* synthetic */ ca(aa aaVar, String str, c.c.a.b.f.e.d1 d1Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, z9 z9Var) {
        this(aaVar, str, d1Var, bitSet, bitSet2, map, map2);
    }

    public /* synthetic */ ca(aa aaVar, String str, z9 z9Var) {
        this(aaVar, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [c.c.a.b.f.e.s4$b, c.c.a.b.f.e.v0$a] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v3, types: [c.c.a.b.f.e.d1$a] */
    public final c.c.a.b.f.e.v0 a(int i2) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? t = c.c.a.b.f.e.v0.t();
        t.a(i2);
        t.a(this.f4644b);
        c.c.a.b.f.e.d1 d1Var = this.f4645c;
        if (d1Var != null) {
            t.a(d1Var);
        }
        ?? y = c.c.a.b.f.e.d1.y();
        y.b(p9.a(this.f4646d));
        y.a(p9.a(this.f4647e));
        if (this.f4648f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f4648f.size());
            Iterator<Integer> it = this.f4648f.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                w0.a q = c.c.a.b.f.e.w0.q();
                q.a(intValue);
                q.a(this.f4648f.get(Integer.valueOf(intValue)).longValue());
                arrayList.add((c.c.a.b.f.e.w0) ((c.c.a.b.f.e.s4) q.F()));
            }
        }
        y.c(arrayList);
        if (this.f4649g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f4649g.size());
            for (Integer num : this.f4649g.keySet()) {
                e1.a q2 = c.c.a.b.f.e.e1.q();
                q2.a(num.intValue());
                List<Long> list = this.f4649g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    q2.a(list);
                }
                arrayList2.add((c.c.a.b.f.e.e1) ((c.c.a.b.f.e.s4) q2.F()));
            }
        }
        y.d(arrayList2);
        t.a(y);
        return (c.c.a.b.f.e.v0) ((c.c.a.b.f.e.s4) t.F());
    }
}
