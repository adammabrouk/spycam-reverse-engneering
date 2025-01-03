package a.a.e.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* compiled from: ActivityResultContract.java */
/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* compiled from: ActivityResultContract.java */
    /* renamed from: a.a.e.d.a$a, reason: collision with other inner class name */
    public static final class C0000a<T> {

        /* renamed from: a, reason: collision with root package name */
        @SuppressLint({"UnknownNullness"})
        public final T f146a;

        public C0000a(@SuppressLint({"UnknownNullness"}) T t) {
            this.f146a = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T a() {
            return this.f146a;
        }
    }

    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i2);

    @SuppressLint({"UnknownNullness"})
    public abstract O a(int i2, Intent intent);

    public C0000a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i2) {
        return null;
    }
}
