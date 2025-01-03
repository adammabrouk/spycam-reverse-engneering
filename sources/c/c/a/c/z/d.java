package c.c.a.c.z;

import a.h.j.y;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes.dex */
public class d extends c.c.a.c.z.e {
    public static final boolean q;

    /* renamed from: d, reason: collision with root package name */
    public final TextWatcher f5756d;

    /* renamed from: e, reason: collision with root package name */
    public final View.OnFocusChangeListener f5757e;

    /* renamed from: f, reason: collision with root package name */
    public final TextInputLayout.e f5758f;

    /* renamed from: g, reason: collision with root package name */
    public final TextInputLayout.f f5759g;

    /* renamed from: h, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g f5760h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5761i;
    public boolean j;
    public long k;
    public StateListDrawable l;
    public c.c.a.c.w.h m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class a implements TextWatcher {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: c.c.a.c.z.d$a$a, reason: collision with other inner class name */
        public class RunnableC0110a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f5763a;

            public RunnableC0110a(AutoCompleteTextView autoCompleteTextView) {
                this.f5763a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f5763a.isPopupShowing();
                d.this.b(isPopupShowing);
                d.this.f5761i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView a2 = dVar.a(dVar.f5775a.getEditText());
            a2.post(new RunnableC0110a(a2));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f5777c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.f5775a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.b(false);
            d.this.f5761i = false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: c.c.a.c.z.d$d, reason: collision with other inner class name */
    public class C0111d extends TextInputLayout.e {
        public C0111d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            if (d.this.f5775a.getEditText().getKeyListener() == null) {
                cVar.a((CharSequence) Spinner.class.getName());
            }
            if (cVar.w()) {
                cVar.d((CharSequence) null);
            }
        }

        @Override // a.h.j.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView a2 = dVar.a(dVar.f5775a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.n.isTouchExplorationEnabled()) {
                d.this.d(a2);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class e implements TextInputLayout.f {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView a2 = d.this.a(textInputLayout.getEditText());
            d.this.b(a2);
            d.this.a(a2);
            d.this.c(a2);
            a2.setThreshold(0);
            a2.removeTextChangedListener(d.this.f5756d);
            a2.addTextChangedListener(d.this.f5756d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f5758f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class f implements TextInputLayout.g {
        public f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.removeTextChangedListener(d.this.f5756d);
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f5757e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.d((AutoCompleteTextView) d.this.f5775a.getEditText());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class h implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoCompleteTextView f5771a;

        public h(AutoCompleteTextView autoCompleteTextView) {
            this.f5771a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.d()) {
                    d.this.f5761i = false;
                }
                d.this.d(this.f5771a);
            }
            return false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class i implements AutoCompleteTextView.OnDismissListener {
        public i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f5761i = true;
            d.this.k = System.currentTimeMillis();
            d.this.b(false);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f5777c.setChecked(dVar.j);
            d.this.p.start();
        }
    }

    static {
        q = Build.VERSION.SDK_INT >= 21;
    }

    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5756d = new a();
        this.f5757e = new c();
        this.f5758f = new C0111d(this.f5775a);
        this.f5759g = new e();
        this.f5760h = new f();
        this.f5761i = false;
        this.j = false;
        this.k = RecyclerView.FOREVER_NS;
    }

    @Override // c.c.a.c.z.e
    public boolean a(int i2) {
        return i2 != 0;
    }

    @Override // c.c.a.c.z.e
    public boolean b() {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void c(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f5757e);
        if (q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    public final void d(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (d()) {
            this.f5761i = false;
        }
        if (!this.f5761i) {
            if (q) {
                b(!this.j);
            } else {
                this.j = !this.j;
                this.f5777c.toggle();
            }
            if (this.j) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.f5761i = false;
    }

    public final void b(AutoCompleteTextView autoCompleteTextView) {
        if (q) {
            int boxBackgroundMode = this.f5775a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.l);
            }
        }
    }

    @Override // c.c.a.c.z.e
    public void a() {
        float dimensionPixelOffset = this.f5776b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f5776b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f5776b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        c.c.a.c.w.h a2 = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        c.c.a.c.w.h a3 = a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = a2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, a2);
        this.l.addState(new int[0], a3);
        this.f5775a.setEndIconDrawable(a.b.b.a.a.c(this.f5776b, q ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f5775a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.f5775a.setEndIconOnClickListener(new g());
        this.f5775a.addOnEditTextAttachedListener(this.f5759g);
        this.f5775a.addOnEndIconChangedListener(this.f5760h);
        c();
        y.h(this.f5777c, 2);
        this.n = (AccessibilityManager) this.f5776b.getSystemService("accessibility");
    }

    public final void c() {
        this.p = a(67, 0.0f, 1.0f);
        ValueAnimator a2 = a(50, 1.0f, 0.0f);
        this.o = a2;
        a2.addListener(new j());
    }

    public final void b(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, c.c.a.c.w.h hVar) {
        LayerDrawable layerDrawable;
        int a2 = c.c.a.c.k.a.a(autoCompleteTextView, R$attr.colorSurface);
        c.c.a.c.w.h hVar2 = new c.c.a.c.w.h(hVar.n());
        int a3 = c.c.a.c.k.a.a(i2, a2, 0.1f);
        hVar2.a(new ColorStateList(iArr, new int[]{a3, 0}));
        if (q) {
            hVar2.setTint(a2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{a3, a2});
            c.c.a.c.w.h hVar3 = new c.c.a.c.w.h(hVar.n());
            hVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar2, hVar3), hVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar});
        }
        y.a(autoCompleteTextView, layerDrawable);
    }

    public final boolean d() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    public final void b(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.p.cancel();
            this.o.start();
        }
    }

    public final void a(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f5775a.getBoxBackgroundMode();
        c.c.a.c.w.h boxBackground = this.f5775a.getBoxBackground();
        int a2 = c.c.a.c.k.a.a(autoCompleteTextView, R$attr.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            b(autoCompleteTextView, a2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            a(autoCompleteTextView, a2, iArr, boxBackground);
        }
    }

    public final void a(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, c.c.a.c.w.h hVar) {
        int boxBackgroundColor = this.f5775a.getBoxBackgroundColor();
        int[] iArr2 = {c.c.a.c.k.a.a(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (q) {
            y.a(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), hVar, hVar));
            return;
        }
        c.c.a.c.w.h hVar2 = new c.c.a.c.w.h(hVar.n());
        hVar2.a(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar, hVar2});
        int w = y.w(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int v = y.v(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        y.a(autoCompleteTextView, layerDrawable);
        y.a(autoCompleteTextView, w, paddingTop, v, paddingBottom);
    }

    public final c.c.a.c.w.h a(float f2, float f3, float f4, int i2) {
        m.b n = m.n();
        n.d(f2);
        n.e(f2);
        n.b(f3);
        n.c(f3);
        m a2 = n.a();
        c.c.a.c.w.h a3 = c.c.a.c.w.h.a(this.f5776b, f4);
        a3.setShapeAppearanceModel(a2);
        a3.a(0, i2, 0, i2);
        return a3;
    }

    public final AutoCompleteTextView a(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public final ValueAnimator a(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.c.a.c.a.a.f5306a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }
}
