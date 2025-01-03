package com.shix.shixipc;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.shix.lookcam.R;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;

/* loaded from: classes.dex */
public class BaseFragment extends Fragment {
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean checkChina(String str, int i2) {
        return false;
    }

    public boolean checkChina1(String str, int i2) {
        if (i2 == 0) {
            return false;
        }
        int i3 = SystemValue.isInCn;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return false;
        }
        return CommonUtil.isCN(getContext()) || getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI");
    }

    public boolean checkChinaDID(String str) {
        return str == null || !str.startsWith("DGKC");
    }

    public void launchAppDetail(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String returnString(int i2) {
        return getResources().getString(i2);
    }

    public void showSetting(int i2, int i3) {
    }

    public void showToast(String str) {
        Toast.makeText(getActivity(), str, 1).show();
    }

    public void showToastLong(int i2) {
        Toast.makeText(getActivity(), getResources().getString(i2), 1).show();
    }

    public void showToast(int i2) {
        Toast.makeText(getActivity(), getResources().getString(i2), 0).show();
    }
}
