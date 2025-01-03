package c.k.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.bugly.CrashModule;

/* loaded from: classes.dex */
public class v3 implements a4 {
    public final void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b2 = s3.b(stringExtra);
            if (!TextUtils.isEmpty(b2)) {
                t3.a(activity.getApplicationContext(), b2, 1007, "play with activity successfully");
                return;
            }
        }
        t3.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    @Override // c.k.d.a4
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            t3.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // c.k.d.a4
    public void a(Context context, w3 w3Var) {
        if (w3Var != null) {
            b(context, w3Var);
        } else {
            t3.a(context, "activity", 1008, "A receive incorrect message");
        }
    }

    public final void b(Context context, w3 w3Var) {
        String m516a = w3Var.m516a();
        String b2 = w3Var.b();
        String d2 = w3Var.d();
        int a2 = w3Var.a();
        if (context == null || TextUtils.isEmpty(m516a) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                t3.a(context, "activity", 1008, "argument error");
                return;
            } else {
                t3.a(context, d2, 1008, "argument error");
                return;
            }
        }
        if (!c.k.d.p9.d1.b(context, m516a, b2)) {
            t3.a(context, d2, 1003, "B is not ready");
            return;
        }
        t3.a(context, d2, 1002, "B is ready");
        t3.a(context, d2, CrashModule.MODULE_ID, "A is ready");
        Intent intent = new Intent(b2);
        intent.setPackage(m516a);
        intent.putExtra("awake_info", s3.a(d2));
        intent.addFlags(276824064);
        intent.setAction(b2);
        if (a2 == 1) {
            try {
                if (!x3.m523a(context)) {
                    t3.a(context, d2, 1008, "A not in foreground");
                    return;
                }
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
                t3.a(context, d2, 1008, "A meet a exception when help B's activity");
                return;
            }
        }
        context.startActivity(intent);
        t3.a(context, d2, 1005, "A is successful");
        t3.a(context, d2, 1006, "The job is finished");
    }
}
