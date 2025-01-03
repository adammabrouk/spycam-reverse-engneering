package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class BarcodeValue {
    public final Map<Integer, Integer> values = new HashMap();

    public Integer getConfidence(int i2) {
        return this.values.get(Integer.valueOf(i2));
    }

    public int[] getValue() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry<Integer, Integer> entry : this.values.entrySet()) {
            if (entry.getValue().intValue() > i2) {
                i2 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i2) {
                arrayList.add(entry.getKey());
            }
        }
        return PDF417Common.toIntArray(arrayList);
    }

    public void setValue(int i2) {
        Integer num = this.values.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.values.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
