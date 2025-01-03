package c.j.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import c.j.a.z.f0;
import c.j.a.z.l;
import c.j.a.z.v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppConfigSettings.java */
/* loaded from: classes.dex */
public final class b extends d<c.j.a.t.d> {
    public b(Context context) {
        super(context);
    }

    @Override // c.j.a.j.d
    public final String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // c.j.a.j.d
    public final List<c.j.a.t.d> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split("@#")) {
                String trim = str2.trim();
                String[] split = trim.trim().split(",");
                if (split.length >= 2) {
                    try {
                        arrayList.add(new c.j.a.t.d(split[0], trim.substring(split[0].length() + 1)));
                    } catch (Exception e2) {
                        v.d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(e2)));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // c.j.a.j.d
    public final String b(String str) throws Exception {
        return new String(l.a(l.a(e()), l.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final c.j.a.t.d c(String str) {
        synchronized (d.f6564e) {
            for (T t : this.f6567c) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }

    public final int b() {
        c.j.a.t.d c2 = c("push_mode");
        if (c2 != null && !TextUtils.isEmpty(c2.b())) {
            try {
                return Integer.parseInt(c2.b());
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static boolean a(int i2) {
        if (i2 != -1) {
            return (i2 & 1) != 0;
        }
        return f0.b("persist.sys.log.ctrl", "no").equals("yes");
    }
}
