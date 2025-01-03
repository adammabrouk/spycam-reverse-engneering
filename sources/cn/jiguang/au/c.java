package cn.jiguang.au;

import android.text.TextUtils;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f8360a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8361b;

    /* renamed from: c, reason: collision with root package name */
    public File f8362c;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f8363d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8364e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8365f;

    public c(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.f8362c = file;
        this.f8363d = jSONObject;
        this.f8361b = jSONObject2;
        this.f8360a = file.length();
        this.f8365f = z;
        this.f8364e = z;
    }

    public static c a(File file, Set<String> set) {
        JSONObject a2 = a(file);
        if (a2 != null) {
            return new c(file, a2, cn.jiguang.e.d.a(a2, set), false);
        }
        cn.jiguang.e.c.a(file);
        return null;
    }

    public static c a(File file, JSONObject jSONObject) {
        JSONObject a2 = a(file);
        if (a2 != null) {
            return new c(file, a2, jSONObject, true);
        }
        cn.jiguang.e.c.a(file);
        return null;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        try {
            String d2 = cn.jiguang.e.c.d(file);
            if (TextUtils.isEmpty(d2) || (optJSONArray = (jSONObject = new JSONObject(d2)).optJSONArray("content")) == null) {
                return null;
            }
            if (optJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(c cVar, File file) {
        boolean z = true;
        if (cVar != null) {
            try {
                if (this.f8360a + cVar.f8360a <= 40960) {
                    JSONArray jSONArray = this.f8363d.getJSONArray("content");
                    JSONArray jSONArray2 = cVar.f8363d.getJSONArray("content");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        jSONArray.put(jSONArray2.getJSONObject(i2));
                    }
                    this.f8360a += cVar.f8360a;
                    this.f8364e = true;
                    cn.jiguang.e.c.a(cVar.f8362c);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.f8362c.getName());
        if (this.f8365f) {
            cn.jiguang.e.d.a(this.f8363d, this.f8361b);
        }
        if (this.f8362c.equals(file2)) {
            z = false;
        }
        if (this.f8364e || z) {
            cn.jiguang.e.c.c(file2, this.f8363d.toString());
        }
        if (z) {
            cn.jiguang.e.c.a(this.f8362c);
        }
        return false;
    }
}
