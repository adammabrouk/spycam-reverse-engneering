package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.ProxyActivityAction;

/* loaded from: classes.dex */
public class PushActivity extends Activity {
    public static final String FROM_OTHER_WAY = "from_way";
    public static final String FROM_UNION_AD = "from_union_ad";
    public static final String TAG = "PushActivity";
    public ProxyActivityAction activityAction;

    @Override // android.app.Activity
    public void onBackPressed() {
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onBackPressed(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        getIntent().getBooleanExtra(FROM_UNION_AD, false);
        ProxyActivityAction pushActivity = ActionHelper.getInstance().getPushActivity(getApplicationContext());
        this.activityAction = pushActivity;
        if (pushActivity != null) {
            pushActivity.onCreate(this, bundle);
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
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onNewIntent(this, intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onPause(this);
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

    public void showTitleBar() {
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onEvent(this, "push_show_titlebar", null);
        }
    }
}
