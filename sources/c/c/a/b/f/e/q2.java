package c.c.a.b.f.e;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q2<T> extends o2<T> {
    public final T zza;

    public q2(T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof q2) {
            return this.zza.equals(((q2) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // c.c.a.b.f.e.o2
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.o2
    public final T zzb() {
        return this.zza;
    }
}
