package a.h.j;

import a.h.j.a;
import a.h.j.g0;
import a.h.j.h0.c;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class y {

    /* renamed from: b, reason: collision with root package name */
    public static Field f1209b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1210c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f1211d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1212e;

    /* renamed from: f, reason: collision with root package name */
    public static WeakHashMap<View, String> f1213f;

    /* renamed from: h, reason: collision with root package name */
    public static Field f1215h;
    public static ThreadLocal<Rect> j;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f1208a = new AtomicInteger(1);

    /* renamed from: g, reason: collision with root package name */
    public static WeakHashMap<View, c0> f1214g = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f1216i = false;
    public static final u k = new a();

    /* compiled from: ViewCompat.java */
    public class a implements u {
        @Override // a.h.j.u
        public a.h.j.c a(a.h.j.c cVar) {
            return cVar;
        }
    }

    /* compiled from: ViewCompat.java */
    public static abstract class g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f1218a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f1219b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1220c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1221d;

        public g(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        public abstract T a(View view);

        public abstract void a(View view, T t);

        public final boolean a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        public abstract boolean a(T t, T t2);

        public void b(View view, T t) {
            if (b()) {
                a(view, (View) t);
            } else if (a() && a(b(view), t)) {
                y.u(view);
                view.setTag(this.f1218a, t);
                y.c(view, this.f1221d);
            }
        }

        public g(int i2, Class<T> cls, int i3, int i4) {
            this.f1218a = i2;
            this.f1219b = cls;
            this.f1221d = i3;
            this.f1220c = i4;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public T b(View view) {
            if (b()) {
                return a(view);
            }
            if (!a()) {
                return null;
            }
            T t = (T) view.getTag(this.f1218a);
            if (this.f1219b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f1220c;
        }
    }

    /* compiled from: ViewCompat.java */
    public static class h {

        /* compiled from: ViewCompat.java */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public g0 f1222a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f1223b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ s f1224c;

            public a(View view, s sVar) {
                this.f1223b = view;
                this.f1224c = sVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                g0 a2 = g0.a(windowInsets, view);
                if (Build.VERSION.SDK_INT < 30) {
                    h.a(windowInsets, this.f1223b);
                    if (a2.equals(this.f1222a)) {
                        return this.f1224c.a(view, a2).k();
                    }
                }
                this.f1222a = a2;
                g0 a3 = this.f1224c.a(view, a2);
                if (Build.VERSION.SDK_INT >= 30) {
                    return a3.k();
                }
                y.O(view);
                return a3.k();
            }
        }

        public static g0 a(View view) {
            return g0.a.a(view);
        }

        public static g0 a(View view, g0 g0Var, Rect rect) {
            WindowInsets k = g0Var.k();
            if (k != null) {
                return g0.a(view.computeSystemWindowInsets(k, rect), view);
            }
            rect.setEmpty();
            return g0Var;
        }

        public static void a(View view, s sVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, sVar);
            }
            if (sVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, sVar));
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }
    }

    /* compiled from: ViewCompat.java */
    public static class i {
        public static g0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            g0 a2 = g0.a(rootWindowInsets);
            a2.a(a2);
            a2.a(view.getRootView());
            return a2;
        }
    }

    /* compiled from: ViewCompat.java */
    public static class j {
        public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    /* compiled from: ViewCompat.java */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    static {
        new f();
    }

    public static String A(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1213f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static float B(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float D(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean E(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean F(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean G(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean H(View view) {
        Boolean b2 = a().b(view);
        if (b2 == null) {
            return false;
        }
        return b2.booleanValue();
    }

    public static boolean I(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean J(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof m) {
            return ((m) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean L(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean M(View view) {
        Boolean b2 = e().b(view);
        if (b2 == null) {
            return false;
        }
        return b2.booleanValue();
    }

    public static void N(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void O(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void P(View view) {
        if (o(view) == 0) {
            h(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (o((View) parent) == 4) {
                h(view, 2);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof m) {
            ((m) view).stopNestedScroll();
        }
    }

    public static void R(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static a.h.j.a b(View view) {
        View.AccessibilityDelegate c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return c2 instanceof a.C0026a ? ((a.C0026a) c2).f1112a : new a.h.j.a(c2);
    }

    public static Rect c() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (f1216i) {
            return null;
        }
        if (f1215h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1215h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1216i = true;
                return null;
            }
        }
        try {
            Object obj = f1215h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1216i = true;
            return null;
        }
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            c(view, 0);
        }
    }

    public static List<c.a> g(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R$id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void h(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void i(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static Rect j(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static Display k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (I(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static float l(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static u m(View view) {
        return view instanceof u ? (u) view : k;
    }

    public static boolean n(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int p(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1212e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f1211d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1212e = true;
        }
        Field field = f1211d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1210c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f1209b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1210c = true;
        }
        Field field = f1209b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static String[] t(View view) {
        return (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static a.h.j.a u(View view) {
        a.h.j.a b2 = b(view);
        if (b2 == null) {
            b2 = new a.h.j.a();
        }
        a(view, b2);
        return b2;
    }

    public static int v(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int w(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static ViewParent x(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static g0 y(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return i.a(view);
        }
        if (i2 >= 21) {
            return h.a(view);
        }
        return null;
    }

    public static final CharSequence z(View view) {
        return f().b(view);
    }

    /* compiled from: ViewCompat.java */
    public class b extends g<Boolean> {
        public b(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        @Override // a.h.j.y.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.h.j.y.g
        public Boolean a(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // a.h.j.y.g
        public void a(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }
    }

    /* compiled from: ViewCompat.java */
    public class c extends g<CharSequence> {
        public c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.h.j.y.g
        public CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // a.h.j.y.g
        public void a(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @Override // a.h.j.y.g
        public boolean a(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: ViewCompat.java */
    public class d extends g<CharSequence> {
        public d(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.h.j.y.g
        public CharSequence a(View view) {
            return view.getStateDescription();
        }

        @Override // a.h.j.y.g
        public void a(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        @Override // a.h.j.y.g
        public boolean a(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: ViewCompat.java */
    public class e extends g<Boolean> {
        public e(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        @Override // a.h.j.y.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.h.j.y.g
        public Boolean a(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // a.h.j.y.g
        public void a(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }
    }

    /* compiled from: ViewCompat.java */
    public static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f1217a = new WeakHashMap<>();

        public final void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                y.c(view, z2 ? 16 : 32);
                this.f1217a.put(view, Boolean.valueOf(z2));
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f1217a.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        public final void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    public static class l {

        /* renamed from: d, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f1225d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f1226a = null;

        /* renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f1227b = null;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f1228c = null;

        public final SparseArray<WeakReference<View>> a() {
            if (this.f1227b == null) {
                this.f1227b = new SparseArray<>();
            }
            return this.f1227b;
        }

        public final View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1226a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((k) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        public static l a(View view) {
            l lVar = (l) view.getTag(R$id.tag_unhandled_key_event_manager);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            view.setTag(R$id.tag_unhandled_key_event_manager, lVar2);
            return lVar2;
        }

        public boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b2));
                }
            }
            return b2 != null;
        }

        public final void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1226a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1225d.isEmpty()) {
                return;
            }
            synchronized (f1225d) {
                if (this.f1226a == null) {
                    this.f1226a = new WeakHashMap<>();
                }
                for (int size = f1225d.size() - 1; size >= 0; size--) {
                    View view = f1225d.get(size).get();
                    if (view == null) {
                        f1225d.remove(size);
                    } else {
                        this.f1226a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1226a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        public boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1228c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f1228c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> a2 = a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = a2.valueAt(indexOfKey);
                a2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = a2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && y.I(view)) {
                c(view, keyEvent);
            }
            return true;
        }
    }

    public static void a(View view, a.h.j.h0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.z());
    }

    public static void e(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (i3 >= 21) {
            Rect c2 = c();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            b(view, i2);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
                return;
            }
            return;
        }
        b(view, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode i(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof x) {
            return ((x) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void a(View view, a.h.j.a aVar) {
        if (aVar == null && (c(view) instanceof a.C0026a)) {
            aVar = new a.h.j.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    public static CharSequence f(View view) {
        return d().b(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList h(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof x) {
            return ((x) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static g<CharSequence> f() {
        return new d(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return d(view);
    }

    public static g0 b(View view, g0 g0Var) {
        WindowInsets k2;
        if (Build.VERSION.SDK_INT >= 21 && (k2 = g0Var.k()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(k2);
            if (!onApplyWindowInsets.equals(k2)) {
                return g0.a(onApplyWindowInsets, view);
            }
        }
        return g0Var;
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void c(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void d(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (i3 >= 21) {
            Rect c2 = c();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            a(view, i2);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
                return;
            }
            return;
        }
        a(view, i2);
    }

    public static void c(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = f(view) != null && view.getVisibility() == 0;
            if (e(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                if (z) {
                    obtain.getText().add(f(view));
                    P(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(f(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void b(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            R(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                R((View) parent);
            }
        }
    }

    public static void a(View view, c.a aVar, CharSequence charSequence, a.h.j.h0.f fVar) {
        if (fVar == null && charSequence == null) {
            f(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, fVar));
        }
    }

    public static void a(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            u(view);
            a(aVar.a(), view);
            g(view).add(aVar);
            c(view, 0);
        }
    }

    public static int b() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f1208a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f1208a.compareAndSet(i2, i3));
        return i2;
    }

    public static g<Boolean> e() {
        return new b(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void a(int i2, View view) {
        List<c.a> g2 = g(view);
        for (int i3 = 0; i3 < g2.size(); i3++) {
            if (g2.get(i3).a() == i2) {
                g2.remove(i3);
                return;
            }
        }
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).a(keyEvent);
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            f().b(view, charSequence);
        }
    }

    public static g<CharSequence> d() {
        return new c(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static c0 a(View view) {
        if (f1214g == null) {
            f1214g = new WeakHashMap<>();
        }
        c0 c0Var = f1214g.get(view);
        if (c0Var != null) {
            return c0Var;
        }
        c0 c0Var2 = new c0(view);
        f1214g.put(view, c0Var2);
        return c0Var2;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1213f == null) {
            f1213f = new WeakHashMap<>();
        }
        f1213f.put(view, str);
    }

    public static void a(View view, s sVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.a(view, sVar);
        }
    }

    public static g0 a(View view, g0 g0Var) {
        WindowInsets k2;
        if (Build.VERSION.SDK_INT >= 21 && (k2 = g0Var.k()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(k2);
            if (!dispatchApplyWindowInsets.equals(k2)) {
                return g0.a(dispatchApplyWindowInsets, view);
            }
        }
        return g0Var;
    }

    public static g0 a(View view, g0 g0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.a(view, g0Var, rect) : g0Var;
    }

    public static a.h.j.c a(View view, a.h.j.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        t tVar = (t) view.getTag(R$id.tag_on_receive_content_listener);
        if (tVar != null) {
            a.h.j.c a2 = tVar.a(view, cVar);
            if (a2 == null) {
                return null;
            }
            return m(view).a(a2);
        }
        return m(view).a(cVar);
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof x) {
            ((x) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof x) {
            ((x) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            R(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                R((View) parent);
            }
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, w wVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (wVar != null ? wVar.a() : null));
        }
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).a(view, keyEvent);
    }

    public static void a(View view, boolean z) {
        a().b(view, Boolean.valueOf(z));
    }

    public static g<Boolean> a() {
        return new e(R$id.tag_accessibility_heading, Boolean.class, 28);
    }
}
