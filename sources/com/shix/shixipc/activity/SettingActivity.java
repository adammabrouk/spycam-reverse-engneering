package com.shix.shixipc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.zxing.WriterException;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.activity.SettingActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    public static DelCameraInterface delCameraInterface;
    public static DeleDetInterface deleInterface;
    public Bitmap bitmap;
    public Bitmap bitmap1;
    public Button btnBack;
    public Button btnDelCamera;
    public LinearLayout buttonAler;
    public LinearLayout buttonDevice;
    public LinearLayout buttonEdit;
    public LinearLayout buttonOther;
    public Button buttonReboot;
    public LinearLayout buttonSd;
    public LinearLayout buttonTime;
    public LinearLayout buttonUser;
    public LinearLayout buttonWifi;
    public String cameraName;
    public String currVersion;
    public ImageView img_er;
    public LinearLayout llSettingReboot;
    public LinearLayout llSettingReset;
    public LinearLayout mSettingPsd;
    public int net;
    public String newVersion;
    public int ptz;
    public int smd;
    public int status;
    public String strDID;
    public String strPwd;
    public String strUser;
    public TextView textViewVersion;
    public TextView tvCameraName;
    public int upgrade_signal;
    public final int WIFI = 0;
    public final int USER = 1;
    public final int ALERM = 2;
    public final int DATETIME = 3;
    public final int MAIL = 4;
    public final int FTP = 5;
    public final int SDCard = 6;
    public MyBackBrod myBackBrod = null;
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.SettingActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                SharedPreferencesUtils.getInstance().putInt("isSmd", SettingActivity.this.smd);
                return;
            }
            if (i2 == 2) {
                return;
            }
            if (i2 == 3) {
                SettingActivity.this.buttonWifi.setVisibility(8);
                return;
            }
            if (i2 == 101) {
                try {
                    CameraParmsModel jsonToModel = CameraParmsModel.jsonToModel((String) message.obj);
                    if (jsonToModel != null) {
                        SettingActivity.this.textViewVersion.setText(jsonToModel.getAppver());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    };
    public final int REQUEST_CHOOSEFILE = 110;

    public interface DelCameraInterface {
        void CallBackDelCamera(String str);
    }

    public interface DeleDetInterface {
        void CallBackDelSet(String str, String str2);
    }

    public class MyBackBrod extends BroadcastReceiver {
        public MyBackBrod() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("myback".equals(intent.getAction())) {
                SettingActivity.this.finish();
            }
        }
    }

    private void delCamera(final String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        niftyDialogBuilder.withMessage(str2 + OSSUtils.NEW_LINE + getResources().getString(R.string.tips_msg_delete_camera)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: c.h.a.a.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.a(str, niftyDialogBuilder, view);
            }
        }).show();
    }

    private void findView() {
        this.textViewVersion = (TextView) findViewById(R.id.textViewVersion);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.btnBack = (Button) findViewById(R.id.back);
        this.buttonAler = (LinearLayout) findViewById(R.id.setting_alerm);
        this.buttonUser = (LinearLayout) findViewById(R.id.setting_use);
        this.buttonSd = (LinearLayout) findViewById(R.id.setting_sdcard);
        this.buttonOther = (LinearLayout) findViewById(R.id.setting_other);
        this.buttonDevice = (LinearLayout) findViewById(R.id.setting_device);
        this.buttonTime = (LinearLayout) findViewById(R.id.setting_time);
        this.buttonReboot = (Button) findViewById(R.id.setting_reboot);
        this.btnDelCamera = (Button) findViewById(R.id.btn_setting_del_camera);
        this.buttonEdit = (LinearLayout) findViewById(R.id.setting_device_edit);
        this.buttonWifi = (LinearLayout) findViewById(R.id.setting_wifi);
        this.mSettingPsd = (LinearLayout) findViewById(R.id.setting_psd);
        this.llSettingReboot = (LinearLayout) findViewById(R.id.ll_setting_reboot);
        this.llSettingReset = (LinearLayout) findViewById(R.id.ll_setting_reset);
        this.buttonEdit.setOnClickListener(this);
        this.buttonReboot.setOnClickListener(this);
        this.btnDelCamera.setOnClickListener(this);
        this.buttonWifi.setOnClickListener(this);
        this.buttonUser.setOnClickListener(this);
        this.buttonTime.setOnClickListener(this);
        this.buttonAler.setOnClickListener(this);
        this.buttonSd.setOnClickListener(this);
        this.buttonOther.setOnClickListener(this);
        this.buttonDevice.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        this.mSettingPsd.setOnClickListener(this);
        this.llSettingReboot.setOnClickListener(this);
        this.llSettingReset.setOnClickListener(this);
        findViewById(R.id.setting_reset).setOnClickListener(this);
        ((TextView) findViewById(R.id.textViewDID)).setText(this.strDID);
        findViewById(R.id.delbtn).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingActivity.this, 10L);
                }
                if (SettingActivity.deleInterface != null) {
                    SettingActivity.deleInterface.CallBackDelSet(SettingActivity.this.strDID, SettingActivity.this.cameraName);
                }
                SettingActivity.this.finish();
            }
        });
    }

    private CameraParamsBean getCameraBean(String str) {
        int size = SystemValue.arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i2;
                return cameraParamsBean;
            }
        }
        return null;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
        try {
            if (query.getCount() == 1 && query.moveToFirst()) {
                str = query.getString(query.getColumnIndexOrThrow("_data"));
            }
            return str;
        } finally {
            query.close();
        }
    }

    private int getPPPPStatus(String str) {
        int size = SystemValue.arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                return cameraParamsBean.getDev_p2pstatus();
            }
        }
        return 0;
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Uri savePicToSDcard(Bitmap bitmap) {
        Uri uri;
        Uri uri2;
        String strDate = getStrDate();
        FileOutputStream fileOutputStream = null;
        uri2 = null;
        uri2 = null;
        uri2 = null;
        fileOutputStream = null;
        try {
            try {
                File file = new File(FileUtil.getRootDir(), "LDDDD/pic");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, strDate + ".jpg"));
                try {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream2)) {
                        fileOutputStream2.flush();
                    }
                    String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "", "");
                    MyLogUtils.d(ContentCommon.SERVER_STRING, "zhaogenghuai savepath:" + insertImage);
                    if (insertImage != null && insertImage.length() > 0) {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        uri2 = Uri.fromFile(new File(getFilePathByContentResolver(this, Uri.parse(insertImage))));
                        intent.setData(uri2);
                        sendBroadcast(intent);
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    Uri uri3 = uri2;
                    fileOutputStream = fileOutputStream2;
                    uri = uri3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    uri2 = uri;
                    return uri2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            uri = null;
        }
        return uri2;
    }

    public static void setDelCameraInterface(DelCameraInterface delCameraInterface2) {
        delCameraInterface = delCameraInterface2;
    }

    public static void setDeleDetInterface(DeleDetInterface deleDetInterface) {
        deleInterface = deleDetInterface;
    }

    public /* synthetic */ void a(String str, NiftyDialogBuilder niftyDialogBuilder, View view) {
        DelCameraInterface delCameraInterface2 = delCameraInterface;
        if (delCameraInterface2 != null) {
            delCameraInterface2.CallBackDelCamera(str);
        }
        niftyDialogBuilder.dismiss();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10L);
        }
        if (view.getId() != R.id.back && view.getId() != R.id.btn_setting_del_camera && getPPPPStatus(this.strDID) != 2) {
            showToast(R.string.device_not_on_line);
        }
        int id = view.getId();
        if (id == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            return;
        }
        if (id == R.id.btn_setting_del_camera) {
            delCamera(this.strDID, this.cameraName);
            return;
        }
        switch (id) {
            case R.id.ll_setting_reboot /* 2131231181 */:
                showSureReboot();
                break;
            case R.id.ll_setting_reset /* 2131231182 */:
                showSureReSet();
                break;
            default:
                switch (id) {
                    case R.id.setting_alerm /* 2131231429 */:
                        Intent intent = new Intent(this, (Class<?>) SettingAlarmActivity.class);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent);
                        break;
                    case R.id.setting_device /* 2131231430 */:
                        Intent intent2 = new Intent(this, (Class<?>) SettingDeviceActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        intent2.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                        intent2.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                        intent2.putExtra("status", this.status);
                        intent2.putExtra("upgrade_signal", this.upgrade_signal);
                        intent2.putExtra("currVersion", this.currVersion);
                        intent2.putExtra("newVersion", this.newVersion);
                        startActivity(intent2);
                        break;
                    case R.id.setting_device_edit /* 2131231431 */:
                        Intent intent3 = new Intent(this, (Class<?>) AddCameraActivity.class);
                        intent3.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent3.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                        intent3.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                        startActivity(intent3);
                        break;
                    case R.id.setting_other /* 2131231432 */:
                        Intent intent4 = new Intent(this, (Class<?>) SettingOtherActivity.class);
                        intent4.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent4.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent4);
                        break;
                    case R.id.setting_psd /* 2131231433 */:
                        Intent intent5 = new Intent(this, (Class<?>) SetHotSpotActivity.class);
                        intent5.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent5.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        intent5.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                        intent5.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                        startActivity(intent5);
                        break;
                    case R.id.setting_reboot /* 2131231434 */:
                        showSureReboot();
                        break;
                    case R.id.setting_reset /* 2131231435 */:
                        showSureReSet();
                        break;
                    case R.id.setting_sdcard /* 2131231436 */:
                        Intent intent6 = new Intent(this, (Class<?>) SettingSDCardActivity.class);
                        intent6.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent6.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent6);
                        break;
                    case R.id.setting_time /* 2131231437 */:
                        Intent intent7 = new Intent(this, (Class<?>) SettingDateActivity.class);
                        intent7.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent7.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent7);
                        break;
                    default:
                        switch (id) {
                            case R.id.setting_use /* 2131231439 */:
                                Intent intent8 = new Intent(this, (Class<?>) PasswordSettingActivity.class);
                                intent8.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                                intent8.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                                startActivity(intent8);
                                break;
                            case R.id.setting_wifi /* 2131231440 */:
                                Intent intent9 = new Intent(this, (Class<?>) SettingWifiActivity.class);
                                intent9.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                                intent9.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                                intent9.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                                intent9.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                                startActivity(intent9);
                                break;
                        }
                }
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        setContentView(R.layout.setting);
        findView();
        this.tvCameraName.setText(this.cameraName);
        try {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        } catch (Exception unused) {
        }
        NUIMainActivity.setSHIXCOMMONInterface(new NUIMainActivity.SHIXCOMMONInterface() { // from class: com.shix.shixipc.activity.SettingActivity.6
            @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
            public void CallBackSHIXJasonCommon(String str, String str2) {
                if (TextUtils.isEmpty(SettingActivity.this.strDID) || !str.equals(SettingActivity.this.strDID.replace("-", ""))) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int i2 = jSONObject.getInt("cmd");
                    if (i2 != 133) {
                        if (i2 != 101 || SettingActivity.this.mHandler == null) {
                            return;
                        }
                        Message message = new Message();
                        message.obj = str2;
                        message.what = 101;
                        SettingActivity.this.mHandler.sendMessage(message);
                        return;
                    }
                    SettingActivity.this.ptz = jSONObject.getInt("ptz");
                    SettingActivity.this.smd = jSONObject.getInt("smd");
                    if (SettingActivity.this.mHandler != null) {
                        SettingActivity.this.mHandler.sendEmptyMessage(1);
                    }
                    if (SettingActivity.this.ptz != 1) {
                        int unused2 = SettingActivity.this.ptz;
                    } else if (SettingActivity.this.mHandler != null) {
                        SettingActivity.this.mHandler.sendEmptyMessageDelayed(2, 200L);
                    }
                    SettingActivity.this.net = jSONObject.getInt("4g_net");
                    if (SettingActivity.this.net != 1 || SettingActivity.this.mHandler == null) {
                        return;
                    }
                    SettingActivity.this.mHandler.sendEmptyMessage(3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        new Thread(new Runnable() { // from class: com.shix.shixipc.activity.SettingActivity.7
            @Override // java.lang.Runnable
            public void run() {
                NativeCallerTools.SDKAPITransferMessage(SettingActivity.this.strDID, CommonUtil.getDeviceSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                NativeCallerTools.SDKAPITransferMessage(SettingActivity.this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
            }
        }).start();
        try {
            this.bitmap = Create2DCode(this.strDID);
        } catch (WriterException e2) {
            e2.printStackTrace();
        }
        if (this.bitmap != null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.qh_trans);
            int width = this.bitmap.getWidth();
            int height = this.bitmap.getHeight();
            int width2 = decodeResource.getWidth();
            int height2 = decodeResource.getHeight();
            float f2 = ((width * 1.0f) / 7.0f) / width2;
            this.bitmap1 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(this.bitmap1);
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f2, f2, width / 2, height / 2);
                canvas.drawBitmap(decodeResource, (width - width2) / 2, (height - height2) / 2, (Paint) null);
                canvas.save();
                canvas.restore();
            } catch (Exception e3) {
                this.bitmap = null;
                e3.getStackTrace();
            }
            ImageView imageView = (ImageView) findViewById(R.id.img_er);
            this.img_er = imageView;
            imageView.setImageBitmap(this.bitmap1);
        }
        findViewById(R.id.img_er).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingActivity.this, 10L);
                }
                View rootView = view.getRootView();
                rootView.setDrawingCacheEnabled(true);
                rootView.buildDrawingCache();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                CommonUtil.Log(1, "zhaogenghuai1");
                SettingActivity settingActivity = SettingActivity.this;
                Uri savePicToSDcard = settingActivity.savePicToSDcard(settingActivity.bitmap1);
                CommonUtil.Log(1, "zhaogenghuai2");
                intent.putExtra("android.intent.extra.STREAM", savePicToSDcard);
                CommonUtil.Log(1, "zhaogenghuai3");
                SettingActivity settingActivity2 = SettingActivity.this;
                settingActivity2.startActivity(Intent.createChooser(intent, settingActivity2.getResources().getString(R.string.send_title)));
                CommonUtil.Log(1, "zhaogenghuai4");
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        NUIMainActivity.setSHIXCOMMONInterface(null);
        StopHeat();
        MyBackBrod myBackBrod = this.myBackBrod;
        if (myBackBrod != null) {
            unregisterReceiver(myBackBrod);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.myBackBrod == null) {
            this.myBackBrod = new MyBackBrod();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("myback");
            registerReceiver(this.myBackBrod, intentFilter);
        }
    }

    public void shareImage(Bitmap bitmap) {
        try {
            Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, (String) null, (String) null));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", parse);
            intent.setType("image/*");
            getPackageManager().queryIntentActivities(intent, 32);
        } catch (Exception unused) {
        }
    }

    public void showSureReSet() {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        niftyDialogBuilder.withMessage(getString(R.string.reset_show)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.SettingActivity.4.1
                    @Override // android.os.AsyncTask
                    public void onPreExecute() {
                        super.onPreExecute();
                        NativeCallerTools.SDKAPITransferMessage(SettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reset", 1));
                    }

                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        try {
                            Thread.sleep(1000L);
                            return null;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(Void r3) {
                        super.onPostExecute((AnonymousClass1) r3);
                        CameraParamsBean SHIX_getDevs = ContentCommon.SHIX_getDevs(SettingActivity.this.strDID.replace("-", "").trim());
                        SHIX_getDevs.setDev_Did(SHIX_getDevs.getDev_Did());
                        SHIX_getDevs.setDev_name("Camera");
                        SHIX_getDevs.setDev_User(ContentCommon.DEFAULT_USER_NAME);
                        SHIX_getDevs.setDev_Pwd("6666");
                        ContentCommon.SHIX_updataDevs(SHIX_getDevs);
                        SettingActivity.this.finish();
                        SettingActivity.this.startActivity(new Intent(SettingActivity.this, (Class<?>) NUIMainActivity.class));
                    }
                }.execute(new Void[0]);
                niftyDialogBuilder.dismiss();
            }
        }).show();
    }

    public void showSureReboot() {
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        niftyDialogBuilder.withMessage(getString(R.string.restart_show)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
                NativeCallerTools.SDKAPITransferMessage(SettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reboot", 1));
                SettingActivity.this.finish();
            }
        }).show();
    }
}
