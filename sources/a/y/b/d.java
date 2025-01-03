package a.y.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: PageTransformerAdapter.java */
/* loaded from: classes.dex */
public final class d extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f2001a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager2.k f2002b;

    public d(LinearLayoutManager linearLayoutManager) {
        this.f2001a = linearLayoutManager;
    }

    public ViewPager2.k a() {
        return this.f2002b;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i2) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i2) {
    }

    public void a(ViewPager2.k kVar) {
        this.f2002b = kVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i2, float f2, int i3) {
        if (this.f2002b == null) {
            return;
        }
        float f3 = -f2;
        for (int i4 = 0; i4 < this.f2001a.getChildCount(); i4++) {
            View childAt = this.f2001a.getChildAt(i4);
            if (childAt != null) {
                this.f2002b.a(childAt, (this.f2001a.getPosition(childAt) - i2) + f3);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.f2001a.getChildCount())));
            }
        }
    }
}
