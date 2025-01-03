package c.c.a.b.g.b;

import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class d8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yc f4675a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4676b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4677c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4678d;

    public d8(AppMeasurementDynamiteService appMeasurementDynamiteService, yc ycVar, String str, String str2) {
        this.f4678d = appMeasurementDynamiteService;
        this.f4675a = ycVar;
        this.f4676b = str;
        this.f4677c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4678d.f10200a.E().a(this.f4675a, this.f4676b, this.f4677c);
    }
}
