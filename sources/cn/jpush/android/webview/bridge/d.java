package cn.jpush.android.webview.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.shix.shixipc.utilcode.LogUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static String f9946d;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f9947a;

    /* renamed from: b, reason: collision with root package name */
    public final cn.jpush.android.d.d f9948b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9949c = false;

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.f9947a = new WeakReference<>((Activity) context);
        this.f9948b = dVar;
    }

    private void a(String str) {
        int i2;
        try {
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
                i2 = LogUtils.MAX_LEN;
            }
            cn.jpush.android.helper.c.a(this.f9948b.f9700d, i2, JPushConstants.mApplicationContext);
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        Logger.d("WebViewHelper", "Web callback:click - actionId:" + str + ", shouldClose:" + str2 + ", shouldCancelNotification:" + str3);
        try {
            a(str);
            boolean parseBoolean = Boolean.parseBoolean(str2);
            if (Boolean.parseBoolean(str3)) {
                cn.jpush.android.bg.b.c(JPushConstants.mApplicationContext, this.f9948b);
            }
            if (!parseBoolean || this.f9947a.get() == null) {
                return;
            }
            this.f9947a.get().finish();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.f9947a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.f9947a.get().finish();
        }
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }

    @JavascriptInterface
    public void download(String str) {
        if (this.f9947a.get() == null) {
            return;
        }
        Logger.d("WebViewHelper", "Web callback:download - " + str);
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.f9947a.get() == null) {
            return;
        }
        a(str);
        download(str2);
        cn.jpush.android.bg.b.c(JPushConstants.mApplicationContext, this.f9948b);
        this.f9947a.get().finish();
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public String getDevInfo() {
        return "";
    }

    @JavascriptInterface
    public String getNotificationInfo() {
        return "";
    }

    @JavascriptInterface
    public String getTplData() {
        return "";
    }

    @JavascriptInterface
    public String getTplExtraData() {
        return "";
    }

    @JavascriptInterface
    public void inAppClick(String str) {
    }

    @JavascriptInterface
    public void onLoadCallback(String str) {
    }

    @JavascriptInterface
    public void reportData(String str) {
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.f9947a.get() == null || !(this.f9947a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.f9947a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.f9947a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:showToast - " + str);
            Toast.makeText(this.f9947a.get(), str, 1).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Context context = JPushConstants.mApplicationContext;
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        Logger.d("WebViewHelper", "activityName = " + str);
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
            }
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName(str));
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
            }
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.f9947a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.bm.a.c(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.f9947a.get());
            if (this.f9947a.get() == null || !(this.f9947a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.f9947a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.f9947a.get();
    }
}
