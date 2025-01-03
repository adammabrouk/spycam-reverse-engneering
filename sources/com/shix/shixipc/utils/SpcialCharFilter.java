package com.shix.shixipc.utils;

import android.content.Context;
import android.text.InputFilter;

/* loaded from: classes.dex */
public class SpcialCharFilter implements InputFilter {
    public Context mContext;

    public SpcialCharFilter(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r2 = r1.mContext;
        android.widget.Toast.makeText(r2, r2.getString(com.shix.lookcam.R.string.tip_not_spcialchar), 0).show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        return "";
     */
    @Override // android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence filter(java.lang.CharSequence r2, int r3, int r4, android.text.Spanned r5, int r6, int r7) {
        /*
            r1 = this;
            java.lang.String r5 = r2.toString()
            java.lang.String r5 = r1.stringToAscii(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L53
            java.lang.String r2 = ","
            java.lang.String[] r2 = r5.split(r2)
            r5 = 0
            r6 = 0
        L16:
            int r7 = r2.length
            if (r6 >= r7) goto L53
            r7 = r2[r6]
            int r7 = java.lang.Integer.parseInt(r7)
            r0 = 32
            if (r7 <= r0) goto L3e
            r0 = 126(0x7e, float:1.77E-43)
            if (r7 > r0) goto L3e
            r0 = 34
            if (r7 == r0) goto L3e
            r0 = 38
            if (r7 == r0) goto L3e
            r0 = 92
            if (r7 == r0) goto L3e
            r0 = 61
            if (r7 == r0) goto L3e
            r0 = 43
            if (r7 == r0) goto L3e
            int r6 = r6 + 1
            goto L16
        L3e:
            if (r3 == r4) goto L50
            android.content.Context r2 = r1.mContext
            r3 = 2131689946(0x7f0f01da, float:1.9008922E38)
            java.lang.String r3 = r2.getString(r3)
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r5)
            r2.show()
        L50:
            java.lang.String r2 = ""
            return r2
        L53:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.SpcialCharFilter.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }

    public String stringToAscii(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (i2 != charArray.length - 1) {
                stringBuffer.append((int) charArray[i2]);
                stringBuffer.append(",");
            } else {
                stringBuffer.append((int) charArray[i2]);
            }
        }
        return stringBuffer.toString();
    }
}
