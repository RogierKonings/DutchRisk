package data;

import game.Player;
import game.Province;
import gui.RiskBoard;

import java.awt.Color;
import java.util.ArrayList;

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
	public static boolean ATTACK_RUNNING;
	
	public GameData(CountryData data) {
		this.data = data;
		initialize();

	}

	public void initialize() {
		loadProvinces();
	}

	public void loadProvinces() {

		provinces = data.getProvinces();

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
		RiskBoard.getGameLabel().setText(
				"You are attacking from " + SELECTED_PROVINCE.getName()
						+ " to " + TARGET_PROVINCE.getName());
	}
	
}
