package gui;

import game.RiskGame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import data.GameData;
import data.NLmap;
import data.Province;

/**
 * 
 * @author rogier_konings
 * 
 */
public class RiskBoard extends JFrame {

	private static final long serialVersionUID = 9197101390756616661L;
	private static int SCREEN_WIDTH;
	private static int SCREEN_HEIGHT;
	private int BORDER = 50;
	private static int ATTACK_ANSWER;

	private static Container game;
	private static JPanel boardPanel;
	private static JLabel statisticsLabel;
	private static JLabel gameLabel;
	private static JLabel attackLabel;
	private static JLabel defenceLabel;
	private static JSpinner attackSpinner;
	private static JSpinner defenceSpinner;
	private static JButton attackThrowButton;
	private static JButton defenceThrowButton;
	private static JButton attackButton;
	private static JLabel attackResultLabel;
	private static JLabel defenceResultLabel;
	private static JButton addArmyButton;
	private static JButton removeArmyButton;
	private static JButton nextPlayerButton;
	private static JComboBox destinationBox;

	GameData gamedata;
	ArrayList<Province> countrydata;

	// static int[] attackResultArray;
	// static int[] defenceResultArray;

	public RiskBoard() {

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		SCREEN_WIDTH = dim.width - 100;
		SCREEN_HEIGHT = dim.height - 100;

		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setLocation(BORDER, BORDER);
		this.setTitle("RISK");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		game = getContentPane();
		game.setLayout(null);

		game.add(getStatisticsLabel());
		game.add(getBoardPanel());
		game.add(getGameLabel());
		game.add(getAttackButton());
		game.add(getDestinationBox());
		game.add(getAttackLabel());
		game.add(getDefenceLabel());
		game.add(getAttackSpinner());
		game.add(getDefenceSpinner());
		game.add(getAttackThrowButton());
		game.add(getDefenceThrowButton());
		game.add(getAttackResultLabel());
		game.add(getDefenceResultLabel());
		game.add(getAddArmyButton());
		game.add(getRemoveArmyButton());
		game.add(getNextPlayerButton());

		this.setVisible(true);

	}

	public static JLabel getGameLabel() {

		if (gameLabel == null) {
			gameLabel = new JLabel("Game Label", SwingConstants.CENTER);
			gameLabel.setBounds(SCREEN_WIDTH - 300, 5, 300, 220);
			gameLabel.setText("Game Label");
		}
		return gameLabel;
	}

