package com.shix.shixipc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SearchListAdapter extends BaseAdapter {
    public static final String LOG_TAG = "SearchListAdapter";
    public Context context;
    public LayoutInflater listContainer;
    public List<Map<String, Object>> listItems = new ArrayList();

    public final class SearchListItem {
        public TextView devID;
        public TextView devIP;
        public TextView tvshow;

        public SearchListItem() {
        }
    }

    public SearchListAdapter(Context context) {
        this.listContainer = null;
        this.context = null;
        this.context = context;
        this.listContainer = LayoutInflater.from(context);
    }

    private boolean CheckCameraInfo(String str) {
        int size = this.listItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals((String) this.listItems.get(i2).get(ContentCommon.STR_CAMERA_ID))) {
                return false;
            }
        }
        return true;
    }

    public void ClearAll() {
        this.listItems.clear();
    }

    public void addItem(Map<String, Object> map) {
        this.listItems.add(map);
        this.listItems = removeDuplicate(this.listItems);
        notifyDataSetChanged();
    }

    public boolean checkDID(String str) {
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (SystemValue.arrayList.get(i2).getDev_Did().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.listItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    public Map<String, Object> getItemContent(int i2) {
        if (i2 > this.listItems.size()) {
            return null;
        }
        return this.listItems.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        SearchListItem searchListItem;
        String string;
        if (view == null) {
            searchListItem = new SearchListItem();
            view2 = this.listContainer.inflate(R.layout.search_list_item, (ViewGroup) null);
            searchListItem.devIP = (TextView) view2.findViewById(R.id.searchDevIP);
            searchListItem.devID = (TextView) view2.findViewById(R.id.searchDevID);
            searchListItem.tvshow = (TextView) view2.findViewById(R.id.showTv);
            view2.setTag(searchListItem);
        } else {
            view2 = view;
            searchListItem = (SearchListItem) view.getTag();
        }
        searchListItem.devIP.setText((String) this.listItems.get(i2).get(ContentCommon.STR_CAMERA_IP));
        searchListItem.devID.setText((String) this.listItems.get(i2).get(ContentCommon.STR_CAMERA_ID));
        if (checkDID((String) this.listItems.get(i2).get(ContentCommon.STR_CAMERA_ID))) {
            string = this.context.getResources().getString(R.string.sertch_add);
            searchListItem.tvshow.setTextColor(this.context.getResources().getColor(R.color.black));
        } else {
            string = this.context.getResources().getString(R.string.sertch_noadd);
            searchListItem.tvshow.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
        }
        searchListItem.tvshow.setText(string);
        return view2;
    }

    public List<Map<String, Object>> removeDuplicate(List<Map<String, Object>> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        list.clear();
        list.addAll(linkedHashSet);
        return list;
    }

    public void setListItems(List<Map<String, Object>> list) {
        this.listItems = list;
    }
}
