package androidx.appcompat.widget;

import a.b.b.a.a;
import a.b.f.b0;
import a.b.f.d0;
import a.b.f.g;
import a.b.f.g0;
import a.b.f.n;
import a.h.k.i;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2243b = {R.attr.checkMark};

    /* renamed from: a, reason: collision with root package name */
    public final n f2244a;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f2244a;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        g.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.c(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        n nVar = this.f2244a;
        if (nVar != null) {
            nVar.a(context, i2);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        n nVar = new n(this);
        this.f2244a = nVar;
        nVar.a(attributeSet, i2);
        this.f2244a.a();
        g0 a2 = g0.a(getContext(), attributeSet, f2243b, i2, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.b();
    }
}
