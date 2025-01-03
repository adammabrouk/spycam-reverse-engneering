package c.k.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k9 {

    /* renamed from: d, reason: collision with root package name */
    public static volatile k9 f7329d;

    /* renamed from: a, reason: collision with root package name */
    public Context f7330a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f7331b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Map<String, String>> f7332c = new HashMap();

    public k9(Context context) {
        this.f7330a = context;
    }

    public static k9 a(Context context) {
        if (f7329d == null) {
            synchronized (k9.class) {
                if (f7329d == null) {
                    f7329d = new k9(context);
                }
            }
        }
        return f7329d;
    }

    public final synchronized String a(String str, String str2) {
        if (this.f7332c != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f7332c.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.f7330a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m269a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f7331b.post(new m9(this, str, str2, str3));
    }

    public final synchronized void b(String str, String str2, String str3) {
        if (this.f7332c == null) {
            this.f7332c = new HashMap();
        }
        Map<String, String> map = this.f7332c.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f7332c.put(str, map);
    }
}
