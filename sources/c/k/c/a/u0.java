package c.k.c.a;

import android.content.Context;
import c.k.d.a7;
import c.k.d.p9.m;

/* loaded from: classes.dex */
public class u0 extends m.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f6927b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(t0 t0Var, int i2, String str) {
        super(i2, str);
        this.f6927b = t0Var;
    }

    @Override // c.k.d.p9.m.a
    public void a() {
        Context context;
        boolean z;
        Context context2;
        context = this.f6927b.f6922a;
        boolean a2 = c.k.d.p9.m.a(context).a(a7.AggregatePushSwitch.a(), true);
        z = this.f6927b.f6924c;
        if (z != a2) {
            this.f6927b.f6924c = a2;
            context2 = this.f6927b.f6922a;
            w0.b(context2);
        }
    }
}
