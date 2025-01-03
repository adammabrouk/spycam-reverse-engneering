package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class HmacSHA1Signature {
    public static final String ALGORITHM = "HmacSHA1";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final Object LOCK = new Object();
    public static final String VERSION = "1";
    public static Mac macInstance;

    private byte[] sign(byte[] bArr, byte[] bArr2) {
        Mac mac;
        try {
            if (macInstance == null) {
                synchronized (LOCK) {
                    if (macInstance == null) {
                        macInstance = Mac.getInstance(getAlgorithm());
                    }
                }
            }
            try {
                mac = (Mac) macInstance.clone();
            } catch (CloneNotSupportedException unused) {
                mac = Mac.getInstance(getAlgorithm());
            }
            mac.init(new SecretKeySpec(bArr, getAlgorithm()));
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException unused2) {
            throw new RuntimeException("key must not be null");
        } catch (NoSuchAlgorithmException unused3) {
            throw new RuntimeException("Unsupported algorithm: HmacSHA1");
        }
    }

    public String computeSignature(String str, String str2) {
        OSSLog.logDebug(getAlgorithm(), false);
        OSSLog.logDebug(getVersion(), false);
        try {
            OSSLog.logDebug("sign start");
            byte[] sign = sign(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
            OSSLog.logDebug("base64 start");
            return BinaryUtil.toBase64String(sign);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Unsupported algorithm: UTF-8");
        }
    }

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getVersion() {
        return "1";
    }
}
