package com.shix.shixipc.activity;

import a.k.a.r;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.FourCameraActivity;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ScreenUtils;
import com.shix.shixipc.utils.CommonUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FourCameraActivity extends BaseActivity {
    public Button back;
    public LinearLayout llAtyCamera1;
    public LinearLayout llAtyCamera2;
    public FragmentCameraFour0 mFragmentCameraFour0;
    public FragmentCameraFour1 mFragmentCameraFour1;
    public FragmentCameraFour2 mFragmentCameraFour2;
    public FragmentCameraFour3 mFragmentCameraFour3;
    public int mItemHeight;
    public int mItemWidth;
    public View tmpView2;
    public View tmpView3;
    public TextView tvSwitch;
    public int currSize = 4;
    public ArrayList<String> addDevIds = new ArrayList<>();

    private void initData() {
    }

    private void initFragment() {
        this.mFragmentCameraFour0 = (FragmentCameraFour0) getSupportFragmentManager().b(R.id.FragmentCameraFour0);
        this.mFragmentCameraFour1 = (FragmentCameraFour1) getSupportFragmentManager().b(R.id.FragmentCameraFour1);
        this.mFragmentCameraFour2 = (FragmentCameraFour2) getSupportFragmentManager().b(R.id.FragmentCameraFour2);
        this.mFragmentCameraFour3 = (FragmentCameraFour3) getSupportFragmentManager().b(R.id.FragmentCameraFour3);
        r b2 = getSupportFragmentManager().b();
        b2.e(this.mFragmentCameraFour0);
        b2.e(this.mFragmentCameraFour1);
        b2.e(this.mFragmentCameraFour2);
        b2.e(this.mFragmentCameraFour3);
        b2.a();
        invalidateOptionsMenu();
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.back);
        this.back = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourCameraActivity.this.a(view);
            }
        });
        initFragment();
        TextView textView = (TextView) findViewById(R.id.tv_aty_camera_four_switch);
        this.tvSwitch = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourCameraActivity.this.b(view);
            }
        });
        this.llAtyCamera1 = (LinearLayout) findViewById(R.id.ll_aty_camera_1);
        this.llAtyCamera2 = (LinearLayout) findViewById(R.id.ll_aty_camera_2);
        int screenWidth = (ScreenUtils.getScreenWidth() - CommonUtil.dip2px(this, 24.0f)) / 2;
        this.mItemWidth = screenWidth;
        this.mItemHeight = (screenWidth * 9) / 16;
        if (this.llAtyCamera2.getChildCount() >= 1 && this.tmpView2 == null) {
            this.tmpView2 = this.llAtyCamera2.getChildAt(0);
        }
        if (this.llAtyCamera2.getChildCount() >= 2 && this.tmpView3 == null) {
            this.tmpView3 = this.llAtyCamera2.getChildAt(1);
        }
        updateUI(this.currSize);
    }

    private void updateFragmentUI(int i2) {
        r b2 = getSupportFragmentManager().b();
        if (i2 == 2) {
            b2.e(this.mFragmentCameraFour0);
            b2.e(this.mFragmentCameraFour1);
            b2.c(this.mFragmentCameraFour2);
            b2.c(this.mFragmentCameraFour3);
        } else if (i2 == 3) {
            b2.e(this.mFragmentCameraFour0);
            b2.e(this.mFragmentCameraFour1);
            b2.e(this.mFragmentCameraFour2);
            b2.c(this.mFragmentCameraFour3);
        } else if (i2 == 4) {
            b2.e(this.mFragmentCameraFour0);
            b2.e(this.mFragmentCameraFour1);
            b2.e(this.mFragmentCameraFour2);
            b2.e(this.mFragmentCameraFour3);
        }
        b2.a();
        invalidateOptionsMenu();
    }

    private void updateUI(int i2) {
        View view;
        View view2;
        View view3;
        if (i2 == 2) {
            this.llAtyCamera1.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight * 4));
            this.llAtyCamera1.setOrientation(1);
            for (int i3 = 0; i3 < this.llAtyCamera1.getChildCount(); i3++) {
                View childAt = this.llAtyCamera1.getChildAt(i3);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                int dip2px = CommonUtil.dip2px(this, 4.0f);
                layoutParams.setMargins(dip2px, dip2px, dip2px, dip2px);
                childAt.setLayoutParams(layoutParams);
            }
            this.llAtyCamera2.setVisibility(8);
            this.llAtyCamera2.removeAllViews();
            return;
        }
        if (i2 == 3) {
            this.llAtyCamera1.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight));
            this.llAtyCamera2.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight * 2));
            if (this.llAtyCamera2.getChildCount() <= 0 && (view = this.tmpView2) != null) {
                this.llAtyCamera2.addView(view);
            }
            if (this.llAtyCamera2.getChildCount() >= 2) {
                this.llAtyCamera2.removeViewAt(1);
            }
            this.llAtyCamera2.setVisibility(0);
            return;
        }
        if (i2 != 4) {
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.mItemHeight);
        this.llAtyCamera1.setLayoutParams(layoutParams2);
        this.llAtyCamera2.setLayoutParams(layoutParams2);
        this.llAtyCamera1.setOrientation(0);
        for (int i4 = 0; i4 < this.llAtyCamera1.getChildCount(); i4++) {
            View childAt2 = this.llAtyCamera1.getChildAt(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            int dip2px2 = CommonUtil.dip2px(this, 4.0f);
            layoutParams3.setMargins(dip2px2, dip2px2, dip2px2, dip2px2);
            childAt2.setLayoutParams(layoutParams3);
        }
        if (this.llAtyCamera2.getChildCount() <= 0 && (view3 = this.tmpView2) != null) {
            this.llAtyCamera2.addView(view3);
        }
        if (this.llAtyCamera2.getChildCount() <= 1 && (view2 = this.tmpView3) != null) {
            this.llAtyCamera2.addView(view2);
        }
        this.llAtyCamera2.setVisibility(0);
    }

    public /* synthetic */ void a(View view) {
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
    }

    public void addCamera(int i2) {
        Intent intent = new Intent(this, (Class<?>) FourCameraAddActivity.class);
        intent.putExtra("ADD_POSITION", i2);
        intent.putStringArrayListExtra("ADD_CAMERA_ID_LIST", this.addDevIds);
        startActivityForResult(intent, 888);
    }

    public void addDevId(String str) {
        this.addDevIds.add(str);
    }

    public /* synthetic */ void b(View view) {
        int i2 = this.currSize;
        if (i2 == 4) {
            this.tvSwitch.setText("3+");
            this.currSize = 3;
            updateUI(3);
        } else if (i2 == 3) {
            this.tvSwitch.setText("2+");
            this.currSize = 2;
            updateUI(2);
        } else if (i2 == 2) {
            this.tvSwitch.setText("4+");
            this.currSize = 4;
            updateUI(4);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 888) {
            String stringExtra = intent.getStringExtra("ADD_CAMERA_ID");
            int intExtra = intent.getIntExtra("ADD_POSITION", -1);
            LogUtils.d("biniy", "xxxI- devId = " + stringExtra);
            LogUtils.d("biniy", "xxxI- poition = " + intExtra);
            addDevId(stringExtra);
            if (intExtra == 0) {
                this.mFragmentCameraFour0.openVideo(stringExtra);
                return;
            }
            if (intExtra == 1) {
                this.mFragmentCameraFour1.openVideo(stringExtra);
            } else if (intExtra == 2) {
                this.mFragmentCameraFour2.openVideo(stringExtra);
            } else {
                if (intExtra != 3) {
                    return;
                }
                this.mFragmentCameraFour3.openVideo(stringExtra);
            }
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_camera_four);
        initView();
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void removeDevId(int i2) {
        try {
            this.addDevIds.remove(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
