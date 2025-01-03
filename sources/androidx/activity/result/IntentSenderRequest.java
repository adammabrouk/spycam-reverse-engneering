package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f2069a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f2070b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2071c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2072d;

    public class a implements Parcelable.Creator<IntentSenderRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public IntentSender f2073a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f2074b;

        /* renamed from: c, reason: collision with root package name */
        public int f2075c;

        /* renamed from: d, reason: collision with root package name */
        public int f2076d;

        public b(IntentSender intentSender) {
            this.f2073a = intentSender;
        }

        public b a(Intent intent) {
            this.f2074b = intent;
            return this;
        }

        public b a(int i2, int i3) {
            this.f2076d = i2;
            this.f2075c = i3;
            return this;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f2073a, this.f2074b, this.f2075c, this.f2076d);
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f2069a = intentSender;
        this.f2070b = intent;
        this.f2071c = i2;
        this.f2072d = i3;
    }

    public Intent a() {
        return this.f2070b;
    }

    public int c() {
        return this.f2071c;
    }

    public int d() {
        return this.f2072d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IntentSender e() {
        return this.f2069a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f2069a, i2);
        parcel.writeParcelable(this.f2070b, i2);
        parcel.writeInt(this.f2071c);
        parcel.writeInt(this.f2072d);
    }

    public IntentSenderRequest(Parcel parcel) {
        this.f2069a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f2070b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f2071c = parcel.readInt();
        this.f2072d = parcel.readInt();
    }
}
