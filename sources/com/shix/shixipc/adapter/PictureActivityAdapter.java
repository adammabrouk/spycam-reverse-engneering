package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PictureActivityAdapter extends BaseAdapter {
    public Context context;
    public ViewHolder holder;
    public LayoutInflater inflater;
    public int mode = 1;
    public final int PHONE = 1;
    public final int REMOTE = 2;
    public boolean isOver = false;

    public class ViewHolder {
        public ImageView arrow;
        public RelativeLayout cameralistrootview;
        public View frame;
        public TextView id;
        public ImageView imgSnapShot;
        public TextView name;
        public TextView number;
        public ProgressBar pBar;
        public ImageView pic;
        public TextView status;

        public ViewHolder() {
        }
    }

    public PictureActivityAdapter(Context context, ArrayList<CameraParamsBean> arrayList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void addBmpAndSum(Bitmap bitmap, int i2) {
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

    public int getMode() {
        return this.mode;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        if (view == null) {
            view = this.inflater.inflate(R.layout.picturevideo_listitem, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            this.holder = viewHolder;
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.id = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.number = (TextView) view.findViewById(R.id.tv_pic_num);
            this.holder.pic = (ImageView) view.findViewById(R.id.pic);
            this.holder.pBar = (ProgressBar) view.findViewById(R.id.progressBar1);
            this.holder.frame = view.findViewById(R.id.frame);
            this.holder.imgSnapShot = (ImageView) view.findViewById(R.id.imgSnapshot);
            this.holder.cameralistrootview = (RelativeLayout) view.findViewById(R.id.cameralistrootview);
            this.holder.arrow = (ImageView) view.findViewById(R.id.arrow);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
        this.holder.number.setText("(0)");
        String dev_Did = cameraParamsBean.getDev_Did();
        String dev_name = cameraParamsBean.getDev_name();
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
            default:
                i3 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.status.setText(this.context.getResources().getString(i3));
        this.holder.id.setText(dev_Did);
        this.holder.name.setText(dev_name);
        int i4 = this.mode;
        if (i4 == 1) {
            this.holder.number.setVisibility(0);
            this.holder.status.setVisibility(8);
            this.holder.frame.setVisibility(0);
        } else if (i4 == 2) {
            this.holder.number.setVisibility(8);
            this.holder.status.setVisibility(0);
            this.holder.frame.setVisibility(8);
        }
        return view;
    }

    public void setMode(int i2) {
        this.mode = i2;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }
}
