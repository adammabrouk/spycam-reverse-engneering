package com.shix.shixipc.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class EmojiFilterOne implements InputFilter {
    public static Set<String> filterSet;

    static {
        HashSet hashSet = new HashSet();
        filterSet = hashSet;
        addUnicodeRangeToSet(hashSet, 128513, 128591);
        addUnicodeRangeToSet(filterSet, 9986, 10160);
        addUnicodeRangeToSet(filterSet, 128640, 128704);
        addUnicodeRangeToSet(filterSet, 9410, 127569);
        addUnicodeRangeToSet(filterSet, 128512, 128566);
        addUnicodeRangeToSet(filterSet, 128641, 128709);
        addUnicodeRangeToSet(filterSet, 127757, 128359);
    }

    public static void addUnicodeRangeToSet(Set<String> set, int i2, int i3) {
        if (set != null && i2 <= i3) {
            while (i2 <= i3) {
                filterSet.add(new String(new int[]{i2}, 0, 1));
                i2++;
            }
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        return filterSet.contains(charSequence.toString()) ? "" : charSequence;
    }
}
