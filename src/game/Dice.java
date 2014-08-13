package game;

import javax.swing.ImageIcon;

/**
 * Class that creates a Dice object
 * 
 * @author rogier_konings
 * 
 */
public class Dice {

	private int number;
	private ImageIcon icon;

	/**
	 * 
	 * @param number
	 *            the amount of eyes of the dice
	 * @param icon
	 *            image of the dice
	 */
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
