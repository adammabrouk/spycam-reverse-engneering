package f.i;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public class h extends g {
    public static final <T> List<T> a() {
        return j.INSTANCE;
    }

    public static final <T> List<T> b(T... tArr) {
        f.j.b.f.c(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new a(tArr, true));
    }

    public static final <T> List<T> a(T... tArr) {
        f.j.b.f.c(tArr, "elements");
        return tArr.length > 0 ? d.a(tArr) : a();
    }
}
