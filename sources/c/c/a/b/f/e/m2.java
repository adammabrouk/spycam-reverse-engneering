package c.c.a.b.f.e;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m2<T> extends o2<T> {
    public static final m2<Object> zza = new m2<>();

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // c.c.a.b.f.e.o2
    public final boolean zza() {
        return false;
    }

    @Override // c.c.a.b.f.e.o2
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
