package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.b.g.e;
import com.lxj.xpopup.R$color;

/* loaded from: classes.dex */
public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(Context context) {
        this(context, null);
    }

    public void setupDivider(Boolean bool) {
        SmartDivider smartDivider = new SmartDivider(getContext(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColor(bool.booleanValue() ? R$color._xpopup_list_dark_divider : R$color._xpopup_list_divider));
        gradientDrawable.setSize(10, e.a(getContext(), 0.5f));
        smartDivider.setDrawable(gradientDrawable);
        addItemDecoration(smartDivider);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
