package cn.jiguang.an;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.service.DownloadProvider;
import com.shix.shixipc.system.ContentCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }

    public static cn.jiguang.am.c a(Context context, String str) {
        try {
            return new cn.jiguang.am.c(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeHelper", "getWakeTarget throwable:" + th.getMessage());
            return null;
        }
    }

    public static String a(List<cn.jiguang.am.c> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).f8205a;
            String str2 = list.get(i2).f8206b;
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    public static HashMap<String, cn.jiguang.am.c> a(Context context) {
        cn.jiguang.am.c a2;
        try {
            HashMap<String, cn.jiguang.am.c> hashMap = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i2 = 0; i2 < queryIntentServices.size(); i2++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i2).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a2 = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.ai.a.a("JWakeHelper", "wakeTarget:" + a2.toString());
                        hashMap.put(a2.f8205a, a2);
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeHelper", "getWakeTargetMap throwable:" + th.getMessage());
            return null;
        }
    }

    public static HashMap<String, cn.jiguang.am.c> a(Context context, HashMap<String, cn.jiguang.am.c> hashMap) {
        try {
            HashMap<String, cn.jiguang.am.c> hashMap2 = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.PushService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i2 = 0; i2 < queryIntentServices.size(); i2++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i2).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((hashMap == null || !hashMap.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                        int checkPermission = packageManager.checkPermission(str2 + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str2);
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, RecyclerView.c0.FLAG_IGNORE);
                        if (applicationInfo != null && applicationInfo.metaData != null) {
                            String b2 = cn.jiguang.l.d.b(context);
                            if (checkPermission == 0 && !TextUtils.isEmpty(b2) && b2.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                cn.jiguang.am.c cVar = new cn.jiguang.am.c(str2, "", applicationInfo.targetSdkVersion);
                                ComponentInfo a2 = cn.jiguang.l.d.a(context, str2, (Class<?>) DownloadProvider.class);
                                if (a2 instanceof ProviderInfo) {
                                    ProviderInfo providerInfo = (ProviderInfo) a2;
                                    if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                        if (TextUtils.equals(str2 + ".DownloadProvider", providerInfo.authority)) {
                                            cVar.f8208d = providerInfo.authority;
                                        }
                                    }
                                }
                                hashMap2.put(cVar.f8205a, cVar);
                            }
                        }
                    }
                }
                cn.jiguang.ai.a.a("JWakeHelper", "getWakeAppListWithoutDService:" + hashMap2.toString());
                return hashMap2;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeHelper", "getWakeAppListWithoutDService throwable:" + th.getMessage());
            return null;
        }
    }

    public static List<cn.jiguang.am.c> a(Context context, List<cn.jiguang.am.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(list.get(i2).f8205a, RecyclerView.c0.FLAG_IGNORE);
                list.get(i2).f8207c = applicationInfo.targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.am.a aVar, List<String> list) {
        return aVar == null ? list : c(aVar, b(aVar, list));
    }

    public static List<cn.jiguang.am.c> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String[] split2 = str2.split("\\|");
            String str3 = split2[0];
            String str4 = split2[1];
            cn.jiguang.am.c cVar = new cn.jiguang.am.c();
            cVar.f8205a = str3;
            cVar.f8206b = str4;
            cVar.f8213i = 1;
            cVar.f8211g = 4;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public static List<String> a(List<String> list, List<String> list2) {
        return a(list, list2, false);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static java.util.List<java.lang.String> a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    public static JSONArray a(Context context, JSONArray jSONArray) {
        int i2;
        Integer valueOf;
        int i3;
        if (jSONArray == null) {
            return jSONArray;
        }
        try {
            if (jSONArray.length() <= 0) {
                return jSONArray;
            }
            HashMap hashMap = new HashMap();
            int i4 = 0;
            while (true) {
                i2 = 1;
                if (i4 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                String optString = jSONObject.optString(ContentCommon.TYPE);
                if ("aa3".equals(optString)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("target");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        break;
                    }
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        String optString2 = optJSONObject.optString("package");
                        JSONArray jSONArray2 = optJSONObject.getJSONArray(JThirdPlatFormInterface.KEY_DATA);
                        if (jSONArray2 != null) {
                            for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i6);
                                if (jSONObject2 != null) {
                                    int i7 = jSONObject2.getInt("wake_type");
                                    int i8 = jSONObject2.getInt("wake_status");
                                    if (hashMap.containsKey(optString2)) {
                                        Map map = (Map) hashMap.get(optString2);
                                        if (map.containsKey(Integer.valueOf(i7))) {
                                            Map map2 = (Map) map.get(Integer.valueOf(i7));
                                            if (map2.containsKey(Integer.valueOf(i8))) {
                                                valueOf = Integer.valueOf(i8);
                                                i3 = Integer.valueOf(((Integer) map2.get(Integer.valueOf(i8))).intValue() + 1);
                                            } else {
                                                valueOf = Integer.valueOf(i8);
                                                i3 = 1;
                                            }
                                            map2.put(valueOf, i3);
                                            map.put(Integer.valueOf(i7), map2);
                                        } else {
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put(Integer.valueOf(i8), 1);
                                            map.put(Integer.valueOf(i7), hashMap2);
                                        }
                                        hashMap.put(optString2, map);
                                    } else {
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put(Integer.valueOf(i8), 1);
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put(Integer.valueOf(i7), hashMap3);
                                        hashMap.put(optString2, hashMap4);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    cn.jiguang.ai.a.d("JWakeHelper", "unkown type :" + optString);
                }
                i4++;
            }
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = new JSONArray();
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("p", entry.getKey());
                JSONArray jSONArray5 = new JSONArray();
                Iterator it2 = ((Map) entry.getValue()).entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    Integer num = (Integer) entry2.getKey();
                    Map map3 = (Map) entry2.getValue();
                    int intValue = map3.containsKey(Integer.valueOf(i2)) ? ((Integer) map3.get(Integer.valueOf(i2))).intValue() : 0;
                    int intValue2 = map3.containsKey(101) ? ((Integer) map3.get(101)).intValue() : 0;
                    Iterator it3 = it;
                    int intValue3 = map3.containsKey(102) ? ((Integer) map3.get(102)).intValue() : 0;
                    Iterator it4 = it2;
                    int intValue4 = map3.containsKey(103) ? ((Integer) map3.get(103)).intValue() : 0;
                    jSONArray5.put(num + "_" + (intValue + intValue2 + intValue3 + intValue4) + "_" + intValue + "_" + intValue2 + "_" + intValue3 + "_" + intValue4);
                    it = it3;
                    it2 = it4;
                    i2 = 1;
                }
                jSONObject3.put("d", jSONArray5);
                jSONArray4.put(jSONObject3);
                it = it;
                i2 = 1;
            }
            if (jSONArray4.length() > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("t", jSONArray4);
                jSONObject4.put("itime", cn.jiguang.l.d.i(context));
                jSONObject4.put(ContentCommon.TYPE, "aa3");
                jSONArray3.put(jSONObject4);
            }
            return jSONArray3.length() > 0 ? jSONArray3 : jSONArray;
        } catch (Throwable th) {
            cn.jiguang.ai.a.e("JWakeHelper", "merge wake json failed:" + th.getMessage());
            return null;
        }
    }

    public static void a(Context context, cn.jiguang.am.a aVar, List<cn.jiguang.am.b> list) {
        if (!aVar.t) {
            cn.jiguang.ai.a.d("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        JSONObject b2 = b(list);
        cn.jiguang.ai.a.a("JWakeHelper", "wake json:" + b2);
        a(context, b2);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            cn.jiguang.ai.a.a("JWakeHelper", "save wake data : " + jSONObject.toString());
            jSONObject.put("itime", cn.jiguang.l.d.i(context));
            jSONObject.put(ContentCommon.TYPE, "aa3");
            synchronized ("wake_cache_v2.json") {
                JSONObject a2 = cn.jiguang.p.c.a(context, "wake_cache_v2.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put("content", optJSONArray);
                cn.jiguang.p.c.a(context, "wake_cache_v2.json", a2);
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeHelper", "saveWakeData failed:" + th.getMessage());
        }
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }

    public static List<String> b(cn.jiguang.am.a aVar, List<String> list) {
        if (TextUtils.isEmpty(aVar.n) || aVar.n.equals("disable")) {
            return list;
        }
        List<String> list2 = aVar.o;
        String str = aVar.n;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1321148966) {
            if (hashCode == 1942574248 && str.equals("include")) {
                c2 = 1;
            }
        } else if (str.equals("exclude")) {
            c2 = 0;
        }
        return c2 != 0 ? c2 != 1 ? list : b(list2, list) : a(list2, list);
    }

    public static List<String> b(List<String> list, List<String> list2) {
        return a(list, list2, true);
    }

    public static JSONArray b(Context context) {
        JSONObject a2;
        synchronized ("wake_cache_v2.json") {
            a2 = cn.jiguang.p.c.a(context, "wake_cache_v2.json");
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        JSONArray optJSONArray = a2.optJSONArray("content");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        cn.jiguang.ai.a.a("JWakeHelper", "no save data");
        return null;
    }

    public static JSONObject b(List<cn.jiguang.am.b> list) {
        if (list == null || list.size() == 0) {
            cn.jiguang.ai.a.a("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.am.b bVar : list) {
            try {
                if (bVar.f8204b != null && !bVar.f8204b.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", bVar.f8203a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> hashMap = bVar.f8204b;
                    for (Integer num : hashMap.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", hashMap.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("package", bVar.f8203a);
                    jSONObject.put(JThirdPlatFormInterface.KEY_DATA, jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                cn.jiguang.ai.a.f("JWakeHelper", "formatReportData:" + th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("target", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject3;
    }

    public static List<String> c(cn.jiguang.am.a aVar, List<String> list) {
        return a(aVar.p, list);
    }

    public static void c(Context context) {
        synchronized ("wake_cache_v2.json") {
            cn.jiguang.p.c.a(context, "wake_cache_v2.json", (String) null);
        }
    }
}
