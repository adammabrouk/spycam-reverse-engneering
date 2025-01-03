package com.shix.shixipc.utils;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class MyAudioPlayer {
    public static final int KEY_CHANNEL_COUNT = 1;
    public static final int KEY_SAMPLE_RATE = 8000;
    public static final String TAG = "AACDecoderUtil";
    public int count = 0;
    public MediaCodec mDecoder;
    public byte[] mPcm;
    public MyAudioTrack mPlayer;

    public void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void decode(byte[] bArr, int i2, int i3) {
        this.mPcm = null;
        Log.d(TAG, "第一步" + i3);
        ByteBuffer[] inputBuffers = this.mDecoder.getInputBuffers();
        ByteBuffer[] outputBuffers = this.mDecoder.getOutputBuffers();
        try {
            Log.d(TAG, "第二步");
            int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(5000L);
            Log.d(TAG, "第三步" + this.count + "--" + dequeueInputBuffer + this.mDecoder.toString());
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr, i2, i3);
                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, i3, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, 5000L);
            if (dequeueOutputBuffer < 0) {
                this.count++;
                Log.d(TAG, "第四步，解码失败" + this.count + "--" + dequeueOutputBuffer);
            }
            while (dequeueOutputBuffer >= 0) {
                Log.d(TAG, "第五步。解码成功");
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                int i4 = bufferInfo.size;
                byte[] bArr2 = new byte[i4];
                byteBuffer2.get(bArr2);
                byteBuffer2.clear();
                setPcm(bArr2, bufferInfo.size);
                this.mPlayer.playAudioTrack(bArr2, 0, bufferInfo.size);
                Log.d(TAG, "第六步，打印解码后的数据长度" + i4 + "--" + bufferInfo.size);
                this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, 5000L);
            }
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
            e2.printStackTrace();
        }
    }

    public int getCount() {
        return this.count;
    }

    public byte[] getPcm() {
        return this.mPcm;
    }

    public boolean prepare() {
        MyAudioTrack myAudioTrack = new MyAudioTrack(KEY_SAMPLE_RATE, 4, 2);
        this.mPlayer = myAudioTrack;
        myAudioTrack.init();
        try {
            this.mDecoder = MediaCodec.createDecoderByType(AacPcmCoder.AUDIO_MIME);
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", AacPcmCoder.AUDIO_MIME);
            mediaFormat.setInteger("channel-count", 1);
            mediaFormat.setInteger("sample-rate", KEY_SAMPLE_RATE);
            mediaFormat.setInteger("bitrate", 0);
            mediaFormat.setInteger("is-adts", 0);
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{21, -120}));
            this.mDecoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            MediaCodec mediaCodec = this.mDecoder;
            if (mediaCodec == null) {
                return false;
            }
            mediaCodec.start();
            return true;
        } catch (IOException e2) {
            Log.e(TAG, e2.toString());
            e2.printStackTrace();
            return false;
        }
    }

    public byte[] readFile(File file) {
        byte[] bArr;
        Closeable closeable = null;
        byte[] bArr2 = null;
        closeable = null;
        try {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    bArr2 = new byte[(int) randomAccessFile.length()];
                    randomAccessFile.readFully(bArr2);
                    closeQuietly(randomAccessFile);
                    return bArr2;
                } catch (Exception e2) {
                    e = e2;
                    bArr = bArr2;
                    closeable = randomAccessFile;
                    e.printStackTrace();
                    closeQuietly(closeable);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    closeable = randomAccessFile;
                    closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
        }
    }

    public void setPcm(byte[] bArr, int i2) {
        if (this.mPcm == null) {
            this.mPcm = new byte[6144];
            this.mPcm = bArr;
        } else {
            byte[] bArr2 = new byte[6144];
            this.mPcm = bArr2;
            System.arraycopy(bArr, 0, bArr2, bArr.length, bArr.length);
        }
    }

    public void start() {
        prepare();
    }

    public void stop() {
        try {
            if (this.mPlayer != null) {
                this.mPlayer.release();
                this.mPlayer = null;
            }
            if (this.mDecoder != null) {
                this.mDecoder.stop();
                this.mDecoder.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(TAG, e2.toString());
        }
    }
}
