package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.CloudDateAdapter;
import com.shix.shixipc.bean.DateModel;
import com.shix.shixipc.bean.DeviceOffTimeModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ClouDateActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public Button btnBack;
    public String camName;
    public String clouddate;
    public String did;
    public List<String> listDate;
    public ListView listView;
    public CloudDateAdapter mAdapter;
    public ProgressDialog mProgress;
    public OSS osss;
    public String strDate1;
    public String strDate2;
    public final int BEND = 1;
    public final int BEND1 = 2;
    public boolean isFirstRun = true;
    public DeviceOffTimeModel mModel = null;
    public DateModel mDateModel = null;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.ClouDateActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeUtil.getTimeZone(ClouDateActivity.this.mDateModel.getTimeZone())));
                ClouDateActivity.this.strDate1 = simpleDateFormat.format(new Date(ClouDateActivity.this.mModel.getTimedOffTime() * 1000));
                LogUtils.e("biniy", "OSS---start-getWifiSSID()= " + ClouDateActivity.this.getWifiSSID());
                if (!CommonUtil.isApModul(ClouDateActivity.this.getWifiSSID())) {
                    LogUtils.e("biniy", "OSS---start-isFirstRun= " + ClouDateActivity.this.isFirstRun);
                    if (ClouDateActivity.this.isFirstRun) {
                        ClouDateActivity.this.test();
                        ClouDateActivity.this.isFirstRun = false;
                    }
                }
            }
            return false;
        }
    });
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.ClouDateActivity.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                String string = message.getData().getString(FileProvider.ATTR_PATH);
                CommonUtil.Log(1, "path:" + string);
                if (string == null || string.length() < 10) {
                    return true;
                }
                string.indexOf("/");
                ClouDateActivity.this.strDate2 = string.substring(string.lastIndexOf("/") + 1);
                LogUtils.e("biniy", "移动侦测-strDate1= " + ClouDateActivity.this.strDate1 + "---strDate2= " + ClouDateActivity.this.strDate2);
                if (ClouDateActivity.this.strDate1 != null && ClouDateActivity.this.strDate2 != null && TimeUtil.getCompareDate(ClouDateActivity.this.strDate1, ClouDateActivity.this.strDate2)) {
                    ClouDateActivity.this.listDate.add(ClouDateActivity.this.strDate2);
                }
            } else if (i2 == 2) {
                ClouDateActivity clouDateActivity = ClouDateActivity.this;
                ClouDateActivity clouDateActivity2 = ClouDateActivity.this;
                clouDateActivity.mAdapter = new CloudDateAdapter(clouDateActivity2, clouDateActivity2.listDate);
                ClouDateActivity.this.listView.setAdapter((ListAdapter) ClouDateActivity.this.mAdapter);
            }
            return false;
        }
    });

    private void findView() {
        this.listView = (ListView) findViewById(R.id.piclistview);
        Button button = (Button) findViewById(R.id.back);
        this.btnBack = button;
        button.setOnClickListener(this);
    }

    private void setListener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOss(ListObjectsRequest listObjectsRequest) {
        this.osss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() { // from class: com.shix.shixipc.activity.ClouDateActivity.4
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(ListObjectsRequest listObjectsRequest2, ClientException clientException, ServiceException serviceException) {
                if (ClouDateActivity.this.mProgress != null && ClouDateActivity.this.mProgress.isShowing()) {
                    ClouDateActivity.this.mProgress.dismiss();
                }
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    LogUtils.e("biniy", "OSS ErrorCode-OSS " + serviceException.getErrorCode());
                    LogUtils.e("biniy", "OSS ErrorCode-OSS " + serviceException.getRequestId());
                    LogUtils.e("biniy", "OSS ErrorCode-OSS " + serviceException.getHostId());
                    LogUtils.e("biniy", "OSS ErrorCode-OSS " + serviceException.getRawMessage());
                }
                LogUtils.e("biniy", "OSS---end ");
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(ListObjectsRequest listObjectsRequest2, ListObjectsResult listObjectsResult) {
                if (ClouDateActivity.this.mProgress != null && ClouDateActivity.this.mProgress.isShowing()) {
                    ClouDateActivity.this.mProgress.dismiss();
                }
                LogUtils.e("biniy", "OSS AyncListObjects", "OSS Success!  size= " + listObjectsResult.getObjectSummaries().size());
                for (int i2 = 0; i2 < listObjectsResult.getObjectSummaries().size(); i2++) {
                    LogUtils.e("biniy", "OSS object: " + listObjectsResult.getObjectSummaries().get(i2).getKey() + LogUtils.PLACEHOLDER + listObjectsResult.getObjectSummaries().get(i2).getETag() + LogUtils.PLACEHOLDER + listObjectsResult.getObjectSummaries().get(i2).getLastModified());
                    String key = listObjectsResult.getObjectSummaries().get(i2).getKey();
                    StringBuilder sb = new StringBuilder();
                    sb.append("path -> ");
                    sb.append(key);
                    MyLogUtils.d("OSS AyncListObjects", sb.toString());
                    Message obtainMessage = ClouDateActivity.this.handler.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString(FileProvider.ATTR_PATH, key);
                    obtainMessage.setData(bundle);
                    ClouDateActivity.this.handler.sendMessage(obtainMessage);
                    if (i2 == listObjectsResult.getObjectSummaries().size() - 1) {
                        ClouDateActivity.this.handler.sendEmptyMessage(2);
                    }
                }
            }
        }).waitUntilFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void test() {
        LogUtils.e("biniy", "OSS---start ");
        final ListObjectsRequest listObjectsRequest = this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new ListObjectsRequest("lookcam") : new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
        listObjectsRequest.setPrefix(this.did + "/dates/");
        new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.ClouDateActivity.3
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r1) {
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                if (ClouDateActivity.this.mProgress == null) {
                    ClouDateActivity.this.mProgress = new ProgressDialog(ClouDateActivity.this);
                    ClouDateActivity.this.mProgress.setMessage(ClouDateActivity.this.getResources().getString(R.string.scan_er_1));
                    ClouDateActivity.this.mProgress.setCancelable(false);
                    ClouDateActivity.this.mProgress.setCanceledOnTouchOutside(false);
                }
                ClouDateActivity.this.mProgress.show();
            }

            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                ClouDateActivity.this.startOss(listObjectsRequest);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.did) || !str.equals(this.did.replace("-", ""))) {
            return;
        }
        try {
            int i2 = new JSONObject(str2).getInt("cmd");
            if (i2 == 121) {
                try {
                    this.mModel = DeviceOffTimeModel.jsonToModel(str2);
                    if (this.mDateModel != null) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            if (i2 == 125) {
                try {
                    this.mDateModel = DateModel.jsonToModel(str2);
                    if (this.mModel != null) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return;
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        e4.printStackTrace();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.back) {
            return;
        }
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.did = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.camName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        LogUtils.e("biniy", "did-> " + this.did + "camName-> " + this.camName);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCallerTools.SDKAPITransferMessage(this.did, CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.did, CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        setContentView(R.layout.clouddateactivity);
        this.listDate = new ArrayList();
        findView();
        setListener();
        ((TextView) findViewById(R.id.tv_camera_setting)).setText(this.camName);
        this.listView.setOnItemClickListener(this);
        this.handler.sendEmptyMessageDelayed(3, 1000L);
        this.did = this.did.toUpperCase().replace("-", "");
        this.did = this.did.substring(0, 3) + "-" + this.did.substring(3, 9) + "-" + this.did.substring(9);
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXCLOUD  did:");
        sb.append(this.did);
        CommonUtil.Log(1, sb.toString());
        OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new OSSPlainTextAKSKCredentialProvider("LTAI4Fvp5vkFic1UxLBmVk41", "E71ud2gGXTGO4DmR3qhYs9eTytcSuL") : new OSSPlainTextAKSKCredentialProvider("LTAI4FuRjQ3yKaiDrhWk7Vxv", "Ncf5q6WIocKiPtPUlyCQxLYKq1tIT1");
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(10000);
        clientConfiguration.setSocketTimeout(10000);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        if (CommonUtil.isApModul(getWifiSSID())) {
            return;
        }
        this.osss = new OSSClient(getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", oSSPlainTextAKSKCredentialProvider, clientConfiguration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.mProgress;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mProgress.dismiss();
        }
        this.mProgress = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Intent intent = new Intent(this, (Class<?>) CloudLogActivity.class);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.did);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.camName);
        intent.putExtra(ContentCommon.STR_CLOUD_DATE, this.listDate.get(i2));
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
