package c.c.a.b.f.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class p5 extends n5 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f4356c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public p5() {
        super();
    }

    public static <E> List<E> b(Object obj, long j) {
        return (List) q7.f(obj, j);
    }

    @Override // c.c.a.b.f.e.n5
    public final void a(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) q7.f(obj, j);
        if (list instanceof k5) {
            unmodifiableList = ((k5) list).a();
        } else {
            if (f4356c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof q6) && (list instanceof z4)) {
                z4 z4Var = (z4) list;
                if (z4Var.zza()) {
                    z4Var.c();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        q7.a(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L> List<L> a(Object obj, long j, int i2) {
        l5 l5Var;
        List<L> arrayList;
        List<L> b2 = b(obj, j);
        if (b2.isEmpty()) {
            if (b2 instanceof k5) {
                arrayList = new l5(i2);
            } else if ((b2 instanceof q6) && (b2 instanceof z4)) {
                arrayList = ((z4) b2).zza(i2);
            } else {
                arrayList = new ArrayList<>(i2);
            }
            q7.a(obj, j, arrayList);
            return arrayList;
        }
        if (f4356c.isAssignableFrom(b2.getClass())) {
            ArrayList arrayList2 = new ArrayList(b2.size() + i2);
            arrayList2.addAll(b2);
            q7.a(obj, j, arrayList2);
            l5Var = arrayList2;
        } else if (b2 instanceof p7) {
            l5 l5Var2 = new l5(b2.size() + i2);
            l5Var2.addAll((p7) b2);
            q7.a(obj, j, l5Var2);
            l5Var = l5Var2;
        } else {
            if (!(b2 instanceof q6) || !(b2 instanceof z4)) {
                return b2;
            }
            z4 z4Var = (z4) b2;
            if (z4Var.zza()) {
                return b2;
            }
            z4 zza = z4Var.zza(b2.size() + i2);
            q7.a(obj, j, zza);
            return zza;
        }
        return l5Var;
    }

    @Override // c.c.a.b.f.e.n5
    public final <E> void a(Object obj, Object obj2, long j) {
        List b2 = b(obj2, j);
        List a2 = a(obj, j, b2.size());
        int size = a2.size();
        int size2 = b2.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(b2);
        }
        if (size > 0) {
            b2 = a2;
        }
        q7.a(obj, j, b2);
    }
}
