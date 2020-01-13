package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameMode {

    @FXML
    Button returnButton, startGame;
    @FXML
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    @FXML
    Text explanation;

    private int numberPlayers = 0;
    private Locale locale;
    String lang = MainMenuController.langSet;

    @FXML
    private void backButtonClicked() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/MainMenu.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    public void startGameClicked(ActionEvent actionEvent) throws IOException {
        Main.currentStage.setUserData(numberPlayers);
        Parent root = FXMLLoader.load(getClass().getResource("../views/PlayTurn.fxml"));
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root, 970, 720));
    }

    public void initialize() {
        startGame.setDisable(true);
        loadLang(lang);

    }

    public void checkBox1Clicked() {
        if (checkBox1.isSelected()) {
            numberPlayers = 0;
            startGame.setDisable(false);
            checkBox2.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
        } else if (!checkBox1.isSelected()) {
            startGame.setDisable(true);
            checkBox2.setDisable(false);
            checkBox3.setDisable(false);
            checkBox4.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox2Clicked() {
        if (checkBox2.isSelected()) {
            startGame.setDisable(false);
            numberPlayers = 1;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
        } else if (!checkBox2.isSelected()) {
            startGame.setDisable(true);
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox4.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox3Clicked() {

        if (checkBox3.isSelected()) {
            startGame.setDisable(false);
            numberPlayers = 2;
            checkBox1.setDisable(true);
            checkBox2.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
        } else if (!checkBox3.isSelected()) {
            startGame.setDisable(true);
            checkBox1.setDisable(false);
            checkBox2.setDisable(false);
            checkBox4.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox4Clicked() {
        if (checkBox4.isSelected()) {
            startGame.setDisable(false);
            numberPlayers = 3;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox2.setDisable(true);
            checkBox5.setDisable(true);
        } else if (!checkBox4.isSelected()) {
            startGame.setDisable(true);
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox2.setDisable(false);
            checkBox5.setDisable(false);
        }
    }

    public void checkBox5Clicked() {
        if (checkBox5.isSelected()) {
            startGame.setDisable(false);
            numberPlayers = 4;
            checkBox1.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox2.setDisable(true);
        } else if (!checkBox5.isSelected()) {
            startGame.setDisable(true);
            checkBox1.setDisable(false);
            checkBox3.setDisable(false);
            checkBox4.setDisable(false);
            checkBox2.setDisable(false);
        }
    }
    public void loadLang(String lang){
        locale = new Locale(lang);
        ResourceBundle bundle = ResourceBundle.getBundle("sample.lang", locale);
        startGame.setText(bundle.getString("play"));
        checkBox1.setText(bundle.getString("check1"));
        checkBox2.setText(bundle.getString("check2"));
        checkBox3.setText(bundle.getString("check3"));
        checkBox4.setText(bundle.getString("check4"));
        checkBox5.setText(bundle.getString("check5"));
        explanation.setText(bundle.getString("exp"));
    }
}
