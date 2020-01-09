package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameMode {

    @FXML
    Button returnButton;
    @FXML
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    
    private int numberPlayers=0;
    
    @FXML
    private void backButtonClicked() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../sample/MainMenu.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    public void startGameClicked(ActionEvent actionEvent) throws IOException {
    	Main.currentStage.setUserData(numberPlayers);
        Parent root = FXMLLoader.load(getClass().getResource("../sample/PlayTurn.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root, 970, 720));
    }

    public void checkBox1Clicked(){
         if (checkBox1.isSelected()){
        	numberPlayers=0;
            checkBox2.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
         }else if (!checkBox1.isSelected()){
             checkBox2.setDisable(false);
             checkBox3.setDisable(false);
             checkBox4.setDisable(false);
             checkBox5.setDisable(false);
         }
    }
    public void checkBox2Clicked(){
        if (checkBox2.isSelected()){
        	numberPlayers=1;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
        }else if (!checkBox2.isSelected()){
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox4.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox3Clicked(){
        if (checkBox3.isSelected()){
        	numberPlayers=2;
            checkBox1.setDisable(true);
            checkBox2.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
        }else if (!checkBox3.isSelected()){
            checkBox1.setDisable(false);
            checkBox2.setDisable(false);
            checkBox4.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox4Clicked(){
        if (checkBox4.isSelected()){
        	numberPlayers=3;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox2.setDisable(true);
            checkBox5.setDisable(true);
        }else if (!checkBox4.isSelected()){
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox2.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox5Clicked(){
        if (checkBox5.isSelected()){
        	numberPlayers=4;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox2.setDisable(true);
        }else if (!checkBox5.isSelected()){
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox4.setDisable(false);
            checkBox2.setDisable(false);
        }
    }

}
