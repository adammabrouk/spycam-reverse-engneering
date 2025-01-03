package a.v;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f1991d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f1992e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1993f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1994g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1995h;

    /* renamed from: i, reason: collision with root package name */
    public int f1996i;
    public int j;
    public int k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a.e.a(), new a.e.a(), new a.e.a());
    }

    @Override // a.v.a
    public boolean a(int i2) {
        while (this.j < this.f1994g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1992e.setDataPosition(this.j);
            int readInt = this.f1992e.readInt();
            this.k = this.f1992e.readInt();
            this.j += readInt;
        }
        return this.k == i2;
    }

    @Override // a.v.a
    public void b(int i2) {
        a();
        this.f1996i = i2;
        this.f1991d.put(i2, this.f1992e.dataPosition());
        c(0);
        c(i2);
    }

    @Override // a.v.a
    public void c(int i2) {
        this.f1992e.writeInt(i2);
    }

    @Override // a.v.a
    public boolean d() {
        return this.f1992e.readInt() != 0;
    }

    @Override // a.v.a
    public byte[] e() {
        int readInt = this.f1992e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1992e.readByteArray(bArr);
        return bArr;
    }

    @Override // a.v.a
    public CharSequence f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1992e);
    }

    @Override // a.v.a
    public int g() {
        return this.f1992e.readInt();
    }

    @Override // a.v.a
    public <T extends Parcelable> T h() {
        return (T) this.f1992e.readParcelable(b.class.getClassLoader());
    }

    @Override // a.v.a
    public String i() {
        return this.f1992e.readString();
    }

    public b(Parcel parcel, int i2, int i3, String str, a.e.a<String, Method> aVar, a.e.a<String, Method> aVar2, a.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1991d = new SparseIntArray();
        this.f1996i = -1;
        this.j = 0;
        this.k = -1;
        this.f1992e = parcel;
        this.f1993f = i2;
        this.f1994g = i3;
        this.j = i2;
        this.f1995h = str;
    }

    @Override // a.v.a
    public a b() {
        Parcel parcel = this.f1992e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f1993f) {
            i2 = this.f1994g;
        }
        return new b(parcel, dataPosition, i2, this.f1995h + "  ", this.f1988a, this.f1989b, this.f1990c);
    }

    @Override // a.v.a
    public void b(String str) {
        this.f1992e.writeString(str);
    }

    @Override // a.v.a
    public void a() {
        int i2 = this.f1996i;
        if (i2 >= 0) {
            int i3 = this.f1991d.get(i2);
            int dataPosition = this.f1992e.dataPosition();
            this.f1992e.setDataPosition(i3);
            this.f1992e.writeInt(dataPosition - i3);
            this.f1992e.setDataPosition(dataPosition);
        }
    }

    @Override // a.v.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f1992e.writeInt(bArr.length);
            this.f1992e.writeByteArray(bArr);
        } else {
            this.f1992e.writeInt(-1);
        }
    }

    @Override // a.v.a
    public void a(Parcelable parcelable) {
        this.f1992e.writeParcelable(parcelable, 0);
    }

    @Override // a.v.a
    public void a(boolean z) {
        this.f1992e.writeInt(z ? 1 : 0);
    }

    @Override // a.v.a
    public void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1992e, 0);
    }
}
