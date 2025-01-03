package c.c.a.c.b;

import a.h.j.g0;
import a.h.j.y;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
public abstract class b extends c<View> {

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5340d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f5341e;

    /* renamed from: f, reason: collision with root package name */
    public int f5342f;

    /* renamed from: g, reason: collision with root package name */
    public int f5343g;

    public b() {
        this.f5340d = new Rect();
        this.f5341e = new Rect();
        this.f5342f = 0;
    }

    public static int c(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    public abstract View a(List<View> list);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View a2;
        g0 lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (a2 = a(coordinatorLayout.b(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (y.n(a2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.h() + lastWindowInsets.e();
        }
        int c2 = size + c(a2);
        int measuredHeight = a2.getMeasuredHeight();
        if (e()) {
            view.setTranslationY(-measuredHeight);
        } else {
            c2 -= measuredHeight;
        }
        coordinatorLayout.a(view, i2, i3, View.MeasureSpec.makeMeasureSpec(c2, i6 == -1 ? MemoryConstants.GB : Integer.MIN_VALUE), i5);
        return true;
    }

    public abstract float b(View view);

    @Override // c.c.a.c.b.c
    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 == null) {
            super.b(coordinatorLayout, (CoordinatorLayout) view, i2);
            this.f5342f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f5340d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, a2.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        g0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && y.n(coordinatorLayout) && !y.n(view)) {
            rect.left += lastWindowInsets.f();
            rect.right -= lastWindowInsets.g();
        }
        Rect rect2 = this.f5341e;
        a.h.j.e.a(c(fVar.f2445c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
        int a3 = a(a2);
        view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
        this.f5342f = rect2.top - a2.getBottom();
    }

    public int c(View view) {
        return view.getMeasuredHeight();
    }

    public final int d() {
        return this.f5342f;
    }

    public boolean e() {
        return false;
    }

    public final int c() {
        return this.f5343g;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5340d = new Rect();
        this.f5341e = new Rect();
        this.f5342f = 0;
    }

    public final int a(View view) {
        if (this.f5343g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i2 = this.f5343g;
        return a.h.e.a.a((int) (b2 * i2), 0, i2);
    }

    public final void b(int i2) {
        this.f5343g = i2;
    }
}
