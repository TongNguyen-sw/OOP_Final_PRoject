package sample.controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sample.controller.PlayTurn.UserData;
import sample.model.Horse;
import sample.Main;
import sample.model.Player;

import java.io.IOException;
import java.util.*;

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
	@FXML Label lb_player1, lb_player2, lb_player3, lb_player4, lb_score_player1, lb_score_player2, lb_score_player3, lb_score_player4;
	@FXML Text timerText;
	@FXML AnchorPane h1, h2, h3, h4;
	@FXML Label status;
	RollDices d1 = new RollDices();
	RollDices d2 = new RollDices();
	Sound sound = new Sound();
	private Locale locale;
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
	private int counter = 0;
	private Horse[] horses;
	private AnchorPane homes[];

	Timer timer = new Timer();
	String lang = MainMenuController.langSet;

	public void initialize(){
		dice1.setImage(new Image("file:src/Image/" + d1.Rolldice() + ".png"));
		dice2.setImage(new Image("file:src/Image/" + d2.Rolldice() + ".png"));
		chooseBoth.setDisable(true);
		setupPlayers();
		initPlayerNames();
		initStackPanes();
		setScore();
		//time();
		initHorseAndHome();
		loadLang(lang);
	}

	private void initHorseAndHome() {
		// TODO Auto-generated method stub
		horses=new Horse[48];
		homes=new AnchorPane[4];
		homes[0]=h1;
		homes[1]=h2;
		homes[2]=h3;
		homes[3]=h4;
	}

	class MyThread extends Thread{
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
					sound.stopMoveSound();
					thread.stop();
					int currentHorseindexInArray=horse.getPosition();
					Horse currentHorse=horses[currentHorseindexInArray];
					if(currentHorse!=null) {
						currentHorse.setPosition(0);
						currentHorse.setOnHouse(true);
						homes[currentHorse.getPlayerIndex()].getChildren().add(currentHorse.getImgHorse());
						players[currentHorse.getPlayerIndex()].setScore(players[currentHorse.getPlayerIndex()].getScore()-2);
						players[horse.getPlayerIndex()].setScore(players[horse.getPlayerIndex()].getScore()+2);
					}
					if(horse.getPosition()!=0)
						horses[currentHorseindexInArray]= horse;
					setScore();
					return;
				}
				else {
					this.horse.increasePosition();
					if(this.horse.getPosition()>47)
						this.horse.setPosition(0);
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

	private void initPlayerNames() {
		// TODO Auto-generated method stub
		lb_player1.setText(playerNames[0]);
		lb_player2.setText(playerNames[1]);
		lb_player3.setText(playerNames[2]);
		lb_player4.setText(playerNames[3]);
	}

	//how many players and player names, which player first, setup specific roll function for player and for machine
	private void setupPlayers() {
		userData=(UserData) Main.currentStage.getUserData();
		numberPlayers=userData.getNumberPlayers();
		playerNames=userData.getPlayerNames();
		currentPlayer=userData.getFirstPlayer();
		lb_currentplayername.setText(playerNames[currentPlayer]);
		players =new Player[4];
		for(int i=0;i<4;i++) {
			if(i<numberPlayers) {
				players[i]=new Player(playerNames[i], false, i) {
					@Override
					public void rollDices() {
						rotatedDice1();
						rotatedDice2();
						//waiting for player choose what way to go then handler that choice
					}
				};
			}
			else {
				players[i]=new Player(playerNames[i], true, i) {
					@Override
					public void rollDices() {
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
					players[i].setHorseColor(bh0, bh1, bh2, bh3);
					break;
				}
				case 2:{
					players[i].setHorseColor(rh0, rh1, rh2, rh3);
					break;
				}
				case 3:{
					players[i].setHorseColor(gh0, gh1, gh2, gh3);
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
		}
		status.setText(lb_currentplayername.getText() + " horse moves " + finalValue);
		go(finalValue);
	}

	public void getValueDice2(){
		finalValue = 0;
		if (chooseValue2){
			BoxBlur boxblur = new BoxBlur();
			value2.setEffect(boxblur);
			finalValue = d2.getValue();
			System.out.println(finalValue);
			//chooseValue2 = false;
		}
		status.setText(lb_currentplayername.getText() + " horse moves " + finalValue);
		go(finalValue);
	}

	public void getBothValue(){
		finalValue = 0;
		if (chooseBothValue){
			finalValue = d1.getValue() + d2.getValue();
			System.out.println(finalValue);
		}
		status.setText(lb_currentplayername.getText() + " horse moves " + finalValue);
		go(finalValue);
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
			Horse horse;
			for(int i=0;i<4;i++) {
				horse=players[currentPlayer].getHorses()[i];
				if(horse.isFinished()) {
					continue;
				}
				boolean[] result=checkCanGo(horse, d1.getValue(), d2.getValue());
				setButtonsCanChoose(result);
				if(result[0]==false&&result[1]==false&&result[2]==false) {
					increaseCurrentPlayerIndex();
					lb_currentplayername.setText(playerNames[currentPlayer]);
					resetDisableButton(true);
				}
				else {
					checkFirstStep(horse);
				}
				break;
			}
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

	private void checkFirstStep(Horse horse) {
		// TODO Auto-generated method stub

		if(horse.isOnHouse()) {
			if(d1.getValue()==6||d2.getValue()==6) {
				sound.playOutNestSound();
				status.setText("Player " + lb_currentplayername.getText() + " horse is out");
				horse.setOnHouse(false);
				horse.setPosition(horse.getPosition()+12*currentPlayer);
				thread=new MyThread(1, horse);
				thread.start();
				resetDisableButton(true);
			}
			else {
				thread=new MyThread(0, horse);
				thread.start();
				resetDisableButton(true);
			}
		}

	}

	public void stopClicked(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = (Stage) stop.getScene().getWindow();
		GaussianBlur blur = new GaussianBlur(3);
		gamePlay.setEffect(blur);

		Parent root = FXMLLoader.load(getClass().getResource("../views/OptionSelect.fxml"));
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
	private void go(int finalValue2) {
		resetDisableButton(true);
		sound.playMoveSound();
		rolldice.setDisable(true);
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			Horse horse=players[currentPlayer].getHorses()[i];
			if(horse.isFinished()) {
				continue;
			}
			horses[horse.getPosition()]=null;
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

//	private void time(){
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				Platform.runLater(() -> {
//					timerText.setText(String.format("%02d:%02d:%02d", counter / 1000 / 60, (counter / 1000) % 60, (counter % 1000) / 10));
//					counter++;
//					time();
//				});
//			}
//		},1);
//	}

	// what dice value can choose to go
	private void setButtonsCanChoose(boolean [] value) {
//    	this.value1.setDisable(!value[0]);
//    	this.value2.setDisable(!value[1]);
		BoxBlur boxblur = new BoxBlur();
		ColorAdjust colorAdjust = new ColorAdjust();
		if(value[0]==true) {
			value1.setEffect(colorAdjust);
			value1.setDisable(false);
		}
		else {
			value1.setEffect(boxblur);
			value1.setDisable(true);
		}
		if(value[1]==true) {
			value2.setEffect(colorAdjust);
			value2.setDisable(false);
		}
		else {
			value2.setEffect(boxblur);
			value2.setDisable(true);
		}
		this.chooseBoth.setDisable(!value[2]);
		if(!value[0]&&!value[1]&&!value[2]) {
			rolldice.setDisable(false);
		}
		else {
			rolldice.setDisable(true);
		}
	}

	private boolean[] checkCanGo(Horse horse, int number1, int number2) {
		boolean result[]=new boolean[3];
		for(int i=0;i<3;i++) {
			result[i]=true;
		}
		int currentPosition=horse.getPosition();
		for(Horse h:horses) {
			if(h==null)
				continue;
			int max=currentPosition+number1;
			int localPosition=h.getPosition();
			if(localPosition>currentPosition&&localPosition<max) {
				result[0]=false;
				break;
			}
		}
		for(Horse h:horses) {
			if(h==null)
				continue;
			int max=currentPosition+number2;
			int localPosition=h.getPosition();
			if(localPosition>currentPosition&&localPosition<max) {
				result[1]=false;
				break;
			}
		}
		for(Horse h:horses) {
			if(h==null)
				continue;
			int max=currentPosition+number2+number1;
			int localPosition=h.getPosition();
			if(localPosition>currentPosition&&localPosition<max) {
				result[2]=false;
				break;
			}
		}
		return result;
	}

	private void setScore() {
		if (lang.equals("el")){
			lb_score_player1.setText("Điểm: "+players[0].getScore());
			lb_score_player2.setText("Điểm: "+players[1].getScore());
			lb_score_player3.setText("Điểm: "+players[2].getScore());
			lb_score_player4.setText("Điểm: "+players[3].getScore());
		} else {
			lb_score_player1.setText("Score: "+players[0].getScore());
			lb_score_player2.setText("Score: "+players[1].getScore());
			lb_score_player3.setText("Score: "+players[2].getScore());
			lb_score_player4.setText("Score: "+players[3].getScore());
		}
	}
	public void loadLang(String lang){
		locale = new Locale(lang);
		ResourceBundle bundle = ResourceBundle.getBundle("sample.lang", locale);
		chooseBoth.setText(bundle.getString("chooseBoth"));
		rolldice.setText(bundle.getString("rollDice"));
		stop.setText(bundle.getString("stop"));
	}
}


