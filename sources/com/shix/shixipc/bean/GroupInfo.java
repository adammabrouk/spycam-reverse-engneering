package com.shix.shixipc.bean;

/* loaded from: classes.dex */
public class GroupInfo {
    public int mGroupID;
    public int mGroupLength;
    public String mTitle;
    public int position;

    public GroupInfo(int i2, String str) {
        this.mGroupID = i2;
        this.mTitle = str;
    }

    public int getGroupID() {
        return this.mGroupID;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isFirstViewInGroup() {
        return this.position == 0;
    }

    public boolean isLastViewInGroup() {
        int i2 = this.position;
        return i2 == this.mGroupLength - 1 && i2 >= 0;
    }

    public void setGroupID(int i2) {
        this.mGroupID = i2;
    }

    public void setGroupLength(int i2) {
        this.mGroupLength = i2;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        return "GroupInfo{mGroupID=" + this.mGroupID + ", mTitle='" + this.mTitle + "', position=" + this.position + ", mGroupLength=" + this.mGroupLength + '}';
    }
}
