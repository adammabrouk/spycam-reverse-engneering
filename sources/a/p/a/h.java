package a.p.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.y {
    public PointF k;
    public final DisplayMetrics l;
    public float n;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f1678i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public boolean m = false;
    public int o = 0;
    public int p = 0;

    public h(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void a(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int a2 = a(view, i());
        int b2 = b(view, k());
        int d2 = d((int) Math.sqrt((a2 * a2) + (b2 * b2)));
        if (d2 > 0) {
            aVar.a(-a2, -b2, d2, this.j);
        }
    }

    public final int b(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    public int b(View view, int i2) {
        RecyclerView.o b2 = b();
        if (b2 == null || !b2.canScrollVertically()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return a(b2.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, b2.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, b2.getPaddingTop(), b2.getHeight() - b2.getPaddingBottom(), i2);
    }

    public int d(int i2) {
        double e2 = e(i2);
        Double.isNaN(e2);
        return (int) Math.ceil(e2 / 0.3356d);
    }

    public int e(int i2) {
        return (int) Math.ceil(Math.abs(i2) * j());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void f() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void g() {
        this.p = 0;
        this.o = 0;
        this.k = null;
    }

    public int i() {
        PointF pointF = this.k;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public final float j() {
        if (!this.m) {
            this.n = a(this.l);
            this.m = true;
        }
        return this.n;
    }

    public int k() {
        PointF pointF = this.k;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void a(int i2, int i3, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (a() == 0) {
            h();
            return;
        }
        this.o = b(this.o, i2);
        int b2 = b(this.p, i3);
        this.p = b2;
        if (this.o == 0 && b2 == 0) {
            a(aVar);
        }
    }

    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public void a(RecyclerView.y.a aVar) {
        PointF a2 = a(c());
        if (a2 != null && (a2.x != 0.0f || a2.y != 0.0f)) {
            a(a2);
            this.k = a2;
            this.o = (int) (a2.x * 10000.0f);
            this.p = (int) (a2.y * 10000.0f);
            aVar.a((int) (this.o * 1.2f), (int) (this.p * 1.2f), (int) (e(10000) * 1.2f), this.f1678i);
            return;
        }
        aVar.a(c());
        h();
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 != 0) {
            if (i6 == 1) {
                return i5 - i3;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i7 = i4 - i2;
        if (i7 > 0) {
            return i7;
        }
        int i8 = i5 - i3;
        if (i8 < 0) {
            return i8;
        }
        return 0;
    }

    public int a(View view, int i2) {
        RecyclerView.o b2 = b();
        if (b2 == null || !b2.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return a(b2.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, b2.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, b2.getPaddingLeft(), b2.getWidth() - b2.getPaddingRight(), i2);
    }
}
