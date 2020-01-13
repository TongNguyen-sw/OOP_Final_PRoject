package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Horse {

	private ImageView imgHorse;
	private int position;
	private boolean isOnHouse;
	private boolean isFinished;
	private int playerIndex;
	private int limit;
	private boolean backHome;
	
	public Horse(ImageView imgHorse, int position, boolean isOnHouse) {
		super();
		this.imgHorse = imgHorse;
		this.position = position;
		this.isOnHouse = isOnHouse;
		this.isFinished=false;
	}
	
	public Horse( int position, boolean isOnHouse, int playerIndex) {
		super();
		this.position = position;
		this.isOnHouse = isOnHouse;
		this.isFinished=false;
		this.playerIndex=playerIndex;
		this.limit=playerIndex*12+playerIndex*6+1;
		this.backHome=false;
	}

	public Horse() {
		super();
	}
	
	public void go(int to, Horse []arrayHorse, StackPane []stackPane) {
		if(this.position!=0)
			stackPane[this.position].getChildren().remove(this.imgHorse);
	}
	
	public ImageView getImgHorse() {
		return imgHorse;
	}
	public void setImgHorse(ImageView imgHorse) {
		this.imgHorse = imgHorse;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean isOnHouse() {
		return isOnHouse;
	}
	public void setOnHouse(boolean isOnHouse) {
		this.isOnHouse = isOnHouse;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	public void increasePosition() {
		this.position++;
	}
	
	public int getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isBackHome() {
		return backHome;
	}

	public void setBackHome(boolean backHome) {
		this.backHome = backHome;
	}

}
