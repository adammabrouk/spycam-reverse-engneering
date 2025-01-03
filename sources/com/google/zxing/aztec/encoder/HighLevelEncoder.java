package com.google.zxing.aztec.encoder;

import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class HighLevelEncoder {
    public static final int[][] CHAR_MAP;
    public static final int MODE_DIGIT = 2;
    public static final int MODE_LOWER = 1;
    public static final int MODE_MIXED = 3;
    public static final int MODE_PUNCT = 4;
    public static final int MODE_UPPER = 0;
    public static final int[][] SHIFT_TABLE;
    public final byte[] text;
    public static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    public static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, RecyclerView.c0.FLAG_TMP_DETACHED);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            CHAR_MAP[0][i2] = (i2 - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            CHAR_MAP[1][i3] = (i3 - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            CHAR_MAP[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = CHAR_MAP;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            CHAR_MAP[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                CHAR_MAP[4][iArr4[i6]] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        SHIFT_TABLE = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    public static Collection<State> simplifyStates(Iterable<State> iterable) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    z = false;
                    break;
                }
                if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i2, Collection<State> collection) {
        char c2 = (char) (this.text[i2] & ThreadUtils.TYPE_SINGLE);
        boolean z = CHAR_MAP[state.getMode()][c2] > 0;
        State state2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = CHAR_MAP[i3][c2];
            if (i4 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i2);
                }
                if (!z || i3 == state.getMode() || i3 == 2) {
                    collection.add(state2.latchAndAppend(i3, i4));
                }
                if (!z && SHIFT_TABLE[state.getMode()][i3] >= 0) {
                    collection.add(state2.shiftAndAppend(i3, i4));
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c2] == 0) {
            collection.add(state.addBinaryShiftChar(i2));
        }
    }

    public static void updateStateForPair(State state, int i2, int i3, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i2);
        collection.add(endBinaryShift.latchAndAppend(4, i3));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i3).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i2).addBinaryShiftChar(i2 + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<State> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForChar(it.next(), i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    public static Collection<State> updateStateListForPair(Iterable<State> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator<State> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForPair(it.next(), i2, i3, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.common.BitArray encode() {
        /*
            r8 = this;
            com.google.zxing.aztec.encoder.State r0 = com.google.zxing.aztec.encoder.State.INITIAL_STATE
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L8:
            byte[] r3 = r8.text
            int r4 = r3.length
            if (r2 < r4) goto L1f
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.aztec.encoder.State r0 = (com.google.zxing.aztec.encoder.State) r0
            byte[] r1 = r8.text
            com.google.zxing.common.BitArray r0 = r0.toBitArray(r1)
            return r0
        L1f:
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L27
            r3 = r3[r4]
            goto L28
        L27:
            r3 = 0
        L28:
            byte[] r5 = r8.text
            r5 = r5[r2]
            r6 = 13
            if (r5 == r6) goto L4c
            r6 = 44
            r7 = 32
            if (r5 == r6) goto L48
            r6 = 46
            if (r5 == r6) goto L44
            r6 = 58
            if (r5 == r6) goto L40
        L3e:
            r3 = 0
            goto L51
        L40:
            if (r3 != r7) goto L3e
            r3 = 5
            goto L51
        L44:
            if (r3 != r7) goto L3e
            r3 = 3
            goto L51
        L48:
            if (r3 != r7) goto L3e
            r3 = 4
            goto L51
        L4c:
            r5 = 10
            if (r3 != r5) goto L3e
            r3 = 2
        L51:
            if (r3 <= 0) goto L59
            java.util.Collection r0 = updateStateListForPair(r0, r2, r3)
            r2 = r4
            goto L5d
        L59:
            java.util.Collection r0 = r8.updateStateListForChar(r0, r2)
        L5d:
            int r2 = r2 + 1
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.encode():com.google.zxing.common.BitArray");
    }
}
