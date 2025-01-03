package cn.jpush.android.webview.bridge;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class b extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final String f9940a = "InjectedChromeClient";

    /* renamed from: b, reason: collision with root package name */
    public c f9941b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9942c;

    public b(String str, Class cls) {
        this.f9941b = new c(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        jsPromptResult.confirm(this.f9941b.a(webView, str2));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        webView.getSettings().setSavePassword(false);
        if (Build.VERSION.SDK_INT < 17) {
            if (i2 <= 25) {
                this.f9942c = false;
            } else if (!this.f9942c) {
                Logger.d("InjectedChromeClient", "Android sdk version lesser than 17, Java—Js interact by injection!");
                webView.loadUrl(this.f9941b.a());
                this.f9942c = true;
                Logger.d("InjectedChromeClient", " inject js interface completely on progress " + i2);
            }
        }
        super.onProgressChanged(webView, i2);
    }
}
