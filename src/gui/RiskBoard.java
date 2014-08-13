package gui;

import game.Dice;
import game.Province;
import game.RiskGame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import data.GameData;

/**
 * Creates the Graphical User Interface
 * 
 * @author rogier_konings
 * 
 */
public class RiskBoard extends JFrame {

	private static final long serialVersionUID = 9197101390756616661L;
	private static int SCREEN_WIDTH;
	private static int SCREEN_HEIGHT;
	private int BORDER = 50;

	public static Container game;
	private JPanel boardPanel;
	private static JLabel statisticsLabel;
	private static JLabel gameLabel;
	private JLabel attackLabel;
	private JLabel defenceLabel;
	private static JSpinner attackSpinner;
	private static JSpinner defenceSpinner;
	private static JButton attackThrowButton;
	private static JButton defenceThrowButton;
	private static JButton attackButton;
	private static JButton moveButton;
	private static JButton collectButton;
	private static JLabel attackResultLabel1;
	private static JLabel attackResultLabel2;
	private static JLabel attackResultLabel3;
	private static JLabel defenceResultLabel1;
	private static JLabel defenceResultLabel2;
	private static JButton addArmyButton;
	private static JButton removeArmyButton;
	public static JButton showCardsButton;
	private static JButton nextPlayerButton;
	private static JComboBox destinationBox;

