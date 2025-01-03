package c.c.a.b.g.b;

import c.c.a.b.f.e.l0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public abstract class da {

    /* renamed from: a, reason: collision with root package name */
    public String f4681a;

    /* renamed from: b, reason: collision with root package name */
    public int f4682b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f4683c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f4684d;

    /* renamed from: e, reason: collision with root package name */
    public Long f4685e;

    /* renamed from: f, reason: collision with root package name */
    public Long f4686f;

    public da(String str, int i2) {
        this.f4681a = str;
        this.f4682b = i2;
    }

    public static Boolean a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();

    public static Boolean a(String str, c.c.a.b.f.e.l0 l0Var, w3 w3Var) {
        List<String> list;
        c.c.a.b.c.o.r.a(l0Var);
        if (str == null || !l0Var.zza() || l0Var.n() == l0.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (l0Var.n() == l0.b.IN_LIST) {
            if (l0Var.t() == 0) {
                return null;
            }
        } else if (!l0Var.o()) {
            return null;
        }
        l0.b n = l0Var.n();
        boolean r = l0Var.r();
        String p = (r || n == l0.b.REGEXP || n == l0.b.IN_LIST) ? l0Var.p() : l0Var.p().toUpperCase(Locale.ENGLISH);
        if (l0Var.t() == 0) {
            list = null;
        } else {
            List<String> s = l0Var.s();
            if (!r) {
                ArrayList arrayList = new ArrayList(s.size());
                Iterator<String> it = s.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                s = Collections.unmodifiableList(arrayList);
            }
            list = s;
        }
        return a(str, n, r, p, list, n == l0.b.REGEXP ? p : null, w3Var);
    }

    public static Boolean a(String str, l0.b bVar, boolean z, String str2, List<String> list, String str3, w3 w3Var) {
        if (str == null) {
            return null;
        }
        if (bVar == l0.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && bVar != l0.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (z9.f5231a[bVar.ordinal()]) {
            case 1:
                try {
                    break;
                } catch (PatternSyntaxException unused) {
                    if (w3Var != null) {
                        w3Var.w().a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
        }
        return null;
    }

    public static Boolean a(long j, c.c.a.b.f.e.j0 j0Var) {
        try {
            return a(new BigDecimal(j), j0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean a(double d2, c.c.a.b.f.e.j0 j0Var) {
        try {
            return a(new BigDecimal(d2), j0Var, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean a(String str, c.c.a.b.f.e.j0 j0Var) {
        if (!p9.a(str)) {
            return null;
        }
        try {
            return a(new BigDecimal(str), j0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0085, code lost:
    
        if (r2 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean a(java.math.BigDecimal r9, c.c.a.b.f.e.j0 r10, double r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.da.a(java.math.BigDecimal, c.c.a.b.f.e.j0, double):java.lang.Boolean");
    }
}
