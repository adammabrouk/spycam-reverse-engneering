package c.k.c.a;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f6920b;

    public t(Context context, Intent intent) {
        this.f6919a = context;
        this.f6920b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6919a.startService(this.f6920b);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a(e2.getMessage());
        }
    }
}
