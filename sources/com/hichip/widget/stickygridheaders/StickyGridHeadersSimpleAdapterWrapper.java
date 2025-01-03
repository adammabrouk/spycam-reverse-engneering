package com.hichip.widget.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class StickyGridHeadersSimpleAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    public StickyGridHeadersSimpleAdapter mDelegate;
    public HeaderData[] mHeaders;

    public final class DataSetObserverExtension extends DataSetObserver {
        public DataSetObserverExtension() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.mHeaders = stickyGridHeadersSimpleAdapterWrapper.generateHeaderList(stickyGridHeadersSimpleAdapterWrapper.mDelegate);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.mHeaders = stickyGridHeadersSimpleAdapterWrapper.generateHeaderList(stickyGridHeadersSimpleAdapterWrapper.mDelegate);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetInvalidated();
        }

        public /* synthetic */ DataSetObserverExtension(StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper, DataSetObserverExtension dataSetObserverExtension) {
            this();
        }
    }

    public class HeaderData {
        public int mCount = 0;
        public int mRefPosition;

        public HeaderData(int i2) {
            this.mRefPosition = i2;
        }

        public int getCount() {
            return this.mCount;
        }

        public int getRefPosition() {
            return this.mRefPosition;
        }

        public void incrementCount() {
            this.mCount++;
        }
    }

    public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        this.mDelegate = stickyGridHeadersSimpleAdapter;
        stickyGridHeadersSimpleAdapter.registerDataSetObserver(new DataSetObserverExtension(this, null));
        this.mHeaders = generateHeaderList(stickyGridHeadersSimpleAdapter);
    }

    public HeaderData[] generateHeaderList(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stickyGridHeadersSimpleAdapter.getCount(); i2++) {
            long headerId = stickyGridHeadersSimpleAdapter.getHeaderId(i2);
            HeaderData headerData = (HeaderData) hashMap.get(Long.valueOf(headerId));
            if (headerData == null) {
                headerData = new HeaderData(i2);
                arrayList.add(headerData);
            }
            headerData.incrementCount();
            hashMap.put(Long.valueOf(headerId), headerData);
        }
        return (HeaderData[]) arrayList.toArray(new HeaderData[arrayList.size()]);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDelegate.getCount();
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapter
    public int getCountForHeader(int i2) {
        return this.mHeaders[i2].getCount();
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapter
    public View getHeaderView(int i2, View view, ViewGroup viewGroup) {
        return this.mDelegate.getHeaderView(this.mHeaders[i2].getRefPosition(), view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.mDelegate.getItem(i2);
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
        return this.mHeaders.length;
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
