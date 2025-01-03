package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.VideoModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DownloadActivity extends BaseActivity {
    public Button back;
    public String file;
    public SeekBar mSeekBar;
    public String selectName;
    public String strDID;
    public TextView tv_FileName;
    public TextView tv_speed;
    public List<byte[]> mBytes = new ArrayList();
    public float mSeekBarSize = 0.0f;
    public float mSeekBarSizeOld = 0.0f;
    public float mSeekBarSizeNew = 0.0f;
    public DecimalFormat mDecimalFormat = new DecimalFormat("0.0");
    public boolean isFistRun = true;
    public int fileSize = 0;
    public int h264Size = 0;
    public int framSize = 0;
    public int oldFramno = 0;
    public boolean isFistCom = true;
    public Handler downHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.DownloadActivity.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                NativeCallerTools.SDKAPIClosePlayBack(DeviceUtil.INSTANCE.getSdkId(DownloadActivity.this.strDID));
                PlayBackActivity.writeFileToSDCard(DownloadActivity.this.mBytes, DownloadActivity.this.file, DownloadActivity.this.selectName, false, false);
                DownloadActivity downloadActivity = DownloadActivity.this;
                downloadActivity.saveVideoHead(downloadActivity.selectName);
                if (DownloadActivity.this.selectName.endsWith(".png") || DownloadActivity.this.selectName.endsWith(".jpg")) {
                    String str = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + DownloadActivity.this.selectName;
                    DownloadActivity downloadActivity2 = DownloadActivity.this;
                    if (downloadActivity2.isRepeat(downloadActivity2.selectName)) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(str);
                        Intent intent = new Intent(DownloadActivity.this, (Class<?>) PhotoViewActivity.class);
                        intent.putStringArrayListExtra("pic_file", arrayList);
                        intent.putExtra("pic_index", 0);
                        DownloadActivity.this.startActivity(intent);
                    }
                }
                DownloadActivity downloadActivity3 = DownloadActivity.this;
                Toast.makeText(downloadActivity3, downloadActivity3.getResources().getString(R.string.done), 0).show();
                DownloadActivity.this.finish();
                DownloadActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            } else if (i2 == 1) {
                DownloadActivity.this.mSeekBar.setProgress(Math.round(DownloadActivity.this.mSeekBarSize));
                DownloadActivity.this.tv_speed.setText(DownloadActivity.this.mDecimalFormat.format(DownloadActivity.this.mSeekBarSize) + " %");
            } else if (i2 == 2) {
                DownloadActivity.this.showToast(R.string.tip_wlbwd);
                DownloadActivity.this.startActivity(new Intent(DownloadActivity.this, (Class<?>) NUIMainActivity.class));
                DownloadActivity.this.finish();
            } else if (i2 == 3) {
                NativeCallerTools.SDKAPITransferMessage(DownloadActivity.this.strDID, CommonUtil.getDownloadFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, DownloadActivity.this.selectName, 0, 0));
                DownloadActivity.this.oldFramno = 0;
                NativeCallerTools.SDKAPIClosePlayBack(DeviceUtil.INSTANCE.getSdkId(DownloadActivity.this.strDID));
                NativeCallerTools.SDKAPIOpenPlayBack(DeviceUtil.INSTANCE.getSdkId(DownloadActivity.this.strDID), DownloadActivity.this.selectName, 0);
                NativeCallerTools.SDKAPITransferMessage(DownloadActivity.this.strDID, CommonUtil.getDownloadFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, DownloadActivity.this.selectName, DownloadActivity.this.h264Size, 1));
            }
            return false;
        }
    });
    public String strVideoName = "";

    private boolean fileIsExists(String str) {
        try {
            File file = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("filePath=");
            sb.append(file);
            MyLogUtils.e("获取文件地址", sb.toString());
            return file.exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getFileSize(String str) {
        File file = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + str);
        StringBuilder sb = new StringBuilder();
        sb.append("fileString=");
        sb.append(file);
        MyLogUtils.e("获取文件地址", sb.toString());
        long j = 0;
        if (file.exists()) {
            try {
                j = new FileInputStream(file).available();
                MyLogUtils.e("获取文件大小", "size" + j);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            MyLogUtils.e("获取文件大小", "文件不存在!");
        }
        return Long.valueOf(j).intValue();
    }

    private void initView() {
        this.file = "HDWiFiCam/video/ALLFile";
        this.tv_FileName = (TextView) findViewById(R.id.down_filename);
        this.mSeekBar = (SeekBar) findViewById(R.id.down_seekbar);
        this.back = (Button) findViewById(R.id.back);
        this.tv_speed = (TextView) findViewById(R.id.down_speed);
        this.mSeekBar.setMax(100);
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(FragmentCameraList.STR_DID);
        String stringExtra = intent.getStringExtra("filepath");
        this.selectName = stringExtra;
        this.tv_FileName.setText(stringExtra);
        this.fileSize = getFileSize(this.selectName);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.DownloadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NativeCallerTools.SDKAPIClosePlayBack(DeviceUtil.INSTANCE.getSdkId(DownloadActivity.this.strDID));
                DownloadActivity.this.finish();
                DownloadActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRepeat(String str) {
        String[] list = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/").list();
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveVideoHead(String str) {
        if (str == null || str.length() <= 5) {
            return;
        }
        this.strVideoName = "IMG_" + str.replace("mp4", "jpg");
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.n_dev_item_df_default);
        File file = new File(FileUtil.getRootDir(), "HDWiFiCam/videohead/ALLFile");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.strVideoName);
        LogUtils.e("biniy", "cccc- path =  " + file2.getAbsolutePath());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            decodeResource.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download);
        initView();
        this.mBytes.clear();
        NUIMainActivity.setPlayBackInterface(new NUIMainActivity.PlayBackInterface() { // from class: com.shix.shixipc.activity.DownloadActivity.1
            @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
            public void callBackH264Data(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
            public void callBackPlayBackPicData(int i2, byte[] bArr, int i3, VideoModel videoModel) {
                if (videoModel.getFrameno() != DownloadActivity.this.oldFramno + 1) {
                    if (DownloadActivity.this.isFistCom) {
                        DownloadActivity.this.isFistCom = false;
                        DownloadActivity.this.downHandler.sendEmptyMessage(3);
                        return;
                    }
                    return;
                }
                DownloadActivity downloadActivity = DownloadActivity.this;
                downloadActivity.h264Size = bArr.length + downloadActivity.h264Size;
                DownloadActivity.this.oldFramno = videoModel.getFrameno();
                DownloadActivity.this.mBytes.add(bArr);
                if (videoModel.getAllframe() != 0 && DownloadActivity.this.h264Size != 0) {
                    DownloadActivity.this.mSeekBarSize = (r4.h264Size * 100.0f) / videoModel.getAllframe();
                }
                if (DownloadActivity.this.h264Size >= videoModel.getAllframe()) {
                    DownloadActivity.this.downHandler.sendEmptyMessage(0);
                } else {
                    DownloadActivity.this.downHandler.sendEmptyMessage(1);
                }
                DownloadActivity.this.framSize = videoModel.getFrameno();
                DownloadActivity.this.isFistCom = true;
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
            public void callBackPlayBackVideoData(int i2, byte[] bArr, int i3, VideoModel videoModel) {
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
            public void callBackPlaybackAudioData(byte[] bArr, int i2, byte[] bArr2) {
            }

            @Override // com.shix.shixipc.activity.NUIMainActivity.PlayBackInterface
            public void callBackPlaybackDecVideoData(byte[] bArr, int i2, int i3, byte[] bArr2) {
            }
        });
        NativeCallerTools.SDKAPIOpenPlayBack(DeviceUtil.INSTANCE.getSdkId(this.strDID), this.selectName, 0);
        if (fileIsExists(this.selectName)) {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getDownloadFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, this.selectName, this.fileSize, 1));
        } else {
            NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getDownloadFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, this.selectName, 0, 1));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NUIMainActivity.setPlayBackInterface(null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            return false;
        }
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
