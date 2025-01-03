package cn.jpush.android.api;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.bm.a;
import cn.jpush.android.bm.e;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.webview.bridge.HostJsScope;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class SystemAlertHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f9187a = 400;

    /* renamed from: b, reason: collision with root package name */
    public static int f9188b = 600;

    /* renamed from: c, reason: collision with root package name */
    public static ImageButton f9189c;

    /* renamed from: d, reason: collision with root package name */
    public static WindowManager f9190d;

    /* renamed from: e, reason: collision with root package name */
    public static WebView f9191e;

    public static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return null;
        }
        Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
        Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
        Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
        Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
        Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
        Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
        return displayMetrics;
    }

    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i2;
        int i3;
        DisplayMetrics a2 = a(context);
        if (a2 != null) {
            int i4 = (a2.widthPixels * 3) / 4;
            f9187a = i4;
            int i5 = a2.heightPixels / 2;
            f9188b = i5;
            i2 = i4 / 2;
            i3 = -(i5 / 2);
        } else {
            i2 = 200;
            i3 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.flags |= 552;
        layoutParams.width = f9187a;
        layoutParams.height = f9188b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        imageButton.setImageBitmap(getImageFromAssetsFile(context, "jpush_close.png"));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i3;
        layoutParams.x = i2;
        windowManager.addView(imageButton, layoutParams);
    }

    public static void close() {
        WindowManager windowManager = f9190d;
        if (windowManager == null) {
            return;
        }
        try {
            if (f9191e != null) {
                windowManager.removeView(f9191e);
            }
            if (f9189c != null) {
                f9190d.removeView(f9189c);
            }
        } catch (Throwable unused) {
        }
        f9190d = null;
        f9191e = null;
        f9189c = null;
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException unused) {
            return bitmap;
        }
    }

    public static int getWindowHeight() {
        return f9188b;
    }

    public static int getWindowWidth() {
        return f9187a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Intent intent = new Intent(webView.getContext(), cls);
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                appContext.startActivity(intent);
                close();
            }
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert() {
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new e("SystemAlertHelper#systemAlert") { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // cn.jpush.android.bm.e
            @SuppressLint({"NewApi"})
            public void a() {
                String str = dVar.W;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.f9190d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.f9191e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.f9189c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.f9190d, SystemAlertHelper.f9191e, SystemAlertHelper.f9189c);
                SystemAlertHelper.f9191e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.f9191e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.f9191e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.f9191e.setScrollBarStyle(33554432);
                a.b(SystemAlertHelper.f9191e.getSettings());
                a.a(SystemAlertHelper.f9191e);
                SystemAlertHelper.f9191e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.f9191e.setWebViewClient(new cn.jpush.android.ui.a(dVar, context));
                if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                    SystemAlertHelper.f9191e.loadUrl(str);
                }
                SystemAlertHelper.f9189c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }
}
