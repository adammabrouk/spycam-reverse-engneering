package com.google.android.material.transformation;

import a.h.j.y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.p.b;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    public int f10676a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10677a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10678b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f10679c;

        public a(View view, int i2, b bVar) {
            this.f10677a = view;
            this.f10678b = i2;
            this.f10679c = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f10677a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f10676a == this.f10678b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f10679c;
                expandableBehavior.a((View) bVar, this.f10677a, bVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f10676a = 0;
    }

    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f10676a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = b2.get(i2);
            if (a(coordinatorLayout, (CoordinatorLayout) view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
        b e2;
        if (y.J(view) || (e2 = e(coordinatorLayout, view)) == null || !a(e2.a())) {
            return false;
        }
        int i3 = e2.a() ? 1 : 2;
        this.f10676a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, e2));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10676a = 0;
    }

    public final boolean a(boolean z) {
        if (!z) {
            return this.f10676a == 1;
        }
        int i2 = this.f10676a;
        return i2 == 0 || i2 == 2;
    }
}
