package com.google.zxing.pdf417;

/* loaded from: classes.dex */
public final class PDF417ResultMetadata {
    public String addressee;
    public String fileId;
    public String fileName;
    public boolean lastSegment;
    public int[] optionalData;
    public int segmentIndex;
    public String sender;
    public int segmentCount = -1;
    public long fileSize = -1;
    public long timestamp = -1;
    public int checksum = -1;

    public String getAddressee() {
        return this.addressee;
    }

    public int getChecksum() {
        return this.checksum;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.optionalData;
    }

    public int getSegmentCount() {
        return this.segmentCount;
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public String getSender() {
        return this.sender;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setAddressee(String str) {
        this.addressee = str;
    }

    public void setChecksum(int i2) {
        this.checksum = i2;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public void setSegmentCount(int i2) {
        this.segmentCount = i2;
    }

    public void setSegmentIndex(int i2) {
        this.segmentIndex = i2;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
