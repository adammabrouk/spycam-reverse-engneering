package c.c.b.g;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public abstract class a implements e {
    @Override // c.c.b.g.e
    public <T> T a(Class<T> cls) {
        c.c.b.m.a<T> c2 = c(cls);
        if (c2 == null) {
            return null;
        }
        return c2.get();
    }

    @Override // c.c.b.g.e
    public <T> Set<T> b(Class<T> cls) {
        return d(cls).get();
    }
}
