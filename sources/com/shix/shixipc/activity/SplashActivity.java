package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import c.c.a.b.j.c;
import c.c.a.b.j.h;
import c.c.b.l.a;
import cn.jpush.android.api.JPushInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.view.MyDialog;

/* loaded from: classes.dex */
public class SplashActivity extends BaseActivity {
    public boolean isFirstRun = true;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.SplashActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (SplashActivity.this.getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) NUIMainActivity.class));
                SplashActivity.this.finish();
                return false;
            }
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) NUIMainActivity.class));
            SplashActivity.this.finish();
            return false;
        }
    });
    public MyDialog mMyDialog;
    public SharedPreferences preSHIX;
    public TextView tvVersion;

    /* JADX INFO: Access modifiers changed from: private */
    public void getFcmToken() {
        FirebaseInstanceId.o().b().a(new c<a>() { // from class: com.shix.shixipc.activity.SplashActivity.2
            @Override // c.c.a.b.j.c
            public void onComplete(h<a> hVar) {
                if (!hVar.e()) {
                    Log.w("Constraints", "getInstanceId failed", hVar.a());
                    return;
                }
                String a2 = hVar.b().a();
                Log.e("Constraints", "getInstanceId token= " + a2);
                SharedPreferencesUtils.getInstance().putString("FcmToken", a2);
                Log.d("Constraints", a2);
            }
        });
    }

    private String getVersionName() throws Exception {
        return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
    }

    private void initJpush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    private void isFirstRunApp() {
        this.isFirstRun = this.preSHIX.getBoolean(ContentCommon.SHIX_IS_FIRST_RUN, true);
        final SharedPreferences.Editor edit = this.preSHIX.edit();
        if (!this.isFirstRun) {
            startNextPage();
            return;
        }
        MyDialog myDialog = new MyDialog(this);
        this.mMyDialog = myDialog;
        myDialog.setCancelable(false);
        this.mMyDialog.show();
        this.mMyDialog.setOnClickBottomListener(new MyDialog.OnClickBottomListener() { // from class: com.shix.shixipc.activity.SplashActivity.3
            @Override // com.shix.shixipc.view.MyDialog.OnClickBottomListener
            public void onAgreeClick() {
                edit.putBoolean(ContentCommon.SHIX_IS_FIRST_RUN, false);
                edit.apply();
                SplashActivity.this.mMyDialog.dismiss();
                SplashActivity.this.startNextPage();
            }

            @Override // com.shix.shixipc.view.MyDialog.OnClickBottomListener
            public void onDisagressClick() {
                SplashActivity.this.finish();
            }

            @Override // com.shix.shixipc.view.MyDialog.OnClickBottomListener
            public void onReadMeClick() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MenuHelepActivity.class);
                SplashActivity.this.startActivity(intent);
            }
        });
    }

    private void sendRegTokenToServer(String str) {
        Log.i("Constraints", "sending token to server. token:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNextPage() {
        new Thread(new Runnable() { // from class: com.shix.shixipc.activity.SplashActivity.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NativeCallerTools.SDKAPIInit();
                    SplashActivity.this.getFcmToken();
                    SplashActivity.this.mHandler.sendMessageDelayed(new Message(), 500L);
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        if (!isTaskRoot() && (intent = getIntent()) != null) {
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(action)) {
                finish();
                return;
            }
        }
        setContentView(R.layout.activity_splash);
        TextView textView = (TextView) findViewById(R.id.tv12);
        this.tvVersion = textView;
        try {
            textView.setText("v " + getVersionName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        if (getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            isFirstRunApp();
        } else {
            startNextPage();
        }
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
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
