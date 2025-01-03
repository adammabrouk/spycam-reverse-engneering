package c.c.b.f.a.c;

import android.os.Bundle;
import c.c.a.b.g.b.c6;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f5825a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f5826b;

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f5827c;

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f5828d;

    /* renamed from: e, reason: collision with root package name */
    public static final List<String> f5829e;

    static {
        new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
        f5825a = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
        f5826b = Arrays.asList("auto", "app", "am");
        f5827c = Arrays.asList("_r", "_dbg");
        f5828d = Arrays.asList((String[]) c.c.a.b.c.s.b.a(c6.f4631a, c6.f4632b));
        f5829e = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(String str) {
        return !f5826b.contains(str);
    }

    public static void b(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean a(String str, Bundle bundle) {
        if (f5825a.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator<String> it = f5827c.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f5828d.contains(str2)) {
            return false;
        }
        Iterator<String> it = f5829e.iterator();
        while (it.hasNext()) {
            if (str2.matches(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        Iterator<String> it = f5827c.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c2 = 2;
                }
            } else if (str.equals("fdl")) {
                c2 = 1;
            }
        } else if (str.equals("fcm")) {
            c2 = 0;
        }
        if (c2 == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        if (c2 == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        if (c2 != 2) {
            return false;
        }
        bundle.putString("_cis", "fiam_integration");
        return true;
    }
}
