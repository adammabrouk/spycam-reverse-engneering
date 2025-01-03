package a.h.k;

import a.h.j.t;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;

/* compiled from: TextViewOnReceiveContentListener.java */
/* loaded from: classes.dex */
public final class j implements t {

    /* compiled from: TextViewOnReceiveContentListener.java */
    public static final class a {
        public static CharSequence a(Context context, ClipData.Item item, int i2) {
            if ((i2 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
    }

    /* compiled from: TextViewOnReceiveContentListener.java */
    public static final class b {
        public static CharSequence a(Context context, ClipData.Item item, int i2) {
            CharSequence coerceToText = item.coerceToText(context);
            return ((i2 & 1) == 0 || !(coerceToText instanceof Spanned)) ? coerceToText : coerceToText.toString();
        }
    }

    @Override // a.h.j.t
    public a.h.j.c a(View view, a.h.j.c cVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + cVar);
        }
        int c2 = cVar.c();
        if (c2 == 2) {
            return cVar;
        }
        if (c2 == 3) {
            a((TextView) view, cVar);
            return null;
        }
        ClipData a2 = cVar.a();
        int b2 = cVar.b();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i2 = 0; i2 < a2.getItemCount(); i2++) {
            CharSequence a3 = a(context, a2.getItemAt(i2), b2);
            if (a3 != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), OSSUtils.NEW_LINE);
                    editable.insert(Selection.getSelectionEnd(editable), a3);
                } else {
                    a(editable, a3);
                    z = true;
                }
            }
        }
        return null;
    }

    public static void a(TextView textView, a.h.j.c cVar) {
        a((Editable) textView.getText(), a(cVar.a(), textView.getContext(), cVar.b()));
    }

    public static CharSequence a(ClipData clipData, Context context, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
            CharSequence a2 = a(context, clipData.getItemAt(i3), i2);
            if (a2 != null) {
                spannableStringBuilder.append(a2);
            }
        }
        return spannableStringBuilder;
    }

    public static CharSequence a(Context context, ClipData.Item item, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a.a(context, item, i2);
        }
        return b.a(context, item, i2);
    }

    public static void a(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }
}
