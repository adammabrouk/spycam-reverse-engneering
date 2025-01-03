package a.h.b.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f951a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f952b;

    /* renamed from: c, reason: collision with root package name */
    public int f953c;

    public b(Shader shader, ColorStateList colorStateList, int i2) {
        this.f951a = shader;
        this.f952b = colorStateList;
        this.f953c = i2;
    }

    public static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b b(int i2) {
        return new b(null, null, i2);
    }

    public boolean c() {
        return this.f951a != null;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return this.f951a == null && (colorStateList = this.f952b) != null && colorStateList.isStateful();
    }

    public boolean e() {
        return c() || this.f953c != 0;
    }

    public static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public Shader b() {
        return this.f951a;
    }

    public static b b(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    public int a() {
        return this.f953c;
    }

    public void a(int i2) {
        this.f953c = i2;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.f952b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f953c) {
                this.f953c = colorForState;
                return true;
            }
        }
        return false;
    }

    public static b a(Resources resources, int i2, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals("gradient")) {
                c2 = 1;
            }
            if (c2 == 0) {
                return a(a.a(resources, xml, asAttributeSet, theme));
            }
            if (c2 == 1) {
                return a(d.a(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }
}
