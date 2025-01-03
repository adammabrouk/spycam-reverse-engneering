package a.b.f;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public TextView f536a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f537b;

    public m(TextView textView) {
        a.h.i.h.a(textView);
        this.f536a = textView;
    }

    public void a(TextClassifier textClassifier) {
        this.f537b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f537b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f536a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
