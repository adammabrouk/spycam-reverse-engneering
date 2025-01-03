package cn.jiguang.ao;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8267a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f8268b;

    /* renamed from: c, reason: collision with root package name */
    public static String f8269c;

    /* renamed from: d, reason: collision with root package name */
    public static String f8270d;

    public static d a() {
        if (f8268b == null) {
            synchronized (f8267a) {
                if (f8268b == null) {
                    f8268b = new d();
                }
            }
        }
        return f8268b;
    }

    public static String a(Context context) {
        String str = f8270d;
        if (str != null) {
            return str;
        }
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            f8270d = "";
            return "";
        }
        f8270d = cn.jiguang.e.a.a(context, c2);
        cn.jiguang.as.d.c("JCommonServiceHelper", "user serviceProcess is:" + f8270d);
        return f8270d;
    }

    public static boolean b(Context context) {
        return cn.jiguang.e.a.a(context).equals(a(context));
    }

    public static String c(Context context) {
        ComponentInfo a2;
        try {
        } catch (Throwable th) {
            cn.jiguang.as.d.c("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (f8269c != null) {
            return f8269c;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        String a3 = cn.jiguang.e.a.a(context, intent, "");
        if (!TextUtils.isEmpty(a3) && JCommonService.class.isAssignableFrom(Class.forName(a3))) {
            f8269c = a3;
            cn.jiguang.as.d.f("JCommonServiceHelper", "found userServiceClass :" + f8269c + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f8269c) && (a2 = cn.jiguang.e.a.a(context, context.getPackageName(), (Class<?>) JCommonService.class)) != null) {
            f8269c = a2.name;
            cn.jiguang.as.d.f("JCommonServiceHelper", "found userServiceClass :" + f8269c + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f8269c)) {
            f8269c = "";
        }
        return f8269c;
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? LogUtils.NULL : bundle.toString());
            cn.jiguang.as.d.c("JCommonServiceHelper", sb.toString());
            String c2 = c(context);
            if (TextUtils.isEmpty(c2)) {
                cn.jiguang.a.a.b(context, str, bundle);
            } else {
                e.a().a(context, c2, str, bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.f("JCommonServiceHelper", "onAction failed", th);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? LogUtils.NULL : bundle.toString());
            cn.jiguang.as.d.e("JCommonServiceHelper", sb.toString());
            cn.jiguang.av.a.a(JConstants.getAppContext(context), str, bundle);
        } catch (Throwable th) {
            cn.jiguang.as.d.f("JCommonServiceHelper", "callAction failed", th);
        }
    }
}
