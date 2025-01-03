package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.bi.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ProtocolUtil {
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String TAG = "ProtocolUtil";

    public static void fillIntData(byte[] bArr, int i2, int i3) {
        System.arraycopy(int2ByteArray(i2), 0, bArr, i3, 4);
    }

    public static void fillStringData(byte[] bArr, String str, int i2) {
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i2, bytes.length);
    }

    public static byte[] fixedStringToBytes(String str, int i2) {
        if (str == null || "".equals(str)) {
            return new byte[]{0, 0, 0, 0};
        }
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        if (bArr == null) {
            return new byte[]{0, 0, 0, 0};
        }
        byte[] defaultByte = getDefaultByte(i2);
        if (bArr.length <= i2) {
            i2 = bArr.length;
        }
        System.arraycopy(bArr, 0, defaultByte, 0, i2);
        return defaultByte;
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytes] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getBytesConsumed(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytesConsumed] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getDefaultByte(int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[0] = 0;
        }
        return bArr;
    }

    public static String getString(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer, JResponse jResponse) {
        int i2 = ByteBufferUtils.getShort(byteBuffer, jResponse);
        if (i2 < 0) {
            d.c(TAG, "[getTlv2] - ByteBuffer error.");
            return null;
        }
        byte[] bArr = new byte[i2];
        ByteBufferUtils.get(byteBuffer, bArr, jResponse);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] int2ByteArray(int i2) {
        return new byte[]{(byte) (i2 >>> 24), (byte) (i2 >>> 16), (byte) (i2 >>> 8), (byte) i2};
    }

    public static byte[] long2ByteArray(long j) {
        return new byte[]{(byte) (j >>> 56), (byte) (j >>> 48), (byte) (j >>> 40), (byte) (j >>> 32), (byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) j};
    }

    public static byte[] short2ByteArray(short s) {
        return new byte[]{(byte) (s >>> 8), (byte) s};
    }

    public static byte[] tlv2ToByteArray(String str) {
        if (str != null && !"".equals(str)) {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            if (bArr != null) {
                short length = (short) bArr.length;
                byte[] bArr2 = new byte[length + 2];
                System.arraycopy(short2ByteArray(length), 0, bArr2, 0, 2);
                System.arraycopy(bArr, 0, bArr2, 2, length);
                return bArr2;
            }
        }
        return new byte[]{0, 0};
    }
}
