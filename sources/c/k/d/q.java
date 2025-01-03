package c.k.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.NetworkUtils;

/* loaded from: classes.dex */
public class q implements s {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f7746h;

    /* renamed from: a, reason: collision with root package name */
    public Context f7747a;

    /* renamed from: b, reason: collision with root package name */
    public ServiceConnection f7748b;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f7751e;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f7749c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile String f7750d = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f7752f = null;

    /* renamed from: g, reason: collision with root package name */
    public final Object f7753g = new Object();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                q.this.f7750d = b.a(iBinder);
                q.this.f7751e = b.m417a(iBinder);
                q.this.m416b();
                q.this.f7749c = 2;
                synchronized (q.this.f7753g) {
                    try {
                        q.this.f7753g.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                q.this.m416b();
                q.this.f7749c = 2;
                synchronized (q.this.f7753g) {
                    try {
                        q.this.f7753g.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                q.this.m416b();
                q.this.f7749c = 2;
                synchronized (q.this.f7753g) {
                    try {
                        q.this.f7753g.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class b {
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public static boolean m417a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public q(Context context) {
        this.f7747a = context;
        m414a();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L24
            r2 = 24
            r3 = 0
            java.lang.String r4 = "aaid"
            if (r1 < r2) goto L19
            android.content.Context r1 = r5.createDeviceProtectedStorageContext()     // Catch: java.lang.Exception -> L24
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)     // Catch: java.lang.Exception -> L24
            java.lang.String r1 = r1.getString(r4, r0)     // Catch: java.lang.Exception -> L24
            if (r1 == 0) goto L1a
            return r1
        L19:
            r1 = r0
        L1a:
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r3)     // Catch: java.lang.Exception -> L23
            java.lang.String r5 = r5.getString(r4, r0)     // Catch: java.lang.Exception -> L23
            goto L25
        L23:
            r0 = r1
        L24:
            r5 = r0
        L25:
            if (r5 != 0) goto L29
            java.lang.String r5 = ""
        L29:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.q.a(android.content.Context):java.lang.String");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m413a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", RecyclerView.c0.FLAG_IGNORE);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f7746h = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    @Override // c.k.d.s
    public String a() {
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m414a() {
        boolean z;
        this.f7748b = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f7747a.bindService(intent, this.f7748b, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f7749c = z ? 1 : 2;
    }

    public final void a(String str) {
        if (this.f7749c != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f7753g) {
            try {
                c.k.a.a.a.c.m6a("huawei's " + str + " wait...");
                this.f7753g.wait(NetworkUtils.SCAN_PERIOD_MILLIS);
            } catch (Exception unused) {
            }
        }
    }

    @Override // c.k.d.s
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo415a() {
        return f7746h;
    }

    @Override // c.k.d.s
    public String b() {
        a("getOAID");
        return this.f7750d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m416b() {
        ServiceConnection serviceConnection = this.f7748b;
        if (serviceConnection != null) {
            try {
                this.f7747a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // c.k.d.s
    public String c() {
        return null;
    }

    @Override // c.k.d.s
    public String d() {
        if (this.f7752f == null) {
            synchronized (this) {
                if (this.f7752f == null) {
                    this.f7752f = a(this.f7747a);
                }
            }
        }
        return this.f7752f;
    }
}
