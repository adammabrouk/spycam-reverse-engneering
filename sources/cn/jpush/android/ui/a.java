package cn.jpush.android.ui;

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
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final d f9871a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f9872b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9873c = false;

    /* renamed from: d, reason: collision with root package name */
    public String f9874d = "";

    /* renamed from: f, reason: collision with root package name */
    public boolean f9876f = false;

    /* renamed from: e, reason: collision with root package name */
    public Queue<String> f9875e = new PriorityQueue();

    public a(d dVar, Context context) {
        this.f9871a = dVar;
        this.f9872b = context;
    }

    private void a(String str, int i2, int i3) {
        String d2;
        try {
            if (!this.f9876f || this.f9871a == null || TextUtils.isEmpty(this.f9871a.be)) {
                return;
            }
            String str2 = this.f9871a.f9700d;
            if (TextUtils.isEmpty(str2)) {
                d2 = "";
            } else {
                d2 = cn.jpush.android.bm.a.d(str2 + i3 + i2);
            }
            if (TextUtils.isEmpty(d2) || this.f9875e.contains(d2)) {
                return;
            }
            this.f9875e.add(d2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("url_result", i3);
            cn.jpush.android.l.c.a(this.f9872b, str2, i2, "", 0, "", jSONObject);
        } catch (Throwable unused) {
            Logger.w("JPushWebViewClient", "report code failed");
        }
    }

    private boolean a(String str) {
        boolean z = true;
        try {
            Intent a2 = str.startsWith("android-app://") ? Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.bm.a.a(str, 2) : null : cn.jpush.android.bm.a.a(str, 1);
            if (this.f9872b != null && a2 != null) {
                PackageManager packageManager = this.f9872b.getPackageManager();
                if (packageManager != null && packageManager.resolveActivity(a2, 0) == null) {
                    Logger.w("JPushWebViewClient", "open deeplink intent can be not resolved, url: " + str);
                    return true;
                }
                a2.addCategory("android.intent.category.BROWSABLE");
                if (!str.startsWith("android-app://")) {
                    a2.setComponent(null);
                }
                Intent a3 = cn.jpush.android.bm.a.a(str, 0);
                a3.setFlags(268435456);
                this.f9872b.startActivity(a3);
                Logger.d("JPushWebViewClient", "h5 open deeplink success, url: " + str);
            }
        } catch (Throwable th) {
            Logger.w("JPushWebViewClient", "[openDeeplink] Bad URI " + str + ": " + th.getMessage());
            z = false;
        }
        int i2 = z ? 976 : 977;
        if (TextUtils.isEmpty(this.f9871a.be)) {
            cn.jpush.android.helper.c.a(this.f9871a.f9700d, i2, this.f9872b);
        } else {
            cn.jpush.android.l.c.a(this.f9872b, this.f9871a.f9700d, z ? 1214 : 1215, 0);
        }
        return z;
    }

    public String a() {
        return this.f9874d;
    }

    public void a(boolean z) {
        this.f9876f = z;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f9874d = str;
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
        Logger.ww("JPushWebViewClient", "onReceivedSslError stop show:" + webView.getUrl());
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        Context context = webView.getContext();
        Logger.i("JPushWebViewClient", "Url vaule is :" + str);
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
                    Logger.dd("JPushWebViewClient", "google play not allowed");
                    return true;
                }
                if (str.startsWith("http")) {
                    if (TextUtils.isEmpty(this.f9871a.be)) {
                        cn.jpush.android.helper.c.a(this.f9871a.f9700d, 1016, format, this.f9872b);
                    } else {
                        cn.jpush.android.l.c.a(context, this.f9871a.f9700d, 1252, "", 0, "", new JSONObject(format));
                    }
                    return false;
                }
                if (!str.startsWith("mailto")) {
                    return a(str);
                }
                if (str.lastIndexOf("direct=") < 0 && !str.startsWith("mailto")) {
                    if (str.indexOf("?") > 0) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("&direct=false");
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("?direct=false");
                    }
                    str = sb.toString();
                    str.lastIndexOf("direct=");
                }
                int indexOf = str.indexOf("?");
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf);
                Logger.v("JPushWebViewClient", "Uri: " + substring);
                Logger.v("JPushWebViewClient", "QueryString: " + substring2);
                Intent intent2 = null;
                if (substring.startsWith("mailto")) {
                    String[] split = substring.split(":");
                    if (split.length == 2) {
                        int indexOf2 = substring2.indexOf("title=") + 6;
                        int indexOf3 = substring2.indexOf("&content=");
                        String substring3 = substring2.substring(indexOf2, indexOf3);
                        String substring4 = substring2.substring(indexOf3 + 9);
                        String[] strArr = {split[1]};
                        Intent intent3 = new Intent("android.intent.action.SEND");
                        intent3.setType("plain/text");
                        intent3.putExtra("android.intent.extra.EMAIL", strArr);
                        intent3.putExtra("android.intent.extra.SUBJECT", substring3);
                        intent3.putExtra("android.intent.extra.TEXT", substring4);
                        intent2 = intent3;
                    }
                }
                if (intent2 != null) {
                    context.startActivity(intent2);
                }
                cn.jpush.android.helper.c.a(this.f9871a.f9700d, 1016, format, JPushConstants.mApplicationContext);
                return true;
            }
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "video/*");
            webView.getContext().startActivity(intent4);
            return true;
        } catch (Throwable unused) {
            Logger.e("JPushWebViewClient", "Invalid url");
            return true;
        }
    }
}
