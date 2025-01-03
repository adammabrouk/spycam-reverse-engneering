package com.shix.shixipc.bean;

/* loaded from: classes.dex */
public class PlayTFStatusBean {
    public int childPosition;
    public int groupPosition;
    public boolean isSelected;

    public PlayTFStatusBean(int i2, int i3, boolean z) {
        this.groupPosition = i2;
        this.childPosition = i3;
        this.isSelected = z;
    }

    public int getChildPosition() {
        return this.childPosition;
    }

    public int getGroupPosition() {
        return this.groupPosition;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setChildPosition(int i2) {
        this.childPosition = i2;
    }

    public void setGroupPosition(int i2) {
        this.groupPosition = i2;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String toString() {
        return "PlayTFStatusBean{groupPosition=" + this.groupPosition + ", childPosition=" + this.childPosition + ", isSelected=" + this.isSelected + '}';
    }
}
