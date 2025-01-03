package c.k.c.a;

import android.content.Context;
import com.xiaomi.mipush.sdk.MessageHandleService;

/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6926a;

    public u(Context context) {
        this.f6926a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.f6926a);
    }
}
