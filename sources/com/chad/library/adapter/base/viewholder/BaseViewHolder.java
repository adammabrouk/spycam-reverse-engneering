package com.chad.library.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import f.j.b.f;

/* compiled from: BaseViewHolder.kt */
@Keep
/* loaded from: classes.dex */
public class BaseViewHolder extends RecyclerView.c0 {
    public final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view) {
        super(view);
        f.d(view, "view");
        this.views = new SparseArray<>();
    }

    public <T extends View> T findView(int i2) {
        return (T) this.itemView.findViewById(i2);
    }

    public <B extends ViewDataBinding> B getBinding() {
        return (B) DataBindingUtil.getBinding(this.itemView);
    }

    public <T extends View> T getView(int i2) {
        T t = (T) getViewOrNull(i2);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(("No view found with id " + i2).toString());
    }

    public <T extends View> T getViewOrNull(int i2) {
        T t;
        T t2 = (T) this.views.get(i2);
        if (t2 == null && (t = (T) this.itemView.findViewById(i2)) != null) {
            this.views.put(i2, t);
            return t;
        }
        if (t2 instanceof View) {
            return t2;
        }
        return null;
    }

    public BaseViewHolder setBackgroundColor(int i2, int i3) {
        getView(i2).setBackgroundColor(i3);
        return this;
    }

    public BaseViewHolder setBackgroundResource(int i2, int i3) {
        getView(i2).setBackgroundResource(i3);
        return this;
    }

    public BaseViewHolder setEnabled(int i2, boolean z) {
        getView(i2).setEnabled(z);
        return this;
    }

    public BaseViewHolder setGone(int i2, boolean z) {
        getView(i2).setVisibility(z ? 8 : 0);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i2, Bitmap bitmap) {
        ((ImageView) getView(i2)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i2, Drawable drawable) {
        ((ImageView) getView(i2)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(int i2, int i3) {
        ((ImageView) getView(i2)).setImageResource(i3);
        return this;
    }

    public BaseViewHolder setText(int i2, CharSequence charSequence) {
        ((TextView) getView(i2)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int i2, int i3) {
        ((TextView) getView(i2)).setTextColor(i3);
        return this;
    }

    public BaseViewHolder setTextColorRes(int i2, int i3) {
        TextView textView = (TextView) getView(i2);
        View view = this.itemView;
        f.a((Object) view, "itemView");
        textView.setTextColor(view.getResources().getColor(i3));
        return this;
    }

    public BaseViewHolder setVisible(int i2, boolean z) {
        getView(i2).setVisibility(z ? 0 : 4);
        return this;
    }

    public BaseViewHolder setText(int i2, int i3) {
        ((TextView) getView(i2)).setText(i3);
        return this;
    }
}
