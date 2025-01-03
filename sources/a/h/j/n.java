package a.h.j;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f1197a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f1198b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1199c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1200d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1201e;

    public n(View view) {
        this.f1199c = view;
    }

    public void a(boolean z) {
        if (this.f1200d) {
            y.Q(this.f1199c);
        }
        this.f1200d = z;
    }

    public boolean b() {
        return b(0);
    }

    public boolean c() {
        return this.f1200d;
    }

    public void d() {
        d(0);
    }

    public boolean b(int i2) {
        return a(i2) != null;
    }

    public boolean c(int i2) {
        return a(i2, 0);
    }

    public void d(int i2) {
        ViewParent a2 = a(i2);
        if (a2 != null) {
            b0.a(a2, this.f1199c, i2);
            a(i2, (ViewParent) null);
        }
    }

    public final boolean b(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent a2;
        int i7;
        int i8;
        int[] iArr3;
        if (!c() || (a2 = a(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1199c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i8 = iArr[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr2 == null) {
            int[] a3 = a();
            a3[0] = 0;
            a3[1] = 0;
            iArr3 = a3;
        } else {
            iArr3 = iArr2;
        }
        b0.a(a2, this.f1199c, i2, i3, i4, i5, i6, iArr3);
        if (iArr != null) {
            this.f1199c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i8;
        }
        return true;
    }

    public boolean a(int i2, int i3) {
        if (b(i3)) {
            return true;
        }
        if (!c()) {
            return false;
        }
        View view = this.f1199c;
        for (ViewParent parent = this.f1199c.getParent(); parent != null; parent = parent.getParent()) {
            if (b0.b(parent, view, this.f1199c, i2, i3)) {
                a(i3, parent);
                b0.a(parent, view, this.f1199c, i2, i3);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return b(i2, i3, i4, i5, iArr, 0, null);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return b(i2, i3, i4, i5, iArr, i6, null);
    }

    public void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent a2;
        int i5;
        int i6;
        if (!c() || (a2 = a(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f1199c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            iArr = a();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        b0.a(a2, this.f1199c, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f1199c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent a2;
        if (!c() || (a2 = a(0)) == null) {
            return false;
        }
        return b0.a(a2, this.f1199c, f2, f3, z);
    }

    public boolean a(float f2, float f3) {
        ViewParent a2;
        if (!c() || (a2 = a(0)) == null) {
            return false;
        }
        return b0.a(a2, this.f1199c, f2, f3);
    }

    public final ViewParent a(int i2) {
        if (i2 == 0) {
            return this.f1197a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f1198b;
    }

    public final void a(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f1197a = viewParent;
        } else {
            if (i2 != 1) {
                return;
            }
            this.f1198b = viewParent;
        }
    }

    public final int[] a() {
        if (this.f1201e == null) {
            this.f1201e = new int[2];
        }
        return this.f1201e;
    }
}
