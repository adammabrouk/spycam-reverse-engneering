package androidx.core.graphics.drawable;

import a.v.a;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2486a = aVar.a(iconCompat.f2486a, 1);
        iconCompat.f2488c = aVar.a(iconCompat.f2488c, 2);
        iconCompat.f2489d = aVar.a((a) iconCompat.f2489d, 3);
        iconCompat.f2490e = aVar.a(iconCompat.f2490e, 4);
        iconCompat.f2491f = aVar.a(iconCompat.f2491f, 5);
        iconCompat.f2492g = (ColorStateList) aVar.a((a) iconCompat.f2492g, 6);
        iconCompat.f2494i = aVar.a(iconCompat.f2494i, 7);
        iconCompat.j = aVar.a(iconCompat.j, 8);
        iconCompat.f();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.c());
        int i2 = iconCompat.f2486a;
        if (-1 != i2) {
            aVar.b(i2, 1);
        }
        byte[] bArr = iconCompat.f2488c;
        if (bArr != null) {
            aVar.b(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2489d;
        if (parcelable != null) {
            aVar.b(parcelable, 3);
        }
        int i3 = iconCompat.f2490e;
        if (i3 != 0) {
            aVar.b(i3, 4);
        }
        int i4 = iconCompat.f2491f;
        if (i4 != 0) {
            aVar.b(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f2492g;
        if (colorStateList != null) {
            aVar.b(colorStateList, 6);
        }
        String str = iconCompat.f2494i;
        if (str != null) {
            aVar.b(str, 7);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            aVar.b(str2, 8);
        }
    }
}
