package com.shix.shixipc.utils;

import android.media.AudioTrack;

/* loaded from: classes.dex */
public class AudioPlayer {
    public CustomBuffer audioBuffer;
    public boolean bAudioPlaying = false;
    public Thread audioThread = null;
    public AudioTrack m_AudioTrack = null;

    public class AudioPlayThread implements Runnable {
        public AudioPlayThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AudioPlayer.this.initAudioDev()) {
                MyLogUtils.d("tag", "��ʼ��audioTrackʧ��");
                return;
            }
            while (AudioPlayer.this.bAudioPlaying) {
                CustomBufferData RemoveData = AudioPlayer.this.audioBuffer.RemoveData();
                if (RemoveData == null) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception unused) {
                        AudioPlayer.this.m_AudioTrack.stop();
                        return;
                    }
                } else {
                    AudioTrack audioTrack = AudioPlayer.this.m_AudioTrack;
                    byte[] bArr = RemoveData.data;
                    audioTrack.write(bArr, 0, bArr.length);
                }
            }
            MyLogUtils.d("tag", "stop/release Audio");
            AudioPlayer.this.m_AudioTrack.stop();
            AudioPlayer.this.m_AudioTrack.release();
            AudioPlayer.this.m_AudioTrack = null;
        }
    }

    public AudioPlayer(CustomBuffer customBuffer) {
        this.audioBuffer = null;
        this.audioBuffer = customBuffer;
    }

    public boolean AudioPlayStart() {
        synchronized (this) {
            if (this.bAudioPlaying) {
                return true;
            }
            this.bAudioPlaying = true;
            Thread thread = new Thread(new AudioPlayThread());
            this.audioThread = thread;
            thread.start();
            return true;
        }
    }

    public void AudioPlayStop() {
        synchronized (this) {
            if (this.bAudioPlaying && this.audioThread != null) {
                this.bAudioPlaying = false;
                try {
                    this.audioThread.join();
                } catch (Exception unused) {
                }
                this.audioThread = null;
            }
        }
    }

    public boolean initAudioDev() {
        MyLogUtils.d("tag", "��ʼ��AudioTrack");
        int minBufferSize = AudioTrack.getMinBufferSize(MyAudioPlayer.KEY_SAMPLE_RATE, 2, 2);
        System.out.println("--audio, mMinBufSize=" + minBufferSize);
        if (minBufferSize != -2 && minBufferSize != -1) {
            try {
                AudioTrack audioTrack = new AudioTrack(3, MyAudioPlayer.KEY_SAMPLE_RATE, 2, 2, minBufferSize * 2, 1);
                this.m_AudioTrack = audioTrack;
                audioTrack.play();
                return true;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean isAudioPlaying() {
        return this.bAudioPlaying;
    }
}
