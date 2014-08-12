package game;

import gui.RiskBoard;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

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
		loadPlayers(2);
		loadScenario("historical");
		updateStatistics();

	}

	public void loadData() {
		GameData data = new GameData(new NedMapData());
	}

	public void loadBoard() {
		board = new RiskBoard();
	}

	public void loadPlayers(int amount) {

		GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;
		GameData.PLAYER_AMOUNT = amount;
	}

	public void loadScenario(String scenario) {
		Scenario scen = new Scenario(scenario);
	}

	public void newGame() {
		GameData.GAME_RUNNING = true;
		GameData.PLACE_ROUND = true;
	}

	public static void attackInitiated() {

		if (GameData.PLACE_ROUND == false && GameData.ATTACK_RUNNING == true
				&& GameData.attackResult != null
				&& GameData.defenceResult != null) {

			int diceattack = GameData.attackResult.length;
			int dicedefence = GameData.defenceResult.length;

			int attackwin = 0;
			int defencewin = 0;

			if (diceattack == 1) {

				if (dicedefence == 1) {

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
				}

				if (dicedefence == 2) {
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
				}
			}

			if (diceattack > 1) {

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
			}

			RiskBoard.getGameLabel().setText(
					"<html>Attack win: " + attackwin + "<br><br>Defence win: "
							+ defencewin + "</html>");
			checkIfConquered();
			checkIfGameWon();
			// setUpPlayers(GameData.PLAYER_AMOUNT);
			//setAttack(false);
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
					"<html>Congratulations "
							+ GameData.CURRENT_PLAYER.getName()
							+ "!! <br><br>You have conquered <b>"
							+ GameData.TARGET_PROVINCE.getName()
							+ "</b></html>");

			GameData.RECEIVE_CARD = true;
			checkIfGameWon();
		}

	}

	public static void checkIfReceiveCard() {

		if (GameData.RECEIVE_CARD == true) {

			System.out.println(GameData.CURRENT_PLAYER.getName()
					+ " receives a card!!");

			int count = 0;

			for (Card card : GameData.gamecards) {

				if (card.getPlayer() == null && count < 1) {
					card.setPlayer(GameData.CURRENT_PLAYER);
					count++;
					System.out.println("Card " + card.getId() + " added to "
							+ GameData.CURRENT_PLAYER.getName()
							+ "'s stock of cards!");
				}

			}

			GameData.RECEIVE_CARD = false;
		}

	}

	public static void checkIfGameWon() {

		if (GameData.PLAYER_AMOUNT == 2) {

			if (GameData.PLAYER_ONE.countPlayerProvinces() == 0) {

				JOptionPane.showInternalMessageDialog(RiskBoard.game,
						"Congratulations " + GameData.PLAYER_TWO.getName()
								+ " , you have won!", "",
						JOptionPane.INFORMATION_MESSAGE);
				GameData.GAME_OVER = true;
				RiskBoard.endGameState();

			} else if (GameData.PLAYER_TWO.countPlayerProvinces() == 0) {

				JOptionPane.showInternalMessageDialog(RiskBoard.game,
						"Congratulations " + GameData.PLAYER_ONE.getName()
								+ " , you have won!", "",
						JOptionPane.INFORMATION_MESSAGE);
				GameData.GAME_OVER = true;
				RiskBoard.endGameState();

			}

		} else if (GameData.PLAYER_AMOUNT == 3) {

			if (GameData.PLAYER_ONE.countPlayerProvinces() == 0
					&& GameData.PLAYER_TWO.countPlayerProvinces() == 0) {

				JOptionPane.showInternalMessageDialog(RiskBoard.game,
						"Congratulations " + GameData.PLAYER_THREE.getName()
								+ " , you have won!", "",
						JOptionPane.INFORMATION_MESSAGE);
				GameData.GAME_OVER = true;
				RiskBoard.endGameState();

			} else if (GameData.PLAYER_TWO.countPlayerProvinces() == 0
					&& GameData.PLAYER_THREE.countPlayerProvinces() == 0) {

				JOptionPane.showInternalMessageDialog(RiskBoard.game,
						"Congratulations " + GameData.PLAYER_ONE.getName()
								+ " , you have won!", "",
						JOptionPane.INFORMATION_MESSAGE);
				GameData.GAME_OVER = true;
				RiskBoard.endGameState();

			} else if (GameData.PLAYER_THREE.countPlayerProvinces() == 0
					&& GameData.PLAYER_ONE.countPlayerProvinces() == 0) {

				JOptionPane.showInternalMessageDialog(RiskBoard.game,
						"Congratulations " + GameData.PLAYER_TWO.getName()
								+ " , you have won!", "",
						JOptionPane.INFORMATION_MESSAGE);
				GameData.GAME_OVER = true;
				RiskBoard.endGameState();

			}

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
			checkIfReceiveCard();
			GameData.CURRENT_PLAYER = GameData.PLAYER_TWO;
			updateStatistics();
			GameData.COLLECT_ROUND = false;
			RiskBoard.getGameLabel().setText("");

		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_TWO
				&& GameData.PLAYER_AMOUNT == 2) {
			checkIfReceiveCard();
			GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;

			nextRound();
			updateStatistics();
			GameData.COLLECT_ROUND = false;
			RiskBoard.getGameLabel().setText("");
		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_TWO
				&& GameData.PLAYER_AMOUNT == 3) {
			checkIfReceiveCard();
			GameData.CURRENT_PLAYER = GameData.PLAYER_THREE;
			updateStatistics();
			GameData.COLLECT_ROUND = false;
			RiskBoard.getGameLabel().setText("");
		} else if (GameData.CURRENT_PLAYER == GameData.PLAYER_THREE) {
			checkIfReceiveCard();
			GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;

			nextRound();
			updateStatistics();
			GameData.COLLECT_ROUND = false;
			RiskBoard.getGameLabel().setText("");
		}

	}

	public static void nextRound() {

		GameData.ROUND++;

		if (GameData.ROUND > 0) {
			GameData.PLACE_ROUND = false;
		}

	}

	public static void updateStatistics() {

		String roundinfo = "";

		if (GameData.ROUND == 0) {
			roundinfo = "PLACING ROUND - PLEASE DIVIDE YOUR ARMIES!";
		} else {
			RiskBoard.showCardsButton.setEnabled(true);
			roundinfo = "Round <b>" + GameData.ROUND + "</b>";
		}

		String result = "" + roundinfo + "<br><br><b>"
				+ GameData.CURRENT_PLAYER.getName()
				+ " </b> can make a move! <br><br>You can place <b>"
				+ GameData.CURRENT_PLAYER.getUnplacedArmies()
				+ "</b> armies<br><br>You have <b>" + GameData.CURRENT_PLAYER.countPlayerArmies() + "</b> armies on the map <br><br><br> <i>Current Provinces:</i> <br><br>";
		ArrayList<Province> prov = GameData.CURRENT_PLAYER.getPlayerProvince();
		for (Province province : prov) {
			result = result + "<b>" + province.getName() + "</b> - "
					+ province.getCapital() + " - " + province.getArmy()
					+ "<br>";
		}
		RiskBoard.getStatisticsLabel().setText("<html>" + result + "</html>");
		RiskBoard.game.repaint();

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
