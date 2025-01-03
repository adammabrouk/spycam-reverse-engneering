package a.y.b;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: AnimateLayoutChangeDetector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f1997b;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f1998a;

    /* compiled from: AnimateLayoutChangeDetector.java */
    /* renamed from: a.y.b.a$a, reason: collision with other inner class name */
    public class C0059a implements Comparator<int[]> {
        public C0059a(a aVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f1997b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public a(LinearLayoutManager linearLayoutManager) {
        this.f1998a = linearLayoutManager;
    }

    public final boolean a() {
        int top;
        int i2;
        int bottom;
        int i3;
        int childCount = this.f1998a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f1998a.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, childCount, 2);
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.f1998a.getChildAt(i4);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f1997b;
            int[] iArr2 = iArr[i4];
            if (z) {
                top = childAt.getLeft();
                i2 = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i2 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i2;
            int[] iArr3 = iArr[i4];
            if (z) {
                bottom = childAt.getRight();
                i3 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i3 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i3;
        }
        Arrays.sort(iArr, new C0059a(this));
        for (int i5 = 1; i5 < childCount; i5++) {
            if (iArr[i5 - 1][1] != iArr[i5][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    public final boolean b() {
        int childCount = this.f1998a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (a(this.f1998a.getChildAt(i2))) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return (!a() || this.f1998a.getChildCount() <= 1) && b();
    }

    public static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
