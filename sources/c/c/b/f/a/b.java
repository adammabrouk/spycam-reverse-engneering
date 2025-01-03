package c.c.b.f.a;

import android.content.Context;
import android.os.Bundle;
import c.c.a.b.c.o.r;
import c.c.b.c;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f5822b;

    /* renamed from: a, reason: collision with root package name */
    public final AppMeasurement f5823a;

    public b(AppMeasurement appMeasurement) {
        r.a(appMeasurement);
        this.f5823a = appMeasurement;
        new ConcurrentHashMap();
    }

    public static a a(c cVar, Context context, c.c.b.j.d dVar) {
        r.a(cVar);
        r.a(context);
        r.a(dVar);
        r.a(context.getApplicationContext());
        if (f5822b == null) {
            synchronized (b.class) {
                if (f5822b == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.h()) {
                        dVar.a(c.c.b.a.class, e.f5831a, d.f5830a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.g());
                    }
                    f5822b = new b(AppMeasurement.a(context, bundle));
                }
            }
        }
        return f5822b;
    }

    @Override // c.c.b.f.a.a
    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (c.c.b.f.a.c.b.a(str) && c.c.b.f.a.c.b.a(str2, bundle) && c.c.b.f.a.c.b.a(str, str2, bundle)) {
            c.c.b.f.a.c.b.b(str, str2, bundle);
            this.f5823a.logEventInternal(str, str2, bundle);
        }
    }

    @Override // c.c.b.f.a.a
    public void a(String str, String str2, Object obj) {
        if (c.c.b.f.a.c.b.a(str) && c.c.b.f.a.c.b.a(str, str2)) {
            this.f5823a.a(str, str2, obj);
        }
    }

    public static final /* synthetic */ void a(c.c.b.j.a aVar) {
        boolean z = ((c.c.b.a) aVar.a()).f5799a;
        synchronized (b.class) {
            ((b) f5822b).f5823a.a(z);
        }
    }
}
