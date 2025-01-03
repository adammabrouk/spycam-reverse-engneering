package a.b.e.j;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* compiled from: MenuPopup.java */
/* loaded from: classes.dex */
public abstract class k implements p, m, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Rect f391a;

    public static boolean b(g gVar) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i2);

    public abstract void a(g gVar);

    @Override // a.b.e.j.m
    public void a(Context context, g gVar) {
    }

    public void a(Rect rect) {
        this.f391a = rect;
    }

    public abstract void a(View view);

    @Override // a.b.e.j.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    public abstract void b(int i2);

    public abstract void b(boolean z);

    public boolean b() {
        return true;
    }

    @Override // a.b.e.j.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public int c() {
        return 0;
    }

    public abstract void c(int i2);

    public abstract void c(boolean z);

    public Rect h() {
        return this.f391a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f352a.a((MenuItem) listAdapter.getItem(i2), this, b() ? 0 : 4);
    }

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    public static f a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (f) listAdapter;
    }
}
