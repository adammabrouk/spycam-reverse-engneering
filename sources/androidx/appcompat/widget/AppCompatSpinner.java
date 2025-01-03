package androidx.appcompat.widget;

import a.b.a.c;
import a.b.e.j.p;
import a.b.f.c0;
import a.b.f.m0;
import a.b.f.u;
import a.b.f.v;
import a.h.j.x;
import a.h.j.y;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements x {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2259i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final a.b.f.d f2260a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2261b;

    /* renamed from: c, reason: collision with root package name */
    public u f2262c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f2263d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2264e;

    /* renamed from: f, reason: collision with root package name */
    public f f2265f;

    /* renamed from: g, reason: collision with root package name */
    public int f2266g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f2267h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f2268a;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f2268a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2268a = parcel.readByte() != 0;
        }
    }

    public class a extends u {
        public final /* synthetic */ e j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, e eVar) {
            super(view);
            this.j = eVar;
        }

        @Override // a.b.f.u
        public p b() {
            return this.j;
        }

        @Override // a.b.f.u
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().a()) {
                return true;
            }
            AppCompatSpinner.this.a();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().a()) {
                AppCompatSpinner.this.a();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    public class c implements f, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public a.b.a.c f2270a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f2271b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f2272c;

        public c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public boolean a() {
            a.b.a.c cVar = this.f2270a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int b() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void b(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public Drawable c() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void dismiss() {
            a.b.a.c cVar = this.f2270a;
            if (cVar != null) {
                cVar.dismiss();
                this.f2270a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence g() {
            return this.f2272c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i2, this.f2271b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(ListAdapter listAdapter) {
            this.f2271b = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(CharSequence charSequence) {
            this.f2272c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(int i2, int i3) {
            if (this.f2271b == null) {
                return;
            }
            c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f2272c;
            if (charSequence != null) {
                aVar.a(charSequence);
            }
            aVar.a(this.f2271b, AppCompatSpinner.this.getSelectedItemPosition(), this);
            a.b.a.c a2 = aVar.a();
            this.f2270a = a2;
            ListView b2 = a2.b();
            if (Build.VERSION.SDK_INT >= 17) {
                b2.setTextDirection(i2);
                b2.setTextAlignment(i3);
            }
            this.f2270a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f2274a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f2275b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2274a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2275b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof c0) {
                    c0 c0Var = (c0) spinnerAdapter;
                    if (c0Var.getDropDownViewTheme() == null) {
                        c0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2275b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f2275b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2274a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class e extends v implements f {
        public CharSequence J;
        public ListAdapter K;
        public final Rect L;
        public int M;

        public class a implements AdapterView.OnItemClickListener {
            public a(AppCompatSpinner appCompatSpinner) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                AppCompatSpinner.this.setSelection(i2);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    AppCompatSpinner.this.performItemClick(view, i2, eVar.K.getItemId(i2));
                }
                e.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.b(AppCompatSpinner.this)) {
                    e.this.dismiss();
                } else {
                    e.this.s();
                    e.super.d();
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2278a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2278a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2278a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.L = new Rect();
            a(AppCompatSpinner.this);
            a(true);
            h(0);
            setOnItemClickListener(new a(AppCompatSpinner.this));
        }

        public boolean b(View view) {
            return y.I(view) && view.getGlobalVisibleRect(this.L);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence g() {
            return this.J;
        }

        public void s() {
            Drawable c2 = c();
            int i2 = 0;
            if (c2 != null) {
                c2.getPadding(AppCompatSpinner.this.f2267h);
                i2 = m0.a(AppCompatSpinner.this) ? AppCompatSpinner.this.f2267h.right : -AppCompatSpinner.this.f2267h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f2267h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i3 = appCompatSpinner.f2266g;
            if (i3 == -2) {
                int a2 = appCompatSpinner.a((SpinnerAdapter) this.K, c());
                int i4 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f2267h;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                e(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                e((width - paddingLeft) - paddingRight);
            } else {
                e(i3);
            }
            c(m0.a(AppCompatSpinner.this) ? i2 + (((width - paddingRight) - o()) - t()) : i2 + paddingLeft + t());
        }

        public int t() {
            return this.M;
        }

        @Override // a.b.f.v, androidx.appcompat.widget.AppCompatSpinner.f
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.K = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void b(int i2) {
            this.M = i2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void a(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean a2 = a();
            s();
            g(2);
            super.d();
            ListView e2 = e();
            e2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                e2.setTextDirection(i2);
                e2.setTextAlignment(i3);
            }
            i(AppCompatSpinner.this.getSelectedItemPosition());
            if (a2 || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            setOnDismissListener(new c(bVar));
        }
    }

    public interface f {
        void a(int i2);

        void a(int i2, int i3);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        boolean a();

        int b();

        void b(int i2);

        Drawable c();

        void c(int i2);

        void dismiss();

        int f();

        CharSequence g();
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f2267h);
        Rect rect = this.f2267h;
        return i3 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.f2265f;
        if (fVar != null) {
            return fVar.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.f2265f;
        if (fVar != null) {
            return fVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f2265f != null) {
            return this.f2266g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public final f getInternalPopup() {
        return this.f2265f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.f2265f;
        if (fVar != null) {
            return fVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2261b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.f2265f;
        return fVar != null ? fVar.g() : super.getPrompt();
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f2265f;
        if (fVar == null || !fVar.a()) {
            return;
        }
        this.f2265f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2265f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f2268a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.f2265f;
        savedState.f2268a = fVar != null && fVar.a();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        u uVar = this.f2262c;
        if (uVar == null || !uVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        f fVar = this.f2265f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.a()) {
            return true;
        }
        a();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.f2265f;
        if (fVar != null) {
            fVar.b(i2);
            this.f2265f.c(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.f2265f;
        if (fVar != null) {
            fVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f2265f != null) {
            this.f2266g = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f2265f;
        if (fVar != null) {
            fVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(a.b.b.a.a.c(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f2265f;
        if (fVar != null) {
            fVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        a.b.f.d dVar = this.f2260a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2264e) {
            this.f2263d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2265f != null) {
            Context context = this.f2261b;
            if (context == null) {
                context = getContext();
            }
            this.f2265f.a(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        if (r11 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f2265f.a(getTextDirection(), getTextAlignment());
        } else {
            this.f2265f.a(-1, -1);
        }
    }
}
