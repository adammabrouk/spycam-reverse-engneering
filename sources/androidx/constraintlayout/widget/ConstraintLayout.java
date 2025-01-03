package androidx.constraintlayout.widget;

import a.f.a.j.f;
import a.f.a.j.g;
import a.f.a.j.i;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.zxing.client.j2se.DecodeWorker;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<View> f2408a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<ConstraintHelper> f2409b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<f> f2410c;

    /* renamed from: d, reason: collision with root package name */
    public g f2411d;

    /* renamed from: e, reason: collision with root package name */
    public int f2412e;

    /* renamed from: f, reason: collision with root package name */
    public int f2413f;

    /* renamed from: g, reason: collision with root package name */
    public int f2414g;

    /* renamed from: h, reason: collision with root package name */
    public int f2415h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2416i;
    public int j;
    public a.f.b.a k;
    public int l;
    public HashMap<String, Integer> m;
    public int n;
    public int o;
    public a.f.a.f p;

    public ConstraintLayout(Context context) {
        super(context);
        this.f2408a = new SparseArray<>();
        this.f2409b = new ArrayList<>(4);
        this.f2410c = new ArrayList<>(100);
        this.f2411d = new g();
        this.f2412e = 0;
        this.f2413f = 0;
        this.f2414g = Integer.MAX_VALUE;
        this.f2415h = Integer.MAX_VALUE;
        this.f2416i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        a((AttributeSet) null);
    }

    public void a(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.m == null) {
                this.m = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public final void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            this.f2410c.clear();
            a();
        }
    }

    public final void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).a(this);
            }
        }
        int size = this.f2409b.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f2409b.get(i3).b(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(DecodeWorker.RED);
                        float f2 = i3;
                        float f3 = i4;
                        float f4 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.f2415h;
    }

    public int getMaxWidth() {
        return this.f2414g;
    }

    public int getMinHeight() {
        return this.f2413f;
    }

    public int getMinWidth() {
        return this.f2412e;
    }

    public int getOptimizationLevel() {
        return this.f2411d.N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            f fVar = aVar.k0;
            if ((childAt.getVisibility() != 8 || aVar.X || aVar.Y || isInEditMode) && !aVar.Z) {
                int h2 = fVar.h();
                int i7 = fVar.i();
                int t = fVar.t() + h2;
                int j = fVar.j() + i7;
                childAt.layout(h2, i7, t, j);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(h2, i7, t, j);
                }
            }
        }
        int size = this.f2409b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f2409b.get(i8).a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 951
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        f a2 = a(view);
        if ((view instanceof Guideline) && !(a2 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            i iVar = new i();
            aVar.k0 = iVar;
            aVar.X = true;
            iVar.w(aVar.R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.a();
            ((a) view.getLayoutParams()).Y = true;
            if (!this.f2409b.contains(constraintHelper)) {
                this.f2409b.add(constraintHelper);
            }
        }
        this.f2408a.put(view.getId(), view);
        this.f2416i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f2408a.remove(view.getId());
        f a2 = a(view);
        this.f2411d.c(a2);
        this.f2409b.remove(view);
        this.f2410c.remove(a2);
        this.f2416i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f2416i = true;
        this.n = -1;
        this.o = -1;
    }

    public void setConstraintSet(a.f.b.a aVar) {
        this.k = aVar;
    }

    @Override // android.view.View
    public void setId(int i2) {
        this.f2408a.remove(getId());
        super.setId(i2);
        this.f2408a.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 == this.f2415h) {
            return;
        }
        this.f2415h = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        if (i2 == this.f2414g) {
            return;
        }
        this.f2414g = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        if (i2 == this.f2413f) {
            return;
        }
        this.f2413f = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        if (i2 == this.f2412e) {
            return;
        }
        this.f2412e = i2;
        requestLayout();
    }

    public void setOptimizationLevel(int i2) {
        this.f2411d.v(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b(int, int):void");
    }

    public final void c(int i2, int i3) {
        int i4;
        f.b bVar;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.b bVar2 = f.b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                bVar = f.b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                bVar = bVar2;
            } else {
                i4 = Math.min(this.f2414g, size) - paddingLeft;
                bVar = bVar2;
            }
            i4 = 0;
        } else {
            i4 = size;
            bVar = f.b.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                bVar2 = f.b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2415h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            bVar2 = f.b.WRAP_CONTENT;
        }
        this.f2411d.m(0);
        this.f2411d.l(0);
        this.f2411d.a(bVar);
        this.f2411d.p(i4);
        this.f2411d.b(bVar2);
        this.f2411d.h(size2);
        this.f2411d.m((this.f2412e - getPaddingLeft()) - getPaddingRight());
        this.f2411d.l((this.f2413f - getPaddingTop()) - getPaddingBottom());
    }

    public Object a(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.m.get(str);
    }

    public final void a(AttributeSet attributeSet) {
        this.f2411d.a(this);
        this.f2408a.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f2412e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2412e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f2413f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2413f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2414g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2414g);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2415h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2415h);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        a.f.b.a aVar = new a.f.b.a();
                        this.k = aVar;
                        aVar.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.k = null;
                    }
                    this.l = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2411d.v(this.j);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2408a = new SparseArray<>();
        this.f2409b = new ArrayList<>(4);
        this.f2410c = new ArrayList<>(100);
        this.f2411d = new g();
        this.f2412e = 0;
        this.f2413f = 0;
        this.f2414g = Integer.MAX_VALUE;
        this.f2415h = Integer.MAX_VALUE;
        this.f2416i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        a(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2408a = new SparseArray<>();
        this.f2409b = new ArrayList<>(4);
        this.f2410c = new ArrayList<>(100);
        this.f2411d = new g();
        this.f2412e = 0;
        this.f2413f = 0;
        this.f2414g = Integer.MAX_VALUE;
        this.f2415h = Integer.MAX_VALUE;
        this.f2416i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        a(attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:231:0x01d6, code lost:
    
        if (r11 != (-1)) goto L123;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01e7  */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a():void");
    }

    public View b(int i2) {
        return this.f2408a.get(i2);
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        public int C;
        public float D;
        public float E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public float N;
        public float O;
        public int P;
        public int Q;
        public int R;
        public boolean S;
        public boolean T;
        public boolean U;
        public boolean V;
        public boolean W;
        public boolean X;
        public boolean Y;
        public boolean Z;

        /* renamed from: a, reason: collision with root package name */
        public int f2417a;
        public int a0;

        /* renamed from: b, reason: collision with root package name */
        public int f2418b;
        public int b0;

        /* renamed from: c, reason: collision with root package name */
        public float f2419c;
        public int c0;

        /* renamed from: d, reason: collision with root package name */
        public int f2420d;
        public int d0;

        /* renamed from: e, reason: collision with root package name */
        public int f2421e;
        public int e0;

        /* renamed from: f, reason: collision with root package name */
        public int f2422f;
        public int f0;

        /* renamed from: g, reason: collision with root package name */
        public int f2423g;
        public float g0;

        /* renamed from: h, reason: collision with root package name */
        public int f2424h;
        public int h0;

        /* renamed from: i, reason: collision with root package name */
        public int f2425i;
        public int i0;
        public int j;
        public float j0;
        public int k;
        public f k0;
        public int l;
        public boolean l0;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0061a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f2426a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2426a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f2426a.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f2426a.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            this.f2417a = -1;
            this.f2418b = -1;
            this.f2419c = -1.0f;
            this.f2420d = -1;
            this.f2421e = -1;
            this.f2422f = -1;
            this.f2423g = -1;
            this.f2424h = -1;
            this.f2425i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = C0061a.f2426a.get(index);
                switch (i4) {
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2417a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2417a);
                        break;
                    case 6:
                        this.f2418b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2418b);
                        break;
                    case 7:
                        this.f2419c = obtainStyledAttributes.getFloat(index, this.f2419c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f2420d);
                        this.f2420d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2420d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f2421e);
                        this.f2421e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f2421e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f2422f);
                        this.f2422f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2422f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f2423g);
                        this.f2423g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2423g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f2424h);
                        this.f2424h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2424h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f2425i);
                        this.f2425i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2425i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        break;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.H = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.N));
                        break;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i2);
                                        if (substring2.length() > 0) {
                                            Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i2, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            case 46:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 47:
                                this.F = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                break;
                            case 50:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.X = false;
            this.U = true;
            this.V = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.S) {
                this.U = false;
                this.H = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == 0 || i2 == -1) {
                this.U = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == 0 || i3 == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f2419c == -1.0f && this.f2417a == -1 && this.f2418b == -1) {
                return;
            }
            this.X = true;
            this.U = true;
            this.V = true;
            if (!(this.k0 instanceof i)) {
                this.k0 = new i();
            }
            ((i) this.k0).w(this.R);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f2417a = -1;
            this.f2418b = -1;
            this.f2419c = -1.0f;
            this.f2420d = -1;
            this.f2421e = -1;
            this.f2422f = -1;
            this.f2423g = -1;
            this.f2424h = -1;
            this.f2425i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2417a = -1;
            this.f2418b = -1;
            this.f2419c = -1.0f;
            this.f2420d = -1;
            this.f2421e = -1;
            this.f2422f = -1;
            this.f2423g = -1;
            this.f2424h = -1;
            this.f2425i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
        }
    }

    public final f a(int i2) {
        if (i2 == 0) {
            return this.f2411d;
        }
        View view = this.f2408a.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f2411d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    public final f a(View view) {
        if (view == this) {
            return this.f2411d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    public final void a(int i2, int i3) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                f fVar = aVar.k0;
                if (!aVar.X && !aVar.Y) {
                    fVar.o(childAt.getVisibility());
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    int i6 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    boolean z3 = aVar.U;
                    if (z3 || aVar.V || (!z3 && aVar.H == 1) || ((ViewGroup.MarginLayoutParams) aVar).width == -1 || (!aVar.V && (aVar.I == 1 || ((ViewGroup.MarginLayoutParams) aVar).height == -1))) {
                        if (i5 == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -2);
                            z = true;
                        } else if (i5 == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -1);
                            z = false;
                        } else {
                            z = i5 == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, i5);
                        }
                        if (i6 == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
                            z2 = true;
                        } else if (i6 == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = i6 == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, i6);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        a.f.a.f fVar2 = this.p;
                        if (fVar2 != null) {
                            fVar2.f746a++;
                        }
                        fVar.b(i5 == -2);
                        fVar.a(i6 == -2);
                        i5 = childAt.getMeasuredWidth();
                        i6 = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    fVar.p(i5);
                    fVar.h(i6);
                    if (z) {
                        fVar.r(i5);
                    }
                    if (z2) {
                        fVar.q(i6);
                    }
                    if (aVar.W && (baseline = childAt.getBaseline()) != -1) {
                        fVar.g(baseline);
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f2411d.L();
        a.f.a.f fVar = this.p;
        if (fVar != null) {
            fVar.f748c++;
        }
    }
}
