package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import c.j.a.a;
import c.j.a.c;
import c.k.c.a.l;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.activity.SettingActivity;
import com.shix.shixipc.adapter.CameraListAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.bean.DateModel;
import com.shix.shixipc.bean.DeviceOffTimeModel;
import com.shix.shixipc.bean.VideoRecordModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.Rom;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utilcode.TimeConstants;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.AppUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.GpsUtil;
import com.shix.shixipc.utils.MyLinearLayoutManager;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.InputDialogBuilder;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FragmentCameraList extends BaseFragment implements View.OnClickListener, AddCameraActivity.DeleInterface, SettingActivity.DeleDetInterface, SettingActivity.DelCameraInterface {
    public static final String STR_DID = "did";
    public static final String STR_MSG_PARAM = "msgparam";
    public static Context contextL;
    public static NewUiMainInterface newUiMainInterface;
    public LinearLayout buttonAdd;
    public DateModel dateModel;
    public TextView device_count;
    public String did;
    public RecyclerView firstFraGrid;
    public GetDataTask getDataTask;
    public int gltag;
    public ImageButton ibCameraFour;
    public ImageButton ibItemSwitch;
    public ImageButton ibSearchWifi;
    public ImageButton imbtn_add;
    public int isPrivacy;
    public LinearLayout layoutAdd;
    public Context mContext;
    public LocationManager mLocationManager;
    public ProgressDialog mProgress;
    public WifiManager mWifiManager;
    public SharedPreferences preuser;
    public SwipeRefreshLayout refreshCamera;
    public String strUUID;
    public final int SNAPSHOT = 200;
    public CameraListAdapter listAdapter = null;
    public HashMap<String, String> mHashMap = new HashMap<>();
    public VideoRecordModel videoRecordModel = new VideoRecordModel();
    public DeviceOffTimeModel mModel = new DeviceOffTimeModel();
    public String fcmToken = "";
    public String wifiName = "";
    public boolean oldStatus = false;
    public int restrict = 0;
    public boolean isFirst2 = true;
    public boolean isShowAllDevice = true;
    public boolean isResetTimedOffTime = false;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.FragmentCameraList.11
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                LogUtils.e("biniy", "121-2-> mModel.getTimedOffTime()= " + FragmentCameraList.this.mModel.getTimedOffTime());
                if (FragmentCameraList.this.mModel.getTimedOffTime() == 0 && !CommonUtil.isApModul(FragmentCameraList.this.getWifiSSID())) {
                    try {
                        FragmentCameraList.this.isResetTimedOffTime = true;
                        LogUtils.e("biniy", "121-3-> TimeUtil.getUTCTimeSec()= " + TimeUtil.getUTCTimeSec());
                        FragmentCameraList.this.mModel.setTimedOffTime((int) TimeUtil.getUTCTimeSec());
                        String json = DeviceOffTimeModel.toJson(FragmentCameraList.this.mModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
                        LogUtils.e("biniy", "121-send-> did= " + FragmentCameraList.this.did + "---json121= " + json);
                        NativeCallerTools.SDKAPITransferMessage(FragmentCameraList.this.did, json);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if (FragmentCameraList.this.isResetTimedOffTime) {
                    FragmentCameraList.this.isResetTimedOffTime = false;
                    LogUtils.e("biniy", "121-已重新设置timeofftime成功，删除云端移动侦测数据");
                    FragmentCameraList.this.clearOSS();
                }
            } else if (i2 == 2) {
                try {
                    int parseDouble = (int) Double.parseDouble(FragmentCameraList.this.getVersionName());
                    int parseDouble2 = (int) Double.parseDouble(message.getData().getString("imgdata"));
                    MyLogUtils.d("tag", "接受到的数据：" + parseDouble + "-" + parseDouble2);
                    if (parseDouble2 > parseDouble) {
                        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(FragmentCameraList.this.mContext);
                        niftyDialogBuilder.withMessage(R.string.tip_app_updata).withTitle(FragmentCameraList.this.mContext.getString(R.string.tip_reminder)).withButton2Text(FragmentCameraList.this.mContext.getString(R.string.tip_updata_right)).withButton1Text(FragmentCameraList.this.mContext.getString(R.string.tip_updata_left)).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.11.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                FragmentCameraList fragmentCameraList = FragmentCameraList.this;
                                fragmentCameraList.launchAppDetail("shix.homeeye.camera", AppUtils.getMarketPkgGoogle(fragmentCameraList.mContext));
                                niftyDialogBuilder.dismiss();
                            }
                        }).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.11.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                niftyDialogBuilder.dismiss();
                            }
                        }).show();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if (i2 == 3) {
                if (!FragmentCameraList.getTimeZone().isEmpty()) {
                    FragmentCameraList.this.dateModel.setTime((int) TimeUtil.getUTCTimeSec());
                }
                if (FragmentCameraList.this.dateModel.getNtpServer().isEmpty()) {
                    FragmentCameraList.this.dateModel.setNtpServer("ntp.sjtu.edu.cn");
                }
                try {
                    NativeCallerTools.SDKAPITransferMessage(FragmentCameraList.this.did, DateModel.toJson(FragmentCameraList.this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                    MyLogUtils.d("tag", " 时区同步3 TimeZone=" + Float.parseFloat(FragmentCameraList.getTimeZone()) + " TimeZone_Sec=" + TimeUtil.getUTCTimeSec());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (i2 == 11) {
                String dataFromDevice = CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
                LogUtils.e("biniy", "121-get11-> did= " + FragmentCameraList.this.did + "---json121= " + dataFromDevice);
                NativeCallerTools.SDKAPITransferMessage(FragmentCameraList.this.did, dataFromDevice);
            }
            return false;
        }
    });
    public Handler PPPPMsgHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.FragmentCameraList.16
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Bundle data = message.getData();
            int i2 = data.getInt(FragmentCameraList.STR_MSG_PARAM);
            int i3 = message.what;
            FragmentCameraList.this.did = data.getString(FragmentCameraList.STR_DID);
            MyLogUtils.d(ContentCommon.SERVER_STRING, "did==" + FragmentCameraList.this.did + "  msgType=" + i3 + "  msgParam=" + i2);
            if (i3 == 0) {
                FragmentCameraList fragmentCameraList = FragmentCameraList.this;
                if (fragmentCameraList.listAdapter.UpdataCameraStatus(fragmentCameraList.did, i2)) {
                    FragmentCameraList.this.setAddViewVisible();
                    if (i2 == 2) {
                        FragmentCameraList fragmentCameraList2 = FragmentCameraList.this;
                        CameraParamsBean cameraBean = fragmentCameraList2.getCameraBean(fragmentCameraList2.did);
                        if (cameraBean == null) {
                            return true;
                        }
                        SystemValue.doorBellAdmin = cameraBean.getDev_User();
                        SystemValue.doorBellPass = cameraBean.getDev_Pwd();
                        int i4 = (-TimeZone.getDefault().getRawOffset()) / 1000;
                        long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                        MyLogUtils.d("tag", " SHIX_SetWifi222  strDID=" + cameraBean.getDev_Did() + " SystemValue.doorBellAdmin=" + cameraBean.getDev_User() + " SystemValue.doorBellPass=" + cameraBean.getDev_Pwd());
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.getCheckUser(cameraBean.getDev_User(), cameraBean.getDev_Pwd()));
                        StringBuilder sb = new StringBuilder();
                        sb.append(" videoRecordModel.getVideoRecord()=getRDParms  ");
                        sb.append(FragmentCameraList.this.videoRecordModel.getVideoRecord());
                        sb.append("--");
                        sb.append(cameraBean.getDev_Did());
                        MyLogUtils.d("tag", sb.toString());
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.getRDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        String dataFromDevice = CommonUtil.getDataFromDevice("get_light_param", 121, cameraBean.getDev_User(), cameraBean.getDev_Pwd());
                        LogUtils.e("biniy", "121-get-> bean.getDev_Did()= " + cameraBean.getDev_Did() + "---json121= " + dataFromDevice);
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), dataFromDevice);
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.getDeviceSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        MyLogUtils.d("tag", " 时区同步1");
                        int i5 = 80;
                        if (FragmentCameraList.this.locationAddress.contains("中国") || FragmentCameraList.this.locationAddress.toLowerCase().contains("china")) {
                            i5 = 16;
                        } else if (!FragmentCameraList.this.locationAddress.isEmpty()) {
                            FragmentCameraList.this.fcmToken.isEmpty();
                        }
                        if (FragmentCameraList.this.isChineseLanguage()) {
                            NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.SHIX_SetCameraParms(cameraBean.getDev_User(), cameraBean.getDev_Pwd(), 1));
                            MyLogUtils.d("push", "语言命令===中文");
                        } else {
                            NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.SHIX_SetCameraParms(cameraBean.getDev_User(), cameraBean.getDev_Pwd(), 0));
                            MyLogUtils.d("push", "语言命令==English");
                        }
                        NativeCallerTools.SDKAPITransferMessage(cameraBean.getDev_Did(), CommonUtil.SHIX_setCloudStorage(cameraBean.getDev_User(), cameraBean.getDev_Pwd(), cameraBean.getDev_Did()));
                        MyLogUtils.d("FragmentCameraList", "  XG_TOKEN=" + ContentCommon.XG_TOKEN + "  FCM_TOKEN=" + FragmentCameraList.this.fcmToken + " type=" + i5);
                        if (FragmentCameraList.this.isFirst2 && CommonUtil.isApModul(FragmentCameraList.this.getWifiSSID()) && FragmentCameraList.this.did.equals(FragmentCameraList.this.getWifiSSID().replace("-", ""))) {
                            FragmentCameraList.this.showConfigWifiDialog(cameraBean.getDev_Did(), Effectstype.Slidetop, cameraBean.getDev_name());
                            FragmentCameraList.this.isFirst2 = false;
                        }
                    }
                    if (i2 == 5 || i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 4) {
                        DeviceUtil.INSTANCE.StopPPPP(FragmentCameraList.this.did);
                    }
                }
            } else if (i3 == 1) {
                MyLogUtils.d("shix", "shix:" + i2);
            } else if (i3 == 3) {
                FragmentCameraList fragmentCameraList3 = FragmentCameraList.this;
                fragmentCameraList3.listAdapter.UpdataCameraResetrict(fragmentCameraList3.did, i2);
            } else if (i3 == 200) {
                FragmentCameraList.this.setAddViewVisible();
            }
            return false;
        }
    });
    public LocListener locListener = null;
    public String locationAddress = "";

    public class GetDataTask extends AsyncTask<Void, Void, Void> {

        public class StopPPPPThread implements Runnable {
            public StopPPPPThread() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(50L);
                    GetDataTask.this.StopCameraPPPP();
                } catch (Exception unused) {
                }
            }
        }

        public GetDataTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void StopCameraPPPP() {
            int count = FragmentCameraList.this.listAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                CameraParamsBean onItem = FragmentCameraList.this.listAdapter.getOnItem(i2);
                if (onItem.getDev_p2pstatus() != 0 && onItem.getDev_p2pstatus() != 2) {
                    DeviceUtil.INSTANCE.StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd());
                    MyLogUtils.d(" tag ", " StopCameraPPPP 当前操作的设备id：" + onItem.getDev_Did() + " 状态码：" + onItem.getDev_p2pstatus());
                    try {
                        Thread.sleep(50L);
                    } catch (Exception unused) {
                    }
                }
            }
            if (FragmentCameraList.this.refreshCamera.d()) {
                FragmentCameraList.this.refreshCamera.setRefreshing(false);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            new Thread(new StopPPPPThread()).start();
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r2) {
            FragmentCameraList.this.setAddViewVisible();
            super.onPostExecute((GetDataTask) r2);
        }
    }

    public class LocListener implements LocationListener {
        public LocListener() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            FragmentCameraList fragmentCameraList = FragmentCameraList.this;
            fragmentCameraList.locationAddress = fragmentCameraList.getLocationAddress(location);
            if (!FragmentCameraList.this.locationAddress.isEmpty()) {
                SharedPreferencesUtils.getInstance().putString(HttpHeaders.LOCATION, FragmentCameraList.this.locationAddress);
            }
            MyLogUtils.d("FragmentCameraList", "当前定位地址为：" + FragmentCameraList.this.locationAddress + "  location=" + location.getLongitude() + LogUtils.PLACEHOLDER + location.getLatitude());
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public interface NewUiMainInterface {
        void CallBackStyle(int i2);
    }

    public class StartPPPPThread implements Runnable {
        public StartPPPPThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FragmentCameraList.this.StartCameraPPPP();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StartCameraPPPP() {
        int count = this.listAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CameraParamsBean onItem = this.listAdapter.getOnItem(i2);
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
            DeviceUtil.INSTANCE.StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd());
        }
    }

    private void addCamera(String str) {
        String replace = str.replace("-", "");
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (replace.equalsIgnoreCase(it.next().getDev_Did())) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        MyLogUtils.d("tag", " --initData-- ");
        this.isFirst2 = true;
        ContentCommon.AP_ADD_OR_CON = 1;
        ContentCommon.AP_ADD_UID = replace;
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_Did(replace);
        cameraParamsBean.setDev_name("Camera");
        cameraParamsBean.setDev_User(ContentCommon.DEFAULT_USER_NAME);
        cameraParamsBean.setDev_Pwd("6666");
        SystemValue.arrayList.add(cameraParamsBean);
        ContentCommon.SHIX_saveDev(cameraParamsBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOSS() {
        if (CommonUtil.isApModul(getWifiSSID()) || TextUtils.isEmpty(this.did) || this.did.length() < 14) {
            return;
        }
        OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new OSSPlainTextAKSKCredentialProvider("LTAI4Fvp5vkFic1UxLBmVk41", "E71ud2gGXTGO4DmR3qhYs9eTytcSuL") : new OSSPlainTextAKSKCredentialProvider("LTAI4FuRjQ3yKaiDrhWk7Vxv", "Ncf5q6WIocKiPtPUlyCQxLYKq1tIT1");
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(10000);
        clientConfiguration.setSocketTimeout(10000);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        final OSSClient oSSClient = new OSSClient(getActivity().getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", oSSPlainTextAKSKCredentialProvider, clientConfiguration);
        String replace = this.did.toUpperCase().replace("-", "");
        new AsyncTask<String, Void, Void>() { // from class: com.shix.shixipc.activity.FragmentCameraList.20
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r1) {
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                if (FragmentCameraList.this.mProgress == null) {
                    FragmentCameraList.this.mProgress = new ProgressDialog(FragmentCameraList.this.getActivity());
                    FragmentCameraList.this.mProgress.setMessage(FragmentCameraList.this.getResources().getString(R.string.scan_er_1));
                    FragmentCameraList.this.mProgress.setCancelable(false);
                    FragmentCameraList.this.mProgress.setCanceledOnTouchOutside(false);
                }
                FragmentCameraList.this.mProgress.show();
            }

            @Override // android.os.AsyncTask
            public Void doInBackground(String... strArr) {
                FragmentCameraList.this.startOss(oSSClient, strArr[0] + "/photos/", strArr[0], 1);
                return null;
            }
        }.execute(replace.substring(0, 3) + "-" + replace.substring(3, 9) + "-" + replace.substring(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delCamera(final String str) {
        DeviceUtil.INSTANCE.StopPPPP(str);
        CameraParamsBean cameraBean = getCameraBean(str);
        ContentCommon.unPush(getActivity(), str);
        ContentCommon.SHIX_delDev(cameraBean);
        if (!CommonUtil.isApModul(this.wifiName)) {
            if (CrashApplication.getPushBrand() != 2 && CrashApplication.getPushBrand() == 3) {
                c.a(this.mContext).a(str, new a() { // from class: com.shix.shixipc.activity.FragmentCameraList.10
                    @Override // c.j.a.a
                    public void onStateChanged(int i2) {
                        if (i2 == 0) {
                            MyLogUtils.d("push", " vivo推送解绑:" + str);
                            return;
                        }
                        MyLogUtils.d("push", " vivo推送解绑:" + str + " 失败");
                    }
                });
            }
            MyLogUtils.d("push", " 小米推送取消订阅*删除按钮*Did:" + str);
            l.g(this.mContext, str, null);
            HashSet hashSet = new HashSet();
            hashSet.add(str);
            MyLogUtils.d("push", " 极光推送取消订阅*删除按钮*tags:" + str);
            JPushInterface.deleteTags(this.mContext, 0, hashSet);
        }
        setAddViewVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePics(final OSS oss, List<String> list, final String str, final int i2) {
        oss.asyncDeleteMultipleObject(this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new DeleteMultipleObjectRequest("lookcam", list, true) : new DeleteMultipleObjectRequest(ContentCommon.CLOUDBUCKET, list, true), new OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult>() { // from class: com.shix.shixipc.activity.FragmentCameraList.22
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(DeleteMultipleObjectRequest deleteMultipleObjectRequest, ClientException clientException, ServiceException serviceException) {
                if (FragmentCameraList.this.mProgress != null && FragmentCameraList.this.mProgress.isShowing()) {
                    FragmentCameraList.this.mProgress.dismiss();
                }
                LogUtils.e("biniy", "移动侦测-Failed!");
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(DeleteMultipleObjectRequest deleteMultipleObjectRequest, DeleteMultipleObjectResult deleteMultipleObjectResult) {
                if (FragmentCameraList.this.mProgress != null && FragmentCameraList.this.mProgress.isShowing()) {
                    FragmentCameraList.this.mProgress.dismiss();
                }
                LogUtils.e("biniy", "移动侦测-success!");
                int i3 = i2;
                if (i3 == 1) {
                    FragmentCameraList.this.startOss(oss, str + "/photos/", str, 1);
                    return;
                }
                if (i3 == 2) {
                    FragmentCameraList.this.startOss(oss, str + "/dates/", str, 3);
                }
            }
        });
    }

    private void done(String str, String str2, String str3, String str4) {
        String upperCase = str4.toUpperCase();
        if (str.length() == 0) {
            showToast(R.string.input_camera_name);
            return;
        }
        if (upperCase.length() == 0) {
            showToast(R.string.input_camera_id);
            return;
        }
        upperCase.length();
        if (!CommonUtil.isApModul(upperCase)) {
            showToast(R.string.add_camer_invi);
            return;
        }
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_Did(upperCase.replace("-", "").trim());
        cameraParamsBean.setDev_name(str);
        cameraParamsBean.setDev_User(str2);
        cameraParamsBean.setDev_Pwd(str3);
        boolean z = false;
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (SystemValue.arrayList.get(i2).getDev_Did().contains(cameraParamsBean.getDev_Did())) {
                z = true;
            }
        }
        if (z) {
            CameraParamsBean SHIX_getDevs = ContentCommon.SHIX_getDevs(upperCase.replace("-", "").trim());
            SHIX_getDevs.setDev_Pwd(str3);
            SHIX_getDevs.setDev_name(str);
            SHIX_getDevs.setDev_p2pstatus(4);
            ContentCommon.SHIX_updataDevs(SHIX_getDevs);
            DeviceUtil.INSTANCE.StopPPPP(SHIX_getDevs.getDev_Did());
        } else {
            SystemValue.arrayList.add(cameraParamsBean);
            ContentCommon.SHIX_saveDev(cameraParamsBean);
        }
        DeviceUtil.INSTANCE.StartPPPP(cameraParamsBean.getDev_Did(), cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CameraParamsBean getCameraBean(String str) {
        int count = this.listAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CameraParamsBean onItem = this.listAdapter.getOnItem(i2);
            if (onItem.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i2;
                return onItem;
            }
        }
        return null;
    }

    public static String getGmtTimeZone() {
        int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / TimeConstants.HOUR;
        MyLogUtils.d("tag", "getGmtTimeZone" + offset);
        return String.valueOf(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocationAddress(Location location) {
        try {
            List<Address> fromLocation = new Geocoder(this.mContext, Locale.CHINESE).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation.size() <= 0) {
                return "";
            }
            Address address = fromLocation.get(0);
            return address.getCountryName() + address.getAdminArea();
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    private Location getMyLastKnownLocation() {
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        this.mLocationManager = locationManager;
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = this.mLocationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        return location;
    }

    private void getNewVersion() {
        new Thread(new Runnable() { // from class: com.shix.shixipc.activity.FragmentCameraList.17
            @Override // java.lang.Runnable
            public void run() {
                MyLogUtils.d("tag", "接受到的数据1：https://xyx.wiki/android/Logversion");
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://xyx.wiki/android/Logversion").openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.connect();
                    MyLogUtils.d("tag", "接受到的数据2：https://xyx.wiki/android/Logversion");
                    if (httpURLConnection.getResponseCode() == 200) {
                        try {
                            JSONObject jSONObject = new JSONObject(new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8)).readLine());
                            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(JThirdPlatFormInterface.KEY_DATA));
                            MyLogUtils.d("tag", "接受到的数据3：" + jSONObject);
                            MyLogUtils.d("tag", "接受到的数据4：" + jSONObject.getString(JThirdPlatFormInterface.KEY_DATA));
                            MyLogUtils.d("tag", "接受到的数据5：" + jSONObject2.getString(ActionManager.SDK_VERSION));
                            SharedPreferencesUtils.getInstance().putString("NewVersion", jSONObject2.getString(ActionManager.SDK_VERSION));
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            Bundle bundle = new Bundle();
                            bundle.putString("imgdata", jSONObject2.getString(ActionManager.SDK_VERSION).replace(".", "").replace("T", ""));
                            obtain.setData(bundle);
                            FragmentCameraList.this.mHandler.sendMessage(obtain);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }).start();
    }

    private String getPrivacy(List<String> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).startsWith(str)) {
                return list.get(i2).substring(list.get(i2).indexOf(",") + 1);
            }
        }
        return null;
    }

    public static String getTimeZone() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(calendar2.getTimeZone());
        calendar.set(calendar2.get(1), 11, 31, 13, 0, 0);
        return getTimeZoneText2(calendar2.getTimeZone(), true);
    }

    public static int getTimeZone2() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(calendar2.getTimeZone());
        calendar.set(calendar2.get(1), 11, 31, 13, 0, 0);
        return getTimeZoneText(calendar2.getTimeZone(), true);
    }

    public static int getTimeZoneText(TimeZone timeZone, boolean z) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ");
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        MyLogUtils.d("tag", "gmtString 0  " + format + " src=0");
        int intValue = (Integer.valueOf(format.substring(4, 6)).intValue() * 3600) + 0;
        MyLogUtils.d("tag", "gmtString 1  " + format + " src=" + intValue);
        int intValue2 = (Integer.valueOf(format.substring(7)).intValue() * 60) + intValue;
        MyLogUtils.d("tag", "gmtString 2  " + format + " src=" + intValue2);
        return (!format.contains("+") && format.contains("-")) ? -intValue2 : intValue2;
    }

    public static String getTimeZoneText2(TimeZone timeZone, boolean z) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ");
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        MyLogUtils.d("tag", "gmtString 1  " + format);
        MyLogUtils.d("tag", "gmtString 2  " + format);
        String replace = format.substring(3, 6).replace("+", "");
        MyLogUtils.d("tag", "gmtString 3  " + replace);
        return replace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVersionName() throws Exception {
        return this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName.replace(".", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public String getWifiSSID() {
        WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
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

    private void initAdapter() {
        this.firstFraGrid.setItemViewCacheSize(20);
        this.firstFraGrid.setDrawingCacheEnabled(true);
        this.firstFraGrid.setDrawingCacheQuality(MemoryConstants.MB);
        this.listAdapter = new CameraListAdapter(this);
        if (this.isShowAllDevice) {
            this.firstFraGrid.setLayoutManager(new MyLinearLayoutManager(getActivity()));
            this.listAdapter.setType(0);
        } else {
            this.firstFraGrid.setLayoutManager(new MyLinearLayoutManager(getActivity()));
            this.listAdapter.setType(1);
        }
        this.firstFraGrid.setAdapter(this.listAdapter);
    }

    private void initData() {
        LogUtils.e("biniy", "clist-3");
        String wifiSSID = getWifiSSID();
        this.wifiName = wifiSSID;
        if (CommonUtil.isApModul(wifiSSID)) {
            addCamera(this.wifiName);
        }
        this.getDataTask.StopCameraPPPP();
        setAddViewVisible();
    }

    public static boolean isBrandHuawei() {
        return "huawei".equalsIgnoreCase(Build.BRAND) || "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChineseLanguage() {
        String language = Locale.getDefault().getLanguage();
        MyLogUtils.e("tag", "language = " + language);
        return language.equalsIgnoreCase("zh");
    }

    private boolean isHave(String str, List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2))) {
                MyLogUtils.d("tag", "  服务器：" + str + "  本地:" + list.get(i2));
                return true;
            }
        }
        return false;
    }

    private synchronized boolean isPrivacyMode(String str) {
        if (str != null) {
            if (str.equals("1")) {
                Toast.makeText(this.mContext, R.string.tip_ysms_switch, 0).show();
                return true;
            }
        }
        return false;
    }

    private boolean isSetHave(String str, Set<String> set) {
        return set.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddViewVisible() {
        int i2 = 0;
        if (SystemValue.arrayList.size() == 0) {
            this.layoutAdd.setVisibility(0);
            this.device_count.setText(0 + getResources().getString(R.string.device_on_line_tip));
        } else {
            Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getDev_p2pstatus() == 2) {
                    i2++;
                }
            }
            this.device_count.setText(i2 + getResources().getString(R.string.device_on_line_tip));
            this.layoutAdd.setVisibility(8);
        }
        this.listAdapter.notifyDataSetChanged();
    }

    private void setMiSubscribe(CameraParamsBean cameraParamsBean, int i2) {
        LogUtils.e("biniy", "xmpush-MiPushClient.getRegId= " + l.q(getActivity()));
        l.f(getActivity(), cameraParamsBean.getDev_Did(), null);
        NativeCallerTools.SDKAPITransferMessage(i2, CommonUtil.SHIX_SetMiPush(cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd(), cameraParamsBean.getDev_name(), cameraParamsBean.getDev_Did()));
    }

    public static void setNewUiMainInterface(NewUiMainInterface newUiMainInterface2) {
        newUiMainInterface = newUiMainInterface2;
    }

    private void setOPPOPPush(CameraParamsBean cameraParamsBean, int i2) {
        String SHIX_SetOPPOPush = CommonUtil.SHIX_SetOPPOPush(cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd(), cameraParamsBean.getDev_name(), cameraParamsBean.getDev_Did(), SharedPreferencesUtils.getInstance().getString("OPPOPUSH_ID"));
        LogUtils.e("biniy", "setOPPOPush-json = " + SHIX_SetOPPOPush);
        NativeCallerTools.SDKAPITransferMessage(i2, SHIX_SetOPPOPush);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPushConfig(String str, CameraParamsBean cameraParamsBean) {
        Log.e("biniy", "getResources().getString(R.string.app_name_show)= " + getResources().getString(R.string.app_name_show));
        if (!getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            LogUtils.e("biniy", "推送走google FCM");
            NativeCallerTools.SDKAPITransferMessage(str, CommonUtil.SHIX_SetGooglePush(cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd(), this.strUUID, this.fcmToken, ContentCommon.FCM_APP_KEY, cameraParamsBean.getDev_name()));
        } else if (Rom.isVivo()) {
            setVIVOPush(cameraParamsBean, cameraParamsBean.getSdkId());
        } else {
            setMiSubscribe(cameraParamsBean, cameraParamsBean.getSdkId());
        }
    }

    private void setVIVOPush(final CameraParamsBean cameraParamsBean, final int i2) {
        final String b2 = c.a(getActivity()).b();
        LogUtils.e("biniy", "VIVOPUSH-vivo.alias= " + cameraParamsBean.getDev_Did() + "---vivoPushRegId= " + b2);
        c.a(getActivity()).b(cameraParamsBean.getDev_Did(), new a() { // from class: c.h.a.a.f0
            @Override // c.j.a.a
            public final void onStateChanged(int i3) {
                FragmentCameraList.this.a(cameraParamsBean, b2, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfigWifiDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this.mContext);
        niftyDialogBuilder.withTitle(str2).withMessage(getString(R.string.ap_add_title2)).withEffect(effectstype).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraParamsBean cameraBean = FragmentCameraList.this.getCameraBean(str);
                String dev_Did = cameraBean.getDev_Did();
                cameraBean.getDev_name();
                NativeCallerTools.SDKAPITransferMessage(dev_Did, CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                Intent intent = new Intent(FragmentCameraList.this.mContext, (Class<?>) SettingWifiActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, cameraBean.getDev_Did());
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, cameraBean.getDev_name());
                FragmentCameraList.this.startActivity(intent);
                niftyDialogBuilder.dismiss();
            }
        }).show();
    }

    private void showDeleteCameraDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(getActivity());
        niftyDialogBuilder.withTitle(str2).withMessage(str + OSSUtils.NEW_LINE + getResources().getString(R.string.tips_msg_delete_camera)).withEffect(effectstype).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FragmentCameraList.this.delCamera(str);
                niftyDialogBuilder.dismiss();
            }
        }).show();
    }

    private void showLowPwdDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(getActivity());
        niftyDialogBuilder.withTitle(str2).withMessage(getString(R.string.pwd_edit_show1)).withEffect(effectstype).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraParamsBean cameraBean = FragmentCameraList.this.getCameraBean(str);
                String dev_Did = cameraBean.getDev_Did();
                String dev_name = cameraBean.getDev_name();
                String dev_User = cameraBean.getDev_User();
                String dev_Pwd = cameraBean.getDev_Pwd();
                SystemValue.doorBellAdmin = cameraBean.getDev_User();
                SystemValue.doorBellPass = cameraBean.getDev_Pwd();
                NativeCallerTools.SDKAPITransferMessage(dev_Did, CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                NativeCallerTools.SDKAPITransferMessage(dev_Did, CommonUtil.SHIX_Heat(cameraBean.getDev_User(), cameraBean.getDev_Pwd()));
                Intent intent = new Intent(FragmentCameraList.this.mContext, (Class<?>) NDNCameraLiveActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                intent.putExtra("uuid", FragmentCameraList.this.strUUID);
                intent.putExtra("modep", 1);
                FragmentCameraList.this.startActivityForResult(intent, 2);
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraParamsBean cameraBean = FragmentCameraList.this.getCameraBean(str);
                String dev_name = cameraBean.getDev_name();
                String dev_Did = cameraBean.getDev_Did();
                String dev_User = cameraBean.getDev_User();
                String dev_Pwd = cameraBean.getDev_Pwd();
                NativeCallerTools.SDKAPITransferMessage(dev_Did, CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                Intent intent = new Intent(FragmentCameraList.this.mContext, (Class<?>) PasswordSettingActivity.class);
                intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                FragmentCameraList.this.startActivity(intent);
                niftyDialogBuilder.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOss(final OSS oss, String str, final String str2, final int i2) {
        ListObjectsRequest listObjectsRequest = this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new ListObjectsRequest("lookcam") : new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
        listObjectsRequest.setPrefix(str);
        listObjectsRequest.setMaxKeys(999);
        LogUtils.e("biniy", "OSS---start  读取文件地址：" + listObjectsRequest.getPrefix());
        oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() { // from class: com.shix.shixipc.activity.FragmentCameraList.21
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(ListObjectsRequest listObjectsRequest2, ClientException clientException, ServiceException serviceException) {
                if (FragmentCameraList.this.mProgress != null && FragmentCameraList.this.mProgress.isShowing()) {
                    FragmentCameraList.this.mProgress.dismiss();
                }
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    LogUtils.e("biniy", "移动侦测-OSS " + serviceException.getErrorCode());
                    LogUtils.e("biniy", "移动侦测-OSS " + serviceException.getRequestId());
                    LogUtils.e("biniy", "移动侦测-OSS " + serviceException.getHostId());
                    LogUtils.e("biniy", "移动侦测-OSS " + serviceException.getRawMessage());
                }
                LogUtils.e("biniy", "移动侦测-OSS AyncListObjects", "OSS---end ");
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(ListObjectsRequest listObjectsRequest2, ListObjectsResult listObjectsResult) {
                ArrayList arrayList = new ArrayList();
                LogUtils.e("biniy", "OSS AyncListObjects-OSS Success!  size：" + listObjectsResult.getObjectSummaries().size());
                for (int i3 = 0; i3 < listObjectsResult.getObjectSummaries().size(); i3++) {
                    String key = listObjectsResult.getObjectSummaries().get(i3).getKey();
                    if (!TextUtils.isEmpty(key)) {
                        arrayList.add(key);
                    }
                }
                if (i2 == 3) {
                    FragmentCameraList.this.deletePics(oss, arrayList, str2, 3);
                } else if (arrayList.size() >= 999) {
                    FragmentCameraList.this.deletePics(oss, arrayList, str2, 1);
                }
                if (arrayList.size() < 999) {
                    FragmentCameraList.this.deletePics(oss, arrayList, str2, 2);
                }
            }
        }).waitUntilFinished();
    }

    private void updataXiaomiPush() {
        if (CommonUtil.isApModul(this.wifiName)) {
            return;
        }
        int count = this.listAdapter.getCount();
        final int i2 = 0;
        if (CrashApplication.getPushBrand() == 1) {
            List<String> k = l.k(this.mContext);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < count; i3++) {
                CameraParamsBean onItem = this.listAdapter.getOnItem(i3);
                arrayList.add(onItem.getDev_Did());
                if (isHave(onItem.getDev_Did(), k)) {
                    MyLogUtils.d("push", " 服务器上还有小米推送 ");
                } else {
                    MyLogUtils.d("push", " 绑定小米推送 uid= " + onItem.getDev_Did());
                    l.f(this.mContext, onItem.getDev_Did(), null);
                }
            }
            while (i2 < k.size()) {
                if (isHave(k.get(i2), arrayList)) {
                    MyLogUtils.d("push", " 本地设备列表还有该设备 ");
                } else {
                    l.g(this.mContext, k.get(i2), null);
                    MyLogUtils.d("push", "  注销小米推送  uid= " + k.get(i2));
                }
                i2++;
            }
            return;
        }
        if (CrashApplication.getPushBrand() == 2) {
            return;
        }
        if (CrashApplication.getPushBrand() != 3) {
            JPushInterface.getAllTags(getActivity(), 1);
            CrashApplication.getTags();
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < count; i4++) {
                CameraParamsBean onItem2 = this.listAdapter.getOnItem(i4);
                MyLogUtils.d("push", " 极光推送tags:" + onItem2.getDev_Did());
                hashSet.add(onItem2.getDev_Did());
            }
            if (hashSet.size() > 0) {
                JPushInterface.addTags(this.mContext, 0, hashSet);
                return;
            }
            return;
        }
        final List<String> c2 = c.a(this.mContext).c();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < count; i5++) {
            final CameraParamsBean onItem3 = this.listAdapter.getOnItem(i5);
            arrayList2.add(onItem3.getDev_Did());
            if (isHave(onItem3.getDev_Did(), c2)) {
                MyLogUtils.d("push", " 服务器上还有vivo推送 ");
            } else {
                MyLogUtils.d("push", " 绑定vivo推送 uid= " + onItem3.getDev_Did());
                c.a(this.mContext).b(onItem3.getDev_Did(), new a() { // from class: com.shix.shixipc.activity.FragmentCameraList.18
                    @Override // c.j.a.a
                    public void onStateChanged(int i6) {
                        if (i6 != 0) {
                            MyLogUtils.d("push", " vivo推送setTopic: 失败");
                            return;
                        }
                        MyLogUtils.d("push", " vivo推送setTopic:" + onItem3.getDev_Did());
                    }
                });
            }
        }
        while (i2 < c2.size()) {
            if (isHave(c2.get(i2), arrayList2)) {
                MyLogUtils.d("push", " 本地设备列表还有vivo该设备 ");
            } else {
                c.a(this.mContext).a(c2.get(i2), new a() { // from class: com.shix.shixipc.activity.FragmentCameraList.19
                    @Override // c.j.a.a
                    public void onStateChanged(int i6) {
                        if (i6 == 0) {
                            MyLogUtils.d("push", " vivo推送解绑:" + ((String) c2.get(i2)));
                            return;
                        }
                        MyLogUtils.d("push", " vivo推送解绑:" + ((String) c2.get(i2)) + " 失败");
                    }
                });
            }
            i2++;
        }
    }

    @Override // com.shix.shixipc.activity.AddCameraActivity.DeleInterface
    public void CallBackDel(String str, String str2) {
        CommonUtil.Log(1, "zhaogenghuai CallBackDel:" + str);
        CameraParamsBean cameraBean = getCameraBean(str);
        if (cameraBean != null && cameraBean.getDev_p2pstatus() == 2) {
            CommonUtil.SHIX_Delpush(cameraBean.getDev_User(), cameraBean.getDev_Pwd(), this.strUUID);
        }
        showDeleteCameraDialog(str, Effectstype.Slidetop, str2);
    }

    @Override // com.shix.shixipc.activity.SettingActivity.DelCameraInterface
    public void CallBackDelCamera(String str) {
        delCamera(str);
    }

    @Override // com.shix.shixipc.activity.SettingActivity.DeleDetInterface
    public void CallBackDelSet(String str, String str2) {
        CommonUtil.Log(1, "zhaogenghuai CallBackDel:" + str);
        showDeleteCameraDialog(str, Effectstype.Slidetop, str2);
    }

    public /* synthetic */ void a(InputDialogBuilder inputDialogBuilder, CameraParamsBean cameraParamsBean, View view, String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtils.showLong(getResources().getString(R.string.tips_c));
        } else {
            inputDialogBuilder.dismiss();
            done(cameraParamsBean.getDev_name(), cameraParamsBean.getDev_User(), str, cameraParamsBean.getDev_Did());
        }
    }

    public boolean isCanUse(int i2, String str) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && GpsUtil.isOPen(this.mContext)) {
            if (this.locListener == null) {
                this.locListener = new LocListener();
            }
            if (CommonUtil.isApModul(getWifiSSID())) {
                this.locationAddress = SharedPreferencesUtils.getInstance().getString(HttpHeaders.LOCATION);
            } else {
                requestLatitudeAndLongtitude(this.mContext, this.locListener);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAdd /* 2131230862 */:
            case R.id.imbtn_add /* 2131231101 */:
                startActivity(new Intent(getActivity(), (Class<?>) AddShowActivity.class));
                break;
            case R.id.ib_camera_four /* 2131231062 */:
                startActivity(new Intent(getActivity(), (Class<?>) FourCameraActivity.class));
                break;
            case R.id.ib_item_switch /* 2131231064 */:
                if (this.listAdapter != null) {
                    if (this.isShowAllDevice) {
                        this.firstFraGrid.setLayoutManager(new MyLinearLayoutManager(getActivity()));
                        this.listAdapter.setType(1);
                        this.isShowAllDevice = false;
                    } else {
                        this.firstFraGrid.setLayoutManager(new MyLinearLayoutManager(getActivity()));
                        this.listAdapter.setType(0);
                        this.isShowAllDevice = true;
                    }
                    SharedPreferencesUtils.getInstance().putBoolean("isShowAllDevice", this.isShowAllDevice);
                    this.firstFraGrid.setAdapter(this.listAdapter);
                    break;
                }
                break;
            case R.id.ib_search_wifi /* 2131231065 */:
                Intent intent = new Intent(getActivity(), (Class<?>) SearchActivity.class);
                intent.putExtra("sType", 110);
                startActivity(intent);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cameralist, viewGroup, false);
        this.ibCameraFour = (ImageButton) inflate.findViewById(R.id.ib_camera_four);
        this.ibItemSwitch = (ImageButton) inflate.findViewById(R.id.ib_item_switch);
        this.ibSearchWifi = (ImageButton) inflate.findViewById(R.id.ib_search_wifi);
        this.ibCameraFour.setOnClickListener(this);
        this.ibItemSwitch.setOnClickListener(this);
        this.ibSearchWifi.setOnClickListener(this);
        this.buttonAdd = (LinearLayout) inflate.findViewById(R.id.buttonAdd);
        this.layoutAdd = (LinearLayout) inflate.findViewById(R.id.layoutAdd);
        this.firstFraGrid = (RecyclerView) inflate.findViewById(R.id.first_fra_grid);
        this.imbtn_add = (ImageButton) inflate.findViewById(R.id.imbtn_add);
        this.refreshCamera = (SwipeRefreshLayout) inflate.findViewById(R.id.refreshCamera);
        this.device_count = (TextView) inflate.findViewById(R.id.device_count);
        this.wifiName = getWifiSSID();
        this.getDataTask = new GetDataTask();
        ContentCommon.SHIX_getDevs();
        LogUtils.e("biniy", "clist-1");
        if (!CommonUtil.isNotificationEnabled(this.mContext)) {
            final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this.mContext);
            niftyDialogBuilder.withMessage(R.string.tip_tzqx).withTitle(this.mContext.getString(R.string.tip_reminder)).withButton1Text(this.mContext.getString(R.string.str_cancel)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    niftyDialogBuilder.dismiss();
                }
            }).withButton2Text(this.mContext.getString(R.string.str_ok)).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CommonUtil.requestNotify(FragmentCameraList.this.mContext);
                    niftyDialogBuilder.dismiss();
                }
            }).show();
        }
        this.isShowAllDevice = SharedPreferencesUtils.getInstance().getBoolean("isShowAllDevice", true);
        LogUtils.e("biniy", "clist-11");
        if (GpsUtil.isOPen(this.mContext)) {
            if (this.locListener == null) {
                this.locListener = new LocListener();
            }
            if (CommonUtil.isApModul(this.wifiName)) {
                this.locationAddress = SharedPreferencesUtils.getInstance().getString(HttpHeaders.LOCATION);
            } else {
                requestLatitudeAndLongtitude(this.mContext, this.locListener);
            }
        } else {
            final NiftyDialogBuilder niftyDialogBuilder2 = NiftyDialogBuilder.getInstance(this.mContext);
            niftyDialogBuilder2.withMessage(R.string.tip_gps).withTitle(getResources().getString(R.string.tip_reminder)).withButton1Text(getResources().getString(R.string.str_cancel)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    niftyDialogBuilder2.dismiss();
                }
            }).withButton2Text(getResources().getString(R.string.str_ok)).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraList.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FragmentCameraList.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
                    niftyDialogBuilder2.dismiss();
                }
            }).show();
        }
        LogUtils.e("biniy", "clist-12");
        NUIMainActivity.setConnectStatusInterface1(new NUIMainActivity.ConnectStatusInterface1() { // from class: com.shix.shixipc.activity.FragmentCameraList.5
            @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
            public void BSCallBack_TYPEMODE(String str, String str2) {
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
            public void BSMsgNotifyData(String str, int i2, int i3) {
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.ConnectStatusInterface1
            public void ConnectStatus(int i2, int i3, int i4) {
                Bundle bundle2 = new Bundle();
                MyLogUtils.d("SHIXTRANS", "param=" + i4 + "  did=" + FragmentCameraList.this.did);
                Message obtainMessage = FragmentCameraList.this.PPPPMsgHandler.obtainMessage();
                obtainMessage.what = i3;
                bundle2.putInt(FragmentCameraList.STR_MSG_PARAM, i4);
                bundle2.putString(FragmentCameraList.STR_DID, DeviceUtil.INSTANCE.getDid(i2));
                obtainMessage.setData(bundle2);
                FragmentCameraList.this.PPPPMsgHandler.sendMessage(obtainMessage);
            }
        });
        LogUtils.e("biniy", "clist-13");
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shix_zhao_user", 0);
        this.preuser = sharedPreferences;
        this.gltag = sharedPreferences.getInt("gltag", 0);
        ContentCommon.AP_ADD_UID = "";
        String string = this.preuser.getString("SHIXUUID", "");
        this.strUUID = string;
        if (string == null || string.length() < 2) {
            this.strUUID = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putString("SHIXUUID", this.strUUID);
            edit.commit();
            SpUtil.INSTANCE.encode("SHIXUUID", this.strUUID);
        }
        LogUtils.e("biniy", "clist-14");
        contextL = getContext();
        SettingActivity.setDeleDetInterface(this);
        SettingActivity.setDelCameraInterface(this);
        this.imbtn_add.setOnClickListener(this);
        this.buttonAdd.setOnClickListener(this);
        initAdapter();
        NewUiMainInterface newUiMainInterface2 = newUiMainInterface;
        if (newUiMainInterface2 != null) {
            newUiMainInterface2.CallBackStyle(this.gltag);
        }
        LogUtils.e("biniy", "clist-15");
        this.refreshCamera.setColorSchemeResources(R.color.color_main);
        this.refreshCamera.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.shix.shixipc.activity.FragmentCameraList.6
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public void onRefresh() {
                if (!CommonUtil.isApModul(FragmentCameraList.this.getWifiSSID())) {
                    FragmentCameraList.this.getDataTask.StopCameraPPPP();
                } else if (FragmentCameraList.this.refreshCamera.d()) {
                    FragmentCameraList.this.refreshCamera.setRefreshing(false);
                }
            }
        });
        LogUtils.e("biniy", "clist-16");
        this.fcmToken = SharedPreferencesUtils.getInstance().getString("FcmToken", "");
        LogUtils.e("biniy", "clist-17");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SystemValue.TAG_CAMERLIST = 0;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.oldStatus == z || z) {
            return;
        }
        LogUtils.e("biniy", "clist-5");
        initData();
        this.oldStatus = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtils.e("biniy", "clist-2");
        NUIMainActivity.setSHIXCOMMONInterface(new NUIMainActivity.SHIXCOMMONInterface() { // from class: com.shix.shixipc.activity.FragmentCameraList.7
            @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
            public void CallBackSHIXJasonCommon(String str, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int i2 = jSONObject.getInt("cmd");
                    if (i2 == 121) {
                        LogUtils.e("biniy", "121-1-> jason= " + str2 + "---jason.length= " + str2.length());
                        FragmentCameraList.this.mModel = DeviceOffTimeModel.jsonToModel(str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("121-1-> mModel.getTimedOffTime()= ");
                        sb.append(FragmentCameraList.this.mModel.getTimedOffTime());
                        LogUtils.e("biniy", sb.toString());
                        if (TextUtils.isEmpty(str2) || str2.length() <= 23) {
                            int i3 = jSONObject.getInt("result");
                            LogUtils.e("biniy", "121-> result= " + i3);
                            if (i3 == 0) {
                                FragmentCameraList.this.mHandler.sendEmptyMessage(11);
                            } else {
                                FragmentCameraList.this.isResetTimedOffTime = false;
                            }
                        } else {
                            FragmentCameraList.this.mHandler.sendEmptyMessage(1);
                        }
                    }
                    if (i2 == 199) {
                        FragmentCameraList.this.videoRecordModel = VideoRecordModel.jsonToModel(str2);
                        FragmentCameraList.this.mHashMap.put(str, FragmentCameraList.this.videoRecordModel.getVideoRecord() + "");
                        MyLogUtils.d("tag", " videoRecordModel.getVideoRecord()=" + FragmentCameraList.this.videoRecordModel.getVideoRecord());
                    }
                    if (i2 == 125) {
                        FragmentCameraList.this.dateModel = DateModel.jsonToModel(str2);
                        FragmentCameraList.this.mHandler.sendEmptyMessage(3);
                        MyLogUtils.d("tag", " 时区同步2");
                    }
                    if (i2 == 133) {
                        MyLogUtils.d("tag", " get_support" + str2);
                        jSONObject.optInt("push_msg_xiaomi_en");
                        jSONObject.optInt("push_msg_huawei_en");
                        jSONObject.optInt("push_msg_oppo_en");
                        jSONObject.optInt("push_msg_vivo_en");
                        jSONObject.optInt("push_msg_jg_en");
                        CameraParamsBean cameraInfo = FragmentCameraList.this.listAdapter.getCameraInfo(str);
                        if (cameraInfo != null) {
                            FragmentCameraList.this.setPushConfig(str, cameraInfo);
                        }
                    }
                    if (i2 == 100) {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.has("restrict")) {
                            FragmentCameraList.this.restrict = jSONObject2.getInt("restrict");
                            SharedPreferencesUtils.getInstance().putInt(str + "restrict", FragmentCameraList.this.restrict);
                            MyLogUtils.d("tag", " 定位 存入的restrict=" + FragmentCameraList.this.restrict);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        if (!isHidden()) {
            initData();
        }
        LogUtils.e("biniy", "clist-4");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @SuppressLint({"MissingPermission"})
    public void requestLatitudeAndLongtitude(Context context, LocListener locListener) {
        List<String> providers;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setPowerRequirement(1);
            criteria.setAltitudeRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setCostAllowed(false);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            MyLogUtils.d("FragmentCameraList", "locationProvider:" + bestProvider);
            if (bestProvider == null && (providers = locationManager.getProviders(true)) != null && providers.size() > 0) {
                bestProvider = providers.get(0);
            }
            String str = bestProvider;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Location myLastKnownLocation = getMyLastKnownLocation();
            MyLogUtils.d("FragmentCameraList", "location:" + myLastKnownLocation);
            if (myLastKnownLocation != null) {
                locListener.onLocationChanged(myLastKnownLocation);
                return;
            }
            locationManager.requestLocationUpdates(str, 500L, 1000.0f, locListener);
            this.locationAddress = SharedPreferencesUtils.getInstance().getString(HttpHeaders.LOCATION);
            MyLogUtils.d("FragmentCameraList", "locationAddress:" + this.locationAddress);
        } catch (Exception unused) {
        }
    }

    public void showLong(int i2) {
        CameraParamsBean itemCamera = this.listAdapter.getItemCamera(i2);
        if (itemCamera != null) {
            if (isCanUse(SharedPreferencesUtils.getInstance().getInt(itemCamera.getDev_Did() + "restrict", 0), itemCamera.getDev_Did())) {
                Intent intent = new Intent(this.mContext, (Class<?>) AddCameraActivity.class);
                AddCameraActivity.setDeleInterface(this);
                intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
                intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
                intent.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
                startActivity(intent);
            }
        }
    }

    public void showSetValue(int i2) {
        CameraParamsBean itemCamera = this.listAdapter.getItemCamera(i2);
        if (itemCamera == null) {
            return;
        }
        SystemValue.position = i2;
        SystemValue.doorBellAdmin = itemCamera.getDev_User();
        SystemValue.doorBellPass = itemCamera.getDev_Pwd();
        NativeCallerTools.SDKAPITransferMessage(itemCamera.getDev_Did(), CommonUtil.getDataFromDevice("get_light_param", 121, itemCamera.getDev_User(), itemCamera.getDev_Pwd()));
    }

    @Override // com.shix.shixipc.BaseFragment
    public void showSetting(int i2, int i3) {
        final CameraParamsBean itemCamera = this.listAdapter.getItemCamera(i2);
        if (isCanUse(SharedPreferencesUtils.getInstance().getInt(itemCamera.getDev_Did() + "restrict", 0), itemCamera.getDev_Did())) {
            int dev_p2pstatus = itemCamera.getDev_p2pstatus();
            SystemValue.position = i2;
            SystemValue.doorBellAdmin = itemCamera.getDev_User();
            SystemValue.doorBellPass = itemCamera.getDev_Pwd();
            Intent intent = new Intent();
            switch (i3) {
                case R.id.imgBtnPPPPSetting /* 2131231103 */:
                    CommonUtil.Log(1, "zhaogenghuai 5");
                    intent.setClass(this.mContext, SettingActivity.class);
                    break;
                case R.id.ivState /* 2131231129 */:
                    if (!isPrivacyMode("" + this.preuser.getInt(itemCamera.getDev_Did(), 0))) {
                        intent.setClass(this.mContext, ClouDateActivity.class);
                        break;
                    } else {
                        return;
                    }
                case R.id.llPic /* 2131231157 */:
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ShowPicActivity.class);
                    intent2.putExtra("DEV_DID", itemCamera.getDev_Did());
                    intent2.putExtra("DEV_NAME", itemCamera.getDev_name());
                    startActivity(intent2);
                    return;
                case R.id.llSdCard /* 2131231159 */:
                    if (isCanUse(SharedPreferencesUtils.getInstance().getInt(itemCamera.getDev_Did() + "restrict", 0), itemCamera.getDev_Did())) {
                        if (isPrivacyMode("" + this.preuser.getInt(itemCamera.getDev_Did(), 0))) {
                            return;
                        }
                        SystemValue.doorBellAdmin = itemCamera.getDev_User();
                        SystemValue.doorBellPass = itemCamera.getDev_Pwd();
                        Intent intent3 = new Intent(this.mContext, (Class<?>) PlayBackTFActivity.class);
                        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
                        intent3.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
                        intent3.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
                        if (dev_p2pstatus == 2) {
                            startActivity(intent3);
                            return;
                        } else {
                            showToast(getString(R.string.device_not_on_line));
                            return;
                        }
                    }
                    return;
                case R.id.llSetting /* 2131231160 */:
                    intent.setClass(this.mContext, SettingActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
                    intent.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
                    intent.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
                    startActivity(intent);
                    return;
                case R.id.llVideo /* 2131231161 */:
                    Intent intent4 = new Intent(getActivity(), (Class<?>) ShowVideoActivity.class);
                    intent4.putExtra("DEV_DID", itemCamera.getDev_Did());
                    intent4.putExtra("DEV_NAME", itemCamera.getDev_name());
                    startActivity(intent4);
                    return;
                case R.id.rl_item_root /* 2131231371 */:
                    if (itemCamera == null) {
                        return;
                    }
                    if (isCanUse(SharedPreferencesUtils.getInstance().getInt(itemCamera.getDev_Did() + "restrict", 0), itemCamera.getDev_Did())) {
                        if (isPrivacyMode("" + this.preuser.getInt(itemCamera.getDev_Did(), 0))) {
                            return;
                        }
                        if (dev_p2pstatus == 5 || dev_p2pstatus == 7 || dev_p2pstatus == 6 || dev_p2pstatus == 3 || dev_p2pstatus == 4 || dev_p2pstatus == -1 || dev_p2pstatus == 0) {
                            String dev_Did = itemCamera.getDev_Did();
                            itemCamera.getDev_User();
                            itemCamera.getDev_Pwd();
                            DeviceUtil.INSTANCE.StopPPPP(dev_Did);
                            DeviceUtil.INSTANCE.StartPPPP(itemCamera.getDev_Did(), itemCamera.getDev_User(), itemCamera.getDev_Pwd());
                            return;
                        }
                        if (dev_p2pstatus == 8) {
                            final InputDialogBuilder inputDialogBuilder = InputDialogBuilder.getInstance(getActivity());
                            inputDialogBuilder.withButton1Text(getString(R.string.my_setup_cancel)).withButton2Text(getString(R.string.my_setup_sure)).setButton2Click(new InputDialogBuilder.MsgCallback() { // from class: c.h.a.a.g0
                                @Override // com.shix.shixipc.view.InputDialogBuilder.MsgCallback
                                public final void onMsgCallback(View view, String str) {
                                    FragmentCameraList.this.a(inputDialogBuilder, itemCamera, view, str);
                                }
                            }).setButton1Click(new View.OnClickListener() { // from class: c.h.a.a.e0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    InputDialogBuilder.this.dismiss();
                                }
                            }).show();
                            return;
                        }
                        if (dev_p2pstatus == 2 && !checkChina(itemCamera.getDev_Did(), itemCamera.getResetrict())) {
                            String dev_Did2 = itemCamera.getDev_Did();
                            String dev_name = itemCamera.getDev_name();
                            String dev_User = itemCamera.getDev_User();
                            String dev_Pwd = itemCamera.getDev_Pwd();
                            SystemValue.doorBellAdmin = itemCamera.getDev_User();
                            SystemValue.doorBellPass = itemCamera.getDev_Pwd();
                            NativeCallerTools.SDKAPITransferMessage(SpUtil.INSTANCE.queryKey(itemCamera.getDev_Did()).booleanValue() ? SpUtil.INSTANCE.decodeInt(itemCamera.getDev_Did()).intValue() : -1, CommonUtil.SHIX_Heat(itemCamera.getDev_User(), itemCamera.getDev_Pwd()));
                            intent.setClass(this.mContext, NDNCameraLiveActivity.class);
                            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                            intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                            intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did2);
                            intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                            intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                            intent.putExtra("uuid", this.strUUID);
                            intent.putExtra("modep", 1);
                            startActivityForResult(intent, 2);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
            }
            intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
            intent.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
            if (dev_p2pstatus == 2) {
                startActivity(intent);
            } else {
                showToast(this.mContext.getString(R.string.device_not_on_line));
            }
        }
    }

    public /* synthetic */ void a(CameraParamsBean cameraParamsBean, String str, int i2, int i3) {
        LogUtils.e("biniy", "VIVOPUSH-setVIVOPush-setTopic -did= " + cameraParamsBean.getDev_Did() + "--- Topic= " + c.a(getActivity()).c() + "--- i= " + i3);
        String SHIX_SetVIVOPush = CommonUtil.SHIX_SetVIVOPush(cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd(), cameraParamsBean.getDev_name(), cameraParamsBean.getDev_Did(), str);
        StringBuilder sb = new StringBuilder();
        sb.append("VIVOPUSH-setVIVOPush-json = ");
        sb.append(SHIX_SetVIVOPush);
        LogUtils.e("biniy", sb.toString());
        NativeCallerTools.SDKAPITransferMessage(i2, SHIX_SetVIVOPush);
    }
}
