package c.c.a.b.f.e;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class o2<T> implements Serializable {
    public static <T> o2<T> zza(T t) {
        n2.a(t);
        return new q2(t);
    }

    public static <T> o2<T> zzc() {
        return m2.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
