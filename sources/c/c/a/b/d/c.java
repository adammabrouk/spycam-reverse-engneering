package c.c.a.b.d;

import android.content.Context;
import android.os.IBinder;
import c.c.a.b.c.h;
import c.c.a.b.c.o.r;

/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f4043a;

    /* renamed from: b, reason: collision with root package name */
    public T f4044b;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public c(String str) {
        this.f4043a = str;
    }

    public final T a(Context context) throws a {
        if (this.f4044b == null) {
            r.a(context);
            Context b2 = h.b(context);
            if (b2 == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.f4044b = a((IBinder) b2.getClassLoader().loadClass(this.f4043a).newInstance());
            } catch (ClassNotFoundException e2) {
                throw new a("Could not load creator class.", e2);
            } catch (IllegalAccessException e3) {
                throw new a("Could not access creator.", e3);
            } catch (InstantiationException e4) {
                throw new a("Could not instantiate creator.", e4);
            }
        }
        return this.f4044b;
    }

    public abstract T a(IBinder iBinder);
}
