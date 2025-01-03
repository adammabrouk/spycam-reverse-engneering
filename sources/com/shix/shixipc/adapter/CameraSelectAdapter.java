package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;

/* loaded from: classes.dex */
public class CameraSelectAdapter extends BaseAdapter {
    public boolean hasSelect = false;
    public ViewHolder holder;
    public LayoutInflater inflater;

    public class ViewHolder {
        public TextView textPPPPStatus;
        public TextView tvID;
        public TextView tvName;

        public ViewHolder() {
        }
    }

    public CameraSelectAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return SystemValue.arrayList.size();
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
        int i3;
        if (view == null) {
            view = this.inflater.inflate(R.layout.camera_select_listitem, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            this.holder = viewHolder;
            viewHolder.tvID = (TextView) view.findViewById(R.id.cameraDevID);
            this.holder.tvName = (TextView) view.findViewById(R.id.cameraDevName);
            this.holder.textPPPPStatus = (TextView) view.findViewById(R.id.textPPPPStatus);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
        this.holder.tvID.setText(cameraParamsBean.getDev_Did());
        this.holder.tvName.setText(cameraParamsBean.getDev_name());
        switch (cameraParamsBean.getDev_p2pstatus()) {
            case 0:
                i3 = R.string.pppp_status_connecting;
                break;
            case 1:
                i3 = R.string.pppp_status_initialing;
                break;
            case 2:
                i3 = R.string.pppp_status_online;
                break;
            case 3:
                i3 = R.string.pppp_status_connect_failed;
                break;
            case 4:
                i3 = R.string.pppp_status_disconnect;
                break;
            case 5:
                i3 = R.string.pppp_status_invalid_id;
                break;
            case 6:
                i3 = R.string.device_not_on_line;
                break;
            case 7:
                i3 = R.string.pppp_status_connect_timeout;
                break;
            case 8:
                i3 = R.string.pppp_status_connect_log_errer;
                break;
            default:
                i3 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.textPPPPStatus.setText(i3);
        return view;
    }
}
