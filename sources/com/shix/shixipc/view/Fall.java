package com.shix.shixipc.view;

import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: classes.dex */
public class Fall extends BaseEffects {
    @Override // com.shix.shixipc.view.BaseEffects
    public void setupAnimation(View view) {
        getAnimatorSet().playTogether(ObjectAnimator.ofFloat(view, "scaleX", 2.0f, 1.5f, 1.0f).setDuration(this.mDuration), ObjectAnimator.ofFloat(view, "scaleY", 2.0f, 1.5f, 1.0f).setDuration(this.mDuration), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration((this.mDuration * 3) / 2));
    }
}
