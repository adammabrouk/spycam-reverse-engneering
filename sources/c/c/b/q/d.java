package c.c.b.q;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f6175b;

    /* renamed from: a, reason: collision with root package name */
    public final Set<f> f6176a = new HashSet();

    public static d b() {
        d dVar = f6175b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f6175b;
                if (dVar == null) {
                    dVar = new d();
                    f6175b = dVar;
                }
            }
        }
        return dVar;
    }

    public Set<f> a() {
        Set<f> unmodifiableSet;
        synchronized (this.f6176a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f6176a);
        }
        return unmodifiableSet;
    }
}
