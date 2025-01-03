package c.e.b.g;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.lxj.xpopup.core.BasePopupView;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KeyboardUtils.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f6302a;

    /* renamed from: b, reason: collision with root package name */
    public static ViewTreeObserver.OnGlobalLayoutListener f6303b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<View, b> f6304c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static int f6305d = 0;

    /* compiled from: KeyboardUtils.java */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f6306a;

        public a(Window window) {
            this.f6306a = window;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int b2 = c.b(this.f6306a);
            if (c.f6302a != b2) {
                Iterator it = c.f6304c.values().iterator();
                while (it.hasNext()) {
                    ((b) it.next()).onSoftInputChanged(b2);
                }
                c.f6302a = b2;
            }
        }
    }

    /* compiled from: KeyboardUtils.java */
    public interface b {
        void onSoftInputChanged(int i2);
    }

    public static int b(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return f6302a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (e.b(window)) {
            abs -= e.b();
        }
        if (abs > e.b() + e.c()) {
            return abs - f6305d;
        }
        f6305d = abs;
        return 0;
    }

    public static void a(Window window, BasePopupView basePopupView, b bVar) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        f6302a = b(window);
        f6304c.put(basePopupView, bVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(window));
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void a(View view, BasePopupView basePopupView) {
        View findViewById;
        f6303b = null;
        f6304c.remove(basePopupView);
        if (view == null || (findViewById = view.findViewById(R.id.content)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(f6303b);
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
