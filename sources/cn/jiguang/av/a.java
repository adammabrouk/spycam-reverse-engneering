package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.az.c;
import cn.jiguang.az.g;
import cn.jiguang.az.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8398a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.StringBuilder] */
    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f8398a) {
                return;
            }
            if (context == null) {
                return;
            }
            d.c("JCoreActionImpl", "init jcore impl ,version:" + cn.jiguang.a.a.f8098b + ",local version:" + JConstants.SDK_VERSION_INT);
            f8398a = true;
            try {
                d.c("JCoreActionImpl", "hb:" + h.a().f() + ",google:true,google pure : false,internal:false");
                ?? r2 = cn.jiguang.a.a.a();
                if (cn.jiguang.a.a.f8099c != JConstants.SDK_VERSION_INT) {
                    r2 = 2;
                }
                d.c("JCoreActionImpl", "custom:1,dynamic:" + r2);
                JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, "core", 1, Integer.valueOf((int) r2), Integer.valueOf(cn.jiguang.a.a.f8099c));
            } catch (Throwable th) {
                d.h("JCoreActionImpl", "sdk type call failed:" + th.getMessage());
            }
            c.b(context);
            c.a(context);
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        String string;
        a(context);
        if (TextUtils.isEmpty(str)) {
            d.h("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        d.c("JCoreActionImpl", "handleAction action:" + str);
        String string2 = bundle != null ? bundle.getString(ActionManager.SDK_TYPE) : "";
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    string = bundle.getString("report_data");
                } catch (Throwable th) {
                    d.g("JCoreActionImpl", "report failed:" + th.getMessage());
                    return;
                }
            } else {
                string = null;
            }
            b.a(context, (Object) string);
            return;
        }
        if (str.startsWith("tcp_")) {
            h.a().a(context, str, bundle);
            return;
        }
        if (str.equals("a2")) {
            g.a().a(context, true);
        } else if (str.equals("a3")) {
            cn.jiguang.az.b.a().a(context, string2, bundle);
        } else if (str.equals("a4")) {
            b.a(context, bundle);
        }
    }
}
