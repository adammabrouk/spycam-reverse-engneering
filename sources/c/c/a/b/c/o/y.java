package c.c.a.b.c.o;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public final class y extends f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f3999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f4000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4001c;

    public y(Intent intent, Activity activity, int i2) {
        this.f3999a = intent;
        this.f4000b = activity;
        this.f4001c = i2;
    }

    @Override // c.c.a.b.c.o.f
    public final void a() {
        Intent intent = this.f3999a;
        if (intent != null) {
            this.f4000b.startActivityForResult(intent, this.f4001c);
        }
    }
}
