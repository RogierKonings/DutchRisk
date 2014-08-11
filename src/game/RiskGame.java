package game;

import gui.RiskBoard;

import java.util.ArrayList;
import java.util.Arrays;

import data.GameData;
import data.NedMapData;
import data.Scenario;

public class RiskGame {

	private GameData data;
	private RiskBoard board;

	public RiskGame() {

		initialize();
		newGame();

	}

	public void initialize() {

		loadData();
		loadBoard();
		loadPlayers();

		updateStatistics();

	}

	public void loadData() {
		GameData data = new GameData(new NedMapData());
	}

	public void loadBoard() {
		board = new RiskBoard();
	}

	public void loadPlayers() {

		data.CURRENT_PLAYER = data.PLAYER_ONE;
		// divideProvinces();
		// divideProvincesHistorically(GameData.PLAYER_ONE, GameData.PLAYER_TWO,
		// GameData.PLAYER_THREE);
		loadScenario("germaninvasion");
	}

	public void loadScenario(String scenario) {
		Scenario scen = new Scenario(scenario);
	}

	public void newGame() {
		GameData.GAME_RUNNING = true;
		GameData.PLACE_ROUND = true;
	}

	public static void attackInitiated() {

		if (GameData.ATTACK_RUNNING == true && GameData.attackResult != null
				&& GameData.defenceResult != null) {

			int diceattack = GameData.attackResult.length;
			int dicedefence = GameData.defenceResult.length;

			int attackwin = 0;
			int defencewin = 0;

			if (GameData.attackResult[diceattack - 1] > GameData.defenceResult[dicedefence - 1]) {
				attackwin++;
				GameData.TARGET_PROVINCE.removeArmy();
				System.out.println("Removing army from "
						+ GameData.TARGET_PROVINCE.getName());
			} else {
				defencewin++;
				GameData.SELECTED_PROVINCE.removeArmy();
				System.out.println("Removing army from "
						+ GameData.SELECTED_PROVINCE.getName());
			}

			if (dicedefence == 2) {
				if (GameData.attackResult[diceattack - 2] > GameData.defenceResult[dicedefence - 2]) {
					attackwin++;
					GameData.TARGET_PROVINCE.removeArmy();
					System.out.println("Removing army from "
							+ GameData.TARGET_PROVINCE.getName());
				} else {
					defencewin++;
					GameData.SELECTED_PROVINCE.removeArmy();
					System.out.println("Removing army from "
							+ GameData.SELECTED_PROVINCE.getName());
				}
			}

			RiskBoard.getGameLabel().setText(
					"<html>Attack win: " + attackwin + "<br><br>Defence win: "
							+ defencewin + "</html>");
			checkIfConquered();
			// setUpPlayers(GameData.PLAYER_AMOUNT);
			setAttack(false);
			RiskBoard.getAttackSpinner().setEnabled(false);
			RiskBoard.getDefenceSpinner().setEnabled(false);

		}
	}

	public static void setAttack(boolean attack) {

		GameData.ATTACK_RUNNING = attack;

	}

	public static boolean unplacedArmies() {

		if (GameData.PLAYER_AMOUNT == 2) {
			if (GameData.PLAYER_ONE.getUnplacedArmies() == 0
					&& GameData.PLAYER_TWO.getUnplacedArmies() == 0) {
				return false;
			}
			return true;
		} else if (GameData.PLAYER_AMOUNT == 3) {

			if (GameData.PLAYER_ONE.getUnplacedArmies() == 0
					&& GameData.PLAYER_TWO.getUnplacedArmies() == 0
					&& GameData.PLAYER_THREE.getUnplacedArmies() == 0) {
				return false;
			} else {
				return true;
			}
		}
		return false;

	}

	public static void checkIfConquered() {

		if (GameData.TARGET_PROVINCE.getArmy() == 0) {

			GameData.TARGET_PROVINCE.setPlayer(GameData.CURRENT_PLAYER);
			GameData.SELECTED_PROVINCE.removeArmy();
			GameData.TARGET_PROVINCE.addArmy();

			RiskBoard.getGameLabel().setText(
					"Congratulations " + GameData.CURRENT_PLAYER.getName()
							+ ", you have conquered "
							+ GameData.TARGET_PROVINCE.getName());

		}

	}

