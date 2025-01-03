package c.c.a.b.f.e;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class m3 implements Comparator<k3> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(k3 k3Var, k3 k3Var2) {
        int a2;
        int a3;
        k3 k3Var3 = k3Var;
        k3 k3Var4 = k3Var2;
        t3 t3Var = (t3) k3Var3.iterator();
        t3 t3Var2 = (t3) k3Var4.iterator();
        while (t3Var.hasNext() && t3Var2.hasNext()) {
            a2 = k3.a(t3Var.zza());
            a3 = k3.a(t3Var2.zza());
            int compare = Integer.compare(a2, a3);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(k3Var3.zza(), k3Var4.zza());
    }
}
