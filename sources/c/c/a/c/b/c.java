package c.c.a.c.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public d f5344a;

    /* renamed from: b, reason: collision with root package name */
    public int f5345b;

    /* renamed from: c, reason: collision with root package name */
    public int f5346c;

    public c() {
        this.f5345b = 0;
        this.f5346c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        b(coordinatorLayout, (CoordinatorLayout) v, i2);
        if (this.f5344a == null) {
            this.f5344a = new d(v);
        }
        this.f5344a.d();
        this.f5344a.a();
        int i3 = this.f5345b;
        if (i3 != 0) {
            this.f5344a.b(i3);
            this.f5345b = 0;
        }
        int i4 = this.f5346c;
        if (i4 == 0) {
            return true;
        }
        this.f5344a.a(i4);
        this.f5346c = 0;
        return true;
    }

    public void b(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.d(v, i2);
    }

    public int b() {
        d dVar = this.f5344a;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5345b = 0;
        this.f5346c = 0;
    }

    public boolean a(int i2) {
        d dVar = this.f5344a;
        if (dVar != null) {
            return dVar.b(i2);
        }
        this.f5345b = i2;
        return false;
    }
}
