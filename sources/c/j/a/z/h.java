package c.j.a.z;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BaseSharePreference.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public Context f6707a;

    /* renamed from: b, reason: collision with root package name */
    public String f6708b;

    /* renamed from: c, reason: collision with root package name */
    public volatile SharedPreferences f6709c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f6710d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, Long> f6711e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, Integer> f6712f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, Boolean> f6713g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f6708b = str;
        this.f6709c = context.getSharedPreferences(str, 0);
        this.f6707a = context;
        List<String> c2 = c("local_iv");
        if (c2 == null || c2.size() < 4) {
            v.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", c2.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", c2.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", c2.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", c2.get(0));
        a(hashMap);
    }

    public final String b(String str, String str2) {
        String str3 = this.f6710d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f6709c != null) {
            str3 = this.f6709c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f6710d.put(str, str3);
            }
        }
        return str3;
    }

    public final List<String> c(String str) {
        Object a2;
        String[] split;
        if (this.f6707a == null) {
            v.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            a2 = f0.a(this.f6707a, this.f6707a.getPackageName(), str);
        } catch (Exception e2) {
            v.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (a2 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a2.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final long b(String str, long j) {
        Long l = this.f6711e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f6709c != null) {
            l = Long.valueOf(this.f6709c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.f6711e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, String str2) {
        this.f6710d.put(str, str2);
        b();
        if (this.f6709c != null) {
            SharedPreferences.Editor edit = this.f6709c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final void b(String str) {
        this.f6711e.remove(str);
        this.f6712f.remove(str);
        this.f6713g.remove(str);
        this.f6710d.remove(str);
        b();
        if (this.f6709c != null) {
            SharedPreferences.Editor edit = this.f6709c.edit();
            if (this.f6709c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f6709c != null) {
                SharedPreferences.Editor edit = this.f6709c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f6710d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    public final void b() {
        if (this.f6709c == null) {
            Context context = this.f6707a;
            if (context != null) {
                this.f6709c = context.getSharedPreferences(this.f6708b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, int i2) {
        this.f6712f.put(str, Integer.valueOf(i2));
        b();
        if (this.f6709c != null) {
            SharedPreferences.Editor edit = this.f6709c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    public final void a(String str, long j) {
        this.f6711e.put(str, Long.valueOf(j));
        b();
        if (this.f6709c != null) {
            SharedPreferences.Editor edit = this.f6709c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final int a(String str) {
        Integer num = this.f6712f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f6709c != null) {
            num = Integer.valueOf(this.f6709c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f6712f.put(str, num);
            }
        }
        return num.intValue();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f6711e.clear();
        this.f6712f.clear();
        this.f6713g.clear();
        this.f6710d.clear();
        b();
        if (this.f6709c != null) {
            SharedPreferences.Editor edit = this.f6709c.edit();
            edit.clear();
            a(edit);
        }
    }
}
