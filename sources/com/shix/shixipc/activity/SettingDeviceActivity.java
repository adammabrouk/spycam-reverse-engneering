package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.MyTextView;
import com.shix.shixipc.view.NiftyDialogBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingDeviceActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface, View.OnClickListener, NUIMainActivity.ConnectStatusInterface1, NUIMainActivity.IpcamClientInterface {
    public Button backBtn;
    public String cameraName;
    public String currVersion;
    public MyTextView deviceAppTime;
    public MyTextView deviceAppver;
    public MyTextView deviceMcuver;
    public MyTextView deviceName;
    public MyTextView deviceSysTime;
    public MyTextView deviceSysver;
    public MyTextView deviceUID;
    public EditText mEditText;
    public RelativeLayout mSetDeviceApptimeRl;
    public RelativeLayout mSetDeviceAppverRl;
    public RelativeLayout mSetDeviceMcuverRl;
    public RelativeLayout mSetDeviceSystimeRl;
    public TextView mTextView;
    public String newVersion;
    public ProgressDialog progressDialog;
    public int status;
    public String strDID;
    public String strPwd;
    public String strUser;
    public int upgrade_signal;
    public final int FAILED = 0;
    public final int SUCCESS = 1;
    public final int PARAMS = 2;
    public CameraParmsModel alarmModel = new CameraParmsModel();
    public boolean isDataCome = false;
    public long startClickTime = 0;
    public Handler handler = new Handler() { // from class: com.shix.shixipc.activity.SettingDeviceActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SettingDeviceActivity.this.mTextView.setText(SettingDeviceActivity.this.cameraName.replace("\\n", OSSUtils.NEW_LINE));
                    break;
                case 2:
                    SettingDeviceActivity.this.deviceName.setText(SettingDeviceActivity.this.cameraName);
                    SettingDeviceActivity.this.deviceUID.setText(SettingDeviceActivity.this.strDID);
                    SettingDeviceActivity.this.deviceSysver.setText(SettingDeviceActivity.this.alarmModel.getSysver());
                    SettingDeviceActivity.this.deviceMcuver.setText(SettingDeviceActivity.this.alarmModel.getMcuver());
                    SettingDeviceActivity.this.deviceAppver.setText(SettingDeviceActivity.this.alarmModel.getAppver());
                    SettingDeviceActivity.this.deviceAppTime.setText(SettingDeviceActivity.this.alarmModel.getAppMakeTime());
                    SettingDeviceActivity.this.deviceSysTime.setText(SettingDeviceActivity.this.alarmModel.getSysMakeTime());
                    break;
                case 3:
                    NativeCallerTools.SDKAPITransferMessage(SettingDeviceActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                    break;
                case 4:
                    Bundle data = message.getData();
                    int i2 = data.getInt("status");
                    if (data.getInt("upgrade_signal") != 0) {
                        if (i2 != 5) {
                            if (SettingDeviceActivity.this.status != 1) {
                                if (SettingDeviceActivity.this.status != 2) {
                                    if (SettingDeviceActivity.this.status != 3) {
                                        if (SettingDeviceActivity.this.status != 4) {
                                            if (SettingDeviceActivity.this.status != 6) {
                                                if (SettingDeviceActivity.this.status == 7) {
                                                    SettingDeviceActivity.this.hideProgress();
                                                    SettingDeviceActivity.this.showToast(R.string.check_updata_7);
                                                    break;
                                                }
                                            } else {
                                                SettingDeviceActivity.this.hideProgress();
                                                SettingDeviceActivity.this.showToast(R.string.check_updata_6);
                                                break;
                                            }
                                        } else {
                                            SettingDeviceActivity.this.hideProgress();
                                            SettingDeviceActivity.this.showToast(R.string.check_updata_4);
                                            break;
                                        }
                                    } else {
                                        NativeCallerTools.SDKAPITransferMessage(SettingDeviceActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                                        break;
                                    }
                                } else {
                                    SettingDeviceActivity.this.hideProgress();
                                    SettingDeviceActivity.this.showProgress(R.string.check_updata_2);
                                    SettingDeviceActivity.this.handler.sendEmptyMessageDelayed(5, NetworkUtils.SCAN_PERIOD_MILLIS);
                                    break;
                                }
                            } else {
                                NativeCallerTools.SDKAPITransferMessage(SettingDeviceActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                                break;
                            }
                        } else {
                            SettingDeviceActivity.this.hideProgress();
                            SettingDeviceActivity.this.showUpdate();
                            break;
                        }
                    } else {
                        SettingDeviceActivity.this.hideProgress();
                        SettingDeviceActivity.this.showToast(R.string.update_titl_update_no_show);
                        break;
                    }
                    break;
                case 5:
                    SettingDeviceActivity.this.hideProgress();
                    SettingDeviceActivity.this.isDataCome = true;
                    DeviceUtil.INSTANCE.StopPPPP(SettingDeviceActivity.this.strDID);
                    DeviceUtil.INSTANCE.StartPPPP(SettingDeviceActivity.this.strDID, SettingDeviceActivity.this.strUser, SettingDeviceActivity.this.strPwd);
                    break;
                case 6:
                    SettingDeviceActivity.this.showToast(R.string.updata_ok);
                    break;
            }
        }
    };

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (this.progressDialog.isShowing()) {
            this.progressDialog.cancel();
        }
    }

    private void initView() {
        this.deviceName = (MyTextView) findViewById(R.id.set_device_name);
        this.deviceUID = (MyTextView) findViewById(R.id.set_device_uid);
        this.deviceSysver = (MyTextView) findViewById(R.id.set_device_sysver);
        this.deviceMcuver = (MyTextView) findViewById(R.id.set_device_mcuver);
        this.deviceAppver = (MyTextView) findViewById(R.id.set_device_appver);
        this.deviceAppTime = (MyTextView) findViewById(R.id.set_device_apptime);
        this.deviceSysTime = (MyTextView) findViewById(R.id.set_device_systime);
        this.backBtn = (Button) findViewById(R.id.back);
        this.mEditText = (EditText) findViewById(R.id.test_dt);
        this.mTextView = (TextView) findViewById(R.id.test_tv);
        this.mSetDeviceMcuverRl = (RelativeLayout) findViewById(R.id.set_device_mcuver_rl);
        this.mSetDeviceAppverRl = (RelativeLayout) findViewById(R.id.set_device_appver_rl);
        this.mSetDeviceApptimeRl = (RelativeLayout) findViewById(R.id.set_device_apptime_rl);
        this.mSetDeviceSystimeRl = (RelativeLayout) findViewById(R.id.set_device_systime_rl);
        this.progressDialog = new ProgressDialog(this, 3);
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingDeviceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDeviceActivity.this.finish();
            }
        });
        findViewById(R.id.setting_updata).setOnClickListener(this);
        this.mSetDeviceAppverRl.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress(int i2) {
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(i2));
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
    public void BSCallBack_TYPEMODE(String str, String str2) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
    public void BSMsgNotifyData(String str, int i2, int i3) {
        if (i2 == 0 && this.isDataCome && i3 == 2 && str.equalsIgnoreCase(this.strDID)) {
            this.handler.sendEmptyMessage(6);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.IpcamClientInterface
    public void BSSnapshotNotify(String str, byte[] bArr, int i2) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i2 = jSONObject.getInt("cmd");
            if (i2 == 101) {
                this.alarmModel = CameraParmsModel.jsonToModel(str2);
                this.handler.sendEmptyMessage(2);
            } else if (i2 == 136) {
                this.cameraName = str + "  //   " + str2;
                this.handler.sendEmptyMessage(1);
            } else if (i2 == 130) {
                this.handler.sendEmptyMessageDelayed(3, 2000L);
            } else if (i2 == 140) {
                this.status = jSONObject.getInt("status");
                this.upgrade_signal = jSONObject.getInt("upgrade_signal");
                this.currVersion = jSONObject.getString("currVersion");
                this.newVersion = jSONObject.getString("newVersion");
                Bundle bundle = new Bundle();
                Message obtainMessage = this.handler.obtainMessage();
                obtainMessage.what = 4;
                bundle.putInt("status", this.status);
                bundle.putInt("upgrade_signal", this.upgrade_signal);
                obtainMessage.setData(bundle);
                this.handler.sendMessageDelayed(obtainMessage, 2000L);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
    public void ConnectStatus(int i2, int i3, int i4) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.IpcamClientInterface
    public void callBaceVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.IpcamClientInterface
    public void callBackAudioData(byte[] bArr, int i2) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.IpcamClientInterface
    public void callBackH264Data(String str, byte[] bArr, int i2, int i3) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.IpcamClientInterface
    public void callBackMessageNotify(String str, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.set_device_appver_rl) {
            if (SystemClock.uptimeMillis() - this.startClickTime >= 1000) {
                this.startClickTime = SystemClock.uptimeMillis();
                return;
            } else {
                this.mSetDeviceApptimeRl.setVisibility(0);
                this.mSetDeviceSystimeRl.setVisibility(0);
                return;
            }
        }
        if (id != R.id.setting_updata) {
            return;
        }
        if (CommonUtil.isApModul(getWifiSSID())) {
            showToast(R.string.show_ap_notify);
        } else {
            showProgress(R.string.check_updata_3);
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getUpdata(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1, 0));
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_device);
        BarUtils.setStatusBarColor(this, Color.parseColor("#FFFFFFFF"));
        initView();
        getDataFromOther();
        NUIMainActivity.setIpcamClientInterface(this);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        NUIMainActivity.setSHIXCOMMONInterface(null);
        NUIMainActivity.setIpcamClientInterface(null);
        super.onDestroy();
    }

    public void showUpdate() {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        niftyDialogBuilder.withMessage(((Object) getResources().getText(R.string.check_updata_5)) + "  " + this.currVersion + "--->" + this.newVersion + OSSUtils.NEW_LINE + getString(R.string.update_titl_isorno1)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).withTitle(getString(R.string.check_updata_5)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingDeviceActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingDeviceActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
                NativeCallerTools.SDKAPITransferMessage(SettingDeviceActivity.this.strDID, CommonUtil.getUpdata(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, 1));
                SettingDeviceActivity.this.showProgress(R.string.check_updata_1);
            }
        }).show();
    }
}
