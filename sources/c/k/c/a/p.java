package c.k.c.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import c.k.d.j7;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.z6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class p {

    public static class a {

        /* renamed from: f, reason: collision with root package name */
        public static volatile a f6880f;

        /* renamed from: a, reason: collision with root package name */
        public Context f6881a;

        /* renamed from: b, reason: collision with root package name */
        public String f6882b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f6883c;

        /* renamed from: d, reason: collision with root package name */
        public C0128a f6884d = new C0128a();

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<z6> f6885e = new ArrayList<>();

        /* renamed from: c.k.c.a.p$a$a, reason: collision with other inner class name */
        public class C0128a {

            /* renamed from: c, reason: collision with root package name */
            public ScheduledFuture<?> f6888c;

            /* renamed from: a, reason: collision with root package name */
            public ScheduledThreadPoolExecutor f6886a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: b, reason: collision with root package name */
            public final ArrayList<z6> f6887b = new ArrayList<>();

            /* renamed from: d, reason: collision with root package name */
            public final Runnable f6889d = new x(this);

            public C0128a() {
            }

            public final void a() {
                if (this.f6888c == null) {
                    this.f6888c = this.f6886a.scheduleAtFixedRate(this.f6889d, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            public void a(z6 z6Var) {
                this.f6886a.execute(new w(this, z6Var));
            }

            public final void b() {
                z6 remove = this.f6887b.remove(0);
                for (v7 v7Var : c.k.d.p9.l0.a(Arrays.asList(remove), a.this.f6881a.getPackageName(), q0.m45a(a.this.f6881a).m46a(), 30720)) {
                    c.k.a.a.a.c.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    i0.a(a.this.f6881a).a((i0) v7Var, v6.Notification, true, (j7) null);
                }
            }
        }

        public static a a() {
            if (f6880f == null) {
                synchronized (a.class) {
                    if (f6880f == null) {
                        f6880f = new a();
                    }
                }
            }
            return f6880f;
        }

        public void a(Context context) {
            if (context == null) {
                c.k.a.a.a.c.m6a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f6881a = context;
            this.f6883c = Boolean.valueOf(m42a(context));
            a("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public final void a(z6 z6Var) {
            synchronized (this.f6885e) {
                if (!this.f6885e.contains(z6Var)) {
                    this.f6885e.add(z6Var);
                    if (this.f6885e.size() > 100) {
                        this.f6885e.remove(0);
                    }
                }
            }
        }

        public void a(String str) {
            c.k.a.a.a.c.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f6885e) {
                arrayList.addAll(this.f6885e);
                this.f6885e.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m43a((z6) it.next());
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m41a() {
            return this.f6881a != null;
        }

        /* renamed from: a, reason: collision with other method in class */
        public final boolean m42a(Context context) {
            if (!i0.a(context).m27a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
        
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel";
         */
        /* renamed from: a, reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean m43a(c.k.d.z6 r6) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: c.k.c.a.p.a.m43a(c.k.d.z6):boolean");
        }

        public final boolean b(Context context) {
            return q0.m45a(context).m46a() == null && !m42a(this.f6881a);
        }

        public final boolean b(z6 z6Var) {
            if (c.k.d.p9.l0.a(z6Var, false)) {
                return false;
            }
            if (!this.f6883c.booleanValue()) {
                this.f6884d.a(z6Var);
                return true;
            }
            c.k.a.a.a.c.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + z6Var.d());
            i0.a(this.f6881a).a(z6Var);
            return true;
        }
    }

    public static boolean a(Context context, z6 z6Var) {
        c.k.a.a.a.c.c("MiTinyDataClient.upload " + z6Var.d());
        if (!a.a().m41a()) {
            a.a().a(context);
        }
        return a.a().m43a(z6Var);
    }

    public static boolean a(String str, String str2, long j, String str3) {
        z6 z6Var = new z6();
        z6Var.d(str);
        z6Var.c(str2);
        z6Var.a(j);
        z6Var.b(str3);
        return a.a().m43a(z6Var);
    }
}
