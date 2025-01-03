package c.c.b.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f5949a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f5950b;

    /* renamed from: c, reason: collision with root package name */
    public final FirebaseInstanceId f5951c;

    public f0(FirebaseInstanceId firebaseInstanceId, long j) {
        this.f5951c = firebaseInstanceId;
        this.f5949a = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f5950b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public final Context a() {
        return this.f5951c.c().b();
    }

    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean c() throws IOException {
        b0 d2 = this.f5951c.d();
        boolean z = true;
        if (!this.f5951c.a(d2)) {
            return true;
        }
        try {
            String e2 = this.f5951c.e();
            if (e2 == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((d2 == null || (d2 != null && !e2.equals(d2.f5909a))) && "[DEFAULT]".equals(this.f5951c.c().c())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.f5951c.c().c());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra(JThirdPlatFormInterface.KEY_TOKEN, e2);
                Context a2 = a();
                Intent intent2 = new Intent(a2, (Class<?>) FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e3) {
            String message = e3.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (!z) {
                if (e3.getMessage() != null) {
                    throw e3;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message2 = e3.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message2);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        if (z.b().a(a())) {
            this.f5950b.acquire();
        }
        try {
            try {
                this.f5951c.a(true);
                if (!this.f5951c.g()) {
                    this.f5951c.a(false);
                    if (z.b().a(a())) {
                        this.f5950b.release();
                        return;
                    }
                    return;
                }
                if (z.b().b(a()) && !b()) {
                    new e0(this).a();
                    if (z.b().a(a())) {
                        this.f5950b.release();
                        return;
                    }
                    return;
                }
                if (c()) {
                    this.f5951c.a(false);
                } else {
                    this.f5951c.a(this.f5949a);
                }
                if (z.b().a(a())) {
                    this.f5950b.release();
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f5951c.a(false);
                if (z.b().a(a())) {
                    this.f5950b.release();
                }
            }
        } catch (Throwable th) {
            if (z.b().a(a())) {
                this.f5950b.release();
            }
            throw th;
        }
    }
}
