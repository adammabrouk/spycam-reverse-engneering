package c.c.a.b.f.e;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r2<T> implements p2<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public volatile transient boolean f4392a;

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public transient T f4393b;
    public final p2<T> zza;

    public r2(p2<T> p2Var) {
        n2.a(p2Var);
        this.zza = p2Var;
    }

    public final String toString() {
        Object obj;
        if (this.f4392a) {
            String valueOf = String.valueOf(this.f4393b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.zza;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // c.c.a.b.f.e.p2
    public final T zza() {
        if (!this.f4392a) {
            synchronized (this) {
                if (!this.f4392a) {
                    T zza = this.zza.zza();
                    this.f4393b = zza;
                    this.f4392a = true;
                    return zza;
                }
            }
        }
        return this.f4393b;
    }
}
