package c.c.a.b.f.e;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class z5 implements w5 {
    @Override // c.c.a.b.f.e.w5
    public final Map<?, ?> a(Object obj) {
        return (x5) obj;
    }

    @Override // c.c.a.b.f.e.w5
    public final Object b(Object obj) {
        ((x5) obj).zzc();
        return obj;
    }

    @Override // c.c.a.b.f.e.w5
    public final boolean c(Object obj) {
        return !((x5) obj).zzd();
    }

    @Override // c.c.a.b.f.e.w5
    public final Map<?, ?> d(Object obj) {
        return (x5) obj;
    }

    @Override // c.c.a.b.f.e.w5
    public final u5<?, ?> e(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // c.c.a.b.f.e.w5
    public final Object f(Object obj) {
        return x5.zza().zzb();
    }

    @Override // c.c.a.b.f.e.w5
    public final Object a(Object obj, Object obj2) {
        x5 x5Var = (x5) obj;
        x5 x5Var2 = (x5) obj2;
        if (!x5Var2.isEmpty()) {
            if (!x5Var.zzd()) {
                x5Var = x5Var.zzb();
            }
            x5Var.zza(x5Var2);
        }
        return x5Var;
    }

    @Override // c.c.a.b.f.e.w5
    public final int a(int i2, Object obj, Object obj2) {
        x5 x5Var = (x5) obj;
        if (x5Var.isEmpty()) {
            return 0;
        }
        Iterator it = x5Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
