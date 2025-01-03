package a.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.reflect.Field;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
public class s extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f568a;

    /* renamed from: b, reason: collision with root package name */
    public int f569b;

    /* renamed from: c, reason: collision with root package name */
    public int f570c;

    /* renamed from: d, reason: collision with root package name */
    public int f571d;

    /* renamed from: e, reason: collision with root package name */
    public int f572e;

    /* renamed from: f, reason: collision with root package name */
    public int f573f;

    /* renamed from: g, reason: collision with root package name */
    public Field f574g;

    /* renamed from: h, reason: collision with root package name */
    public a f575h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f576i;
    public boolean j;
    public boolean k;
    public a.h.j.c0 l;
    public a.h.k.f m;
    public b n;

    /* compiled from: DropDownListView.java */
    public static class a extends a.b.c.a.c {

        /* renamed from: b, reason: collision with root package name */
        public boolean f577b;

        public a(Drawable drawable) {
            super(drawable);
            this.f577b = true;
        }

        public void a(boolean z) {
            this.f577b = z;
        }

        @Override // a.b.c.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f577b) {
                super.draw(canvas);
            }
        }

        @Override // a.b.c.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f577b) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // a.b.c.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f577b) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // a.b.c.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f577b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // a.b.c.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f577b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    public class b implements Runnable {
        public b() {
        }

        public void a() {
            s sVar = s.this;
            sVar.n = null;
            sVar.removeCallbacks(this);
        }

        public void b() {
            s.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = s.this;
            sVar.n = null;
            sVar.drawableStateChanged();
        }
    }

    public s(Context context, boolean z) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f568a = new Rect();
        this.f569b = 0;
        this.f570c = 0;
        this.f571d = 0;
        this.f572e = 0;
        this.j = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f574g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f575h;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            view.measure(i2, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i5) {
                return (i6 < 0 || i8 <= i6 || i10 <= 0 || i7 == i5) ? i5 : i10;
            }
            if (i6 >= 0 && i8 >= i6) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    public final void b(int i2, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i2 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        a(i2, view);
        if (z) {
            Rect rect = this.f568a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            a.h.c.l.a.a(selector, exactCenterX, exactCenterY);
        }
    }

    public final void c() {
        Drawable selector = getSelector();
        if (selector != null && b() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.n != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.j && this.f576i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.n == null) {
            b bVar = new b();
            this.n = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                c();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f573f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f576i = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f575h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f569b = rect.left;
        this.f570c = rect.top;
        this.f571d = rect.right;
        this.f572e = rect.bottom;
    }

    public final boolean b() {
        return this.k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.a(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.a(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            a.h.k.f r9 = r7.m
            if (r9 != 0) goto L5a
            a.h.k.f r9 = new a.h.k.f
            r9.<init>(r7)
            r7.m = r9
        L5a:
            a.h.k.f r9 = r7.m
            r9.a(r2)
            a.h.k.f r9 = r7.m
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            a.h.k.f r8 = r7.m
            if (r8 == 0) goto L6c
            r8.a(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.s.a(android.view.MotionEvent, int):boolean");
    }

    public final void a(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    public final void a(Canvas canvas) {
        Drawable selector;
        if (this.f568a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f568a);
        selector.draw(canvas);
    }

    public final void a(int i2, View view, float f2, float f3) {
        b(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        a.h.c.l.a.a(selector, f2, f3);
    }

    public final void a(int i2, View view) {
        Rect rect = this.f568a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f569b;
        rect.top -= this.f570c;
        rect.right += this.f571d;
        rect.bottom += this.f572e;
        try {
            boolean z = this.f574g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f574g.set(this, Boolean.valueOf(!z));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        this.k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f573f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        a.h.j.c0 c0Var = this.l;
        if (c0Var != null) {
            c0Var.a();
            this.l = null;
        }
    }

    public final void a(View view, int i2, float f2, float f3) {
        View childAt;
        this.k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f573f;
        if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f573f = i2;
        float left = f2 - view.getLeft();
        float top = f3 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }
}
