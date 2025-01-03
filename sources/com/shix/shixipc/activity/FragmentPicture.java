package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.adapter.FragmentPicAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utils.MyLinearLayoutManager;

/* loaded from: classes.dex */
public class FragmentPicture extends BaseFragment {
    public FragmentPicAdapter mAdapter;
    public RecyclerView mRecyclerView;
    public TextView mTvTitle;
    public int type;

    public FragmentPicture(int i2) {
        this.type = i2;
    }

    private void initAdapter(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment_picture);
        this.mRecyclerView = recyclerView;
        recyclerView.setItemViewCacheSize(20);
        this.mRecyclerView.setDrawingCacheEnabled(true);
        this.mRecyclerView.setDrawingCacheQuality(MemoryConstants.MB);
        this.mAdapter = new FragmentPicAdapter(getContext(), this);
        this.mRecyclerView.setLayoutManager(new MyLinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_picture, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_fragment_title);
        this.mTvTitle = textView;
        int i2 = this.type;
        if (i2 == 0) {
            textView.setText(getResources().getString(R.string.ipc_manager_pic));
        } else if (i2 == 1) {
            textView.setText(getResources().getString(R.string.ipc_manager_locvideo));
        } else if (i2 == 2) {
            textView.setText(getResources().getString(R.string.ipc_manager_remot));
        }
        initAdapter(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtils.d("biniy", "root-pic-> onResume");
        FragmentPicAdapter fragmentPicAdapter = this.mAdapter;
        if (fragmentPicAdapter != null) {
            fragmentPicAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.shix.shixipc.BaseFragment
    public void showSetting(int i2, int i3) {
        CameraParamsBean itemCamera = this.mAdapter.getItemCamera(i2);
        if (i3 != R.id.rl_item_root) {
            return;
        }
        int i4 = this.type;
        if (i4 == 0) {
            Intent intent = new Intent(getActivity(), (Class<?>) ShowPicActivity.class);
            intent.putExtra("DEV_DID", itemCamera.getDev_Did());
            intent.putExtra("DEV_NAME", itemCamera.getDev_name());
            startActivity(intent);
            return;
        }
        if (i4 == 1) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) ShowVideoActivity.class);
            intent2.putExtra("DEV_DID", itemCamera.getDev_Did());
            intent2.putExtra("DEV_NAME", itemCamera.getDev_name());
            startActivity(intent2);
            return;
        }
        if (i4 != 2) {
            return;
        }
        SystemValue.doorBellAdmin = itemCamera.getDev_User();
        SystemValue.doorBellPass = itemCamera.getDev_Pwd();
        Intent intent3 = new Intent(getContext(), (Class<?>) PlayBackTFActivity.class);
        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
        intent3.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
        intent3.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
        intent3.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
        if (itemCamera.getDev_p2pstatus() == 2) {
            startActivity(intent3);
        } else {
            showToast(getString(R.string.device_not_on_line));
        }
    }

    public void updateUI() {
        LogUtils.d("biniy", "root-pic-> updateUI");
        FragmentPicAdapter fragmentPicAdapter = this.mAdapter;
        if (fragmentPicAdapter != null) {
            fragmentPicAdapter.notifyDataSetChanged();
        }
    }
}
