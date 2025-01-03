package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.bm.e;
import cn.jpush.android.bm.i;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends ProxyActivityAction {

    /* renamed from: a, reason: collision with root package name */
    public static d f9881a;

    /* renamed from: d, reason: collision with root package name */
    public String f9884d;

    /* renamed from: f, reason: collision with root package name */
    public WebView f9886f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f9887g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f9888h;

    /* renamed from: i, reason: collision with root package name */
    public ImageButton f9889i;
    public ProgressBar j;
    public a k;

    /* renamed from: b, reason: collision with root package name */
    public int f9882b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9883c = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9885e = false;
    public View.OnClickListener l = new View.OnClickListener() { // from class: cn.jpush.android.ui.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
                        return;
                    }
                    ((Activity) view.getContext()).onBackPressed();
                } catch (Throwable unused) {
                }
            }
        }
    };

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.bg.b.a(activity, activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PushActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        Logger.d("PushActivityImpl", "content:" + uri);
        return cn.jpush.android.bl.b.a(activity, uri, "");
    }

    private void a(Activity activity, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else if (dVar.r == 0) {
            activity.setRequestedOrientation(1);
            b(activity, dVar);
            return;
        } else {
            Logger.w("PushActivityImpl", "Invalid msg type to show - " + dVar.r);
            cn.jpush.android.bg.b.c(activity, dVar);
        }
        activity.finish();
    }

    private void b() {
        try {
            i.a(this.f9886f, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f9881a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PushActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void b(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                this.f9883c = activity.getIntent().getBooleanExtra(PushActivity.FROM_OTHER_WAY, false);
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                if (a2 != null) {
                    this.f9884d = a2.f9700d;
                    this.f9885e = TextUtils.isEmpty(a2.be) ? false : true;
                    a(activity, a2);
                    cn.jpush.android.ba.a.a(activity, a2);
                    if (this.f9885e) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", a2.W);
                        cn.jpush.android.l.c.a(activity.getApplicationContext(), this.f9884d, 1311, "", 0, "", jSONObject);
                    }
                } else {
                    Logger.ww("PushActivityImpl", "Warning，null message entity! Close PushActivity!");
                    activity.finish();
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PushActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PushActivityImpl", "PushActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity, cn.jpush.android.d.d dVar) {
        String str;
        Logger.i("PushActivityImpl", "Action: processShow");
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else {
            if (dVar.ab != 0) {
                return;
            }
            this.f9882b = dVar.Z;
            int identifier = activity.getResources().getIdentifier("jpush_webview_layout", "layout", activity.getPackageName());
            if (identifier == 0) {
                str = "Please add layout resource jpush_webview_layout.xml to res/layout !";
            } else {
                activity.setContentView(identifier);
                String str2 = dVar.W;
                if (cn.jpush.android.bm.a.c(str2)) {
                    String str3 = dVar.Y;
                    if (dVar.s) {
                        int identifier2 = activity.getResources().getIdentifier("actionbarLayoutId", "id", activity.getPackageName());
                        if (identifier2 == 0) {
                            str = "Please use default code in jpush_webview_layout.xml!";
                        } else {
                            View findViewById = activity.findViewById(identifier2);
                            if (findViewById != null) {
                                a(activity, findViewById, dVar);
                                if (TextUtils.isEmpty(str3) || !new File(str3.replace("file://", "")).exists() || this.f9883c) {
                                    this.f9886f.loadUrl(str2);
                                } else {
                                    this.f9886f.loadUrl(str3);
                                }
                            }
                        }
                    }
                    if (!this.f9883c && !this.f9885e) {
                        cn.jpush.android.helper.c.a(this.f9884d, 1000, activity.getApplicationContext());
                    }
                    int i2 = dVar.aa;
                    return;
                }
                cn.jpush.android.bg.b.c(activity, dVar);
            }
            Logger.ee("PushActivityImpl", str);
        }
        activity.finish();
    }

    private void c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags &= -1025;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().clearFlags(512);
        } catch (Throwable unused) {
            Logger.w("PushActivityImpl", "quitFullScreen errno");
        }
    }

    public void a() {
        try {
            if (this.f9887g == null || this.f9887g.getVisibility() != 8) {
                return;
            }
            this.f9887g.setVisibility(0);
            c((Activity) this.f9887g.getContext());
            this.f9889i.setOnClickListener(this.l);
            if (this.f9886f != null) {
                this.f9886f.postDelayed(new e("PushActivityImpl#showTitleBar") { // from class: cn.jpush.android.ui.c.3
                    @Override // cn.jpush.android.bm.e
                    public void a() {
                        try {
                            if (c.this.f9886f != null) {
                                c.this.f9886f.clearHistory();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Activity activity) {
        activity.finish();
        if (1 == this.f9882b) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                ComponentName componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                ComponentName componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                Logger.d("PushActivityImpl", "baseActivity  = " + componentName.toString());
                Logger.d("PushActivityImpl", "topActivity  = " + componentName2.toString());
                if (componentName == null || componentName2 == null || !componentName2.toString().equals(componentName.toString())) {
                    return;
                }
                cn.jpush.android.bm.a.f(activity);
            } catch (Throwable unused) {
                Logger.ww("PushActivityImpl", "Get running tasks failed.");
                cn.jpush.android.bm.a.f(activity);
            }
        }
    }

    public void a(Activity activity, View view, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.X;
            view.setFocusable(true);
            int identifier = activity.getResources().getIdentifier("fullWebView", "id", activity.getPackageName());
            if (identifier > 0) {
                ((LinearLayout) view).removeView(activity.findViewById(identifier));
            }
            WebView webView = new WebView(activity.getApplicationContext());
            this.f9886f = webView;
            webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f9886f.setBackgroundColor(Color.parseColor("#000000"));
            ((LinearLayout) view).addView(this.f9886f);
            this.f9887g = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlRichpushTitleBar", "id", activity.getPackageName()));
            this.f9888h = (TextView) activity.findViewById(activity.getResources().getIdentifier("tvRichpushTitle", "id", activity.getPackageName()));
            this.f9889i = (ImageButton) activity.findViewById(activity.getResources().getIdentifier("imgRichpushBtnBack", "id", activity.getPackageName()));
            this.j = (ProgressBar) activity.findViewById(activity.getResources().getIdentifier("pushPrograssBar", "id", activity.getPackageName()));
            if (this.f9886f == null || this.f9887g == null || this.f9888h == null || this.f9889i == null) {
                Logger.ee("PushActivityImpl", "Please use default code in jpush_webview_layout.xml!");
                activity.finish();
            }
            if (1 == dVar.aa) {
                this.f9887g.setVisibility(8);
                activity.getWindow().setFlags(1024, 1024);
            } else {
                this.f9888h.setText(str);
                this.f9889i.setOnClickListener(this.l);
                k.a(activity.getApplicationContext(), this.f9889i, true, 10, 6, 10, 6);
            }
            this.f9886f.setScrollbarFadingEnabled(true);
            this.f9886f.setScrollBarStyle(33554432);
            WebSettings settings = this.f9886f.getSettings();
            cn.jpush.android.bm.a.b(settings);
            cn.jpush.android.bm.a.a(this.f9886f);
            cn.jpush.android.bm.a.a(settings);
            settings.setSavePassword(false);
            f9881a = new d(activity, dVar);
            if (Build.VERSION.SDK_INT >= 17) {
                Logger.dd("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                Logger.d("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                b();
            }
            this.f9886f.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, this.j, this.f9888h));
            a aVar = new a(dVar, activity);
            this.k = aVar;
            aVar.a(this.f9885e);
            this.f9886f.setWebViewClient(this.k);
            HostJsScope.setWebViewHelper(f9881a);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        WebView webView = this.f9886f;
        if (webView != null && webView.canGoBack()) {
            this.f9886f.goBack();
            return;
        }
        if (this.f9885e) {
            cn.jpush.android.l.c.a(activity.getApplicationContext(), this.f9884d, 1251, 0);
        } else {
            cn.jpush.android.helper.c.a(this.f9884d, 1006, activity);
        }
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.bm.a.e(activity);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        if (this.f9886f != null) {
            if (this.f9885e && !TextUtils.isEmpty(this.f9884d) && activity != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", this.k != null ? this.k.a() : "");
                    cn.jpush.android.l.c.a(activity.getApplicationContext(), this.f9884d, 1313, "", 0, "", jSONObject);
                } catch (Throwable unused) {
                }
            }
            ViewParent parent = this.f9886f.getParent();
            if (parent != null) {
                Logger.d("PushActivityImpl", "webview parent view " + parent.toString());
                ((ViewGroup) parent).removeView(this.f9886f);
            }
            this.f9886f.getSettings().setJavaScriptEnabled(false);
            this.f9886f.clearCache(true);
            this.f9886f.clearHistory();
            this.f9886f.clearView();
            this.f9886f.removeAllViews();
            this.f9886f.clearSslPreferences();
            this.f9886f.destroy();
            this.f9886f = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("push_show_titlebar")) {
            return;
        }
        activity.runOnUiThread(new e("PushActivityImpl#onEvent") { // from class: cn.jpush.android.ui.c.1
            @Override // cn.jpush.android.bm.e
            public void a() {
                c.this.a();
            }
        });
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
        activity.setIntent(intent);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f9886f;
        if (webView == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        webView.onPause();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.f9886f;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.onResume();
            }
            HostJsScope.setWebViewHelper(f9881a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
