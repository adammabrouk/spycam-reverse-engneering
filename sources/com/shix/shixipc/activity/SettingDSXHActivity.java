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
public class SettingDSXHActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface {
    public Button back;
    public RelativeLayout mRelativeLayout;
    public SwitchView mSwitchView;
    public String strDID;
    public TextView timeTv;
    public final int PARAMS = 2;
    public YunTaiModel alarmModel = new YunTaiModel();
    public Handler handler = new Handler() { // from class: com.shix.shixipc.activity.SettingDSXHActivity.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            SettingDSXHActivity.this.timeTv.setText(TimeUtil.formatTimeS(SettingDSXHActivity.this.alarmModel.getScan_start_sec()) + "-" + TimeUtil.formatTimeS(SettingDSXHActivity.this.alarmModel.getScan_end_sec()));
            if (SettingDSXHActivity.this.alarmModel.getScan_enable() == 1) {
                SettingDSXHActivity.this.mSwitchView.setOpened(true);
            } else {
                SettingDSXHActivity.this.mSwitchView.setOpened(false);
            }
        }
    };

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void initView() {
        this.back = (Button) findViewById(R.id.back);
        this.mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_xhsj);
        this.mSwitchView = (SwitchView) findViewById(R.id.sw_xhkg);
        this.timeTv = (TextView) findViewById(R.id.rl_xhsj_tv);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingDSXHActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDSXHActivity.this.finish();
                SettingDSXHActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        this.mRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingDSXHActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final BottomDialog bottomDialog = new BottomDialog(SettingDSXHActivity.this);
                bottomDialog.show();
                bottomDialog.setStartTime(SettingDSXHActivity.this.alarmModel.getScan_start_sec());
                bottomDialog.setEndTime(SettingDSXHActivity.this.alarmModel.getScan_end_sec());
                bottomDialog.setCallBackListener(new BottomDialog.OnClickCallBackListener() { // from class: com.shix.shixipc.activity.SettingDSXHActivity.2.1
                    @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
                    public void OnClickCancel(View view2) {
                        bottomDialog.dismiss();
                    }

                    @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
                    public void OnClickSure(View view2) {
                        SettingDSXHActivity.this.timeTv.setText(TimeUtil.formatTimeS(bottomDialog.getStartTimes()) + "-" + TimeUtil.formatTimeS(bottomDialog.getEndTimes()));
                        SettingDSXHActivity.this.alarmModel.setScan_start_sec(bottomDialog.getStartTimes());
                        SettingDSXHActivity.this.alarmModel.setScan_end_sec(bottomDialog.getEndTimes());
                        try {
                            NativeCallerTools.SDKAPITransferMessage(SettingDSXHActivity.this.strDID, YunTaiModel.toJson(SettingDSXHActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        bottomDialog.dismiss();
                    }
                });
            }
        });
        this.mSwitchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingDSXHActivity.3
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                switchView.setOpened(false);
                SettingDSXHActivity.this.alarmModel.setScan_enable(0);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingDSXHActivity.this.strDID, YunTaiModel.toJson(SettingDSXHActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                switchView.setOpened(true);
                SettingDSXHActivity.this.alarmModel.setScan_enable(1);
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingDSXHActivity.this.strDID, YunTaiModel.toJson(SettingDSXHActivity.this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
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
        setContentView(R.layout.activity_set_dsxh);
        getDataFromOther();
        initView();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }
}
