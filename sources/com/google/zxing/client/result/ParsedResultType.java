package com.google.zxing.client.result;

/* loaded from: classes.dex */
public enum ParsedResultType {
    ADDRESSBOOK,
    EMAIL_ADDRESS,
    PRODUCT,
    URI,
    TEXT,
    GEO,
    TEL,
    SMS,
    CALENDAR,
    WIFI,
    ISBN,
    VIN;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ParsedResultType[] valuesCustom() {
        ParsedResultType[] valuesCustom = values();
        int length = valuesCustom.length;
        ParsedResultType[] parsedResultTypeArr = new ParsedResultType[length];
        System.arraycopy(valuesCustom, 0, parsedResultTypeArr, 0, length);
        return parsedResultTypeArr;
    }
}
