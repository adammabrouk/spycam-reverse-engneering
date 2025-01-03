package com.shix.shixipc.utils;

import android.media.AudioTrack;
import android.util.Log;

/* loaded from: classes.dex */
public class MyAudioTrack {
    public AudioTrack mAudioTrack;
    public int mChannel;
    public int mFrequency;
    public int mSampBit;

    public MyAudioTrack(int i2, int i3, int i4) {
        this.mFrequency = i2;
        this.mChannel = i3;
        this.mSampBit = i4;
    }

    public int getMinBufferSize() {
        return AudioTrack.getMinBufferSize(this.mFrequency, this.mChannel, this.mSampBit);
    }

    public void init() {
        if (this.mAudioTrack != null) {
            release();
        }
        int minBufferSize = getMinBufferSize();
        this.mAudioTrack = new AudioTrack(3, this.mFrequency, this.mChannel, this.mSampBit, minBufferSize, 1);
        Log.e("MyAudioTrack", "minBufSize : " + minBufferSize + "--mAudioTrack--" + toString());
        this.mAudioTrack.play();
    }

    public void playAudioTrack(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            this.mAudioTrack.write(bArr, i2, i3);
        } catch (Exception e2) {
            Log.e("MyAudioTrack", "AudioTrack Exception : " + e2.toString());
        }
    }

    public void release() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.stop();
            this.mAudioTrack.release();
        }
    }

    public String toString() {
        return "MyAudioTrack{mFrequency=" + this.mFrequency + ", mChannel=" + this.mChannel + ", mSampBit=" + this.mSampBit + ", mAudioTrack=" + this.mAudioTrack + '}';
    }
}
