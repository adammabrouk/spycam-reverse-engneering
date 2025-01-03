package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
public abstract class DecodedObject {
    public final int newPosition;

    public DecodedObject(int i2) {
        this.newPosition = i2;
    }

    public final int getNewPosition() {
        return this.newPosition;
    }
}
