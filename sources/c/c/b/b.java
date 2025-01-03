package c.c.b;

import android.content.Context;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements c.c.b.m.a {

    /* renamed from: a, reason: collision with root package name */
    public final c f5800a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5801b;

    public b(c cVar, Context context) {
        this.f5800a = cVar;
        this.f5801b = context;
    }

    public static c.c.b.m.a a(c cVar, Context context) {
        return new b(cVar, context);
    }

    @Override // c.c.b.m.a
    public Object get() {
        return c.a(this.f5800a, this.f5801b);
    }
}
