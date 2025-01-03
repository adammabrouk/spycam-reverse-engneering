package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f9039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f9040b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PushMessageReceiver f9041c;

    public a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.f9041c = pushMessageReceiver;
        this.f9039a = context;
        this.f9040b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9041c.a(this.f9039a, this.f9040b);
    }
}
