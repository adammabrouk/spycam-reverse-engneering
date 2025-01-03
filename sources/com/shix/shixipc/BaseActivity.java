package com.shix.shixipc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.shix.lookcam.R;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseActivity extends AppCompatActivity {
    public boolean isSend = false;
    public WifiStateReceiver wifiStateReceiver;

    public class HeatThread extends Thread {
        public int count;
        public String did1;
        public String pwd1;
        public String user1;

        public HeatThread(String str, String str2, String str3) {
            this.user1 = "";
            this.pwd1 = "";
            this.did1 = "";
            this.count = 0;
            this.did1 = str;
            this.user1 = str2;
            this.pwd1 = str3;
            this.count = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (BaseActivity.this.isSend) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                int i2 = this.count + 1;
                this.count = i2;
                if (i2 == 4) {
                    this.count = 0;
                }
            }
            super.run();
        }
    }

    public class WifiStateReceiver extends BroadcastReceiver {
        public WifiStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_CHANGED_ACTION");
                int intExtra = intent.getIntExtra("wifi_state", 0);
                if (intExtra == 0) {
                    MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_DISABLING");
                } else if (intExtra == 1) {
                    MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_DISABLED");
                } else if (intExtra == 2) {
                    MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_ENABLING");
                } else if (intExtra == 3) {
                    MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_ENABLED");
                } else if (intExtra == 4) {
                    MyLogUtils.i("WifiStateReceiver", "WIFI_STATE_UNKNOWN");
                }
            }
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                MyLogUtils.i("WifiStateReceiver", "NETWORK_STATE_CHANGED_ACTION");
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    NetworkInfo.State state = ((NetworkInfo) parcelableExtra).getState();
                    NetworkInfo.State state2 = NetworkInfo.State.CONNECTED;
                    MyLogUtils.i("WifiStateReceiver", "当前连接状态:" + state);
                }
            }
        }
    }

    public static String getProcessName(int i2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i2 + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return readLine;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    @TargetApi(19)
    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    public Bitmap Create2DCode(String str) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(new String(str.getBytes("UTF-8"), Encoder.DEFAULT_BYTE_MODE_ENCODING), BarcodeFormat.QR_CODE, 800, 800);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bitMatrix = null;
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                if (bitMatrix.get(i3, i2)) {
                    iArr[(i2 * width) + i3] = -16777216;
                } else {
                    iArr[(i2 * width) + i3] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public void SetTab(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        new SystemBarTintManager(this).setStatusBarTintEnabled(true);
    }

    public void StartHeat(String str, String str2, String str3) {
        this.isSend = true;
        CommonUtil.Log(1, "HeatThread start ");
        new HeatThread(str, str2, str3).start();
    }

    public void StopHeat() {
        CommonUtil.Log(1, "HeatThread StopHeat ");
        this.isSend = false;
    }

    public String getWifiSSID() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (CommonUtil.isApModul(ssid)) {
            int networkId = connectionInfo.getNetworkId();
            Iterator<WifiConfiguration> it = wifiManager.getConfiguredNetworks().iterator();
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

    public void launchAppDetail(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isSend = false;
        super.onCreate(bundle);
        BarUtils.setStatusBarColor(this, Color.parseColor("#FFFFFFFF")).setBackgroundResource(R.color.white);
        BarUtils.setStatusBarLightMode((Activity) this, true);
    }

    public String returnString(int i2) {
        return getResources().getString(i2);
    }

    public void sendReceiver(Context context) {
        MyLogUtils.i("WifiStateReceiver", "sendReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        WifiStateReceiver wifiStateReceiver = new WifiStateReceiver();
        this.wifiStateReceiver = wifiStateReceiver;
        context.registerReceiver(wifiStateReceiver, intentFilter);
    }

    public void showSureDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.app1);
        builder.setTitle(getResources().getString(R.string.exit) + getResources().getString(R.string.app_name));
        builder.setMessage(R.string.exit_chenxu_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.BaseActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                BaseActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void showToastLong(int i2) {
        Toast.makeText(this, getResources().getString(i2), 1).show();
    }

    public void stopReceiver(Context context) {
        MyLogUtils.i("WifiStateReceiver", "stopReceiver");
        WifiStateReceiver wifiStateReceiver = this.wifiStateReceiver;
        if (wifiStateReceiver != null) {
            context.unregisterReceiver(wifiStateReceiver);
            this.wifiStateReceiver = null;
        }
    }

    public void showToast(int i2) {
        Toast.makeText(this, getResources().getString(i2), 0).show();
    }

    public void SetTab(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(i2);
    }
}
