package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.service.WakedResultReceiver;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CrashHandler;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.TimeUtil;
import java.util.Locale;

/* loaded from: classes.dex */
public class FragmentMe extends BaseFragment implements View.OnClickListener {
    public static LogoutInterface logoutInterface;
    public RelativeLayout aboutUpdata;
    public RelativeLayout mUploadFile;
    public OSS oss;
    public SharedPreferences preSHIX;
    public RelativeLayout privacy;
    public RelativeLayout privacy1;
    public RelativeLayout privacy2;
    public int tag = 0;
    public TextView tv_name;
    public TextView tv_size;

    public interface LogoutInterface {
        void LogOutClick();
    }

    private void hidePrivacy() {
        if (getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            this.privacy.setVisibility(0);
        } else {
            this.privacy.setVisibility(0);
        }
    }

    public static void setLogoutInterface(LogoutInterface logoutInterface2) {
        logoutInterface = logoutInterface2;
    }

    public void chooseLanguage(Locale locale) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
        getActivity().finish();
        getActivity().startActivity(getActivity().getIntent());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10L);
        }
        int id = view.getId();
        if (id == R.id.rl_about) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), AboutVersionActivity.class);
            startActivity(intent);
        }
        if (id == R.id.upload_file) {
            uploadFile(FileUtil.getRootDir() + "/HDWiFiCam/video/ALLFile/crashHE.txt");
            return;
        }
        switch (id) {
            case R.id.rl_ys /* 2131231377 */:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), MenuHelepActivity.class);
                startActivity(intent2);
                break;
            case R.id.rl_ys_1 /* 2131231378 */:
                Intent intent3 = new Intent();
                intent3.setClass(getActivity(), MenuHelepActivity.class);
                intent3.putExtra("WEB_URL", "1");
                startActivity(intent3);
                break;
            case R.id.rl_ys_2 /* 2131231379 */:
                Intent intent4 = new Intent();
                intent4.setClass(getActivity(), MenuHelepActivity.class);
                intent4.putExtra("WEB_URL", WakedResultReceiver.WAKE_TYPE_KEY);
                startActivity(intent4);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_me, viewGroup, false);
        this.tv_size = (TextView) inflate.findViewById(R.id.tv_size);
        this.tv_name = (TextView) inflate.findViewById(R.id.tv_name);
        this.privacy = (RelativeLayout) inflate.findViewById(R.id.rl_ys);
        this.privacy1 = (RelativeLayout) inflate.findViewById(R.id.rl_ys_1);
        this.privacy2 = (RelativeLayout) inflate.findViewById(R.id.rl_ys_2);
        this.privacy.setOnClickListener(this);
        this.privacy1.setOnClickListener(this);
        this.privacy2.setOnClickListener(this);
        if (getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            this.privacy.setVisibility(8);
            this.privacy1.setVisibility(0);
            this.privacy2.setVisibility(0);
        } else {
            this.privacy.setVisibility(0);
            this.privacy1.setVisibility(8);
            this.privacy2.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_about);
        this.aboutUpdata = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.upload_file);
        this.mUploadFile = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.preSHIX = getActivity().getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_USER, "");
        this.tv_name.setText(string + "");
        this.tv_size.setText(SystemValue.arrayList.size() + LogUtils.PLACEHOLDER + getResources().getString(R.string.main_me_dev));
    }

    public void uploadFile(String str) {
        OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = new OSSPlainTextAKSKCredentialProvider("LTAI4FuRjQ3yKaiDrhWk7Vxv", "Ncf5q6WIocKiPtPUlyCQxLYKq1tIT1");
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(LogThreadPoolManager.TIME_KEEP_ALIVE);
        clientConfiguration.setSocketTimeout(LogThreadPoolManager.TIME_KEEP_ALIVE);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        this.oss = new OSSClient(getActivity().getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", oSSPlainTextAKSKCredentialProvider);
        try {
            PutObjectResult putObject = this.oss.putObject(new PutObjectRequest(ContentCommon.CLOUDBUCKET, "AndroidLog/log_" + TimeUtil.getUTCTime() + CrashHandler.FILE_NAME_SUFFIX, str));
            Log.d("PutObject", "UploadSuccess");
            Log.d(HttpHeaders.ETAG, putObject.getETag());
            Log.d("RequestId", putObject.getRequestId());
            Toast.makeText(getActivity(), " 上传成功 ", 1).show();
        } catch (ClientException e2) {
            e2.printStackTrace();
            Toast.makeText(getActivity(), " 上传失败 ", 1).show();
        } catch (ServiceException e3) {
            Log.e("RequestId", e3.getRequestId());
            Log.e("ErrorCode", e3.getErrorCode());
            Log.e("HostId", e3.getHostId());
            Log.e("RawMessage", e3.getRawMessage());
            Toast.makeText(getActivity(), " 上传失败 ", 1).show();
        }
        this.mUploadFile.setVisibility(8);
    }
}
