package c.c.b.l;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.iid.zzj;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: g, reason: collision with root package name */
    public static int f6008g;

    /* renamed from: h, reason: collision with root package name */
    public static PendingIntent f6009h;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6011b;

    /* renamed from: c, reason: collision with root package name */
    public final r f6012c;

    /* renamed from: e, reason: collision with root package name */
    public Messenger f6014e;

    /* renamed from: f, reason: collision with root package name */
    public zzj f6015f;

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("responseCallbacks")
    public final a.e.g<String, c.c.a.b.j.i<Bundle>> f6010a = new a.e.g<>();

    /* renamed from: d, reason: collision with root package name */
    public Messenger f6013d = new Messenger(new a0(this, Looper.getMainLooper()));

    public x(Context context, r rVar) {
        this.f6011b = context;
        this.f6012c = rVar;
    }

    public final void a(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzj.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzj) {
                        this.f6015f = (zzj) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f6014e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf2 = String.valueOf(stringExtra);
                            Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Unexpected response string: ".concat(valueOf2) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    a(group, extras);
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf3 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf3);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf4 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Received InstanceID error ".concat(valueOf4) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (this.f6010a) {
                        for (int i2 = 0; i2 < this.f6010a.size(); i2++) {
                            a(this.f6010a.c(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] split = stringExtra2.split("\\|");
                if (split.length <= 2 || !"ID".equals(split[1])) {
                    String valueOf5 = String.valueOf(stringExtra2);
                    Log.w("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected structured response ".concat(valueOf5) : new String("Unexpected structured response "));
                    return;
                }
                String str = split[2];
                String str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
                a(str, intent2.putExtra("error", str2).getExtras());
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    public final Bundle b(Bundle bundle) throws IOException {
        Bundle c2 = c(bundle);
        if (c2 == null || !c2.containsKey("google.messenger")) {
            return c2;
        }
        Bundle c3 = c(bundle);
        if (c3 == null || !c3.containsKey("google.messenger")) {
            return c3;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
    
        if (r7.f6015f != null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [c.c.a.b.j.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v21, types: [android.os.Bundle] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d3 -> B:21:0x00de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00d9 -> B:21:0x00de). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle c(android.os.Bundle r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.l.x.c(android.os.Bundle):android.os.Bundle");
    }

    public static synchronized void a(Context context, Intent intent) {
        synchronized (x.class) {
            if (f6009h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f6009h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f6009h);
        }
    }

    public final void a(String str, Bundle bundle) {
        synchronized (this.f6010a) {
            c.c.a.b.j.i<Bundle> remove = this.f6010a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
            } else {
                remove.a((c.c.a.b.j.i<Bundle>) bundle);
            }
        }
    }

    public final Bundle a(Bundle bundle) throws IOException {
        if (this.f6012c.e() >= 12000000) {
            try {
                return (Bundle) c.c.a.b.j.k.a((c.c.a.b.j.h) e.a(this.f6011b).b(1, bundle));
            } catch (InterruptedException | ExecutionException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ((e2.getCause() instanceof p) && ((p) e2.getCause()).zza() == 4) {
                    return b(bundle);
                }
                return null;
            }
        }
        return b(bundle);
    }

    public static synchronized String a() {
        String num;
        synchronized (x.class) {
            int i2 = f6008g;
            f6008g = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }
}
