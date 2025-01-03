package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class CustomBuffer {
    public List<CustomBufferData> DataBuffer = new LinkedList();

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }

    public CustomBufferData RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            return this.DataBuffer.remove(0);
        }
    }

    public boolean addData(CustomBufferData customBufferData) {
        synchronized (this) {
            this.DataBuffer.add(customBufferData);
        }
        return true;
    }
}
