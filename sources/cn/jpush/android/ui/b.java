package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.bm.i;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import java.io.File;

/* loaded from: classes.dex */
public class b extends ProxyActivityAction {

    /* renamed from: a, reason: collision with root package name */
    public static d f9877a;

    /* renamed from: b, reason: collision with root package name */
    public String f9878b;

    /* renamed from: c, reason: collision with root package name */
    public WebView f9879c;

    /* renamed from: d, reason: collision with root package name */
    public cn.jpush.android.d.d f9880d = null;

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.bg.b.a(activity.getApplicationContext(), activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PopWinActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        return cn.jpush.android.bl.b.a(activity, uri, "");
    }

    private void a() {
        try {
            i.a(this.f9879c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f9877a, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("PopWinActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void a(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                this.f9880d = a2;
                if (a2 != null) {
                    this.f9878b = a2.f9700d;
                    b(activity);
                    c(activity);
                    cn.jpush.android.ba.a.a(activity, this.f9880d);
                } else {
                    Logger.ww("PopWinActivityImpl", "Warning，null message entity! Close PopWinActivity!");
                    activity.finish();
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PopWinActivityImpl", "Extra data is not serializable!" + th);
            }
        } else {
            Logger.ww("PopWinActivityImpl", "PopWinActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity) {
        int identifier = activity.getResources().getIdentifier("jpush_popwin_layout", "layout", activity.getPackageName());
        if (identifier == 0) {
            Logger.ee("PopWinActivityImpl", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
            activity.finish();
            return;
        }
        activity.setContentView(identifier);
        int identifier2 = activity.getResources().getIdentifier("wvPopwin", "id", activity.getPackageName());
        if (identifier2 == 0) {
            Logger.ee("PopWinActivityImpl", "Please use default code in jpush_popwin_layout.xml!");
            activity.finish();
            return;
        }
        WebView webView = (WebView) activity.findViewById(identifier2);
        this.f9879c = webView;
        if (webView == null) {
            Logger.ee("PopWinActivityImpl", "Can not get webView in layout file!");
            activity.finish();
            return;
        }
        webView.setScrollbarFadingEnabled(true);
        this.f9879c.setScrollBarStyle(33554432);
        WebSettings settings = this.f9879c.getSettings();
        settings.setDomStorageEnabled(true);
        cn.jpush.android.bm.a.b(settings);
        cn.jpush.android.bm.a.a(this.f9879c);
        cn.jpush.android.bm.a.a(settings);
        settings.setSavePassword(false);
        this.f9879c.setBackgroundColor(0);
        f9877a = new d(activity, this.f9880d);
        if (Build.VERSION.SDK_INT >= 17) {
            Logger.dd("PopWinActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            a();
        }
        this.f9879c.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
        this.f9879c.setWebViewClient(new a(this.f9880d, activity));
        HostJsScope.setWebViewHelper(f9877a);
    }

    private void c(Activity activity) {
        cn.jpush.android.d.d dVar = this.f9880d;
        String str = dVar.Y;
        String str2 = dVar.W;
        Logger.d("PopWinActivityImpl", "showUrl = " + str2);
        if (TextUtils.isEmpty(str) || !new File(str.replace("file://", "")).exists()) {
            this.f9879c.loadUrl(str2);
        } else {
            this.f9879c.loadUrl(str);
        }
        cn.jpush.android.helper.c.a(this.f9878b, 1000, activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        cn.jpush.android.helper.c.a(this.f9878b, 1006, activity.getApplicationContext());
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.bm.a.e(activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f9879c;
        if (webView != null) {
            webView.removeAllViews();
            this.f9879c.destroy();
            this.f9879c = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("start_push_activity") || this.f9880d == null || this.f9879c == null) {
            return;
        }
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            this.f9880d.W = string;
            Intent intent = new Intent(activity, (Class<?>) PushActivity.class);
            intent.putExtra("msg_data", this.f9880d.c());
            intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
            intent.setFlags(335544320);
            activity.startActivity(intent);
        }
        activity.finish();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f9879c;
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
        WebView webView = this.f9879c;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.onResume();
            }
            HostJsScope.setWebViewHelper(f9877a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
