package sample;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class GamePlay {

    @FXML
    Button stop;
    @FXML
    ImageView dice1;
    @FXML
    ImageView dice2;
    @FXML
    Button rolldice;
    @FXML
    ImageView value1;
    @FXML
    ImageView value2;
    @FXML
    SplitPane gamePlay;
    @FXML
    Button chooseBoth;

    RollDices d1 = new RollDices();
    RollDices d2 = new RollDices();
    Sound sound = new Sound();
    private int finalValue;
    private boolean chooseValue1 = true;
    private boolean chooseValue2 = true;
    private boolean chooseBothValue = true;

    public void initialize(){
        dice1.setImage(new Image("file:src/Image/" + d1.Rolldice() + ".png"));
        dice2.setImage(new Image("file:src/Image/" + d2.Rolldice() + ".png"));
        chooseBoth.setDisable(true);
    }


    public void getValueDice1(){
        if (chooseValue1){
            BoxBlur boxblur = new BoxBlur();
            value1.setEffect(boxblur);
            finalValue += d1.getValue();
            chooseValue1 = false;
            System.out.println(finalValue);
        } else {
            ColorAdjust colorAdjust = new ColorAdjust();
            value1.setEffect(colorAdjust);
            finalValue -= d1.getValue();
            chooseValue1 = true;
        }
    }

    public void getValueDice2(){
        if (chooseValue2){
            BoxBlur boxblur = new BoxBlur();
            value2.setEffect(boxblur);
            finalValue += d2.getValue();
            System.out.println(finalValue);
            chooseValue2 = false;
        } else {
            ColorAdjust colorAdjust = new ColorAdjust();
            value2.setEffect(colorAdjust);
            finalValue -= d2.getValue();
            chooseValue2 = true;
        }
    }

    public void getBothValue(){
        if (chooseBothValue){
            finalValue = 0;
            chooseValue1 = false;
            chooseValue2 = false;
            BoxBlur boxblur = new BoxBlur();
            value2.setEffect(boxblur);
            value1.setEffect(boxblur);
            finalValue = d1.getValue() + d2.getValue();
            System.out.println(finalValue);
            chooseBothValue = false;
        }else {
            finalValue = 0;
            ColorAdjust colorAdjust = new ColorAdjust();
            value2.setEffect(colorAdjust);
            value1.setEffect(colorAdjust);
            chooseBothValue=true;
            chooseValue1 = true;
            chooseValue2 = true;
        }
    }

    public void rotatedDice1() {
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(0.5), dice1);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setOnFinished(actionEvent -> {
            dice1.setImage(new Image("file:src/Image/" + d1.Rolldice() + ".png"));
            value1.setImage(new Image("file:src/Image/" + d1.getValue() + ".png"));
        });
        rt.play();
    }

    public void rotatedDice2() {
        RotateTransition rt = new RotateTransition(Duration.seconds(0.5), dice2);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setOnFinished(actionEvent -> {
            dice2.setImage(new Image("file:src/Image/" + d2.Rolldice() + ".png"));
            value2.setImage(new Image("file:src/Image/" + d2.getValue() + ".png"));
            sound.stopDiceSound();
        });
        rt.play();
    }

    public void clickedRoll(ActionEvent event){
        finalValue = 0;
        chooseBoth.setDisable(false);
        sound.playDiceSound();
        rotatedDice1();
        rotatedDice2();
    }

    public void stopClicked(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) stop.getScene().getWindow();
        GaussianBlur blur = new GaussianBlur(3);
        gamePlay.setEffect(blur);

        Parent root = FXMLLoader.load(getClass().getResource("OptionSelect.fxml"));
        Stage dialog = new Stage();

        Scene scene = new Scene(root,425,200);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.setResizable(false);

        double centerXPosition = primaryStage.getX() + primaryStage.getWidth()/2d;
        double centerYPosition = primaryStage.getY() + primaryStage.getHeight()/2d;

        dialog.setOnShowing(event -> dialog.hide());

        dialog.setOnShown(event -> {
            dialog.setX(centerXPosition - dialog.getWidth()/2d);
            dialog.setY(centerYPosition - dialog.getHeight()/2d);
            dialog.show();
        });
        dialog.show();

    }

}


