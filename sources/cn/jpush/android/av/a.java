package cn.jpush.android.av;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.d.d;
import cn.jpush.android.l.c;
import cn.jpush.android.r.b;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final d f9379a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f9380b;

    /* renamed from: d, reason: collision with root package name */
    public String f9382d = "";

    /* renamed from: e, reason: collision with root package name */
    public boolean f9383e = false;

    /* renamed from: c, reason: collision with root package name */
    public Queue<String> f9381c = new PriorityQueue();

    public a(d dVar, Context context) {
        this.f9379a = dVar;
        this.f9380b = context;
    }

    private void a(String str, int i2, int i3) {
        String d2;
        try {
            if (!this.f9383e || this.f9379a == null || TextUtils.isEmpty(this.f9379a.be)) {
                return;
            }
            String str2 = this.f9379a.f9700d;
            if (TextUtils.isEmpty(str2)) {
                d2 = "";
            } else {
                d2 = cn.jpush.android.bm.a.d(str2 + i3 + i2);
            }
            if (TextUtils.isEmpty(d2) || this.f9381c.contains(d2)) {
                return;
            }
            this.f9381c.add(d2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("url_result", i3);
            c.a(this.f9380b, str2, i2, "", 0, "", jSONObject);
        } catch (Throwable unused) {
            b.f("UnionWebClient", "report code failed");
        }
    }

    private boolean a(String str) {
        boolean z = true;
        try {
            Intent a2 = str.startsWith("android-app://") ? Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.bm.a.a(str, 2) : null : cn.jpush.android.bm.a.a(str, 1);
            if (this.f9380b != null && a2 != null) {
                PackageManager packageManager = this.f9380b.getPackageManager();
                if (packageManager != null && packageManager.resolveActivity(a2, 0) == null) {
                    b.f("UnionWebClient", "open deeplink intent can be not resolved, url: " + str);
                    return true;
                }
                a2.addCategory("android.intent.category.BROWSABLE");
                if (!str.startsWith("android-app://")) {
                    a2.setComponent(null);
                }
                Intent a3 = cn.jpush.android.bm.a.a(str, 0);
                a3.setFlags(268435456);
                this.f9380b.startActivity(a3);
                b.b("UnionWebClient", "h5 open deeplink success, url: " + str);
            }
        } catch (Throwable th) {
            b.f("UnionWebClient", "[openDeeplink] Bad URI " + str + ": " + th.getMessage());
            z = false;
        }
        if (!TextUtils.isEmpty(this.f9379a.be)) {
            c.a(this.f9380b, this.f9379a.f9700d, z ? 1214 : 1215, 0);
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f9382d = str;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        a(str, 1312, 0);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        a(str2, 1314, i2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            a(webResourceRequest.getUrl().toString(), 1314, webResourceError.getErrorCode());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT >= 21) {
            a(webResourceRequest.getUrl().toString(), 1314, 101);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(sslError.getUrl(), 1314, 102);
        }
        b.g("UnionWebClient", "onReceivedSslError stop show:" + webView.getUrl());
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context = webView.getContext();
        b.d("UnionWebClient", "Url vaule is :" + str);
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.bm.a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", str);
            if (str.endsWith(".mp3")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "audio/*");
                webView.getContext().startActivity(intent);
                return true;
            }
            if (!str.endsWith(".mp4") && !str.endsWith(".3gp")) {
                if (str.endsWith(".apk")) {
                    b.c("UnionWebClient", "google play not allowed");
                    return true;
                }
                if (!str.startsWith("http") || TextUtils.isEmpty(this.f9379a.be)) {
                    return a(str);
                }
                c.a(context, this.f9379a.f9700d, 1252, "", 0, "", new JSONObject(format));
                return false;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setDataAndType(Uri.parse(str), "video/*");
            webView.getContext().startActivity(intent2);
            return true;
        } catch (Throwable unused) {
            b.h("UnionWebClient", "Invalid url");
            return true;
        }
    }
}
