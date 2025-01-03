package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import com.tencent.bugly.BuglyStrategy;

/* loaded from: classes.dex */
public abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void addWeightCode(StringBuilder sb, int i2);

    public abstract int checkWeight(int i2);

    public final void encodeCompressedWeight(StringBuilder sb, int i2, int i3) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i2, i3);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i4 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        for (int i5 = 0; i5 < 5; i5++) {
            if (checkWeight / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(checkWeight);
    }
}
