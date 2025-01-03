package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.ActivityTaskManager;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class ErShowActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.AddCameraInterface1 {
    public Bitmap bitmap;
    public ImageView img_mode_show;
    public WifiManager mWifiManager;
    public String nowssid;
    public TextView tv_count;
    public final int CHECKSSID = 1;
    public final int CHECKUID = 2;
    public final int CHECKCOUNT = 3;
    public boolean isFistComeOn = false;
    public boolean isCheck = false;
    public String strUid = "";
    public int count = 0;
    public String strEr = "";
    public String mConnectedSsid = "";
    public String Password = "";
    public Handler MsgHandler = new Handler() { // from class: com.shix.shixipc.activity.ErShowActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                ErShowActivity.this.tv_count.setText(ErShowActivity.this.count + " S");
            }
        }
    };

    public class CheckThread extends Thread {
        public CheckThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (ErShowActivity.this.isCheck && ErShowActivity.this.isCheck) {
                NativeCallerTools.SDKAPIStartSearchLanDev(CommonUtil.getLocalIpAddress(ErShowActivity.this));
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                NativeCallerTools.SDKAPIStopSearchLanDev();
                if (!ErShowActivity.this.isCheck) {
                    return;
                }
                ErShowActivity.access$108(ErShowActivity.this);
                ErShowActivity.this.MsgHandler.sendEmptyMessage(3);
            }
        }
    }

    public static /* synthetic */ int access$108(ErShowActivity erShowActivity) {
        int i2 = erShowActivity.count;
        erShowActivity.count = i2 + 1;
        return i2;
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.AddCameraInterface1
    public void callBackSearchResultData(int i2, String str, String str2, String str3, String str4, int i3) {
        if (str3 == null || str3.length() <= 3) {
            return;
        }
        boolean z = true;
        if (i3 == 1) {
            this.strUid = str3.replace("-", "").toUpperCase();
            int i4 = 0;
            while (true) {
                if (i4 >= SystemValue.arrayList.size()) {
                    z = false;
                    break;
                } else if (this.strUid.equals(SystemValue.arrayList.get(i4).getDev_Did())) {
                    break;
                } else {
                    i4++;
                }
            }
            if (!z) {
                CameraParamsBean cameraParamsBean = new CameraParamsBean();
                cameraParamsBean.setDev_Did(this.strUid);
                cameraParamsBean.setDev_name("Camera");
                cameraParamsBean.setDev_Pwd("6666");
                cameraParamsBean.setDev_User(ContentCommon.DEFAULT_USER_NAME);
                SystemValue.arrayList.add(cameraParamsBean);
                ContentCommon.SHIX_saveDev(cameraParamsBean);
            }
            this.isCheck = false;
            ActivityTaskManager.getInstance().closeAllActivity();
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            this.isCheck = false;
            finish();
        } else {
            if (id != R.id.tvNext) {
                return;
            }
            this.isCheck = false;
            startActivity(new Intent(this, (Class<?>) NUIMainActivity.class));
            finish();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_er);
        CommonUtil.Log(1, "SHIX  onCreate");
        this.mConnectedSsid = getIntent().getStringExtra("mConnectedSsid");
        this.Password = getIntent().getStringExtra("Password");
        this.img_mode_show = (ImageView) findViewById(R.id.img_mode_show);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        this.tv_count = (TextView) findViewById(R.id.tv_count);
        this.isFistComeOn = true;
        NUIMainActivity.setAddCameraInterface1(this);
        this.isCheck = true;
        new CheckThread().start();
        SystemValue.isExitBackGoudExit = false;
        try {
            this.mConnectedSsid = URLEncoder.encode(this.mConnectedSsid, "UTF-8");
            this.Password = URLEncoder.encode(this.Password, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        String str = "{\"ssid\":\"" + this.mConnectedSsid + "\",\"password\":\"" + this.Password + "\"}";
        this.strEr = str;
        try {
            this.bitmap = Create2DCode(str);
        } catch (WriterException e3) {
            e3.printStackTrace();
        }
        if (this.bitmap != null) {
            this.img_mode_show.setVisibility(0);
            this.img_mode_show.setImageBitmap(this.bitmap);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NUIMainActivity.setAddCameraInterface1(null);
        this.MsgHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.isFistComeOn = false;
        MyLogUtils.d("SHIX", "SHIX onRestart" + this.nowssid);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
