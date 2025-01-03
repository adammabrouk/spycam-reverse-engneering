package c.k.d.p9;

import android.util.Pair;
import c.k.d.b7;
import c.k.d.c7;
import c.k.d.e7;
import c.k.d.h7;
import c.k.d.t7;
import c.k.d.u7;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class n {
    public static int a(m mVar, b7 b7Var) {
        return mVar.f7647a.getInt(a(b7Var), o.f7660a[b7Var.ordinal()] != 1 ? 0 : 1);
    }

    public static String a(b7 b7Var) {
        return "oc_version_" + b7Var.a();
    }

    public static List<Pair<Integer, Object>> a(List<h7> list, boolean z) {
        if (c.k.d.e.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (h7 h7Var : list) {
            int a2 = h7Var.a();
            c7 a3 = c7.a(h7Var.b());
            if (a3 != null) {
                if (z && h7Var.f34a) {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                } else {
                    int i2 = o.f7661b[a3.ordinal()];
                    arrayList.add(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(h7Var.g())) : new Pair(Integer.valueOf(a2), h7Var.m209a()) : new Pair(Integer.valueOf(a2), Long.valueOf(h7Var.m208a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(h7Var.c())));
                }
            }
        }
        return arrayList;
    }

    public static void a(m mVar, b7 b7Var, int i2) {
        mVar.f7647a.edit().putInt(a(b7Var), i2).commit();
    }

    public static void a(m mVar, t7 t7Var) {
        mVar.b(a(t7Var.a(), true));
        mVar.b();
    }

    public static void a(m mVar, u7 u7Var) {
        for (e7 e7Var : u7Var.a()) {
            if (e7Var.a() > a(mVar, e7Var.m142a())) {
                a(mVar, e7Var.m142a(), e7Var.a());
                mVar.a(a(e7Var.f24a, false));
            }
        }
        mVar.b();
    }
}
