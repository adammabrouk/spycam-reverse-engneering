package com.shix.shixipc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;

/* loaded from: classes.dex */
public class FragmentPicAdapter extends RecyclerView.g<ViewHolder> {
    public Context mContext;
    public BaseFragment mFragment;

    public class MyOnTouchListener implements View.OnTouchListener {
        public int position;

        public MyOnTouchListener(int i2) {
            this.position = i2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 && FragmentPicAdapter.this.mFragment != null) {
                FragmentPicAdapter.this.mFragment.showSetting(this.position, view.getId());
            }
            return true;
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

    public FragmentPicAdapter(Context context, BaseFragment baseFragment) {
        this.mContext = context;
        this.mFragment = baseFragment;
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

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @SuppressLint({"ClickableViewAccessibility"})
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        int i3;
        viewHolder.ivState.setVisibility(8);
        viewHolder.llSetting.setVisibility(8);
        viewHolder.ivState.setOnTouchListener(new MyOnTouchListener(i2));
        viewHolder.rlItemRoot.setOnTouchListener(new MyOnTouchListener(i2));
        viewHolder.llSdCard.setOnTouchListener(new MyOnTouchListener(i2));
        viewHolder.llVideo.setOnTouchListener(new MyOnTouchListener(i2));
        viewHolder.llPic.setOnTouchListener(new MyOnTouchListener(i2));
        viewHolder.llSetting.setOnTouchListener(new MyOnTouchListener(i2));
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
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adapter_device_small, viewGroup, false));
    }
}
