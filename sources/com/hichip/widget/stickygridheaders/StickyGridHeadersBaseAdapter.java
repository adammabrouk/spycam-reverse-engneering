package com.hichip.widget.stickygridheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public interface StickyGridHeadersBaseAdapter extends ListAdapter {
    int getCountForHeader(int i2);

    View getHeaderView(int i2, View view, ViewGroup viewGroup);

    int getNumHeaders();
}
