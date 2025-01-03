package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public int f10303a;

    /* renamed from: b, reason: collision with root package name */
    public int f10304b;

    /* renamed from: c, reason: collision with root package name */
    public int f10305c;

    /* renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimator f10306d;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f10306d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f10303a = 0;
        this.f10304b = 2;
        this.f10305c = 0;
    }

    public void b(V v) {
        if (this.f10304b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10306d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f10304b = 2;
        a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, c.c.a.c.a.a.f5309d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        return i2 == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.f10303a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.a(coordinatorLayout, (CoordinatorLayout) v, i2);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10303a = 0;
        this.f10304b = 2;
        this.f10305c = 0;
    }

    public void a(V v, int i2) {
        this.f10305c = i2;
        if (this.f10304b == 1) {
            v.setTranslationY(this.f10303a + i2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i3 > 0) {
            a((HideBottomViewOnScrollBehavior<V>) v);
        } else if (i3 < 0) {
            b(v);
        }
    }

    public void a(V v) {
        if (this.f10304b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f10306d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f10304b = 1;
        a((HideBottomViewOnScrollBehavior<V>) v, this.f10303a + this.f10305c, 175L, c.c.a.c.a.a.f5308c);
    }

    public final void a(V v, int i2, long j, TimeInterpolator timeInterpolator) {
        this.f10306d = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }
}
