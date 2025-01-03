package cn.jpush.android.be;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f9534a;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9535e = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Handler f9536b;

    /* renamed from: c, reason: collision with root package name */
    public Context f9537c;

    /* renamed from: d, reason: collision with root package name */
    public String f9538d;

    public a(Context context) {
        this.f9536b = null;
        this.f9537c = null;
        this.f9538d = "";
        Logger.d("JPushLocalNotificationCenter", "Constructor : JPushLocalNotificationCenter");
        this.f9536b = new Handler(Looper.getMainLooper());
        this.f9537c = context;
        this.f9538d = context.getPackageName();
    }

    public static a a(Context context) {
        Logger.v("JPushLocalNotificationCenter", "getInstance");
        if (f9534a == null) {
            synchronized (f9535e) {
                if (f9534a == null) {
                    f9534a = new a(context);
                }
            }
        }
        return f9534a;
    }

    private synchronized void a(final long j, long j2, int i2) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification scheduleReadiedLN");
        if (this.f9536b != null) {
            Runnable runnable = new Runnable() { // from class: cn.jpush.android.be.a.2
                @Override // java.lang.Runnable
                public void run() {
                    long a2;
                    int i3;
                    int i4;
                    int i5;
                    String d2;
                    long f2;
                    long e2;
                    try {
                        b a3 = b.a(a.this.f9537c);
                        c a4 = a3.a(j, 0);
                        if (a4 != null) {
                            if (a4.c() == 1) {
                                Logger.d("JPushLocalNotificationCenter", "remove ");
                                a2 = a4.a();
                                i3 = 0;
                                i4 = 1;
                                i5 = 0;
                                d2 = a4.d();
                                f2 = a4.f();
                                e2 = a4.e();
                            } else {
                                if (a4.b() > 1) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    a3.b(a4.a(), a4.b() - 1, 0, 0, a4.d(), a4.f(), a4.e());
                                    return;
                                }
                                if (a4.b() != 1) {
                                    Logger.d("JPushLocalNotificationCenter", "already triggered");
                                    return;
                                }
                                Logger.d("JPushLocalNotificationCenter", "send broadcast");
                                if (a4.f() > System.currentTimeMillis()) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    return;
                                }
                                a.this.a(a.this.f9537c, a4.d());
                                a2 = a4.a();
                                i3 = 0;
                                i4 = 0;
                                i5 = 0;
                                d2 = a4.d();
                                f2 = a4.f();
                                e2 = a4.e();
                            }
                            a3.b(a2, i3, i4, i5, d2, f2, e2);
                        }
                    } catch (Exception e3) {
                        Logger.e("JPushLocalNotificationCenter", "exception:" + e3.getMessage());
                    }
                }
            };
            if (j2 <= 0) {
                Logger.d("JPushLocalNotificationCenter", "post right now ");
                this.f9536b.post(runnable);
            } else {
                Logger.d("JPushLocalNotificationCenter", "post delayed : " + j2);
                this.f9536b.postDelayed(runnable, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Context context) {
        Logger.d("JPushLocalNotificationCenter", "triggerLNKillProcess");
        b a2 = b.a(context);
        if (a2.a(false)) {
            Cursor cursor = null;
            try {
                try {
                    Cursor a3 = a2.a(1, System.currentTimeMillis());
                    try {
                        if (a3.moveToFirst()) {
                            do {
                                c a4 = b.a(a3);
                                if (a4 != null) {
                                    a(context, a4.d());
                                    a2.b(a4.a(), 0, 0, 0, a4.d(), a4.f(), a4.e());
                                }
                            } while (a3.moveToNext());
                        }
                        if (a3 != null) {
                            a3.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = a3;
                        Logger.ww("JPushLocalNotificationCenter", "triggerLNKillProcess: " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                    } catch (Throwable th) {
                        th = th;
                        cursor = a3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            a2.b(false);
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public void a(Context context, String str) {
        Logger.d("JPushLocalNotificationCenter", "start LocalNotification broadCastToPushService");
        Bundle bundle = new Bundle();
        bundle.putString("local_notify_msg", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "show_local_notify", bundle);
        Logger.d("JPushLocalNotificationCenter", "end LocalNotification broadCastToPushService");
    }

    public synchronized boolean a(Context context, long j) {
        Logger.dd("JPushLocalNotificationCenter", "remove LocalNotification ");
        long j2 = (int) j;
        try {
            b a2 = b.a(context);
            c a3 = a2.a(j2, 0);
            if (a3 == null) {
                return false;
            }
            Logger.d("JPushLocalNotificationCenter", "remove local count : " + a3.b());
            a2.a(j2);
            JPushInterface.clearNotificationById(this.f9537c, (int) j2);
            return true;
        } catch (Exception e2) {
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
            return false;
        }
    }

    public synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        Logger.dd("JPushLocalNotificationCenter", "add LocalNotification");
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        if (cn.jpush.android.cache.a.e(context)) {
            Logger.d("JPushLocalNotificationCenter", "push has stopped");
        }
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            b a2 = b.a(context);
            if (a2.a(notificationId, 0) != null) {
                a2.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a2.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e2) {
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
        }
        if (broadcastTime >= 300000) {
            return true;
        }
        a(jPushLocalNotification.getNotificationId(), broadcastTime, 0);
        return true;
    }

    public synchronized void b(Context context) {
        Logger.dd("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a2 = b.a(context).a();
        if (a2 != null && a2.length > 0) {
            Logger.d("JPushLocalNotificationCenter", " success");
            for (int i2 : a2) {
                JPushInterface.clearNotificationById(this.f9537c, i2);
            }
        }
    }

    public synchronized void c(Context context) {
        Logger.d("JPushLocalNotificationCenter", "init LocalNotification");
        b a2 = b.a(context);
        if (a2.a(false)) {
            Cursor cursor = null;
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    cursor = a2.a(currentTimeMillis, 300000L);
                    if (cursor.moveToFirst()) {
                        do {
                            c a3 = b.a(cursor);
                            if (a3 != null) {
                                a(a3.a(), a3.f() - currentTimeMillis, 0);
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e2) {
                    Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt:" + e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                a2.b(false);
            }
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public void d(final Context context) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification onHeartBeat");
        JCoreHelper.futureExecutor(context, "JPushLocalNotificationCenter", new cn.jpush.android.bm.e("JPushLocationNotificationCenter#onHeartBeat") { // from class: cn.jpush.android.be.a.1
            @Override // cn.jpush.android.bm.e
            public void a() {
                a.this.e(context);
                a.this.c(context);
            }
        });
    }
}
