package androidx.appcompat.widget;

import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.g;
import a.b.f.k;
import a.b.f.m;
import a.b.f.n;
import a.h.j.c;
import a.h.j.i0.a;
import a.h.j.i0.b;
import a.h.j.u;
import a.h.j.x;
import a.h.j.y;
import a.h.k.i;
import a.h.k.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements x, u {

    /* renamed from: a, reason: collision with root package name */
    public final d f2245a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2246b;

    /* renamed from: c, reason: collision with root package name */
    public final m f2247c;

    /* renamed from: d, reason: collision with root package name */
    public final j f2248d;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    @Override // a.h.j.u
    public c a(c cVar) {
        return this.f2248d.a((View) this, cVar);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2245a;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2246b;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2245a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2245a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        m mVar;
        return (Build.VERSION.SDK_INT >= 28 || (mVar = this.f2247c) == null) ? super.getTextClassifier() : mVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2246b.a(this, onCreateInputConnection, editorInfo);
        g.a(onCreateInputConnection, editorInfo, this);
        String[] t = y.t(this);
        if (onCreateInputConnection == null || t == null) {
            return onCreateInputConnection;
        }
        a.a(editorInfo, t);
        return b.a(onCreateInputConnection, editorInfo, k.a(this));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (k.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        if (k.a(this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2245a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2245a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2245a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2245a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        n nVar = this.f2246b;
        if (nVar != null) {
            nVar.a(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.f2247c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            mVar.a(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f2245a = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2246b = nVar;
        nVar.a(attributeSet, i2);
        this.f2246b.a();
        this.f2247c = new m(this);
        this.f2248d = new j();
    }
}
