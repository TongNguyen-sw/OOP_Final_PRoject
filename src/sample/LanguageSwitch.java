package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LanguageSwitch {
    @FXML
    Button returnButton1;

    @FXML
    private void backButtonClicked1() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../sample/MainMenu.fxml"));
        Stage dialog = (Stage) returnButton1.getScene().getWindow();
        Parent root1 = dialog.getOwner().getScene().getRoot();
        root1.setEffect(null);
        Window root2 = dialog.getOwner();
        root2.getScene().setRoot(root);
        dialog.close();
    }

    @FXML
    public void btnVI(ActionEvent event){

    }

    @FXML
    public void btnEN(ActionEvent event){

    }


}
