package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.PlayTFStatusBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PlaybackTFAdapter extends BaseExpandableListAdapter {
    public LayoutInflater inflater;
    public onClickButton mClickButton;
    public boolean isRepeat = false;
    public boolean isEditMode = false;
    public List<PlayTFStatusBean> checks = new ArrayList();
    public boolean isSelete = false;
    public List<String> groupList = new ArrayList();
    public Map<String, List<String>> childMap = new HashMap();

    public class CViewHolder {
        public TextView content;
        public ImageView iv_download;
        public CheckBox play_back_cb;
        public ImageView textView2;

        public CViewHolder() {
        }
    }

    public class GViewHolder {
        public ImageView img;
        public TextView tvdate;
        public TextView tvsum;

        public GViewHolder() {
        }
    }

    public interface onClickButton {
        void clickDownload(int i2, int i3);

        void clickPlay(String str);
    }

    public PlaybackTFAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private boolean isRepeat(String str) {
        String[] list = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/").list();
        if (list == null) {
            return false;
        }
        for (int i2 = 0; i2 < list.length; i2++) {
            MyLogUtils.d("TAG", "fileName:" + str + "   " + list[i2]);
            list[i2] = list[i2].replace("IMG_", "");
            list[i2] = list[i2].replace("jpg", "avi");
            if (str.equals(list[i2])) {
                return true;
            }
        }
        return false;
    }

    private boolean isRepeat2(String str) {
        String[] list = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/").list();
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void addGroupAndChild(String str, String str2) {
        if (this.groupList.contains(str)) {
            this.childMap.get(str).add(str2);
            return;
        }
        this.groupList.add(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.childMap.put(str, arrayList);
    }

    public String delChildFilePath(int i2, int i3) {
        return this.childMap.get(this.groupList.get(i2)).remove(i3);
    }

    public void delChildForFilePath(String str) {
        for (int i2 = 0; i2 < this.groupList.size(); i2++) {
            List<String> list = this.childMap.get(this.groupList.get(i2));
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).equals(str)) {
                    delChildFilePath(i2, i3);
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i2, int i3) {
        return this.childMap.get(this.groupList.get(i2)).get(i3);
    }

    public String getChildFilePath(int i2, int i3) {
        return this.childMap.get(this.groupList.get(i2)).get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return i3;
    }

    public boolean getChildStatus(int i2, int i3) {
        boolean z = false;
        for (int i4 = 0; i4 < this.checks.size(); i4++) {
            if (this.checks.get(i4).getGroupPosition() == i2 && this.checks.get(i4).getChildPosition() == i3) {
                z = this.checks.get(i4).isSelected();
            }
        }
        return z;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(final int i2, final int i3, boolean z, View view, ViewGroup viewGroup) {
        CViewHolder cViewHolder;
        final boolean z2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.playbacktf_childlistitem, (ViewGroup) null);
            cViewHolder = new CViewHolder();
            cViewHolder.content = (TextView) view.findViewById(R.id.tv_datetime);
            cViewHolder.iv_download = (ImageView) view.findViewById(R.id.iv_download);
            cViewHolder.play_back_cb = (CheckBox) view.findViewById(R.id.play_back_cb);
            cViewHolder.textView2 = (ImageView) view.findViewById(R.id.textView2);
            view.setTag(cViewHolder);
        } else {
            cViewHolder = (CViewHolder) view.getTag();
        }
        cViewHolder.play_back_cb.setChecked(false);
        for (int i4 = 0; i4 < this.checks.size(); i4++) {
            if (this.checks.get(i4).getGroupPosition() == i2 && this.checks.get(i4).getChildPosition() == i3) {
                cViewHolder.play_back_cb.setChecked(this.checks.get(i4).isSelected());
            }
        }
        this.isSelete = cViewHolder.play_back_cb.isChecked();
        if (this.isEditMode) {
            cViewHolder.textView2.setVisibility(8);
            cViewHolder.play_back_cb.setVisibility(0);
        } else {
            cViewHolder.textView2.setVisibility(0);
            cViewHolder.play_back_cb.setVisibility(8);
        }
        final String str = this.childMap.get(this.groupList.get(i2)).get(i3);
        cViewHolder.content.setText(str);
        boolean isRepeat2 = isRepeat2(str);
        this.isRepeat = isRepeat2;
        if (isRepeat2) {
            cViewHolder.iv_download.setImageResource(R.mipmap.hz_item_tf);
            z2 = true;
        } else {
            cViewHolder.iv_download.setImageResource(R.mipmap.h_download);
            z2 = false;
        }
        cViewHolder.iv_download.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.adapter.PlaybackTFAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                onClickButton onclickbutton = PlaybackTFAdapter.this.mClickButton;
                if (onclickbutton != null) {
                    if (z2) {
                        onclickbutton.clickPlay(str);
                    } else {
                        onclickbutton.clickDownload(i2, i3);
                    }
                }
            }
        });
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        return this.childMap.get(this.groupList.get(i2)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i2) {
        return this.groupList.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.groupList.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return i2;
    }

    public String[] getGroupTitleAndSum(int i2) {
        String str = this.groupList.get(i2);
        return new String[]{str, String.valueOf(this.childMap.get(str).size())};
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        GViewHolder gViewHolder;
        if (view == null) {
            gViewHolder = new GViewHolder();
            view2 = this.inflater.inflate(R.layout.playbacktf_grouplistitem, (ViewGroup) null);
            gViewHolder.tvdate = (TextView) view2.findViewById(R.id.tv_date);
            gViewHolder.tvsum = (TextView) view2.findViewById(R.id.tv_sum);
            gViewHolder.img = (ImageView) view2.findViewById(R.id.img);
            view2.setTag(gViewHolder);
        } else {
            view2 = view;
            gViewHolder = (GViewHolder) view.getTag();
        }
        if (z) {
            gViewHolder.img.setImageResource(R.mipmap.qh_down);
        } else {
            gViewHolder.img.setImageResource(R.mipmap.qh_right_next);
        }
        String str = this.groupList.get(i2);
        List<String> list = this.childMap.get(str);
        gViewHolder.tvdate.setText(str);
        if (list != null) {
            gViewHolder.tvsum.setText(String.valueOf(list.size()));
        }
        return view2;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public boolean isSeleteed(int i2, int i3) {
        return this.isSelete;
    }

    public PlaybackTFAdapter setClickDownload(onClickButton onclickbutton) {
        this.mClickButton = onclickbutton;
        return this;
    }

    public void setEditMode(boolean z) {
        this.isEditMode = z;
        notifyDataSetChanged();
    }

    public void setSeleteAll(int i2) {
        for (int i3 = 0; i3 < getChildrenCount(i2); i3++) {
            this.checks.add(new PlayTFStatusBean(i2, i3, true));
        }
        notifyDataSetChanged();
    }

    public void setSeleteAllCancel() {
        this.checks.clear();
        notifyDataSetChanged();
    }

    public void setSeleteOne(int i2, int i3, boolean z) {
        this.checks.add(new PlayTFStatusBean(i2, i3, z));
        for (int i4 = 0; i4 < this.checks.size(); i4++) {
        }
        notifyDataSetChanged();
    }
}
