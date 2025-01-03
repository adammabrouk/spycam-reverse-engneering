package a.t;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.transition.R$id;
import java.util.ArrayList;

/* compiled from: GhostViewHolder.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class k extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f1835a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1836b;

    public k(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f1835a = viewGroup;
        viewGroup.setTag(R$id.ghost_view_holder, this);
        h0.a(this.f1835a).a(this);
        this.f1836b = true;
    }

    public static k a(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(R$id.ghost_view_holder);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f1836b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f1835a.setTag(R$id.ghost_view_holder, null);
            h0.a(this.f1835a).b(this);
            this.f1836b = false;
        }
    }

    public void a() {
        if (!this.f1836b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        h0.a(this.f1835a).b(this);
        h0.a(this.f1835a).a(this);
    }

    public void a(m mVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        a(mVar.f1847c, arrayList);
        int a2 = a(arrayList);
        if (a2 >= 0 && a2 < getChildCount()) {
            addView(mVar, a2);
        } else {
            addView(mVar);
        }
    }

    public final int a(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (i2 <= childCount) {
            int i3 = (i2 + childCount) / 2;
            a(((m) getChildAt(i3)).f1847c, (ArrayList<View>) arrayList2);
            if (a(arrayList, (ArrayList<View>) arrayList2)) {
                i2 = i3 + 1;
            } else {
                childCount = i3 - 1;
            }
            arrayList2.clear();
        }
        return i2;
    }

    public static boolean a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i2 = 1; i2 < min; i2++) {
            View view = arrayList.get(i2);
            View view2 = arrayList2.get(i2);
            if (view != view2) {
                return a(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    public static void a(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    public static boolean a(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(h0.a(viewGroup, i2));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }
}
