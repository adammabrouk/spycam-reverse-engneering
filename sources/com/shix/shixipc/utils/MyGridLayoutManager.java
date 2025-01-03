package com.shix.shixipc.utils;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class MyGridLayoutManager extends GridLayoutManager {
    public MyGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        try {
            super.onLayoutChildren(vVar, zVar);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }

    public MyGridLayoutManager(Context context, int i2) {
        super(context, i2);
    }

    public MyGridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i2, i3, z);
    }
}
