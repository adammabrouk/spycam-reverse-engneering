package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public ProgressBar f9938a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f9939b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.f9938a = progressBar;
        this.f9939b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.f9939b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.f9939b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        ProgressBar progressBar = this.f9938a;
        if (progressBar != null) {
            if (100 == i2) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.f9938a.setProgress(i2);
            }
        }
        if (this.f9939b == null || webView.getTitle() == null || webView.getTitle().equals(this.f9939b.getText())) {
            return;
        }
        String title = webView.getTitle();
        if (title.startsWith("http") || title.startsWith("android-app://") || title.startsWith("file://")) {
            return;
        }
        this.f9939b.setText(webView.getTitle());
    }
}
