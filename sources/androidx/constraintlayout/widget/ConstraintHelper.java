package androidx.constraintlayout.widget;

import a.f.a.j.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f2402a;

    /* renamed from: b, reason: collision with root package name */
    public int f2403b;

    /* renamed from: c, reason: collision with root package name */
    public Context f2404c;

    /* renamed from: d, reason: collision with root package name */
    public j f2405d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2406e;

    /* renamed from: f, reason: collision with root package name */
    public String f2407f;

    public ConstraintHelper(Context context) {
        super(context);
        this.f2402a = new int[32];
        this.f2406e = false;
        this.f2404c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i2);
            if (indexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, indexOf));
                i2 = indexOf + 1;
            }
        }
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f2407f = string;
                    setIds(string);
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f2407f);
        }
        j jVar = this.f2405d;
        if (jVar == null) {
            return;
        }
        jVar.K();
        for (int i2 = 0; i2 < this.f2403b; i2++) {
            View b2 = constraintLayout.b(this.f2402a[i2]);
            if (b2 != null) {
                this.f2405d.b(constraintLayout.a(b2));
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2402a, this.f2403b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f2406e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2403b = 0;
        for (int i2 : iArr) {
            setTag(i2, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        int i3 = this.f2403b + 1;
        int[] iArr = this.f2402a;
        if (i3 > iArr.length) {
            this.f2402a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2402a;
        int i4 = this.f2403b;
        iArr2[i4] = i2;
        this.f2403b = i4 + 1;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2402a = new int[32];
        this.f2406e = false;
        this.f2404c = context;
        a(attributeSet);
    }

    public void a() {
        if (this.f2405d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).k0 = this.f2405d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2402a = new int[32];
        this.f2406e = false;
        this.f2404c = context;
        a(attributeSet);
    }

    public final void a(String str) {
        int i2;
        Object a2;
        if (str == null || this.f2404c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i2 = R$id.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = this.f2404c.getResources().getIdentifier(trim, "id", this.f2404c.getPackageName());
        }
        if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
            i2 = ((Integer) a2).intValue();
        }
        if (i2 != 0) {
            setTag(i2, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }
}
