package androidx.appcompat.view.menu;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.n;
import a.b.f.g0;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2167c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public g f2168a;

    /* renamed from: b, reason: collision with root package name */
    public int f2169b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // a.b.e.j.n
    public void a(g gVar) {
        this.f2168a = gVar;
    }

    public int getWindowAnimations() {
        return this.f2169b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        a((i) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        g0 a2 = g0.a(context, attributeSet, f2167c, i2, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.b();
    }

    @Override // a.b.e.j.g.b
    public boolean a(i iVar) {
        return this.f2168a.a(iVar, 0);
    }
}
