package c.c.a.b.f.e;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s2 {
    public static <T> p2<T> a(p2<T> p2Var) {
        return ((p2Var instanceof u2) || (p2Var instanceof r2)) ? p2Var : p2Var instanceof Serializable ? new r2(p2Var) : new u2(p2Var);
    }

    public static <T> p2<T> a(@NullableDecl T t) {
        return new t2(t);
    }
}
