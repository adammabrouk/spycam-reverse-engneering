package c.c.a.b.c.n;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.c.a.b.f.b.d;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public int f3912a;

    public final void a(Context context, Bitmap bitmap, boolean z) {
        c.c.a.b.c.o.b.a(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    public abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public final void a(Context context, d dVar, boolean z) {
        int i2 = this.f3912a;
        a(i2 != 0 ? context.getResources().getDrawable(i2) : null, z, false, false);
    }
}
