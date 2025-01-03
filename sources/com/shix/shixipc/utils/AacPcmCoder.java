package com.shix.shixipc.utils;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;

/* loaded from: classes.dex */
public class AacPcmCoder {
    public static final long AUDIO_BYTES_PER_SAMPLE = 88200;
    public static final String AUDIO_MIME = "audio/mp4a-latm";
    public static final String TAG = "AacPcmCoder";

    public static void addADTStoPacket(byte[] bArr, int i2) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 80;
        bArr[3] = (byte) (64 + (i2 >> 11));
        bArr[4] = (byte) ((i2 & 2047) >> 3);
        bArr[5] = (byte) (((i2 & 7) << 5) + 31);
        bArr[6] = -4;
    }

    public static MediaCodec createAudioEncoder() throws IOException {
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(AUDIO_MIME);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", AUDIO_MIME);
        mediaFormat.setInteger("bitrate", 64000);
        mediaFormat.setInteger("channel-count", 1);
        mediaFormat.setInteger("sample-rate", 44100);
        mediaFormat.setInteger("aac-profile", 2);
        createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        return createEncoderByType;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8 A[Catch: all -> 0x0130, TryCatch #0 {all -> 0x0130, blocks: (B:57:0x00a0, B:21:0x00c2, B:23:0x00c8, B:25:0x00ce, B:28:0x00d7, B:30:0x00db, B:31:0x00f4, B:33:0x00fd, B:38:0x0107, B:42:0x0114, B:58:0x00a8), top: B:56:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void decodeAacToPcm(java.io.File r20, java.io.File r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.AacPcmCoder.decodeAacToPcm(java.io.File, java.io.File):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:7:0x0017, B:11:0x0041, B:13:0x0047, B:15:0x0053, B:16:0x0055, B:20:0x0064, B:21:0x00a7, B:23:0x00ad, B:42:0x00b3, B:25:0x00c1, B:27:0x00c5, B:29:0x00da, B:30:0x0107, B:39:0x00fd, B:46:0x011e, B:49:0x0126, B:50:0x007e), top: B:6:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void encodePcmToAac(java.io.File r27, java.io.File r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.AacPcmCoder.encodePcmToAac(java.io.File, java.io.File):void");
    }
}
