package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.zxing.view.ViewfinderView;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f2428a;

    /* renamed from: b, reason: collision with root package name */
    public View f2429b;

    /* renamed from: c, reason: collision with root package name */
    public int f2430c;

    public Placeholder(Context context) {
        super(context);
        this.f2428a = -1;
        this.f2429b = null;
        this.f2430c = 4;
        a((AttributeSet) null);
    }

    public final void a(AttributeSet attributeSet) {
        super.setVisibility(this.f2430c);
        this.f2428a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.f2428a = obtainStyledAttributes.getResourceId(index, this.f2428a);
                } else if (index == R$styleable.ConstraintLayout_placeholder_emptyVisibility) {
                    this.f2430c = obtainStyledAttributes.getInt(index, this.f2430c);
                }
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f2428a == -1 && !isInEditMode()) {
            setVisibility(this.f2430c);
        }
        View findViewById = constraintLayout.findViewById(this.f2428a);
        this.f2429b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.a) findViewById.getLayoutParams()).Z = true;
            this.f2429b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f2429b;
    }

    public int getEmptyVisibility() {
        return this.f2430c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(ViewfinderView.OPAQUE, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f2428a == i2) {
            return;
        }
        View view = this.f2429b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f2429b.getLayoutParams()).Z = false;
            this.f2429b = null;
        }
        this.f2428a = i2;
        if (i2 == -1 || (findViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.f2430c = i2;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2428a = -1;
        this.f2429b = null;
        this.f2430c = 4;
        a(attributeSet);
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.f2429b == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f2429b.getLayoutParams();
        aVar2.k0.o(0);
        aVar.k0.p(aVar2.k0.t());
        aVar.k0.h(aVar2.k0.j());
        aVar2.k0.o(8);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2428a = -1;
        this.f2429b = null;
        this.f2430c = 4;
        a(attributeSet);
    }
}
