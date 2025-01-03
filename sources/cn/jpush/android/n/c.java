package cn.jpush.android.n;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.at.e;
import cn.jpush.android.d.d;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends cn.jpush.android.r.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f9814b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f9815c;

    /* renamed from: d, reason: collision with root package name */
    public JPushMessageReceiver f9816d;

    public c(Context context, Intent intent, Object obj) {
        this.f9814b = context;
        this.f9815c = intent;
        this.f9816d = (JPushMessageReceiver) obj;
    }

    private void a(Context context, Intent intent, JPushMessageReceiver jPushMessageReceiver) {
        String str;
        d a2;
        if (intent == null || jPushMessageReceiver == null) {
            str = "intent or jPushMessageReceiver was null";
        } else {
            String action = intent.getAction();
            cn.jpush.android.r.b.b("JUnionReceiverAction", "do receiver action :" + action);
            if (action != null) {
                try {
                    a2 = cn.jpush.android.ax.a.a(context, intent);
                    cn.jpush.android.r.b.a("JUnionReceiverAction", "handleAction action: " + action + ", entity: " + a2);
                    switch (action) {
                        case "cn.jpush.android.intent.NOTIFY_INAPP_CANCEL":
                            cn.jpush.android.an.a.a().c(context, a2);
                            break;
                        case "cn.jpush.android.intent.IN_APP_MSG_ARRIVED_INTERVAL":
                            jPushMessageReceiver.onInAppMessageArrived(context, cn.jpush.android.ax.a.b(context, intent));
                            break;
                        case "cn.jpush.android.intent.IN_APP_MSG_CLICK_INTERVAL":
                            jPushMessageReceiver.onInAppMessageClick(context, cn.jpush.android.ax.a.b(context, intent));
                            break;
                        case "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL":
                            jPushMessageReceiver.onInAppMessageDismiss(context, cn.jpush.android.ax.a.b(context, intent));
                            break;
                        case "cn.jpush.android.intent.IN_APP_MSG_UN_SHOW_INTERVAL":
                            jPushMessageReceiver.onInAppMessageUnShow(context, cn.jpush.android.ax.a.b(context, intent));
                            break;
                        case "in_app_pull_result":
                            jPushMessageReceiver.onPullInAppResult(context, e.a().a(context, intent));
                            break;
                        case "cn.jpush.android.intent.ACTION_SYNC_ACTIVITY_TASK_CNT":
                            break;
                        case "cn.jpush.android.intent.SYNC_BLACK_LIST":
                            if (a2 != null) {
                                cn.jpush.android.at.b.a(context, a2.bu);
                                break;
                            }
                            break;
                        case "cn.jpush.android.intent.SYNC_ANI_CONFIG":
                            if (a2 != null) {
                                cn.jpush.android.at.a.a().a(context, a2.bv);
                                break;
                            }
                            break;
                        case "sync_reg_lifecycle":
                            if (a2 != null) {
                                cn.jpush.android.r.b.b("JUnionReceiverAction", "sync reg lifecycle, type: " + a2.r);
                                if (a2.r != 1) {
                                    cn.jpush.android.o.b.a(context);
                                    break;
                                } else {
                                    JPushConstants.init(context);
                                    break;
                                }
                            }
                            break;
                        case "cn.jpush.android.intent.DISPLAYED_STOP":
                            if (a2 != null) {
                                cn.jpush.android.an.a.a().a(context, a2.bq, a2.r);
                                break;
                            }
                            break;
                        case "load_nativ_ad_resp":
                            if (a2 != null && !TextUtils.isEmpty(a2.bG)) {
                                cn.jpush.android.ah.a.a().a(context, a2.bG);
                                break;
                            }
                            break;
                        case "ad_arrived_sdk":
                            if (a2 != null) {
                                cn.jpush.android.x.b.a(a2.f9700d, a2.by + "&" + a2.bw);
                                cn.jpush.android.x.b.b(a2.f9700d, a2.ax);
                                cn.jpush.android.an.a.a().b(context, a2);
                                break;
                            }
                            break;
                        case "ad_arrived_native":
                            if (a2 != null) {
                                cn.jpush.android.ah.a.a().b(context, new JSONObject(a2.bG).optString("msg_data"));
                                break;
                            }
                            break;
                        default:
                            cn.jpush.android.r.b.b("JUnionReceiverAction", "unknown action: " + action);
                            break;
                    }
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("JUnionReceiverAction", "Handle receiver action failed, e: " + th.getMessage());
                    return;
                }
            }
            str = "unsupport action type";
        }
        cn.jpush.android.r.b.f("JUnionReceiverAction", str);
    }

    @Override // cn.jpush.android.r.a
    public void a() {
        a(this.f9814b, this.f9815c, this.f9816d);
    }
}
