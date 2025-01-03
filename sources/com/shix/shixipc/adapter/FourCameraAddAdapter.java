package com.shix.shixipc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.adapter.FourCameraAddAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;

/* loaded from: classes.dex */
public class FourCameraAddAdapter extends RecyclerView.g<ViewHolder> {
    public OnClickListener listener;
    public Context mContext;

    public interface OnClickListener {
        void onClick(CameraParamsBean cameraParamsBean);
    }

    public class ViewHolder extends RecyclerView.c0 {
        public LinearLayout llItemRoot;
        public TextView tvDevId;
        public TextView tvDevName;
        public TextView tvState;

        public ViewHolder(View view) {
            super(view);
            this.llItemRoot = (LinearLayout) view.findViewById(R.id.ll_item_root);
            this.tvDevName = (TextView) view.findViewById(R.id.tv_item_dev_name);
            this.tvDevId = (TextView) view.findViewById(R.id.tv_item_dev_id);
            this.tvState = (TextView) view.findViewById(R.id.tv_item_state);
        }
    }

    public FourCameraAddAdapter(Context context) {
        this.mContext = context;
    }

    public /* synthetic */ void a(CameraParamsBean cameraParamsBean, View view) {
        OnClickListener onClickListener;
        if (cameraParamsBean.getDev_p2pstatus() != 2 || (onClickListener = this.listener) == null) {
            return;
        }
        onClickListener.onClick(cameraParamsBean);
    }

    public void addOnClickListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return SystemValue.arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return i2;
    }

    public CameraParamsBean getOnItem(int i2) {
        synchronized (this) {
            if (i2 > SystemValue.arrayList.size()) {
                return null;
            }
            return SystemValue.arrayList.get(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        int i3;
        final CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
        if (cameraParamsBean == null) {
            return;
        }
        viewHolder.llItemRoot.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.b.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourCameraAddAdapter.this.a(cameraParamsBean, view);
            }
        });
        viewHolder.tvDevName.setText(cameraParamsBean.getDev_name());
        viewHolder.tvDevId.setText(cameraParamsBean.getDev_Did());
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
        viewHolder.tvState.setText(this.mContext.getResources().getString(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_four_camera_add, viewGroup, false));
    }
}
