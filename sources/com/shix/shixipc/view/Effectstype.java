package com.shix.shixipc.view;

/* loaded from: classes.dex */
public enum Effectstype {
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    Slideright(SlideRight.class),
    Fall(Fall.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    RotateRight(RotateRight.class),
    Sidefill(SideFall.class);

    public Class effectsClazz;

    Effectstype(Class cls) {
        this.effectsClazz = cls;
    }

    public BaseEffects getAnimator() {
        try {
            return (BaseEffects) this.effectsClazz.newInstance();
        } catch (Exception unused) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
