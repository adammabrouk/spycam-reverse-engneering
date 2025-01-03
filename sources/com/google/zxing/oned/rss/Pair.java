package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public final class Pair extends DataCharacter {
    public int count;
    public final FinderPattern finderPattern;

    public Pair(int i2, int i3, FinderPattern finderPattern) {
        super(i2, i3);
        this.finderPattern = finderPattern;
    }

    public int getCount() {
        return this.count;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public void incrementCount() {
        this.count++;
    }
}
