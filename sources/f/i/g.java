package f.i;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes.dex */
public class g {
    public static final <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        f.j.b.f.b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        f.j.b.f.c(tArr, "$this$copyToArrayOfAny");
        if (z && f.j.b.f.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        f.j.b.f.b(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
