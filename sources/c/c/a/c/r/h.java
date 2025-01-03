package c.c.a.c.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f5561a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public b f5562b = null;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f5563c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f5564d = new a();

    /* compiled from: StateListAnimator.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h hVar = h.this;
            if (hVar.f5563c == animator) {
                hVar.f5563c = null;
            }
        }
    }

    /* compiled from: StateListAnimator.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f5566a;

        /* renamed from: b, reason: collision with root package name */
        public final ValueAnimator f5567b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f5566a = iArr;
            this.f5567b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f5564d);
        this.f5561a.add(bVar);
    }

    public void b() {
        ValueAnimator valueAnimator = this.f5563c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f5563c = null;
        }
    }

    public void a(int[] iArr) {
        b bVar;
        int size = this.f5561a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f5561a.get(i2);
            if (StateSet.stateSetMatches(bVar.f5566a, iArr)) {
                break;
            } else {
                i2++;
            }
        }
        b bVar2 = this.f5562b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            a();
        }
        this.f5562b = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(b bVar) {
        ValueAnimator valueAnimator = bVar.f5567b;
        this.f5563c = valueAnimator;
        valueAnimator.start();
    }

    public final void a() {
        ValueAnimator valueAnimator = this.f5563c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f5563c = null;
        }
    }
}
