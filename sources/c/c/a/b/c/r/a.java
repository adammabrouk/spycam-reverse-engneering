package c.c.a.b.c.r;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4004a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f4005b;

    public a() {
        List list = Collections.EMPTY_LIST;
    }

    public static a a() {
        if (f4005b == null) {
            synchronized (f4004a) {
                if (f4005b == null) {
                    f4005b = new a();
                }
            }
        }
        return f4005b;
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : c.c.a.b.c.s.d.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
