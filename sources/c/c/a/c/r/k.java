package c.c.a.c.r;

import a.t.c0;
import a.t.w;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: TextScale.java */
/* loaded from: classes.dex */
public class k extends w {

    /* compiled from: TextScale.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f5584a;

        public a(k kVar, TextView textView) {
            this.f5584a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f5584a.setScaleX(floatValue);
            this.f5584a.setScaleY(floatValue);
        }
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        d(c0Var);
    }

    @Override // a.t.w
    public void c(c0 c0Var) {
        d(c0Var);
    }

    public final void d(c0 c0Var) {
        View view = c0Var.f1753b;
        if (view instanceof TextView) {
            c0Var.f1752a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // a.t.w
    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null || !(c0Var.f1753b instanceof TextView)) {
            return null;
        }
        View view = c0Var2.f1753b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = c0Var.f1752a;
        Map<String, Object> map2 = c0Var2.f1752a;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new a(this, textView));
        return ofFloat;
    }
}
