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
    private String[] playerResult = new String[4];
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
    private Text rollDiceAgainNoti;

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


        if(i < 4){
            rotatedDice1();
            playerText.setText("Player " + player[i]);

        }

        String diceStringResult = "";
        diceStringResult += (char)(diceResult+48);

        if (i == 0){
            playerResult[i] = diceStringResult;
            yellowResult.setText(diceStringResult);
            i++;
        } else if (i == 1){
            for (int j = 0; j < i; j++) {
                if (diceStringResult.equals(playerResult[j])){
                    //rollDiceAgainNoti.setText("Roll Dice Again");
                    break;
                } else {
                    if (j == i- 1){
                        rollDiceAgainNoti.setText(" ");
                        playerResult[i] = diceStringResult;
                        greenResult.setText(diceStringResult);
                        i++;
                    }
                }
            }
        } else if (i == 2){
            for (int j = 0; j < i; j++) {
                if (diceStringResult.equals(playerResult[j])){
                    //rollDiceAgainNoti.setText("Roll Dice Again");
                    break;
                } else {
                    if (j == i- 1){
                        rollDiceAgainNoti.setText(" ");
                        playerResult[i] = diceStringResult;
                        blueResult.setText(diceStringResult);
                        i++;
                    }
                }
            }
        } else if (i == 3){
            for (int j = 0; j < i; j++) {
                if (diceStringResult.equals(playerResult[j])){
                    //rollDiceAgainNoti.setText("Roll Dice Again");
                    break;
                } else {
                    if (j == i- 1){
                        rollDiceAgainNoti.setText(" ");
                        playerResult[i] = diceStringResult;
                        redResult.setText(diceStringResult);
                        i++;
                    }
                }
            }
        }
    }

    @FXML
    void setNameClicked(ActionEvent event){
        yellowNameText.setText(yellowName.getText());
        greenNameText.setText(greenName.getText());
        blueNameText.setText(blueName.getText());
        redNameText.setText(redName.getText());
    }

    private int diceResult;
    private RollDices dice1 = new RollDices();

    private void rotatedDice1(){
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
