package a.b.f;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
public class i extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f504b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f505a;

    static {
        f504b = Build.VERSION.SDK_INT < 21;
    }

    public i(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        g0 a2 = g0.a(context, attributeSet, R$styleable.PopupWindow, i2, i3);
        if (a2.g(R$styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(R$styleable.PopupWindow_android_popupBackground));
        a2.b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (f504b && this.f505a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f504b && this.f505a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f504b && this.f505a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }

    public final void a(boolean z) {
        if (f504b) {
            this.f505a = z;
        } else {
            a.h.k.h.a(this, z);
        }
    }
}
