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
import com.shix.shixipc.bean.DeviceSupportModel;
import com.shix.shixipc.bean.YunTaiModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.SwitchView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingAutoActivity extends BaseActivity implements View.OnClickListener, SwitchView.OnStateChangedListener, NUIMainActivity.SHIXCOMMONInterface {
    public Button back;
    public RelativeLayout mRelativeLayout;
    public SwitchView mSwitchView1;
    public SwitchView mSwitchView2;
    public TextView mTextView;
    public RelativeLayout rxzzRl;
    public String strDID;
    public final int FAILED = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 2;
    public YunTaiModel alarmModel = new YunTaiModel();
    public DeviceSupportModel mDeviceSupportModel = new DeviceSupportModel();
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.SettingAutoActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    if (SettingAutoActivity.this.alarmModel.getTrack_enable() == 1) {
                        SettingAutoActivity.this.mSwitchView1.setOpened(true);
                    } else {
                        SettingAutoActivity.this.mSwitchView1.setOpened(false);
                    }
                    if (SettingAutoActivity.this.alarmModel.getTrack_smd_enable() == 1) {
                        SettingAutoActivity.this.mSwitchView2.setOpened(true);
                    } else {
                        SettingAutoActivity.this.mSwitchView2.setOpened(false);
                    }
                    if (SettingAutoActivity.this.alarmModel.getTrack_sensitivity() == 0) {
                        SettingAutoActivity.this.mTextView.setText(R.string.alarm_setting_5_h);
                    } else if (SettingAutoActivity.this.alarmModel.getTrack_sensitivity() == 1) {
                        SettingAutoActivity.this.mTextView.setText(R.string.alarm_setting_5_M);
                    } else if (SettingAutoActivity.this.alarmModel.getTrack_sensitivity() == 2) {
                        SettingAutoActivity.this.mTextView.setText(R.string.alarm_setting_5_L);
                    }
                }
            } else if (SettingAutoActivity.this.mDeviceSupportModel.getSmd() == 1) {
                SettingAutoActivity.this.rxzzRl.setVisibility(0);
            } else {
                SettingAutoActivity.this.rxzzRl.setVisibility(8);
            }
            return false;
        }
    });

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void initView() {
        this.mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_zzlmd);
        this.mSwitchView1 = (SwitchView) findViewById(R.id.sw_zzkg);
        this.mSwitchView2 = (SwitchView) findViewById(R.id.sw_rxzc);
        this.back = (Button) findViewById(R.id.back);
        this.mTextView = (TextView) findViewById(R.id.rl_zzlmd_tv);
        this.rxzzRl = (RelativeLayout) findViewById(R.id.rl_rxzz);
        this.mRelativeLayout.setOnClickListener(this);
        this.back.setOnClickListener(this);
        this.mSwitchView1.setOnStateChangedListener(this);
        this.mSwitchView2.setOnStateChangedListener(this);
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            int i2 = new JSONObject(str2).getInt("cmd");
            if (i2 == 119) {
                this.alarmModel = YunTaiModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(2);
            }
            if (i2 == 133) {
                this.mDeviceSupportModel = DeviceSupportModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(1);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 3) {
            this.mTextView.setText(intent.getStringExtra("result"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else {
            if (id != R.id.rl_zzlmd) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) SettingLMDActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_zhineng);
        getDataFromOther();
        initView();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getDeviceSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
    public void toggleToOff(SwitchView switchView) {
        int id = switchView.getId();
        if (id == R.id.sw_rxzc) {
            this.mSwitchView2.setOpened(false);
            this.alarmModel.setTrack_smd_enable(0);
        } else if (id == R.id.sw_zzkg) {
            this.mSwitchView1.setOpened(false);
            this.alarmModel.setTrack_enable(0);
        }
        try {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, YunTaiModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
    public void toggleToOn(SwitchView switchView) {
        int id = switchView.getId();
        if (id == R.id.sw_rxzc) {
            this.mSwitchView2.setOpened(true);
            this.alarmModel.setTrack_smd_enable(1);
        } else if (id == R.id.sw_zzkg) {
            this.mSwitchView1.setOpened(true);
            this.alarmModel.setTrack_enable(1);
        }
        try {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, YunTaiModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
