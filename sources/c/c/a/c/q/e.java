package c.c.a.c.q;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes.dex */
public class e extends d {

    /* compiled from: FloatingActionButtonImplLollipop.java */
    public static class a extends h {
        public a(m mVar) {
            super(mVar);
        }

        @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public e(FloatingActionButton floatingActionButton, c.c.a.c.v.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // c.c.a.c.q.d
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        h a2 = a();
        this.f5504b = a2;
        a2.setTintList(colorStateList);
        if (mode != null) {
            this.f5504b.setTintMode(mode);
        }
        this.f5504b.a(this.y.getContext());
        if (i2 > 0) {
            this.f5506d = a(i2, colorStateList);
            c cVar = this.f5506d;
            a.h.i.h.a(cVar);
            h hVar = this.f5504b;
            a.h.i.h.a(hVar);
            drawable = new LayerDrawable(new Drawable[]{cVar, hVar});
        } else {
            this.f5506d = null;
            drawable = this.f5504b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(c.c.a.c.u.b.b(colorStateList2), drawable, null);
        this.f5505c = rippleDrawable;
        this.f5507e = rippleDrawable;
    }

    @Override // c.c.a.c.q.d
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.f5505c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(c.c.a.c.u.b.b(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // c.c.a.c.q.d
    public float e() {
        return this.y.getElevation();
    }

    @Override // c.c.a.c.q.d
    public void o() {
    }

    @Override // c.c.a.c.q.d
    public void q() {
        B();
    }

    @Override // c.c.a.c.q.d
    public boolean v() {
        return false;
    }

    @Override // c.c.a.c.q.d
    public boolean w() {
        return this.z.a() || !y();
    }

    @Override // c.c.a.c.q.d
    public void z() {
    }

    @Override // c.c.a.c.q.d
    public void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.G, a(f2, f4));
            stateListAnimator.addState(d.H, a(f2, f3));
            stateListAnimator.addState(d.I, a(f2, f3));
            stateListAnimator.addState(d.J, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L));
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.F);
            stateListAnimator.addState(d.K, animatorSet);
            stateListAnimator.addState(d.L, a(0.0f, 0.0f));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (w()) {
            B();
        }
    }

    public final Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.F);
        return animatorSet;
    }

    @Override // c.c.a.c.q.d
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.y.isEnabled()) {
                this.y.setElevation(this.f5510h);
                if (this.y.isPressed()) {
                    this.y.setTranslationZ(this.j);
                    return;
                } else if (!this.y.isFocused() && !this.y.isHovered()) {
                    this.y.setTranslationZ(0.0f);
                    return;
                } else {
                    this.y.setTranslationZ(this.f5511i);
                    return;
                }
            }
            this.y.setElevation(0.0f);
            this.y.setTranslationZ(0.0f);
        }
    }

    public c a(int i2, ColorStateList colorStateList) {
        Context context = this.y.getContext();
        m mVar = this.f5503a;
        a.h.i.h.a(mVar);
        c cVar = new c(mVar);
        cVar.a(a.h.b.a.a(context, R$color.design_fab_stroke_top_outer_color), a.h.b.a.a(context, R$color.design_fab_stroke_top_inner_color), a.h.b.a.a(context, R$color.design_fab_stroke_end_inner_color), a.h.b.a.a(context, R$color.design_fab_stroke_end_outer_color));
        cVar.a(i2);
        cVar.a(colorStateList);
        return cVar;
    }

    @Override // c.c.a.c.q.d
    public h a() {
        m mVar = this.f5503a;
        a.h.i.h.a(mVar);
        return new a(mVar);
    }

    @Override // c.c.a.c.q.d
    public void a(Rect rect) {
        if (this.z.a()) {
            super.a(rect);
        } else if (!y()) {
            int sizeDimension = (this.k - this.y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
