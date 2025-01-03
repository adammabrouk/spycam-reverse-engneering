package androidx.appcompat.widget;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.l;
import a.b.e.j.m;
import a.b.e.j.n;
import a.b.e.j.p;
import a.b.e.j.r;
import a.b.f.i0;
import a.b.f.u;
import a.h.j.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActionMenuPresenter extends a.b.e.j.b implements b.a {
    public c A;
    public b B;
    public final f C;
    public int D;
    public d j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public final SparseBooleanArray x;
    public e y;
    public a z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2202a;

        public class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2202a);
        }

        public SavedState(Parcel parcel) {
            this.f2202a = parcel.readInt();
        }
    }

    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).h()) {
                View view2 = ActionMenuPresenter.this.j;
                a(view2 == null ? (View) ActionMenuPresenter.this.f318h : view2);
            }
            a(ActionMenuPresenter.this.C);
        }

        @Override // a.b.e.j.l
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.z = null;
            actionMenuPresenter.D = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public p a() {
            a aVar = ActionMenuPresenter.this.z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public e f2204a;

        public c(e eVar) {
            this.f2204a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f313c != null) {
                ActionMenuPresenter.this.f313c.a();
            }
            View view = (View) ActionMenuPresenter.this.f318h;
            if (view != null && view.getWindowToken() != null && this.f2204a.g()) {
                ActionMenuPresenter.this.y = this.f2204a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        public class a extends u {
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            @Override // a.b.f.u
            public p b() {
                e eVar = ActionMenuPresenter.this.y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // a.b.f.u
            public boolean c() {
                ActionMenuPresenter.this.k();
                return true;
            }

            @Override // a.b.f.u
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.e();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            i0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.k();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                a.h.c.l.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends l {
        public e(Context context, g gVar, View view, boolean z) {
            super(context, gVar, view, z, R$attr.actionOverflowMenuStyle);
            a(8388613);
            a(ActionMenuPresenter.this.C);
        }

        @Override // a.b.e.j.l
        public void e() {
            if (ActionMenuPresenter.this.f313c != null) {
                ActionMenuPresenter.this.f313c.close();
            }
            ActionMenuPresenter.this.y = null;
            super.e();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.C = new f();
    }

    public boolean h() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean i() {
        return this.A != null || j();
    }

    public boolean j() {
        e eVar = this.y;
        return eVar != null && eVar.d();
    }

    public boolean k() {
        g gVar;
        if (!this.m || j() || (gVar = this.f313c) == null || this.f318h == null || this.A != null || gVar.j().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f312b, this.f313c, this.j, true));
        this.A = cVar;
        ((View) this.f318h).post(cVar);
        return true;
    }

    @Override // a.b.e.j.b, a.b.e.j.m
    public void a(Context context, g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        a.b.e.a a2 = a.b.e.a.a(context);
        if (!this.n) {
            this.m = a2.g();
        }
        if (!this.u) {
            this.o = a2.b();
        }
        if (!this.r) {
            this.q = a2.c();
        }
        int i2 = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.f311a);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = i2;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // a.b.e.j.b
    public n b(ViewGroup viewGroup) {
        n nVar = this.f318h;
        n b2 = super.b(viewGroup);
        if (nVar != b2) {
            ((ActionMenuView) b2).setPresenter(this);
        }
        return b2;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void d(boolean z) {
        this.m = z;
        this.n = true;
    }

    public boolean e() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.f318h) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    @Override // a.b.e.j.m
    public boolean f() {
        ArrayList<i> arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        ActionMenuPresenter actionMenuPresenter = this;
        g gVar = actionMenuPresenter.f313c;
        View view = null;
        int i6 = 0;
        if (gVar != null) {
            arrayList = gVar.n();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.q;
        int i8 = actionMenuPresenter.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f318h;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            i iVar = arrayList.get(i11);
            if (iVar.k()) {
                i9++;
            } else if (iVar.j()) {
                i10++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.v && iVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.m && (z || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i13 = actionMenuPresenter.w;
            i4 = i8 / i13;
            i3 = i13 + ((i8 % i13) / i4);
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i2) {
            i iVar2 = arrayList.get(i14);
            if (iVar2.k()) {
                View a2 = actionMenuPresenter.a(iVar2, view, viewGroup);
                if (actionMenuPresenter.t) {
                    i4 -= ActionMenuView.b(a2, i3, i4, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.d(true);
                i5 = i2;
            } else if (iVar2.j()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i12 > 0 || z2) && i8 > 0 && (!actionMenuPresenter.t || i4 > 0);
                boolean z4 = z3;
                i5 = i2;
                if (z3) {
                    View a3 = actionMenuPresenter.a(iVar2, null, viewGroup);
                    if (actionMenuPresenter.t) {
                        int b2 = ActionMenuView.b(a3, i3, i4, makeMeasureSpec, 0);
                        i4 -= b2;
                        if (b2 == 0) {
                            z4 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.t ? i8 + i15 <= 0 : i8 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        i iVar3 = arrayList.get(i16);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.h()) {
                                i12++;
                            }
                            iVar3.d(false);
                        }
                    }
                }
                if (z3) {
                    i12--;
                }
                iVar2.d(z3);
            } else {
                i5 = i2;
                iVar2.d(false);
                i14++;
                i2 = i5;
                view = null;
                i6 = 0;
                actionMenuPresenter = this;
            }
            i14++;
            i2 = i5;
            view = null;
            i6 = 0;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f2202a = this.D;
        return savedState;
    }

    public class f implements m.a {
        public f() {
        }

        @Override // a.b.e.j.m.a
        public boolean a(g gVar) {
            if (gVar == ActionMenuPresenter.this.f313c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((r) gVar).getItem().getItemId();
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(gVar);
            }
            return false;
        }

        @Override // a.b.e.j.m.a
        public void a(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.m().a(false);
            }
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(gVar, z);
            }
        }
    }

    public Drawable d() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.l) {
            return this.k;
        }
        return null;
    }

    public boolean b() {
        return e() | h();
    }

    @Override // a.h.j.b.a
    public void b(boolean z) {
        if (z) {
            super.a((r) null);
            return;
        }
        g gVar = this.f313c;
        if (gVar != null) {
            gVar.a(false);
        }
    }

    public void a(Configuration configuration) {
        if (!this.r) {
            this.q = a.b.e.a.a(this.f312b).c();
        }
        g gVar = this.f313c;
        if (gVar != null) {
            gVar.c(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.l = true;
            this.k = drawable;
        }
    }

    @Override // a.b.e.j.b
    public View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.f()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // a.b.e.j.b
    public void a(i iVar, n.a aVar) {
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f318h);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // a.b.e.j.b
    public boolean a(int i2, i iVar) {
        return iVar.h();
    }

    @Override // a.b.e.j.b, a.b.e.j.m
    public void a(boolean z) {
        super.a(z);
        ((View) this.f318h).requestLayout();
        g gVar = this.f313c;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<i> c2 = gVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.h.j.b a2 = c2.get(i2).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        g gVar2 = this.f313c;
        ArrayList<i> j = gVar2 != null ? gVar2.j() : null;
        if (this.m && j != null) {
            int size2 = j.size();
            if (size2 == 1) {
                z2 = !j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.j == null) {
                this.j = new d(this.f311a);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.f318h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f318h;
                actionMenuView.addView(this.j, actionMenuView.e());
            }
        } else {
            d dVar = this.j;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f318h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.j);
                }
            }
        }
        ((ActionMenuView) this.f318h).setOverflowReserved(this.m);
    }

    @Override // a.b.e.j.b
    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.j) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    @Override // a.b.e.j.b, a.b.e.j.m
    public boolean a(r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.t() != this.f313c) {
            rVar2 = (r) rVar2.t();
        }
        View a2 = a(rVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.D = rVar.getItem().getItemId();
        int size = rVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f312b, rVar, a2);
        this.z = aVar;
        aVar.a(z);
        this.z.f();
        super.a(rVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f318h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // a.b.e.j.b, a.b.e.j.m
    public void a(g gVar, boolean z) {
        b();
        super.a(gVar, z);
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).f2202a) > 0 && (findItem = this.f313c.findItem(i2)) != null) {
            a((r) findItem.getSubMenu());
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f318h = actionMenuView;
        actionMenuView.a(this.f313c);
    }
}
