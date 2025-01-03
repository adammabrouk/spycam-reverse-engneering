package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<d> f8419a = new Comparator<d>() { // from class: cn.jiguang.ax.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar.equals(dVar2)) {
                return 0;
            }
            int i2 = dVar.f8415b;
            int i3 = dVar2.f8415b;
            if (i2 > i3) {
                return -1;
            }
            if (i2 < i3) {
                return 1;
            }
            int i4 = dVar.f8418e;
            int i5 = dVar2.f8418e;
            if (i4 > i5) {
                return -1;
            }
            if (i4 < i5) {
                return 1;
            }
            long j = dVar.f8417d;
            if (j != 0) {
                long j2 = dVar2.f8417d;
                if (j2 != 0) {
                    if (j < j2) {
                        return -1;
                    }
                    if (j > j2) {
                        return 1;
                    }
                }
            }
            long j3 = dVar.f8416c;
            if (j3 != 0) {
                long j4 = dVar2.f8416c;
                if (j4 != 0) {
                    if (j3 > j4 + 180000) {
                        return -1;
                    }
                    if (j3 < j4 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public static LinkedHashSet<g> a(Context context, LinkedHashSet<g> linkedHashSet, long j) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        Iterator<g> it = linkedHashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            g next = it.next();
            if (next.a()) {
                cn.jiguang.f.a<String> f2 = cn.jiguang.f.a.f(next.toString());
                cn.jiguang.f.a<String> g2 = cn.jiguang.f.a.g(next.toString());
                String str = (String) cn.jiguang.f.b.a(context, g2);
                if (TextUtils.isEmpty(str)) {
                    str = (String) cn.jiguang.f.b.a(context, f2);
                }
                d a2 = d.a(str);
                if (a2 == null) {
                    a2 = new d(next);
                }
                if (z) {
                    a2.f8418e = 1;
                    z = false;
                }
                if (j > 0) {
                    a2.f8416c = j;
                    cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{g2.a((cn.jiguang.f.a<String>) a2.a())});
                }
                linkedList.add(a2);
            }
        }
        LinkedList a3 = a(linkedList, f8419a);
        LinkedHashSet<g> linkedHashSet2 = new LinkedHashSet<>();
        Iterator it2 = a3.iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((LinkedList) it2.next()).iterator();
            while (it3.hasNext()) {
                linkedHashSet2.add(((d) it3.next()).f8414a);
            }
        }
        return linkedHashSet2;
    }

    public static <T> LinkedList<LinkedList<T>> a(Collection<T> collection, Comparator<T> comparator) {
        boolean z;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t : collection) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinkedList<T> linkedList2 = linkedList.get(i2);
                int compare = comparator.compare(t, linkedList2.getFirst());
                if (compare == 0) {
                    linkedList2.add(secureRandom.nextInt(linkedList2.size() + 1), t);
                } else if (compare < 0) {
                    LinkedList<T> linkedList3 = new LinkedList<>();
                    linkedList3.add(t);
                    linkedList.add(i2, linkedList3);
                }
                z = true;
            }
            z = false;
            if (!z) {
                LinkedList<T> linkedList4 = new LinkedList<>();
                linkedList4.add(t);
                linkedList.add(linkedList4);
            }
        }
        return linkedList;
    }

    public static void a(Context context, g gVar, int i2, long j) {
        if (gVar != null) {
            cn.jiguang.f.a<String> f2 = cn.jiguang.f.a.f(gVar.toString());
            cn.jiguang.f.a<String> g2 = cn.jiguang.f.a.g(gVar.toString());
            String str = (String) cn.jiguang.f.b.a(context, g2);
            if (TextUtils.isEmpty(str)) {
                str = (String) cn.jiguang.f.b.a(context, f2);
            }
            d a2 = d.a(str);
            if (a2 == null) {
                a2 = new d(gVar);
            }
            a2.f8417d = j;
            a2.f8415b = i2;
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{g2.a((cn.jiguang.f.a<String>) a2.a())});
        }
    }
}
