package c.c.a.c.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MotionTiming.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public long f5321a;

    /* renamed from: b, reason: collision with root package name */
    public long f5322b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f5323c;

    /* renamed from: d, reason: collision with root package name */
    public int f5324d;

    /* renamed from: e, reason: collision with root package name */
    public int f5325e;

    public i(long j, long j2) {
        this.f5321a = 0L;
        this.f5322b = 300L;
        this.f5323c = null;
        this.f5324d = 0;
        this.f5325e = 1;
        this.f5321a = j;
        this.f5322b = j2;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f5322b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f5323c;
        return timeInterpolator != null ? timeInterpolator : a.f5307b;
    }

    public int d() {
        return this.f5324d;
    }

    public int e() {
        return this.f5325e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }

    public static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f5307b : interpolator instanceof AccelerateInterpolator ? a.f5308c : interpolator instanceof DecelerateInterpolator ? a.f5309d : interpolator;
    }

    public long a() {
        return this.f5321a;
    }

    public static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f5324d = valueAnimator.getRepeatCount();
        iVar.f5325e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f5321a = 0L;
        this.f5322b = 300L;
        this.f5323c = null;
        this.f5324d = 0;
        this.f5325e = 1;
        this.f5321a = j;
        this.f5322b = j2;
        this.f5323c = timeInterpolator;
    }
}
