package com.shix.shixipc.activity;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.bean.WifiModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.WifiUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WiFiConnectionActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface, NUIMainActivity.AddCameraInterface1 {
    public Button backBtn;
    public String cameraName;
    public String mString1;
    public int mString2;
    public int mString3;
    public WifiManager mWifiManager;
    public String strDID;
    public String strPwd;
    public String strUser;
    public String wifiName;
    public String wifiPwd;
    public TextView wifiValue;
    public int FAILED = 0;
    public int SUCCESS = 1;
    public int PARAMS = 2;
    public boolean changeWifiFlag = true;
    public boolean successFlag = false;
    public WifiModel wifiBean = new WifiModel();
    public List<Map<String, Object>> listItems11 = new ArrayList();
    public int checkCount = 0;
    public String pwd = null;
    public String ssid = null;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.WiFiConnectionActivity.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (WiFiConnectionActivity.this.strUser == null) {
                    WiFiConnectionActivity.this.strUser = "Camera";
                }
                WiFiConnectionActivity wiFiConnectionActivity = WiFiConnectionActivity.this;
                if (wiFiConnectionActivity.getPPPPStatus(wiFiConnectionActivity.strDID) == 2) {
                    WiFiConnectionActivity.this.mHandler.sendEmptyMessage(3);
                    return false;
                }
                try {
                    DeviceUtil.INSTANCE.StartPPPP(WiFiConnectionActivity.this.strDID, WiFiConnectionActivity.this.strUser, WiFiConnectionActivity.this.strPwd);
                } catch (Exception unused) {
                }
                WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(1, 5000L);
                return false;
            }
            if (i2 == 2) {
                WiFiConnectionActivity.access$608(WiFiConnectionActivity.this);
                WiFiConnectionActivity.this.wifiValue.setText(WiFiConnectionActivity.this.FAILED + "s");
                if (WiFiConnectionActivity.this.FAILED < 90) {
                    WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(2, 1000L);
                    return false;
                }
                final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(WiFiConnectionActivity.this);
                niftyDialogBuilder.withTitle(WiFiConnectionActivity.this.getString(R.string.tip_reminder)).withOneBtn().withMessage(WiFiConnectionActivity.this.getString(R.string.add_show_config2_show)).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.WiFiConnectionActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        niftyDialogBuilder.dismiss();
                        WiFiConnectionActivity.this.destroy();
                        WiFiConnectionActivity.this.startActivity(new Intent(WiFiConnectionActivity.this, (Class<?>) NUIMainActivity.class));
                    }
                }).show();
                return false;
            }
            if (i2 == 3) {
                WiFiConnectionActivity wiFiConnectionActivity2 = WiFiConnectionActivity.this;
                Toast.makeText(wiFiConnectionActivity2, wiFiConnectionActivity2.getResources().getString(R.string.wifi_set_success), 1).show();
                WiFiConnectionActivity.this.destroy();
                Intent intent = new Intent(WiFiConnectionActivity.this, (Class<?>) NUIMainActivity.class);
                intent.setFlags(67108864);
                WiFiConnectionActivity.this.startActivity(intent);
                WiFiConnectionActivity.this.finish();
                return false;
            }
            if (i2 != 4) {
                if (i2 != 6) {
                    if (i2 != 7) {
                        return false;
                    }
                    WiFiConnectionActivity.this.changeWifi2();
                    WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(4, 2000L);
                    return false;
                }
                if (WiFiConnectionActivity.this.successFlag) {
                    return false;
                }
                NativeCallerTools.SDKAPITransferMessage(WiFiConnectionActivity.this.strDID, CommonUtil.SHIX_SetWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass, WiFiConnectionActivity.this.ssid, WiFiConnectionActivity.this.pwd, WiFiConnectionActivity.this.wifiBean.getEncryption()));
                WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(6, 1000L);
                return false;
            }
            WiFiConnectionActivity.access$808(WiFiConnectionActivity.this);
            MyLogUtils.d("log", "当前手机连接wifi：" + WiFiConnectionActivity.this.getConnectWifiSsid() + "  指定wifi:" + WiFiConnectionActivity.this.wifiBean.toString() + "//" + WiFiConnectionActivity.this.wifiName);
            if (WiFiConnectionActivity.this.getConnectWifiSsid().equals(WiFiConnectionActivity.this.wifiName)) {
                new Thread(new SearchThread()).start();
                WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(4, NetworkUtils.SCAN_PERIOD_MILLIS);
                return false;
            }
            if (WiFiConnectionActivity.this.checkCount > 100) {
                return false;
            }
            WiFiConnectionActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
            return false;
        }
    });

    public class SearchThread implements Runnable {
        public SearchThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyLogUtils.d("log", " SearchThread start");
            NativeCallerTools.SDKAPIStartSearchLanDev(CommonUtil.getLocalIpAddress(WiFiConnectionActivity.this));
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            NativeCallerTools.SDKAPIStopSearchLanDev();
            if (WiFiConnectionActivity.this.listItems11.size() == 0) {
                MyLogUtils.d("log", "list.size=" + WiFiConnectionActivity.this.listItems11.size());
            } else {
                for (int i2 = 0; i2 < WiFiConnectionActivity.this.listItems11.size() - 1; i2++) {
                    if (WiFiConnectionActivity.this.strDID.equals(((Map) WiFiConnectionActivity.this.listItems11.get(i2)).get(ContentCommon.STR_CAMERA_ID))) {
                        WiFiConnectionActivity.this.mHandler.sendEmptyMessage(3);
                    }
                }
                MyLogUtils.d("log", "list.size=" + WiFiConnectionActivity.this.listItems11.size());
            }
            MyLogUtils.d("log", " SearchThread stop");
        }
    }

    public static /* synthetic */ int access$608(WiFiConnectionActivity wiFiConnectionActivity) {
        int i2 = wiFiConnectionActivity.FAILED;
        wiFiConnectionActivity.FAILED = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$808(WiFiConnectionActivity wiFiConnectionActivity) {
        int i2 = wiFiConnectionActivity.checkCount;
        wiFiConnectionActivity.checkCount = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeWifi2() {
        WifiUtil.getIns().init(getApplicationContext());
        WifiUtil.getIns().changeToWifi(this.wifiName, this.wifiPwd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        NUIMainActivity.setSHIXCOMMONInterface(null);
        NUIMainActivity.setAddCameraInterface1(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getConnectWifiSsid() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.mWifiManager = wifiManager;
        if (!wifiManager.isWifiEnabled()) {
            return "";
        }
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (CommonUtil.isApModul(ssid)) {
            int networkId = connectionInfo.getNetworkId();
            Iterator<WifiConfiguration> it = this.mWifiManager.getConfiguredNetworks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WifiConfiguration next = it.next();
                if (next.networkId == networkId) {
                    ssid = next.SSID;
                    break;
                }
            }
        }
        if (ssid != null) {
            return (ssid.startsWith("\"") && ssid.endsWith("\"")) ? ssid.substring(1, ssid.length() - 1) : ssid;
        }
        return "";
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.wifiName = intent.getStringExtra("wifiName");
        this.wifiPwd = intent.getStringExtra("wifiPwd");
        this.mString1 = intent.getStringExtra("wifissid");
        this.mString2 = intent.getIntExtra("wifiencry", 0);
        this.mString3 = intent.getIntExtra("wifisignl", 0);
        this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPPPPStatus(String str) {
        int size = SystemValue.arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                return cameraParamsBean.getDev_p2pstatus();
            }
        }
        return 0;
    }

    private void initView() {
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.wifiValue = (TextView) findViewById(R.id.wifi_con_value);
        this.backBtn = (Button) findViewById(R.id.wifi_con_cancel);
        WifiModel wifiModel = new WifiModel();
        this.wifiBean = wifiModel;
        wifiModel.setSsid(this.mString1);
        this.wifiBean.setEncryption(this.mString2);
        this.wifiBean.setSignal(this.mString3);
        this.mHandler.sendEmptyMessage(2);
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.WiFiConnectionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WiFiConnectionActivity.this.destroy();
                WiFiConnectionActivity.this.finish();
                WiFiConnectionActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
    }

    private void setWifi() {
        if (this.changeWifiFlag) {
            try {
                this.pwd = URLEncoder.encode(this.wifiPwd, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (this.pwd == null) {
                this.pwd = "";
            }
            try {
                this.ssid = URLEncoder.encode(this.wifiName, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            if (this.ssid == null) {
                this.ssid = "";
            }
            MyLogUtils.d("tag", " SHIX_SetWifi111  strDID=" + this.strDID + " ssid=" + this.ssid + " pwd=" + this.pwd + " SystemValue.doorBellAdmin=" + SystemValue.doorBellAdmin + " SystemValue.doorBellPass=" + SystemValue.doorBellPass);
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_SetWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.ssid, this.pwd, this.wifiBean.getEncryption()));
            MyLogUtils.d("tag", " SHIX_SetWifi222  strDID=" + this.strDID + " ssid=" + this.ssid + " pwd=" + this.pwd + " SystemValue.doorBellAdmin=" + SystemValue.doorBellAdmin + " SystemValue.doorBellPass=" + SystemValue.doorBellPass);
            this.mHandler.sendEmptyMessageDelayed(7, 5000L);
        }
    }

    public boolean AddCamera(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(ContentCommon.STR_CAMERA_MAC, str);
        hashMap.put(ContentCommon.STR_CAMERA_NAME, str2);
        hashMap.put(ContentCommon.STR_CAMERA_ID, str3);
        this.listItems11.add(hashMap);
        return true;
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            int i2 = new JSONObject(str2).getInt("cmd");
            if (i2 == 114) {
                this.successFlag = true;
            }
            if (i2 == 101) {
                this.mHandler.sendEmptyMessage(5);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.AddCameraInterface1
    public void callBackSearchResultData(int i2, String str, String str2, String str3, String str4, int i3) {
        MyLogUtils.d("log", "  strMac=" + str + "  strName=" + str2 + "  strDeviceID=" + str3 + "  strIpAddr=" + str4);
        if (str3 == null || str3.length() <= 3 || !AddCamera(str, "Camera", str3.trim().replace("-", "").toUpperCase())) {
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wifi_connect);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NUIMainActivity.setAddCameraInterface1(this);
        getDataFromOther();
        initView();
        setWifi();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10L);
        }
        if (i2 == 82) {
            return false;
        }
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        destroy();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
