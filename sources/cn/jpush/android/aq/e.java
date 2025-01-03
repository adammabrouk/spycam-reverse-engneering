package cn.jpush.android.aq;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import cn.jpush.android.ap.a;
import cn.jpush.android.aq.c;
import cn.jpush.android.ar.b;
import cn.jpush.android.bm.k;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* loaded from: classes.dex */
public class e extends c {

    /* renamed from: e, reason: collision with root package name */
    public cn.jpush.android.ap.a f9236e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f9237f;

    /* renamed from: g, reason: collision with root package name */
    public WindowManager.LayoutParams f9238g;

    public e(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        super(cVar, eVar);
    }

    @Override // cn.jpush.android.aq.c
    public View a() {
        return this.f9237f;
    }

    @Override // cn.jpush.android.aq.c
    public Object a(Context context, cn.jpush.android.au.c cVar, boolean z, WindowManager windowManager, View view) {
        int i2;
        if (cVar == null || context == null || view == null) {
            cn.jpush.android.r.b.f("InAppFloatBindingWrapper", "getLayoutParams unexpected exception occurred for param is null, layout:" + cVar + ", context:" + context + ", view:" + view);
            i2 = 105;
        } else {
            try {
                int d2 = cVar.d() | OSSConstants.DEFAULT_STREAM_BUFFER_SIZE | 32 | 8;
                int i3 = z ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2003 : 1003;
                DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
                int c2 = cVar.c();
                int b2 = cVar.b();
                int f2 = cVar.f();
                int g2 = cVar.g();
                int o = cVar.o();
                int n = cVar.n();
                int e2 = cVar.e();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(f2, g2, i3, d2, -3);
                this.f9238g = layoutParams;
                layoutParams.x = o;
                layoutParams.y = n;
                layoutParams.dimAmount = 0.3f;
                layoutParams.gravity = e2;
                layoutParams.windowAnimations = 0;
                cn.jpush.android.r.b.b("InAppFloatBindingWrapper", "[float] parent view layout param, gravity: " + e2 + ", marginX: " + o + ", marginY: " + n + ", maxWidth: " + c2 + ", maxHeight: " + b2 + ", screenW: " + a2.widthPixels + ", screenH: " + a2.heightPixels);
                windowManager.addView(view, this.f9238g);
                StringBuilder sb = new StringBuilder();
                sb.append("[float] webview layout param, gravity same as parent, width: MATCH_PARENT-");
                sb.append(f2);
                sb.append(", height: ");
                sb.append(g2);
                cn.jpush.android.r.b.b("InAppFloatBindingWrapper", sb.toString());
                return this.f9238g;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppFloatBindingWrapper", "[float] [getLayoutParams] error." + th.getMessage());
                i2 = 106;
            }
        }
        return Integer.valueOf(i2);
    }

    @Override // cn.jpush.android.aq.c
    public void a(Context context) {
        f();
    }

    @Override // cn.jpush.android.aq.c
    public void a(WindowManager windowManager, final Context context) {
        final View d2 = d();
        final cn.jpush.android.au.c f2 = f();
        if (f2 == null || d2 == null) {
            return;
        }
        boolean z = f().e() == 53;
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        int i2 = a2.widthPixels;
        int i3 = a2.heightPixels;
        int b2 = this.f9228a.b(context, a2, 0);
        int b3 = this.f9228a.b(context, a2, 2);
        this.f9228a.b(context, a2, 1);
        this.f9228a.b(context, a2, 3);
        int f3 = f2.f();
        f2.g();
        f2.n();
        if (b2 < 0 && b3 < 0) {
            k.a(context, 6);
        }
        if (!z && b2 < 0 && b3 < 0) {
            k.a(context, 6);
        }
        if (!z) {
            f3 = -f3;
        }
        Point point = new Point(f3, 0);
        Point point2 = new Point(0, 0);
        a();
        cn.jpush.android.ar.b.a(context, d2, point, point2, (long) f2.l(), new b.a() { // from class: cn.jpush.android.aq.e.1
            @Override // cn.jpush.android.ar.b.a
            public void a() {
                cn.jpush.android.r.b.b("InAppFloatBindingWrapper", "in-app float message show success use animation");
                cn.jpush.android.aw.e eVar = e.this.f9228a;
                if (eVar != null) {
                    eVar.w = SystemClock.elapsedRealtime();
                }
                c.a aVar = e.this.f9229b;
                if (aVar != null) {
                    aVar.a(context, d2);
                }
            }
        });
        cn.jpush.android.aw.e eVar = this.f9228a;
        boolean z2 = eVar != null && eVar.t().bt;
        cn.jpush.android.r.b.b("InAppFloatBindingWrapper", "message is fixed: " + z2 + ", float auto dismiss time: " + f2.k());
        if (!z2) {
            cn.jpush.android.ap.a aVar = this.f9236e;
            if (aVar == null) {
                aVar = new cn.jpush.android.ap.a();
            }
            cn.jpush.android.ap.a aVar2 = aVar;
            this.f9236e = aVar2;
            final boolean z3 = z;
            aVar2.a(new a.InterfaceC0143a() { // from class: cn.jpush.android.aq.e.2
                @Override // cn.jpush.android.ap.a.InterfaceC0143a
                public void a() {
                    try {
                        cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", e.this.f9228a.t(), false);
                        int i4 = z3 ? cn.jpush.android.af.a.a(context).widthPixels : -f2.f();
                        f2.n();
                        Point point3 = new Point(i4, 0);
                        e.this.a();
                        cn.jpush.android.ar.b.a(context, d2, point3, (long) f2.m(), new b.a() { // from class: cn.jpush.android.aq.e.2.1
                            @Override // cn.jpush.android.ar.b.a
                            public void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                e eVar2 = e.this;
                                c.a aVar3 = eVar2.f9229b;
                                if (aVar3 != null) {
                                    cn.jpush.android.aw.e eVar3 = eVar2.f9228a;
                                    eVar3.v = 2;
                                    aVar3.a(context, d2, eVar3);
                                }
                            }
                        });
                        cn.jpush.android.r.b.b("InAppFloatBindingWrapper", "dismiss timer reach, dismiss in-app message, message to user: " + e.this.f9228a.t().aN);
                    } catch (Throwable th) {
                        cn.jpush.android.r.b.f("InAppFloatBindingWrapper", "in-app slide to dismiss error." + th.getMessage());
                    }
                }
            }, (long) f2.k(), 1000L);
        }
        super.d(context);
    }
}
