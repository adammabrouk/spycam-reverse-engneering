package androidx.constraintlayout.widget;

import a.f.a.j.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: g, reason: collision with root package name */
    public int f2399g;

    /* renamed from: h, reason: collision with root package name */
    public int f2400h;

    /* renamed from: i, reason: collision with root package name */
    public b f2401i;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2401i = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2401i.c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f2405d = this.f2401i;
        a();
    }

    public int getType() {
        return this.f2399g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2401i.c(z);
    }

    public void setType(int i2) {
        this.f2399g = i2;
        this.f2400h = i2;
        if (Build.VERSION.SDK_INT >= 17) {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f2399g;
                if (i3 == 5) {
                    this.f2400h = 1;
                } else if (i3 == 6) {
                    this.f2400h = 0;
                }
            } else {
                int i4 = this.f2399g;
                if (i4 == 5) {
                    this.f2400h = 0;
                } else if (i4 == 6) {
                    this.f2400h = 1;
                }
            }
        } else if (i2 == 5) {
            this.f2400h = 0;
        } else if (i2 == 6) {
            this.f2400h = 1;
        }
        this.f2401i.u(this.f2400h);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
