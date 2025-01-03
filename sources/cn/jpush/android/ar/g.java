package cn.jpush.android.ar;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.bm.k;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    public static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2) {
        return a(arrayList, context, str, str2, true);
    }

    public static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        String str3;
        ArrayList<String> arrayList2 = new ArrayList<>();
        cn.jpush.android.r.b.a("InAppTemplateHelper", "action:loadH5TemplateImageResources - urlPrefix:" + str);
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (!cn.jpush.android.bm.a.c(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
                z2 = true;
            } else {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next) || next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                        str3 = next;
                    } else {
                        str3 = str + next;
                    }
                    byte[] a2 = cn.jpush.android.bf.a.a(str3, 3, MemoryConstants.MB);
                    if (a2 != null) {
                        try {
                            cn.jpush.android.r.b.b("InAppTemplateHelper", "download image resource success, path: " + next);
                            if (next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                                next = cn.jpush.android.bm.c.b(next);
                            }
                            String str4 = cn.jpush.android.bm.c.a(context, "h5_tpl_imgs", 0, z) + next;
                            boolean a3 = cn.jpush.android.bm.c.a(str4, a2);
                            if (a3) {
                                arrayList2.add(str4);
                                cn.jpush.android.r.b.b("InAppTemplateHelper", "download image resource cache to local success, path: " + str4);
                            }
                            cn.jpush.android.r.b.a("InAppTemplateHelper", "Succeed to load image - " + str4 + ", cache local status: " + a3);
                        } catch (Throwable th) {
                            cn.jpush.android.r.b.a("InAppTemplateHelper", "Write storage error,  create img file fail.", th);
                        }
                    } else {
                        cn.jpush.android.r.b.f("InAppTemplateHelper", "download image resource failed, path: " + str3);
                    }
                    z3 = false;
                }
                cn.jpush.android.r.b.d("InAppTemplateHelper", "template image resource download completed. local image list: " + arrayList2.toString());
                z2 = z3;
            }
        } catch (Throwable th2) {
            cn.jpush.android.r.b.f("InAppTemplateHelper", "load h5 template image resource failed, " + th2.getMessage());
        }
        if (z2) {
            return arrayList2;
        }
        return null;
    }

    public static LinkedHashMap<String, cn.jpush.android.aw.f> a(Context context) {
        LinkedHashMap<String, cn.jpush.android.aw.f> linkedHashMap = new LinkedHashMap<>();
        if (context == null) {
            cn.jpush.android.r.b.f("InAppTemplateHelper", "unexcepted , context is null");
            return linkedHashMap;
        }
        FileInputStream fileInputStream = null;
        try {
            File a2 = cn.jpush.android.bm.c.a(context, "tpl.cfg.cache");
            if (a2 != null && a2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    JSONObject jSONObject = new JSONObject(new String(k.a((InputStream) fileInputStream2)));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.aw.f a3 = cn.jpush.android.aw.f.a(jSONObject.getJSONObject(keys.next()));
                        if (a3 != null) {
                            linkedHashMap.put(a3.f9435a, a3);
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        cn.jpush.android.r.b.f("InAppTemplateHelper", "load objects error:" + th.getMessage());
                        return linkedHashMap;
                    } finally {
                        k.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LinkedHashMap<String, cn.jpush.android.aw.f> a(LinkedHashMap<String, cn.jpush.android.aw.f> linkedHashMap) {
        LinkedHashMap<String, cn.jpush.android.aw.f> linkedHashMap2 = new LinkedHashMap<>();
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, cn.jpush.android.aw.f>>() { // from class: cn.jpush.android.ar.g.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, cn.jpush.android.aw.f> entry, Map.Entry<String, cn.jpush.android.aw.f> entry2) {
                    if (entry2.getValue().f9437c > entry.getValue().f9437c) {
                        return 1;
                    }
                    return entry2.getValue().f9437c < entry.getValue().f9437c ? -1 : 0;
                }
            });
            for (Map.Entry entry : arrayList) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppTemplateHelper", "sort template file map filed. error: " + th.getMessage());
        }
        return linkedHashMap2;
    }

    public static void a(Context context, LinkedHashMap<String, cn.jpush.android.aw.f> linkedHashMap) {
        try {
            File a2 = cn.jpush.android.bm.c.a(context, "tpl.cfg.cache");
            if (a2 != null) {
                JSONObject jSONObject = new JSONObject();
                if (linkedHashMap.size() > 20) {
                    linkedHashMap = a(linkedHashMap);
                }
                int i2 = 0;
                for (Map.Entry<String, cn.jpush.android.aw.f> entry : linkedHashMap.entrySet()) {
                    cn.jpush.android.aw.f value = entry.getValue();
                    if (i2 < 20) {
                        jSONObject.put(entry.getKey(), value.a());
                    } else {
                        String str = value.f9436b;
                        File file = new File(str);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                            cn.jpush.android.r.b.b("InAppTemplateHelper", "exceed max template cache count, delete old template file: " + str + ", maxCacheCount: 20");
                        }
                    }
                    i2++;
                }
                cn.jpush.android.r.b.b("InAppTemplateHelper", "[saveTemplateConfig] template config info: " + jSONObject.toString() + ", templateSize: " + linkedHashMap.values().size());
                cn.jpush.android.bm.c.a(a2.getAbsolutePath(), jSONObject.toString());
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppTemplateHelper", "save template config to file failed. error: " + th.getMessage());
        }
    }
}
