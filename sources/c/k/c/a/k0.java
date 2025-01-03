package c.k.c.a;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes.dex */
public class k0 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f6853a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(i0 i0Var, Handler handler) {
        super(handler);
        this.f6853a = i0Var;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        i0 i0Var = this.f6853a;
        context = i0Var.f6838b;
        i0Var.f6845i = Integer.valueOf(c.k.d.p9.y.a(context).a());
        num = this.f6853a.f6845i;
        if (num.intValue() != 0) {
            context2 = this.f6853a.f6838b;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f6853a.f6838b;
            if (c.k.d.e0.b(context3)) {
                this.f6853a.m31c();
            }
        }
    }
}