	public static JButton getAttackButton() {

		if (attackButton == null) {
			attackButton = new JButton("Attack");
			attackButton.setEnabled(false);
			attackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					attackResultLabel.setText("");
					defenceResultLabel.setText("");

					String result = (String) destinationBox.getSelectedItem();
					RiskGame.setTargetProvince(result);

					if (RiskGame.unplacedArmies() == true) {

						gameLabel.setText(
								"There are still armies to be placed!!");

					} else {

						if (RiskGame.getCurrentPlayer().isPlayerProvince(
								RiskGame.getTargetProvince()) == true) {

							gameLabel
									.setText("You cannot attack your own province!!");

						} else {

							// returns 0 in case of a 'Yes' answer, 1 in case of
							// a
							// 'No'
							ATTACK_ANSWER = JOptionPane
									.showConfirmDialog(
											game,
											"Do you want to attack from "
													+ RiskGame
															.getSelectedProvince()
															.getName()
													+ " to "
													+ RiskGame
															.getTargetProvince()
															.getName() + "?",
											"Confirm Attack",
											JOptionPane.YES_NO_OPTION);

							if (ATTACK_ANSWER == 0) {
								RiskGame.setAttack(true);
								gameLabel
										.setText("You may now select the amount of armies!");
								attackSpinner.setEnabled(true);
								defenceSpinner.setEnabled(true);
								attackThrowButton.setEnabled(true);
								defenceThrowButton.setEnabled(true);
							}
						}
					}
				}
			});
			attackButton.setBounds(SCREEN_WIDTH - 250, 310, 190, 50);
		}
		return attackButton;
	}

	public static JComboBox getDestinationBox() {

		if (destinationBox == null) {
			destinationBox = new JComboBox();
			destinationBox.setBounds(SCREEN_WIDTH - 225, 370, 140, 50);
		}
		return destinationBox;
	}

	public static JLabel getStatisticsLabel() {

		if (statisticsLabel == null) {
			statisticsLabel = new JLabel();
			statisticsLabel.setBounds(20, 100, 300, 800);
			statisticsLabel.setVerticalAlignment(JLabel.TOP);
		}

		return statisticsLabel;
	}

	public static JPanel getBoardPanel() {

		if (boardPanel == null) {
			boardPanel = new JPanel();
			boardPanel.setBounds(5, 5, SCREEN_WIDTH - 320, SCREEN_HEIGHT - 10);
			RiskMap riskmap = new RiskMap(new ImageIcon(
					"../Risk/src/img/NL.jpg").getImage());
			
			NLmap nlsettings = new NLmap();
			
			boardPanel.add(riskmap);
		}
		return boardPanel;
	}

	public static JSpinner getAttackSpinner() {

		if (attackSpinner == null) {
			SpinnerNumberModel attackdice = new SpinnerNumberModel(1, 1, 3, 1);
			attackSpinner = new JSpinner(attackdice);
			attackSpinner.setBounds(SCREEN_WIDTH - 260, 485, 40, 30);
			attackSpinner.setEnabled(false);
		}
		return attackSpinner;
	}

	public static JSpinner getDefenceSpinner() {

		if (defenceSpinner == null) {
			SpinnerNumberModel defenddice = new SpinnerNumberModel(1, 1, 2, 1);
			defenceSpinner = new JSpinner(defenddice);
			defenceSpinner.setBounds(SCREEN_WIDTH - 110, 485, 40, 30);
			defenceSpinner.setEnabled(false);
		}
		return defenceSpinner;
	}

	public static JButton getAttackThrowButton() {

		if (attackThrowButton == null) {
			attackThrowButton = new JButton("Throw");
			attackThrowButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dice = (Integer) attackSpinner.getValue();
					GameData.setAttackResultArray(RiskGame.diceThrow(dice));
					int[] attackArray = new int[dice];
					attackArray = GameData.getAttackResultArray();

					String result = "";

					for (int i = 0; i < attackArray.length; i++) {
						result = result + " " + attackArray[i];
					}
					attackResultLabel.setText(result);
					attackThrowButton.setEnabled(false);
				}

			});
			attackThrowButton.setBounds(SCREEN_WIDTH - 280, 550, 100, 100);
			attackThrowButton.setEnabled(false);
		}
		return attackThrowButton;
	}

	public static JButton getDefenceThrowButton() {

		if (defenceThrowButton == null) {

			defenceThrowButton = new JButton("Throw");
			defenceThrowButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dice = (Integer) defenceSpinner.getValue();
					GameData.setDefenceResultArray(RiskGame.diceThrow(dice));
					int[] defenceArray = new int[dice];
					defenceArray = GameData.getDefenceResultArray();

					String result = "";

					for (int i = 0; i < defenceArray.length; i++) {
						result = result + " " + defenceArray[i];
					}
					defenceResultLabel.setText(result);
					defenceThrowButton.setEnabled(false);

					RiskGame.attackInitiated();
				}
			});
			defenceThrowButton.setBounds(SCREEN_WIDTH - 130, 550, 100, 100);
			defenceThrowButton.setEnabled(false);

		}
		return defenceThrowButton;
	}

	public static JLabel getAttackLabel() {

		if (attackLabel == null) {
			attackLabel = new JLabel("Attack");
			attackLabel.setBounds(SCREEN_WIDTH - 260, 460, 60, 15);
		}
		return attackLabel;
	}

	public static JLabel getDefenceLabel() {

		if (defenceLabel == null) {
			defenceLabel = new JLabel("Defence");
			defenceLabel.setBounds(SCREEN_WIDTH - 110, 460, 60, 15);
		}
		return defenceLabel;
	}

	public static JLabel getAttackResultLabel() {

		if (attackResultLabel == null) {
			attackResultLabel = new JLabel();
			attackResultLabel.setBounds(SCREEN_WIDTH - 255, 660, 60, 20);
		}
		return attackResultLabel;
	}

	public static JLabel getDefenceResultLabel() {

		if (defenceResultLabel == null) {
			defenceResultLabel = new JLabel();
			defenceResultLabel.setBounds(SCREEN_WIDTH - 105, 660, 60, 20);
		}
		return defenceResultLabel;
	}

	public static JButton getAddArmyButton() {

		if (addArmyButton == null) {
			addArmyButton = new JButton("Add Army");

			addArmyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					RiskGame.addUnit();

				}
			});
			addArmyButton.setEnabled(false);
			addArmyButton.setBounds(SCREEN_WIDTH - 300, 755, 140, 65);
		}

		return addArmyButton;
	}

	public static JButton getRemoveArmyButton() {

		if (removeArmyButton == null) {
			removeArmyButton = new JButton("Remove Army");

			removeArmyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					RiskGame.removeUnit();

				}
			});
			removeArmyButton.setBounds(SCREEN_WIDTH - 150, 755, 140, 65);
		}

		return removeArmyButton;
	}

	public static JButton getNextPlayerButton() {

		if (nextPlayerButton == null) {
			nextPlayerButton = new JButton("Next Player");

			nextPlayerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					RiskGame.nextPlayer();
					addArmyButton.setEnabled(true);

				}
			});

			nextPlayerButton.setBounds(SCREEN_WIDTH - 300, 830, 290, 65);
		}
		return nextPlayerButton;
	}

	public static void main(String[] args) {

		RiskGame game = new RiskGame();
		game.newGame();

	}
}