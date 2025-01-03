package f.i;

import java.util.Set;

/* compiled from: Sets.kt */
/* loaded from: classes.dex */
public class q extends p {
    public static final <T> Set<T> a() {
        return l.INSTANCE;
    }

    public static final <T> Set<T> a(T... tArr) {
        f.j.b.f.c(tArr, "elements");
        return tArr.length > 0 ? e.b(tArr) : a();
    }
}
