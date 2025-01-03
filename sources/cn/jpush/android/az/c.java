package cn.jpush.android.az;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.ax.a;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.service.SchedulerReceiver;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f9452a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList<a> f9453b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<a> f9454c;

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<a> f9455d = new Comparator<a>() { // from class: cn.jpush.android.az.c.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            if (aVar.f9457a < aVar2.f9457a) {
                return -1;
            }
            return aVar.f9457a == aVar2.f9457a ? 0 : 1;
        }
    };

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f9457a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9458b;

        /* renamed from: c, reason: collision with root package name */
        public cn.jpush.android.d.d f9459c;

        /* renamed from: d, reason: collision with root package name */
        public int f9460d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f9461e;

        public a(long j, int i2) {
            this.f9457a = j;
            this.f9458b = false;
            this.f9460d = i2;
        }

        public a(long j, cn.jpush.android.d.d dVar, boolean z) {
            this.f9457a = j;
            this.f9458b = true;
            this.f9459c = dVar;
            this.f9461e = z;
        }

        public a(JSONObject jSONObject) {
            try {
                this.f9457a = jSONObject.getLong("operationTime");
                this.f9458b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.f9459c = cn.jpush.android.d.d.a(optString);
                }
                this.f9460d = jSONObject.optInt("notifyId");
            } catch (Throwable unused) {
            }
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.f9457a);
                jSONObject.put("showOrDismiss", this.f9458b);
                if (this.f9458b) {
                    jSONObject.put("pushEntity", this.f9459c != null ? this.f9459c.c() : null);
                } else {
                    jSONObject.put("notifyId", this.f9460d);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.f9457a + ", showOrDismiss=" + this.f9458b + ", pushEntity=" + this.f9459c + ", notifyId=" + this.f9460d + ", isDelayByInapp=" + this.f9461e + '}';
        }
    }

    public static c a() {
        if (f9452a == null) {
            synchronized (c.class) {
                if (f9452a == null) {
                    f9452a = new c();
                }
            }
        }
        return f9452a;
    }

    private void a(Context context, a aVar) {
        try {
            cn.jpush.android.r.b.b("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, (Class<?>) SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1000, intent, 67108864);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setWindow(0, aVar.f9457a, 300L, broadcast);
                } else {
                    alarmManager.set(0, aVar.f9457a, broadcast);
                }
                cn.jpush.android.r.b.b("NotificationScheduler", "setAlarm at=" + cn.jpush.android.bm.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.f9457a)));
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public static void a(Context context, LinkedList<a> linkedList, long j, a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        if (aVar.f9459c != null && !TextUtils.equals(aVar.f9459c.H, "ssp")) {
            str = "not ssp notification message";
        } else {
            if (aVar.f9457a > j) {
                linkedList.add(aVar);
                return;
            }
            if (!aVar.f9458b) {
                cn.jpush.android.r.b.b("NotificationScheduler", "cancelNotification:" + aVar);
                cn.jpush.android.ax.a.b(context, aVar.f9460d);
                return;
            }
            if (aVar.f9459c == null || !b.a(context, aVar.f9459c.f9700d, aVar.f9459c.f9704h)) {
                long b2 = cn.jpush.android.bm.b.b(aVar.f9459c.at);
                int a2 = cn.jpush.android.ax.a.a(aVar.f9459c);
                if (b2 <= 0) {
                    cn.jpush.android.r.b.b("NotificationScheduler", "handleNotification:" + aVar);
                    a.C0151a.a(context, aVar.f9459c);
                    return;
                }
                if (b2 <= j) {
                    cn.jpush.android.r.b.b("NotificationScheduler", "cancelNotification:" + aVar);
                    cn.jpush.android.ax.a.b(context, a2);
                    return;
                }
                cn.jpush.android.r.b.b("NotificationScheduler", "handleNotification:" + aVar);
                a.C0151a.a(context, aVar.f9459c);
                linkedList.add(new a(b2, a2));
                return;
            }
            str = "item: " + aVar + " already cancel";
        }
        cn.jpush.android.r.b.b("NotificationScheduler", str);
    }

    private void b() {
        LinkedList linkedList = new LinkedList();
        Iterator<a> it = this.f9453b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            cn.jpush.android.d.d dVar = next.f9459c;
            if (next.f9459c != null && TextUtils.equals(dVar.H, "ssp") && next.f9458b) {
                linkedList.add(next);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        cn.jpush.android.r.b.b("NotificationScheduler", "clear ssp cache, del_items: " + linkedList + ", list_size: " + this.f9453b.size());
        this.f9453b.removeAll(linkedList);
    }

    public void a(Context context) {
        this.f9453b = new LinkedList<>();
        if (this.f9454c == null) {
            this.f9454c = new LinkedList<>();
        }
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f9453b.add(new a(jSONArray.getJSONObject(i2)));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f9454c.size() > 0) {
            this.f9453b.addAll(this.f9454c);
            this.f9454c.clear();
            Collections.sort(this.f9453b, this.f9455d);
        }
    }

    public synchronized void a(Context context, a aVar, boolean z) {
        a(context);
        if (z) {
            b();
        }
        LinkedList<a> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = aVar != null;
        Iterator<a> it = this.f9453b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (z2 && next.f9457a > aVar.f9457a) {
                a(context, linkedList, currentTimeMillis, aVar);
                z2 = false;
            }
            a(context, linkedList, currentTimeMillis, next);
        }
        if (z2) {
            a(context, linkedList, currentTimeMillis, aVar);
        }
        this.f9453b = linkedList;
        b(context);
        if (!linkedList.isEmpty()) {
            a(context, linkedList.getFirst());
        }
    }

    public void b(Context context) {
        if (this.f9453b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.f9453b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f9461e) {
                    this.f9454c.add(next);
                } else {
                    jSONArray.put(next.a());
                }
            }
            String jSONArray2 = jSONArray.toString();
            Collections.sort(this.f9453b, this.f9455d);
            Sp.set(context, Key.NotiSchedule().set(jSONArray2));
        }
    }
}
