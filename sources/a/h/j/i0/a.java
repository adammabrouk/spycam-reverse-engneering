package a.h.j.i0;

import a.h.i.h;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

/* compiled from: EditorInfoCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1189a = new String[0];

    /* compiled from: EditorInfoCompat.java */
    /* renamed from: a.h.j.i0.a$a, reason: collision with other inner class name */
    public static class C0030a {
        public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2) {
            editorInfo.setInitialSurroundingSubText(charSequence, i2);
        }
    }

    public static void a(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static boolean a(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    public static void b(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        int i4 = i3 - i2;
        int i5 = i4 > 1024 ? 0 : i4;
        int length = charSequence.length() - i3;
        int i6 = 2048 - i5;
        double d2 = i6;
        Double.isNaN(d2);
        int min = Math.min(length, i6 - Math.min(i2, (int) (d2 * 0.8d)));
        int min2 = Math.min(i2, i6 - min);
        int i7 = i2 - min2;
        if (a(charSequence, i7, 0)) {
            i7++;
            min2--;
        }
        if (a(charSequence, (i3 + min) - 1, 1)) {
            min--;
        }
        CharSequence concat = i5 != i4 ? TextUtils.concat(charSequence.subSequence(i7, i7 + min2), charSequence.subSequence(i3, min + i3)) : charSequence.subSequence(i7, min2 + i5 + min + i7);
        int i8 = min2 + 0;
        a(editorInfo, concat, i8, i5 + i8);
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f1189a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f1189a;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray != null ? stringArray : f1189a;
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            C0030a.a(editorInfo, charSequence, 0);
        } else {
            a(editorInfo, charSequence, 0);
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2) {
        h.a(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            C0030a.a(editorInfo, charSequence, i2);
            return;
        }
        int i3 = editorInfo.initialSelStart;
        int i4 = editorInfo.initialSelEnd;
        int i5 = i3 > i4 ? i4 - i2 : i3 - i2;
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i6 - i2 : i7 - i2;
        int length = charSequence.length();
        if (i2 >= 0 && i5 >= 0 && i8 <= length) {
            if (a(editorInfo.inputType)) {
                a(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                a(editorInfo, charSequence, i5, i8);
                return;
            } else {
                b(editorInfo, charSequence, i5, i8);
                return;
            }
        }
        a(editorInfo, null, 0, 0);
    }

    public static boolean a(CharSequence charSequence, int i2, int i3) {
        if (i3 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i2));
        }
        if (i3 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i2));
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }
}
