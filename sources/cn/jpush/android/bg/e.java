package cn.jpush.android.bg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.bg.b;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.SchedulerReceiver;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile e f9582a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList<a> f9583b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<a> f9584c;

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<a> f9585d = new Comparator<a>() { // from class: cn.jpush.android.bg.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            if (aVar.f9587a < aVar2.f9587a) {
                return -1;
            }
            return aVar.f9587a == aVar2.f9587a ? 0 : 1;
        }
    };

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f9587a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9588b;

        /* renamed from: c, reason: collision with root package name */
        public cn.jpush.android.d.d f9589c;

        /* renamed from: d, reason: collision with root package name */
        public int f9590d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f9591e;

        public a(long j, int i2) {
            this.f9587a = j;
            this.f9588b = false;
            this.f9590d = i2;
        }

        public a(long j, cn.jpush.android.d.d dVar, boolean z) {
            this.f9587a = j;
            this.f9588b = true;
            this.f9589c = dVar;
            this.f9591e = z;
        }

        public a(JSONObject jSONObject) {
            try {
                this.f9587a = jSONObject.getLong("operationTime");
                this.f9588b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.f9589c = cn.jpush.android.d.d.a(optString);
                }
                this.f9590d = jSONObject.optInt("notifyId");
            } catch (Throwable unused) {
            }
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.f9587a);
                jSONObject.put("showOrDismiss", this.f9588b);
                if (this.f9588b) {
                    jSONObject.put("pushEntity", this.f9589c != null ? this.f9589c.c() : null);
                } else {
                    jSONObject.put("notifyId", this.f9590d);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.f9587a + ", showOrDismiss=" + this.f9588b + ", pushEntity=" + this.f9589c + ", notifyId=" + this.f9590d + ", isDelayByInapp=" + this.f9591e + '}';
        }
    }

    public static e a() {
        if (f9582a == null) {
            synchronized (e.class) {
                if (f9582a == null) {
                    f9582a = new e();
                }
            }
        }
        return f9582a;
    }

    public static void a(Context context, LinkedList<a> linkedList, long j, a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        if (aVar.f9589c != null && TextUtils.equals(aVar.f9589c.H, "ssp")) {
            str = "ssp notification message";
        } else {
            if (aVar.f9587a > j) {
                linkedList.add(aVar);
                return;
            }
            if (!aVar.f9588b) {
                Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                b.d(context, aVar.f9590d);
                return;
            }
            if (aVar.f9589c == null || !d.a(context, aVar.f9589c.f9700d, aVar.f9589c.f9704h)) {
                long b2 = cn.jpush.android.bm.b.b(aVar.f9589c.at);
                int a2 = b.a(aVar.f9589c);
                if (b2 <= 0) {
                    Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                    b.a.a(context, aVar.f9589c);
                    return;
                }
                if (b2 <= j) {
                    Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                    b.d(context, a2);
                    return;
                }
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f9589c);
                linkedList.add(new a(b2, a2));
                return;
            }
            str = "item: " + aVar + " already cancel";
        }
        Logger.d("NotificationScheduler", str);
    }

    private void b(Context context, a aVar) {
        try {
            Logger.d("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, (Class<?>) SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1000, intent, 67108864);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setWindow(0, aVar.f9587a, 300L, broadcast);
                } else {
                    alarmManager.set(0, aVar.f9587a, broadcast);
                }
                Logger.d("NotificationScheduler", "setAlarm at=" + cn.jpush.android.bm.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.f9587a)));
            }
        } catch (Throwable th) {
            Logger.ww("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public void a(Context context) {
        this.f9583b = new LinkedList<>();
        if (this.f9584c == null) {
            this.f9584c = new LinkedList<>();
        }
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f9583b.add(new a(jSONArray.getJSONObject(i2)));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f9584c.size() > 0) {
            this.f9583b.addAll(this.f9584c);
            this.f9584c.clear();
            Collections.sort(this.f9583b, this.f9585d);
        }
    }

    public synchronized void a(Context context, a aVar) {
        a(context);
        LinkedList<a> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = aVar != null;
        Iterator<a> it = this.f9583b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (z && next.f9587a > aVar.f9587a) {
                a(context, linkedList, currentTimeMillis, aVar);
                z = false;
            }
            a(context, linkedList, currentTimeMillis, next);
        }
        if (z) {
            a(context, linkedList, currentTimeMillis, aVar);
        }
        this.f9583b = linkedList;
        b(context);
        if (!linkedList.isEmpty()) {
            b(context, linkedList.getFirst());
        }
    }

    public void b(Context context) {
        if (this.f9583b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.f9583b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f9591e) {
                    this.f9584c.add(next);
                } else {
                    jSONArray.put(next.a());
                }
            }
            String jSONArray2 = jSONArray.toString();
            Collections.sort(this.f9583b, this.f9585d);
            Sp.set(context, Key.NotiSchedule().set(jSONArray2));
        }
    }
}
