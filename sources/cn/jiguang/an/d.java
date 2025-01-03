package cn.jiguang.an;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {
    public static List<cn.jiguang.am.c> a(String str, String str2, String str3, int i2) {
        List<cn.jiguang.am.c> list;
        cn.jiguang.am.c cVar = new cn.jiguang.am.c();
        cVar.f8205a = str2;
        cVar.f8206b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            list = null;
        } else {
            list = c.a(str);
            cn.jiguang.ai.a.a("JWakePackageHelper", "cache cmd wakeTargets:" + list);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (list.get(size).f8205a.equals(str2) && list.get(size).f8206b.equals(str3)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (i2 == 1) {
            list.add(cVar);
        }
        return list;
    }
}
