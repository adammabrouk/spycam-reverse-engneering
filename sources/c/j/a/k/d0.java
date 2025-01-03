package c.j.a.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.WakedResultReceiver;
import com.shix.shixipc.system.ContentCommon;
import java.util.HashMap;
import java.util.Map;

/* compiled from: OnNotificationClickTask.java */
/* loaded from: classes.dex */
public final class d0 extends i0 {
    public d0(c.j.a.v vVar) {
        super(vVar);
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    public static /* synthetic */ Intent a(Intent intent, Map map) {
        b(intent, map);
        return intent;
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        Intent parseUri;
        String str;
        c.j.a.f.o oVar = (c.j.a.f.o) vVar;
        c.j.a.t.a f2 = oVar.f();
        if (f2 == null) {
            c.j.a.z.v.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        c.j.a.t.b a2 = c.j.a.z.w.a(f2);
        boolean equals = this.f6635a.getPackageName().equals(oVar.d());
        if (equals) {
            c.j.a.z.d.a(this.f6635a);
        }
        if (equals) {
            c.j.a.f.w wVar = new c.j.a.f.w(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(ContentCommon.TYPE, WakedResultReceiver.WAKE_TYPE_KEY);
            hashMap.put("messageID", String.valueOf(oVar.e()));
            hashMap.put(JThirdPlatFormInterface.KEY_PLATFORM, this.f6635a.getPackageName());
            Context context = this.f6635a;
            String b2 = c.j.a.z.f0.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            wVar.a(hashMap);
            c.j.a.m.m().a(wVar);
            c.j.a.z.v.d("OnNotificationClickTask", "notification is clicked by skip type[" + a2.n() + "]");
            int n = a2.n();
            boolean z = true;
            if (n == 1) {
                new Thread(new e0(this, this.f6635a, a2.k())).start();
                a(a2);
                return;
            }
            if (n == 2) {
                String m = a2.m();
                if (!m.startsWith(JPushConstants.HTTP_PRE) && !m.startsWith(JPushConstants.HTTPS_PRE)) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(m);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a2.k());
                    try {
                        this.f6635a.startActivity(intent);
                    } catch (Exception unused) {
                        c.j.a.z.v.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    c.j.a.z.v.a("OnNotificationClickTask", "url not legal");
                }
                a(a2);
                return;
            }
            if (n == 3) {
                a(a2);
                return;
            }
            if (n != 4) {
                c.j.a.z.v.a("OnNotificationClickTask", "illegitmacy skip type error : " + a2.n());
                return;
            }
            String m2 = a2.m();
            try {
                parseUri = Intent.parseUri(m2, 1);
                str = parseUri.getPackage();
            } catch (Exception e2) {
                c.j.a.z.v.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(m2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f6635a.getPackageName().equals(str)) {
                c.j.a.z.v.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f6635a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f6635a.getPackageName().equals(packageName)) {
                c.j.a.z.v.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f6635a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f6635a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a2.k());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f6635a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                c.j.a.z.v.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f6635a.startActivity(parseUri);
                a(a2);
                return;
            }
        }
        c.j.a.z.v.a("OnNotificationClickTask", "notify is " + a2 + " ; isMatch is " + equals);
    }

    public final void a(c.j.a.t.b bVar) {
        c.j.a.s.c(new f0(this, bVar));
    }
}
