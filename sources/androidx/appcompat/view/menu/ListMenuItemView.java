package androidx.appcompat.view.menu;

import a.b.e.j.i;
import a.b.e.j.n;
import a.b.f.g0;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public i f2170a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f2171b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f2172c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f2173d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f2174e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f2175f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f2176g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f2177h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f2178i;
    public Drawable j;
    public int k;
    public Context l;
    public boolean m;
    public Drawable n;
    public boolean o;
    public LayoutInflater p;
    public boolean q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f2176g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // a.b.e.j.n.a
    public void a(i iVar, int i2) {
        this.f2170a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a(this));
        setCheckable(iVar.isCheckable());
        a(iVar.m(), iVar.d());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2177h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2177h.getLayoutParams();
        rect.top += this.f2177h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // a.b.e.j.n.a
    public boolean b() {
        return false;
    }

    public final void c() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f2171b = imageView;
        a(imageView, 0);
    }

    public final void d() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f2172c = radioButton;
        a(radioButton);
    }

    @Override // a.b.e.j.n.a
    public i getItemData() {
        return this.f2170a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        y.a(this, this.j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f2173d = textView;
        int i2 = this.k;
        if (i2 != -1) {
            textView.setTextAppearance(this.l, i2);
        }
        this.f2175f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f2176g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.f2177h = (ImageView) findViewById(R$id.group_divider);
        this.f2178i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f2171b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2171b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f2172c == null && this.f2174e == null) {
            return;
        }
        if (this.f2170a.i()) {
            if (this.f2172c == null) {
                d();
            }
            compoundButton = this.f2172c;
            compoundButton2 = this.f2174e;
        } else {
            if (this.f2174e == null) {
                a();
            }
            compoundButton = this.f2174e;
            compoundButton2 = this.f2172c;
        }
        if (z) {
            compoundButton.setChecked(this.f2170a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2174e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2172c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2170a.i()) {
            if (this.f2172c == null) {
                d();
            }
            compoundButton = this.f2172c;
        } else {
            if (this.f2174e == null) {
                a();
            }
            compoundButton = this.f2174e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f2177h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f2170a.l() || this.q;
        if (z || this.m) {
            if (this.f2171b == null && drawable == null && !this.m) {
                return;
            }
            if (this.f2171b == null) {
                c();
            }
            if (drawable == null && !this.m) {
                this.f2171b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f2171b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f2171b.getVisibility() != 0) {
                this.f2171b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f2173d.getVisibility() != 8) {
                this.f2173d.setVisibility(8);
            }
        } else {
            this.f2173d.setText(charSequence);
            if (this.f2173d.getVisibility() != 0) {
                this.f2173d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        g0 a2 = g0.a(getContext(), attributeSet, R$styleable.MenuView, i2, 0);
        this.j = a2.b(R$styleable.MenuView_android_itemBackground);
        this.k = a2.g(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.b(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.b();
        obtainStyledAttributes.recycle();
    }

    public final void a(View view) {
        a(view, -1);
    }

    public final void a(View view, int i2) {
        LinearLayout linearLayout = this.f2178i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (z && this.f2170a.m()) ? 0 : 8;
        if (i2 == 0) {
            this.f2175f.setText(this.f2170a.e());
        }
        if (this.f2175f.getVisibility() != i2) {
            this.f2175f.setVisibility(i2);
        }
    }

    public final void a() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f2174e = checkBox;
        a(checkBox);
    }
}
