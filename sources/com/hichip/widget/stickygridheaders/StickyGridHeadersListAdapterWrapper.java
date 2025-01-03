package com.hichip.widget.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public class StickyGridHeadersListAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    public DataSetObserver mDataSetObserver;
    public ListAdapter mDelegate;

    public StickyGridHeadersListAdapterWrapper(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersListAdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersListAdapterWrapper.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersListAdapterWrapper.this.notifyDataSetInvalidated();
            }
        };
        this.mDataSetObserver = dataSetObserver;
        this.mDelegate = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ListAdapter listAdapter = this.mDelegate;
        if (listAdapter == null) {
            return 0;
        }
        return listAdapter.getCount();
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapter
    public int getCountForHeader(int i2) {
        return 0;
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapter
    public View getHeaderView(int i2, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ListAdapter listAdapter = this.mDelegate;
        if (listAdapter == null) {
            return null;
        }
        return listAdapter.getItem(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return this.mDelegate.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return this.mDelegate.getItemViewType(i2);
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapter
    public int getNumHeaders() {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return this.mDelegate.getView(i2, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }
}
