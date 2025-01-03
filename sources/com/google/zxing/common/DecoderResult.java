package com.google.zxing.common;

import java.util.List;

/* loaded from: classes.dex */
public final class DecoderResult {
    public final List<byte[]> byteSegments;
    public final String ecLevel;
    public Integer erasures;
    public Integer errorsCorrected;
    public int numBits;
    public Object other;
    public final byte[] rawBytes;
    public final int structuredAppendParity;
    public final int structuredAppendSequenceNumber;
    public final String text;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public String getECLevel() {
        return this.ecLevel;
    }

    public Integer getErasures() {
        return this.erasures;
    }

    public Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public Object getOther() {
        return this.other;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }

    public String getText() {
        return this.text;
    }

    public boolean hasStructuredAppend() {
        return this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0;
    }

    public void setErasures(Integer num) {
        this.erasures = num;
    }

    public void setErrorsCorrected(Integer num) {
        this.errorsCorrected = num;
    }

    public void setNumBits(int i2) {
        this.numBits = i2;
    }

    public void setOther(Object obj) {
        this.other = obj;
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.rawBytes = bArr;
        this.numBits = bArr == null ? 0 : bArr.length * 8;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i3;
        this.structuredAppendSequenceNumber = i2;
    }
}
