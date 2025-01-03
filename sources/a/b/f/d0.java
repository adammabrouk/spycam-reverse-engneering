package a.b.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class d0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f459c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<d0>> f460d;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f461a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f462b;

    public d0(Context context) {
        super(context);
        if (!l0.b()) {
            this.f461a = new f0(this, context.getResources());
            this.f462b = null;
            return;
        }
        l0 l0Var = new l0(this, context.getResources());
        this.f461a = l0Var;
        Resources.Theme newTheme = l0Var.newTheme();
        this.f462b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof d0) || (context.getResources() instanceof f0) || (context.getResources() instanceof l0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || l0.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f459c) {
            if (f460d == null) {
                f460d = new ArrayList<>();
            } else {
                for (int size = f460d.size() - 1; size >= 0; size--) {
                    WeakReference<d0> weakReference = f460d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f460d.remove(size);
                    }
                }
                for (int size2 = f460d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<d0> weakReference2 = f460d.get(size2);
                    d0 d0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (d0Var != null && d0Var.getBaseContext() == context) {
                        return d0Var;
                    }
                }
            }
            d0 d0Var2 = new d0(context);
            f460d.add(new WeakReference<>(d0Var2));
            return d0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f461a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f461a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f462b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f462b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
