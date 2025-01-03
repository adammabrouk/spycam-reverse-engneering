package c.c.a.c.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import com.google.zxing.view.ViewfinderView;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f5313b = new e();

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f5314a;

    public e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f5314a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Build.VERSION.SDK_INT >= 19 ? Integer.valueOf(drawable.getAlpha()) : this.f5314a.containsKey(drawable) ? this.f5314a.get(drawable) : Integer.valueOf(ViewfinderView.OPAQUE);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f5314a.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
