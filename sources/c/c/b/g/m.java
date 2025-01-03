package c.c.b.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class m {

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final d<?> f5859a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<b> f5860b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final Set<b> f5861c = new HashSet();

        public b(d<?> dVar) {
            this.f5859a = dVar;
        }

        public void a(b bVar) {
            this.f5860b.add(bVar);
        }

        public void b(b bVar) {
            this.f5861c.add(bVar);
        }

        public void c(b bVar) {
            this.f5861c.remove(bVar);
        }

        public boolean d() {
            return this.f5861c.isEmpty();
        }

        public d<?> a() {
            return this.f5859a;
        }

        public Set<b> b() {
            return this.f5860b;
        }

        public boolean c() {
            return this.f5860b.isEmpty();
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f5862a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5863b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f5862a.equals(this.f5862a) && cVar.f5863b == this.f5863b;
        }

        public int hashCode() {
            return ((this.f5862a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f5863b).hashCode();
        }

        public c(Class<?> cls, boolean z) {
            this.f5862a = cls;
            this.f5863b = z;
        }
    }

    public static void a(List<d<?>> list) {
        Set<b> b2 = b(list);
        Set<b> a2 = a(b2);
        int i2 = 0;
        while (!a2.isEmpty()) {
            b next = a2.iterator().next();
            a2.remove(next);
            i2++;
            for (b bVar : next.b()) {
                bVar.c(next);
                if (bVar.d()) {
                    a2.add(bVar);
                }
            }
        }
        if (i2 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : b2) {
            if (!bVar2.d() && !bVar2.c()) {
                arrayList.add(bVar2.a());
            }
        }
        throw new o(arrayList);
    }

    public static Set<b> b(List<d<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<d<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (n nVar : bVar.a().a()) {
                            if (nVar.b() && (set = (Set) hashMap.get(new c(nVar.a(), nVar.d()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            d<?> next = it.next();
            b bVar3 = new b(next);
            for (Class<? super Object> cls : next.c()) {
                c cVar = new c(cls, !next.g());
                if (!hashMap.containsKey(cVar)) {
                    hashMap.put(cVar, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar);
                if (!set2.isEmpty() && !cVar.f5863b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar3);
            }
        }
    }

    public static Set<b> a(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.d()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }
}
