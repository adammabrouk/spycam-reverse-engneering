package com.shix.shixipc.utils;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class MyLinearLayoutManager extends LinearLayoutManager {
    public MyLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        try {
            super.onLayoutChildren(vVar, zVar);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }

    public MyLinearLayoutManager(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public MyLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
