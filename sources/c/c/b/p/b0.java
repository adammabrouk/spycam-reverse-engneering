package c.c.b.p;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    public static WeakReference<b0> f6114d;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6115a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f6116b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f6117c;

    public b0(SharedPreferences sharedPreferences, Executor executor) {
        this.f6117c = executor;
        this.f6115a = sharedPreferences;
    }

    public static synchronized b0 a(Context context, Executor executor) {
        b0 b0Var;
        synchronized (b0.class) {
            b0Var = f6114d != null ? f6114d.get() : null;
            if (b0Var == null) {
                b0Var = new b0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                b0Var.b();
                f6114d = new WeakReference<>(b0Var);
            }
        }
        return b0Var;
    }

    public final synchronized void b() {
        this.f6116b = a0.a(this.f6115a, "topic_operation_queue", ",", this.f6117c);
    }

    public final synchronized c0 a() {
        return c0.a(this.f6116b.a());
    }

    public final synchronized boolean a(c0 c0Var) {
        return this.f6116b.a(c0Var.c());
    }
}
