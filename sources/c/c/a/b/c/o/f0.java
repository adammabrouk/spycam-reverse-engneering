package c.c.a.b.c.o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.BinderWrapper;

/* loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<BinderWrapper> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
