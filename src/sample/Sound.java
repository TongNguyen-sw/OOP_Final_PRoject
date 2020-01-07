package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    Media dice = new Media(new File("src//sample//sound//dice.mp3").toURI().toString());
    MediaPlayer diceSound = new MediaPlayer(dice);
    Media kick = new Media(new File("src//sample//sound//kick.mp3").toURI().toString());
    MediaPlayer kickSound = new MediaPlayer(kick);
    Media goCage = new Media(new File("src//sample//sound//gocage.mp3").toURI().toString());
    MediaPlayer goCageSound = new MediaPlayer(goCage);
    Media move = new Media(new File("src//sample//sound//move.mp3").toURI().toString());
    MediaPlayer moveSound = new MediaPlayer(move);
    Media outNest = new Media(new File("src//sample//sound//outnest.mp3").toURI().toString());
    MediaPlayer outNestSound = new MediaPlayer(outNest);

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
    }

    void stopOutNestSound(){
        outNestSound.stop();
    }
}
