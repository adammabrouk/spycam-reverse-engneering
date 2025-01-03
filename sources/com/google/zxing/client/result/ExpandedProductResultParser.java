package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class ExpandedProductResultParser extends ResultParser {
    public static String findAIvalue(int i2, String str) {
        if (str.charAt(i2) != '(') {
            return null;
        }
        String substring = str.substring(i2 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String findValue(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i2);
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt != '(') {
                sb.append(charAt);
            } else {
                if (findAIvalue(i3, substring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        if (r1.equals("3933") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ab, code lost:
    
        if (r2.length() >= 4) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        r15 = r2.substring(3);
        r17 = r2.substring(0, 3);
        r16 = r1.substring(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ad, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        if (r1.equals("3932") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
    
        if (r1.equals("3931") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
    
        if (r1.equals("3930") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:
    
        if (r1.equals("3923") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:
    
        r16 = r1.substring(3);
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cf, code lost:
    
        if (r1.equals("3922") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d9, code lost:
    
        if (r1.equals("3921") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e3, code lost:
    
        if (r1.equals("3920") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f4, code lost:
    
        if (r1.equals("3209") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        r14 = r1.substring(3);
        r13 = com.google.zxing.client.result.ExpandedProductParsedResult.POUND;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c4, code lost:
    
        r12 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fe, code lost:
    
        if (r1.equals("3208") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0108, code lost:
    
        if (r1.equals("3207") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0112, code lost:
    
        if (r1.equals("3206") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x011c, code lost:
    
        if (r1.equals("3205") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0126, code lost:
    
        if (r1.equals("3204") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0130, code lost:
    
        if (r1.equals("3203") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x013a, code lost:
    
        if (r1.equals("3202") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0144, code lost:
    
        if (r1.equals("3201") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014e, code lost:
    
        if (r1.equals("3200") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0160, code lost:
    
        if (r1.equals("3109") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01be, code lost:
    
        r14 = r1.substring(3);
        r13 = com.google.zxing.client.result.ExpandedProductParsedResult.KILOGRAM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x016a, code lost:
    
        if (r1.equals("3108") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0174, code lost:
    
        if (r1.equals("3107") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017e, code lost:
    
        if (r1.equals("3106") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0188, code lost:
    
        if (r1.equals("3105") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0192, code lost:
    
        if (r1.equals("3104") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x019c, code lost:
    
        if (r1.equals("3103") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a6, code lost:
    
        if (r1.equals("3102") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b0, code lost:
    
        if (r1.equals("3101") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ba, code lost:
    
        if (r1.equals("3100") == false) goto L152;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.google.zxing.client.result.ResultParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r22) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }
}
