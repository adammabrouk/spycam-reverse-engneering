package c.c.b.p;

import a.h.a.g;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6149a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6150b;

    /* renamed from: c, reason: collision with root package name */
    public final w f6151c;

    public i(Context context, w wVar, Executor executor) {
        this.f6149a = executor;
        this.f6150b = context;
        this.f6151c = wVar;
    }

    public final boolean a() {
        boolean z;
        if (this.f6151c.b("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.f6150b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!c.c.a.b.c.s.n.g()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f6150b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        t b2 = t.b(this.f6151c.a("gcm.n.image"));
        if (b2 != null) {
            b2.a(this.f6149a);
        }
        c a2 = h.a(this.f6150b, this.f6151c);
        g.e eVar = a2.f6118a;
        if (b2 != null) {
            try {
                Bitmap bitmap = (Bitmap) c.c.a.b.j.k.a(b2.a(), 5L, TimeUnit.SECONDS);
                eVar.b(bitmap);
                g.b bVar = new g.b();
                bVar.b(bitmap);
                bVar.a((Bitmap) null);
                eVar.a(bVar);
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                b2.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                String valueOf = String.valueOf(e2.getCause());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
                sb.append("Failed to download image: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                b2.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f6150b.getSystemService("notification")).notify(a2.f6119b, 0, a2.f6118a.a());
        return true;
    }
}
