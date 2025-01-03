package com.shix.shixipc.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.e;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.FileDateBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.RoundCornerImageView;
import java.util.List;

/* loaded from: classes.dex */
public class FileManageAdapter extends RecyclerView.g<TestHolder> {
    public List<FileDateBean> data;
    public boolean isEditMode;
    public boolean isVideo;
    public Context mContext;
    public String mDevDid;
    public OnItemClickListener mOnItemClickListener;
    public String picFile;
    public String videoFile;

    public interface OnItemClickListener {
        void onItemClick(int i2);
    }

    public static class TestHolder extends RecyclerView.c0 {
        public CheckBox mGridCb;
        public RoundCornerImageView mGridItem;
        public ImageView mImgVideo;

        public TestHolder(View view) {
            super(view);
            this.mGridItem = (RoundCornerImageView) view.findViewById(R.id.grid_item);
            this.mGridCb = (CheckBox) view.findViewById(R.id.grid_cb);
            this.mImgVideo = (ImageView) view.findViewById(R.id.img_video);
        }
    }

    public FileManageAdapter(Context context, List<FileDateBean> list, boolean z) {
        this.isVideo = false;
        this.isEditMode = false;
        this.mDevDid = "";
        this.picFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + ContentCommon.SAVEFILES + "/";
        this.videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/";
        this.data = list;
        this.isVideo = z;
        this.mContext = context;
    }

    public void deleteFile(List<FileDateBean> list) {
        List<FileDateBean> list2 = this.data;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < this.data.size(); i3++) {
                if (list.get(i2).getFileName().equals(this.data.get(i3).getFileName())) {
                    this.data.remove(i3);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void deleteFile2() {
        List<FileDateBean> list = this.data;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            if (this.data.get(i2).isSelected()) {
                this.data.remove(i2);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        List<FileDateBean> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<FileDateBean> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void updateMode(boolean z) {
        this.isEditMode = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(TestHolder testHolder, final int i2) {
        List<FileDateBean> list = this.data;
        if (list == null || list.size() <= 0) {
            return;
        }
        testHolder.mGridItem.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.adapter.FileManageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FileManageAdapter.this.mOnItemClickListener != null) {
                    FileManageAdapter.this.mOnItemClickListener.onItemClick(i2);
                }
            }
        });
        LogUtils.d("biniy", "isSelected = " + this.data.get(i2).isSelected());
        testHolder.mGridCb.setChecked(this.data.get(i2).isSelected());
        if (this.isVideo) {
            testHolder.mImgVideo.setVisibility(0);
            if (FileUtil.fileIsExists(this.videoFile + this.data.get(i2).getFileName())) {
                e.b(this.mContext).a(this.videoFile + this.data.get(i2).getFileName()).a((ImageView) testHolder.mGridItem);
            } else {
                e.b(this.mContext).a(Integer.valueOf(R.mipmap.n_dev_item_df_default)).a((ImageView) testHolder.mGridItem);
            }
            if (this.isEditMode) {
                testHolder.mGridCb.setVisibility(0);
                return;
            } else {
                testHolder.mGridCb.setVisibility(8);
                return;
            }
        }
        testHolder.mImgVideo.setVisibility(8);
        if (FileUtil.fileIsExists(this.picFile + this.data.get(i2).getFileName())) {
            e.b(this.mContext).a(this.picFile + this.data.get(i2).getFileName()).a((ImageView) testHolder.mGridItem);
        } else {
            e.b(this.mContext).a(Integer.valueOf(R.mipmap.n_dev_item_df_default)).a((ImageView) testHolder.mGridItem);
        }
        if (this.isEditMode) {
            testHolder.mGridCb.setVisibility(0);
        } else {
            testHolder.mGridCb.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public TestHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new TestHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false));
    }

    public FileManageAdapter(Context context, String str, List<FileDateBean> list, boolean z, boolean z2) {
        this.isVideo = false;
        this.isEditMode = false;
        this.mDevDid = "";
        this.picFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + ContentCommon.SAVEFILES + "/";
        this.videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/";
        this.data = list;
        this.isVideo = z;
        this.mContext = context;
        this.isEditMode = z2;
        this.mDevDid = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.picFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + this.mDevDid + "/";
        this.videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + this.mDevDid + "/";
    }

    public FileManageAdapter(Context context, List<FileDateBean> list, boolean z, boolean z2) {
        this.isVideo = false;
        this.isEditMode = false;
        this.mDevDid = "";
        this.picFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + ContentCommon.SAVEFILES + "/";
        this.videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/";
        this.data = list;
        this.isVideo = z;
        this.mContext = context;
        this.isEditMode = z2;
    }
}
