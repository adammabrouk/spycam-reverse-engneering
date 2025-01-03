package com.shix.shixipc.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.google.zxing.camera.AutoFocusCallback;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.VideoPlayActivity;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.FileUtils;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import com.shix.shixipc.utils.TimeUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class VideoPlayActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = VideoPlayActivity.class.getSimpleName();
    public ImageButton ibVideoMore;
    public MediaPlayer mMediaPlayer;
    public String mPath;
    public ImageView mStartAndStop;
    public SurfaceHolder mSurfaceHolder;
    public ImageView mVideoPlayBack;
    public ImageView mVideoPlayBack2;
    public ImageView mVideoPlayFull;
    public LinearLayout mVideoPlayProbar;
    public SeekBar mVideoPlaySeek;
    public SurfaceView mVideoPlaySurfaceview;
    public TextView mVideoPlayTime;
    public TextView mVideoPlayTimeNow;
    public volatile MyThread myThread;
    public PopupWindow popupMoreView;
    public RelativeLayout rlRootVideoView;
    public boolean isInitFinish = false;
    public String fileName = "";
    public String videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/";
    public String videoHeadPath = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/";
    public boolean isBack = false;
    public String previewPicName = "";
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.VideoPlayActivity.4
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1 && (VideoPlayActivity.this.mMediaPlayer == null || !VideoPlayActivity.this.mMediaPlayer.isPlaying())) {
                    VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
                    videoPlayActivity.openLocalFile(videoPlayActivity.mPath);
                    VideoPlayActivity.this.finish();
                }
            } else if (VideoPlayActivity.this.mMediaPlayer == null || !VideoPlayActivity.this.mMediaPlayer.isPlaying()) {
                VideoPlayActivity.this.mStartAndStop.setImageResource(R.mipmap.item41);
            } else {
                VideoPlayActivity.this.mVideoPlayProbar.setVisibility(8);
                VideoPlayActivity.this.mVideoPlayTimeNow.setText(TimeUtil.formatTimeS2(VideoPlayActivity.this.mMediaPlayer.getCurrentPosition()));
                VideoPlayActivity.this.mHandler.sendEmptyMessageDelayed(0, 33L);
            }
            return false;
        }
    });

    public class MyThread extends Thread {
        public MyThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (VideoPlayActivity.this.mVideoPlaySeek.getProgress() < VideoPlayActivity.this.mVideoPlaySeek.getMax()) {
                if (VideoPlayActivity.this.mMediaPlayer != null && !VideoPlayActivity.this.isBack) {
                    VideoPlayActivity.this.mVideoPlaySeek.setProgress(VideoPlayActivity.this.mMediaPlayer.getCurrentPosition());
                    try {
                        Thread.sleep(33L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void stopMyThread() {
            MyThread myThread = VideoPlayActivity.this.myThread;
            VideoPlayActivity.this.myThread = null;
            if (myThread != null) {
                myThread.interrupt();
            }
        }
    }

    private void delVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer = null;
            }
        }
        String str = this.videoHeadPath + this.previewPicName;
        if (FileUtil.delFile(str)) {
            String replace = str.replace("IMG_", "").replace("videohead", "video").replace("jpg", "mp4");
            if (!FileUtil.fileIsExists(replace)) {
                replace = replace.replace("mp4", "avi");
            }
            if (FileUtil.delFile(replace)) {
                resultFinish();
            }
        }
    }

    private void destroy() {
        this.isBack = true;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer = null;
            }
        }
    }

    private void initMediaPalyer() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
    }

    private void initSurfaceviewStateListener() {
        SurfaceHolder holder = this.mVideoPlaySurfaceview.getHolder();
        this.mSurfaceHolder = holder;
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.shix.shixipc.activity.VideoPlayActivity.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                MyLogUtils.d("tag", " surfaceChanged ");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoPlayActivity.this.mMediaPlayer.setDisplay(surfaceHolder);
                if (!VideoPlayActivity.this.mPath.isEmpty()) {
                    VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
                    videoPlayActivity.setPlayVideo(videoPlayActivity.mPath);
                }
                MyLogUtils.d("tag", " surfaceCreated ");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                MyLogUtils.d("tag", " surfaceDestroyed ");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLocalFile(String str) {
        Uri uriForFile;
        String replace = str.replace("IMG_", "").replace("videohead", "video").replace("jpg", "mp4");
        if (!FileUtil.fileIsExists(replace)) {
            replace = replace.replace("mp4", "avi");
        }
        String str2 = "file://" + replace;
        Intent intent = new Intent("android.intent.action.VIEW");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23) {
            uriForFile = Uri.parse(str2);
        } else if (i2 >= 29) {
            uriForFile = PlayBackTFActivity.getUriFromFile(replace, this);
        } else {
            intent.setFlags(1);
            uriForFile = FileProvider.getUriForFile(this, "com.shix.lookcam.provider", new File(replace));
        }
        if (replace.contains(".jpg")) {
            intent.setDataAndType(uriForFile, "image/jpeg");
        } else if (replace.contains(".wav")) {
            intent.setDataAndType(uriForFile, "audio/x-wav");
        } else if (replace.contains(".mp4")) {
            intent.setDataAndType(uriForFile, "video/mp4");
        } else if (replace.contains(".png")) {
            intent.setDataAndType(uriForFile, "image/png");
        } else {
            intent.setDataAndType(uriForFile, "*/*");
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.pause();
        this.mStartAndStop.setImageResource(R.mipmap.item41);
    }

    private void resultFinish() {
        setResult(-1, getIntent());
        finish();
    }

    private void saveVideo2Album(Context context, File file) {
        File file2 = new File(FileUtil.getRootDir() + "/HDFile");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, file.getName());
        if (FileUtils.copy(file, file3)) {
            FileUtil.saveVideoToSystemAlbum(file3.getAbsolutePath(), context);
            ToastUtils.showLong(getString(R.string.saved_successfully));
        }
    }

    private void seekTo(int i2) {
        this.mMediaPlayer.seekTo(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayVideo(String str) {
        MyLogUtils.d("tag", " setPlayVideo path=" + str);
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.setVideoScalingMode(1);
            this.mMediaPlayer.setLooping(false);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.shix.shixipc.activity.VideoPlayActivity.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    VideoPlayActivity.this.isInitFinish = true;
                    VideoPlayActivity.this.startPlay();
                }
            });
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void shared() {
        Uri uriForFile;
        Intent intent = new Intent("android.intent.action.SEND");
        String str = "file://" + this.videoFile + this.fileName;
        if (Build.VERSION.SDK_INT <= 23) {
            uriForFile = Uri.parse(str);
        } else {
            intent.setFlags(1);
            uriForFile = FileProvider.getUriForFile(this, "com.shix.lookcam.provider", new File(this.videoFile + this.fileName));
        }
        intent.setType("video/mp4");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
    }

    private void sharedxx() throws FileNotFoundException {
        Intent intent = new Intent();
        intent.addFlags(3);
        intent.setAction("android.intent.action.SEND");
        int i2 = getApplicationInfo().targetSdkVersion;
        File file = new File(this.videoFile + this.fileName);
        LogUtils.d("biniy", "shared- file = " + file.getAbsolutePath());
        if (i2 < 24 || Build.VERSION.SDK_INT < 24) {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(file.getPath())));
            intent.setType("video/*");
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("_data", file.getAbsolutePath());
        Uri insert = getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        grantUriPermission(ShareSystemFileUtils.PACKAGE_WECHAT, insert, 1);
        intent.addFlags(3);
        intent.addFlags(268435456);
        intent.setType("video/mp4");
        intent.putExtra("android.intent.extra.STREAM", insert);
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
    }

    private void showPopupMoreView() {
        PopupWindow popupWindow = this.popupMoreView;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.rlRootVideoView, 80, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            this.mMediaPlayer.start();
        }
        this.mStartAndStop.setImageResource(R.mipmap.camera_live_start1);
        if (this.mVideoPlaySeek.getProgress() >= this.mVideoPlaySeek.getMax()) {
            this.mVideoPlaySeek.setProgress(0);
            this.mMediaPlayer.seekTo(0);
        }
        this.mVideoPlayTime.setText(TimeUtil.formatTimeS2(this.mMediaPlayer.getDuration()));
        this.mVideoPlaySeek.setMax(this.mMediaPlayer.getDuration());
        if (this.myThread != null) {
            this.myThread.stopMyThread();
        }
        this.myThread = new MyThread();
        this.myThread.start();
        this.mHandler.sendEmptyMessage(0);
    }

    private void stopPlay() {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void toggleFullscreen() {
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(1);
        }
    }

    public /* synthetic */ void a(View view) {
        this.popupMoreView.dismiss();
        delVideo();
    }

    public /* synthetic */ void b(View view) {
        this.popupMoreView.dismiss();
        shared();
    }

    public /* synthetic */ void c(View view) {
        this.popupMoreView.dismiss();
        saveVideo2Album(this, new File(this.videoFile, this.fileName));
    }

    public /* synthetic */ void d(View view) {
        this.popupMoreView.dismiss();
    }

    public void initPopupMore() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_popup_more, (ViewGroup) null);
        inflate.findViewById(R.id.tvMoreDel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.a(view);
            }
        });
        inflate.findViewById(R.id.tvMoreShared).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.b(view);
            }
        });
        inflate.findViewById(R.id.tvMoreSave).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.c(view);
            }
        });
        inflate.findViewById(R.id.tvMoreCancel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayActivity.this.d(view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.popupMoreView = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupMoreView.setFocusable(true);
        this.popupMoreView.setInputMethodMode(1);
        this.popupMoreView.setSoftInputMode(16);
        this.popupMoreView.setOutsideTouchable(true);
        this.popupMoreView.setBackgroundDrawable(new ColorDrawable(0));
        inflate.setFocusableInTouchMode(true);
        inflate.setOnKeyListener(new View.OnKeyListener() { // from class: c.h.a.a.x0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return VideoPlayActivity.this.a(view, i2, keyEvent);
            }
        });
        this.popupMoreView.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: c.h.a.a.d1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                VideoPlayActivity.this.a();
            }
        });
        this.popupMoreView.setTouchInterceptor(new View.OnTouchListener() { // from class: c.h.a.a.b1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return VideoPlayActivity.this.a(view, motionEvent);
            }
        });
    }

    public void initView() {
        Intent intent = getIntent();
        this.previewPicName = intent.getStringExtra("FileName");
        String stringExtra = intent.getStringExtra("DEV_DID");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + stringExtra + "/";
            this.videoHeadPath = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + stringExtra + "/";
        }
        this.fileName = this.previewPicName.replace("IMG_", "").replace(".jpg", ".mp4");
        SpUtil.INSTANCE.encode("isFileRefresh", (Object) false);
        this.mVideoPlaySurfaceview = (SurfaceView) findViewById(R.id.video_play_surfaceview);
        ImageView imageView = (ImageView) findViewById(R.id.start_and_stop);
        this.mStartAndStop = imageView;
        imageView.setOnClickListener(this);
        this.mVideoPlaySeek = (SeekBar) findViewById(R.id.video_play_seek);
        this.mVideoPlayTime = (TextView) findViewById(R.id.video_play_time);
        ImageView imageView2 = (ImageView) findViewById(R.id.video_play_back);
        this.mVideoPlayBack = imageView2;
        imageView2.setOnClickListener(this);
        this.mVideoPlayTimeNow = (TextView) findViewById(R.id.video_play_time_now);
        ImageView imageView3 = (ImageView) findViewById(R.id.video_play_full);
        this.mVideoPlayFull = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.video_play_back2);
        this.mVideoPlayBack2 = imageView4;
        imageView4.setOnClickListener(this);
        this.mVideoPlayProbar = (LinearLayout) findViewById(R.id.video_play_probar);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibVideoMore);
        this.ibVideoMore = imageButton;
        imageButton.setOnClickListener(this);
        this.rlRootVideoView = (RelativeLayout) findViewById(R.id.rlRootVideoView);
        initMediaPalyer();
        initSurfaceviewStateListener();
        this.mVideoPlaySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.shix.shixipc.activity.VideoPlayActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoPlayActivity.this.pausePlay();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (VideoPlayActivity.this.mMediaPlayer != null) {
                    VideoPlayActivity.this.mMediaPlayer.seekTo(seekBar.getProgress());
                    VideoPlayActivity.this.startPlay();
                }
            }
        });
        this.mPath = new File(this.videoFile, this.fileName).getAbsolutePath();
        this.mHandler.sendEmptyMessageDelayed(1, AutoFocusCallback.AUTOFOCUS_INTERVAL_MS);
        initPopupMore();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ibVideoMore) {
            showPopupMoreView();
            return;
        }
        if (id != R.id.start_and_stop) {
            switch (id) {
                case R.id.video_play_back /* 2131231646 */:
                case R.id.video_play_back2 /* 2131231647 */:
                    resultFinish();
                    break;
                case R.id.video_play_full /* 2131231648 */:
                    toggleFullscreen();
                    break;
            }
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            startPlay();
        } else {
            pausePlay();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            BarUtils.setStatusBarVisibility((Activity) this, true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (getResources().getDisplayMetrics().widthPixels * 0.5625f));
            layoutParams.gravity = 17;
            this.mVideoPlaySurfaceview.setLayoutParams(layoutParams);
            this.mVideoPlayBack2.setVisibility(8);
            return;
        }
        if (getResources().getConfiguration().orientation == 2) {
            BarUtils.setStatusBarVisibility((Activity) this, false);
            this.mVideoPlaySurfaceview.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mVideoPlayBack2.setVisibility(0);
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_play);
        BarUtils.setStatusBarVisibility((Activity) this, true);
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        initView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            return false;
        }
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        resultFinish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    public /* synthetic */ boolean a(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return false;
        }
        this.popupMoreView.dismiss();
        return false;
    }

    public /* synthetic */ void a() {
        this.popupMoreView.dismiss();
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        this.popupMoreView.dismiss();
        return false;
    }
}
