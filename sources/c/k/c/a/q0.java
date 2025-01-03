package c.k.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.d5;
import c.k.d.f7;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q0 {

    /* renamed from: e, reason: collision with root package name */
    public static volatile q0 f6898e;

    /* renamed from: a, reason: collision with root package name */
    public Context f6899a;

    /* renamed from: b, reason: collision with root package name */
    public a f6900b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, a> f6901c;

    /* renamed from: d, reason: collision with root package name */
    public String f6902d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6903a;

        /* renamed from: b, reason: collision with root package name */
        public String f6904b;

        /* renamed from: c, reason: collision with root package name */
        public String f6905c;

        /* renamed from: d, reason: collision with root package name */
        public String f6906d;

        /* renamed from: e, reason: collision with root package name */
        public String f6907e;

        /* renamed from: f, reason: collision with root package name */
        public String f6908f;

        /* renamed from: g, reason: collision with root package name */
        public String f6909g;

        /* renamed from: h, reason: collision with root package name */
        public String f6910h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f6911i = true;
        public boolean j = false;
        public int k = 1;
        public Context l;

        public a(Context context) {
            this.l = context;
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f6903a);
                jSONObject.put("appToken", aVar.f6904b);
                jSONObject.put("regId", aVar.f6905c);
                jSONObject.put("regSec", aVar.f6906d);
                jSONObject.put("devId", aVar.f6908f);
                jSONObject.put("vName", aVar.f6907e);
                jSONObject.put("valid", aVar.f6911i);
                jSONObject.put("paused", aVar.j);
                jSONObject.put("envType", aVar.k);
                jSONObject.put("regResource", aVar.f6909g);
                return jSONObject.toString();
            } catch (Throwable th) {
                c.k.a.a.a.c.a(th);
                return null;
            }
        }

        public final String a() {
            Context context = this.l;
            return d5.m127a(context, context.getPackageName());
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m55a() {
            q0.a(this.l).edit().clear().commit();
            this.f6903a = null;
            this.f6904b = null;
            this.f6905c = null;
            this.f6906d = null;
            this.f6908f = null;
            this.f6907e = null;
            this.f6911i = false;
            this.j = false;
            this.k = 1;
        }

        public void a(int i2) {
            this.k = i2;
        }

        public void a(String str, String str2) {
            this.f6905c = str;
            this.f6906d = str2;
            this.f6908f = f7.l(this.l);
            this.f6907e = a();
            this.f6911i = true;
        }

        public void a(String str, String str2, String str3) {
            this.f6903a = str;
            this.f6904b = str2;
            this.f6909g = str3;
            SharedPreferences.Editor edit = q0.a(this.l).edit();
            edit.putString("appId", this.f6903a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.j = z;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m56a() {
            return m57a(this.f6903a, this.f6904b);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m57a(String str, String str2) {
            return TextUtils.equals(this.f6903a, str) && TextUtils.equals(this.f6904b, str2) && !TextUtils.isEmpty(this.f6905c) && !TextUtils.isEmpty(this.f6906d) && (TextUtils.equals(this.f6908f, f7.l(this.l)) || TextUtils.equals(this.f6908f, f7.k(this.l)));
        }

        public void b() {
            this.f6911i = false;
            q0.a(this.l).edit().putBoolean("valid", this.f6911i).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f6905c = str;
            this.f6906d = str2;
            this.f6908f = f7.l(this.l);
            this.f6907e = a();
            this.f6911i = true;
            SharedPreferences.Editor edit = q0.a(this.l).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f6908f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }
    }

    public q0(Context context) {
        this.f6899a = context;
        m51c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static q0 m45a(Context context) {
        if (f6898e == null) {
            synchronized (q0.class) {
                if (f6898e == null) {
                    f6898e = new q0(context);
                }
            }
        }
        return f6898e;
    }

    public int a() {
        return this.f6900b.k;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m46a() {
        return this.f6900b.f6903a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m47a() {
        this.f6900b.m55a();
    }

    public void a(int i2) {
        this.f6900b.a(i2);
        a(this.f6899a).edit().putInt("envType", i2).commit();
    }

    public void a(String str) {
        SharedPreferences.Editor edit = a(this.f6899a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f6900b.f6907e = str;
    }

    public void a(String str, a aVar) {
        this.f6901c.put(str, aVar);
        a(this.f6899a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f6900b.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f6900b.a(z);
        a(this.f6899a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m48a() {
        Context context = this.f6899a;
        return !TextUtils.equals(d5.m127a(context, context.getPackageName()), this.f6900b.f6907e);
    }

    public boolean a(String str, String str2) {
        return this.f6900b.m57a(str, str2);
    }

    public String b() {
        return this.f6900b.f6904b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m49b() {
        this.f6900b.b();
    }

    public void b(String str, String str2, String str3) {
        this.f6900b.b(str, str2, str3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m50b() {
        if (this.f6900b.m56a()) {
            return true;
        }
        c.k.a.a.a.c.m6a("Don't send message before initialization succeeded!");
        return false;
    }

    public String c() {
        return this.f6900b.f6905c;
    }

    /* renamed from: c, reason: collision with other method in class */
    public final void m51c() {
        this.f6900b = new a(this.f6899a);
        this.f6901c = new HashMap();
        SharedPreferences a2 = a(this.f6899a);
        this.f6900b.f6903a = a2.getString("appId", null);
        this.f6900b.f6904b = a2.getString("appToken", null);
        this.f6900b.f6905c = a2.getString("regId", null);
        this.f6900b.f6906d = a2.getString("regSec", null);
        this.f6900b.f6908f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f6900b.f6908f) && f7.m154a(this.f6900b.f6908f)) {
            this.f6900b.f6908f = f7.l(this.f6899a);
            a2.edit().putString("devId", this.f6900b.f6908f).commit();
        }
        this.f6900b.f6907e = a2.getString("vName", null);
        this.f6900b.f6911i = a2.getBoolean("valid", true);
        this.f6900b.j = a2.getBoolean("paused", false);
        this.f6900b.k = a2.getInt("envType", 1);
        this.f6900b.f6909g = a2.getString("regResource", null);
        this.f6900b.f6910h = a2.getString("appRegion", null);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m52c() {
        return this.f6900b.m56a();
    }

    public String d() {
        return this.f6900b.f6906d;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m53d() {
        return this.f6900b.j;
    }

    public String e() {
        return this.f6900b.f6909g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m54e() {
        return !this.f6900b.f6911i;
    }
}
