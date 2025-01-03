package com.shix.shixipc.utils;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AACHelper {
    public static Map<Integer, Integer> samplingFrequencyIndexMap;
    public FileInputStream mFileInputStream;
    public AdtsHeader mAdtsHeader = new AdtsHeader();
    public BitReader mHeaderBitReader = new BitReader(new byte[7]);
    public byte[] mSkipTwoBytes = new byte[2];
    public byte[] mBytes = new byte[1024];

    public class AdtsHeader {
        public int bufferFullness;
        public int channelconfig;
        public int copyrightStart;
        public int copyrightedStream;
        public int frameLength;
        public int home;
        public int layer;
        public int mpegVersion;
        public int numAacFramesPerAdtsFrame;
        public int original;
        public int profile;
        public int protectionAbsent;
        public int sampleFrequencyIndex;
        public int sampleRate;

        public AdtsHeader() {
        }

        public int getSize() {
            return (this.protectionAbsent == 0 ? 2 : 0) + 7;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        samplingFrequencyIndexMap = hashMap;
        hashMap.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(48000, 3);
        samplingFrequencyIndexMap.put(44100, 4);
        samplingFrequencyIndexMap.put(32000, 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(16000, 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(11025, 10);
        samplingFrequencyIndexMap.put(Integer.valueOf(MyAudioPlayer.KEY_SAMPLE_RATE), 11);
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, Integer.valueOf(MyAudioPlayer.KEY_SAMPLE_RATE));
    }

    public AACHelper(String str) throws FileNotFoundException {
        this.mFileInputStream = new FileInputStream(str);
    }

    public int getSample(ByteBuffer byteBuffer) throws IOException {
        if (!readADTSHeader(this.mAdtsHeader, this.mFileInputStream)) {
            return -1;
        }
        FileInputStream fileInputStream = this.mFileInputStream;
        byte[] bArr = this.mBytes;
        AdtsHeader adtsHeader = this.mAdtsHeader;
        int read = fileInputStream.read(bArr, 0, adtsHeader.frameLength - adtsHeader.getSize());
        byteBuffer.clear();
        byteBuffer.put(this.mBytes, 0, read);
        byteBuffer.position(0);
        byteBuffer.limit(read);
        return read;
    }

    public boolean readADTSHeader(AdtsHeader adtsHeader, FileInputStream fileInputStream) throws IOException {
        if (fileInputStream.read(this.mHeaderBitReader.buffer) < 7) {
            return false;
        }
        BitReader bitReader = this.mHeaderBitReader;
        bitReader.position = 0;
        if (bitReader.readBits(12) != 4095) {
            throw new IOException("Expected Start Word 0xfff");
        }
        adtsHeader.mpegVersion = this.mHeaderBitReader.readBits(1);
        adtsHeader.layer = this.mHeaderBitReader.readBits(2);
        adtsHeader.protectionAbsent = this.mHeaderBitReader.readBits(1);
        adtsHeader.profile = this.mHeaderBitReader.readBits(2) + 1;
        int readBits = this.mHeaderBitReader.readBits(4);
        adtsHeader.sampleFrequencyIndex = readBits;
        adtsHeader.sampleRate = samplingFrequencyIndexMap.get(Integer.valueOf(readBits)).intValue();
        this.mHeaderBitReader.readBits(1);
        adtsHeader.channelconfig = this.mHeaderBitReader.readBits(3);
        adtsHeader.original = this.mHeaderBitReader.readBits(1);
        adtsHeader.home = this.mHeaderBitReader.readBits(1);
        adtsHeader.copyrightedStream = this.mHeaderBitReader.readBits(1);
        adtsHeader.copyrightStart = this.mHeaderBitReader.readBits(1);
        adtsHeader.frameLength = this.mHeaderBitReader.readBits(13);
        adtsHeader.bufferFullness = this.mHeaderBitReader.readBits(11);
        adtsHeader.numAacFramesPerAdtsFrame = this.mHeaderBitReader.readBits(2) + 1;
        MyLogUtils.d("readADTSHeader", "mpegVersion" + adtsHeader.mpegVersion + "\nlayer" + adtsHeader.layer + "\nprotectionAbsent" + adtsHeader.protectionAbsent + "\nprofile" + adtsHeader.profile + "\nsampleFrequencyIndex" + adtsHeader.sampleFrequencyIndex + "\nsampleRate" + adtsHeader.sampleRate + "\nchannelconfig" + adtsHeader.channelconfig + "\noriginal" + adtsHeader.original + "\nhome" + adtsHeader.home + "\nframeLength" + adtsHeader.frameLength + OSSUtils.NEW_LINE);
        if (adtsHeader.numAacFramesPerAdtsFrame != 1) {
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        if (adtsHeader.protectionAbsent == 0) {
            fileInputStream.read(this.mSkipTwoBytes);
        }
        return true;
    }

    public void release() throws IOException {
        this.mFileInputStream.close();
    }
}
