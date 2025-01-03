package b.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import cn.asus.push.DataBuffer;

/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<DataBuffer> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataBuffer createFromParcel(Parcel parcel) {
        return new DataBuffer(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataBuffer[] newArray(int i2) {
        return new DataBuffer[i2];
    }
}
