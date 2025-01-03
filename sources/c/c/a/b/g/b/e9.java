package c.c.a.b.g.b;

import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class e9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yc f4704a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4705b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4706c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4707d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4708e;

    public e9(AppMeasurementDynamiteService appMeasurementDynamiteService, yc ycVar, String str, String str2, boolean z) {
        this.f4708e = appMeasurementDynamiteService;
        this.f4704a = ycVar;
        this.f4705b = str;
        this.f4706c = str2;
        this.f4707d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4708e.f10200a.E().a(this.f4704a, this.f4705b, this.f4706c, this.f4707d);
    }
}
