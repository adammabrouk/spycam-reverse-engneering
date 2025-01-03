package c.k.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class n2 implements r2 {
    @Override // c.k.d.r2
    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        j.a(context).a(new o2(this, context, intent));
    }

    public final void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (p2.a(context, String.valueOf(12), 1L)) {
                return;
            }
            d7 d7Var = new d7();
            d7Var.a(str + ":" + str2);
            d7Var.a(System.currentTimeMillis());
            d7Var.a(x6.BroadcastAction);
            a3.a(context, d7Var);
        } catch (Throwable unused) {
        }
    }

    public final void b(Context context, Intent intent) {
        int a2;
        try {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            String[] split = dataString.split(":");
            if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                String str = split[1];
                long currentTimeMillis = System.currentTimeMillis();
                boolean a3 = c.k.d.p9.m.a(context).a(a7.BroadcastActionCollectionSwitch.a(), true);
                if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                    if (!p2.a(context, String.valueOf(12), 1L) && a3) {
                        if (TextUtils.isEmpty(z2.f8058c)) {
                            z2.f8058c += q2.f7758b + ":";
                        }
                        z2.f8058c += str + "(" + currentTimeMillis + "),";
                        return;
                    }
                    return;
                }
                if (TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                    if (!p2.a(context, String.valueOf(12), 1L) && a3) {
                        if (TextUtils.isEmpty(z2.f8059d)) {
                            z2.f8059d += q2.f7759c + ":";
                        }
                        z2.f8059d += str + "(" + currentTimeMillis + "),";
                        return;
                    }
                    return;
                }
                if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                    if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a3) {
                        return;
                    } else {
                        a2 = x6.BroadcastActionAdded.a();
                    }
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                    if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !a3) {
                        return;
                    } else {
                        a2 = x6.BroadcastActionRemoved.a();
                    }
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                    if (!a3) {
                        return;
                    } else {
                        a2 = x6.BroadcastActionReplaced.a();
                    }
                } else if (!TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) || !a3) {
                    return;
                } else {
                    a2 = x6.BroadcastActionDataCleared.a();
                }
                a(context, String.valueOf(a2), str);
            }
        } catch (Throwable unused) {
        }
    }
}
