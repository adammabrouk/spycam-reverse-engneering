package c.c.a.b.g.b;

import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class d7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yc f4673a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4674b;

    public d7(AppMeasurementDynamiteService appMeasurementDynamiteService, yc ycVar) {
        this.f4674b = appMeasurementDynamiteService;
        this.f4673a = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4674b.f10200a.E().a(this.f4673a);
    }
}
