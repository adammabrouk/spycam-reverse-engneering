package c.c.b.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5917a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5918b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f5919c = new a.e.a();

    public c0(Context context) {
        this.f5918b = context;
        this.f5917a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(a.h.b.a.c(this.f5918b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || b()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            a();
            FirebaseInstanceId.o().f();
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized boolean b() {
        return this.f5917a.getAll().isEmpty();
    }

    public final long c(String str) {
        String string = this.f5917a.getString(a(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public final synchronized void a() {
        this.f5919c.clear();
        this.f5917a.edit().clear().commit();
    }

    public final synchronized void b(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f5917a.edit();
        for (String str2 : this.f5917a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public final synchronized b0 a(String str, String str2, String str3) {
        return b0.b(this.f5917a.getString(b(str, str2, str3), null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = b0.a(str4, str5, System.currentTimeMillis());
        if (a2 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f5917a.edit();
        edit.putString(b(str, str2, str3), a2);
        edit.commit();
    }

    public final synchronized long a(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.f5917a.contains(a(str, "cre"))) {
            SharedPreferences.Editor edit = this.f5917a.edit();
            edit.putString(a(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = c(str);
        }
        this.f5919c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }
}
