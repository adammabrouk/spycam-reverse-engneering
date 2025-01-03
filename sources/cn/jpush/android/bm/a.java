package cn.jpush.android.bm;

import android.R;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.hjq.permissions.Permission;
import com.shix.shixipc.utilcode.RomUtils;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f9655a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f9656b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f9657c;

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f9658d = {105, 120, 117, 66, 79, 112, 108, 56, 102, 85, 66, 114, 97, 98, 63, 103, 69, 123, 91, 115, 101, 68, 73, 119, 111, 101};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f9659e = {83, 124, 124, 87, 125, 92, 79, 110, 78, Byte.MAX_VALUE, 125, 85, 97, 122, 107, 115, 98, 67};

    /* renamed from: f, reason: collision with root package name */
    public static String f9660f = "";

    public static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] split = str.split("[._]");
            String[] split2 = str2.split("[._]");
            if (split.length > split2.length) {
                split2 = (String[]) Arrays.copyOf(split2, split.length);
            } else if (split.length < split2.length) {
                split = (String[]) Arrays.copyOf(split, split2.length);
            }
            for (int i2 = 0; i2 < split.length; i2++) {
                long parseLong = (TextUtils.isEmpty(split[i2]) ? 0L : Long.parseLong(split[i2])) - (TextUtils.isEmpty(split2[i2]) ? 0L : Long.parseLong(split2[i2]));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return str.compareTo(str2);
        }
    }

    public static Intent a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i2);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            parseUri.setSelector(null);
        }
        return intent;
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            componentInfoArr = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "hasComponent error:" + th.getMessage());
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        if (r8 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        if (r8 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = 0
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch: java.lang.Throwable -> L79
            java.io.InputStream r8 = r8.open(r9)     // Catch: java.lang.Throwable -> L79
            org.xmlpull.v1.XmlPullParserFactory r9 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch: java.lang.Throwable -> L77
            r2 = 1
            r9.setNamespaceAware(r2)     // Catch: java.lang.Throwable -> L77
            org.xmlpull.v1.XmlPullParser r9 = r9.newPullParser()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "utf-8"
            r9.setInput(r8, r3)     // Catch: java.lang.Throwable -> L77
            int r3 = r9.getEventType()     // Catch: java.lang.Throwable -> L77
        L20:
            if (r3 == r2) goto L71
            int r3 = r9.next()     // Catch: java.lang.Throwable -> L77
            r4 = 2
            if (r3 != r4) goto L20
            java.lang.String r4 = r9.getName()     // Catch: java.lang.Throwable -> L77
            boolean r4 = r4.equals(r10)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L20
            int r4 = r9.getAttributeCount()     // Catch: java.lang.Throwable -> L77
            r5 = 0
        L38:
            if (r5 >= r4) goto L20
            java.lang.String r6 = r9.getAttributeName(r5)     // Catch: java.lang.Throwable -> L77
            java.lang.String r7 = r9.getAttributeValue(r5)     // Catch: java.lang.Throwable -> L77
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Throwable -> L77
            boolean r6 = r6.equals(r11)     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L6e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r9.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r10 = "[getValueFromAssetFile] key = "
            r9.append(r10)     // Catch: java.lang.Throwable -> L77
            r9.append(r11)     // Catch: java.lang.Throwable -> L77
            java.lang.String r10 = ", value="
            r9.append(r10)     // Catch: java.lang.Throwable -> L77
            r9.append(r7)     // Catch: java.lang.Throwable -> L77
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L77
            cn.jpush.android.helper.Logger.d(r0, r9)     // Catch: java.lang.Throwable -> L77
            if (r8 == 0) goto L6d
            r8.close()     // Catch: java.io.IOException -> L6d
        L6d:
            return r7
        L6e:
            int r5 = r5 + 1
            goto L38
        L71:
            if (r8 == 0) goto L96
        L73:
            r8.close()     // Catch: java.io.IOException -> L96
            goto L96
        L77:
            r9 = move-exception
            goto L7b
        L79:
            r9 = move-exception
            r8 = r1
        L7b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r10.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r11 = "[getValueFromAssetFile] parseConfig error :"
            r10.append(r11)     // Catch: java.lang.Throwable -> L97
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L97
            r10.append(r9)     // Catch: java.lang.Throwable -> L97
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> L97
            cn.jpush.android.helper.Logger.w(r0, r9)     // Catch: java.lang.Throwable -> L97
            if (r8 == 0) goto L96
            goto L73
        L96:
            return r1
        L97:
            r9 = move-exception
            if (r8 == 0) goto L9d
            r8.close()     // Catch: java.io.IOException -> L9d
        L9d:
            goto L9f
        L9e:
            throw r9
        L9f:
            goto L9e
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bm.a.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
            }
            return str.substring(str.lastIndexOf("."));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return b(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, Intent intent, String str) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> b2 = b(context, intent, str);
            if (b2 == null || b2.isEmpty()) {
                Logger.ww("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str2 : b2) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e2) {
                    Logger.ww("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + intent.getAction());
                }
            }
        }
    }

    public static void a(WebSettings webSettings) {
        try {
            Logger.d("AndroidUtil", "fix.");
            Class.forName(d.b(f9658d)).getMethod(d.b(f9659e), Boolean.TYPE).invoke(webSettings, true);
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "something is wrong:" + th.getMessage());
        }
    }

    public static void a(final WebView webView) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixSecure failed, error:" + th);
            if (Build.VERSION.SDK_INT >= 12) {
                webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cn.jpush.android.bm.a.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        WebSettings settings = webView.getSettings();
                        if (settings != null) {
                            try {
                                Method declaredMethod = settings.getClass().getDeclaredMethod("removeJavascriptInterface", String.class);
                                if (declaredMethod != null) {
                                    declaredMethod.invoke(webView, "searchBoxJavaBridge_");
                                    declaredMethod.invoke(webView, "accessibility");
                                    declaredMethod.invoke(webView, "accessibilityTraversal");
                                }
                            } catch (Throwable th2) {
                                Logger.e("AndroidUtil", "removeJavascriptInterface failed, error:" + th2);
                            }
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }
                });
            }
        }
    }

    public static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b2 & 15));
    }

    public static boolean a() {
        return false;
    }

    public static boolean a(Activity activity) {
        if (activity != null) {
            try {
                TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowNoTitle, R.attr.windowContentOverlay, R.attr.windowBackground, R.attr.windowIsTranslucent, R.attr.colorBackgroundCacheHint});
                boolean z = obtainStyledAttributes.getBoolean(0, false);
                Drawable drawable = obtainStyledAttributes.getDrawable(1);
                int color = obtainStyledAttributes.getColor(2, -1);
                boolean z2 = obtainStyledAttributes.getBoolean(3, false);
                Drawable drawable2 = obtainStyledAttributes.getDrawable(4);
                Logger.d("AndroidUtil", "notitle:" + z + ", overlay:" + drawable + ", color:" + color + ", translucent:" + z2 + "background:" + drawable2);
                obtainStyledAttributes.recycle();
                if (z && z2 && drawable == null && drawable2 == null && color == activity.getResources().getColor(R.color.transparent)) {
                    Logger.d("AndroidUtil", "activity is Translucent theme");
                    return true;
                }
            } catch (Throwable th) {
                Logger.w("AndroidUtil", "check TranslucentNotitleTheme failed: " + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, Class<?> cls) {
        if (context != null) {
            try {
                boolean z = context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
                if (z) {
                    return z;
                }
                return a(context, context.getPackageName(), cls) != null;
            } catch (Throwable th) {
                Logger.dd("AndroidUtil", "hasActivityResolves error:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "[hasPermissionDefined] unexpected error, context: " + context + ", thePermission: " + str;
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    for (String str3 : packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                        if (str.equals(str3)) {
                            Logger.d("AndroidUtil", "find permission: " + str);
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.ww("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
            }
            str2 = "not find permission: " + str;
        }
        Logger.w("AndroidUtil", str2);
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
        if (d(context, str)) {
            return true;
        }
        Logger.d("AndroidUtil", "p not:" + str);
        try {
            return b(context, str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Signature[] signatureArr) {
        for (Signature signature : signatureArr) {
            if (signature.toCharsString().toLowerCase().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                Logger.d("AndroidUtil", "check wx Signature validate pass");
                return true;
            }
        }
        return false;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f9656b)) {
            return f9656b;
        }
        try {
            f9656b = context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (Throwable unused) {
        }
        return f9656b;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    public static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(false);
        }
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static boolean b() {
        try {
            String e2 = e();
            Logger.d("AndroidUtil", "vivoVersion:" + e2);
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !e2.startsWith("Funtouch")) {
                String e3 = e("ro.iqoo.os.build.display.id");
                Logger.d("AndroidUtil", "iqooMonsterUI:" + e3);
                if (e3 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(e3.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String permissionToOp = AppOpsManager.permissionToOp(str);
                    if (permissionToOp != null) {
                        z = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName()) == 0;
                    }
                    return z;
                }
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Logger.d("AndroidUtil", "try d:" + str2);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static boolean b(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String trim = str.trim();
            z = trim.matches("^https?(.*)\\.(png|jpg|jpeg)(\\?.*)?$");
            if (!z) {
                Logger.w("AndroidUtil", "Invalid url - " + trim);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static String c() {
        try {
            Class<?> cls = Class.forName("com.umeng.socialize.PlatformConfig");
            if (cls == null) {
                return null;
            }
            Field declaredField = cls.getDeclaredField("configs");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(cls);
            Class<?> cls2 = Class.forName("com.umeng.socialize.bean.SHARE_MEDIA");
            if (map == null) {
                return null;
            }
            Field declaredField2 = cls2.getDeclaredField("WEIXIN");
            declaredField2.setAccessible(true);
            Enum r2 = (Enum) declaredField2.get(cls2);
            Logger.d("AndroidUtil", "[appid] enum weixin =" + r2.ordinal());
            Object obj = map.get(r2);
            Field declaredField3 = Class.forName("com.umeng.socialize.PlatformConfig$APPIDPlatform").getDeclaredField("appId");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(obj);
            Logger.d("AndroidUtil", "[getWxAppidByUmeng] wx appid =" + obj2);
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            return null;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "[getWxAppidByUmeng] failed  e=" + th.getMessage());
            return null;
        }
    }

    public static List<String> c(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z = false;
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            if (resolveService != null && resolveService.serviceInfo != null) {
                String str2 = resolveService.serviceInfo.name;
                if (!TextUtils.isEmpty(str2)) {
                    if (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveService.activityInfo.packageName) == 0) {
                        z = true;
                    }
                    if (z) {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void c(Context context, String str) {
        try {
            Intent g2 = g(context);
            if (g2 != null) {
                if (!TextUtils.isEmpty(str)) {
                    g2.putExtra("extra", str);
                }
                context.startActivity(g2);
            }
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "startMainActivity error:" + th.getMessage());
        }
    }

    public static boolean c(Context context) {
        if (a(context, Permission.SYSTEM_ALERT_WINDOW)) {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            if (Settings.canDrawOverlays(context)) {
                Logger.d("AndroidUtil", "can over lay...");
                return true;
            }
            Logger.d("AndroidUtil", "user no open draw overlay permission");
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        boolean matches = trim.matches("^[http|https]+://.*");
        if (!matches) {
            Logger.w("AndroidUtil", "Invalid url - " + trim);
        }
        return matches;
    }

    public static String d() {
        try {
            Class<?> cls = Class.forName("cn.jiguang.share.android.api.JShareInterface");
            if (cls == null) {
                return null;
            }
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object obj = field.get(cls);
                    Logger.d("AndroidUtil", "platFormManager =" + obj);
                    if (obj != null) {
                        for (Field field2 : obj.getClass().getDeclaredFields()) {
                            try {
                                field2.setAccessible(true);
                                Object obj2 = field2.get(obj);
                                if (obj2 instanceof HashMap) {
                                    Object obj3 = ((HashMap) obj2).get("Wechat");
                                    if (obj3 instanceof HashMap) {
                                        String str = (String) ((HashMap) obj3).get("AppId");
                                        Logger.d("AndroidUtil", "[getWxAppidByJiguang] wx appid=" + str);
                                        return str;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Throwable th) {
                                Logger.w("AndroidUtil", "[getWxAppidByJiguangCode] get configmap failed: " + th.getMessage());
                            }
                        }
                    } else {
                        continue;
                    }
                } catch (Throwable th2) {
                    Logger.w("AndroidUtil", "[getWxAppidByJiguangCode] platFormManager error : " + th2.getMessage());
                }
            }
            return null;
        } catch (Throwable th3) {
            Logger.w("AndroidUtil", "[getWxAppidByJiguangCode] failed " + th3.getMessage());
            return null;
        }
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(f9657c)) {
            return f9657c;
        }
        try {
            f9657c = h.a(JPushConstants.getAppContext(context));
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        return f9657c;
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return a(str.getBytes());
    }

    public static boolean d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static String e() {
        if (!TextUtils.isEmpty(f9660f)) {
            return f9660f;
        }
        String e2 = e(RomUtils.VERSION_PROPERTY_VIVO);
        f9660f = e2;
        return e2;
    }

    public static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.i("AndroidUtil", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("AndroidUtil", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static void e(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String d2 = d(context);
                String packageName = context.getPackageName();
                if (d2 == null || packageName == null || packageName.equals(d2)) {
                    return;
                }
                WebView.setDataDirectorySuffix(d2);
                Logger.d("AndroidUtil", "setDataDirectorySuffix =" + d2);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixWebViewProcess e:" + th);
        }
    }

    public static boolean e(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return packageManager.resolveActivity(intent, 0) != null;
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "hasActivityIntentFilter error:" + th.getMessage());
            return true;
        }
    }

    public static String f(Context context, String str) {
        return context.getPackageName() + "." + str;
    }

    public static void f(Context context) {
        c(context, null);
    }

    public static Intent g(Context context) {
        Throwable th;
        Intent intent;
        PackageManager packageManager;
        String packageName;
        try {
            packageManager = context.getPackageManager();
            packageName = context.getApplicationContext().getPackageName();
        } catch (Throwable th2) {
            th = th2;
            intent = null;
        }
        if (TextUtils.isEmpty(packageName)) {
            Logger.ww("AndroidUtil", "The package with the given name cannot be found!");
            return null;
        }
        intent = packageManager.getLaunchIntentForPackage(packageName);
        try {
        } catch (Throwable th3) {
            th = th3;
            Logger.w("AndroidUtil", "getLaunchIntent error:" + th.getMessage());
            return intent;
        }
        if (intent == null) {
            Logger.ww("AndroidUtil", "Can't get launch intent for this package!");
            return null;
        }
        intent.addFlags(268435456);
        return intent;
    }

    public static String g(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return a(packageInfo.signatures[0].toByteArray());
        } catch (Throwable th) {
            Logger.d("AndroidUtil", "[getAppSignMD5] failed :" + th.getMessage());
            return null;
        }
    }

    public static int h(Context context, String str) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean h(Context context) {
        StringBuilder sb;
        String str;
        Logger.dd("AndroidUtil", "action:checkValidManifest");
        if (!a(context, (Class<?>) PushActivity.class)) {
            Logger.w("AndroidUtil", "AndroidManifest.xml missing required activity: " + PushActivity.class.getCanonicalName());
        }
        if (!a(context, (Class<?>) PopWinActivity.class)) {
            Logger.ww("AndroidUtil", "AndroidManifest.xml missing activity: " + PopWinActivity.class.getCanonicalName());
            Logger.ww("AndroidUtil", "You will unable to use pop-window rich push type.");
        }
        if (!e(context, "cn.jpush.android.ui.PushActivity")) {
            Logger.w("AndroidUtil", "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity");
        }
        if (!a(context, (Class<?>) JNotifyActivity.class)) {
            sb = new StringBuilder();
        } else {
            if (TextUtils.isEmpty(JPushConstants.getMessageReceiverClass(context))) {
                str = "AndroidManifest.xml missing required receiver: please custom receiver extends JPushMessageReceiver";
                Logger.ee("AndroidUtil", str);
                return false;
            }
            if (i(context)) {
                return true;
            }
            sb = new StringBuilder();
        }
        sb.append("AndroidManifest.xml missing required activity: ");
        sb.append(JNotifyActivity.class.getCanonicalName());
        str = sb.toString();
        Logger.ee("AndroidUtil", str);
        return false;
    }

    public static boolean i(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent(context, (Class<?>) JNotifyActivity.class), 0);
                if (resolveActivity == null) {
                    return false;
                }
                if (resolveActivity.activityInfo != null && !resolveActivity.activityInfo.exported) {
                    Logger.dd("AndroidUtil", "Please set AndroidManifest.xml activity JNotifyActivity exported to be true if you want to use vendor push SDK.");
                }
                Intent intent = new Intent();
                intent.setAction("cn.jpush.android.intent.JNotifyActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                if (packageManager.resolveActivity(intent, 0) != null) {
                    return true;
                }
                Logger.ee("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <action android:name=\"cn.jpush.android.intent.JNotifyActivity\" />");
                Logger.ee("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <category android:name=\"android.intent.category.DEFAULT\" />");
                Logger.ee("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity not set <data>");
                return false;
            } catch (Throwable th) {
                Logger.dd("AndroidUtil", "hasJNotifyTransitActivity error:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        return false;
    }

    public static boolean k(Context context) {
        return JPushConstants.isForeGround == 0;
    }

    public static boolean l(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ShareSystemFileUtils.PACKAGE_WECHAT, 64);
            if (packageInfo == null) {
                return false;
            }
            return a(packageInfo.signatures);
        } catch (Throwable th) {
            Logger.d("AndroidUtil", "[isWXAppInstalled] check failed :" + th.getMessage());
            return false;
        }
    }

    public static boolean m(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo(ShareSystemFileUtils.PACKAGE_WECHAT, RecyclerView.c0.FLAG_IGNORE).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0) >= 620823808) {
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static String n(Context context) {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            c2 = r(context);
            if (TextUtils.isEmpty(c2)) {
                c2 = s(context);
                if (TextUtils.isEmpty(c2)) {
                    c2 = d();
                    if (TextUtils.isEmpty(c2)) {
                        c2 = q(context);
                        if (!TextUtils.isEmpty(c2)) {
                        }
                    }
                }
            }
        }
        return c2;
    }

    public static String o(Context context) {
        ComponentInfo a2;
        try {
        } catch (Throwable th) {
            Logger.d("AndroidUtil", "getUserServiceClass failed:" + th);
        }
        if (f9655a != null) {
            return f9655a;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        List<String> c2 = c(context, intent, "");
        if (c2 != null && c2.size() >= 1 && JCommonService.class.isAssignableFrom(Class.forName(c2.get(0)))) {
            f9655a = c2.get(0);
            Logger.ii("AndroidUtil", "found userServiceClass :" + f9655a + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f9655a) && (a2 = a(context, context.getPackageName(), (Class<?>) JCommonService.class)) != null) {
            f9655a = a2.name;
            Logger.ii("AndroidUtil", "found userServiceClass :" + f9655a + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f9655a)) {
            f9655a = "";
        }
        return f9655a;
    }

    public static Activity p(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    Logger.w("AndroidUtil", "get current activities for currentActivityThread, activities is null");
                    return null;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            Logger.w("AndroidUtil", "[getCurrentActivity] activity is null");
                            return null;
                        }
                        if (activity.getPackageName().equals(context.getPackageName())) {
                            Logger.d("AndroidUtil", "getCurrentActivity: " + activity.getLocalClassName());
                            return activity;
                        }
                        Logger.w("AndroidUtil", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                        return null;
                    }
                }
            } catch (Throwable th) {
                Logger.w("AndroidUtil", "[getCurrentActivity] error: " + th.getMessage());
            }
        }
        return null;
    }

    public static String q(Context context) {
        try {
            if (Class.forName("cn.jiguang.share.android.api.JShareInterface") == null) {
                return null;
            }
            String a2 = a(context, "JGShareSDK.xml", "Wechat", "AppId");
            if (TextUtils.isEmpty(a2)) {
                a2 = a(context, "JGShareSDK.conf", "Wechat", "AppId");
            }
            Logger.d("AndroidUtil", "[getWxAppidByJiguangFile] wx appid=" + a2);
            return a2;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "[getWxAppidByJiguangFile]  failed :" + th.getMessage());
            return null;
        }
    }

    public static String r(Context context) {
        try {
            if (Class.forName("cn.jiguang.share.android.api.JShareInterface") == null) {
                return null;
            }
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE).metaData.getString("wxAppId");
            Logger.d("AndroidUtil", "[getWxAppidByShareMeta] share sdk meta wxid=" + string);
            return string;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "[getWxAppidByShareMeta]  error :" + th.getMessage());
            return null;
        }
    }

    public static String s(Context context) {
        try {
            if (Class.forName("cn.sharesdk.onekeyshare.OnekeyShare") == null) {
                return null;
            }
            String a2 = a(context, "ShareSDK.xml", "Wechat", "AppId");
            Logger.d("AndroidUtil", "[getWxAppidByShareFile] share sdk wxid=" + a2);
            return a2;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "[getWxAppidByShareFile] failed :" + th.getMessage());
            return null;
        }
    }
}
