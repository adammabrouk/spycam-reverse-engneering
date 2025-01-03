package object.p2pipcam.nativecaller;

/* loaded from: classes.dex */
public class NativeCaller {
    public static native int CloseAvi(String str);

    public static native int OpenAviFileName(String str, String str2, String str3, int i2, int i3, int i4, int i5);

    public static native void SDKAPICleanUp();

    public static native void SDKAPICloseDevice(int i2);

    public static native void SDKAPICloseLiveStream(int i2);

    public static native void SDKAPIClosePlayBack(int i2);

    public static native void SDKAPICloseTalk(int i2);

    public static native int SDKAPIDecodeH264Frame(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int[] iArr, int i5);

    public static native int SDKAPIDecodeVdata(int i2, int i3, byte[] bArr, int i4, byte[] bArr2, int i5, int[] iArr);

    public static native int SDKAPIInit(String str);

    public static native int SDKAPIOpenDevice(String str, String str2, String str3, int i2);

    public static native int SDKAPIOpenDeviceSendCmd(String str, String str2, String str3, String str4);

    public static native int SDKAPIOpenLiveStream(int i2, int i3);

    public static native int SDKAPIOpenPlayBack(int i2, String str, int i3);

    public static native int SDKAPIOpenTalk(int i2);

    public static native void SDKAPISendTalkData(int i2, byte[] bArr, int i3);

    public static native void SDKAPISetCallbackContext(Object obj);

    public static native int SDKAPIStartSearchLanDev(String str);

    public static native void SDKAPIStopSearchLanDev();

    public static native int SDKAPITransferBinary(int i2, int i3, int i4, byte[] bArr, int i5);

    public static native int SDKAPITransferMessage(int i2, int i3, int i4, String str);

    public static native int SDKAPIYuv420ToRgb565(byte[] bArr, byte[] bArr2, int i2, int i3);

    public static native int WriteAudioData(String str, byte[] bArr, int i2);

    public static native int WriteData(String str, byte[] bArr, int i2, int i3);
}
