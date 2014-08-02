package data;

import game.Player;

import java.util.ArrayList;

public class GameData {

	ArrayList<Province> currentCountry;
	public static final int starting_armies = 17;
	
	public static final Player PLAYER_ONE = new Player(1, starting_armies);
	public static final Player PLAYER_TWO = new Player(2, starting_armies);
	public static final Player PLAYER_THREE = new Player(3, starting_armies);
	
	

	public GameData() {

	}

	public ArrayList<Province> loadCountryData(NedData data) {

		currentCountry = data.getProvinces();
		return currentCountry;
	}

}
