package cn.jpush.android.ae;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.af.d;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f9095a;

    public static JSONArray a(Context context) {
        JSONObject a2;
        synchronized ("load_statistic_cache.json") {
            a2 = d.a(context, "load_statistic_cache.json");
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        JSONArray optJSONArray = a2.optJSONArray(JThirdPlatFormInterface.KEY_DATA);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        cn.jpush.android.r.b.b("JUnionAdLoadHelper", "no save data");
        return null;
    }

    public static JSONArray a(Context context, JSONArray jSONArray) {
        String str;
        String str2;
        Map hashMap;
        Map hashMap2;
        Integer valueOf;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    cn.jpush.android.r.b.b("JUnionAdLoadHelper", "report mergeData: " + jSONArray.toString());
                    HashMap hashMap3 = new HashMap();
                    HashMap hashMap4 = new HashMap();
                    HashMap hashMap5 = new HashMap();
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        str = "default";
                        str2 = "ad_position";
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        String optString = jSONObject.optString("ad_position");
                        if (!TextUtils.isEmpty(optString)) {
                            str = optString;
                        }
                        int optInt = jSONObject.optInt("call_type");
                        int optInt2 = jSONObject.optInt("call_status");
                        long optLong = jSONObject.optLong("call_time");
                        if (hashMap3.containsKey(str)) {
                            Long l = (Long) hashMap4.get(str);
                            Long l2 = (Long) hashMap5.get(str);
                            Long valueOf2 = Long.valueOf(l == null ? optLong : l.longValue());
                            Long valueOf3 = Long.valueOf(l2 == null ? optLong : l2.longValue());
                            if (optLong <= valueOf2.longValue()) {
                                hashMap4.put(str, Long.valueOf(optLong));
                            }
                            if (optLong >= valueOf3.longValue()) {
                                hashMap5.put(str, Long.valueOf(optLong));
                            }
                            hashMap = (Map) hashMap3.get(str);
                            if (hashMap.containsKey(Integer.valueOf(optInt))) {
                                hashMap2 = (Map) hashMap.get(Integer.valueOf(optInt));
                                if (hashMap2.containsKey(Integer.valueOf(optInt2))) {
                                    hashMap2.put(Integer.valueOf(optInt2), Integer.valueOf(((Integer) hashMap2.get(Integer.valueOf(optInt2))).intValue() + 1));
                                } else {
                                    hashMap2.put(Integer.valueOf(optInt2), 1);
                                }
                                valueOf = Integer.valueOf(optInt);
                            } else {
                                hashMap2 = new HashMap();
                                hashMap2.put(Integer.valueOf(optInt2), 1);
                                valueOf = Integer.valueOf(optInt);
                            }
                            hashMap.put(valueOf, hashMap2);
                        } else {
                            hashMap = new HashMap();
                            HashMap hashMap6 = new HashMap();
                            hashMap6.put(Integer.valueOf(optInt2), 1);
                            hashMap.put(Integer.valueOf(optInt), hashMap6);
                            hashMap4.put(str, Long.valueOf(optLong));
                            hashMap5.put(str, Long.valueOf(optLong));
                        }
                        hashMap3.put(str, hashMap);
                        i3++;
                    }
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = hashMap3.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        JSONObject jSONObject2 = new JSONObject();
                        String str3 = (String) entry.getKey();
                        String str4 = TextUtils.equals(str3, str) ? "" : str3;
                        long longValue = ((Long) hashMap4.get(str3)).longValue();
                        long longValue2 = ((Long) hashMap5.get(str3)).longValue();
                        jSONObject2.put(str2, str4);
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(longValue / 1000);
                        jSONArray3.put(longValue2 / 1000);
                        jSONObject2.put("duration", jSONArray3);
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator it2 = ((Map) entry.getValue()).entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it2.next();
                            Integer num = (Integer) entry2.getKey();
                            Map map = (Map) entry2.getValue();
                            int intValue = map.containsKey(Integer.valueOf(i2)) ? ((Integer) map.get(Integer.valueOf(i2))).intValue() : 0;
                            int intValue2 = map.containsKey(103) ? ((Integer) map.get(103)).intValue() : 0;
                            Iterator it3 = it;
                            int intValue3 = map.containsKey(104) ? ((Integer) map.get(104)).intValue() : 0;
                            HashMap hashMap7 = hashMap4;
                            int intValue4 = map.containsKey(105) ? ((Integer) map.get(105)).intValue() : 0;
                            HashMap hashMap8 = hashMap5;
                            int intValue5 = map.containsKey(106) ? ((Integer) map.get(106)).intValue() : 0;
                            Iterator it4 = it2;
                            int intValue6 = map.containsKey(101) ? ((Integer) map.get(101)).intValue() : 0;
                            String str5 = str;
                            int intValue7 = map.containsKey(102) ? ((Integer) map.get(102)).intValue() : 0;
                            String str6 = str2;
                            int intValue8 = map.containsKey(107) ? ((Integer) map.get(107)).intValue() : 0;
                            jSONArray4.put(num + "_" + (intValue + intValue2 + intValue3 + intValue4 + intValue5 + intValue6 + intValue7 + intValue8) + "_" + intValue + "_" + intValue2 + "_" + intValue3 + "_" + intValue4 + "_" + intValue5 + "_" + intValue6 + "_" + intValue7 + "_" + intValue8);
                            it = it3;
                            hashMap4 = hashMap7;
                            hashMap5 = hashMap8;
                            it2 = it4;
                            str = str5;
                            str2 = str6;
                            i2 = 0;
                        }
                        jSONObject2.put("statistics", jSONArray4);
                        cn.jpush.android.r.b.d("JUnionAdLoadHelper", "report statistic data: " + jSONObject2.toString());
                        jSONArray2.put(jSONObject2);
                        it = it;
                        hashMap4 = hashMap4;
                        hashMap5 = hashMap5;
                        str = str;
                        str2 = str2;
                        i2 = 0;
                    }
                    return jSONArray2.length() > 0 ? jSONArray2 : jSONArray;
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.g("JUnionAdLoadHelper", "merge load ad json failed:" + th.getMessage());
                return null;
            }
        }
        return jSONArray;
    }

    public static JSONObject a(a aVar) {
        if (aVar == null) {
            cn.jpush.android.r.b.b("JUnionAdLoadHelper", "loadResult is empty, no need report");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_position", aVar.f9093d);
            jSONObject.put("call_time", aVar.f9092c);
            jSONObject.put("call_type", aVar.f9090a);
            jSONObject.put("call_status", aVar.f9091b);
        } catch (Throwable th) {
            cn.jpush.android.r.b.h("JUnionAdLoadHelper", "formatReportData:" + th);
        }
        return jSONObject;
    }

    public static void a(Context context, int i2, int i3, String str) {
        a aVar = new a();
        aVar.f9090a = i2;
        aVar.f9091b = i3;
        aVar.f9092c = System.currentTimeMillis();
        aVar.f9093d = str;
        a(context, aVar);
        if (!c(context) || System.currentTimeMillis() - f9095a <= 20000) {
            return;
        }
        cn.jpush.android.r.b.b("JUnionAdLoadHelper", "onADLoadResult - time up to report");
        new b().a(context);
        f9095a = System.currentTimeMillis();
    }

    public static void a(Context context, Bundle bundle) {
        try {
            if (bundle == null) {
                cn.jpush.android.r.b.f("JUnionAdLoadHelper", "onADLoadResult-bundle is null");
            } else {
                a(context, bundle.getInt("call_type"), bundle.getInt("call_status"), bundle.getString("ad_position"));
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdLoadHelper", "onADLoadResult failed, " + th.getMessage());
        }
    }

    public static void a(Context context, a aVar) {
        JSONObject a2 = a(aVar);
        cn.jpush.android.r.b.b("JUnionAdLoadHelper", "load json:" + a2);
        a(context, a2);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            cn.jpush.android.r.b.b("JUnionAdLoadHelper", "save load ad data : " + jSONObject.toString());
            synchronized ("load_statistic_cache.json") {
                JSONObject a2 = d.a(context, "load_statistic_cache.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray(JThirdPlatFormInterface.KEY_DATA);
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put(JThirdPlatFormInterface.KEY_DATA, optJSONArray);
                d.a(context, "load_statistic_cache.json", a2);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdLoadHelper", "saveData failed:" + th.getMessage());
        }
    }

    public static void b(Context context) {
        synchronized ("load_statistic_cache.json") {
            d.a(context, "load_statistic_cache.json", (String) null);
        }
    }

    public static void b(Context context, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("call_type", i2);
        bundle.putInt("call_status", i3);
        bundle.putString("ad_position", str);
        cn.jpush.android.l.a.a(context, "load_api_result", bundle);
    }

    public static boolean c(Context context) {
        return cn.jpush.android.q.a.b(context, "JUnionAdLoad");
    }
}
