package com.shix.shixipc.utils;

import android.media.AudioRecord;

/* loaded from: classes.dex */
public class CustomAudioRecorder {
    public AudioRecordResult audioResult;
    public Thread recordThread = null;
    public boolean bRecordThreadRuning = false;
    public int m_in_buf_size = 0;
    public AudioRecord m_in_rec = null;
    public byte[] m_in_bytes = null;

    public interface AudioRecordResult {
        void AudioRecordData(byte[] bArr, int i2);
    }

    public class RecordThread implements Runnable {
        public RecordThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CustomAudioRecorder.this.initRecorder()) {
                CustomAudioRecorder.this.m_in_rec.startRecording();
                while (CustomAudioRecorder.this.bRecordThreadRuning) {
                    int read = CustomAudioRecorder.this.m_in_rec.read(CustomAudioRecorder.this.m_in_bytes, 0, CustomAudioRecorder.this.m_in_buf_size);
                    if (read == 0) {
                        return;
                    }
                    MyLogUtils.d("tag", "read audio");
                    if (CustomAudioRecorder.this.audioResult != null) {
                        CustomAudioRecorder.this.audioResult.AudioRecordData(CustomAudioRecorder.this.m_in_bytes, read);
                    }
                }
                CustomAudioRecorder.this.m_in_rec.stop();
            }
        }
    }

    public CustomAudioRecorder(AudioRecordResult audioRecordResult) {
        this.audioResult = null;
        this.audioResult = audioRecordResult;
        initRecorder();
    }

    public void StartRecord() {
        synchronized (this) {
            MyLogUtils.d("tag", "startRecord");
            if (this.bRecordThreadRuning) {
                MyLogUtils.d("tag", "is startRecord");
                return;
            }
            MyLogUtils.d("tag", "begin startRecord");
            this.bRecordThreadRuning = true;
            Thread thread = new Thread(new RecordThread());
            this.recordThread = thread;
            thread.start();
        }
    }

    public void StopRecord() {
        synchronized (this) {
            if (this.bRecordThreadRuning) {
                this.bRecordThreadRuning = false;
                try {
                    this.recordThread.join();
                    MyLogUtils.d("tag", "stopRecord()");
                } catch (Exception unused) {
                }
            }
        }
    }

    public boolean initRecorder() {
        this.m_in_buf_size = AudioRecord.getMinBufferSize(MyAudioPlayer.KEY_SAMPLE_RATE, 2, 2);
        AudioRecord audioRecord = new AudioRecord(1, MyAudioPlayer.KEY_SAMPLE_RATE, 2, 2, this.m_in_buf_size);
        this.m_in_rec = audioRecord;
        if (audioRecord == null) {
            return false;
        }
        this.m_in_bytes = new byte[this.m_in_buf_size];
        return true;
    }

    public void releaseRecord() {
        MyLogUtils.d("tag", "releaseRecord");
        AudioRecord audioRecord = this.m_in_rec;
        if (audioRecord != null) {
            audioRecord.release();
            this.m_in_rec = null;
        }
    }
}
