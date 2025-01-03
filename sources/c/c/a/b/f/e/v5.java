package c.c.a.b.f.e;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class v5<K, V> {
    public static <K, V> void a(b4 b4Var, u5<K, V> u5Var, K k, V v) throws IOException {
        l4.a(b4Var, u5Var.f4460a, 1, k);
        l4.a(b4Var, u5Var.f4462c, 2, v);
    }

    public static <K, V> int a(u5<K, V> u5Var, K k, V v) {
        return l4.a(u5Var.f4460a, 1, k) + l4.a(u5Var.f4462c, 2, v);
    }
}
