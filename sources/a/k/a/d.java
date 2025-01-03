package a.k.a;

import a.h.f.b;
import a.k.a.s;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public class d {

    /* compiled from: FragmentAnim.java */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1347a;

        public a(Fragment fragment) {
            this.f1347a = fragment;
        }

        @Override // a.h.f.b.a
        public void a() {
            if (this.f1347a.getAnimatingAway() != null) {
                View animatingAway = this.f1347a.getAnimatingAway();
                this.f1347a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.f1347a.setAnimator(null);
        }
    }

    /* compiled from: FragmentAnim.java */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1348a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f1349b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s.g f1350c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a.h.f.b f1351d;

        /* compiled from: FragmentAnim.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f1349b.getAnimatingAway() != null) {
                    b.this.f1349b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f1350c.a(bVar.f1349b, bVar.f1351d);
                }
            }
        }

        public b(ViewGroup viewGroup, Fragment fragment, s.g gVar, a.h.f.b bVar) {
            this.f1348a = viewGroup;
            this.f1349b = fragment;
            this.f1350c = gVar;
            this.f1351d = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1348a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: FragmentAnim.java */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1353a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1354b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f1355c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s.g f1356d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a.h.f.b f1357e;

        public c(ViewGroup viewGroup, View view, Fragment fragment, s.g gVar, a.h.f.b bVar) {
            this.f1353a = viewGroup;
            this.f1354b = view;
            this.f1355c = fragment;
            this.f1356d = gVar;
            this.f1357e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1353a.endViewTransition(this.f1354b);
            Animator animator2 = this.f1355c.getAnimator();
            this.f1355c.setAnimator(null);
            if (animator2 == null || this.f1353a.indexOfChild(this.f1354b) >= 0) {
                return;
            }
            this.f1356d.a(this.f1355c, this.f1357e);
        }
    }

    public static C0040d a(Context context, Fragment fragment, boolean z, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int a2 = a(fragment, z, z2);
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(R$id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R$id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, a2);
        if (onCreateAnimation != null) {
            return new C0040d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, a2);
        if (onCreateAnimator != null) {
            return new C0040d(onCreateAnimator);
        }
        if (a2 == 0 && nextTransition != 0) {
            a2 = a(nextTransition, z);
        }
        if (a2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a2);
                    if (loadAnimation != null) {
                        return new C0040d(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a2);
                    if (loadAnimator != null) {
                        return new C0040d(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a2);
                    if (loadAnimation2 != null) {
                        return new C0040d(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: a.k.a.d$d, reason: collision with other inner class name */
    public static class C0040d {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f1358a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f1359b;

        public C0040d(Animation animation) {
            this.f1358a = animation;
            this.f1359b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public C0040d(Animator animator) {
            this.f1358a = null;
            this.f1359b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    public static class e extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f1360a;

        /* renamed from: b, reason: collision with root package name */
        public final View f1361b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1362c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1363d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1364e;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1364e = true;
            this.f1360a = viewGroup;
            this.f1361b = view;
            addAnimation(animation);
            this.f1360a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1364e = true;
            if (this.f1362c) {
                return !this.f1363d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1362c = true;
                a.h.j.v.a(this.f1360a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1362c || !this.f1364e) {
                this.f1360a.endViewTransition(this.f1361b);
                this.f1363d = true;
            } else {
                this.f1364e = false;
                this.f1360a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f1364e = true;
            if (this.f1362c) {
                return !this.f1363d;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f1362c = true;
                a.h.j.v.a(this.f1360a, this);
            }
            return true;
        }
    }

    public static int a(Fragment fragment, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (z) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    public static void a(Fragment fragment, C0040d c0040d, s.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        a.h.f.b bVar = new a.h.f.b();
        bVar.setOnCancelListener(new a(fragment));
        gVar.b(fragment, bVar);
        if (c0040d.f1358a != null) {
            e eVar = new e(c0040d.f1358a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = c0040d.f1359b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static int a(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i2 == 4099) {
            return z ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
    }
}
