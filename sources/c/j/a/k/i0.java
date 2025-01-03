package c.j.a.k;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.security.PublicKey;

/* compiled from: OnReceiveTask.java */
/* loaded from: classes.dex */
public abstract class i0 extends c.j.a.r {

    /* renamed from: d, reason: collision with root package name */
    public c.j.a.y.a f6591d;

    public i0(c.j.a.v vVar) {
        super(vVar);
    }

    public final void a(c.j.a.y.a aVar) {
        this.f6591d = aVar;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) this.f6635a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (Build.VERSION.SDK_INT < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("vivo_push_channel");
            if (notificationChannel != null) {
                return notificationChannel.getImportance() == 0 ? 2121 : 0;
            }
            return 0;
        } catch (Exception unused) {
            c.j.a.z.v.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!c.j.a.m.m().c()) {
            c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            c.j.a.z.v.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
        try {
            c.j.a.z.v.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
            if (c.j.a.z.a0.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify id is success");
                return true;
            }
            c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
            c.j.a.z.v.c(this.f6635a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            c.j.a.z.v.d("OnVerifyCallBackCommand", "vertify exception");
            return false;
        }
    }
}
