package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.zxing.camera.AutoFocusCallback;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.VideoModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ThreadUtils;
import com.shix.shixipc.utils.AacEncode;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.ByteUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyAudioPlayer;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.TakeVideoThread;
import com.xyx.mp4.Mp4VideoData;
import com.xyx.mp4.Mp4WriteData;
import com.xyx.mp4.NativeImplement;
import g.a.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class PlayBackActivity extends BaseActivity implements NUIMainActivity.PlayBackInterface {
    public static final int AUDIO_BUFFER_START_CODE = -1474975147;
    public static final String tag = "PlayBackActivity1";
    public LinearLayout btn_play;
    public ImageView btn_play_img;
    public ImageView im_audio_l;
    public ImageView im_more_l;
    public ImageView im_pic_l;
    public ImageView im_talk_l;
    public ImageView im_video_l;
    public boolean isMp4Opened;
    public LinearLayout layoutConnPrompt;
    public AacEncode mAacEncode;
    public Bitmap mBmp;
    public ImageView mImFullL;
    public LinearLayout mLlFullL;
    public Mp4VideoData mMp4VideoData;
    public Mp4WriteData mMp4WriteData;
    public TextView mTvFullL;
    public GLSurfaceView myGlSurfaceView;
    public a myRender;
    public ImageView playImg;
    public SeekBar playSeekBar;
    public String strDID;
    public String strFilePath;
    public TextView textTimeStamp;
    public long time;
    public long time1;
    public TextView tv_audio_l;
    public TextView tv_more_l;
    public TextView tv_pic_l;
    public TextView tv_talk_l;
    public TextView tv_video_l;
    public int isSupportMP4 = 0;
    public byte[] videodata = null;
    public int videoDataLen = 0;
    public int nVideoWidth = 0;
    public int nVideoHeight = 0;
    public boolean isPlaySeekBar = true;
    public int i1 = 0;
    public int i2 = 0;
    public boolean exit = false;
    public String tzStr = "GMT+08:00";
    public String timeShow = LogUtils.PLACEHOLDER;
    public CustomBuffer AudioBuffer = null;
    public AudioPlayer audioPlayer = null;
    public int PlayMode = 0;
    public boolean isPlayOrPause = false;
    public TakeVideoThread takeVideoThread = null;
    public boolean isTakepic = false;
    public boolean isPictSave = false;
    public boolean isTakeVideo = false;
    public boolean isAudio = false;
    public byte[] mBytes1 = new byte[0];
    public byte[] mBytes2 = new byte[0];
    public int oldCount = -1;
    public boolean isNeedShow = true;
    public int size1 = 0;
    public boolean isFirstShow = false;
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.PlayBackActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmap;
            PlayBackActivity.this.layoutConnPrompt.setVisibility(8);
            int i2 = message.what;
            if (i2 == 1) {
                if (!PlayBackActivity.this.isFirstShow) {
                    PlayBackActivity.this.isFirstShow = true;
                    PlayBackActivity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                }
                PlayBackActivity.this.playSeekBar.setProgress(PlayBackActivity.this.size1);
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                if (playBackActivity.size1 == 100) {
                    if (playBackActivity.isTakeVideo) {
                        PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.playback_take_video);
                        PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                        PlayBackActivity.this.isTakeVideo = false;
                        PlayBackActivity.this.takeVideoThread.stopThread();
                    }
                    PlayBackActivity.this.finish();
                }
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                PlayBackActivity.this.myRender.a(PlayBackActivity.this.videodata, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                PlayBackActivity.this.playImg.setVisibility(8);
                return;
            }
            if (i2 != 2) {
                return;
            }
            PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
            Bitmap bitmap2 = null;
            try {
                bitmap = BitmapFactory.decodeByteArray(PlayBackActivity.this.videodata, 0, PlayBackActivity.this.videoDataLen);
            } catch (Exception unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return;
            }
            int width = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getWidth();
            int height = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getHeight();
            int i3 = (width * 3) / 4;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, i3);
            layoutParams.gravity = 17;
            PlayBackActivity.this.playImg.setLayoutParams(layoutParams);
            if (PlayBackActivity.this.getResources().getConfiguration().orientation == 1) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, width, i3, true);
            } else if (PlayBackActivity.this.getResources().getConfiguration().orientation == 2) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, width, height, true);
            }
            PlayBackActivity.this.playImg.setVisibility(0);
            PlayBackActivity.this.playImg.setImageBitmap(bitmap2);
        }
    };
    public String strVideoName = "";
    public MyAudioPlayer mMyAudioPlayer = new MyAudioPlayer();

    private void StartAudio() {
        synchronized (this) {
            this.AudioBuffer.ClearAll();
            this.audioPlayer.AudioPlayStart();
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.audioPlayer.AudioPlayStop();
            this.AudioBuffer.ClearAll();
        }
    }

    private void findView() {
        this.playImg = (ImageView) findViewById(R.id.playback_img);
        this.layoutConnPrompt = (LinearLayout) findViewById(R.id.layout_connect_prompt);
        this.playSeekBar = (SeekBar) findViewById(R.id.playback_seekbar);
        this.textTimeStamp = (TextView) findViewById(R.id.textTimeStamp);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) findViewById(R.id.myhsurfaceview);
        this.myGlSurfaceView = gLSurfaceView;
        a aVar = new a(gLSurfaceView);
        this.myRender = aVar;
        this.myGlSurfaceView.setRenderer(aVar);
        this.im_video_l = (ImageView) findViewById(R.id.im_video_l);
        this.im_pic_l = (ImageView) findViewById(R.id.im_pic_l);
        this.im_audio_l = (ImageView) findViewById(R.id.im_audio_l);
        this.mLlFullL = (LinearLayout) findViewById(R.id.ll_full_l);
        this.mImFullL = (ImageView) findViewById(R.id.im_full_l);
        this.mTvFullL = (TextView) findViewById(R.id.tv_full_l);
        this.tv_video_l = (TextView) findViewById(R.id.tv_video_l);
        this.tv_pic_l = (TextView) findViewById(R.id.tv_pic_l);
        this.tv_audio_l = (TextView) findViewById(R.id.tv_audio_l);
        findViewById(R.id.alerm_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10L);
                }
                if (PlayBackActivity.this.isTakeVideo) {
                    PlayBackActivity.this.showToast(R.string.ptz_takevideo_show);
                } else {
                    PlayBackActivity.this.finish();
                }
            }
        });
        this.btn_play = (LinearLayout) findViewById(R.id.btn_play);
        this.btn_play_img = (ImageView) findViewById(R.id.btn_play_img);
        this.btn_play.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10L);
                }
                if (PlayBackActivity.this.isPlayOrPause) {
                    PlayBackActivity.this.btn_play_img.setImageResource(R.mipmap.playback_pause);
                    NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.rePlayRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath));
                } else {
                    PlayBackActivity.this.btn_play_img.setImageResource(R.mipmap.playback_play);
                    NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.pauseRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath));
                }
                PlayBackActivity.this.isPlayOrPause = !r4.isPlayOrPause;
            }
        });
        findViewById(R.id.ll_pic_l).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10L);
                }
                PlayBackActivity.this.isTakepic = true;
            }
        });
        findViewById(R.id.ll_audio_l).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10L);
                }
                if (PlayBackActivity.this.isAudio) {
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.playback_voice);
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                    NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 0));
                } else {
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                    NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 1));
                }
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                playBackActivity.isAudio = true ^ playBackActivity.isAudio;
            }
        });
        findViewById(R.id.ll_full_l).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayBackActivity.this.toggleFullscreen();
            }
        });
        findViewById(R.id.ll_video_l).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10L);
                }
                if (PlayBackActivity.this.isTakeVideo) {
                    if (PlayBackActivity.this.isAudio) {
                        PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                        PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                        NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 0));
                    }
                    PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.playback_take_video);
                    PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                    PlayBackActivity.this.isTakeVideo = false;
                    if (PlayBackActivity.this.isSupportMP4 == 0) {
                        PlayBackActivity.this.takeVideoThread.stopThread();
                        return;
                    }
                    PlayBackActivity.this.mBytes1 = new byte[0];
                    PlayBackActivity.this.mBytes2 = new byte[0];
                    PlayBackActivity.this.isMp4Opened = false;
                    NativeImplement.MP4WRITEClose(1L);
                    return;
                }
                if (!PlayBackActivity.this.isAudio) {
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                    NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 1));
                }
                PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                PlayBackActivity.this.isTakeVideo = true;
                SystemValue.checkSDStatu = 1;
                if (PlayBackActivity.this.isSupportMP4 == 0) {
                    PlayBackActivity.this.takeVideoThread = new TakeVideoThread(1, PlayBackActivity.this.strDID, 15, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                    new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.PlayBackActivity.8.1
                        @Override // android.os.AsyncTask
                        public void onPreExecute() {
                            super.onPreExecute();
                            PlayBackActivity.this.takeVideoThread.start();
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
                            super.onPostExecute((AnonymousClass1) r2);
                            if (PlayBackActivity.this.takeVideoThread != null) {
                                PlayBackActivity.this.saveVideoHead(PlayBackActivity.this.takeVideoThread.GetAviName());
                            }
                        }
                    }.execute(new Void[0]);
                    return;
                }
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                playBackActivity.mMp4WriteData = new Mp4WriteData(playBackActivity.nVideoWidth, PlayBackActivity.this.nVideoHeight, 90000, 1, 1, MyAudioPlayer.KEY_SAMPLE_RATE, 1, MyAudioPlayer.KEY_SAMPLE_RATE);
                String fileNameWithTime = CommonUtil.getFileNameWithTime(1);
                File file = new File(FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES);
                if (!file.exists()) {
                    file.mkdirs();
                }
                PlayBackActivity.this.isMp4Opened = false;
                if (NativeImplement.MP4WRITEOpen(FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + fileNameWithTime, PlayBackActivity.this.mMp4WriteData) != 0) {
                    PlayBackActivity.this.isMp4Opened = true;
                }
                PlayBackActivity.this.saveVideoHead(fileNameWithTime);
            }
        });
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(FragmentCameraList.STR_DID);
        this.strFilePath = intent.getStringExtra("filepath");
        this.isSupportMP4 = intent.getIntExtra("mp4", 0);
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[Catch: all -> 0x009c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:15:0x0043, B:17:0x0045, B:19:0x008a, B:25:0x004a, B:37:0x008f, B:41:0x0093, B:39:0x009b, B:44:0x0098, B:29:0x007e, B:32:0x0082), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r7.getStrDate()     // Catch: java.lang.Throwable -> L9c
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch: java.lang.Throwable -> L9c
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch: java.lang.Throwable -> L9c
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.io.File r4 = com.shix.shixipc.utils.FileUtil.getRootDir()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r5 = "HDWiFiCam/Snapshot/ALLFile"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r4 != 0) goto L24
            r3.mkdirs()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
        L24:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r4.<init>(r3, r1)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            r3 = 100
            boolean r0 = r8.compress(r0, r3, r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            if (r0 == 0) goto L43
            r1.flush()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            com.shix.shixipc.activity.PlayBackActivity$11 r0 = new com.shix.shixipc.activity.PlayBackActivity$11     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            r0.<init>()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            r7.runOnUiThread(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
        L43:
            r7.isPictSave = r2     // Catch: java.lang.Throwable -> L9c
            r1.close()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L9c
            goto L88
        L49:
            r0 = move-exception
        L4a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L9c
            goto L88
        L4e:
            r8 = move-exception
            r0 = r1
            goto L8f
        L51:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L59
        L56:
            r8 = move-exception
            goto L8f
        L58:
            r1 = move-exception
        L59:
            com.shix.shixipc.activity.PlayBackActivity$12 r3 = new com.shix.shixipc.activity.PlayBackActivity$12     // Catch: java.lang.Throwable -> L56
            r3.<init>()     // Catch: java.lang.Throwable -> L56
            r7.runOnUiThread(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r4.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = r1.getMessage()     // Catch: java.lang.Throwable -> L56
            r4.append(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L56
            com.shix.shixipc.utils.MyLogUtils.d(r3, r4)     // Catch: java.lang.Throwable -> L56
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L56
            r7.isPictSave = r2     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.io.IOException -> L86 java.lang.Throwable -> L9c
            goto L88
        L86:
            r0 = move-exception
            goto L4a
        L88:
            if (r8 == 0) goto L8d
            r8.recycle()     // Catch: java.lang.Throwable -> L9c
        L8d:
            monitor-exit(r7)
            return
        L8f:
            r7.isPictSave = r2     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L9b
            r0.close()     // Catch: java.io.IOException -> L97 java.lang.Throwable -> L9c
            goto L9b
        L97:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L9c
        L9b:
            throw r8     // Catch: java.lang.Throwable -> L9c
        L9c:
            r8 = move-exception
            monitor-exit(r7)
            goto La0
        L9f:
            throw r8
        La0:
            goto L9f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.PlayBackActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveVideoHead(String str) {
        if (this.videodata == null || str == null || str.length() <= 5) {
            return;
        }
        this.strVideoName = "IMG_" + str.replace("mp4", "jpg");
        new Thread() { // from class: com.shix.shixipc.activity.PlayBackActivity.9
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                byte[] bArr = new byte[PlayBackActivity.this.nVideoWidth * PlayBackActivity.this.nVideoHeight * 2];
                NativeCallerTools.SDKAPIYuv420ToRgb565(PlayBackActivity.this.videodata, bArr, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                playBackActivity.mBmp = Bitmap.createBitmap(playBackActivity.nVideoWidth, PlayBackActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                PlayBackActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                if (PlayBackActivity.this.mBmp != null) {
                    File file = new File(FileUtil.getRootDir(), "HDWiFiCam/videohead/ALLFile");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, PlayBackActivity.this.strVideoName));
                        if (PlayBackActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
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

    private String setDeviceTime(long j, String str) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        String valueOf4;
        String valueOf5;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(str));
        calendar.setTimeInMillis(j);
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        int i7 = calendar.get(13);
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        if (i4 < 10) {
            valueOf2 = "0" + i4;
        } else {
            valueOf2 = String.valueOf(i4);
        }
        if (i5 < 10) {
            valueOf3 = "0" + i5;
        } else {
            valueOf3 = String.valueOf(i5);
        }
        if (i6 < 10) {
            valueOf4 = "0" + i6;
        } else {
            valueOf4 = String.valueOf(i6);
        }
        if (i7 < 10) {
            valueOf5 = "0" + i7;
        } else {
            valueOf5 = String.valueOf(i7);
        }
        return i2 + "-" + valueOf + "-" + valueOf2 + "   " + valueOf3 + ":" + valueOf4 + ":" + valueOf5;
    }

    private void setListener() {
        this.playSeekBar.setMax(100);
        this.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.PlayBackActivity.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MyLogUtils.d("playbackActivity", "onStartTrackingTouch=" + seekBar.getProgress());
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                final int progress = seekBar.getProgress();
                PlayBackActivity.this.playSeekBar.setProgress(progress);
                MyLogUtils.d("playbackActivity", "onStopTrackingTouch=" + progress);
                NativeCallerTools.SDKAPITransferMessage(PlayBackActivity.this.strDID, CommonUtil.offsetRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, progress));
                new Thread() { // from class: com.shix.shixipc.activity.PlayBackActivity.2.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(AutoFocusCallback.AUTOFOCUS_INTERVAL_MS);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        NativeCallerTools.SDKAPIOpenPlayBack(DeviceUtil.INSTANCE.getSdkId(PlayBackActivity.this.strDID), PlayBackActivity.this.strFilePath, progress);
                    }
                }.start();
            }
        });
    }

    private void setTimeZone(int i2) {
        switch (i2) {
            case -43200:
                this.tzStr = "GMT+12:00";
                break;
            case -39600:
                this.tzStr = "GMT+11:00";
                break;
            case -36000:
                this.tzStr = "GMT+10:00";
                break;
            case -34200:
                this.tzStr = "GMT+09:30";
                break;
            case -32400:
                this.tzStr = "GMT+09:00";
                break;
            case -28800:
                this.tzStr = "GMT+08:00";
                break;
            case -25200:
                this.tzStr = "GMT+07:00";
                break;
            case -21600:
                this.tzStr = "GMT+06:00";
                break;
            case -19800:
                this.tzStr = "GMT+05:30";
                break;
            case -18000:
                this.tzStr = "GMT+05:00";
                break;
            case -16200:
                this.tzStr = "GMT+04:30";
                break;
            case -14400:
                this.tzStr = "GMT+04:00";
                break;
            case -12600:
                this.tzStr = "GMT+03:30";
                break;
            case -10800:
                this.tzStr = "GMT+03:00";
                break;
            case -7200:
                this.tzStr = "GMT+02:00";
                break;
            case -3600:
                this.tzStr = "GMT+01:00";
                break;
            case 0:
                this.tzStr = "GMT";
                break;
            case 3600:
                this.tzStr = "GMT-01:00";
                break;
            case 7200:
                this.tzStr = "GMT-02:00";
                break;
            case 10800:
                this.tzStr = "GMT-03:00";
                break;
            case 12600:
                this.tzStr = "GMT-03:30";
                break;
            case 14400:
                this.tzStr = "GMT-04:00";
                break;
            case 18000:
                this.tzStr = "GMT-05:00";
                break;
            case 21600:
                this.tzStr = "GMT-06:00";
                break;
            case 25200:
                this.tzStr = "GMT-07:00";
                break;
            case 28800:
                this.tzStr = "GMT-08:00";
                break;
            case 32400:
                this.tzStr = "GMT-09:00";
                break;
            case 36000:
                this.tzStr = "GMT-10:00";
                break;
            case 39600:
                this.tzStr = "GMT-11:00";
                break;
        }
    }

    private void takePicture(final Bitmap bitmap) {
        if (this.isPictSave) {
            return;
        }
        this.isPictSave = true;
        new Thread() { // from class: com.shix.shixipc.activity.PlayBackActivity.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                PlayBackActivity.this.savePicToSDcard(bitmap);
            }
        }.start();
    }

    public static int toInt(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 += (bArr[i3] & ThreadUtils.TYPE_SINGLE) << (i3 * 8);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void toggleFullscreen() {
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0129 A[Catch: IOException -> 0x0125, all -> 0x0143, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0015, B:9:0x0048, B:11:0x0053, B:16:0x005b, B:18:0x0061, B:19:0x008d, B:45:0x0105, B:37:0x010d, B:41:0x0111, B:70:0x0131, B:63:0x0139, B:68:0x0140, B:67:0x013d, B:58:0x0121, B:53:0x0129, B:86:0x0078, B:87:0x002b), top: B:3:0x0003, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139 A[Catch: IOException -> 0x0135, all -> 0x0143, TRY_LEAVE, TryCatch #7 {IOException -> 0x0135, blocks: (B:70:0x0131, B:63:0x0139), top: B:69:0x0131, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void writeFileToSDCard(java.util.List<byte[]> r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.PlayBackActivity.writeFileToSDCard(java.util.List, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
    public void callBackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
    public void callBackPlayBackPicData(int i2, byte[] bArr, int i3, VideoModel videoModel) {
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
    public void callBackPlayBackVideoData(int i2, byte[] bArr, int i3, VideoModel videoModel) {
        TakeVideoThread takeVideoThread;
        int i4 = videoModel.getStartcode() == -1474975147 ? 0 : videoModel.getStartcode() == -1474975148 ? 1 : -1;
        if (videoModel.getFrameno() == this.oldCount + 1) {
            this.isNeedShow = true;
            this.oldCount = videoModel.getFrameno();
        } else {
            this.isNeedShow = false;
            if (i4 == 0) {
                this.oldCount = videoModel.getFrameno();
                this.isNeedShow = true;
            }
        }
        if (this.isTakeVideo) {
            if (this.isSupportMP4 == 0 && (takeVideoThread = this.takeVideoThread) != null) {
                takeVideoThread.addVideo(bArr, i4, this.nVideoWidth, this.nVideoHeight);
                return;
            }
            if (!this.isMp4Opened || videoModel == null || videoModel.getFramerate() == 0) {
                return;
            }
            Mp4VideoData mp4VideoData = new Mp4VideoData(i4, videoModel.getFramerate());
            this.mMp4VideoData = mp4VideoData;
            NativeImplement.MP4WRITEAddVideo(1, bArr, bArr.length, mp4VideoData);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
    public void callBackPlaybackAudioData(byte[] bArr, int i2, byte[] bArr2) {
        TakeVideoThread takeVideoThread;
        if (this.audioPlayer.isAudioPlaying()) {
            if (this.isSupportMP4 == 1) {
                this.mMyAudioPlayer.decode(bArr, 0, i2);
                if (this.isTakeVideo && this.isMp4Opened) {
                    byte[] byteArr = ByteUtil.getByteArr(bArr, 0, i2);
                    NativeImplement.MP4WRITEAddAudio(1, byteArr, byteArr.length);
                    return;
                }
                return;
            }
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferData.data = ByteUtil.getByteArr(bArr, 0, i2);
            this.AudioBuffer.addData(customBufferData);
            if (!this.isTakeVideo || (takeVideoThread = this.takeVideoThread) == null) {
                return;
            }
            takeVideoThread.addAudio(ByteUtil.getByteArr(bArr, 0, i2));
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
    public void callBackPlaybackDecVideoData(byte[] bArr, int i2, int i3, byte[] bArr2) {
        MyLogUtils.d(tag, "解码数据 callBackPlaybackDecVideoData  len:" + bArr.length + " width:" + i2 + " height:" + i3);
        this.videodata = bArr;
        this.nVideoWidth = i2;
        this.nVideoHeight = i3;
        this.myRender.a(bArr, i2, i3);
        VideoModel videoModel = (VideoModel) new Gson().fromJson(ByteUtil.getString(bArr2, "utf-8"), VideoModel.class);
        this.i1 = this.i1 + 1;
        if (!this.exit) {
            this.exit = true;
        }
        if (videoModel.getAllframe() > 0) {
            this.size1 = (videoModel.getFrameno() * 100) / videoModel.getAllframe();
        }
        this.time = videoModel.getTimestamp();
        this.videoDataLen = videoModel.getLen();
        long j = this.time * 1000;
        this.time1 = j;
        this.timeShow = setDeviceTime(j, this.tzStr);
        char c2 = 65535;
        if (videoModel.getStartcode() == -1474975147) {
            c2 = 0;
        } else if (videoModel.getStartcode() == -1474975148) {
            c2 = 1;
        }
        if (c2 != 1 && c2 != 0) {
            MyLogUtils.d(tag, "mHandler.sendEmptyMessage(2)");
            this.mHandler.sendEmptyMessage(2);
        } else if (this.isNeedShow) {
            MyLogUtils.d(tag, "mHandler.sendEmptyMessage(1)");
            this.mHandler.sendEmptyMessage(1);
        }
        if (this.isTakepic) {
            this.isTakepic = false;
            byte[] bArr3 = new byte[i2 * i3 * 2];
            if (NativeCallerTools.SDKAPIYuv420ToRgb565(bArr, bArr3, i2, i3) >= 0) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                this.mBmp = createBitmap;
                createBitmap.copyPixelsFromBuffer(wrap);
                takePicture(this.mBmp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (getResources().getDisplayMetrics().widthPixels * 0.5625f));
            layoutParams.gravity = 17;
            this.myGlSurfaceView.setLayoutParams(layoutParams);
            this.mTvFullL.setText(getString(R.string.n_play_full));
            this.mImFullL.setImageResource(R.mipmap.playback_to_small);
            return;
        }
        if (getResources().getConfiguration().orientation == 2) {
            this.myGlSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTvFullL.setText(getString(R.string.n_play_sport));
            this.mImFullL.setImageResource(R.mipmap.playback_to_small);
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.playback);
        findView();
        setListener();
        NUIMainActivity.setPlayBackInterface(this);
        NativeCallerTools.SDKAPIOpenPlayBack(DeviceUtil.INSTANCE.getSdkId(this.strDID), this.strFilePath, 0);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.playRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.strFilePath));
        CustomBuffer customBuffer = new CustomBuffer();
        this.AudioBuffer = customBuffer;
        this.audioPlayer = new AudioPlayer(customBuffer);
        this.mAacEncode = new AacEncode();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        StopAudio();
        a aVar = this.myRender;
        if (aVar != null) {
            aVar.b();
        }
        this.mAacEncode.close();
        this.exit = false;
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.stopRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPIClosePlayBack(DeviceUtil.INSTANCE.getSdkId(this.strDID));
        MyLogUtils.d("tag", "PlayBackActivity  onDestroy()");
        MyAudioPlayer myAudioPlayer = this.mMyAudioPlayer;
        if (myAudioPlayer != null) {
            myAudioPlayer.stop();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            return false;
        }
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.mAacEncode.start();
        this.mMyAudioPlayer.start();
        StartAudio();
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.isPlaySeekBar) {
                this.isPlaySeekBar = false;
                findViewById(R.id.ll_butoom).setVisibility(8);
            } else {
                this.isPlaySeekBar = true;
                findViewById(R.id.ll_butoom).setVisibility(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void printHexString(String str, byte[] bArr) {
        System.out.print(str);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            System.out.print(hexString.toUpperCase() + LogUtils.PLACEHOLDER);
        }
        System.out.println("");
    }
}
