package a.b.a;

import a.b.e.b;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f151a = -100;

    /* renamed from: b, reason: collision with root package name */
    public static final a.e.b<WeakReference<e>> f152b = new a.e.b<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f153c = new Object();

    public static e a(Activity activity, d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    public static void c(e eVar) {
        synchronized (f153c) {
            Iterator<WeakReference<e>> it = f152b.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static int k() {
        return f151a;
    }

    public abstract b a();

    public abstract a.b.e.b a(b.a aVar);

    public abstract <T extends View> T a(int i2);

    @Deprecated
    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public int b() {
        return -100;
    }

    public Context b(Context context) {
        a(context);
        return context;
    }

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b(int i2);

    public abstract MenuInflater c();

    public abstract void c(int i2);

    public abstract void c(Bundle bundle);

    public abstract a d();

    public void d(int i2) {
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public static e a(Dialog dialog, d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    public static void b(e eVar) {
        synchronized (f153c) {
            c(eVar);
        }
    }

    public static void a(e eVar) {
        synchronized (f153c) {
            c(eVar);
            f152b.add(new WeakReference<>(eVar));
        }
    }
}
