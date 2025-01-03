package a.h.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<View> f1125a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f1126b = null;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f1127c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f1128d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f1129a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1130b;

        public a(c0 c0Var, d0 d0Var, View view) {
            this.f1129a = d0Var;
            this.f1130b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1129a.a(this.f1130b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1129a.b(this.f1130b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1129a.c(this.f1130b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f1131a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1132b;

        public b(c0 c0Var, f0 f0Var, View view) {
            this.f1131a = f0Var;
            this.f1132b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1131a.a(this.f1132b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    public static class c implements d0 {

        /* renamed from: a, reason: collision with root package name */
        public c0 f1133a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1134b;

        public c(c0 c0Var) {
            this.f1133a = c0Var;
        }

        @Override // a.h.j.d0
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            d0 d0Var = tag instanceof d0 ? (d0) tag : null;
            if (d0Var != null) {
                d0Var.a(view);
            }
        }

        @Override // a.h.j.d0
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i2 = this.f1133a.f1128d;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.f1133a.f1128d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1134b) {
                c0 c0Var = this.f1133a;
                Runnable runnable = c0Var.f1127c;
                if (runnable != null) {
                    c0Var.f1127c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                d0 d0Var = tag instanceof d0 ? (d0) tag : null;
                if (d0Var != null) {
                    d0Var.b(view);
                }
                this.f1134b = true;
            }
        }

        @Override // a.h.j.d0
        public void c(View view) {
            this.f1134b = false;
            if (this.f1133a.f1128d > -1) {
                view.setLayerType(2, null);
            }
            c0 c0Var = this.f1133a;
            Runnable runnable = c0Var.f1126b;
            if (runnable != null) {
                c0Var.f1126b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            d0 d0Var = tag instanceof d0 ? (d0) tag : null;
            if (d0Var != null) {
                d0Var.c(view);
            }
        }
    }

    public c0(View view) {
        this.f1125a = new WeakReference<>(view);
    }

    public c0 a(long j) {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public c0 b(float f2) {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public void c() {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public c0 a(float f2) {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public long b() {
        View view = this.f1125a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public c0 a(Interpolator interpolator) {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public c0 b(long j) {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = this.f1125a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public c0 a(d0 d0Var) {
        View view = this.f1125a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, d0Var);
            } else {
                view.setTag(2113929216, d0Var);
                a(view, new c(this));
            }
        }
        return this;
    }

    public final void a(View view, d0 d0Var) {
        if (d0Var != null) {
            view.animate().setListener(new a(this, d0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public c0 a(f0 f0Var) {
        View view = this.f1125a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(f0Var != null ? new b(this, f0Var, view) : null);
        }
        return this;
    }
}
