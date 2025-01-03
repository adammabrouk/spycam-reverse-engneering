package com.shix.shixipc.view;

import android.animation.AnimatorSet;
import android.view.View;
import c.f.a.a;

/* loaded from: classes.dex */
public abstract class BaseEffects {
    public static final int DURATION = 500;
    public long mDuration = 500;
    public AnimatorSet mAnimatorSet = new AnimatorSet();

    public AnimatorSet getAnimatorSet() {
        return this.mAnimatorSet;
    }

    public void reset(View view) {
        a.a(view, view.getMeasuredWidth() / 2.0f);
        a.b(view, view.getMeasuredHeight() / 2.0f);
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public abstract void setupAnimation(View view);

    public void start(View view) {
        reset(view);
        setupAnimation(view);
        this.mAnimatorSet.start();
    }
}
