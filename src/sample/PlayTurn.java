package sample;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayTurn {
    private String[] player = {"Yellow" , "Green", "Blue", "Red"};
    private String[] playerResult = {};
    private int i = 0;

    @FXML
    private Text playerText;

    @FXML
    private ImageView dice;

    @FXML
    private Button rollDice;

    @FXML
    private Text yellowResult;

    @FXML
    private Text greenResult;

    @FXML
    private Text blueResult;

    @FXML
    private Text redResult;

    @FXML
    private TextField yellowName;

    @FXML
    private TextField greenName;

    @FXML
    private TextField blueName;

    @FXML
    private TextField redName;

    @FXML
    private Text yellowNameText;

    @FXML
    private Text greenNameText;

    @FXML
    private Text blueNameText;

    @FXML
    private Text redNameText;

    @FXML
    private Button setAllName;

    @FXML
    private Button PlayButton;

    @FXML
    void PlayButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../sample/GamePlay.fxml"));
        Stage stage = (Stage) PlayButton.getScene().getWindow();
        stage.setScene(new Scene(root, 970, 720));
    }

    @FXML
    void rollDiceClicked(ActionEvent event) {
        rotatedDice1();
        playerText.setText("Player " + player[i]);

        String diceStringResult = "";
        diceStringResult += (char)(diceResult+48);

        if (i == 0){
            //playerResult[i] = diceStringResult;
            yellowResult.setText(diceStringResult);
        } else if (i == 1){
            greenResult.setText(diceStringResult);
        } else if (i == 2){
            blueResult.setText(diceStringResult);
        } else if (i == 3){
            redResult.setText(diceStringResult);
        }
        i++;
    }

    @FXML
    void setNameClicked(ActionEvent event){
        yellowNameText.setText(yellowName.getText());
        greenNameText.setText(greenName.getText());
        blueNameText.setText(blueName.getText());
        redNameText.setText(redName.getText());
    }

    int diceResult;
    RollDices dice1 = new RollDices();

    public void rotatedDice1(){
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(0.5),dice);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        diceResult = dice1.Rolldice();
        rt.setOnFinished(actionEvent -> {
            dice.setImage(new Image("file:src/Image/" + diceResult + ".png"));
        });
        rt.play();
    }

}
