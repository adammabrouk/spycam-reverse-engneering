package f.i;

import java.util.Collections;
import java.util.Set;

/* compiled from: SetsJVM.kt */
/* loaded from: classes.dex */
public class p {
    public static final <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        f.j.b.f.b(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
