package com.xyx.mp4;

/* loaded from: classes.dex */
public class Mp4VideoData {
    public int iFrameType;
    public int uFrameRate;

    public Mp4VideoData(int i2, int i3) {
        this.iFrameType = i2;
        this.uFrameRate = i3;
    }

    public int getiFrameType() {
        return this.iFrameType;
    }

    public int getuFrameRate() {
        return this.uFrameRate;
    }

    public void setiFrameType(int i2) {
        this.iFrameType = i2;
    }

    public void setuFrameRate(int i2) {
        this.uFrameRate = i2;
    }
}
