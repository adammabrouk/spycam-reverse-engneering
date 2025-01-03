package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.he.Constant;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public int G;
    public int q;
    public int r;
    public int t;
    public int u;
    public int v;
    public int w;
    public final Paint x;
    public final Rect y;
    public int z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.f2837a.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f2837a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void a(int i2, float f2, boolean z) {
        Rect rect = this.y;
        int height = getHeight();
        int left = this.f2839c.getLeft() - this.w;
        int right = this.f2839c.getRight() + this.w;
        int i3 = height - this.r;
        rect.set(left, i3, right, height);
        super.a(i2, f2, z);
        this.z = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f2839c.getLeft() - this.w, i3, this.f2839c.getRight() + this.w, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.A;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.v);
    }

    public int getTabIndicatorColor() {
        return this.q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f2839c.getLeft() - this.w;
        int right = this.f2839c.getRight() + this.w;
        int i2 = height - this.r;
        this.x.setColor((this.z << 24) | (this.q & Constant.PPPP_STATUS_UNKNOWN));
        float f2 = height;
        canvas.drawRect(left, i2, right, f2, this.x);
        if (this.A) {
            this.x.setColor((-16777216) | (this.q & Constant.PPPP_STATUS_UNKNOWN));
            canvas.drawRect(getPaddingLeft(), height - this.C, getWidth() - getPaddingRight(), f2, this.x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.D) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.E = x;
            this.F = y;
            this.D = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.E) > this.G || Math.abs(y - this.F) > this.G)) {
                this.D = true;
            }
        } else if (x < this.f2839c.getLeft() - this.w) {
            ViewPager viewPager = this.f2837a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x > this.f2839c.getRight() + this.w) {
            ViewPager viewPager2 = this.f2837a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (this.B) {
            return;
        }
        this.A = (i2 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.B) {
            return;
        }
        this.A = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.B) {
            return;
        }
        this.A = i2 == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.A = z;
        this.B = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.t;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(int i2) {
        this.q = i2;
        this.x.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        setTabIndicatorColor(a.h.b.a.a(getContext(), i2));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i2) {
        int i3 = this.u;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new Paint();
        this.y = new Rect();
        this.z = ViewfinderView.OPAQUE;
        this.A = false;
        this.B = false;
        int i2 = this.n;
        this.q = i2;
        this.x.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f2) + 0.5f);
        this.t = (int) ((6.0f * f2) + 0.5f);
        this.u = (int) (64.0f * f2);
        this.w = (int) ((16.0f * f2) + 0.5f);
        this.C = (int) ((1.0f * f2) + 0.5f);
        this.v = (int) ((f2 * 32.0f) + 0.5f);
        this.G = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f2838b.setFocusable(true);
        this.f2838b.setOnClickListener(new a());
        this.f2840d.setFocusable(true);
        this.f2840d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.A = true;
        }
    }
}
