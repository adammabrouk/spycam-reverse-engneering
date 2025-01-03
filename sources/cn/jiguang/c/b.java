package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ao.g;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.as.d;
import cn.jiguang.az.e;
import cn.jiguang.az.h;
import cn.jiguang.ba.c;
import cn.jiguang.e.f;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreHelperAction;
import cn.jpush.android.service.DataShare;
import com.shix.shixipc.utils.MyAudioPlayer;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends JCoreHelperAction {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8830b = {"JDevice", "JWakeCmd", "JWake", "JCommon", "JArp", "JLocation"};

    /* renamed from: c, reason: collision with root package name */
    public boolean f8832c = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8831a = false;

    public class a extends cn.jiguang.bj.b {

        /* renamed from: b, reason: collision with root package name */
        public Context f8834b;

        /* renamed from: c, reason: collision with root package name */
        public Intent f8835c;

        /* renamed from: d, reason: collision with root package name */
        public String f8836d;

        public a(Context context, Intent intent, String str) {
            this.f8834b = context;
            this.f8836d = str;
            this.f8835c = intent;
            this.f8813h = "JCoreHelper#PushReceiverAction";
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            try {
                ActionManager.getInstance().handleMessage(this.f8834b, this.f8836d, this.f8835c);
                b.this.a(this.f8834b, this.f8835c);
            } catch (Throwable th) {
                d.i("JCoreHelper", "[PushReceiverAction failed:]" + th.getMessage());
            }
        }
    }

    public static Bundle a(Context context, int i2, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i2 == 4096) {
                if (bundle != null) {
                    a(context, cn.jiguang.ao.a.a(bundle, "arg1"));
                }
                return bundle2;
            }
            if (i2 == 4098) {
                JCoreManager.init(context);
                return bundle2;
            }
            switch (i2) {
                case 36864:
                    a(bundle);
                    break;
                case 36865:
                    if (JCoreManager.isInternal()) {
                        JConstants.testAndroidQ();
                        break;
                    }
                    break;
            }
            return null;
        } catch (Throwable th) {
            d.i("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    public static Object a(Context context) {
        return e.a(context, "deviceinfo", null);
    }

    private Object a(Context context, String str, int i2) {
        boolean b2 = cn.jiguang.ao.d.b(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isServiceProcess", b2);
        d.c("JCoreHelper", "getDeviceInfoToService isServiceProcess：" + b2);
        if (b2) {
            Object a2 = e.a(context, "deviceinfo", null);
            d.c("JCoreHelper", "getDeviceInfoToService deviceInfoJson：" + a2);
            if (a2 instanceof JSONObject) {
                bundle.putString("de_inf", a2.toString());
            }
        } else {
            IDataShare dataShare = DataShare.getInstance(cn.jiguang.ao.d.a(context));
            if (dataShare != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("cmd_event_bundle_cmd", i2);
                if (str != null) {
                    bundle2.putString("cmd_event_bundle_sdk_type", str);
                }
                bundle = dataShare.execute("INTERNAL_API", "cmd_event_bundle", bundle2);
            }
        }
        d.c("JCoreHelper", "getDeviceInfoToService deviceInfoBundle：" + bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        Method declaredMethod;
        Boolean bool;
        boolean z;
        d.c("JCoreHelper", "[handleReceiverIntent]:" + intent.getAction());
        e.a(context, "get_receiver", intent);
        String action = intent.getAction();
        if (action == null) {
            d.g("JCoreHelper", "onReceive empty action");
            return;
        }
        if (action.equals("android.intent.action.USER_PRESENT")) {
            d.e("JCoreHelper", "onReceiveandroid.intent.action.USER_PRESENT");
            cn.jiguang.a.a.a(context, true, 0L);
            a(context, JConstants.SDK_TYPE, "user_present", (Bundle) null);
            return;
        }
        if (action.equals("android.intent.action.SCREEN_ON")) {
            cn.jiguang.a.a.a(context, false, 0L);
            return;
        }
        if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                d.g("JCoreHelper", "Not found networkInfo");
                return;
            }
            d.c("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
            if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                d.c("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (booleanExtra) {
                d.c("JCoreHelper", "No any network is connected");
                extras.putBoolean("connected", false);
            } else {
                try {
                    if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                        d.c("JCoreHelper", "Network is connected.");
                        extras.putBoolean("connected", true);
                    } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                        d.c("JCoreHelper", "Network is disconnected.");
                        extras.putBoolean("connected", false);
                    } else {
                        d.c("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    }
                } catch (Throwable unused) {
                    extras.putBoolean("connected", cn.jiguang.e.a.d(context));
                }
            }
            cn.jiguang.a.a.a(context, "tcp_a15", extras);
            return;
        }
        if (!action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") && !action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            if (action.equals("noti_open_proxy") && intent.getBooleanExtra("debug_notification", false)) {
                String stringExtra = intent.getStringExtra("toastText");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                Toast makeText = Toast.makeText(context, stringExtra, 0);
                try {
                    View view = makeText.getView();
                    if (view instanceof LinearLayout) {
                        View childAt = ((LinearLayout) view).getChildAt(0);
                        if (childAt instanceof TextView) {
                            TextView textView = (TextView) childAt;
                            if (!f.a(stringExtra)) {
                                textView.setText(stringExtra);
                            }
                            textView.setTextSize(13.0f);
                        }
                    }
                } catch (Exception unused2) {
                }
                makeText.show();
                return;
            }
            return;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            try {
                Class<?> cls = Class.forName("android.os.PowerManager");
                if (cls != null) {
                    if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                        Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                        if (declaredMethod2 != null) {
                            bool = (Boolean) declaredMethod2.invoke(powerManager, new Object[0]);
                            z = bool.booleanValue();
                        }
                        z = true;
                    } else {
                        if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                            bool = (Boolean) declaredMethod.invoke(powerManager, new Object[0]);
                            z = bool.booleanValue();
                        }
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    d.c("JCoreHelper", "doze or powersave mode exit.");
                    cn.jiguang.a.a.a(context, true, 0L);
                }
            } catch (Throwable th) {
                d.i("JCoreHelper", "handle DEVICE_IDLE_MODE_CHANGED or POWER_SAVE_MODE_CHANGED fail:" + th);
            }
        }
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return;
        }
        try {
            d.c("JCoreHelper", "setSDKConfigs");
            int i2 = 86400;
            try {
                int i3 = bundle.getInt("heartbeat_interval", JConstants.DEFAULT_HEARTBEAT_INTERVAL);
                if (i3 < 30) {
                    i3 = 30;
                } else if (i3 > 86400) {
                    i3 = 86400;
                }
                JConstants.DEFAULT_HEARTBEAT_INTERVAL = i3;
                d.c("JCoreHelper", "set heartbeat interval=" + i3);
            } catch (Throwable unused) {
            }
            try {
                int i4 = bundle.getInt("alarm_delay", JConstants.DEFAULT_ALARM_DELAY);
                if (i4 <= 86400) {
                    i2 = i4;
                }
                if (i2 < JConstants.DEFAULT_HEARTBEAT_INTERVAL + 5) {
                    i2 = JConstants.DEFAULT_HEARTBEAT_INTERVAL + 5;
                }
                JConstants.DEFAULT_ALARM_DELAY = i2;
                d.c("JCoreHelper", "set alarm delay=" + i2);
            } catch (Throwable unused2) {
            }
            byte b2 = (byte) bundle.getInt("tcp_algorithm", -1);
            if (b2 >= 0) {
                JConstants.tcpAlgorithm = b2;
                d.c("JCoreHelper", "set tcp algorithm=" + ((int) b2));
            }
            if (bundle.containsKey("tcp_report")) {
                cn.jiguang.au.f.f8380b = bundle.getBoolean("tcp_report");
            }
            if (bundle.containsKey("plugin_report_switch")) {
                context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_report_switch", bundle.getBoolean("plugin_report_switch")).apply();
            }
            if (bundle.containsKey("plugin_multi_switch")) {
                context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_multi_switch", bundle.getBoolean("plugin_multi_switch")).apply();
            }
            int i5 = bundle.getInt("ipv_config", -1);
            c.a(i5);
            if (i5 != 2 && i5 != 3) {
                if (i5 == 0 || i5 == 1) {
                    cn.jiguang.au.f.f8382d = true;
                    return;
                }
                return;
            }
            cn.jiguang.au.f.f8382d = false;
        } catch (Throwable unused3) {
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.ao.a.a(context, str);
    }

    public static void a(Context context, String str, int i2, int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt("custom", i2);
        bundle.putInt("dynamic", i3);
        bundle.putInt("sdk_v", i4);
        e.a(context, "set_sdktype_info", bundle);
    }

    public static void a(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.a(context, str, bundle);
    }

    public static void a(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString(ActionManager.SDK_TYPE, str);
            cn.jiguang.a.a.a(context, str2, bundle);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        d.d("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString(ActionManager.SDK_TYPE, str);
        bundle.putString("internal_action", str2);
        cn.jiguang.a.a.a(context, "a3", bundle);
    }

    public static void a(Bundle bundle) {
    }

    public static void a(String str, String str2, boolean z, int i2, String str3, Throwable th) {
        cn.jiguang.as.b.a(str, str2, z, i2, str3, th);
    }

    private Object b(Context context, String str, int i2) {
        boolean b2 = cn.jiguang.ao.d.b(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isServiceProcess", b2);
        d.c("JCoreHelper", "getLocInfoToService isServiceProcess：" + b2);
        if (b2) {
            Object a2 = e.a(context, "get_loc_info", null);
            if (a2 instanceof Bundle) {
                bundle = (Bundle) a2;
                bundle.putBoolean("isServiceProcess", true);
            }
        } else {
            IDataShare dataShare = DataShare.getInstance(cn.jiguang.ao.d.a(context));
            if (dataShare != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("cmd_event_bundle_cmd", i2);
                if (str != null) {
                    bundle2.putString("cmd_event_bundle_sdk_type", str);
                }
                bundle = dataShare.execute("INTERNAL_API", "cmd_event_bundle", bundle2);
            }
        }
        d.c("JCoreHelper", "getLocInfoToService locInfoBundle：" + bundle);
        return bundle;
    }

    public static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ActionManager.SDK_TYPE, str);
        cn.jiguang.a.a.a(context, "tcp_a8", bundle);
    }

    public static Pair<String, Long> c(Context context) {
        return cn.jiguang.ao.a.d(context);
    }

    public static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ActionManager.SDK_TYPE, str);
        cn.jiguang.a.a.a(context, "tcp_a9", bundle);
    }

    public static void c(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                boolean z = bundle.getBoolean("sdk_banned");
                d.c("JCoreHelper", "[handleSdkBannedStatusChanged] sdk banned: " + z);
                if (z) {
                    b(context, str);
                    cn.jiguang.bd.b.a().b(MyAudioPlayer.KEY_SAMPLE_RATE);
                } else {
                    c(context, str);
                }
            } catch (Throwable th) {
                d.g("JCoreHelper", "network change handler error, " + th.getMessage());
            }
        }
    }

    public static void d(Context context, String str, Bundle bundle) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (bundle != null) {
            try {
                d.c("JCoreHelper", "[handleConnectionChanged] connected: " + bundle.getBoolean("connected"));
            } catch (Throwable th) {
                d.g("JCoreHelper", "network change handler error, " + th.getMessage());
                return;
            }
        }
        Intent intent = new Intent();
        intent.setAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            intent.putExtra("networkInfo", activeNetworkInfo);
            d.c("JCoreHelper", "networkInfo, available: " + activeNetworkInfo.isAvailable() + ", type: " + activeNetworkInfo.getType());
        }
        ActionManager.getInstance().handleMessage(context, str, intent);
        cn.jiguang.a.a.a(context, "tcp_a15", bundle);
    }

    public void a(Context context, boolean z, int i2) {
        d.c("JCoreHelper", "changeForegroudStat:" + z + ", userActiveType:" + i2);
        this.f8831a = z;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", this.f8831a);
        bundle.putInt("user_type", i2);
        cn.jiguang.a.a.a(context, "a4", bundle);
        if (this.f8831a) {
            cn.jiguang.ap.e.a(context, 3);
        } else {
            this.f8832c = true;
            cn.jiguang.ap.e.a(context);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.b(context, str, bundle);
    }

    public boolean b(Context context) {
        try {
            Bundle a2 = cn.jiguang.ao.e.a().a(context, "INTERNAL_API", "isTcpLoggedIn", null, cn.jiguang.ao.d.a(context));
            return (a2 == null || !a2.containsKey("state")) ? h.a().d() : a2.getBoolean("state");
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Bundle directHandle(Context context, String str, String str2, Bundle bundle) {
        return cn.jiguang.ao.e.a().b(context, str, str2, bundle);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Object onCommonMethod(Context context, String str, Object obj) {
        return e.a(context, str, obj);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Object onEvent(Context context, String str, int i2, String str2, Bundle bundle, Object... objArr) {
        Runnable runnable;
        Runnable runnable2;
        Object obj;
        String str3;
        char c2;
        Throwable th;
        Bundle bundle2;
        String str4;
        boolean z;
        try {
            if (cn.jiguang.ao.f.a()) {
                return i2 == 82 ? true : null;
            }
            if (g.a()) {
                return null;
            }
            Context appContext = JConstants.getAppContext(context);
            String str5 = "SCHEDULE_TASK";
            String str6 = "NORMAL_TASK";
            String str7 = "MAJOR_TASK";
            boolean z2 = false;
            switch (i2) {
                case 0:
                    b(appContext, str);
                    return null;
                case 1:
                    c(appContext, str);
                    return null;
                case 2:
                    b(appContext, str2, bundle);
                    return null;
                case 3:
                    a(appContext, str, str2, bundle);
                    return null;
                case 4:
                    return cn.jiguang.d.a.b(appContext);
                case 5:
                    return cn.jiguang.d.a.d(appContext);
                case 6:
                    return cn.jiguang.d.a.g(appContext);
                case 7:
                    return cn.jiguang.d.a.e(appContext);
                case 8:
                    return cn.jiguang.d.a.h(appContext);
                case 9:
                    a(appContext, str2);
                    return null;
                case 10:
                    a(appContext, str2, bundle);
                    cn.jiguang.b.c.a(appContext);
                    return null;
                case 11:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    if (TextUtils.isEmpty(str) || !str.toLowerCase().equals("jpush")) {
                        if (!Arrays.asList(f8830b).contains(str2)) {
                            str5 = str2;
                        }
                        str7 = str5;
                    }
                    runnable = (Runnable) objArr[0];
                    cn.jiguang.bj.d.a(str7, runnable);
                    return null;
                case 12:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("jpush")) {
                        str6 = "MAJOR_TASK";
                    }
                    runnable2 = (Runnable) objArr[0];
                    cn.jiguang.bj.d.a(str6, runnable2);
                    return null;
                case 13:
                case 32:
                case 33:
                case 64:
                case 65:
                case 69:
                case 87:
                default:
                    return null;
                case 14:
                    obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
                    cn.jiguang.au.f.a(appContext, str, obj);
                    return null;
                case 15:
                    if (objArr == null || objArr.length <= 1 || !(objArr[1] instanceof ReportCallBack)) {
                        return null;
                    }
                    cn.jiguang.au.f.a(appContext, (JSONObject) objArr[0], (ReportCallBack) objArr[1]);
                    return null;
                case 16:
                    str3 = "tcp_a3";
                    a(appContext, str, bundle, str3);
                    return null;
                case 17:
                    str3 = "tcp_a5";
                    a(appContext, str, bundle, str3);
                    return null;
                case 18:
                    if (objArr == null || objArr.length <= 2) {
                        return null;
                    }
                    if (objArr.length <= 3 || !(objArr[3] instanceof Throwable)) {
                        c2 = 1;
                        th = null;
                    } else {
                        th = (Throwable) objArr[3];
                        c2 = 1;
                    }
                    a(str, str2, ((Boolean) objArr[c2]).booleanValue(), ((Integer) objArr[0]).intValue(), (String) objArr[2], th);
                    return null;
                case 19:
                    return (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) ? Long.valueOf(cn.jiguang.d.b.b(appContext)) : Long.valueOf(cn.jiguang.d.b.a(appContext, ((Long) objArr[0]).longValue()));
                case 20:
                    return Long.valueOf(cn.jiguang.d.a.f(appContext));
                case 21:
                    return Boolean.valueOf(cn.jiguang.d.b.a(appContext));
                case 22:
                    cn.jiguang.f.b.a(appContext, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.o().a((cn.jiguang.f.a<String>) str2)});
                    return null;
                case 23:
                    JConstants.testCountry = str2;
                    return null;
                case 24:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    new Bundle().putInt("cmd", ((Integer) objArr[0]).intValue());
                    a(appContext, JConstants.SDK_TYPE, "old_cmd", (Bundle) null);
                    return null;
                case 25:
                    return Integer.valueOf(cn.jiguang.a.a.f8099c);
                case 26:
                    if (objArr != null && objArr.length > 1 && (objArr[0] instanceof JSONObject) && (objArr[1] == null || (objArr[1] instanceof String))) {
                        return cn.jiguang.d.a.a(appContext, (JSONObject) objArr[0], (String) objArr[1]);
                    }
                    break;
                case 27:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Boolean)) {
                        return null;
                    }
                    bundle2 = new Bundle();
                    bundle2.putBoolean("enable", ((Boolean) objArr[0]).booleanValue());
                    str4 = "lbsenable";
                    a(appContext, JConstants.SDK_TYPE, str4, bundle2);
                    return null;
                case 28:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                        return null;
                    }
                    bundle2 = new Bundle();
                    bundle2.putLong("forenry", ((Long) objArr[0]).longValue());
                    str4 = "lbsforenry";
                    a(appContext, JConstants.SDK_TYPE, str4, bundle2);
                    return null;
                case 29:
                    str4 = "notification_state";
                    if (objArr == null) {
                        return null;
                    }
                    if (!(objArr[0] instanceof Integer) || !(objArr.length > 0)) {
                        return null;
                    }
                    bundle2 = new Bundle();
                    bundle2.putInt("scence", ((Integer) objArr[0]).intValue());
                    a(appContext, JConstants.SDK_TYPE, str4, bundle2);
                    return null;
                case 30:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    return a(appContext, ((Integer) objArr[0]).intValue(), bundle);
                case 31:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Intent)) {
                        return null;
                    }
                    cn.jiguang.bj.d.a("MAJOR_TASK", new a(appContext, (Intent) objArr[0], str));
                    return null;
                case 34:
                    return cn.jiguang.d.a.i(appContext);
                case 35:
                    if (objArr == null || objArr.length <= 2 || !(objArr[0] instanceof Long) || !(objArr[1] instanceof String) || !(objArr[2] instanceof String)) {
                        return null;
                    }
                    cn.jiguang.f.b.b(appContext, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.c().a((cn.jiguang.f.a<Long>) Long.valueOf(((Long) objArr[0]).longValue())), cn.jiguang.f.a.f().a((cn.jiguang.f.a<String>) objArr[1]), cn.jiguang.f.a.d().a((cn.jiguang.f.a<String>) objArr[2]), cn.jiguang.f.a.e().a((cn.jiguang.f.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                    return null;
                case 36:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                        return null;
                    }
                    cn.jiguang.bk.c.a(appContext, (String) objArr[0]);
                    return null;
                case 37:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                        return null;
                    }
                    cn.jiguang.d.b.b(appContext, ((Long) objArr[0]).longValue());
                    return null;
                case 38:
                    cn.jiguang.f.b.a(appContext, "cn.jiguang.sdk.user.profile");
                    return null;
                case 39:
                    cn.jiguang.au.f.a(appContext, objArr != null ? objArr[0] : null);
                    return null;
                case 40:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof Boolean) || !(objArr[1] instanceof Long)) {
                        return null;
                    }
                    cn.jiguang.a.a.a(appContext, ((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue());
                    return null;
                case 41:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof JSONObject)) {
                        return null;
                    }
                    return Boolean.valueOf(cn.jiguang.au.f.a(appContext, (String) objArr[0], (JSONObject) objArr[1]));
                case 42:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                        return null;
                    }
                    return cn.jiguang.d.a.a(appContext, (String) objArr[0]);
                case 43:
                    return cn.jiguang.d.a.a();
                case 44:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof Long)) {
                        return null;
                    }
                    cn.jiguang.f.b.a(appContext, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.k().a((cn.jiguang.f.a<String>) objArr[0]), cn.jiguang.f.a.l().a((cn.jiguang.f.a<Long>) Long.valueOf(((Long) objArr[1]).longValue()))});
                    return null;
                case 45:
                    return cn.jiguang.d.a.j(appContext);
                case 46:
                    return Integer.valueOf(cn.jiguang.d.a.k(appContext));
                case 47:
                    return Integer.valueOf(cn.jiguang.d.a.m(appContext));
                case 48:
                    cn.jiguang.au.d.a(appContext);
                    return null;
                case 49:
                    return true;
                case 50:
                    str3 = "tcp_a4";
                    a(appContext, str, bundle, str3);
                    return null;
                case 51:
                    if (objArr == null || objArr.length != 1 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    cn.jiguang.f.b.a(appContext, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.h().a((cn.jiguang.f.a<Integer>) Integer.valueOf(((Integer) objArr[0]).intValue()))});
                    return null;
                case 52:
                    a(bundle);
                    return null;
                case 53:
                    return Boolean.valueOf(cn.jiguang.ao.c.a().a(appContext));
                case 54:
                    if (objArr == null || objArr.length <= 2) {
                        return null;
                    }
                    String str8 = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    int intValue2 = ((Integer) objArr[2]).intValue();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("name", str8);
                    bundle3.putInt("custom", intValue);
                    bundle3.putInt("dynamic", intValue2);
                    e.a(appContext, "set_sdktype_info", bundle3);
                    return null;
                case 55:
                    a(appContext, bundle);
                    return null;
                case 56:
                    if ("resume".equals(str2)) {
                        if (!JConstants.isInstrumentationHookFailed) {
                            return null;
                        }
                        PushSA.getInstance().onResume(appContext);
                        return null;
                    }
                    if ("pause".equals(str2)) {
                        if (!JConstants.isInstrumentationHookFailed) {
                            return null;
                        }
                        PushSA.getInstance().onPause(appContext);
                        return null;
                    }
                    if ("kill".equals(str2)) {
                        PushSA.getInstance().onKillProcess(appContext);
                        return null;
                    }
                    if ("enable".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Boolean)) {
                            return null;
                        }
                        PushSA.getInstance().setStatEnable(((Boolean) objArr[0]).booleanValue());
                        return null;
                    }
                    if ("s_timeout".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                            return null;
                        }
                        PushSA.getInstance().setInterval(((Long) objArr[0]).longValue());
                        return null;
                    }
                    if ("f_resume".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                            return null;
                        }
                        PushSA.getInstance().onFragmentResume(appContext, (String) objArr[0]);
                        return null;
                    }
                    if (!"f_pause".equals(str2) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                        return null;
                    }
                    PushSA.getInstance().onFragmentPause(appContext, (String) objArr[0]);
                    return null;
                case 57:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    d.c("JCoreHelper", "SET_SHARE_PROCESS_STATE state:" + objArr[0]);
                    cn.jiguang.f.b.a(appContext, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.m().a((cn.jiguang.f.a<Integer>) Integer.valueOf(((Integer) objArr[0]).intValue()))});
                    return null;
                case 58:
                    return Boolean.valueOf(cn.jiguang.d.a.l(appContext));
                case 59:
                    str3 = "tcp_a20";
                    a(appContext, str, bundle, str3);
                    return null;
                case 60:
                    String str9 = "unknown msg";
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z2 = ((Boolean) objArr[0]).booleanValue();
                    }
                    if (objArr != null && objArr.length > 1 && (objArr[1] instanceof String)) {
                        str9 = (String) objArr[1];
                    }
                    return Boolean.valueOf(JConstants.isAndroidQ(appContext, z2, str9));
                case 61:
                    if (objArr == null || objArr.length <= 7) {
                        return null;
                    }
                    cn.jiguang.au.f.a(appContext, ((Integer) objArr[0]).intValue(), (JSONObject) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (File) objArr[4], (Set) objArr[5], (ReportCallBack) objArr[6], (String) objArr[7]);
                    return null;
                case 62:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    cn.jiguang.ao.e.a().a(appContext, (String) objArr[0], str2, bundle);
                    return null;
                case 63:
                    if (objArr == null || objArr.length <= 1) {
                        return null;
                    }
                    return cn.jiguang.ao.e.a().a(appContext, (String) objArr[0], str2, bundle, (String) objArr[1]);
                case 66:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    if (JConstants.SDK_VERSION_INT < 250 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                        d.c("JCoreHelper", "old change fore:" + z);
                        a(appContext, z, -1);
                    } else {
                        if (JConstants.SDK_VERSION_INT < 250 || !(objArr[0] instanceof Integer)) {
                            d.c("JCoreHelper", "unkown change fore");
                            return null;
                        }
                        int intValue3 = ((Integer) objArr[0]).intValue();
                        d.c("JCoreHelper", "new change fore:" + intValue3);
                        boolean z3 = intValue3 != 0;
                        a(appContext, z3, intValue3);
                        z = z3;
                    }
                    if (!z) {
                        obj = null;
                        cn.jiguang.au.f.a(appContext, (Object) null);
                        cn.jiguang.au.f.a(appContext, str, obj);
                        return null;
                    }
                    cn.jiguang.a.a.a(appContext, false, 0L);
                    bundle2 = new Bundle();
                    bundle2.putInt("scence", 1);
                    str4 = "notification_state";
                    a(appContext, JConstants.SDK_TYPE, str4, bundle2);
                    return null;
                case 67:
                    return Boolean.valueOf(b(appContext));
                case 68:
                    return e.a(appContext, "deviceinfo", null);
                case 70:
                    cn.jiguang.b.a.a().a(appContext);
                    return null;
                case 71:
                    cn.jiguang.b.a.a().b(appContext);
                    return null;
                case 72:
                    if (objArr == null || objArr.length != 4 || !(objArr[0] instanceof String) || !(objArr[1] instanceof Integer) || !(objArr[2] instanceof Integer)) {
                        return null;
                    }
                    a(appContext, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                    return null;
                case 73:
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putBoolean("enable", ((Boolean) objArr[0]).booleanValue());
                        a(appContext, JConstants.SDK_TYPE, "set_wake_enable", bundle4);
                    }
                    break;
                case 74:
                    if (bundle == null) {
                        return null;
                    }
                    e.a(appContext, "waked", bundle);
                    return null;
                case 75:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    runnable = (Runnable) objArr[0];
                    cn.jiguang.bj.d.a(str7, runnable);
                    return null;
                case 76:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    cn.jiguang.bj.d.a("FUTURE_TASK", (Runnable) objArr[0]);
                    return null;
                case 77:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    runnable2 = (Runnable) objArr[0];
                    cn.jiguang.bj.d.a(str6, runnable2);
                    return null;
                case 78:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    cn.jiguang.bj.d.a("SCHEDULE_TASK", (Runnable) objArr[0]);
                    return null;
                case 79:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof String)) {
                        return null;
                    }
                    return Boolean.valueOf(cn.jiguang.e.c.a(appContext, (String) objArr[0], (String) objArr[1]));
                case 80:
                    d(appContext, str, bundle);
                    return null;
                case 81:
                    c(appContext, str, bundle);
                    return null;
                case 82:
                    return false;
                case 83:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof Runnable) || !(objArr[1] instanceof Integer)) {
                        return null;
                    }
                    cn.jiguang.bj.d.a("DELAY_TASK", (Runnable) objArr[0], ((Integer) objArr[1]).intValue());
                    return null;
                case 84:
                case 85:
                    return "";
                case 86:
                    return cn.jiguang.ao.b.a(appContext);
                case 88:
                    if (objArr == null || objArr.length <= 0 || JConstants.SDK_VERSION_INT <= 284) {
                        return null;
                    }
                    cn.jiguang.az.b.a().a(appContext, 20002, 0, (String) objArr[0]);
                    return null;
                case 89:
                case 90:
                    return cn.jiguang.ap.e.a(appContext, str2, bundle);
                case 91:
                    return b(appContext, str, i2);
                case 92:
                    return cn.jiguang.a.a.f8098b;
                case 93:
                    if (objArr == null || objArr.length < 2 || !(objArr[0] instanceof Thread) || !(objArr[1] instanceof Throwable)) {
                        return null;
                    }
                    cn.jiguang.bf.h.a().a((Thread) objArr[0], (Throwable) objArr[1]);
                    return null;
                case 94:
                    return a(appContext, str, i2);
                case 95:
                    return Boolean.valueOf(new cn.jiguang.bh.d(appContext).a());
                case 96:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Boolean)) {
                        return null;
                    }
                    cn.jiguang.bk.a.a(((Boolean) objArr[0]).booleanValue());
                    return null;
            }
        } catch (Throwable th2) {
            d.g("JCoreHelper", "onEvent:" + th2);
            return null;
        }
    }
}
