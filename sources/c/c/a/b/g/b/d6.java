package c.c.a.b.g.b;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d6 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4664a;

    /* renamed from: b, reason: collision with root package name */
    public String f4665b;

    /* renamed from: c, reason: collision with root package name */
    public String f4666c;

    /* renamed from: d, reason: collision with root package name */
    public String f4667d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f4668e;

    /* renamed from: f, reason: collision with root package name */
    public long f4669f;

    /* renamed from: g, reason: collision with root package name */
    public zzaa f4670g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4671h;

    /* renamed from: i, reason: collision with root package name */
    public Long f4672i;

    public d6(Context context, zzaa zzaaVar, Long l) {
        this.f4671h = true;
        c.c.a.b.c.o.r.a(context);
        Context applicationContext = context.getApplicationContext();
        c.c.a.b.c.o.r.a(applicationContext);
        this.f4664a = applicationContext;
        this.f4672i = l;
        if (zzaaVar != null) {
            this.f4670g = zzaaVar;
            this.f4665b = zzaaVar.f10191f;
            this.f4666c = zzaaVar.f10190e;
            this.f4667d = zzaaVar.f10189d;
            this.f4671h = zzaaVar.f10188c;
            this.f4669f = zzaaVar.f10187b;
            Bundle bundle = zzaaVar.f10192g;
            if (bundle != null) {
                this.f4668e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