	public static int[] diceThrow(int dice) {

		int[] result = new int[dice];
		for (int i = 0; i < dice; i++) {

			int randomthrow = (int) (Math.random() * 6 + 1);

			if (randomthrow == 1) {

			}

			result[i] = randomthrow;

		}
		Arrays.sort(result);
		return result;
	}

	public static void addUnit() {

		int armies = GameData.CURRENT_PLAYER.getUnplacedArmies();

		if (armies > 0
				&& GameData.CURRENT_PLAYER
						.isPlayerProvince(GameData.SELECTED_PROVINCE) == true) {

			GameData.SELECTED_PROVINCE.addArmy();
			armies--;
			GameData.CURRENT_PLAYER.setUnplacedArmies(armies);
			RiskBoard.getGameLabel().setText(
					"<html> Unit added to "
							+ GameData.SELECTED_PROVINCE.getName()
							+ " <br> <br> You have <b>"
							+ GameData.CURRENT_PLAYER.getUnplacedArmies()
							+ "</b> armies left!</html>");

			updateStatistics();
			RiskBoard.getRemoveArmyButton().setEnabled(true);

		} else if (armies == 0) {
			RiskBoard.getAddArmyButton().setEnabled(false);
			RiskBoard.getGameLabel().setText(
					"No more armies left to be placed!");

		}

	}

	public static void removeUnit() {

		int armies = GameData.CURRENT_PLAYER.getUnplacedArmies();

		if (GameData.SELECTED_PROVINCE.getArmy() > 1
				&& GameData.CURRENT_PLAYER
						.isPlayerProvince(GameData.SELECTED_PROVINCE) == true) {

			GameData.SELECTED_PROVINCE.removeArmy();
			armies++;
			GameData.CURRENT_PLAYER.setUnplacedArmies(armies);
			RiskBoard.getGameLabel().setText(
					"<html> Unit removed from "
							+ GameData.SELECTED_PROVINCE.getName()
							+ " <br> <br> You have <b>"
							+ GameData.CURRENT_PLAYER.getUnplacedArmies()
							+ "</b> armies left!</html>");

			updateStatistics();
			RiskBoard.getAddArmyButton().setEnabled(true);

		} else if (GameData.SELECTED_PROVINCE.getArmy() < 2) {
			RiskBoard.getGameLabel().setText(
					"You will need at least one army on this province!");
			RiskBoard.getRemoveArmyButton().setEnabled(false);
		}

	}

	public static void nextPlayer() {
		if (GameData.CURRENT_PLAYER == GameData.PLAYER_ONE) {
			GameData.CURRENT_PLAYER = GameData.PLAYER_TWO;
			updateStatistics();
			RiskBoard.getGameLabel().setText("");

		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_TWO
				&& GameData.PLAYER_AMOUNT == 2) {
			GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;

			nextRound();
			updateStatistics();
			RiskBoard.getGameLabel().setText("");
		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_TWO
				&& GameData.PLAYER_AMOUNT == 3) {
			GameData.CURRENT_PLAYER = GameData.PLAYER_THREE;
			updateStatistics();
			RiskBoard.getGameLabel().setText("");
		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_THREE) {
			GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;

			nextRound();
			updateStatistics();
			RiskBoard.getGameLabel().setText("");
		}

	}

	public static void nextRound() {

		GameData.ROUND++;

		if (GameData.ROUND > 1) {
			GameData.PLACE_ROUND = false;
		}

	}

	public static void updateStatistics() {

		String result = "Round <b>" + GameData.ROUND + "</b><br><br><b>"
				+ GameData.CURRENT_PLAYER.getName()
				+ " </b> can make a move! <br><br>You can place <b>"
				+ GameData.CURRENT_PLAYER.getUnplacedArmies()
				+ "</b> armies<br><br> Current Provinces: <br><br>";
		ArrayList<Province> prov = GameData.CURRENT_PLAYER.getPlayerProvince();
		for (Province province : prov) {
			result = result + province.getName() + " - "
					+ province.getCapital() + " - " + province.getArmy()
					+ "<br>";
		}
		RiskBoard.getStatisticsLabel().setText("<html>" + result + "</html>");

	}

	public static void main(String[] args) {

		RiskGame game = new RiskGame();

		for (Card card : GameData.gamecards) {

			if (card.getPlayer() != null) {

				System.out.println(card.getPlayer().getName());
			}

		}

	}

}
