package com.shix.shixipc.gridview;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GridItem implements Parcelable {
    public static final Parcelable.Creator<GridItem> CREATOR = new Parcelable.Creator<GridItem>() { // from class: com.shix.shixipc.gridview.GridItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GridItem createFromParcel(Parcel parcel) {
            return new GridItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GridItem[] newArray(int i2) {
            return new GridItem[i2];
        }
    };
    public String path;
    public int section;
    public String time;

    public GridItem(String str, String str2) {
        this.path = str;
        this.time = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPath() {
        return this.path;
    }

    public int getSection() {
        return this.section;
    }

    public String getTime() {
        return this.time;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSection(int i2) {
        this.section = i2;
    }

    public void setTime(String str) {
        this.time = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.path);
        parcel.writeString(this.time);
        parcel.writeInt(this.section);
    }

    public GridItem(Parcel parcel) {
        this.path = parcel.readString();
        this.time = parcel.readString();
        this.section = parcel.readInt();
    }
}
