package c.k.d.p9;

import c.k.d.c6;
import c.k.d.o5;
import c.k.d.x5;
import c.k.d.y5;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class c1 implements x5 {
    public static o5 b(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                strArr3[i2] = xmlPullParser.getAttributeName(i2);
                strArr4[i2] = c6.b(xmlPullParser.getAttributeValue(i2));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new o5(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                o5 b2 = b(xmlPullParser);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
    }

    public o5 a(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return b(xmlPullParser);
        }
        return null;
    }

    public void a() {
        y5.a().a("all", "xm:chat", this);
    }
}
