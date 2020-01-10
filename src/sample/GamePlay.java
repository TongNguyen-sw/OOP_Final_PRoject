package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sample.PlayTurn.UserData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GamePlay {

    @FXML Button stop;
    @FXML ImageView dice1;
    @FXML ImageView dice2;
    @FXML Button rolldice;
    @FXML ImageView value1;
    @FXML ImageView value2;
    @FXML SplitPane gamePlay;
    @FXML Button chooseBoth;
    @FXML private Label lb_currentplayername;
    @FXML private ImageView yh0, yh1, yh2, yh3, gh0, gh1, gh2, gh3, bh0, bh1, bh2, bh3, rh0, rh1, rh2, rh3;
    @FXML private StackPane c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17
    , c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32
    , c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47;
    @FXML Label lb_player1, lb_player2, lb_player3, lb_player4;
    @FXML Text timerText;

    RollDices d1 = new RollDices();
    RollDices d2 = new RollDices();
    Sound sound = new Sound();
    private int finalValue;
    private boolean chooseValue1 = true;
    private boolean chooseValue2 = true;
    private boolean chooseBothValue = true;
    private Player[] players;
    private int currentPlayer;
    private UserData userData;
    private int numberPlayers;
    private String[] playerNames;
    private List<StackPane> stackPanes;
    private int interval=0;
    private Timeline timeline;
    private MyThread thread;

    public void initialize(){
        dice1.setImage(new Image("file:src/Image/" + d1.Rolldice() + ".png"));
        dice2.setImage(new Image("file:src/Image/" + d2.Rolldice() + ".png"));
        chooseBoth.setDisable(true);
        setupPlayers();
        setupPlayerNames();
        initStackPanes();
        time();
    }


    
    class MyThread extends Thread{
    	
    	Timer timer;
    	int to;
    	Horse horse;
    	public MyThread( int _to, Horse _horse) {
			this.to=_to;
			this.horse=_horse;
			interval=to;
		}
    	
    	@Override
    	public void run() {
    	     timeline= new Timeline(new KeyFrame(Duration.millis(500), ev -> {
    	    	interval--;
    	    	if(interval<0) {
	 	    		increaseCurrentPlayerIndex();
	 	    		rolldice.setDisable(false);
	 	    		lb_currentplayername.setText(playerNames[currentPlayer]);
	 	    		timeline.stop();
	 	    		thread.stop();
	 	    		return;
	         	}
    	    	else {
        	    	this.horse.increasePosition();	
        	    	int horsePosition=this.horse.getPosition();
     	        	StackPane sp=stackPanes.get(horsePosition);
    	    		ImageView imgv=this.horse.getImgHorse();
    	        	sp.getChildren().add(imgv);
    	    	}
    	    }));
    	    timeline.setCycleCount(Animation.INDEFINITE);
    	    timeline.play();
    	}
    }
    
    private void initStackPanes() {
		// TODO Auto-generated method stub
		stackPanes=new ArrayList<StackPane>();
		stackPanes.add(c0);
		stackPanes.add(c1);
		stackPanes.add(c2);
		stackPanes.add(c3);
		stackPanes.add(c4);
		stackPanes.add(c5);
		stackPanes.add(c6);
		stackPanes.add(c7);
		stackPanes.add(c8);
		stackPanes.add(c9);
		stackPanes.add(c10);
		stackPanes.add(c11);
		stackPanes.add(c12);
		stackPanes.add(c13);
		stackPanes.add(c14);
		stackPanes.add(c15);
		stackPanes.add(c16);
		stackPanes.add(c17);
		stackPanes.add(c18);
		stackPanes.add(c19);
		stackPanes.add(c20);
		stackPanes.add(c21);
		stackPanes.add(c22);
		stackPanes.add(c23);
		stackPanes.add(c24);
		stackPanes.add(c25);
		stackPanes.add(c26);
		stackPanes.add(c27);
		stackPanes.add(c28);
		stackPanes.add(c29);
		stackPanes.add(c30);
		stackPanes.add(c31);
		stackPanes.add(c32);
		stackPanes.add(c33);
		stackPanes.add(c34);
		stackPanes.add(c35);
		stackPanes.add(c36);
		stackPanes.add(c37);
		stackPanes.add(c38);
		stackPanes.add(c39);
		stackPanes.add(c40);
		stackPanes.add(c41);
		stackPanes.add(c42);
		stackPanes.add(c43);
		stackPanes.add(c44);
		stackPanes.add(c45);
		stackPanes.add(c46);
		stackPanes.add(c47);
	}

	private void setupPlayerNames() {
		// TODO Auto-generated method stub
    	lb_player1.setText(playerNames[0]);
        lb_player2.setText(playerNames[1]);
        lb_player3.setText(playerNames[2]);
        lb_player4.setText(playerNames[3]);
	}

	//how many players and playernames, which player first, setup specific roll function for player and for machine
	private void setupPlayers() {
		// TODO Auto-generated method stub
    	userData=(UserData) Main.currentStage.getUserData();
    	numberPlayers=userData.getNumberPlayers();
    	playerNames=userData.getPlayerNames();
    	currentPlayer=userData.getFirstPlayer();
    	lb_currentplayername.setText(playerNames[currentPlayer]);
    	players =new Player[4];
		for(int i=0;i<4;i++) {
			if(i<numberPlayers) {
				players[i]=new Player(playerNames[i], false) {
					@Override
					public void rollDices() {
						// TODO Auto-generated method stub
						rotatedDice1();
						rotatedDice2();
						//waiting for player choose what way to go then handler that choice
					}
				};
			}
			else {
				players[i]=new Player(playerNames[i], true) {
					@Override
					public void rollDices() {
						// TODO Auto-generated method stub
						rotatedDice1();
						rotatedDice2();
						//randomchoice and next player rolldice
					}
				};
			}
			switch (i) {
			case 0:{
				players[i].setHorseColor(yh0, yh1, yh2, yh3);
				break;
			}
			case 1:{
				players[i].setHorseColor(gh0, gh1, gh2, gh3);
				break;
			}
			case 2:{
				players[i].setHorseColor(bh0, bh1, bh2, bh3);
				break;
			}
			case 3:{
				players[i].setHorseColor(rh0, rh1, rh2, rh3);
				break;
			}

			default:
				break;
			}
		}
	}


	public void getValueDice1(){
		finalValue = 0;
        if (chooseValue1){
            BoxBlur boxblur = new BoxBlur();
            value1.setEffect(boxblur);
            finalValue = d1.getValue();
            //chooseValue1 = false;
            System.out.println(finalValue);
        } else {
            ColorAdjust colorAdjust = new ColorAdjust();
            value1.setEffect(colorAdjust);
            finalValue -= d1.getValue();
            chooseValue1 = true;
        }
        checkAndGo(finalValue);
    }

	public void getValueDice2(){
    	finalValue = 0;
        if (chooseValue2){
            BoxBlur boxblur = new BoxBlur();
            value2.setEffect(boxblur);
            finalValue = d2.getValue();
            System.out.println(finalValue);
            //chooseValue2 = false;
        } else {
            ColorAdjust colorAdjust = new ColorAdjust();
            value2.setEffect(colorAdjust);
            finalValue -= d2.getValue();
            chooseValue2 = true;
        }
        checkAndGo(finalValue);
    }

    public void getBothValue(){
    	finalValue = 0;
        if (chooseBothValue){
            chooseValue1 = false;
            chooseValue2 = false;
            finalValue = d1.getValue() + d2.getValue();
            System.out.println(finalValue);
            //chooseBothValue = false;
        }else {
            chooseBothValue=true;
            chooseValue1 = true;
            chooseValue2 = true;
        }
        checkAndGo(finalValue);
    }

    public void rotatedDice1() {
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(0.5), dice1);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setOnFinished(actionEvent -> {
            dice1.setImage(new Image("file:src/Image/" + d1.Rolldice() + ".png"));
            value1.setImage(new Image("file:src/Image/" + d1.getValue() + ".png"));
        });
        rt.play();
    }

    public void rotatedDice2() {
        RotateTransition rt = new RotateTransition(Duration.seconds(0.5), dice2);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setOnFinished(actionEvent -> {
            dice2.setImage(new Image("file:src/Image/" + d2.Rolldice() + ".png"));
            value2.setImage(new Image("file:src/Image/" + d2.getValue() + ".png"));
            sound.stopDiceSound();
        });
        rt.play();
    }

    public void clickedRoll(ActionEvent event){
        finalValue = 0;
        chooseBoth.setDisable(false);
        sound.playDiceSound();
        players[currentPlayer].rollDices();
        resetDisableButton(false);
    }

    public void stopClicked(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) stop.getScene().getWindow();
        GaussianBlur blur = new GaussianBlur(3);
        gamePlay.setEffect(blur);

        Parent root = FXMLLoader.load(getClass().getResource("OptionSelect.fxml"));
        Stage dialog = new Stage();

        Scene scene = new Scene(root,425,200);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.setResizable(false);

        double centerXPosition = primaryStage.getX() + primaryStage.getWidth()/2d;
        double centerYPosition = primaryStage.getY() + primaryStage.getHeight()/2d;

        dialog.setOnShowing(event -> dialog.hide());

        dialog.setOnShown(event -> {
            dialog.setX(centerXPosition - dialog.getWidth()/2d);
            dialog.setY(centerYPosition - dialog.getHeight()/2d);
            dialog.show();
        });
        dialog.show();
    }
    
    //block button when roll click or choice one way to go 
    private void resetDisableButton(boolean isSetBoth) {
    	if(isSetBoth) {
    		BoxBlur boxblur = new BoxBlur();
            value2.setEffect(boxblur);
            value1.setEffect(boxblur);
    		value1.setDisable(true);
    		value2.setDisable(true);
    		chooseBoth.setDisable(true);
    		rolldice.setDisable(false);
    	}
    	else {    	
            ColorAdjust colorAdjust = new ColorAdjust();
	        value2.setEffect(colorAdjust);
	        value1.setEffect(colorAdjust);
    		value1.setDisable(false);
    		value2.setDisable(false);
    		chooseBoth.setDisable(false);
    		rolldice.setDisable(true);
    	}
    }

    //check rules and go seahorse
    private void checkAndGo(int finalValue2) {
    	resetDisableButton(true);
    	rolldice.setDisable(true);
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			Horse horse=players[currentPlayer].getHorses()[i];
			if(horse.isFinished()) {
				continue;
			}
			thread=new MyThread(finalValue2, horse);
			thread.start();
			break;
		}
	}
    
    //set index to know what index of players in players is current player
    private void increaseCurrentPlayerIndex() {
    	currentPlayer++;
    	if(currentPlayer>3)
        	currentPlayer=0;
    }

    private int counter = 0;
    Timer timer = new Timer();

    private void time(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    timerText.setText(String.format("%02d:%02d:%02d", counter / 1000 / 60, (counter / 1000) % 60, (counter % 1000) / 10));
                    counter++;
                    time();
                });
            }
        },1);
    }
}


