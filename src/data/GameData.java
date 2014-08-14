package data;

import game.Card;
import game.Dice;
import game.Player;
import game.Province;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

/**
 * Class that contains all of the game's data, accessible from all the other
 * classes.
 * 
 * @author rogier_konings
 * 
 */
public class GameData {

	public static int PLAYER_AMOUNT = 2;
	public static int STARTING_ARMIES = 36 / PLAYER_AMOUNT;

	// this variables store the player information
	public static Player PLAYER_ONE;
	public static Player PLAYER_TWO;
	public static Player PLAYER_THREE;

	private CountryData data;

	// database of provinces
	public static ArrayList<Province> provinces;
	
	// database of scenario's
	public static ArrayList<Scenario> scenarios;

	// database of gamecards
	public static ArrayList<Card> gamecards;

	// arrays with the dice rolling results
	public static int[] attackResult = null;
	public static int[] defenceResult = null;

	public static Province SELECTED_PROVINCE;
	public static Province TARGET_PROVINCE;

	public static Player CURRENT_PLAYER;

	// scenario settings
	public static Scenario random;
	public static Scenario historical;
	public static Scenario germaninvasion;
	public static String CURRENT_SCENARIO;

	public static boolean GAME_RUNNING;
	public static boolean PLACE_ROUND;
	public static boolean COLLECT_ROUND;
	public static boolean ATTACK_RUNNING;
	public static boolean RECEIVE_CARD;
	public static boolean GAME_OVER;

	public static int ROUND = 0;

	// images of the different dice
	public static ImageIcon dice1img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice1.png"));
	public static ImageIcon dice2img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice2.png"));
	public static ImageIcon dice3img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice3.png"));
	public static ImageIcon dice4img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice4.png"));
	public static ImageIcon dice5img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice5.png"));
	public static ImageIcon dice6img = new ImageIcon(GameData.class.getClass()
			.getResource("/img/dice/dice6.png"));

	// Dice objects are created
	public static Dice dice1 = new Dice(1, dice1img);
	public static Dice dice2 = new Dice(2, dice2img);
	public static Dice dice3 = new Dice(3, dice3img);
	public static Dice dice4 = new Dice(4, dice4img);
	public static Dice dice5 = new Dice(5, dice5img);
	public static Dice dice6 = new Dice(6, dice6img);

	public static Dice[] dices = new Dice[6];

	public GameData(CountryData data) {
		this.data = data;
		initialize();

	}

	public void initialize() {
		loadProvinces();
		loadDice();
		loadGameCards();
		loadScenarios();
	}

	public void loadProvinces() {

		provinces = data.getProvinces();

	}

	/**
	 * Loads the dice in an array
	 */
	public void loadDice() {

		dices[0] = dice1;
		dices[1] = dice2;
		dices[2] = dice3;
		dices[3] = dice4;
		dices[4] = dice5;
		dices[5] = dice6;

	}

	/**
	 * Loads and shuffles the gamecards
	 */
	public void loadGameCards() {

		gamecards = NedCardData.getGameCards();

		for (int i = 0; i < 100; i++) {

			Collections.shuffle(GameData.gamecards);
		}

	}
	
	public void loadScenarios() {
		
		scenarios = new ArrayList<Scenario>();
		
		random = new Scenario("random");
		historical = new Scenario("historical");
		germaninvasion = new Scenario("germaninvasion");
		
		scenarios.add(random);
		scenarios.add(historical);
		scenarios.add(germaninvasion);
		
	}

	/**
	 * Sets the province that will be attacked
	 * 
	 * @param victim_province
	 *            province that will be attacked
	 */
	public static void setTargetProvince(String victim_province) {

		for (Province province : provinces) {

			if (province.getName() == victim_province) {
				TARGET_PROVINCE = province;
			}

		}
	}

}
