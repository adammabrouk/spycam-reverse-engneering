package com.shix.shixipc.activity;

import a.h.b.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.android.BuildConfig;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.DisplayUtil;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class NApGetWififActivity extends BaseActivity implements View.OnClickListener {
    public static final int RP_ACCESS_FINE_LOCATION = 2;
    public ImageView ivEye;
    public Dialog resetDialog;
    public Dialog tipsDialog;
    public EditText tvWIFINAME;
    public EditText tvWifiPass;
    public String wifyName = "";

    private void initResetDialog() {
        Dialog dialog = new Dialog(this, R.style.customDialog);
        this.resetDialog = dialog;
        dialog.setCanceledOnTouchOutside(false);
        this.resetDialog.setContentView(R.layout.dialog_get_more);
        this.resetDialog.findViewById(R.id.im_close).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NApGetWififActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NApGetWififActivity.this.resetDialog.dismiss();
            }
        });
        Window window = this.resetDialog.getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(this, 40.0f);
    }

    private void initTipsDialog() {
        Dialog dialog = new Dialog(this, R.style.customDialog);
        this.tipsDialog = dialog;
        dialog.setCanceledOnTouchOutside(false);
        this.tipsDialog.setContentView(R.layout.dialog_wifi_nopwd_tips);
        this.tipsDialog.findViewById(R.id.tvCancel).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NApGetWififActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NApGetWififActivity.this.tipsDialog.dismiss();
            }
        });
        this.tipsDialog.findViewById(R.id.tvConfirm).setOnClickListener(this);
        this.tipsDialog.getWindow().setGravity(17);
    }

    private boolean isContainChinese(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.location_permissions_title)).setMessage(getResources().getString(R.string.location_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NApGetWififActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NApGetWififActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    NApGetWififActivity.this.toCheckPermission();
                }
            });
        }
        negativeButton.create().show();
    }

    private byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermission() {
        if (a.a(this, Permission.ACCESS_FINE_LOCATION) == 0) {
            return true;
        }
        a.h.a.a.a(this, new String[]{Permission.ACCESS_FINE_LOCATION}, 2);
        return false;
    }

    public void initEvents() {
        findViewById(R.id.add_more).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
        findViewById(R.id.ivDevice).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.edit_wify_pass);
        this.tvWifiPass = editText;
        editText.setInputType(32);
        this.tvWifiPass.setImeOptions(6);
        ImageView imageView = (ImageView) findViewById(R.id.edit_wify_pass_eye);
        this.ivEye = imageView;
        imageView.setOnClickListener(this);
        this.tvWIFINAME = (EditText) findViewById(R.id.edit_wify_name);
        this.ivEye.setSelected(false);
        this.ivEye.setImageResource(R.mipmap.eyes_close);
        this.tvWifiPass.setInputType(129);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_more /* 2131230800 */:
                this.resetDialog.show();
                break;
            case R.id.back /* 2131230819 */:
                finish();
                break;
            case R.id.btn_next /* 2131230850 */:
                String trim = this.tvWIFINAME.getText().toString().trim();
                this.wifyName = trim;
                if (trim != null && trim.length() >= 1 && !CommonUtil.isApModul(this.wifyName)) {
                    String trim2 = this.tvWifiPass.getText().toString().trim();
                    if (!"".equals(this.wifyName)) {
                        byte[] strToByteArray = strToByteArray(this.wifyName);
                        CommonUtil.Log(1, "SHIXWIFI  wifiName:" + this.wifyName + "  Len:" + strToByteArray.length);
                        if (strToByteArray.length <= 30) {
                            if (trim2 != null && trim2.length() > 1) {
                                byte[] strToByteArray2 = strToByteArray(trim2);
                                CommonUtil.Log(1, "SHIXWIFI  pwd:" + trim2 + "  Len:" + strToByteArray2.length);
                                if (strToByteArray2.length > 30) {
                                    showToast(R.string.config_wifi_len_show);
                                    break;
                                }
                            }
                            if (trim2 != null && trim2.length() != 0) {
                                Intent intent = new Intent(this, (Class<?>) ErShowActivity.class);
                                intent.putExtra("mConnectedSsid", this.wifyName);
                                intent.putExtra("Password", trim2);
                                startActivity(intent);
                                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", trim2, -1);
                                finish();
                                break;
                            } else {
                                this.tipsDialog.show();
                                break;
                            }
                        } else {
                            showToast(R.string.config_wifi_len_show);
                            break;
                        }
                    } else {
                        Toast.makeText(this, getResources().getString(R.string.add_device_danale_wifi), 0).show();
                        break;
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.add_device_danale_wifi1_1), 0).show();
                    break;
                }
                break;
            case R.id.edit_wify_pass_eye /* 2131231004 */:
                if (this.ivEye.isSelected()) {
                    this.ivEye.setSelected(false);
                    this.ivEye.setImageResource(R.mipmap.eyes_close);
                    this.tvWifiPass.setInputType(129);
                } else {
                    this.ivEye.setSelected(true);
                    this.ivEye.setImageResource(R.mipmap.eyes_open);
                    this.tvWifiPass.setInputType(BuildConfig.Build_ID);
                }
                EditText editText = this.tvWifiPass;
                editText.setSelection(editText.length());
                break;
            case R.id.ivDevice /* 2131231124 */:
                ((TextView) findViewById(R.id.edit_wify_name)).setText(getWifiSSID());
                this.tvWifiPass.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
                break;
            case R.id.tvConfirm /* 2131231559 */:
                Intent intent2 = new Intent(this, (Class<?>) ErShowActivity.class);
                intent2.putExtra("mConnectedSsid", this.wifyName);
                intent2.putExtra("Password", "");
                startActivity(intent2);
                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", "", -1);
                finish();
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_getwifi);
        initTipsDialog();
        initResetDialog();
        initEvents();
        toCheckPermission();
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
            EditText editText = this.tvWIFINAME;
            if (editText != null) {
                editText.setText(getWifiSSID());
                return;
            }
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.tvWIFINAME.setText(getWifiSSID());
        this.tvWifiPass.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
    }
}
