package cn.jpush.android.n;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.at.e;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.d.d;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.service.SchedulerReceiver;
import com.shix.shixipc.system.ContentCommon;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jpush.android.r.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f9805b;

    /* renamed from: c, reason: collision with root package name */
    public String f9806c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9807d;

    public a(Context context, String str, Object obj) {
        this.f9805b = context;
        this.f9806c = str;
        this.f9807d = obj;
        this.f9839a = "JUnionBaseAction";
    }

    public static JSONObject a(ByteBuffer byteBuffer) {
        try {
            byteBuffer.getLong();
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            String str = new String(bArr, StandardCharsets.UTF_8);
            cn.jpush.android.r.b.b("JUnionBaseAction", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            cn.jpush.android.r.b.f("JUnionBaseAction", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }

    public static void a(Context context) {
        new cn.jpush.android.ae.b().a(context);
    }

    public static void a(Context context, int i2, long j) {
        if (34 != i2) {
            cn.jpush.android.r.b.d("JUnionBaseAction", "not ad load timeout, cmd: " + i2);
            return;
        }
        if (e.a().a(j)) {
            e.a().a(context, j, JPushInterface.ErrorCode.TIMEOUT, 1, 30L);
            return;
        }
        try {
            d dVar = new d();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request_id", j);
            jSONObject.put("is_timeout", true);
            dVar.bG = jSONObject.toString();
            cn.jpush.android.ax.a.a(context, "load_nativ_ad_resp", dVar);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionBaseAction", "package load native response data failed, e: " + th.getMessage());
        }
    }

    private void a(Context context, Bundle bundle) {
        try {
            int i2 = bundle.getInt(ContentCommon.TYPE);
            int i3 = bundle.getInt(JThirdPlatFormInterface.KEY_CODE);
            String string = bundle.getString(JThirdPlatFormInterface.KEY_MSG);
            cn.jpush.android.r.b.b("JUnionBaseAction", "eventType:" + i2 + ",code:" + i3 + ",msg:" + string);
            if (i2 == -1) {
                cn.jpush.android.v.e.a().h(context);
                cn.jpush.android.at.c.a().c(context);
                return;
            }
            if (i2 == 1) {
                cn.jpush.android.at.c.a().b(context);
                cn.jpush.android.v.e.a().g(context);
                cn.jpush.android.an.a.a().b(context);
            } else if (i2 != 19) {
                if (i2 != 20002) {
                    return;
                }
                Sp.set(context, Key.SvrAniConfigSign().set(string));
                return;
            }
            a(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionBaseAction", "onEvent failed:" + th.getMessage());
        }
    }

    public static void a(Context context, JPushResponse jPushResponse) {
        String str;
        cn.jpush.android.r.b.c("JUnionBaseAction", "action:handleMsg:" + jPushResponse);
        if (jPushResponse == null) {
            return;
        }
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            cn.jpush.android.bi.c cVar = new cn.jpush.android.bi.c(jPushResponse);
            if (cn.jpush.android.cache.a.e(context)) {
                cn.jpush.android.r.b.b("JUnionBaseAction", "Push was stopped");
                return;
            } else {
                cn.jpush.android.w.b.a(context, cVar);
                return;
            }
        }
        if (cmd == 25) {
            JSONObject a2 = a(jPushResponse.getBody());
            if (a2 != null) {
                int optInt = a2.optInt("cmd");
                if (optInt == 59) {
                    a(context, a2);
                    cn.jpush.android.an.a.a().a(context, a2);
                    return;
                }
                if (optInt != 77) {
                    if (optInt != 78) {
                        cn.jpush.android.r.b.b("JUnionBaseAction", "Unknown command for ctrl");
                        return;
                    } else {
                        cn.jpush.android.at.c.a().a(context, a2);
                        return;
                    }
                }
                cn.jpush.android.v.e.a().a(context, a2);
                if (cn.jpush.android.u.a.c().isAllowRunningProcess() == null) {
                    cn.jpush.android.r.b.b("JUnionBaseAction", "receive heartbeat interval, alllowRP: true");
                    cn.jpush.android.u.a.c().setAllowRunningProcess(true);
                    return;
                }
                return;
            }
            return;
        }
        if (cmd != 34) {
            str = "Unknown command for parsing inbound.";
        } else {
            cn.jpush.android.y.a aVar = new cn.jpush.android.y.a(jPushResponse);
            long rquestId = jPushResponse.getRquestId();
            if (e.a().a(rquestId)) {
                e.a().a(context, rquestId, aVar.a(), aVar.c(), aVar.b());
                return;
            }
            try {
                d dVar = new d();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_id", rquestId);
                jSONObject.put("response_body", aVar.d());
                jSONObject.put("is_timeout", false);
                dVar.bG = jSONObject.toString();
                cn.jpush.android.ax.a.a(context, "load_nativ_ad_resp", dVar);
                return;
            } catch (Throwable th) {
                str = "package load native response data failed, e: " + th.getMessage();
            }
        }
        cn.jpush.android.r.b.f("JUnionBaseAction", str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Context context, String str, Object obj) {
        char c2;
        StringBuilder sb;
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        cn.jpush.android.r.b.d("JUnionBaseAction", "Handle action: " + str + ", data: " + obj);
        switch (str.hashCode()) {
            case -2087706805:
                if (str.equals("apk_download")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case -1571921725:
                if (str.equals("in_app_notify_msg")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -1446559778:
                if (str.equals("in_app_msg_handle")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -1295272964:
                if (str.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case -1200408345:
                if (str.equals("sync_fragment_life")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -1042706741:
                if (str.equals("display_status_sync")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case -806050815:
                if (str.equals("stop_display_in_app")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case -327074085:
                if (str.equals("load_api_result")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case -58429990:
                if (str.equals("msg_time_out")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3670:
                if (str.equals("si")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 108417:
                if (str.equals(JThirdPlatFormInterface.KEY_MSG)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3378882:
                if (str.equals("change_foreground_dy")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 31865564:
                if (str.equals("download_task")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 379684932:
                if (str.equals("save_config")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 564476281:
                if (str.equals("set_hb_period_enable")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 578301833:
                if (str.equals("trigger_in_app_event")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 732320569:
                if (str.equals("handle_life_resume")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 757328602:
                if (str.equals("ssp_neg_fb")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 833375383:
                if (str.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 858713394:
                if (str.equals("load_native_ad")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 976281776:
                if (str.equals("jcore_on_event")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1154033766:
                if (str.equals("in_app_req")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1420433891:
                if (str.equals("check_vas_integrate")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 1556577436:
                if (str.equals("in_app_display_state")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1755460374:
                if (str.equals("install_status")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1987834090:
                if (str.equals("handle_msg")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 2037297541:
                if (str.equals(SchedulerReceiver.DELAY_NOTIFY)) {
                    c2 = 2;
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
                if (obj instanceof JPushResponse) {
                    a(context, (JPushResponse) obj);
                    break;
                }
                break;
            case 1:
                if (bundle != null) {
                    a(context, bundle.getInt("cmd", -1), bundle.getLong("rid", -1L));
                    break;
                }
                break;
            case 2:
                cn.jpush.android.az.c.a().a(context, null, false);
                break;
            case 3:
                if (bundle != null) {
                    a(context, bundle);
                    break;
                }
                break;
            case 4:
                if (obj instanceof Intent) {
                    ((Intent) obj).getAction();
                    break;
                }
                break;
            case 5:
                e.a().a(context, bundle);
                break;
            case 6:
            case 24:
                break;
            case 7:
                if (bundle != null) {
                    int i2 = bundle.getInt("user_type");
                    boolean z = i2 > 0;
                    cn.jpush.android.o.b.f9824a = i2;
                    cn.jpush.android.o.b.a(z);
                    cn.jpush.android.v.e a2 = cn.jpush.android.v.e.a();
                    if (!z) {
                        a2.j(context);
                        if (!context.getPackageName().equals(cn.jpush.android.bm.a.d(context))) {
                            cn.jpush.android.an.a.a().a(context);
                            break;
                        }
                    } else {
                        a2.i(context);
                        break;
                    }
                } else {
                    cn.jpush.android.r.b.b("JUnionBaseAction", "Unexpected error bundle is null");
                    break;
                }
                break;
            case '\b':
                if (bundle != null) {
                    cn.jpush.android.o.b.f9826c = bundle.getBoolean("install_status");
                    sb = new StringBuilder();
                    sb.append("action: ");
                    sb.append(str);
                    sb.append(", supportInstall: ");
                    sb.append(cn.jpush.android.o.b.f9826c);
                    cn.jpush.android.r.b.b("JUnionBaseAction", sb.toString());
                    break;
                }
                break;
            case '\t':
                if (bundle != null) {
                    String string = bundle.getString(ContentCommon.TYPE);
                    if (!"config_info".equals(string)) {
                        if (!"config_state".equals(string)) {
                            "config_pkg_info".equals(string);
                            break;
                        } else {
                            cn.jpush.android.ar.d.a(context, bundle.getString("content"));
                            break;
                        }
                    } else {
                        String string2 = bundle.getString("content");
                        long j = bundle.getLong("display_time");
                        cn.jpush.android.r.b.b("JUnionBaseAction", "save config: in app content: " + string2 + ", displayTime: " + j);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(string2);
                        sb2.append(",");
                        sb2.append(j);
                        cn.jpush.android.cache.a.i(context, sb2.toString());
                        break;
                    }
                }
                break;
            case '\n':
                cn.jpush.android.r.b.b("JUnionBaseAction", "receive ssp fb intent action");
                cn.jpush.android.ax.b.a(context, bundle);
                break;
            case 11:
                cn.jpush.android.an.a.a().b(context, bundle);
                break;
            case '\f':
                cn.jpush.android.an.a.a().a(context, bundle);
                break;
            case '\r':
                if (bundle != null) {
                    d a3 = d.a(bundle.getString("content"));
                    if (a3 != null) {
                        cn.jpush.android.an.a.a().d(context, a3);
                        break;
                    }
                } else {
                    cn.jpush.android.r.b.f("JUnionBaseAction", "Unexpected data of bundle is null");
                    break;
                }
                break;
            case 14:
                if (bundle != null) {
                    int i3 = bundle.getInt(ContentCommon.TYPE);
                    if (i3 == 1) {
                        cn.jpush.android.ax.a.c(context);
                    } else if (i3 == 2) {
                        cn.jpush.android.ar.d.b(context);
                    }
                }
            case 15:
                cn.jpush.android.an.a.a().a(context, 2);
                break;
            case 16:
                if (bundle != null) {
                    cn.jpush.android.an.a.a().a(context, bundle.getString("activity_name"), bundle.getBoolean("state"));
                    break;
                }
                break;
            case 17:
                cn.jpush.android.at.c.a().b(context, bundle);
                break;
            case 18:
                cn.jpush.android.o.b.a(context, bundle);
                break;
            case 19:
                if (bundle != null) {
                    cn.jpush.android.at.c.a().a(context, bundle.getBoolean("enable"));
                    break;
                }
                break;
            case 20:
                if (bundle != null) {
                    cn.jpush.android.at.c.a().a(context, bundle.getString("event_name"));
                    break;
                }
                break;
            case 21:
                if (bundle != null) {
                    int i4 = bundle.getInt("ad_type");
                    if (bundle.getInt("render_type") == 1 && i4 == 2) {
                        cn.jpush.android.ah.a.a().a(context, bundle);
                        break;
                    }
                }
                break;
            case 22:
                if (obj instanceof d) {
                    cn.jpush.android.ar.d.b(this.f9805b, (d) obj);
                    break;
                }
                break;
            case 23:
                if (obj instanceof d) {
                    cn.jpush.android.ax.a.d(context, str, (d) obj);
                    break;
                }
                break;
            case 25:
                cn.jpush.android.ae.c.a(context, bundle);
                break;
            case 26:
                if (bundle != null) {
                    cn.jpush.android.v.e.a().a(context, bundle.getString("ad_slot"), bundle.getLong("interval_time"), bundle.getLong("delay_time"));
                    break;
                }
                break;
            default:
                sb = new StringBuilder();
                sb.append("Unknown action, ");
                sb.append(str);
                cn.jpush.android.r.b.b("JUnionBaseAction", sb.toString());
                break;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            cn.jpush.android.r.b.b("JUnionBaseAction", "dealCancelNotification ids=" + optString);
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    if (cn.jpush.android.az.b.a(context, str)) {
                        int a2 = cn.jpush.android.ax.a.a(str, 0);
                        cn.jpush.android.r.b.b("JUnionBaseAction", "message id:" + str + " is in local history ,try cancel notificationID : " + a2);
                        if (cn.jpush.android.ax.a.a(context, a2)) {
                            cn.jpush.android.ax.a.b(context, a2);
                            cn.jpush.android.l.c.a(context, split.length == 2 ? split[1] : str, 1068, 3);
                        }
                    } else {
                        cn.jpush.android.r.b.b("JUnionBaseAction", "dealCancelNotification , do nothing ");
                    }
                    linkedList.add(str);
                }
            }
            cn.jpush.android.az.b.a(context, linkedList);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionBaseAction", "dealCancelNotification e:" + th);
        }
    }

    @Override // cn.jpush.android.r.a
    public void a() {
        try {
            a(this.f9805b, this.f9806c, this.f9807d);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionBaseAction", "Handle action failed , error: " + th.getMessage());
        }
    }
}
