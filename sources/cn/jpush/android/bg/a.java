package cn.jpush.android.bg;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: cn.jpush.android.bg.a$a, reason: collision with other inner class name */
    public static class C0154a {

        /* renamed from: a, reason: collision with root package name */
        public String f9564a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f9565b;

        /* renamed from: c, reason: collision with root package name */
        public int f9566c;

        /* renamed from: d, reason: collision with root package name */
        public int f9567d;

        /* renamed from: e, reason: collision with root package name */
        public int f9568e;

        /* renamed from: f, reason: collision with root package name */
        public String f9569f;

        /* renamed from: g, reason: collision with root package name */
        public Uri f9570g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9571h;

        public C0154a(String str, CharSequence charSequence, int i2, int i3, String str2) {
            this.f9564a = str;
            this.f9565b = charSequence;
            this.f9566c = i2;
            this.f9568e = i3;
            this.f9569f = str2;
        }
    }

    public static int a(int i2) {
        if (i2 == -2) {
            return 1;
        }
        if (i2 != -1) {
            return (i2 == 1 || i2 == 2) ? 4 : 3;
        }
        return 2;
    }

    public static NotificationChannel a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(str)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
                if (notificationChannel != null) {
                    Logger.dd("ChannelHelper", "channel has created: " + str);
                    return notificationChannel;
                }
                Logger.dd("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
            }
        } catch (Throwable th) {
            Logger.e("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
        }
        return null;
    }

    public static String a(Context context, int i2) {
        boolean z;
        String str;
        String str2 = "";
        try {
            String str3 = "jg_channel_name_p_" + (i2 != -2 ? i2 != -1 ? (i2 == 1 || i2 == 2) ? "HIGH" : "DEFAULT" : "LOW" : "MIN").toLowerCase();
            int identifier = context.getResources().getIdentifier(str3, "string", context.getPackageName());
            if (identifier != 0) {
                str2 = context.getResources().getString(identifier);
                str = "found " + str2 + " from resource by name:" + str3;
            } else {
                str = "not found string value from resource by name:" + str3;
            }
            Logger.dd("ChannelHelper", str);
        } catch (Throwable th) {
            Logger.ww("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            z = Locale.getDefault().getLanguage().contains("zh");
        } catch (Throwable th2) {
            Logger.ww("ChannelHelper", "get language failed:" + th2.getMessage());
            z = true;
        }
        if (i2 == -2 || i2 == -1) {
            return z ? "不重要" : "LOW";
        }
        if (i2 == 1 || i2 == 2) {
            return z ? "重要" : "HIGH";
        }
        return z ? "普通" : "NORMAL";
    }

    public static String a(Context context, int i2, int i3) {
        int a2 = a(i2);
        String str = "JPush_" + a2 + "_" + i3;
        String a3 = a(context, i2);
        Logger.d("ChannelHelper", "channelId:" + str + ",channelName:" + a3);
        return a(context, str, a3, a2, i3, null) ? str : "";
    }

    public static String a(C0154a c0154a) {
        String str = "JPush_" + c0154a.f9567d + "_" + c0154a.f9568e;
        if (c0154a.f9570g == null) {
            return str;
        }
        return str + "_" + c0154a.f9569f;
    }

    public static void a(Context context) {
        a(context, -1, 0);
        a(context, 0, 7);
    }

    public static void a(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i2, int i3, String str2) {
        C0154a c0154a = new C0154a(str, charSequence, i2, i3, str2);
        a(context, c0154a);
        b.a(context, builder, c0154a);
    }

    public static void a(Context context, Notification notification, String str, CharSequence charSequence, int i2, int i3, String str2) {
        C0154a c0154a = new C0154a(str, charSequence, i2, i3, str2);
        a(context, c0154a);
        b.a(notification, c0154a);
    }

    public static void a(Context context, C0154a c0154a) {
        NotificationChannel a2;
        NotificationChannel a3;
        if (b.c(context)) {
            Logger.d("ChannelHelper", "in silence push time,change defaults to 0");
            c0154a.f9564a = "";
            c0154a.f9568e = 0;
            c0154a.f9569f = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (a2 = a(context, c0154a.f9564a)) != null) {
            c0154a.f9564a = a2.getId();
            c0154a.f9565b = a2.getName();
            int importance = a2.getImportance();
            c0154a.f9567d = importance;
            c0154a.f9566c = b(importance);
            Uri sound = a2.getSound();
            c0154a.f9570g = sound;
            if (sound != null) {
                c0154a.f9569f = sound.getPath();
            }
            c0154a.f9571h = true;
            return;
        }
        int i2 = c0154a.f9566c;
        if (i2 == -2 || i2 == -1) {
            c0154a.f9568e = 0;
            c0154a.f9569f = null;
        } else if (i2 >= 0 && c0154a.f9568e == 0 && TextUtils.isEmpty(c0154a.f9569f)) {
            c0154a.f9566c = -1;
        }
        c0154a.f9568e &= 7;
        if (c0154a.f9566c == 2) {
            c0154a.f9566c = 1;
        }
        int a4 = a(c0154a.f9566c);
        c0154a.f9567d = a4;
        c0154a.f9566c = b(a4);
        Uri a5 = b.a(context, c0154a.f9569f);
        c0154a.f9570g = a5;
        if (a5 != null) {
            c0154a.f9568e &= -2;
        } else {
            c0154a.f9569f = null;
        }
        if (TextUtils.isEmpty(c0154a.f9564a)) {
            String a6 = a(c0154a);
            c0154a.f9564a = a6;
            if (Build.VERSION.SDK_INT >= 26 && (a3 = a(context, a6)) != null) {
                c0154a.f9564a = a3.getId();
                c0154a.f9565b = a3.getName();
                c0154a.f9571h = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0154a.f9565b)) {
            c0154a.f9565b = ("KG_channel_normal".equals(c0154a.f9564a) && "com.tencent.karaoke".equals(context.getPackageName())) ? "普通_K歌" : a(context, c0154a.f9566c);
        }
        Logger.d("ChannelHelper", "create channelId:" + c0154a.f9564a + ",channelName:" + ((Object) c0154a.f9565b) + " soundUri:" + c0154a.f9570g);
        c0154a.f9571h = a(context, c0154a.f9564a, c0154a.f9565b, c0154a.f9567d, c0154a.f9568e, c0154a.f9570g);
    }

    public static boolean a(Context context, String str, CharSequence charSequence, int i2, int i3, Uri uri) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            Logger.d("ChannelHelper", "sdkversion < 26, no need use notificationChannel!");
            return false;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                Logger.ee("ChannelHelper", "NotificationManager is null!");
                return false;
            }
            Logger.dd("ChannelHelper", "prepare NotificationChannel, channelId=" + str + "");
            try {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
                if (notificationChannel != null) {
                    notificationChannel.setName(charSequence);
                    notificationManager.createNotificationChannel(notificationChannel);
                    return true;
                }
            } catch (Throwable th) {
                Logger.w("ChannelHelper", "check channelID failed:" + th.getMessage());
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i2);
            try {
                if (Build.VERSION.SDK_INT < 28 || notificationManager.getNotificationChannelGroup("JIGUANG_CHANNEL_GROUP") == null) {
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("JIGUANG_CHANNEL_GROUP", cn.jpush.android.bm.a.b(context)));
                }
                notificationChannel2.setGroup("JIGUANG_CHANNEL_GROUP");
            } catch (Throwable th2) {
                Logger.ww("ChannelHelper", "config channel group failed:" + th2.getMessage());
            }
            try {
                notificationChannel2.enableLights((i3 & 4) != 0);
            } catch (Throwable th3) {
                Logger.ww("ChannelHelper", "enableLights fail:" + th3);
            }
            try {
                notificationChannel2.enableVibration((i3 & 2) != 0);
            } catch (Throwable th4) {
                Logger.ww("ChannelHelper", "enableVibration fail:" + th4);
            }
            try {
                if (uri != null) {
                    notificationChannel2.setSound(uri, null);
                } else {
                    if (!((i3 & 1) != 0)) {
                        notificationChannel2.setSound(null, null);
                    }
                }
            } catch (Throwable th5) {
                Logger.ww("ChannelHelper", "setSound fail:" + th5);
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        } catch (Throwable th6) {
            Logger.ee("ChannelHelper", "new NotificationChannel fail:" + th6);
            return false;
        }
    }

    public static int b(int i2) {
        if (i2 == 1) {
            return -2;
        }
        if (i2 != 2) {
            return (i2 == 4 || i2 == 5) ? 1 : 0;
        }
        return -1;
    }
}
