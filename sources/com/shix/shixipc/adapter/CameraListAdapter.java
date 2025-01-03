package com.shix.shixipc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import c.a.a.e;
import com.shix.lookcam.R;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.adapter.CameraListAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;

/* loaded from: classes.dex */
public class CameraListAdapter extends RecyclerView.g<ViewHolder> {
    public FragmentCameraList fragmentCameraList;
    public Context mContext;
    public int type = 0;

    public class MyOnClickListener implements View.OnClickListener {
        public int position;

        public MyOnClickListener(int i2) {
            this.position = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraListAdapter.this.fragmentCameraList != null) {
                CameraListAdapter.this.fragmentCameraList.showSetValue(this.position);
                CameraListAdapter.this.fragmentCameraList.showSetting(this.position, view.getId());
            }
        }
    }

    public class ViewHolder extends RecyclerView.c0 {
        public RelativeLayout cameralistrootview;
        public TextView devID;
        public TextView devName;
        public TextView devStatus;
        public TextView devType;
        public ImageView im_play;
        public ImageView imgSnapShot;
        public ImageView ivState;
        public Button leftBtn;
        public LinearLayout linear_for;
        public LinearLayout llPic;
        public LinearLayout llSdCard;
        public LinearLayout llSetting;
        public LinearLayout llVideo;
        public RelativeLayout rlItemRoot;
        public TextView textDeafualPwd;
        public View viewItem1;

        public ViewHolder(View view) {
            super(view);
            this.rlItemRoot = (RelativeLayout) view.findViewById(R.id.rl_item_root);
            this.llSdCard = (LinearLayout) view.findViewById(R.id.llSdCard);
            this.llVideo = (LinearLayout) view.findViewById(R.id.llVideo);
            this.llPic = (LinearLayout) view.findViewById(R.id.llPic);
            this.llSetting = (LinearLayout) view.findViewById(R.id.llSetting);
            this.viewItem1 = view.findViewById(R.id.viewItem1);
            this.im_play = (ImageView) view.findViewById(R.id.im_play);
            this.linear_for = (LinearLayout) view.findViewById(R.id.linear_for);
            this.imgSnapShot = (ImageView) view.findViewById(R.id.imgSnapshot);
            this.devName = (TextView) view.findViewById(R.id.cameraDevName);
            this.devID = (TextView) view.findViewById(R.id.cameraDevID);
            this.devStatus = (TextView) view.findViewById(R.id.textPPPPStatus);
            this.cameralistrootview = (RelativeLayout) view.findViewById(R.id.cameralistrootview);
            this.textDeafualPwd = (TextView) view.findViewById(R.id.textDeafualPwd);
            this.ivState = (ImageView) view.findViewById(R.id.ivState);
        }
    }

    public CameraListAdapter(FragmentCameraList fragmentCameraList) {
        this.fragmentCameraList = fragmentCameraList;
        this.mContext = fragmentCameraList.getContext();
    }

    public boolean UpdataCameraResetrict(String str, int i2) {
        CommonUtil.Log(1, "zhaogenghuaiUpdataCameraStatus did:" + str + "  resetrict:" + i2);
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
                if (str.equals(cameraParamsBean.getDev_Did())) {
                    if (cameraParamsBean.getResetrict() == i2) {
                        return false;
                    }
                    cameraParamsBean.setResetrict(i2);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean UpdataCameraStatus(String str, int i2) {
        CommonUtil.Log(1, "UpdataCameraStatus did:" + str + "  status:" + i2);
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
                if (str.equals(cameraParamsBean.getDev_Did())) {
                    if (cameraParamsBean.getDev_p2pstatus() == i2) {
                        return false;
                    }
                    cameraParamsBean.setDev_p2pstatus(i2);
                    return true;
                }
            }
            return false;
        }
    }

    public /* synthetic */ boolean a(int i2, View view) {
        this.fragmentCameraList.showLong(i2);
        return false;
    }

    public CameraParamsBean getCameraInfo(String str) {
        int size = SystemValue.arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (SystemValue.arrayList.get(i2).getDev_Did().equals(str)) {
                return SystemValue.arrayList.get(i2);
            }
        }
        return null;
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public CameraParamsBean getItemCamera(int i2) {
        if (SystemValue.arrayList.size() > 0) {
            return SystemValue.arrayList.get(i2);
        }
        return null;
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

    public void setType(int i2) {
        this.type = i2;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void onBindViewHolder(ViewHolder viewHolder, final int i2) {
        int i3;
        viewHolder.ivState.setOnClickListener(new MyOnClickListener(i2));
        viewHolder.rlItemRoot.setOnClickListener(new MyOnClickListener(i2));
        viewHolder.rlItemRoot.setOnLongClickListener(new View.OnLongClickListener() { // from class: c.h.a.b.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return CameraListAdapter.this.a(i2, view);
            }
        });
        viewHolder.llSdCard.setOnClickListener(new MyOnClickListener(i2));
        viewHolder.llVideo.setOnClickListener(new MyOnClickListener(i2));
        viewHolder.llPic.setOnClickListener(new MyOnClickListener(i2));
        viewHolder.llSetting.setOnClickListener(new MyOnClickListener(i2));
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
        viewHolder.devName.setText(cameraParamsBean.getDev_name());
        viewHolder.devID.setText(cameraParamsBean.getDev_Did());
        b<String> a2 = e.b(this.mContext).a(cameraParamsBean.getDevicePath());
        a2.b(R.mipmap.item_device_bg);
        a2.a(R.mipmap.item_device_bg);
        a2.a(true);
        a2.a(c.a.a.l.i.b.NONE);
        a2.a(viewHolder.imgSnapShot);
        viewHolder.viewItem1.setBackgroundResource(R.drawable.biz_content_bg1);
        int dev_p2pstatus = cameraParamsBean.getDev_p2pstatus();
        viewHolder.ivState.setImageResource(R.mipmap.ic_disconnect);
        switch (dev_p2pstatus) {
            case 0:
                i3 = R.string.pppp_status_connecting;
                break;
            case 1:
                i3 = R.string.pppp_status_initialing;
                break;
            case 2:
                viewHolder.viewItem1.setBackgroundResource(R.drawable.biz_content_bg);
                i3 = R.string.pppp_status_online;
                viewHolder.ivState.setImageResource(R.mipmap.ic_connect);
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
        String dev_Pwd = cameraParamsBean.getDev_Pwd();
        if (dev_p2pstatus == 2) {
            if (dev_Pwd == null || dev_Pwd.length() == 0 || dev_Pwd.length() < 3 || dev_Pwd.equalsIgnoreCase(ContentCommon.DEFAULT_USER_NAME) || dev_Pwd.equalsIgnoreCase("123456") || dev_Pwd.equalsIgnoreCase("654321") || dev_Pwd.equalsIgnoreCase("123456789") || dev_Pwd.equalsIgnoreCase("987654321")) {
                viewHolder.textDeafualPwd.setVisibility(8);
                viewHolder.textDeafualPwd.setTextColor(this.mContext.getResources().getColor(R.color.color_qh_addtxt));
            } else {
                viewHolder.textDeafualPwd.setVisibility(8);
            }
            viewHolder.devStatus.setTextColor(this.mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            viewHolder.textDeafualPwd.setVisibility(8);
            viewHolder.devStatus.setTextColor(this.mContext.getResources().getColor(R.color.gray));
        }
        viewHolder.devStatus.setText(this.mContext.getResources().getString(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.type == 0 ? new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adapter_device, viewGroup, false)) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adapter_device_small, viewGroup, false));
    }
}
