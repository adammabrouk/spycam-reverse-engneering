package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile r0 f7789b;

    /* renamed from: a, reason: collision with root package name */
    public Context f7790a;

    public r0(Context context) {
        this.f7790a = context;
    }

    public static r0 a(Context context) {
        if (f7789b == null) {
            synchronized (r0.class) {
                if (f7789b == null) {
                    f7789b = new r0(context);
                }
            }
        }
        return f7789b;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f7790a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f7790a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m438a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f7790a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m439a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f7790a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
