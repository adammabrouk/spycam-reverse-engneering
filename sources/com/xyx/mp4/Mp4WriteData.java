package com.xyx.mp4;

/* loaded from: classes.dex */
public class Mp4WriteData {
    public int height;
    public int iWitchAudio;
    public int is_hevc;
    public int uAudioChannelNums;
    public int uAudioRate;
    public int uAudioTimeScale;
    public int uVideoTimeScale;
    public int width;

    public Mp4WriteData(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.width = i2;
        this.height = i3;
        this.uVideoTimeScale = i4;
        this.is_hevc = i5;
        this.iWitchAudio = i6;
        this.uAudioRate = i7;
        this.uAudioChannelNums = i8;
        this.uAudioTimeScale = i9;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIs_hevc() {
        return this.is_hevc;
    }

    public int getWidth() {
        return this.width;
    }

    public int getiWitchAudio() {
        return this.iWitchAudio;
    }

    public int getuAudioChannelNums() {
        return this.uAudioChannelNums;
    }

    public int getuAudioRate() {
        return this.uAudioRate;
    }

    public int getuAudioTimeScale() {
        return this.uAudioTimeScale;
    }

    public int getuVideoTimeScale() {
        return this.uVideoTimeScale;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIs_hevc(int i2) {
        this.is_hevc = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setiWitchAudio(int i2) {
        this.iWitchAudio = i2;
    }

    public void setuAudioChannelNums(int i2) {
        this.uAudioChannelNums = i2;
    }

    public void setuAudioRate(int i2) {
        this.uAudioRate = i2;
    }

    public void setuAudioTimeScale(int i2) {
        this.uAudioTimeScale = i2;
    }

    public void setuVideoTimeScale(int i2) {
        this.uVideoTimeScale = i2;
    }
}
