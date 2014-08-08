package game;

import gui.RiskBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import data.GameData;
import data.NedData;
import data.Province;

/**
 * 
 * @author rogier_konings
 * 
 */
public class RiskGame {

	private GameData gamedata;
	private static ArrayList<Province> countrydata;

	private static Province SELECTED_PROVINCE;
	private static Province TARGET_PROVINCE;

	private ArrayList<Province> playeroneprovinces;
	private ArrayList<Province> playertwoprovinces;
	private ArrayList<Province> playerthreeprovinces;

	private static boolean GAME_RUNNING = false;
	private static boolean ATTACK_RUNNING = false;
	private static Player CURRENT_PLAYER;

	public RiskGame() {

	}

	/**
	 * Starts a new game
	 */
	public void newGame() {

		loadSettings();
		divideProvinces();
		setUpPlayers(GameData.PLAYER_AMOUNT);
		GAME_RUNNING = true;
		CURRENT_PLAYER = GameData.PLAYER_ONE;
		placeArmies();
		updateStatistics();

	}

	/**
	 * Loads game settings
	 */
	public void loadSettings() {

		RiskBoard board = new RiskBoard();
		board.initialize();
		gamedata = new GameData();
		countrydata = gamedata.loadCountryData(new NedData());

	}

	/**
	 * Adds an army to the currently selected province
	 */
	public static void addUnit() {

		if (SELECTED_PROVINCE == null) {
			RiskBoard.getGameLabel().setText("Please select a Province!");
		} else {

			int armies = CURRENT_PLAYER.getUnplacedArmies();

			if (armies > 0 && isCurrentProvince(SELECTED_PROVINCE) == true) {

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
				RiskBoard.getRemoveArmyButton().setEnabled(true);

			} else if (armies > 0
					&& isCurrentProvince(SELECTED_PROVINCE) == false) {
				RiskBoard.getGameLabel().setText(
						"Please select your own Province!");
			} else if (armies <= 0) {
				RiskBoard.getGameLabel().setText(
						"No more armies left to be placed!");
				RiskBoard.getAddArmyButton().setEnabled(false);
			}
		}

	}

	/**
	 * Removes an army from the currently selected province
	 */
	public static void removeUnit() {

		if (SELECTED_PROVINCE == null) {
			RiskBoard.getGameLabel().setText("Please select a Province!");
		} else {

			int armies = CURRENT_PLAYER.getUnplacedArmies();

			if (SELECTED_PROVINCE.getArmy() > 0
					&& isCurrentProvince(SELECTED_PROVINCE) == true) {

				SELECTED_PROVINCE.removeArmy();
				armies++;
				CURRENT_PLAYER.setUnplacedArmies(armies);
				RiskBoard.getGameLabel().setText(
						"<html> Unit remove from "
								+ RiskGame.getSelectedProvince().getName()
								+ " <br> <br> You have <b>"
								+ CURRENT_PLAYER.getUnplacedArmies()
								+ "</b> armies left!</html>");

				updateStatistics();
				RiskBoard.getAddArmyButton().setEnabled(true);

			} else if (SELECTED_PROVINCE.getArmy() > 0
					&& isCurrentProvince(SELECTED_PROVINCE) == false) {
				RiskBoard.getGameLabel().setText(
						"Please select your own Province!");
			} else if (SELECTED_PROVINCE.getArmy() <= 0) {
				RiskBoard.getGameLabel().setText(
						"No more armies left on this province!");
				RiskBoard.getRemoveArmyButton().setEnabled(false);
			}
		}

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
		Arrays.sort(result);
		return result;
	}

