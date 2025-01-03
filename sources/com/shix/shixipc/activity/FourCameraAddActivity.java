package com.shix.shixipc.activity;

import a.p.a.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.FourCameraAddActivity;
import com.shix.shixipc.adapter.FourCameraAddAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utils.MyLinearLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FourCameraAddActivity extends BaseActivity {
    public int addPosition = -1;
    public Button back;
    public ArrayList<String> beans;
    public FourCameraAddAdapter mAdapter;
    public RecyclerView mRecyclerView;

    private void initAdapter() {
        this.mRecyclerView.setItemViewCacheSize(20);
        this.mRecyclerView.setDrawingCacheEnabled(true);
        this.mRecyclerView.setDrawingCacheQuality(MemoryConstants.MB);
        this.mRecyclerView.setLayoutManager(new MyLinearLayoutManager(this));
        d dVar = new d(this.mRecyclerView.getContext(), 1);
        dVar.setDrawable(getResources().getDrawable(R.drawable.inset_recyclerview_divider));
        this.mRecyclerView.addItemDecoration(dVar);
        FourCameraAddAdapter fourCameraAddAdapter = new FourCameraAddAdapter(this);
        this.mAdapter = fourCameraAddAdapter;
        fourCameraAddAdapter.addOnClickListener(new FourCameraAddAdapter.OnClickListener() { // from class: c.h.a.a.m
            @Override // com.shix.shixipc.adapter.FourCameraAddAdapter.OnClickListener
            public final void onClick(CameraParamsBean cameraParamsBean) {
                FourCameraAddActivity.this.a(cameraParamsBean);
            }
        });
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    private void initData() {
        getIntent().getExtras();
        this.addPosition = getIntent().getIntExtra("ADD_POSITION", -1);
        LogUtils.d("biniy", "xxxI- addPosition = " + this.addPosition);
        this.beans = getIntent().getStringArrayListExtra("ADD_CAMERA_ID_LIST");
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.back);
        this.back = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourCameraAddActivity.this.a(view);
            }
        });
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_four_camera_add);
    }

    public /* synthetic */ void a(CameraParamsBean cameraParamsBean) {
        ArrayList<String> arrayList = this.beans;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = this.beans.iterator();
            while (it.hasNext()) {
                if (cameraParamsBean.getDev_Did().equals(it.next())) {
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("ADD_CAMERA_ID", cameraParamsBean.getDev_Did());
        intent.putExtra("ADD_POSITION", this.addPosition);
        setResult(-1, intent);
        finish();
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_camera_four_add);
        initView();
        initData();
        initAdapter();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public /* synthetic */ void a(View view) {
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
    }
}
