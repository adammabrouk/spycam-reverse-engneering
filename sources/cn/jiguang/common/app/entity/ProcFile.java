package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* loaded from: classes.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator<ProcFile>() { // from class: cn.jiguang.common.app.entity.ProcFile.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcFile[] newArray(int i2) {
            return new ProcFile[i2];
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final String f8841b;

    public ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.f8841b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return this.f8841b.length();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.f8841b);
    }
}
