package c.k.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class g6 {

    /* renamed from: a, reason: collision with root package name */
    public static m f7160a = new m(true);

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f7161b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static long f7162c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f7163d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static List<a> f7164e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f, reason: collision with root package name */
    public static String f7165f = "";

    /* renamed from: g, reason: collision with root package name */
    public static c.k.d.l9.a f7166g = null;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f7167a;

        /* renamed from: b, reason: collision with root package name */
        public long f7168b;

        /* renamed from: c, reason: collision with root package name */
        public int f7169c;

        /* renamed from: d, reason: collision with root package name */
        public int f7170d;

        /* renamed from: e, reason: collision with root package name */
        public String f7171e;

        /* renamed from: f, reason: collision with root package name */
        public long f7172f;

        public a(String str, long j, int i2, int i3, String str2, long j2) {
            this.f7167a = "";
            this.f7168b = 0L;
            this.f7169c = -1;
            this.f7170d = -1;
            this.f7171e = "";
            this.f7172f = 0L;
            this.f7167a = str;
            this.f7168b = j;
            this.f7169c = i2;
            this.f7170d = i3;
            this.f7171e = str2;
            this.f7172f = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f7167a, this.f7167a) && TextUtils.equals(aVar.f7171e, this.f7171e) && aVar.f7169c == this.f7169c && aVar.f7170d == this.f7170d && Math.abs(aVar.f7168b - this.f7168b) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f7161b == -1) {
            f7161b = b(context);
        }
        return f7161b;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    public static long a(int i2, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f7162c;
            f7162c = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i2 == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static c.k.d.l9.a m175a(Context context) {
        c.k.d.l9.a aVar = f7166g;
        if (aVar != null) {
            return aVar;
        }
        c.k.d.l9.a aVar2 = new c.k.d.l9.a(context);
        f7166g = aVar2;
        return aVar2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m176a(Context context) {
        synchronized (g6.class) {
            if (TextUtils.isEmpty(f7165f)) {
                return "";
            }
            return f7165f;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m178a(Context context) {
        f7161b = b(context);
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f7163d) {
            isEmpty = f7164e.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m176a(context) : "", j));
        }
        if (isEmpty) {
            f7160a.a(new h6(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    public static void a(a aVar) {
        for (a aVar2 : f7164e) {
            if (aVar2.a(aVar)) {
                aVar2.f7172f += aVar.f7172f;
                return;
            }
        }
        f7164e.add(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized void m179a(String str) {
        synchronized (g6.class) {
            if (!g9.d() && !TextUtils.isEmpty(str)) {
                f7165f = str;
            }
        }
    }

    public static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void b(Context context, List<a> list) {
        try {
            synchronized (c.k.d.l9.a.f7362b) {
                SQLiteDatabase writableDatabase = m175a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f7167a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f7168b));
                        contentValues.put("network_type", Integer.valueOf(aVar.f7169c));
                        contentValues.put("bytes", Long.valueOf(aVar.f7172f));
                        contentValues.put("rcv", Integer.valueOf(aVar.f7170d));
                        contentValues.put("imsi", aVar.f7171e);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e2) {
            c.k.a.a.a.c.a(e2);
        }
    }
}
