package com.google.android.material.button;

import a.h.j.h;
import a.h.j.h0.c;
import a.h.j.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String k = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int l = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a, reason: collision with root package name */
    public final List<d> f10415a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10416b;

    /* renamed from: c, reason: collision with root package name */
    public final f f10417c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<e> f10418d;

    /* renamed from: e, reason: collision with root package name */
    public final Comparator<MaterialButton> f10419e;

    /* renamed from: f, reason: collision with root package name */
    public Integer[] f10420f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10421g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10422h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10423i;
    public int j;

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    public class b extends a.h.j.a {
        public b() {
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            cVar.b(c.C0028c.a(0, 1, MaterialButtonToggleGroup.this.b(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.a {
        public c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            if (MaterialButtonToggleGroup.this.f10421g) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f10422h) {
                MaterialButtonToggleGroup.this.j = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.c(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.a(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public static class d {

        /* renamed from: e, reason: collision with root package name */
        public static final c.c.a.c.w.c f10427e = new c.c.a.c.w.a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        public c.c.a.c.w.c f10428a;

        /* renamed from: b, reason: collision with root package name */
        public c.c.a.c.w.c f10429b;

        /* renamed from: c, reason: collision with root package name */
        public c.c.a.c.w.c f10430c;

        /* renamed from: d, reason: collision with root package name */
        public c.c.a.c.w.c f10431d;

        public d(c.c.a.c.w.c cVar, c.c.a.c.w.c cVar2, c.c.a.c.w.c cVar3, c.c.a.c.w.c cVar4) {
            this.f10428a = cVar;
            this.f10429b = cVar3;
            this.f10430c = cVar4;
            this.f10431d = cVar2;
        }

        public static d a(d dVar, View view) {
            return r.e(view) ? b(dVar) : c(dVar);
        }

        public static d b(d dVar, View view) {
            return r.e(view) ? c(dVar) : b(dVar);
        }

        public static d c(d dVar) {
            c.c.a.c.w.c cVar = f10427e;
            return new d(cVar, cVar, dVar.f10429b, dVar.f10430c);
        }

        public static d d(d dVar) {
            c.c.a.c.w.c cVar = dVar.f10428a;
            c.c.a.c.w.c cVar2 = f10427e;
            return new d(cVar, cVar2, dVar.f10429b, cVar2);
        }

        public static d a(d dVar) {
            c.c.a.c.w.c cVar = f10427e;
            return new d(cVar, dVar.f10431d, cVar, dVar.f10430c);
        }

        public static d b(d dVar) {
            c.c.a.c.w.c cVar = dVar.f10428a;
            c.c.a.c.w.c cVar2 = dVar.f10431d;
            c.c.a.c.w.c cVar3 = f10427e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z);
    }

    public class f implements MaterialButton.b {
        public f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (c(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && c(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.j = i2;
        a(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(y.b());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.f10416b);
        materialButton.setOnPressedChangeListenerInternal(this.f10417c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addOnButtonCheckedListener(e eVar) {
        this.f10418d.add(eVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            c(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f10415a.add(new d(shapeAppearanceModel.j(), shapeAppearanceModel.c(), shapeAppearanceModel.l(), shapeAppearanceModel.e()));
        y.a(materialButton, new b());
    }

    public boolean c() {
        return this.f10422h;
    }

    public final void d(int i2) {
        if (getChildCount() == 0 || i2 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b(i2).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            h.a(layoutParams, 0);
            h.b(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        d();
        super.dispatchDraw(canvas);
    }

    public void e() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton b2 = b(i2);
            if (b2.getVisibility() != 8) {
                m.b m = b2.getShapeAppearanceModel().m();
                a(m, a(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                b2.setShapeAppearanceModel(m.a());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f10422h) {
            return this.j;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton b2 = b(i2);
            if (b2.isChecked()) {
                arrayList.add(Integer.valueOf(b2.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f10420f;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(k, "Child order wasn't updated");
        return i3;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.j;
        if (i2 != -1) {
            a(i2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a.h.j.h0.c.a(accessibilityNodeInfo).a(c.b.a(1, getVisibleButtonCount(), false, c() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        e();
        a();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.f10416b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f10415a.remove(indexOfChild);
        }
        e();
        a();
    }

    public void removeOnButtonCheckedListener(e eVar) {
        this.f10418d.remove(eVar);
    }

    public void setSelectionRequired(boolean z) {
        this.f10423i = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f10422h != z) {
            this.f10422h = z;
            b();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    public final boolean c(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, l), attributeSet, i2);
        this.f10415a = new ArrayList();
        a aVar = null;
        this.f10416b = new c(this, aVar);
        this.f10417c = new f(this, aVar);
        this.f10418d = new LinkedHashSet<>();
        this.f10419e = new a();
        this.f10421g = false;
        TypedArray c2 = l.c(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i2, l, new int[0]);
        setSingleSelection(c2.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.j = c2.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f10423i = c2.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        c2.recycle();
        y.h(this, 1);
    }

    public void b() {
        this.f10421g = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton b2 = b(i2);
            b2.setChecked(false);
            a(b2.getId(), false);
        }
        this.f10421g = false;
        setCheckedId(-1);
    }

    public final boolean c(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f10423i && checkedButtonIds.isEmpty()) {
            b(i2, true);
            this.j = i2;
            return false;
        }
        if (z && this.f10422h) {
            checkedButtonIds.remove(Integer.valueOf(i2));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                b(intValue, false);
                a(intValue, false);
            }
        }
        return true;
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton b2 = b(i2);
            int min = Math.min(b2.getStrokeWidth(), b(i2 - 1).getStrokeWidth());
            LinearLayout.LayoutParams a2 = a(b2);
            if (getOrientation() == 0) {
                h.a(a2, 0);
                h.b(a2, -min);
            } else {
                a2.bottomMargin = 0;
                a2.topMargin = -min;
            }
            b2.setLayoutParams(a2);
        }
        d(firstVisibleChildIndex);
    }

    public final void b(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f10421g = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f10421g = false;
        }
    }

    public final void d() {
        TreeMap treeMap = new TreeMap(this.f10419e);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(b(i2), Integer.valueOf(i2));
        }
        this.f10420f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public final MaterialButton b(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public final int b(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && c(i3)) {
                i2++;
            }
        }
        return -1;
    }

    public final d a(int i2, int i3, int i4) {
        d dVar = this.f10415a.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? d.b(dVar, this) : d.d(dVar);
        }
        if (i2 == i4) {
            return z ? d.a(dVar, this) : d.a(dVar);
        }
        return null;
    }

    public static void a(m.b bVar, d dVar) {
        if (dVar == null) {
            bVar.a(0.0f);
            return;
        }
        bVar.c(dVar.f10428a);
        bVar.a(dVar.f10431d);
        bVar.d(dVar.f10429b);
        bVar.b(dVar.f10430c);
    }

    public final void a(int i2, boolean z) {
        Iterator<e> it = this.f10418d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    public final void a(int i2) {
        b(i2, true);
        c(i2, true);
        setCheckedId(i2);
    }

    public final LinearLayout.LayoutParams a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }
}
