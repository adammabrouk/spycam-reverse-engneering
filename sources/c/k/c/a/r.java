package c.k.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import c.k.d.j7;
import c.k.d.z7;
import com.xiaomi.mipush.sdk.PushServiceReceiver;
import java.util.List;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static int f6912a;

    public static int a(Context context) {
        if (f6912a == 0) {
            a(b(context) ? 1 : 2);
        }
        return f6912a;
    }

    public static n a(String str, List<String> list, long j, String str2, String str3) {
        n nVar = new n();
        nVar.setCommand(str);
        nVar.setCommandArguments(list);
        nVar.setResultCode(j);
        nVar.setReason(str2);
        nVar.setCategory(str3);
        return nVar;
    }

    public static o a(z7 z7Var, j7 j7Var, boolean z) {
        o oVar = new o();
        oVar.setMessageId(z7Var.m564a());
        if (!TextUtils.isEmpty(z7Var.d())) {
            oVar.setMessageType(1);
            oVar.setAlias(z7Var.d());
        } else if (!TextUtils.isEmpty(z7Var.c())) {
            oVar.setMessageType(2);
            oVar.setTopic(z7Var.c());
        } else if (TextUtils.isEmpty(z7Var.f())) {
            oVar.setMessageType(0);
        } else {
            oVar.setMessageType(3);
            oVar.setUserAccount(z7Var.f());
        }
        oVar.setCategory(z7Var.e());
        if (z7Var.a() != null) {
            oVar.setContent(z7Var.a().c());
        }
        if (j7Var != null) {
            if (TextUtils.isEmpty(oVar.getMessageId())) {
                oVar.setMessageId(j7Var.m246a());
            }
            if (TextUtils.isEmpty(oVar.getTopic())) {
                oVar.setTopic(j7Var.m251b());
            }
            oVar.setDescription(j7Var.d());
            oVar.setTitle(j7Var.m254c());
            oVar.setNotifyType(j7Var.a());
            oVar.setNotifyId(j7Var.c());
            oVar.setPassThrough(j7Var.b());
            oVar.setExtra(j7Var.m247a());
        }
        oVar.setNotified(z);
        return oVar;
    }

    public static void a(int i2) {
        f6912a = i2;
    }

    public static void a(Context context, n nVar) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra("key_command", nVar);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return a(context, intent);
    }
}
