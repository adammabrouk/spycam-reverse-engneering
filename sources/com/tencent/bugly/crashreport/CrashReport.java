package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    public static Context f10830a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c, reason: collision with root package name */
        public CrashHandleCallback f10832c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f10811a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f10812b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.f10811a = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f10812b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f10832c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f10832c;
        }
    }

    /* compiled from: BUGLY */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not close bugly because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f10830a == null) {
            return;
        }
        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
        if (buglyBroadcastReceiver != null) {
            buglyBroadcastReceiver.unregister(f10830a);
        }
        closeCrashReport();
        com.tencent.bugly.crashreport.biz.b.a(f10830a);
        w a2 = w.a();
        if (a2 != null) {
            a2.b();
        }
    }

    public static void closeCrashReport() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().d();
        } else {
            Log.w(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().g();
        } else {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z) {
        b.f10825a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set DB name because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(x.f11209a, "enableObtainId args context should not be null");
            return;
        }
        Log.i(x.f11209a, "Enable identification obtaining? " + z);
        com.tencent.bugly.crashreport.common.info.a.a(context).b(z);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).x();
        }
        Log.e(x.f11209a, "getAllUserDataKeys args context should not be null");
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get App channel because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f10830a).l;
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppID() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get App ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f10830a).f();
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppVer() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get app version because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f10830a).j;
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).c();
        }
        x.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static String getDeviceID(Context context) {
        return com.tencent.bugly.crashreport.common.info.a.a(context).h();
    }

    public static Proxy getHttpProxy() {
        return com.tencent.bugly.proguard.a.b();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f10830a).B;
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(x.f11209a, "getUserDataValue args context should not be null");
            return "unknown";
        }
        if (z.a(str)) {
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).h(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).w();
        }
        Log.e(x.f11209a, "getUserDatasSize args context should not be null");
        return -1;
    }

    public static String getUserId() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get user ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f10830a).g();
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).A();
        }
        Log.e(x.f11209a, "getUserSceneTagId args context should not be null");
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f10830a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return c.a().b();
        }
        Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return false;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            d.a(thread, i2, str, str2, str3, map);
        } else {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void putSdkData(Context context, String str, String str2) {
        if (context == null || z.a(str) || z.a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(x.f11209a, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(x.f11209a, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).c(replace, str2);
        x.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(x.f11209a, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            String str3 = str;
            x.d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            String str4 = str2;
            x.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            x.d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a2.x().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
            x.c("replace KV %s %s", str, str2);
            return;
        }
        if (a2.w() >= 50) {
            x.d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            x.d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
        x.b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not remove user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(x.f11209a, "removeUserData args context should not be null");
            return "unknown";
        }
        if (z.a(str)) {
            return null;
        }
        x.b("[param] remove user data: %s", str);
        return com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App channel because Bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(x.f11209a, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(x.f11209a, "App channel is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).l = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(x.f11209a, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(x.f11209a, "App package is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f10872c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(x.f11209a, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(x.f11209a, "App version is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).j = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(x.f11209a, "Set Bugly DB name: " + str);
        q.f11170a = str;
    }

    public static void setContext(Context context) {
        f10830a = context;
    }

    public static void setCrashFilter(String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(x.f11209a, "Set crash stack filter: " + str);
        c.n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(x.f11209a, "Set crash stack filter: " + str);
        c.o = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).c(str);
        }
    }

    public static void setDeviceModel(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).d(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(x.f11209a, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i2) {
        com.tencent.bugly.proguard.a.a(str, i2);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set 'isAppForeground' because bugly is disable.");
            return;
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            x.c("App is in foreground.", new Object[0]);
        } else {
            x.c("App is in background.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(z);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            x.c("This is a development device.", new Object[0]);
        } else {
            x.c("This is not a development device.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).z = z;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not put SDK extra data because bugly is disable.");
        } else {
            if (context == null || z.a(str) || z.a(str2)) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (z.a(str) || !z.c(str)) {
            Log.i(x.f11209a, "URL is invalid.");
            return;
        }
        com.tencent.bugly.crashreport.common.strategy.a.a(str);
        StrategyBean.f10882a = str;
        StrategyBean.f10883b = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (b.f10825a) {
            com.tencent.bugly.crashreport.biz.b.a(j);
        } else {
            Log.w(x.f11209a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f10830a, str);
        } else {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(x.f11209a, "setTag args context should not be null");
            return;
        }
        if (i2 <= 0) {
            x.d("setTag args tagId should > 0", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(i2);
        x.b("[param] set user scene tag: %d", Integer.valueOf(i2));
    }

    public static void startCrashReport() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            c.a().c();
        } else {
            Log.w(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a anr crash for test!", new Object[0]);
            c.a().l();
        }
    }

    public static void testJavaCrash() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not test Java crash because bugly is disable.");
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b2 != null) {
                b2.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void uploadUserInfo() {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not upload user info because bugly is disable.");
            return;
        }
        com.tencent.bugly.crashreport.biz.a aVar = com.tencent.bugly.crashreport.biz.b.f10855a;
        if (aVar == null) {
            Log.w(x.f11209a, "Can not upload user info because bugly is not init.");
        } else {
            aVar.b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        com.tencent.bugly.proguard.a.a(inetAddress, i2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(x.f11209a, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final CharSequence getContentDescription() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final String getUrl() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void loadUrl(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }
        }, z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.f11209a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th == null) {
            x.d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        c.a().a(thread, th, false, (String) null, (byte[]) null, z);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f10830a = context;
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(x.f11209a, "Context should not be null when bugly has not been initialed!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            x.d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            x.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(context).g())) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
        x.b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            com.tencent.bugly.crashreport.biz.b.a();
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).B;
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            f10830a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z, null);
        }
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f10830a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(x.f11209a, "WebViewInterface is null.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        x.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!b.f10825a) {
            Log.w(x.f11209a, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        x.c("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && Build.VERSION.SDK_INT < 19) {
            x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        x.a("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            x.a("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            x.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
            String a2 = com.tencent.bugly.crashreport.crash.h5.b.a();
            if (a2 == null) {
                x.e("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + a2);
        }
        return true;
    }
}
