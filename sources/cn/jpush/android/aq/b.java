package cn.jpush.android.aq;

import android.content.Context;
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
public class b extends c {

    /* renamed from: e, reason: collision with root package name */
    public cn.jpush.android.ap.a f9207e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f9208f;

    /* renamed from: g, reason: collision with root package name */
    public int f9209g;

    /* renamed from: h, reason: collision with root package name */
    public int f9210h;

    public b(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        super(cVar, eVar);
        this.f9209g = -1;
        this.f9210h = -1;
    }

    private void g() {
        cn.jpush.android.ap.a aVar = this.f9207e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // cn.jpush.android.aq.c
    public View a() {
        return this.f9208f;
    }

    @Override // cn.jpush.android.aq.c
    public Object a(Context context, cn.jpush.android.au.c cVar, boolean z, final WindowManager windowManager, View view) {
        int i2;
        cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "getLayoutParams");
        if (cVar == null || context == null) {
            i2 = 105;
        } else {
            try {
                int d2 = cVar.d() | OSSConstants.DEFAULT_STREAM_BUFFER_SIZE | 32 | 8;
                int i3 = z ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2003 : 1003;
                boolean z2 = context.getResources().getConfiguration().orientation == 2;
                int g2 = cn.jpush.android.au.a.g(context, z2);
                int h2 = cn.jpush.android.au.a.h(context, z2);
                int c2 = cn.jpush.android.au.a.c(context, z2);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, c2, i3, d2, -3);
                layoutParams.dimAmount = 0.3f;
                layoutParams.gravity = 48;
                layoutParams.windowAnimations = 0;
                cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "dialog view w: " + g2 + ", h: " + h2 + ",heightMax:" + c2);
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(g2, h2, i3, d2, -3);
                LinearLayout linearLayout = new LinearLayout(context);
                this.f9208f = linearLayout;
                linearLayout.addView(view, layoutParams2);
                layoutParams.y = g.b(context);
                this.f9208f.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: cn.jpush.android.aq.b.1

                    /* renamed from: a, reason: collision with root package name */
                    public int f9211a = -100;

                    /* renamed from: b, reason: collision with root package name */
                    public int f9212b = -100;

                    /* renamed from: c, reason: collision with root package name */
                    public int f9213c = -100;

                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                        int width = view2.getWidth();
                        if (-100 == this.f9212b || -100 == this.f9213c) {
                            DisplayMetrics a2 = cn.jpush.android.af.a.a(view2.getContext());
                            this.f9212b = a2.widthPixels;
                            this.f9213c = a2.heightPixels;
                        }
                        if (this.f9212b == width || this.f9213c == width) {
                            if (-100 == this.f9211a) {
                                this.f9211a = width;
                            }
                            if (this.f9211a != width) {
                                windowManager.removeViewImmediate(view2);
                                cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "linearLayout onLayoutChange removeViewImmediate:" + this.f9211a);
                            }
                        }
                    }
                });
                windowManager.addView(this.f9208f, layoutParams);
                return layoutParams;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppBannerNotificationBindingWrapper", "[getLayoutParams] error." + th.getMessage());
                i2 = 106;
            }
        }
        return Integer.valueOf(i2);
    }

    @Override // cn.jpush.android.aq.c
    public void a(Context context) {
    }

    @Override // cn.jpush.android.aq.c
    public void a(final WindowManager windowManager, final Context context) {
        final View d2;
        final cn.jpush.android.au.c f2;
        cn.jpush.android.ap.a aVar;
        try {
            cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "startViewAnimation.");
            d2 = d();
            f2 = f();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppBannerNotificationBindingWrapper", "start in-app with animation error. " + th.getMessage());
        }
        if (f2 != null && d2 != null) {
            boolean b2 = ((cn.jpush.android.aw.b) c()).b();
            final View a2 = a();
            cn.jpush.android.ar.b.a(context, d2, a2, new b.a() { // from class: cn.jpush.android.aq.b.2
                @Override // cn.jpush.android.ar.b.a
                public void a() {
                    cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "in-app message show success use animation.");
                    cn.jpush.android.aw.e eVar = b.this.f9228a;
                    if (eVar != null) {
                        eVar.w = SystemClock.elapsedRealtime();
                    }
                    c.a aVar2 = b.this.f9229b;
                    if (aVar2 != null) {
                        aVar2.a(context, d2);
                    }
                }
            }, windowManager, b2);
            if (f2.j()) {
                d2.setOnTouchListener(new cn.jpush.android.ap.b(this, null, new b.a() { // from class: cn.jpush.android.aq.b.3
                    @Override // cn.jpush.android.ap.b.a
                    public void a(View view, Object obj) {
                        b bVar = b.this;
                        if (bVar.f9229b != null) {
                            cn.jpush.android.aw.e eVar = bVar.f9228a;
                            if (eVar != null) {
                                eVar.v = 1;
                            }
                            b bVar2 = b.this;
                            bVar2.f9229b.a(context, view, bVar2.f9228a);
                        }
                    }

                    @Override // cn.jpush.android.ap.b.a
                    public boolean a(Object obj) {
                        return true;
                    }
                }));
            }
            boolean z = this.f9228a != null && this.f9228a.t().bt;
            cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "message is fixed: " + z + ", banner auto dismiss time: " + f2.k());
            if (f2.i() && !z) {
                if (this.f9207e == null) {
                    aVar = new cn.jpush.android.ap.a();
                    this.f9207e = aVar;
                } else {
                    aVar = this.f9207e;
                }
                cn.jpush.android.ap.a aVar2 = aVar;
                this.f9207e = aVar2;
                aVar2.a(new a.InterfaceC0143a() { // from class: cn.jpush.android.aq.b.4
                    @Override // cn.jpush.android.ap.a.InterfaceC0143a
                    public void a() {
                        try {
                            cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "dismiss timer reach, dismiss in-app message");
                            if (b.this.f9228a != null) {
                                cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", b.this.f9228a.t(), false);
                            }
                            f2.m();
                            cn.jpush.android.ar.b.a(context, d2, a2, new b.a() { // from class: cn.jpush.android.aq.b.4.1
                                @Override // cn.jpush.android.ar.b.a
                                public void a() {
                                    b bVar = b.this;
                                    if (bVar.f9229b != null) {
                                        cn.jpush.android.aw.e eVar = bVar.f9228a;
                                        if (eVar != null) {
                                            eVar.v = 2;
                                        }
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        b bVar2 = b.this;
                                        bVar2.f9229b.a(context, d2, bVar2.f9228a);
                                    }
                                }
                            }, windowManager);
                        } catch (Throwable th2) {
                            cn.jpush.android.r.b.f("InAppBannerNotificationBindingWrapper", "in-app slide to dismiss error." + th2.getMessage());
                        }
                    }
                }, (long) f2.k(), 1000L);
            }
            cn.jpush.android.r.b.b("InAppBannerNotificationBindingWrapper", "in app animation with: slideToShow: " + f2.h() + " , autoSlideToDismiss: " + f2.i() + ", swipeToDismiss: " + f2.j());
            super.d(context);
        }
    }

    @Override // cn.jpush.android.aq.c
    public void b() {
        g();
        super.b();
    }

    @Override // cn.jpush.android.aq.c
    public boolean b(Context context) {
        cn.jpush.android.w.c e2 = e();
        return e2 != null && e2.a() == context.getResources().getConfiguration().orientation;
    }
}
