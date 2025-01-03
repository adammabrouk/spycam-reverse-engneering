package c.k.d.p9;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import c.k.d.a7;
import c.k.d.f7;
import c.k.d.g9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    public static Context f7629c;

    /* renamed from: d, reason: collision with root package name */
    public static Object f7630d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7631e;

    /* renamed from: a, reason: collision with root package name */
    public String f7633a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f7628b = Log.isLoggable("NMHelper", 3);

    /* renamed from: f, reason: collision with root package name */
    public static WeakHashMap<Integer, k> f7632f = new WeakHashMap<>();

    public k(String str) {
        this.f7633a = str;
        b("create " + this);
    }

    public static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f7629c.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static NotificationManager a() {
        return (NotificationManager) f7629c.getSystemService("notification");
    }

    public static k a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        k kVar = f7632f.get(Integer.valueOf(hashCode));
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(str);
        f7632f.put(Integer.valueOf(hashCode), kVar2);
        return kVar2;
    }

    public static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static void a(Context context) {
        if (f7629c == null) {
            f7629c = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) c.k.d.f0.a(a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            c("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f7631e = booleanValue;
            if (booleanValue) {
                f7630d = c.k.d.f0.a(a2, "getService", new Object[0]);
            }
        }
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public static boolean m392a() {
        if (g9.m183a() && m.a(f7629c).a(a7.NotificationBelongToAppSwitch.a(), true)) {
            return f7631e;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m393a(Context context) {
        a(context);
        return m392a();
    }

    public static void c(String str) {
        c.k.a.a.a.c.m6a("NMHelper:" + str);
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public NotificationChannel m394a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m392a()) {
                List<NotificationChannel> m396a = m396a();
                if (m396a != null) {
                    for (NotificationChannel notificationChannel2 : m396a) {
                        if (str.equals(notificationChannel2.getId())) {
                            try {
                                b("getNotificationChannel succ:" + str);
                                notificationChannel = notificationChannel2;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                notificationChannel = notificationChannel2;
                                c("getNotificationChannel error" + e);
                                return notificationChannel;
                            }
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
        } catch (Exception e3) {
            e = e3;
        }
        return notificationChannel;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m395a(String str) {
        String str2;
        if (m392a()) {
            b("get cid new format");
            str2 = "mipush|%s|%s";
        } else {
            b("get cid old format");
            str2 = "mipush_%s_%s";
        }
        return String.format(str2, this.f7633a, str);
    }

    public String a(String str, String str2) {
        if (!m392a()) {
            str = str2;
        }
        b("group summary cid is " + str);
        return str;
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m396a() {
        String str;
        String str2 = this.f7633a;
        List<NotificationChannel> list = null;
        try {
            if (m392a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    List<NotificationChannel> list2 = (List) a(c.k.d.f0.a(f7630d, "getNotificationChannelsForPackage", str2, Integer.valueOf(a2), false));
                    try {
                        b("getNotificationChannels succ:" + list2);
                        str = "mipush|%s|%s";
                        list = list2;
                    } catch (Exception e2) {
                        e = e2;
                        list = list2;
                        c("getNotificationChannels error " + e);
                        return list;
                    }
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            b("getNotificationChannels filter before:" + list);
            if (g9.m183a() && list != null) {
                ArrayList arrayList = new ArrayList();
                String format = String.format(str, str2, "");
                for (NotificationChannel notificationChannel : list) {
                    if (notificationChannel.getId().startsWith(format)) {
                        arrayList.add(notificationChannel);
                    }
                }
                list = arrayList;
            }
            b("getNotificationChannels filter after:" + list);
        } catch (Exception e3) {
            e = e3;
        }
        return list;
    }

    public void a(int i2) {
        String str = this.f7633a;
        try {
            if (m392a()) {
                c.k.d.f0.b(f7630d, "cancelNotificationWithTag", str, null, Integer.valueOf(i2));
                b("cancel succ:" + i2);
            } else {
                a().cancel(i2);
            }
        } catch (Exception e2) {
            b("cancel error" + e2);
        }
    }

    public void a(int i2, Notification notification) {
        String str;
        String str2 = this.f7633a;
        NotificationManager a2 = a();
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (m392a()) {
                if (i3 >= 19) {
                    notification.extras.putString("xmsf_target_package", str2);
                    str = "notify succ:" + i2;
                } else {
                    str = "fwk support but api<19";
                }
                b(str);
                if (i3 >= 29) {
                    a2.notifyAsPackage(str2, null, i2, notification);
                    return;
                }
            }
            a2.notify(i2, notification);
        } catch (Exception e2) {
            b("notify error" + e2);
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f7633a;
        try {
            if (m392a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    c.k.d.f0.b(f7630d, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                    b("createNotificationChannel succ:" + notificationChannel);
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            c("createNotificationChannel error" + e2);
        }
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public void m397a(String str) {
        a().deleteNotificationChannel(str);
        b("deleteNotificationChannel succ " + str);
    }

    @TargetApi(23)
    public List<StatusBarNotification> b() {
        String str;
        String str2 = this.f7633a;
        NotificationManager a2 = a();
        try {
            if (m392a()) {
                int a3 = f7.a();
                r2 = a3 != -1 ? (List) a(c.k.d.f0.a(f7630d, "getAppActiveNotifications", str2, Integer.valueOf(a3))) : null;
                str = "getActiveNotifications succ:" + a3 + ":" + r2;
            } else {
                StatusBarNotification[] activeNotifications = a2.getActiveNotifications();
                b("getActiveNotifications filter before:" + Arrays.toString(activeNotifications));
                boolean m183a = g9.m183a();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (!m183a || str2.equals(l.a(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        r2 = arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        r2 = arrayList;
                        c("getActiveNotifications error " + e);
                        return r2;
                    }
                }
                str = "getActiveNotifications filter after:" + r2;
            }
            b(str);
        } catch (Exception e3) {
            e = e3;
        }
        return r2;
    }

    public void b(String str) {
        if (f7628b) {
            c(this.f7633a + "-->" + str);
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f7633a + "}";
    }
}
