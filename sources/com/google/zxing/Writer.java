package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException;

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException;
}
