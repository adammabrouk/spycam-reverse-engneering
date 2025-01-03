package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
public interface Encoder {
    void encode(EncoderContext encoderContext);

    int getEncodingMode();
}
