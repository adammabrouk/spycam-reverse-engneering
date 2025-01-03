package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AlarmActivityAdapter extends BaseAdapter {
    public Context context;
    public ViewHolder holder;
    public LayoutInflater inflater;
    public ArrayList<CameraParamsBean> list;

    public class ViewHolder {
        public ImageView arrow;
        public RelativeLayout cameralistrootview;
        public TextView did;
        public ImageView imgSnapShot;
        public TextView name;
        public TextView status;

        public ViewHolder() {
        }
    }

    public AlarmActivityAdapter(Context context, ArrayList<CameraParamsBean> arrayList) {
        this.list = null;
        this.list = arrayList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    private Bitmap getFirstPic(String str) {
        File file = new File(new File(FileUtil.getRootDir(), "HDWiFiCam/picid"), str + ".jpg");
        if (!file.exists()) {
            CommonUtil.Log(1, "zhaogenghuai  !file.exists()");
            return null;
        }
        CommonUtil.Log(1, "zhaogenghuai path:" + file.getAbsolutePath());
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    public CameraParamsBean getItemCam(int i2) {
        return this.list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        if (view == null) {
            view = this.inflater.inflate(R.layout.alarmactivity_listitem, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            this.holder = viewHolder;
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.did = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.imgSnapShot = (ImageView) view.findViewById(R.id.imgSnapshot);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = this.list.get(i2);
        int dev_p2pstatus = cameraParamsBean.getDev_p2pstatus();
        int color = this.context.getResources().getColor(R.color.color_n_status_offline);
        Bitmap firstPic = getFirstPic(cameraParamsBean.getDev_Did());
        if (firstPic != null) {
            this.holder.imgSnapShot.setImageResource(R.mipmap.qh_trans);
            this.holder.imgSnapShot.setBackgroundDrawable(new BitmapDrawable(firstPic));
        }
        switch (dev_p2pstatus) {
            case 0:
                i3 = R.string.pppp_status_connecting;
                break;
            case 1:
                i3 = R.string.pppp_status_initialing;
                break;
            case 2:
                i3 = R.string.pppp_status_online;
                color = this.context.getResources().getColor(R.color.color_qh_addtxt);
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
                color = this.context.getResources().getColor(R.color.color_pass_word);
                break;
            default:
                i3 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.status.setTextColor(color);
        this.holder.status.setText(i3);
        this.holder.name.setText(cameraParamsBean.getDev_name());
        this.holder.did.setText(cameraParamsBean.getDev_Did());
        return view;
    }
}
