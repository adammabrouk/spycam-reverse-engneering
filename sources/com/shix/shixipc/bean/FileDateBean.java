package com.shix.shixipc.bean;

import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class FileDateBean {
    public boolean Selected;
    public String fileName;
    public String fileTime;

    public FileDateBean(String str, String str2, boolean z) {
        this.Selected = false;
        this.fileName = str;
        this.fileTime = str2;
        this.Selected = z;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileTime() {
        return this.fileTime;
    }

    public boolean isSelected() {
        return this.Selected;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileTime(String str) {
        this.fileTime = str;
    }

    public void setSelected(boolean z) {
        LogUtils.d("biniy", "isSelected2 = " + z);
        this.Selected = z;
    }

    public String toString() {
        return "FileDateBean{fileName='" + this.fileName + "', fileTime='" + this.fileTime + "', Selected=" + this.Selected + '}';
    }
}
