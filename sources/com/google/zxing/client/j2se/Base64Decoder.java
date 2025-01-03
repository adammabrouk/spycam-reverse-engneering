package com.google.zxing.client.j2se;

/* loaded from: classes.dex */
public abstract class Base64Decoder {
    public static final Base64Decoder INSTANCE;

    static {
        Base64Decoder jAXBBase64Decoder;
        try {
            Class.forName("java.util.Base64");
            jAXBBase64Decoder = new Java8Base64Decoder();
        } catch (ClassNotFoundException unused) {
            jAXBBase64Decoder = new JAXBBase64Decoder();
        }
        INSTANCE = jAXBBase64Decoder;
    }

    public static Base64Decoder getInstance() {
        return INSTANCE;
    }

    public abstract byte[] decode(String str);
}
