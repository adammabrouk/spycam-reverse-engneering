package androidx.appcompat.app;

import a.b.e.b;
import a.b.e.f;
import a.b.e.j.g;
import a.b.e.j.m;
import a.b.f.l0;
import a.b.f.m0;
import a.b.f.t;
import a.h.b.d.f;
import a.h.j.c0;
import a.h.j.d0;
import a.h.j.e0;
import a.h.j.f;
import a.h.j.g0;
import a.h.j.y;
import a.m.f;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends a.b.a.e implements g.a, LayoutInflater.Factory2 {
    public static final a.e.g<String, Integer> c0 = new a.e.g<>();
    public static final boolean d0;
    public static final int[] e0;
    public static final boolean f0;
    public static final boolean g0;
    public static boolean h0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public PanelFeatureState[] H;
    public PanelFeatureState I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public q S;
    public q T;
    public boolean U;
    public int V;
    public final Runnable W;
    public boolean X;
    public Rect Y;
    public Rect Z;
    public a.b.a.g a0;
    public a.b.a.h b0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2123d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f2124e;

    /* renamed from: f, reason: collision with root package name */
    public Window f2125f;

    /* renamed from: g, reason: collision with root package name */
    public o f2126g;

    /* renamed from: h, reason: collision with root package name */
    public final a.b.a.d f2127h;

    /* renamed from: i, reason: collision with root package name */
    public a.b.a.a f2128i;
    public MenuInflater j;
    public CharSequence k;
    public a.b.f.p l;
    public i m;
    public u n;
    public a.b.e.b o;
    public ActionBarContextView p;
    public PopupWindow q;
    public Runnable r;
    public c0 t;
    public boolean u;
    public boolean v;
    public ViewGroup w;
    public TextView x;
    public View y;
    public boolean z;

    public class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f2141a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f2141a = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f2141a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f2141a.uncaughtException(thread, notFoundException);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.V & 1) != 0) {
                appCompatDelegateImpl.f(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.V & 4096) != 0) {
                appCompatDelegateImpl2.f(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.U = false;
            appCompatDelegateImpl3.V = 0;
        }
    }

    public class c implements a.h.j.s {
        public c() {
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            int h2 = g0Var.h();
            int a2 = AppCompatDelegateImpl.this.a(g0Var, (Rect) null);
            if (h2 != a2) {
                g0Var = g0Var.b(g0Var.f(), a2, g0Var.g(), g0Var.e());
            }
            return y.b(view, g0Var);
        }
    }

    public class d implements t.a {
        public d() {
        }

        @Override // a.b.f.t.a
        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.a((g0) null, rect);
        }
    }

    public class e implements ContentFrameLayout.a {
        public e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.q();
        }
    }

    public class f implements Runnable {

        public class a extends e0 {
            public a() {
            }

            @Override // a.h.j.d0
            public void b(View view) {
                AppCompatDelegateImpl.this.p.setAlpha(1.0f);
                AppCompatDelegateImpl.this.t.a((d0) null);
                AppCompatDelegateImpl.this.t = null;
            }

            @Override // a.h.j.e0, a.h.j.d0
            public void c(View view) {
                AppCompatDelegateImpl.this.p.setVisibility(0);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.q.showAtLocation(appCompatDelegateImpl.p, 55, 0, 0);
            AppCompatDelegateImpl.this.r();
            if (!AppCompatDelegateImpl.this.C()) {
                AppCompatDelegateImpl.this.p.setAlpha(1.0f);
                AppCompatDelegateImpl.this.p.setVisibility(0);
                return;
            }
            AppCompatDelegateImpl.this.p.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            c0 a2 = y.a(appCompatDelegateImpl2.p);
            a2.a(1.0f);
            appCompatDelegateImpl2.t = a2;
            AppCompatDelegateImpl.this.t.a(new a());
        }
    }

    public class g extends e0 {
        public g() {
        }

        @Override // a.h.j.d0
        public void b(View view) {
            AppCompatDelegateImpl.this.p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.t.a((d0) null);
            AppCompatDelegateImpl.this.t = null;
        }

        @Override // a.h.j.e0, a.h.j.d0
        public void c(View view) {
            AppCompatDelegateImpl.this.p.setVisibility(0);
            AppCompatDelegateImpl.this.p.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.p.getParent() instanceof View) {
                y.O((View) AppCompatDelegateImpl.this.p.getParent());
            }
        }
    }

    public class h implements a.b.a.b {
        public h(AppCompatDelegateImpl appCompatDelegateImpl) {
        }
    }

    public static class l {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    public static class m {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    public static class n {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.colorMode & 3;
            int i3 = configuration2.colorMode;
            if (i2 != (i3 & 3)) {
                configuration3.colorMode |= i3 & 3;
            }
            int i4 = configuration.colorMode & 12;
            int i5 = configuration2.colorMode;
            if (i4 != (i5 & 12)) {
                configuration3.colorMode |= i5 & 12;
            }
        }
    }

    public class p extends q {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f2154c;

        public p(Context context) {
            super();
            this.f2154c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !l.a(this.f2154c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public void d() {
            AppCompatDelegateImpl.this.l();
        }
    }

    public abstract class q {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f2156a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                q.this.d();
            }
        }

        public q() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f2156a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f2124e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f2156a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.f2156a == null) {
                this.f2156a = new a();
            }
            AppCompatDelegateImpl.this.f2124e.registerReceiver(this.f2156a, b2);
        }
    }

    public class r extends q {

        /* renamed from: c, reason: collision with root package name */
        public final a.b.a.l f2159c;

        public r(a.b.a.l lVar) {
            super();
            this.f2159c = lVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public int c() {
            return this.f2159c.b() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.q
        public void d() {
            AppCompatDelegateImpl.this.l();
        }
    }

    public static class s {
        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class t extends ContentFrameLayout {
        public t(Context context) {
            super(context);
        }

        public final boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.e(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(a.b.b.a.a.c(getContext(), i2));
        }
    }

    static {
        d0 = Build.VERSION.SDK_INT < 21;
        e0 = new int[]{R.attr.windowBackground};
        f0 = !"robolectric".equals(Build.FINGERPRINT);
        g0 = Build.VERSION.SDK_INT >= 17;
        if (!d0 || h0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        h0 = true;
    }

    public AppCompatDelegateImpl(Activity activity, a.b.a.d dVar) {
        this(activity, null, dVar, activity);
    }

    public boolean A() {
        a.b.e.b bVar = this.o;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        a.b.a.a d2 = d();
        return d2 != null && d2.f();
    }

    public final a.b.a.a B() {
        return this.f2128i;
    }

    public final boolean C() {
        ViewGroup viewGroup;
        return this.v && (viewGroup = this.w) != null && y.J(viewGroup);
    }

    public final void D() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final AppCompatActivity E() {
        for (Context context = this.f2124e; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    @Override // a.b.a.e
    public void a(Bundle bundle) {
        this.K = true;
        a(false);
        t();
        Object obj = this.f2123d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = a.h.a.e.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a.b.a.a B = B();
                if (B == null) {
                    this.X = true;
                } else {
                    B.c(true);
                }
            }
            a.b.a.e.a(this);
        }
        this.L = true;
    }

    public void a(ViewGroup viewGroup) {
    }

    @Override // a.b.a.e
    public Context b(Context context) {
        this.K = true;
        int a2 = a(context, n());
        Configuration configuration = null;
        if (g0 && (context instanceof ContextThemeWrapper)) {
            try {
                s.a((ContextThemeWrapper) context, a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof a.b.e.d) {
            try {
                ((a.b.e.d) context).a(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f0) {
            super.b(context);
            return context;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = k.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = a(configuration3, configuration4);
            }
        }
        Configuration a3 = a(context, a2, configuration);
        a.b.e.d dVar = new a.b.e.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(a3);
        boolean z = false;
        try {
            z = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z) {
            f.b.a(dVar.getTheme());
        }
        super.b(dVar);
        return dVar;
    }

    @Override // a.b.a.e
    public MenuInflater c() {
        if (this.j == null) {
            x();
            a.b.a.a aVar = this.f2128i;
            this.j = new a.b.e.g(aVar != null ? aVar.h() : this.f2124e);
        }
        return this.j;
    }

    @Override // a.b.a.e
    public void c(Bundle bundle) {
    }

    @Override // a.b.a.e
    public a.b.a.a d() {
        x();
        return this.f2128i;
    }

    @Override // a.b.a.e
    public void e() {
        LayoutInflater from = LayoutInflater.from(this.f2124e);
        if (from.getFactory() == null) {
            a.h.j.g.b(from, this);
        } else {
            if (from.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // a.b.a.e
    public void f() {
        a.b.a.a d2 = d();
        if (d2 == null || !d2.i()) {
            g(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    @Override // a.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2123d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            a.b.a.e.b(r3)
        L9:
            boolean r0 = r3.U
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f2125f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.W
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.M = r0
            r0 = 1
            r3.N = r0
            int r0 = r3.O
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.f2123d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            a.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.c0
            java.lang.Object r1 = r3.f2123d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.O
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            a.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.c0
            java.lang.Object r1 = r3.f2123d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            a.b.a.a r0 = r3.f2128i
            if (r0 == 0) goto L5e
            r0.j()
        L5e:
            r3.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.g():void");
    }

    @Override // a.b.a.e
    public void h() {
        a.b.a.a d2 = d();
        if (d2 != null) {
            d2.d(true);
        }
    }

    @Override // a.b.a.e
    public void i() {
        this.M = true;
        l();
    }

    @Override // a.b.a.e
    public void j() {
        this.M = false;
        a.b.a.a d2 = d();
        if (d2 != null) {
            d2.d(false);
        }
    }

    public boolean l() {
        return a(true);
    }

    public final void m() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(R.id.content);
        View decorView = this.f2125f.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f2124e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final int n() {
        int i2 = this.O;
        return i2 != -100 ? i2 : a.b.a.e.k();
    }

    public final void o() {
        q qVar = this.S;
        if (qVar != null) {
            qVar.a();
        }
        q qVar2 = this.T;
        if (qVar2 != null) {
            qVar2.a();
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public final ViewGroup p() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f2124e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            b(1);
        } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            b(108);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            b(109);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            b(10);
        }
        this.E = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        t();
        this.f2125f.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f2124e);
        if (this.F) {
            viewGroup = this.D ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.E) {
            viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.C = false;
            this.B = false;
        } else if (this.B) {
            TypedValue typedValue = new TypedValue();
            this.f2124e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new a.b.e.d(this.f2124e, typedValue.resourceId) : this.f2124e).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            a.b.f.p pVar = (a.b.f.p) viewGroup.findViewById(R$id.decor_content_parent);
            this.l = pVar;
            pVar.setWindowCallback(w());
            if (this.C) {
                this.l.a(109);
            }
            if (this.z) {
                this.l.a(2);
            }
            if (this.A) {
                this.l.a(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            y.a(viewGroup, new c());
        } else if (viewGroup instanceof a.b.f.t) {
            ((a.b.f.t) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.l == null) {
            this.x = (TextView) viewGroup.findViewById(R$id.title);
        }
        m0.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2125f.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2125f.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    public void q() {
        a.b.e.j.g gVar;
        a.b.f.p pVar = this.l;
        if (pVar != null) {
            pVar.g();
        }
        if (this.q != null) {
            this.f2125f.getDecorView().removeCallbacks(this.r);
            if (this.q.isShowing()) {
                try {
                    this.q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.q = null;
        }
        r();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || (gVar = a2.j) == null) {
            return;
        }
        gVar.close();
    }

    public void r() {
        c0 c0Var = this.t;
        if (c0Var != null) {
            c0Var.a();
        }
    }

    public final void s() {
        if (this.v) {
            return;
        }
        this.w = p();
        CharSequence v = v();
        if (!TextUtils.isEmpty(v)) {
            a.b.f.p pVar = this.l;
            if (pVar != null) {
                pVar.setWindowTitle(v);
            } else if (B() != null) {
                B().a(v);
            } else {
                TextView textView = this.x;
                if (textView != null) {
                    textView.setText(v);
                }
            }
        }
        m();
        a(this.w);
        this.v = true;
        PanelFeatureState a2 = a(0, false);
        if (this.N) {
            return;
        }
        if (a2 == null || a2.j == null) {
            g(108);
        }
    }

    public final void t() {
        if (this.f2125f == null) {
            Object obj = this.f2123d;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f2125f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context u() {
        a.b.a.a d2 = d();
        Context h2 = d2 != null ? d2.h() : null;
        return h2 == null ? this.f2124e : h2;
    }

    public final CharSequence v() {
        Object obj = this.f2123d;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.k;
    }

    public final Window.Callback w() {
        return this.f2125f.getCallback();
    }

    public final void x() {
        s();
        if (this.B && this.f2128i == null) {
            Object obj = this.f2123d;
            if (obj instanceof Activity) {
                this.f2128i = new a.b.a.m((Activity) this.f2123d, this.C);
            } else if (obj instanceof Dialog) {
                this.f2128i = new a.b.a.m((Dialog) this.f2123d);
            }
            a.b.a.a aVar = this.f2128i;
            if (aVar != null) {
                aVar.c(this.X);
            }
        }
    }

    public final boolean y() {
        if (!this.R && (this.f2123d instanceof Activity)) {
            PackageManager packageManager = this.f2124e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f2124e, this.f2123d.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    public boolean z() {
        return this.u;
    }

    public final class i implements m.a {
        public i() {
        }

        @Override // a.b.e.j.m.a
        public boolean a(a.b.e.j.g gVar) {
            Window.Callback w = AppCompatDelegateImpl.this.w();
            if (w == null) {
                return true;
            }
            w.onMenuOpened(108, gVar);
            return true;
        }

        @Override // a.b.e.j.m.a
        public void a(a.b.e.j.g gVar, boolean z) {
            AppCompatDelegateImpl.this.b(gVar);
        }
    }

    public class j implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public b.a f2150a;

        public class a extends e0 {
            public a() {
            }

            @Override // a.h.j.d0
            public void b(View view) {
                AppCompatDelegateImpl.this.p.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.p.getParent() instanceof View) {
                    y.O((View) AppCompatDelegateImpl.this.p.getParent());
                }
                AppCompatDelegateImpl.this.p.d();
                AppCompatDelegateImpl.this.t.a((d0) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.t = null;
                y.O(appCompatDelegateImpl2.w);
            }
        }

        public j(b.a aVar) {
            this.f2150a = aVar;
        }

        @Override // a.b.e.b.a
        public boolean a(a.b.e.b bVar, Menu menu) {
            y.O(AppCompatDelegateImpl.this.w);
            return this.f2150a.a(bVar, menu);
        }

        @Override // a.b.e.b.a
        public boolean b(a.b.e.b bVar, Menu menu) {
            return this.f2150a.b(bVar, menu);
        }

        @Override // a.b.e.b.a
        public boolean a(a.b.e.b bVar, MenuItem menuItem) {
            return this.f2150a.a(bVar, menuItem);
        }

        @Override // a.b.e.b.a
        public void a(a.b.e.b bVar) {
            this.f2150a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.q != null) {
                appCompatDelegateImpl.f2125f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.r);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.p != null) {
                appCompatDelegateImpl2.r();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                c0 a2 = y.a(appCompatDelegateImpl3.p);
                a2.a(0.0f);
                appCompatDelegateImpl3.t = a2;
                AppCompatDelegateImpl.this.t.a(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            a.b.a.d dVar = appCompatDelegateImpl4.f2127h;
            if (dVar != null) {
                dVar.onSupportActionModeFinished(appCompatDelegateImpl4.o);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.o = null;
            y.O(appCompatDelegateImpl5.w);
        }
    }

    public static class k {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }

        public static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }
    }

    public AppCompatDelegateImpl(Dialog dialog, a.b.a.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f2129a;

        /* renamed from: b, reason: collision with root package name */
        public int f2130b;

        /* renamed from: c, reason: collision with root package name */
        public int f2131c;

        /* renamed from: d, reason: collision with root package name */
        public int f2132d;

        /* renamed from: e, reason: collision with root package name */
        public int f2133e;

        /* renamed from: f, reason: collision with root package name */
        public int f2134f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f2135g;

        /* renamed from: h, reason: collision with root package name */
        public View f2136h;

        /* renamed from: i, reason: collision with root package name */
        public View f2137i;
        public a.b.e.j.g j;
        public a.b.e.j.e k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            public int f2138a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f2139b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f2140c;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }
            }

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f2138a = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.f2139b = z;
                if (z) {
                    savedState.f2140c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f2138a);
                parcel.writeInt(this.f2139b ? 1 : 0);
                if (this.f2139b) {
                    parcel.writeBundle(this.f2140c);
                }
            }
        }

        public PanelFeatureState(int i2) {
            this.f2129a = i2;
        }

        public boolean a() {
            if (this.f2136h == null) {
                return false;
            }
            return this.f2137i != null || this.k.a().getCount() > 0;
        }

        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            a.b.e.d dVar = new a.b.e.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f2130b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f2134f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void a(a.b.e.j.g gVar) {
            a.b.e.j.e eVar;
            a.b.e.j.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.b(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.a(eVar);
        }

        public a.b.e.j.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                a.b.e.j.e eVar = new a.b.e.j.e(this.l, R$layout.abc_list_menu_item_layout);
                this.k = eVar;
                eVar.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.f2135g);
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, a.b.a.d dVar, Object obj) {
        Integer num;
        AppCompatActivity E;
        this.t = null;
        this.u = true;
        this.O = -100;
        this.W = new b();
        this.f2124e = context;
        this.f2127h = dVar;
        this.f2123d = obj;
        if (this.O == -100 && (obj instanceof Dialog) && (E = E()) != null) {
            this.O = E.getDelegate().b();
        }
        if (this.O == -100 && (num = c0.get(this.f2123d.getClass().getName())) != null) {
            this.O = num.intValue();
            c0.remove(this.f2123d.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        a.b.f.f.c();
    }

    @Override // a.b.a.e
    public void d(int i2) {
        this.P = i2;
    }

    public void h(int i2) {
        a.b.a.a d2;
        if (i2 != 108 || (d2 = d()) == null) {
            return;
        }
        d2.b(true);
    }

    public void i(int i2) {
        if (i2 == 108) {
            a.b.a.a d2 = d();
            if (d2 != null) {
                d2.b(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            PanelFeatureState a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    public class o extends a.b.e.i {
        public o(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f2124e, callback);
            a.b.e.b a2 = AppCompatDelegateImpl.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.c(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof a.b.e.j.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl.this.h(i2);
            return true;
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.i(i2);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            a.b.e.j.g gVar = menu instanceof a.b.e.j.g ? (a.b.e.j.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.d(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.d(false);
            }
            return onPreparePanel;
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            a.b.e.j.g gVar;
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 == null || (gVar = a2.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i2);
            }
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.z() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (AppCompatDelegateImpl.this.z() && i2 == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }

    public boolean d(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.J;
            this.J = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            }
            if (A()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    public void f(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.e(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 != 108 && i2 != 0) || this.l == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    public final int j(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    public final class u implements m.a {
        public u() {
        }

        @Override // a.b.e.j.m.a
        public void a(a.b.e.j.g gVar, boolean z) {
            a.b.e.j.g m = gVar.m();
            boolean z2 = m != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                gVar = m;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) gVar);
            if (a2 != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.a(a2, z);
                } else {
                    AppCompatDelegateImpl.this.a(a2.f2129a, a2, m);
                    AppCompatDelegateImpl.this.a(a2, true);
                }
            }
        }

        @Override // a.b.e.j.m.a
        public boolean a(a.b.e.j.g gVar) {
            Window.Callback w;
            if (gVar != gVar.m()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.B || (w = appCompatDelegateImpl.w()) == null || AppCompatDelegateImpl.this.N) {
                return true;
            }
            w.onMenuOpened(108, gVar);
            return true;
        }
    }

    @Override // a.b.a.e
    public void c(int i2) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2124e).inflate(i2, viewGroup);
        this.f2126g.a().onContentChanged();
    }

    public void e(int i2) {
        a(a(i2, true), true);
    }

    public final boolean e(int i2, KeyEvent keyEvent) {
        boolean z;
        a.b.f.p pVar;
        if (this.o != null) {
            return false;
        }
        boolean z2 = true;
        PanelFeatureState a2 = a(i2, true);
        if (i2 == 0 && (pVar = this.l) != null && pVar.f() && !ViewConfiguration.get(this.f2124e).hasPermanentMenuKey()) {
            if (!this.l.a()) {
                if (!this.N && b(a2, keyEvent)) {
                    z2 = this.l.e();
                }
                z2 = false;
            } else {
                z2 = this.l.d();
            }
        } else if (!a2.o && !a2.n) {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z = b(a2, keyEvent);
                } else {
                    z = true;
                }
                if (z) {
                    a(a2, keyEvent);
                }
            }
            z2 = false;
        } else {
            boolean z3 = a2.o;
            a(a2, true);
            z2 = z3;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f2124e.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    @Override // a.b.a.e
    public void a(Toolbar toolbar) {
        if (this.f2123d instanceof Activity) {
            a.b.a.a d2 = d();
            if (!(d2 instanceof a.b.a.m)) {
                this.j = null;
                if (d2 != null) {
                    d2.j();
                }
                if (toolbar != null) {
                    a.b.a.j jVar = new a.b.a.j(toolbar, v(), this.f2126g);
                    this.f2128i = jVar;
                    this.f2125f.setCallback(jVar.m());
                } else {
                    this.f2128i = null;
                    this.f2125f.setCallback(this.f2126g);
                }
                f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public boolean c(int i2, KeyEvent keyEvent) {
        a.b.a.a d2 = d();
        if (d2 != null && d2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.I;
        if (panelFeatureState != null && a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.I;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.I == null) {
            PanelFeatureState a2 = a(0, true);
            b(a2, keyEvent);
            boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
            a2.m = false;
            if (a3) {
                return true;
            }
        }
        return false;
    }

    public final q d(Context context) {
        if (this.S == null) {
            this.S = new r(a.b.a.l.a(context));
        }
        return this.S;
    }

    public final void g(int i2) {
        this.V = (1 << i2) | this.V;
        if (this.U) {
            return;
        }
        y.a(this.f2125f.getDecorView(), this.W);
        this.U = true;
    }

    public final boolean c(PanelFeatureState panelFeatureState) {
        Context context = this.f2124e;
        int i2 = panelFeatureState.f2129a;
        if ((i2 == 0 || i2 == 108) && this.l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                a.b.e.d dVar = new a.b.e.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        a.b.e.j.g gVar = new a.b.e.j.g(context);
        gVar.a(this);
        panelFeatureState.a(gVar);
        return true;
    }

    @Override // a.b.a.e
    public <T extends View> T a(int i2) {
        s();
        return (T) this.f2125f.findViewById(i2);
    }

    @Override // a.b.a.e
    public void a(Configuration configuration) {
        a.b.a.a d2;
        if (this.B && this.v && (d2 = d()) != null) {
            d2.a(configuration);
        }
        a.b.f.f.b().a(this.f2124e);
        a(false);
    }

    @Override // a.b.a.e
    public void b(Bundle bundle) {
        s();
    }

    @Override // a.b.a.e
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2126g.a().onContentChanged();
    }

    @Override // a.b.a.e
    public void a(View view) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2126g.a().onContentChanged();
    }

    @Override // a.b.a.e
    public boolean b(int i2) {
        int j2 = j(i2);
        if (this.F && j2 == 108) {
            return false;
        }
        if (this.B && j2 == 1) {
            this.B = false;
        }
        if (j2 == 1) {
            D();
            this.F = true;
            return true;
        }
        if (j2 == 2) {
            D();
            this.z = true;
            return true;
        }
        if (j2 == 5) {
            D();
            this.A = true;
            return true;
        }
        if (j2 == 10) {
            D();
            this.D = true;
            return true;
        }
        if (j2 == 108) {
            D();
            this.B = true;
            return true;
        }
        if (j2 != 109) {
            return this.f2125f.requestFeature(j2);
        }
        D();
        this.C = true;
        return true;
    }

    @Override // a.b.a.e
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        ((ViewGroup) this.w.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2126g.a().onContentChanged();
    }

    public final void a(Window window) {
        if (this.f2125f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof o)) {
                o oVar = new o(callback);
                this.f2126g = oVar;
                window.setCallback(oVar);
                a.b.f.g0 a2 = a.b.f.g0.a(this.f2124e, (AttributeSet) null, e0);
                Drawable c2 = a2.c(0);
                if (c2 != null) {
                    window.setBackgroundDrawable(c2);
                }
                a2.b();
                this.f2125f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final q c(Context context) {
        if (this.T == null) {
            this.T = new p(context);
        }
        return this.T;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a.b.e.b b(a.b.e.b.a r8) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(a.b.e.b$a):a.b.e.b");
    }

    @Override // a.b.a.e
    public final void a(CharSequence charSequence) {
        this.k = charSequence;
        a.b.f.p pVar = this.l;
        if (pVar != null) {
            pVar.setWindowTitle(charSequence);
            return;
        }
        if (B() != null) {
            B().a(charSequence);
            return;
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // a.b.e.j.g.a
    public boolean a(a.b.e.j.g gVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback w = w();
        if (w == null || this.N || (a2 = a((Menu) gVar.m())) == null) {
            return false;
        }
        return w.onMenuItemSelected(a2.f2129a, menuItem);
    }

    @Override // a.b.e.j.g.a
    public void a(a.b.e.j.g gVar) {
        b(true);
    }

    @Override // a.b.a.e
    public a.b.e.b a(b.a aVar) {
        a.b.a.d dVar;
        if (aVar != null) {
            a.b.e.b bVar = this.o;
            if (bVar != null) {
                bVar.a();
            }
            j jVar = new j(aVar);
            a.b.a.a d2 = d();
            if (d2 != null) {
                a.b.e.b a2 = d2.a(jVar);
                this.o = a2;
                if (a2 != null && (dVar = this.f2127h) != null) {
                    dVar.onSupportActionModeStarted(a2);
                }
            }
            if (this.o == null) {
                this.o = b(jVar);
            }
            return this.o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f2123d;
        if (((obj instanceof f.a) || (obj instanceof a.b.a.f)) && (decorView = this.f2125f.getDecorView()) != null && a.h.j.f.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f2126g.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? a(keyCode, keyEvent) : d(keyCode, keyEvent);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.J = (keyEvent.getFlags() & RecyclerView.c0.FLAG_IGNORE) != 0;
        } else if (i2 == 82) {
            b(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.a0 == null) {
            String string = this.f2124e.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.a0 = new a.b.a.g();
            } else {
                try {
                    this.a0 = (a.b.a.g) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.a0 = new a.b.a.g();
                }
            }
        }
        if (d0) {
            if (this.b0 == null) {
                this.b0 = new a.b.a.h();
            }
            if (this.b0.a(attributeSet)) {
                z = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                        z2 = true;
                    }
                } else {
                    z2 = a((ViewParent) view);
                }
                z = z2;
            }
        } else {
            z = false;
        }
        return this.a0.a(view, str, context, attributeSet, z, d0, true, l0.b());
    }

    public final boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2125f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || y.I((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.N) {
            return;
        }
        if (panelFeatureState.f2129a == 0) {
            if ((this.f2124e.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback w = w();
        if (w != null && !w.onMenuOpened(panelFeatureState.f2129a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2124e.getSystemService("window");
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.f2135g != null && !panelFeatureState.q) {
                View view = panelFeatureState.f2137i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f2132d, panelFeatureState.f2133e, 1002, 8519680, -3);
                    layoutParams2.gravity = panelFeatureState.f2131c;
                    layoutParams2.windowAnimations = panelFeatureState.f2134f;
                    windowManager.addView(panelFeatureState.f2135g, layoutParams2);
                    panelFeatureState.o = true;
                }
            } else {
                ViewGroup viewGroup = panelFeatureState.f2135g;
                if (viewGroup == null) {
                    if (!b(panelFeatureState) || panelFeatureState.f2135g == null) {
                        return;
                    }
                } else if (panelFeatureState.q && viewGroup.getChildCount() > 0) {
                    panelFeatureState.f2135g.removeAllViews();
                }
                if (a(panelFeatureState) && panelFeatureState.a()) {
                    ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f2136h.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    panelFeatureState.f2135g.setBackgroundResource(panelFeatureState.f2130b);
                    ViewParent parent = panelFeatureState.f2136h.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(panelFeatureState.f2136h);
                    }
                    panelFeatureState.f2135g.addView(panelFeatureState.f2136h, layoutParams3);
                    if (!panelFeatureState.f2136h.hasFocus()) {
                        panelFeatureState.f2136h.requestFocus();
                    }
                } else {
                    panelFeatureState.q = true;
                    return;
                }
            }
            i2 = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f2132d, panelFeatureState.f2133e, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.f2131c;
            layoutParams22.windowAnimations = panelFeatureState.f2134f;
            windowManager.addView(panelFeatureState.f2135g, layoutParams22);
            panelFeatureState.o = true;
        }
    }

    public final boolean b(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(u());
        panelFeatureState.f2135g = new t(panelFeatureState.l);
        panelFeatureState.f2131c = 81;
        return true;
    }

    public final void b(boolean z) {
        a.b.f.p pVar = this.l;
        if (pVar != null && pVar.f() && (!ViewConfiguration.get(this.f2124e).hasPermanentMenuKey() || this.l.c())) {
            Window.Callback w = w();
            if (this.l.a() && z) {
                this.l.d();
                if (this.N) {
                    return;
                }
                w.onPanelClosed(108, a(0, true).j);
                return;
            }
            if (w == null || this.N) {
                return;
            }
            if (this.U && (this.V & 1) != 0) {
                this.f2125f.getDecorView().removeCallbacks(this.W);
                this.W.run();
            }
            PanelFeatureState a2 = a(0, true);
            a.b.e.j.g gVar = a2.j;
            if (gVar == null || a2.r || !w.onPreparePanel(0, a2.f2137i, gVar)) {
                return;
            }
            w.onMenuOpened(108, a2.j);
            this.l.e();
            return;
        }
        PanelFeatureState a3 = a(0, true);
        a3.q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    public final boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        a.b.f.p pVar;
        a.b.f.p pVar2;
        a.b.f.p pVar3;
        if (this.N) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.I;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            a(panelFeatureState2, false);
        }
        Window.Callback w = w();
        if (w != null) {
            panelFeatureState.f2137i = w.onCreatePanelView(panelFeatureState.f2129a);
        }
        int i2 = panelFeatureState.f2129a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (pVar3 = this.l) != null) {
            pVar3.b();
        }
        if (panelFeatureState.f2137i == null && (!z || !(B() instanceof a.b.a.j))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!c(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.l != null) {
                    if (this.m == null) {
                        this.m = new i();
                    }
                    this.l.a(panelFeatureState.j, this.m);
                }
                panelFeatureState.j.s();
                if (!w.onCreatePanelMenu(panelFeatureState.f2129a, panelFeatureState.j)) {
                    panelFeatureState.a((a.b.e.j.g) null);
                    if (z && (pVar = this.l) != null) {
                        pVar.a(null, this.m);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.s();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.c(bundle);
                panelFeatureState.s = null;
            }
            if (!w.onPreparePanel(0, panelFeatureState.f2137i, panelFeatureState.j)) {
                if (z && (pVar2 = this.l) != null) {
                    pVar2.a(null, this.m);
                }
                panelFeatureState.j.r();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.p = z2;
            panelFeatureState.j.setQwertyMode(z2);
            panelFeatureState.j.r();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.I = panelFeatureState;
        return true;
    }

    public final boolean a(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f2137i;
        if (view != null) {
            panelFeatureState.f2136h = view;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.n == null) {
            this.n = new u();
        }
        View view2 = (View) panelFeatureState.a(this.n);
        panelFeatureState.f2136h = view2;
        return view2 != null;
    }

    public void a(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        a.b.f.p pVar;
        if (z && panelFeatureState.f2129a == 0 && (pVar = this.l) != null && pVar.a()) {
            b(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2124e.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.f2135g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(panelFeatureState.f2129a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.f2136h = null;
        panelFeatureState.q = true;
        if (this.I == panelFeatureState) {
            this.I = null;
        }
    }

    public void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.H;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.N) {
            this.f2126g.a().onPanelClosed(i2, menu);
        }
    }

    public PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public void b(a.b.e.j.g gVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.l.g();
        Window.Callback w = w();
        if (w != null && !this.N) {
            w.onPanelClosed(108, gVar);
        }
        this.G = false;
    }

    public PanelFeatureState a(int i2, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.H = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        a.b.e.j.g gVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && (gVar = panelFeatureState.j) != null) {
            z = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.l == null) {
            a(panelFeatureState, true);
        }
        return z;
    }

    public final boolean b(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (a2.o) {
            return false;
        }
        return b(a2, keyEvent);
    }

    public final void b(View view) {
        int a2;
        if ((y.C(view) & 8192) != 0) {
            a2 = a.h.b.a.a(this.f2124e, R$color.abc_decor_view_status_guard_light);
        } else {
            a2 = a.h.b.a.a(this.f2124e, R$color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(a2);
    }

    public final int a(g0 g0Var, Rect rect) {
        int i2;
        boolean z;
        boolean z2;
        if (g0Var != null) {
            i2 = g0Var.h();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            if (this.p.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect2 = this.Y;
                Rect rect3 = this.Z;
                if (g0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(g0Var.f(), g0Var.h(), g0Var.g(), g0Var.e());
                }
                m0.a(this.w, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                g0 y = y.y(this.w);
                int f2 = y == null ? 0 : y.f();
                int g2 = y == null ? 0 : y.g();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z2 = true;
                }
                if (i3 > 0 && this.y == null) {
                    View view = new View(this.f2124e);
                    this.y = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = f2;
                    layoutParams.rightMargin = g2;
                    this.w.addView(this.y, -1, layoutParams);
                } else {
                    View view2 = this.y;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != f2 || marginLayoutParams2.rightMargin != g2) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = f2;
                            marginLayoutParams2.rightMargin = g2;
                            this.y.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                r5 = this.y != null;
                if (r5 && this.y.getVisibility() != 0) {
                    b(this.y);
                }
                if (!this.D && r5) {
                    i2 = 0;
                }
                z = r5;
                r5 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.p.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.y;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    @Override // a.b.a.e
    public int b() {
        return this.O;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f2124e
            r1 = 0
            android.content.res.Configuration r0 = r6.a(r0, r7, r1)
            boolean r2 = r6.y()
            android.content.Context r3 = r6.f2124e
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L47
            if (r8 == 0) goto L47
            if (r2 != 0) goto L47
            boolean r8 = r6.K
            if (r8 == 0) goto L47
            boolean r8 = androidx.appcompat.app.AppCompatDelegateImpl.f0
            if (r8 != 0) goto L30
            boolean r8 = r6.L
            if (r8 == 0) goto L47
        L30:
            java.lang.Object r8 = r6.f2123d
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L47
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L47
            java.lang.Object r8 = r6.f2123d
            android.app.Activity r8 = (android.app.Activity) r8
            a.h.a.a.d(r8)
            r8 = 1
            goto L48
        L47:
            r8 = 0
        L48:
            if (r8 != 0) goto L50
            if (r3 == r0) goto L50
            r6.a(r0, r2, r1)
            goto L51
        L50:
            r4 = r8
        L51:
            if (r4 == 0) goto L5e
            java.lang.Object r8 = r6.f2123d
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L5e
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.onNightModeChanged(r7)
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(int, boolean):boolean");
    }

    public final boolean a(boolean z) {
        if (this.N) {
            return false;
        }
        int n2 = n();
        boolean b2 = b(a(this.f2124e, n2), z);
        if (n2 == 0) {
            d(this.f2124e).e();
        } else {
            q qVar = this.S;
            if (qVar != null) {
                qVar.a();
            }
        }
        if (n2 == 3) {
            c(this.f2124e).e();
        } else {
            q qVar2 = this.T;
            if (qVar2 != null) {
                qVar2.a();
            }
        }
        return b2;
    }

    public int a(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return d(context).c();
                }
                return -1;
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return c(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    public final Configuration a(Context context, int i2, Configuration configuration) {
        int i3;
        if (i2 != 1) {
            i3 = i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i2, boolean z, Configuration configuration) {
        Resources resources = this.f2124e.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            a.b.a.i.a(resources);
        }
        int i3 = this.P;
        if (i3 != 0) {
            this.f2124e.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f2124e.getTheme().applyStyle(this.P, true);
            }
        }
        if (z) {
            Object obj = this.f2123d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof a.m.i) {
                    if (((a.m.i) activity).getLifecycle().a().isAtLeast(f.c.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.M) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    @Override // a.b.a.e
    public final a.b.a.b a() {
        return new h(this);
    }

    public static Configuration a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                m.a(configuration, configuration2, configuration3);
            } else if (!a.h.i.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                n.a(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                k.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }
}
