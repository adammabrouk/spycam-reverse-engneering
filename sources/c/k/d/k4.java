package c.k.d;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    public static a f7320a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f7321b = XMJobService.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    public static int f7322c = 0;

    public interface a {
        /* renamed from: a */
        void mo284a();

        void a(boolean z);

        /* renamed from: a, reason: collision with other method in class */
        boolean mo268a();
    }

    public static synchronized void a() {
        synchronized (k4.class) {
            if (f7320a == null) {
                return;
            }
            c.k.a.a.a.c.c("stop alarm.");
            f7320a.mo284a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (c.k.d.k4.f7321b.equals(c.k.d.q9.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            c.k.d.l4 r0 = new c.k.d.l4
            r0.<init>(r9)
        L17:
            c.k.d.k4.f7320a = r0
            goto Ld4
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L81
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L81
            android.content.pm.ServiceInfo[] r3 = r1.services     // Catch: java.lang.Exception -> L81
            r4 = 1
            if (r3 == 0) goto L9a
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L81
            int r3 = r1.length     // Catch: java.lang.Exception -> L81
            r5 = 0
        L32:
            if (r2 >= r3) goto L7f
            r6 = r1[r2]     // Catch: java.lang.Exception -> L7c
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L65
            java.lang.String r7 = c.k.d.k4.f7321b     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L4a
        L48:
            r5 = 1
            goto L62
        L4a:
            java.lang.String r7 = r6.name     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = c.k.d.q9.a(r9, r7)     // Catch: java.lang.Exception -> L61
            java.lang.String r8 = c.k.d.k4.f7321b     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = r7.getSuperclass()     // Catch: java.lang.Exception -> L61
            java.lang.String r7 = r7.getCanonicalName()     // Catch: java.lang.Exception -> L61
            boolean r7 = r8.equals(r7)     // Catch: java.lang.Exception -> L61
            if (r7 == 0) goto L62
            goto L48
        L61:
        L62:
            if (r5 != r4) goto L65
            goto L7f
        L65:
            java.lang.String r7 = c.k.d.k4.f7321b     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L79
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L7c
            if (r6 == 0) goto L79
            r2 = 1
            goto L9a
        L79:
            int r2 = r2 + 1
            goto L32
        L7c:
            r1 = move-exception
            r2 = r5
            goto L82
        L7f:
            r2 = r5
            goto L9a
        L81:
            r1 = move-exception
        L82:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            c.k.a.a.a.c.m6a(r1)
        L9a:
            if (r2 != 0) goto Lc9
            boolean r1 = c.k.d.q9.m436a(r9)
            if (r1 != 0) goto La3
            goto Lc9
        La3:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = c.k.d.k4.f7321b
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            c.k.d.l4 r0 = new c.k.d.l4
            r0.<init>(r9)
            goto L17
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.k4.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i2) {
        synchronized (k4.class) {
            int i3 = f7322c;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i2 == 2) {
                    f7322c = 2;
                } else {
                    f7322c = 0;
                }
            }
            if (i3 != f7322c && f7322c == 2) {
                a();
                f7320a = new m4(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (k4.class) {
            if (f7320a == null) {
                c.k.a.a.a.c.m6a("timer is not initialized");
                return;
            }
            c.k.a.a.a.c.c("register alarm. (" + z + ")");
            f7320a.a(z);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m267a() {
        synchronized (k4.class) {
            if (f7320a == null) {
                return false;
            }
            return f7320a.mo268a();
        }
    }
}
