package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class State {
    public static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    public final int binaryShiftByteCount;
    public final int bitCount;
    public final int mode;
    public final Token token;

    public State(Token token, int i2, int i3, int i4) {
        this.token = token;
        this.mode = i2;
        this.binaryShiftByteCount = i3;
        this.bitCount = i4;
    }

    public static int calculateBinaryShiftCost(State state) {
        int i2 = state.binaryShiftByteCount;
        if (i2 > 62) {
            return 21;
        }
        if (i2 > 31) {
            return 20;
        }
        return i2 > 0 ? 10 : 0;
    }

    public State addBinaryShiftChar(int i2) {
        Token token = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (i3 == 4 || i3 == 2) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            token = token.add(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.binaryShiftByteCount;
        State state = new State(token, i3, this.binaryShiftByteCount + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i2 + 1) : state;
    }

    public State endBinaryShift(int i2) {
        int i3 = this.binaryShiftByteCount;
        return i3 == 0 ? this : new State(this.token.addBinaryShift(i2 - i3, i3), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i2 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i3 = this.binaryShiftByteCount;
        int i4 = state.binaryShiftByteCount;
        if (i3 < i4) {
            i2 += calculateBinaryShiftCost(state) - calculateBinaryShiftCost(this);
        } else if (i3 > i4 && i4 > 0) {
            i2 += 10;
        }
        return i2 <= state.bitCount;
    }

    public State latchAndAppend(int i2, int i3) {
        int i4 = this.bitCount;
        Token token = this.token;
        int i5 = this.mode;
        if (i2 != i5) {
            int i6 = HighLevelEncoder.LATCH_TABLE[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            token = token.add(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new State(token.add(i3, i9), i2, 0, i4 + i9);
    }

    public State shiftAndAppend(int i2, int i3) {
        Token token = this.token;
        int i4 = this.mode == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i2], i4).add(i3, 5), this.mode, 0, this.bitCount + i4 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
