package data;

import java.util.ArrayList;

public class GameData {

	ArrayList<Province> currentCountry;

	private static int PLAYER_AMOUNT = -1;
	private static int SELECTED_PLAYER = -1;
	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;
	public static final int PLAYER_THREE = 3;
	
	public static final int starting_armies = 17;

	public GameData() {

	}

	public void setUpPlayers(int amount) {
		PLAYER_AMOUNT = amount;
	}

	public ArrayList<Province> loadCountryData(NedData data) {

		currentCountry = data.getProvinces();
		return currentCountry;
	}

}
