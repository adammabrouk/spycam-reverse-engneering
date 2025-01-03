package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class s6 {
    public static HashMap<String, ArrayList<z6>> a(Context context, List<z6> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<z6>> hashMap = new HashMap<>();
        for (z6 z6Var : list) {
            a(context, z6Var);
            ArrayList<z6> arrayList = hashMap.get(z6Var.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(z6Var.c(), arrayList);
            }
            arrayList.add(z6Var);
        }
        return hashMap;
    }

    public static void a(Context context, u6 u6Var, HashMap<String, ArrayList<z6>> hashMap) {
        for (Map.Entry<String, ArrayList<z6>> entry : hashMap.entrySet()) {
            try {
                ArrayList<z6> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    u6Var.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, u6 u6Var, List<z6> list) {
        HashMap<String, ArrayList<z6>> a2 = a(context, list);
        if (a2 != null && a2.size() != 0) {
            a(context, u6Var, a2);
            return;
        }
        c.k.a.a.a.c.m6a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    public static void a(Context context, z6 z6Var) {
        if (z6Var.f135a) {
            z6Var.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(z6Var.d())) {
            z6Var.f(c.k.d.p9.l0.a());
        }
        z6Var.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(z6Var.e())) {
            z6Var.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(z6Var.c())) {
            z6Var.e(z6Var.e());
        }
    }
}
