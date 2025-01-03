package c.k.d.p9;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import c.k.d.g9;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e0 {

    /* renamed from: e, reason: collision with root package name */
    public static e0 f7560e;

    /* renamed from: a, reason: collision with root package name */
    public Context f7561a;

    /* renamed from: b, reason: collision with root package name */
    public List<Message> f7562b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f7563c = false;

    /* renamed from: d, reason: collision with root package name */
    public Messenger f7564d;

    public e0(Context context) {
        this.f7561a = context.getApplicationContext();
        new Messenger(new f0(this, Looper.getMainLooper()));
        if (a()) {
            c.k.a.a.a.c.c("use miui push service");
        }
    }

    public static e0 a(Context context) {
        if (f7560e == null) {
            f7560e = new e0(context);
        }
        return f7560e;
    }

    public final Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final synchronized void m367a(Intent intent) {
        if (this.f7563c) {
            Message a2 = a(intent);
            if (this.f7562b.size() >= 50) {
                this.f7562b.remove(0);
            }
            this.f7562b.add(a2);
            return;
        }
        if (this.f7564d == null) {
            this.f7561a.bindService(intent, new g0(this), 1);
            this.f7563c = true;
            this.f7562b.clear();
            this.f7562b.add(a(intent));
        } else {
            try {
                this.f7564d.send(a(intent));
            } catch (RemoteException unused) {
                this.f7564d = null;
                this.f7563c = false;
            }
        }
    }

    public final boolean a() {
        if (c.k.d.c.f7007c) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f7561a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m368a(Intent intent) {
        try {
            if (g9.m183a() || Build.VERSION.SDK_INT < 26) {
                this.f7561a.startService(intent);
                return true;
            }
            m367a(intent);
            return true;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }
}
