package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.view.ViewfinderView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.WifiScanListAdapter;
import com.shix.shixipc.bean.WifiModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingWifiActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public static final int INITTIMEOUT = 10000;
    public Button btnCancel;
    public TextView btnManager;
    public Button btnOk;
    public String cameraName;
    public ImageView cbxShowPwd;
    public EditText editPwd;
    public List<WifiModel> listWifiModels;
    public WifiScanListAdapter mAdapter;
    public ListView mListView;
    public String mString1;
    public int mString2;
    public int mString3;
    public Timer mTimerTimeOut;
    public ProgressDialog progressDialog;
    public ProgressDialog scanDialog;
    public String strDID;
    public String strPwd;
    public String strUser;
    public TextView tvCameraName;
    public EditText tvName;
    public String wifiName;
    public String wifiPwd;
    public String LOG_TAG = "SettingWifiActivity";
    public boolean changeWifiFlag = true;
    public boolean successFlag = false;
    public final int WIFIPARAMS = 1;
    public final int SCANPARAMS = 2;
    public final int OVER = 3;
    public final int TIMEOUT = 4;
    public boolean isTimerOver = false;
    public WifiModel wifiBean = new WifiModel();
    public WifiModel wifiModel = new WifiModel();
    public boolean isCanSee = true;

    @SuppressLint({"HandlerLeak"})
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.SettingWifiActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                SettingWifiActivity.this.successFlag = true;
                if (SettingWifiActivity.this.progressDialog.isShowing()) {
                    SettingWifiActivity.this.progressDialog.cancel();
                }
                if (SettingWifiActivity.this.wifiModel.getSsid() == null || SettingWifiActivity.this.wifiModel.getSsid().length() < 1) {
                    SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                }
                if (SettingWifiActivity.this.wifiModel.getSsid() == null || SettingWifiActivity.this.wifiModel.getSsid().length() <= 1) {
                    return;
                }
                SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiModel.getSsid());
                return;
            }
            if (i2 == 2) {
                MyLogUtils.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi");
                if (SettingWifiActivity.this.scanDialog != null && SettingWifiActivity.this.scanDialog.isShowing()) {
                    SettingWifiActivity.this.scanDialog.dismiss();
                    if (!SettingWifiActivity.this.isTimerOver) {
                        SettingWifiActivity.this.mTimerTimeOut.cancel();
                    }
                    MyLogUtils.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi  2");
                }
                SettingWifiActivity.this.mAdapter.wifiSort();
                SettingWifiActivity.this.mListView.setAdapter((ListAdapter) SettingWifiActivity.this.mAdapter);
                SettingWifiActivity.this.setListViewHeight();
                SettingWifiActivity.this.mListView.setVisibility(0);
                MyLogUtils.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi  3");
                return;
            }
            if (i2 == 3) {
                SettingWifiActivity.this.successFlag = true;
                MyLogUtils.d("tag", "over");
                SettingWifiActivity settingWifiActivity = SettingWifiActivity.this;
                Toast.makeText(settingWifiActivity, settingWifiActivity.getResources().getString(R.string.wifi_set_success), 1).show();
                SettingWifiActivity.this.finish();
                return;
            }
            if (i2 != 4) {
                return;
            }
            SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiBean.getSsid());
            SettingWifiActivity.this.editPwd.setText(SharedPreferencesUtils.getInstance().getString("wifi" + SettingWifiActivity.this.wifiBean.getSsid(), ""));
            if (SettingWifiActivity.this.scanDialog == null || !SettingWifiActivity.this.scanDialog.isShowing()) {
                return;
            }
            SettingWifiActivity.this.scanDialog.dismiss();
        }
    };
    public Runnable settingRunnable = new Runnable() { // from class: com.shix.shixipc.activity.SettingWifiActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (SettingWifiActivity.this.successFlag) {
                return;
            }
            SettingWifiActivity.this.showToast(R.string.wifi_set_failed);
        }
    };

    public static String decode(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i3]) * 16) + "0123456789ABCDEF".indexOf(charArray[i3 + 1])) & ViewfinderView.OPAQUE);
        }
        return new String(bArr);
    }

    private void findView() {
        this.btnOk = (Button) findViewById(R.id.wifi_ok);
        this.btnCancel = (Button) findViewById(R.id.wifi_cancel);
        this.cbxShowPwd = (ImageView) findViewById(R.id.wifi_cbox_show_pwd);
        this.mListView = (ListView) findViewById(R.id.wifi_listview);
        this.tvName = (EditText) findViewById(R.id.wifi_tv_name);
        this.editPwd = (EditText) findViewById(R.id.wifi_edit_pwd);
        this.btnManager = (TextView) findViewById(R.id.wifi_btn_manger);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.editPwd.setImeOptions(6);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
    }

    private void setListener() {
        this.btnManager.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.cbxShowPwd.setOnClickListener(this);
    }

    private void setTimeOut() {
        TimerTask timerTask = new TimerTask() { // from class: com.shix.shixipc.activity.SettingWifiActivity.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MyLogUtils.d(SettingWifiActivity.this.LOG_TAG, "isTimeOver");
                SettingWifiActivity.this.isTimerOver = true;
                SettingWifiActivity.this.mHandler.sendEmptyMessage(4);
            }
        };
        Timer timer = new Timer();
        this.mTimerTimeOut = timer;
        timer.schedule(timerTask, 10000L);
    }

    private void setWifi() {
        if (this.changeWifiFlag) {
            String obj = this.editPwd.getText().toString();
            if (obj == null) {
                obj = "";
            }
            try {
                obj = URLEncoder.encode(obj, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            String ssid = this.wifiBean.getSsid();
            try {
                ssid = URLEncoder.encode(ssid, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_SetWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass, ssid, obj, this.wifiBean.getEncryption()));
        }
    }

    private void setttingTimeOut() {
        this.successFlag = false;
        this.mHandler.postAtTime(this.settingRunnable, 100L);
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        int i2;
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i3 = jSONObject.getInt("cmd");
            int i4 = 1;
            if (i3 == 112) {
                this.wifiModel = WifiModel.jsonToModel(str2);
                this.mHandler.sendEmptyMessage(1);
                return;
            }
            if (i3 == 113) {
                LogUtils.e("biniy", "扫描wifi-dataJson-> " + jSONObject);
                MyLogUtils.d("SHIX", "SHIXWIFI cmd:" + jSONObject.getInt("cmd"));
                if (jSONObject.getInt("result") >= 0) {
                    int i5 = jSONObject.getInt("count");
                    int i6 = 0;
                    while (i6 < i5) {
                        String str3 = "ssid[" + i6 + "]";
                        String str4 = "signal[" + i6 + "]";
                        String str5 = "encryption[" + i6 + "]";
                        CommonUtil.Log(i4, "key1:" + str3 + "  key2:" + str4 + "  key3:" + str5);
                        WifiModel wifiModel = new WifiModel();
                        String obj = jSONObject.get(str3).toString();
                        if (!obj.contains("\\") || obj.length() >= 63) {
                            i2 = i5;
                            wifiModel.setSsid(obj);
                        } else {
                            String replace = obj.substring(obj.indexOf("\\"), obj.lastIndexOf("\\") + 4).replace("\\x", "");
                            String substring = obj.substring(obj.lastIndexOf("\\") + 4);
                            StringBuilder sb = new StringBuilder();
                            i2 = i5;
                            sb.append(obj.substring(0, obj.indexOf("\\")));
                            sb.append(decode(replace));
                            sb.append(substring);
                            wifiModel.setSsid(sb.toString());
                            MyLogUtils.d("SHIX", "  splitSsid:" + replace + "    解码后ssid:" + decode(replace) + "   剩下的其它文本：" + obj.substring(0, obj.indexOf("\\")) + substring + "  保存下来的ssid：" + wifiModel.getSsid());
                        }
                        wifiModel.setEncryption(jSONObject.getInt(str5));
                        wifiModel.setSignal(jSONObject.getInt(str4) + 100);
                        if (wifiModel.getSsid() != null && wifiModel.getSsid().length() > 0) {
                            this.listWifiModels.add(wifiModel);
                            this.mAdapter.addWifiScan(wifiModel);
                            CommonUtil.Log(1, "SHIXWIFI listWifiModel.add  size:" + this.listWifiModels.size());
                        }
                        i6++;
                        i5 = i2;
                        i4 = 1;
                    }
                    this.mHandler.sendEmptyMessage(2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.wifi_ok) {
            switch (id) {
                case R.id.wifi_btn_manger /* 2131231668 */:
                    this.mAdapter.clearWifi();
                    this.mAdapter.notifyDataSetChanged();
                    this.mListView.setVisibility(8);
                    NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.scanWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                    ProgressDialog progressDialog = new ProgressDialog(this, 3);
                    this.scanDialog = progressDialog;
                    progressDialog.setProgressStyle(0);
                    this.scanDialog.setMessage(getResources().getString(R.string.wifi_scanning));
                    this.scanDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.shix.shixipc.activity.SettingWifiActivity.2
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            return i2 == 4;
                        }
                    });
                    this.scanDialog.show();
                    setTimeOut();
                    return;
                case R.id.wifi_cancel /* 2131231669 */:
                    finish();
                    overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    break;
                case R.id.wifi_cbox_show_pwd /* 2131231670 */:
                    break;
                default:
                    return;
            }
            if (this.isCanSee) {
                this.cbxShowPwd.setImageResource(R.mipmap.eyes_open);
                this.editPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.isCanSee = false;
                return;
            } else {
                this.cbxShowPwd.setImageResource(R.mipmap.eyes_close);
                this.editPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.isCanSee = true;
                return;
            }
        }
        if (!this.changeWifiFlag) {
            showToast(R.string.wifi_setting_no_change);
            return;
        }
        if (this.editPwd.getText().toString().isEmpty()) {
            showToast(R.string.tips_c);
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        NUIMainActivity.setSHIXCOMMONInterface(null);
        this.wifiName = this.tvName.getText().toString();
        this.wifiPwd = this.editPwd.getText().toString();
        SharedPreferencesUtils.getInstance().putString("wifi" + this.wifiName, this.wifiPwd);
        Intent intent = new Intent(this, (Class<?>) WiFiConnectionActivity.class);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
        intent.putExtra("wifiName", this.wifiName);
        intent.putExtra("wifiPwd", this.wifiPwd);
        intent.putExtra("wifissid", this.mString1);
        intent.putExtra("wifiencry", this.mString2);
        intent.putExtra("wifisignl", this.mString3);
        intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
        intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
        startActivity(intent);
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.settingwifi);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        findView();
        setListener();
        getDataFromOther();
        ProgressDialog progressDialog = new ProgressDialog(this, 3);
        this.progressDialog = progressDialog;
        progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.wifi_getparams));
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
        this.wifiBean = new WifiModel();
        this.mAdapter = new WifiScanListAdapter(this);
        this.mListView.setOnItemClickListener(this);
        this.listWifiModels = new ArrayList();
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.scanWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getWifiParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.changeWifiFlag = true;
        WifiModel wifiScan = this.mAdapter.getWifiScan(i2);
        this.wifiBean.setSsid(wifiScan.getSsid());
        this.wifiBean.setEncryption(wifiScan.getEncryption());
        this.wifiBean.setSignal(wifiScan.getSignal());
        this.mString1 = wifiScan.getSsid();
        this.mString2 = wifiScan.getEncryption();
        this.mString3 = wifiScan.getSignal();
        this.mHandler.sendEmptyMessage(4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setListViewHeight() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View view = adapter.getView(i3, null, this.mListView);
            view.measure(0, 0);
            i2 += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = this.mListView.getLayoutParams();
        layoutParams.height = i2 + (this.mListView.getDividerHeight() * (adapter.getCount() - 1));
        this.mListView.setLayoutParams(layoutParams);
    }
}
