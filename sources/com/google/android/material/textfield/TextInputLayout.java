package com.google.android.material.textfield;

import a.b.f.g0;
import a.b.f.r;
import a.h.j.y;
import a.h.k.i;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.r.l;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int J0 = R$style.Widget_Design_TextInputLayout;
    public CharSequence A;
    public int A0;
    public boolean B;
    public int B0;
    public h C;
    public int C0;
    public h D;
    public boolean D0;
    public m E;
    public final c.c.a.c.r.a E0;
    public final int F;
    public boolean F0;
    public int G;
    public ValueAnimator G0;
    public final int H;
    public boolean H0;
    public int I;
    public boolean I0;
    public int J;
    public int K;
    public int L;
    public int M;
    public final Rect N;
    public final Rect O;
    public final RectF P;
    public Typeface Q;
    public final CheckableImageButton R;
    public ColorStateList S;
    public boolean T;
    public PorterDuff.Mode U;
    public boolean V;
    public Drawable W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f10660a;
    public int a0;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f10661b;
    public View.OnLongClickListener b0;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f10662c;
    public final LinkedHashSet<f> c0;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f10663d;
    public int d0;

    /* renamed from: e, reason: collision with root package name */
    public EditText f10664e;
    public final SparseArray<c.c.a.c.z.e> e0;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f10665f;
    public final CheckableImageButton f0;

    /* renamed from: g, reason: collision with root package name */
    public final c.c.a.c.z.f f10666g;
    public final LinkedHashSet<g> g0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10667h;
    public ColorStateList h0;

    /* renamed from: i, reason: collision with root package name */
    public int f10668i;
    public boolean i0;
    public boolean j;
    public PorterDuff.Mode j0;
    public TextView k;
    public boolean k0;
    public int l;
    public Drawable l0;
    public int m;
    public int m0;
    public CharSequence n;
    public Drawable n0;
    public boolean o;
    public View.OnLongClickListener o0;
    public TextView p;
    public View.OnLongClickListener p0;
    public ColorStateList q;
    public final CheckableImageButton q0;
    public int r;
    public ColorStateList r0;
    public ColorStateList s0;
    public ColorStateList t;
    public ColorStateList t0;
    public ColorStateList u;
    public int u0;
    public CharSequence v;
    public int v0;
    public final TextView w;
    public int w0;
    public CharSequence x;
    public ColorStateList x0;
    public final TextView y;
    public int y0;
    public boolean z;
    public int z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10669c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10670d;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f10669c) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f10669c, parcel, i2);
            parcel.writeInt(this.f10670d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10669c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f10670d = parcel.readInt() == 1;
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.d(!r0.I0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f10667h) {
                textInputLayout.b(editable.length());
            }
            if (TextInputLayout.this.o) {
                TextInputLayout.this.c(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f0.performClick();
            TextInputLayout.this.f0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f10664e.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.g(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends a.h.j.a {

        /* renamed from: d, reason: collision with root package name */
        public final TextInputLayout f10675d;

        public e(TextInputLayout textInputLayout) {
            this.f10675d = textInputLayout;
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            EditText editText = this.f10675d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f10675d.getHint();
            CharSequence helperText = this.f10675d.getHelperText();
            CharSequence error = this.f10675d.getError();
            int counterMaxLength = this.f10675d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f10675d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? ", " : "");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb3.append((Object) helperText);
            String sb4 = sb3.toString();
            if (z) {
                cVar.i(text);
            } else if (!TextUtils.isEmpty(sb4)) {
                cVar.i(sb4);
            }
            if (!TextUtils.isEmpty(sb4)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.d(sb4);
                } else {
                    if (z) {
                        sb4 = ((Object) text) + ", " + sb4;
                    }
                    cVar.i(sb4);
                }
                cVar.n(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.c(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                cVar.c(error);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private c.c.a.c.z.e getEndIconDelegate() {
        c.c.a.c.z.e eVar = this.e0.get(this.d0);
        return eVar != null ? eVar : this.e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.q0.getVisibility() == 0) {
            return this.q0;
        }
        if (n() && p()) {
            return this.f0;
        }
        return null;
    }

    private void setEditText(EditText editText) {
        if (this.f10664e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.d0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f10664e = editText;
        w();
        setTextInputAccessibilityDelegate(new e(this));
        this.E0.e(this.f10664e.getTypeface());
        this.E0.f(this.f10664e.getTextSize());
        int gravity = this.f10664e.getGravity();
        this.E0.b((gravity & (-113)) | 48);
        this.E0.d(gravity);
        this.f10664e.addTextChangedListener(new a());
        if (this.s0 == null) {
            this.s0 = this.f10664e.getHintTextColors();
        }
        if (this.z) {
            if (TextUtils.isEmpty(this.A)) {
                CharSequence hint = this.f10664e.getHint();
                this.f10665f = hint;
                setHint(hint);
                this.f10664e.setHint((CharSequence) null);
            }
            this.B = true;
        }
        if (this.k != null) {
            b(this.f10664e.getText().length());
        }
        H();
        this.f10666g.a();
        this.f10661b.bringToFront();
        this.f10662c.bringToFront();
        this.f10663d.bringToFront();
        this.q0.bringToFront();
        m();
        M();
        O();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        a(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.q0.setVisibility(z ? 0 : 8);
        this.f10663d.setVisibility(z ? 8 : 0);
        O();
        if (n()) {
            return;
        }
        G();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.A)) {
            return;
        }
        this.A = charSequence;
        this.E0.b(charSequence);
        if (this.D0) {
            return;
        }
        x();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.o == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.p = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            y.g(this.p, 1);
            setPlaceholderTextAppearance(this.r);
            setPlaceholderTextColor(this.q);
            a();
        } else {
            y();
            this.p = null;
        }
        this.o = z;
    }

    public final boolean A() {
        return (this.q0.getVisibility() == 0 || ((n() && p()) || this.x != null)) && this.f10662c.getMeasuredWidth() > 0;
    }

    public final boolean B() {
        return !(getStartIconDrawable() == null && this.v == null) && this.f10661b.getMeasuredWidth() > 0;
    }

    public final boolean C() {
        EditText editText = this.f10664e;
        return (editText == null || this.C == null || editText.getBackground() != null || this.G == 0) ? false : true;
    }

    public final void D() {
        TextView textView = this.p;
        if (textView == null || !this.o) {
            return;
        }
        textView.setText(this.n);
        this.p.setVisibility(0);
        this.p.bringToFront();
    }

    public final void E() {
        if (this.k != null) {
            EditText editText = this.f10664e;
            b(editText == null ? 0 : editText.getText().length());
        }
    }

    public final void F() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.k;
        if (textView != null) {
            a(textView, this.j ? this.l : this.m);
            if (!this.j && (colorStateList2 = this.t) != null) {
                this.k.setTextColor(colorStateList2);
            }
            if (!this.j || (colorStateList = this.u) == null) {
                return;
            }
            this.k.setTextColor(colorStateList);
        }
    }

    public final boolean G() {
        boolean z;
        if (this.f10664e == null) {
            return false;
        }
        boolean z2 = true;
        if (B()) {
            int measuredWidth = this.f10661b.getMeasuredWidth() - this.f10664e.getPaddingLeft();
            if (this.W == null || this.a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a2 = i.a(this.f10664e);
            Drawable drawable = a2[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                i.a(this.f10664e, drawable2, a2[1], a2[2], a2[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.W != null) {
                Drawable[] a3 = i.a(this.f10664e);
                i.a(this.f10664e, null, a3[1], a3[2], a3[3]);
                this.W = null;
                z = true;
            }
            z = false;
        }
        if (A()) {
            int measuredWidth2 = this.y.getMeasuredWidth() - this.f10664e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + a.h.j.h.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a4 = i.a(this.f10664e);
            Drawable drawable3 = this.l0;
            if (drawable3 == null || this.m0 == measuredWidth2) {
                if (this.l0 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.l0 = colorDrawable2;
                    this.m0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a4[2];
                Drawable drawable5 = this.l0;
                if (drawable4 != drawable5) {
                    this.n0 = a4[2];
                    i.a(this.f10664e, a4[0], a4[1], drawable5, a4[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.m0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                i.a(this.f10664e, a4[0], a4[1], this.l0, a4[3]);
            }
        } else {
            if (this.l0 == null) {
                return z;
            }
            Drawable[] a5 = i.a(this.f10664e);
            if (a5[2] == this.l0) {
                i.a(this.f10664e, a5[0], a5[1], this.n0, a5[3]);
            } else {
                z2 = z;
            }
            this.l0 = null;
        }
        return z2;
    }

    public void H() {
        Drawable background;
        TextView textView;
        EditText editText = this.f10664e;
        if (editText == null || this.G != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (r.a(background)) {
            background = background.mutate();
        }
        if (this.f10666g.d()) {
            background.setColorFilter(a.b.f.f.a(this.f10666g.g(), PorterDuff.Mode.SRC_IN));
        } else if (this.j && (textView = this.k) != null) {
            background.setColorFilter(a.b.f.f.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            a.h.c.l.a.b(background);
            this.f10664e.refreshDrawableState();
        }
    }

    public final boolean I() {
        int max;
        if (this.f10664e == null || this.f10664e.getMeasuredHeight() >= (max = Math.max(this.f10662c.getMeasuredHeight(), this.f10661b.getMeasuredHeight()))) {
            return false;
        }
        this.f10664e.setMinimumHeight(max);
        return true;
    }

    public final void J() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10660a.getLayoutParams();
            int h2 = h();
            if (h2 != layoutParams.topMargin) {
                layoutParams.topMargin = h2;
                this.f10660a.requestLayout();
            }
        }
    }

    public final void K() {
        EditText editText;
        if (this.p == null || (editText = this.f10664e) == null) {
            return;
        }
        this.p.setGravity(editText.getGravity());
        this.p.setPadding(this.f10664e.getCompoundPaddingLeft(), this.f10664e.getCompoundPaddingTop(), this.f10664e.getCompoundPaddingRight(), this.f10664e.getCompoundPaddingBottom());
    }

    public final void L() {
        EditText editText = this.f10664e;
        c(editText == null ? 0 : editText.getText().length());
    }

    public final void M() {
        if (this.f10664e == null) {
            return;
        }
        y.a(this.w, v() ? 0 : y.w(this.f10664e), this.f10664e.getCompoundPaddingTop(), 0, this.f10664e.getCompoundPaddingBottom());
    }

    public final void N() {
        this.w.setVisibility((this.v == null || s()) ? 8 : 0);
        G();
    }

    public final void O() {
        if (this.f10664e == null) {
            return;
        }
        y.a(this.y, 0, this.f10664e.getPaddingTop(), (p() || q()) ? 0 : y.v(this.f10664e), this.f10664e.getPaddingBottom());
    }

    public final void P() {
        int visibility = this.y.getVisibility();
        boolean z = (this.x == null || s()) ? false : true;
        this.y.setVisibility(z ? 0 : 8);
        if (visibility != this.y.getVisibility()) {
            getEndIconDelegate().a(z);
        }
        G();
    }

    public void Q() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C == null || this.G == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f10664e) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.f10664e) != null && editText.isHovered());
        if (!isEnabled()) {
            this.L = this.C0;
        } else if (this.f10666g.d()) {
            if (this.x0 != null) {
                b(z2, z3);
            } else {
                this.L = this.f10666g.g();
            }
        } else if (!this.j || (textView = this.k) == null) {
            if (z2) {
                this.L = this.w0;
            } else if (z3) {
                this.L = this.v0;
            } else {
                this.L = this.u0;
            }
        } else if (this.x0 != null) {
            b(z2, z3);
        } else {
            this.L = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.f10666g.m() && this.f10666g.d()) {
            z = true;
        }
        setErrorIconVisible(z);
        a(this.q0, this.r0);
        a(this.R, this.S);
        a(this.f0, this.h0);
        if (getEndIconDelegate().b()) {
            c(this.f10666g.d());
        }
        if (z2 && isEnabled()) {
            this.I = this.K;
        } else {
            this.I = this.J;
        }
        if (this.G == 1) {
            if (!isEnabled()) {
                this.M = this.z0;
            } else if (z3 && !z2) {
                this.M = this.B0;
            } else if (z2) {
                this.M = this.A0;
            } else {
                this.M = this.y0;
            }
        }
        b();
    }

    public void addOnEditTextAttachedListener(f fVar) {
        this.c0.add(fVar);
        if (this.f10664e != null) {
            fVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(g gVar) {
        this.g0.add(gVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f10660a.addView(view, layoutParams2);
        this.f10660a.setLayoutParams(layoutParams);
        J();
        setEditText((EditText) view);
    }

    public void d(boolean z) {
        a(z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.f10665f == null || (editText = this.f10664e) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z = this.B;
        this.B = false;
        CharSequence hint = editText.getHint();
        this.f10664e.setHint(this.f10665f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.f10664e.setHint(hint);
            this.B = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.I0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.I0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.H0) {
            return;
        }
        this.H0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        c.c.a.c.r.a aVar = this.E0;
        boolean a2 = aVar != null ? aVar.a(drawableState) | false : false;
        if (this.f10664e != null) {
            d(y.J(this) && isEnabled());
        }
        H();
        Q();
        if (a2) {
            invalidate();
        }
        this.H0 = false;
    }

    public final void e() {
        a(this.R, this.T, this.S, this.V, this.U);
    }

    public final void f() {
        int i2 = this.G;
        if (i2 == 0) {
            this.C = null;
            this.D = null;
            return;
        }
        if (i2 == 1) {
            this.C = new h(this.E);
            this.D = new h();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.z || (this.C instanceof c.c.a.c.z.c)) {
                this.C = new h(this.E);
            } else {
                this.C = new c.c.a.c.z.c(this.E);
            }
            this.D = null;
        }
    }

    public final int g() {
        return this.G == 1 ? c.c.a.c.k.a.a(c.c.a.c.k.a.a(this, R$attr.colorSurface, 0), this.M) : this.M;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f10664e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + h() : super.getBaseline();
    }

    public h getBoxBackground() {
        int i2 = this.G;
        if (i2 == 1 || i2 == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.M;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.C.c();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.C.d();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.C.r();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.q();
    }

    public int getBoxStrokeColor() {
        return this.w0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.x0;
    }

    public int getBoxStrokeWidth() {
        return this.J;
    }

    public int getBoxStrokeWidthFocused() {
        return this.K;
    }

    public int getCounterMaxLength() {
        return this.f10668i;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f10667h && this.j && (textView = this.k) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.t;
    }

    public ColorStateList getCounterTextColor() {
        return this.t;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.s0;
    }

    public EditText getEditText() {
        return this.f10664e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.d0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f0;
    }

    public CharSequence getError() {
        if (this.f10666g.m()) {
            return this.f10666g.f();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f10666g.e();
    }

    public int getErrorCurrentTextColors() {
        return this.f10666g.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.q0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f10666g.g();
    }

    public CharSequence getHelperText() {
        if (this.f10666g.n()) {
            return this.f10666g.i();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f10666g.j();
    }

    public CharSequence getHint() {
        if (this.z) {
            return this.A;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.E0.h();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.E0.j();
    }

    public ColorStateList getHintTextColor() {
        return this.t0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.o) {
            return this.n;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.r;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.q;
    }

    public CharSequence getPrefixText() {
        return this.v;
    }

    public ColorStateList getPrefixTextColor() {
        return this.w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.w;
    }

    public CharSequence getStartIconContentDescription() {
        return this.R.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.R.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.y;
    }

    public Typeface getTypeface() {
        return this.Q;
    }

    public final int h() {
        float h2;
        if (!this.z) {
            return 0;
        }
        int i2 = this.G;
        if (i2 == 0 || i2 == 1) {
            h2 = this.E0.h();
        } else {
            if (i2 != 2) {
                return 0;
            }
            h2 = this.E0.h() / 2.0f;
        }
        return (int) h2;
    }

    public final boolean i() {
        return this.G == 2 && j();
    }

    public final boolean j() {
        return this.I > -1 && this.L != 0;
    }

    public final void k() {
        if (l()) {
            ((c.c.a.c.z.c) this.C).E();
        }
    }

    public final boolean l() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof c.c.a.c.z.c);
    }

    public final void m() {
        Iterator<f> it = this.c0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final boolean n() {
        return this.d0 != 0;
    }

    public final void o() {
        TextView textView = this.p;
        if (textView == null || !this.o) {
            return;
        }
        textView.setText((CharSequence) null);
        this.p.setVisibility(4);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f10664e;
        if (editText != null) {
            Rect rect = this.N;
            c.c.a.c.r.c.a(this, editText, rect);
            c(rect);
            if (this.z) {
                this.E0.f(this.f10664e.getTextSize());
                int gravity = this.f10664e.getGravity();
                this.E0.b((gravity & (-113)) | 48);
                this.E0.d(gravity);
                this.E0.a(a(rect));
                this.E0.b(b(rect));
                this.E0.u();
                if (!l() || this.D0) {
                    return;
                }
                x();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean I = I();
        boolean G = G();
        if (I || G) {
            this.f10664e.post(new c());
        }
        K();
        M();
        O();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f10669c);
        if (savedState.f10670d) {
            this.f0.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f10666g.d()) {
            savedState.f10669c = getError();
        }
        savedState.f10670d = n() && this.f0.isChecked();
        return savedState;
    }

    public boolean p() {
        return this.f10663d.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    public final boolean q() {
        return this.q0.getVisibility() == 0;
    }

    public boolean r() {
        return this.f10666g.n();
    }

    public void removeOnEditTextAttachedListener(f fVar) {
        this.c0.remove(fVar);
    }

    public void removeOnEndIconChangedListener(g gVar) {
        this.g0.remove(gVar);
    }

    public final boolean s() {
        return this.D0;
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.M != i2) {
            this.M = i2;
            this.y0 = i2;
            this.A0 = i2;
            this.B0 = i2;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(a.h.b.a.a(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.y0 = defaultColor;
        this.M = defaultColor;
        this.z0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.B0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.G) {
            return;
        }
        this.G = i2;
        if (this.f10664e != null) {
            w();
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            Q();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.u0 = colorStateList.getDefaultColor();
            this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.v0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.w0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.w0 != colorStateList.getDefaultColor()) {
            this.w0 = colorStateList.getDefaultColor();
        }
        Q();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            Q();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.J = i2;
        Q();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.K = i2;
        Q();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f10667h != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.k = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.k.setTypeface(typeface);
                }
                this.k.setMaxLines(1);
                this.f10666g.a(this.k, 2);
                a.h.j.h.b((ViewGroup.MarginLayoutParams) this.k.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                F();
                E();
            } else {
                this.f10666g.b(this.k, 2);
                this.k = null;
            }
            this.f10667h = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f10668i != i2) {
            if (i2 > 0) {
                this.f10668i = i2;
            } else {
                this.f10668i = -1;
            }
            if (this.f10667h) {
                E();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.l != i2) {
            this.l = i2;
            F();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            F();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.m != i2) {
            this.m = i2;
            F();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            F();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.s0 = colorStateList;
        this.t0 = colorStateList;
        if (this.f10664e != null) {
            d(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.d0;
        this.d0 = i2;
        a(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().a(this.G)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.G + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.f0, onClickListener, this.o0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        b(this.f0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.h0 != colorStateList) {
            this.h0 = colorStateList;
            this.i0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.j0 != mode) {
            this.j0 = mode;
            this.k0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (p() != z) {
            this.f0.setVisibility(z ? 0 : 8);
            O();
            G();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f10666g.m()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f10666g.k();
        } else {
            this.f10666g.b(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f10666g.a(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f10666g.a(z);
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.q0, onClickListener, this.p0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.p0 = onLongClickListener;
        b(this.q0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.r0 = colorStateList;
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = a.h.c.l.a.i(drawable).mutate();
            a.h.c.l.a.a(drawable, colorStateList);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = a.h.c.l.a.i(drawable).mutate();
            a.h.c.l.a.a(drawable, mode);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.f10666g.d(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f10666g.a(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (r()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!r()) {
                setHelperTextEnabled(true);
            }
            this.f10666g.c(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f10666g.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f10666g.b(z);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f10666g.e(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.F0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.z) {
            this.z = z;
            if (z) {
                CharSequence hint = this.f10664e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f10664e.setHint((CharSequence) null);
                }
                this.B = true;
            } else {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f10664e.getHint())) {
                    this.f10664e.setHint(this.A);
                }
                setHintInternal(null);
            }
            if (this.f10664e != null) {
                J();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.E0.a(i2);
        this.t0 = this.E0.f();
        if (this.f10664e != null) {
            d(false);
            J();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                this.E0.b(colorStateList);
            }
            this.t0 = colorStateList;
            if (this.f10664e != null) {
                d(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.d0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        this.i0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.j0 = mode;
        this.k0 = true;
        d();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.o && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.o) {
                setPlaceholderTextEnabled(true);
            }
            this.n = charSequence;
        }
        L();
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.r = i2;
        TextView textView = this.p;
        if (textView != null) {
            i.d(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            TextView textView = this.p;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.w.setText(charSequence);
        N();
    }

    public void setPrefixTextAppearance(int i2) {
        i.d(this.w, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.R.setCheckable(z);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.R, onClickListener, this.b0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b0 = onLongClickListener;
        b(this.R, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            e();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            e();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (v() != z) {
            this.R.setVisibility(z ? 0 : 8);
            M();
            G();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        P();
    }

    public void setSuffixTextAppearance(int i2) {
        i.d(this.y, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f10664e;
        if (editText != null) {
            y.a(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.e(typeface);
            this.f10666g.a(typeface);
            TextView textView = this.k;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public boolean t() {
        return this.B;
    }

    public final boolean u() {
        return this.G == 1 && (Build.VERSION.SDK_INT < 16 || this.f10664e.getMinLines() <= 1);
    }

    public boolean v() {
        return this.R.getVisibility() == 0;
    }

    public final void w() {
        f();
        z();
        Q();
        if (this.G != 0) {
            J();
        }
    }

    public final void x() {
        if (l()) {
            RectF rectF = this.P;
            this.E0.a(rectF, this.f10664e.getWidth(), this.f10664e.getGravity());
            a(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((c.c.a.c.z.c) this.C).a(rectF);
        }
    }

    public final void y() {
        TextView textView = this.p;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void z() {
        if (C()) {
            y.a(this.f10664e, this.C);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public void b(int i2) {
        boolean z = this.j;
        int i3 = this.f10668i;
        if (i3 == -1) {
            this.k.setText(String.valueOf(i2));
            this.k.setContentDescription(null);
            this.j = false;
        } else {
            this.j = i2 > i3;
            a(getContext(), this.k, i2, this.f10668i, this.j);
            if (z != this.j) {
                F();
            }
            this.k.setText(a.h.h.a.b().a(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f10668i))));
        }
        if (this.f10664e == null || z == this.j) {
            return;
        }
        d(false);
        Q();
        H();
    }

    public final void c(int i2) {
        if (i2 != 0 || this.D0) {
            o();
        } else {
            D();
        }
    }

    public final void d() {
        a(this.f0, this.i0, this.h0, this.k0, this.j0);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.q0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f10666g.m());
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.R.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.R.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            e();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, J0), attributeSet, i2);
        this.f10666g = new c.c.a.c.z.f(this);
        this.N = new Rect();
        this.O = new Rect();
        this.P = new RectF();
        this.c0 = new LinkedHashSet<>();
        this.d0 = 0;
        this.e0 = new SparseArray<>();
        this.g0 = new LinkedHashSet<>();
        this.E0 = new c.c.a.c.r.a(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f10660a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f10660a);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f10661b = linearLayout;
        linearLayout.setOrientation(0);
        this.f10661b.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.f10660a.addView(this.f10661b);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f10662c = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f10662c.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.f10660a.addView(this.f10662c);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f10663d = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.E0.b(c.c.a.c.a.a.f5306a);
        this.E0.a(c.c.a.c.a.a.f5306a);
        this.E0.b(8388659);
        g0 d2 = l.d(context2, attributeSet, R$styleable.TextInputLayout, i2, J0, R$styleable.TextInputLayout_counterTextAppearance, R$styleable.TextInputLayout_counterOverflowTextAppearance, R$styleable.TextInputLayout_errorTextAppearance, R$styleable.TextInputLayout_helperTextTextAppearance, R$styleable.TextInputLayout_hintTextAppearance);
        this.z = d2.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(d2.e(R$styleable.TextInputLayout_android_hint));
        this.F0 = d2.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.E = m.a(context2, attributeSet, i2, J0).a();
        this.F = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.H = d2.b(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.J = d2.c(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.K = d2.c(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.I = this.J;
        float a2 = d2.a(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float a3 = d2.a(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float a4 = d2.a(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float a5 = d2.a(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        m.b m = this.E.m();
        if (a2 >= 0.0f) {
            m.d(a2);
        }
        if (a3 >= 0.0f) {
            m.e(a3);
        }
        if (a4 >= 0.0f) {
            m.c(a4);
        }
        if (a5 >= 0.0f) {
            m.b(a5);
        }
        this.E = m.a();
        ColorStateList a6 = c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_boxBackgroundColor);
        if (a6 != null) {
            int defaultColor = a6.getDefaultColor();
            this.y0 = defaultColor;
            this.M = defaultColor;
            if (a6.isStateful()) {
                this.z0 = a6.getColorForState(new int[]{-16842910}, -1);
                this.A0 = a6.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.B0 = a6.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.A0 = this.y0;
                ColorStateList b2 = a.b.b.a.a.b(context2, R$color.mtrl_filled_background_color);
                this.z0 = b2.getColorForState(new int[]{-16842910}, -1);
                this.B0 = b2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.M = 0;
            this.y0 = 0;
            this.z0 = 0;
            this.A0 = 0;
            this.B0 = 0;
        }
        if (d2.g(R$styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList a7 = d2.a(R$styleable.TextInputLayout_android_textColorHint);
            this.t0 = a7;
            this.s0 = a7;
        }
        ColorStateList a8 = c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_boxStrokeColor);
        this.w0 = d2.a(R$styleable.TextInputLayout_boxStrokeColor, 0);
        this.u0 = a.h.b.a.a(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.C0 = a.h.b.a.a(context2, R$color.mtrl_textinput_disabled_color);
        this.v0 = a.h.b.a.a(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (a8 != null) {
            setBoxStrokeColorStateList(a8);
        }
        if (d2.g(R$styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (d2.g(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(d2.g(R$styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int g2 = d2.g(R$styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence e2 = d2.e(R$styleable.TextInputLayout_errorContentDescription);
        boolean a9 = d2.a(R$styleable.TextInputLayout_errorEnabled, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.f10662c, false);
        this.q0 = checkableImageButton;
        checkableImageButton.setVisibility(8);
        if (d2.g(R$styleable.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(d2.b(R$styleable.TextInputLayout_errorIconDrawable));
        }
        if (d2.g(R$styleable.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_errorIconTint));
        }
        if (d2.g(R$styleable.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(c.c.a.c.r.r.a(d2.d(R$styleable.TextInputLayout_errorIconTintMode, -1), (PorterDuff.Mode) null));
        }
        this.q0.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        y.h(this.q0, 2);
        this.q0.setClickable(false);
        this.q0.setPressable(false);
        this.q0.setFocusable(false);
        int g3 = d2.g(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean a10 = d2.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence e3 = d2.e(R$styleable.TextInputLayout_helperText);
        int g4 = d2.g(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence e4 = d2.e(R$styleable.TextInputLayout_placeholderText);
        int g5 = d2.g(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence e5 = d2.e(R$styleable.TextInputLayout_prefixText);
        int g6 = d2.g(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence e6 = d2.e(R$styleable.TextInputLayout_suffixText);
        boolean a11 = d2.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(d2.d(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.m = d2.g(R$styleable.TextInputLayout_counterTextAppearance, 0);
        this.l = d2.g(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.f10661b, false);
        this.R = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (d2.g(R$styleable.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(d2.b(R$styleable.TextInputLayout_startIconDrawable));
            if (d2.g(R$styleable.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(d2.e(R$styleable.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(d2.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        if (d2.g(R$styleable.TextInputLayout_startIconTint)) {
            setStartIconTintList(c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_startIconTint));
        }
        if (d2.g(R$styleable.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(c.c.a.c.r.r.a(d2.d(R$styleable.TextInputLayout_startIconTintMode, -1), (PorterDuff.Mode) null));
        }
        setBoxBackgroundMode(d2.d(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.f10663d, false);
        this.f0 = checkableImageButton3;
        this.f10663d.addView(checkableImageButton3);
        this.f0.setVisibility(8);
        this.e0.append(-1, new c.c.a.c.z.b(this));
        this.e0.append(0, new c.c.a.c.z.g(this));
        this.e0.append(1, new c.c.a.c.z.h(this));
        this.e0.append(2, new c.c.a.c.z.a(this));
        this.e0.append(3, new c.c.a.c.z.d(this));
        if (d2.g(R$styleable.TextInputLayout_endIconMode)) {
            setEndIconMode(d2.d(R$styleable.TextInputLayout_endIconMode, 0));
            if (d2.g(R$styleable.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(d2.b(R$styleable.TextInputLayout_endIconDrawable));
            }
            if (d2.g(R$styleable.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(d2.e(R$styleable.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(d2.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (d2.g(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(d2.a(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(d2.b(R$styleable.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(d2.e(R$styleable.TextInputLayout_passwordToggleContentDescription));
            if (d2.g(R$styleable.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_passwordToggleTint));
            }
            if (d2.g(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(c.c.a.c.r.r.a(d2.d(R$styleable.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        if (!d2.g(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (d2.g(R$styleable.TextInputLayout_endIconTint)) {
                setEndIconTintList(c.c.a.c.t.c.a(context2, d2, R$styleable.TextInputLayout_endIconTint));
            }
            if (d2.g(R$styleable.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(c.c.a.c.r.r.a(d2.d(R$styleable.TextInputLayout_endIconTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.w = appCompatTextView;
        appCompatTextView.setId(R$id.textinput_prefix_text);
        this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        y.g(this.w, 1);
        this.f10661b.addView(this.R);
        this.f10661b.addView(this.w);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.y = appCompatTextView2;
        appCompatTextView2.setId(R$id.textinput_suffix_text);
        this.y.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        y.g(this.y, 1);
        this.f10662c.addView(this.y);
        this.f10662c.addView(this.q0);
        this.f10662c.addView(this.f10663d);
        setHelperTextEnabled(a10);
        setHelperText(e3);
        setHelperTextTextAppearance(g3);
        setErrorEnabled(a9);
        setErrorTextAppearance(g2);
        setErrorContentDescription(e2);
        setCounterTextAppearance(this.m);
        setCounterOverflowTextAppearance(this.l);
        setPlaceholderText(e4);
        setPlaceholderTextAppearance(g4);
        setPrefixText(e5);
        setPrefixTextAppearance(g5);
        setSuffixText(e6);
        setSuffixTextAppearance(g6);
        if (d2.g(R$styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(d2.a(R$styleable.TextInputLayout_errorTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(d2.a(R$styleable.TextInputLayout_helperTextTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(d2.a(R$styleable.TextInputLayout_hintTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(d2.a(R$styleable.TextInputLayout_counterTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(d2.a(R$styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(d2.a(R$styleable.TextInputLayout_placeholderTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(d2.a(R$styleable.TextInputLayout_prefixTextColor));
        }
        if (d2.g(R$styleable.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(d2.a(R$styleable.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(a11);
        setEnabled(d2.a(R$styleable.TextInputLayout_android_enabled, true));
        d2.b();
        y.h(this, 2);
    }

    public final void a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f10664e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f10664e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean d2 = this.f10666g.d();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            this.E0.b(colorStateList2);
            this.E0.c(this.s0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.s0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.b(ColorStateList.valueOf(colorForState));
            this.E0.c(ColorStateList.valueOf(colorForState));
        } else if (d2) {
            this.E0.b(this.f10666g.h());
        } else if (this.j && (textView = this.k) != null) {
            this.E0.b(textView.getTextColors());
        } else if (z4 && (colorStateList = this.t0) != null) {
            this.E0.b(colorStateList);
        }
        if (!z3 && (!isEnabled() || (!z4 && !d2))) {
            if (z2 || !this.D0) {
                b(z);
                return;
            }
            return;
        }
        if (z2 || this.D0) {
            a(z);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    public final void c() {
        if (this.D == null) {
            return;
        }
        if (j()) {
            this.D.a(ColorStateList.valueOf(this.L));
        }
        invalidate();
    }

    public final void c(boolean z) {
        if (z && getEndIconDrawable() != null) {
            Drawable mutate = a.h.c.l.a.i(getEndIconDrawable()).mutate();
            a.h.c.l.a.b(mutate, this.f10666g.g());
            this.f0.setImageDrawable(mutate);
            return;
        }
        d();
    }

    public final void c(Rect rect) {
        h hVar = this.D;
        if (hVar != null) {
            int i2 = rect.bottom;
            hVar.setBounds(rect.left, i2 - this.K, rect.right, i2);
        }
    }

    public final int b(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.f10664e.getCompoundPaddingRight();
        return (this.v == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    public static void a(Context context, TextView textView, int i2, int i3, boolean z) {
        textView.setContentDescription(context.getString(z ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public final Rect b(Rect rect) {
        if (this.f10664e != null) {
            Rect rect2 = this.O;
            float m = this.E0.m();
            rect2.left = rect.left + this.f10664e.getCompoundPaddingLeft();
            rect2.top = a(rect, m);
            rect2.right = rect.right - this.f10664e.getCompoundPaddingRight();
            rect2.bottom = a(rect, rect2, m);
            return rect2;
        }
        throw new IllegalStateException();
    }

    public final void a() {
        TextView textView = this.p;
        if (textView != null) {
            this.f10660a.addView(textView);
            this.p.setVisibility(0);
        }
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public final void b() {
        h hVar = this.C;
        if (hVar == null) {
            return;
        }
        hVar.setShapeAppearanceModel(this.E);
        if (i()) {
            this.C.a(this.I, this.L);
        }
        int g2 = g();
        this.M = g2;
        this.C.a(ColorStateList.valueOf(g2));
        if (this.d0 == 3) {
            this.f10664e.getBackground().invalidateSelf();
        }
        c();
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            a.h.k.i.d(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R$style.TextAppearance_AppCompat_Caption
            a.h.k.i.d(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R$color.design_error
            int r4 = a.h.b.a.a(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a(android.widget.TextView, int):void");
    }

    public final Rect a(Rect rect) {
        if (this.f10664e != null) {
            Rect rect2 = this.O;
            boolean z = y.q(this) == 1;
            rect2.bottom = rect.bottom;
            int i2 = this.G;
            if (i2 == 1) {
                rect2.left = a(rect.left, z);
                rect2.top = rect.top + this.H;
                rect2.right = b(rect.right, z);
                return rect2;
            }
            if (i2 != 2) {
                rect2.left = a(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = b(rect.right, z);
                return rect2;
            }
            rect2.left = rect.left + this.f10664e.getPaddingLeft();
            rect2.top = rect.top - h();
            rect2.right = rect.right - this.f10664e.getPaddingRight();
            return rect2;
        }
        throw new IllegalStateException();
    }

    public static void b(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a(checkableImageButton, onLongClickListener);
    }

    public final void b(Canvas canvas) {
        if (this.z) {
            this.E0.a(canvas);
        }
    }

    public final void b(boolean z, boolean z2) {
        int defaultColor = this.x0.getDefaultColor();
        int colorForState = this.x0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.x0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.L = colorForState2;
        } else if (z2) {
            this.L = colorForState;
        } else {
            this.L = defaultColor;
        }
    }

    public final void b(boolean z) {
        ValueAnimator valueAnimator = this.G0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.G0.cancel();
        }
        if (z && this.F0) {
            a(0.0f);
        } else {
            this.E0.g(0.0f);
        }
        if (l() && ((c.c.a.c.z.c) this.C).D()) {
            k();
        }
        this.D0 = true;
        o();
        N();
        P();
    }

    public final int a(int i2, boolean z) {
        int compoundPaddingLeft = i2 + this.f10664e.getCompoundPaddingLeft();
        return (this.v == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    public final int a(Rect rect, float f2) {
        if (u()) {
            return (int) (rect.centerY() - (f2 / 2.0f));
        }
        return rect.top + this.f10664e.getCompoundPaddingTop();
    }

    public final int a(Rect rect, Rect rect2, float f2) {
        if (u()) {
            return (int) (rect2.top + f2);
        }
        return rect.bottom - this.f10664e.getCompoundPaddingBottom();
    }

    public final void a(int i2) {
        Iterator<g> it = this.g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    public final void a(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = a.h.c.l.a.i(drawable).mutate();
            if (z) {
                a.h.c.l.a.a(drawable, colorStateList);
            }
            if (z2) {
                a.h.c.l.a.a(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void a(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        a(checkableImageButton, onLongClickListener);
    }

    public static void a(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean E = y.E(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = E || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(E);
        checkableImageButton.setPressable(E);
        checkableImageButton.setLongClickable(z);
        y.h(checkableImageButton, z2 ? 1 : 2);
    }

    public final void a(Canvas canvas) {
        h hVar = this.D;
        if (hVar != null) {
            Rect bounds = hVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    public final void a(boolean z) {
        ValueAnimator valueAnimator = this.G0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.G0.cancel();
        }
        if (z && this.F0) {
            a(1.0f);
        } else {
            this.E0.g(1.0f);
        }
        this.D0 = false;
        if (l()) {
            x();
        }
        L();
        N();
        P();
    }

    public final void a(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.F;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    public final void a(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable mutate = a.h.c.l.a.i(drawable).mutate();
        a.h.c.l.a.a(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public void a(float f2) {
        if (this.E0.o() == f2) {
            return;
        }
        if (this.G0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.G0 = valueAnimator;
            valueAnimator.setInterpolator(c.c.a.c.a.a.f5307b);
            this.G0.setDuration(167L);
            this.G0.addUpdateListener(new d());
        }
        this.G0.setFloatValues(this.E0.o(), f2);
        this.G0.start();
    }
}
