package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class URIResultParser extends ResultParser {
    public static final Pattern ALLOWED_URI_CHARS_PATTERN = Pattern.compile("[-._~:/?#\\[\\]@!$&'()*+,;=%A-Za-z0-9]+");
    public static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    public static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    public static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean isBasicallyValidURI(String str) {
        if (str.contains(LogUtils.PLACEHOLDER)) {
            return false;
        }
        Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    public static boolean isPossiblyMaliciousURI(String str) {
        return !ALLOWED_URI_CHARS_PATTERN.matcher(str).matches() || USER_IN_HOST.matcher(str).find();
    }

    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new URIParsedResult(massagedText.substring(4).trim(), null);
        }
        String trim = massagedText.trim();
        if (!isBasicallyValidURI(trim) || isPossiblyMaliciousURI(trim)) {
            return null;
        }
        return new URIParsedResult(trim, null);
    }
}
