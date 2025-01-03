package com.google.zxing.client.j2se;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class Java8Base64Decoder extends Base64Decoder {
    @Override // com.google.zxing.client.j2se.Base64Decoder
    public byte[] decode(String str) {
        try {
            return (byte[]) Class.forName("java.util.Base64$Decoder").getMethod("decode", String.class).invoke(Class.forName("java.util.Base64").getMethod("getDecoder", new Class[0]).invoke(null, new Object[0]), str);
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException(e5.getCause());
        }
    }
}
