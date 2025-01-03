package cn.jpush.android.az;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: cn.jpush.android.az.a$a, reason: collision with other inner class name */
    public static class C0152a {

        /* renamed from: a, reason: collision with root package name */
        public String f9442a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f9443b;

        /* renamed from: c, reason: collision with root package name */
        public int f9444c;

        /* renamed from: d, reason: collision with root package name */
        public int f9445d;

        /* renamed from: e, reason: collision with root package name */
        public int f9446e;

        /* renamed from: f, reason: collision with root package name */
        public String f9447f;

        /* renamed from: g, reason: collision with root package name */
        public Uri f9448g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9449h;

        public C0152a(String str, CharSequence charSequence, int i2, int i3, String str2) {
            this.f9442a = str;
            this.f9443b = charSequence;
            this.f9444c = i2;
            this.f9446e = i3;
            this.f9447f = str2;
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
                    cn.jpush.android.r.b.c("ChannelHelper", "channel has created: " + str);
                    return notificationChannel;
                }
                cn.jpush.android.r.b.c("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.h("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
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
            cn.jpush.android.r.b.c("ChannelHelper", str);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            z = Locale.getDefault().getLanguage().contains("zh");
        } catch (Throwable th2) {
            cn.jpush.android.r.b.g("ChannelHelper", "get language failed:" + th2.getMessage());
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

    public static String a(C0152a c0152a) {
        String str = "JPush_" + c0152a.f9445d + "_" + c0152a.f9446e;
        if (c0152a.f9448g == null) {
            return str;
        }
        return str + "_" + c0152a.f9447f;
    }

    public static void a(Context context, C0152a c0152a) {
        NotificationChannel a2;
        NotificationChannel a3;
        if (cn.jpush.android.ax.a.b(context)) {
            cn.jpush.android.r.b.b("ChannelHelper", "in silence push time,change defaults to 0");
            c0152a.f9442a = "";
            c0152a.f9446e = 0;
            c0152a.f9447f = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (a2 = a(context, c0152a.f9442a)) != null) {
            c0152a.f9442a = a2.getId();
            c0152a.f9443b = a2.getName();
            int importance = a2.getImportance();
            c0152a.f9445d = importance;
            c0152a.f9444c = b(importance);
            Uri sound = a2.getSound();
            c0152a.f9448g = sound;
            if (sound != null) {
                c0152a.f9447f = sound.getPath();
            }
            c0152a.f9449h = true;
            return;
        }
        int i2 = c0152a.f9444c;
        if (i2 == -2 || i2 == -1) {
            c0152a.f9446e = 0;
            c0152a.f9447f = null;
        } else if (i2 >= 0 && c0152a.f9446e == 0 && TextUtils.isEmpty(c0152a.f9447f)) {
            c0152a.f9444c = -1;
        }
        c0152a.f9446e &= 7;
        if (c0152a.f9444c == 2) {
            c0152a.f9444c = 1;
        }
        int a4 = a(c0152a.f9444c);
        c0152a.f9445d = a4;
        c0152a.f9444c = b(a4);
        Uri a5 = cn.jpush.android.ax.a.a(context, c0152a.f9447f);
        c0152a.f9448g = a5;
        if (a5 != null) {
            c0152a.f9446e &= -2;
        } else {
            c0152a.f9447f = null;
        }
        if (TextUtils.isEmpty(c0152a.f9442a)) {
            String a6 = a(c0152a);
            c0152a.f9442a = a6;
            if (Build.VERSION.SDK_INT >= 26 && (a3 = a(context, a6)) != null) {
                c0152a.f9442a = a3.getId();
                c0152a.f9443b = a3.getName();
                c0152a.f9449h = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0152a.f9443b)) {
            c0152a.f9443b = ("KG_channel_normal".equals(c0152a.f9442a) && "com.tencent.karaoke".equals(context.getPackageName())) ? "普通_K歌" : a(context, c0152a.f9444c);
        }
        cn.jpush.android.r.b.b("ChannelHelper", "create channelId:" + c0152a.f9442a + ",channelName:" + ((Object) c0152a.f9443b) + " soundUri:" + c0152a.f9448g);
        c0152a.f9449h = a(context, c0152a.f9442a, c0152a.f9443b, c0152a.f9445d, c0152a.f9446e, c0152a.f9448g);
    }

    public static boolean a(Context context, String str, CharSequence charSequence, int i2, int i3, Uri uri) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            cn.jpush.android.r.b.b("ChannelHelper", "sdkversion < 26, no need use notificationChannel!");
            return false;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                cn.jpush.android.r.b.i("ChannelHelper", "NotificationManager is null!");
                return false;
            }
            cn.jpush.android.r.b.c("ChannelHelper", "prepare NotificationChannel, channelId=" + str + "");
            try {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
                if (notificationChannel != null) {
                    notificationChannel.setName(charSequence);
                    notificationManager.createNotificationChannel(notificationChannel);
                    return true;
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("ChannelHelper", "check channelID failed:" + th.getMessage());
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i2);
            try {
                if (Build.VERSION.SDK_INT < 28 || notificationManager.getNotificationChannelGroup("JIGUANG_CHANNEL_GROUP") == null) {
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("JIGUANG_CHANNEL_GROUP", cn.jpush.android.bm.a.b(context)));
                }
                notificationChannel2.setGroup("JIGUANG_CHANNEL_GROUP");
            } catch (Throwable th2) {
                cn.jpush.android.r.b.g("ChannelHelper", "config channel group failed:" + th2.getMessage());
            }
            try {
                notificationChannel2.enableLights((i3 & 4) != 0);
            } catch (Throwable th3) {
                cn.jpush.android.r.b.g("ChannelHelper", "enableLights fail:" + th3);
            }
            try {
                notificationChannel2.enableVibration((i3 & 2) != 0);
            } catch (Throwable th4) {
                cn.jpush.android.r.b.g("ChannelHelper", "enableVibration fail:" + th4);
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
                cn.jpush.android.r.b.g("ChannelHelper", "setSound fail:" + th5);
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        } catch (Throwable th6) {
            cn.jpush.android.r.b.i("ChannelHelper", "new NotificationChannel fail:" + th6);
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
