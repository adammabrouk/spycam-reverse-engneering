package cn.jpush.android.au;

import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.aw.d;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static int a(d.a aVar) {
        int d2 = aVar.d();
        int e2 = aVar.e();
        if (-1 == e2 && -1 == d2) {
            return 3;
        }
        if (-1 == e2) {
            return Build.VERSION.SDK_INT >= d2 ? 1 : 2;
        }
        int i2 = Build.VERSION.SDK_INT;
        return (d2 > i2 || i2 > e2) ? 2 : 1;
    }

    public static int a(String str, d.a aVar) {
        String c2 = aVar.c();
        if (TextUtils.isEmpty(c2)) {
            return 3;
        }
        return Pattern.matches(c2, str) ? 1 : 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
    
        if (r9.size() == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        if (r4.size() > 0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.aw.d.a a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.au.b.a(java.lang.String):cn.jpush.android.aw.d$a");
    }

    public static void a(int i2, String str, List<d.a> list, List<d.a> list2, List<d.a> list3) {
        cn.jpush.android.r.b.b("InAppMatchesConfigUtils", "matches type:" + i2 + ",value:" + str);
        for (int i3 = 0; i3 < list.size(); i3++) {
            d.a aVar = list.get(i3);
            if (!TextUtils.isEmpty(aVar.f())) {
                int i4 = 4;
                if (i2 == 1) {
                    i4 = a(str, aVar);
                } else if (i2 == 2) {
                    i4 = a(aVar);
                } else if (i2 == 3) {
                    i4 = b(str, aVar);
                }
                if (i4 == 1) {
                    list2.add(aVar);
                } else if (i4 == 3) {
                    list3.add(aVar);
                }
            }
        }
    }

    public static int b(String str, d.a aVar) {
        String b2 = aVar.b();
        if (TextUtils.isEmpty(b2)) {
            return 3;
        }
        return Pattern.matches(b2, str) ? 1 : 2;
    }

    public static cn.jpush.android.aw.d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cn.jpush.android.aw.d dVar = new cn.jpush.android.aw.d();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                d.a aVar = new d.a();
                int optInt = jSONObject.optInt(ActionManager.SDK_VERSION, -1);
                String optString = jSONObject.optString("manufacturer", null);
                String optString2 = jSONObject.optString("model", null);
                String optString3 = jSONObject.optString("rom", null);
                int optInt2 = jSONObject.optInt("android_min", -1);
                int optInt3 = jSONObject.optInt("android_max", -1);
                String optString4 = jSONObject.optString("file_path", null);
                aVar.a(optInt);
                aVar.a(optString);
                aVar.b(optString2);
                aVar.c(optString3);
                aVar.b(optInt2);
                aVar.c(optInt3);
                aVar.d(optString4);
                arrayList.add(aVar);
            }
            dVar.a(arrayList);
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
