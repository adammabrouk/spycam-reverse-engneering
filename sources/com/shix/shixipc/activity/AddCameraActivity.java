package com.shix.shixipc.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.zxing.activity.CaptureActivity;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.File;

/* loaded from: classes.dex */
public class AddCameraActivity extends BaseActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_CAMERA_ADD = 0;
    public static final int SEARCH_TIME = 3000;
    public static DeleInterface deleInterface;
    public Button back;
    public Button btnScanId;
    public Button btnSearchCamera;
    public Button delbtn;
    public Button done;
    public AppCompatImageView done1;
    public boolean isSearched;
    public ToggleButton tb_img;
    public EditText devNameEdit = null;
    public EditText userEdit = null;
    public EditText pwdEdit = null;
    public EditText didEdit = null;
    public String strName = "";
    public String strUser = "";
    public String strPwd = "";
    public String strOldDID = "";
    public int option = ContentCommon.INVALID_OPTION;
    public TextView textViewAddCamera = null;
    public int CameraType = 1;
    public ProgressDialog progressdlg = null;
    public boolean isHaved = false;
    public final int REQUEST_CHOOSEFILE = 110;
    public int pushTypeInt = 0;
    public Runnable updateThread = new Runnable() { // from class: com.shix.shixipc.activity.AddCameraActivity.1
        @Override // java.lang.Runnable
        public void run() {
            NativeCallerTools.SDKAPIStopSearchLanDev();
            AddCameraActivity.this.progressdlg.dismiss();
            Message obtainMessage = AddCameraActivity.this.updateListHandler.obtainMessage();
            obtainMessage.what = 1;
            AddCameraActivity.this.updateListHandler.sendMessage(obtainMessage);
        }
    };
    public Handler updateListHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.AddCameraActivity.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            return false;
        }
    });

    public interface DeleInterface {
        void CallBackDel(String str, String str2);
    }

    public class ToggleButtonClick implements CompoundButton.OnCheckedChangeListener {
        public ToggleButtonClick() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                AddCameraActivity.this.pwdEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                AddCameraActivity.this.pwdEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            AddCameraActivity.this.pwdEdit.setSelection(AddCameraActivity.this.pwdEdit.length());
        }
    }

    private void InitParams() {
        if (this.option == 2) {
            this.textViewAddCamera.setText(R.string.device_edit);
            this.tb_img.setVisibility(8);
            this.pwdEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.pwdEdit.setFocusable(false);
            this.pwdEdit.setClickable(false);
        } else {
            this.textViewAddCamera.setText(R.string.add_camera);
        }
        if (this.option != 65535) {
            this.devNameEdit.setText(this.strName);
            this.userEdit.setText(this.strUser);
            this.pwdEdit.setText(this.strPwd);
            this.didEdit.setText(this.strOldDID);
        }
        this.back.setOnClickListener(this);
        this.done.setOnClickListener(this);
        this.done1.setOnClickListener(this);
        this.btnScanId.setOnClickListener(this);
        this.btnSearchCamera.setOnClickListener(this);
    }

    private void done() {
        String obj = this.devNameEdit.getText().toString();
        String obj2 = this.userEdit.getText().toString();
        String obj3 = this.pwdEdit.getText().toString();
        String upperCase = this.didEdit.getText().toString().toUpperCase();
        if (obj.length() == 0) {
            showToast(R.string.input_camera_name);
            return;
        }
        if (upperCase.length() == 0) {
            showToast(R.string.input_camera_id);
            return;
        }
        upperCase.length();
        if (!CommonUtil.isApModul(upperCase)) {
            showToast(R.string.add_camer_invi);
            return;
        }
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (!this.strOldDID.endsWith(upperCase) && upperCase.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                showToast(R.string.input_camera_all_include);
                return;
            }
        }
        if (obj2.length() == 0) {
            showToast(R.string.input_camera_user);
            return;
        }
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_Did(upperCase.replace("-", "").trim());
        cameraParamsBean.setDev_name(obj);
        cameraParamsBean.setDev_User(obj2);
        cameraParamsBean.setDev_Pwd(obj3);
        for (int i3 = 0; i3 < SystemValue.arrayList.size(); i3++) {
            if (SystemValue.arrayList.get(i3).getDev_Did().contains(cameraParamsBean.getDev_Did())) {
                this.isHaved = true;
            }
        }
        if (this.isHaved) {
            CameraParamsBean SHIX_getDevs = ContentCommon.SHIX_getDevs(upperCase.replace("-", "").trim());
            SHIX_getDevs.setDev_Pwd(obj3);
            SHIX_getDevs.setDev_name(obj);
            SHIX_getDevs.setDev_p2pstatus(4);
            ContentCommon.SHIX_updataDevs(SHIX_getDevs);
            DeviceUtil.INSTANCE.StopPPPP(SHIX_getDevs.getDev_Did());
        } else {
            SystemValue.arrayList.add(cameraParamsBean);
            ContentCommon.SHIX_saveDev(cameraParamsBean);
        }
        finish();
        startActivity(new Intent(this, (Class<?>) NUIMainActivity.class));
    }

    private void findView() {
        this.tb_img = (ToggleButton) findViewById(R.id.tb_img);
        Button button = (Button) findViewById(R.id.delbtn);
        this.delbtn = button;
        button.setOnClickListener(this);
        this.done1 = (AppCompatImageView) findViewById(R.id.done1);
        this.back = (Button) findViewById(R.id.back);
        this.done = (Button) findViewById(R.id.done);
        this.devNameEdit = (EditText) findViewById(R.id.editDevName);
        this.userEdit = (EditText) findViewById(R.id.editUser);
        this.pwdEdit = (EditText) findViewById(R.id.editPwd);
        this.didEdit = (EditText) findViewById(R.id.editDID);
        this.btnScanId = (Button) findViewById(R.id.scanID);
        this.btnSearchCamera = (Button) findViewById(R.id.btn_searchCamera);
        this.textViewAddCamera = (TextView) findViewById(R.id.textview_add_camera);
        this.tb_img.setOnCheckedChangeListener(new ToggleButtonClick());
        if (this.pushTypeInt == 110) {
            this.devNameEdit.setText(this.strName);
            this.didEdit.setText(this.strOldDID);
            this.userEdit.setText(this.strUser);
            this.pwdEdit.setText(this.strPwd);
        }
    }

    private void hiddenInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static void setDeleInterface(DeleInterface deleInterface2) {
        deleInterface = deleInterface2;
    }

    public String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @TargetApi(19)
    public String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return FileUtil.getRootDir() + "/" + split[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        String path;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 11002 && i3 == -1) {
            this.didEdit.setText(intent.getExtras().getString("qr_scan_result"));
        }
        if (i3 == -1) {
            if (i2 == 0) {
                this.didEdit.setText(intent.getStringExtra("mUID"));
                return;
            }
            if (i2 != 110 || (data = intent.getData()) == null || (path = getPath(this, data)) == null) {
                return;
            }
            File file = new File(path);
            if (file.exists()) {
                MyLogUtils.d("", "选择文件返回：" + file.toString() + "  upLoadFileName:" + file.getName());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131230819 */:
                finish();
                break;
            case R.id.btn_searchCamera /* 2131230853 */:
                startActivityForResult(new Intent(this, (Class<?>) SearchActivity.class), 0);
                break;
            case R.id.delbtn /* 2131230970 */:
                DeleInterface deleInterface2 = deleInterface;
                if (deleInterface2 != null) {
                    deleInterface2.CallBackDel(this.strOldDID, this.strName);
                }
                finish();
                break;
            case R.id.done /* 2131230986 */:
                done();
                break;
            case R.id.done1 /* 2131230987 */:
            case R.id.scanID /* 2131231389 */:
                this.progressdlg.setMessage(getResources().getString(R.string.add_twodimensioncode));
                this.progressdlg.setCancelable(false);
                this.progressdlg.show();
                startActivityForResult(new Intent(this, (Class<?>) CaptureActivity.class), 11002);
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.add_camera);
        Intent intent = getIntent();
        this.option = intent.getIntExtra(ContentCommon.CAMERA_OPTION, ContentCommon.INVALID_OPTION);
        int intExtra = intent.getIntExtra("pushTypeInt", 0);
        this.pushTypeInt = intExtra;
        if (this.option != 65535 || intExtra == 110) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strOldDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progressdlg = progressDialog;
        progressDialog.setProgressStyle(0);
        this.progressdlg.setMessage(getString(R.string.searching_tip));
        findView();
        InitParams();
        if (this.option != 2) {
            this.delbtn.setVisibility(8);
            return;
        }
        this.btnScanId.setVisibility(8);
        this.btnSearchCamera.setVisibility(8);
        this.done1.setVisibility(4);
        this.delbtn.setVisibility(0);
        this.didEdit.setEnabled(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        hideSoftKeyboard(this);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ProgressDialog progressDialog = this.progressdlg;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressdlg.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
