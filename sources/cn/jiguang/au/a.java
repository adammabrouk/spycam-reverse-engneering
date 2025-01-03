package cn.jiguang.au;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f8355c;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8356d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public long f8357a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Set<String>> f8358b = new HashMap();

    public static a a() {
        if (f8355c == null) {
            synchronized (f8356d) {
                if (f8355c == null) {
                    f8355c = new a();
                }
            }
        }
        return f8355c;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        linkedHashSet.add(optJSONArray.getString(i2));
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.f8358b = hashMap;
        } catch (JSONException unused) {
        }
    }

    public a a(Context context) {
        try {
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.w())).longValue();
            if (this.f8357a == 0 || this.f8357a != longValue) {
                this.f8357a = longValue;
                String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.u());
                if (!TextUtils.isEmpty(str)) {
                    a(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        switch (str) {
            case "android_awake2":
            case "android_awake":
            case "android_awake_target2":
            case "android_awake_target":
            case "awake":
            case "aa3":
            case "aat3":
                return "awake";
            case "active_launch":
            case "active_terminate":
            case "active_user":
                return "active_user";
            case "identify_account":
            case "detach_account":
            case "account":
                return "account";
            case "android_notification_state":
                return "android_notification_state";
            case "normal":
                break;
            default:
                if (this.f8358b.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    public String a(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    String str = null;
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        String a2 = a(it.next());
                        if (str == null) {
                            str = a2;
                        } else if (!str.equals(a2)) {
                            cn.jiguang.as.d.g("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return "normal";
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return "normal";
    }

    public void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        long j = JConstants.HOUR;
        try {
            long j2 = jSONObject.getLong("ttl");
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.f.a[] aVarArr = new cn.jiguang.f.a[4];
        aVarArr[0] = cn.jiguang.f.a.v().a((cn.jiguang.f.a<String>) optJSONArray.toString());
        aVarArr[1] = cn.jiguang.f.a.x().a((cn.jiguang.f.a<Long>) Long.valueOf(j * 1000));
        aVarArr[2] = cn.jiguang.f.a.w().a((cn.jiguang.f.a<Long>) Long.valueOf(System.currentTimeMillis()));
        aVarArr[3] = cn.jiguang.f.a.u().a((cn.jiguang.f.a<String>) (optJSONObject != null ? optJSONObject.toString() : ""));
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) aVarArr);
        a(optJSONObject);
    }

    public a b(Context context) {
        boolean z;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(context);
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.x())).longValue();
            if (longValue < 0) {
                longValue = JConstants.HOUR;
            } else if (longValue < JConstants.MIN) {
                longValue = 60000;
            }
            if (longValue > 604800000) {
                longValue = 604800000;
            }
            SimpleDateFormat a2 = cn.jiguang.e.b.a("yyyy-MM-dd HH:mm:ss");
            cn.jiguang.as.d.c("AddressGroupManager", "lastUpdateTime=" + a2.format(new Date(this.f8357a)) + " now=" + a2.format(new Date(currentTimeMillis)) + " expire=" + (longValue / 1000));
            if (this.f8357a == 0 || this.f8357a + longValue < currentTimeMillis) {
                cn.jiguang.as.d.c("AddressGroupManager", "cache invalid, fetch new urls");
                if (this.f8358b != null && !this.f8358b.isEmpty()) {
                    z = false;
                    e.a(context, z);
                }
                z = true;
                e.a(context, z);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("AddressGroupManager", "refresh e" + th);
        }
        return this;
    }

    public Set<String> b(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            Set<String> set2 = null;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                Set<String> set3 = this.f8358b.get(a(it.next()));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f8358b.get("normal");
    }
}
