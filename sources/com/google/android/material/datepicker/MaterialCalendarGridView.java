package com.google.android.material.datepicker;

import a.h.i.d;
import a.h.j.h0.c;
import a.h.j.y;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.c.a.c.l.b;
import c.c.a.c.l.g;
import c.c.a.c.l.j;
import c.c.a.c.l.p;
import com.google.android.material.R$id;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10472a;

    public class a extends a.h.j.a {
        public a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // a.h.j.a
        public void a(View view, c cVar) {
            super.a(view, cVar);
            cVar.a((Object) null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public final void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter().b());
        } else if (i2 == 130) {
            setSelection(getAdapter().a());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int a2;
        int a3;
        int a4;
        int a5;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        j adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f5455b;
        b bVar = adapter.f5456c;
        Long item = adapter.getItem(adapter.a());
        Long item2 = adapter.getItem(adapter.b());
        for (d<Long, Long> dVar : dateSelector.b()) {
            Long l = dVar.f1104a;
            if (l != null) {
                if (dVar.f1105b == null) {
                    continue;
                } else {
                    long longValue = l.longValue();
                    long longValue2 = dVar.f1105b.longValue();
                    if (a(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        return;
                    }
                    if (longValue < item.longValue()) {
                        a2 = adapter.a();
                        a3 = adapter.b(a2) ? 0 : materialCalendarGridView.getChildAt(a2 - 1).getRight();
                    } else {
                        materialCalendarGridView.f10472a.setTimeInMillis(longValue);
                        a2 = adapter.a(materialCalendarGridView.f10472a.get(5));
                        a3 = a(materialCalendarGridView.getChildAt(a2));
                    }
                    if (longValue2 > item2.longValue()) {
                        a4 = Math.min(adapter.b(), getChildCount() - 1);
                        a5 = adapter.c(a4) ? getWidth() : materialCalendarGridView.getChildAt(a4).getRight();
                    } else {
                        materialCalendarGridView.f10472a.setTimeInMillis(longValue2);
                        a4 = adapter.a(materialCalendarGridView.f10472a.get(5));
                        a5 = a(materialCalendarGridView.getChildAt(a4));
                    }
                    int itemId = (int) adapter.getItemId(a2);
                    int itemId2 = (int) adapter.getItemId(a4);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > a2 ? 0 : a3, childAt.getTop() + bVar.f5403a.b(), a4 > numColumns2 ? getWidth() : a5, childAt.getBottom() - bVar.f5403a.a(), bVar.f5410h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().a()) {
            super.setSelection(getAdapter().a());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof j)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10472a = p.f();
        if (g.f(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        y.a(this, new a(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public ListAdapter getAdapter2() {
        return (j) super.getAdapter();
    }

    public static boolean a(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    public static int a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
