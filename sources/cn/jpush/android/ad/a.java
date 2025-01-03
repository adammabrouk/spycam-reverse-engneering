package cn.jpush.android.ad;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: cn.jpush.android.ad.a$a, reason: collision with other inner class name */
    public class C0142a extends cn.jpush.android.r.a {

        /* renamed from: c, reason: collision with root package name */
        public Context f9085c;

        /* renamed from: d, reason: collision with root package name */
        public String f9086d;

        public C0142a(Context context, String str) {
            this.f9085c = context;
            this.f9086d = str;
        }

        @Override // cn.jpush.android.r.a
        public void a() {
            try {
                a.this.e(this.f9085c, this.f9086d);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JCollectCommon", "CollectAction-deal failed, " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, String str) {
        a(context, str);
        b(context, str);
    }

    public void a(Context context) {
        try {
            String b2 = b(context);
            cn.jpush.android.r.b.b("JCollectCommon", "executeAction: [" + b2 + "] from heartBeat");
            boolean c2 = c(context, b2);
            cn.jpush.android.r.b.b("JCollectCommon", b2 + " - isBusinessEnable:" + c2);
            if (c2) {
                cn.jpush.android.l.a.a(context, (Runnable) new C0142a(context, b2));
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.b("JCollectCommon", "executeAction failed, error:" + th);
        }
    }

    public void a(Context context, String str) {
        cn.jpush.android.q.a.e(context, str);
    }

    public abstract String b(Context context);

    public void b(Context context, String str) {
        cn.jpush.android.q.a.f(context, str);
    }

    public boolean c(Context context, String str) {
        return cn.jpush.android.q.a.a(context, str);
    }

    public boolean d(Context context, String str) {
        return cn.jpush.android.q.a.b(context, str);
    }
}
