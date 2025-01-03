package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
public final class ASCIIEncoder implements Encoder {
    public static char encodeASCIIDigits(char c2, char c3) {
        if (HighLevelEncoder.isDigit(c2) && HighLevelEncoder.isDigit(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (lookAheadTest == getEncodingMode()) {
            if (!HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
                return;
            } else {
                encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
                encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                encoderContext.pos++;
                return;
            }
        }
        if (lookAheadTest == 1) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
            encoderContext.signalEncoderChange(1);
            return;
        }
        if (lookAheadTest == 2) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
            encoderContext.signalEncoderChange(2);
            return;
        }
        if (lookAheadTest == 3) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
            encoderContext.signalEncoderChange(3);
        } else if (lookAheadTest == 4) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
            encoderContext.signalEncoderChange(4);
        } else if (lookAheadTest == 5) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
            encoderContext.signalEncoderChange(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + lookAheadTest);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }
}
