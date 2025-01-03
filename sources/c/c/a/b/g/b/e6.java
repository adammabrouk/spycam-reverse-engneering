package c.c.a.b.g.b;

import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class e6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yc f4693a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaq f4694b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4695c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4696d;

    public e6(AppMeasurementDynamiteService appMeasurementDynamiteService, yc ycVar, zzaq zzaqVar, String str) {
        this.f4696d = appMeasurementDynamiteService;
        this.f4693a = ycVar;
        this.f4694b = zzaqVar;
        this.f4695c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4696d.f10200a.E().a(this.f4693a, this.f4694b, this.f4695c);
    }
}
