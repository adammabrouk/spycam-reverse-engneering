package cn.jiguang.ap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final BroadcastReceiver f8294a = new BroadcastReceiver() { // from class: cn.jiguang.ap.g.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            try {
                cn.jiguang.ar.f.a("JOperateProccessHelper", "onReceive:" + intent);
                if (intent == null) {
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                if (!"cn.jiguang.joperate.to_main_process_action".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
                    return;
                }
                final String string = extras.getString(ContentCommon.TYPE);
                final Bundle bundle = extras.getBundle("bundle_data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                f.a(new Runnable() { // from class: cn.jiguang.ap.g.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(applicationContext.getApplicationContext(), string, bundle);
                    }
                }, new int[0]);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8295b = false;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f8296c;

    public static void a(Context context) {
        if (!f8295b && b(context)) {
            synchronized (g.class) {
                if (f8295b) {
                    return;
                }
                cn.jiguang.ar.f.a("JOperateProccessHelper", "init");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("cn.jiguang.joperate.to_main_process_action");
                context.registerReceiver(f8294a, intentFilter);
                f8295b = true;
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (context.getPackageName().equals(f.g(context))) {
            return;
        }
        cn.jiguang.ar.f.a("JOperateProccessHelper", "toMainProcess");
        Intent intent = new Intent("cn.jiguang.joperate.to_main_process_action");
        intent.setPackage(context.getPackageName());
        intent.putExtra(ContentCommon.TYPE, str);
        intent.putExtra("bundle_data", bundle);
        context.getApplicationContext().sendBroadcast(intent);
    }

    public static boolean b(Context context) {
        if (f8296c == null) {
            f8296c = Boolean.valueOf(context.getPackageName().equals(f.g(context)));
        }
        return f8296c.booleanValue();
    }
}
