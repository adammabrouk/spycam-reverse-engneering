package a.b.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class l0 extends Resources {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f534b = false;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f535a;

    public l0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f535a = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = this.f535a.get();
        return context != null ? x.a().a(context, this, i2) : super.getDrawable(i2);
    }

    public static boolean a() {
        return f534b;
    }
}
