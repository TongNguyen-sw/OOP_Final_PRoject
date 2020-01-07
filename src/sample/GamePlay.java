package sample;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
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

//    public void quitClicked(ActionEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("../sample/MainMenu.fxml"));
//        Stage stage = (Stage) quit.getScene().getWindow();
//        stage.setScene(new Scene(root,800,600));
//    }
//}

