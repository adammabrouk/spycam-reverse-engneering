package com.google.zxing.client.j2se;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.shix.shixipc.utils.CrashHandler;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;

/* loaded from: classes.dex */
public final class DecodeWorker implements Callable<Integer> {
    public static final int BLACK = -16777216;
    public static final int RED = -65536;
    public static final int WHITE = -1;
    public final DecoderConfig config;
    public final Map<DecodeHintType, ?> hints;
    public final Queue<URI> inputs;

    public DecodeWorker(DecoderConfig decoderConfig, Queue<URI> queue) {
        this.config = decoderConfig;
        this.inputs = queue;
        this.hints = decoderConfig.buildHints();
    }

    public static Path buildOutputPath(URI uri, String str) throws IOException {
        Path realPath;
        String str2;
        String str3;
        if ("file".equals(uri.getScheme())) {
            Path path = Paths.get(uri);
            realPath = path.getParent();
            str2 = path.getFileName().toString();
        } else {
            realPath = Paths.get(".", new String[0]).toRealPath(new LinkOption[0]);
            String path2 = uri.getPath();
            if (path2 == null) {
                str2 = "input";
            } else {
                str2 = path2.split("/")[r4.length - 1];
            }
        }
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str3 = String.valueOf(str2.substring(0, lastIndexOf)) + str;
        } else {
            str3 = String.valueOf(str2) + str;
        }
        return realPath.resolve(str3);
    }

    private Result[] decode(URI uri, Map<DecodeHintType, ?> map) throws IOException {
        BufferedImage readImage = ImageReader.readImage(uri);
        List<Integer> list = this.config.crop;
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(list == null ? new BufferedImageLuminanceSource(readImage) : new BufferedImageLuminanceSource(readImage, list.get(0).intValue(), list.get(1).intValue(), list.get(2).intValue(), list.get(3).intValue())));
        if (this.config.dumpBlackPoint) {
            dumpBlackPoint(uri, readImage, binaryBitmap);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        try {
            Result[] decodeMultiple = this.config.multi ? new GenericMultipleBarcodeReader(multiFormatReader).decodeMultiple(binaryBitmap, map) : new Result[]{multiFormatReader.decode(binaryBitmap, map)};
            if (this.config.brief) {
                System.out.println(uri + ": Success");
            } else {
                StringWriter stringWriter = new StringWriter();
                for (Result result : decodeMultiple) {
                    ParsedResult parseResult = ResultParser.parseResult(result);
                    stringWriter.write(uri + " (format: " + result.getBarcodeFormat() + ", type: " + parseResult.getType() + "):\nRaw result:\n" + result.getText() + OSSUtils.NEW_LINE + "Parsed result:\n" + parseResult.getDisplayResult() + OSSUtils.NEW_LINE);
                    ResultPoint[] resultPoints = result.getResultPoints();
                    int length = resultPoints.length;
                    StringBuilder sb = new StringBuilder("Found ");
                    sb.append(length);
                    sb.append(" result points.\n");
                    stringWriter.write(sb.toString());
                    for (int i2 = 0; i2 < length; i2++) {
                        ResultPoint resultPoint = resultPoints[i2];
                        if (resultPoint != null) {
                            stringWriter.write("  Point " + i2 + ": (" + resultPoint.getX() + ',' + resultPoint.getY() + ')');
                            if (i2 != length - 1) {
                                stringWriter.write(10);
                            }
                        }
                    }
                    stringWriter.write(10);
                }
                System.out.println(stringWriter);
            }
            return decodeMultiple;
        } catch (NotFoundException unused) {
            System.out.println(uri + ": No barcode found");
            return null;
        }
    }

    public static void dumpBlackPoint(URI uri, BufferedImage bufferedImage, BinaryBitmap binaryBitmap) throws IOException {
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        int i2 = width * 3;
        int[] iArr = new int[i2 * height];
        int[] iArr2 = new int[width];
        for (int i3 = 0; i3 < height; i3++) {
            bufferedImage.getRGB(0, i3, width, 1, iArr2, 0, width);
            System.arraycopy(iArr2, 0, iArr, i3 * i2, width);
        }
        BitArray bitArray = new BitArray(width);
        for (int i4 = 0; i4 < height; i4++) {
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i4, bitArray);
                int i5 = (i4 * i2) + width;
                for (int i6 = 0; i6 < width; i6++) {
                    iArr[i5 + i6] = blackRow.get(i6) ? -16777216 : -1;
                }
                bitArray = blackRow;
            } catch (NotFoundException unused) {
                int i7 = (i4 * i2) + width;
                Arrays.fill(iArr, i7, i7 + width, RED);
            }
        }
        for (int i8 = 0; i8 < height; i8++) {
            try {
                BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
                int i9 = (i8 * i2) + (width * 2);
                for (int i10 = 0; i10 < width; i10++) {
                    iArr[i9 + i10] = blackMatrix.get(i10, i8) ? -16777216 : -1;
                }
            } catch (NotFoundException unused2) {
            }
        }
        writeResultImage(i2, height, iArr, uri, ".mono.png");
    }

    public static void dumpResult(URI uri, Result... resultArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (Result result : resultArr) {
            arrayList.add(result.getText());
        }
        Files.write(buildOutputPath(uri, CrashHandler.FILE_NAME_SUFFIX), arrayList, StandardCharsets.UTF_8, new OpenOption[0]);
    }

    public static void writeResultImage(int i2, int i3, int[] iArr, URI uri, String str) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(i2, i3, 2);
        bufferedImage.setRGB(0, 0, i2, i3, iArr, 0, i2);
        Path buildOutputPath = buildOutputPath(uri, str);
        try {
            if (ImageIO.write(bufferedImage, "png", buildOutputPath.toFile())) {
                return;
            }
            System.err.println("Could not encode an image to " + buildOutputPath);
        } catch (IOException unused) {
            System.err.println("Could not write to " + buildOutputPath);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws IOException {
        int i2 = 0;
        while (true) {
            URI poll = this.inputs.poll();
            if (poll == null) {
                return Integer.valueOf(i2);
            }
            Result[] decode = decode(poll, this.hints);
            if (decode != null) {
                i2++;
                if (this.config.dumpResults) {
                    dumpResult(poll, decode);
                }
            }
        }
    }
}
