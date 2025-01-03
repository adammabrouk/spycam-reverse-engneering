package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f2043a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f2044b;

    public class a implements Parcelable.Creator<ActivityResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult[] newArray(int i2) {
            return new ActivityResult[i2];
        }
    }

    public ActivityResult(int i2, Intent intent) {
        this.f2043a = i2;
        this.f2044b = intent;
    }

    public Intent a() {
        return this.f2044b;
    }

    public int c() {
        return this.f2043a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + a(this.f2043a) + ", data=" + this.f2044b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2043a);
        parcel.writeInt(this.f2044b == null ? 0 : 1);
        Intent intent = this.f2044b;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    public static String a(int i2) {
        return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public ActivityResult(Parcel parcel) {
        this.f2043a = parcel.readInt();
        this.f2044b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
