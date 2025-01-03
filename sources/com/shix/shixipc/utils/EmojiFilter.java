package com.shix.shixipc.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class EmojiFilter implements InputFilter {
    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66).matcher(charSequence).find()) {
            return "";
        }
        return null;
    }
}
