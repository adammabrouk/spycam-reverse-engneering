package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.activity.CloudLogActivity;
import com.shix.shixipc.bean.CloudBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CloudLogAdapter extends BaseAdapter {
    public CloudLogActivity alarmLogActivity;
    public ArrayList<CloudBean> arrayList = new ArrayList<>();
    public Context context;
    public LayoutInflater inflater;

    public class MyOnClickListener implements View.OnClickListener {
        public CloudBean alarmLogBean1;
        public int position;

        public MyOnClickListener(int i2) {
            this.position = i2;
            this.alarmLogBean1 = (CloudBean) CloudLogAdapter.this.arrayList.get(i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudLogAdapter.this.alarmLogActivity.showPic(this.position, this.alarmLogBean1.getStrDid(), this.alarmLogBean1.getFileName(), this.alarmLogBean1.getCreateTime(), this.alarmLogBean1.getCloudPath(), null, this.alarmLogBean1.getType());
        }
    }

    public class MyOnLongListener implements View.OnLongClickListener {
        public int position;

        public MyOnLongListener(int i2) {
            this.position = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class ViewHolder {
        public ImageView button_check_pic;
        public TextView content;
        public TextView createTime;
        public CheckBox delete_box;
        public ImageView downLoad;
        public TextView tv_type;

        public ViewHolder() {
        }
    }

    public CloudLogAdapter(Context context, CloudLogActivity cloudLogActivity) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.alarmLogActivity = cloudLogActivity;
    }

    public void addAlarmLog(CloudBean cloudBean) {
        for (int i2 = 0; i2 < this.arrayList.size(); i2++) {
            if (this.arrayList.get(i2).getFileName().equals(cloudBean.getFileName())) {
                return;
            }
        }
        this.arrayList.add(cloudBean);
    }

    public void clearAlarmLog(List<String> list) {
        if (list.size() > 0 && this.arrayList.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                int parseInt = Integer.parseInt(list.get(i2)) - i2;
                if (this.arrayList.size() > 0 && parseInt < this.arrayList.size() && parseInt >= 0) {
                    this.arrayList.remove(parseInt);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void clearAllAlarmLog() {
        this.arrayList.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.arrayList.size();
    }

    public ArrayList<CloudBean> getDatas() {
        return this.arrayList;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.cloud_listitem1, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.content = (TextView) view.findViewById(R.id.alarm_log_content);
            viewHolder.createTime = (TextView) view.findViewById(R.id.alarm_log_time);
            viewHolder.button_check_pic = (ImageView) view.findViewById(R.id.button_check_pic);
            viewHolder.tv_type = (TextView) view.findViewById(R.id.alarm_log_left);
            viewHolder.delete_box = (CheckBox) view.findViewById(R.id.alarm_delete_box);
            viewHolder.downLoad = (ImageView) view.findViewById(R.id.alarm_log_download);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CloudBean cloudBean = new CloudBean();
        if (this.arrayList.size() > 0) {
            cloudBean = this.arrayList.get(i2);
        }
        if (cloudBean.isEdited()) {
            viewHolder.delete_box.setVisibility(0);
        } else {
            viewHolder.delete_box.setVisibility(8);
        }
        viewHolder.delete_box.setChecked(cloudBean.isChecked());
        String str = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/cloud/" + cloudBean.getStrDid() + "/" + cloudBean.getFileName();
        if (new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    viewHolder.button_check_pic.setImageBitmap(decodeFile);
                } else {
                    viewHolder.button_check_pic.setImageResource(R.mipmap.item_device_bg);
                }
            } catch (Exception unused) {
                viewHolder.button_check_pic.setImageResource(R.mipmap.item_device_bg);
            }
        } else {
            viewHolder.button_check_pic.setImageResource(R.mipmap.item_device_bg);
        }
        viewHolder.button_check_pic.setOnClickListener(new MyOnClickListener(i2));
        cloudBean.getType();
        viewHolder.tv_type.setText(R.string.doorbell_alerm);
        viewHolder.createTime.setText(cloudBean.getCreateTime());
        viewHolder.content.setOnLongClickListener(new MyOnLongListener(i2));
        return view;
    }

    public void remove(int i2) {
        if (i2 < this.arrayList.size() - 1) {
            this.arrayList.remove(i2);
        }
    }

    public void seleteAlarmLog(int i2) {
        if (this.arrayList.get(i2).isChecked()) {
            this.arrayList.get(i2).setChecked(false);
        } else {
            this.arrayList.get(i2).setChecked(true);
        }
    }

    public void seleteAllAlarmLog(boolean z) {
        for (int i2 = 0; i2 < this.arrayList.size(); i2++) {
            this.arrayList.get(i2).setChecked(z);
        }
    }

    public void startEdit(boolean z) {
        for (int i2 = 0; i2 < this.arrayList.size(); i2++) {
            this.arrayList.get(i2).setEdited(z);
        }
    }
}
