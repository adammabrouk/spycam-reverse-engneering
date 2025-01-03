package c.c.b.k;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.internal.JConstants;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static d f5901b;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5902a;

    public d(Context context) {
        this.f5902a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f5901b == null) {
                f5901b = new d(context);
            }
            dVar = f5901b;
        }
        return dVar;
    }

    public synchronized boolean a(String str, long j) {
        if (!this.f5902a.contains(str)) {
            this.f5902a.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.f5902a.getLong(str, -1L) < JConstants.DAY) {
            return false;
        }
        this.f5902a.edit().putLong(str, j).apply();
        return true;
    }

    public synchronized boolean a(long j) {
        return a("fire-global", j);
    }
}
