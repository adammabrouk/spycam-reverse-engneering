package androidx.appcompat.widget;

import a.b.b.a.a;
import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.g;
import a.b.f.m;
import a.b.f.n;
import a.h.h.c;
import a.h.j.x;
import a.h.k.b;
import a.h.k.i;
import a.h.k.l;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements x, l, b {

    /* renamed from: a, reason: collision with root package name */
    public final d f2280a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2281b;

    /* renamed from: c, reason: collision with root package name */
    public final m f2282c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2283d;

    /* renamed from: e, reason: collision with root package name */
    public Future<c> f2284e;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public final void d() {
        Future<c> future = this.f2284e;
        if (future != null) {
            try {
                this.f2284e = null;
                i.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2280a;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.s) {
            return super.getAutoSizeMaxTextSize();
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            return nVar.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.s) {
            return super.getAutoSizeMinTextSize();
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            return nVar.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.s) {
            return super.getAutoSizeStepGranularity();
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            return nVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.s) {
            return super.getAutoSizeTextAvailableSizes();
        }
        n nVar = this.f2281b;
        return nVar != null ? nVar.f() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.s) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            return nVar.g();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return i.c(this);
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2280a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2280a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2281b.h();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2281b.i();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        d();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        m mVar;
        return (Build.VERSION.SDK_INT >= 28 || (mVar = this.f2282c) == null) ? super.getTextClassifier() : mVar.a();
    }

    public c.a getTextMetricsParamsCompat() {
        return i.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2281b.a(this, onCreateInputConnection, editorInfo);
        g.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        d();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        n nVar = this.f2281b;
        if (nVar == null || b.s || !nVar.j()) {
            return;
        }
        this.f2281b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.s) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.s) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.s) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2280a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2280a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            i.a(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            i.b(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        i.c(this, i2);
    }

    public void setPrecomputedText(c cVar) {
        i.a(this, cVar);
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2280a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2280a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // a.h.k.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2281b.a(colorStateList);
        this.f2281b.a();
    }

    @Override // a.h.k.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2281b.a(mode);
        this.f2281b.a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.f2282c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            mVar.a(textClassifier);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.f2284e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        i.a(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (b.s) {
            super.setTextSize(i2, f2);
            return;
        }
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.a(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        if (this.f2283d) {
            return;
        }
        Typeface typeface2 = null;
        if (typeface != null && i2 > 0) {
            typeface2 = a.h.c.d.a(getContext(), typeface, i2);
        }
        this.f2283d = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.f2283d = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        this.f2283d = false;
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f2280a = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2281b = nVar;
        nVar.a(attributeSet, i2);
        this.f2281b.a();
        this.f2282c = new m(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? a.c(context, i2) : null, i3 != 0 ? a.c(context, i3) : null, i4 != 0 ? a.c(context, i4) : null, i5 != 0 ? a.c(context, i5) : null);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? a.c(context, i2) : null, i3 != 0 ? a.c(context, i3) : null, i4 != 0 ? a.c(context, i4) : null, i5 != 0 ? a.c(context, i5) : null);
        n nVar = this.f2281b;
        if (nVar != null) {
            nVar.k();
        }
    }
}
