package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f10867a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10868b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10869c;

    public PlugInBean(String str, String str2, String str3) {
        this.f10867a = str;
        this.f10868b = str2;
        this.f10869c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f10867a + " plV:" + this.f10868b + " plUUID:" + this.f10869c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f10867a);
        parcel.writeString(this.f10868b);
        parcel.writeString(this.f10869c);
    }

    public PlugInBean(Parcel parcel) {
        this.f10867a = parcel.readString();
        this.f10868b = parcel.readString();
        this.f10869c = parcel.readString();
    }
}
