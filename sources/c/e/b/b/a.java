package c.e.b.b;

import android.animation.FloatEvaluator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/* compiled from: BlurAnimator.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f6203c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6204d;

    public a(View view) {
        super(view);
        new FloatEvaluator();
        this.f6204d = false;
    }

    @Override // c.e.b.b.c
    public void a() {
    }

    @Override // c.e.b.b.c
    public void b() {
    }

    @Override // c.e.b.b.c
    public void c() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f6205a.getResources(), c.e.b.g.e.a(this.f6205a.getContext(), this.f6203c, 25.0f, true));
        if (this.f6204d) {
            bitmapDrawable.setColorFilter(c.e.b.a.c(), PorterDuff.Mode.SRC_OVER);
        }
        this.f6205a.setBackground(bitmapDrawable);
    }
}
