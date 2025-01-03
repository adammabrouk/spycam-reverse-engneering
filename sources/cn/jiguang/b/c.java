package cn.jiguang.b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import cn.jiguang.as.d;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8618a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f8619b;

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public Context f8620a;

        public a(Context context) {
            super(Looper.getMainLooper());
            this.f8620a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (1 == message.what) {
                    c.c(this.f8620a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(Context context) {
        boolean equals;
        synchronized (c.class) {
            try {
                equals = context.getPackageName().equals(cn.jiguang.e.a.a(context));
                d.c("ScreenRegister", "registerReceiver isCurProcess:" + equals);
            } catch (Throwable unused) {
            }
            if (equals) {
                if (f8618a) {
                    return;
                }
                f8618a = true;
                f8619b = new a(context);
                String str = context.getPackageName() + cn.jiguang.a.a.f8097a;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: cn.jiguang.b.c.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (intent == null) {
                            return;
                        }
                        try {
                            d.c("ScreenRegister", "onReceive Action:" + intent.getAction());
                            if (c.f8619b != null) {
                                c.f8619b.removeMessages(1);
                                c.f8619b.sendEmptyMessageDelayed(1, 2000L);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }, intentFilter, str, null);
            }
        }
    }

    public static void c(Context context) {
        boolean isScreenOn = ((PowerManager) context.getSystemService("power")).isScreenOn();
        d.c("ScreenRegister", "onReceive isScreenOn:" + isScreenOn);
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        d.c("ScreenRegister", "onReceive flag:" + inKeyguardRestrictedInputMode);
        boolean z = isScreenOn && !inKeyguardRestrictedInputMode;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceive status:");
        sb.append(z ? "开" : "锁");
        d.c("ScreenRegister", sb.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = cn.jiguang.d.a.a(context, jSONObject, "sc_status");
        jSONObject.put("status", z);
        d.c("ScreenRegister", "onReceive jsonObject:" + a2);
        cn.jiguang.d.a.a(context, a2);
    }
}
