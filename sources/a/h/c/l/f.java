package a.h.c.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f1011a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f1012b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f1013c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f1014d;

    public f(f fVar) {
        this.f1013c = null;
        this.f1014d = d.f1003g;
        if (fVar != null) {
            this.f1011a = fVar.f1011a;
            this.f1012b = fVar.f1012b;
            this.f1013c = fVar.f1013c;
            this.f1014d = fVar.f1014d;
        }
    }

    public boolean a() {
        return this.f1012b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.f1011a;
        Drawable.ConstantState constantState = this.f1012b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
