package com.shix.shixipc.bean;

import java.util.List;

/* loaded from: classes.dex */
public class FileListDateBean {
    public String groupTitle;
    public List<FileDateBean> mFileDateBeans;

    public FileListDateBean(String str, List<FileDateBean> list) {
        this.groupTitle = str;
        this.mFileDateBeans = list;
    }

    public List<FileDateBean> getFileDateBeans() {
        return this.mFileDateBeans;
    }

    public String getGroupTitle() {
        return this.groupTitle;
    }

    public void setFileDateBeans(List<FileDateBean> list) {
        this.mFileDateBeans = list;
    }

    public void setGroupTitle(String str) {
        this.groupTitle = str;
    }

    public String toString() {
        return "FileListDateBean{groupTitle='" + this.groupTitle + "', mFileDateBeans=" + this.mFileDateBeans + '}';
    }
}
