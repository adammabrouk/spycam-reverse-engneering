package a.b.c.a;

import a.b.c.a.b;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class d extends b {
    public a m;
    public boolean n;

    /* compiled from: StateListDrawable.java */
    public static class a extends b.d {
        public int[][] J;

        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[d()][];
            }
        }

        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.J[a2] = iArr;
            return a2;
        }

        @Override // a.b.c.a.b.d
        public void n() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        public int a(int[] iArr) {
            int[][] iArr2 = this.J;
            int e2 = e();
            for (int i2 = 0; i2 < e2; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // a.b.c.a.b.d
        public void a(int i2, int i3) {
            super.a(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }
    }

    public d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // a.b.c.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.b.c.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.n) {
            super.mutate();
            if (this == this) {
                this.m.n();
                this.n = true;
            }
        }
        return this;
    }

    @Override // a.b.c.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int a2 = this.m.a(iArr);
        if (a2 < 0) {
            a2 = this.m.a(StateSet.WILD_CARD);
        }
        return a(a2) || onStateChange;
    }

    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    public d(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    @Override // a.b.c.a.b
    public a a() {
        return new a(this.m, this, null);
    }

    @Override // a.b.c.a.b
    public void a(b.d dVar) {
        super.a(dVar);
        if (dVar instanceof a) {
            this.m = (a) dVar;
        }
    }
}
