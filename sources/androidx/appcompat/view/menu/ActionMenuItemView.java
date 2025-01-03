package androidx.appcompat.view.menu;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.n;
import a.b.e.j.p;
import a.b.f.i0;
import a.b.f.u;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: f, reason: collision with root package name */
    public i f2163f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f2164g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f2165h;

    /* renamed from: i, reason: collision with root package name */
    public g.b f2166i;
    public u j;
    public b k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    public class a extends u {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // a.b.f.u
        public p b() {
            b bVar = ActionMenuItemView.this.k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // a.b.f.u
        public boolean c() {
            p b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f2166i;
            return bVar != null && bVar.a(actionMenuItemView.f2163f) && (b2 = b()) != null && b2.a();
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // a.b.e.j.n.a
    public void a(i iVar, int i2) {
        this.f2163f = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.j == null) {
            this.j = new a();
        }
    }

    @Override // a.b.e.j.n.a
    public boolean b() {
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return e() && this.f2163f.getIcon() == null;
    }

    public boolean e() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void g() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f2164g);
        if (this.f2165h != null && (!this.f2163f.n() || (!this.l && !this.m))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f2164g : null);
        CharSequence contentDescription = this.f2163f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f2163f.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f2163f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            i0.a(this, z3 ? null : this.f2163f.getTitle());
        } else {
            i0.a(this, tooltipText);
        }
    }

    @Override // a.b.e.j.n.a
    public i getItemData() {
        return this.f2163f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f2166i;
        if (bVar != null) {
            bVar.a(this.f2163f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.l = f();
        g();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean e2 = e();
        if (e2 && (i4 = this.o) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.n) : this.n;
        if (mode != 1073741824 && this.n > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, MemoryConstants.GB), i3);
        }
        if (e2 || this.f2165h == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2165h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        u uVar;
        if (this.f2163f.hasSubMenu() && (uVar = this.j) != null && uVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.m != z) {
            this.m = z;
            i iVar = this.f2163f;
            if (iVar != null) {
                iVar.b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2165h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.p;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            int i3 = this.p;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(g.b bVar) {
        this.f2166i = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.o = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2164g = charSequence;
        g();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.l = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i2, 0);
        this.n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.o = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return e();
    }
}
