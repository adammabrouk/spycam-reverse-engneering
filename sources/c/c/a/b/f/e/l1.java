package c.c.a.b.f.e;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class l1 {

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, String> f4272f;
    public static Object k;
    public static boolean l;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f4267a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f4268b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f4269c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f4270d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f4271e = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, Boolean> f4273g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, Integer> f4274h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap<String, Long> f4275i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static String[] m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (l1.class) {
            if (f4272f == null) {
                f4271e.set(false);
                f4272f = new HashMap<>();
                k = new Object();
                l = false;
                contentResolver.registerContentObserver(f4267a, true, new k1(null));
            } else if (f4271e.getAndSet(false)) {
                f4272f.clear();
                f4273g.clear();
                f4274h.clear();
                f4275i.clear();
                j.clear();
                k = new Object();
                l = false;
            }
            Object obj = k;
            if (f4272f.containsKey(str)) {
                String str3 = f4272f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!l || f4272f.isEmpty()) {
                        f4272f.putAll(a(contentResolver, m));
                        l = true;
                        if (f4272f.containsKey(str)) {
                            String str5 = f4272f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(f4267a, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    a(obj, str, (String) null);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                a(obj, str, string);
                String str6 = string != null ? string : null;
                if (query != null) {
                    query.close();
                }
                return str6;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    public static void a(Object obj, String str, String str2) {
        synchronized (l1.class) {
            if (obj == k) {
                f4272f.put(str, str2);
            }
        }
    }

    public static Map<String, String> a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f4268b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
