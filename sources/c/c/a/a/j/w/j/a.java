package c.c.a.a.j.w.j;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3655a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.w.k.c f3656b;

    /* renamed from: c, reason: collision with root package name */
    public AlarmManager f3657c;

    /* renamed from: d, reason: collision with root package name */
    public final g f3658d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3659e;

    public a(Context context, c.c.a.a.j.w.k.c cVar, c.c.a.a.j.y.a aVar, g gVar) {
        this(context, cVar, (AlarmManager) context.getSystemService("alarm"), aVar, gVar);
    }

    public boolean a(Intent intent) {
        return PendingIntent.getBroadcast(this.f3655a, 0, intent, 536870912) != null;
    }

    @Override // c.c.a.a.j.w.j.s
    public void a(c.c.a.a.j.l lVar, int i2) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", lVar.a());
        builder.appendQueryParameter("priority", String.valueOf(c.c.a.a.j.z.a.a(lVar.c())));
        if (lVar.b() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(lVar.b(), 0));
        }
        Intent intent = new Intent(this.f3655a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        if (a(intent)) {
            c.c.a.a.j.u.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", lVar);
            return;
        }
        long b2 = this.f3656b.b(lVar);
        long a2 = this.f3658d.a(lVar.c(), b2, i2);
        c.c.a.a.j.u.a.a("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", lVar, Long.valueOf(a2), Long.valueOf(b2), Integer.valueOf(i2));
        this.f3657c.set(3, this.f3659e.a() + a2, PendingIntent.getBroadcast(this.f3655a, 0, intent, 0));
    }

    public a(Context context, c.c.a.a.j.w.k.c cVar, AlarmManager alarmManager, c.c.a.a.j.y.a aVar, g gVar) {
        this.f3655a = context;
        this.f3656b = cVar;
        this.f3657c = alarmManager;
        this.f3659e = aVar;
        this.f3658d = gVar;
    }
}
