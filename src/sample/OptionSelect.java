package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class OptionSelect {
    @FXML
    Button playagain;

    @FXML
    Button quit;

    public void playAgainClicked(ActionEvent actionEvent) throws IOException {
//        Stage dialog = (Stage) playagain.getScene().getWindow();
//        Parent root = dialog.getOwner().getScene().getRoot();
//        root.setEffect(null);
//
//        dialog.close();
    }

    public void quitClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../sample/MainMenu.fxml"));
        Stage dialog = (Stage) quit.getScene().getWindow();
        Parent root1 = dialog.getOwner().getScene().getRoot();
        root1.setEffect(null);
        Window root2 = dialog.getOwner();
        root2.getScene().setRoot(root);
        dialog.close();

    }
}