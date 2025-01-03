package c.c.a.b.g.b;

import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class w9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yc f5170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f5171b;

    public w9(AppMeasurementDynamiteService appMeasurementDynamiteService, yc ycVar) {
        this.f5171b = appMeasurementDynamiteService;
        this.f5170a = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5171b.f10200a.v().a(this.f5170a, this.f5171b.f10200a.f());
    }
}
