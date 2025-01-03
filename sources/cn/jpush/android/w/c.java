package cn.jpush.android.w;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.aw.e;
import cn.jpush.android.aw.g;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends cn.jpush.android.webview.bridge.d {

    /* renamed from: f, reason: collision with root package name */
    public static String f9923f;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f9924a;

    /* renamed from: b, reason: collision with root package name */
    public final cn.jpush.android.d.d f9925b;

    /* renamed from: c, reason: collision with root package name */
    public e f9926c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9927d;

    /* renamed from: e, reason: collision with root package name */
    public int f9928e;

    public c(Context context, cn.jpush.android.d.d dVar) {
        super(context, dVar);
        this.f9927d = false;
        this.f9928e = 0;
        this.f9924a = new WeakReference<>((Activity) context);
        this.f9925b = dVar;
    }

    private JSONObject a(Context context) {
        String str;
        String str2;
        String str3;
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
        String str4 = "";
        if (onEvent instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) onEvent;
            str4 = jSONObject.optString("manufacturer", LogUtils.PLACEHOLDER);
            str2 = jSONObject.optString("model", LogUtils.PLACEHOLDER);
            str3 = d.a();
            str = jSONObject.optString("os_version", LogUtils.PLACEHOLDER);
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        if (f9923f == null) {
            f9923f = context.getResources().getConfiguration().locale.toString();
            cn.jpush.android.r.b.b("WebViewHelper", "device info language: " + f9923f);
        }
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        int i2 = a2.widthPixels;
        int i3 = a2.heightPixels;
        float f2 = a2.scaledDensity;
        int i4 = context.getResources().getConfiguration().orientation;
        String str5 = i4 == 2 ? "landscape" : "portrait";
        this.f9928e = i4;
        int i5 = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("manufacturer", str4);
        jSONObject2.put("model", str2);
        jSONObject2.put("romUIVersion", str3);
        jSONObject2.put("osVersion", str);
        jSONObject2.put("language", f9923f);
        jSONObject2.put("screenW", i2);
        jSONObject2.put("screenH", i3);
        jSONObject2.put("scaledDensity", f2);
        jSONObject2.put("orientation", str5);
        jSONObject2.put("currentTime", currentTimeMillis);
        jSONObject2.put("nightMode", i5);
        jSONObject2.put("is24Hour", is24HourFormat ? 1 : 0);
        cn.jpush.android.r.b.b("WebViewHelper", "device info: " + jSONObject2.toString());
        return jSONObject2;
    }

    public int a() {
        return this.f9928e;
    }

    public void a(e eVar) {
        this.f9926c = eVar;
        this.f9927d = false;
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public String getDevInfo() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return "";
            }
            Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
            if (onEvent instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) onEvent;
                str2 = jSONObject.optString("manufacturer", LogUtils.PLACEHOLDER);
                str3 = jSONObject.optString("model", LogUtils.PLACEHOLDER);
                str4 = d.a();
                str5 = jSONObject.optString("os_version", LogUtils.PLACEHOLDER);
                str = jSONObject.optString("language", LogUtils.PLACEHOLDER);
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
            int i2 = a2.widthPixels;
            int i3 = a2.heightPixels;
            float f2 = a2.scaledDensity;
            String str6 = context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
            int i4 = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
            int i5 = DateFormat.is24HourFormat(context) ? 1 : 0;
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("manufacturer", str2);
            jSONObject2.put("model", str3);
            jSONObject2.put("romUIVersion", str4);
            jSONObject2.put("osVersion", str5);
            jSONObject2.put("language", str);
            jSONObject2.put("screenW", i2);
            jSONObject2.put("screenH", i3);
            jSONObject2.put("scaledDensity", f2);
            jSONObject2.put("orientation", str6);
            jSONObject2.put("currentTime", currentTimeMillis);
            jSONObject2.put("nightMode", i4);
            jSONObject2.put("is24Hour", i5);
            cn.jpush.android.r.b.b("WebViewHelper", "[getDevInfo] device info, " + jSONObject2.toString());
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public String getNotificationInfo() {
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return "";
            }
            JSONObject a2 = a(context);
            Bitmap c2 = cn.jpush.android.bg.b.c(context, context.getPackageName());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            c2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
            String charSequence = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", charSequence);
            jSONObject.put("icon", str);
            cn.jpush.android.r.b.b("WebViewHelper", "appInfo:" + jSONObject.toString());
            JSONObject b2 = cn.jpush.android.au.a.b(context);
            String c3 = cn.jpush.android.au.a.c(context);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON h5Extras:" + c3);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON devInfo:" + a2);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON appInfo:" + jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", a2);
            jSONObject2.put("app", jSONObject);
            jSONObject2.put("container", b2);
            jSONObject2.put("h5_extras", c3);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON:" + jSONObject2.toString());
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public String getTplData() {
        e eVar = this.f9926c;
        if (eVar == null) {
            return "";
        }
        String r = eVar.r();
        cn.jpush.android.r.b.b("WebViewHelper", "[getTplData] js get template data: " + r);
        return r;
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public String getTplExtraData() {
        Context context;
        if (this.f9926c == null || (context = JPushConstants.mApplicationContext) == null) {
            return "";
        }
        try {
            JSONObject a2 = a(context);
            JSONObject b2 = g.b(context, this.f9926c);
            if (b2 == null) {
                return "";
            }
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON devInfo:" + a2);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON container:" + b2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device", a2);
            jSONObject.put("container", b2);
            cn.jpush.android.r.b.b("WebViewHelper", "containerJSON:" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public void inAppClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("actionType");
            String optString = jSONObject.optString("param");
            cn.jpush.android.r.b.b("WebViewHelper", "h5 click, actionType: " + optInt + ", actionKey: " + optString + ", param: " + str);
            cn.jpush.android.an.a.a().a(this.f9926c, optInt, optString);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("WebViewHelper", "h5 click failed, " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public void onLoadCallback(String str) {
        try {
            cn.jpush.android.r.b.b("WebViewHelper", "onLoadCallback : " + str);
            if (this.f9927d) {
                cn.jpush.android.r.b.b("WebViewHelper", "js callback already, param: " + str);
                return;
            }
            this.f9927d = true;
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.f9924a.get() != null) {
                context = this.f9924a.get().getApplicationContext();
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("statusCode");
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG);
            if (optInt != 0) {
                cn.jpush.android.r.b.g("WebViewHelper", "msg tpl load failed, code: " + optInt + ", errMsg: " + optString);
            }
            cn.jpush.android.an.a.a().a(context, this.f9926c, optInt);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("WebViewHelper", "[onLoadCallback] parse param error. " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.webview.bridge.d
    @JavascriptInterface
    public void reportData(String str) {
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.f9924a.get() != null) {
                context = this.f9924a.get().getApplicationContext();
            }
            cn.jpush.android.r.b.b("WebViewHelper", "[reportData] report data: " + str);
            String optString = new JSONObject(str).optString("content");
            if (TextUtils.isEmpty(optString) || this.f9926c == null) {
                return;
            }
            cn.jpush.android.an.a.a().a(context, this.f9926c, optString);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("WebViewHelper", "[reportData] report data failed. " + th.getMessage());
        }
    }
}
