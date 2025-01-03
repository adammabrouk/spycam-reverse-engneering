package a.b.f;

import a.h.j.c;
import a.h.j.i0.b;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;

/* compiled from: AppCompatReceiveContentHelper.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: AppCompatReceiveContentHelper.java */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f520a;

        public a(View view) {
            this.f520a = view;
        }

        @Override // a.h.j.i0.b.c
        public boolean a(a.h.j.i0.c cVar, int i2, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
                try {
                    cVar.d();
                    InputContentInfo inputContentInfo = (InputContentInfo) cVar.e();
                    bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                    bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                } catch (Exception e2) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e2);
                    return false;
                }
            }
            c.a aVar = new c.a(new ClipData(cVar.b(), new ClipData.Item(cVar.a())), 2);
            aVar.a(cVar.c());
            aVar.a(bundle);
            return a.h.j.y.a(this.f520a, aVar.a()) == null;
        }
    }

    public static boolean a(TextView textView, int i2) {
        if ((i2 != 16908322 && i2 != 16908337) || a.h.j.y.t(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            c.a aVar = new c.a(primaryClip, 1);
            aVar.a(i2 != 16908322 ? 1 : 0);
            a.h.j.y.a(textView, aVar.a());
        }
        return true;
    }

    public static Activity b(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* compiled from: AppCompatReceiveContentHelper.java */
    public static final class b {
        public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                a.h.j.y.a(textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        public static boolean a(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            a.h.j.y.a(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    public static boolean a(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && a.h.j.y.t(view) != null) {
            Activity b2 = b(view);
            if (b2 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                if (view instanceof TextView) {
                    return b.a(dragEvent, (TextView) view, b2);
                }
                return b.a(dragEvent, view, b2);
            }
        }
        return false;
    }

    public static b.c a(View view) {
        return new a(view);
    }
}
