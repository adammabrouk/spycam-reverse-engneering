package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.YunTaiModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.SwitchView;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SettingOtherActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public Button back;
    public RelativeLayout dingshi;
    public TextView disnghiTV;
    public SwitchView kanshou;
    public String strDID;
    public RelativeLayout yinsi;
    public TextView yinsiTV;
    public RelativeLayout zhineng;
    public final int FAILED = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 2;
    public YunTaiModel alarmModel = new YunTaiModel();
    public boolean successFlag = false;
    public Handler handler = new Handler() { // from class: com.shix.shixipc.activity.SettingOtherActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            SettingOtherActivity.this.disnghiTV.setText(TimeUtil.formatTimeS(SettingOtherActivity.this.alarmModel.getScan_start_sec()) + "-" + TimeUtil.formatTimeS(SettingOtherActivity.this.alarmModel.getScan_end_sec()));
            SettingOtherActivity.this.yinsiTV.setText(TimeUtil.formatTimeS(SettingOtherActivity.this.alarmModel.getPrivacy_start_sec()) + "-" + TimeUtil.formatTimeS(SettingOtherActivity.this.alarmModel.getPrivacy_end_sec()));
            if (SettingOtherActivity.this.alarmModel.getWatch_position_enable() == 1) {
                SettingOtherActivity.this.kanshou.setOpened(true);
            } else {
                SettingOtherActivity.this.kanshou.setOpened(false);
            }
        }
    };

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void initView() {
        this.back = (Button) findViewById(R.id.back);
        this.zhineng = (RelativeLayout) findViewById(R.id.yuntai_znzz);
        this.dingshi = (RelativeLayout) findViewById(R.id.yuntai_dsxh);
        this.yinsi = (RelativeLayout) findViewById(R.id.yuntai_ysms);
        this.disnghiTV = (TextView) findViewById(R.id.yuntai_dsxh_tv);
        this.yinsiTV = (TextView) findViewById(R.id.yuntai_ysms_tv);
        this.kanshou = (SwitchView) findViewById(R.id.yuntai_ksw);
        this.back.setOnClickListener(this);
        this.zhineng.setOnClickListener(this);
        this.dingshi.setOnClickListener(this);
        this.yinsi.setOnClickListener(this);
        this.kanshou.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingOtherActivity.2
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                SettingOtherActivity.this.kanshou.setOpened(false);
                SettingOtherActivity.this.alarmModel.setWatch_position_enable(0);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingOtherActivity.this.strDID, YunTaiModel.toJson(SettingOtherActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                SettingOtherActivity.this.kanshou.setOpened(true);
                SettingOtherActivity.this.alarmModel.setWatch_position_enable(1);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingOtherActivity.this.strDID, YunTaiModel.toJson(SettingOtherActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
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
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                break;
            case R.id.yuntai_dsxh /* 2131231688 */:
                Intent intent = new Intent(this, (Class<?>) SettingDSXHActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                startActivity(intent);
                break;
            case R.id.yuntai_ysms /* 2131231691 */:
                Intent intent2 = new Intent(this, (Class<?>) SettingYSMSActivity.class);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                startActivity(intent2);
                break;
            case R.id.yuntai_znzz /* 2131231693 */:
                Intent intent3 = new Intent(this, (Class<?>) SettingAutoActivity.class);
                intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                startActivity(intent3);
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_other);
        initView();
        getDataFromOther();
        this.alarmModel = new YunTaiModel();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NUIMainActivity.setSHIXCOMMONInterface(null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        StopHeat();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }
}
