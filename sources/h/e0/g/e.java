package h.e0.g;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.l;
import h.m;
import h.r;
import h.s;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(a0 a0Var) {
        return a(a0Var.g());
    }

    public static boolean b(a0 a0Var) {
        if (a0Var.r().e().equals("HEAD")) {
            return false;
        }
        int c2 = a0Var.c();
        return (((c2 >= 100 && c2 < 200) || c2 == 204 || c2 == 304) && a(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) ? false : true;
    }

    public static long a(r rVar) {
        return a(rVar.a(HttpHeaders.CONTENT_LENGTH));
    }

    public static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.f11723a) {
            return;
        }
        List<l> a2 = l.a(sVar, rVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(sVar, a2);
    }

    public static int b(String str, int i2) {
        char charAt;
        while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
