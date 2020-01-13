package sample.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    private Media dice = new Media(new File("src//sample//sound//roll.wav").toURI().toString());
    private MediaPlayer diceSound = new MediaPlayer(dice);
    private Media kick = new Media(new File("src//sample//sound//kick.mp3").toURI().toString());
    private MediaPlayer kickSound = new MediaPlayer(kick);
    private Media goCage = new Media(new File("src//sample//sound//gocage.mp3").toURI().toString());
    private MediaPlayer goCageSound = new MediaPlayer(goCage);
    private Media move = new Media(new File("src//sample//sound//run.mp3").toURI().toString());
    private MediaPlayer moveSound = new MediaPlayer(move);
    private Media outNest = new Media(new File("src//sample//sound//horseWhinny.wav").toURI().toString());
    private MediaPlayer outNestSound = new MediaPlayer(outNest);

    void playDiceSound(){
        diceSound.setCycleCount(MediaPlayer.INDEFINITE);
        diceSound.play();
    }

    void stopDiceSound(){
        diceSound.stop();
    }

    void playKickSound(){
        kickSound.setCycleCount(MediaPlayer.INDEFINITE);
        kickSound.play();
    }

    void stopKickSound(){
        kickSound.stop();
    }

    void playGoCageSound(){
        goCageSound.setCycleCount(MediaPlayer.INDEFINITE);
        goCageSound.play();
    }

    void stopGoCageSound(){
        goCageSound.stop();
    }

    void playMoveSound(){
        moveSound.setCycleCount(MediaPlayer.INDEFINITE);
        moveSound.play();
    }

    void stopMoveSound(){
        moveSound.stop();
    }

    void playOutNestSound(){
        outNestSound.setCycleCount(MediaPlayer.INDEFINITE);
        outNestSound.play();
        outNestSound.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                outNestSound.stop();
            }
        });
    }

    void stopOutNestSound(){
        outNestSound.stop();
    }
}
