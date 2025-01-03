package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8031a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f8032b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8033c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f8034d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x3 f8035e;

    public y3(x3 x3Var, String str, Context context, String str2, String str3) {
        this.f8035e = x3Var;
        this.f8031a = str;
        this.f8032b = context;
        this.f8033c = str2;
        this.f8034d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        x3 x3Var;
        z3 z3Var;
        Context context3;
        if (TextUtils.isEmpty(this.f8031a)) {
            context = this.f8032b;
            str = LogUtils.NULL;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                t3.a(this.f8032b, this.f8031a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f8031a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.f8033c.equals(optString3) && this.f8034d.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f8035e.b(optString3);
                        this.f8035e.a(optString4);
                        w3 w3Var = new w3();
                        w3Var.b(optString);
                        w3Var.a(optString2);
                        w3Var.a(optInt);
                        w3Var.d(this.f8031a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                w3Var.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                x3Var = this.f8035e;
                                z3Var = z3.SERVICE_COMPONENT;
                                context3 = this.f8032b;
                            } else {
                                x3Var = this.f8035e;
                                z3Var = z3.SERVICE_ACTION;
                                context3 = this.f8032b;
                            }
                        } else if (z3.ACTIVITY.f131a.equals(optString5)) {
                            x3Var = this.f8035e;
                            z3Var = z3.ACTIVITY;
                            context3 = this.f8032b;
                        } else if (z3.PROVIDER.f131a.equals(optString5)) {
                            x3Var = this.f8035e;
                            z3Var = z3.PROVIDER;
                            context3 = this.f8032b;
                        } else {
                            context2 = this.f8032b;
                            str3 = this.f8031a;
                            str4 = "A receive a incorrect message with unknown type " + optString5;
                        }
                        x3Var.a(z3Var, context3, w3Var);
                        return;
                    }
                    context2 = this.f8032b;
                    str3 = this.f8031a;
                    str4 = "A receive a incorrect message with empty type";
                    t3.a(context2, str3, 1008, str4);
                    return;
                }
                t3.a(this.f8032b, this.f8031a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e2) {
                c.k.a.a.a.c.a(e2);
                context = this.f8032b;
                str = this.f8031a;
                str2 = "A meet a exception when receive the message";
            }
        }
        t3.a(context, str, 1008, str2);
    }
}
