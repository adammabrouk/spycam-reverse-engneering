package a.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class g extends t0 {

    /* compiled from: Fade.java */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1806a;

        public a(g gVar, View view) {
            this.f1806a = view;
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            m0.a(this.f1806a, 1.0f);
            m0.a(this.f1806a);
            wVar.b(this);
        }
    }

    /* compiled from: Fade.java */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final View f1807a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1808b = false;

        public b(View view) {
            this.f1807a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m0.a(this.f1807a, 1.0f);
            if (this.f1808b) {
                this.f1807a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (a.h.j.y.F(this.f1807a) && this.f1807a.getLayerType() == 0) {
                this.f1808b = true;
                this.f1807a.setLayerType(2, null);
            }
        }
    }

    public g(int i2) {
        a(i2);
    }

    public final Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        m0.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, m0.f1853b, f3);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // a.t.t0
    public Animator b(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        m0.e(view);
        return a(view, a(c0Var, 1.0f), 0.0f);
    }

    @Override // a.t.t0, a.t.w
    public void c(c0 c0Var) {
        super.c(c0Var);
        c0Var.f1752a.put("android:fade:transitionAlpha", Float.valueOf(m0.c(c0Var.f1753b)));
    }

    public g() {
    }

    @Override // a.t.t0
    public Animator a(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        float a2 = a(c0Var, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    public static float a(c0 c0Var, float f2) {
        Float f3;
        return (c0Var == null || (f3 = (Float) c0Var.f1752a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }
}
