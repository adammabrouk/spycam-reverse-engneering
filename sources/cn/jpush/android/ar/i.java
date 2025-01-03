package cn.jpush.android.ar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import com.hjq.permissions.XXPermissions;
import com.tencent.bugly.CrashModule;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i extends cn.jpush.android.as.d implements cn.jpush.android.as.b {

    /* renamed from: a, reason: collision with root package name */
    public cn.jpush.android.as.a f9305a;

    /* renamed from: d, reason: collision with root package name */
    public cn.jpush.android.d.d f9308d;

    /* renamed from: e, reason: collision with root package name */
    public int f9309e = 0;

    /* renamed from: c, reason: collision with root package name */
    public cn.jpush.android.as.c f9307c = new c(this);

    /* renamed from: b, reason: collision with root package name */
    public int f9306b = 2;

    public static class a extends cn.jpush.android.bm.e {

        /* renamed from: a, reason: collision with root package name */
        public Context f9310a;

        /* renamed from: b, reason: collision with root package name */
        public cn.jpush.android.d.d f9311b;

        /* renamed from: c, reason: collision with root package name */
        public cn.jpush.android.as.a f9312c;

        public a(Context context, cn.jpush.android.d.d dVar, cn.jpush.android.as.a aVar) {
            this.f9310a = context;
            this.f9311b = dVar;
            this.f9312c = aVar;
            this.f9666f = "NotifyInAppMessageAction";
        }

        private boolean a(Context context, cn.jpush.android.d.d dVar) {
            try {
                if (context == null || dVar == null) {
                    cn.jpush.android.r.b.f("NotificationInAppHelper", "unexpected nulrl param error, context is " + context + ", message is " + dVar);
                    return false;
                }
                cn.jpush.android.r.b.b("NotificationInAppHelper", "handle notify message, messageType: " + dVar.aw);
                if (a(dVar)) {
                    cn.jpush.android.r.b.g("NotificationInAppHelper", "notify inapp message expired");
                    cn.jpush.android.helper.c.a(dVar.f9700d, 1603, context);
                    return false;
                }
                if (b(context, dVar) != null) {
                    cn.jpush.android.an.a.a(context, "ad_arrived_sdk", dVar, true);
                    return true;
                }
                cn.jpush.android.r.b.g("NotificationInAppHelper", "notify tpl dl failed");
                return false;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("NotificationInAppHelper", "handle notify in-app message failed, " + th.getMessage());
                return false;
            }
        }

        private boolean a(cn.jpush.android.d.d dVar) {
            if (TextUtils.isEmpty(dVar.au)) {
                return false;
            }
            return System.currentTimeMillis() >= cn.jpush.android.bm.b.b(dVar.au);
        }

        private cn.jpush.android.d.d b(Context context, cn.jpush.android.d.d dVar) {
            String str;
            String str2;
            boolean z;
            try {
                String str3 = dVar.bf;
                if (TextUtils.isEmpty(str3)) {
                    str3 = cn.jpush.android.bm.a.d(dVar.bg);
                }
                String str4 = dVar.f9700d;
                LinkedHashMap<String, cn.jpush.android.aw.f> a2 = g.a(context);
                cn.jpush.android.aw.f fVar = a2.get(str3);
                str = "";
                if (fVar != null) {
                    str2 = fVar.f9436b;
                    if (cn.jpush.android.bm.c.a(str2)) {
                        dVar.bb = "file://" + str2;
                        fVar.f9437c = System.currentTimeMillis();
                        cn.jpush.android.r.b.b("NotificationInAppHelper", "use cache template, templateId: " + str3 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a2.values().size() + ", update template file time: " + new File(str2).setLastModified(fVar.f9437c));
                    } else {
                        a2.remove(str3);
                        cn.jpush.android.r.b.b("NotificationInAppHelper", "local config has template path, but the template file is not exist, will download again.");
                        str2 = "";
                    }
                    g.a(context, a2);
                } else {
                    str2 = "";
                }
                String str5 = dVar.bg;
                int i2 = 0;
                if (TextUtils.isEmpty(str2)) {
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "no local template cache, start download template, url: " + str5);
                    if (TextUtils.isEmpty(str5)) {
                        cn.jpush.android.r.b.f("NotificationInAppHelper", "template url is Empty! Give up to download!");
                        z = false;
                    } else {
                        String a3 = cn.jpush.android.bf.a.a(str5, 5, 5000L);
                        boolean isEmpty = TextUtils.isEmpty(a3);
                        str = isEmpty ? "" : a3;
                        z = !isEmpty;
                    }
                    if (!z) {
                        cn.jpush.android.r.b.f("NotificationInAppHelper", "NOTE: failed to download html page. Give up this.");
                        return null;
                    }
                    String str6 = cn.jpush.android.bm.c.a(context, "h5_tpls", 20) + str3 + ".html";
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "download template success, will save to local of path: " + str6);
                    if (cn.jpush.android.bm.c.b(str6, str)) {
                        dVar.bb = "file://" + str6;
                        cn.jpush.android.r.b.b("NotificationInAppHelper", "cache h5 template to local success, templateId: " + str3 + ", path: " + dVar.bb);
                        a2.put(str3, cn.jpush.android.aw.f.a(str3, str6, System.currentTimeMillis()));
                        g.a(context, a2);
                    } else {
                        dVar.bb = dVar.bg;
                    }
                }
                if (dVar.bk.size() > 0) {
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "template has image resource, start download image to local, images: " + dVar.bk.toString());
                    ArrayList<String> a4 = g.a(dVar.bk, context, str5.substring(0, str5.lastIndexOf("/") + 1), str4);
                    if (a4 == null) {
                        cn.jpush.android.r.b.f("NotificationInAppHelper", "Load notify in-app message image resources failed, give up this in app!");
                        return null;
                    }
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "Load notify in-app message image succeed, webView will open cache!");
                    String str7 = dVar.bi;
                    try {
                        JSONObject jSONObject = new JSONObject(str7);
                        while (i2 < a4.size()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("in_pic_path");
                            int i3 = i2 + 1;
                            sb.append(i3);
                            jSONObject.put(sb.toString(), a4.get(i2));
                            i2 = i3;
                        }
                        dVar.bi = jSONObject.toString();
                        cn.jpush.android.r.b.b("NotificationInAppHelper", "http image resources replace local path, new templateData: " + dVar.bi);
                    } catch (Throwable th) {
                        dVar.bi = str7;
                        cn.jpush.android.r.b.f("NotificationInAppHelper", "replace template picture resource error, " + th.getMessage());
                    }
                } else {
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "template no image resource.");
                }
            } catch (Throwable unused) {
            }
            return dVar;
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            cn.jpush.android.d.d dVar;
            if (a(this.f9310a, this.f9311b) || (dVar = this.f9311b) == null) {
                return;
            }
            if (!TextUtils.isEmpty(dVar.f9700d)) {
                cn.jpush.android.helper.c.a(this.f9311b.f9700d, 1604, this.f9310a);
            }
            if (this.f9311b.aw == 104) {
                cn.jpush.android.r.b.b("NotificationInAppHelper", "in app handle failed, start handle notification");
                cn.jpush.android.d.b.a(this.f9310a, this.f9311b);
            }
            if (this.f9312c != null) {
                cn.jpush.android.d.d dVar2 = this.f9311b;
                this.f9312c.a(this.f9310a, this.f9311b.bq, d.a(dVar2.aC, dVar2.aE), 0);
            }
        }
    }

    public i(cn.jpush.android.as.a aVar) {
        this.f9305a = aVar;
    }

    private void b(Context context, cn.jpush.android.aw.e eVar, int i2) {
        if (eVar != null) {
            if (this.f9305a != null) {
                this.f9305a.a(context, eVar.t().bq, d.a(eVar.n(), eVar.t().aE), i2);
            }
            if (i2 != 1 && eVar.t().aw == 104 && this.f9309e != 2) {
                cn.jpush.android.r.b.b("NotificationInAppHelper", "in app handle completed, start handle notification, state: " + i2);
                f(context, eVar.t());
            }
        }
        this.f9309e = i2;
    }

    private boolean e(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        String str3;
        boolean z = false;
        if (context == null) {
            cn.jpush.android.r.b.f("NotificationInAppHelper", "[openDeepLink] context is null");
            return false;
        }
        if (dVar == null || TextUtils.isEmpty(dVar.L)) {
            cn.jpush.android.r.b.b("NotificationInAppHelper", "is not deep link notification in app");
            return false;
        }
        try {
            cn.jpush.android.r.b.b("NotificationInAppHelper", "open deeplink notification in app, targetPkg:" + dVar.O);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("NotificationInAppHelper", "url failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(dVar.O)) {
            z = cn.jpush.android.bg.b.a(context, dVar.L, dVar.O);
            if (z) {
                str3 = dVar.f9700d;
                cn.jpush.android.helper.c.a(str3, 1605, context);
                return z;
            }
            str2 = dVar.f9700d;
            cn.jpush.android.helper.c.a(str2, 1606, context);
            return z;
        }
        if (cn.jpush.android.bm.a.a(context, dVar.O, dVar.L)) {
            z = d.b(context, new cn.jpush.android.aw.e(dVar));
            if (z) {
                str3 = dVar.f9700d;
                cn.jpush.android.helper.c.a(str3, 1605, context);
                return z;
            }
            str2 = dVar.f9700d;
            cn.jpush.android.helper.c.a(str2, 1606, context);
            return z;
        }
        cn.jpush.android.r.b.b("NotificationInAppHelper", "app not installed,fail_handle_type:" + dVar.M + ",fail_handle_url:" + dVar.N);
        int i2 = dVar.M;
        if (i2 == 0) {
            Intent g2 = cn.jpush.android.bm.a.g(context);
            if (g2 != null) {
                try {
                    context.startActivity(g2);
                } catch (Throwable th2) {
                    str = "start main intent error:" + th2.getMessage();
                }
            }
            return z;
        }
        if (i2 != 1 && i2 != 2) {
            return z;
        }
        if (TextUtils.isEmpty(dVar.N)) {
            str = "fail_handle_url is empty";
            cn.jpush.android.r.b.b("NotificationInAppHelper", str);
            return z;
        }
        z = cn.jpush.android.bg.b.d(context, dVar.N);
        if (z) {
            str3 = dVar.f9700d;
            cn.jpush.android.helper.c.a(str3, 1605, context);
            return z;
        }
        str2 = dVar.f9700d;
        cn.jpush.android.helper.c.a(str2, 1606, context);
        return z;
    }

    private void f(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            cn.jpush.android.r.b.b("NotificationInAppHelper", "notify in app, start handle notify message");
            Bundle bundle = new Bundle();
            bundle.putString("content", dVar.c());
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_notify_msg", bundle);
        }
    }

    @Override // cn.jpush.android.as.d
    public int a() {
        return 201;
    }

    @Override // cn.jpush.android.as.d
    public int a(int i2) {
        if (i2 == 1) {
            return this.f9309e;
        }
        return 0;
    }

    @Override // cn.jpush.android.as.d
    public int a(Context context) {
        return this.f9306b;
    }

    @Override // cn.jpush.android.as.b
    public Boolean a(Context context, int i2, cn.jpush.android.aw.e eVar, Object... objArr) {
        if (context == null) {
            cn.jpush.android.r.b.f("NotificationInAppHelper", "unexpected error context is null, eventType: " + i2);
            return false;
        }
        if (eVar == null) {
            cn.jpush.android.r.b.g("NotificationInAppHelper", "unexpected error message is null, eventType: " + i2);
            return false;
        }
        try {
            String m = eVar.m();
            int i3 = eVar.t().bq;
            switch (i2) {
                case 1000:
                case 1001:
                case 1002:
                case 1015:
                    if (i2 != 1015) {
                        cn.jpush.android.helper.c.a(m, 1604, context);
                    }
                    b(context, eVar, 0);
                    break;
                case 1003:
                case CrashModule.MODULE_ID /* 1004 */:
                case 1007:
                case 1011:
                case 1017:
                case 1021:
                case 1023:
                case 1024:
                case XXPermissions.REQUEST_CODE /* 1025 */:
                    break;
                case 1005:
                case 1006:
                case 1008:
                case 1009:
                case 1010:
                case 1013:
                case 1018:
                case 1020:
                    cn.jpush.android.helper.c.a(m, 1604, context);
                    break;
                case 1012:
                    boolean a2 = cn.jpush.android.bg.d.a(context, eVar.m(), "");
                    if (a2) {
                        cn.jpush.android.helper.c.a(m, 1602, context);
                    }
                    return Boolean.valueOf(a2);
                case 1014:
                    cn.jpush.android.helper.c.a(m, 1600, context);
                    b(context, eVar, 2);
                    break;
                case 1016:
                    cn.jpush.android.helper.c.a(m, 1602, context);
                    break;
                case 1019:
                    cn.jpush.android.helper.c.a(m, 1601, context);
                    e(context, eVar.t());
                    break;
                case 1022:
                    if (this.f9305a != null) {
                        this.f9305a.a(context, m, i3);
                        break;
                    }
                    break;
                default:
                    cn.jpush.android.r.b.b("NotificationInAppHelper", "onDisplayEvent default eventType: " + i2);
                    break;
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("NotificationInAppHelper", "onDisplayEvent error: " + th.getMessage());
        }
        return true;
    }

    @Override // cn.jpush.android.as.d
    public void a(int i2, int i3) {
        if (i2 == 1) {
            this.f9309e = i3;
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, int i2) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.a(context, i2);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, cn.jpush.android.aw.e eVar, int i2) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.a(context, eVar, i2);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, cn.jpush.android.d.d dVar) {
        if (cn.jpush.android.af.e.a(context) && !d.c(context)) {
            this.f9309e = 1;
            this.f9308d = dVar;
            this.f9306b = dVar.br;
            JCoreHelper.normalExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar, this.f9305a));
            return;
        }
        cn.jpush.android.r.b.c("NotificationInAppHelper", "cache notify message in background or page in black list");
        b(context, dVar);
        if (this.f9305a != null) {
            this.f9305a.a(context, dVar.bq, d.a(dVar.aC, dVar.aE), 0);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(cn.jpush.android.aw.e eVar, int i2, String str) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.a(eVar, i2, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public cn.jpush.android.d.d b(Context context) {
        return cn.jpush.android.au.e.b(context);
    }

    @Override // cn.jpush.android.as.d
    public void b(Context context, int i2) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.a(context, 3);
        }
    }

    @Override // cn.jpush.android.as.d
    public void b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            this.f9306b = dVar.br;
            cn.jpush.android.au.e.a(context, dVar);
        }
    }

    @Override // cn.jpush.android.as.d
    public boolean c(Context context) {
        return cn.jpush.android.au.e.a(context) > 0;
    }

    @Override // cn.jpush.android.as.d
    public boolean c(Context context, cn.jpush.android.d.d dVar) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar == null) {
            return false;
        }
        this.f9308d = dVar;
        return cVar.a(context, dVar);
    }

    @Override // cn.jpush.android.as.d
    public void d(Context context) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar == null || this.f9309e != 2) {
            return;
        }
        cVar.a(context);
    }

    @Override // cn.jpush.android.as.d
    public void d(Context context, cn.jpush.android.d.d dVar) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.a(context, dVar.f9700d, false, false, 201);
        }
    }

    @Override // cn.jpush.android.as.d
    public void e(Context context, String str) {
        cn.jpush.android.as.c cVar = this.f9307c;
        if (cVar != null) {
            cVar.e(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public void f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.f("NotificationInAppHelper", "unexpected param is null");
            return;
        }
        String[] split = str.split(",");
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                if (cn.jpush.android.au.e.a(context, str2)) {
                    if (split.length == 2) {
                        str2 = split[1];
                    }
                    cn.jpush.android.helper.c.a(str2, 1602, context);
                } else if (this.f9307c != null) {
                    cn.jpush.android.d.d dVar = this.f9308d;
                    this.f9307c.a(context, str2, dVar != null && dVar.f9700d.equals(str2), true, 201);
                }
            }
        }
    }
}
