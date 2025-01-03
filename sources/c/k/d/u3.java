package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public final class u3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7922a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7923b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7924c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7925d;

    public u3(Context context, String str, int i2, String str2) {
        this.f7922a = context;
        this.f7923b = str;
        this.f7924c = i2;
        this.f7925d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        t3.c(this.f7922a, this.f7923b, this.f7924c, this.f7925d);
    }
}
