package c.j.a.y;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import c.j.a.f.w;
import c.j.a.h.d;
import c.j.a.m;
import c.j.a.x;
import c.j.a.z.a0;
import c.j.a.z.c;
import c.j.a.z.f0;
import c.j.a.z.g;
import c.j.a.z.v;
import c.j.a.z.z;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: CommandWorker.java */
/* loaded from: classes.dex */
public final class b extends x {

    /* renamed from: f, reason: collision with root package name */
    public static b f6671f;

    /* renamed from: g, reason: collision with root package name */
    public static final List<Integer> f6672g = Arrays.asList(3);

    /* renamed from: d, reason: collision with root package name */
    public String f6673d;

    /* renamed from: e, reason: collision with root package name */
    public String f6674e = "";

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f6671f == null) {
                f6671f = new b();
            }
            bVar = f6671f;
        }
        return bVar;
    }

    public final void a() {
        this.f6673d = null;
    }

    public final boolean c(Intent intent) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        String c2 = f0.c(this.f6668b, "com.vivo.pushservice");
        v.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c2)));
        if (!TextUtils.equals(c2, "1")) {
            return true;
        }
        String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
        String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            v.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        try {
            if (d.a(this.f6668b).a().a("com.vivo.pushservice".getBytes("UTF-8"), a0.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                v.d("CommandWorker", " RSA验签通过  ");
                return true;
            }
        } catch (Exception e2) {
            v.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
        }
        v.d("CommandWorker", " RSA验签 不通过  ");
        return false;
    }

    public final int d(Intent intent) {
        String stringExtra;
        if (!TextUtils.isEmpty(this.f6674e) && this.f6674e.contains("CommandService")) {
            if (!(intent != null && b(intent) && c(intent))) {
                v.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                return 2151;
            }
        }
        String packageName = this.f6668b.getPackageName();
        try {
            stringExtra = intent.getStringExtra("command_type");
        } catch (Exception e2) {
            v.a("CommandWorker", e2);
        }
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            if (f6672g.contains(Integer.valueOf(intExtra)) && z.c(this.f6668b, packageName) && !z.c(this.f6668b)) {
                v.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                return 2153;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.f6673d)) {
                String a2 = a(this.f6668b, packageName, action);
                this.f6673d = a2;
                if (TextUtils.isEmpty(a2)) {
                    v.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.f6668b.sendBroadcast(intent);
                    return 2152;
                }
            }
            return 0;
        }
        v.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2151;
    }

    public final void a(String str) {
        this.f6674e = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f6668b != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            v.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f6668b);
        }
    }

    @Override // c.j.a.x
    public final void b(Message message) {
        Context context;
        Intent intent = (Intent) message.obj;
        if (intent != null && (context = this.f6668b) != null) {
            String packageName = context.getPackageName();
            int d2 = d(intent);
            if (d2 > 0) {
                w wVar = new w(d2);
                HashMap<String, String> hashMap = new HashMap<>();
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    hashMap.put("messageID", String.valueOf(extras != null ? extras.getLong("notify_id", 404000044642424832L) : 404000044642424832L));
                }
                String b2 = f0.b(this.f6668b, packageName);
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                wVar.a(hashMap);
                m.m().a(wVar);
                return;
            }
            try {
                Class<?> cls = Class.forName(this.f6673d);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.f6673d);
                method.invoke(newInstance, c.c(this.f6668b).getApplicationContext(), intent);
                return;
            } catch (Exception e2) {
                v.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        v.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f6668b);
    }

    public static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            v.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }

    public final boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                String b2 = g.a(this.f6668b).b(stringExtra);
                if ("com.vivo.pushservice".equals(b2)) {
                    return true;
                }
                v.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b2)));
                return false;
            } catch (Exception e2) {
                v.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                return false;
            }
        }
        v.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
        return true;
    }
}
