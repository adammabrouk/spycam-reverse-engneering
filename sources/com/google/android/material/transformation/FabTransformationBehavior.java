package com.google.android.material.transformation;

import a.h.j.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.a.h;
import c.c.a.c.a.i;
import c.c.a.c.a.j;
import c.c.a.c.j.c;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.view.ViewfinderView;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f10683c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f10684d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f10685e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f10686f;

    /* renamed from: g, reason: collision with root package name */
    public float f10687g;

    /* renamed from: h, reason: collision with root package name */
    public float f10688h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10689a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f10690b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f10691c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f10689a = z;
            this.f10690b = view;
            this.f10691c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f10689a) {
                return;
            }
            this.f10690b.setVisibility(4);
            this.f10691c.setAlpha(1.0f);
            this.f10691c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f10689a) {
                this.f10690b.setVisibility(0);
                this.f10691c.setAlpha(0.0f);
                this.f10691c.setVisibility(4);
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10692a;

        public b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f10692a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f10692a.invalidate();
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.j.c f10693a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f10694b;

        public c(FabTransformationBehavior fabTransformationBehavior, c.c.a.c.j.c cVar, Drawable drawable) {
            this.f10693a = cVar;
            this.f10694b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10693a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f10693a.setCircularRevealOverlayDrawable(this.f10694b);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.j.c f10695a;

        public d(FabTransformationBehavior fabTransformationBehavior, c.c.a.c.j.c cVar) {
            this.f10695a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f10695a.getRevealInfo();
            revealInfo.f5396c = Float.MAX_VALUE;
            this.f10695a.setRevealInfo(revealInfo);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f10696a;

        /* renamed from: b, reason: collision with root package name */
        public j f10697b;
    }

    public FabTransformationBehavior() {
        this.f10683c = new Rect();
        this.f10684d = new RectF();
        this.f10685e = new RectF();
        this.f10686f = new int[2];
    }

    public abstract e a(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        e a2 = a(view2.getContext(), z);
        if (z) {
            this.f10687g = view.getTranslationX();
            this.f10688h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f10684d;
        a(view, view2, z, z2, a2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        a(view, view2, z, a2, arrayList);
        d(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, width, height, arrayList, arrayList2);
        b(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        c.c.a.c.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @TargetApi(21)
    public final void c(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float l = y.l(view2) - y.l(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-l);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -l);
        }
        eVar.f10696a.b("elevation").a((Animator) ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof c.c.a.c.j.c) && (view instanceof ImageView)) {
            c.c.a.c.j.c cVar = (c.c.a.c.j.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(ViewfinderView.OPAQUE);
                }
                ofInt = ObjectAnimator.ofInt(drawable, c.c.a.c.a.e.f5313b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, c.c.a.c.a.e.f5313b, ViewfinderView.OPAQUE);
            }
            ofInt.addUpdateListener(new b(this, view2));
            eVar.f10696a.b("iconFade").a((Animator) ofInt);
            list.add(ofInt);
            list2.add(new c(this, cVar, drawable));
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10683c = new Rect();
        this.f10684d = new RectF();
        this.f10685e = new RectF();
        this.f10686f = new int[2];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout.f fVar) {
        if (fVar.f2450h == 0) {
            fVar.f2450h = 80;
        }
    }

    public final float c(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f10684d;
        RectF rectF2 = this.f10685e;
        a(view, rectF);
        b(view2, rectF2);
        int i2 = jVar.f5326a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f5327b;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.f5327b;
    }

    public final void a(View view, View view2, boolean z, e eVar, List<Animator> list) {
        float c2 = c(view, view2, eVar.f10697b);
        float d2 = d(view, view2, eVar.f10697b);
        Pair<i, i> a2 = a(c2, d2, z, eVar);
        i iVar = (i) a2.first;
        i iVar2 = (i) a2.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            c2 = this.f10687g;
        }
        fArr[0] = c2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            d2 = this.f10688h;
        }
        fArr2[0] = d2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final float d(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f10684d;
        RectF rectF2 = this.f10685e;
        a(view, rectF);
        b(view2, rectF2);
        int i2 = jVar.f5326a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f5328c;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f5328c;
    }

    public final ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public final void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float c2 = c(view, view2, eVar.f10697b);
        float d2 = d(view, view2, eVar.f10697b);
        Pair<i, i> a2 = a(c2, d2, z, eVar);
        i iVar = (i) a2.first;
        i iVar2 = (i) a2.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-c2);
                view2.setTranslationY(-d2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            a(view2, eVar, iVar, iVar2, -c2, -d2, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -c2);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -d2);
        }
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof c.c.a.c.j.c) {
            c.c.a.c.j.c cVar = (c.c.a.c.j.c) view2;
            int b2 = b(view);
            int i2 = 16777215 & b2;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(b2);
                }
                ofInt = ObjectAnimator.ofInt(cVar, c.d.f5393a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(cVar, c.d.f5393a, b2);
            }
            ofInt.setEvaluator(c.c.a.c.a.c.a());
            eVar.f10696a.b("color").a((Animator) ofInt);
            list.add(ofInt);
        }
    }

    public final void b(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f10686f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(View view, View view2, boolean z, boolean z2, e eVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof c.c.a.c.j.c) {
            c.c.a.c.j.c cVar = (c.c.a.c.j.c) view2;
            float a2 = a(view, view2, eVar.f10697b);
            float b2 = b(view, view2, eVar.f10697b);
            ((FloatingActionButton) view).a(this.f10683c);
            float width = this.f10683c.width() / 2.0f;
            i b3 = eVar.f10696a.b("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new c.e(a2, b2, width));
                }
                if (z2) {
                    width = cVar.getRevealInfo().f5396c;
                }
                animator = c.c.a.c.j.a.a(cVar, a2, b2, c.c.a.c.s.a.a(a2, b2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(this, cVar));
                a(view2, b3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f4 = cVar.getRevealInfo().f5396c;
                Animator a3 = c.c.a.c.j.a.a(cVar, a2, b2, width);
                int i2 = (int) a2;
                int i3 = (int) b2;
                a(view2, b3.a(), i2, i3, f4, list);
                a(view2, b3.a(), b3.b(), eVar.f10696a.a(), i2, i3, width, list);
                animator = a3;
            }
            b3.a(animator);
            list.add(animator);
            list2.add(c.c.a.c.j.a.a(cVar));
        }
    }

    public final float b(View view, View view2, j jVar) {
        RectF rectF = this.f10684d;
        RectF rectF2 = this.f10685e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    public final int b(View view) {
        ColorStateList h2 = y.h(view);
        if (h2 != null) {
            return h2.getColorForState(view.getDrawableState(), h2.getDefaultColor());
        }
        return 0;
    }

    public final void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof c.c.a.c.j.c) && c.c.a.c.j.b.j == 0) || (a2 = a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    c.c.a.c.a.d.f5312a.set(a2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(a2, c.c.a.c.a.d.f5312a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(a2, c.c.a.c.a.d.f5312a, 0.0f);
            }
            eVar.f10696a.b("contentFade").a((Animator) ofFloat);
            list.add(ofFloat);
        }
    }

    public final Pair<i, i> a(float f2, float f3, boolean z, e eVar) {
        i b2;
        i b3;
        if (f2 == 0.0f || f3 == 0.0f) {
            b2 = eVar.f10696a.b("translationXLinear");
            b3 = eVar.f10696a.b("translationYLinear");
        } else if ((z && f3 < 0.0f) || (!z && f3 > 0.0f)) {
            b2 = eVar.f10696a.b("translationXCurveUpwards");
            b3 = eVar.f10696a.b("translationYCurveUpwards");
        } else {
            b2 = eVar.f10696a.b("translationXCurveDownwards");
            b3 = eVar.f10696a.b("translationYCurveDownwards");
        }
        return new Pair<>(b2, b3);
    }

    public final void a(View view, RectF rectF) {
        b(view, rectF);
        rectF.offset(this.f10687g, this.f10688h);
    }

    public final float a(View view, View view2, j jVar) {
        RectF rectF = this.f10684d;
        RectF rectF2 = this.f10685e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final void a(View view, e eVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(eVar, iVar, f2, f4);
        float a3 = a(eVar, iVar2, f3, f5);
        Rect rect = this.f10683c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f10684d;
        rectF2.set(rect);
        RectF rectF3 = this.f10685e;
        b(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final float a(e eVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i b3 = eVar.f10696a.b("expansion");
        return c.c.a.c.a.a.a(f2, f3, iVar.c().getInterpolation((((b3.a() + b3.b()) + 17) - a2) / b2));
    }

    public final ViewGroup a(View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return c(view);
        }
        return c(((ViewGroup) view).getChildAt(0));
    }

    public final void a(View view, long j, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    public final void a(View view, long j, long j2, long j3, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
