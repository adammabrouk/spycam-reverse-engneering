package c.c.a.b.c;

import a.h.a.g;
import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.FragmentActivity;
import c.c.a.b.c.o.r;
import c.c.a.b.c.s.n;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f3809d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final c f3810e = new c();

    /* renamed from: c, reason: collision with root package name */
    public String f3811c;

    @SuppressLint({"HandlerLeak"})
    public class a extends c.c.a.b.f.b.e {

        /* renamed from: a, reason: collision with root package name */
        public final Context f3812a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f3812a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int b2 = c.this.b(this.f3812a);
            if (c.this.b(b2)) {
                c.this.b(this.f3812a, b2);
            }
        }
    }

    public static c a() {
        return f3810e;
    }

    public boolean b(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i2, i3, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final void c(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public Dialog a(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a(activity, i2, c.c.a.b.c.o.f.a(activity, a(activity, i2, "d"), i3), onCancelListener);
    }

    public void b(Context context, int i2) {
        a(context, i2, (String) null, a(context, i2, 0, "n"));
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent a2 = a(context, connectionResult);
        if (a2 == null) {
            return false;
        }
        a(context, connectionResult.u(), (String) null, GoogleApiActivity.a(context, a2, i2));
        return true;
    }

    public final String b() {
        String str;
        synchronized (f3809d) {
            str = this.f3811c;
        }
        return str;
    }

    @Override // c.c.a.b.c.d
    public int b(Context context) {
        return super.b(context);
    }

    @Override // c.c.a.b.c.d
    public int a(Context context, int i2) {
        return super.a(context, i2);
    }

    @Override // c.c.a.b.c.d
    public final boolean b(int i2) {
        return super.b(i2);
    }

    @Override // c.c.a.b.c.d
    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    @Override // c.c.a.b.c.d
    public PendingIntent a(Context context, int i2, int i3) {
        return super.a(context, i2, i3);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.x()) {
            return connectionResult.w();
        }
        return a(context, connectionResult.u(), 0);
    }

    @Override // c.c.a.b.c.d
    public final String a(int i2) {
        return super.a(i2);
    }

    public static Dialog a(Context context, int i2, c.c.a.b.c.o.f fVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(c.c.a.b.c.o.e.b(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a2 = c.c.a.b.c.o.e.a(context, i2);
        if (a2 != null) {
            builder.setPositiveButton(a2, fVar);
        }
        String e2 = c.c.a.b.c.o.e.e(context, i2);
        if (e2 != null) {
            builder.setTitle(e2);
        }
        return builder.create();
    }

    public static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            j.a(dialog, onCancelListener).a(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @TargetApi(20)
    public final void a(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            c(context);
            return;
        }
        if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String d2 = c.c.a.b.c.o.e.d(context, i2);
        String c2 = c.c.a.b.c.o.e.c(context, i2);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        g.e eVar = new g.e(context);
        eVar.b(true);
        eVar.a(true);
        eVar.b(d2);
        g.c cVar = new g.c();
        cVar.a(c2);
        eVar.a(cVar);
        if (c.c.a.b.c.s.i.b(context)) {
            r.b(n.f());
            eVar.e(context.getApplicationInfo().icon);
            eVar.d(2);
            if (c.c.a.b.c.s.i.c(context)) {
                eVar.a(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent);
            } else {
                eVar.a(pendingIntent);
            }
        } else {
            eVar.e(R.drawable.stat_sys_warning);
            eVar.c(resources.getString(R$string.common_google_play_services_notification_ticker));
            eVar.a(System.currentTimeMillis());
            eVar.a(pendingIntent);
            eVar.a((CharSequence) c2);
        }
        if (n.i()) {
            r.b(n.i());
            String b2 = b();
            if (b2 == null) {
                b2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String b3 = c.c.a.b.c.o.e.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", b3, 4));
                } else if (!b3.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(b3);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVar.a(b2);
        }
        Notification a2 = eVar.a();
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            i3 = 10436;
            h.f3823d.set(false);
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, a2);
    }
}
