package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.zxing.decoding.InactivityTimer;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.AlarmModel;
import com.shix.shixipc.bean.DeviceOffTimeModel;
import com.shix.shixipc.bean.SDCardModel;
import com.shix.shixipc.bean.SdcardBean;
import com.shix.shixipc.bean.VideoRecordModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.view.SwitchView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingSDCardActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, NUIMainActivity.SHIXCOMMONInterface {
    public AlarmModel alarmModel;
    public Button btn_videomode0;
    public PopupWindow popupWindow_bit;
    public PopupWindow popupWindow_videomode;
    public View popv_bit;
    public View popv_videomode;
    public SharedPreferences preuser;
    public SDCardModel sdModel;
    public SdcardBean sdcardBean;
    public Button set_sd_format;
    public SwitchView sv_audio;
    public SwitchView sv_loop;
    public int time15;
    public int time23;
    public int time7;
    public TextView tvSdcardStatus;
    public TextView tv_bit;
    public TextView tv_endtime;
    public TextView tv_mode;
    public TextView tv_starttime;
    public TextView tvSdTotal = null;
    public TextView tvSdRemain = null;
    public CheckBox cbxConverage = null;
    public EditText editRecordLength = null;
    public Button btnBack = null;
    public Button btnOk = null;
    public final int TIMEOUT = AddCameraActivity.SEARCH_TIME;
    public String strDID = null;
    public ProgressDialog progressDialog = null;
    public ProgressDialog progressDialog1 = null;
    public boolean successFlag = false;
    public final int FAILED = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 2;
    public VideoRecordModel videoRecordModel = new VideoRecordModel();
    public DeviceOffTimeModel mDeviceOffTimeModel = new DeviceOffTimeModel();
    public int m_start_time_hour = 0;
    public int m_start_time_min = 0;
    public int m_end_time_hour = 0;
    public int m_end_time_min = 0;
    public boolean isSuccessFlag = true;
    public boolean isChangeFlag = false;
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                SettingSDCardActivity.this.showToast(R.string.sdcard_set_failed);
            } else if (i2 == 1) {
                SettingSDCardActivity.this.handler.removeCallbacksAndMessages(null);
                SettingSDCardActivity.this.showToast(R.string.sdcard_set_success);
                SettingSDCardActivity.this.finish();
                SettingSDCardActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            } else if (i2 == 2) {
                SettingSDCardActivity.this.successFlag = true;
                SettingSDCardActivity.this.progressDialog.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                    settingSDCardActivity.m_start_time_hour = settingSDCardActivity.videoRecordModel.getStart_time() / 3600;
                    SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                    settingSDCardActivity2.m_start_time_min = (settingSDCardActivity2.videoRecordModel.getStart_time() % 3600) / 60;
                    SettingSDCardActivity settingSDCardActivity3 = SettingSDCardActivity.this;
                    settingSDCardActivity3.m_end_time_hour = settingSDCardActivity3.videoRecordModel.getEnd_time() / 3600;
                    SettingSDCardActivity settingSDCardActivity4 = SettingSDCardActivity.this;
                    settingSDCardActivity4.m_end_time_min = (settingSDCardActivity4.videoRecordModel.getEnd_time() % 3600) / 60;
                    TextView textView = SettingSDCardActivity.this.tv_starttime;
                    StringBuilder sb = new StringBuilder();
                    SettingSDCardActivity settingSDCardActivity5 = SettingSDCardActivity.this;
                    sb.append(settingSDCardActivity5.getStrHour(settingSDCardActivity5.m_start_time_hour));
                    sb.append(" : ");
                    SettingSDCardActivity settingSDCardActivity6 = SettingSDCardActivity.this;
                    sb.append(settingSDCardActivity6.getStrMin(settingSDCardActivity6.m_start_time_min));
                    textView.setText(sb.toString());
                    TextView textView2 = SettingSDCardActivity.this.tv_endtime;
                    StringBuilder sb2 = new StringBuilder();
                    SettingSDCardActivity settingSDCardActivity7 = SettingSDCardActivity.this;
                    sb2.append(settingSDCardActivity7.getStrHour(settingSDCardActivity7.m_end_time_hour));
                    sb2.append(" : ");
                    SettingSDCardActivity settingSDCardActivity8 = SettingSDCardActivity.this;
                    sb2.append(settingSDCardActivity8.getStrMin(settingSDCardActivity8.m_end_time_min));
                    textView2.setText(sb2.toString());
                    if (SettingSDCardActivity.this.videoRecordModel.getRecordAudio() == 1) {
                        SettingSDCardActivity.this.sv_audio.setOpened(true);
                    } else {
                        SettingSDCardActivity.this.sv_audio.setOpened(false);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getRecordcov() == 1) {
                        SettingSDCardActivity.this.sv_loop.setOpened(true);
                    } else {
                        SettingSDCardActivity.this.sv_loop.setOpened(false);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getBistream() == 1) {
                        SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit2);
                    } else {
                        SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit1);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() == -110) {
                        SettingSDCardActivity.this.btn_videomode0.setVisibility(8);
                        if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() != 1) {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                        } else if (SettingSDCardActivity.this.videoRecordModel.getStart_time() == 0 && SettingSDCardActivity.this.videoRecordModel.getEnd_time() == 86400) {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                        } else {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                        }
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 0) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.yuntai_ysms);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 1) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 2) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 3) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    }
                    SettingSDCardActivity.this.editRecordLength.setText((SettingSDCardActivity.this.videoRecordModel.getRecord_time() / 60) + "");
                }
            } else if (i2 == 109) {
                NativeCallerTools.SDKAPITransferMessage(SettingSDCardActivity.this.strDID, CommonUtil.getSDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
            } else if (i2 == 119) {
                SettingSDCardActivity.this.tvSdcardStatus.setText(R.string.abnormal);
                if (SettingSDCardActivity.this.isSuccessFlag && SettingSDCardActivity.this.sdModel != null) {
                    SettingSDCardActivity.this.tvSdTotal.setText(SettingSDCardActivity.this.sdModel.getTotal() + "M");
                    SettingSDCardActivity.this.tvSdRemain.setText(SettingSDCardActivity.this.sdModel.getFree() + "M");
                    if (SettingSDCardActivity.this.sdModel.getSdstatu() == 1) {
                        SettingSDCardActivity.this.tvSdcardStatus.setText(R.string.normal);
                        SettingSDCardActivity.this.isSuccessFlag = false;
                        SettingSDCardActivity.this.handler.sendEmptyMessageDelayed(129, 50L);
                    } else if (SettingSDCardActivity.this.sdModel.getSdstatu() == 0) {
                        SettingSDCardActivity.this.set_sd_format.setVisibility(8);
                        SettingSDCardActivity.this.showToast(R.string.no_sd_card);
                    } else if (SettingSDCardActivity.this.sdModel.getSdstatu() != 2 && SettingSDCardActivity.this.sdModel.getSdstatu() != 3) {
                        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(SettingSDCardActivity.this);
                        niftyDialogBuilder.withTitle(SettingSDCardActivity.this.getString(R.string.my_setup_tips)).withMessage(SettingSDCardActivity.this.getString(R.string.add_tips_item52)).withOneBtn().withButton2Text(SettingSDCardActivity.this.getString(R.string.tip_updata_left)).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                niftyDialogBuilder.dismiss();
                            }
                        }).show();
                    }
                }
            } else if (i2 != 129) {
                if (i2 == 139) {
                    if (SettingSDCardActivity.this.progressDialog1 != null && SettingSDCardActivity.this.progressDialog1.isShowing()) {
                        SettingSDCardActivity.this.progressDialog1.cancel();
                    }
                    SettingSDCardActivity.this.handler.removeCallbacksAndMessages(null);
                    SettingSDCardActivity.this.startActivity(new Intent(SettingSDCardActivity.this, (Class<?>) NUIMainActivity.class));
                    SettingSDCardActivity.this.finish();
                }
            } else if (SettingSDCardActivity.this.isChangeFlag) {
                if (SettingSDCardActivity.this.progressDialog1 != null && SettingSDCardActivity.this.progressDialog1.isShowing()) {
                    SettingSDCardActivity.this.progressDialog1.cancel();
                }
                NativeCallerTools.SDKAPITransferMessage(SettingSDCardActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reboot", 1));
                SettingSDCardActivity.this.handler.sendEmptyMessageDelayed(139, 1000L);
            }
            return false;
        }
    });
    public Runnable runnable = new Runnable() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (SettingSDCardActivity.this.successFlag) {
                return;
            }
            SettingSDCardActivity.this.successFlag = false;
            SettingSDCardActivity.this.progressDialog.dismiss();
        }
    };
    public int ifShow = 0;
    public boolean isGetVideoRecordModel = false;

    private void findView() {
        this.tvSdcardStatus = (TextView) findViewById(R.id.tvSdcardStatus);
        this.tv_bit = (TextView) findViewById(R.id.tv_bit);
        this.tv_mode = (TextView) findViewById(R.id.tv_mode);
        this.tv_starttime = (TextView) findViewById(R.id.tv_starttime);
        this.tv_endtime = (TextView) findViewById(R.id.tv_endtime);
        this.tvSdTotal = (TextView) findViewById(R.id.tv_sd_total);
        this.tvSdRemain = (TextView) findViewById(R.id.tv_sd_remain);
        this.cbxConverage = (CheckBox) findViewById(R.id.cbx_coverage);
        this.editRecordLength = (EditText) findViewById(R.id.edit_record_length);
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnOk = (Button) findViewById(R.id.ok);
        Button button = (Button) findViewById(R.id.set_sd_format);
        this.set_sd_format = button;
        button.setOnClickListener(this);
        SwitchView switchView = (SwitchView) findViewById(R.id.sv_audio);
        this.sv_audio = switchView;
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.13
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView2) {
                SettingSDCardActivity.this.sv_audio.setOpened(false);
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setRecordAudio(0);
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView2) {
                SettingSDCardActivity.this.sv_audio.setOpened(true);
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setRecordAudio(1);
                }
            }
        });
        SwitchView switchView2 = (SwitchView) findViewById(R.id.sv_loop);
        this.sv_loop = switchView2;
        switchView2.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.14
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView3) {
                SettingSDCardActivity.this.sv_loop.setOpened(false);
                SettingSDCardActivity.this.videoRecordModel.setRecordcov(0);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView3) {
                SettingSDCardActivity.this.sv_loop.setOpened(true);
                SettingSDCardActivity.this.videoRecordModel.setRecordcov(1);
            }
        });
        findViewById(R.id.ll_bit).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10L);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                settingSDCardActivity.popupWindow_bit.showAtLocation(settingSDCardActivity.findViewById(R.id.ll_bit), 17, 0, 0);
            }
        });
        findViewById(R.id.ll_mode).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10L);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                settingSDCardActivity.popupWindow_videomode.showAtLocation(settingSDCardActivity.findViewById(R.id.ll_mode), 17, 0, 0);
            }
        });
        findViewById(R.id.ll_start).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10L);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                settingSDCardActivity.m_start_time_hour = settingSDCardActivity.videoRecordModel.getStart_time() / 3600;
                SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                settingSDCardActivity2.m_start_time_min = (settingSDCardActivity2.videoRecordModel.getStart_time() % 3600) / 60;
                new TimePickerDialog(SettingSDCardActivity.this, 2, new TimePickerDialog.OnTimeSetListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.17.1
                    @Override // android.app.TimePickerDialog.OnTimeSetListener
                    public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                        CommonUtil.Log(1, "start hourOfDay:" + i2 + "  minute:" + i3);
                        SettingSDCardActivity.this.m_start_time_hour = i2;
                        SettingSDCardActivity.this.m_start_time_min = i3;
                        int i4 = (SettingSDCardActivity.this.m_start_time_hour * 3600) + (SettingSDCardActivity.this.m_start_time_min * 60);
                        if (SettingSDCardActivity.this.videoRecordModel != null) {
                            SettingSDCardActivity.this.videoRecordModel.setStart_time(i4);
                        }
                        TextView textView = SettingSDCardActivity.this.tv_starttime;
                        StringBuilder sb = new StringBuilder();
                        SettingSDCardActivity settingSDCardActivity3 = SettingSDCardActivity.this;
                        sb.append(settingSDCardActivity3.getStrHour(settingSDCardActivity3.m_start_time_hour));
                        sb.append(" : ");
                        SettingSDCardActivity settingSDCardActivity4 = SettingSDCardActivity.this;
                        sb.append(settingSDCardActivity4.getStrMin(settingSDCardActivity4.m_start_time_min));
                        textView.setText(sb.toString());
                    }
                }, SettingSDCardActivity.this.m_start_time_hour, SettingSDCardActivity.this.m_start_time_min, true).show();
            }
        });
        findViewById(R.id.ll_end).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10L);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                settingSDCardActivity.m_end_time_hour = settingSDCardActivity.videoRecordModel.getEnd_time() / 3600;
                SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                settingSDCardActivity2.m_end_time_min = (settingSDCardActivity2.videoRecordModel.getEnd_time() % 3600) / 60;
                new TimePickerDialog(SettingSDCardActivity.this, 2, new TimePickerDialog.OnTimeSetListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.18.1
                    @Override // android.app.TimePickerDialog.OnTimeSetListener
                    public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                        CommonUtil.Log(1, "end hourOfDay:" + i2 + "  minute:" + i3);
                        SettingSDCardActivity.this.m_end_time_hour = i2;
                        SettingSDCardActivity.this.m_end_time_min = i3;
                        int i4 = (SettingSDCardActivity.this.m_end_time_hour * 3600) + (SettingSDCardActivity.this.m_end_time_min * 60);
                        if (SettingSDCardActivity.this.videoRecordModel != null) {
                            SettingSDCardActivity.this.videoRecordModel.setEnd_time(i4);
                        }
                        TextView textView = SettingSDCardActivity.this.tv_endtime;
                        StringBuilder sb = new StringBuilder();
                        SettingSDCardActivity settingSDCardActivity3 = SettingSDCardActivity.this;
                        sb.append(settingSDCardActivity3.getStrHour(settingSDCardActivity3.m_end_time_hour));
                        sb.append(" : ");
                        SettingSDCardActivity settingSDCardActivity4 = SettingSDCardActivity.this;
                        sb.append(settingSDCardActivity4.getStrMin(settingSDCardActivity4.m_end_time_min));
                        textView.setText(sb.toString());
                    }
                }, SettingSDCardActivity.this.m_end_time_hour, SettingSDCardActivity.this.m_end_time_min, true).show();
            }
        });
    }

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStrHour(int i2) {
        if (i2 < 10) {
            return "0" + i2;
        }
        return "" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStrMin(int i2) {
        if (i2 < 10) {
            return "0" + i2;
        }
        return "" + i2;
    }

    private void setLister() {
        this.btnBack.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.cbxConverage.setOnCheckedChangeListener(this);
    }

    private void setSDCardSchedule() {
        this.sdcardBean.getRecord_timer();
        VideoRecordModel videoRecordModel = this.videoRecordModel;
        if (videoRecordModel != null) {
            if (videoRecordModel.getEnd_time() <= this.videoRecordModel.getStart_time()) {
                showToast(R.string.set_sd_show4);
                return;
            }
            if (this.videoRecordModel.getRecord_time() < 300 || this.videoRecordModel.getRecord_time() > 1800 || this.editRecordLength.getText().length() == 0) {
                this.videoRecordModel.setRecord_time(InactivityTimer.INACTIVITY_DELAY_SECONDS);
            } else {
                int parseInt = Integer.parseInt(this.editRecordLength.getText().toString());
                if (parseInt < 5 || parseInt > 30) {
                    showToast(getString(R.string.sdcard_range));
                    return;
                }
                this.videoRecordModel.setRecord_time(parseInt * 60);
            }
            try {
                NativeCallerTools.SDKAPITransferMessage(this.strDID, DeviceOffTimeModel.toJson(this.mDeviceOffTimeModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                NativeCallerTools.SDKAPITransferMessage(this.strDID, VideoRecordModel.toJson(this.videoRecordModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                NativeCallerTools.SDKAPITransferMessage(this.strDID, AlarmModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        SharedPreferences.Editor edit = this.preuser.edit();
        if (this.tv_mode.getText().toString().contains(getResources().getString(R.string.yuntai_ysms))) {
            edit.putInt(this.strDID, 1);
        } else {
            edit.putInt(this.strDID, 0);
        }
        edit.commit();
        this.handler.removeCallbacksAndMessages(null);
        MyLogUtils.d("tag", " did=" + this.strDID + "  mode=" + this.preuser.getInt(this.strDID, 1));
        finish();
    }

    private ArrayAdapter<String> showSpnner(List<String> list) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return arrayAdapter;
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            int i2 = new JSONObject(str2).getInt("cmd");
            if (i2 == 109) {
                this.sdModel = SDCardModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(119);
            }
            if (i2 == 199) {
                this.isGetVideoRecordModel = true;
                this.videoRecordModel = VideoRecordModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(2);
            }
            if (i2 == 121) {
                this.mDeviceOffTimeModel = DeviceOffTimeModel.jsonToModel(str2);
            }
            if (i2 == 107) {
                this.alarmModel = AlarmModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(107);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void initExitPopupWindow_bit() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_bit, (ViewGroup) null);
        this.popv_bit = inflate;
        inflate.findViewById(R.id.btn_bit1).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit1);
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setBistream(0);
                }
            }
        });
        this.popv_bit.findViewById(R.id.btn_bit2).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit2);
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setBistream(1);
                }
            }
        });
        PopupWindow popupWindow = new PopupWindow(this.popv_bit, -2, -2);
        this.popupWindow_bit = popupWindow;
        popupWindow.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_bit.setFocusable(true);
        this.popupWindow_bit.setOutsideTouchable(true);
        this.popupWindow_bit.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_bit.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
            }
        });
        this.popupWindow_bit.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_videomode() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_videomode, (ViewGroup) null);
        this.popv_videomode = inflate;
        Button button = (Button) inflate.findViewById(R.id.btn_videomode0);
        this.btn_videomode0 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SettingSDCardActivity.this.alarmModel != null) {
                    SettingSDCardActivity.this.alarmModel.setPirvideo(0);
                }
                SettingSDCardActivity.this.tv_mode.setText(R.string.yuntai_ysms);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setTimerecord(0);
                    SettingSDCardActivity.this.mDeviceOffTimeModel.setTimedOffDays(1);
                }
            }
        });
        this.popv_videomode.findViewById(R.id.btn_videomode1).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SettingSDCardActivity.this.alarmModel != null) {
                    SettingSDCardActivity.this.alarmModel.setPirvideo(0);
                }
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.mDeviceOffTimeModel.setTimedOffDays(0);
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                        SettingSDCardActivity.this.videoRecordModel.setStart_time(0);
                        SettingSDCardActivity.this.videoRecordModel.setEnd_time(86400);
                    } else {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                        SettingSDCardActivity.this.videoRecordModel.setStart_time(0);
                        SettingSDCardActivity.this.videoRecordModel.setEnd_time(86400);
                    }
                }
            }
        });
        this.popv_videomode.findViewById(R.id.btn_videomode2).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.mDeviceOffTimeModel.setTimedOffDays(0);
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(3);
                    } else {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(0);
                    }
                }
                if (SettingSDCardActivity.this.alarmModel != null) {
                    SettingSDCardActivity.this.alarmModel.setPirvideo(1);
                }
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
            }
        });
        this.popv_videomode.findViewById(R.id.btn_videomode3).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SettingSDCardActivity.this.alarmModel != null) {
                    SettingSDCardActivity.this.alarmModel.setPirvideo(0);
                }
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.mDeviceOffTimeModel.setTimedOffDays(0);
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(2);
                        return;
                    }
                    SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                    if (SettingSDCardActivity.this.videoRecordModel.getEnd_time() == 86400) {
                        SettingSDCardActivity.this.videoRecordModel.setEnd_time(86340);
                    }
                }
            }
        });
        PopupWindow popupWindow = new PopupWindow(this.popv_videomode, -2, -2);
        this.popupWindow_videomode = popupWindow;
        popupWindow.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_videomode.setFocusable(true);
        this.popupWindow_videomode.setOutsideTouchable(true);
        this.popupWindow_videomode.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_videomode.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.10
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
            }
        });
        this.popupWindow_videomode.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                return false;
            }
        });
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() != R.id.cbx_coverage) {
            return;
        }
        if (z) {
            this.sdcardBean.setRecord_conver_enable(1);
        } else {
            this.sdcardBean.setRecord_conver_enable(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            this.handler.removeCallbacksAndMessages(null);
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.ok) {
            if (this.isGetVideoRecordModel) {
                setSDCardSchedule();
            }
        } else {
            if (id != R.id.set_sd_format) {
                return;
            }
            final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
            niftyDialogBuilder.withTitle(getResources().getString(R.string.set_sd_format)).withMessage(getString(R.string.sd_setting_show)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    niftyDialogBuilder.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.SettingSDCardActivity.19.1
                        @Override // android.os.AsyncTask
                        public Void doInBackground(Void... voidArr) {
                            return null;
                        }

                        @Override // android.os.AsyncTask
                        public void onPreExecute() {
                            NativeCallerTools.SDKAPITransferMessage(SettingSDCardActivity.this.strDID, CommonUtil.formatSDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                            SettingSDCardActivity.this.progressDialog1 = new ProgressDialog(SettingSDCardActivity.this);
                            SettingSDCardActivity.this.progressDialog1.setProgressStyle(0);
                            SettingSDCardActivity.this.progressDialog1.setMessage(SettingSDCardActivity.this.getString(R.string.set_sd_format_show1));
                            SettingSDCardActivity.this.progressDialog1.setCancelable(false);
                            SettingSDCardActivity.this.progressDialog1.show();
                            SettingSDCardActivity.this.handler.sendEmptyMessageDelayed(139, 20000L);
                        }

                        @Override // android.os.AsyncTask
                        public void onPostExecute(Void r4) {
                            SettingSDCardActivity.this.isSuccessFlag = true;
                            SettingSDCardActivity.this.isChangeFlag = true;
                            SettingSDCardActivity.this.handler.sendEmptyMessageDelayed(109, 2000L);
                        }
                    }.execute(new Void[0]);
                    niftyDialogBuilder.dismiss();
                }
            }).show();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        setContentView(R.layout.settingsdcard);
        BarUtils.setStatusBarColor(this, Color.parseColor("#FFFFFFFF"));
        ProgressDialog progressDialog = new ProgressDialog(this, 3);
        this.progressDialog = progressDialog;
        progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.sdcard_getparams));
        this.progressDialog.show();
        this.sdcardBean = new SdcardBean();
        this.handler.postDelayed(this.runnable, NetworkUtils.SCAN_PERIOD_MILLIS);
        initExitPopupWindow_bit();
        initExitPopupWindow_videomode();
        findView();
        setLister();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getAlarmParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getSDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getRDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
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
