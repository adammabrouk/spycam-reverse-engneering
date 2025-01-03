package c.c.a.b.f.e;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class c7<K, V> implements Comparable<c7>, Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f4120a;

    /* renamed from: b, reason: collision with root package name */
    public V f4121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x6 f4122c;

    public c7(x6 x6Var, Map.Entry<K, V> entry) {
        this(x6Var, (Comparable) entry.getKey(), entry.getValue());
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c7 c7Var) {
        return ((Comparable) getKey()).compareTo((Comparable) c7Var.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f4120a, entry.getKey()) && a(this.f4121b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f4120a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f4121b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f4120a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f4121b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f4122c.f();
        V v2 = this.f4121b;
        this.f4121b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4120a);
        String valueOf2 = String.valueOf(this.f4121b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c7(x6 x6Var, K k, V v) {
        this.f4122c = x6Var;
        this.f4120a = k;
        this.f4121b = v;
    }
}
