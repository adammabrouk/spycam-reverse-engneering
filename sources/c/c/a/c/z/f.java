package c.c.a.c.z;

import a.h.j.y;
import a.h.k.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5778a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f5779b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f5780c;

    /* renamed from: d, reason: collision with root package name */
    public int f5781d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f5782e;

    /* renamed from: f, reason: collision with root package name */
    public int f5783f;

    /* renamed from: g, reason: collision with root package name */
    public Animator f5784g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5785h;

    /* renamed from: i, reason: collision with root package name */
    public int f5786i;
    public int j;
    public CharSequence k;
    public boolean l;
    public TextView m;
    public CharSequence n;
    public int o;
    public ColorStateList p;
    public CharSequence q;
    public boolean r;
    public TextView s;
    public int t;
    public ColorStateList u;
    public Typeface v;

    /* compiled from: IndicatorViewController.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5787a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f5788b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f5789c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f5790d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.f5787a = i2;
            this.f5788b = textView;
            this.f5789c = i3;
            this.f5790d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f5786i = this.f5787a;
            f.this.f5784g = null;
            TextView textView = this.f5788b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f5789c == 1 && f.this.m != null) {
                    f.this.m.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f5790d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f5790d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f5790d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        this.f5778a = textInputLayout.getContext();
        this.f5779b = textInputLayout;
        this.f5785h = r0.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void b(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.f5786i != 1) {
            this.j = 1;
        }
        a(this.f5786i, this.j, a(this.m, charSequence));
    }

    public void c(CharSequence charSequence) {
        c();
        this.q = charSequence;
        this.s.setText(charSequence);
        if (this.f5786i != 2) {
            this.j = 2;
        }
        a(this.f5786i, this.j, a(this.s, charSequence));
    }

    public boolean c(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public boolean d() {
        return b(this.j);
    }

    public CharSequence e() {
        return this.n;
    }

    public CharSequence f() {
        return this.k;
    }

    public int g() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList h() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence i() {
        return this.q;
    }

    public int j() {
        TextView textView = this.s;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void k() {
        this.k = null;
        c();
        if (this.f5786i == 1) {
            if (!this.r || TextUtils.isEmpty(this.q)) {
                this.j = 0;
            } else {
                this.j = 2;
            }
        }
        a(this.f5786i, this.j, a(this.m, (CharSequence) null));
    }

    public void l() {
        c();
        if (this.f5786i == 2) {
            this.j = 0;
        }
        a(this.f5786i, this.j, a(this.s, (CharSequence) null));
    }

    public boolean m() {
        return this.l;
    }

    public boolean n() {
        return this.r;
    }

    public void d(int i2) {
        this.o = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f5779b.a(textView, i2);
        }
    }

    public void e(int i2) {
        this.t = i2;
        TextView textView = this.s;
        if (textView != null) {
            i.d(textView, i2);
        }
    }

    public final boolean a(TextView textView, CharSequence charSequence) {
        return y.J(this.f5779b) && this.f5779b.isEnabled() && !(this.j == this.f5786i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void a(int i2, int i3, boolean z) {
        if (i2 == i3) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f5784g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.r, this.s, 2, i2, i3);
            a(arrayList, this.l, this.m, 1, i2, i3);
            c.c.a.c.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, a(i2), i2, a(i3)));
            animatorSet.start();
        } else {
            a(i2, i3);
        }
        this.f5779b.H();
        this.f5779b.d(z);
        this.f5779b.Q();
    }

    public final boolean b() {
        return (this.f5780c == null || this.f5779b.getEditText() == null) ? false : true;
    }

    public void c() {
        Animator animator = this.f5784g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f5780c == null) {
            return;
        }
        if (c(i2) && (frameLayout = this.f5782e) != null) {
            int i3 = this.f5783f - 1;
            this.f5783f = i3;
            a(frameLayout, i3);
            this.f5782e.removeView(textView);
        } else {
            this.f5780c.removeView(textView);
        }
        int i4 = this.f5781d - 1;
        this.f5781d = i4;
        a(this.f5780c, i4);
    }

    public void b(boolean z) {
        if (this.r == z) {
            return;
        }
        c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f5778a);
            this.s = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.s.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.s.setTypeface(typeface);
            }
            this.s.setVisibility(4);
            y.g(this.s, 1);
            e(this.t);
            b(this.u);
            a(this.s, 1);
        } else {
            l();
            b(this.s, 1);
            this.s = null;
            this.f5779b.H();
            this.f5779b.Q();
        }
        this.r = z;
    }

    public final void a(int i2, int i3) {
        TextView a2;
        TextView a3;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (a3 = a(i3)) != null) {
            a3.setVisibility(0);
            a3.setAlpha(1.0f);
        }
        if (i2 != 0 && (a2 = a(i2)) != null) {
            a2.setVisibility(4);
            if (i2 == 1) {
                a2.setText((CharSequence) null);
            }
        }
        this.f5786i = i3;
    }

    public final void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(a(textView, i4 == i2));
            if (i4 == i2) {
                list.add(a(textView));
            }
        }
    }

    public final ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(c.c.a.c.a.a.f5306a);
        return ofFloat;
    }

    public final ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f5785h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(c.c.a.c.a.a.f5309d);
        return ofFloat;
    }

    public final boolean b(int i2) {
        return (i2 != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    public final TextView a(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.s;
    }

    public void b(ColorStateList colorStateList) {
        this.u = colorStateList;
        TextView textView = this.s;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void a() {
        if (b()) {
            y.a(this.f5780c, y.w(this.f5779b.getEditText()), 0, y.v(this.f5779b.getEditText()), 0);
        }
    }

    public void a(TextView textView, int i2) {
        if (this.f5780c == null && this.f5782e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f5778a);
            this.f5780c = linearLayout;
            linearLayout.setOrientation(0);
            this.f5779b.addView(this.f5780c, -1, -2);
            this.f5782e = new FrameLayout(this.f5778a);
            this.f5780c.addView(this.f5782e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f5779b.getEditText() != null) {
                a();
            }
        }
        if (c(i2)) {
            this.f5782e.setVisibility(0);
            this.f5782e.addView(textView);
            this.f5783f++;
        } else {
            this.f5780c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f5780c.setVisibility(0);
        this.f5781d++;
    }

    public final void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (this.l == z) {
            return;
        }
        c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f5778a);
            this.m = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.m.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            d(this.o);
            a(this.p);
            a(this.n);
            this.m.setVisibility(4);
            y.g(this.m, 1);
            a(this.m, 0);
        } else {
            k();
            b(this.m, 0);
            this.m = null;
            this.f5779b.H();
            this.f5779b.Q();
        }
        this.l = z;
    }

    public void a(Typeface typeface) {
        if (typeface != this.v) {
            this.v = typeface;
            a(this.m, typeface);
            a(this.s, typeface);
        }
    }

    public final void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void a(ColorStateList colorStateList) {
        this.p = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void a(CharSequence charSequence) {
        this.n = charSequence;
        TextView textView = this.m;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }
}
