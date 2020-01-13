package sample.model;

import javafx.scene.image.ImageView;
import sample.model.Horse;

public abstract class Player {

	private String name;
	private Horse[] horses;
	private int score;
	private boolean isMachine;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String name, Horse[] horses, int score, boolean isMachine) {
		super();
		this.name = name;
		this.horses = horses;
		this.score = score;
		this.isMachine = isMachine;
	}

	public Player(String name, boolean isMaChine, int index) {
		this.name=name;
		this.isMachine=isMaChine;
		this.score=0;
		this.horses=new Horse[4];
		for(int i=0;i<4;i++) {
			this.horses[i]=new Horse(0, true, index);
		}
	}

	public void setHorseColor(ImageView img1, ImageView img2, ImageView img3, ImageView img4) {
		for(int i=0;i<4;i++) {
			switch (i) {
				case 0:
					horses[i].setImgHorse(img1);
					break;
				case 1:
					horses[i].setImgHorse(img2);
					break;
				case 2:
					horses[i].setImgHorse(img3);
					break;
				case 3:
					horses[i].setImgHorse(img4);
					break;
				default:
					break;
			}
		}
	}

	public abstract void rollDices();

	public boolean isMachine() {
		return isMachine;
	}

	public void setMachine(boolean isMachine) {
		this.isMachine = isMachine;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Horse[] getHorses() {
		return horses;
	}
	public void setHorses(Horse[] horses) {
		this.horses = horses;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
