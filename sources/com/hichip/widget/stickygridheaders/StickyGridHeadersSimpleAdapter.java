package com.hichip.widget.stickygridheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public interface StickyGridHeadersSimpleAdapter extends ListAdapter {
    long getHeaderId(int i2);

    View getHeaderView(int i2, View view, ViewGroup viewGroup);
}
