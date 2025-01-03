package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public class DataCharacter {
    public final int checksumPortion;
    public final int value;

    public DataCharacter(int i2, int i3) {
        this.value = i2;
        this.checksumPortion = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.value == dataCharacter.value && this.checksumPortion == dataCharacter.checksumPortion;
    }

    public final int getChecksumPortion() {
        return this.checksumPortion;
    }

    public final int getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value ^ this.checksumPortion;
    }

    public final String toString() {
        return String.valueOf(this.value) + "(" + this.checksumPortion + ')';
    }
}
