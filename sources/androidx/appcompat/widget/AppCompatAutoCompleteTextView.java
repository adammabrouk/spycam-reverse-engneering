package androidx.appcompat.widget;

import a.b.b.a.a;
import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.g;
import a.b.f.g0;
import a.b.f.n;
import a.h.j.x;
import a.h.k.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements x {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2235c = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final d f2236a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2237b;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2236a;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2237b;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2236a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2236a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        g.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2236a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2236a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.c(getContext(), i2));
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2236a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2236a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        n nVar = this.f2237b;
        if (nVar != null) {
            nVar.a(context, i2);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        g0 a2 = g0.a(getContext(), attributeSet, f2235c, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.b();
        d dVar = new d(this);
        this.f2236a = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2237b = nVar;
        nVar.a(attributeSet, i2);
        this.f2237b.a();
    }
}
