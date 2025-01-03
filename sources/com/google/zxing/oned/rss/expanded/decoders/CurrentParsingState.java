package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
public final class CurrentParsingState {
    public int position = 0;
    public State encoding = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void incrementPosition(int i2) {
        this.position += i2;
    }

    public boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    public boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    public boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    public void setAlpha() {
        this.encoding = State.ALPHA;
    }

    public void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }

    public void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }
}
