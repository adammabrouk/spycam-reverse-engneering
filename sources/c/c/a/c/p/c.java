package c.c.a.c.p;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final View f5483a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5484b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f5485c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f5483a = (View) bVar;
    }

    public void a(Bundle bundle) {
        this.f5484b = bundle.getBoolean("expanded", false);
        this.f5485c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f5484b) {
            a();
        }
    }

    public int b() {
        return this.f5485c;
    }

    public boolean c() {
        return this.f5484b;
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f5484b);
        bundle.putInt("expandedComponentIdHint", this.f5485c);
        return bundle;
    }

    public void a(int i2) {
        this.f5485c = i2;
    }

    public final void a() {
        ViewParent parent = this.f5483a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.f5483a);
        }
    }
}
