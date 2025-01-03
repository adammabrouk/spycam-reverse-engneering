package a.t;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
public class k0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewOverlay f1837a;

    public k0(View view) {
        this.f1837a = view.getOverlay();
    }

    @Override // a.t.l0
    public void a(Drawable drawable) {
        this.f1837a.add(drawable);
    }

    @Override // a.t.l0
    public void b(Drawable drawable) {
        this.f1837a.remove(drawable);
    }
}
