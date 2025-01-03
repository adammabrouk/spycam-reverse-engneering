package c.k.c.a;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.PushMessageHandler;

/* loaded from: classes.dex */
public final class e0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6816a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f6817b;

    public e0(Context context, Intent intent) {
        this.f6816a = context;
        this.f6817b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.f6816a, this.f6817b);
    }
}
