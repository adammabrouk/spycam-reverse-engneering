package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.e;
import c.g.a.b;
import c.j.a.c;
import c.k.c.a.l;
import cn.jpush.android.api.JPushInterface;
import com.google.zxing.camera.AutoFocusCallback;
import com.google.zxing.decoding.InactivityTimer;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.NDNCameraLiveActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.bean.DateModel;
import com.shix.shixipc.bean.DeviceSupportModel;
import com.shix.shixipc.bean.YunTaiModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.VideoModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.Rom;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.AacEncode;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.ByteUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomAudioRecorder;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.DisplayUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyAudioPlayer;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.PermissionXUtils;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.view.SwitchView;
import com.shix.shixipc.view.ZoomView;
import com.xyx.mp4.Mp4VideoData;
import com.xyx.mp4.Mp4WriteData;
import com.xyx.mp4.NativeImplement;
import g.a.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NDNCameraLiveActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.PlayInterface, NUIMainActivity.SHIXCOMMONInterface, CustomAudioRecorder.AudioRecordResult {
    public static final int AUDIO_BUFFER_START_CODE = 16711935;
    public static final int REFRESH_RECORD_TIME = 4;
    public static final int RP_AUDIO = 3;
    public static final int RP_WRITE = 2;
    public AlphaAnimation alphaAnimation;
    public LinearLayout audioLayout;
    public AudioManager audioManager;
    public long availableBlocks;
    public int batcapacity;
    public long blockSize;
    public Button btn1080;
    public Button btn2k;
    public Button btn4k;
    public Button btn720;
    public Button btnPtz_cer;
    public ImageButton btnPtz_down;
    public ImageButton btnPtz_large;
    public ImageButton btnPtz_left;
    public ImageButton btnPtz_right;
    public ImageButton btnPtz_small;
    public ImageButton btnPtz_up;
    public Button btnTouch;
    public Button btnTut1080;
    public Button btnTut640;
    public Button btnTut720;
    public Button btnTutVGA;
    public ImageView btn_full;
    public ImageView btn_full2;
    public Button btn_zsd0;
    public Button btn_zsd1;
    public ImageView camLiveContinuePlay;
    public CameraParmsModel cameraParmsModel;
    public CheckBox cbSzp;
    public CheckBox cbZsd;
    public String currVersion;
    public DateModel dateModel;
    public Dialog dlgExit;
    public FrameLayout fl_bg;
    public GLSurfaceView glVideo;
    public Button icut0;
    public Button icut1;
    public Button icut2;
    public ImageView im_audio;
    public ImageView im_audio2;
    public ImageButton im_ircut;
    public ImageView im_ircut1;
    public ImageButton im_jx_rl;
    public ImageView im_jx_rl2;
    public ImageButton im_jx_ud;
    public ImageView im_jx_ud2;
    public ImageView im_k;
    public ImageView im_k2;
    public ImageView im_more;
    public ImageView im_pic;
    public ImageView im_pic2;
    public ImageButton im_showhide;
    public ImageView im_t;
    public ImageView im_talk;
    public ImageView im_talk2;
    public ImageView im_video;
    public ImageView im_video2;
    public ImageView im_zsd;
    public boolean isMp4Opened;
    public ImageView ivRecordTips;
    public ImageView ivSingn;
    public LinearLayout llRecordTips;
    public LinearLayout ll_audio;
    public LinearLayout ll_audio2;
    public LinearLayout ll_more;
    public LinearLayout ll_pic;
    public LinearLayout ll_pic2;
    public LinearLayout ll_talk;
    public LinearLayout ll_talk2;
    public LinearLayout ll_video;
    public LinearLayout ll_video2;
    public RelativeLayout lyHeader;
    public AacEncode mAacEncode;
    public Bitmap mBmp;
    public byte[] mBytes1;
    public byte[] mBytes2;
    public RelativeLayout mCamLiveBottom;
    public LinearLayout mCamLiveYs;
    public LinearLayout mCamLiveYs1;
    public Mp4VideoData mMp4VideoData;
    public Mp4WriteData mMp4WriteData;
    public RelativeLayout mSvSzpRl;
    public ZoomView mZoomView;
    public a myRender;
    public int myStatus;
    public String newVersion;
    public PopupWindow popupWindow_Icut;
    public PopupWindow popupWindow_hight;
    public PopupWindow popupWindow_hight_tut;
    public PopupWindow popupWindow_more_funtion;
    public PopupWindow popupWindow_zsd;
    public View popupmore;
    public View popv_hight;
    public View popv_hight_tut;
    public View popv_icut;
    public View popv_more_funtion;
    public View popv_zsd;
    public int recordTime;
    public LinearLayout rl_h_bm;
    public RelativeLayout rootView;
    public SeekBar seekBar1;
    public SeekBar seekBar11;
    public SeekBar seekBar12;
    public SeekBar seekBar2;
    public LinearLayout setKsw;
    public LinearLayout shix_LL_buttom;
    public StatFs stat;
    public SwitchView sv_szp;
    public SwitchView sv_zsd;
    public SwitchView test1;
    public EditText test2;
    public EditText test3;
    public EditText test4;
    public EditText test5;
    public long totalBlocks;
    public TextView tvRecordTime;
    public TextView tvSee1;
    public TextView tvSee11;
    public TextView tvSee12;
    public TextView tvSee2;
    public TextView tv_audio;
    public TextView tv_more;
    public TextView tv_name1;
    public TextView tv_name2;
    public TextView tv_pic;
    public TextView tv_talk;
    public TextView tv_video;
    public int upgrade_signal;
    public View viewLineBottom;
    public boolean isFullscreen = false;
    public String strName = null;
    public String strDID = null;
    public String strUser = null;
    public String strPwd = null;
    public String strUUID = null;
    public boolean bDisplayFinished = true;
    public boolean isTakeVideo = false;
    public String status = null;
    public File path = null;
    public boolean isAudio = false;
    public CustomBuffer AudioBuffer = null;
    public AudioPlayer audioPlayer = null;
    public CustomAudioRecorder customAudioRecorder = null;
    public boolean bAudioRecordStart = false;
    public YunTaiModel alarmModel = new YunTaiModel();
    public DeviceSupportModel mDeviceSupportModel = new DeviceSupportModel();
    public boolean isH264Data = false;
    public boolean isHaveIFrame = false;
    public boolean isCheckVideo = false;
    public TakeVideoThread takeVideoThread = null;
    public int devDecoderCount1 = 0;
    public int devDecoderCount2 = 0;
    public int mIsHasIdrCmd = 0;
    public int oldCount = -1;
    public boolean isNeedShow = true;
    public int net_4g = 0;
    public int mySignalvalue = 0;
    public int K_menu4 = 0;
    public int K_menu2 = 0;
    public int clock_disable = 0;
    public String fcmToken = "";
    public int speak_out = 0;
    public Handler refreshUIHandler = new Handler() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.1
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4) {
                return;
            }
            NDNCameraLiveActivity.access$008(NDNCameraLiveActivity.this);
            NDNCameraLiveActivity.this.tvRecordTime.setText(TimeUtil.getTimeDesc(NDNCameraLiveActivity.this.recordTime));
            NDNCameraLiveActivity.this.refreshUIHandler.sendEmptyMessageDelayed(4, 1000L);
        }
    };
    public boolean isSendPtzCotr = false;
    public boolean isDateComeOn = false;
    public int ret = 0;
    public int clickRs = 1;
    public boolean isAudioClick = false;
    public long clickTimeDown = 0;
    public long clickTimeUp = 0;
    public String strVideoName = "";
    public int mirror = 0;
    public int flipping = 0;
    public int streamid = 1;
    public int count = 0;
    public List<String> frames = new ArrayList();
    public boolean isBack = false;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.45
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (NDNCameraLiveActivity.this.isOneShow) {
                    NDNCameraLiveActivity.this.isOneShow = false;
                    NDNCameraLiveActivity.this.isDateComeOn = true;
                    NDNCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                }
                NDNCameraLiveActivity.this.myRender.a(NDNCameraLiveActivity.this.videodata, NDNCameraLiveActivity.this.nVideoWidth, NDNCameraLiveActivity.this.nVideoHeight);
                if (NDNCameraLiveActivity.this.isFullscreen) {
                    ImageView unused = NDNCameraLiveActivity.this.ivSingn;
                } else if (NDNCameraLiveActivity.this.ivSingn != null) {
                    NDNCameraLiveActivity nDNCameraLiveActivity = NDNCameraLiveActivity.this;
                    nDNCameraLiveActivity.setSignalImage(nDNCameraLiveActivity.net_4g, NDNCameraLiveActivity.this.mySignalvalue);
                }
            } else if (i2 != 3) {
                if (i2 == 125) {
                    if (!NDNCameraLiveActivity.getTimeZone().isEmpty()) {
                        NDNCameraLiveActivity.this.dateModel.setTime((int) TimeUtil.getUTCTimeSec());
                    }
                    if (NDNCameraLiveActivity.this.dateModel.getNtpServer().isEmpty()) {
                        NDNCameraLiveActivity.this.dateModel.setNtpServer("ntp.sjtu.edu.cn");
                    }
                    try {
                        NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, DateModel.toJson(NDNCameraLiveActivity.this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        MyLogUtils.d("tag", " 时区同步3 TimeZone=" + Float.parseFloat(NDNCameraLiveActivity.getTimeZone()) + " TimeZone_Sec=" + TimeUtil.getUTCTimeSec());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if (i2 == 130) {
                    NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                } else if (i2 == 140) {
                    Bundle data = message.getData();
                    int i3 = data.getInt("status");
                    if (data.getInt("upgrade_signal") != 0) {
                        if (i3 == 5 && ContentCommon.MY_COUNT == 0) {
                            ContentCommon.MY_COUNT = 1;
                            NDNCameraLiveActivity.this.showUpdate(true);
                        } else if (i3 == 3) {
                            NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
                        }
                    }
                } else if (i2 == 222) {
                    NDNCameraLiveActivity.this.btn4k.performClick();
                } else if (i2 == 1234) {
                    if (NDNCameraLiveActivity.this.devDecoderCount2 < 10) {
                        NDNCameraLiveActivity.this.devDecoderCount2 += 5;
                    }
                    NDNCameraLiveActivity.access$3808(NDNCameraLiveActivity.this);
                    if (NDNCameraLiveActivity.this.count < 30) {
                        NDNCameraLiveActivity.this.frames.add(String.valueOf(NDNCameraLiveActivity.this.devDecoderCount2));
                    } else {
                        NDNCameraLiveActivity nDNCameraLiveActivity2 = NDNCameraLiveActivity.this;
                        nDNCameraLiveActivity2.changeStatu(nDNCameraLiveActivity2.frames);
                        NDNCameraLiveActivity.this.count = 0;
                    }
                    NDNCameraLiveActivity.this.getResources().getString(R.string.n_play_hh);
                    if (NDNCameraLiveActivity.this.clickRs == 0) {
                        NDNCameraLiveActivity.this.getResources().getString(R.string.n_play_hh);
                    } else if (NDNCameraLiveActivity.this.clickRs == 1) {
                        NDNCameraLiveActivity.this.getResources().getString(R.string.n_play_h);
                    } else if (NDNCameraLiveActivity.this.clickRs == 2) {
                        NDNCameraLiveActivity.this.getResources().getString(R.string.n_play_l);
                    }
                    MyLogUtils.d("tag", " 实时帧率=" + NDNCameraLiveActivity.this.devDecoderCount2);
                } else if (i2 == 123321) {
                    if (!NDNCameraLiveActivity.this.isBack) {
                        ToastUtils.showShort(R.string.camera_not_online);
                    }
                    NDNCameraLiveActivity.this.dropOut();
                    NDNCameraLiveActivity.this.finish();
                } else if (i2 == 23) {
                    CameraParmsModel cameraParmsModel = NDNCameraLiveActivity.this.cameraParmsModel;
                    if (cameraParmsModel != null) {
                        if (cameraParmsModel.getMenual_exposure_en() == 1) {
                            NDNCameraLiveActivity.this.test1.setOpened(true);
                        } else {
                            NDNCameraLiveActivity.this.test1.setOpened(false);
                        }
                        NDNCameraLiveActivity.this.test2.setText(NDNCameraLiveActivity.this.cameraParmsModel.getMenual_exposure_expTime() + "");
                        NDNCameraLiveActivity.this.test3.setText(NDNCameraLiveActivity.this.cameraParmsModel.getMenual_exposure_again() + "");
                        NDNCameraLiveActivity.this.test4.setText(NDNCameraLiveActivity.this.cameraParmsModel.getMenual_exposure_dgain() + "");
                        NDNCameraLiveActivity.this.test5.setText(NDNCameraLiveActivity.this.cameraParmsModel.getMenual_exposure_ispdgain() + "");
                        NDNCameraLiveActivity.this.seekBar1.setProgress(NDNCameraLiveActivity.this.cameraParmsModel.getMic());
                        NDNCameraLiveActivity.this.seekBar2.setProgress(NDNCameraLiveActivity.this.cameraParmsModel.getSpk());
                        NDNCameraLiveActivity.this.tvSee1.setText(String.valueOf(NDNCameraLiveActivity.this.cameraParmsModel.getMic()));
                        NDNCameraLiveActivity.this.tvSee2.setText(String.valueOf(NDNCameraLiveActivity.this.cameraParmsModel.getSpk()));
                        NDNCameraLiveActivity nDNCameraLiveActivity3 = NDNCameraLiveActivity.this;
                        nDNCameraLiveActivity3.batcapacity = nDNCameraLiveActivity3.cameraParmsModel.getBatvalue();
                        String str = NDNCameraLiveActivity.this.batcapacity + "%";
                        if (NDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 0) {
                            NDNCameraLiveActivity.this.mirror = 0;
                            NDNCameraLiveActivity.this.flipping = 0;
                        } else if (NDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 1) {
                            NDNCameraLiveActivity.this.mirror = 1;
                            NDNCameraLiveActivity.this.flipping = 0;
                        } else if (NDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 2) {
                            NDNCameraLiveActivity.this.mirror = 0;
                            NDNCameraLiveActivity.this.flipping = 1;
                        } else if (NDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 3) {
                            NDNCameraLiveActivity.this.mirror = 1;
                            NDNCameraLiveActivity.this.flipping = 1;
                        }
                        if (NDNCameraLiveActivity.this.cameraParmsModel.getLamp() == 1) {
                            NDNCameraLiveActivity.this.cbZsd.setChecked(true);
                            NDNCameraLiveActivity.this.sv_zsd.setOpened(true);
                            if (NDNCameraLiveActivity.this.btn_zsd0 != null && NDNCameraLiveActivity.this.btn_zsd1 != null) {
                                NDNCameraLiveActivity.this.btn_zsd0.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.gray));
                                NDNCameraLiveActivity.this.btn_zsd1.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                            }
                        } else {
                            NDNCameraLiveActivity.this.cbZsd.setChecked(false);
                            NDNCameraLiveActivity.this.sv_zsd.setOpened(false);
                            if (NDNCameraLiveActivity.this.btn_zsd0 != null && NDNCameraLiveActivity.this.btn_zsd1 != null) {
                                NDNCameraLiveActivity.this.btn_zsd0.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                                NDNCameraLiveActivity.this.btn_zsd1.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.gray));
                            }
                        }
                        if (NDNCameraLiveActivity.this.cameraParmsModel.getIcut() == 2) {
                            NDNCameraLiveActivity.this.icut2.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.colorPrimary));
                            NDNCameraLiveActivity.this.icut1.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                            NDNCameraLiveActivity.this.icut0.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        } else if (NDNCameraLiveActivity.this.cameraParmsModel.getIcut() == 1) {
                            NDNCameraLiveActivity.this.icut1.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.colorPrimary));
                            NDNCameraLiveActivity.this.icut2.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                            NDNCameraLiveActivity.this.icut0.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        } else {
                            NDNCameraLiveActivity.this.icut0.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.colorPrimary));
                            NDNCameraLiveActivity.this.icut1.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                            NDNCameraLiveActivity.this.icut2.setTextColor(NDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        }
                        if (NDNCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 1 || NDNCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 2) {
                            NDNCameraLiveActivity.this.sv_szp.setOpened(true);
                            NDNCameraLiveActivity.this.cbSzp.setChecked(true);
                        } else {
                            NDNCameraLiveActivity.this.sv_szp.setOpened(false);
                            NDNCameraLiveActivity.this.cbSzp.setChecked(false);
                        }
                        NDNCameraLiveActivity.this.seekBar12.setProgress(NDNCameraLiveActivity.this.cameraParmsModel.getBright());
                        NDNCameraLiveActivity.this.seekBar11.setProgress(NDNCameraLiveActivity.this.cameraParmsModel.getContrast());
                        NDNCameraLiveActivity.this.tvSee12.setText(String.valueOf(NDNCameraLiveActivity.this.cameraParmsModel.getBright()));
                        NDNCameraLiveActivity.this.tvSee11.setText(String.valueOf(NDNCameraLiveActivity.this.cameraParmsModel.getContrast()));
                    }
                } else if (i2 == 24) {
                    if (NDNCameraLiveActivity.this.mDeviceSupportModel.getIrcut_menu_dis() == 1) {
                        NDNCameraLiveActivity.this.mCamLiveYs.setVisibility(8);
                    } else {
                        NDNCameraLiveActivity.this.mCamLiveYs.setVisibility(0);
                    }
                    if (NDNCameraLiveActivity.this.speak_out == 1) {
                        NDNCameraLiveActivity.this.ll_talk.setVisibility(0);
                    } else {
                        NDNCameraLiveActivity.this.ll_talk.setVisibility(8);
                    }
                }
            } else if (!NDNCameraLiveActivity.this.isDateComeOn) {
                NDNCameraLiveActivity.this.mHandler.sendEmptyMessage(123321);
            }
            int i4 = message.what;
            if (i4 == 1 || i4 == 2) {
                NDNCameraLiveActivity.this.bDisplayFinished = true;
            }
            return false;
        }
    });
    public boolean isPictSave = false;
    public int videoDataLen = 0;
    public int nVideoWidth = 0;
    public int nVideoHeight = 0;
    public byte[] videodata = null;
    public boolean isTakepic = false;
    public boolean isOneShow = true;
    public int jPush = 0;

    private void StartAudio() {
        synchronized (this) {
            this.AudioBuffer.ClearAll();
            this.audioPlayer.AudioPlayStart();
            NativeCallerTools.SDKAPIOpenTalk(this.strDID);
            this.isAudio = true;
        }
    }

    private void StartTalk() {
        CustomAudioRecorder customAudioRecorder = this.customAudioRecorder;
        if (customAudioRecorder != null) {
            customAudioRecorder.StartRecord();
            this.bAudioRecordStart = true;
            NativeCallerTools.SDKAPIOpenTalk(this.strDID);
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.audioPlayer.AudioPlayStop();
            this.AudioBuffer.ClearAll();
            NativeCallerTools.SDKAPICloseTalk(this.strDID);
            this.isAudio = false;
        }
    }

    private void StopTalk() {
        CustomAudioRecorder customAudioRecorder = this.customAudioRecorder;
        if (customAudioRecorder != null) {
            this.bAudioRecordStart = false;
            customAudioRecorder.StopRecord();
            NativeCallerTools.SDKAPICloseTalk(this.strDID);
        }
    }

    private void UpdateClarityUi(int i2) {
        MyLogUtils.d("clickRs", "2900 clickRs = " + this.clickRs);
        if (i2 == 0) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_720p_sel)).a(this.im_k);
            this.btn4k.setTextColor(getResources().getColor(R.color.color_white));
            this.btn2k.setTextColor(getResources().getColor(R.color.color_white));
            this.btn1080.setTextColor(getResources().getColor(R.color.color_white));
            this.btn720.setTextColor(getResources().getColor(R.color.colorPrimary));
            this.btnTut1080.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut720.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut640.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTutVGA.setTextColor(getResources().getColor(R.color.colorPrimary));
            return;
        }
        if (i2 == 1) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_1080p_sel)).a(this.im_k);
            this.btn4k.setTextColor(getResources().getColor(R.color.color_white));
            this.btn2k.setTextColor(getResources().getColor(R.color.color_white));
            this.btn1080.setTextColor(getResources().getColor(R.color.colorPrimary));
            this.btn720.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut1080.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut720.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut640.setTextColor(getResources().getColor(R.color.colorPrimary));
            this.btnTutVGA.setTextColor(getResources().getColor(R.color.color_white));
            return;
        }
        if (i2 == 2) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_2k_sel)).a(this.im_k);
            this.btn4k.setTextColor(getResources().getColor(R.color.color_white));
            this.btn2k.setTextColor(getResources().getColor(R.color.colorPrimary));
            this.btn1080.setTextColor(getResources().getColor(R.color.color_white));
            this.btn720.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut1080.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTut720.setTextColor(getResources().getColor(R.color.colorPrimary));
            this.btnTut640.setTextColor(getResources().getColor(R.color.color_white));
            this.btnTutVGA.setTextColor(getResources().getColor(R.color.color_white));
            return;
        }
        if (i2 != 3) {
            return;
        }
        e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_4k_sel)).a(this.im_k);
        this.btn4k.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.btn2k.setTextColor(getResources().getColor(R.color.color_white));
        this.btn1080.setTextColor(getResources().getColor(R.color.color_white));
        this.btn720.setTextColor(getResources().getColor(R.color.color_white));
        this.btnTut1080.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.btnTut720.setTextColor(getResources().getColor(R.color.color_white));
        this.btnTut640.setTextColor(getResources().getColor(R.color.color_white));
        this.btnTutVGA.setTextColor(getResources().getColor(R.color.color_white));
    }

    public static /* synthetic */ int access$008(NDNCameraLiveActivity nDNCameraLiveActivity) {
        int i2 = nDNCameraLiveActivity.recordTime;
        nDNCameraLiveActivity.recordTime = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$3808(NDNCameraLiveActivity nDNCameraLiveActivity) {
        int i2 = nDNCameraLiveActivity.count;
        nDNCameraLiveActivity.count = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeStatu(List<String> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += Integer.parseInt(list.get(i3));
        }
        if (i2 < 300) {
            if (this.streamid == 1) {
                this.streamid = 2;
                NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 2);
                return;
            }
            return;
        }
        if (this.streamid == 2) {
            this.streamid = 1;
            NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void contrDevDee(int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "ptz_control");
            jSONObject.put("cmd", RecyclerView.c0.FLAG_IGNORE);
            jSONObject.put("parms", i2);
            jSONObject.put("value", i3);
            jSONObject.put("user", SystemValue.doorBellAdmin);
            jSONObject.put("pwd", SystemValue.doorBellPass);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, jSONObject.toString());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dropOut() {
        this.isBack = true;
        StopAudio();
        StopTalk();
        releaseTalk();
        this.refreshUIHandler.removeCallbacksAndMessages(null);
        this.mHandler.removeCallbacksAndMessages(null);
        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
        NUIMainActivity.setPlayInterface(null);
        this.isCheckVideo = false;
        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", this.clickRs);
    }

    private void duoFangVersionCheck(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals("506") && str2.startsWith("50.13.6.")) {
            try {
                if (Integer.valueOf(str2.replace("50.13.6.", "")).intValue() < 9) {
                    showUpdate(false);
                    return;
                }
                return;
            } catch (NumberFormatException unused) {
                LogUtils.e("biniy", "06S多方 固件版本读取异常 appver= " + str2);
                return;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals("508") || !str2.startsWith("50.10.7.")) {
            return;
        }
        try {
            if (Integer.valueOf(str2.replace("50.10.7.", "")).intValue() < 9) {
                showUpdate(false);
            }
        } catch (NumberFormatException unused2) {
            LogUtils.e("biniy", "S62 固件版本读取异常 appver= " + str2);
        }
    }

    private String formatSize(long j) {
        return Formatter.formatFileSize(this, j);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
            this.strUUID = intent.getStringExtra("uuid");
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    public static String getTimeZone() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(calendar2.getTimeZone());
        calendar.set(calendar2.get(1), 11, 31, 13, 0, 0);
        return getTimeZoneText2(calendar2.getTimeZone(), true);
    }

    public static int getTimeZone2() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(calendar2.getTimeZone());
        calendar.set(calendar2.get(1), 11, 31, 13, 0, 0);
        return getTimeZoneText(calendar2.getTimeZone(), true);
    }

    public static int getTimeZoneText(TimeZone timeZone, boolean z) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ");
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        MyLogUtils.d("tag", "gmtString 0  " + format + " src=0");
        int intValue = (Integer.valueOf(format.substring(4, 6)).intValue() * 3600) + 0;
        MyLogUtils.d("tag", "gmtString 1  " + format + " src=" + intValue);
        int intValue2 = (Integer.valueOf(format.substring(7)).intValue() * 60) + intValue;
        MyLogUtils.d("tag", "gmtString 2  " + format + " src=" + intValue2);
        return (!format.contains("+") && format.contains("-")) ? -intValue2 : intValue2;
    }

    public static String getTimeZoneText2(TimeZone timeZone, boolean z) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ");
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        MyLogUtils.d("tag", "gmtString 1  " + format);
        MyLogUtils.d("tag", "gmtString 2  " + format);
        String replace = format.substring(3, 6).replace("+", "");
        MyLogUtils.d("tag", "gmtString 3  " + replace);
        return replace;
    }

    private void hideRecordTimeTips() {
        this.ivRecordTips.clearAnimation();
        this.refreshUIHandler.removeMessages(4);
        this.llRecordTips.setVisibility(4);
    }

    private void initAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.alphaAnimation = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.alphaAnimation.setRepeatMode(2);
        this.alphaAnimation.setRepeatCount(-1);
    }

    private void initExitDialog() {
        Dialog dialog = new Dialog(this, R.style.customDialog);
        this.dlgExit = dialog;
        dialog.setContentView(R.layout.dialog_exit_play);
        this.dlgExit.findViewById(R.id.tvCancel).setOnClickListener(this);
        this.dlgExit.findViewById(R.id.tvExit).setOnClickListener(this);
    }

    private void initListen() {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tvHeaderTitle);
        String str = this.strName;
        if (str != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_name1);
        this.tv_name1 = textView2;
        textView2.setText(this.strName);
        this.tv_name2 = (TextView) findViewById(R.id.tv_name2);
        this.camLiveContinuePlay = (ImageView) findViewById(R.id.cam_live_continue_play);
        this.mCamLiveYs = (LinearLayout) findViewById(R.id.cam_live_ys);
        this.mCamLiveYs1 = (LinearLayout) findViewById(R.id.cam_live_ys1);
        this.rl_h_bm = (LinearLayout) findViewById(R.id.rl_h_bm);
        this.mZoomView = (ZoomView) findViewById(R.id.zoomView);
        this.rootView = (RelativeLayout) findViewById(R.id.rootView);
        this.mCamLiveBottom = (RelativeLayout) findViewById(R.id.cam_live_bottom);
        this.mZoomView.setOnClickListener(this);
        this.ivSingn = (ImageView) findViewById(R.id.ivSingn);
        Button button = (Button) findViewById(R.id.btnTouch);
        this.btnTouch = button;
        button.setVisibility(8);
        this.btnTouch.setOnClickListener(this);
        this.glVideo.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llRecordTips);
        this.llRecordTips = linearLayout;
        this.ivRecordTips = (ImageView) linearLayout.findViewById(R.id.ivRecordTips);
        this.tvRecordTime = (TextView) this.llRecordTips.findViewById(R.id.tvRecordTime);
        this.shix_LL_buttom = (LinearLayout) findViewById(R.id.shix_LL_buttom);
        this.lyHeader = (RelativeLayout) findViewById(R.id.lyHeader);
        this.ll_video = (LinearLayout) findViewById(R.id.ll_video);
        this.ll_pic = (LinearLayout) findViewById(R.id.ll_pic);
        this.ll_talk = (LinearLayout) findViewById(R.id.ll_talk);
        this.ll_audio = (LinearLayout) findViewById(R.id.ll_audio);
        this.ll_talk2 = (LinearLayout) findViewById(R.id.ll_talk2);
        this.ll_audio2 = (LinearLayout) findViewById(R.id.ll_audio2);
        this.ll_more = (LinearLayout) findViewById(R.id.ll_more);
        this.im_video = (ImageView) findViewById(R.id.im_video);
        this.im_pic = (ImageView) findViewById(R.id.im_pic);
        this.im_talk = (ImageView) findViewById(R.id.im_talk);
        this.im_audio = (ImageView) findViewById(R.id.im_audio);
        this.im_talk2 = (ImageView) findViewById(R.id.im_talk2);
        this.im_audio2 = (ImageView) findViewById(R.id.im_audio2);
        this.im_more = (ImageView) findViewById(R.id.im_more);
        this.viewLineBottom = findViewById(R.id.view_line_bottom);
        this.tv_video = (TextView) findViewById(R.id.tv_video);
        this.tv_pic = (TextView) findViewById(R.id.tv_pic);
        this.tv_talk = (TextView) findViewById(R.id.tv_talk);
        this.tv_audio = (TextView) findViewById(R.id.tv_audio);
        this.tv_more = (TextView) findViewById(R.id.tv_more);
        findViewById(R.id.ivOperator1).setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.im_showhide);
        this.im_showhide = imageButton;
        imageButton.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mtv_set_ksw);
        this.setKsw = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.btn_full = (ImageView) findViewById(R.id.btn_full);
        this.btn_full2 = (ImageView) findViewById(R.id.btn_full2);
        this.btn_full.setOnClickListener(this);
        this.btn_full2.setOnClickListener(this);
        this.ll_video.setOnClickListener(this);
        this.ll_pic.setOnClickListener(this);
        this.ll_audio.setOnClickListener(this);
        this.ll_more.setOnClickListener(this);
        this.ll_video.setOnTouchListener(this);
        this.ll_pic.setOnTouchListener(this);
        this.ll_talk.setOnTouchListener(this);
        this.ll_audio.setOnTouchListener(this);
        this.ll_talk2.setOnTouchListener(this);
        this.ll_audio2.setOnTouchListener(this);
        this.ll_more.setOnTouchListener(this);
        this.camLiveContinuePlay.setOnClickListener(this);
        findViewById(R.id.ivBack).setOnClickListener(this);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_zsd);
        this.cbZsd = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.h.a.a.j0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NDNCameraLiveActivity.this.a(compoundButton, z);
            }
        });
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.cb_szp);
        this.cbSzp = checkBox2;
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.h.a.a.k0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NDNCameraLiveActivity.this.b(compoundButton, z);
            }
        });
        this.im_jx_ud = (ImageButton) findViewById(R.id.im_jx_ud);
        this.im_jx_ud2 = (ImageView) findViewById(R.id.im_jx_ud2);
        this.im_jx_rl = (ImageButton) findViewById(R.id.im_jx_rl);
        this.im_jx_rl2 = (ImageView) findViewById(R.id.im_jx_rl2);
        this.im_zsd = (ImageView) findViewById(R.id.im_zsd);
        this.im_ircut = (ImageButton) findViewById(R.id.im_ircut);
        this.im_ircut1 = (ImageView) findViewById(R.id.im_ircut1);
        this.im_t = (ImageView) findViewById(R.id.im_t);
        this.im_k = (ImageView) findViewById(R.id.im_k);
        this.im_k2 = (ImageView) findViewById(R.id.im_k2);
        this.im_jx_ud.setOnClickListener(this);
        this.im_jx_ud2.setOnClickListener(this);
        this.im_jx_rl.setOnClickListener(this);
        this.im_jx_rl2.setOnClickListener(this);
        this.im_zsd.setOnClickListener(this);
        this.im_ircut.setOnClickListener(this);
        this.im_ircut1.setOnClickListener(this);
        this.im_t.setOnClickListener(this);
        this.im_k.setOnClickListener(this);
        this.im_k2.setOnClickListener(this);
        this.fl_bg = (FrameLayout) findViewById(R.id.fl_bg);
        this.btnPtz_up = (ImageButton) findViewById(R.id.btnPtz_up);
        this.btnPtz_down = (ImageButton) findViewById(R.id.btnPtz_down);
        this.btnPtz_left = (ImageButton) findViewById(R.id.btnPtz_left);
        this.btnPtz_right = (ImageButton) findViewById(R.id.btnPtz_right);
        this.btnPtz_cer = (Button) findViewById(R.id.btnPtz_cer);
        this.btnPtz_up.setOnClickListener(this);
        this.btnPtz_down.setOnClickListener(this);
        this.btnPtz_left.setOnClickListener(this);
        this.btnPtz_right.setOnClickListener(this);
        this.btnPtz_cer.setOnClickListener(this);
        this.btnPtz_up.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                NDNCameraLiveActivity.this.isSendPtzCotr = true;
                NDNCameraLiveActivity.this.contrDevDee(0, 0);
                return true;
            }
        });
        this.btnPtz_up.setOnTouchListener(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_up);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraLiveActivity.this, 10L);
                    }
                    return false;
                }
                if (action != 1) {
                    return true;
                }
                if (NDNCameraLiveActivity.this.isSendPtzCotr) {
                    NDNCameraLiveActivity.this.isSendPtzCotr = false;
                    NDNCameraLiveActivity.this.contrDevDee(0, 1);
                }
                NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                return false;
            }
        });
        this.btnPtz_down.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                NDNCameraLiveActivity.this.isSendPtzCotr = true;
                NDNCameraLiveActivity.this.contrDevDee(0, 2);
                return true;
            }
        });
        this.btnPtz_down.setOnTouchListener(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_down);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraLiveActivity.this, 10L);
                    }
                    return false;
                }
                if (action != 1) {
                    return true;
                }
                if (NDNCameraLiveActivity.this.isSendPtzCotr) {
                    NDNCameraLiveActivity.this.isSendPtzCotr = false;
                    NDNCameraLiveActivity.this.contrDevDee(0, 3);
                }
                NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                return false;
            }
        });
        this.btnPtz_left.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                NDNCameraLiveActivity.this.isSendPtzCotr = true;
                NDNCameraLiveActivity.this.contrDevDee(0, 4);
                return true;
            }
        });
        this.btnPtz_left.setOnTouchListener(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_left);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraLiveActivity.this, 10L);
                    }
                    return false;
                }
                if (action != 1) {
                    return true;
                }
                if (NDNCameraLiveActivity.this.isSendPtzCotr) {
                    NDNCameraLiveActivity.this.isSendPtzCotr = false;
                    NDNCameraLiveActivity.this.contrDevDee(0, 5);
                }
                NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                return false;
            }
        });
        this.btnPtz_right.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                NDNCameraLiveActivity.this.isSendPtzCotr = true;
                NDNCameraLiveActivity.this.contrDevDee(0, 6);
                return true;
            }
        });
        this.btnPtz_right.setOnTouchListener(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_rigth);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraLiveActivity.this, 10L);
                    }
                    return false;
                }
                if (action != 1) {
                    return true;
                }
                if (NDNCameraLiveActivity.this.isSendPtzCotr) {
                    NDNCameraLiveActivity.this.isSendPtzCotr = false;
                    NDNCameraLiveActivity.this.contrDevDee(0, 7);
                }
                NDNCameraLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                return false;
            }
        });
        int screenSizeWidth = DisplayUtil.getScreenSizeWidth(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = screenSizeWidth;
        layoutParams.addRule(13);
        layoutParams.height = (screenSizeWidth * 9) / 16;
        this.mZoomView.setLayoutParams(layoutParams);
    }

    private boolean isChineseLanguage() {
        String language = Locale.getDefault().getLanguage();
        MyLogUtils.e("tag", "language = " + language);
        return language.equalsIgnoreCase("zh");
    }

    private void releaseTalk() {
        CustomAudioRecorder customAudioRecorder = this.customAudioRecorder;
        if (customAudioRecorder != null) {
            this.bAudioRecordStart = false;
            customAudioRecorder.releaseRecord();
        }
    }

    private void returnLastBmp2Home() {
        if (this.videodata == null) {
            return;
        }
        new Thread() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.12
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                byte[] bArr = new byte[NDNCameraLiveActivity.this.nVideoWidth * NDNCameraLiveActivity.this.nVideoHeight * 2];
                NativeCallerTools.SDKAPIYuv420ToRgb565(NDNCameraLiveActivity.this.videodata, bArr, NDNCameraLiveActivity.this.nVideoWidth, NDNCameraLiveActivity.this.nVideoHeight);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                NDNCameraLiveActivity nDNCameraLiveActivity = NDNCameraLiveActivity.this;
                nDNCameraLiveActivity.mBmp = Bitmap.createBitmap(nDNCameraLiveActivity.nVideoWidth, NDNCameraLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                NDNCameraLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                if (NDNCameraLiveActivity.this.mBmp != null) {
                    File file = new File(new File(FileUtil.getRootDir(), "HDWiFiCam/picid"), NDNCameraLiveActivity.this.strDID + ".jpg");
                    if (file.exists()) {
                        MyLogUtils.d("first_pic", file.delete() + "");
                    }
                    NDNCameraLiveActivity nDNCameraLiveActivity2 = NDNCameraLiveActivity.this;
                    nDNCameraLiveActivity2.setBitMapToBean(nDNCameraLiveActivity2.strDID, NDNCameraLiveActivity.this.mBmp);
                    NDNCameraLiveActivity nDNCameraLiveActivity3 = NDNCameraLiveActivity.this;
                    nDNCameraLiveActivity3.saveBmpToSDcard(nDNCameraLiveActivity3.strDID, NDNCameraLiveActivity.this.mBmp);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBmpToSDcard(String str, Bitmap bitmap) {
        File file = new File(FileUtil.getRootDir(), "HDWiFiCam/picid");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".jpg"));
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b A[Catch: all -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:15:0x0054, B:17:0x0056, B:19:0x009b, B:25:0x005b, B:38:0x00a0, B:42:0x00a4, B:40:0x00ac, B:45:0x00a9, B:29:0x008f, B:32:0x0093), top: B:2:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.getStrDate()     // Catch: java.lang.Throwable -> Lad
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch: java.lang.Throwable -> Lad
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch: java.lang.Throwable -> Lad
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.File r4 = com.shix.shixipc.utils.FileUtil.getRootDir()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r5.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r6 = "HDWiFiCam/Snapshot/"
            r5.append(r6)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r6 = r8.strDID     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r5.append(r6)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r4 != 0) goto L35
            r3.mkdirs()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
        L35:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4.<init>(r3, r1)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r3 = 100
            boolean r0 = r9.compress(r0, r3, r1)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r0 == 0) goto L54
            r1.flush()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            com.shix.shixipc.activity.NDNCameraLiveActivity$42 r0 = new com.shix.shixipc.activity.NDNCameraLiveActivity$42     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r0.<init>()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r8.runOnUiThread(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
        L54:
            r8.isPictSave = r2     // Catch: java.lang.Throwable -> Lad
            r1.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> Lad
            goto L99
        L5a:
            r0 = move-exception
        L5b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lad
            goto L99
        L5f:
            r9 = move-exception
            r0 = r1
            goto La0
        L62:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L6a
        L67:
            r9 = move-exception
            goto La0
        L69:
            r1 = move-exception
        L6a:
            com.shix.shixipc.activity.NDNCameraLiveActivity$43 r3 = new com.shix.shixipc.activity.NDNCameraLiveActivity$43     // Catch: java.lang.Throwable -> L67
            r3.<init>()     // Catch: java.lang.Throwable -> L67
            r8.runOnUiThread(r3)     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r4.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = r1.getMessage()     // Catch: java.lang.Throwable -> L67
            r4.append(r5)     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L67
            com.shix.shixipc.utils.MyLogUtils.d(r3, r4)     // Catch: java.lang.Throwable -> L67
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L67
            r8.isPictSave = r2     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto L99
            r0.close()     // Catch: java.io.IOException -> L97 java.lang.Throwable -> Lad
            goto L99
        L97:
            r0 = move-exception
            goto L5b
        L99:
            if (r9 == 0) goto L9e
            r9.recycle()     // Catch: java.lang.Throwable -> Lad
        L9e:
            monitor-exit(r8)
            return
        La0:
            r8.isPictSave = r2     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto Lac
            r0.close()     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lad
            goto Lac
        La8:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lad
        Lac:
            throw r9     // Catch: java.lang.Throwable -> Lad
        Lad:
            r9 = move-exception
            monitor-exit(r8)
            goto Lb1
        Lb0:
            throw r9
        Lb1:
            goto Lb0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.NDNCameraLiveActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveVideoHead(String str) {
        if (this.videodata == null || str == null || str.length() <= 5) {
            return;
        }
        this.strVideoName = "IMG_" + str.replace("mp4", "jpg");
        new Thread() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.11
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                byte[] bArr = new byte[NDNCameraLiveActivity.this.nVideoWidth * NDNCameraLiveActivity.this.nVideoHeight * 2];
                NativeCallerTools.SDKAPIYuv420ToRgb565(NDNCameraLiveActivity.this.videodata, bArr, NDNCameraLiveActivity.this.nVideoWidth, NDNCameraLiveActivity.this.nVideoHeight);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                NDNCameraLiveActivity nDNCameraLiveActivity = NDNCameraLiveActivity.this;
                nDNCameraLiveActivity.mBmp = Bitmap.createBitmap(nDNCameraLiveActivity.nVideoWidth, NDNCameraLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                NDNCameraLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                if (NDNCameraLiveActivity.this.mBmp != null) {
                    File file = new File(FileUtil.getRootDir(), "HDWiFiCam/videohead/" + NDNCameraLiveActivity.this.strDID);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, NDNCameraLiveActivity.this.strVideoName));
                        if (NDNCameraLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitMapToBean(String str, Bitmap bitmap) {
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (str != null) {
                str.equals(SystemValue.arrayList.get(i2).getDev_Did());
            }
        }
    }

    private void setPushConfig() {
        if (!getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_SetGooglePush(this.strUser, this.strPwd, this.strUUID, this.fcmToken, ContentCommon.FCM_APP_KEY, this.strName));
            return;
        }
        if (CrashApplication.getPushBrand() == 1) {
            MyLogUtils.d("push", " 绑定小米推送 uid= " + this.strDID);
            l.k(this);
            l.f(this, this.strDID, null);
        } else if (CrashApplication.getPushBrand() != 2) {
            if (CrashApplication.getPushBrand() == 4) {
                c.a(this).b(this.strDID, new c.j.a.a() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.44
                    @Override // c.j.a.a
                    public void onStateChanged(int i2) {
                        if (i2 == 0) {
                            MyLogUtils.d("push", " vivo推送订阅:" + NDNCameraLiveActivity.this.strDID);
                            return;
                        }
                        MyLogUtils.d("push", " vivo推送订阅:" + NDNCameraLiveActivity.this.strDID + " 失败");
                    }
                });
            } else if (CrashApplication.getPushBrand() != 3) {
                if (CrashApplication.getPushBrand() == 5) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(this.strDID);
                    JPushInterface.addTags(this, 0, JPushInterface.filterValidTags(hashSet));
                } else {
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(this.strDID);
                    JPushInterface.addTags(this, 0, JPushInterface.filterValidTags(hashSet2));
                }
            }
        }
        String str = this.strDID;
        NativeCallerTools.SDKAPITransferMessage(str, CommonUtil.SHIX_RegistPush(this.strUser, this.strPwd, ContentCommon.XG_TOKEN, this.strUUID, this.fcmToken, ContentCommon.FCM_APP_KEY, this.strName, str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSignalImage(int i2, int i3) {
        MyLogUtils.d("tag", " setSignalImage type=" + i2 + " value=" + i3);
        if (i2 == 1) {
            if (i3 <= 1) {
                this.ivSingn.setImageResource(R.mipmap.hz_wifisign_100);
                return;
            }
            if (i3 >= 2 && i3 <= 30) {
                this.ivSingn.setImageResource(R.mipmap.hz_wifisign_100);
                return;
            } else if (i3 == 31) {
                this.ivSingn.setImageResource(R.mipmap.hz_wifisign_50);
                return;
            } else {
                this.ivSingn.setImageResource(R.mipmap.hz_wifisign_20);
                return;
            }
        }
        if (i3 > 0 && i3 <= 33) {
            this.ivSingn.setImageResource(R.mipmap.hz_wifisign_20);
            return;
        }
        if (i3 > 33 && i3 <= 66) {
            this.ivSingn.setImageResource(R.mipmap.hz_wifisign_50);
        } else if (i3 > 66) {
            this.ivSingn.setImageResource(R.mipmap.hz_wifisign_100);
        } else {
            this.ivSingn.setImageResource(R.mipmap.hz_wifisign_20);
        }
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.sd_card_permissions_title)).setMessage(getResources().getString(R.string.sd_card_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.48
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.49
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    NDNCameraLiveActivity.this.toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.49.1
                        @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
                        public void onResult(boolean z2) {
                        }
                    });
                }
            });
        }
        negativeButton.create().show();
    }

    private void showDialogAudio(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.recording_permissions_title)).setMessage(getResources().getString(R.string.recording_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.50
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.51
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    NDNCameraLiveActivity.this.toCheckPermissionAudio();
                }
            });
        }
        negativeButton.create().show();
    }

    private void showRecordTimeTips() {
        this.llRecordTips.setVisibility(0);
        this.refreshUIHandler.sendMessageDelayed(this.refreshUIHandler.obtainMessage(4), 1000L);
        this.tvRecordTime.setText("00:00");
        this.recordTime = 0;
        this.ivRecordTips.startAnimation(this.alphaAnimation);
    }

    private void takePicture(final Bitmap bitmap) {
        if (this.isPictSave) {
            return;
        }
        this.isPictSave = true;
        new Thread() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.41
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                NDNCameraLiveActivity.this.savePicToSDcard(bitmap);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCheckPermission(PermissionXUtils.OnPermissionCallback onPermissionCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"}, onPermissionCallback);
        } else {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, onPermissionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermissionAudio() {
        if (a.h.b.a.a(this, Permission.RECORD_AUDIO) == 0) {
            return true;
        }
        a.h.a.a.a(this, new String[]{Permission.RECORD_AUDIO}, 3);
        return false;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void toggleFullscreen(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
    
        return true;
     */
    @android.annotation.SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean touchView(android.view.View r6, int r7) {
        /*
            r5 = this;
            int r6 = r6.getId()
            r0 = 2131493006(0x7f0c008e, float:1.860948E38)
            r1 = 2131492902(0x7f0c0026, float:1.860927E38)
            r2 = 1
            r3 = 0
            r4 = 2131493005(0x7f0c008d, float:1.8609478E38)
            switch(r6) {
                case 2131231166: goto Lb1;
                case 2131231167: goto Lb1;
                case 2131231176: goto L85;
                case 2131231177: goto L71;
                case 2131231185: goto L20;
                case 2131231186: goto L20;
                case 2131231187: goto L14;
                default: goto L12;
            }
        L12:
            goto Ldc
        L14:
            if (r7 != 0) goto Ldc
            c.h.a.a.i0 r6 = new c.h.a.a.i0
            r6.<init>()
            r5.toCheckPermission(r6)
            goto Ldc
        L20:
            if (r7 != 0) goto L4f
            boolean r6 = r5.toCheckPermissionAudio()
            if (r6 == 0) goto Ldc
            boolean r6 = r5.isFullscreen
            r7 = 2131493014(0x7f0c0096, float:1.8609496E38)
            if (r6 == 0) goto L34
            android.widget.ImageView r6 = r5.im_talk2
            r6.setImageResource(r7)
        L34:
            android.widget.ImageView r6 = r5.im_talk
            r6.setImageResource(r7)
            r5.StartTalk()
            boolean r6 = r5.isAudioClick
            if (r6 == 0) goto Ldc
            r5.StopAudio()
            android.widget.ImageView r6 = r5.im_audio2
            r6.setImageResource(r1)
            android.widget.ImageView r6 = r5.im_audio
            r6.setImageResource(r0)
            goto Ldc
        L4f:
            android.widget.ImageView r6 = r5.im_talk2
            r7 = 2131493013(0x7f0c0095, float:1.8609494E38)
            r6.setImageResource(r7)
            android.widget.ImageView r6 = r5.im_talk
            r6.setImageResource(r7)
            r5.StopTalk()
            boolean r6 = r5.isAudioClick
            if (r6 == 0) goto Ldc
            r5.StartAudio()
            android.widget.ImageView r6 = r5.im_audio2
            r6.setImageResource(r4)
            android.widget.ImageView r6 = r5.im_audio
            r6.setImageResource(r4)
            goto Ldc
        L71:
            if (r7 != 0) goto L7c
            c.h.a.a.h0 r6 = new c.h.a.a.h0
            r6.<init>()
            r5.toCheckPermission(r6)
            goto Ldc
        L7c:
            android.widget.ImageView r6 = r5.im_pic
            r7 = 2131493011(0x7f0c0093, float:1.860949E38)
            r6.setImageResource(r7)
            goto Ldc
        L85:
            if (r7 != 0) goto L90
            android.widget.ImageView r6 = r5.im_more
            r7 = 2131493010(0x7f0c0092, float:1.8609488E38)
            r6.setImageResource(r7)
            goto L98
        L90:
            android.widget.ImageView r6 = r5.im_more
            r7 = 2131493009(0x7f0c0091, float:1.8609486E38)
            r6.setImageResource(r7)
        L98:
            android.widget.PopupWindow r6 = r5.popupWindow_more_funtion
            if (r6 == 0) goto Ldc
            android.widget.RelativeLayout r7 = r5.lyHeader
            r0 = 80
            r6.showAtLocation(r7, r0, r3, r3)
            java.lang.String r6 = r5.strDID
            java.lang.String r7 = com.shix.shixipc.system.SystemValue.doorBellAdmin
            java.lang.String r0 = com.shix.shixipc.system.SystemValue.doorBellPass
            java.lang.String r7 = com.shix.shixipc.utils.CommonUtil.getCameraParms(r7, r0)
            com.shix.shixipc.he.NativeCallerTools.SDKAPITransferMessage(r6, r7)
            goto Ldc
        Lb1:
            if (r7 != 0) goto Ldc
            boolean r6 = r5.toCheckPermissionAudio()
            if (r6 == 0) goto Ldc
            boolean r6 = r5.isAudio
            if (r6 == 0) goto Lcd
            r5.StopAudio()
            r5.isAudioClick = r3
            android.widget.ImageView r6 = r5.im_audio2
            r6.setImageResource(r1)
            android.widget.ImageView r6 = r5.im_audio
            r6.setImageResource(r0)
            goto Ldc
        Lcd:
            r5.StartAudio()
            r5.isAudioClick = r2
            android.widget.ImageView r6 = r5.im_audio2
            r6.setImageResource(r4)
            android.widget.ImageView r6 = r5.im_audio
            r6.setImageResource(r4)
        Ldc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.NDNCameraLiveActivity.touchView(android.view.View, int):boolean");
    }

    private void updateStreamUI(int i2) {
        if (i2 == 0) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_fhd)).a(this.im_k);
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_fhd)).a(this.im_k2);
        } else if (i2 == 1) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_hd)).a(this.im_k);
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_hd)).a(this.im_k2);
        } else {
            if (i2 != 2) {
                return;
            }
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_sd)).a(this.im_k);
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.ic_sd)).a(this.im_k2);
        }
    }

    private void updateZoomView(int i2) {
        float f2 = 0.5625f;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        f2 = 0.0f;
                    }
                }
            }
            LogUtils.d("biniy", "translate-> " + f2);
            int screenSizeWidth = DisplayUtil.getScreenSizeWidth(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = screenSizeWidth;
            layoutParams.addRule(13);
            layoutParams.height = (int) (screenSizeWidth * f2);
            this.mZoomView.setLayoutParams(layoutParams);
        }
        f2 = 0.6875f;
        LogUtils.d("biniy", "translate-> " + f2);
        int screenSizeWidth2 = DisplayUtil.getScreenSizeWidth(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = screenSizeWidth2;
        layoutParams2.addRule(13);
        layoutParams2.height = (int) (screenSizeWidth2 * f2);
        this.mZoomView.setLayoutParams(layoutParams2);
    }

    @Override // com.shix.shixipc.utils.CustomAudioRecorder.AudioRecordResult
    public void AudioRecordData(byte[] bArr, int i2) {
        if (!this.bAudioRecordStart || i2 <= 0) {
            return;
        }
        NativeCallerTools.SDKAPISendTalkData(this.strDID, bArr, i2);
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i2 = jSONObject.getInt("cmd");
            if (i2 == 101) {
                this.cameraParmsModel = CameraParmsModel.jsonToModel(str2);
                this.mHandler.sendEmptyMessage(23);
            }
            if (i2 == 119) {
                this.alarmModel = YunTaiModel.jsonToModel(str2);
            }
            if (i2 == 133) {
                this.mDeviceSupportModel = DeviceSupportModel.jsonToModel(str2);
                if (jSONObject.has("set_idr_cmd")) {
                    this.mIsHasIdrCmd = jSONObject.getInt("set_idr_cmd");
                }
                if (jSONObject.has("4K_menu")) {
                    this.K_menu4 = jSONObject.getInt("4K_menu");
                }
                if (jSONObject.has("2K_menu")) {
                    this.K_menu2 = jSONObject.getInt("2K_menu");
                }
                if (jSONObject.has("clock_disable")) {
                    this.clock_disable = jSONObject.getInt("clock_disable");
                }
                LogUtils.d("biniy", "K_menu4 = " + this.K_menu4);
                LogUtils.d("biniy", "K_menu2 = " + this.K_menu2);
                if (jSONObject.has("speak_out")) {
                    this.speak_out = jSONObject.getInt("speak_out");
                }
                if (jSONObject.has("4g_net")) {
                    this.net_4g = jSONObject.optInt("4g_net");
                }
                jSONObject.optInt("push_msg_xiaomi_en");
                jSONObject.optInt("push_msg_huawei_en");
                jSONObject.optInt("push_msg_oppo_en");
                jSONObject.optInt("push_msg_vivo_en");
                jSONObject.optInt("push_msg_jg_en");
                this.mHandler.sendEmptyMessage(24);
            }
            if (i2 == 105) {
                MyLogUtils.d("tag", " getIFrame  is success! ");
            }
            if (i2 == 125) {
                DateModel jsonToModel = DateModel.jsonToModel(str2);
                this.dateModel = jsonToModel;
                if (jsonToModel.getNtpSwitch() == 1) {
                    this.mHandler.sendEmptyMessage(125);
                    MyLogUtils.d("tag", " 时区同步2");
                }
            }
            if (i2 == 130) {
                this.mHandler.sendEmptyMessageDelayed(130, 2000L);
            }
            if (i2 == 140) {
                this.myStatus = jSONObject.getInt("status");
                this.upgrade_signal = jSONObject.getInt("upgrade_signal");
                this.currVersion = jSONObject.getString("currVersion");
                this.newVersion = jSONObject.getString("newVersion");
                Bundle bundle = new Bundle();
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.what = 140;
                bundle.putInt("status", this.myStatus);
                bundle.putInt("upgrade_signal", this.upgrade_signal);
                obtainMessage.setData(bundle);
                this.mHandler.sendMessageDelayed(obtainMessage, 2000L);
            }
            if (i2 == 2000) {
                MyLogUtils.d("push", "2000 **dataJson =" + jSONObject);
                if (Rom.isMiui()) {
                    return;
                }
                int optInt = jSONObject.optInt("jg_push_en");
                this.jPush = optInt;
                if (optInt == 1) {
                    this.mHandler.sendEmptyMessage(RecyclerView.MAX_SCROLL_DURATION);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (z) {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1));
            CameraParmsModel cameraParmsModel = this.cameraParmsModel;
            if (cameraParmsModel != null) {
                cameraParmsModel.setLamp(1);
                return;
            }
            return;
        }
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0));
        CameraParmsModel cameraParmsModel2 = this.cameraParmsModel;
        if (cameraParmsModel2 != null) {
            cameraParmsModel2.setLamp(0);
        }
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        if (z) {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1));
            CameraParmsModel cameraParmsModel = this.cameraParmsModel;
            if (cameraParmsModel != null) {
                cameraParmsModel.setClockScreen(1);
                return;
            }
            return;
        }
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0));
        CameraParmsModel cameraParmsModel2 = this.cameraParmsModel;
        if (cameraParmsModel2 != null) {
            cameraParmsModel2.setClockScreen(0);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBaceVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackAudioData(byte[] bArr, int i2) {
        TakeVideoThread takeVideoThread;
        if (this.isTakeVideo) {
            if (!this.isH264Data || (takeVideoThread = this.takeVideoThread) == null) {
                try {
                    byte[] byteArr = ByteUtil.getByteArr(bArr, 0, i2);
                    if (this.mBytes1 != null && this.mBytes1.length != 0) {
                        if (this.isMp4Opened) {
                            byte[] byteMerger = ByteUtil.byteMerger(this.mBytes1, byteArr);
                            this.mBytes1 = byteMerger;
                            if (byteMerger.length >= 2048) {
                                byte[] byteArr2 = ByteUtil.getByteArr(byteMerger, 0, 2048);
                                this.mBytes2 = byteArr2;
                                byte[] encode = this.mAacEncode.encode(byteArr2, 0, byteArr2.length);
                                NativeImplement.MP4WRITEAddAudio(1, encode, encode.length);
                                this.mBytes1 = ByteUtil.getByteArr(this.mBytes1, 2048, this.mBytes1.length);
                            }
                        }
                        MyLogUtils.d("tag", "  音频数据2 mBytes1=" + this.mBytes1.length);
                    }
                    this.mBytes1 = byteArr;
                    MyLogUtils.d("tag", "  音频数据1 mBytes1=" + this.mBytes1.length);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.isHaveIFrame) {
                takeVideoThread.addAudio(ByteUtil.getByteArr(bArr, 0, i2));
            }
        }
        AudioPlayer audioPlayer = this.audioPlayer;
        if (audioPlayer == null || audioPlayer.isAudioPlaying()) {
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferData.data = ByteUtil.getByteArr(bArr, 0, i2);
            this.AudioBuffer.addData(customBufferData);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackCameraParamNotify(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackConnectLook(String str, int i2, int i3) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackLiveStatusNotify(int i2, int i3, int i4) {
        if (i3 == 0 && i4 != 2 && DeviceUtil.INSTANCE.getDid(i2).equalsIgnoreCase(this.strDID)) {
            this.mHandler.sendEmptyMessage(123321);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callBackMessageNotify(String str, int i2, int i3) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        if (DeviceUtil.INSTANCE.getDid(i2).endsWith(this.strDID)) {
            MyLogUtils.d("tag", " 跳帧 isNeedShow=" + this.isNeedShow);
            this.devDecoderCount1 = this.devDecoderCount1 + 1;
            this.bDisplayFinished = false;
            this.videodata = bArr;
            this.videoDataLen = bArr.length;
            Message message = new Message();
            this.nVideoWidth = i3;
            this.nVideoHeight = i4;
            if (this.isTakepic) {
                this.isTakepic = false;
                byte[] bArr3 = new byte[i3 * i4 * 2];
                NativeCallerTools.SDKAPIYuv420ToRgb565(bArr, bArr3, i3, i4);
                ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
                this.mBmp = createBitmap;
                createBitmap.copyPixelsFromBuffer(wrap);
                takePicture(this.mBmp);
            }
            if (this.isNeedShow) {
                message.what = 1;
                this.mHandler.sendMessage(message);
            }
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayInterface
    public void callbackVideoData(int i2, byte[] bArr, int i3, VideoModel videoModel) {
        TakeVideoThread takeVideoThread;
        if (DeviceUtil.INSTANCE.getDid(i2).endsWith(this.strDID)) {
            char c2 = 65535;
            if (videoModel.getStartcode() == -1474975147) {
                this.isH264Data = true;
                c2 = 0;
            } else if (videoModel.getStartcode() == -1474975148) {
                this.isH264Data = false;
                c2 = 1;
            }
            this.mySignalvalue = videoModel.getSignalvalue();
            if (this.isTakeVideo) {
                if (videoModel.getFrametype() == 0) {
                    this.isHaveIFrame = true;
                }
                int i4 = c2 == 0 ? 1 : 0;
                if (this.isH264Data && (takeVideoThread = this.takeVideoThread) != null) {
                    if (this.isHaveIFrame) {
                        takeVideoThread.addVideo(bArr, i4, this.nVideoWidth, this.nVideoHeight);
                    }
                } else if (this.isMp4Opened) {
                    Mp4VideoData mp4VideoData = new Mp4VideoData(i4, videoModel.getFramerate());
                    this.mMp4VideoData = mp4VideoData;
                    NativeImplement.MP4WRITEAddVideo(1, bArr, bArr.length, mp4VideoData);
                }
            }
        }
    }

    public int getBatteryRes(int i2) {
        return i2 >= 90 ? R.mipmap.home_power_100 : i2 >= 60 ? R.mipmap.home_power_80 : i2 >= 40 ? R.mipmap.home_power_60 : i2 >= 20 ? R.mipmap.home_power_40 : R.mipmap.home_power_20;
    }

    public void initExitPopupWindow_Hight() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_4k, (ViewGroup) null);
        this.popv_hight = inflate;
        this.btn4k = (Button) inflate.findViewById(R.id.button_4k);
        this.btn2k = (Button) this.popv_hight.findViewById(R.id.button_2k);
        this.btn1080 = (Button) this.popv_hight.findViewById(R.id.button_1080);
        this.btn720 = (Button) this.popv_hight.findViewById(R.id.button_720);
        this.btn4k.setOnClickListener(this);
        this.btn2k.setOnClickListener(this);
        this.btn1080.setOnClickListener(this);
        this.btn720.setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(this.popv_hight, -2, -2);
        this.popupWindow_hight = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_hight.setFocusable(true);
        this.popupWindow_hight.setInputMethodMode(1);
        this.popupWindow_hight.setSoftInputMode(16);
        this.popupWindow_hight.setOutsideTouchable(true);
        this.popupWindow_hight.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_hight.setFocusableInTouchMode(true);
        this.popv_hight.setOnKeyListener(new View.OnKeyListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.35
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 82) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
        this.popupWindow_hight.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.36
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NDNCameraLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.37
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_Hight_tut() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_4k_tut, (ViewGroup) null);
        this.popv_hight_tut = inflate;
        this.btnTut1080 = (Button) inflate.findViewById(R.id.button_4k_tut);
        this.btnTut720 = (Button) this.popv_hight_tut.findViewById(R.id.button_2k_tut);
        this.btnTut640 = (Button) this.popv_hight_tut.findViewById(R.id.button_1080_tut);
        this.btnTutVGA = (Button) this.popv_hight_tut.findViewById(R.id.button_720_tut);
        this.btnTut1080.setOnClickListener(this);
        this.btnTut720.setOnClickListener(this);
        this.btnTut640.setOnClickListener(this);
        this.btnTutVGA.setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(this.popv_hight_tut, -2, -2);
        this.popupWindow_hight_tut = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_hight_tut.setFocusable(true);
        this.popupWindow_hight_tut.setInputMethodMode(1);
        this.popupWindow_hight_tut.setSoftInputMode(16);
        this.popupWindow_hight_tut.setOutsideTouchable(true);
        this.popupWindow_hight_tut.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_hight_tut.setFocusableInTouchMode(true);
        this.popv_hight_tut.setOnKeyListener(new View.OnKeyListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.38
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 82) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_hight_tut.dismiss();
                return false;
            }
        });
        this.popupWindow_hight_tut.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.39
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NDNCameraLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight_tut.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.40
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_hight_tut.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_Icut() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_icut, (ViewGroup) null);
        this.popv_icut = inflate;
        Button button = (Button) inflate.findViewById(R.id.icut0);
        this.icut0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.popv_icut.findViewById(R.id.icut1);
        this.icut1 = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) this.popv_icut.findViewById(R.id.icut2);
        this.icut2 = button3;
        button3.setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(this.popv_icut, -2, -2);
        this.popupWindow_Icut = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_Icut.setFocusable(true);
        this.popupWindow_Icut.setInputMethodMode(1);
        this.popupWindow_Icut.setSoftInputMode(16);
        this.popupWindow_Icut.setOutsideTouchable(true);
        this.popupWindow_Icut.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_icut.setFocusableInTouchMode(true);
        this.popv_icut.setOnKeyListener(new View.OnKeyListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.29
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 82) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.30
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_more_funtion() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_playmore_funtion, (ViewGroup) null);
        this.popv_more_funtion = inflate;
        this.popupmore = inflate.findViewById(R.id.popupmore);
        this.seekBar1 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar1);
        this.seekBar2 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar2);
        this.audioLayout = (LinearLayout) this.popv_more_funtion.findViewById(R.id.audioLayout);
        this.test1 = (SwitchView) this.popv_more_funtion.findViewById(R.id.test1);
        this.test2 = (EditText) this.popv_more_funtion.findViewById(R.id.test2);
        this.test3 = (EditText) this.popv_more_funtion.findViewById(R.id.test3);
        this.test4 = (EditText) this.popv_more_funtion.findViewById(R.id.test4);
        this.test5 = (EditText) this.popv_more_funtion.findViewById(R.id.test5);
        this.mSvSzpRl = (RelativeLayout) this.popv_more_funtion.findViewById(R.id.sv_szp_rl);
        this.test5.addTextChangedListener(new TextWatcher() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.13
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                if (parseInt < 1024) {
                    parseInt = 1024;
                } else if (parseInt > 2048) {
                    parseInt = 2048;
                }
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_ispdgain", parseInt));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_ispdgain(parseInt);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.test4.addTextChangedListener(new TextWatcher() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.14
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                if (parseInt < 1024) {
                    parseInt = 1024;
                } else if (parseInt > 2048) {
                    parseInt = 2048;
                }
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_dgain", parseInt));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_dgain(parseInt);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.test3.addTextChangedListener(new TextWatcher() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.15
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                if (parseInt < 1024) {
                    parseInt = 1024;
                } else if (parseInt > 2048) {
                    parseInt = 2048;
                }
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_again", parseInt));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_again(parseInt);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.test2.addTextChangedListener(new TextWatcher() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.16
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                if (parseInt < 0) {
                    parseInt = 0;
                } else if (parseInt > 90000) {
                    parseInt = 90000;
                }
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_expTime", parseInt));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_expTime(parseInt);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.test1.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.17
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                NDNCameraLiveActivity.this.test1.setOpened(false);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_en", 0));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_en(0);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                NDNCameraLiveActivity.this.test1.setOpened(true);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "menual_exposure_en", 1));
                NDNCameraLiveActivity.this.cameraParmsModel.setMenual_exposure_en(1);
            }
        });
        this.sv_zsd = (SwitchView) this.popv_more_funtion.findViewById(R.id.sv_zsd);
        SwitchView switchView = (SwitchView) this.popv_more_funtion.findViewById(R.id.sv_szp);
        this.sv_szp = switchView;
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.18
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView2) {
                NDNCameraLiveActivity.this.sv_szp.setOpened(false);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0));
                CameraParmsModel cameraParmsModel = NDNCameraLiveActivity.this.cameraParmsModel;
                if (cameraParmsModel != null) {
                    cameraParmsModel.setClockScreen(0);
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView2) {
                NDNCameraLiveActivity.this.sv_szp.setOpened(true);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1));
                CameraParmsModel cameraParmsModel = NDNCameraLiveActivity.this.cameraParmsModel;
                if (cameraParmsModel != null) {
                    cameraParmsModel.setClockScreen(1);
                }
            }
        });
        this.sv_zsd.setOnStateChangedListener(new SwitchView.OnStateChangedListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.19
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView2) {
                NDNCameraLiveActivity.this.sv_zsd.setOpened(false);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0));
                CameraParmsModel cameraParmsModel = NDNCameraLiveActivity.this.cameraParmsModel;
                if (cameraParmsModel != null) {
                    cameraParmsModel.setLamp(0);
                }
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView2) {
                NDNCameraLiveActivity.this.sv_zsd.setOpened(true);
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1));
                CameraParmsModel cameraParmsModel = NDNCameraLiveActivity.this.cameraParmsModel;
                if (cameraParmsModel != null) {
                    cameraParmsModel.setLamp(1);
                }
            }
        });
        this.tvSee1 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee1);
        this.tvSee2 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee2);
        this.seekBar1.setMax(100);
        this.seekBar2.setMax(100);
        this.seekBar11 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar11);
        this.seekBar12 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar12);
        this.tvSee11 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee11);
        this.tvSee12 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee12);
        this.seekBar11.setMax(100);
        this.seekBar12.setMax(100);
        this.seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.20
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                NDNCameraLiveActivity.this.tvSee11.setText(String.valueOf(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "contrast", seekBar.getProgress()));
            }
        });
        this.seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.21
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                NDNCameraLiveActivity.this.tvSee12.setText(String.valueOf(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "bright", seekBar.getProgress()));
            }
        });
        this.seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.22
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                NDNCameraLiveActivity.this.tvSee1.setText(String.valueOf(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_setMIC(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()));
            }
        });
        this.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.23
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                NDNCameraLiveActivity.this.tvSee2.setText(String.valueOf(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCallerTools.SDKAPITransferMessage(NDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_setSPK(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()));
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonSD).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NDNCameraLiveActivity.this.isTakeVideo) {
                    ToastUtils.showShort(R.string.ptz_takevideo_show);
                    return;
                }
                NDNCameraLiveActivity.this.dropOut();
                NDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                Intent intent = new Intent(NDNCameraLiveActivity.this, (Class<?>) PlayBackTFActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, NDNCameraLiveActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, NDNCameraLiveActivity.this.strDID);
                NDNCameraLiveActivity.this.startActivity(intent);
                NDNCameraLiveActivity.this.finish();
            }
        });
        PopupWindow popupWindow = new PopupWindow(this.popv_more_funtion, -1, -2);
        this.popupWindow_more_funtion = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_more_funtion.setFocusable(true);
        this.popupWindow_more_funtion.setInputMethodMode(1);
        this.popupWindow_more_funtion.setSoftInputMode(16);
        this.popupWindow_more_funtion.setOutsideTouchable(true);
        this.popupWindow_more_funtion.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_more_funtion.setFocusableInTouchMode(true);
        this.popv_more_funtion.setOnKeyListener(new View.OnKeyListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.26
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 82) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.27
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        if (this.speak_out == 1) {
            this.audioLayout.setVisibility(0);
        } else {
            this.audioLayout.setVisibility(8);
        }
    }

    public void initExitPopupWindow_zsd() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_zsd, (ViewGroup) null);
        this.popv_zsd = inflate;
        Button button = (Button) inflate.findViewById(R.id.btn_zsd0);
        this.btn_zsd0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.popv_zsd.findViewById(R.id.btn_zsd1);
        this.btn_zsd1 = button2;
        button2.setOnClickListener(this);
        PopupWindow popupWindow = new PopupWindow(this.popv_zsd, -2, -2);
        this.popupWindow_zsd = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_zsd.setFocusable(true);
        this.popupWindow_zsd.setInputMethodMode(1);
        this.popupWindow_zsd.setSoftInputMode(16);
        this.popupWindow_zsd.setOutsideTouchable(true);
        this.popupWindow_zsd.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_zsd.setFocusableInTouchMode(true);
        this.popv_zsd.setOnKeyListener(new View.OnKeyListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.32
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 82) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_zsd.dismiss();
                return false;
            }
        });
        this.popupWindow_zsd.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.33
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                NDNCameraLiveActivity.this.popupWindow_zsd.dismiss();
            }
        });
        this.popupWindow_zsd.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.34
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraLiveActivity.this.popupWindow_zsd.dismiss();
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10L);
        }
        int id = view.getId();
        switch (id) {
            case R.id.btnPtz_cer /* 2131230835 */:
                contrDevDee(1, ContentCommon.CMD_PTZ_RESET);
                break;
            case R.id.btnPtz_down /* 2131230836 */:
                contrDevDee(1, 2);
                break;
            case R.id.btnPtz_left /* 2131230837 */:
                contrDevDee(1, 4);
                break;
            case R.id.btnPtz_right /* 2131230838 */:
                contrDevDee(1, 6);
                break;
            case R.id.btnPtz_up /* 2131230839 */:
                contrDevDee(1, 0);
                break;
            case R.id.btnTouch /* 2131230840 */:
                MyLogUtils.d("tag", " CameraLive btnTouch");
                if (!this.rl_h_bm.isShown()) {
                    this.rl_h_bm.setVisibility(0);
                    break;
                } else {
                    this.rl_h_bm.setVisibility(8);
                    break;
                }
            default:
                switch (id) {
                    case R.id.btn_full /* 2131230848 */:
                    case R.id.btn_full2 /* 2131230849 */:
                        toggleFullscreen(!this.isFullscreen);
                        break;
                    default:
                        switch (id) {
                            case R.id.btn_zsd0 /* 2131230860 */:
                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1));
                                CameraParmsModel cameraParmsModel = this.cameraParmsModel;
                                if (cameraParmsModel != null) {
                                    cameraParmsModel.setLamp(1);
                                }
                                this.btn_zsd0.setTextColor(getResources().getColor(R.color.gray));
                                this.btn_zsd1.setTextColor(getResources().getColor(R.color.color_white));
                                break;
                            case R.id.btn_zsd1 /* 2131230861 */:
                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0));
                                CameraParmsModel cameraParmsModel2 = this.cameraParmsModel;
                                if (cameraParmsModel2 != null) {
                                    cameraParmsModel2.setLamp(0);
                                }
                                this.btn_zsd0.setTextColor(getResources().getColor(R.color.color_white));
                                this.btn_zsd1.setTextColor(getResources().getColor(R.color.gray));
                                break;
                            default:
                                switch (id) {
                                    case R.id.button_1080 /* 2131230867 */:
                                    case R.id.button_1080_tut /* 2131230868 */:
                                        this.clickRs = 1;
                                        UpdateClarityUi(1);
                                        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", this.clickRs);
                                        this.popupWindow_hight.dismiss();
                                        this.popupWindow_hight_tut.dismiss();
                                        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
                                        try {
                                            Thread.sleep(300L);
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 2);
                                        updateZoomView(this.clickRs);
                                        break;
                                    case R.id.button_2k /* 2131230869 */:
                                    case R.id.button_2k_tut /* 2131230870 */:
                                        this.clickRs = 2;
                                        UpdateClarityUi(2);
                                        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", this.clickRs);
                                        this.popupWindow_hight.dismiss();
                                        this.popupWindow_hight_tut.dismiss();
                                        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
                                        try {
                                            Thread.sleep(300L);
                                        } catch (InterruptedException e3) {
                                            e3.printStackTrace();
                                        }
                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 1);
                                        updateZoomView(this.clickRs);
                                        break;
                                    case R.id.button_4k /* 2131230871 */:
                                    case R.id.button_4k_tut /* 2131230872 */:
                                        this.clickRs = 3;
                                        UpdateClarityUi(3);
                                        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", this.clickRs);
                                        this.popupWindow_hight.dismiss();
                                        this.popupWindow_hight_tut.dismiss();
                                        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
                                        try {
                                            Thread.sleep(300L);
                                        } catch (InterruptedException e4) {
                                            e4.printStackTrace();
                                        }
                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 1);
                                        updateZoomView(this.clickRs);
                                        break;
                                    case R.id.button_720 /* 2131230873 */:
                                    case R.id.button_720_tut /* 2131230874 */:
                                        this.clickRs = 0;
                                        UpdateClarityUi(0);
                                        this.popupWindow_hight.dismiss();
                                        this.popupWindow_hight_tut.dismiss();
                                        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
                                        try {
                                            Thread.sleep(300L);
                                        } catch (InterruptedException e5) {
                                            e5.printStackTrace();
                                        }
                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 2);
                                        updateZoomView(this.clickRs);
                                        break;
                                    default:
                                        switch (id) {
                                            case R.id.cam_live_continue_play /* 2131230882 */:
                                                String str = this.strDID;
                                                if (str != null && !str.isEmpty()) {
                                                    this.camLiveContinuePlay.setVisibility(8);
                                                    int i2 = this.clickRs;
                                                    if (i2 != 2 && i2 != 3) {
                                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 0);
                                                        break;
                                                    } else {
                                                        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 1);
                                                        break;
                                                    }
                                                } else {
                                                    dropOut();
                                                    finish();
                                                    break;
                                                }
                                                break;
                                            case R.id.glVideo /* 2131231041 */:
                                                if (this.isFullscreen) {
                                                    if (!this.rl_h_bm.isShown()) {
                                                        this.rl_h_bm.setVisibility(0);
                                                        break;
                                                    } else {
                                                        this.rl_h_bm.setVisibility(8);
                                                        break;
                                                    }
                                                }
                                                break;
                                            case R.id.im_zsd /* 2131231098 */:
                                                if (this.cameraParmsModel != null) {
                                                    this.popupWindow_zsd.showAtLocation(this.im_ircut, 48, 0, InactivityTimer.INACTIVITY_DELAY_SECONDS);
                                                    break;
                                                }
                                                break;
                                            case R.id.ivBack /* 2131231123 */:
                                                if (!this.isTakeVideo) {
                                                    returnLastBmp2Home();
                                                    this.dlgExit.show();
                                                    break;
                                                } else {
                                                    ToastUtils.showShort(R.string.ptz_takevideo_show);
                                                    break;
                                                }
                                            case R.id.ivOperator1 /* 2131231125 */:
                                                if (!this.isTakeVideo) {
                                                    dropOut();
                                                    Intent intent = new Intent(this, (Class<?>) SettingActivity.class);
                                                    intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                                                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                                                    intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                                                    intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                                                    startActivity(intent);
                                                    finish();
                                                    break;
                                                } else {
                                                    ToastUtils.showShort(R.string.ptz_takevideo_show);
                                                    break;
                                                }
                                            case R.id.mtv_set_ksw /* 2131231254 */:
                                                try {
                                                    NativeCallerTools.SDKAPITransferMessage(this.strDID, YunTaiModel.toJsonSimple(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass, "set_watch_position", 1));
                                                    Toast.makeText(this, getResources().getString(R.string.set_ksw_done), 1).show();
                                                    break;
                                                } catch (JSONException e6) {
                                                    e6.printStackTrace();
                                                    return;
                                                }
                                            case R.id.tvCancel /* 2131231558 */:
                                                this.dlgExit.dismiss();
                                                break;
                                            case R.id.tvExit /* 2131231560 */:
                                                this.dlgExit.dismiss();
                                                dropOut();
                                                finish();
                                                break;
                                            default:
                                                switch (id) {
                                                    case R.id.icut0 /* 2131231069 */:
                                                        this.popupWindow_Icut.dismiss();
                                                        if (this.cameraParmsModel != null) {
                                                            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 0));
                                                            CameraParmsModel cameraParmsModel3 = this.cameraParmsModel;
                                                            if (cameraParmsModel3 != null) {
                                                                cameraParmsModel3.setIcut(0);
                                                            }
                                                            this.icut0.setTextColor(getResources().getColor(R.color.colorPrimary));
                                                            this.icut1.setTextColor(getResources().getColor(R.color.color_white));
                                                            this.icut2.setTextColor(getResources().getColor(R.color.color_white));
                                                            break;
                                                        }
                                                        break;
                                                    case R.id.icut1 /* 2131231070 */:
                                                        this.popupWindow_Icut.dismiss();
                                                        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 1));
                                                        CameraParmsModel cameraParmsModel4 = this.cameraParmsModel;
                                                        if (cameraParmsModel4 != null) {
                                                            cameraParmsModel4.setIcut(1);
                                                        }
                                                        this.icut1.setTextColor(getResources().getColor(R.color.colorPrimary));
                                                        this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                                                        this.icut2.setTextColor(getResources().getColor(R.color.color_white));
                                                        break;
                                                    case R.id.icut2 /* 2131231071 */:
                                                        this.popupWindow_Icut.dismiss();
                                                        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 2));
                                                        CameraParmsModel cameraParmsModel5 = this.cameraParmsModel;
                                                        if (cameraParmsModel5 != null) {
                                                            cameraParmsModel5.setIcut(2);
                                                        }
                                                        this.icut2.setTextColor(getResources().getColor(R.color.colorPrimary));
                                                        this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                                                        this.icut1.setTextColor(getResources().getColor(R.color.color_white));
                                                        break;
                                                    default:
                                                        switch (id) {
                                                            case R.id.im_ircut /* 2131231079 */:
                                                            case R.id.im_ircut1 /* 2131231080 */:
                                                                this.popupWindow_Icut.showAtLocation(this.im_ircut, 48, 0, InactivityTimer.INACTIVITY_DELAY_SECONDS);
                                                                break;
                                                            case R.id.im_jx_rl /* 2131231081 */:
                                                            case R.id.im_jx_rl2 /* 2131231082 */:
                                                                if (this.mirror == 1) {
                                                                    this.mirror = 0;
                                                                    if (0 == 0 && this.flipping == 1) {
                                                                        this.ret = 2;
                                                                    } else if (this.mirror == 0 && this.flipping == 0) {
                                                                        this.ret = 0;
                                                                    }
                                                                } else {
                                                                    this.mirror = 1;
                                                                    if (1 == 1 && this.flipping == 1) {
                                                                        this.ret = 3;
                                                                    } else if (this.mirror == 1 && this.flipping == 0) {
                                                                        this.ret = 1;
                                                                    }
                                                                }
                                                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "rotmir", this.ret));
                                                                break;
                                                            case R.id.im_jx_ud /* 2131231083 */:
                                                            case R.id.im_jx_ud2 /* 2131231084 */:
                                                                if (this.flipping == 1) {
                                                                    this.flipping = 0;
                                                                    if (this.mirror == 1 && 0 == 0) {
                                                                        this.ret = 1;
                                                                    } else if (this.mirror == 0 && this.flipping == 0) {
                                                                        this.ret = 0;
                                                                    }
                                                                } else {
                                                                    this.flipping = 1;
                                                                    if (this.mirror == 1 && 1 == 1) {
                                                                        this.ret = 3;
                                                                    } else if (this.mirror == 0 && this.flipping == 1) {
                                                                        this.ret = 2;
                                                                    }
                                                                }
                                                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "rotmir", this.ret));
                                                                break;
                                                            case R.id.im_k /* 2131231085 */:
                                                            case R.id.im_k2 /* 2131231086 */:
                                                                if (this.K_menu2 != 1 && this.K_menu4 != 1) {
                                                                    this.popupWindow_hight_tut.showAtLocation(this.im_k, 17, 0, 0);
                                                                    break;
                                                                } else {
                                                                    this.popupWindow_hight.showAtLocation(this.im_k, 17, 0, 0);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (id) {
                                                                    case R.id.im_showhide /* 2131231091 */:
                                                                        if (!this.isFullscreen) {
                                                                            if (!this.fl_bg.isShown()) {
                                                                                this.fl_bg.setVisibility(0);
                                                                                this.im_showhide.setImageResource(R.mipmap.huang_play_down);
                                                                                break;
                                                                            } else {
                                                                                this.fl_bg.setVisibility(8);
                                                                                this.im_showhide.setImageResource(R.mipmap.huang_play_up);
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case R.id.im_t /* 2131231092 */:
                                                                        CameraParmsModel cameraParmsModel6 = this.cameraParmsModel;
                                                                        if (cameraParmsModel6 != null) {
                                                                            if (cameraParmsModel6.getClockScreen() != 0) {
                                                                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0));
                                                                                this.cameraParmsModel.setClockScreen(0);
                                                                                this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_topen);
                                                                                break;
                                                                            } else {
                                                                                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1));
                                                                                this.cameraParmsModel.setClockScreen(1);
                                                                                this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_tclose);
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation != 1) {
            if (getResources().getConfiguration().orientation != 2 || this.isFullscreen) {
                return;
            }
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.hz_play_full2)).a(this.btn_full);
            this.viewLineBottom.setVisibility(8);
            this.tv_video.setTextColor(getResources().getColor(R.color.color_white));
            this.tv_pic.setTextColor(getResources().getColor(R.color.color_white));
            this.tv_talk.setTextColor(getResources().getColor(R.color.color_white));
            this.tv_audio.setTextColor(getResources().getColor(R.color.color_white));
            this.tv_more.setTextColor(getResources().getColor(R.color.color_white));
            this.isFullscreen = true;
            BarUtils.setStatusBarVisibility((Activity) this, false);
            if (Build.VERSION.SDK_INT >= 21) {
                BarUtils.setNavBarColor(this, getResources().getColor(R.color.black));
            }
            this.lyHeader.setVisibility(8);
            this.mCamLiveBottom.setVisibility(8);
            if (this.speak_out != 1) {
                this.ll_talk2.setVisibility(8);
            }
            if (this.mDeviceSupportModel.getIrcut_menu_dis() == 1) {
                this.mCamLiveYs1.setVisibility(8);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mZoomView.setLayoutParams(layoutParams);
            this.rootView.setBackgroundColor(getResources().getColor(R.color.black));
            this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_white));
            return;
        }
        if (this.isFullscreen) {
            e.a((FragmentActivity) this).a(Integer.valueOf(R.mipmap.hz_play_full1)).a(this.btn_full);
            this.viewLineBottom.setVisibility(0);
            this.tv_video.setTextColor(getResources().getColor(R.color.black_4C4C4C));
            this.tv_pic.setTextColor(getResources().getColor(R.color.black_4C4C4C));
            this.tv_talk.setTextColor(getResources().getColor(R.color.black_4C4C4C));
            this.tv_audio.setTextColor(getResources().getColor(R.color.black_4C4C4C));
            this.tv_more.setTextColor(getResources().getColor(R.color.black_4C4C4C));
            BarUtils.setStatusBarVisibility((Activity) this, true);
            if (Build.VERSION.SDK_INT >= 21) {
                BarUtils.setNavBarColor(this, getResources().getColor(R.color.white));
            }
            this.isFullscreen = false;
            this.lyHeader.setVisibility(0);
            this.shix_LL_buttom.setVisibility(0);
            this.mCamLiveBottom.setVisibility(0);
            this.rl_h_bm.setVisibility(8);
            int screenSizeWidth = DisplayUtil.getScreenSizeWidth(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = screenSizeWidth;
            layoutParams2.height = (screenSizeWidth * 9) / 16;
            layoutParams2.addRule(13);
            this.mZoomView.setLayoutParams(layoutParams2);
            updateZoomView(this.clickRs);
            this.rootView.setBackgroundColor(getResources().getColor(R.color.white));
            this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_white));
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_camera_live_dn_n);
        BarUtils.setStatusBarLightMode((Activity) this, true);
        this.isDateComeOn = false;
        getDataFromOther();
        this.audioManager = (AudioManager) getSystemService("audio");
        this.glVideo = (GLSurfaceView) findViewById(R.id.glVideo);
        this.fcmToken = SharedPreferencesUtils.getInstance().getString("FcmToken", "");
        initView();
        initAnim();
        initExitPopupWindow_more_funtion();
        initExitPopupWindow_Hight();
        initExitPopupWindow_Hight_tut();
        initExitPopupWindow_Icut();
        initExitPopupWindow_zsd();
        initListen();
        initExitDialog();
        a aVar = new a(this.glVideo);
        this.myRender = aVar;
        this.glVideo.setRenderer(aVar);
        NUIMainActivity.setPlayInterface(this);
        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", 1);
        UpdateClarityUi(this.clickRs);
        NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, 2);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        if (isChineseLanguage()) {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_SetCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1));
            MyLogUtils.d("push", "语言命令===中文");
        } else {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_SetCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0));
            MyLogUtils.d("push", "语言命令==English");
        }
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getDeviceSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getPushSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getYunTai(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.SHIX_getSPKMICParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        String externalStorageState = Environment.getExternalStorageState();
        this.status = externalStorageState;
        if (externalStorageState.equals("mounted")) {
            try {
                this.path = FileUtil.getRootDir();
                this.stat = new StatFs(this.path.getPath());
                this.blockSize = r5.getBlockSize();
                this.totalBlocks = this.stat.getBlockCount();
                this.availableBlocks = this.stat.getAvailableBlocks();
            } catch (IllegalArgumentException unused) {
                this.status = "removed";
            }
        }
        CustomBuffer customBuffer = new CustomBuffer();
        this.AudioBuffer = customBuffer;
        this.audioPlayer = new AudioPlayer(customBuffer);
        this.customAudioRecorder = new CustomAudioRecorder(this);
        AacEncode aacEncode = new AacEncode();
        this.mAacEncode = aacEncode;
        aacEncode.start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mAacEncode.close();
        SharedPreferencesUtils.getInstance().putInt(this.strDID + "clickRs", 0);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        boolean z = this.isFullscreen;
        if (z) {
            toggleFullscreen(!z);
            return true;
        }
        if (this.isTakeVideo) {
            ToastUtils.showShort(R.string.ptz_takevideo_show);
            return true;
        }
        returnLastBmp2Home();
        this.dlgExit.show();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.isTakeVideo) {
            if (this.isAudio) {
                StopAudio();
                this.isAudioClick = false;
                this.im_audio.setImageResource(R.mipmap.n_audios1);
            }
            this.im_video.setImageResource(R.mipmap.n_play_buttom_video);
            hideRecordTimeTips();
            this.isTakeVideo = false;
            this.isHaveIFrame = false;
            if (this.isH264Data) {
                TakeVideoThread takeVideoThread = this.takeVideoThread;
                if (takeVideoThread != null) {
                    takeVideoThread.stopThread();
                }
            } else {
                this.mBytes1 = new byte[0];
                this.mBytes2 = new byte[0];
                this.isMp4Opened = false;
                NativeImplement.MP4WRITEClose(1L);
            }
        }
        this.camLiveContinuePlay.setVisibility(0);
        NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        if (2 == i2) {
            if (iArr[0] == 0 || iArr[0] == 0) {
                return;
            }
            if (a.h.a.a.a((Activity) this, Permission.WRITE_EXTERNAL_STORAGE)) {
                showDialog(true);
                return;
            } else {
                showDialog(false);
                return;
            }
        }
        if (3 != i2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] == 0 || iArr[0] == 0) {
            return;
        }
        if (a.h.a.a.a((Activity) this, Permission.RECORD_AUDIO)) {
            showDialogAudio(true);
        } else {
            showDialogAudio(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == 1) {
            this.isFullscreen = false;
            this.isCheckVideo = true;
        } else {
            this.isCheckVideo = false;
            this.isFullscreen = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return touchView(view, 0);
        }
        if (action != 1) {
            return false;
        }
        return touchView(view, 1);
    }

    public void showUpdate(boolean z) {
        String str;
        final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getResources().getText(R.string.check_updata_5));
        if (z) {
            str = "  " + this.currVersion + "--->" + this.newVersion;
        } else {
            str = "";
        }
        sb.append(str);
        niftyDialogBuilder.withMessage(sb.toString()).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).withTitle(getString(R.string.update_title)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.47
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.46
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                niftyDialogBuilder.dismiss();
                NDNCameraLiveActivity.this.dropOut();
                Intent intent = new Intent(NDNCameraLiveActivity.this, (Class<?>) SettingDeviceActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, NDNCameraLiveActivity.this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, NDNCameraLiveActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, NDNCameraLiveActivity.this.strPwd);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, NDNCameraLiveActivity.this.strUser);
                NDNCameraLiveActivity.this.startActivity(intent);
                NDNCameraLiveActivity.this.finish();
            }
        }).show();
    }

    public /* synthetic */ void b(boolean z) {
        if (z) {
            this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic_ing);
            this.isTakepic = true;
        }
    }

    public /* synthetic */ void a(boolean z) {
        if (z) {
            if (this.isTakeVideo) {
                if (this.recordTime < 3) {
                    Toast.makeText(this, getResources().getString(R.string.play_videoing_show), 0).show();
                    return;
                }
                this.isMp4Opened = false;
                if (this.isAudio) {
                    StopAudio();
                    this.isAudioClick = false;
                    this.im_audio2.setImageResource(R.mipmap.full_voice_close_icon);
                    this.im_audio.setImageResource(R.mipmap.n_audios2);
                }
                this.im_video.setImageResource(R.mipmap.n_play_buttom_video);
                hideRecordTimeTips();
                this.isTakeVideo = false;
                this.isHaveIFrame = false;
                if (this.isH264Data) {
                    TakeVideoThread takeVideoThread = this.takeVideoThread;
                    if (takeVideoThread != null) {
                        takeVideoThread.stopThread();
                        return;
                    }
                    return;
                }
                this.mBytes1 = new byte[0];
                this.mBytes2 = new byte[0];
                this.isMp4Opened = false;
                NativeImplement.MP4WRITEClose(1L);
                return;
            }
            if (!this.isAudio) {
                StartAudio();
                this.isAudioClick = true;
                this.im_audio2.setImageResource(R.mipmap.n_audios1);
                this.im_audio.setImageResource(R.mipmap.n_audios1);
            }
            this.im_video.setImageResource(R.mipmap.n_play_buttom_videoing);
            showRecordTimeTips();
            StatFs statFs = new StatFs(this.path.getPath());
            this.stat = statFs;
            long availableBlocks = statFs.getAvailableBlocks();
            this.availableBlocks = availableBlocks;
            if ((availableBlocks * this.blockSize) / 1048576 < 50) {
                ToastUtils.showLong(R.string.sd_card_size_show);
                return;
            }
            this.isTakeVideo = true;
            SystemValue.checkSDStatu = 1;
            if (this.isH264Data) {
                LogUtils.d("biniy", "h264");
                this.takeVideoThread = new TakeVideoThread(1, this.strDID, 15, this.nVideoWidth, this.nVideoHeight);
                new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.NDNCameraLiveActivity.10
                    @Override // android.os.AsyncTask
                    public void onPreExecute() {
                        super.onPreExecute();
                        NDNCameraLiveActivity.this.takeVideoThread.start();
                    }

                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        try {
                            Thread.sleep(AutoFocusCallback.AUTOFOCUS_INTERVAL_MS);
                            return null;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(Void r2) {
                        super.onPostExecute((AnonymousClass10) r2);
                        if (NDNCameraLiveActivity.this.takeVideoThread != null) {
                            NDNCameraLiveActivity.this.saveVideoHead(NDNCameraLiveActivity.this.takeVideoThread.GetAviName());
                        }
                    }
                }.execute(new Void[0]);
            } else {
                LogUtils.d("biniy", "!h264");
                this.mMp4WriteData = new Mp4WriteData(this.nVideoWidth, this.nVideoHeight, 90000, 1, 1, MyAudioPlayer.KEY_SAMPLE_RATE, 1, MyAudioPlayer.KEY_SAMPLE_RATE);
                String fileNameWithTime = CommonUtil.getFileNameWithTime(1);
                File file = new File(FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + this.strDID);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (NativeImplement.MP4WRITEOpen(FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + this.strDID + "/" + fileNameWithTime, this.mMp4WriteData) != 0.0d) {
                    this.isMp4Opened = true;
                }
                saveVideoHead(fileNameWithTime);
            }
            if (this.mIsHasIdrCmd == 1) {
                NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getIFrame(this.strUser, this.strPwd));
                return;
            }
            NativeCallerTools.SDKAPICloseLiveStream(this.strDID);
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            NativeCallerTools.SDKAPIOpenLiveStream(this.strDID, this.clickRs == 2 ? 2 : 1);
        }
    }
}
