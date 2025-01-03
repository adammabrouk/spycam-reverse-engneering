package f.j.b;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes.dex */
public final class b {
    public static final <T> Iterator<T> a(T[] tArr) {
        f.c(tArr, "array");
        return new a(tArr);
    }
}
