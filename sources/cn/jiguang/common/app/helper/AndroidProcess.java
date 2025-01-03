package cn.jiguang.common.app.helper;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AndroidProcess implements Parcelable {
    public static final Parcelable.Creator<AndroidProcess> CREATOR = new Parcelable.Creator<AndroidProcess>() { // from class: cn.jiguang.common.app.helper.AndroidProcess.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidProcess createFromParcel(Parcel parcel) {
            return new AndroidProcess(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidProcess[] newArray(int i2) {
            return new AndroidProcess[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f8845a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8846b;

    public AndroidProcess(Parcel parcel) {
        this.f8845a = parcel.readString();
        this.f8846b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8845a);
        parcel.writeInt(this.f8846b);
    }
}
