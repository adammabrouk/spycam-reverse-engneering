package a.p.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: d, reason: collision with root package name */
    public k f1685d;

    /* renamed from: e, reason: collision with root package name */
    public k f1686e;

    @Override // a.p.a.p
    public int[] a(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = a(oVar, view, d(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = a(oVar, view, f(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // a.p.a.p
    public h b(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new a(this.f1692a.getContext());
        }
        return null;
    }

    @Override // a.p.a.p
    public View c(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return a(oVar, f(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return a(oVar, d(oVar));
        }
        return null;
    }

    public final k d(RecyclerView.o oVar) {
        k kVar = this.f1686e;
        if (kVar == null || kVar.f1682a != oVar) {
            this.f1686e = k.a(oVar);
        }
        return this.f1686e;
    }

    public final k e(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return f(oVar);
        }
        if (oVar.canScrollHorizontally()) {
            return d(oVar);
        }
        return null;
    }

    public final k f(RecyclerView.o oVar) {
        k kVar = this.f1685d;
        if (kVar == null || kVar.f1682a != oVar) {
            this.f1685d = k.b(oVar);
        }
        return this.f1685d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean g(RecyclerView.o oVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = oVar.getItemCount();
        if (!(oVar instanceof RecyclerView.y.b) || (computeScrollVectorForPosition = ((RecyclerView.y.b) oVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    /* compiled from: PagerSnapHelper.java */
    public class a extends h {
        public a(Context context) {
            super(context);
        }

        @Override // a.p.a.h, androidx.recyclerview.widget.RecyclerView.y
        public void a(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            l lVar = l.this;
            int[] a2 = lVar.a(lVar.f1692a.getLayoutManager(), view);
            int i2 = a2[0];
            int i3 = a2[1];
            int d2 = d(Math.max(Math.abs(i2), Math.abs(i3)));
            if (d2 > 0) {
                aVar.a(i2, i3, d2, this.j);
            }
        }

        @Override // a.p.a.h
        public int e(int i2) {
            return Math.min(100, super.e(i2));
        }

        @Override // a.p.a.h
        public float a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public final boolean c(RecyclerView.o oVar, int i2, int i3) {
        return oVar.canScrollHorizontally() ? i2 > 0 : i3 > 0;
    }

    @Override // a.p.a.p
    public int a(RecyclerView.o oVar, int i2, int i3) {
        k e2;
        int itemCount = oVar.getItemCount();
        if (itemCount == 0 || (e2 = e(oVar)) == null) {
            return -1;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int childCount = oVar.getChildCount();
        View view = null;
        View view2 = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = oVar.getChildAt(i6);
            if (childAt != null) {
                int a2 = a(oVar, childAt, e2);
                if (a2 <= 0 && a2 > i4) {
                    view2 = childAt;
                    i4 = a2;
                }
                if (a2 >= 0 && a2 < i5) {
                    view = childAt;
                    i5 = a2;
                }
            }
        }
        boolean c2 = c(oVar, i2, i3);
        if (c2 && view != null) {
            return oVar.getPosition(view);
        }
        if (!c2 && view2 != null) {
            return oVar.getPosition(view2);
        }
        if (c2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = oVar.getPosition(view) + (g(oVar) == c2 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    public final int a(RecyclerView.o oVar, View view, k kVar) {
        return (kVar.d(view) + (kVar.b(view) / 2)) - (kVar.f() + (kVar.g() / 2));
    }

    public final View a(RecyclerView.o oVar, k kVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int f2 = kVar.f() + (kVar.g() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = oVar.getChildAt(i3);
            int abs = Math.abs((kVar.d(childAt) + (kVar.b(childAt) / 2)) - f2);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }
}
