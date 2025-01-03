package com.shix.shixipc.activity;

import a.h.a.a;
import a.k.a.n;
import a.k.a.r;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import c.g.a.b;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.gson.Gson;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.he.Constant;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.SearchIPBean;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.he.VideoModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.ThreadUtils;
import com.shix.shixipc.utils.ByteUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.PermissionXUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NUIMainActivity extends BaseActivity implements View.OnClickListener, FragmentCameraList.NewUiMainInterface, ViewPager.j {
    public static final int REQUEST_CODE = 1024;
    public static final int RP_WRITE = 2;
    public static AddCameraInterface1 addCameraInterface;
    public static ConnectStatusInterface1 connectStatusInterface;
    public static IPPlayInterface ipPlayInterface;
    public static IpcamClientInterface ipcamClientInterface;
    public static PlayBackInterface playBackInterface;
    public static PlayInterface playInterface;
    public static PlayFramgent0Interface playInterface0;
    public static PlayFramgent1Interface playInterface1;
    public static PlayFramgent2Interface playInterface2;
    public static PlayFramgent3Interface playInterface3;
    public static ArDeviceCodeConnect sArDeviceCodeConnect;
    public static DownloadFileInterface sDownloadFileInterface;
    public static SHIXCOMMONInterface106 sInterface106;
    public static LocalNetAdd sLocalNetAddConnect;
    public static SHIXCOMMONInterface shixOMMONInterface;
    public LinearLayout bottom_tab;
    public int devType;
    public FragmentCameraList fragmentCameraList;
    public FragmentManager fragmentManager;
    public FragmentPicture fragmentPicture;
    public FragmentPicture fragmentSdCard;
    public FragmentPicture fragmentVideo;
    public FrameLayout frameRoot;
    public ImageView imageView1;
    public ImageView imageView2;
    public ImageView imageView3;
    public ImageView imageView4;
    public boolean isGetSnap;
    public boolean isSnap;
    public LinearLayout layoutCamera;
    public LinearLayout layoutPic;
    public LinearLayout layoutSdcard;
    public LinearLayout layoutVideo;
    public ArrayList<Fragment> mFragments;
    public SharedPreferences preSHIX;
    public SharedPreferences preuser;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public ViewPager viewPager;
    public String TAG = "NUIMainActivity";
    public int snapCount = 0;
    public int mFinalCount = 0;

    public interface AddCameraInterface1 {
        void callBackSearchResultData(int i2, String str, String str2, String str3, String str4, int i3);
    }

    public interface ArDeviceCodeConnect {
        void ArDeviceCodeConnectStatus(int i2, int i3, int i4);
    }

    public interface ConnectStatusInterface1 {
        void BSCallBack_TYPEMODE(String str, String str2);

        void BSMsgNotifyData(String str, int i2, int i3);

        void ConnectStatus(int i2, int i3, int i4);
    }

    public interface DownloadFileInterface {
        void callBackDownloadFile(int i2, byte[] bArr, int i3, int i4, int i5, int i6);
    }

    public interface IPPlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5);

        void callBackAudioData(byte[] bArr, int i2);

        void callBackCameraParamNotify(String str, int i2, int i3, int i4, int i5, int i6, int i7);

        void callBackH264Data(byte[] bArr, int i2, int i3);

        void callBackMessageNotify(String str, int i2, int i3);
    }

    public interface IpcamClientInterface {
        void BSMsgNotifyData(String str, int i2, int i3);

        void BSSnapshotNotify(String str, byte[] bArr, int i2);

        void callBaceVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5);

        void callBackAudioData(byte[] bArr, int i2);

        void callBackH264Data(String str, byte[] bArr, int i2, int i3);

        void callBackMessageNotify(String str, int i2, int i3);
    }

    public interface LocalNetAdd {
        void LocalNetAddConnectStatus(int i2, int i3, int i4);
    }

    public class MyAdapter extends n {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // a.x.a.a
        public int getCount() {
            return NUIMainActivity.this.mFragments.size();
        }

        @Override // a.k.a.n
        public Fragment getItem(int i2) {
            return (Fragment) NUIMainActivity.this.mFragments.get(i2);
        }
    }

    public interface PlayBackInterface {
        void callBackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6);

        void callBackPlayBackPicData(int i2, byte[] bArr, int i3, VideoModel videoModel);

        void callBackPlayBackVideoData(int i2, byte[] bArr, int i3, VideoModel videoModel);

        void callBackPlaybackAudioData(byte[] bArr, int i2, byte[] bArr2);

        void callBackPlaybackDecVideoData(byte[] bArr, int i2, int i3, byte[] bArr2);
    }

    public interface PlayFramgent0Interface {
        void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    public interface PlayFramgent1Interface {
        void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    public interface PlayFramgent2Interface {
        void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    public interface PlayFramgent3Interface {
        void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    public interface PlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        void callBackAudioData(byte[] bArr, int i2);

        void callBackCameraParamNotify(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

        void callBackConnectLook(String str, int i2, int i3);

        void callBackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6);

        void callBackLiveStatusNotify(int i2, int i3, int i4);

        void callBackMessageNotify(String str, int i2, int i3);

        void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2);

        void callbackVideoData(int i2, byte[] bArr, int i3, VideoModel videoModel);
    }

    public interface SHIXCOMMONInterface {
        void CallBackSHIXJasonCommon(String str, String str2);
    }

    public interface SHIXCOMMONInterface106 {
        void CallBackSHIXJason106(String str, String str2);
    }

    private void CallBack_RecordFileSearchResult(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    private void PPPPMsgNotify(int i2, int i3, int i4) {
        String did = DeviceUtil.INSTANCE.getDid(i2);
        MyLogUtils.e("tag", "PPPPMsgNotify f_niFd=" + i2 + " ,f_nlMsgType= " + i3 + " ,f_nlPara= " + i4);
        PlayInterface playInterface4 = playInterface;
        if (playInterface4 != null) {
            playInterface4.callBackLiveStatusNotify(i2, i3, i4);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBackMessageNotify(did, i3, i4);
        }
        ArDeviceCodeConnect arDeviceCodeConnect = sArDeviceCodeConnect;
        if (arDeviceCodeConnect != null) {
            arDeviceCodeConnect.ArDeviceCodeConnectStatus(i2, i3, i4);
        }
        LocalNetAdd localNetAdd = sLocalNetAddConnect;
        if (localNetAdd != null) {
            localNetAdd.LocalNetAddConnectStatus(i2, i3, i4);
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSMsgNotifyData(did, i3, i4);
        }
        if (connectStatusInterface != null) {
            MyLogUtils.d("PPPPMsgNotify", "首页 PPPPMsgNotify  ");
            connectStatusInterface.ConnectStatus(i2, i3, i4);
        }
    }

    private void PPPPSnapshotNotify(String str, byte[] bArr, int i2) {
        MyLogUtils.d("PPPPSnapshotNotify", "SHIXCONNET did:" + str + " len:" + i2);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i2);
        }
    }

    private void VideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        MyLogUtils.d("VideoData", "MainActivity  SHIXCONNET VideoData...h264Data:" + i2 + " len==" + i3 + " videobuf len==" + bArr.length + "  time==" + i6 + "  vOrh==" + i7 + "  allframe==" + i8 + "  signalvalue==" + i9 + " endflag=" + i10);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBaceVideoData(str, bArr, i2, i3, i4, i5);
        }
        PlayInterface playInterface4 = playInterface;
        if (playInterface4 != null) {
            playInterface4.callBaceVideoData(str, bArr, i2, bArr.length, i4, i5, i6, i8, i7, i9, i10);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBaceVideoData(str, bArr, i2, i3, i4, i5);
        }
    }

    private void clearSelection() {
        this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera);
        this.imageView2.setImageResource(StyleCommon.IMG_Menu_Pic);
        this.imageView3.setImageResource(StyleCommon.IMG_Menu_Video);
        this.imageView4.setImageResource(StyleCommon.IMG_Menu_Sdcard);
        this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView2.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void findViewInit() {
        this.bottom_tab = (LinearLayout) findViewById(R.id.bottom_tab);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.frameRoot = (FrameLayout) findViewById(R.id.frameRoot);
        this.layoutCamera = (LinearLayout) findViewById(R.id.main_layout_camera);
        this.layoutPic = (LinearLayout) findViewById(R.id.main_layout_pic);
        this.layoutVideo = (LinearLayout) findViewById(R.id.main_layout_video);
        this.layoutSdcard = (LinearLayout) findViewById(R.id.main_layout_sdcard);
        this.layoutCamera.setOnClickListener(this);
        this.layoutPic.setOnClickListener(this);
        this.layoutVideo.setOnClickListener(this);
        this.layoutSdcard.setOnClickListener(this);
        this.imageView1 = (ImageView) findViewById(R.id.main_img_camera);
        this.imageView2 = (ImageView) findViewById(R.id.main_img_picture);
        this.imageView3 = (ImageView) findViewById(R.id.main_img_video);
        this.imageView4 = (ImageView) findViewById(R.id.main_img_sdcard);
        this.textView1 = (TextView) findViewById(R.id.main_tv_camera);
        this.textView2 = (TextView) findViewById(R.id.main_tv_picture);
        this.textView3 = (TextView) findViewById(R.id.main_tv_video);
        this.textView4 = (TextView) findViewById(R.id.main_tv_sdcard);
        this.mFragments = new ArrayList<>();
        this.fragmentCameraList = new FragmentCameraList();
        this.fragmentPicture = new FragmentPicture(0);
        this.fragmentVideo = new FragmentPicture(1);
        this.fragmentSdCard = new FragmentPicture(2);
        this.mFragments.add(this.fragmentCameraList);
        this.mFragments.add(this.fragmentPicture);
        this.mFragments.add(this.fragmentVideo);
        this.mFragments.add(this.fragmentSdCard);
        this.viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        this.viewPager.setOffscreenPageLimit(4);
        this.viewPager.addOnPageChangeListener(this);
        this.viewPager.setCurrentItem(0);
    }

    private void hideFragments(r rVar) {
        FragmentCameraList fragmentCameraList = this.fragmentCameraList;
        if (fragmentCameraList != null) {
            rVar.c(fragmentCameraList);
        }
        FragmentPicture fragmentPicture = this.fragmentPicture;
        if (fragmentPicture != null) {
            rVar.c(fragmentPicture);
        }
        FragmentPicture fragmentPicture2 = this.fragmentVideo;
        if (fragmentPicture2 != null) {
            rVar.c(fragmentPicture2);
        }
        FragmentPicture fragmentPicture3 = this.fragmentSdCard;
        if (fragmentPicture3 != null) {
            rVar.c(fragmentPicture3);
        }
    }

    public static void setAddCameraInterface1(AddCameraInterface1 addCameraInterface1) {
        addCameraInterface = addCameraInterface1;
    }

    public static void setArDeviceCodeConnect(ArDeviceCodeConnect arDeviceCodeConnect) {
        sArDeviceCodeConnect = arDeviceCodeConnect;
    }

    public static void setCallBackDownLoadFile(DownloadFileInterface downloadFileInterface) {
        sDownloadFileInterface = downloadFileInterface;
    }

    public static void setConnectStatusInterface1(ConnectStatusInterface1 connectStatusInterface1) {
        connectStatusInterface = connectStatusInterface1;
    }

    public static void setIpPlayInterface(IPPlayInterface iPPlayInterface) {
        ipPlayInterface = iPPlayInterface;
    }

    public static void setIpcamClientInterface(IpcamClientInterface ipcamClientInterface2) {
        ipcamClientInterface = ipcamClientInterface2;
    }

    public static void setLocalNetAddConnect(LocalNetAdd localNetAdd) {
        sLocalNetAddConnect = localNetAdd;
    }

    public static void setPlayBackInterface(PlayBackInterface playBackInterface2) {
        playBackInterface = playBackInterface2;
    }

    public static void setPlayFramgent0Interface(PlayFramgent0Interface playFramgent0Interface) {
        playInterface0 = playFramgent0Interface;
    }

    public static void setPlayFramgent1Interface(PlayFramgent1Interface playFramgent1Interface) {
        playInterface1 = playFramgent1Interface;
    }

    public static void setPlayFramgent2Interface(PlayFramgent2Interface playFramgent2Interface) {
        playInterface2 = playFramgent2Interface;
    }

    public static void setPlayFramgent3Interface(PlayFramgent3Interface playFramgent3Interface) {
        playInterface3 = playFramgent3Interface;
    }

    public static void setPlayInterface(PlayInterface playInterface4) {
        playInterface = playInterface4;
    }

    public static void setSHIXCOMMONInterface(SHIXCOMMONInterface sHIXCOMMONInterface) {
        shixOMMONInterface = sHIXCOMMONInterface;
    }

    public static void setSHIXOMMONInterface106(SHIXCOMMONInterface106 sHIXCOMMONInterface106) {
        sInterface106 = sHIXCOMMONInterface106;
    }

    private void setTabSelection(int i2) {
        clearSelection();
        if (i2 == 0) {
            BarUtils.setStatusBarColor(this, 0).setBackgroundResource(R.color.white);
            this.frameRoot.setBackgroundColor(getResources().getColor(R.color.white));
            this.bottom_tab.setBackground(null);
            this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera_Press);
            this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            return;
        }
        if (i2 == 1) {
            BarUtils.setStatusBarColor(this, 0).setBackgroundResource(R.color.white);
            this.frameRoot.setBackgroundColor(getResources().getColor(R.color.color_EDEDED));
            this.bottom_tab.setBackgroundColor(getResources().getColor(R.color.white));
            this.imageView2.setImageResource(StyleCommon.IMG_Menu_Pic_Press);
            this.textView2.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            return;
        }
        if (i2 == 2) {
            BarUtils.setStatusBarColor(this, 0).setBackgroundResource(R.color.white);
            this.frameRoot.setBackgroundColor(getResources().getColor(R.color.color_EDEDED));
            this.bottom_tab.setBackgroundColor(getResources().getColor(R.color.white));
            this.imageView3.setImageResource(StyleCommon.IMG_Menu_Video_Press);
            this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            return;
        }
        if (i2 != 3) {
            return;
        }
        BarUtils.setStatusBarColor(this, 0).setBackgroundResource(R.color.white);
        this.frameRoot.setBackgroundColor(getResources().getColor(R.color.color_EDEDED));
        this.bottom_tab.setBackgroundColor(getResources().getColor(R.color.white));
        this.imageView4.setImageResource(StyleCommon.IMG_Menu_Sdcard_Press);
        this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
    }

    @TargetApi(19)
    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.sd_card_permissions_title)).setMessage(getResources().getString(R.string.sd_card_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NUIMainActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NUIMainActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    NUIMainActivity.this.toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.NUIMainActivity.4.1
                        @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
                        public void onResult(boolean z2) {
                        }
                    });
                }
            });
        }
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCheckPermission(PermissionXUtils.OnPermissionCallback onPermissionCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"}, onPermissionCallback);
        } else {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, onPermissionCallback);
        }
    }

    public void AudioData(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        MyLogUtils.e("tag", "MainActivity AudioData  f_niFd=" + i2 + " f_pncAData=" + bArr.length + " f_nlALen=" + i3 + "  f_pncAPara=" + bArr2.length + "  f_nlAParaLen=" + i4);
        StringBuilder sb = new StringBuilder();
        sb.append("AudioData f_pncVPara=");
        sb.append(ByteUtil.getString(bArr2, "utf-8"));
        MyLogUtils.e("tag", sb.toString());
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackAudioData(bArr, i3);
        }
        PlayInterface playInterface4 = playInterface;
        if (playInterface4 != null) {
            playInterface4.callBackAudioData(bArr, i3);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackAudioData(bArr, i3, bArr2);
        }
    }

    public void CallBackDecVData(int i2, int i3, byte[] bArr, int i4, int i5, int i6, byte[] bArr2, int i7) {
        PlayBackInterface playBackInterface2;
        PlayInterface playInterface4;
        if (i3 == 0 && (playInterface4 = playInterface) != null) {
            playInterface4.callbackDecVideoData(i2, bArr, i5, i6, bArr2);
        }
        PlayFramgent0Interface playFramgent0Interface = playInterface0;
        if (playFramgent0Interface != null) {
            playFramgent0Interface.callbackDecVideoData(i2, bArr, i5, i6, bArr2);
        }
        PlayFramgent1Interface playFramgent1Interface = playInterface1;
        if (playFramgent1Interface != null) {
            playFramgent1Interface.callbackDecVideoData(i2, bArr, i5, i6, bArr2);
        }
        PlayFramgent2Interface playFramgent2Interface = playInterface2;
        if (playFramgent2Interface != null) {
            playFramgent2Interface.callbackDecVideoData(i2, bArr, i5, i6, bArr2);
        }
        PlayFramgent3Interface playFramgent3Interface = playInterface3;
        if (playFramgent3Interface != null) {
            playFramgent3Interface.callbackDecVideoData(i2, bArr, i5, i6, bArr2);
        }
        if (i3 != 1 || (playBackInterface2 = playBackInterface) == null) {
            return;
        }
        playBackInterface2.callBackPlaybackDecVideoData(bArr, i5, i6, bArr2);
    }

    @Override // com.shix.shixipc.activity.FragmentCameraList.NewUiMainInterface
    public void CallBackStyle(int i2) {
        StyleCommon.COM_STYLE = i2;
        if (i2 == 1) {
            this.bottom_tab.setVisibility(8);
        } else {
            this.bottom_tab.setVisibility(0);
        }
    }

    public void CallBackTransferMessage(String str, String str2, int i2) {
        MyLogUtils.d("CallBackTransferMessage", "SHIXCONNET SHIXTRANS did:" + str + "  strJason:" + str2.substring(str2.indexOf("{"), str2.indexOf("}") + 1) + " cmd:" + i2);
    }

    public void CallBackTransferMessageB(String str, byte[] bArr) {
        MyLogUtils.d("CallBackTransferMessageB", "SHIXCONNET SHIXTRANS did:" + str + " buffer.length=" + bArr.length + " buffer=" + ByteUtil.Bytes2HexString(bArr));
        for (byte b2 : bArr) {
            MyLogUtils.d("CallBackTransferMessageB", "SHIXCONNET SHIXTRANS buffer=" + Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE));
        }
    }

    public void CallBackTransferMessageBin(int i2, int i3, byte[] bArr, int i4) {
        MyLogUtils.e("tag", "CallBackTransferMessage i1=$i1 ,i2=$i2 ,f_pncAlarm=$f_pncAlarm ,i3=$i3");
        MyLogUtils.e("tag", "CallBackTransferMessage f_pncAlarm=" + ByteUtil.getString(bArr, "utf-8"));
        ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr, 2, 2));
        MyLogUtils.e("tag", "CallBackTransferMessage cmd=" + ByteUtil.byteArrToHexString(ByteUtil.getByteArrSkip(bArr, 2, 2)));
        MyLogUtils.e("tag", "10进制=" + ByteUtil.binary(bArr, 10));
        MyLogUtils.e("tag", "16进制=" + ByteUtil.binary(bArr, 16));
    }

    public void CallBackWriteLog(String str, int i2) {
        MyLogUtils.e("tag", "CallBackWriteLog");
    }

    public void CallBack_AlarmNotify(String str, int i2) {
        MyLogUtils.d("tag", "callBack_AlarmNotify3 did:" + str + " alarmtype:" + i2);
    }

    public void CallBack_AlarmNotifyDoorBell(String str, String str2, String str3, String str4) {
        MyLogUtils.e(ContentCommon.SERVER_STRING, "doorbell:db_did:" + str3 + "  db_type:" + str4 + "  db_time:" + str2);
    }

    public void CallBack_AlarmParams(int i2, int i3, byte[] bArr, int i4) {
        MyLogUtils.e("tag", "CallBack_AlarmParams");
    }

    public void CallBack_H264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        MyLogUtils.e("tag", "CallBack_H264Data  did=" + str + "  h264=" + bArr.length + "  size=" + i3 + "  framno=" + i4 + "  type=" + i2 + " framerate:" + i5 + " frametype:" + i6);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackH264Data(str, bArr, i2, i3);
        }
        PlayInterface playInterface4 = playInterface;
        if (playInterface4 != null) {
            playInterface4.callBackH264Data(str, bArr, i2, i3, i5, i6, i4);
        }
    }

    public void CallBack_PPPPMsgNotify(int i2, int i3, int i4) {
        MyLogUtils.e("tag", "CallBack_PPPPMsgNotify");
    }

    public void CallBack_PlaybackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        MyLogUtils.e("tag", "CallBack_H264Data  did=" + str + "  h264=" + bArr.length + "  size=" + i3 + "  framno=" + i4 + "  type=" + i2 + " framerate:" + i5 + " frametype:" + i6);
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackH264Data(str, bArr, i2, i3, i4, i5, i4);
        }
    }

    public void CallBack_SendAudioData(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        MyLogUtils.e("tag", "MainActivity CallBack_SendAudioData  f_niFd=" + i2 + " h264=" + bArr.length + " f_nlVLen=" + i3 + "  f_pncVPara=" + bArr2.length + "  f_nlVParaLen=" + i4);
        StringBuilder sb = new StringBuilder();
        sb.append("10进制=");
        sb.append(ByteUtil.binary(bArr2, 10));
        MyLogUtils.e("tag", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("16进制=");
        sb2.append(ByteUtil.binary(bArr2, 16));
        MyLogUtils.e("tag", sb2.toString());
        MyLogUtils.e("tag", "SearchResult=" + ByteUtil.getString(bArr2, "utf-8") + "** " + i4);
        String ByteToString = ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 0, 4));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("startcode= ");
        sb3.append(ByteToString);
        MyLogUtils.e("tag", sb3.toString());
        MyLogUtils.e("tag", "type= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 4, 1)));
        MyLogUtils.e("tag", "militime= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 5, 2)));
        MyLogUtils.e("tag", "sectime= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 7, 4)));
        MyLogUtils.e("tag", "frameno= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 11, 4)));
        MyLogUtils.e("tag", "len= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 15, 4)));
        MyLogUtils.e("tag", "version= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 19, 1)));
        MyLogUtils.e("tag", "sessid= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 20, 1)));
        int i5 = i4 + (-8);
        int i6 = i4 - 4;
        MyLogUtils.e("tag", "nowframe= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, i5, i6)));
        MyLogUtils.e("tag", "allframe= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, i6, 4)));
    }

    public void CallBack_SendVedioData(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        MyLogUtils.e("tag", "MainActivity CallBack_SendVedioData  f_niFd=" + i2 + " h264=" + bArr.length + " f_nlVLen=" + i3 + "  f_pncVPara=" + bArr2.length + "  f_nlVParaLen=" + i4);
        StringBuilder sb = new StringBuilder();
        sb.append("10进制=");
        sb.append(ByteUtil.binary(bArr2, 10));
        MyLogUtils.e("tag", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("16进制=");
        sb2.append(ByteUtil.binary(bArr2, 16));
        MyLogUtils.e("tag", sb2.toString());
        MyLogUtils.e("tag", "SearchResult=" + ByteUtil.getString(bArr2, "utf-8") + "** " + i4);
        String ByteToString = ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 0, 4));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("head= ");
        sb3.append(ByteToString);
        MyLogUtils.e("tag", sb3.toString());
        MyLogUtils.e("tag", "timestamp= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 4, 4)));
        MyLogUtils.e("tag", "len= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 8, 4)));
        MyLogUtils.e("tag", "frametype= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 12, 4)));
        MyLogUtils.e("tag", "streamid= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 16, 4)));
        MyLogUtils.e("tag", "time= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 20, 8)));
        MyLogUtils.e("tag", "frameno= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 28, 4)));
        MyLogUtils.e("tag", "version= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 32, 1)));
        MyLogUtils.e("tag", "framerate= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 33, 1)));
        MyLogUtils.e("tag", "nowframe1= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 34, 1)));
        MyLogUtils.e("tag", "signalvalue= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 35, 1)));
        MyLogUtils.e("tag", "allframe= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 36, 4)));
        MyLogUtils.e("tag", "startcode= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 40, 4)));
        MyLogUtils.e("tag", "nowframe2= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 41, 1)));
        MyLogUtils.e("tag", "spareframe= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 42, 1)));
        MyLogUtils.e("tag", "endflag= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 43, 1)));
        MyLogUtils.e("tag", "res= " + ByteUtil.ByteToString(ByteUtil.getByteArrSkip(bArr2, 44, 1)));
    }

    public void CallBack_Snapshot(String str, byte[] bArr, int i2) {
        MyLogUtils.d("ddd", "SHIXCONNET CallBack_Snapshot");
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i2);
        }
    }

    public void CallBack_TYPEMODE(String str, String str2) {
        ConnectStatusInterface1 connectStatusInterface1 = connectStatusInterface;
        if (connectStatusInterface1 != null) {
            connectStatusInterface1.BSCallBack_TYPEMODE(str, str2);
        }
    }

    public void CallBack_TransferMsg(int i2, int i3, byte[] bArr, int i4) {
        MyLogUtils.e("tag", "CallBack_TransferMsg");
    }

    public void CallBack_VideoTrans_H264H265(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
    }

    public String GetNetIp() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://ip.taobao.com/service/getIpInfo2.php?ip=myip").openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36");
            if (httpURLConnection.getResponseCode() != 200) {
                MyLogUtils.e("提示", "网络连接异常，无法获取IP地址！");
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + OSSUtils.NEW_LINE);
            }
            JSONObject jSONObject = new JSONObject(sb.toString());
            String string = jSONObject.getString(JThirdPlatFormInterface.KEY_CODE);
            MyLogUtils.e("", "提示：" + sb.toString());
            if (!string.equals("0")) {
                MyLogUtils.e("提示", "IP接口异常，无法获取IP地址！");
                return "";
            }
            String string2 = jSONObject.getJSONObject(JThirdPlatFormInterface.KEY_DATA).getString("country");
            CommonUtil.Log(1, "CHANA IP:" + string2);
            if (string2 != null && string2.length() > 0) {
                if (!CommonUtil.isContainChinese(string2) && !string2.equalsIgnoreCase("中国") && !string2.equalsIgnoreCase("cn")) {
                    SystemValue.isInCn = 2;
                    CommonUtil.Log(1, "CHANA IP isInCn:" + SystemValue.isInCn);
                    SharedPreferences.Editor edit = this.preuser.edit();
                    edit.putInt("isInCn", SystemValue.isInCn);
                    edit.commit();
                }
                SystemValue.isInCn = 1;
                CommonUtil.Log(1, "CHANA IP isInCn:" + SystemValue.isInCn);
                SharedPreferences.Editor edit2 = this.preuser.edit();
                edit2.putInt("isInCn", SystemValue.isInCn);
                edit2.commit();
            }
            MyLogUtils.e("提示", "您的IP地址是：" + string2);
            return string2;
        } catch (Exception e2) {
            MyLogUtils.e("提示", "获取IP地址时出现异常，异常信息是：" + e2.toString());
            return "";
        }
    }

    public void GetNetIpSOHU() {
        new Thread() { // from class: com.shix.shixipc.activity.NUIMainActivity.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine + OSSUtils.NEW_LINE);
                        }
                        inputStream.close();
                        String substring = sb.substring(sb.indexOf("{"), sb.indexOf("}") + 1);
                        if (substring != null) {
                            try {
                                String optString = new JSONObject(substring).optString("cname");
                                CommonUtil.Log(1, "CHANA line:" + optString);
                                if (optString != null && optString.length() > 0) {
                                    if (CommonUtil.isContainChinese(optString)) {
                                        SystemValue.isInCn = 1;
                                    } else {
                                        SystemValue.isInCn = 2;
                                    }
                                    CommonUtil.Log(1, "CHANA SystemValue.isInCn:" + SystemValue.isInCn);
                                    SharedPreferences.Editor edit = NUIMainActivity.this.preuser.edit();
                                    edit.putInt("isInCn", SystemValue.isInCn);
                                    edit.commit();
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                NUIMainActivity.this.GetNetIp();
            }
        }.start();
    }

    public void MessageNotify(int i2, int i3, int i4) {
        MyLogUtils.e("tag", "MessageNotify iFd= " + i2 + " ,f_nlMsgType= " + i3 + " ,f_nlPara= " + i4);
    }

    public void SearchResult(byte[] bArr, int i2) {
        String string = ByteUtil.getString(bArr, "utf-8");
        MyLogUtils.e("tag", "MainActivity SearchResult= " + string);
        SearchIPBean searchIPBean = (SearchIPBean) new Gson().fromJson(string, SearchIPBean.class);
        AddCameraInterface1 addCameraInterface1 = addCameraInterface;
        if (addCameraInterface1 != null) {
            addCameraInterface1.callBackSearchResultData(0, searchIPBean.getSzIpAddr(), searchIPBean.getSzDevName(), searchIPBean.getDwDeviceID(), searchIPBean.getSzIpAddr(), searchIPBean.getINewConfig());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1024 || Build.VERSION.SDK_INT < 30) {
            return;
        }
        if (Environment.isExternalStorageManager()) {
            MyLogUtils.e("权限", "NUIMainActivity  onActivityResult申请权限 成功");
        } else {
            MyLogUtils.e("权限", "NUIMainActivity  onActivityResult申请权限 失败");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_layout_camera /* 2131231208 */:
                this.viewPager.setCurrentItem(0);
                SpUtil.INSTANCE.encode("isRefresh", (Object) false);
                setTabSelection(0);
                break;
            case R.id.main_layout_pic /* 2131231209 */:
                this.viewPager.setCurrentItem(1);
                setTabSelection(1);
                break;
            case R.id.main_layout_sdcard /* 2131231211 */:
                this.viewPager.setCurrentItem(3);
                SpUtil.INSTANCE.encode("isRefresh", (Object) false);
                setTabSelection(3);
                break;
            case R.id.main_layout_video /* 2131231213 */:
                this.viewPager.setCurrentItem(2);
                setTabSelection(2);
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aictivity_nuimain);
        ContentCommon.FCM_APP_KEY = stringFcmAppKeyFromJNI();
        SpUtil.INSTANCE.clearAll();
        SystemValue.isInCn = 0;
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        SystemValue.isInCn = this.preuser.getInt("isInCn", 0);
        this.fragmentManager = getSupportFragmentManager();
        findViewInit();
        setTabSelection(0);
        NativeCallerTools.SDKAPISetCallbackContext(this);
        this.isGetSnap = true;
        this.isSnap = true;
        this.snapCount = 0;
        SystemValue.isExitBackGoudExit = true;
        CommonUtil.Log(1, "SHIXPUSH ContentCommon.XM_STRING :" + ContentCommon.XM_STRING);
        String registrationID = JPushInterface.getRegistrationID(getApplicationContext());
        ContentCommon.JPUSH_REGID = registrationID;
        MyLogUtils.d("push", "极光推送id=" + registrationID);
        JPushInterface.getAllTags(this, 1);
        toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.NUIMainActivity.1
            @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
            public void onResult(boolean z) {
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NativeCallerTools.SDKAPICleanUp();
        SystemValue.checkSDStatu = 0;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10L);
        }
        if (i2 == 82) {
            return false;
        }
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        finish();
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i2) {
        if (i2 == 0) {
            this.isGetSnap = true;
            setTabSelection(0);
            return;
        }
        if (i2 == 1) {
            this.isGetSnap = false;
            SpUtil.INSTANCE.encode("request_file_permission", (Object) false);
            setTabSelection(1);
            this.fragmentPicture.updateUI();
            return;
        }
        if (i2 == 2) {
            this.isGetSnap = false;
            SpUtil.INSTANCE.encode("request_file_permission", (Object) false);
            setTabSelection(2);
            this.fragmentVideo.updateUI();
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.isGetSnap = false;
        SpUtil.INSTANCE.encode("request_file_permission", (Object) false);
        setTabSelection(3);
        this.fragmentSdCard.updateUI();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.isGetSnap = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        MyLogUtils.e("权限", "NUIMainActivity 申请权限 提示");
        if (iArr.length == 0) {
            return;
        }
        if (2 != i2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] == 0) {
            MyLogUtils.e("权限", "NUIMainActivity 申请权限 成功");
            return;
        }
        MyLogUtils.e("权限", "NUIMainActivity 申请权限 失败");
        if (iArr[0] != 0) {
            if (a.a((Activity) this, Permission.WRITE_EXTERNAL_STORAGE)) {
                showDialog(true);
            } else {
                showDialog(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isGetSnap = true;
    }

    public native String stringFcmAppKeyFromJNI();

    public void CallBack_AlarmNotify(String str, String str2) {
        MyLogUtils.d("tag", "callBack_AlarmNotify4 did:" + str + " alarmtype:" + str2);
    }

    public void CallBackTransferMessage(int i2, int i3, String str) {
        String str2;
        MyLogUtils.e("tag", "CallBackTransferMessage f_niFd=" + i2 + ",f_niMsgType=0x" + ByteUtil.ten2Hex(i3) + ",msg=" + str);
        if (SpUtil.INSTANCE.queryKey(Constant.MMKV_sdkId + i2).booleanValue()) {
            str2 = SpUtil.INSTANCE.decodeString(Constant.MMKV_sdkId + i2);
        } else {
            str2 = "";
        }
        SHIXCOMMONInterface sHIXCOMMONInterface = shixOMMONInterface;
        if (sHIXCOMMONInterface != null) {
            sHIXCOMMONInterface.CallBackSHIXJasonCommon(str2, str);
        } else {
            MyLogUtils.d("CallBackTransferMessage", "CallBackTransferMessage shixOMMONInterface = null");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cmd") && 106 == jSONObject.optInt("cmd") && sInterface106 != null) {
                sInterface106.CallBackSHIXJason106(str2, str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void CallBack_AlarmNotify(int i2, int i3, byte[] bArr, int i4) {
        MyLogUtils.e("tag", "callBack_AlarmNotify did:" + i2 + " alarmtype:" + i3);
    }

    public void VideoData(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        DownloadFileInterface downloadFileInterface;
        PlayBackInterface playBackInterface2;
        PlayInterface playInterface4;
        VideoModel videoModel = (VideoModel) new Gson().fromJson(ByteUtil.getString(bArr2, "utf-8"), VideoModel.class);
        if (SpUtil.INSTANCE.queryKey(Constant.MMKV_sdkId + i2).booleanValue()) {
            SpUtil.INSTANCE.decodeString(Constant.MMKV_sdkId + i2);
        }
        if (videoModel.getRes() == 0 && (playInterface4 = playInterface) != null) {
            playInterface4.callbackVideoData(i2, bArr, i3, videoModel);
        }
        if (videoModel.getRes() == 1) {
            if (videoModel.getVersion() == 1) {
                PlayBackInterface playBackInterface3 = playBackInterface;
                if (playBackInterface3 != null) {
                    playBackInterface3.callBackPlayBackVideoData(i2, bArr, i3, videoModel);
                }
            } else if (videoModel.getVersion() == 2 && (playBackInterface2 = playBackInterface) != null) {
                playBackInterface2.callBackPlayBackPicData(i2, bArr, i3, videoModel);
            }
        }
        if (videoModel.getRes() == 1 && videoModel.getVersion() == 2 && (downloadFileInterface = sDownloadFileInterface) != null) {
            downloadFileInterface.callBackDownloadFile(i2, bArr, videoModel.getAllframe(), videoModel.getAllframe(), videoModel.getFramerate(), videoModel.getFrameno());
        }
    }
}
