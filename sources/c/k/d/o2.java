package c.k.d;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class o2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7447a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f7448b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n2 f7449c;

    public o2(n2 n2Var, Context context, Intent intent) {
        this.f7449c = n2Var;
        this.f7447a = context;
        this.f7448b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7449c.b(this.f7447a, this.f7448b);
    }
}
