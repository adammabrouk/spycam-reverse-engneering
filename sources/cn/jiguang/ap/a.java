package cn.jiguang.ap;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f8284a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f8285b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f8286c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static a f8287d;

    /* renamed from: e, reason: collision with root package name */
    public Set<String> f8288e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public Map<String, cn.jiguang.aq.a> f8289f = new HashMap();

    public static a a(Context context) {
        if (f8287d == null) {
            synchronized (a.class) {
                if (f8287d == null) {
                    f8287d = new a();
                    cn.jiguang.ar.e.c(context);
                    String c2 = c(context);
                    if (c2 != null) {
                        try {
                            f8287d.a(a(new JSONArray(c2)));
                        } catch (Throwable th) {
                            cn.jiguang.ar.f.b("JOperateConfig", "reservedEventsJson:", th);
                            cn.jiguang.ar.e.b(context, 0L);
                        }
                    }
                    String b2 = b(context);
                    if (b2 != null) {
                        try {
                            f8287d.a(b(new JSONArray(b2)));
                        } catch (Throwable th2) {
                            cn.jiguang.ar.f.b("JOperateConfig", "userPropertiesJson:", th2);
                            cn.jiguang.ar.e.a(context, 0L);
                        }
                    }
                }
            }
        }
        return f8287d;
    }

    public static cn.jiguang.aq.a a(JSONObject jSONObject) {
        return new cn.jiguang.aq.a(jSONObject);
    }

    public static Set<String> a(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.optString(i2));
        }
        return hashSet;
    }

    public static String b(Context context) {
        String d2 = cn.jiguang.ar.d.d(context);
        if (d2 == null && (d2 = cn.jiguang.ar.e.e(context)) != null) {
            cn.jiguang.ar.d.f(context, d2);
            cn.jiguang.ar.e.c(context, null);
        }
        return d2;
    }

    public static Map<String, cn.jiguang.aq.a> b(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            cn.jiguang.aq.a a2 = a(jSONArray.optJSONObject(i2));
            hashMap.put(a2.a(), a2);
        }
        return hashMap;
    }

    public static String c(Context context) {
        String c2 = cn.jiguang.ar.d.c(context);
        if (c2 == null && (c2 = cn.jiguang.ar.e.d(context)) != null) {
            cn.jiguang.ar.d.e(context, c2);
            cn.jiguang.ar.e.b(context, (String) null);
        }
        return c2;
    }

    public synchronized Set<Map.Entry<String, cn.jiguang.aq.a>> a() {
        return this.f8289f.entrySet();
    }

    public synchronized void a(Map<String, cn.jiguang.aq.a> map) {
        this.f8289f.clear();
        this.f8289f.putAll(map);
    }

    public synchronized void a(Set<String> set) {
        this.f8288e.clear();
        this.f8288e.addAll(set);
    }

    public synchronized boolean a(String str) {
        return this.f8288e.contains(str);
    }

    public synchronized JSONArray b() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        Iterator<Map.Entry<String, cn.jiguang.aq.a>> it = this.f8289f.entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getValue().d());
        }
        return jSONArray;
    }
}
