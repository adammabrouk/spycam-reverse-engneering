package c.c.b.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f6140f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f6141g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f6142h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6143a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.b.l.r f6144b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f6145c;

    /* renamed from: d, reason: collision with root package name */
    public final e f6146d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6147e;

    public g(e eVar, Context context, c.c.b.l.r rVar, long j) {
        this.f6146d = eVar;
        this.f6143a = context;
        this.f6147e = j;
        this.f6144b = rVar;
        this.f6145c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean b(Context context) {
        boolean booleanValue;
        synchronized (f6140f) {
            Boolean valueOf = Boolean.valueOf(f6142h == null ? a(context, "android.permission.ACCESS_NETWORK_STATE", f6142h) : f6142h.booleanValue());
            f6142h = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    public static boolean c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public final synchronized boolean a() {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f6143a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            z = activeNetworkInfo.isConnected();
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        android.util.Log.d("FirebaseMessaging", "Connectivity change received registered");
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"Wakelock"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.p.g.run():void");
    }

    public static boolean a(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (f6140f) {
            if (f6141g == null) {
                booleanValue = a(context, "android.permission.WAKE_LOCK", f6141g);
            } else {
                booleanValue = f6141g.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f6141g = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    public static boolean a(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 142);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z;
    }
}
