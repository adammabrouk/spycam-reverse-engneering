package com.google.android.material.tabs;

import a.b.f.i0;
import a.h.j.h0.c;
import a.h.j.w;
import a.h.j.y;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.zxing.decoding.InactivityTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.e
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int P = R$style.Widget_Design_TabLayout;
    public static final a.h.i.e<g> Q = new a.h.i.g(16);
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public c E;
    public final ArrayList<c> F;
    public c G;
    public ValueAnimator H;
    public ViewPager I;
    public a.x.a.a J;
    public DataSetObserver K;
    public h L;
    public b M;
    public boolean N;
    public final a.h.i.e<TabView> O;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<g> f10604a;

    /* renamed from: b, reason: collision with root package name */
    public g f10605b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f10606c;

    /* renamed from: d, reason: collision with root package name */
    public final f f10607d;

    /* renamed from: e, reason: collision with root package name */
    public int f10608e;

    /* renamed from: f, reason: collision with root package name */
    public int f10609f;

    /* renamed from: g, reason: collision with root package name */
    public int f10610g;

    /* renamed from: h, reason: collision with root package name */
    public int f10611h;

    /* renamed from: i, reason: collision with root package name */
    public int f10612i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public PorterDuff.Mode n;
    public float o;
    public float p;
    public final int q;
    public int r;
    public final int t;
    public final int u;
    public final int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public final class TabView extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public g f10613a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f10614b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f10615c;

        /* renamed from: d, reason: collision with root package name */
        public View f10616d;

        /* renamed from: e, reason: collision with root package name */
        public BadgeDrawable f10617e;

        /* renamed from: f, reason: collision with root package name */
        public View f10618f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f10619g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f10620h;

        /* renamed from: i, reason: collision with root package name */
        public Drawable f10621i;
        public int j;

        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f10622a;

            public a(View view) {
                this.f10622a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.f10622a.getVisibility() == 0) {
                    TabView.this.d(this.f10622a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.j = 2;
            a(context);
            y.a(this, TabLayout.this.f10608e, TabLayout.this.f10609f, TabLayout.this.f10610g, TabLayout.this.f10611h);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            y.a(this, w.a(getContext(), 1002));
        }

        private BadgeDrawable getBadge() {
            return this.f10617e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            View[] viewArr = {this.f10614b, this.f10615c, this.f10618f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.f10617e == null) {
                this.f10617e = BadgeDrawable.a(getContext());
            }
            g();
            BadgeDrawable badgeDrawable = this.f10617e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d() {
            FrameLayout frameLayout;
            if (c.c.a.c.c.a.f5356a) {
                frameLayout = a();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.f10614b = textView;
            frameLayout.addView(textView);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f10621i;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f10621i.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public void e() {
            setTab(null);
            setSelected(false);
        }

        public final void f() {
            if (b()) {
                a(true);
                View view = this.f10616d;
                if (view != null) {
                    c.c.a.c.c.a.b(this.f10617e, view, b(view));
                    this.f10616d = null;
                }
            }
        }

        public final void g() {
            g gVar;
            g gVar2;
            if (b()) {
                if (this.f10618f != null) {
                    f();
                    return;
                }
                if (this.f10615c != null && (gVar2 = this.f10613a) != null && gVar2.b() != null) {
                    View view = this.f10616d;
                    ImageView imageView = this.f10615c;
                    if (view == imageView) {
                        d(imageView);
                        return;
                    } else {
                        f();
                        c(this.f10615c);
                        return;
                    }
                }
                if (this.f10614b == null || (gVar = this.f10613a) == null || gVar.d() != 1) {
                    f();
                    return;
                }
                View view2 = this.f10616d;
                TextView textView = this.f10614b;
                if (view2 == textView) {
                    d(textView);
                } else {
                    f();
                    c(this.f10614b);
                }
            }
        }

        public g getTab() {
            return this.f10613a;
        }

        public final void h() {
            g gVar = this.f10613a;
            Drawable drawable = null;
            View a2 = gVar != null ? gVar.a() : null;
            if (a2 != null) {
                ViewParent parent = a2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a2);
                    }
                    addView(a2);
                }
                this.f10618f = a2;
                TextView textView = this.f10614b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f10615c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f10615c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) a2.findViewById(R.id.text1);
                this.f10619g = textView2;
                if (textView2 != null) {
                    this.j = a.h.k.i.d(textView2);
                }
                this.f10620h = (ImageView) a2.findViewById(R.id.icon);
            } else {
                View view = this.f10618f;
                if (view != null) {
                    removeView(view);
                    this.f10618f = null;
                }
                this.f10619g = null;
                this.f10620h = null;
            }
            if (this.f10618f == null) {
                if (this.f10615c == null) {
                    c();
                }
                if (gVar != null && gVar.b() != null) {
                    drawable = a.h.c.l.a.i(gVar.b()).mutate();
                }
                if (drawable != null) {
                    a.h.c.l.a.a(drawable, TabLayout.this.k);
                    PorterDuff.Mode mode = TabLayout.this.n;
                    if (mode != null) {
                        a.h.c.l.a.a(drawable, mode);
                    }
                }
                if (this.f10614b == null) {
                    d();
                    this.j = a.h.k.i.d(this.f10614b);
                }
                a.h.k.i.d(this.f10614b, TabLayout.this.f10612i);
                ColorStateList colorStateList = TabLayout.this.j;
                if (colorStateList != null) {
                    this.f10614b.setTextColor(colorStateList);
                }
                a(this.f10614b, this.f10615c);
                g();
                a(this.f10615c);
                a(this.f10614b);
            } else if (this.f10619g != null || this.f10620h != null) {
                a(this.f10619g, this.f10620h);
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f10644c)) {
                setContentDescription(gVar.f10644c);
            }
            setSelected(gVar != null && gVar.f());
        }

        public final void i() {
            setOrientation(!TabLayout.this.B ? 1 : 0);
            if (this.f10619g == null && this.f10620h == null) {
                a(this.f10614b, this.f10615c);
            } else {
                a(this.f10619g, this.f10620h);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f10617e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f10617e.c()));
            }
            a.h.j.h0.c a2 = a.h.j.h0.c.a(accessibilityNodeInfo);
            a2.b(c.C0028c.a(0, 1, this.f10613a.c(), 1, false, isSelected()));
            if (isSelected()) {
                a2.e(false);
                a2.b(c.a.f1176g);
            }
            a2.g("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f10614b != null) {
                float f2 = TabLayout.this.o;
                int i4 = this.j;
                ImageView imageView = this.f10615c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f10614b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.p;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f10614b.getTextSize();
                int lineCount = this.f10614b.getLineCount();
                int d2 = a.h.k.i.d(this.f10614b);
                if (f2 != textSize || (d2 >= 0 && i4 != d2)) {
                    if (TabLayout.this.A == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f10614b.getLayout()) == null || a(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f10614b.setTextSize(0, f2);
                        this.f10614b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f10613a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f10613a.h();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f10614b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f10615c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f10618f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f10613a) {
                this.f10613a = gVar;
                h();
            }
        }

        public final boolean b() {
            return this.f10617e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c() {
            FrameLayout frameLayout;
            if (c.c.a.c.c.a.f5356a) {
                frameLayout = a();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f10615c = imageView;
            frameLayout.addView(imageView, 0);
        }

        public final FrameLayout b(View view) {
            if ((view == this.f10615c || view == this.f10614b) && c.c.a.c.c.a.f5356a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public final void a(Context context) {
            int i2 = TabLayout.this.q;
            if (i2 != 0) {
                Drawable c2 = a.b.b.a.a.c(context, i2);
                this.f10621i = c2;
                if (c2 != null && c2.isStateful()) {
                    this.f10621i.setState(getDrawableState());
                }
            } else {
                this.f10621i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.l != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = c.c.a.c.u.b.a(TabLayout.this.l);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.D) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, TabLayout.this.D ? null : gradientDrawable2);
                } else {
                    Drawable i3 = a.h.c.l.a.i(gradientDrawable2);
                    a.h.c.l.a.a(i3, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, i3});
                }
            }
            y.a(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        public final void d(View view) {
            if (b() && view == this.f10616d) {
                c.c.a.c.c.a.c(this.f10617e, view, b(view));
            }
        }

        public final void c(View view) {
            if (b() && view != null) {
                a(false);
                c.c.a.c.c.a.a(this.f10617e, view, b(view));
                this.f10616d = view;
            }
        }

        public final void a(Canvas canvas) {
            Drawable drawable = this.f10621i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f10621i.draw(canvas);
            }
        }

        public final FrameLayout a() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void a(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        public final void a(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        public final void a(TextView textView, ImageView imageView) {
            g gVar = this.f10613a;
            Drawable mutate = (gVar == null || gVar.b() == null) ? null : a.h.c.l.a.i(this.f10613a.b()).mutate();
            g gVar2 = this.f10613a;
            CharSequence e2 = gVar2 != null ? gVar2.e() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(e2);
            if (textView != null) {
                if (z) {
                    textView.setText(e2);
                    if (this.f10613a.f10647f == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a2 = (z && imageView.getVisibility() == 0) ? (int) r.a(getContext(), 8) : 0;
                if (TabLayout.this.B) {
                    if (a2 != a.h.j.h.a(marginLayoutParams)) {
                        a.h.j.h.a(marginLayoutParams, a2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (a2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a2;
                    a.h.j.h.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f10613a;
            i0.a(this, z ? null : gVar3 != null ? gVar3.f10644c : null);
        }

        public final float a(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.f();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.f();
        }
    }

    public class f extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public int f10628a;

        /* renamed from: b, reason: collision with root package name */
        public final Paint f10629b;

        /* renamed from: c, reason: collision with root package name */
        public final GradientDrawable f10630c;

        /* renamed from: d, reason: collision with root package name */
        public int f10631d;

        /* renamed from: e, reason: collision with root package name */
        public float f10632e;

        /* renamed from: f, reason: collision with root package name */
        public int f10633f;

        /* renamed from: g, reason: collision with root package name */
        public int f10634g;

        /* renamed from: h, reason: collision with root package name */
        public int f10635h;

        /* renamed from: i, reason: collision with root package name */
        public ValueAnimator f10636i;
        public int j;
        public int k;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f10637a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f10638b;

            public a(int i2, int i3) {
                this.f10637a = i2;
                this.f10638b = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                f fVar = f.this;
                fVar.b(c.c.a.c.a.a.a(fVar.j, this.f10637a, animatedFraction), c.c.a.c.a.a.a(f.this.k, this.f10638b, animatedFraction));
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f10640a;

            public b(int i2) {
                this.f10640a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f fVar = f.this;
                fVar.f10631d = this.f10640a;
                fVar.f10632e = 0.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f10631d = this.f10640a;
            }
        }

        public f(Context context) {
            super(context);
            this.f10631d = -1;
            this.f10633f = -1;
            this.f10634g = -1;
            this.f10635h = -1;
            this.j = -1;
            this.k = -1;
            setWillNotDraw(false);
            this.f10629b = new Paint();
            this.f10630c = new GradientDrawable();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.m;
            int i2 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i3 = this.f10628a;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.z;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                intrinsicHeight = i4 != 3 ? 0 : getHeight();
            }
            int i5 = this.f10634g;
            if (i5 >= 0 && this.f10635h > i5) {
                Drawable drawable2 = TabLayout.this.m;
                if (drawable2 == null) {
                    drawable2 = this.f10630c;
                }
                Drawable mutate = a.h.c.l.a.i(drawable2).mutate();
                mutate.setBounds(this.f10634g, i2, this.f10635h, intrinsicHeight);
                Paint paint = this.f10629b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        mutate.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        a.h.c.l.a.b(mutate, paint.getColor());
                    }
                }
                mutate.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f10636i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
            } else {
                a(false, this.f10631d, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (((int) r.a(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.x = 0;
                    tabLayout2.a(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f10633f == i2) {
                return;
            }
            requestLayout();
            this.f10633f = i2;
        }

        public void a(int i2) {
            if (this.f10629b.getColor() != i2) {
                this.f10629b.setColor(i2);
                y.N(this);
            }
        }

        public void b(int i2) {
            if (this.f10628a != i2) {
                this.f10628a = i2;
                y.N(this);
            }
        }

        public boolean a() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public final void b() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f10631d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i2 = childAt.getLeft();
                i3 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof TabView)) {
                    a((TabView) childAt, tabLayout.f10606c);
                    i2 = (int) TabLayout.this.f10606c.left;
                    i3 = (int) TabLayout.this.f10606c.right;
                }
                if (this.f10632e > 0.0f && this.f10631d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f10631d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof TabView)) {
                        a((TabView) childAt2, tabLayout2.f10606c);
                        left = (int) TabLayout.this.f10606c.left;
                        right = (int) TabLayout.this.f10606c.right;
                    }
                    float f2 = this.f10632e;
                    i2 = (int) ((left * f2) + ((1.0f - f2) * i2));
                    i3 = (int) ((right * f2) + ((1.0f - f2) * i3));
                }
            }
            b(i2, i3);
        }

        public void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.f10636i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f10636i.cancel();
            }
            this.f10631d = i2;
            this.f10632e = f2;
            b();
        }

        public void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.f10636i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f10636i.cancel();
            }
            a(true, i2, i3);
        }

        public final void a(boolean z, int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof TabView)) {
                a((TabView) childAt, tabLayout.f10606c);
                left = (int) TabLayout.this.f10606c.left;
                right = (int) TabLayout.this.f10606c.right;
            }
            int i4 = this.f10634g;
            int i5 = this.f10635h;
            if (i4 == left && i5 == right) {
                return;
            }
            if (z) {
                this.j = i4;
                this.k = i5;
            }
            a aVar = new a(left, right);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f10636i = valueAnimator;
                valueAnimator.setInterpolator(c.c.a.c.a.a.f5307b);
                valueAnimator.setDuration(i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.f10636i.removeAllUpdateListeners();
            this.f10636i.addUpdateListener(aVar);
        }

        public void b(int i2, int i3) {
            if (i2 == this.f10634g && i3 == this.f10635h) {
                return;
            }
            this.f10634g = i2;
            this.f10635h = i3;
            y.N(this);
        }

        public final void a(TabView tabView, RectF rectF) {
            int contentWidth = tabView.getContentWidth();
            int a2 = (int) r.a(getContext(), 24);
            if (contentWidth < a2) {
                contentWidth = a2;
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i2 = contentWidth / 2;
            rectF.set(left - i2, 0.0f, left + i2, 0.0f);
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f10642a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f10643b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10644c;

        /* renamed from: e, reason: collision with root package name */
        public View f10646e;

        /* renamed from: g, reason: collision with root package name */
        public TabLayout f10648g;

        /* renamed from: h, reason: collision with root package name */
        public TabView f10649h;

        /* renamed from: d, reason: collision with root package name */
        public int f10645d = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f10647f = 1;

        public int d() {
            return this.f10647f;
        }

        public CharSequence e() {
            return this.f10643b;
        }

        public boolean f() {
            TabLayout tabLayout = this.f10648g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f10645d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void g() {
            this.f10648g = null;
            this.f10649h = null;
            this.f10642a = null;
            this.f10643b = null;
            this.f10644c = null;
            this.f10645d = -1;
            this.f10646e = null;
        }

        public void h() {
            TabLayout tabLayout = this.f10648g;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.h(this);
        }

        public void i() {
            TabView tabView = this.f10649h;
            if (tabView != null) {
                tabView.h();
            }
        }

        public View a() {
            return this.f10646e;
        }

        public Drawable b() {
            return this.f10642a;
        }

        public int c() {
            return this.f10645d;
        }

        public g a(View view) {
            this.f10646e = view;
            i();
            return this;
        }

        public void b(int i2) {
            this.f10645d = i2;
        }

        public g b(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f10644c) && !TextUtils.isEmpty(charSequence)) {
                this.f10649h.setContentDescription(charSequence);
            }
            this.f10643b = charSequence;
            i();
            return this;
        }

        public g a(int i2) {
            a(LayoutInflater.from(this.f10649h.getContext()).inflate(i2, (ViewGroup) this.f10649h, false));
            return this;
        }

        public g a(Drawable drawable) {
            this.f10642a = drawable;
            TabLayout tabLayout = this.f10648g;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                this.f10648g.a(true);
            }
            i();
            if (c.c.a.c.c.a.f5356a && this.f10649h.b() && this.f10649h.f10617e.isVisible()) {
                this.f10649h.invalidate();
            }
            return this;
        }

        public g a(CharSequence charSequence) {
            this.f10644c = charSequence;
            i();
            return this;
        }
    }

    public static class h implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f10650a;

        /* renamed from: b, reason: collision with root package name */
        public int f10651b;

        /* renamed from: c, reason: collision with root package name */
        public int f10652c;

        public h(TabLayout tabLayout) {
            this.f10650a = new WeakReference<>(tabLayout);
        }

        public void a() {
            this.f10652c = 0;
            this.f10651b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i2) {
            this.f10651b = this.f10652c;
            this.f10652c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f10650a.get();
            if (tabLayout != null) {
                tabLayout.a(i2, f2, this.f10652c != 2 || this.f10651b == 1, (this.f10652c == 2 && this.f10651b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.f10650a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f10652c;
            tabLayout.b(tabLayout.c(i2), i3 == 0 || (i3 == 2 && this.f10651b == 0));
        }
    }

    public static class i implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager f10653a;

        public i(ViewPager viewPager) {
            this.f10653a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
            this.f10653a.setCurrentItem(gVar.c());
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private int getDefaultHeight() {
        int size = this.f10604a.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f10604a.get(i2);
                if (gVar != null && gVar.b() != null && !TextUtils.isEmpty(gVar.e())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.B) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.A;
        if (i3 == 0 || i3 == 2) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f10607d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f10607d.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f10607d.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public void addOnTabSelectedListener(d dVar) {
        addOnTabSelectedListener((c) dVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public final void b(g gVar) {
        TabView tabView = gVar.f10649h;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f10607d.addView(tabView, gVar.c(), b());
    }

    public g c() {
        g a2 = Q.a();
        return a2 == null ? new g() : a2;
    }

    public final void d(int i2) {
        TabView tabView = (TabView) this.f10607d.getChildAt(i2);
        this.f10607d.removeViewAt(i2);
        if (tabView != null) {
            tabView.e();
            this.O.a(tabView);
        }
        requestLayout();
    }

    public g e() {
        g c2 = c();
        c2.f10648g = this;
        c2.f10649h = c(c2);
        return c2;
    }

    public void f() {
        int currentItem;
        g();
        a.x.a.a aVar = this.J;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g e2 = e();
                e2.b(this.J.getPageTitle(i2));
                a(e2, false);
            }
            ViewPager viewPager = this.I;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            h(c(currentItem));
        }
    }

    public boolean g(g gVar) {
        return Q.a(gVar);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f10605b;
        if (gVar != null) {
            return gVar.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f10604a.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.k;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    public int getTabMaxWidth() {
        return this.r;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.l;
    }

    public Drawable getTabSelectedIndicator() {
        return this.m;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    public final void h() {
        int size = this.f10604a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10604a.get(i2).i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.c.a.c.w.i.a(this);
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager(null);
            this.N = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f10607d.getChildCount(); i2++) {
            View childAt = this.f10607d.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a.h.j.h0.c.a(accessibilityNodeInfo).a(c.b.a(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (r0 != 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L29;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = c.c.a.c.r.r.a(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.u
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = c.c.a.c.r.r.a(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.A
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void removeOnTabSelectedListener(d dVar) {
        removeOnTabSelectedListener((c) dVar);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c.c.a.c.w.i.a(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.B != z) {
            this.B = z;
            for (int i2 = 0; i2 < this.f10607d.getChildCount(); i2++) {
                View childAt = this.f10607d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).i();
                }
            }
            a();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        d();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            y.N(this.f10607d);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f10607d.a(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            y.N(this.f10607d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f10607d.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            a();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            h();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(a.b.b.a.a.b(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.C = z;
        y.N(this.f10607d);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            a();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            for (int i2 = 0; i2 < this.f10607d.getChildCount(); i2++) {
                View childAt = this.f10607d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(a.b.b.a.a.b(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            h();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a.x.a.a aVar) {
        a(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.D != z) {
            this.D = z;
            for (int i2 = 0; i2 < this.f10607d.getChildCount(); i2++) {
                View childAt = this.f10607d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public class b implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10625a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, a.x.a.a aVar, a.x.a.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.a(aVar2, this.f10625a);
            }
        }

        public void a(boolean z) {
            this.f10625a = z;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    public void a(int i2, float f2, boolean z) {
        a(i2, f2, z, true);
    }

    @Deprecated
    public void addOnTabSelectedListener(c cVar) {
        if (this.F.contains(cVar)) {
            return;
        }
        this.F.add(cVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    public void g() {
        for (int childCount = this.f10607d.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<g> it = this.f10604a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.g();
            g(next);
        }
        this.f10605b = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(c cVar) {
        this.F.remove(cVar);
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.E;
        if (cVar2 != null) {
            removeOnTabSelectedListener(cVar2);
        }
        this.E = cVar;
        if (cVar != null) {
            addOnTabSelectedListener(cVar);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, P), attributeSet, i2);
        this.f10604a = new ArrayList<>();
        this.f10606c = new RectF();
        this.r = Integer.MAX_VALUE;
        this.F = new ArrayList<>();
        this.O = new a.h.i.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f10607d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.TabLayout, i2, P, R$styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            c.c.a.c.w.h hVar = new c.c.a.c.w.h();
            hVar.a(ColorStateList.valueOf(colorDrawable.getColor()));
            hVar.a(context2);
            hVar.b(y.l(this));
            y.a(this, hVar);
        }
        this.f10607d.b(c2.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        this.f10607d.a(c2.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(c.c.a.c.t.c.b(context2, c2, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(c2.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(c2.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = c2.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f10611h = dimensionPixelSize;
        this.f10610g = dimensionPixelSize;
        this.f10609f = dimensionPixelSize;
        this.f10608e = dimensionPixelSize;
        this.f10608e = c2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f10609f = c2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f10609f);
        this.f10610g = c2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f10610g);
        this.f10611h = c2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f10611h);
        int resourceId = c2.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        this.f10612i = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.o = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.j = c.c.a.c.t.c.a(context2, obtainStyledAttributes, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (c2.hasValue(R$styleable.TabLayout_tabTextColor)) {
                this.j = c.c.a.c.t.c.a(context2, c2, R$styleable.TabLayout_tabTextColor);
            }
            if (c2.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
                this.j = a(this.j.getDefaultColor(), c2.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.k = c.c.a.c.t.c.a(context2, c2, R$styleable.TabLayout_tabIconTint);
            this.n = r.a(c2.getInt(R$styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.l = c.c.a.c.t.c.a(context2, c2, R$styleable.TabLayout_tabRippleColor);
            this.y = c2.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, InactivityTimer.INACTIVITY_DELAY_SECONDS);
            this.t = c2.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.u = c2.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.q = c2.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.w = c2.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.A = c2.getInt(R$styleable.TabLayout_tabMode, 1);
            this.x = c2.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.B = c2.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.D = c2.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            c2.recycle();
            Resources resources = getResources();
            this.p = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void a(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.f10607d.getChildCount()) {
            return;
        }
        if (z2) {
            this.f10607d.a(i2, f2);
        }
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public g c(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f10604a.get(i2);
    }

    public void h(g gVar) {
        b(gVar, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public final TabView c(g gVar) {
        a.h.i.e<TabView> eVar = this.O;
        TabView a2 = eVar != null ? eVar.a() : null;
        if (a2 == null) {
            a2 = new TabView(getContext());
        }
        a2.setTab(gVar);
        a2.setFocusable(true);
        a2.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f10644c)) {
            a2.setContentDescription(gVar.f10643b);
        } else {
            a2.setContentDescription(gVar.f10644c);
        }
        return a2;
    }

    public final void e(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).c(gVar);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(a.b.b.a.a.c(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public final LinearLayout.LayoutParams b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    public final void d() {
        if (this.H == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.H = valueAnimator;
            valueAnimator.setInterpolator(c.c.a.c.a.a.f5307b);
            this.H.setDuration(this.y);
            this.H.addUpdateListener(new a());
        }
    }

    public void b(g gVar, boolean z) {
        g gVar2 = this.f10605b;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                d(gVar);
                a(gVar.c());
                return;
            }
            return;
        }
        int c2 = gVar != null ? gVar.c() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.c() == -1) && c2 != -1) {
                a(c2, 0.0f, true);
            } else {
                a(c2);
            }
            if (c2 != -1) {
                setSelectedTabView(c2);
            }
        }
        this.f10605b = gVar;
        if (gVar2 != null) {
            f(gVar2);
        }
        if (gVar != null) {
            e(gVar);
        }
    }

    public final void f(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(gVar);
        }
    }

    public void a(g gVar) {
        a(gVar, this.f10604a.isEmpty());
    }

    public void a(g gVar, boolean z) {
        a(gVar, this.f10604a.size(), z);
    }

    public final void d(g gVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(gVar);
        }
    }

    public void a(g gVar, int i2, boolean z) {
        if (gVar.f10648g == this) {
            a(gVar, i2);
            b(gVar);
            if (z) {
                gVar.h();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final void a(TabItem tabItem) {
        g e2 = e();
        CharSequence charSequence = tabItem.f10601a;
        if (charSequence != null) {
            e2.b(charSequence);
        }
        Drawable drawable = tabItem.f10602b;
        if (drawable != null) {
            e2.a(drawable);
        }
        int i2 = tabItem.f10603c;
        if (i2 != 0) {
            e2.a(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            e2.a(tabItem.getContentDescription());
        }
        a(e2);
    }

    public final void b(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.f10607d.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.f10607d.setGravity(8388611);
    }

    public void a(ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    public final void a(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            h hVar = this.L;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.M;
            if (bVar != null) {
                this.I.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.G;
        if (cVar != null) {
            removeOnTabSelectedListener(cVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new h(this);
            }
            this.L.a();
            viewPager.addOnPageChangeListener(this.L);
            i iVar = new i(viewPager);
            this.G = iVar;
            addOnTabSelectedListener((c) iVar);
            a.x.a.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.M == null) {
                this.M = new b();
            }
            this.M.a(z);
            viewPager.addOnAdapterChangeListener(this.M);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.I = null;
            a((a.x.a.a) null, false);
        }
        this.N = z2;
    }

    public void a(a.x.a.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        a.x.a.a aVar2 = this.J;
        if (aVar2 != null && (dataSetObserver = this.K) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.J = aVar;
        if (z && aVar != null) {
            if (this.K == null) {
                this.K = new e();
            }
            aVar.registerDataSetObserver(this.K);
        }
        f();
    }

    public final void a(g gVar, int i2) {
        gVar.b(i2);
        this.f10604a.add(i2, gVar);
        int size = this.f10604a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.f10604a.get(i2).b(i2);
            }
        }
    }

    public final void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void a(LinearLayout.LayoutParams layoutParams) {
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public final void a(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && y.J(this) && !this.f10607d.a()) {
            int scrollX = getScrollX();
            int a2 = a(i2, 0.0f);
            if (scrollX != a2) {
                d();
                this.H.setIntValues(scrollX, a2);
                this.H.start();
            }
            this.f10607d.a(i2, this.y);
            return;
        }
        a(i2, 0.0f, true);
    }

    public final int a(int i2, float f2) {
        int i3 = this.A;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f10607d.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.f10607d.getChildCount() ? this.f10607d.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return y.q(this) == 0 ? left + i5 : left - i5;
    }

    public final void a() {
        int i2 = this.A;
        y.a(this.f10607d, (i2 == 0 || i2 == 2) ? Math.max(0, this.w - this.f10608e) : 0, 0, 0, 0);
        int i3 = this.A;
        if (i3 == 0) {
            b(this.x);
        } else if (i3 == 1 || i3 == 2) {
            if (this.x == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f10607d.setGravity(1);
        }
        a(true);
    }

    public void a(boolean z) {
        for (int i2 = 0; i2 < this.f10607d.getChildCount(); i2++) {
            View childAt = this.f10607d.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }
}
