package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Horse {

	private ImageView imgHorse;
	private int position;
	private boolean isOnHouse;
	
	public Horse(ImageView imgHorse, int position, boolean isOnHouse) {
		super();
		this.imgHorse = imgHorse;
		this.position = position;
		this.isOnHouse = isOnHouse;
	}
	
	public Horse( int position, boolean isOnHouse) {
		super();
		this.position = position;
		this.isOnHouse = isOnHouse;
	}
	
	public Horse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void go(int position, int []array, StackPane []stackPane) {
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
	
}
