package cn.jiguang.be;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.e.f;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static List<String> f8693a;

    static {
        ArrayList arrayList = new ArrayList();
        f8693a = arrayList;
        arrayList.add("358673013795895");
        f8693a.add("004999010640000");
        f8693a.add("00000000000000");
        f8693a.add("000000000000000");
    }

    public static String a() {
        String b2 = cn.jiguang.e.a.b();
        if (b2 == null) {
            return null;
        }
        return b2 + ".push_udid";
    }

    public static String a(Context context) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.F());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (a(str)) {
            return str;
        }
        String b2 = b(context);
        if (!TextUtils.isEmpty(b2)) {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.F().a((cn.jiguang.f.a<String>) Base64.encodeToString(b2.getBytes(), 2))});
        }
        return b2;
    }

    public static boolean a(String str) {
        if (!f.h(str) || str.length() < 10) {
            return false;
        }
        Iterator<String> it = f8693a.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static String b(Context context) {
        try {
            String str = a.a(context).p;
            if (a(str)) {
                return str;
            }
            String str2 = a.a(context).f8687i;
            if (a(str2) && !"9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                return str2;
            }
            String c2 = c(context);
            return a(c2) ? c2 : "";
        } catch (Exception e2) {
            cn.jiguang.as.d.d("UDIDUtils", "", e2);
            String d2 = d(context);
            return a(d2) ? d2 : "";
        }
    }

    public static String c(Context context) {
        String j = cn.jiguang.d.a.l(context) ? cn.jiguang.e.a.j(context) : "";
        if (a(j)) {
            return j;
        }
        String d2 = d(context);
        return d2 == null ? LogUtils.PLACEHOLDER : d2;
    }

    public static String d(Context context) {
        cn.jiguang.as.d.c("UDIDUtils", "Action:getSavedUuid");
        String str = (String) cn.jiguang.f.b.b(context, cn.jiguang.f.a.U());
        if (!f.a(str)) {
            return str;
        }
        if (!cn.jiguang.e.a.a()) {
            return f(context);
        }
        String str2 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.G());
        return TextUtils.isEmpty(str2) ? Build.VERSION.SDK_INT < 23 ? e(context) : f(context) : str2;
    }

    public static String e(Context context) {
        String a2 = a();
        File file = !f.a(a2) ? new File(a2) : null;
        String d2 = cn.jiguang.e.c.d(file);
        if (!TextUtils.isEmpty(d2)) {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.G().a((cn.jiguang.f.a<String>) d2)});
            cn.jiguang.as.d.e("UDIDUtils", "Got sdcard file saved udid - " + d2);
            return d2;
        }
        String j = f.j(UUID.nameUUIDFromBytes((System.currentTimeMillis() + "").getBytes()).toString());
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.G().a((cn.jiguang.f.a<String>) j)});
        cn.jiguang.e.c.c(file, j);
        return j;
    }

    public static String f(Context context) {
        cn.jiguang.f.a<String> U = cn.jiguang.f.a.U();
        String str = (String) cn.jiguang.f.b.b(context, U);
        if (str != null) {
            return str;
        }
        String uuid = UUID.randomUUID().toString();
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{U.a((cn.jiguang.f.a<String>) uuid)});
        return uuid;
    }
}
