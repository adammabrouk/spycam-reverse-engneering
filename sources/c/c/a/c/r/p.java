package c.c.a.c.r;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
public class p implements q {

    /* renamed from: a, reason: collision with root package name */
    public final ViewOverlay f5593a;

    public p(View view) {
        this.f5593a = view.getOverlay();
    }

    @Override // c.c.a.c.r.q
    public void a(Drawable drawable) {
        this.f5593a.add(drawable);
    }

    @Override // c.c.a.c.r.q
    public void b(Drawable drawable) {
        this.f5593a.remove(drawable);
    }
}
