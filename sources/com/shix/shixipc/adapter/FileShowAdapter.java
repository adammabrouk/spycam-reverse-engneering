package com.shix.shixipc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.adapter.FileManageAdapter;
import com.shix.shixipc.bean.FileListDateBean;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FileShowAdapter extends RecyclerView.g<MyHolder> {
    public boolean isEditMode;
    public boolean isVideo;
    public FileManageAdapter mAdapter;
    public Context mContext;
    public String mDevDid;
    public List<FileListDateBean> mFileListDateBeans;
    public OnItemClickListener mOnItemClickListener;

    public static class MyHolder extends RecyclerView.c0 {
        public RecyclerView mShowFileRecycle;
        public TextView mShowFileTitle;

        public MyHolder(View view) {
            super(view);
            this.mShowFileTitle = (TextView) view.findViewById(R.id.show_file_title);
            this.mShowFileRecycle = (RecyclerView) view.findViewById(R.id.show_file_recycle);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i2, int i3);
    }

    public FileShowAdapter(Context context, List<FileListDateBean> list, boolean z) {
        this.mFileListDateBeans = new ArrayList();
        this.isEditMode = false;
        this.isVideo = false;
        this.mDevDid = "";
        this.mContext = context;
        this.isVideo = z;
        this.mFileListDateBeans = list;
    }

    public void deleteDate() {
        List<FileListDateBean> list = this.mFileListDateBeans;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (i2 < this.mFileListDateBeans.size()) {
            if (this.mFileListDateBeans.get(i2).getFileDateBeans().size() > 0) {
                int i3 = 0;
                while (i3 < this.mFileListDateBeans.get(i2).getFileDateBeans().size()) {
                    if (this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).isSelected()) {
                        this.mFileListDateBeans.get(i2).getFileDateBeans().remove(i3);
                        Log.e("tag", " 删除文件 下标= " + i2 + " -- " + i3);
                        i3 += -1;
                    }
                    i3++;
                }
                if (this.mFileListDateBeans.get(i2).getFileDateBeans().size() <= 0) {
                    this.mFileListDateBeans.remove(i2);
                    i2--;
                }
            }
            i2++;
        }
        notifyDataSetChanged();
    }

    public int deleteSize() {
        List<FileListDateBean> list = this.mFileListDateBeans;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.mFileListDateBeans.size(); i3++) {
            if (this.mFileListDateBeans.get(i3).getFileDateBeans().size() > 0) {
                for (int i4 = 0; i4 < this.mFileListDateBeans.get(i3).getFileDateBeans().size(); i4++) {
                    if (this.mFileListDateBeans.get(i3).getFileDateBeans().get(i4).isSelected()) {
                        i2++;
                    }
                }
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.mFileListDateBeans.size();
    }

    public void selecteAll(boolean z) {
        LogUtils.d("biniy", "isSelected3 = " + z);
        List<FileListDateBean> list = this.mFileListDateBeans;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.mFileListDateBeans.size(); i2++) {
            if (this.mFileListDateBeans.get(i2).getFileDateBeans().size() > 0) {
                for (int i3 = 0; i3 < this.mFileListDateBeans.get(i2).getFileDateBeans().size(); i3++) {
                    this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).setSelected(z);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void selecteOne(int i2, int i3, boolean z) {
        LogUtils.d("biniy", "isSelected4 = " + z);
        if (this.mFileListDateBeans.size() > 0) {
            this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).setSelected(z);
        }
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
    public void onBindViewHolder(MyHolder myHolder, final int i2) {
        if (this.mFileListDateBeans.size() > 0) {
            this.mAdapter = new FileManageAdapter(this.mContext, this.mDevDid, this.mFileListDateBeans.get(i2).getFileDateBeans(), this.isVideo, this.isEditMode);
            myHolder.mShowFileRecycle.setLayoutManager(new GridLayoutManager(this.mContext, 3));
            myHolder.mShowFileRecycle.setAdapter(this.mAdapter);
            this.mAdapter.setOnItemClickListener(new FileManageAdapter.OnItemClickListener() { // from class: com.shix.shixipc.adapter.FileShowAdapter.1
                @Override // com.shix.shixipc.adapter.FileManageAdapter.OnItemClickListener
                public void onItemClick(int i3) {
                    if (FileShowAdapter.this.mOnItemClickListener != null) {
                        FileShowAdapter.this.mOnItemClickListener.onItemClick(i2, i3);
                    }
                }
            });
            this.mAdapter.notifyDataSetChanged();
            myHolder.mShowFileTitle.setText(this.mFileListDateBeans.get(i2).getGroupTitle());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_file_show, viewGroup, false));
    }

    public FileShowAdapter(Context context, String str, List<FileListDateBean> list, boolean z) {
        this.mFileListDateBeans = new ArrayList();
        this.isEditMode = false;
        this.isVideo = false;
        this.mDevDid = "";
        this.mContext = context;
        this.isVideo = z;
        this.mFileListDateBeans = list;
        this.mDevDid = str;
    }
}
