package data;

import game.Player;

import java.util.ArrayList;

/**
 * 
 * @author rogier_konings
 *
 */
public class GameData {

	ArrayList<Province> currentCountry;
	
	public static int PLAYER_AMOUNT = 3;
	public static final int STARTING_ARMIES = 36 / PLAYER_AMOUNT;

	
	public static final Player PLAYER_ONE = new Player(1, STARTING_ARMIES, 0);
	public static final Player PLAYER_TWO = new Player(2, STARTING_ARMIES, 0);
	public static final Player PLAYER_THREE = new Player(3, STARTING_ARMIES, 0);
	
	private static int[] attackResultArray = null;
	private static int[] defenceResultArray = null;
	


	public GameData() {

	}

	public ArrayList<Province> loadCountryData(NedData data) {

		currentCountry = data.getProvinces();
		return currentCountry;
	}
	
	public static int[] getAttackResultArray() {
		return attackResultArray;
	}
	
	public static void setAttackResultArray(int[] result) {
		attackResultArray = result;
	}
	
	public static int[] getDefenceResultArray() {
		return defenceResultArray;
	}
	
	public static void setDefenceResultArray(int[] result) {
		defenceResultArray = result;
	}

}
