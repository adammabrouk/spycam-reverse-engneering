package a.b.f;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f430a;

    public b(ActionBarContainer actionBarContainer) {
        this.f430a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f430a;
        if (actionBarContainer.f2186h) {
            Drawable drawable = actionBarContainer.f2185g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2183e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f430a;
        Drawable drawable3 = actionBarContainer2.f2184f;
        if (drawable3 == null || !actionBarContainer2.f2187i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f430a;
        if (actionBarContainer.f2186h) {
            Drawable drawable = actionBarContainer.f2185g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2183e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
