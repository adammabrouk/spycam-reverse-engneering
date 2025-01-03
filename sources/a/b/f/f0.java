package a.b.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
public class f0 extends y {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f482b;

    public f0(Context context, Resources resources) {
        super(resources);
        this.f482b = new WeakReference<>(context);
    }

    @Override // a.b.f.y, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f482b.get();
        if (drawable != null && context != null) {
            x.a().a(context, i2, drawable);
        }
        return drawable;
    }
}
