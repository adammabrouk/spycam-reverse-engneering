package c.k.d.p9;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import c.k.d.a7;
import c.k.d.g9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static h f7590a = new h();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public List<b> f7591a;

        /* renamed from: b, reason: collision with root package name */
        public List<b> f7592b;

        public a(h hVar) {
            this.f7591a = new ArrayList();
            this.f7592b = new ArrayList();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f7593a;

        /* renamed from: b, reason: collision with root package name */
        public Notification f7594b;

        public b(h hVar, int i2, Notification notification) {
            this.f7593a = i2;
            this.f7594b = notification;
        }

        public String toString() {
            return "id:" + this.f7593a;
        }
    }

    public static h a() {
        return f7590a;
    }

    public final int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public final String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m378a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    public final List<StatusBarNotification> a(k kVar) {
        List<StatusBarNotification> b2 = kVar != null ? kVar.b() : null;
        if (b2 == null || b2.size() == 0) {
            return null;
        }
        return b2;
    }

    public void a(Context context, int i2, Notification notification) {
        if (m378a()) {
            if (a(context)) {
                try {
                    b(context, i2, notification);
                } catch (Exception e2) {
                    c.k.a.a.a.c.m6a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i2, notification, true);
                } catch (Exception e3) {
                    c.k.a.a.a.c.m6a("group notify handle auto error " + e3);
                }
            }
        }
    }

    public final void a(Context context, int i2, Notification notification, boolean z) {
        String str;
        String a2 = l.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group auto not extract pkg from notification:" + i2;
        } else {
            k a3 = k.a(context, a2);
            List<StatusBarNotification> a4 = a(a3);
            if (a4 != null) {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a4) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i2) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !m380b(notification)) {
                            (m379a(notification) ? value.f7592b : value.f7591a).add(new b(this, i2, notification));
                        }
                        int size = value.f7591a.size();
                        if (value.f7592b.size() <= 0) {
                            if (size >= 2) {
                                a(context, a2, key, value.f7591a.get(0).f7594b);
                            }
                        } else if (size <= 0) {
                            a(context, a2, key);
                        } else if (size >= 2 && !a(context)) {
                            b bVar = value.f7592b.get(0);
                            c.k.a.a.a.c.b("group refresh:" + bVar);
                            bVar.f7594b.when = System.currentTimeMillis();
                            a3.a(bVar.f7593a, bVar.f7594b);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        c.k.a.a.a.c.m6a(str);
    }

    public final void a(Context context, String str, String str2) {
        c.k.a.a.a.c.b("group cancel summary:" + str2);
        k.a(context, str).a(a(str, str2));
    }

    public final void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                c.k.a.a.a.c.m6a("group show summary group is null");
                return;
            }
            int a2 = l.a(context, str);
            if (a2 == 0) {
                c.k.a.a.a.c.m6a("group show summary not get icon from " + str);
                return;
            }
            k a3 = k.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String a4 = a3.a(notification.getChannelId(), "groupSummary");
                NotificationChannel m394a = a3.m394a(a4);
                if ("groupSummary".equals(a4) && m394a == null) {
                    a3.a(new NotificationChannel(a4, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, a4);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!g9.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                l.a(build, str);
            }
            int a5 = a(str, str2);
            a3.a(a5, build);
            c.k.a.a.a.c.b("group show summary notify:" + a5);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("group show summary error " + e2);
        }
    }

    public final void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (m379a(statusBarNotification.getNotification()) ? aVar.f7592b : aVar.f7591a).add(new b(this, statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m378a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m379a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a2 = c.k.d.f0.a(notification, "isGroupSummary", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    public final boolean a(Context context) {
        if (b(context) && k.m393a(context)) {
            return m.a(context).a(a7.LatestNotificationNotIntoGroupSwitch.a(), true);
        }
        return false;
    }

    public final String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m380b(notification) ? a(notification) : notification.getGroup();
    }

    public final void b(Context context, int i2, Notification notification) {
        String str;
        String a2 = l.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group restore not extract pkg from notification:" + i2;
        } else {
            k a3 = k.a(context, a2);
            List<StatusBarNotification> a4 = a(a3);
            if (a4 != null) {
                for (StatusBarNotification statusBarNotification : a4) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && m380b(notification2) && statusBarNotification.getId() != i2) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        a3.a(statusBarNotification.getId(), recoverBuilder.build());
                        c.k.a.a.a.c.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        c.k.a.a.a.c.m6a(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public final boolean m380b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    public final boolean b(Context context) {
        return m.a(context).a(a7.NotificationAutoGroupSwitch.a(), true);
    }
}
