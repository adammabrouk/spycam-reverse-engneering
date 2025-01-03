package com.shix.shixipc.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Toast;
import com.shix.lookcam.R;

/* loaded from: classes.dex */
public class FullCharFilter implements InputFilter {
    public Context mContext;

    public FullCharFilter(Context context) {
        this.mContext = context;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        String stringToAscii = stringToAscii(charSequence.toString());
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        for (String str : stringToAscii.split(",")) {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 32 || parseInt > 126) {
                if (i2 == i3) {
                    return "";
                }
                Context context = this.mContext;
                Toast.makeText(context, context.getString(R.string.tip_not_spcialchar), 0).show();
                return "";
            }
        }
        return null;
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
