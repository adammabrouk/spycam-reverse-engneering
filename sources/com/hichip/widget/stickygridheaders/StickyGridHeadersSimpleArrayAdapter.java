package com.hichip.widget.stickygridheaders;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
    public static final String TAG = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();
    public int mHeaderResId;
    public LayoutInflater mInflater;
    public int mItemResId;
    public List<T> mItems;

    public class HeaderViewHolder {
        public TextView textView;

        public HeaderViewHolder() {
        }
    }

    public class ViewHolder {
        public TextView textView;

        public ViewHolder() {
        }
    }

    public StickyGridHeadersSimpleArrayAdapter(Context context, List<T> list, int i2, int i3) {
        init(context, list, i2, i3);
    }

    private void init(Context context, List<T> list, int i2, int i3) {
        this.mItems = list;
        this.mHeaderResId = i2;
        this.mItemResId = i3;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter
    public long getHeaderId(int i2) {
        return (getItem(i2) instanceof CharSequence ? (CharSequence) r3 : r3.toString()).subSequence(0, 1).charAt(0);
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter
    public View getHeaderView(int i2, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            view = this.mInflater.inflate(this.mHeaderResId, viewGroup, false);
            headerViewHolder = new HeaderViewHolder();
            headerViewHolder.textView = (TextView) view.findViewById(R.id.text1);
            view.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        T item = getItem(i2);
        headerViewHolder.textView.setText((item instanceof CharSequence ? (CharSequence) item : item.toString()).subSequence(0, 1));
        return view;
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        return this.mItems.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemResId, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.text1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T item = getItem(i2);
        if (item instanceof CharSequence) {
            viewHolder.textView.setText((CharSequence) item);
        } else {
            viewHolder.textView.setText(item.toString());
        }
        return view;
    }

    public StickyGridHeadersSimpleArrayAdapter(Context context, T[] tArr, int i2, int i3) {
        init(context, Arrays.asList(tArr), i2, i3);
    }
}
