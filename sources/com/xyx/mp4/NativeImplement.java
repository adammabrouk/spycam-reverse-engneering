package com.xyx.mp4;

/* loaded from: classes.dex */
public class NativeImplement {
    static {
        System.loadLibrary("mp4");
    }

    public static native void MP4WRITEAddAudio(int i2, byte[] bArr, int i3);

    public static native void MP4WRITEAddVideo(int i2, byte[] bArr, int i3, Mp4VideoData mp4VideoData);

    public static native void MP4WRITEClose(long j);

    public static native long MP4WRITEOpen(String str, Mp4WriteData mp4WriteData);
}
