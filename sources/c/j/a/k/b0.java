package c.j.a.k;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes.dex */
public final class b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.t.a f6569a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.p f6570b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f6571c;

    public b0(a0 a0Var, c.j.a.t.a aVar, c.j.a.f.p pVar) {
        this.f6571c = a0Var;
        this.f6569a = aVar;
        this.f6570b = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c2;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        a0 a0Var = this.f6571c;
        c.j.a.y.a aVar = a0Var.f6591d;
        context = a0Var.f6635a;
        if (aVar.onNotificationMessageArrived(context, c.j.a.z.w.a(this.f6569a))) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context11 = this.f6571c.f6635a;
            sb.append(context11.getPackageName());
            sb.append(" 应用主动拦截通知");
            c.j.a.z.v.b("OnNotificationArrivedTask", sb.toString());
            context12 = this.f6571c.f6635a;
            c.j.a.z.v.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.f6570b.f()));
            context13 = this.f6571c.f6635a;
            context14 = this.f6571c.f6635a;
            String b2 = c.j.a.z.f0.b(context13, context14.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            c.j.a.z.k.a(2120L, hashMap);
            return;
        }
        int b3 = this.f6571c.b();
        if (b3 > 0) {
            StringBuilder sb2 = new StringBuilder("pkg name : ");
            context7 = this.f6571c.f6635a;
            sb2.append(context7.getPackageName());
            sb2.append(" notify channel switch is ");
            sb2.append(b3);
            c.j.a.z.v.b("OnNotificationArrivedTask", sb2.toString());
            context8 = this.f6571c.f6635a;
            c.j.a.z.v.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b3)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("messageID", String.valueOf(this.f6570b.f()));
            context9 = this.f6571c.f6635a;
            context10 = this.f6571c.f6635a;
            String b4 = c.j.a.z.f0.b(context9, context10.getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap2.put("remoteAppId", b4);
            }
            c.j.a.z.k.a(b3, hashMap2);
            return;
        }
        context2 = this.f6571c.f6635a;
        c.j.a.t.a aVar2 = this.f6569a;
        long f2 = this.f6570b.f();
        a0 a0Var2 = this.f6571c;
        c.j.a.y.a aVar3 = a0Var2.f6591d;
        context3 = a0Var2.f6635a;
        c.j.a.z.q qVar = new c.j.a.z.q(context2, aVar2, f2, aVar3.isAllowNet(context3), new c0(this));
        boolean z = this.f6569a.z();
        String l = this.f6569a.l();
        if (TextUtils.isEmpty(l)) {
            l = this.f6569a.f();
        }
        if (!TextUtils.isEmpty(l)) {
            c.j.a.z.v.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(z)));
            if (z) {
                context4 = this.f6571c.f6635a;
                c.j.a.z.v.a(context4, "mobile net show");
            } else {
                context5 = this.f6571c.f6635a;
                c.j.a.z.v.a(context5, "mobile net unshow");
                context6 = this.f6571c.f6635a;
                NetworkInfo a2 = c.j.a.z.x.a(context6);
                if (a2 != null && a2.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a2.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    l = null;
                    this.f6569a.a();
                    this.f6569a.b();
                }
            }
        }
        qVar.execute(this.f6569a.g(), l);
    }
}
