package a.y.b;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositeOnPageChangeCallback.java */
/* loaded from: classes.dex */
public final class b extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final List<ViewPager2.i> f1999a;

    public b(int i2) {
        this.f1999a = new ArrayList(i2);
    }

    public void a(ViewPager2.i iVar) {
        this.f1999a.add(iVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i2) {
        try {
            Iterator<ViewPager2.i> it = this.f1999a.iterator();
            while (it.hasNext()) {
                it.next().b(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i2, float f2, int i3) {
        try {
            Iterator<ViewPager2.i> it = this.f1999a.iterator();
            while (it.hasNext()) {
                it.next().a(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i2) {
        try {
            Iterator<ViewPager2.i> it = this.f1999a.iterator();
            while (it.hasNext()) {
                it.next().a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    public final void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