	public RiskBoard() {
		initialize();
	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		SCREEN_WIDTH = dim.width - 100;
		SCREEN_HEIGHT = dim.height - 100;

		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setLocation(BORDER, BORDER);
		this.setTitle("RISK - SCENARIO ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		game = getContentPane();
		game.setLayout(null);

		game.add(getStatisticsLabel());
		game.add(getBoardPanel());
		game.add(getGameLabel());
		game.add(getAttackButton());
		game.add(getMoveButton());
		game.add(getCollectButton());
		game.add(getDestinationBox());
		game.add(getAttackLabel());
		game.add(getDefenceLabel());
		game.add(getAttackSpinner());
		game.add(getDefenceSpinner());
		game.add(getAttackThrowButton());
		game.add(getDefenceThrowButton());
		game.add(getAttackResultLabel1());
		game.add(getAttackResultLabel2());
		game.add(getAttackResultLabel3());
		game.add(getDefenceResultLabel1());
		game.add(getDefenceResultLabel2());
		game.add(getAddArmyButton());
		game.add(getRemoveArmyButton());
		game.add(getShowCardsButton());
		game.add(getNextPlayerButton());

		this.setVisible(true);

	}

	public static JLabel getGameLabel() {

		if (gameLabel == null) {
			gameLabel = new JLabel("Game Label", SwingConstants.CENTER);
			gameLabel.setBounds(SCREEN_WIDTH - 300, 5, 300, 220);
			gameLabel.setText("");
		}
		return gameLabel;
	}

	/**
	 * Creates the attack button and checks when pressed for the necessary
	 * requirements before an attack can be initiated
	 * 
	 * @return the attack button
	 */
	public static JButton getAttackButton() {

		if (attackButton == null) {
			attackButton = new JButton("Attack");
			attackButton.setEnabled(false);
			attackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (GameData.COLLECT_ROUND == true) {
						gameLabel.setText("You have already collected!");
					} else {

						attackResultLabel1.setText("");
						attackResultLabel2.setText("");
						attackResultLabel3.setText("");
						defenceResultLabel1.setText("");
						defenceResultLabel2.setText("");

						String result = (String) destinationBox
								.getSelectedItem();
						GameData.setTargetProvince(result);

						if (RiskGame.unplacedArmies() == true) {

							gameLabel
									.setText("There are still armies to be placed!!");

						} else {

							if (GameData.CURRENT_PLAYER
									.isPlayerProvince(GameData.TARGET_PROVINCE) == true) {

								gameLabel
										.setText("You cannot attack your own province!!");

							} else if (GameData.SELECTED_PROVINCE.getArmy() == 1) {
								gameLabel
										.setText("You will need more than one army to attack!");
							} else {

								// returns 0 in case of a 'Yes' answer, 1 in
								// case of
								// a
								// 'No'
								int ATTACK_ANSWER = JOptionPane
										.showConfirmDialog(
												game,
												"Do you want to attack from "
														+ GameData.SELECTED_PROVINCE
																.getName()
														+ " to "
														+ GameData.TARGET_PROVINCE
																.getName()
														+ "?",
												"Confirm Attack",
												JOptionPane.YES_NO_OPTION);

								if (ATTACK_ANSWER == 0) {
									RiskGame.setAttack(true);

									attackResultLabel1.setIcon(null);
									attackResultLabel2.setIcon(null);
									attackResultLabel3.setIcon(null);
									defenceResultLabel1.setIcon(null);
									defenceResultLabel2.setIcon(null);

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
				}
			});

			attackButton.setBounds(SCREEN_WIDTH - 300, 310, 95, 50);
		}
		return attackButton;

	}

	/**
	 * Creates the move button and checks when pressed for the necessary
	 * requirements before a move can be initiated
	 * 
	 * @return the move button
	 */
	public static JButton getMoveButton() {

		if (moveButton == null) {
			moveButton = new JButton("Move");
			moveButton.setEnabled(false);
			moveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					attackResultLabel1.setText("");
					attackResultLabel2.setText("");
					attackResultLabel3.setText("");
					defenceResultLabel1.setText("");
					defenceResultLabel2.setText("");

					String result = (String) destinationBox.getSelectedItem();
					GameData.setTargetProvince(result);

					if (RiskGame.unplacedArmies() == true) {

						gameLabel
								.setText("There are still armies to be placed!!");

					} else {

						if (GameData.CURRENT_PLAYER
								.isPlayerProvince(GameData.TARGET_PROVINCE) != true) {

							gameLabel
									.setText("You cannot move to your enemies province!!");

						} else if (GameData.SELECTED_PROVINCE.getArmy() == 1) {
							gameLabel
									.setText("You will need more than one army to move!");
						} else {

							GameData.SELECTED_PROVINCE.removeArmy();
							GameData.TARGET_PROVINCE.addArmy();
							game.repaint();

						}

					}

				}

			});

			moveButton.setBounds(SCREEN_WIDTH - 200, 310, 95, 50);
		}
		return moveButton;

	}

	/**
	 * Creates the collect button and checks when pressed for the necessary
	 * requirements before a collect can be initiated
	 * 
	 * @return the collect button
	 */
	public static JButton getCollectButton() {

		if (collectButton == null) {
			collectButton = new JButton();
			collectButton.setText("Collect");
			collectButton.setBounds(SCREEN_WIDTH - 100, 310, 95, 50);
			collectButton.setEnabled(false);

			collectButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (GameData.COLLECT_ROUND == true) {
						gameLabel.setText("You have already collected!");
					} else {

						if (GameData.ATTACK_RUNNING == true) {

							gameLabel
									.setText("<html>You cannot collect! <br><br> You have already attacked!!</html>");

						} else {

							int armiestobereceived = GameData.CURRENT_PLAYER
									.countPlayerProvinces() / 3;
							GameData.CURRENT_PLAYER
									.setUnplacedArmies(armiestobereceived);
							gameLabel.setText("You get " + armiestobereceived
									+ " armies!");
							RiskGame.updateStatistics();

							GameData.COLLECT_ROUND = true;

						}
					}
				}

			});

		}
		return collectButton;
	}

	/**
	 * The list of possible destinations from the selected province
	 * 
	 * @return the list
	 */
	public static JComboBox getDestinationBox() {

		if (destinationBox == null) {
			destinationBox = new JComboBox();
			destinationBox.setBounds(SCREEN_WIDTH - 225, 370, 140, 50);
		}
		return destinationBox;
	}

	/**
	 * The label displaying all the statistics
	 * 
	 * @return the label
	 */
	public static JLabel getStatisticsLabel() {

		if (statisticsLabel == null) {
			statisticsLabel = new JLabel();
			statisticsLabel.setBounds(20, 100, 300, 800);
			statisticsLabel.setVerticalAlignment(JLabel.TOP);
		}

		return statisticsLabel;
	}

	/**
	 * The board panel - the map image is added to this panel
	 * 
	 * @return the panel
	 */
	public JPanel getBoardPanel() {

		if (boardPanel == null) {
			boardPanel = new JPanel();
			boardPanel.setBounds(5, 5, SCREEN_WIDTH - 320, SCREEN_HEIGHT);
			RiskMap riskmap = new RiskMap(new ImageIcon(getClass().getResource(
					"/img/maps/NL-map.jpg")).getImage());

			boardPanel.add(riskmap);
		}
		return boardPanel;
	}

	/**
	 * Creates a JSpinner for the attacking player to select the amount of dice
	 * 
	 * @return JSpinner
	 */
	public static JSpinner getAttackSpinner() {

		if (attackSpinner == null) {

			Dice dices[] = new Dice[] { GameData.dice1, GameData.dice2,
					GameData.dice3 };

			attackSpinner = new JSpinner(new SpinnerListModel(dices));
			attackSpinner.setBounds(SCREEN_WIDTH - 260, 485, 40, 30);
			attackSpinner.setEditor(new IconEditor(attackSpinner));

			attackSpinner.setEnabled(false);

		}
		return attackSpinner;
	}

	/**
	 * Creates a JSpinner for the defending player to select the amount of dice
	 * 
	 * @return JSpinner
	 */
	public static JSpinner getDefenceSpinner() {

		if (defenceSpinner == null) {

			Dice dices[] = new Dice[] { GameData.dice1, GameData.dice2 };

			defenceSpinner = new JSpinner(new SpinnerListModel(dices));
			defenceSpinner.setBounds(SCREEN_WIDTH - 260, 485, 40, 30);
			defenceSpinner.setEditor(new IconEditor(defenceSpinner));

			defenceSpinner.setBounds(SCREEN_WIDTH - 110, 485, 40, 30);
			defenceSpinner.setEnabled(false);
		}
		return defenceSpinner;
	}

	/**
	 * The button to press in order to throw the attacking dice - the dice eyes
	 * are collected in an array
	 * 
	 * @return JButton
	 */
	public static JButton getAttackThrowButton() {

		if (attackThrowButton == null) {
			attackThrowButton = new JButton("Throw");
			attackThrowButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int dice = ((Dice) attackSpinner.getValue())
							.getDiceNumber();
					System.out.println("Dice " + dice + " selected!");

					if (dice > GameData.SELECTED_PROVINCE.getArmy() - 1) {

						getGameLabel()
								.setText("You do not have enough armies!");

					} else {
						GameData.attackResult = null;
						GameData.attackResult = RiskGame.diceThrow(dice);
						int[] attackArray = new int[dice];
						attackArray = GameData.attackResult;

						// String result = "";

						for (int i = 0; i < attackArray.length; i++) {

							if (dice == 1) {

								int resultnum = attackArray[0];
								ImageIcon resultimg = GameData.dices[resultnum - 1]
										.getDiceIcon();

								attackResultLabel1.setIcon(resultimg);

								game.repaint();
							} else if (dice == 2) {

								int resultnum1 = attackArray[0];
								int resultnum2 = attackArray[1];
								ImageIcon resultimg1 = GameData.dices[resultnum1 - 1]
										.getDiceIcon();
								ImageIcon resultimg2 = GameData.dices[resultnum2 - 1]
										.getDiceIcon();

								attackResultLabel1.setIcon(resultimg1);
								attackResultLabel2.setIcon(resultimg2);

								game.repaint();
							} else if (dice == 3) {
								int resultnum1 = attackArray[0];
								int resultnum2 = attackArray[1];
								int resultnum3 = attackArray[2];

								ImageIcon resultimg1 = GameData.dices[resultnum1 - 1]
										.getDiceIcon();
								ImageIcon resultimg2 = GameData.dices[resultnum2 - 1]
										.getDiceIcon();
								ImageIcon resultimg3 = GameData.dices[resultnum3 - 1]
										.getDiceIcon();

								attackResultLabel1.setIcon(resultimg1);
								attackResultLabel2.setIcon(resultimg2);
								attackResultLabel3.setIcon(resultimg3);

								game.repaint();
							}

							// result = result + " " + attackArray[i];
						}

						// attackResultLabel1.setText(result);
						attackThrowButton.setEnabled(false);
					}
				}

			});
			attackThrowButton.setBounds(SCREEN_WIDTH - 280, 550, 100, 100);
			attackThrowButton.setEnabled(false);
		}
		return attackThrowButton;
	}

	/**
	 * The button to press in order to throw the defending dice - the dice eyes
	 * are collected in an array - afterwards a calculation is made who won/
	 * lost the attack
	 * 
	 * @return JButton
	 */
	public static JButton getDefenceThrowButton() {

		if (defenceThrowButton == null) {

			defenceThrowButton = new JButton("Throw");
			defenceThrowButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// int dice = (Integer) defenceSpinner.getValue();

					int dice = ((Dice) defenceSpinner.getValue())
							.getDiceNumber();

					if (dice > (Integer) ((Dice) attackSpinner.getValue())
							.getDiceNumber()
							&& GameData.SELECTED_PROVINCE.getArmy() < 3) {

						getGameLabel().setText(
								"You can only defend with one army!");
					}

					else if (dice > GameData.TARGET_PROVINCE.getArmy()) {

						getGameLabel()
								.setText("You do not have enough armies!");
					} else {
						GameData.defenceResult = null;
						GameData.defenceResult = RiskGame.diceThrow(dice);
						int[] defenceArray = new int[dice];
						defenceArray = GameData.defenceResult;

						for (int i = 0; i < defenceArray.length; i++) {

							if (dice == 1) {

								int resultnum = defenceArray[0];
								ImageIcon resultimg = GameData.dices[resultnum - 1]
										.getDiceIcon();

								defenceResultLabel1.setIcon(resultimg);

								game.repaint();
							} else if (dice == 2) {

								int resultnum1 = defenceArray[0];
								int resultnum2 = defenceArray[1];
								ImageIcon resultimg1 = GameData.dices[resultnum1 - 1]
										.getDiceIcon();
								ImageIcon resultimg2 = GameData.dices[resultnum2 - 1]
										.getDiceIcon();

								defenceResultLabel1.setIcon(resultimg1);
								defenceResultLabel2.setIcon(resultimg2);

								game.repaint();
							}

						}

						defenceThrowButton.setEnabled(false);

						RiskGame.attackInitiated();
						game.repaint();
					}
				}
			});
			defenceThrowButton.setBounds(SCREEN_WIDTH - 130, 550, 100, 100);
			defenceThrowButton.setEnabled(false);

		}
		return defenceThrowButton;
	}

	public JLabel getAttackLabel() {

		if (attackLabel == null) {
			attackLabel = new JLabel("Attack");
			attackLabel.setBounds(SCREEN_WIDTH - 260, 460, 60, 15);
		}
		return attackLabel;
	}

	public JLabel getDefenceLabel() {

		if (defenceLabel == null) {
			defenceLabel = new JLabel("Defence");
			defenceLabel.setBounds(SCREEN_WIDTH - 110, 460, 60, 15);
		}
		return defenceLabel;
	}

	public JLabel getAttackResultLabel1() {

		if (attackResultLabel1 == null) {
			attackResultLabel1 = new JLabel();
			attackResultLabel1.setBounds(SCREEN_WIDTH - 255, 660, 20, 20);
		}
		return attackResultLabel1;
	}

	public JLabel getAttackResultLabel2() {

		if (attackResultLabel2 == null) {
			attackResultLabel2 = new JLabel();
			attackResultLabel2.setBounds(SCREEN_WIDTH - 235, 660, 20, 20);
		}
		return attackResultLabel2;
	}

	public JLabel getAttackResultLabel3() {

		if (attackResultLabel3 == null) {
			attackResultLabel3 = new JLabel();
			attackResultLabel3.setBounds(SCREEN_WIDTH - 215, 660, 20, 20);
		}
		return attackResultLabel3;
	}

	public JLabel getDefenceResultLabel1() {

		if (defenceResultLabel1 == null) {
			defenceResultLabel1 = new JLabel();
			defenceResultLabel1.setBounds(SCREEN_WIDTH - 105, 660, 20, 20);
		}
		return defenceResultLabel1;
	}

	public JLabel getDefenceResultLabel2() {

		if (defenceResultLabel2 == null) {
			defenceResultLabel2 = new JLabel();
			defenceResultLabel2.setBounds(SCREEN_WIDTH - 85, 660, 60, 20);
		}
		return defenceResultLabel2;
	}

	/**
	 * Button to add an army
	 * 
	 * @return JButton
	 */
	public static JButton getAddArmyButton() {

		if (addArmyButton == null) {
			addArmyButton = new JButton("Add Army");

			addArmyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (GameData.SELECTED_PROVINCE == null) {
						getGameLabel().setText("Please select a Province!");
					} else {

						RiskGame.addUnit();
						game.repaint();
					}
				}
			});
			addArmyButton.setEnabled(true);
			addArmyButton.setBounds(SCREEN_WIDTH - 300, 700, 140, 65);
		}

		return addArmyButton;
	}

	/**
	 * Button to remove an army
	 * 
	 * @return JButton
	 */
	public static JButton getRemoveArmyButton() {

		if (removeArmyButton == null) {
			removeArmyButton = new JButton("Remove Army");

			removeArmyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (GameData.SELECTED_PROVINCE == null) {
						RiskBoard.getGameLabel().setText(
								"Please select a Province!");
					} else {

						RiskGame.removeUnit();
						game.repaint();
					}

				}
			});
			removeArmyButton.setBounds(SCREEN_WIDTH - 150, 700, 140, 65);
		}

		return removeArmyButton;
	}

	/**
	 * Button to show the cards that the player currently has
	 * 
	 * @return JButton
	 */
	public JButton getShowCardsButton() {

		if (showCardsButton == null) {
			showCardsButton = new JButton("Show your cards");

			showCardsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardBoard cardboard = new CardBoard();

				}
			});

			showCardsButton.setBounds(SCREEN_WIDTH - 300, 765, 290, 65);
			showCardsButton.setEnabled(false);
		}
		return showCardsButton;
	}

	/**
	 * Button the press to go to the next player
	 * 
	 * @return JButton
	 */
	public JButton getNextPlayerButton() {

		if (nextPlayerButton == null) {
			nextPlayerButton = new JButton("Next Player");

			nextPlayerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GameData.ATTACK_RUNNING = false;
					addArmyButton.setEnabled(false);
					removeArmyButton.setEnabled(false);

					if (GameData.CURRENT_PLAYER.getUnplacedArmies() > 0) {
						gameLabel.setText("Place your armies first!");
					} else {

						RiskGame.nextPlayer();
						game.repaint();
					}

				}
			});

			nextPlayerButton.setBounds(SCREEN_WIDTH - 300, 830, 290, 65);
		}
		return nextPlayerButton;
	}

	/**
	 * Shows the destinations that can be moved/ attack to from the selected
	 * province
	 */
	public static void showDestinations() {
		if (GameData.GAME_RUNNING == true && GameData.SELECTED_PROVINCE != null) {

			getDestinationBox().removeAllItems();

			Province[] des = new Province[GameData.SELECTED_PROVINCE
					.getDestinations().length - 1];

			des = GameData.SELECTED_PROVINCE.getDestinations();

			for (int i = 0; i < des.length; i++) {

				getDestinationBox().addItem(des[i].getName());

			}
		}

	}

	/**
	 * Initiated when a player wins the game
	 */
	public static void endGameState() {

		attackButton.setEnabled(false);
		moveButton.setEnabled(false);
		collectButton.setEnabled(false);
		nextPlayerButton.setEnabled(false);
		showCardsButton.setEnabled(false);
		destinationBox.setEnabled(false);

	}
}