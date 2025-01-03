package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.lookcam.R;
import java.util.List;

/* loaded from: classes.dex */
public class CloudDateAdapter extends BaseAdapter {
    public Context context;
    public ViewHolder holder;
    public LayoutInflater inflater;
    public List<String> listDate;

    public class ViewHolder {
        public TextView name;

        public ViewHolder() {
        }
    }

    public CloudDateAdapter(Context context, List<String> list) {
        this.context = context;
        this.listDate = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.listDate.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.clouddate_listitem, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            this.holder = viewHolder;
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        this.holder.name.setText(this.listDate.get(i2) + "");
        return view;
    }
}
