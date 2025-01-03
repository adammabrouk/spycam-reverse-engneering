package c.c.a.b.g.b;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u3 extends v5 {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<String[]> f5113c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String[]> f5114d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReference<String[]> f5115e = new AtomicReference<>();

    public u3(a5 a5Var) {
        super(a5Var);
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !s() ? str : a(str, a6.f4582b, a6.f4581a, f5113c);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !s() ? str : a(str, z5.f5223b, z5.f5222a, f5114d);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!s()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return a(str, c6.f4632b, c6.f4631a, f5115e);
        }
        return "experiment_id(" + str + ")";
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        return false;
    }

    public final boolean s() {
        F();
        return this.f5160a.y() && this.f5160a.c().a(3);
    }

    public static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        c.c.a.b.c.o.r.a(strArr);
        c.c.a.b.c.o.r.a(strArr2);
        c.c.a.b.c.o.r.a(atomicReference);
        c.c.a.b.c.o.r.a(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (s9.c(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i2] == null) {
                        strArr3[i2] = strArr2[i2] + "(" + strArr[i2] + ")";
                    }
                    str2 = strArr3[i2];
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(zzaq zzaqVar) {
        String str = null;
        if (zzaqVar == null) {
            return null;
        }
        if (!s()) {
            return zzaqVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzaqVar.f10209c);
        sb.append(",name=");
        sb.append(a(zzaqVar.f10207a));
        sb.append(",params=");
        zzal zzalVar = zzaqVar.f10208b;
        if (zzalVar != null) {
            if (!s()) {
                str = zzalVar.toString();
            } else {
                str = a(zzalVar.zzb());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    public final String a(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!s()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(str));
            sb.append("=");
            if (c.c.a.b.f.e.d9.a() && l().a(r.F0)) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    valueOf = a(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    valueOf = a((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    valueOf = a(((ArrayList) obj).toArray());
                } else {
                    valueOf = String.valueOf(obj);
                }
                sb.append(valueOf);
            } else {
                sb.append(bundle.get(str));
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String a(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = a((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(valueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
