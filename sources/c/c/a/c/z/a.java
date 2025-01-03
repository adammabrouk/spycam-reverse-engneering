package c.c.a.c.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes.dex */
public class a extends c.c.a.c.z.e {

    /* renamed from: d, reason: collision with root package name */
    public final TextWatcher f5741d;

    /* renamed from: e, reason: collision with root package name */
    public final View.OnFocusChangeListener f5742e;

    /* renamed from: f, reason: collision with root package name */
    public final TextInputLayout.f f5743f;

    /* renamed from: g, reason: collision with root package name */
    public final TextInputLayout.g f5744g;

    /* renamed from: h, reason: collision with root package name */
    public AnimatorSet f5745h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f5746i;

    /* compiled from: ClearTextEndIconDelegate.java */
    /* renamed from: c.c.a.c.z.a$a, reason: collision with other inner class name */
    public class C0109a implements TextWatcher {
        public C0109a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f5775a.getSuffixText() != null) {
                return;
            }
            a.this.b(a.b(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a.this.b((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class c implements TextInputLayout.f {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.b(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f5742e);
            editText.removeTextChangedListener(a.this.f5741d);
            editText.addTextChangedListener(a.this.f5741d);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class d implements TextInputLayout.g {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.removeTextChangedListener(a.this.f5741d);
            if (editText.getOnFocusChangeListener() == a.this.f5742e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f5775a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f5775a.setEndIconVisible(true);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f5775a.setEndIconVisible(false);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f5777c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f5777c.setScaleX(floatValue);
            a.this.f5777c.setScaleY(floatValue);
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5741d = new C0109a();
        this.f5742e = new b();
        this.f5743f = new c();
        this.f5744g = new d();
    }

    public final ValueAnimator c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(c.c.a.c.a.a.f5309d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    public final void d() {
        ValueAnimator c2 = c();
        ValueAnimator a2 = a(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5745h = animatorSet;
        animatorSet.playTogether(c2, a2);
        this.f5745h.addListener(new f());
        ValueAnimator a3 = a(1.0f, 0.0f);
        this.f5746i = a3;
        a3.addListener(new g());
    }

    public final void b(boolean z) {
        boolean z2 = this.f5775a.p() == z;
        if (z) {
            this.f5746i.cancel();
            this.f5745h.start();
            if (z2) {
                this.f5745h.end();
                return;
            }
            return;
        }
        this.f5745h.cancel();
        this.f5746i.start();
        if (z2) {
            this.f5746i.end();
        }
    }

    @Override // c.c.a.c.z.e
    public void a() {
        this.f5775a.setEndIconDrawable(a.b.b.a.a.c(this.f5776b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f5775a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.f5775a.setEndIconOnClickListener(new e());
        this.f5775a.addOnEditTextAttachedListener(this.f5743f);
        this.f5775a.addOnEndIconChangedListener(this.f5744g);
        d();
    }

    public static boolean b(Editable editable) {
        return editable.length() > 0;
    }

    @Override // c.c.a.c.z.e
    public void a(boolean z) {
        if (this.f5775a.getSuffixText() == null) {
            return;
        }
        b(z);
    }

    public final ValueAnimator a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.c.a.c.a.a.f5306a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }
}
