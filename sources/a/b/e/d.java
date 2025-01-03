package a.b.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public int f257a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f258b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f259c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f260d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f261e;

    public d() {
        super(null);
    }

    public void a(Configuration configuration) {
        if (this.f261e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f260d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f260d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f257a;
    }

    public final void c() {
        boolean z = this.f258b == null;
        if (z) {
            this.f258b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f258b.setTo(theme);
            }
        }
        a(this.f258b, this.f257a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f259c == null) {
            this.f259c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f259c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f258b;
        if (theme != null) {
            return theme;
        }
        if (this.f257a == 0) {
            this.f257a = R$style.Theme_AppCompat_Light;
        }
        c();
        return this.f258b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.f257a != i2) {
            this.f257a = i2;
            c();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f257a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f258b = theme;
    }

    public final Resources a() {
        if (this.f261e == null) {
            Configuration configuration = this.f260d;
            if (configuration == null) {
                this.f261e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f261e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f260d);
                this.f261e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f261e;
    }

    public void a(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }
}
