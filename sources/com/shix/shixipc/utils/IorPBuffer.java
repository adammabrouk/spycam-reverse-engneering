package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class IorPBuffer {
    public List<Integer> DataBuffer;

    public IorPBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }

    public int RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return 0;
            }
            return this.DataBuffer.remove(0).intValue();
        }
    }

    public boolean addData(int i2) {
        synchronized (this) {
            this.DataBuffer.add(Integer.valueOf(i2));
        }
        return true;
    }

    public int size() {
        return this.DataBuffer.size();
    }
}
