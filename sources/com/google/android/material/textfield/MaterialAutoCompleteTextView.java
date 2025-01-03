package com.google.android.material.textfield;

import a.b.f.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import c.c.a.c.r.d;
import c.c.a.c.r.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    public final v f10654d;

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f10655e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f10656f;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MaterialAutoCompleteTextView.this.a(i2 < 0 ? MaterialAutoCompleteTextView.this.f10654d.k() : MaterialAutoCompleteTextView.this.getAdapter().getItem(i2));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i2 < 0) {
                    view = MaterialAutoCompleteTextView.this.f10654d.n();
                    i2 = MaterialAutoCompleteTextView.this.f10654d.m();
                    j = MaterialAutoCompleteTextView.this.f10654d.l();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f10654d.e(), view, i2, j);
            }
            MaterialAutoCompleteTextView.this.f10654d.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public final int b() {
        ListAdapter adapter = getAdapter();
        TextInputLayout a2 = a();
        int i2 = 0;
        if (adapter == null || a2 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f10654d.m()) + 15);
        View view = null;
        int i3 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(max, view, a2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        Drawable c2 = this.f10654d.c();
        if (c2 != null) {
            c2.getPadding(this.f10656f);
            Rect rect = this.f10656f;
            i3 += rect.left + rect.right;
        }
        return i3 + a2.getEndIconView().getMeasuredWidth();
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout a2 = a();
        return (a2 == null || !a2.t()) ? super.getHint() : a2.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout a2 = a();
        if (a2 != null && a2.t() && super.getHint() == null && d.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), b()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f10654d.a(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() == 0 && (accessibilityManager = this.f10655e) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f10654d.d();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, 0), attributeSet, i2);
        this.f10656f = new Rect();
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i2, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (c2.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && c2.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f10655e = (AccessibilityManager) context2.getSystemService("accessibility");
        v vVar = new v(context2);
        this.f10654d = vVar;
        vVar.a(true);
        this.f10654d.a(this);
        this.f10654d.g(2);
        this.f10654d.a(getAdapter());
        this.f10654d.setOnItemClickListener(new a());
        c2.recycle();
    }

    public final TextInputLayout a() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final <T extends ListAdapter & Filterable> void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }
}
