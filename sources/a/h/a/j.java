package a.h.a;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.shix.shixipc.utils.CommonUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static String f915d;

    /* renamed from: g, reason: collision with root package name */
    public static d f918g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f919a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f920b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f914c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static Set<String> f916e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f917f = new Object();

    /* compiled from: NotificationManagerCompat.java */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f925a;

        /* renamed from: b, reason: collision with root package name */
        public final int f926b;

        /* renamed from: c, reason: collision with root package name */
        public final String f927c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification f928d;

        public b(String str, int i2, String str2, Notification notification) {
            this.f925a = str;
            this.f926b = i2;
            this.f927c = str2;
            this.f928d = notification;
        }

        @Override // a.h.a.j.e
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f925a, this.f926b, this.f927c, this.f928d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f925a + ", id:" + this.f926b + ", tag:" + this.f927c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f929a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f930b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f929a = componentName;
            this.f930b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Context f931a;

        /* renamed from: b, reason: collision with root package name */
        public final HandlerThread f932b;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f933c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f934d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public Set<String> f935e = new HashSet();

        /* compiled from: NotificationManagerCompat.java */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f936a;

            /* renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f938c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f937b = false;

            /* renamed from: d, reason: collision with root package name */
            public ArrayDeque<e> f939d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            public int f940e = 0;

            public a(ComponentName componentName) {
                this.f936a = componentName;
            }
        }

        public d(Context context) {
            this.f931a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f932b = handlerThread;
            handlerThread.start();
            this.f933c = new Handler(this.f932b.getLooper(), this);
        }

        public final void a(e eVar) {
            a();
            for (a aVar : this.f934d.values()) {
                aVar.f939d.add(eVar);
                c(aVar);
            }
        }

        public void b(e eVar) {
            this.f933c.obtainMessage(0, eVar).sendToTarget();
        }

        public final void c(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f936a + ", " + aVar.f939d.size() + " queued tasks");
            }
            if (aVar.f939d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f938c == null) {
                d(aVar);
                return;
            }
            while (true) {
                e peek = aVar.f939d.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + peek);
                    }
                    peek.a(aVar.f938c);
                    aVar.f939d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f936a);
                    }
                } catch (RemoteException e2) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f936a, e2);
                }
            }
            if (aVar.f939d.isEmpty()) {
                return;
            }
            d(aVar);
        }

        public final void d(a aVar) {
            if (this.f933c.hasMessages(3, aVar.f936a)) {
                return;
            }
            int i2 = aVar.f940e + 1;
            aVar.f940e = i2;
            if (i2 <= 6) {
                int i3 = (1 << (i2 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
                }
                this.f933c.sendMessageDelayed(this.f933c.obtainMessage(3, aVar.f936a), i3);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f939d.size() + " tasks to " + aVar.f936a + " after " + aVar.f940e + " retries");
            aVar.f939d.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                a((e) message.obj);
                return true;
            }
            if (i2 == 1) {
                c cVar = (c) message.obj;
                a(cVar.f929a, cVar.f930b);
                return true;
            }
            if (i2 == 2) {
                b((ComponentName) message.obj);
                return true;
            }
            if (i2 != 3) {
                return false;
            }
            a((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f933c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f933c.obtainMessage(2, componentName).sendToTarget();
        }

        public final void b(ComponentName componentName) {
            a aVar = this.f934d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void b(a aVar) {
            if (aVar.f937b) {
                this.f931a.unbindService(this);
                aVar.f937b = false;
            }
            aVar.f938c = null;
        }

        public final void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f934d.get(componentName);
            if (aVar != null) {
                aVar.f938c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f940e = 0;
                c(aVar);
            }
        }

        public final void a(ComponentName componentName) {
            a aVar = this.f934d.get(componentName);
            if (aVar != null) {
                c(aVar);
            }
        }

        public final void a() {
            Set<String> b2 = j.b(this.f931a);
            if (b2.equals(this.f935e)) {
                return;
            }
            this.f935e = b2;
            List<ResolveInfo> queryIntentServices = this.f931a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (b2.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f934d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f934d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f934d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public final boolean a(a aVar) {
            if (aVar.f937b) {
                return true;
            }
            boolean bindService = this.f931a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f936a), this, 33);
            aVar.f937b = bindService;
            if (bindService) {
                aVar.f940e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f936a);
                this.f931a.unbindService(this);
            }
            return aVar.f937b;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    public interface e {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public j(Context context) {
        this.f919a = context;
        this.f920b = (NotificationManager) context.getSystemService("notification");
    }

    public static j a(Context context) {
        return new j(context);
    }

    public void b() {
        this.f920b.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a(new a(this.f919a.getPackageName()));
        }
    }

    public void a(int i2) {
        a(null, i2);
    }

    public void a(String str, int i2) {
        this.f920b.cancel(str, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new a(this.f919a.getPackageName(), i2, str));
        }
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f914c) {
            if (string != null) {
                if (!string.equals(f915d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f916e = hashSet;
                    f915d = string;
                }
            }
            set = f916e;
        }
        return set;
    }

    /* compiled from: NotificationManagerCompat.java */
    public static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f921a;

        /* renamed from: b, reason: collision with root package name */
        public final int f922b;

        /* renamed from: c, reason: collision with root package name */
        public final String f923c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f924d;

        public a(String str) {
            this.f921a = str;
            this.f922b = 0;
            this.f923c = null;
            this.f924d = true;
        }

        @Override // a.h.a.j.e
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f924d) {
                iNotificationSideChannel.cancelAll(this.f921a);
            } else {
                iNotificationSideChannel.cancel(this.f921a, this.f922b, this.f923c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f921a + ", id:" + this.f922b + ", tag:" + this.f923c + ", all:" + this.f924d + "]";
        }

        public a(String str, int i2, String str2) {
            this.f921a = str;
            this.f922b = i2;
            this.f923c = str2;
            this.f924d = false;
        }
    }

    public void a(String str, int i2, Notification notification) {
        if (a(notification)) {
            a(new b(this.f919a.getPackageName(), i2, str, notification));
            this.f920b.cancel(str, i2);
        } else {
            this.f920b.notify(str, i2, notification);
        }
    }

    public boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return this.f920b.areNotificationsEnabled();
        }
        if (i2 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f919a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f919a.getApplicationInfo();
        String packageName = this.f919a.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod(CommonUtil.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(CommonUtil.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public static boolean a(Notification notification) {
        Bundle a2 = g.a(notification);
        return a2 != null && a2.getBoolean("android.support.useSideChannel");
    }

    public final void a(e eVar) {
        synchronized (f917f) {
            if (f918g == null) {
                f918g = new d(this.f919a.getApplicationContext());
            }
            f918g.b(eVar);
        }
    }
}
