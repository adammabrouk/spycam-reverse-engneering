package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.YunTaiModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SettingLMDActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public Button back;
    public ImageView dlmdiv;
    public RelativeLayout dlmdrl;
    public RelativeLayout glmdrl;
    public ImageView glmiv;
    public String strDID;
    public ImageView zlmdiv;
    public RelativeLayout zlmdrl;
    public final int FAILED = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 2;
    public YunTaiModel alarmModel = new YunTaiModel();
    public Handler handler = new Handler() { // from class: com.shix.shixipc.activity.SettingLMDActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            SettingLMDActivity settingLMDActivity = SettingLMDActivity.this;
            settingLMDActivity.setChangeImageView(settingLMDActivity.alarmModel.getTrack_sensitivity());
        }
    };

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private String getStringLmd(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? "" : getResources().getString(R.string.alarm_setting_5_L) : getResources().getString(R.string.alarm_setting_5_M) : getResources().getString(R.string.alarm_setting_5_h);
    }

    private void initView() {
        this.back = (Button) findViewById(R.id.back);
        this.glmdrl = (RelativeLayout) findViewById(R.id.rl_glmd);
        this.zlmdrl = (RelativeLayout) findViewById(R.id.rl_zlmd);
        this.dlmdrl = (RelativeLayout) findViewById(R.id.rl_dlmd);
        this.glmiv = (ImageView) findViewById(R.id.iv_glmd);
        this.zlmdiv = (ImageView) findViewById(R.id.iv_zlmd);
        this.dlmdiv = (ImageView) findViewById(R.id.iv_dlmd);
        this.back.setOnClickListener(this);
        this.glmdrl.setOnClickListener(this);
        this.zlmdrl.setOnClickListener(this);
        this.dlmdrl.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeImageView(int i2) {
        if (i2 == 0) {
            this.glmiv.setVisibility(0);
            this.zlmdiv.setVisibility(8);
            this.dlmdiv.setVisibility(8);
        } else if (i2 == 1) {
            this.glmiv.setVisibility(8);
            this.zlmdiv.setVisibility(0);
            this.dlmdiv.setVisibility(8);
        } else {
            if (i2 != 2) {
                return;
            }
            this.glmiv.setVisibility(8);
            this.zlmdiv.setVisibility(8);
            this.dlmdiv.setVisibility(0);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", "")) || str2.indexOf("119") <= 0) {
            return;
        }
        try {
            this.alarmModel = YunTaiModel.jsonToModel(str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.handler.sendEmptyMessage(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131230819 */:
                Intent intent = new Intent();
                intent.putExtra("result", getStringLmd(this.alarmModel.getTrack_sensitivity()));
                setResult(3, intent);
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                break;
            case R.id.rl_dlmd /* 2131231368 */:
                setChangeImageView(2);
                this.alarmModel.setTrack_sensitivity(2);
                break;
            case R.id.rl_glmd /* 2131231369 */:
                setChangeImageView(0);
                this.alarmModel.setTrack_sensitivity(0);
                break;
            case R.id.rl_zlmd /* 2131231380 */:
                setChangeImageView(1);
                this.alarmModel.setTrack_sensitivity(1);
                break;
        }
        try {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, YunTaiModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_lmd);
        getDataFromOther();
        initView();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("result", getStringLmd(this.alarmModel.getTrack_sensitivity()));
        setResult(3, intent.putExtras(bundle));
        finish();
        return true;
    }
}
