package cn.jpush.android.aq;

import android.R;
import android.content.Context;
import android.graphics.Region;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.bm.i;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final cn.jpush.android.aw.e f9228a;

    /* renamed from: b, reason: collision with root package name */
    public a f9229b;

    /* renamed from: c, reason: collision with root package name */
    public Region f9230c = new Region();

    /* renamed from: d, reason: collision with root package name */
    public boolean f9231d = false;

    /* renamed from: e, reason: collision with root package name */
    public final cn.jpush.android.au.c f9232e;

    /* renamed from: f, reason: collision with root package name */
    public WebView f9233f;

    /* renamed from: g, reason: collision with root package name */
    public cn.jpush.android.w.c f9234g;

    /* renamed from: h, reason: collision with root package name */
    public WindowManager.LayoutParams f9235h;

    public interface a {
        void a(Context context, View view);

        void a(Context context, View view, Object obj);
    }

    public c(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        this.f9232e = cVar;
        this.f9228a = eVar;
    }

    private void g() {
        try {
            i.a(this.f9233f, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{this.f9234g, "JPushWeb"});
        } catch (Throwable th) {
            cn.jpush.android.r.b.h("InAppBindingWrapper", "addJavascriptInterface failed:" + th.toString());
        }
    }

    public View a() {
        return null;
    }

    public Object a(Context context, cn.jpush.android.au.c cVar, boolean z, WindowManager windowManager, View view) {
        int i2;
        if (cVar == null || context == null) {
            i2 = 105;
        } else {
            try {
                int d2 = cVar.d() | OSSConstants.DEFAULT_STREAM_BUFFER_SIZE | 32 | 8;
                int i3 = z ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2003 : 1003;
                DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
                cVar.c();
                cVar.b();
                int f2 = cVar.f();
                int g2 = cVar.g();
                int o = cVar.o();
                int n = cVar.n();
                int e2 = cVar.e();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(f2, g2, i3, d2, -3);
                this.f9235h = layoutParams;
                layoutParams.x = o;
                layoutParams.y = n;
                layoutParams.dimAmount = 0.3f;
                layoutParams.gravity = e2;
                layoutParams.windowAnimations = 0;
                windowManager.addView(view, layoutParams);
                cn.jpush.android.r.b.b("InAppBindingWrapper", "webview layout param, gravity: " + e2 + ", margin_x: " + o + ", margin_y: " + n + ", width: " + f2 + ", height: " + g2 + ", pixelsW: " + a2.widthPixels + ", pixelsH: " + a2.heightPixels);
                return this.f9235h;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppBindingWrapper", "[getLayoutParams] error." + th.getMessage());
                i2 = 106;
            }
        }
        return Integer.valueOf(i2);
    }

    public void a(Context context) {
    }

    public void a(WindowManager windowManager, Context context) {
        d(context);
    }

    public void a(a aVar) {
        this.f9229b = aVar;
    }

    public void b() {
        try {
            if (this.f9233f != null) {
                ViewParent parent = this.f9233f.getParent();
                if (parent != null) {
                    try {
                        cn.jpush.android.r.b.b("InAppBindingWrapper", "webview parent view " + parent);
                        ((ViewGroup) parent).removeView(this.f9233f);
                    } catch (Throwable unused) {
                        cn.jpush.android.r.b.f("InAppBindingWrapper", "release - parent not viewGroup");
                    }
                }
                this.f9233f.getSettings().setJavaScriptEnabled(false);
                this.f9233f.clearCache(true);
                this.f9233f.clearHistory();
                this.f9233f.clearView();
                this.f9233f.removeAllViews();
                this.f9233f.clearSslPreferences();
                this.f9233f.destroy();
                this.f9233f = null;
                cn.jpush.android.r.b.b("InAppBindingWrapper", "webview release completed.");
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppBindingWrapper", "web view destroy failed. error: " + th.getMessage());
        }
    }

    public boolean b(Context context) {
        return true;
    }

    public cn.jpush.android.aw.e c() {
        return this.f9228a;
    }

    public boolean c(Context context) {
        String str;
        if (context == null) {
            str = "unexpected error, context is null";
        } else {
            try {
                if (this.f9228a == null) {
                    cn.jpush.android.r.b.f("InAppBindingWrapper", "unexpected error, message is null");
                    return false;
                }
                String q = this.f9228a.q();
                if (TextUtils.isEmpty(q)) {
                    cn.jpush.android.r.b.f("InAppBindingWrapper", "in-app message web page url is empty, webview inflate failed.");
                    return false;
                }
                cn.jpush.android.r.b.d("InAppBindingWrapper", "webview inflate, templateData: " + this.f9228a.r());
                if (this.f9233f == null) {
                    WebView webView = new WebView(context);
                    this.f9233f = webView;
                    webView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
                    cn.jpush.android.r.b.b("InAppBindingWrapper", "create web view xxxxx");
                }
                this.f9233f.setHorizontalScrollBarEnabled(false);
                this.f9233f.setVerticalScrollBarEnabled(false);
                this.f9233f.setScrollbarFadingEnabled(true);
                this.f9233f.setScrollBarStyle(33554432);
                WebSettings settings = this.f9233f.getSettings();
                cn.jpush.android.bm.a.b(settings);
                cn.jpush.android.bm.a.a(this.f9233f);
                cn.jpush.android.bm.a.a(settings);
                cn.jpush.android.d.d t = this.f9228a.t();
                cn.jpush.android.w.c cVar = new cn.jpush.android.w.c(null, t);
                this.f9234g = cVar;
                cVar.a(this.f9228a);
                if (Build.VERSION.SDK_INT >= 17) {
                    cn.jpush.android.r.b.c("InAppBindingWrapper", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                    g();
                }
                this.f9233f.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                this.f9233f.setWebViewClient(new cn.jpush.android.av.a(t, context));
                HostJsScope.setWebViewHelper(this.f9234g);
                this.f9233f.loadUrl(q);
                cn.jpush.android.r.b.b("InAppBindingWrapper", "in-app message webview load url completed. visibility: " + this.f9233f.getVisibility() + ", url: " + q);
                return true;
            } catch (Throwable th) {
                str = "webview inflate failed. " + th.getMessage();
            }
        }
        cn.jpush.android.r.b.f("InAppBindingWrapper", str);
        return false;
    }

    public View d() {
        return this.f9233f;
    }

    public void d(Context context) {
        this.f9228a.w = SystemClock.elapsedRealtime();
    }

    public cn.jpush.android.w.c e() {
        return this.f9234g;
    }

    public cn.jpush.android.au.c f() {
        return this.f9232e;
    }
}
