package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class VideoBuffer {
    public List<byte[]> DataBuffer;

    public VideoBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }

    public byte[] RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            return this.DataBuffer.remove(0);
        }
    }

    public boolean addData(byte[] bArr) {
        synchronized (this) {
            this.DataBuffer.add(bArr);
        }
        return true;
    }

    public int size() {
        return this.DataBuffer.size();
    }
}
