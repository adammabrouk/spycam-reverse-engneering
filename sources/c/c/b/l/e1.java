package c.c.b.l;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c.c.b.k.c;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.b.c f5936a;

    /* renamed from: b, reason: collision with root package name */
    public final r f5937b;

    /* renamed from: c, reason: collision with root package name */
    public final x f5938c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f5939d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.b.q.h f5940e;

    /* renamed from: f, reason: collision with root package name */
    public final c.c.b.k.c f5941f;

    /* renamed from: g, reason: collision with root package name */
    public final c.c.b.n.h f5942g;

    public e1(c.c.b.c cVar, r rVar, Executor executor, c.c.b.q.h hVar, c.c.b.k.c cVar2, c.c.b.n.h hVar2) {
        this(cVar, rVar, executor, new x(cVar.b(), rVar), hVar, cVar2, hVar2);
    }

    public final c.c.a.b.j.h<String> a(String str, String str2, String str3) {
        return a(a(str, str2, str3, new Bundle()));
    }

    public final c.c.a.b.j.h<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return b(a(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final c.c.a.b.j.h<Void> c(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString(RequestParameters.SUBRESOURCE_DELETE, "1");
        String valueOf2 = String.valueOf(str3);
        return b(a(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public e1(c.c.b.c cVar, r rVar, Executor executor, x xVar, c.c.b.q.h hVar, c.c.b.k.c cVar2, c.c.b.n.h hVar2) {
        this.f5936a = cVar;
        this.f5937b = rVar;
        this.f5938c = xVar;
        this.f5939d = executor;
        this.f5940e = hVar;
        this.f5941f = cVar2;
        this.f5942g = hVar2;
    }

    public final c.c.a.b.j.h<Bundle> a(final String str, final String str2, final String str3, final Bundle bundle) {
        final c.c.a.b.j.i iVar = new c.c.a.b.j.i();
        this.f5939d.execute(new Runnable(this, str, str2, str3, bundle, iVar) { // from class: c.c.b.l.d1

            /* renamed from: a, reason: collision with root package name */
            public final e1 f5924a;

            /* renamed from: b, reason: collision with root package name */
            public final String f5925b;

            /* renamed from: c, reason: collision with root package name */
            public final String f5926c;

            /* renamed from: d, reason: collision with root package name */
            public final String f5927d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f5928e;

            /* renamed from: f, reason: collision with root package name */
            public final c.c.a.b.j.i f5929f;

            {
                this.f5924a = this;
                this.f5925b = str;
                this.f5926c = str2;
                this.f5927d = str3;
                this.f5928e = bundle;
                this.f5929f = iVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5924a.a(this.f5925b, this.f5926c, this.f5927d, this.f5928e, this.f5929f);
            }
        });
        return iVar.a();
    }

    public final Bundle b(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f5936a.d().b());
        bundle.putString("gmsv", Integer.toString(this.f5937b.e()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f5937b.c());
        bundle.putString("app_ver_name", this.f5937b.d());
        bundle.putString("firebase-app-name-hash", a());
        try {
            String a2 = ((c.c.b.n.m) c.c.a.b.j.k.a((c.c.a.b.j.h) this.f5942g.a(false))).a();
            if (!TextUtils.isEmpty(a2)) {
                bundle.putString("Goog-Firebase-Installations-Auth", a2);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e2);
        }
        String a3 = c.c.a.b.c.o.p.a().a("firebase-iid");
        if ("UNKNOWN".equals(a3)) {
            int i2 = c.c.a.b.c.d.f3814a;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i2);
            a3 = sb.toString();
        }
        String valueOf = String.valueOf(a3);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        c.a a4 = this.f5941f.a("fire-iid");
        if (a4 != c.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a4.getCode()));
            bundle.putString("Firebase-Client", this.f5940e.a());
        }
        return bundle;
    }

    public final String a() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.f5936a.c().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public final c.c.a.b.j.h<String> a(c.c.a.b.j.h<Bundle> hVar) {
        return hVar.a(this.f5939d, new c.c.a.b.j.a(this) { // from class: c.c.b.l.f1
            @Override // c.c.a.b.j.a
            public final Object a(c.c.a.b.j.h hVar2) {
                Bundle bundle = (Bundle) hVar2.a(IOException.class);
                if (bundle == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                String string = bundle.getString("registration_id");
                if (string != null) {
                    return string;
                }
                String string2 = bundle.getString("unregistered");
                if (string2 != null) {
                    return string2;
                }
                String string3 = bundle.getString("error");
                if ("RST".equals(string3)) {
                    throw new IOException("INSTANCE_ID_RESET");
                }
                if (string3 != null) {
                    throw new IOException(string3);
                }
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }

    public final /* synthetic */ void a(String str, String str2, String str3, Bundle bundle, c.c.a.b.j.i iVar) {
        try {
            b(str, str2, str3, bundle);
            iVar.a((c.c.a.b.j.i) this.f5938c.a(bundle));
        } catch (IOException e2) {
            iVar.a((Exception) e2);
        }
    }

    public static <T> c.c.a.b.j.h<Void> b(c.c.a.b.j.h<T> hVar) {
        return hVar.a(t0.a(), g1.f5953a);
    }
}
