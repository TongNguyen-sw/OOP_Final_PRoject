package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitComfirm {
    @FXML
    Button yes,no;

    public void yesClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void noClicked(ActionEvent actionEvent) {
        Stage dialog = (Stage) no.getScene().getWindow();
        Parent root = dialog.getOwner().getScene().getRoot();
        root.setEffect(null);

        dialog.close();
    }
}
