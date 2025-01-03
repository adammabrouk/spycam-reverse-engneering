package com.google.zxing.client.j2se;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class JAXBBase64Decoder extends Base64Decoder {
    @Override // com.google.zxing.client.j2se.Base64Decoder
    public byte[] decode(String str) {
        try {
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
