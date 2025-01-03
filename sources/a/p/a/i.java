package a.p.a;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSnapHelper.java */
/* loaded from: classes.dex */
public class i extends p {

    /* renamed from: d, reason: collision with root package name */
    public k f1679d;

    /* renamed from: e, reason: collision with root package name */
    public k f1680e;

    @Override // a.p.a.p
    public int[] a(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = a(oVar, view, d(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = a(oVar, view, e(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final View b(RecyclerView.o oVar, k kVar) {
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

    @Override // a.p.a.p
    public View c(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return b(oVar, e(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return b(oVar, d(oVar));
        }
        return null;
    }

    public final k d(RecyclerView.o oVar) {
        k kVar = this.f1680e;
        if (kVar == null || kVar.f1682a != oVar) {
            this.f1680e = k.a(oVar);
        }
        return this.f1680e;
    }

    public final k e(RecyclerView.o oVar) {
        k kVar = this.f1679d;
        if (kVar == null || kVar.f1682a != oVar) {
            this.f1679d = k.b(oVar);
        }
        return this.f1679d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.p.a.p
    public int a(RecyclerView.o oVar, int i2, int i3) {
        int itemCount;
        View c2;
        int position;
        int i4;
        PointF computeScrollVectorForPosition;
        int i5;
        int i6;
        if (!(oVar instanceof RecyclerView.y.b) || (itemCount = oVar.getItemCount()) == 0 || (c2 = c(oVar)) == null || (position = oVar.getPosition(c2)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.y.b) oVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (oVar.canScrollHorizontally()) {
            i5 = a(oVar, d(oVar), i2, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (oVar.canScrollVertically()) {
            i6 = a(oVar, e(oVar), 0, i3);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (oVar.canScrollVertically()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i7 = position + i5;
        int i8 = i7 >= 0 ? i7 : 0;
        return i8 >= itemCount ? i4 : i8;
    }

    public final int a(RecyclerView.o oVar, View view, k kVar) {
        return (kVar.d(view) + (kVar.b(view) / 2)) - (kVar.f() + (kVar.g() / 2));
    }

    public final int a(RecyclerView.o oVar, k kVar, int i2, int i3) {
        int[] b2 = b(i2, i3);
        float a2 = a(oVar, kVar);
        if (a2 <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(b2[0]) > Math.abs(b2[1]) ? b2[0] : b2[1]) / a2);
    }

    public final float a(RecyclerView.o oVar, k kVar) {
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = oVar.getChildAt(i4);
            int position = oVar.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i3) {
                    view2 = childAt;
                    i3 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(kVar.a(view), kVar.a(view2)) - Math.min(kVar.d(view), kVar.d(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i3 - i2) + 1);
    }
}
