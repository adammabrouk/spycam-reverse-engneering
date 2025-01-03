package androidx.fragment.app;

import a.k.a.r;
import a.m.f;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2540a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f2541b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f2542c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2543d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2544e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2545f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2546g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2547h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f2548i;
    public final int j;
    public final CharSequence k;
    public final ArrayList<String> l;
    public final ArrayList<String> m;
    public final boolean n;

    public class a implements Parcelable.Creator<BackStackState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(a.k.a.a aVar) {
        int size = aVar.f1395a.size();
        this.f2540a = new int[size * 5];
        if (!aVar.f1401g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2541b = new ArrayList<>(size);
        this.f2542c = new int[size];
        this.f2543d = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            r.a aVar2 = aVar.f1395a.get(i2);
            int i4 = i3 + 1;
            this.f2540a[i3] = aVar2.f1404a;
            ArrayList<String> arrayList = this.f2541b;
            Fragment fragment = aVar2.f1405b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f2540a;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f1406c;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f1407d;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f1408e;
            iArr[i7] = aVar2.f1409f;
            this.f2542c[i2] = aVar2.f1410g.ordinal();
            this.f2543d[i2] = aVar2.f1411h.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.f2544e = aVar.f1400f;
        this.f2545f = aVar.f1402h;
        this.f2546g = aVar.s;
        this.f2547h = aVar.f1403i;
        this.f2548i = aVar.j;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.n;
        this.n = aVar.o;
    }

    public a.k.a.a a(FragmentManager fragmentManager) {
        a.k.a.a aVar = new a.k.a.a(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f2540a.length) {
            r.a aVar2 = new r.a();
            int i4 = i2 + 1;
            aVar2.f1404a = this.f2540a[i2];
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f2540a[i4]);
            }
            String str = this.f2541b.get(i3);
            if (str != null) {
                aVar2.f1405b = fragmentManager.b(str);
            } else {
                aVar2.f1405b = null;
            }
            aVar2.f1410g = f.c.values()[this.f2542c[i3]];
            aVar2.f1411h = f.c.values()[this.f2543d[i3]];
            int[] iArr = this.f2540a;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            aVar2.f1406c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            aVar2.f1407d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f1408e = i10;
            int i11 = iArr[i9];
            aVar2.f1409f = i11;
            aVar.f1396b = i6;
            aVar.f1397c = i8;
            aVar.f1398d = i10;
            aVar.f1399e = i11;
            aVar.a(aVar2);
            i3++;
            i2 = i9 + 1;
        }
        aVar.f1400f = this.f2544e;
        aVar.f1402h = this.f2545f;
        aVar.s = this.f2546g;
        aVar.f1401g = true;
        aVar.f1403i = this.f2547h;
        aVar.j = this.f2548i;
        aVar.k = this.j;
        aVar.l = this.k;
        aVar.m = this.l;
        aVar.n = this.m;
        aVar.o = this.n;
        aVar.a(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f2540a);
        parcel.writeStringList(this.f2541b);
        parcel.writeIntArray(this.f2542c);
        parcel.writeIntArray(this.f2543d);
        parcel.writeInt(this.f2544e);
        parcel.writeString(this.f2545f);
        parcel.writeInt(this.f2546g);
        parcel.writeInt(this.f2547h);
        TextUtils.writeToParcel(this.f2548i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeStringList(this.l);
        parcel.writeStringList(this.m);
        parcel.writeInt(this.n ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2540a = parcel.createIntArray();
        this.f2541b = parcel.createStringArrayList();
        this.f2542c = parcel.createIntArray();
        this.f2543d = parcel.createIntArray();
        this.f2544e = parcel.readInt();
        this.f2545f = parcel.readString();
        this.f2546g = parcel.readInt();
        this.f2547h = parcel.readInt();
        this.f2548i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.createStringArrayList();
        this.m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }
}
