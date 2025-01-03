package com.shix.shixipc.activity;

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
import com.shix.shixipc.view.BottomDialog;
import com.shix.shixipc.view.SwitchView;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SettingYSMSActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface {
    public Button back;
    public RelativeLayout mRelativeLayout;
    public SwitchView mSwitchView;
    public String strDID;
    public TextView timeTv;
    public final int PARAMS = 2;
    public YunTaiModel alarmModel = new YunTaiModel();
    public Handler handler = new Handler() { // from class: com.shix.shixipc.activity.SettingYSMSActivity.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            SettingYSMSActivity.this.timeTv.setText(TimeUtil.formatTimeS(SettingYSMSActivity.this.alarmModel.getPrivacy_start_sec()) + "-" + TimeUtil.formatTimeS(SettingYSMSActivity.this.alarmModel.getPrivacy_end_sec()));
            if (SettingYSMSActivity.this.alarmModel.getPrivacy_enable() == 1) {
                SettingYSMSActivity.this.mSwitchView.setOpened(true);
            } else {
                SettingYSMSActivity.this.mSwitchView.setOpened(false);
            }
        }
    };

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void initView() {
        this.back = (Button) findViewById(R.id.back);
        this.mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_mdlsj);
        this.mSwitchView = (SwitchView) findViewById(R.id.sw_dsys);
        this.timeTv = (TextView) findViewById(R.id.rl_mdlsj_tv);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingYSMSActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingYSMSActivity.this.finish();
                SettingYSMSActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        this.mRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingYSMSActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final BottomDialog bottomDialog = new BottomDialog(SettingYSMSActivity.this);
                bottomDialog.show();
                bottomDialog.setStartTime(SettingYSMSActivity.this.alarmModel.getPrivacy_start_sec());
                bottomDialog.setEndTime(SettingYSMSActivity.this.alarmModel.getPrivacy_end_sec());
                bottomDialog.setCallBackListener(new BottomDialog.OnClickCallBackListener() { // from class: com.shix.shixipc.activity.SettingYSMSActivity.2.1
                    @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
                    public void OnClickCancel(View view2) {
                        bottomDialog.dismiss();
                    }

                    @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
                    public void OnClickSure(View view2) {
                        SettingYSMSActivity.this.timeTv.setText(TimeUtil.formatTimeS(bottomDialog.getStartTimes()) + "-" + TimeUtil.formatTimeS(bottomDialog.getEndTimes()));
                        SettingYSMSActivity.this.alarmModel.setPrivacy_start_sec(bottomDialog.getStartTimes());
                        SettingYSMSActivity.this.alarmModel.setPrivacy_end_sec(bottomDialog.getEndTimes());
                        try {
                            NativeCallerTools.SDKAPITransferMessage(SettingYSMSActivity.this.strDID, YunTaiModel.toJson(SettingYSMSActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        bottomDialog.dismiss();
                    }
                });
            }
        });
        this.mSwitchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingYSMSActivity.3
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                switchView.setOpened(false);
                SettingYSMSActivity.this.alarmModel.setPrivacy_enable(0);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingYSMSActivity.this.strDID, YunTaiModel.toJson(SettingYSMSActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                switchView.setOpened(true);
                SettingYSMSActivity.this.alarmModel.setPrivacy_enable(1);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingYSMSActivity.this.strDID, YunTaiModel.toJson(SettingYSMSActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
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

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_set_ysms);
        getDataFromOther();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        initView();
    }
}
