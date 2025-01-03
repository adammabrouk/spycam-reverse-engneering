package c.c.a.b.j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f5268a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f5269b = new b0();

    public static final class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f5270a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f5270a.post(runnable);
        }
    }
}
