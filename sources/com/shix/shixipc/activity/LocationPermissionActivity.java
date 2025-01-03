package com.shix.shixipc.activity;

import a.h.b.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class LocationPermissionActivity extends BaseActivity {
    public static final int RP_ACCESS_FINE_LOCATION = 2;
    public Button backBt;
    public TextView noThanks;
    public TextView turnOn;
    public int type = 0;

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.location_permissions_title)).setMessage(getResources().getString(R.string.location_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.LocationPermissionActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.LocationPermissionActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    LocationPermissionActivity.this.toCheckPermission();
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

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_permission);
        Intent intent = getIntent();
        if (intent != null) {
            this.type = intent.getIntExtra(ContentCommon.TYPE, 0);
        }
        this.backBt = (Button) findViewById(R.id.backBt);
        this.noThanks = (TextView) findViewById(R.id.noThanks);
        this.turnOn = (TextView) findViewById(R.id.turnOn);
        this.backBt.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.LocationPermissionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocationPermissionActivity.this.finish();
            }
        });
        this.noThanks.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.LocationPermissionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocationPermissionActivity.this.finish();
            }
        });
        this.turnOn.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.LocationPermissionActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocationPermissionActivity.this.toCheckPermission();
            }
        });
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
            int i3 = this.type;
            if (i3 == 0) {
                startActivity(new Intent(this, (Class<?>) ApConnectActivity.class));
            } else if (i3 == 1) {
                startActivity(new Intent(this, (Class<?>) NApGetWififActivity.class));
            }
            finish();
            return;
        }
        if (iArr[0] != 0) {
            if (a.h.a.a.a((Activity) this, Permission.ACCESS_FINE_LOCATION)) {
                showDialog(true);
            } else {
                showDialog(false);
            }
        }
    }
}
