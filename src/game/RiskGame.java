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

	private ArrayList<Province> playeroneprovinces;
	private ArrayList<Province> playertwoprovinces;
	private ArrayList<Province> playerthreeprovinces;

	private boolean GAME_RUNNING = false;
	private static Player CURRENT_PLAYER;

	public RiskGame() {

	}

	public void newGame() {

		loadSettings();
		divideProvinces();
		setUpPlayers(GameData.PLAYER_AMOUNT);
		GAME_RUNNING = true;
		CURRENT_PLAYER = GameData.PLAYER_ONE;
		placeArmies();
		updateStatistics();

	}

	public void loadSettings() {
		
		RiskBoard board = new RiskBoard();
		board.initialize();
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
			RiskBoard.getGameLabel().setText("Please select a Province!");
		} else {

			int armies = CURRENT_PLAYER.getUnplacedArmies();

			if (armies > 0 && isPlayerProvince(SELECTED_PROVINCE) == true) {

				SELECTED_PROVINCE.addArmy();
				armies--;
				CURRENT_PLAYER.setUnplacedArmies(armies);
				RiskBoard.getGameLabel().setText(
						"<html> Unit added to "
								+ RiskGame.getSelectedProvince().getName()
								+ " <br> <br> You have <b>"
								+ CURRENT_PLAYER.getUnplacedArmies()
								+ "</b> armies left!</html>");

				updateStatistics();

			} else if (armies > 0
					&& isPlayerProvince(SELECTED_PROVINCE) == false) {
				RiskBoard.getGameLabel().setText(
						"Please select your own Province!");
			} else if (armies <= 0) {
				RiskBoard.getGameLabel().setText("No more armies left!");
				RiskBoard.getAddArmyButton().setEnabled(false);
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

		int[] result = new int[dice];
		for (int i = 0; i < dice; i++) {

			int randomthrow = (int) (Math.random() * 6 + 1);
			result[i] = randomthrow;
		}
		return result;
	}

	/**
	 * Divides the provinces on the map evenly among the selected players
	 * 
	 * @param players
	 *            the amount of selected players
	 */
	public void divideProvinces() {

		Collections.shuffle(countrydata);
		Collections.shuffle(countrydata);
		Collections.shuffle(countrydata);

		int count = 0;

		if (GameData.PLAYER_AMOUNT == 2) {
			for (Province province : countrydata) {

				if (count % 2 == 0) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else if (count % 2 == 1) {
					province.setPlayer(GameData.PLAYER_TWO);
				}
				count++;
			}
		}

		if (GameData.PLAYER_AMOUNT == 3) {
			for (Province province : countrydata) {

				if (count % 3 == 0) {
					province.setPlayer(GameData.PLAYER_ONE);
				} else if (count % 3 == 1) {
					province.setPlayer(GameData.PLAYER_TWO);
				} else if (count % 3 == 2) {
					province.setPlayer(GameData.PLAYER_THREE);
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

	public static boolean isPlayerProvince(Province province) {

		ArrayList<Province> currentprovince = CURRENT_PLAYER
				.getPlayerProvince();

		for (Province prov : currentprovince) {
			if (prov.equals(province)) {
				return true;
			}
		}
		return false;
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

		GameData.PLAYER_ONE.setPlayerProvinces(playeroneprovinces);
		GameData.PLAYER_TWO.setPlayerProvinces(playertwoprovinces);
		

		
		//player_one = new Player(GameData.PLAYER_ONE, GameData.starting_armies,
				//playeroneprovinces);
		//player_two = new Player(GameData.PLAYER_TWO, GameData.starting_armies,
			//	playertwoprovinces);

		if (players > 2) {

			GameData.PLAYER_THREE.setPlayerProvinces(playerthreeprovinces);
		}

	}

	public void placeArmies() {

		if (GAME_RUNNING == true && CURRENT_PLAYER.getUnplacedArmies() > 0) {
			RiskBoard.getAddArmyButton().setEnabled(true);
			RiskBoard.getGameLabel().setText(
					"Place your armies Player " + CURRENT_PLAYER.getPlayerId());
			
			if(CURRENT_PLAYER.getUnplacedArmies() == 0) {
			RiskBoard.getAddArmyButton().setEnabled(false);
			}
		}

	}

	public static void nextPlayer() {

		if (CURRENT_PLAYER.getUnplacedArmies() == 0) {

			if (CURRENT_PLAYER == GameData.PLAYER_ONE) {
				CURRENT_PLAYER = GameData.PLAYER_TWO;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_TWO && GameData.PLAYER_AMOUNT == 2) {
				CURRENT_PLAYER = GameData.PLAYER_ONE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_TWO && GameData.PLAYER_AMOUNT == 3) {
				CURRENT_PLAYER = GameData.PLAYER_THREE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_THREE) {
				CURRENT_PLAYER = GameData.PLAYER_ONE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			}
		} else {
			RiskBoard.getGameLabel().setText("You still have some unplaced armies!");
		}

	}

	public static void updateStatistics() {
		String result = "Player <b>"
				+ CURRENT_PLAYER.getPlayerId()
				+ " </b> can make a move! <br><br><br> Current Provinces: <br><br>";
		ArrayList<Province> prov = CURRENT_PLAYER.getPlayerProvince();
		for (Province province : prov) {
			result = result + province.getName() + " - "
					+ province.getCapital() + " - " + province.getArmy()
					+ "<br>";
		}
		RiskBoard.getStatisticsLabel().setText("<html>" + result + "</html>");

	}
	
	

}
