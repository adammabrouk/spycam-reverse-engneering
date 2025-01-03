package c.k.d;

import android.text.TextUtils;
import c.k.d.p5;
import c.k.d.p9.r;
import c.k.d.t5;
import c.k.d.v5;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.system.ContentCommon;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class z5 {

    /* renamed from: a, reason: collision with root package name */
    public static XmlPullParser f8076a;

    public static o5 a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = y5.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof c.k.d.p9.c1)) {
            return null;
        }
        return ((c.k.d.p9.c1) a2).a(xmlPullParser);
    }

    public static p5 a(XmlPullParser xmlPullParser, z4 z4Var) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        p5.a a2 = p5.a.a(xmlPullParser.getAttributeValue("", ContentCommon.TYPE));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        p5 p5Var = null;
        v5 v5Var = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    v5Var = m553a(xmlPullParser);
                } else {
                    p5Var = new p5();
                    p5Var.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (p5Var == null) {
            if (p5.a.f7499b == a2 || p5.a.f7500c == a2) {
                a6 a6Var = new a6();
                a6Var.b(attributeValue);
                a6Var.d(attributeValue3);
                a6Var.e(attributeValue2);
                a6Var.a(p5.a.f7502e);
                a6Var.c(attributeValue4);
                a6Var.a(new v5(v5.a.f7949b));
                z4Var.a(a6Var);
                c.k.a.a.a.c.d("iq usage error. send packet in packet parser.");
                return null;
            }
            p5Var = new b6();
        }
        p5Var.b(attributeValue);
        p5Var.d(attributeValue2);
        p5Var.c(attributeValue4);
        p5Var.e(attributeValue3);
        p5Var.a(a2);
        p5Var.a(v5Var);
        p5Var.a(hashMap);
        return p5Var;
    }

    public static r5 a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", ContentCommon.TYPE);
            r.b a2 = c.k.d.p9.r.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = c.k.d.p9.r.a().a(attributeValue, attributeValue3);
            }
            if (a2 == null) {
                throw new l5("the channel id is wrong while receiving a encrypted message");
            }
            r5 r5Var = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new l5("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new l5("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        q5 q5Var = new q5();
                        q5Var.c(attributeValue);
                        q5Var.b(true);
                        q5Var.e(attributeValue3);
                        q5Var.d(attributeValue4);
                        q5Var.b(attributeValue2);
                        q5Var.k(attributeValue5);
                        o5 o5Var = new o5("s", null, null, null);
                        o5Var.m324a(text);
                        q5Var.a(o5Var);
                        return q5Var;
                    }
                    a(c.k.d.p9.a0.a(c.k.d.p9.a0.a(a2.f7685i, attributeValue2), text));
                    f8076a.next();
                    r5Var = a(f8076a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (r5Var != null) {
                return r5Var;
            }
            throw new l5("error while receiving a encrypted message with wrong format");
        }
        q5 q5Var2 = new q5();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        q5Var2.b(attributeValue6);
        q5Var2.d(xmlPullParser.getAttributeValue("", "to"));
        q5Var2.e(xmlPullParser.getAttributeValue("", "from"));
        q5Var2.c(xmlPullParser.getAttributeValue("", "chid"));
        q5Var2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                q5Var2.g(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                q5Var2.h(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                q5Var2.i(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                q5Var2.j(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        q5Var2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        q5Var2.k(xmlPullParser.getAttributeValue("", ContentCommon.TYPE));
        String b2 = b(xmlPullParser);
        if (b2 == null || "".equals(b2.trim())) {
            r5.k();
        } else {
            q5Var2.o(b2);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    q5Var2.l(m554a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m554a = m554a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        q5Var2.m(m554a);
                    } else {
                        q5Var2.a(m554a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    q5Var2.a(m553a(xmlPullParser));
                } else {
                    q5Var2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        q5Var2.n(str2);
        return q5Var2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static t5 m551a(XmlPullParser xmlPullParser) {
        t5.b bVar = t5.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", ContentCommon.TYPE);
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = t5.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        t5 t5Var = new t5(bVar);
        t5Var.d(xmlPullParser.getAttributeValue("", "to"));
        t5Var.e(xmlPullParser.getAttributeValue("", "from"));
        t5Var.c(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        t5Var.b(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    t5Var.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        t5Var.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        t5Var.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        t5Var.a(t5.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    t5Var.a(m553a(xmlPullParser));
                } else {
                    t5Var.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return t5Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static u5 m552a(XmlPullParser xmlPullParser) {
        u5 u5Var = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                u5Var = new u5(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return u5Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static v5 m553a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            if (xmlPullParser.getAttributeName(i2).equals(JThirdPlatFormInterface.KEY_CODE)) {
                str = xmlPullParser.getAttributeValue("", JThirdPlatFormInterface.KEY_CODE);
            }
            if (xmlPullParser.getAttributeName(i2).equals(ContentCommon.TYPE)) {
                str3 = xmlPullParser.getAttributeValue("", ContentCommon.TYPE);
            }
            if (xmlPullParser.getAttributeName(i2).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new v5(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m554a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    public static void a(byte[] bArr) {
        if (f8076a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f8076a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f8076a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static String b(XmlPullParser xmlPullParser) {
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i2)))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }
}
