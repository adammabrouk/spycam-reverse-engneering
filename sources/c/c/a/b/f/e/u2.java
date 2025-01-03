package c.c.a.b.f.e;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u2<T> implements p2<T> {

    /* renamed from: a, reason: collision with root package name */
    public volatile p2<T> f4455a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f4456b;

    /* renamed from: c, reason: collision with root package name */
    @NullableDecl
    public T f4457c;

    public u2(p2<T> p2Var) {
        n2.a(p2Var);
        this.f4455a = p2Var;
    }

    public final String toString() {
        Object obj = this.f4455a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f4457c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
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
        if (!this.f4456b) {
            synchronized (this) {
                if (!this.f4456b) {
                    T zza = this.f4455a.zza();
                    this.f4457c = zza;
                    this.f4456b = true;
                    this.f4455a = null;
                    return zza;
                }
            }
        }
        return this.f4457c;
    }
}
