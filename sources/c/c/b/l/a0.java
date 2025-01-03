package c.c.b.l;

import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class a0 extends c.c.a.b.f.d.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f5903a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(x xVar, Looper looper) {
        super(looper);
        this.f5903a = xVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f5903a.a(message);
    }
}
