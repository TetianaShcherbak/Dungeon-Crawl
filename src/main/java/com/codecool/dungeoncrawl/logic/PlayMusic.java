package com.codecool.dungeoncrawl.logic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class PlayMusic {

    public static void playMusic(String link) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File(link);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
//        clip.stop();
//        clip.setMicrosecondPosition(0);
//        clip.close();
    }
}