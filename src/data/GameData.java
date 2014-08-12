package data;

import game.Card;
import game.Dice;
import game.Player;
import game.Province;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

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
			Color.BLUE, null);
	public final static Player PLAYER_TWO = new Player(2, "Jeroen", STARTING_ARMIES, 0,
			Color.RED, null);
	public final static Player PLAYER_THREE = new Player(3, "Isaac", STARTING_ARMIES, 0,
			Color.MAGENTA, null);

	private CountryData data;

	public static ArrayList<Province> provinces;
	public static ArrayList<Card> gamecards;
	
	
	public static int[] attackResult = null;
	public static int[] defenceResult = null;
	
	public static Province SELECTED_PROVINCE;
	public static Province TARGET_PROVINCE;

	public static Player CURRENT_PLAYER;
	
	public static String CURRENT_SCENARIO;

	
	public static boolean GAME_RUNNING;
	public static boolean PLACE_ROUND;
	public static boolean ATTACK_RUNNING;
	public static boolean RECEIVE_CARD;
	
	public static int ROUND = 0;
	
	public static ImageIcon dice1img = new ImageIcon("../DutchRisk/src/img/dice/dice1.png");
	public static ImageIcon dice2img = new ImageIcon("../DutchRisk/src/img/dice/dice2.png");
	public static ImageIcon dice3img = new ImageIcon("../DutchRisk/src/img/dice/dice3.png");
	public static ImageIcon dice4img = new ImageIcon("../DutchRisk/src/img/dice/dice4.png");
	public static ImageIcon dice5img = new ImageIcon("../DutchRisk/src/img/dice/dice5.png");
	public static ImageIcon dice6img = new ImageIcon("../DutchRisk/src/img/dice/dice6.png");
	
	public static Dice dice1 = new Dice(1, dice1img);
	public static Dice dice2 = new Dice(2, dice2img);
	public static Dice dice3 = new Dice(3, dice3img);
	public static Dice dice4 = new Dice(4, dice4img);
	public static Dice dice5 = new Dice(5, dice5img);
	public static Dice dice6 = new Dice(6, dice6img);
	
	public static Dice[] dices = new Dice[6];
	
	
	//public static ImageIcon[] diceimage = new ImageIcon[6];
	
	
	public GameData(CountryData data) {
		this.data = data;
		initialize();

	}

	public void initialize() {
		loadProvinces();
		loadDice();
		loadGameCards();
	}

	public void loadProvinces() {

		provinces = data.getProvinces();

	}
	
	public void loadDice() {
		
		dices[0] = dice1;
		dices[1] = dice2;
		dices[2] = dice3;
		dices[3] = dice4;
		dices[4] = dice5;
		dices[5] = dice6;
		
	}
	
	public void loadGameCards() {
		
		gamecards = NedCardData.getGameCards();
		
		for (int i = 0; i < 100; i++) {

			Collections.shuffle(GameData.gamecards);
		}
		
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
