package sample.controller;

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
import sample.controller.RollDices;
import sample.controller.Sound;
import sample.Main;

import java.io.IOException;
import java.util.*;

public class PlayTurn {
    private String[] player = {"Yellow" , "Green", "Blue", "Red"};
    public String[] playerResult = new String[4];
    private int i = 0;
    private int firstPlayer = 0;
    private int maxDiceValue = 0;
    private int numberPlayer = 0;
    private Sound sound = new Sound();
    private Locale locale;

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
    private Text yellowChart;

    @FXML
    private Text greenChart;

    @FXML
    private Text blueChart;

    @FXML
    private Text redChart;

    @FXML
    private Text rollDiceAgainNoti;

    @FXML
    private Text playWarning;

    @FXML
    private Button setAllName;

    @FXML
    private Button PlayButton;

    @FXML
    void PlayButtonClicked(ActionEvent event) throws IOException {
        if (i == 4){
            Main.currentStage.setUserData(setUserData());
            Parent root = FXMLLoader.load(getClass().getResource("../views/GamePlay.fxml"));
            Stage stage = (Stage) PlayButton.getScene().getWindow();
            stage.setScene(new Scene(root, 970, 720));
        } else {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    playWarning.setText("");
                }
            } ;
            playWarning.setText("Cannot move on to play until all player roll dice");
            timer.schedule(timerTask, 3000);
        }
    }
    public static class UserData{
        String playerNames[];
        int firstPlayer;
        int numberPlayers;
        public String[] getPlayerNames() {
            return playerNames;
        }
        public void setPlayerNames(String[] playerNames) {
            this.playerNames = playerNames;
        }
        public int getFirstPlayer() {
            return firstPlayer;
        }
        public void setFirstPlayer(int firstPlayer) {
            this.firstPlayer = firstPlayer;
        }
        public int getNumberPlayers() {
            return numberPlayers;
        }
        public void setNumberPlayers(int numberPlayers) {
            this.numberPlayers = numberPlayers;
        }
        public UserData(String[] playerNames, int firstPlayer, int numberPlayers) {
            super();
            this.playerNames = playerNames;
            this.firstPlayer = firstPlayer;
            this.numberPlayers = numberPlayers;
        }
        public UserData() {
            super();
            // TODO Auto-generated constructor stub
        }

    }

    private UserData setUserData() {
        UserData userData=new UserData();
        String playerNames[]=new String[4];
        playerNames[0]=yellowChart.getText();
        playerNames[1]=blueChart.getText();
        playerNames[2]=redChart.getText();
        playerNames[3]=greenChart.getText();
        userData.setPlayerNames(playerNames);
        userData.setFirstPlayer(firstPlayer);
        userData.setNumberPlayers(numberPlayer);
        return userData;
    }

    @FXML
    void rollDiceClicked(ActionEvent event) {
        if(i < 4){

            sound.playDiceSound();
            rotatedDice1();
            if(maxDiceValue<diceResult) {
                firstPlayer=i;
                maxDiceValue=diceResult;
            }
            System.out.println(firstPlayer);
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
                        blueResult.setText(diceStringResult);
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
                        redResult.setText(diceStringResult);
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
                        greenResult.setText(diceStringResult);
                        i++;
                    }
                }
            }
        }
    }

    @FXML
    void setNameClicked(ActionEvent event){
        yellowNameText.setText(yellowName.getText());
        if (yellowName.getText().equals("")){ yellowChart.setText("Player 1");  }
        else { yellowChart.setText(yellowName.getText()); }
        blueNameText.setText(blueName.getText());
        if (blueName.getText().equals("")) {blueChart.setText("Player 2"); }
        else { blueChart.setText(blueName.getText());  }
        greenNameText.setText(greenName.getText());
        redNameText.setText(redName.getText());
        if (redName.getText().equals("")){ redChart.setText("Player 3"); }
        else { redChart.setText(redName.getText());  }
        if (greenName.getText().equals("")){ greenChart.setText("Player 4");  }
        else { greenChart.setText(greenName.getText());  }



    }

    private int diceResult;
    private RollDices dice1 = new RollDices();

    public void initialize(){
        dice.setImage(new Image("file:src/Image/" + dice1.Rolldice() + ".png"));
        numberPlayer=(int)Main.currentStage.getUserData();
        String lang = MainMenuController.langSet;
        loadLang(lang);
    }

    private void rotatedDice1(){
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(0.5),dice);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        diceResult = dice1.Rolldice();
        rt.setOnFinished(actionEvent -> {
            dice.setImage(new Image("file:src/Image/" + diceResult + ".png"));
            sound.stopDiceSound();
        });
        rt.play();
    }

    public void loadLang(String lang){
        locale = new Locale(lang);
        ResourceBundle bundle = ResourceBundle.getBundle("sample.lang", locale);
        rollDice.setText(bundle.getString("rollDice"));
        PlayButton.setText(bundle.getString("play"));
        setAllName.setText(bundle.getString("setAllNames"));
//        yellowNameText.setText(bundle.getString("yellow"));
//        yellowChart.setText(bundle.getString("yellow"));
//        greenNameText.setText(bundle.getString("green"));
//        greenChart.setText(bundle.getString("green"));
//        blueNameText.setText(bundle.getString("blue"));
//        blueChart.setText(bundle.getString("blue"));
//        redNameText.setText(bundle.getString("red"));
//        redChart.setText(bundle.getString("red"));
//        yellowResult.setText("result");
//        greenResult.setText("result");
//        blueResult.setText("result");
//        redResult.setText("result");
    }
}
