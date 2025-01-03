package com.shix.shixipc.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CloudBean implements Serializable {
    public static final long serialVersionUID = 112;
    public String cloudPath;
    public String createTime;
    public String fileName;
    public boolean isChecked;
    public boolean isEdited;
    public String strDid;
    public int type;

    public static long getSerialversionuid() {
        return 112L;
    }

    public String getCloudPath() {
        return this.cloudPath;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getStrDid() {
        return this.strDid;
    }

    public int getType() {
        return this.type;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isEdited() {
        return this.isEdited;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCloudPath(String str) {
        this.cloudPath = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setEdited(boolean z) {
        this.isEdited = z;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setStrDid(String str) {
        this.strDid = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
