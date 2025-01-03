package c.j.a.z;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import c.j.a.k.a0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: NotifyAdapterUtil.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f6683a = 20000000;

    /* renamed from: b, reason: collision with root package name */
    public static NotificationManager f6684b;

    public static void a(Context context, List<Bitmap> list, c.j.a.t.a aVar, long j, int i2, a0.a aVar2) {
        v.d("NotifyManager", "pushNotification");
        b(context);
        int a2 = e.a(context).a(aVar);
        if (!TextUtils.isEmpty(aVar.l()) && list != null && list.size() > 1 && list.get(1) != null) {
            a2 = 1;
        }
        if (a2 == 2) {
            b(context, list, aVar, j, i2, aVar2);
        } else if (a2 == 1) {
            a(context, list, aVar, j, aVar2);
        }
    }

    public static synchronized void b(Context context) {
        synchronized (d.class) {
            if (f6684b == null) {
                f6684b = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && f6684b != null) {
                NotificationChannel notificationChannel = f6684b.getNotificationChannel("default");
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if ("推送通知".equals(name) || "PUSH".equals(name)) {
                        f6684b.deleteNotificationChannel("default");
                    }
                }
                NotificationChannel notificationChannel2 = new NotificationChannel("vivo_push_channel", c(context) ? "推送通知" : "PUSH", 4);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLockscreenVisibility(1);
                f6684b.createNotificationChannel(notificationChannel2);
            }
        }
    }

    public static boolean c(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void a(Context context, List<Bitmap> list, c.j.a.t.a aVar, long j, a0.a aVar2) {
        Notification notification;
        int i2;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String p = aVar.p();
        int a2 = e.a(context).a();
        int i3 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong("pushId", j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Notification.Builder builder = new Notification.Builder(context, "vivo_push_channel");
            if (a2 > 0) {
                bundle.putInt("vivo.summaryIconRes", a2);
            }
            builder.setExtras(bundle);
            notification = builder.build();
        } else if (i4 >= 19) {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            notification = builder2.build();
        } else {
            notification = new Notification();
        }
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = p;
        int b2 = e.a(context).b();
        if (b2 <= 0) {
            b2 = i3;
        }
        notification.icon = b2;
        RemoteViews remoteViews = new RemoteViews(packageName, e.b(context).c());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), p);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), e.b(context).a());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), aVar.e());
        if (aVar.r()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int b3 = e.b(context).b();
        remoteViews.setViewVisibility(b3, i2);
        if (list != null && !list.isEmpty() && (bitmap = list.get(i2)) != null) {
            remoteViews.setImageViewBitmap(b3, bitmap);
        } else {
            if (a2 <= 0) {
                a2 = i3;
            }
            remoteViews.setImageViewResource(b3, a2);
        }
        Bitmap bitmap2 = null;
        if (list != null && list.size() > 1) {
            bitmap2 = list.get(1);
        }
        if (bitmap2 != null) {
            if (!TextUtils.isEmpty(aVar.l())) {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
            }
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        }
        notification.contentView = remoteViews;
        if (Build.VERSION.SDK_INT >= 16 && TextUtils.isEmpty(aVar.l())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        v.d("NotifyManager", "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int j2 = aVar.j();
        if (j2 != 2) {
            if (j2 != 3) {
                if (j2 == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", g.a(context).a("com.vivo.pushservice"));
            if (Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("security_avoid_pull_rsa", c.j.a.h.d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", a0.a(c.j.a.h.d.a(context).a().a()));
            }
        } catch (Exception e2) {
            v.a("NotifyManager", "pushNotificationByCustom encrypt ：" + e2.getMessage());
        }
        new c.j.a.f.o(packageName, j, aVar).b(intent);
        notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456);
        if (f6684b != null) {
            int i5 = c.j.a.m.m().i();
            try {
                if (i5 == 0) {
                    f6684b.notify(f6683a, notification);
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                if (i5 == 1) {
                    f6684b.notify((int) j, notification);
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                v.a("NotifyManager", "unknow notify style ".concat(String.valueOf(i5)));
            } catch (Exception e3) {
                v.a("NotifyManager", e3);
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        }
    }

    public static void b(Context context, List<Bitmap> list, c.j.a.t.a aVar, long j, int i2, a0.a aVar2) {
        String str;
        Bitmap bitmap;
        Notification.Builder builder;
        int i3;
        Bitmap bitmap2;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String p = aVar.p();
        String e2 = aVar.e();
        int i4 = context.getApplicationInfo().icon;
        boolean r = aVar.r();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int a2 = e.a(context).a();
        if (list == null || list.isEmpty()) {
            str = packageName;
            bitmap = null;
        } else {
            bitmap = list.get(0);
            if (bitmap == null || a2 <= 0 || (decodeResource = BitmapFactory.decodeResource(context.getResources(), a2)) == null) {
                str = packageName;
            } else {
                int width = decodeResource.getWidth();
                str = packageName;
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = i.a(bitmap, width, height);
            }
        }
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, "vivo_push_channel");
            if (a2 > 0) {
                bundle.putInt("vivo.summaryIconRes", a2);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        } else {
            builder = new Notification.Builder(context);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            } else if (Build.VERSION.SDK_INT <= 22) {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i4));
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            bundle.putLong("pushId", j);
            builder.setExtras(bundle);
        }
        int b2 = e.a(context).b();
        if (b2 > 0) {
            i4 = b2;
        }
        builder.setSmallIcon(i4);
        if (aVar.d() != 1) {
            builder.setContentTitle(p);
        }
        builder.setPriority(2);
        builder.setContentText(e2);
        builder.setWhen(r ? System.currentTimeMillis() : 0L);
        builder.setShowWhen(r);
        builder.setTicker(p);
        int ringerMode = audioManager.getRingerMode();
        int j2 = aVar.j();
        if (j2 != 2) {
            if (j2 != 3) {
                if (j2 == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
        } else if (ringerMode == 2) {
            builder.setDefaults(1);
        }
        if (list == null || list.size() <= 1) {
            i3 = i2;
            bitmap2 = null;
        } else {
            bitmap2 = list.get(1);
            i3 = i2;
        }
        if (i3 != 1) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(p);
            bigTextStyle.bigText(e2);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(p);
            bigPictureStyle.setSummaryText(e2);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", g.a(context).a("com.vivo.pushservice"));
            if (Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("security_avoid_pull_rsa", c.j.a.h.d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", a0.a(c.j.a.h.d.a(context).a().a()));
            }
        } catch (Exception e3) {
            v.a("NotifyManager", "pushNotificationBySystem encrypt ：" + e3.getMessage());
        }
        new c.j.a.f.o(str, j, aVar).b(intent);
        builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456));
        Notification build = builder.build();
        int i5 = c.j.a.m.m().i();
        NotificationManager notificationManager = f6684b;
        if (notificationManager != null) {
            try {
                if (i5 == 0) {
                    notificationManager.notify(f6683a, build);
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                if (i5 == 1) {
                    notificationManager.notify((int) j, build);
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                v.a("NotifyManager", "unknow notify style ".concat(String.valueOf(i5)));
            } catch (Exception e4) {
                v.a("NotifyManager", e4);
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        }
    }

    public static boolean a(Context context, long j) {
        int i2 = c.j.a.m.m().i();
        if (i2 != 0) {
            if (i2 == 1) {
                return a(context, (int) j);
            }
            v.a("NotifyManager", "unknow cancle notify style ".concat(String.valueOf(i2)));
            return false;
        }
        long b2 = c0.b().b("com.vivo.push.notify_key", -1L);
        if (b2 == j) {
            v.d("NotifyManager", "undo showed message ".concat(String.valueOf(j)));
            v.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
            return a(context, f6683a);
        }
        v.d("NotifyManager", "current showing message id " + b2 + " not match " + j);
        v.a(context, "与已展示的通知" + b2 + "与待回收的通知" + j + "不匹配");
        return false;
    }

    public static boolean a(Context context, int i2) {
        b(context);
        NotificationManager notificationManager = f6684b;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i2);
        return true;
    }

    public static void a(Context context) {
        a(context, f6683a);
    }
}
