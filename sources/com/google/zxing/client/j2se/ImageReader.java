package com.google.zxing.client.j2se;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;

/* loaded from: classes.dex */
public final class ImageReader {
    public static final String BASE64TOKEN = "base64,";

    public static BufferedImage readDataURIImage(URI uri) throws IOException {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (!schemeSpecificPart.startsWith("image/")) {
            throw new IOException("Unsupported data URI MIME type");
        }
        int indexOf = schemeSpecificPart.indexOf(BASE64TOKEN);
        if (indexOf < 0) {
            throw new IOException("Unsupported data URI encoding");
        }
        return ImageIO.read(new ByteArrayInputStream(Base64Decoder.getInstance().decode(schemeSpecificPart.substring(indexOf + 7))));
    }

    public static BufferedImage readImage(URI uri) throws IOException {
        if (JThirdPlatFormInterface.KEY_DATA.equals(uri.getScheme())) {
            return readDataURIImage(uri);
        }
        try {
            BufferedImage read = ImageIO.read(uri.toURL());
            if (read != null) {
                return read;
            }
            throw new IOException("Could not load " + uri);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Resource not found: " + uri, e2);
        }
    }
}
