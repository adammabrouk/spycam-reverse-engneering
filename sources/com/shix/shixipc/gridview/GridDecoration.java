package com.shix.shixipc.gridview;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public abstract class GridDecoration extends NormalDecoration {
    public int itemTotalCount;
    public GridLayoutManager.c lookup;
    public Set<Integer> headerPaddingSet = new TreeSet();
    public Set<Integer> groupHeadPos = new TreeSet();
    public SparseArray<Integer> headerSpanArray = new SparseArray<>();

    public GridDecoration(int i2, int i3) {
        this.itemTotalCount = i2;
        int i4 = 0;
        while (i4 < i2) {
            String realHeaderName = getRealHeaderName(i4);
            if (realHeaderName == null) {
                return;
            }
            if (!this.headerPaddingSet.contains(Integer.valueOf(i4)) && (i4 == 0 || !realHeaderName.equals(getRealHeaderName(i4 - 1)))) {
                this.groupHeadPos.add(Integer.valueOf(i4));
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = i4 + i5;
                    this.headerPaddingSet.add(Integer.valueOf(i6));
                    Log.w(this.TAG, "headerPaddingArray put--->" + i6);
                    if (!realHeaderName.equals(getRealHeaderName(i6 + 1))) {
                        break;
                    }
                }
            }
            int i7 = i4 + 1;
            if (!realHeaderName.equals(getRealHeaderName(i7)) && this.groupHeadPos.size() > 0) {
                int intValue = i3 - ((i4 - ((Integer) ((TreeSet) this.groupHeadPos).last()).intValue()) % i3);
                this.headerSpanArray.put(i4, Integer.valueOf(intValue));
                Log.w(this.TAG, "headerSpanArray put--->" + i4 + "--->" + intValue);
            }
            i4 = i7;
        }
    }

    private String getRealHeaderName(int i2) {
        return i2 >= this.itemTotalCount ? "" : getHeaderName(i2);
    }

    @Override // com.shix.shixipc.gridview.NormalDecoration, androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.getItemOffsets(rect, view, recyclerView, zVar);
        if (this.lookup == null) {
            this.lookup = new GridLayoutManager.c() { // from class: com.shix.shixipc.gridview.GridDecoration.1
                @Override // androidx.recyclerview.widget.GridLayoutManager.c
                public int getSpanSize(int i2) {
                    if (GridDecoration.this.headerSpanArray.indexOfKey(i2) < 0) {
                        return 1;
                    }
                    int intValue = ((Integer) GridDecoration.this.headerSpanArray.valueAt(GridDecoration.this.headerSpanArray.indexOfKey(i2))).intValue();
                    Log.e(GridDecoration.this.TAG, "设置span" + i2 + "span==" + intValue);
                    return intValue;
                }
            };
            ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanSizeLookup(this.lookup);
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (this.headerPaddingSet.contains(Integer.valueOf(childAdapterPosition))) {
            rect.top = this.headerHeight;
            Log.w(this.TAG, "设置偏移==pos==" + childAdapterPosition + "-->" + rect);
        }
    }

    @Override // com.shix.shixipc.gridview.NormalDecoration
    public void onDestory() {
        super.onDestory();
        this.headerSpanArray.clear();
        this.headerPaddingSet.clear();
        this.groupHeadPos.clear();
    }
}
