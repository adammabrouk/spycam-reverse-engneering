package c.c.a.c.q;

import android.animation.Animator;

/* compiled from: AnimatorTracker.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Animator f5486a;

    public void a(Animator animator) {
        a();
        this.f5486a = animator;
    }

    public void b() {
        this.f5486a = null;
    }

    public void a() {
        Animator animator = this.f5486a;
        if (animator != null) {
            animator.cancel();
        }
    }
}
