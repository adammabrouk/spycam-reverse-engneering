package cn.jiguang.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends cn.jiguang.l.a {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile c f8985c;

    /* renamed from: a, reason: collision with root package name */
    public Context f8986a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8987b;

    public static c a() {
        if (f8985c == null) {
            synchronized (c.class) {
                if (f8985c == null) {
                    f8985c = new c();
                }
            }
        }
        return f8985c;
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8986a = context;
        return "JDeviceBattery";
    }

    @Override // cn.jiguang.l.a
    public void b(Context context, String str) {
        if (cn.jiguang.h.a.a().f(1200)) {
            return;
        }
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + cn.jiguang.a.a.f8097a, null);
            if (registerReceiver == null) {
                return;
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            if (intExtra3 == 1) {
                intExtra3 = 0;
            } else if (intExtra3 == 2) {
                intExtra3 = 2;
            } else if (intExtra3 == 3 || intExtra3 == 4) {
                intExtra3 = 1;
            } else if (intExtra3 == 5) {
                intExtra3 = 3;
            }
            int intExtra4 = registerReceiver.getIntExtra("voltage", -1);
            int intExtra5 = registerReceiver.getIntExtra("temperature", -1);
            if (this.f8987b == null) {
                this.f8987b = new JSONObject();
            }
            this.f8987b.put("level", intExtra);
            this.f8987b.put("scale", intExtra2);
            this.f8987b.put("status", intExtra3);
            this.f8987b.put("voltage", intExtra4);
            this.f8987b.put("temperature", intExtra5);
            cn.jiguang.ai.a.a("JDeviceBattery", "collect success:" + this.f8987b);
            super.b(context, str);
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("JDeviceBattery", "packageJson exception: " + e2.getMessage());
        }
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        if (cn.jiguang.h.a.a().f(1200)) {
            return;
        }
        JSONObject jSONObject = this.f8987b;
        if (jSONObject == null) {
            cn.jiguang.ai.a.d("JDeviceBattery", "there are no data to report");
            return;
        }
        cn.jiguang.l.d.a(context, jSONObject, "battery");
        cn.jiguang.l.d.a(context, this.f8987b);
        super.d(context, str);
        this.f8987b = null;
    }
}
