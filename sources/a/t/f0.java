package a.t;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
public class f0 implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f1805a;

    public f0(ViewGroup viewGroup) {
        this.f1805a = viewGroup.getOverlay();
    }

    @Override // a.t.l0
    public void a(Drawable drawable) {
        this.f1805a.add(drawable);
    }

    @Override // a.t.l0
    public void b(Drawable drawable) {
        this.f1805a.remove(drawable);
    }

    @Override // a.t.g0
    public void a(View view) {
        this.f1805a.add(view);
    }

    @Override // a.t.g0
    public void b(View view) {
        this.f1805a.remove(view);
    }
}
