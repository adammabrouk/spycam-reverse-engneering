package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.union.ads.api.JUnionAdError;
import com.tencent.bugly.CrashModule;

/* loaded from: classes.dex */
public class c4 implements a4 {
    @Override // c.k.d.a4
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // c.k.d.a4
    public void a(Context context, w3 w3Var) {
        if (w3Var != null) {
            b(context, w3Var);
        } else {
            t3.a(context, "provider", 1008, "A receive incorrect message");
        }
    }

    public final void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        t3.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        t3.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String b2 = s3.b(decode);
                    if (!TextUtils.isEmpty(b2)) {
                        t3.a(context, b2, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            t3.a(context, "provider", 1008, "B get a incorrect message");
        } catch (Exception e2) {
            t3.a(context, "provider", 1008, "B meet a exception" + e2.getMessage());
        }
    }

    public final void b(Context context, w3 w3Var) {
        String b2 = w3Var.b();
        String d2 = w3Var.d();
        int a2 = w3Var.a();
        if (context == null || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                t3.a(context, "provider", 1008, "argument error");
                return;
            } else {
                t3.a(context, d2, 1008, "argument error");
                return;
            }
        }
        if (!c.k.d.p9.d1.b(context, b2)) {
            t3.a(context, d2, 1003, "B is not ready");
            return;
        }
        t3.a(context, d2, 1002, "B is ready");
        t3.a(context, d2, CrashModule.MODULE_ID, "A is ready");
        String a3 = s3.a(d2);
        try {
            if (TextUtils.isEmpty(a3)) {
                t3.a(context, d2, 1008, "info is empty");
                return;
            }
            if (a2 == 1 && !x3.m523a(context)) {
                t3.a(context, d2, 1008, "A not in foreground");
                return;
            }
            String type = context.getContentResolver().getType(s3.a(b2, a3));
            if (TextUtils.isEmpty(type) || !JUnionAdError.Message.SUCCESS.equals(type)) {
                t3.a(context, d2, 1008, "A is fail to help B's provider");
            } else {
                t3.a(context, d2, 1005, "A is successful");
                t3.a(context, d2, 1006, "The job is finished");
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            t3.a(context, d2, 1008, "A meet a exception when help B's provider");
        }
    }
}
