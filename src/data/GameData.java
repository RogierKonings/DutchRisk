package data;

import game.Player;
import game.Province;
import gui.RiskBoard;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * @author rogier_konings
 * 
 */
public class GameData {

	public static int PLAYER_AMOUNT = 2;
	public static int STARTING_ARMIES = 36 / PLAYER_AMOUNT;

	public final static Player PLAYER_ONE = new Player(1, "Rogier", STARTING_ARMIES, 0,
			Color.BLUE);
	public final static Player PLAYER_TWO = new Player(2, "Jeroen", STARTING_ARMIES, 0,
			Color.RED);
	public final static Player PLAYER_THREE = new Player(3, "Isaac", STARTING_ARMIES, 0,
			Color.MAGENTA);

	private CountryData data;

	public static ArrayList<Province> provinces;
	public static int[] attackResult = null;
	public static int[] defenceResult = null;
	
	public static Province SELECTED_PROVINCE;
	public static Province TARGET_PROVINCE;

	public static Player CURRENT_PLAYER;
	
	public static String CURRENT_SCENARIO;

	
	public static boolean GAME_RUNNING;
	public static boolean PLACE_ROUND;
	public static boolean ATTACK_RUNNING;
	
	public static int ROUND = 1;
	
	public static ImageIcon dice1 = new ImageIcon("../DutchRisk/src/img/dice/dice1.png");
	public static ImageIcon dice2 = new ImageIcon("../DutchRisk/src/img/dice/dice2.png");
	public static ImageIcon dice3 = new ImageIcon("../DutchRisk/src/img/dice/dice3.png");
	public static ImageIcon dice4 = new ImageIcon("../DutchRisk/src/img/dice/dice4.png");
	public static ImageIcon dice5 = new ImageIcon("../DutchRisk/src/img/dice/dice5.png");
	public static ImageIcon dice6 = new ImageIcon("../DutchRisk/src/img/dice/dice6.png");
	
	public static ImageIcon[] diceimage = new ImageIcon[6];
	
	
	public GameData(CountryData data) {
		this.data = data;
		initialize();

	}

	public void initialize() {
		loadProvinces();
		loadDiceImages();
	}

	public void loadProvinces() {

		provinces = data.getProvinces();

	}
	
	public void loadDiceImages() {
		
		diceimage[0] = dice1;
		diceimage[1] = dice2;
		diceimage[2] = dice3;
		diceimage[3] = dice4;
		diceimage[4] = dice5;
		diceimage[5] = dice6;
		
	}

	public Province getSelectedProvince() {

		for (Province province : provinces) {
			if (province.SELECTED == true) {
				SELECTED_PROVINCE = province;
			}
		}
		return SELECTED_PROVINCE;
	}

	public Player getCurrentPlayer() {
		return CURRENT_PLAYER;
	}
	
	public static void setTargetProvince(String province_name) {

		for (Province province : provinces) {

			if (province.getName() == province_name) {
				TARGET_PROVINCE = province;
			}

		}
	}
	
}
