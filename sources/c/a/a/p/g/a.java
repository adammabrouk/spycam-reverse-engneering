package c.a.a.p.g;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import c.a.a.p.g.f;
import com.google.zxing.decoding.InactivityTimer;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final g<T> f3415a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3416b;

    /* renamed from: c, reason: collision with root package name */
    public b<T> f3417c;

    /* renamed from: d, reason: collision with root package name */
    public b<T> f3418d;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: c.a.a.p.g.a$a, reason: collision with other inner class name */
    public static class C0075a implements f.a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3419a;

        public C0075a(int i2) {
            this.f3419a = i2;
        }

        @Override // c.a.a.p.g.f.a
        public Animation a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.f3419a);
            return alphaAnimation;
        }
    }

    public a() {
        this(InactivityTimer.INACTIVITY_DELAY_SECONDS);
    }

    @Override // c.a.a.p.g.d
    public c<T> a(boolean z, boolean z2) {
        return z ? e.b() : z2 ? a() : b();
    }

    public final c<T> b() {
        if (this.f3418d == null) {
            this.f3418d = new b<>(this.f3415a.a(false, false), this.f3416b);
        }
        return this.f3418d;
    }

    public a(int i2) {
        this(new g(new C0075a(i2)), i2);
    }

    public a(g<T> gVar, int i2) {
        this.f3415a = gVar;
        this.f3416b = i2;
    }

    public final c<T> a() {
        if (this.f3417c == null) {
            this.f3417c = new b<>(this.f3415a.a(false, true), this.f3416b);
        }
        return this.f3417c;
    }
}
