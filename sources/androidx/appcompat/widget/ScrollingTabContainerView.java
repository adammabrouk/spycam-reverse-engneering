package androidx.appcompat.widget;

import a.b.a.a;
import a.b.f.g0;
import a.b.f.i0;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public Runnable f2309a;

    /* renamed from: b, reason: collision with root package name */
    public c f2310b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayoutCompat f2311c;

    /* renamed from: d, reason: collision with root package name */
    public Spinner f2312d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2313e;

    /* renamed from: f, reason: collision with root package name */
    public int f2314f;

    /* renamed from: g, reason: collision with root package name */
    public int f2315g;

    /* renamed from: h, reason: collision with root package name */
    public int f2316h;

    /* renamed from: i, reason: collision with root package name */
    public int f2317i;
    public ViewPropertyAnimator j;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2318a;

        public a(View view) {
            this.f2318a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f2318a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f2318a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f2309a = null;
        }
    }

    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2311c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) ScrollingTabContainerView.this.f2311c.getChildAt(i2)).a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((a.c) getItem(i2), true);
            }
            ((d) view).a((a.c) getItem(i2));
            return view;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).a().e();
            int childCount = ScrollingTabContainerView.this.f2311c.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.f2311c.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2328a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f2329b;

        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2328a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2328a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.j = null;
            scrollingTabContainerView.setVisibility(this.f2329b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f2328a = false;
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        new e();
        setHorizontalScrollBarEnabled(false);
        a.b.e.a a2 = a.b.e.a.a(context);
        setContentHeight(a2.e());
        this.f2315g = a2.d();
        LinearLayoutCompat b2 = b();
        this.f2311c = b2;
        addView(b2, new ViewGroup.LayoutParams(-2, -1));
    }

    public final Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public final LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return linearLayoutCompat;
    }

    public final boolean c() {
        Spinner spinner = this.f2312d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void d() {
        if (c()) {
            return;
        }
        if (this.f2312d == null) {
            this.f2312d = a();
        }
        removeView(this.f2311c);
        addView(this.f2312d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2312d.getAdapter() == null) {
            this.f2312d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f2309a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2309a = null;
        }
        this.f2312d.setSelection(this.f2317i);
    }

    public final boolean e() {
        if (!c()) {
            return false;
        }
        removeView(this.f2312d);
        addView(this.f2311c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2312d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2309a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.b.e.a a2 = a.b.e.a.a(getContext());
        setContentHeight(a2.e());
        this.f2315g = a2.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2309a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        ((d) view).a().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2311c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2314f = -1;
        } else {
            if (childCount > 2) {
                this.f2314f = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f2314f = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f2314f = Math.min(this.f2314f, this.f2315g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2316h, MemoryConstants.GB);
        if (!z && this.f2313e) {
            this.f2311c.measure(0, makeMeasureSpec);
            if (this.f2311c.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                d();
            } else {
                e();
            }
        } else {
            e();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2317i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2313e = z;
    }

    public void setContentHeight(int i2) {
        this.f2316h = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f2317i = i2;
        int childCount = this.f2311c.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f2311c.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f2312d;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }

    public class d extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f2322a;

        /* renamed from: b, reason: collision with root package name */
        public a.c f2323b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f2324c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f2325d;

        /* renamed from: e, reason: collision with root package name */
        public View f2326e;

        public d(Context context, a.c cVar, boolean z) {
            super(context, null, R$attr.actionBarTabStyle);
            int[] iArr = {R.attr.background};
            this.f2322a = iArr;
            this.f2323b = cVar;
            g0 a2 = g0.a(context, null, iArr, R$attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.b();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(a.c cVar) {
            this.f2323b = cVar;
            b();
        }

        public void b() {
            a.c cVar = this.f2323b;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f2326e = b2;
                TextView textView = this.f2324c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2325d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2325d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2326e;
            if (view != null) {
                removeView(view);
                this.f2326e = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f2325d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2325d = appCompatImageView;
                }
                this.f2325d.setImageDrawable(c2);
                this.f2325d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2325d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2325d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f2324c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2324c = appCompatTextView;
                }
                this.f2324c.setText(d2);
                this.f2324c.setVisibility(0);
            } else {
                TextView textView2 = this.f2324c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2324c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2325d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            i0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f2314f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = ScrollingTabContainerView.this.f2314f;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public a.c a() {
            return this.f2323b;
        }
    }

    public void a(int i2) {
        View childAt = this.f2311c.getChildAt(i2);
        Runnable runnable = this.f2309a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f2309a = aVar;
        post(aVar);
    }

    public d a(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2316h));
        } else {
            dVar.setFocusable(true);
            if (this.f2310b == null) {
                this.f2310b = new c();
            }
            dVar.setOnClickListener(this.f2310b);
        }
        return dVar;
    }
}
