package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameMode {

    @FXML
    Button returnButton;
    @FXML
    private void backButtonClicked() throws IOException {
//        mediaPlayer.seek(Duration.ZERO);
//        mediaPlayer.setVolume(0.3f);
//        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("../sample/MainMenu.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.getScene().setRoot(root);

    }

    public void startGameClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../sample/PlayTurn.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root, 970, 720));
    }
}
