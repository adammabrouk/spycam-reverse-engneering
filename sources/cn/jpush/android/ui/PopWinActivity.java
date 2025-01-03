package cn.jpush.android.ui;

import android.app.Activity;
import android.os.Bundle;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.ProxyActivityAction;

/* loaded from: classes.dex */
public class PopWinActivity extends Activity {
    public static final String TAG = "PopWinActivity";
    public ProxyActivityAction activityAction;

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onBackPressed(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        ProxyActivityAction popWinActivity = ActionHelper.getInstance().getPopWinActivity(this);
        this.activityAction = popWinActivity;
        if (popWinActivity != null) {
            popWinActivity.onCreate(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onResume(this);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onResume(this);
        }
    }

    public void startPushActivity(String str) {
        if (this.activityAction != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.activityAction.onEvent(this, "start_push_activity", bundle);
        }
    }
}
