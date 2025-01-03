package c.j.a.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c.j.a.e;
import c.j.a.g;
import c.j.a.h.d;
import c.j.a.v;
import c.j.a.z.a0;
import c.j.a.z.z;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.util.List;

/* compiled from: CommandBridge.java */
/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, String str, v vVar) {
        boolean c2 = vVar.c();
        g a2 = g.a(context, c2 ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a3 = a2.a();
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        if (a3 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            e eVar = new e(vVar.a(), str, new Bundle());
            vVar.a(eVar);
            if (a2.a(eVar.b())) {
                return;
            }
            c.j.a.z.v.b("CommandBridge", "send command error by aidl");
            c.j.a.z.v.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c2 ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        vVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e2) {
            c.j.a.z.v.a("CommandBridge", "CommandBridge startService exception: ", e2);
        }
    }

    public static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e2) {
                c.j.a.z.v.a("CommandBridge", "start service error", e2);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        c.j.a.z.v.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, v vVar, String str) {
        try {
            boolean d2 = z.d(context, str);
            String str2 = d2 ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (d2 || a(context, str2, str)) {
                    if (TextUtils.isEmpty(vVar.a())) {
                        vVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(MemoryConstants.MB);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, d2 ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", c.j.a.z.g.a(context).a("com.vivo.pushservice"));
                    vVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    if (Build.VERSION.SDK_INT >= 18) {
                        intent.putExtra("security_avoid_pull_rsa", d.a(context).a().a("com.vivo.pushservice"));
                        intent.putExtra("security_avoid_rsa_public_key", a0.a(d.a(context).a().a()));
                    }
                    a(context, intent);
                    return;
                }
                return;
            }
            c.j.a.z.v.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e2) {
            c.j.a.z.v.a("CommandBridge", "CommandBridge sendCommandToClient exception", e2);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            c.j.a.z.v.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            c.j.a.z.v.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
