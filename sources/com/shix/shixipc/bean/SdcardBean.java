package com.shix.shixipc.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SdcardBean implements Serializable {
    public static final long serialVersionUID = 1;
    public String did;
    public int record_conver_enable;
    public int record_sd_status;
    public int record_size;
    public int record_time_enable;
    public int record_timer;
    public int record_void_enable;
    public int sdfree;
    public int sdtotal;

    public static long getSerialversionuid() {
        return 1L;
    }

    public String getDid() {
        return this.did;
    }

    public int getRecord_conver_enable() {
        return this.record_conver_enable;
    }

    public int getRecord_sd_status() {
        return this.record_sd_status;
    }

    public int getRecord_size() {
        return this.record_size;
    }

    public int getRecord_time_enable() {
        return this.record_time_enable;
    }

    public int getRecord_timer() {
        return this.record_timer;
    }

    public int getRecord_void_enable() {
        return this.record_void_enable;
    }

    public int getSdfree() {
        return this.sdfree;
    }

    public int getSdtotal() {
        return this.sdtotal;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setRecord_conver_enable(int i2) {
        this.record_conver_enable = i2;
    }

    public void setRecord_sd_status(int i2) {
        this.record_sd_status = i2;
    }

    public void setRecord_size(int i2) {
        this.record_size = i2;
    }

    public void setRecord_time_enable(int i2) {
        this.record_time_enable = i2;
    }

    public void setRecord_timer(int i2) {
        this.record_timer = i2;
    }

    public void setRecord_void_enable(int i2) {
        this.record_void_enable = i2;
    }

    public void setSdfree(int i2) {
        this.sdfree = i2;
    }

    public void setSdtotal(int i2) {
        this.sdtotal = i2;
    }
}
