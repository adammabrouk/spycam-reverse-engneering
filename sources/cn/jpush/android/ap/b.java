package cn.jpush.android.ap;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import cn.jpush.android.aq.c;

/* loaded from: classes.dex */
public class b implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public int f9151a;

    /* renamed from: b, reason: collision with root package name */
    public int f9152b;

    /* renamed from: c, reason: collision with root package name */
    public int f9153c;

    /* renamed from: d, reason: collision with root package name */
    public long f9154d;

    /* renamed from: e, reason: collision with root package name */
    public View f9155e;

    /* renamed from: f, reason: collision with root package name */
    public a f9156f;

    /* renamed from: g, reason: collision with root package name */
    public int f9157g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f9158h = 1;

    /* renamed from: i, reason: collision with root package name */
    public float f9159i;
    public float j;
    public boolean k;
    public int l;
    public Object m;
    public VelocityTracker n;
    public float o;
    public float p;
    public boolean q;
    public boolean r;
    public c s;

    public interface a {
        void a(View view, Object obj);

        boolean a(Object obj);
    }

    public b(c cVar, Object obj, a aVar) {
        this.q = false;
        this.r = true;
        View d2 = cVar.d();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(d2.getContext());
        this.f9151a = viewConfiguration.getScaledTouchSlop();
        this.f9152b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f9153c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f9154d = 1000L;
        this.f9155e = d2;
        this.m = obj;
        this.f9156f = aVar;
        this.q = false;
        this.r = cVar.f().e() >= 80;
        this.s = cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("[InAppSwipeDismissTouchListener] in-app show at top: ");
        sb.append(!this.r);
        sb.append(", dismiss top_bottom: ");
        sb.append(!this.q);
        cn.jpush.android.r.b.b("InAppSwipeDismissTouchListener", sb.toString());
    }

    private void a(float f2, float f3, AnimatorListenerAdapter animatorListenerAdapter) {
        try {
            final float a2 = this.q ? a() : b();
            final float f4 = f2 - a2;
            final float alpha = this.f9155e.getAlpha();
            final float f5 = f3 - alpha;
            cn.jpush.android.r.b.d("InAppSwipeDismissTouchListener", "animateTo, beginTranslation: " + a2 + ", translationDiff: " + f4 + ", beginAlpha: , alphaDiff: " + f5);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            if (ofFloat != null) {
                ofFloat.setDuration(this.f9154d);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.ap.b.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        float f6 = a2 + (f4 * animatedFraction);
                        float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f5);
                        if (b.this.q) {
                            b.this.a(f6);
                        } else {
                            b.this.b(f6);
                            if (b.this.s != null && animatedFraction > 0.4d) {
                                b.this.s.f9231d = true;
                            }
                        }
                        b.this.c(animatedFraction2);
                    }
                });
                if (animatorListenerAdapter != null) {
                    ofFloat.addListener(animatorListenerAdapter);
                }
                ofFloat.start();
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppSwipeDismissTouchListener", "[animateTo] failed" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (this.f9155e != null) {
                final ViewGroup.LayoutParams layoutParams = this.f9155e.getLayoutParams();
                final int height = this.f9155e.getHeight();
                final int width = this.f9155e.getWidth();
                int[] iArr = new int[2];
                iArr[0] = this.q ? height : width;
                iArr[1] = 1;
                ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(this.f9154d);
                duration.addListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.ap.b.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        cn.jpush.android.r.b.b("InAppSwipeDismissTouchListener", "[onAnimationEnd] ...");
                        if (b.this.f9156f != null) {
                            b.this.f9156f.a(b.this.f9155e, b.this.m);
                        }
                        b.this.f9155e.setAlpha(1.0f);
                        if (b.this.q) {
                            b.this.f9155e.setTranslationX(0.0f);
                            layoutParams.height = height;
                        } else {
                            b.this.f9155e.setTranslationY(0.0f);
                            layoutParams.width = width;
                        }
                        b.this.f9155e.setLayoutParams(layoutParams);
                    }
                });
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.ap.b.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (b.this.q) {
                            layoutParams.height = intValue;
                        } else {
                            layoutParams.width = intValue;
                        }
                        b.this.f9155e.setLayoutParams(layoutParams);
                    }
                });
                duration.start();
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppSwipeDismissTouchListener", "[performDismiss] failed." + th.getMessage());
        }
    }

    public float a() {
        return this.f9155e.getTranslationX();
    }

    public void a(float f2) {
        this.f9155e.setTranslationX(f2);
    }

    public void a(boolean z) {
        int i2 = this.f9158h;
        if (z) {
            i2 = -i2;
        }
        cn.jpush.android.r.b.b("InAppSwipeDismissTouchListener", "[startDismissAnimationY] dismissTop: " + z + ", viewHeight: " + this.f9158h);
        a((float) i2, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.ap.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.d();
            }
        });
    }

    public float b() {
        return this.f9155e.getTranslationY();
    }

    public void b(float f2) {
        this.f9155e.setTranslationY(f2);
    }

    public void b(boolean z) {
        a(z ? this.f9157g : -this.f9157g, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.ap.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.d();
            }
        });
    }

    public void c() {
        a(0.0f, 1.0f, null);
    }

    public void c(float f2) {
        this.f9155e.setAlpha(f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[Catch: all -> 0x0379, TryCatch #0 {all -> 0x0379, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0016, B:8:0x0030, B:16:0x0043, B:21:0x0049, B:22:0x0058, B:25:0x005c, B:29:0x0062, B:31:0x007b, B:33:0x0086, B:35:0x0093, B:37:0x0099, B:38:0x009f, B:39:0x00bd, B:40:0x009c, B:41:0x011e, B:43:0x0122, B:45:0x0128, B:46:0x0146, B:48:0x014a, B:50:0x00c1, B:52:0x00cc, B:56:0x00dd, B:60:0x00e3, B:62:0x00e7, B:66:0x00f3, B:68:0x00f9, B:69:0x00ff, B:70:0x00fc, B:71:0x016a, B:75:0x0170, B:78:0x01fe, B:80:0x0209, B:86:0x0250, B:88:0x0302, B:90:0x0306, B:91:0x0315, B:93:0x0319, B:94:0x031e, B:95:0x030a, B:96:0x030e, B:98:0x0312, B:100:0x0217, B:102:0x021e, B:106:0x0229, B:116:0x0240, B:124:0x029b, B:126:0x02a7, B:132:0x02b7, B:135:0x032c, B:137:0x0364, B:139:0x036e, B:143:0x001f, B:145:0x0028), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r17, android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ap.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
