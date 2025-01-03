package cn.jpush.android.bj;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.bm.e;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f9603a;

    /* renamed from: b, reason: collision with root package name */
    public cn.jpush.android.bj.b f9604b;

    /* renamed from: cn.jpush.android.bj.a$a, reason: collision with other inner class name */
    public class C0155a extends e {

        /* renamed from: b, reason: collision with root package name */
        public String f9606b;

        public C0155a(String str) {
            this.f9606b = str;
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            if (!TextUtils.isEmpty(this.f9606b)) {
                a.this.f9604b.a(this.f9606b);
                return;
            }
            Map<String, Integer> a2 = a.this.f9604b.a();
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            Sp.set(a.this.f9603a, Key.LastReportApiStatisticTime().set(Long.valueOf(System.currentTimeMillis())));
            if (c.a(a.this.f9603a, a2)) {
                a.this.f9604b.b();
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9607a = new a();
    }

    public a() {
    }

    public static final a a() {
        return b.f9607a;
    }

    public void a(Context context) {
        if (this.f9603a == null || this.f9604b == null) {
            Context applicationContext = context.getApplicationContext();
            this.f9603a = applicationContext;
            this.f9604b = new cn.jpush.android.bj.b(applicationContext);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(Context context, String str) {
        char c2;
        String str2;
        a(context);
        switch (str.hashCode()) {
            case -1589456679:
                if (str.equals("clear_all_notify")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1346339041:
                if (str.equals("set_mobile")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1258365551:
                if (str.equals("clear_by_id")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -834809288:
                if (str.equals("is_enable")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -653414577:
                if (str.equals("clear_local_notify")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -370069005:
                if (str.equals("geo_interval")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -98347653:
                if (str.equals("add_local_notify")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -63913041:
                if (str.equals("geo_fence_max_num")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 283445295:
                if (str.equals("delete_geo_fence")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 784590234:
                if (str.equals("go_settings")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1554655777:
                if (str.equals("rm_local_notify")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1833972392:
                if (str.equals("on_check")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                str2 = "JPushInterface#clearNotificationById";
                break;
            case 1:
                str2 = "JPushInterface#clearAllNotifications";
                break;
            case 2:
                str2 = "JPushInterface#setMobileNumber";
                break;
            case 3:
                str2 = "JPushInterface#addLocalNotification";
                break;
            case 4:
                str2 = "JPushInterface#removeLocalNotification";
                break;
            case 5:
                str2 = "JPushInterface#clearLocalNotifications";
                break;
            case 6:
                str2 = "JPushInterface#setGeofenceInterval";
                break;
            case 7:
                str2 = "JPushInterface#setMaxGeofenceNumber";
                break;
            case '\b':
                str2 = "JPushInterface#deleteGeofence";
                break;
            case '\t':
                str2 = "JPushInterface#goToAppNotificationSettings";
                break;
            case '\n':
                str2 = "JPushInterface#isNotificationEnabled";
                break;
            case 11:
                str2 = "JPushMessageReceiver#onNotificationSettingsCheck";
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Logger.d("JPushApiStatistics", "  statistic api =" + str2);
        JCoreHelper.normalExecutor(this.f9603a, null, new C0155a(str2));
    }

    public void b() {
        long longValue = ((Long) Sp.get(this.f9603a, Key.LastReportApiStatisticTime())).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - longValue);
        if (longValue == 0 || abs >= JConstants.DAY) {
            JCoreHelper.normalExecutor(this.f9603a, null, new C0155a(""));
            return;
        }
        Logger.dd("JPushApiStatistics", "Less 24 hours since the last report so return. lastTime=" + longValue + " currentTime=" + currentTimeMillis + " diffTime=" + abs);
    }
}
