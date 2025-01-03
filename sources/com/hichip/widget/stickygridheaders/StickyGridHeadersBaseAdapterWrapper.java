package com.hichip.widget.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {
    public static final int ID_FILLER = -2;
    public static final int ID_HEADER = -1;
    public static final int ID_HEADER_FILLER = -3;
    public static final int POSITION_FILLER = -1;
    public static final int POSITION_HEADER = -2;
    public static final int POSITION_HEADER_FILLER = -3;
    public static final int VIEW_TYPE_FILLER = 0;
    public static final int VIEW_TYPE_HEADER = 1;
    public static final int VIEW_TYPE_HEADER_FILLER = 2;
    public static final int sNumViewTypes = 3;
    public final Context mContext;
    public int mCount;
    public boolean mCounted = false;
    public DataSetObserver mDataSetObserver;
    public final StickyGridHeadersBaseAdapter mDelegate;
    public StickyGridHeadersGridView mGridView;
    public View mLastHeaderViewSeen;
    public View mLastViewSeen;
    public int mNumColumns;

    public class HeaderHolder {
        public View mHeaderView;

        public HeaderHolder() {
        }
    }

    public class Position {
        public int mHeader;
        public int mPosition;

        public Position(int i2, int i3) {
            this.mPosition = i2;
            this.mHeader = i3;
        }
    }

    public StickyGridHeadersBaseAdapterWrapper(Context context, StickyGridHeadersGridView stickyGridHeadersGridView, StickyGridHeadersBaseAdapter stickyGridHeadersBaseAdapter) {
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersBaseAdapterWrapper.this.updateCount();
                StickyGridHeadersBaseAdapterWrapper.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersBaseAdapterWrapper.this.mCounted = false;
                StickyGridHeadersBaseAdapterWrapper.this.notifyDataSetInvalidated();
            }
        };
        this.mDataSetObserver = dataSetObserver;
        this.mNumColumns = 1;
        this.mContext = context;
        this.mDelegate = stickyGridHeadersBaseAdapter;
        this.mGridView = stickyGridHeadersGridView;
        stickyGridHeadersBaseAdapter.registerDataSetObserver(dataSetObserver);
    }

    private FillerView getFillerView(View view, ViewGroup viewGroup, View view2) {
        FillerView fillerView = (FillerView) view;
        if (fillerView == null) {
            fillerView = new FillerView(this.mContext);
        }
        fillerView.setMeasureTarget(view2);
        return fillerView;
    }

    private HeaderFillerView getHeaderFillerView(int i2, View view, ViewGroup viewGroup) {
        HeaderFillerView headerFillerView = (HeaderFillerView) view;
        return headerFillerView == null ? new HeaderFillerView(this.mContext) : headerFillerView;
    }

    private int unFilledSpacesInHeaderGroup(int i2) {
        int countForHeader = this.mDelegate.getCountForHeader(i2);
        int i3 = this.mNumColumns;
        int i4 = countForHeader % i3;
        if (i4 == 0) {
            return 0;
        }
        return i3 - i4;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mCounted) {
            return this.mCount;
        }
        this.mCount = 0;
        int numHeaders = this.mDelegate.getNumHeaders();
        if (numHeaders == 0) {
            int count = this.mDelegate.getCount();
            this.mCount = count;
            this.mCounted = true;
            return count;
        }
        for (int i2 = 0; i2 < numHeaders; i2++) {
            this.mCount += this.mDelegate.getCountForHeader(i2) + unFilledSpacesInHeaderGroup(i2) + this.mNumColumns;
        }
        this.mCounted = true;
        return this.mCount;
    }

    public long getHeaderId(int i2) {
        return translatePosition(i2).mHeader;
    }

    public View getHeaderView(int i2, View view, ViewGroup viewGroup) {
        if (this.mDelegate.getNumHeaders() == 0) {
            return null;
        }
        return this.mDelegate.getHeaderView(translatePosition(i2).mHeader, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) throws ArrayIndexOutOfBoundsException {
        int i3 = translatePosition(i2).mPosition;
        if (i3 == -1 || i3 == -2) {
            return null;
        }
        return this.mDelegate.getItem(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3 = translatePosition(i2).mPosition;
        if (i3 == -2) {
            return -1L;
        }
        if (i3 == -1) {
            return -2L;
        }
        if (i3 == -3) {
            return -3L;
        }
        return this.mDelegate.getItemId(i3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3 = translatePosition(i2).mPosition;
        if (i3 == -2) {
            return 1;
        }
        if (i3 == -1) {
            return 0;
        }
        if (i3 == -3) {
            return 2;
        }
        int itemViewType = this.mDelegate.getItemViewType(i3);
        return itemViewType == -1 ? itemViewType : itemViewType + 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        Position translatePosition = translatePosition(i2);
        int i3 = translatePosition.mPosition;
        if (i3 == -2) {
            HeaderFillerView headerFillerView = getHeaderFillerView(translatePosition.mHeader, view, viewGroup);
            View headerView = this.mDelegate.getHeaderView(translatePosition.mHeader, (View) headerFillerView.getTag(), viewGroup);
            this.mGridView.detachHeader((View) headerFillerView.getTag());
            headerFillerView.setTag(headerView);
            this.mGridView.attachHeader(headerView);
            this.mLastHeaderViewSeen = headerFillerView;
            headerFillerView.forceLayout();
            return headerFillerView;
        }
        if (i3 == -3) {
            FillerView fillerView = getFillerView(view, viewGroup, this.mLastHeaderViewSeen);
            fillerView.forceLayout();
            return fillerView;
        }
        if (i3 == -1) {
            return getFillerView(view, viewGroup, this.mLastViewSeen);
        }
        View view2 = this.mDelegate.getView(i3, view, viewGroup);
        this.mLastViewSeen = view2;
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount() + 3;
    }

    public StickyGridHeadersBaseAdapter getWrappedAdapter() {
        return this.mDelegate;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int i3 = translatePosition(i2).mPosition;
        if (i3 == -1 || i3 == -2) {
            return false;
        }
        return this.mDelegate.isEnabled(i3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.registerDataSetObserver(dataSetObserver);
    }

    public void setNumColumns(int i2) {
        this.mNumColumns = i2;
        this.mCounted = false;
    }

    public Position translatePosition(int i2) {
        int numHeaders = this.mDelegate.getNumHeaders();
        if (numHeaders == 0) {
            return i2 >= this.mDelegate.getCount() ? new Position(-1, 0) : new Position(i2, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 < numHeaders) {
            int countForHeader = this.mDelegate.getCountForHeader(i4);
            if (i2 == 0) {
                return new Position(-2, i4);
            }
            int i5 = this.mNumColumns;
            int i6 = i2 - i5;
            if (i6 < 0) {
                return new Position(-3, i4);
            }
            int i7 = i3 - i5;
            if (i6 < countForHeader) {
                return new Position(i7, i4);
            }
            int unFilledSpacesInHeaderGroup = unFilledSpacesInHeaderGroup(i4);
            i3 = i7 - unFilledSpacesInHeaderGroup;
            i2 = i6 - (countForHeader + unFilledSpacesInHeaderGroup);
            if (i2 < 0) {
                return new Position(-1, i4);
            }
            i4++;
        }
        return new Position(-1, i4);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.unregisterDataSetObserver(dataSetObserver);
    }

    public void updateCount() {
        this.mCount = 0;
        int numHeaders = this.mDelegate.getNumHeaders();
        if (numHeaders == 0) {
            this.mCount = this.mDelegate.getCount();
            this.mCounted = true;
        } else {
            for (int i2 = 0; i2 < numHeaders; i2++) {
                this.mCount += this.mDelegate.getCountForHeader(i2) + this.mNumColumns;
            }
            this.mCounted = true;
        }
    }

    public class FillerView extends View {
        public View mMeasureTarget;

        public FillerView(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.mMeasureTarget.getMeasuredHeight(), MemoryConstants.GB));
        }

        public void setMeasureTarget(View view) {
            this.mMeasureTarget = view;
        }

        public FillerView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FillerView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }

    public class HeaderFillerView extends FrameLayout {
        public int mHeaderId;

        public HeaderFillerView(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup
        public FrameLayout.LayoutParams generateDefaultLayoutParams() {
            return new FrameLayout.LayoutParams(-1, -1);
        }

        public int getHeaderId() {
            return this.mHeaderId;
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            View view = (View) getTag();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (view.getVisibility() != 8) {
                view.measure(FrameLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(StickyGridHeadersBaseAdapterWrapper.this.mGridView.getWidth(), MemoryConstants.GB), 0, layoutParams.width), FrameLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i2), view.getMeasuredHeight());
        }

        public void setHeaderId(int i2) {
            this.mHeaderId = i2;
        }

        public HeaderFillerView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public HeaderFillerView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }
}
