package c.e.b.b;

import android.view.View;

/* compiled from: EmptyAnimator.java */
/* loaded from: classes.dex */
public class b extends c {
    public b(View view) {
        super(view, null);
    }

    @Override // c.e.b.b.c
    public void a() {
        this.f6205a.animate().alpha(0.0f).setDuration(c.e.b.a.a()).withLayer().start();
    }

    @Override // c.e.b.b.c
    public void b() {
        this.f6205a.animate().alpha(1.0f).setDuration(c.e.b.a.a()).withLayer().start();
    }

    @Override // c.e.b.b.c
    public void c() {
        this.f6205a.setAlpha(0.0f);
    }
}
