package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.WifiModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class WifiScanListAdapter extends BaseAdapter {
    public Context context;
    public ViewHolder holder;
    public LayoutInflater inflater;
    public ArrayList<WifiModel> list = new ArrayList<>();

    public class ViewHolder {
        public TextView signal;
        public TextView ssid;

        public ViewHolder() {
        }
    }

    public WifiScanListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void addWifiScan(WifiModel wifiModel) {
        this.list.add(wifiModel);
    }

    public void clearWifi() {
        this.list.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
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
            view = this.inflater.inflate(R.layout.settingwifi_list_item, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            this.holder = viewHolder;
            viewHolder.ssid = (TextView) view.findViewById(R.id.ssid);
            this.holder.signal = (TextView) view.findViewById(R.id.wifi_scan_listitem_tv_signal_strong);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        WifiModel wifiModel = this.list.get(i2);
        this.holder.ssid.setText(wifiModel.getSsid());
        if (wifiModel.getSignal() > 100) {
            this.holder.signal.setText((wifiModel.getSignal() - 100) + "%");
        } else if (wifiModel.getSignal() < 0) {
            this.holder.signal.setText((wifiModel.getSignal() + 100) + "%");
        } else {
            this.holder.signal.setText(wifiModel.getSignal() + "%");
        }
        if (wifiModel.getEncryption() == 0) {
            this.context.getResources().getString(R.string.wifi_no_safe);
        }
        return view;
    }

    public WifiModel getWifiScan(int i2) {
        return this.list.get(i2);
    }

    public ArrayList<WifiModel> getWifiScanBeans() {
        return this.list;
    }

    public void wifiSort() {
        Collections.sort(this.list, new Comparator<WifiModel>() { // from class: com.shix.shixipc.adapter.WifiScanListAdapter.1
            @Override // java.util.Comparator
            public int compare(WifiModel wifiModel, WifiModel wifiModel2) {
                return wifiModel.getSignal() < wifiModel2.getSignal() ? 1 : -1;
            }
        });
    }
}
