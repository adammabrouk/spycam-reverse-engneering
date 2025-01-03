package com.shix.shixipc.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SetHotSpotActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface {
    public String appwd;
    public String apssid;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.SetHotSpotActivity.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 112) {
                return false;
            }
            SetHotSpotActivity.this.mHotspotOldName.setText(SetHotSpotActivity.this.apssid);
            SetHotSpotActivity.this.mHotspotOldPsd.setText(SetHotSpotActivity.this.appwd);
            return false;
        }
    });
    public Button mHotspotCancel;
    public EditText mHotspotNewName;
    public EditText mHotspotNewPsd;
    public EditText mHotspotOldName;
    public EditText mHotspotOldPsd;
    public Button mHotspotPasswordBtn;
    public String strDID;

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void initView() {
        this.mHotspotCancel = (Button) findViewById(R.id.hotspot_cancel);
        this.mHotspotOldName = (EditText) findViewById(R.id.hotspot_old_name);
        this.mHotspotOldPsd = (EditText) findViewById(R.id.hotspot_old_psd);
        this.mHotspotNewName = (EditText) findViewById(R.id.hotspot_new_name);
        this.mHotspotNewPsd = (EditText) findViewById(R.id.hotspot_new_psd);
        this.mHotspotPasswordBtn = (Button) findViewById(R.id.hotspot_password_btn);
        this.mHotspotCancel.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SetHotSpotActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetHotSpotActivity.this.finish();
            }
        });
        this.mHotspotPasswordBtn.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SetHotSpotActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!SetHotSpotActivity.this.mHotspotNewName.getText().toString().isEmpty()) {
                    SetHotSpotActivity setHotSpotActivity = SetHotSpotActivity.this;
                    setHotSpotActivity.apssid = setHotSpotActivity.mHotspotNewName.getText().toString();
                }
                if (!SetHotSpotActivity.this.mHotspotNewPsd.getText().toString().isEmpty()) {
                    SetHotSpotActivity setHotSpotActivity2 = SetHotSpotActivity.this;
                    setHotSpotActivity2.appwd = setHotSpotActivity2.mHotspotNewPsd.getText().toString();
                }
                if (!SetHotSpotActivity.this.apssid.isEmpty() && !SetHotSpotActivity.this.appwd.isEmpty()) {
                    NativeCallerTools.SDKAPITransferMessage(SetHotSpotActivity.this.strDID, CommonUtil.SHIX_SetWifi2(SystemValue.doorBellAdmin, SystemValue.doorBellPass, SetHotSpotActivity.this.apssid, SetHotSpotActivity.this.appwd));
                }
                SetHotSpotActivity.this.finish();
            }
        });
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.getInt("cmd") == 112) {
                if (str2.contains("apssid")) {
                    this.apssid = jSONObject.getString("apssid");
                }
                if (str2.contains("appwd")) {
                    this.appwd = jSONObject.getString("appwd");
                }
                this.mHandler.sendEmptyMessage(112);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_hotspot);
        initView();
        getDataFromOther();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getWifiParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
    }
}
