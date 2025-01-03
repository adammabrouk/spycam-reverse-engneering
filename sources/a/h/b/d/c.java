package a.h.b.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.viewpager.widget.ViewPager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final C0017c[] f954a;

        public b(C0017c[] c0017cArr) {
            this.f954a = c0017cArr;
        }

        public C0017c[] a() {
            return this.f954a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.h.b.d.c$c, reason: collision with other inner class name */
    public static final class C0017c {

        /* renamed from: a, reason: collision with root package name */
        public final String f955a;

        /* renamed from: b, reason: collision with root package name */
        public int f956b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f957c;

        /* renamed from: d, reason: collision with root package name */
        public String f958d;

        /* renamed from: e, reason: collision with root package name */
        public int f959e;

        /* renamed from: f, reason: collision with root package name */
        public int f960f;

        public C0017c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.f955a = str;
            this.f956b = i2;
            this.f957c = z;
            this.f958d = str2;
            this.f959e = i3;
            this.f960f = i4;
        }

        public String a() {
            return this.f955a;
        }

        public int b() {
            return this.f960f;
        }

        public int c() {
            return this.f959e;
        }

        public String d() {
            return this.f958d;
        }

        public int e() {
            return this.f956b;
        }

        public boolean f() {
            return this.f957c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final a.h.g.d f961a;

        /* renamed from: b, reason: collision with root package name */
        public final int f962b;

        /* renamed from: c, reason: collision with root package name */
        public final int f963c;

        /* renamed from: d, reason: collision with root package name */
        public final String f964d;

        public d(a.h.g.d dVar, int i2, int i3, String str) {
            this.f961a = dVar;
            this.f963c = i2;
            this.f962b = i3;
            this.f964d = str;
        }

        public int a() {
            return this.f963c;
        }

        public a.h.g.d b() {
            return this.f961a;
        }

        public String c() {
            return this.f964d;
        }

        public int d() {
            return this.f962b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    public static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new a.h.g.d(string, string2, string3, a(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0017c[]) arrayList.toArray(new C0017c[arrayList.size()]));
    }

    public static C0017c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i2 = obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, ViewPager.MIN_FLING_VELOCITY);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i3 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i4 = obtainAttributes.getInt(i3, 0);
        int i5 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0017c(string2, i2, z, string, i4, resourceId);
    }

    public static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
