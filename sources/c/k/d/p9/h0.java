package c.k.d.p9;

import android.content.SharedPreferences;
import c.k.d.d6;
import c.k.d.f7;
import c.k.d.g3;
import c.k.d.i3;
import c.k.d.m;
import c.k.d.q9;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h0 {

    /* renamed from: d, reason: collision with root package name */
    public static String f7595d;

    /* renamed from: e, reason: collision with root package name */
    public static h0 f7596e = new h0();

    /* renamed from: a, reason: collision with root package name */
    public List<a> f7597a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public g3 f7598b;

    /* renamed from: c, reason: collision with root package name */
    public m.b f7599c;

    public static abstract class a {
        public void a(g3 g3Var) {
        }

        public void a(i3 i3Var) {
        }
    }

    public static h0 a() {
        return f7596e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m381a() {
        String str;
        synchronized (h0.class) {
            if (f7595d == null) {
                SharedPreferences sharedPreferences = q9.m432a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f7595d = string;
                if (string == null) {
                    String a2 = f7.a(q9.m432a(), false);
                    f7595d = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f7595d).commit();
                    }
                }
            }
            str = f7595d;
        }
        return str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m384a() {
        b();
        g3 g3Var = this.f7598b;
        if (g3Var != null) {
            return g3Var.c();
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public g3 m385a() {
        b();
        return this.f7598b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m386a() {
        this.f7597a.clear();
    }

    public void a(i3 i3Var) {
        a[] aVarArr;
        if (i3Var.m218d() && i3Var.d() > m384a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f7597a.toArray(new a[this.f7597a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(i3Var);
        }
    }

    public synchronized void a(a aVar) {
        this.f7597a.add(aVar);
    }

    public final void b() {
        if (this.f7598b == null) {
            d();
        }
    }

    public final void c() {
        if (this.f7599c != null) {
            return;
        }
        i0 i0Var = new i0(this);
        this.f7599c = i0Var;
        d6.a(i0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = c.k.d.q9.m432a()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            c.k.d.b0 r0 = c.k.d.b0.a(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            c.k.d.g3 r0 = c.k.d.g3.b(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f7598b = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            c.k.d.v9.a(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            c.k.a.a.a.c.m6a(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            c.k.d.g3 r0 = r4.f7598b
            if (r0 != 0) goto L4e
            c.k.d.g3 r0 = new c.k.d.g3
            r0.<init>()
            r4.f7598b = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            c.k.d.v9.a(r2)
            goto L55
        L54:
            throw r0
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.h0.d():void");
    }

    public final void e() {
        try {
            if (this.f7598b != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(q9.m432a().openFileOutput("XMCloudCfg", 0));
                c.k.d.c1 a2 = c.k.d.c1.a(bufferedOutputStream);
                this.f7598b.a(a2);
                a2.m98a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("save config failure: " + e2.getMessage());
        }
    }
}
