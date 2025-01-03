package com.shix.shixipc.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class ByteUtil {
    public static ByteBuffer buffer = ByteBuffer.allocate(8);
    public static final byte[] hex = "0123456789ABCDEF".getBytes();

    public static int ByteArrayToInt(byte[] bArr) {
        if (bArr.length != 4) {
            return -1;
        }
        return ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 0) | ((bArr[3] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[1] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static String ByteToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length && bArr[i2] != 0; i2++) {
            sb.append((char) bArr[i2]);
        }
        return sb.toString();
    }

    public static String Bytes2HexString(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            byte[] bArr3 = hex;
            bArr2[i3] = bArr3[(bArr[i2] >> 4) & 15];
            bArr2[i3 + 1] = bArr3[bArr[i2] & 15];
        }
        return new String(bArr2);
    }

    public static byte[] addBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String binary(byte[] bArr, int i2) {
        return new BigInteger(1, bArr).toString(i2);
    }

    public static char byte2Char(byte[] bArr) {
        return (char) ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static String byte2Hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static String byte2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            sb.append(LogUtils.PLACEHOLDER);
        }
        return sb.toString().toUpperCase().trim();
    }

    public static final String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toUpperCase();
    }

    public static int byte2int(byte[] bArr, int i2) {
        int i3;
        int i4;
        if (i2 == 1) {
            return bArr[0];
        }
        if (i2 == 2) {
            i3 = bArr[0] & ThreadUtils.TYPE_SINGLE;
            i4 = (bArr[1] << 8) & 65280;
        } else if (i2 == 3) {
            i3 = (bArr[0] & ThreadUtils.TYPE_SINGLE) | ((bArr[1] << 8) & 65280);
            i4 = (bArr[2] << 16) & 16711680;
        } else {
            if (i2 != 4) {
                return 0;
            }
            i3 = ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
            i4 = bArr[3] & ThreadUtils.TYPE_SINGLE;
        }
        return i4 | i3;
    }

    public static String byteArrToHexString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            str = str + Integer.toString((b2 & ThreadUtils.TYPE_SINGLE) + RecyclerView.c0.FLAG_TMP_DETACHED, 16).substring(1);
        }
        return str;
    }

    public static void byteArrToShort(byte[] bArr, short s, int i2) {
        bArr[i2 + 1] = (byte) (s >> 8);
        bArr[i2 + 0] = (byte) (s >> 0);
    }

    public static int byteArrayTo2Int(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int length = bArr.length - 1;
        int i2 = 3;
        while (i2 >= 0) {
            if (length >= 0) {
                bArr2[i2] = bArr[length];
            } else {
                bArr2[i2] = 0;
            }
            i2--;
            length--;
        }
        return (bArr2[3] & ThreadUtils.TYPE_SINGLE) + ((bArr2[2] & ThreadUtils.TYPE_SINGLE) << 8) + ((bArr2[1] & ThreadUtils.TYPE_SINGLE) << 16) + ((bArr2[0] & ThreadUtils.TYPE_SINGLE) << 24);
    }

    public static int byteArrayToInt(byte[] bArr) {
        return ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 24) | (bArr[3] & ThreadUtils.TYPE_SINGLE) | ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 8) | ((bArr[1] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static int byteArrayToInt2(byte[] bArr, int i2, int i3) {
        byte[] byteArr = getByteArr(bArr, i2, i3);
        return ((byteArr[0] & ThreadUtils.TYPE_SINGLE) << 24) | (byteArr[3] & ThreadUtils.TYPE_SINGLE) | ((byteArr[2] & ThreadUtils.TYPE_SINGLE) << 8) | ((byteArr[1] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static byte[] byteMerger(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static char byteTo2Char(byte[] bArr) {
        return (char) ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static char byteToChar(byte[] bArr) {
        return (char) ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static char[] byteToChars(byte[] bArr) {
        Charset forName = Charset.forName("UTF-8");
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.flip();
        return forName.decode(allocate).array();
    }

    public static String byteToCharsToString(byte[] bArr) {
        Charset charset = StandardCharsets.UTF_8;
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.flip();
        return new String(charset.decode(allocate).array());
    }

    public static int byteToInt(byte b2) {
        return b2 & ThreadUtils.TYPE_SINGLE;
    }

    public static int byteToInt(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += bArr[i3] << (i3 * 8);
        }
        return i2;
    }

    public static String bytes2HexString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static long bytesToLong(byte[] bArr) {
        buffer.put(bArr, 0, bArr.length);
        buffer.flip();
        return buffer.getLong();
    }

    public static String char2String(byte[] bArr) {
        return String.valueOf((char) ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8));
    }

    public static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 > -1) {
            int i3 = i2 + 2;
            int indexOf = str.indexOf("\\u", i3);
            stringBuffer.append(new Character((char) Integer.parseInt(indexOf == -1 ? str.substring(i3, str.length()) : str.substring(i3, indexOf), 16)).toString());
            i2 = indexOf;
        }
        return stringBuffer.toString();
    }

    public static byte[] getByteArr(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        MyLogUtils.d("tag", " getByteArr data.len=" + bArr.length + " ret.len=" + i4 + " end=" + i3);
        int i5 = 0;
        while (true) {
            int i6 = i2 + i5;
            if (i6 >= i3) {
                return bArr2;
            }
            bArr2[i5] = bArr[i6];
            i5++;
        }
    }

    public static byte[] getByteArrSkip(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        MyLogUtils.d("tag", " getByteArr data.len=" + bArr.length + " ret.len=" + i3 + " skip=" + i3);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr2[i4] = bArr[((i2 + i3) - 1) - i4];
        }
        return bArr2;
    }

    public static byte[] getByteArrSkipSearch(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        MyLogUtils.d("tag", " getByteArr data.len=" + bArr.length + " ret.len=" + i3 + " skip=" + i3);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr2[i4] = bArr[i2 + i4];
        }
        return bArr2;
    }

    public static byte[] getSendContent(byte[] bArr, int i2) {
        MyLogUtils.d("AddDeviceToWifi", " message=" + bArr.length + "  message=" + new String(bArr));
        int length = bArr.length;
        byte[] intToBytesLittle = intToBytesLittle(320082708);
        byte[] intToBytesLittle2 = intToBytesLittle(i2);
        byte[] intToBytesLittle3 = intToBytesLittle(2);
        byte[] intToBytesLittle4 = intToBytesLittle(1024);
        MyLogUtils.d("AddDeviceToWifi", "startcode=" + Integer.toHexString(byteArrayToInt(intToBytesLittle)) + "==" + byteArrayToInt(intToBytesLittle) + " cmd=" + byteArrayToInt(intToBytesLittle2) + " subcmd=" + byteArrayToInt(intToBytesLittle3) + " datalen=" + byteArrayToInt(intToBytesLittle4));
        int length2 = intToBytesLittle.length + intToBytesLittle2.length + intToBytesLittle3.length + intToBytesLittle4.length;
        byte[] bArr2 = new byte[length2];
        StringBuilder sb = new StringBuilder();
        sb.append(" headlenght=");
        sb.append(length2);
        sb.append("  head=");
        sb.append(byteArrayToInt(bArr2));
        MyLogUtils.d("AddDeviceToWifi", sb.toString());
        System.arraycopy(intToBytesLittle, 0, bArr2, 0, intToBytesLittle.length);
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr2, 0, bArr3, 0, 4);
        MyLogUtils.d("AddDeviceToWifi", " headlenght=4  head1=" + byteArrayToInt(bArr3));
        System.arraycopy(intToBytesLittle2, 0, bArr2, 4, intToBytesLittle2.length);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr2, 4, bArr4, 0, 4);
        MyLogUtils.d("AddDeviceToWifi", " headlenght=4  head2=" + byteArrayToInt(bArr4));
        System.arraycopy(intToBytesLittle3, 0, bArr2, 8, intToBytesLittle3.length);
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr2, 8, bArr5, 0, 4);
        MyLogUtils.d("AddDeviceToWifi", " headlenght=4  head3=" + byteArrayToInt(bArr5));
        System.arraycopy(intToBytesLittle4, 0, bArr2, 12, intToBytesLittle4.length);
        byte[] bArr6 = new byte[4];
        System.arraycopy(bArr2, 12, bArr6, 0, 4);
        MyLogUtils.d("AddDeviceToWifi", " headlenght=4  head4=" + byteArrayToInt(bArr6));
        byte[] bArr7 = new byte[length + length2];
        System.arraycopy(bArr2, 0, bArr7, 0, length2);
        System.arraycopy(bArr, 0, bArr7, length2, length);
        return bArr7;
    }

    public static byte[] getSendVoiceData(byte[] bArr, int i2, int i3, String str) {
        MyLogUtils.d("AddDeviceToWifi", " message=" + bArr.length + "  message=" + new String(bArr));
        int length = bArr.length;
        byte[] intToBytesLittle = intToBytesLittle(i2);
        byte[] intToBytesLittle2 = intToBytesLittle(i3);
        byte[] bArr2 = new byte[64];
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        return byteMerger(byteMerger(byteMerger(intToBytesLittle, intToBytesLittle2), bArr2), bArr);
    }

    public static String getString(byte[] bArr, String str, String str2) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            if (str2 == null) {
                return null;
            }
            return str2;
        }
    }

    public static int hexStringToInt(String str) {
        return Integer.parseInt(str, 16);
    }

    public static String intToBinary(int i2) {
        return Integer.toBinaryString(i2);
    }

    public static byte intToByte(int i2) {
        return (byte) i2;
    }

    public static byte[] intToByteArray(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & ViewfinderView.OPAQUE), (byte) ((i2 >> 16) & ViewfinderView.OPAQUE), (byte) ((i2 >> 8) & ViewfinderView.OPAQUE), (byte) (i2 & ViewfinderView.OPAQUE)};
    }

    public static byte[] intToBytesBig(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & ViewfinderView.OPAQUE), (byte) ((i2 >> 16) & ViewfinderView.OPAQUE), (byte) ((i2 >> 8) & ViewfinderView.OPAQUE), (byte) (i2 & ViewfinderView.OPAQUE)};
    }

    public static byte[] intToBytesLittle(int i2) {
        return new byte[]{(byte) (i2 & ViewfinderView.OPAQUE), (byte) ((i2 >> 8) & ViewfinderView.OPAQUE), (byte) ((i2 >> 16) & ViewfinderView.OPAQUE), (byte) ((i2 >> 24) & ViewfinderView.OPAQUE)};
    }

    public static boolean isEq(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] longToBytes(long j) {
        buffer.putLong(0, j);
        return buffer.array();
    }

    public static void main(String[] strArr) {
        System.err.println(isEq(new byte[]{1, 2}, new byte[]{1, 2}));
    }

    public static InputStream readByteArr(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static byte[] readInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException unused) {
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return byteArray;
            } catch (IOException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                    return null;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused5) {
                    return null;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static String revert(String str) {
        int i2;
        if (str == null) {
            str = "";
        }
        if (str.indexOf("\\u") == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(1000);
        int i3 = 0;
        while (i3 < str.length() - 6) {
            int i4 = i3 + 6;
            String substring = str.substring(i3, i4).substring(2);
            int i5 = 0;
            for (int i6 = 0; i6 < substring.length(); i6++) {
                char charAt = substring.charAt(i6);
                switch (charAt) {
                    case 'a':
                        i2 = 10;
                        break;
                    case 'b':
                        i2 = 11;
                        break;
                    case 'c':
                        i2 = 12;
                        break;
                    case 'd':
                        i2 = 13;
                        break;
                    case 'e':
                        i2 = 14;
                        break;
                    case 'f':
                        i2 = 15;
                        break;
                    default:
                        i2 = charAt - '0';
                        break;
                }
                i5 += i2 * ((int) Math.pow(16.0d, (substring.length() - i6) - 1));
            }
            stringBuffer.append((char) i5);
            i3 = i4;
        }
        return stringBuffer.toString();
    }

    public static byte[] shortToByteArr(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & ViewfinderView.OPAQUE)};
    }

    public static byte[] splicingArrays(byte[]... bArr) {
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 += bArr2.length;
        }
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
            i3 += bArr4.length;
        }
        return bArr3;
    }

    public static String ten2Hex(int i2) {
        return Integer.toHexString(i2);
    }

    public static int byteArrayToInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & ThreadUtils.TYPE_SINGLE) << 24) | (bArr[i2 + 0] & ThreadUtils.TYPE_SINGLE) | ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) << 8) | ((bArr[i2 + 2] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static String getString(byte[] bArr, String str) {
        return getString(bArr, str, null);
    }

    public static short byteArrToShort(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) | (bArr[i2 + 0] << 8));
    }

    public static int byteArrayToInt(byte[] bArr, int i2, int i3) {
        byte[] byteArr = getByteArr(bArr, i2, i3);
        return ((byteArr[3] & ThreadUtils.TYPE_SINGLE) << 24) | (byteArr[0] & ThreadUtils.TYPE_SINGLE) | ((byteArr[1] & ThreadUtils.TYPE_SINGLE) << 8) | ((byteArr[2] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static short byteArrToShort(byte[] bArr) {
        return byteArrToShort(bArr, 0);
    }
}
