package c.c.a.b.f.e;

import android.content.Context;
import android.os.Bundle;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class f extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4156e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4157f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f4158g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Bundle f4159h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f4160i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar, String str, String str2, Context context, Bundle bundle) {
        super(cVar);
        this.f4160i = cVar;
        this.f4156e = str;
        this.f4157f = str2;
        this.f4158g = context;
        this.f4159h = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: Exception -> 0x00a0, TryCatch #0 {Exception -> 0x00a0, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0083), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: Exception -> 0x00a0, TryCatch #0 {Exception -> 0x00a0, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0083), top: B:2:0x0002 }] */
    @Override // c.c.a.b.f.e.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            c.c.a.b.f.e.c r2 = r14.f4160i     // Catch: java.lang.Exception -> La0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> La0
            r3.<init>()     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c.a(r2, r3)     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c r2 = r14.f4160i     // Catch: java.lang.Exception -> La0
            java.lang.String r3 = r14.f4156e     // Catch: java.lang.Exception -> La0
            java.lang.String r4 = r14.f4157f     // Catch: java.lang.Exception -> La0
            boolean r2 = c.c.a.b.f.e.c.a(r2, r3, r4)     // Catch: java.lang.Exception -> La0
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.String r3 = r14.f4157f     // Catch: java.lang.Exception -> La0
            java.lang.String r2 = r14.f4156e     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c r4 = r14.f4160i     // Catch: java.lang.Exception -> La0
            java.lang.String r4 = c.c.a.b.f.e.c.b(r4)     // Catch: java.lang.Exception -> La0
            r10 = r2
            r11 = r3
            r9 = r4
            goto L2a
        L27:
            r9 = r3
            r10 = r9
            r11 = r10
        L2a:
            android.content.Context r2 = r14.f4158g     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c.c(r2)     // Catch: java.lang.Exception -> La0
            java.lang.Boolean r2 = c.c.a.b.f.e.c.f()     // Catch: java.lang.Exception -> La0
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> La0
            if (r2 != 0) goto L3e
            if (r10 == 0) goto L3c
            goto L3e
        L3c:
            r2 = 0
            goto L3f
        L3e:
            r2 = 1
        L3f:
            c.c.a.b.f.e.c r3 = r14.f4160i     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c r4 = r14.f4160i     // Catch: java.lang.Exception -> La0
            android.content.Context r5 = r14.f4158g     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.xc r4 = r4.a(r5, r2)     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c.a(r3, r4)     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c r3 = r14.f4160i     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.xc r3 = c.c.a.b.f.e.c.c(r3)     // Catch: java.lang.Exception -> La0
            if (r3 != 0) goto L60
            c.c.a.b.f.e.c r2 = r14.f4160i     // Catch: java.lang.Exception -> La0
            java.lang.String r2 = c.c.a.b.f.e.c.b(r2)     // Catch: java.lang.Exception -> La0
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: java.lang.Exception -> La0
            return
        L60:
            android.content.Context r3 = r14.f4158g     // Catch: java.lang.Exception -> La0
            int r3 = c.c.a.b.f.e.c.d(r3)     // Catch: java.lang.Exception -> La0
            android.content.Context r4 = r14.f4158g     // Catch: java.lang.Exception -> La0
            int r4 = c.c.a.b.f.e.c.e(r4)     // Catch: java.lang.Exception -> La0
            if (r2 == 0) goto L79
            int r2 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Exception -> La0
            if (r4 >= r3) goto L76
            r3 = 1
            goto L77
        L76:
            r3 = 0
        L77:
            r8 = r3
            goto L83
        L79:
            if (r3 <= 0) goto L7c
            r4 = r3
        L7c:
            if (r3 <= 0) goto L80
            r2 = 1
            goto L81
        L80:
            r2 = 0
        L81:
            r8 = r2
            r2 = r4
        L83:
            com.google.android.gms.internal.measurement.zzaa r13 = new com.google.android.gms.internal.measurement.zzaa     // Catch: java.lang.Exception -> La0
            r4 = 27000(0x6978, double:1.334E-319)
            long r6 = (long) r2     // Catch: java.lang.Exception -> La0
            android.os.Bundle r12 = r14.f4159h     // Catch: java.lang.Exception -> La0
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.c r2 = r14.f4160i     // Catch: java.lang.Exception -> La0
            c.c.a.b.f.e.xc r2 = c.c.a.b.f.e.c.c(r2)     // Catch: java.lang.Exception -> La0
            android.content.Context r3 = r14.f4158g     // Catch: java.lang.Exception -> La0
            c.c.a.b.d.a r3 = c.c.a.b.d.b.a(r3)     // Catch: java.lang.Exception -> La0
            long r4 = r14.f4107a     // Catch: java.lang.Exception -> La0
            r2.initialize(r3, r13, r4)     // Catch: java.lang.Exception -> La0
            return
        La0:
            r2 = move-exception
            c.c.a.b.f.e.c r3 = r14.f4160i
            c.c.a.b.f.e.c.a(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.f.a():void");
    }
}
