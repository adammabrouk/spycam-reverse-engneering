package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.as.d;
import cn.jiguang.d.a;

/* loaded from: classes.dex */
public class DownloadActivity extends Activity {
    public static final String TAG = "DownloadActivity";

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.c(TAG, "DownloadActivity onCreate");
        try {
            a.a(getApplicationContext(), getIntent());
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d.c(TAG, "DownloadActivity onNewIntent");
        try {
            a.a(getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
    }
}
