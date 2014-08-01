package game;

import gui.RiskBoard;

import java.util.ArrayList;
import java.util.Collections;

import data.GameData;
import data.NedData;
import data.Province;

public class RiskGame {

	private GameData gamedata;
	private static ArrayList<Province> countrydata;

	private static Province SELECTED_PROVINCE;

	public static Player player_one;
	public static Player player_two;
	public static Player player_three;
	public int players = 3;

	ArrayList<Province> playeroneprovinces;
	ArrayList<Province> playertwoprovinces;
	ArrayList<Province> playerthreeprovinces;

	private boolean GAME_RUNNING = false;
	private static Player CURRENT_PLAYER;

	public RiskGame() {

	}

	public void newGame() {

		loadSettings();
		divideProvinces(players);
		setUpPlayers(players);
		GAME_RUNNING = true;
		CURRENT_PLAYER = player_one;
		placeArmies();

	}

	public void loadSettings() {

		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());

	}

	public void selectProvince(int id) {

		for (Province province : countrydata) {
			if (province.getId() == id) {
				SELECTED_PROVINCE = province;
				System.out.println("You have selected: " + "\n" + "Province: "
						+ province.getName() + "\n" + "Capital: "
						+ province.getCapital() + "\n" + "Army Size: "
						+ province.getArmy() + "\n");
			}
		}

	}

	public static void addUnit() {

		if (SELECTED_PROVINCE == null) {
			System.out.println("Select a province!");
		} else {

			int armies = CURRENT_PLAYER.getUnplacedArmies();

			if (armies > 0) {

				SELECTED_PROVINCE.addArmy();
				System.out.println("Unit added to "
						+ RiskGame.getSelectedProvince().getName());
				armies--;
				CURRENT_PLAYER.setUnplacedArmies(armies);

			} else {
				System.out.println("No more armies available!");
			}
		}

	}

	public void removeUnit() {

		SELECTED_PROVINCE.removeArmy();

	}

	/**
	 * Simulates a dice throw
	 * 
	 * @param dice
	 *            the amount of dice that are thrown
	 * @return an array with numbers thrown
	 */
	public static int[] diceThrow(int dice) {

		int[] resultaat = new int[dice];
		for (int i = 0; i < dice; i++) {

			int randomthrow = (int) (Math.random() * 6 + 1);
			resultaat[i] = randomthrow;
		}
		return resultaat;
	}

	/**
	 * Divides the provinces on the map evenly among the selected players
	 * 
	 * @param players
	 *            the amount of selected players
	 */
	public void divideProvinces(int players) {

		Collections.shuffle(countrydata);

		int count = 0;

		if (players == 2) {
			for (Province province : countrydata) {

				if (count % 2 == 0) {
					province.setPlayer(1);
				} else if (count % 2 == 1) {
					province.setPlayer(2);
				}
				count++;
			}
		}

		if (players == 3) {
			for (Province province : countrydata) {

				if (count % 3 == 0) {
					province.setPlayer(1);
				} else if (count % 3 == 1) {
					province.setPlayer(2);
				} else if (count % 3 == 2) {
					province.setPlayer(3);
				}
				count++;
			}
		}
	}

	/**
	 * Gives us the currently selected province
	 * 
	 * @return the selected province
	 */
	public static Province getSelectedProvince() {

		for (Province province : countrydata) {
			if (province.SELECTED == true) {
				SELECTED_PROVINCE = province;
			}
		}
		return SELECTED_PROVINCE;
	}

	public void setUpPlayers(int players) {

		playeroneprovinces = new ArrayList<Province>();
		playertwoprovinces = new ArrayList<Province>();
		playerthreeprovinces = new ArrayList<Province>();

		for (Province province : countrydata) {

			if (province.getPlayer() == GameData.PLAYER_ONE) {

				playeroneprovinces.add(province);
			} else if (province.getPlayer() == GameData.PLAYER_TWO) {

				playertwoprovinces.add(province);
			} else if (players > 2
					&& province.getPlayer() == GameData.PLAYER_THREE) {

				playerthreeprovinces.add(province);
			}
		}

		player_one = new Player(GameData.PLAYER_ONE, GameData.starting_armies,
				playeroneprovinces);
		player_two = new Player(GameData.PLAYER_TWO, GameData.starting_armies,
				playertwoprovinces);

		if (players > 2) {

			player_three = new Player(GameData.PLAYER_THREE,
					GameData.starting_armies, playerthreeprovinces);
		}

	}

	public void placeArmies() {

		if (GAME_RUNNING == true && CURRENT_PLAYER.getUnplacedArmies() > 0) {
			RiskBoard.getGameLabel().setText(
					"Place your armies Player " + CURRENT_PLAYER.getPlayerId());
		}

	}

	public void nextPlayer() {

		if (CURRENT_PLAYER == player_one) {
			CURRENT_PLAYER = player_two;
		} else if (CURRENT_PLAYER == player_two && players == 2) {
			CURRENT_PLAYER = player_one;
		} else if (CURRENT_PLAYER == player_two && players == 3) {
			CURRENT_PLAYER = player_three;
		} else if (CURRENT_PLAYER == player_three) {
			CURRENT_PLAYER = player_one;
		}

	}

}
