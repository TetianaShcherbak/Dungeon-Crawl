//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.PlayMusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class App {
    public App() {
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        PlayMusic.playMusic("src/main/resources/music/start.wav");
        PlayerInput.start(args);
    }
}
