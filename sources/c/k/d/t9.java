package c.k.d;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class t9 extends s9 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f7905d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.f7905d = runnable;
    }

    @Override // c.k.d.s9
    public void a(Context context) {
        Runnable runnable = this.f7905d;
        if (runnable != null) {
            runnable.run();
        }
    }
}
