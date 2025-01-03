package c.c.a.a.j.w.j;

import android.app.job.JobInfo;
import c.c.a.a.j.w.j.d;
import cn.jiguang.internal.JConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class g {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public c.c.a.a.j.y.a f3674a;

        /* renamed from: b, reason: collision with root package name */
        public Map<c.c.a.a.d, b> f3675b = new HashMap();

        public a a(c.c.a.a.j.y.a aVar) {
            this.f3674a = aVar;
            return this;
        }

        public a a(c.c.a.a.d dVar, b bVar) {
            this.f3675b.put(dVar, bVar);
            return this;
        }

        public g a() {
            if (this.f3674a != null) {
                if (this.f3675b.keySet().size() >= c.c.a.a.d.values().length) {
                    Map<c.c.a.a.d, b> map = this.f3675b;
                    this.f3675b = new HashMap();
                    return g.a(this.f3674a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class b {

        /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
        public static abstract class a {
            public abstract a a(long j);

            public abstract a a(Set<c> set);

            public abstract b a();

            public abstract a b(long j);
        }

        public static a d() {
            d.b bVar = new d.b();
            bVar.a(Collections.emptySet());
            return bVar;
        }

        public abstract long a();

        public abstract Set<c> b();

        public abstract long c();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static g a(c.c.a.a.j.y.a aVar) {
        a c2 = c();
        c.c.a.a.d dVar = c.c.a.a.d.DEFAULT;
        b.a d2 = b.d();
        d2.a(30000L);
        d2.b(JConstants.DAY);
        c2.a(dVar, d2.a());
        c.c.a.a.d dVar2 = c.c.a.a.d.HIGHEST;
        b.a d3 = b.d();
        d3.a(1000L);
        d3.b(JConstants.DAY);
        c2.a(dVar2, d3.a());
        c.c.a.a.d dVar3 = c.c.a.a.d.VERY_LOW;
        b.a d4 = b.d();
        d4.a(JConstants.DAY);
        d4.b(JConstants.DAY);
        d4.a(a(c.NETWORK_UNMETERED, c.DEVICE_IDLE));
        c2.a(dVar3, d4.a());
        c2.a(aVar);
        return c2.a();
    }

    public static a c() {
        return new a();
    }

    public abstract c.c.a.a.j.y.a a();

    public abstract Map<c.c.a.a.d, b> b();

    public static g a(c.c.a.a.j.y.a aVar, Map<c.c.a.a.d, b> map) {
        return new c.c.a.a.j.w.j.c(aVar, map);
    }

    public long a(c.c.a.a.d dVar, long j, int i2) {
        long a2 = j - a().a();
        b bVar = b().get(dVar);
        return Math.min(Math.max(((long) Math.pow(2.0d, i2 - 1)) * bVar.a(), a2), bVar.c());
    }

    public JobInfo.Builder a(JobInfo.Builder builder, c.c.a.a.d dVar, long j, int i2) {
        builder.setMinimumLatency(a(dVar, j, i2));
        a(builder, b().get(dVar).b());
        return builder;
    }

    public final void a(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public static <T> Set<T> a(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }
}
