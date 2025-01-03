package com.shix.shixipc.utils;

import android.annotation.SuppressLint;
import com.shix.shixipc.system.ContentCommon;
import java.io.File;
import object.p2pipcam.nativecaller.NativeCaller;

@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class TakeVideoThread extends Thread {
    public AudioBuffer audioBuffer;
    public byte[] audioByte;
    public long availableBlocks;
    public long blockSize;
    public int frame;
    public int height;
    public IorPBuffer iorPBuffer;
    public boolean isStart;
    public boolean isone;
    public String name;
    public int sleepTime;
    public String strDID;
    public String szDid;
    public int tag;
    public long totalBlocks;
    public VideoBuffer videoBuffer;
    public byte[] videoByte;
    public int width;
    public int video_i = 0;
    public int widthRun = 0;
    public int heightRun = 0;
    public int thisIoP = 0;

    public TakeVideoThread(int i2, String str, int i3, int i4, int i5) {
        this.tag = 0;
        this.videoBuffer = null;
        this.audioBuffer = null;
        this.iorPBuffer = null;
        this.strDID = "";
        this.isStart = false;
        this.frame = 5;
        this.width = 0;
        this.height = 0;
        this.szDid = "";
        this.sleepTime = 0;
        this.isone = false;
        MyLogUtils.e("testTakeVideoThread", "video tag:" + i2 + "  did:" + str + "  frame:" + i3 + "  width:" + i4 + "  height:" + i5);
        this.szDid = str;
        this.tag = i2;
        this.frame = 15;
        if (i3 == 0) {
            this.frame = 15;
        }
        this.sleepTime = 1000 / this.frame;
        this.width = i4;
        this.height = i5;
        this.videoBuffer = new VideoBuffer();
        this.audioBuffer = new AudioBuffer();
        if (i2 != 0) {
            this.iorPBuffer = new IorPBuffer();
        }
        this.strDID = str;
        this.isStart = true;
        this.isone = true;
    }

    public String GetAviName() {
        return this.name;
    }

    public boolean addAudio(byte[] bArr) {
        return this.audioBuffer.addAudioData(bArr);
    }

    public boolean addVideo(byte[] bArr, int i2, int i3, int i4) {
        MyLogUtils.e("testTakeVideoThread", "video data width:" + i3 + "  heigh:" + i4);
        this.width = i3;
        this.height = i4;
        if (this.tag == 0) {
            return this.videoBuffer.addData(bArr);
        }
        if (!this.videoBuffer.addData(bArr) || !this.iorPBuffer.addData(i2)) {
            this.videoBuffer.ClearAll();
            this.iorPBuffer.ClearAll();
            return false;
        }
        if (this.videoBuffer.size() == this.iorPBuffer.size()) {
            return true;
        }
        this.videoBuffer.ClearAll();
        this.iorPBuffer.ClearAll();
        return false;
    }

    public void clearAll() {
        if (this.tag == 0) {
            this.videoBuffer.ClearAll();
            this.audioBuffer.ClearAudioAll();
        } else {
            this.videoBuffer.ClearAll();
            this.iorPBuffer.ClearAll();
            this.audioBuffer.ClearAudioAll();
        }
    }

    public boolean isRun() {
        return this.isStart;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.isStart) {
            MyLogUtils.e("testTakeVideoThread", "video start:" + this.isStart);
            this.video_i = this.video_i + 1;
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.video_i == 1) {
                this.name = CommonUtil.getFileNameWithTime(1);
                if (this.tag > 0) {
                    File file = new File(FileUtil.getRootDir(), "HDWiFiCam/video/" + this.szDid);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    NativeCaller.OpenAviFileName(this.szDid, FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + this.szDid + "/" + this.name, "h264", this.height, this.width, this.frame, MyAudioPlayer.KEY_SAMPLE_RATE);
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                } else {
                    File file2 = new File(FileUtil.getRootDir(), "HDWiFiCam/video/" + this.szDid);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    NativeCaller.OpenAviFileName(this.szDid, FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + this.szDid + "/" + this.name, "mjpg", this.height, this.width, this.frame, MyAudioPlayer.KEY_SAMPLE_RATE);
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                }
            }
            if (this.video_i > 1) {
                int i2 = this.widthRun;
                int i3 = this.width;
                this.audioByte = this.audioBuffer.RemoveAudioData();
                this.videoByte = this.videoBuffer.RemoveData();
                MyLogUtils.e("testTakeVideoThread", "video start write1");
                if (this.tag != 0) {
                    this.thisIoP = this.iorPBuffer.RemoveData();
                    if (this.videoByte == null) {
                        this.videoByte = new byte[0];
                    }
                    String str = this.szDid;
                    byte[] bArr = this.videoByte;
                    NativeCaller.WriteData(str, bArr, bArr.length, this.thisIoP);
                    MyLogUtils.e("testTakeVideoThread", "kkkkkWriteVideoData width:" + this.width + "  heigh:" + this.height);
                    if (this.audioByte == null) {
                        this.audioByte = new byte[0];
                    }
                    String str2 = this.szDid;
                    byte[] bArr2 = this.audioByte;
                    NativeCaller.WriteAudioData(str2, bArr2, bArr2.length);
                    MyLogUtils.i("testTakeVideoThread", "kkkkkWriteAudioData1");
                } else {
                    if (this.videoByte == null) {
                        this.videoByte = new byte[0];
                    }
                    String str3 = this.szDid;
                    byte[] bArr3 = this.videoByte;
                    NativeCaller.WriteData(str3, bArr3, bArr3.length, 1);
                }
                byte[] RemoveAudioData = this.audioBuffer.RemoveAudioData();
                this.audioByte = RemoveAudioData;
                if (RemoveAudioData != null) {
                    NativeCaller.WriteAudioData(this.szDid, RemoveAudioData, RemoveAudioData.length);
                    MyLogUtils.i("testTakeVideoThread", "kkkkkWriteAudioData2");
                }
            }
        }
        super.run();
    }

    public void stopThread() {
        this.isStart = false;
        this.video_i = 0;
        NativeCaller.CloseAvi(this.szDid);
        clearAll();
    }
}
