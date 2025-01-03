package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class AudioBuffer {
    public List<byte[]> DataBuffer;
    public byte[] data;
    public int size;

    public AudioBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public void ClearAudioAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }

    public byte[] RemoveAudioData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            return this.DataBuffer.remove(0);
        }
    }

    public boolean addAudioData(byte[] bArr) {
        synchronized (this) {
            this.DataBuffer.add(bArr);
        }
        return true;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getSize() {
        return this.size;
    }

    public AudioBuffer(byte[] bArr, int i2) {
        this.DataBuffer = null;
        this.data = bArr;
        this.size = i2;
    }
}