	public static void attackInitiated() {

		if (ATTACK_RUNNING == true && GameData.getAttackResultArray() != null
				&& GameData.getDefenceResultArray() != null) {

			int diceattack = GameData.getAttackResultArray().length;
			int dicedefence = GameData.getDefenceResultArray().length;

			int attackwin = 0;
			int defencewin = 0;

			if (GameData.getAttackResultArray()[diceattack - 1] > GameData
					.getDefenceResultArray()[dicedefence - 1]) {
				attackwin++;
				TARGET_PROVINCE.removeArmy();
				System.out.println("Removing army from "
						+ TARGET_PROVINCE.getName());
			} else {
				defencewin++;
				SELECTED_PROVINCE.removeArmy();
				System.out.println("Removing army from "
						+ SELECTED_PROVINCE.getName());
			}

			if (dicedefence == 2) {
				if (GameData.getAttackResultArray()[diceattack - 2] > GameData
						.getDefenceResultArray()[dicedefence - 2]) {
					attackwin++;
					TARGET_PROVINCE.removeArmy();
					System.out.println("Removing army from "
							+ TARGET_PROVINCE.getName());
				} else {
					defencewin++;
					SELECTED_PROVINCE.removeArmy();
					System.out.println("Removing army from "
							+ SELECTED_PROVINCE.getName());
				}
			}

			RiskBoard.getGameLabel().setText(
					"<html>Attack win: " + attackwin + "<br><br>Defence win: "
							+ defencewin + "</html>");
			setAttack(false);

		}
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

	/**
	 * Gives us the provine that is under attack
	 * 
	 * @return the province that will be attacked
	 */
	public static Province getTargetProvince() {
		return TARGET_PROVINCE;
	}

	public static void setTargetProvince(String province_name) {

		for (Province province : countrydata) {

			if (province.getName() == province_name) {
				TARGET_PROVINCE = province;
			}

		}
		RiskBoard.getGameLabel().setText(
				"You are attacking from " + SELECTED_PROVINCE.getName()
						+ " to " + TARGET_PROVINCE.getName());
	}

	/**
	 * Checkc whether the province belongs to the player
	 * 
	 * @param province
	 * @return true if the province belongs to the player
	 */
	public static boolean isCurrentProvince(Province province) {

		ArrayList<Province> currentprovince = CURRENT_PLAYER
				.getPlayerProvince();

		for (Province prov : currentprovince) {
			if (prov.equals(province)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets whether we are attacking or not
	 * 
	 * @param attack
	 *            true in case of an attack
	 */
	public static void setAttack(boolean attack) {
		ATTACK_RUNNING = attack;
	}

	/**
	 * The players are randomly assigned provinces, depending on the amount of
	 * players
	 * 
	 * @param players
	 *            the amount of players that will play the game
	 */
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

		if (players > 2) {

			GameData.PLAYER_THREE.setPlayerProvinces(playerthreeprovinces);
		}

	}

	public static Player getCurrentPlayer() {
		return CURRENT_PLAYER;
	}

	public static void showDestinations() {
		if (GAME_RUNNING == true && SELECTED_PROVINCE != null) {

			RiskBoard.getDestinationBox().removeAllItems();

			Province[] des = new Province[SELECTED_PROVINCE.getDestinations().length - 1];

			des = SELECTED_PROVINCE.getDestinations();

			for (int i = 0; i < des.length; i++) {

				// if(CURRENT_PLAYER.isPlayerProvince(province))

				RiskBoard.getDestinationBox().addItem(des[i].getName());

			}
		}

	}

	/**
	 * Points out to the player that he/ she has to select a province before
	 * add-ing armies
	 */
	public void placeArmies() {

		if (GAME_RUNNING == true && CURRENT_PLAYER.getUnplacedArmies() > 0) {
			RiskBoard.getAddArmyButton().setEnabled(true);
			RiskBoard.getGameLabel().setText(
					"Place your armies Player " + CURRENT_PLAYER.getPlayerId());

			if (CURRENT_PLAYER.getUnplacedArmies() == 0) {
				RiskBoard.getAddArmyButton().setEnabled(false);
			}
		}

	}

	public static boolean unplacedArmies() {

		if (GameData.PLAYER_ONE.getUnplacedArmies() == 0
				&& GameData.PLAYER_TWO.getUnplacedArmies() == 0
				&& GameData.PLAYER_THREE.getUnplacedArmies() == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Selects the next player
	 */
	public static void nextPlayer() {

		if (CURRENT_PLAYER.getUnplacedArmies() == 0) {

			if (CURRENT_PLAYER == GameData.PLAYER_ONE) {
				CURRENT_PLAYER = GameData.PLAYER_TWO;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_TWO
					&& GameData.PLAYER_AMOUNT == 2) {
				CURRENT_PLAYER = GameData.PLAYER_ONE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_TWO
					&& GameData.PLAYER_AMOUNT == 3) {
				CURRENT_PLAYER = GameData.PLAYER_THREE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} else if (CURRENT_PLAYER == GameData.PLAYER_THREE) {
				CURRENT_PLAYER = GameData.PLAYER_ONE;
				updateStatistics();
				RiskBoard.getGameLabel().setText("");
			} 
		} else {
			RiskBoard.getGameLabel().setText(
					"You still have some unplaced armies!");
		}

	}

	/**
	 * Updates the statistics label with updates information about the current
	 * player's provinces
	 */
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
