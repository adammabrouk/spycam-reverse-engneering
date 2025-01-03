package com.google.zxing.activity;

import a.h.b.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.common.StringUtils;
import com.google.zxing.decoding.CaptureActivityHandler;
import com.google.zxing.decoding.InactivityTimer;
import com.google.zxing.decoding.RGBLuminanceSource;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.view.ViewfinderView;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes.dex */
public class CaptureActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    public static final float BEEP_VOLUME = 0.1f;
    public static final int REQUEST_CODE_SCAN_GALLERY = 100;
    public static final int RP_CAMERA = 2;
    public static final int RP_SD = 3;
    public static final long VIBRATE_DURATION = 200;
    public ImageButton back;
    public Button btnAlbum;
    public ImageButton btnFlash;
    public String characterSet;
    public Vector<BarcodeFormat> decodeFormats;
    public CaptureActivityHandler handler;
    public boolean hasSurface;
    public InactivityTimer inactivityTimer;
    public ProgressDialog mProgress;
    public MediaPlayer mediaPlayer;
    public String photo_path;
    public boolean playBeep;
    public Bitmap scanBitmap;
    public boolean vibrate;
    public ViewfinderView viewfinderView;
    public boolean isFlashOn = false;
    public int type = 0;
    public View.OnClickListener albumOnClick = new View.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CaptureActivity.this.toCheckPermissionSD()) {
                SystemValue.isExitBackGoudExit = false;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                CaptureActivity.this.startActivityForResult(intent, 100);
            }
        }
    };
    public final MediaPlayer.OnCompletionListener beepListener = new MediaPlayer.OnCompletionListener() { // from class: com.google.zxing.activity.CaptureActivity.4
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };
    public View.OnClickListener flashListener = new View.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (!CameraManager.get().setFlashLight(!CaptureActivity.this.isFlashOn)) {
                    Toast.makeText(CaptureActivity.this, R.string.scan_er_3, 0).show();
                } else if (CaptureActivity.this.isFlashOn) {
                    CaptureActivity.this.btnFlash.setImageResource(R.mipmap.flash_off);
                    CaptureActivity.this.isFlashOn = false;
                } else {
                    CaptureActivity.this.btnFlash.setImageResource(R.mipmap.flash_on);
                    CaptureActivity.this.isFlashOn = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    private void handleAlbumPic(Intent intent) {
        final Uri data = intent.getData();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.mProgress = progressDialog;
        progressDialog.setMessage(getResources().getString(R.string.scan_er_1));
        this.mProgress.setCancelable(false);
        this.mProgress.show();
        runOnUiThread(new Runnable() { // from class: com.google.zxing.activity.CaptureActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Result scanningImage = CaptureActivity.this.scanningImage(data);
                CaptureActivity.this.mProgress.dismiss();
                if (scanningImage == null) {
                    Toast.makeText(CaptureActivity.this, R.string.scan_er_2, 0).show();
                    return;
                }
                if (CaptureActivity.this.type != 1) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("qr_scan_result", scanningImage.getText());
                    intent2.putExtras(bundle);
                    CaptureActivity.this.setResult(-1, intent2);
                    CaptureActivity.this.finish();
                    return;
                }
                Intent intent3 = new Intent(CaptureActivity.this, (Class<?>) AddCameraActivity.class);
                intent3.putExtra(ContentCommon.CAMERA_OPTION, 1);
                intent3.putExtra(ContentCommon.STR_CAMERA_NAME, "Camera");
                intent3.putExtra(ContentCommon.STR_CAMERA_ID, scanningImage.getText());
                intent3.putExtra(ContentCommon.STR_CAMERA_USER, ContentCommon.DEFAULT_USER_NAME);
                intent3.putExtra(ContentCommon.STR_CAMERA_PWD, "6666");
                intent3.putExtra("pushTypeInt", 110);
                CaptureActivity.this.startActivity(intent3);
                CaptureActivity.this.finish();
            }
        });
    }

    private void initBeepSound() {
        if (this.playBeep && this.mediaPlayer == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.mediaPlayer.setVolume(0.1f, 0.1f);
                this.mediaPlayer.prepare();
            } catch (IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
            if (this.handler == null) {
                this.handler = new CaptureActivityHandler(this, this.decodeFormats, this.characterSet);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }

    private void playBeepSoundAndVibrate() {
        MediaPlayer mediaPlayer;
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            ((Vibrator) getSystemService("vibrator")).vibrate(200L);
        }
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.camera_permissions_title)).setMessage(getResources().getString(R.string.camera_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                CaptureActivity.this.finish();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    CaptureActivity.this.toCheckPermission();
                }
            });
        }
        negativeButton.create().show();
    }

    private void showDialogSD(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.sd_card_permissions_title)).setMessage(getResources().getString(R.string.sd_card_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    CaptureActivity.this.toCheckPermissionSD();
                }
            });
        }
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermission() {
        if (a.a(this, Permission.CAMERA) == 0) {
            return true;
        }
        a.h.a.a.a(this, new String[]{Permission.CAMERA}, 2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toCheckPermissionSD() {
        if (a.a(this, Permission.READ_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        a.h.a.a.a(this, new String[]{Permission.READ_EXTERNAL_STORAGE}, 3);
        return false;
    }

    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    public Handler getHandler() {
        return this.handler;
    }

    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public void handleDecode(Result result, Bitmap bitmap) {
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, R.string.scan_er_2, 0).show();
        } else if (this.type == 1) {
            Intent intent = new Intent(this, (Class<?>) AddCameraActivity.class);
            intent.putExtra(ContentCommon.CAMERA_OPTION, 1);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, "Camera");
            intent.putExtra(ContentCommon.STR_CAMERA_ID, text);
            intent.putExtra(ContentCommon.STR_CAMERA_USER, ContentCommon.DEFAULT_USER_NAME);
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, "6666");
            intent.putExtra("pushTypeInt", 110);
            startActivity(intent);
            finish();
        } else {
            Intent intent2 = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("qr_scan_result", text);
            System.out.println("sssssssssssssssss scan 0 = " + text);
            intent2.putExtras(bundle);
            setResult(-1, intent2);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 100) {
            handleAlbumPic(intent);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scanner);
        this.type = getIntent().getIntExtra(ContentCommon.TYPE, 0);
        CameraManager.init(getApplication());
        this.viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_content);
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_back);
        this.back = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.zxing.activity.CaptureActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaptureActivity.this.finish();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.btn_flash);
        this.btnFlash = imageButton2;
        imageButton2.setOnClickListener(this.flashListener);
        Button button = (Button) findViewById(R.id.btn_album);
        this.btnAlbum = button;
        button.setOnClickListener(this.albumOnClick);
        this.hasSurface = false;
        this.inactivityTimer = new InactivityTimer(this);
        toCheckPermission();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.inactivityTimer.shutdown();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        CameraManager.get().closeDriver();
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
            if (a.h.a.a.a((Activity) this, Permission.CAMERA)) {
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
        if (iArr[0] == 0) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            startActivityForResult(intent, 100);
        } else if (iArr[0] != 0) {
            if (a.h.a.a.a((Activity) this, Permission.READ_EXTERNAL_STORAGE)) {
                showDialogSD(true);
            } else {
                showDialogSD(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.scanner_view)).getHolder();
        if (this.hasSurface) {
            initCamera(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.decodeFormats = null;
        this.characterSet = null;
        this.playBeep = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        this.vibrate = true;
    }

    public Result scanningImage(Uri uri) {
        if (uri == null) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, StringUtils.UTF8);
        Bitmap a2 = c.b.a.a.a.a(this, uri, 500, 500);
        this.scanBitmap = a2;
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(a2))), hashtable);
        } catch (ChecksumException e2) {
            e2.printStackTrace();
            return null;
        } catch (FormatException e3) {
            e3.printStackTrace();
            return null;
        } catch (NotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
        initCamera(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
    }
}
