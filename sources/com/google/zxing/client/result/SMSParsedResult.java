package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class SMSParsedResult extends ParsedResult {
    public final String body;
    public final String[] numbers;
    public final String subject;
    public final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSMSURI() {
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z = true;
        for (int i2 = 0; i2 < this.numbers.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.numbers[i2]);
            String[] strArr = this.vias;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.vias[i2]);
            }
        }
        boolean z2 = this.body != null;
        boolean z3 = this.subject != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (z3) {
                if (z2) {
                    sb.append('&');
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
