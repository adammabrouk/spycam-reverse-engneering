package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.AlarmModel;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.bean.VideoRecordModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.BottomDialog;
import com.shix.shixipc.view.SwitchView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingAlarmActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public AlarmModel alarmModel;
    public Button button_leve_1;
    public Button button_leve_2;
    public Button button_leve_3;
    public Button button_leve_4;
    public Button button_leve_5;
    public EditText edit_alarm_delay_time;
    public EditText edit_time_delay;
    public RelativeLayout layoutr_alerm_leve;
    public TextView mTvIrTimer;
    public PopupWindow popupWindow_alarm_leve;
    public View popv_alerm_leve;
    public RelativeLayout renxing;
    public SwitchView sw1;
    public SwitchView sw2;
    public SwitchView sw4;
    public SwitchView swAlarmCloudPic;
    public SwitchView swAlarmIrTimerMode;
    public TextView tv_alarm_leve;
    public String strDID = null;
    public Button ok = null;
    public Button cancel = null;
    public final int TIMEOUT = AddCameraActivity.SEARCH_TIME;
    public final int PARAMS = 3;
    public VideoRecordModel videoRecordModel = new VideoRecordModel();
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (SettingAlarmActivity.this.strDID.startsWith(ContentCommon.SHIX_APPRE4)) {
                    if (SettingAlarmActivity.this.videoRecordModel.getVideoRecord() == 3) {
                        SettingAlarmActivity.this.alarmModel.setPirvideo(1);
                        return;
                    } else {
                        SettingAlarmActivity.this.alarmModel.setPirvideo(0);
                        return;
                    }
                }
                return;
            }
            if (i2 != 3) {
                if (i2 != 221) {
                    return;
                }
                try {
                    CameraParmsModel jsonToModel = CameraParmsModel.jsonToModel((String) message.obj);
                    if (jsonToModel != null) {
                        if (jsonToModel.getOss_push_en() == 1) {
                            SettingAlarmActivity.this.swAlarmCloudPic.setOpened(true);
                        } else {
                            SettingAlarmActivity.this.swAlarmCloudPic.setOpened(false);
                        }
                        if (jsonToModel.getIr_mode_timer_en() == 1) {
                            SettingAlarmActivity.this.swAlarmIrTimerMode.setOpened(true);
                        } else {
                            SettingAlarmActivity.this.swAlarmIrTimerMode.setOpened(false);
                        }
                        SettingAlarmActivity.this.startSec = jsonToModel.getIr_mode_start_sec();
                        SettingAlarmActivity.this.endSec = jsonToModel.getIr_mode_end_sec();
                        SettingAlarmActivity.this.mTvIrTimer.setText(TimeUtil.formatTimeS(jsonToModel.getIr_mode_start_sec()) + "-" + TimeUtil.formatTimeS(jsonToModel.getIr_mode_end_sec()));
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (SettingAlarmActivity.this.alarmModel.getPirenable() == 1) {
                SettingAlarmActivity.this.sw1.setOpened(true);
            } else {
                SettingAlarmActivity.this.sw1.setOpened(false);
            }
            if (SettingAlarmActivity.this.alarmModel.getMotion_smd_enable() == 1) {
                SettingAlarmActivity.this.sw4.setOpened(true);
            } else {
                SettingAlarmActivity.this.sw4.setOpened(false);
            }
            if (SettingAlarmActivity.this.alarmModel.getPirPush() == 1) {
                SettingAlarmActivity.this.sw2.setOpened(true);
            } else {
                SettingAlarmActivity.this.sw2.setOpened(false);
            }
            SettingAlarmActivity.this.edit_time_delay.setText(SettingAlarmActivity.this.alarmModel.getPirdelaytime() + "");
            SettingAlarmActivity.this.edit_alarm_delay_time.setText(SettingAlarmActivity.this.alarmModel.getPirvideotime() + "");
            if (SettingAlarmActivity.this.alarmModel.getPirsensitive() == 3) {
                SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_h));
            } else if (SettingAlarmActivity.this.alarmModel.getPirsensitive() == 2) {
                SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_M));
            } else {
                SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_L));
            }
        }
    };
    public String cameraName = null;
    public int startSec = 0;
    public int endSec = 0;
    public boolean isGetAlarmModel = false;
    public boolean isGetVideoRecordModel = false;

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        if (SharedPreferencesUtils.getInstance().getInt("isSmd", 0) == 0) {
            this.renxing.setVisibility(8);
        } else {
            this.renxing.setVisibility(0);
        }
    }

    private String retrunTime(int i2) {
        if (i2 < 10) {
            return "0" + i2;
        }
        return "" + i2;
    }

    private void showTime() {
        final BottomDialog bottomDialog = new BottomDialog(this);
        bottomDialog.show();
        bottomDialog.setStartTime(this.startSec);
        bottomDialog.setEndTime(this.endSec);
        bottomDialog.setCallBackListener(new BottomDialog.OnClickCallBackListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.6
            @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
            public void OnClickCancel(View view) {
                bottomDialog.dismiss();
            }

            @Override // com.shix.shixipc.view.BottomDialog.OnClickCallBackListener
            public void OnClickSure(View view) {
                SettingAlarmActivity.this.startSec = bottomDialog.getStartTimes();
                SettingAlarmActivity.this.endSec = bottomDialog.getEndTimes();
                SettingAlarmActivity.this.mTvIrTimer.setText(TimeUtil.formatTimeS(bottomDialog.getStartTimes()) + "-" + TimeUtil.formatTimeS(bottomDialog.getEndTimes()));
                bottomDialog.dismiss();
            }
        });
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            int i2 = new JSONObject(str2).getInt("cmd");
            LogUtils.e("biniy", "cmd-> " + i2 + "--json-> " + str2);
            if (i2 == 107) {
                this.isGetAlarmModel = true;
                this.alarmModel = AlarmModel.jsonToModel(str2);
                this.mHandler.sendEmptyMessage(3);
            }
            if (i2 == 199) {
                this.isGetVideoRecordModel = true;
                this.videoRecordModel = VideoRecordModel.jsonToModel(str2);
                this.mHandler.sendEmptyMessage(0);
            }
            if (i2 == 101) {
                Message message = new Message();
                message.what = 221;
                message.obj = str2;
                this.mHandler.sendMessage(message);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void initExitPopupWindow_leve() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_alarm_leve, (ViewGroup) null);
        this.popv_alerm_leve = inflate;
        this.button_leve_1 = (Button) inflate.findViewById(R.id.button_leve_1);
        this.button_leve_2 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_2);
        this.button_leve_3 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_3);
        this.button_leve_4 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_4);
        this.button_leve_5 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_5);
        this.button_leve_1.setOnClickListener(this);
        this.button_leve_2.setOnClickListener(this);
        this.button_leve_3.setOnClickListener(this);
        this.button_leve_4.setOnClickListener(this);
        this.button_leve_5.setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(this.popv_alerm_leve, -2, -2);
        this.popupWindow_alarm_leve = popupWindow;
        popupWindow.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_alarm_leve.setFocusable(true);
        this.popupWindow_alarm_leve.setOutsideTouchable(true);
        this.popupWindow_alarm_leve.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_alarm_leve.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.7
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SettingAlarmActivity.this.popupWindow_alarm_leve.dismiss();
            }
        });
        this.popupWindow_alarm_leve.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingAlarmActivity.this.popupWindow_alarm_leve.dismiss();
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layoutr_alerm_leve) {
            this.popupWindow_alarm_leve.showAtLocation(this.layoutr_alerm_leve, 17, 0, 0);
        }
        if (id == R.id.tv_alarm_ir_timer) {
            showTime();
            return;
        }
        switch (id) {
            case R.id.alerm_cancel /* 2131230808 */:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                break;
            case R.id.alerm_ok /* 2131230809 */:
                int parseInt = Integer.parseInt(this.edit_alarm_delay_time.getText().toString().trim());
                int parseInt2 = Integer.parseInt(this.edit_time_delay.getText().toString().trim());
                int i2 = 10;
                if (parseInt >= 10 && parseInt <= 60) {
                    int i3 = 30;
                    if (parseInt2 >= 30 && parseInt2 <= 240) {
                        if (this.isGetAlarmModel && this.isGetVideoRecordModel) {
                            if (this.edit_alarm_delay_time.getText().toString().trim().length() == 0) {
                                showToast(R.string.door_setting_alarm_show1);
                                this.alarmModel.setPirvideotime(10);
                            } else {
                                int parseInt3 = Integer.parseInt(this.edit_alarm_delay_time.getText().toString().trim());
                                if (parseInt3 >= 10 && parseInt3 <= 60) {
                                    i2 = parseInt3;
                                }
                                this.alarmModel.setPirvideotime(i2);
                            }
                            if (this.edit_time_delay.getText().toString().trim().length() == 0) {
                                this.alarmModel.setPirdelaytime(30);
                            } else {
                                int parseInt4 = Integer.parseInt(this.edit_time_delay.getText().toString().trim());
                                if (parseInt4 >= 30 && parseInt4 <= 240) {
                                    i3 = parseInt4;
                                }
                                this.alarmModel.setPirdelaytime(i3);
                            }
                            String str = this.strDID;
                            String str2 = SystemValue.doorBellAdmin;
                            String str3 = SystemValue.doorBellPass;
                            boolean isOpened = this.swAlarmCloudPic.isOpened();
                            boolean isOpened2 = this.swAlarmIrTimerMode.isOpened();
                            NativeCallerTools.SDKAPITransferMessage(str, CommonUtil.setCameraParms(str2, str3, isOpened ? 1 : 0, isOpened2 ? 1 : 0, this.startSec, this.endSec));
                            try {
                                NativeCallerTools.SDKAPITransferMessage(this.strDID, AlarmModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                                NativeCallerTools.SDKAPITransferMessage(this.strDID, VideoRecordModel.toJson(this.videoRecordModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            finish();
                            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                            break;
                        }
                    } else {
                        showToast(R.string.edit_time_delay);
                        break;
                    }
                } else {
                    showToast(R.string.edit_alarm_delay_time);
                    break;
                }
                break;
            default:
                switch (id) {
                    case R.id.button_leve_1 /* 2131230876 */:
                        this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_h));
                        this.alarmModel.setPirsensitive(3);
                        this.popupWindow_alarm_leve.dismiss();
                        break;
                    case R.id.button_leve_2 /* 2131230877 */:
                        this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_M));
                        this.alarmModel.setPirsensitive(2);
                        this.popupWindow_alarm_leve.dismiss();
                        break;
                    case R.id.button_leve_3 /* 2131230878 */:
                        this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_L));
                        this.alarmModel.setPirsensitive(1);
                        this.popupWindow_alarm_leve.dismiss();
                        break;
                    case R.id.button_leve_4 /* 2131230879 */:
                        this.popupWindow_alarm_leve.dismiss();
                        break;
                    case R.id.button_leve_5 /* 2131230880 */:
                        this.popupWindow_alarm_leve.dismiss();
                        break;
                }
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.settingalarm);
        BarUtils.setStatusBarColor(this, Color.parseColor("#FFFFFFFF"));
        this.renxing = (RelativeLayout) findViewById(R.id.renxing);
        TextView textView = (TextView) findViewById(R.id.tv_alarm_ir_timer);
        this.mTvIrTimer = textView;
        textView.setOnClickListener(this);
        this.swAlarmCloudPic = (SwitchView) findViewById(R.id.sw_alarm_cloud_pic);
        this.swAlarmIrTimerMode = (SwitchView) findViewById(R.id.sw_alarm_ir_timer_mode);
        getDataFromOther();
        this.alarmModel = new AlarmModel();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        new Thread(new Runnable() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NativeCallerTools.SDKAPITransferMessage(SettingAlarmActivity.this.strDID, CommonUtil.getAlarmParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                    Thread.sleep(50L);
                    NativeCallerTools.SDKAPITransferMessage(SettingAlarmActivity.this.strDID, CommonUtil.getRDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                    Thread.sleep(50L);
                    NativeCallerTools.SDKAPITransferMessage(SettingAlarmActivity.this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
        SwitchView switchView = (SwitchView) findViewById(R.id.sw1);
        this.sw1 = switchView;
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.3
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView2) {
                SettingAlarmActivity.this.sw1.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setPirenable(0);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView2) {
                SettingAlarmActivity.this.sw1.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setPirenable(1);
            }
        });
        SwitchView switchView2 = (SwitchView) findViewById(R.id.sw2);
        this.sw2 = switchView2;
        switchView2.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.4
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView3) {
                SettingAlarmActivity.this.sw2.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setPirPush(0);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView3) {
                SettingAlarmActivity.this.sw2.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setPirPush(1);
            }
        });
        SwitchView switchView3 = (SwitchView) findViewById(R.id.sw4);
        this.sw4 = switchView3;
        switchView3.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingAlarmActivity.5
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView4) {
                SettingAlarmActivity.this.sw4.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setMotion_smd_enable(0);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView4) {
                SettingAlarmActivity.this.sw4.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setMotion_smd_enable(1);
            }
        });
        this.edit_alarm_delay_time = (EditText) findViewById(R.id.edit_alarm_delay_time);
        this.edit_time_delay = (EditText) findViewById(R.id.edit_time_delay);
        this.ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.tv_alarm_leve = (TextView) findViewById(R.id.tv_alarm_leve);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutr_alerm_leve);
        this.layoutr_alerm_leve = relativeLayout;
        relativeLayout.setOnClickListener(this);
        initExitPopupWindow_leve();
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
