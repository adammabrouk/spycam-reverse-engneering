package c.c.a.b.f.e;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o1 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f4340a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(m1 m1Var, Handler handler) {
        super(null);
        this.f4340a = m1Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f4340a.b();
    }
}
