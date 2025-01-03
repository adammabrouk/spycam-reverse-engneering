package c.k.d.p9;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.q9;
import c.k.d.v7;
import c.k.d.v9;
import c.k.d.y6;
import c.k.d.z6;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicLong f7642a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f7643b;

    /* renamed from: c, reason: collision with root package name */
    public static String f7644c;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f7643b = simpleDateFormat;
        f7644c = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (l0.class) {
            String format = f7643b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f7644c, format)) {
                f7642a.set(0L);
                f7644c = format;
            }
            str = format + "-" + f7642a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<v7> a(List<z6> list, String str, String str2, int i2) {
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else {
            if (list.size() != 0) {
                ArrayList<v7> arrayList = new ArrayList<>();
                y6 y6Var = new y6();
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    z6 z6Var = list.get(i4);
                    if (z6Var != null) {
                        int length = h8.a(z6Var).length;
                        if (length > i2) {
                            c.k.a.a.a.c.d("TinyData is too big, ignore upload request item:" + z6Var.d());
                        } else {
                            if (i3 + length > i2) {
                                v7 v7Var = new v7("-1", false);
                                v7Var.d(str);
                                v7Var.b(str2);
                                v7Var.c(g7.UploadTinyData.f30a);
                                v7Var.a(v9.a(h8.a(y6Var)));
                                arrayList.add(v7Var);
                                y6Var = new y6();
                                i3 = 0;
                            }
                            y6Var.a(z6Var);
                            i3 += length;
                        }
                    }
                }
                if (y6Var.a() != 0) {
                    v7 v7Var2 = new v7("-1", false);
                    v7Var2.d(str);
                    v7Var2.b(str2);
                    v7Var2.c(g7.UploadTinyData.f30a);
                    v7Var2.a(v9.a(h8.a(y6Var)));
                    arrayList.add(v7Var2);
                }
                return arrayList;
            }
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        }
        c.k.a.a.a.c.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        z6 z6Var = new z6();
        z6Var.d(str);
        z6Var.c(str2);
        z6Var.a(j);
        z6Var.b(str3);
        z6Var.a("push_sdk_channel");
        z6Var.g(context.getPackageName());
        z6Var.e(context.getPackageName());
        z6Var.a(true);
        z6Var.b(System.currentTimeMillis());
        z6Var.f(a());
        m0.a(context, z6Var);
    }

    public static boolean a(z6 z6Var, boolean z) {
        String str;
        if (z6Var == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(z6Var.f132a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(z6Var.f8082d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(z6Var.f8081c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!c.k.d.k0.m259a(z6Var.f8082d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (c.k.d.k0.m259a(z6Var.f8081c)) {
            String str2 = z6Var.f136b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + z6Var.f136b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        c.k.a.a.a.c.m6a(str);
        return true;
    }

    public static boolean a(String str) {
        return !q9.m437b() || "com.miui.hybrid".equals(str);
    }
}
