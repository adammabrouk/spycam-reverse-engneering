package c.c.a.b.f.e;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class f2 extends a2<Boolean> {
    public f2(g2 g2Var, String str, Boolean bool, boolean z) {
        super(g2Var, str, bool, z, null);
    }

    @Override // c.c.a.b.f.e.a2
    public final /* synthetic */ Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (l1.f4269c.matcher(str).matches()) {
                return true;
            }
            if (l1.f4270d.matcher(str).matches()) {
                return false;
            }
        }
        String a2 = super.a();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(a2);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
