package c.k.d.p9;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import c.k.d.d5;
import c.k.d.j7;
import c.k.d.p9.j;
import c.k.d.s7;
import c.k.d.v6;
import cn.jpush.android.service.WakedResultReceiver;
import com.shix.shixipc.activity.AddCameraActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static long f7532a;

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedList<Pair<Integer, s7>> f7533b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    public static ExecutorService f7534c = Executors.newCachedThreadPool();

    public static class a implements Callable<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public String f7535a;

        /* renamed from: b, reason: collision with root package name */
        public Context f7536b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7537c;

        public a(String str, Context context, boolean z) {
            this.f7536b = context;
            this.f7535a = str;
            this.f7537c = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f7535a)) {
                c.k.a.a.a.c.m6a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f7535a.startsWith("http")) {
                j.b a2 = j.a(this.f7536b, this.f7535a, this.f7537c);
                if (a2 != null) {
                    return a2.f7616a;
                }
            } else {
                bitmap = j.a(this.f7536b, this.f7535a);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            c.k.a.a.a.c.m6a("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* renamed from: c.k.d.p9.b$b, reason: collision with other inner class name */
    public static class C0129b {

        /* renamed from: a, reason: collision with root package name */
        public Notification f7538a;

        /* renamed from: b, reason: collision with root package name */
        public long f7539b = 0;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f7540a;

        /* renamed from: b, reason: collision with root package name */
        public long f7541b = 0;
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    @TargetApi(16)
    public static Notification.Builder a(Notification.Builder builder, Context context, String str, Map<String, String> map) {
        PendingIntent a2 = a(context, str, 1, map);
        if (a2 != null && !TextUtils.isEmpty(map.get("notification_style_button_left_name"))) {
            builder.addAction(0, map.get("notification_style_button_left_name"), a2);
        }
        PendingIntent a3 = a(context, str, 2, map);
        if (a3 != null && !TextUtils.isEmpty(map.get("notification_style_button_mid_name"))) {
            builder.addAction(0, map.get("notification_style_button_mid_name"), a3);
        }
        PendingIntent a4 = a(context, str, 3, map);
        if (a4 != null && !TextUtils.isEmpty(map.get("notification_style_button_right_name"))) {
            builder.addAction(0, map.get("notification_style_button_right_name"), a4);
        }
        return builder;
    }

    @TargetApi(16)
    public static Notification.Builder a(Context context, Map<String, String> map, Notification.Builder builder, String str) {
        if (WakedResultReceiver.WAKE_TYPE_KEY.equals(map.get("notification_style_type"))) {
            Bitmap a2 = map == null ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a2 == null) {
                c.k.a.a.a.c.m6a("can not get big picture.");
                return builder;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
            bigPictureStyle.bigPicture(a2);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            builder.setStyle(bigPictureStyle);
        } else if ("1".equals(map.get("notification_style_type"))) {
            builder.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        return builder;
    }

    public static Notification a(Notification notification) {
        Object a2 = c.k.d.f0.a(notification, "extraNotification");
        if (a2 != null) {
            c.k.d.f0.a(a2, "setCustomizedIcon", true);
        }
        return notification;
    }

    public static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
        return notification;
    }

    public static PendingIntent a(Context context, s7 s7Var, j7 j7Var, byte[] bArr, int i2) {
        Intent intent;
        ComponentName componentName;
        int i3 = c(s7Var) ? 1000 : m359a(s7Var) ? AddCameraActivity.SEARCH_TIME : -1;
        String m246a = j7Var != null ? j7Var.m246a() : "";
        if (j7Var != null && !TextUtils.isEmpty(j7Var.f7300e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(j7Var.f7300e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", m246a);
            intent2.putExtra("eventMessageType", i3);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (m359a(s7Var)) {
            intent = new Intent();
            componentName = new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler");
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            componentName = new ComponentName(s7Var.f7851b, "com.xiaomi.mipush.sdk.PushMessageHandler");
        }
        intent.setComponent(componentName);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_notified", true);
        intent.addCategory(String.valueOf(i2));
        intent.addCategory(String.valueOf(m246a));
        intent.putExtra("messageId", m246a);
        intent.putExtra("eventMessageType", i3);
        if (!d1.b(context, s7Var.f7851b, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
        Intent intent3 = new Intent();
        intent3.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
        intent3.setClassName(s7Var.f7851b, "com.xiaomi.mipush.sdk.BridgeActivity");
        intent3.addFlags(276824064);
        intent3.putExtra("mipush_serviceIntent", intent);
        intent3.addCategory(String.valueOf(i2));
        intent3.addCategory(String.valueOf(m246a));
        return PendingIntent.getActivity(context, 0, intent3, 134217728);
    }

    public static PendingIntent a(Context context, String str, int i2, Map<String, String> map) {
        Intent m355a;
        if (map == null || (m355a = m355a(context, str, i2, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, m355a, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013f  */
    /* renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent m355a(android.content.Context r6, java.lang.String r7, int r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.b.m355a(android.content.Context, java.lang.String, int, java.util.Map):android.content.Intent");
    }

    public static Bitmap a(Context context, int i2) {
        return a(context.getResources().getDrawable(i2));
    }

    public static Bitmap a(Context context, String str, boolean z) {
        Bitmap bitmap;
        Future submit = f7534c.submit(new a(str, context, z));
        try {
            try {
                bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                if (bitmap == null) {
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                c.k.a.a.a.c.a(e2);
                submit.cancel(true);
                bitmap = null;
            }
            return bitmap;
        } finally {
            submit.cancel(true);
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static RemoteViews a(Context context, s7 s7Var, byte[] bArr) {
        j7 a2 = s7Var.a();
        String a3 = a(s7Var);
        Map<String, String> m247a = a2.m247a();
        if (m247a == null) {
            return null;
        }
        String str = m247a.get("layout_name");
        String str2 = m247a.get("layout_value");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a3);
                int identifier = resourcesForApplication.getIdentifier(str, "layout", a3);
                if (identifier == 0) {
                    return null;
                }
                RemoteViews remoteViews = new RemoteViews(a3, identifier);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("text")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject2.getString(next);
                            int identifier2 = resourcesForApplication.getIdentifier(next, "id", a3);
                            if (identifier2 > 0) {
                                remoteViews.setTextViewText(identifier2, string);
                            }
                        }
                    }
                    if (jSONObject.has("image")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            String string2 = jSONObject3.getString(next2);
                            int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a3);
                            int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a3);
                            if (identifier3 > 0) {
                                remoteViews.setImageViewResource(identifier3, identifier4);
                            }
                        }
                    }
                    if (jSONObject.has("time")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                        Iterator<String> keys3 = jSONObject4.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            String string3 = jSONObject4.getString(next3);
                            if (string3.length() == 0) {
                                string3 = "yy-MM-dd hh:mm";
                            }
                            int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a3);
                            if (identifier5 > 0) {
                                remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                            }
                        }
                    }
                    return remoteViews;
                } catch (JSONException e2) {
                    c.k.a.a.a.c.a(e2);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                c.k.a.a.a.c.a(e3);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0437 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0252  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c.k.d.p9.b.C0129b a(android.content.Context r25, c.k.d.s7 r26, byte[] r27, android.widget.RemoteViews r28, android.app.PendingIntent r29) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.b.a(android.content.Context, c.k.d.s7, byte[], android.widget.RemoteViews, android.app.PendingIntent):c.k.d.p9.b$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0283 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0354 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0185  */
    /* renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c.k.d.p9.b.c m356a(android.content.Context r19, c.k.d.s7 r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.b.m356a(android.content.Context, c.k.d.s7, byte[]):c.k.d.p9.b$c");
    }

    public static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? d5.b(context, str) : map.get("channel_name");
    }

    public static String a(s7 s7Var) {
        j7 a2;
        if ("com.xiaomi.xmsf".equals(s7Var.f7851b) && (a2 = s7Var.a()) != null && a2.m247a() != null) {
            String str = a2.m247a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return s7Var.f7851b;
    }

    public static void a(Notification notification, int i2) {
        Object a2 = c.k.d.f0.a(notification, "extraNotification");
        if (a2 != null) {
            c.k.d.f0.a(a2, "setMessageCount", Integer.valueOf(i2));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m357a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i2) {
        k a2 = k.a(context, str);
        int hashCode = ((str.hashCode() / 10) * 10) + i2;
        LinkedList linkedList = new LinkedList();
        if (i2 >= 0) {
            a2.a(hashCode);
        }
        synchronized (f7533b) {
            Iterator<Pair<Integer, s7>> it = f7533b.iterator();
            while (it.hasNext()) {
                Pair<Integer, s7> next = it.next();
                s7 s7Var = (s7) next.second;
                if (s7Var != null) {
                    String a3 = a(s7Var);
                    if (i2 >= 0) {
                        if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(a3, str)) {
                            linkedList.add(next);
                        }
                    } else if (i2 == -1 && TextUtils.equals(a3, str)) {
                        a2.a(((Integer) next.first).intValue());
                        linkedList.add(next);
                    }
                }
            }
            if (f7533b != null) {
                f7533b.removeAll(linkedList);
                a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        synchronized (f7533b) {
            Iterator<Pair<Integer, s7>> it = f7533b.iterator();
            while (it.hasNext()) {
                Pair<Integer, s7> next = it.next();
                s7 s7Var = (s7) next.second;
                if (s7Var != null) {
                    String a2 = a(s7Var);
                    j7 a3 = s7Var.a();
                    if (a3 != null && TextUtils.equals(a2, str)) {
                        String m254c = a3.m254c();
                        String d2 = a3.d();
                        if (!TextUtils.isEmpty(m254c) && !TextUtils.isEmpty(d2) && a(str2, m254c) && a(str3, d2)) {
                            k.a(context, str).a(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            if (f7533b != null) {
                f7533b.removeAll(linkedList);
                a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        l0.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void a(Object obj, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("channel_description"))) {
            return;
        }
        c.k.d.f0.a(obj, "setDescription", map.get("channel_description"));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m358a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(j7 j7Var) {
        if (j7Var == null) {
            return false;
        }
        String m246a = j7Var.m246a();
        return !TextUtils.isEmpty(m246a) && m246a.length() == 22 && "satuigmo".indexOf(m246a.charAt(0)) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m359a(s7 s7Var) {
        j7 a2 = s7Var.a();
        return a(a2) && a2.l();
    }

    public static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m360a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0072, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] a(android.content.Context r3, c.k.d.j7 r4) {
        /*
            java.lang.String r0 = r4.m254c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m247a()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.b.a(android.content.Context, c.k.d.j7):java.lang.String[]");
    }

    public static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    public static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            c.k.a.a.a.c.c("importance=3");
            return Integer.parseInt(str);
        } catch (Exception e2) {
            c.k.a.a.a.c.d("parsing channel importance error: " + e2);
            return 3;
        }
    }

    public static String b(s7 s7Var) {
        return m359a(s7Var) ? "E100002" : c(s7Var) ? "E100000" : m363b(s7Var) ? "E100001" : d(s7Var) ? "E100003" : "";
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m361b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static void b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m362b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m363b(s7 s7Var) {
        j7 a2 = s7Var.a();
        return a(a2) && a2.f7297b == 1 && !m359a(s7Var);
    }

    public static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            c.k.a.a.a.c.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            c.k.a.a.a.c.d("parsing notification priority error: " + e2);
            return 0;
        }
    }

    public static boolean c(s7 s7Var) {
        j7 a2 = s7Var.a();
        return a(a2) && a2.f7297b == 0 && !m359a(s7Var);
    }

    public static boolean d(s7 s7Var) {
        return s7Var.m469a() == v6.Registration;
    }

    public static boolean e(s7 s7Var) {
        return m359a(s7Var) || c(s7Var) || m363b(s7Var);
    }
}
