package data;

import game.Player;

import java.util.ArrayList;

public class GameData {

	ArrayList<Province> currentCountry;
	
	public static int PLAYER_AMOUNT = 2;
	public static final int STARTING_ARMIES = 36 / PLAYER_AMOUNT;

	
	public static final Player PLAYER_ONE = new Player(1, STARTING_ARMIES);
	public static final Player PLAYER_TWO = new Player(2, STARTING_ARMIES);
	public static final Player PLAYER_THREE = new Player(3, STARTING_ARMIES);
	


	public GameData() {

	}

	public ArrayList<Province> loadCountryData(NedData data) {

		currentCountry = data.getProvinces();
		return currentCountry;
	}

}
