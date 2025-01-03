package androidx.viewpager.widget;

import a.h.k.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.he.Constant;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.e
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {
    public static final int[] o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    public static final int[] p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f2837a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f2838b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f2839c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f2840d;

    /* renamed from: e, reason: collision with root package name */
    public int f2841e;

    /* renamed from: f, reason: collision with root package name */
    public float f2842f;

    /* renamed from: g, reason: collision with root package name */
    public int f2843g;

    /* renamed from: h, reason: collision with root package name */
    public int f2844h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2845i;
    public boolean j;
    public final a k;
    public WeakReference<a.x.a.a> l;
    public int m;
    public int n;

    public class a extends DataSetObserver implements ViewPager.j, ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public int f2846a;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, a.x.a.a aVar, a.x.a.a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a(pagerTitleStrip.f2837a.getCurrentItem(), PagerTitleStrip.this.f2837a.getAdapter());
            float f2 = PagerTitleStrip.this.f2842f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.f2837a.getCurrentItem(), f2, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i2) {
            this.f2846a = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.a(i2, f2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i2) {
            if (this.f2846a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a(pagerTitleStrip.f2837a.getCurrentItem(), PagerTitleStrip.this.f2837a.getAdapter());
                float f2 = PagerTitleStrip.this.f2842f;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.f2837a.getCurrentItem(), f2, true);
            }
        }
    }

    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        public Locale f2848a;

        public b(Context context) {
            this.f2848a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f2848a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i2, float f2) {
        this.f2838b.setTextSize(i2, f2);
        this.f2839c.setTextSize(i2, f2);
        this.f2840d.setTextSize(i2, f2);
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f2843g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        a.x.a.a adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.k);
        viewPager.addOnAdapterChangeListener(this.k);
        this.f2837a = viewPager;
        WeakReference<a.x.a.a> weakReference = this.l;
        a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f2837a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (a.x.a.a) null);
            this.f2837a.setInternalPageChangeListener(null);
            this.f2837a.removeOnAdapterChangeListener(this.k);
            this.f2837a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f2837a != null) {
            float f2 = this.f2842f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            a(this.f2841e, f2, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int max;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
        this.f2838b.measure(childMeasureSpec2, childMeasureSpec);
        this.f2839c.measure(childMeasureSpec2, childMeasureSpec);
        this.f2840d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            max = View.MeasureSpec.getSize(i3);
        } else {
            max = Math.max(getMinHeight(), this.f2839c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i3, this.f2839c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2845i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.f2844h = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        int i2 = ((int) (f2 * 255.0f)) & ViewfinderView.OPAQUE;
        this.m = i2;
        int i3 = (i2 << 24) | (this.n & Constant.PPPP_STATUS_UNKNOWN);
        this.f2838b.setTextColor(i3);
        this.f2840d.setTextColor(i3);
    }

    public void setTextColor(int i2) {
        this.n = i2;
        this.f2839c.setTextColor(i2);
        int i3 = (this.m << 24) | (this.n & Constant.PPPP_STATUS_UNKNOWN);
        this.f2838b.setTextColor(i3);
        this.f2840d.setTextColor(i3);
    }

    public void setTextSpacing(int i2) {
        this.f2843g = i2;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2841e = -1;
        this.f2842f = -1.0f;
        this.k = new a();
        TextView textView = new TextView(context);
        this.f2838b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2839c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f2840d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            i.d(this.f2838b, resourceId);
            i.d(this.f2839c, resourceId);
            i.d(this.f2840d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f2838b.setTextColor(color);
            this.f2839c.setTextColor(color);
            this.f2840d.setTextColor(color);
        }
        this.f2844h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.n = this.f2839c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f2838b.setEllipsize(TextUtils.TruncateAt.END);
        this.f2839c.setEllipsize(TextUtils.TruncateAt.END);
        this.f2840d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, p);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f2838b);
            setSingleLineAllCaps(this.f2839c);
            setSingleLineAllCaps(this.f2840d);
        } else {
            this.f2838b.setSingleLine();
            this.f2839c.setSingleLine();
            this.f2840d.setSingleLine();
        }
        this.f2843g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void a(int i2, a.x.a.a aVar) {
        int count = aVar != null ? aVar.getCount() : 0;
        this.f2845i = true;
        CharSequence charSequence = null;
        this.f2838b.setText((i2 < 1 || aVar == null) ? null : aVar.getPageTitle(i2 - 1));
        this.f2839c.setText((aVar == null || i2 >= count) ? null : aVar.getPageTitle(i2));
        int i3 = i2 + 1;
        if (i3 < count && aVar != null) {
            charSequence = aVar.getPageTitle(i3);
        }
        this.f2840d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f2838b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f2839c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f2840d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f2841e = i2;
        if (!this.j) {
            a(i2, this.f2842f, false);
        }
        this.f2845i = false;
    }

    public void a(a.x.a.a aVar, a.x.a.a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.k);
            this.l = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.k);
            this.l = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f2837a;
        if (viewPager != null) {
            this.f2841e = -1;
            this.f2842f = -1.0f;
            a(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    public void a(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.f2841e) {
            a(i2, this.f2837a.getAdapter());
        } else if (!z && f2 == this.f2842f) {
            return;
        }
        this.j = true;
        int measuredWidth = this.f2838b.getMeasuredWidth();
        int measuredWidth2 = this.f2839c.getMeasuredWidth();
        int measuredWidth3 = this.f2840d.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (i9 * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.f2838b.getBaseline();
        int baseline2 = this.f2839c.getBaseline();
        int baseline3 = this.f2840d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = max - baseline;
        int i13 = max - baseline2;
        int i14 = max - baseline3;
        int max2 = Math.max(Math.max(this.f2838b.getMeasuredHeight() + i12, this.f2839c.getMeasuredHeight() + i13), this.f2840d.getMeasuredHeight() + i14);
        int i15 = this.f2844h & 112;
        if (i15 == 16) {
            i3 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else {
            if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = i13 + paddingTop;
                i6 = paddingTop + i14;
                TextView textView = this.f2839c;
                textView.layout(i10, i5, i11, textView.getMeasuredHeight() + i5);
                int min = Math.min(paddingLeft, (i10 - this.f2843g) - measuredWidth);
                TextView textView2 = this.f2838b;
                textView2.layout(min, i4, measuredWidth + min, textView2.getMeasuredHeight() + i4);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f2843g);
                TextView textView3 = this.f2840d;
                textView3.layout(max3, i6, max3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.f2842f = f2;
                this.j = false;
            }
            i3 = (height - paddingBottom) - max2;
        }
        i4 = i12 + i3;
        i5 = i13 + i3;
        i6 = i3 + i14;
        TextView textView4 = this.f2839c;
        textView4.layout(i10, i5, i11, textView4.getMeasuredHeight() + i5);
        int min2 = Math.min(paddingLeft, (i10 - this.f2843g) - measuredWidth);
        TextView textView22 = this.f2838b;
        textView22.layout(min2, i4, measuredWidth + min2, textView22.getMeasuredHeight() + i4);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f2843g);
        TextView textView32 = this.f2840d;
        textView32.layout(max32, i6, max32 + measuredWidth3, textView32.getMeasuredHeight() + i6);
        this.f2842f = f2;
        this.j = false;
    }
}
