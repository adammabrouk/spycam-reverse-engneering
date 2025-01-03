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
import cn.jpush.android.ap.b;
import cn.jpush.android.aq.c;
import cn.jpush.android.ar.b;
import cn.jpush.android.aw.g;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: e, reason: collision with root package name */
    public cn.jpush.android.ap.a f9195e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f9196f;

    public a(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        super(cVar, eVar);
    }

    private void g() {
        cn.jpush.android.ap.a aVar = this.f9195e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // cn.jpush.android.aq.c
    public View a() {
        return this.f9196f;
    }

    @Override // cn.jpush.android.aq.c
    public Object a(Context context, cn.jpush.android.au.c cVar, boolean z, WindowManager windowManager, View view) {
        int i2;
        if (cVar == null || context == null || view == null) {
            cn.jpush.android.r.b.f("InAppBannerBindingWrapper", "getLayoutParams unexpected exception occurred for param is null, layout:" + cVar + ", context:" + context + ", view:" + view);
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
                layoutParams.x = o;
                layoutParams.y = n;
                layoutParams.dimAmount = 0.3f;
                layoutParams.gravity = e2;
                layoutParams.windowAnimations = 0;
                cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "[banner] parent view layout param, gravity: " + e2 + ", marginX: " + o + ", marginY: " + n + ", maxWidth: " + c2 + ", maxHeight: " + b2 + ", screenW: " + a2.widthPixels + ", screenH: " + a2.heightPixels + ", windowManager: " + windowManager);
                windowManager.addView(view, layoutParams);
                StringBuilder sb = new StringBuilder();
                sb.append("[banner] webview layout param, gravity same as parent, width: MATCH_PARENT-");
                sb.append(f2);
                sb.append(", height: ");
                sb.append(g2);
                cn.jpush.android.r.b.b("InAppBannerBindingWrapper", sb.toString());
                return layoutParams;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppBannerBindingWrapper", "[banner] [getLayoutParams] error." + th.getMessage());
                i2 = 106;
            }
        }
        return Integer.valueOf(i2);
    }

    @Override // cn.jpush.android.aq.c
    public void a(Context context) {
    }

    @Override // cn.jpush.android.aq.c
    public void a(WindowManager windowManager, final Context context) {
        final View d2;
        final cn.jpush.android.au.c f2;
        cn.jpush.android.ap.a aVar;
        try {
            d2 = d();
            f2 = f();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppBannerBindingWrapper", "start in-app with animation error. " + th.getMessage());
        }
        if (f2 != null && d2 != null) {
            boolean z = false;
            if (f2.h()) {
                int g2 = f2.g();
                if (g2 <= 0) {
                    g2 = cn.jpush.android.af.a.a(context, cn.jpush.android.aw.e.f9426a);
                }
                f().o();
                Point point = new Point(0, -g2);
                Point point2 = new Point(0, 0);
                if (f2.e() >= 80) {
                    cn.jpush.android.af.a.a(context);
                    point.y = g2;
                    g.a(context);
                }
                a();
                cn.jpush.android.ar.b.a(context, d2, point, point2, (long) f2.l(), new b.a() { // from class: cn.jpush.android.aq.a.1
                    @Override // cn.jpush.android.ar.b.a
                    public void a() {
                        cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "in-app message show success use animation.");
                        cn.jpush.android.aw.e eVar = a.this.f9228a;
                        if (eVar != null) {
                            eVar.w = SystemClock.elapsedRealtime();
                        }
                        c.a aVar2 = a.this.f9229b;
                        if (aVar2 != null) {
                            aVar2.a(context, d2);
                        }
                    }
                });
            } else {
                cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "in-app message show success directory.");
            }
            if (f2.j()) {
                d2.setOnTouchListener(new cn.jpush.android.ap.b(this, null, new b.a() { // from class: cn.jpush.android.aq.a.2
                    @Override // cn.jpush.android.ap.b.a
                    public void a(View view, Object obj) {
                        a aVar2 = a.this;
                        if (aVar2.f9229b != null) {
                            cn.jpush.android.aw.e eVar = aVar2.f9228a;
                            if (eVar != null) {
                                eVar.v = 1;
                            }
                            a aVar3 = a.this;
                            aVar3.f9229b.a(context, view, aVar3.f9228a);
                        }
                    }

                    @Override // cn.jpush.android.ap.b.a
                    public boolean a(Object obj) {
                        return true;
                    }
                }));
            }
            if (this.f9228a != null && this.f9228a.t().bt) {
                z = true;
            }
            cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "message is fixed: " + z + ", banner auto dismiss time: " + f2.k());
            if (f2.i() && !z) {
                if (this.f9195e == null) {
                    aVar = new cn.jpush.android.ap.a();
                    this.f9195e = aVar;
                } else {
                    aVar = this.f9195e;
                }
                this.f9195e = aVar;
                this.f9195e.a(new a.InterfaceC0143a() { // from class: cn.jpush.android.aq.a.3
                    @Override // cn.jpush.android.ap.a.InterfaceC0143a
                    public void a() {
                        try {
                            cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "dismiss timer reach, dismiss in-app message");
                            if (a.this.f9228a != null) {
                                cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", a.this.f9228a.t(), false);
                            }
                            a.this.f().o();
                            int g3 = f2.g();
                            if (g3 <= 0) {
                                g3 = cn.jpush.android.af.a.a(context, cn.jpush.android.aw.e.f9426a);
                            }
                            Point point3 = new Point(0, (-f2.n()) - g3);
                            if (f2.e() >= 80) {
                                cn.jpush.android.af.a.a(context);
                                point3.y = g3;
                            }
                            a.this.a();
                            cn.jpush.android.ar.b.a(context, d2, point3, (long) f2.m(), new b.a() { // from class: cn.jpush.android.aq.a.3.1
                                @Override // cn.jpush.android.ar.b.a
                                public void a() {
                                    a aVar2 = a.this;
                                    if (aVar2.f9229b != null) {
                                        cn.jpush.android.aw.e eVar = aVar2.f9228a;
                                        if (eVar != null) {
                                            eVar.v = 2;
                                        }
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        a aVar3 = a.this;
                                        aVar3.f9229b.a(context, d2, aVar3.f9228a);
                                    }
                                }
                            });
                        } catch (Throwable th2) {
                            cn.jpush.android.r.b.f("InAppBannerBindingWrapper", "in-app slide to dismiss error." + th2.getMessage());
                        }
                    }
                }, (long) (f2.k() + f2.l()), 1000L);
            }
            cn.jpush.android.r.b.b("InAppBannerBindingWrapper", "in app animation with: slideToShow: " + f2.h() + " , autoSlideToDismiss: " + f2.i() + ", swipeToDismiss: " + f2.j());
            super.d(context);
            return;
        }
        cn.jpush.android.r.b.f("InAppBannerBindingWrapper", "startViewAnimation unexpected error occurred for param is null, view:" + d2 + "config:" + f2);
    }

    @Override // cn.jpush.android.aq.c
    public void b() {
        g();
        super.b();
    }
}
