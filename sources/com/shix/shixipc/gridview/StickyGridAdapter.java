package com.shix.shixipc.gridview;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.a.e;
import com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter;
import com.shix.lookcam.R;
import com.shix.shixipc.gridview.MyImageView;
import java.util.List;

/* loaded from: classes.dex */
public class StickyGridAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
    public boolean[] checks;
    public int delMode;
    public boolean isVideo;
    public List<GridItem> list;
    public Context mContext;
    public GridView mGridView;
    public LayoutInflater mInflater;
    public Point mPoint = new Point(0, 0);

    public static class HeaderViewHolder {
        public TextView mTextView;
    }

    public static class ViewHolder {
        public CheckBox grid_cb;
        public ImageView img_video;
        public MyImageView mImageView;
    }

    public StickyGridAdapter(Context context, List<GridItem> list, GridView gridView, boolean z) {
        this.isVideo = false;
        this.list = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mGridView = gridView;
        this.checks = new boolean[list.size()];
        this.isVideo = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    public int getDelMode() {
        return this.delMode;
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter
    public long getHeaderId(int i2) {
        return this.list.get(i2).getSection();
    }

    @Override // com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter
    public View getHeaderView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            headerViewHolder = new HeaderViewHolder();
            view2 = this.mInflater.inflate(R.layout.grid_header, viewGroup, false);
            headerViewHolder.mTextView = (TextView) view2.findViewById(R.id.grid_header);
            view2.setTag(headerViewHolder);
        } else {
            view2 = view;
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        headerViewHolder.mTextView.setText(this.list.get(i2).getTime());
        return view2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.mInflater.inflate(R.layout.grid_item, viewGroup, false);
            viewHolder.mImageView = (MyImageView) view2.findViewById(R.id.grid_item);
            viewHolder.grid_cb = (CheckBox) view2.findViewById(R.id.grid_cb);
            viewHolder.img_video = (ImageView) view2.findViewById(R.id.img_video);
            view2.setTag(viewHolder);
            viewHolder.mImageView.setOnMeasureListener(new MyImageView.OnMeasureListener() { // from class: com.shix.shixipc.gridview.StickyGridAdapter.1
                @Override // com.shix.shixipc.gridview.MyImageView.OnMeasureListener
                public void onMeasureSize(int i3, int i4) {
                    StickyGridAdapter.this.mPoint.set(i3, i4);
                }
            });
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.grid_cb.setChecked(this.checks[i2]);
        if (this.isVideo) {
            viewHolder.img_video.setVisibility(0);
        } else {
            viewHolder.img_video.setVisibility(8);
        }
        e.b(this.mContext).a(this.list.get(i2).getPath()).a((ImageView) viewHolder.mImageView);
        if (this.delMode == 1) {
            viewHolder.grid_cb.setVisibility(0);
        } else {
            viewHolder.grid_cb.setVisibility(8);
        }
        return view2;
    }

    public void setDelMode(int i2) {
        this.delMode = i2;
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.checks;
            if (i3 >= zArr.length) {
                notifyDataSetChanged();
                return;
            } else {
                zArr[i3] = false;
                i3++;
            }
        }
    }

    public void setSeleteAll() {
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.checks;
            if (i2 >= zArr.length) {
                notifyDataSetChanged();
                return;
            } else {
                zArr[i2] = true;
                i2++;
            }
        }
    }

    public void setSeleteAllCancel() {
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.checks;
            if (i2 >= zArr.length) {
                notifyDataSetChanged();
                return;
            } else {
                zArr[i2] = false;
                i2++;
            }
        }
    }
}
