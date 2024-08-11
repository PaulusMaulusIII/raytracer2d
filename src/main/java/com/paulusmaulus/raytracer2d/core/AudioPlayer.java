package com.paulusmaulus.raytracer2d.core;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import com.paulusmaulus.raytracer2d.utils.res.Audio;

public class AudioPlayer implements LineListener {

    boolean isPlaybackCompleted;

    public void play(Audio audio) {
        try {
            // Load the audio file as a Clip
            File audioFile = new File(audio.getPath());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.addLineListener(this);
            audioClip.open(audioStream);

            // Start playing the audio
            audioClip.start();
            System.out.println("Playing: " + audio.getName());

            // Wait for the playback to complete
            while (!isPlaybackCompleted) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Close resources
            audioClip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            isPlaybackCompleted = false;
            System.out.println("Playback started.");
        } else if (LineEvent.Type.STOP == event.getType()) {
            isPlaybackCompleted = true;
            System.out.println("Playback completed.");
        }
    }
}
