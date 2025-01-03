package com.shix.shixipc.utils;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class AacEncode {
    public MediaCodec.BufferInfo bufferInfo;
    public File file;
    public MediaCodec mediaCodec;
    public String mediaType = "OMX.google.aac.encoder";
    public ByteBuffer[] inputBuffers = null;
    public ByteBuffer[] outputBuffers = null;
    public FileOutputStream encFi = null;
    public long presentationTimeUs = 0;
    public ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private void addADTStoPacket(byte[] bArr, int i2) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 80;
        bArr[3] = (byte) (RecyclerView.c0.FLAG_IGNORE + (i2 >> 11));
        bArr[4] = (byte) ((i2 & 2047) >> 3);
        bArr[5] = (byte) (((i2 & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private long computePresentationTime(long j) {
        return ((j * 90000) * 1024) / 44100;
    }

    public void close() {
        try {
            this.mediaCodec.stop();
            this.mediaCodec.release();
            this.outputStream.flush();
            this.outputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public byte[] encode(byte[] bArr, int i2, int i3) throws Exception {
        Log.d("AudioEncoder", "  input.length=" + bArr.length);
        int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = this.inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr);
            byteBuffer.limit(bArr.length);
            this.mediaCodec.queueInputBuffer(dequeueInputBuffer, i2, i3, computePresentationTime(this.presentationTimeUs), 0);
            this.presentationTimeUs++;
        }
        int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        while (dequeueOutputBuffer >= 0) {
            MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
            int i4 = bufferInfo.size;
            int i5 = i4 + 0;
            ByteBuffer byteBuffer2 = this.outputBuffers[dequeueOutputBuffer];
            byteBuffer2.position(bufferInfo.offset);
            byteBuffer2.limit(this.bufferInfo.offset + i4);
            byte[] bArr2 = new byte[i5];
            byteBuffer2.get(bArr2, 0, i4);
            byteBuffer2.position(this.bufferInfo.offset);
            this.outputStream.write(bArr2);
            Log.d("AudioEncoder", i5 + " bytes written");
            this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
            dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        }
        byte[] byteArray = this.outputStream.toByteArray();
        Log.d("AudioEncoder", "  out.length=" + byteArray.length + "  encFi=" + this.encFi);
        this.outputStream.flush();
        this.outputStream.reset();
        return byteArray;
    }

    public void setOutputPath(String str) {
    }

    public void start() {
        try {
            this.mediaCodec = MediaCodec.createEncoderByType(AacPcmCoder.AUDIO_MIME);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(AacPcmCoder.AUDIO_MIME, new int[]{MyAudioPlayer.KEY_SAMPLE_RATE, 11025, 22050, 44100, 48000}[0], 1);
        createAudioFormat.setString("mime", AacPcmCoder.AUDIO_MIME);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", new int[]{64000, 96000, 128000}[2]);
        createAudioFormat.setInteger("max-input-size", 10240);
        this.mediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mediaCodec.start();
        this.inputBuffers = this.mediaCodec.getInputBuffers();
        this.outputBuffers = this.mediaCodec.getOutputBuffers();
        this.bufferInfo = new MediaCodec.BufferInfo();
    }
}
