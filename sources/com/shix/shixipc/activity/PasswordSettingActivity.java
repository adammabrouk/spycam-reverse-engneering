package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.EmojiFilter;
import com.shix.shixipc.utils.FullCharFilter;
import com.shix.shixipc.utils.NotCopyAndPaste;
import com.shix.shixipc.utils.SpcialCharFilter;

/* loaded from: classes.dex */
public class PasswordSettingActivity extends BaseActivity implements TextWatcher, NUIMainActivity.SHIXCOMMONInterface {
    public String cameraName;
    public EditText edt_confirm_password;
    public EditText edt_new_password;
    public String newPassword;
    public ImageView showPswImg;
    public TextView showPswTip;
    public LinearLayout show_psw_layout;
    public String strDID;
    public boolean isSupportLenExt = false;
    public boolean isSupportFullChar = false;
    public boolean showPsw = false;

    private CameraParamsBean getCameraBean(String str) {
        int size = SystemValue.arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i2;
                return cameraParamsBean;
            }
        }
        return null;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    private String getPwd() {
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (this.strDID.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                return SystemValue.arrayList.get(i2).getDev_Pwd();
            }
        }
        return "";
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    private void initView() {
        this.show_psw_layout = (LinearLayout) findViewById(R.id.show_psw_layout);
        this.showPswImg = (ImageView) findViewById(R.id.showPswImg);
        this.showPswTip = (TextView) findViewById(R.id.showPswTip);
        EditText editText = (EditText) findViewById(R.id.edt_new_password);
        this.edt_new_password = editText;
        editText.setCustomSelectionActionModeCallback(new NotCopyAndPaste());
        EditText editText2 = (EditText) findViewById(R.id.edt_confirm_password);
        this.edt_confirm_password = editText2;
        editText2.setCustomSelectionActionModeCallback(new NotCopyAndPaste());
        if (this.isSupportFullChar && this.isSupportLenExt) {
            this.edt_new_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63), new FullCharFilter(this), new EmojiFilter()});
            this.edt_confirm_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63), new FullCharFilter(this), new EmojiFilter()});
        } else {
            this.edt_new_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31), new SpcialCharFilter(this), new EmojiFilter()});
            this.edt_confirm_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31), new SpcialCharFilter(this), new EmojiFilter()});
        }
        this.edt_new_password.addTextChangedListener(this);
        this.edt_confirm_password.addTextChangedListener(this);
        this.edt_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edt_confirm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.show_psw_layout.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PasswordSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PasswordSettingActivity.this.showPsw) {
                    PasswordSettingActivity.this.showPsw = false;
                    PasswordSettingActivity.this.showPswImg.setImageResource(R.mipmap.eyes_close);
                    PasswordSettingActivity.this.showPswTip.setText(PasswordSettingActivity.this.getString(R.string.use_setting_show_psw));
                    PasswordSettingActivity.this.edt_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    PasswordSettingActivity.this.edt_confirm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    return;
                }
                PasswordSettingActivity.this.showPsw = true;
                PasswordSettingActivity.this.showPswImg.setImageResource(R.mipmap.eyes_open);
                PasswordSettingActivity.this.showPswTip.setText(PasswordSettingActivity.this.getString(R.string.use_setting_no_show_psw));
                PasswordSettingActivity.this.edt_new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                PasswordSettingActivity.this.edt_confirm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
        ((Button) findViewById(R.id.update_password_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PasswordSettingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordSettingActivity.this.updatePassword();
            }
        });
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.isSupportFullChar && this.isSupportLenExt) {
            if (editable.toString().getBytes().length > 63) {
                showToast(getString(R.string.tip_password_limit));
            }
        } else if (editable.toString().length() > 31) {
            showToast(getString(R.string.tip_password_limit));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_password);
        getDataFromOther();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        initView();
        findViewById(R.id.wifi_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PasswordSettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordSettingActivity.this.finish();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        hideSoftKeyboard(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void updatePassword() {
        this.newPassword = this.edt_new_password.getText().toString();
        String obj = this.edt_confirm_password.getText().toString();
        if (!this.newPassword.equals(obj)) {
            Toast.makeText(this, getText(R.string.tips_new_passwords_do_not_match).toString(), 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.newPassword) && TextUtils.isEmpty(obj)) {
            showToast(getString(R.string.tip_not_empty));
            return;
        }
        if (this.newPassword.length() < 4) {
            showToast(getString(R.string.pwd_dialog_show2));
            return;
        }
        if (this.newPassword.equalsIgnoreCase("123456") || this.newPassword.equalsIgnoreCase("654321")) {
            showToast(getString(R.string.pwd_dialog_show1));
            return;
        }
        if (this.isSupportLenExt) {
            if (this.newPassword.getBytes().length > 63 || obj.getBytes().length > 63) {
                showToast(getString(R.string.tips_input_tolong));
                return;
            }
        } else if (this.newPassword.getBytes().length > 31 || obj.getBytes().length > 31) {
            showToast(getString(R.string.tips_input_tolong));
            return;
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.PasswordSettingActivity.4
            @Override // android.os.AsyncTask
            public void onPreExecute() {
                super.onPreExecute();
                String str = PasswordSettingActivity.this.strDID;
                String str2 = SystemValue.doorBellAdmin;
                String str3 = SystemValue.doorBellPass;
                String str4 = SystemValue.doorBellAdmin;
                NativeCallerTools.SDKAPITransferMessage(str, CommonUtil.editUsersParms(str2, str3, str4, str4, PasswordSettingActivity.this.newPassword));
            }

            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(500L);
                    return null;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Void r3) {
                super.onPostExecute((AnonymousClass4) r3);
                CameraParamsBean SHIX_getDevs = ContentCommon.SHIX_getDevs(PasswordSettingActivity.this.strDID.replace("-", "").trim());
                SHIX_getDevs.setDev_Pwd(PasswordSettingActivity.this.newPassword);
                SHIX_getDevs.setDev_p2pstatus(4);
                ContentCommon.SHIX_updataDevs(SHIX_getDevs);
                DeviceUtil.INSTANCE.StopPPPP(SHIX_getDevs.getDev_Did());
                PasswordSettingActivity.this.finish();
                PasswordSettingActivity.this.startActivity(new Intent(PasswordSettingActivity.this, (Class<?>) NUIMainActivity.class));
            }
        }.execute(new Void[0]);
    }
}
