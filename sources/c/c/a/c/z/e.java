package c.c.a.c.z;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: EndIconDelegate.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public TextInputLayout f5775a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5776b;

    /* renamed from: c, reason: collision with root package name */
    public CheckableImageButton f5777c;

    public e(TextInputLayout textInputLayout) {
        this.f5775a = textInputLayout;
        this.f5776b = textInputLayout.getContext();
        this.f5777c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public void a(boolean z) {
    }

    public boolean a(int i2) {
        return true;
    }

    public boolean b() {
        return false;
    }
}
