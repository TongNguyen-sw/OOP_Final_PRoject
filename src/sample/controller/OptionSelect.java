package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class OptionSelect {
    @FXML
    Button playAgain;

    @FXML
    Button quit;

    @FXML
    Button returnButton2;


    @FXML
    private void backButtonClicked1() throws IOException {
        Stage dialog = (Stage) returnButton2.getScene().getWindow();
        Parent root = dialog.getOwner().getScene().getRoot();
        root.setEffect(null);

        dialog.close();
    }

    public void playAgainClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/MainMenu.fxml"));
        Stage dialog = (Stage) playAgain.getScene().getWindow();
        Parent root1 = dialog.getOwner().getScene().getRoot();
        root1.setEffect(null);
        Window root2 = dialog.getOwner();
        root2.getScene().setRoot(root);
        dialog.close();

    }

    public void quitClicked(ActionEvent actionEvent) throws IOException {
        Platform.exit();

    }
}