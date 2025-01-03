package com.shix.shixipc.activity;

import a.h.b.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.google.zxing.activity.CaptureActivity;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.AddShowActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.ActivityTaskManager;

/* loaded from: classes.dex */
public class AddShowActivity extends BaseActivity {
    public static final int RP_CAMERA = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkHasPermission() {
        return XXPermissions.isGranted(this, Permission.ACCESS_FINE_LOCATION);
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.no_camera_permission)).setMessage(getResources().getString(R.string.no_camera_permission_notice)).setNegativeButton(getResources().getString(R.string.no_camera_permission_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.no_camera_permission_reset), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    AddShowActivity.this.toCheckPermission();
                }
            });
        }
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermission() {
        if (a.a(this, Permission.CAMERA) == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        requestPermissions(new String[]{Permission.CAMERA}, 3);
        return false;
    }

    public /* synthetic */ void a(View view) {
        finish();
        startActivity(new Intent(this, (Class<?>) AddCameraActivity.class));
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.add_show);
        ActivityTaskManager.getInstance().putActivity("AddShowActivity", this);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddShowActivity.this.finish();
            }
        });
        findViewById(R.id.add_camera_type_1).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AddShowActivity.this.checkHasPermission()) {
                    Intent intent = new Intent(AddShowActivity.this, (Class<?>) LocationPermissionActivity.class);
                    intent.putExtra(ContentCommon.TYPE, 0);
                    AddShowActivity.this.startActivity(intent);
                } else {
                    AddShowActivity.this.finish();
                    ContentCommon.AP_ADD_OR_CON = 1;
                    Intent intent2 = new Intent();
                    intent2.setClass(AddShowActivity.this, ApConnectActivity.class);
                    AddShowActivity.this.startActivity(intent2);
                }
            }
        });
        findViewById(R.id.add_camera_type_3).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AddShowActivity.this.checkHasPermission()) {
                    Intent intent = new Intent(AddShowActivity.this, (Class<?>) LocationPermissionActivity.class);
                    intent.putExtra(ContentCommon.TYPE, 0);
                    AddShowActivity.this.startActivity(intent);
                } else {
                    AddShowActivity.this.finish();
                    ContentCommon.AP_ADD_OR_CON = 1;
                    Intent intent2 = new Intent();
                    intent2.setClass(AddShowActivity.this, ApConnectActivity.class);
                    AddShowActivity.this.startActivity(intent2);
                }
            }
        });
        findViewById(R.id.add_camera_type_4).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AddShowActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddShowActivity.this.checkHasPermission()) {
                    AddShowActivity.this.finish();
                    AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, (Class<?>) NApGetWififActivity.class));
                } else {
                    Intent intent = new Intent(AddShowActivity.this, (Class<?>) LocationPermissionActivity.class);
                    intent.putExtra(ContentCommon.TYPE, 1);
                    AddShowActivity.this.startActivity(intent);
                }
            }
        });
        findViewById(R.id.add_camera_type_2).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddShowActivity.this.a(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        if (3 != i2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] == 0) {
            Intent intent = new Intent(this, (Class<?>) CaptureActivity.class);
            intent.putExtra(ContentCommon.TYPE, 1);
            startActivityForResult(intent, 11002);
            finish();
            return;
        }
        if (a.h.a.a.a((Activity) this, Permission.CAMERA)) {
            showDialog(true);
        } else {
            showDialog(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
