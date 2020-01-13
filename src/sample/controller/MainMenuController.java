package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainMenuController {
    @FXML
    Button play, exit;
    @FXML
    AnchorPane mainMenu;

    public void playClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/GameMode.fxml"));
        Stage stage = (Stage) play.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    public void onlineClicked(ActionEvent actionEvent) {
    }

    public void languageClicked(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit.getScene().getWindow();
        GaussianBlur blur = new GaussianBlur(3);
        mainMenu.setEffect(blur);
        Parent root = FXMLLoader.load(getClass().getResource("../views/LanguageSwitch.fxml"));
        Stage dialog = new Stage();
        Scene scene = new Scene(root,384.0,133.0);
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

    public void exitClicked(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit.getScene().getWindow();
        GaussianBlur blur = new GaussianBlur(3);
        mainMenu.setEffect(blur);
        Parent root = FXMLLoader.load(getClass().getResource("../views/ExitConfirm.fxml"));
        Stage dialog = new Stage();
        dialog.setTitle("Exit");
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

