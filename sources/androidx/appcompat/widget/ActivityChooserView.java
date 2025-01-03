package androidx.appcompat.widget;

import a.b.e.j.p;
import a.b.f.g0;
import a.b.f.u;
import a.b.f.v;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final f f2215a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2216b;

    /* renamed from: c, reason: collision with root package name */
    public final View f2217c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f2218d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f2219e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f2220f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f2221g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f2222h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2223i;
    public a.h.j.b j;
    public final DataSetObserver k;
    public final ViewTreeObserver.OnGlobalLayoutListener l;
    public v m;
    public PopupWindow.OnDismissListener n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f2224a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            g0 a2 = g0.a(context, attributeSet, f2224a);
            setBackgroundDrawable(a2.b(0));
            a2.b();
        }
    }

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f2215a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f2215a.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().d();
                a.h.j.b bVar = ActivityChooserView.this.j;
                if (bVar != null) {
                    bVar.a(true);
                }
            }
        }
    }

    public class c extends View.AccessibilityDelegate {
        public c(ActivityChooserView activityChooserView) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            a.h.j.h0.c.a(accessibilityNodeInfo).b(true);
        }
    }

    public class d extends u {
        public d(View view) {
            super(view);
        }

        @Override // a.b.f.u
        public p b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // a.b.f.u
        public boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // a.b.f.u
        public boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.d();
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2221g) {
                if (view != activityChooserView.f2219e) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.o = false;
                activityChooserView.a(activityChooserView.p);
                return;
            }
            activityChooserView.a();
            Intent a2 = ActivityChooserView.this.f2215a.b().a(ActivityChooserView.this.f2215a.b().a(ActivityChooserView.this.f2215a.c()));
            if (a2 != null) {
                a2.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(a2);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            a.h.j.b bVar = ActivityChooserView.this.j;
            if (bVar != null) {
                bVar.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.a(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.o) {
                if (i2 > 0) {
                    activityChooserView.f2215a.b().c(i2);
                    return;
                }
                return;
            }
            if (!activityChooserView.f2215a.e()) {
                i2++;
            }
            Intent a2 = ActivityChooserView.this.f2215a.b().a(i2);
            if (a2 != null) {
                a2.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(a2);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2221g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f2215a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.o = true;
                activityChooserView2.a(activityChooserView2.p);
            }
            return true;
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    public void a(int i2) {
        if (this.f2215a.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        ?? r0 = this.f2221g.getVisibility() == 0 ? 1 : 0;
        int a2 = this.f2215a.a();
        if (i2 == Integer.MAX_VALUE || a2 <= i2 + r0) {
            this.f2215a.a(false);
            this.f2215a.a(i2);
        } else {
            this.f2215a.a(true);
            this.f2215a.a(i2 - 1);
        }
        v listPopupWindow = getListPopupWindow();
        if (listPopupWindow.a()) {
            return;
        }
        if (this.o || r0 == 0) {
            this.f2215a.a(true, r0);
        } else {
            this.f2215a.a(false, false);
        }
        listPopupWindow.e(Math.min(this.f2215a.f(), this.f2223i));
        listPopupWindow.d();
        a.h.j.b bVar = this.j;
        if (bVar != null) {
            bVar.a(true);
        }
        listPopupWindow.e().setContentDescription(getContext().getString(R$string.abc_activitychooserview_choose_application));
        listPopupWindow.e().setSelector(new ColorDrawable(0));
    }

    public boolean b() {
        return getListPopupWindow().a();
    }

    public boolean c() {
        if (b() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    public void d() {
        if (this.f2215a.getCount() > 0) {
            this.f2219e.setEnabled(true);
        } else {
            this.f2219e.setEnabled(false);
        }
        int a2 = this.f2215a.a();
        int d2 = this.f2215a.d();
        if (a2 == 1 || (a2 > 1 && d2 > 0)) {
            this.f2221g.setVisibility(0);
            ResolveInfo c2 = this.f2215a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f2222h.setImageDrawable(c2.loadIcon(packageManager));
            if (this.r != 0) {
                this.f2221g.setContentDescription(getContext().getString(this.r, c2.loadLabel(packageManager)));
            }
        } else {
            this.f2221g.setVisibility(8);
        }
        if (this.f2221g.getVisibility() == 0) {
            this.f2217c.setBackgroundDrawable(this.f2218d);
        } else {
            this.f2217c.setBackgroundDrawable(null);
        }
    }

    public a.b.f.c getDataModel() {
        return this.f2215a.b();
    }

    public v getListPopupWindow() {
        if (this.m == null) {
            v vVar = new v(getContext());
            this.m = vVar;
            vVar.a(this.f2215a);
            this.m.a(this);
            this.m.a(true);
            this.m.setOnItemClickListener(this.f2216b);
            this.m.setOnDismissListener(this.f2216b);
        }
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.b.f.c b2 = this.f2215a.b();
        if (b2 != null) {
            b2.registerObserver(this.k);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.b.f.c b2 = this.f2215a.b();
        if (b2 != null) {
            b2.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (b()) {
            a();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f2217c.layout(0, 0, i4 - i2, i5 - i3);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        View view = this.f2217c;
        if (this.f2221g.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), MemoryConstants.GB);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(a.b.f.c cVar) {
        this.f2215a.a(cVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.r = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f2220f.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2220f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.p = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setProvider(a.h.j.b bVar) {
        this.j = bVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new a();
        this.l = new b();
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i2, 0);
        y.a(this, context, R$styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i2, 0);
        this.p = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f2216b = new g();
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.f2217c = findViewById;
        this.f2218d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f2221g = frameLayout;
        frameLayout.setOnClickListener(this.f2216b);
        this.f2221g.setOnLongClickListener(this.f2216b);
        this.f2222h = (ImageView) this.f2221g.findViewById(R$id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(this.f2216b);
        frameLayout2.setAccessibilityDelegate(new c(this));
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f2219e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.f2220f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f2215a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f2223i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public a.b.f.c f2228a;

        /* renamed from: b, reason: collision with root package name */
        public int f2229b = 4;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2230c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2231d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2232e;

        public f() {
        }

        public void a(a.b.f.c cVar) {
            a.b.f.c b2 = ActivityChooserView.this.f2215a.b();
            if (b2 != null && ActivityChooserView.this.isShown()) {
                b2.unregisterObserver(ActivityChooserView.this.k);
            }
            this.f2228a = cVar;
            if (cVar != null && ActivityChooserView.this.isShown()) {
                cVar.registerObserver(ActivityChooserView.this.k);
            }
            notifyDataSetChanged();
        }

        public a.b.f.c b() {
            return this.f2228a;
        }

        public ResolveInfo c() {
            return this.f2228a.c();
        }

        public int d() {
            return this.f2228a.d();
        }

        public boolean e() {
            return this.f2230c;
        }

        public int f() {
            int i2 = this.f2229b;
            this.f2229b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            this.f2229b = i2;
            return i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int b2 = this.f2228a.b();
            if (!this.f2230c && this.f2228a.c() != null) {
                b2--;
            }
            int min = Math.min(b2, this.f2229b);
            return this.f2232e ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f2230c && this.f2228a.c() != null) {
                i2++;
            }
            return this.f2228a.b(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return (this.f2232e && i2 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return inflate;
            }
            if (view == null || view.getId() != R$id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f2230c && i2 == 0 && this.f2231d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(int i2) {
            if (this.f2229b != i2) {
                this.f2229b = i2;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z) {
            if (this.f2232e != z) {
                this.f2232e = z;
                notifyDataSetChanged();
            }
        }

        public int a() {
            return this.f2228a.b();
        }

        public void a(boolean z, boolean z2) {
            if (this.f2230c == z && this.f2231d == z2) {
                return;
            }
            this.f2230c = z;
            this.f2231d = z2;
            notifyDataSetChanged();
        }
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        return true;
    }
}
