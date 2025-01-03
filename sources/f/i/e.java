package f.i;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: _Arrays.kt */
/* loaded from: classes.dex */
public class e extends d {
    public static final <T> boolean a(T[] tArr, T t) {
        f.j.b.f.c(tArr, "$this$contains");
        return b(tArr, t) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        f.j.b.f.c(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (f.j.b.f.a(t, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c2) {
        f.j.b.f.c(tArr, "$this$toCollection");
        f.j.b.f.c(c2, "destination");
        for (T t : tArr) {
            c2.add(t);
        }
        return c2;
    }

    public static final <T> Set<T> b(T[] tArr) {
        f.j.b.f.c(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return q.a();
        }
        if (length != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(n.a(tArr.length));
            a((Object[]) tArr, linkedHashSet);
            return linkedHashSet;
        }
        return p.a(tArr[0]);
    }
}
