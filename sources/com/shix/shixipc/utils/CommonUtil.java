package com.shix.shixipc.utils;

import a.h.a.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.android.BuildConfig;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.decoding.InactivityTimer;
import com.google.zxing.view.ViewfinderView;
import com.hjq.permissions.Permission;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseValueOf", "ShowToast"})
/* loaded from: classes.dex */
public class CommonUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    public static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    public static final Boolean isLog = true;

    public static final String CameraControl(String str, String str2, String str3, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(str3, i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Log(1, "CameraControl:" + jSONObject.toString());
        return jSONObject.toString();
    }

    public static final String CutStream(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "stream");
            jSONObject.put("cmd", 111);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("video", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int GetCommonShareIntValue(Context context, String str, int i2) {
        return context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).getInt(str, i2);
    }

    public static String GetCommonShareStringValue(Context context, String str, String str2) {
        return context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).getString(str, str2);
    }

    public static final void Log(int i2, String str) {
    }

    public static final String SHIX_DelVideoFiles(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("filename", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Delpush(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Delpush2(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_push");
            jSONObject.put("cmd", 999);
            jSONObject.put("user", ContentCommon.DEFAULT_USER_NAME);
            jSONObject.put("UserUUID", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_GetDateParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_datetime");
            jSONObject.put("cmd", 125);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_GetVideoFiles(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_videofiles");
            jSONObject.put("cmd", 116);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("start_time", str3);
            jSONObject.put("end_time", str4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Heat(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("heart", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistPush(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str4);
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", str7);
            jSONObject.put("pageName", "com.shix.lookcam");
            if (CrashApplication.getPushBrand() == 1) {
                jSONObject.put("pustType", 16);
                jSONObject.put("xm_app_id", ContentCommon.XM_APP_ID);
                jSONObject.put("xm_app_key", ContentCommon.XM_APP_KEY);
                jSONObject.put("xm_app_secret", ContentCommon.XM_APPSECRET);
                jSONObject.put("xm_registid", ContentCommon.XM_TOKEN);
                jSONObject.put("xm_tips", str8);
            } else if (CrashApplication.getPushBrand() == 2) {
                jSONObject.put("pustType", 32);
                jSONObject.put("hw_client_id", "102019835");
                jSONObject.put("hw_device_token", ContentCommon.HW_TOKEN);
                jSONObject.put("hw_client_secret", "6478b03924f75ebf2aae01c41b9fd2696b6259dea7f68dbd1f0ed932afcbc5ae");
                jSONObject.put("hw_tips", str8);
            } else if (CrashApplication.getPushBrand() == 4) {
                jSONObject.put("pustType", RecyclerView.c0.FLAG_IGNORE);
                jSONObject.put("vivo_app_id", "105326334");
                jSONObject.put("vivo_regid", ContentCommon.VIVO_REGID);
                jSONObject.put("vivo_app_key", "7c2968278dc83bc0e872a02e0f75c361");
                jSONObject.put("vivo_app_secret", "29d6850d-c2a7-4231-aca7-0ebb8733bdd2");
                jSONObject.put("vivo_tips", str8);
            } else if (CrashApplication.getPushBrand() == 3) {
                jSONObject.put("pustType", RecyclerView.c0.FLAG_TMP_DETACHED);
                jSONObject.put("oppo_regid", ContentCommon.OPPO_REGID);
                jSONObject.put("oppo_app_key", "1332e81b03fc4fd08daf9984d40ee073");
                jSONObject.put("oppo_app_secret", "6e4ca69c5126447e920144491873dca3");
                jSONObject.put("oppo_tips", str8);
            } else if (CrashApplication.getPushBrand() == 5) {
                jSONObject.put("pustType", 1);
                jSONObject.put("jpush_tips", str8);
                jSONObject.put("jpush_regid", ContentCommon.JPUSH_REGID);
                jSONObject.put("jpush_app_key", "37fac9831d44013b2750a764");
                jSONObject.put("jpush_app_secret", "8b904ebb7d045c14008a4973");
            } else {
                jSONObject.put("pustType", 1);
                jSONObject.put("jpush_tips", str8);
                jSONObject.put("jpush_regid", ContentCommon.JPUSH_REGID);
                jSONObject.put("jpush_app_key", "37fac9831d44013b2750a764");
                jSONObject.put("jpush_app_secret", "8b904ebb7d045c14008a4973");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MyLogUtils.d("set_push", jSONObject.toString());
        return jSONObject.toString();
    }

    public static final String SHIX_SetCameraParms(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_parms");
            jSONObject.put("cmd", 103);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("language", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetGooglePush(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str3);
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", str6);
            jSONObject.put("pageName", "com.shix.lookcam");
            jSONObject.put("pustType", 64);
            jSONObject.put("fcm_device_token", str4);
            jSONObject.put("fcm_apiKey", str5);
            jSONObject.put("fcm_apiKey_v2", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MyLogUtils.d("set_push", jSONObject.toString());
        return jSONObject.toString();
    }

    public static final String SHIX_SetHWPush(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", SpUtil.INSTANCE.decodeString("SHIXUUID"));
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", URLDecoder.decode(str3, "UTF-8"));
            jSONObject.put("pageName", "com.shix.lookcam");
            jSONObject.put("pustType", 32);
            jSONObject.put("hw_client_id", ContentCommon.HW_CLIENT_ID);
            jSONObject.put("hw_device_token", str5);
            jSONObject.put("hw_client_key", ContentCommon.HW_CLIENT_KEY);
            jSONObject.put("hw_client_secret", ContentCommon.HW_APP_SECRET);
            jSONObject.put("hw_tips", str4);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetMiPush(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", UUID.randomUUID().toString());
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", URLDecoder.decode(str3, "UTF-8"));
            jSONObject.put("pageName", "com.shix.lookcam");
            jSONObject.put("pustType", 16);
            jSONObject.put("xm_app_id", ContentCommon.XM_APP_ID);
            jSONObject.put("xm_app_key", ContentCommon.XM_APP_KEY);
            jSONObject.put("xm_app_secret", ContentCommon.XM_APPSECRET);
            jSONObject.put("xm_registid", ContentCommon.XM_TOKEN);
            jSONObject.put("xm_tips", str4);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetOPPOPush(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", SpUtil.INSTANCE.decodeString("SHIXUUID"));
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", URLDecoder.decode(str3, "UTF-8"));
            jSONObject.put("pageName", "com.shix.lookcam");
            jSONObject.put("pustType", RecyclerView.c0.FLAG_TMP_DETACHED);
            jSONObject.put("oppo_regid", str5);
            jSONObject.put("oppo_app_key", ContentCommon.OPPO_APPKEY);
            jSONObject.put("oppo_app_secret", ContentCommon.OPPO_MASTER_SECRET);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetVIVOPush(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", SpUtil.INSTANCE.decodeString("SHIXUUID"));
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", URLDecoder.decode(str3, "UTF-8"));
            jSONObject.put("pageName", "com.shix.lookcam");
            jSONObject.put("pustType", RecyclerView.c0.FLAG_IGNORE);
            jSONObject.put("vivo_app_id", ContentCommon.VIVO_APP_ID);
            jSONObject.put("vivo_regid", str5);
            jSONObject.put("vivo_app_key", ContentCommon.VIVO_APP_KEY);
            jSONObject.put("vivo_app_secret", ContentCommon.VIVO_APP_SECRET);
            jSONObject.put("vivo_tips", str4);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetWifi(String str, String str2, String str3, String str4, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_wifi");
            jSONObject.put("cmd", 114);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("wifissid", str3);
            jSONObject.put("wifipwd", str4);
            jSONObject.put("encryption", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetWifi2(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_wifi");
            jSONObject.put("cmd", 114);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("apssid", str3);
            jSONObject.put("appwd", str4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_talk");
            jSONObject.put("cmd", 129);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, "g711a");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartVideoFiles(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_videofiles");
            jSONObject.put("cmd", 117);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("start_time", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "end_talk");
            jSONObject.put("cmd", 130);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, "g711a");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopVideoFiles(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "stop_videofiles");
            jSONObject.put("cmd", 120);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_getSPKMICParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_vol");
            jSONObject.put("cmd", 134);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_setCloudStorage(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_cloud_storage");
            jSONObject.put("cmd", 136);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("cloud_type", 0);
            jSONObject.put("server_type", 1);
            jSONObject.put("storage_path", "");
            jSONObject.put("expiration_time_sec", (long) (Math.floor(System.currentTimeMillis() / 1000) + 3.1536E7d));
            if (str3.startsWith(ContentCommon.SHIX_APPRE4)) {
                jSONObject.put("oss_host_name", "lookcam.oss-cn-hongkong.aliyuncs.com");
                jSONObject.put("oss_access_id", "LTAI4Fvp5vkFic1UxLBmVk41");
                jSONObject.put("oss_secret_key", "E71ud2gGXTGO4DmR3qhYs9eTytcSuL");
                jSONObject.put("oss_bucket_name", "lookcam");
            } else {
                if (!str3.startsWith(ContentCommon.SHIX_APPRE1) && !str3.startsWith(ContentCommon.SHIX_APPRE)) {
                    if (str3.startsWith(ContentCommon.SHIX_APPRE6)) {
                        jSONObject.put("oss_host_name", "jxtcamera.oss-cn-hangzhou.aliyuncs.com");
                        jSONObject.put("oss_access_id", "LTAI4GHDkMTasLXNiGbj3FAo");
                        jSONObject.put("oss_secret_key", "0263KtMBwjnTroQVEmCv3s2q7p3rEk");
                        jSONObject.put("oss_bucket_name", "jxtcamera");
                    }
                }
                jSONObject.put("oss_host_name", "xyxcamera.oss-cn-hongkong.aliyuncs.com");
                jSONObject.put("oss_access_id", "LTAI4FuRjQ3yKaiDrhWk7Vxv");
                jSONObject.put("oss_secret_key", "Ncf5q6WIocKiPtPUlyCQxLYKq1tIT1");
                jSONObject.put("oss_bucket_name", ContentCommon.CLOUDBUCKET);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_setMIC(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_vol");
            jSONObject.put("cmd", 135);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("inputvol", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_setSPK(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_vol");
            jSONObject.put("cmd", 135);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("outputvol", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void SaveCommonShare(Context context, String str, String str2, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).edit();
        if (i2 != -1) {
            edit.putInt(str, i2);
        }
        if (str2 != null) {
            edit.putString(str, str2);
        }
        edit.commit();
    }

    public static final String StartPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_start");
            jSONObject.put("cmd", 313);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String UpdateFile(String str, String str2, String str3, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "upload_file");
            jSONObject.put("cmd", 202);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("filename", str3);
            jSONObject.put("filesize", j);
            jSONObject.put("offset", j2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String UpdateFileRequst(String str, String str2, String str3, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "upload_file_request");
            jSONObject.put("cmd", 201);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("filename", str3);
            jSONObject.put("filesize", j);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @SuppressLint({"MissingPermission"})
    public static void Vibrate(Activity activity, long j) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(j);
    }

    public static final String addUsersParms(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "add_user");
            jSONObject.put("cmd", 104);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("newuser", str3);
            jSONObject.put("newpwd", str4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final int byteToInt(byte[] bArr) {
        int i2 = bArr[0] & ThreadUtils.TYPE_SINGLE;
        int i3 = bArr[1] & ThreadUtils.TYPE_SINGLE;
        return ((bArr[3] & ThreadUtils.TYPE_SINGLE) << 24) | i2 | (i3 << 8) | ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static final long byteToLong(byte[] bArr) {
        return (bArr[0] & ThreadUtils.TYPE_SINGLE) | ((bArr[1] & ThreadUtils.TYPE_SINGLE) << 8) | ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[3] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[4] & ThreadUtils.TYPE_SINGLE) << 32) | ((bArr[5] & ThreadUtils.TYPE_SINGLE) << 40) | ((bArr[6] & ThreadUtils.TYPE_SINGLE) << 48) | ((bArr[7] & ThreadUtils.TYPE_SINGLE) << 56);
    }

    public static void checkCameraPermission(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, Permission.CAMERA)) {
            arrayList.add(Permission.CAMERA);
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            a.a(activity, strArr, 0);
        }
    }

    public static void checkCameraRecordAudioPermission(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, Permission.CAMERA)) {
            arrayList.add(Permission.CAMERA);
        }
        if (!checkPermission(activity, Permission.RECORD_AUDIO)) {
            arrayList.add(Permission.RECORD_AUDIO);
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            a.a(activity, strArr, 0);
        }
    }

    public static boolean checkEnable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean checkPermission(Context context, String str) {
        return a.h.b.a.a(context, str) == 0;
    }

    public static void checkPermissionAll(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, Permission.READ_EXTERNAL_STORAGE)) {
            arrayList.add(Permission.READ_EXTERNAL_STORAGE);
        }
        if (!checkPermission(activity, Permission.WRITE_EXTERNAL_STORAGE)) {
            arrayList.add(Permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!checkPermission(activity, Permission.ACCESS_FINE_LOCATION)) {
            arrayList.add(Permission.ACCESS_FINE_LOCATION);
        }
        if (!checkPermission(activity, Permission.ACCESS_COARSE_LOCATION)) {
            arrayList.add(Permission.ACCESS_COARSE_LOCATION);
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            a.a(activity, strArr, 0);
        }
    }

    public static void checkRecordAudioPermission(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, Permission.RECORD_AUDIO)) {
            arrayList.add(Permission.RECORD_AUDIO);
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            a.a(activity, strArr, 0);
        }
    }

    public static void checkStoragePermission(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, Permission.READ_EXTERNAL_STORAGE)) {
            arrayList.add(Permission.READ_EXTERNAL_STORAGE);
        }
        if (!checkPermission(activity, Permission.WRITE_EXTERNAL_STORAGE)) {
            arrayList.add(Permission.WRITE_EXTERNAL_STORAGE);
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            a.a(activity, strArr, 0);
        }
    }

    public static final String deleteUsersParms(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_user");
            jSONObject.put("cmd", 105);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("deluser", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final String editUsersParms(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "edit_user");
            jSONObject.put("cmd", 106);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("edituser", str3);
            jSONObject.put("newuser", str4);
            jSONObject.put("newpwd", str5);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String formatSDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_sd");
            jSONObject.put("cmd", 110);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("format", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final long fourBytesToLong(byte[] bArr) {
        int length = bArr.length;
        return ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 24) + ((bArr[1] & ThreadUtils.TYPE_SINGLE) << 16) + ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 8) + (bArr[3] & ThreadUtils.TYPE_SINGLE);
    }

    public static boolean get(int i2, int i3) {
        return (i2 & (1 << i3)) != 0;
    }

    public static final String getAlarmParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_alarm");
            jSONObject.put("cmd", 107);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int getAndroidVersion() {
        char[] charArray = Build.VERSION.RELEASE.toCharArray();
        String valueOf = (charArray == null || charArray.length < 1) ? null : String.valueOf(charArray[0]);
        if (valueOf == null) {
            return 0;
        }
        return Integer.valueOf(valueOf).intValue();
    }

    public static final String getCameraParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_parms");
            jSONObject.put("cmd", 101);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getCheckUser(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "check_user");
            jSONObject.put("cmd", 100);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getConnetState(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_prconnectstate");
            jSONObject.put("cmd", BuildConfig.VERSION_CODE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getDataFromDevice(String str, int i2, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", str);
            jSONObject.put("cmd", i2);
            jSONObject.put("user", str2);
            jSONObject.put("pwd", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static boolean getDay(int i2, int i3) {
        int i4 = i3 * 4;
        return get(i2, i4 + 0) || get(i2, i4 + 1) || get(i2, i4 + 2) || get(i2, i4 + 3);
    }

    public static final String getDeviceSupport(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_support");
            jSONObject.put("cmd", 133);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getDownloadFile(String str, String str2, int i2, String str3, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "download_file");
            jSONObject.put("cmd", 123);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ContentCommon.TYPE, i2);
            jSONObject.put("file_name", str3);
            jSONObject.put("offset", i3);
            jSONObject.put("control", i4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getFileNameWithTime(int i2) {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(1);
        int i4 = calendar.get(2) + 1;
        int i5 = calendar.get(5);
        int i6 = calendar.get(11);
        int i7 = calendar.get(12);
        int i8 = calendar.get(13);
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 == 0) {
            stringBuffer.append("IMG_");
        }
        stringBuffer.append(i3);
        if (i4 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i4);
        if (i5 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i5);
        stringBuffer.append('_');
        if (i6 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i6);
        if (i7 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i7);
        if (i8 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i8);
        if (i2 == 0) {
            stringBuffer.append(".jpg");
        } else if (i2 == 1) {
            stringBuffer.append(".mp4");
        }
        return stringBuffer.toString();
    }

    public static final String getFiles(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_3dpr_file");
            jSONObject.put("cmd", 203);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getIFrame(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_idr");
            jSONObject.put("cmd", 105);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getLocalIpAddress(Context context) {
        try {
            return int2ip(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String getOffTime(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_light_param");
            jSONObject.put("cmd", 121);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getPhotoList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_photo_list");
            jSONObject.put("cmd", 208);
            jSONObject.put("ymd", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getPushSupport(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_push_support");
            jSONObject.put("cmd", RecyclerView.MAX_SCROLL_DURATION);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_param");
            jSONObject.put("cmd", 199);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordDays(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_day");
            jSONObject.put("cmd", 205);
            jSONObject.put(TypeAdapters.AnonymousClass27.YEAR, i2);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordDays2020(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_day");
            jSONObject.put("cmd", 205);
            jSONObject.put(TypeAdapters.AnonymousClass27.YEAR, 2020);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_list");
            jSONObject.put("cmd", 206);
            jSONObject.put("ymd", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getSDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_sd");
            jSONObject.put("cmd", 109);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getSimOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getTemp(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_temp");
            jSONObject.put("cmd", 302);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getTest(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "debug_device");
            jSONObject.put("cmd", 136);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("shell", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUpdata(String str, String str2, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_upgrade_config");
            jSONObject.put("cmd", 130);
            jSONObject.put("check_version", i2);
            jSONObject.put("update_version", i3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUpdataParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_upgrade_config");
            jSONObject.put("cmd", 140);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUsersParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_user");
            jSONObject.put("cmd", 103);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getWifiParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_wifi");
            jSONObject.put("cmd", 112);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getXYZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_xyz");
            jSONObject.put("cmd", 304);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getYunTai(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_ptz");
            jSONObject.put("cmd", 119);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String int2ip(int i2) {
        return (i2 & ViewfinderView.OPAQUE) + "." + ((i2 >> 8) & ViewfinderView.OPAQUE) + "." + ((i2 >> 16) & ViewfinderView.OPAQUE) + "." + ViewfinderView.OPAQUE;
    }

    public static final byte[] intToByte(int i2) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = new Integer(i2 & ViewfinderView.OPAQUE).byteValue();
            i2 >>= 8;
        }
        return bArr;
    }

    public static final byte[] integerToFourBytes(int i2) {
        int i3 = (i2 > Math.pow(2.0d, 63.0d) ? 1 : (i2 == Math.pow(2.0d, 63.0d) ? 0 : -1));
        return new byte[]{(byte) ((i2 >>> 24) & ViewfinderView.OPAQUE), (byte) ((i2 >>> 16) & ViewfinderView.OPAQUE), (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE), (byte) (i2 & ViewfinderView.OPAQUE)};
    }

    public static final byte integerToOneByte(int i2) {
        int i3 = (i2 > Math.pow(2.0d, 15.0d) ? 1 : (i2 == Math.pow(2.0d, 15.0d) ? 0 : -1));
        return (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public static final byte[] integerToTwoBytes(int i2) {
        int i3 = (i2 > Math.pow(2.0d, 31.0d) ? 1 : (i2 == Math.pow(2.0d, 31.0d) ? 0 : -1));
        return new byte[]{(byte) ((i2 >>> 8) & ViewfinderView.OPAQUE), (byte) (i2 & ViewfinderView.OPAQUE)};
    }

    public static boolean isApModul(String str) {
        return (str.startsWith(ContentCommon.SHIX_APPRE1) || str.startsWith(ContentCommon.SHIX_APPRE) || str.startsWith(ContentCommon.SHIX_APPRE4) || str.startsWith(ContentCommon.SHIX_APPRE3) || str.startsWith(ContentCommon.SHIX_APPRE5) || str.startsWith(ContentCommon.SHIX_APPRE6)) && str.length() >= 14 && str.length() <= 20;
    }

    public static boolean isCN(Context context) {
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        return !TextUtils.isEmpty(simCountryIso) && simCountryIso.toUpperCase(Locale.US).contains("CN");
    }

    public static boolean isChinaSimCard(Context context) {
        String simOperator = getSimOperator(context);
        if (isOperatorEmpty(simOperator)) {
            return false;
        }
        return simOperator.startsWith("460");
    }

    public static boolean isContainChinese(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public static boolean isFlyme() {
        return false;
    }

    public static boolean isHW() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            MyLogUtils.d("", "HW_get EMUI version is:" + str);
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 2) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
            MyLogUtils.e("", " getEmuiVersion wrong, ClassNotFoundException");
        } catch (Exception unused2) {
            MyLogUtils.e("", " getEmuiVersion wrong");
        } catch (LinkageError unused3) {
            MyLogUtils.e("", " getEmuiVersion wrong, LinkageError");
        } catch (NoSuchMethodException unused4) {
            MyLogUtils.e("", " getEmuiVersion wrong, NoSuchMethodException");
        } catch (NullPointerException unused5) {
            MyLogUtils.e("", " getEmuiVersion wrong, NullPointerException");
        }
        return false;
    }

    public static final boolean isNotificationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 26 && ((NotificationManager) context.getSystemService("notification")).getImportance() == 0) {
            return false;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isOperatorEmpty(String str) {
        return str == null || str.equals("") || str.toLowerCase(Locale.US).contains(LogUtils.NULL);
    }

    public static final float jasonPaseFloat(JSONObject jSONObject, String str, float f2) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return f2;
        }
    }

    public static final int jasonPaseInt(JSONObject jSONObject, String str, int i2) {
        return jSONObject.optInt(str);
    }

    public static final String jasonPaseString(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }

    public static final byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static final String offPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_off");
            jSONObject.put("cmd", 317);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String offsetRecordFile(String str, String str2, String str3, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("offset", i2);
            jSONObject.put("filename", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final int oneByteToInteger(byte b2) {
        return b2 & ThreadUtils.TYPE_SINGLE;
    }

    public static final String pausePrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_pause");
            jSONObject.put("cmd", 314);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String pauseRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put(ContentCommon.TYPE, 0);
            jSONObject.put("filename", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String playRecordAudio(String str, String str2, String str3, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("audio", i2);
            jSONObject.put("filename", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String playRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put(ContentCommon.TYPE, 1);
            jSONObject.put("video", 1);
            jSONObject.put("audio", 0);
            jSONObject.put("filename", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final String rePlayRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put(ContentCommon.TYPE, 1);
            jSONObject.put("filename", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void requestNotify(Context context) {
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else if (i2 >= 21 && i2 < 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        } else if (Build.VERSION.SDK_INT == 19) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent.addFlags(268435456);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            } else if (i3 <= 8) {
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
            }
        }
        context.startActivity(intent);
    }

    public static final String resetXYZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_originxyz");
            jSONObject.put("cmd", 305);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String restartPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_restart");
            jSONObject.put("cmd", 316);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String resunmPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_resume");
            jSONObject.put("cmd", 315);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String scanWifi(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "scan_wifi");
            jSONObject.put("cmd", 113);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setBedtemp(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_bedtemp");
            jSONObject.put("cmd", InactivityTimer.INACTIVITY_DELAY_SECONDS);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tempture", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setCameraParms(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_parms");
            jSONObject.put("cmd", 108);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("oss_push_en", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setConnet(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_connect");
            jSONObject.put("cmd", 310);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setDisConnet(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_disconnect");
            jSONObject.put("cmd", 311);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setNoztemp(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_bedtemp");
            jSONObject.put("cmd", ErrorCorrection.MODULO_VALUE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tempture", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setX(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("xpos", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setY(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("ypos", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setZ(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("zpos", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startDJ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_startmotors");
            jSONObject.put("cmd", 306);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startFS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_startfan");
            jSONObject.put("cmd", 308);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopDJ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_stopmotors");
            jSONObject.put("cmd", 307);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopFS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_stopfan");
            jSONObject.put("cmd", 309);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopRecordFile(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put(ContentCommon.TYPE, 0);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final int twoBytesToInteger(byte[] bArr) {
        int length = bArr.length;
        return ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8) + (bArr[1] & ThreadUtils.TYPE_SINGLE);
    }

    @SuppressLint({"MissingPermission"})
    public static void Vibrate(Activity activity, long[] jArr, int i2) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(jArr, i2);
    }

    public static final String setCameraParms(String str, String str2, int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_parms");
            jSONObject.put("cmd", 711);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("oss_push_en", i2);
            jSONObject.put("ir_mode_timer_en", i3);
            jSONObject.put("ir_mode_start_sec", i4);
            jSONObject.put("ir_mode_end_sec", i5);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
