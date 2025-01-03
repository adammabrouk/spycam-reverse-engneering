package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.DateModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.SwitchView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingDateActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.SHIXCOMMONInterface {
    public String cameraName;
    public DateModel dateModel;
    public SwitchView date_cbx_check;
    public LinearLayout date_edit_ntp_server_layout;
    public ProgressDialog progressDialog;
    public String strDID;
    public boolean successFlag;
    public long time;
    public String timeZone;
    public SwitchView xls_cbx_check;
    public SwitchView yees_cbx_check;
    public String TAG = "SettingDateActivity";
    public final int FAIL = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 3;
    public final int TIMEOUT = AddCameraActivity.SEARCH_TIME;
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.SettingDateActivity.1
        private void setTimeZone() {
            CommonUtil.Log(1, "SHIXDEV   utc:" + ((int) SettingDateActivity.this.dateModel.getTimeZone()));
            switch (SettingDateActivity.this.dateModel.getTimeZone_Sec()) {
                case -39600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_island);
                    break;
                case -36000:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_hawaii);
                    break;
                case -32400:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_alaska);
                    break;
                case -28800:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_pacific_time);
                    break;
                case -25200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_mountain_time);
                    break;
                case -18000:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_eastern_time);
                    break;
                case -14400:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_ocean_time);
                    break;
                case -12600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_newfoundland);
                    break;
                case -10800:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_brasilia);
                    break;
                case -7200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_center_ocean);
                    break;
                case -3600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_cape_verde_island);
                    break;
                case -6:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_part_time);
                    break;
                case 0:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_greenwich);
                    break;
                case 3600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_brussels);
                    break;
                case 7200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_athens);
                    break;
                case 10800:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_nairobi);
                    break;
                case 12600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_teheran);
                    break;
                case 14400:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_baku);
                    break;
                case 16200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_kebuer);
                    break;
                case 18000:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_islamabad);
                    break;
                case 19800:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_calcutta);
                    break;
                case 21600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_alamotu);
                    break;
                case 25200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_bangkok);
                    break;
                case 28800:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_beijing);
                    break;
                case 32400:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_seoul);
                    break;
                case 34200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_darwin);
                    break;
                case 36000:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_guam);
                    break;
                case 39600:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_suolumen);
                    break;
                case 43200:
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_auckland);
                    break;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                SettingDateActivity.this.showToast(R.string.date_setting_failed);
                return;
            }
            if (i2 == 1) {
                SettingDateActivity.this.showToast(R.string.date_setting_success);
                SettingDateActivity.this.finish();
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                SettingDateActivity.access$008(SettingDateActivity.this);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long j = SettingDateActivity.this.time * 1000;
                LogUtils.e("biniy", "时区-timel= " + j);
                SettingDateActivity.this.tvDeviceTime.setText(simpleDateFormat.format(new Date(j)));
                SettingDateActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                return;
            }
            SettingDateActivity.this.successFlag = true;
            if (SettingDateActivity.this.progressDialog.isShowing()) {
                SettingDateActivity.this.progressDialog.cancel();
            }
            if (SettingDateActivity.this.dateModel == null) {
                return;
            }
            SettingDateActivity.this.time = TimeUtil.dateTransformBetweenTimeZone(new Date((SettingDateActivity.this.dateModel.getDstSwitch() == 1 ? SettingDateActivity.this.dateModel.getTime() + 3600 : SettingDateActivity.this.dateModel.getTime()) * 1000), TimeZone.getTimeZone("GMT" + TimeUtil.getTimeZone()), TimeZone.getTimeZone(TimeUtil.getTimeZone(SettingDateActivity.this.dateModel.getTimeZone()))) / 1000;
            LogUtils.e("biniy", "时区-time1= " + SettingDateActivity.this.time);
            SettingDateActivity.this.tvDeviceTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(SettingDateActivity.this.time * 1000)));
            SettingDateActivity.this.mHandler.sendEmptyMessage(4);
            setTimeZone();
            SettingDateActivity.this.editNtpServer.setText(SettingDateActivity.this.dateModel.getNtpServer() + "");
            if (SettingDateActivity.this.dateModel.getNtpSwitch() == 1) {
                SettingDateActivity.this.date_cbx_check.setOpened(true);
            } else {
                SettingDateActivity.this.date_cbx_check.setOpened(false);
            }
            if (SettingDateActivity.this.dateModel.getDstSwitch() == 1) {
                SettingDateActivity.this.xls_cbx_check.setOpened(true);
            } else {
                SettingDateActivity.this.xls_cbx_check.setOpened(false);
            }
            if (SettingDateActivity.this.dateModel.getTimeHour() == 1) {
                SettingDateActivity.this.yees_cbx_check.setOpened(true);
            } else {
                SettingDateActivity.this.yees_cbx_check.setOpened(false);
            }
        }
    };
    public TextView tvDeviceTime = null;
    public TextView editTimeZone = null;
    public TextView editNtpServer = null;
    public View ntpView = null;
    public PopupWindow timeZonePopWindow = null;
    public PopupWindow ntpServerPopWindow = null;
    public ScrollView scrollView = null;
    public Button btnOk = null;
    public Button btnCancel = null;
    public Button btnCheckOut = null;
    public TextView tvCameraName = null;
    public Runnable runnable = new Runnable() { // from class: com.shix.shixipc.activity.SettingDateActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (SettingDateActivity.this.successFlag) {
                return;
            }
            SettingDateActivity.this.progressDialog.dismiss();
        }
    };

    public static /* synthetic */ long access$008(SettingDateActivity settingDateActivity) {
        long j = settingDateActivity.time;
        settingDateActivity.time = 1 + j;
        return j;
    }

    private void checkDeviceAsPhoneTime() {
        if (this.date_cbx_check.isOpened()) {
            this.dateModel.setNtpSwitch(1);
        } else {
            this.dateModel.setNtpSwitch(0);
        }
        if (this.xls_cbx_check.isOpened()) {
            this.dateModel.setDstSwitch(1);
        } else {
            this.dateModel.setDstSwitch(0);
        }
        if (this.yees_cbx_check.isOpened()) {
            this.dateModel.setTimeHour(1);
        } else {
            this.dateModel.setTimeHour(0);
        }
        String timeZone = TimeUtil.getTimeZone(this.dateModel.getTimeZone());
        this.dateModel.setTimeZone_Sec(TimeZone.getTimeZone(timeZone).getRawOffset() / 1000);
        String str = "GMT" + TimeUtil.getTimeZone();
        LogUtils.e("biniy", "时区-sTimeZone= " + str);
        LogUtils.e("biniy", "时区-timezone= " + timeZone);
        long dateTransformBetweenTimeZone = TimeUtil.dateTransformBetweenTimeZone(new Date(System.currentTimeMillis()), TimeZone.getTimeZone(str), TimeZone.getTimeZone(timeZone));
        LogUtils.e("biniy", "时区-now= " + dateTransformBetweenTimeZone + "");
        this.time = dateTransformBetweenTimeZone / 1000;
        LogUtils.e("biniy", "时区-time2= " + this.time);
        this.dateModel.setTime((int) TimeUtil.getUTCTimeSec());
    }

    private void findView() {
        this.btnOk = (Button) findViewById(R.id.date_ok);
        this.btnCancel = (Button) findViewById(R.id.date_cancel);
        this.btnCheckOut = (Button) findViewById(R.id.date_btn_checkout);
        this.tvDeviceTime = (TextView) findViewById(R.id.date_tv_device_time);
        this.editTimeZone = (TextView) findViewById(R.id.date_edit_timezone);
        this.editNtpServer = (TextView) findViewById(R.id.date_edit_ntp_server);
        this.date_edit_ntp_server_layout = (LinearLayout) findViewById(R.id.date_edit_ntp_server_layout);
        this.ntpView = findViewById(R.id.date_ntp_view);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView1);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.date_cbx_check = (SwitchView) findViewById(R.id.date_cbx_check);
        this.xls_cbx_check = (SwitchView) findViewById(R.id.xls_cbx_check);
        this.yees_cbx_check = (SwitchView) findViewById(R.id.yees_cbx_check);
        this.xls_cbx_check.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingDateActivity.4
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                SettingDateActivity.this.xls_cbx_check.setOpened(false);
                SettingDateActivity.this.setDate2();
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                SettingDateActivity.this.xls_cbx_check.setOpened(true);
                SettingDateActivity.this.setDate2();
            }
        });
        this.date_cbx_check.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingDateActivity.5
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                SettingDateActivity.this.date_cbx_check.setOpened(false);
                SettingDateActivity.this.setDate2();
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                SettingDateActivity.this.date_cbx_check.setOpened(true);
                SettingDateActivity.this.setDate2();
            }
        });
        this.yees_cbx_check.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.SettingDateActivity.6
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                SettingDateActivity.this.yees_cbx_check.setOpened(false);
                SettingDateActivity.this.setDate2();
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                SettingDateActivity.this.yees_cbx_check.setOpened(true);
                SettingDateActivity.this.setDate2();
            }
        });
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    private void setDate() {
        if (this.dateModel == null) {
            return;
        }
        checkDeviceAsPhoneTime();
        try {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, DateModel.toJson(this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate2() {
        if (this.dateModel == null) {
            return;
        }
        checkDeviceAsPhoneTime();
        try {
            String json = DateModel.toJson(this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
            LogUtils.e("biniy", "json= " + json);
            NativeCallerTools.SDKAPITransferMessage(this.strDID, json);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    private void setListener() {
        this.date_edit_ntp_server_layout.setOnClickListener(this);
        this.scrollView.setOnTouchListener(this);
        this.editTimeZone.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.btnCheckOut.setOnClickListener(this);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.shix.shixipc.activity.SettingDateActivity.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }
        });
    }

    private void showNtpServerPopWindow() {
        PopupWindow popupWindow = this.ntpServerPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_ntpserver_popwindow, (ViewGroup) null);
            Button button = (Button) linearLayout.findViewById(R.id.date_ntpserver_kriss);
            Button button2 = (Button) linearLayout.findViewById(R.id.date_ntpserver_nist);
            Button button3 = (Button) linearLayout.findViewById(R.id.date_ntpserver_nuri);
            Button button4 = (Button) linearLayout.findViewById(R.id.date_ntpserver_windows);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);
            PopupWindow popupWindow2 = new PopupWindow(linearLayout, 450, -2);
            this.ntpServerPopWindow = popupWindow2;
            popupWindow2.showAtLocation(this.editNtpServer, 17, 0, 0);
        }
    }

    private void showTimeZonePopWindow() {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_timezone_popwindow, (ViewGroup) null);
            Button button = (Button) linearLayout.findViewById(R.id.date_zone_middle_island);
            Button button2 = (Button) linearLayout.findViewById(R.id.date_zone_hawaii);
            Button button3 = (Button) linearLayout.findViewById(R.id.date_zone_alaska);
            Button button4 = (Button) linearLayout.findViewById(R.id.date_zone_pacific_time);
            Button button5 = (Button) linearLayout.findViewById(R.id.date_zone_mountain_time);
            Button button6 = (Button) linearLayout.findViewById(R.id.date_zone_middle_part_time);
            Button button7 = (Button) linearLayout.findViewById(R.id.date_zone_eastern_time);
            Button button8 = (Button) linearLayout.findViewById(R.id.date_zone_ocean_time);
            Button button9 = (Button) linearLayout.findViewById(R.id.date_zone_newfoundland);
            Button button10 = (Button) linearLayout.findViewById(R.id.date_zone_brasilia);
            Button button11 = (Button) linearLayout.findViewById(R.id.date_zone_center_ocean);
            Button button12 = (Button) linearLayout.findViewById(R.id.date_zone_cap_verde_island);
            Button button13 = (Button) linearLayout.findViewById(R.id.date_zone_greenwich);
            Button button14 = (Button) linearLayout.findViewById(R.id.date_zone_brussels);
            Button button15 = (Button) linearLayout.findViewById(R.id.date_zone_athens);
            Button button16 = (Button) linearLayout.findViewById(R.id.date_zone_nairobi);
            Button button17 = (Button) linearLayout.findViewById(R.id.date_zone_teheran);
            Button button18 = (Button) linearLayout.findViewById(R.id.date_zone_baku);
            Button button19 = (Button) linearLayout.findViewById(R.id.date_zone_kebuer);
            Button button20 = (Button) linearLayout.findViewById(R.id.date_zone_islamabad);
            Button button21 = (Button) linearLayout.findViewById(R.id.date_zone_calcutta);
            Button button22 = (Button) linearLayout.findViewById(R.id.date_zone_alamotu);
            Button button23 = (Button) linearLayout.findViewById(R.id.date_zone_bangkok);
            Button button24 = (Button) linearLayout.findViewById(R.id.date_zone_beijing);
            Button button25 = (Button) linearLayout.findViewById(R.id.date_zone_seoul);
            Button button26 = (Button) linearLayout.findViewById(R.id.date_zone_darwin);
            Button button27 = (Button) linearLayout.findViewById(R.id.date_zone_guam);
            Button button28 = (Button) linearLayout.findViewById(R.id.date_zone_soulumen);
            Button button29 = (Button) linearLayout.findViewById(R.id.date_zone_auckland);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);
            button5.setOnClickListener(this);
            button6.setOnClickListener(this);
            button7.setOnClickListener(this);
            button8.setOnClickListener(this);
            button9.setOnClickListener(this);
            button10.setOnClickListener(this);
            button11.setOnClickListener(this);
            button12.setOnClickListener(this);
            button13.setOnClickListener(this);
            button14.setOnClickListener(this);
            button15.setOnClickListener(this);
            button16.setOnClickListener(this);
            button17.setOnClickListener(this);
            button18.setOnClickListener(this);
            button19.setOnClickListener(this);
            button20.setOnClickListener(this);
            button21.setOnClickListener(this);
            button22.setOnClickListener(this);
            button23.setOnClickListener(this);
            button24.setOnClickListener(this);
            button25.setOnClickListener(this);
            button26.setOnClickListener(this);
            button27.setOnClickListener(this);
            button28.setOnClickListener(this);
            button29.setOnClickListener(this);
            PopupWindow popupWindow2 = new PopupWindow(linearLayout, -1, 700);
            this.timeZonePopWindow = popupWindow2;
            popupWindow2.showAsDropDown(this.editTimeZone, -popupWindow2.getWidth(), 0);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            LogUtils.e("biniy", "json-> " + str2);
            if (new JSONObject(str2).getInt("cmd") == 125) {
                this.dateModel = DateModel.jsonToModel(str2);
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacksAndMessages(null);
                    this.mHandler.sendEmptyMessage(3);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10L);
        }
        switch (view.getId()) {
            case R.id.date_btn_checkout /* 2131230922 */:
                this.date_cbx_check.setOpened(false);
                checkDeviceAsPhoneTime();
                try {
                    NativeCallerTools.SDKAPITransferMessage(this.strDID, DateModel.toJson(this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0));
                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1));
                finish();
                break;
            case R.id.date_cancel /* 2131230923 */:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                break;
            case R.id.date_edit_ntp_server_layout /* 2131230926 */:
                PopupWindow popupWindow = this.timeZonePopWindow;
                if (popupWindow != null && popupWindow.isShowing()) {
                    this.timeZonePopWindow.dismiss();
                    this.timeZonePopWindow = null;
                }
                showNtpServerPopWindow();
                break;
            case R.id.date_edit_timezone /* 2131230927 */:
                PopupWindow popupWindow2 = this.ntpServerPopWindow;
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    this.ntpServerPopWindow.dismiss();
                    this.ntpServerPopWindow = null;
                }
                showTimeZonePopWindow();
                break;
            case R.id.date_ntpserver_kriss /* 2131230929 */:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_kriss_re_kr);
                break;
            case R.id.date_ntpserver_nist /* 2131230930 */:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_nist_gov);
                break;
            case R.id.date_ntpserver_nuri /* 2131230931 */:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_nuri_net);
                break;
            case R.id.date_ntpserver_windows /* 2131230932 */:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_windows_com);
                break;
            case R.id.date_ok /* 2131230933 */:
                setDate();
                break;
            case R.id.date_zone_alamotu /* 2131230936 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(6.0f);
                this.editTimeZone.setText(R.string.date_alamotu);
                break;
            case R.id.date_zone_alaska /* 2131230937 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-9.0f);
                this.editTimeZone.setText(R.string.date_alaska);
                break;
            case R.id.date_zone_athens /* 2131230938 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(2.0f);
                this.editTimeZone.setText(R.string.date_athens);
                break;
            case R.id.date_zone_auckland /* 2131230939 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(12.0f);
                this.editTimeZone.setText(R.string.date_auckland);
                break;
            case R.id.date_zone_baku /* 2131230940 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(4.0f);
                this.editTimeZone.setText(R.string.date_baku);
                break;
            case R.id.date_zone_bangkok /* 2131230941 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(7.0f);
                this.editTimeZone.setText(R.string.date_bangkok);
                break;
            case R.id.date_zone_beijing /* 2131230942 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(8.0f);
                this.editTimeZone.setText(R.string.date_beijing);
                break;
            case R.id.date_zone_brasilia /* 2131230943 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-3.0f);
                this.editTimeZone.setText(R.string.date_brasilia);
                break;
            case R.id.date_zone_brussels /* 2131230944 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(1.0f);
                this.editTimeZone.setText(R.string.date_brussels);
                break;
            case R.id.date_zone_calcutta /* 2131230945 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(5.5f);
                this.editTimeZone.setText(R.string.date_calcutta);
                break;
            case R.id.date_zone_cap_verde_island /* 2131230946 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-1.0f);
                this.editTimeZone.setText(R.string.date_cape_verde_island);
                break;
            case R.id.date_zone_center_ocean /* 2131230947 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-2.0f);
                this.editTimeZone.setText(R.string.date_center_ocean);
                break;
            case R.id.date_zone_darwin /* 2131230948 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(9.5f);
                this.editTimeZone.setText(R.string.date_darwin);
                break;
            case R.id.date_zone_eastern_time /* 2131230949 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-5.0f);
                this.editTimeZone.setText(R.string.date_eastern_time);
                break;
            case R.id.date_zone_greenwich /* 2131230950 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(0.0f);
                this.editTimeZone.setText(R.string.date_greenwich);
                break;
            case R.id.date_zone_guam /* 2131230951 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(10.0f);
                this.editTimeZone.setText(R.string.date_guam);
                break;
            case R.id.date_zone_hawaii /* 2131230952 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-10.0f);
                this.editTimeZone.setText(R.string.date_hawaii);
                break;
            case R.id.date_zone_islamabad /* 2131230953 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(5.0f);
                this.editTimeZone.setText(R.string.date_islamabad);
                break;
            case R.id.date_zone_kebuer /* 2131230954 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(4.5f);
                this.editTimeZone.setText(R.string.date_kebuer);
                break;
            case R.id.date_zone_middle_island /* 2131230955 */:
                this.timeZonePopWindow.dismiss();
                this.editTimeZone.setText(R.string.date_middle_island);
                this.dateModel.setTimeZone(-11.0f);
                break;
            case R.id.date_zone_middle_part_time /* 2131230956 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-6.0f);
                this.editTimeZone.setText(R.string.date_middle_part_time);
                break;
            case R.id.date_zone_mountain_time /* 2131230957 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-7.0f);
                this.editTimeZone.setText(R.string.date_mountain_time);
                break;
            case R.id.date_zone_nairobi /* 2131230958 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(3.0f);
                this.editTimeZone.setText(R.string.date_nairobi);
                break;
            case R.id.date_zone_newfoundland /* 2131230959 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-3.5f);
                this.editTimeZone.setText(R.string.date_newfoundland);
                break;
            case R.id.date_zone_ocean_time /* 2131230960 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-4.0f);
                this.editTimeZone.setText(R.string.date_ocean_time);
                break;
            case R.id.date_zone_pacific_time /* 2131230961 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-8.0f);
                this.editTimeZone.setText(R.string.date_pacific_time);
                break;
            case R.id.date_zone_seoul /* 2131230962 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(9.0f);
                this.editTimeZone.setText(R.string.date_seoul);
                break;
            case R.id.date_zone_soulumen /* 2131230963 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(11.0f);
                this.editTimeZone.setText(R.string.date_suolumen);
                break;
            case R.id.date_zone_teheran /* 2131230964 */:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(3.5f);
                this.editTimeZone.setText(R.string.date_teheran);
                break;
        }
        this.dateModel.setNtpServer(this.editNtpServer.getText().toString());
        setDate2();
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        setContentView(R.layout.settingdate);
        ProgressDialog progressDialog = new ProgressDialog(this, 3);
        this.progressDialog = progressDialog;
        progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.date_get_params));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, NetworkUtils.SCAN_PERIOD_MILLIS);
        findView();
        int rawOffset = TimeZone.getDefault().getRawOffset() / 1000;
        setListener();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        super.onPause();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 == null || !popupWindow2.isShowing()) {
            return false;
        }
        this.ntpServerPopWindow.dismiss();
        this.ntpServerPopWindow = null;
        return false;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
        return super.onTouchEvent(motionEvent);
    }
}
