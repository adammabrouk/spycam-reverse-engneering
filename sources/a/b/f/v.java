package a.b.f;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class v implements a.b.e.j.p {
    public static Method G;
    public static Method H;
    public static Method I;
    public final c A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public boolean E;
    public PopupWindow F;

    /* renamed from: a, reason: collision with root package name */
    public Context f590a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f591b;

    /* renamed from: c, reason: collision with root package name */
    public s f592c;

    /* renamed from: d, reason: collision with root package name */
    public int f593d;

    /* renamed from: e, reason: collision with root package name */
    public int f594e;

    /* renamed from: f, reason: collision with root package name */
    public int f595f;

    /* renamed from: g, reason: collision with root package name */
    public int f596g;

    /* renamed from: h, reason: collision with root package name */
    public int f597h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f598i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public View p;
    public int q;
    public DataSetObserver r;
    public View t;
    public Drawable u;
    public AdapterView.OnItemClickListener v;
    public AdapterView.OnItemSelectedListener w;
    public final g x;
    public final f y;
    public final e z;

    /* compiled from: ListPopupWindow.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View j = v.this.j();
            if (j == null || j.getWindowToken() == null) {
                return;
            }
            v.this.d();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            s sVar;
            if (i2 == -1 || (sVar = v.this.f592c) == null) {
                return;
            }
            sVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.i();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (v.this.a()) {
                v.this.d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            v.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || v.this.p() || v.this.F.getContentView() == null) {
                return;
            }
            v vVar = v.this;
            vVar.B.removeCallbacks(vVar.x);
            v.this.x.run();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = v.this.F) != null && popupWindow.isShowing() && x >= 0 && x < v.this.F.getWidth() && y >= 0 && y < v.this.F.getHeight()) {
                v vVar = v.this;
                vVar.B.postDelayed(vVar.x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            v vVar2 = v.this;
            vVar2.B.removeCallbacks(vVar2.x);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = v.this.f592c;
            if (sVar == null || !a.h.j.y.I(sVar) || v.this.f592c.getCount() <= v.this.f592c.getChildCount()) {
                return;
            }
            int childCount = v.this.f592c.getChildCount();
            v vVar = v.this;
            if (childCount <= vVar.o) {
                vVar.F.setInputMethodMode(2);
                v.this.d();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public v(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new d();
        } else {
            ListAdapter listAdapter2 = this.f591b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f591b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        s sVar = this.f592c;
        if (sVar != null) {
            sVar.setAdapter(this.f591b);
        }
    }

    public int b() {
        return this.f595f;
    }

    public Drawable c() {
        return this.F.getBackground();
    }

    public void d(int i2) {
        this.F.setAnimationStyle(i2);
    }

    @Override // a.b.e.j.p
    public void dismiss() {
        this.F.dismiss();
        r();
        this.F.setContentView(null);
        this.f592c = null;
        this.B.removeCallbacks(this.x);
    }

    public void e(int i2) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            j(i2);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f594e = rect.left + rect.right + i2;
    }

    public int f() {
        if (this.f598i) {
            return this.f596g;
        }
        return 0;
    }

    public void g(int i2) {
        this.F.setInputMethodMode(i2);
    }

    public void h(int i2) {
        this.q = i2;
    }

    public void i(int i2) {
        s sVar = this.f592c;
        if (!a() || sVar == null) {
            return;
        }
        sVar.setListSelectionHidden(false);
        sVar.setSelection(i2);
        if (sVar.getChoiceMode() != 0) {
            sVar.setItemChecked(i2, true);
        }
    }

    public View j() {
        return this.t;
    }

    public Object k() {
        if (a()) {
            return this.f592c.getSelectedItem();
        }
        return null;
    }

    public long l() {
        if (a()) {
            return this.f592c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int m() {
        if (a()) {
            return this.f592c.getSelectedItemPosition();
        }
        return -1;
    }

    public View n() {
        if (a()) {
            return this.f592c.getSelectedView();
        }
        return null;
    }

    public int o() {
        return this.f594e;
    }

    public boolean p() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean q() {
        return this.E;
    }

    public final void r() {
        View view = this.p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
        }
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.w = onItemSelectedListener;
    }

    public v(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public void b(boolean z) {
        this.k = true;
        this.j = z;
    }

    public void c(int i2) {
        this.f595f = i2;
    }

    @Override // a.b.e.j.p
    public void d() {
        int h2 = h();
        boolean p = p();
        a.h.k.h.a(this.F, this.f597h);
        if (this.F.isShowing()) {
            if (a.h.j.y.I(j())) {
                int i2 = this.f594e;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = j().getWidth();
                }
                int i3 = this.f593d;
                if (i3 == -1) {
                    if (!p) {
                        h2 = -1;
                    }
                    if (p) {
                        this.F.setWidth(this.f594e == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f594e == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    h2 = i3;
                }
                this.F.setOutsideTouchable((this.n || this.m) ? false : true);
                this.F.update(j(), this.f595f, this.f596g, i2 < 0 ? -1 : i2, h2 < 0 ? -1 : h2);
                return;
            }
            return;
        }
        int i4 = this.f594e;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = j().getWidth();
        }
        int i5 = this.f593d;
        if (i5 == -1) {
            h2 = -1;
        } else if (i5 != -2) {
            h2 = i5;
        }
        this.F.setWidth(i4);
        this.F.setHeight(h2);
        c(true);
        this.F.setOutsideTouchable((this.n || this.m) ? false : true);
        this.F.setTouchInterceptor(this.y);
        if (this.k) {
            a.h.k.h.a(this.F, this.j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.F.setEpicenterBounds(this.D);
        }
        a.h.k.h.a(this.F, j(), this.f595f, this.f596g, this.l);
        this.f592c.setSelection(-1);
        if (!this.E || this.f592c.isInTouchMode()) {
            i();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.A);
    }

    public final int h() {
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        if (this.f592c == null) {
            Context context = this.f590a;
            new a();
            s a2 = a(context, !this.E);
            this.f592c = a2;
            Drawable drawable = this.u;
            if (drawable != null) {
                a2.setSelector(drawable);
            }
            this.f592c.setAdapter(this.f591b);
            this.f592c.setOnItemClickListener(this.v);
            this.f592c.setFocusable(true);
            this.f592c.setFocusableInTouchMode(true);
            this.f592c.setOnItemSelectedListener(new b());
            this.f592c.setOnScrollListener(this.z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.w;
            if (onItemSelectedListener != null) {
                this.f592c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f592c;
            View view2 = this.p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.q;
                if (i5 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i6 = this.f594e;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i2 = 0;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i2 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f598i) {
                this.f596g = -i7;
            }
        } else {
            this.C.setEmpty();
            i3 = 0;
        }
        int a3 = a(j(), this.f596g, this.F.getInputMethodMode() == 2);
        if (this.m || this.f593d == -1) {
            return a3 + i3;
        }
        int i8 = this.f594e;
        if (i8 == -2) {
            int i9 = this.f590a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, MemoryConstants.GB);
        } else {
            int i10 = this.f590a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), MemoryConstants.GB);
        }
        int a4 = this.f592c.a(makeMeasureSpec, 0, -1, a3 - i2, -1);
        if (a4 > 0) {
            i2 += i3 + this.f592c.getPaddingTop() + this.f592c.getPaddingBottom();
        }
        return a4 + i2;
    }

    public void j(int i2) {
        this.f594e = i2;
    }

    public v(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f593d = -2;
        this.f594e = -2;
        this.f597h = 1002;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = Integer.MAX_VALUE;
        this.q = 0;
        this.x = new g();
        this.y = new f();
        this.z = new e();
        this.A = new c();
        this.C = new Rect();
        this.f590a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f595f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f596g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f598i = true;
        }
        obtainStyledAttributes.recycle();
        i iVar = new i(context, attributeSet, i2, i3);
        this.F = iVar;
        iVar.setInputMethodMode(1);
    }

    public final void c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = G;
            if (method != null) {
                try {
                    method.invoke(this.F, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.F.setIsClippedToScreen(z);
    }

    public void f(int i2) {
        this.l = i2;
    }

    @Override // a.b.e.j.p
    public ListView e() {
        return this.f592c;
    }

    public void i() {
        s sVar = this.f592c;
        if (sVar != null) {
            sVar.setListSelectionHidden(true);
            sVar.requestLayout();
        }
    }

    public void a(boolean z) {
        this.E = z;
        this.F.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.t = view;
    }

    public void a(int i2) {
        this.f596g = i2;
        this.f598i = true;
    }

    public void a(Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    @Override // a.b.e.j.p
    public boolean a() {
        return this.F.isShowing();
    }

    public s a(Context context, boolean z) {
        return new s(context, z);
    }

    public final int a(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = H;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.F, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.F.getMaxAvailableHeight(view, i2);
        }
        return this.F.getMaxAvailableHeight(view, i2, z);
    }
}
