package com.shix.shixipc.activity;

import a.h.b.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.SystemValue;

/* loaded from: classes.dex */
public class ApConnectActivity extends BaseActivity implements View.OnClickListener {
    public static final int RP_ACCESS_FINE_LOCATION = 2;
    public final int CHECKSSID = 1;
    public final int CHECKUID = 2;
    public boolean isFistComeOn = true;
    public String strUid = "";

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.location_permissions_title)).setMessage(getResources().getString(R.string.location_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.ApConnectActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.ApConnectActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    ApConnectActivity.this.toCheckPermission();
                }
            });
        }
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermission() {
        if (a.a(this, Permission.ACCESS_FINE_LOCATION) == 0) {
            return true;
        }
        a.h.a.a.a(this, new String[]{Permission.ACCESS_FINE_LOCATION}, 2);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else {
            if (id != R.id.tvNext) {
                return;
            }
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            finish();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ap_connect);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        SystemValue.isExitBackGoudExit = false;
        toCheckPermission();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        if (2 != i2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] == 0) {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else if (iArr[0] != 0) {
            if (a.h.a.a.a((Activity) this, Permission.ACCESS_FINE_LOCATION)) {
                showDialog(true);
            } else {
                showDialog(false);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFistComeOn) {
            this.isFistComeOn = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
