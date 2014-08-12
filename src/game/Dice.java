package game;

import javax.swing.ImageIcon;

public class Dice {

	
	private int number;
	private ImageIcon icon;
	
	
	public Dice(int number, ImageIcon icon) {
		
		this.number = number;
		this.icon = icon;
		
	}
	
	public int getDiceNumber() {
		return number;
	}
	
	public ImageIcon getDiceIcon() {
		return icon;
	}
	
	
}
