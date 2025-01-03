package c.c.a.b.f.e;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public interface h8 {
    void a(int i2, double d2) throws IOException;

    void a(int i2, float f2) throws IOException;

    void a(int i2, int i3) throws IOException;

    void a(int i2, long j) throws IOException;

    void a(int i2, k3 k3Var) throws IOException;

    <K, V> void a(int i2, u5<K, V> u5Var, Map<K, V> map) throws IOException;

    void a(int i2, Object obj) throws IOException;

    void a(int i2, Object obj, t6 t6Var) throws IOException;

    void a(int i2, String str) throws IOException;

    void a(int i2, List<k3> list) throws IOException;

    void a(int i2, List<?> list, t6 t6Var) throws IOException;

    void a(int i2, List<Long> list, boolean z) throws IOException;

    void a(int i2, boolean z) throws IOException;

    void b(int i2, int i3) throws IOException;

    void b(int i2, long j) throws IOException;

    @Deprecated
    void b(int i2, Object obj, t6 t6Var) throws IOException;

    void b(int i2, List<String> list) throws IOException;

    @Deprecated
    void b(int i2, List<?> list, t6 t6Var) throws IOException;

    void b(int i2, List<Boolean> list, boolean z) throws IOException;

    void c(int i2, int i3) throws IOException;

    void c(int i2, long j) throws IOException;

    void c(int i2, List<Long> list, boolean z) throws IOException;

    void d(int i2, int i3) throws IOException;

    void d(int i2, long j) throws IOException;

    void d(int i2, List<Integer> list, boolean z) throws IOException;

    void e(int i2, int i3) throws IOException;

    void e(int i2, long j) throws IOException;

    void e(int i2, List<Long> list, boolean z) throws IOException;

    void f(int i2, int i3) throws IOException;

    void f(int i2, List<Integer> list, boolean z) throws IOException;

    void g(int i2, List<Integer> list, boolean z) throws IOException;

    void h(int i2, List<Long> list, boolean z) throws IOException;

    void i(int i2, List<Double> list, boolean z) throws IOException;

    void j(int i2, List<Long> list, boolean z) throws IOException;

    void k(int i2, List<Integer> list, boolean z) throws IOException;

    void l(int i2, List<Float> list, boolean z) throws IOException;

    void m(int i2, List<Integer> list, boolean z) throws IOException;

    void n(int i2, List<Integer> list, boolean z) throws IOException;

    int zza();

    @Deprecated
    void zza(int i2) throws IOException;

    @Deprecated
    void zzb(int i2) throws IOException;
}
