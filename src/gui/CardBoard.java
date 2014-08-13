package gui;

import game.Card;
import game.RiskGame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import data.CardType;
import data.GameData;

/**
 * Class responsible for displaying the players cards - this tactic is chosen so
 * that the other player can look away when the current player is checking their
 * cards.
 * 
 * @author rogier_konings
 * 
 */
public class CardBoard extends JFrame {

	private static Container cardBoard;
	private final JLabel cardone = new JLabel();
	private final JLabel cardtwo = new JLabel();
	private final JLabel cardthree = new JLabel();
	private final JLabel cardfour = new JLabel();
	private final JLabel cardfive = new JLabel();

	private static Card card1;
	private static Card card2;
	private static Card card3;
	private static Card card4;
	private static Card card5;

	private ArrayList<Card> playercards;

	private final JButton cardTradeButton = new JButton();

	public CardBoard() {

		initialize();
		showCards();
		checkIfEnoughCards();

	}

	public void initialize() {

		this.setSize(640, 350);
		this.setLocation(500, 200);
		this.setTitle("CARDS from " + GameData.CURRENT_PLAYER.getName());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		cardBoard = getContentPane();
		cardBoard.setLayout(null);

		cardTradeButton.setBounds(160, 210, 300, 100);
		cardTradeButton.setText("Trade your cards");
		cardTradeButton.setEnabled(false);

		/**
		 * Elaborate algorithm to check how many armies a player receives when
		 * submitting their cards.
		 * 
		 * Three cannons will yield four armies Three soldiers will yield six
		 * armies Three horses will yield 8 armies Three different cards will
		 * yield 10 armies
		 * 
		 * If the player is currently holding some of the provinces written on
		 * the cards, the player will receive an extra army on THAT province A
		 * maximum of five cards is set - not only would six cards
		 * expontentially increase the line of coding of this Class, classic
		 * Risk rules also constitute five cards maximum
		 */
		cardTradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int count = 0;

				for (int i = 0; i < playercards.size(); i++) {

					if (i == 0) {
						card1 = playercards.get(i);
					} else if (i == 1) {
						card2 = playercards.get(i);
					} else if (i == 2) {
						card3 = playercards.get(i);

						if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card3.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {

								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);

								GameData.CURRENT_PLAYER.setUnplacedArmies(4);

							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}

							count++;

							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}

							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}

							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);

							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card3.getCardType()
								&& card1.getCardType() != card3.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							} else if (GameData.CURRENT_PLAYER
									.isPlayerProvince(card2.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							} else if (GameData.CURRENT_PLAYER
									.isPlayerProvince(card3.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();
						}

					} else if (i == 3) {
						card4 = playercards.get(i);

						if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card3.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);

							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}

							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card4.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);

							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								System.out
										.println("Three horses, you get 8 armies!");
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}

							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() == card3.getCardType()
								&& card3.getCardType() == card4.getCardType()) {

							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card2.getCardType() == card3.getCardType()
								&& card3.getCardType() == card4.getCardType()) {
							if (card2.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card2.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card2.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card3.getCardType()
								&& card1.getCardType() != card3.getCardType()) {

							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							} else if (GameData.CURRENT_PLAYER
									.isPlayerProvince(card2.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							} else if (GameData.CURRENT_PLAYER
									.isPlayerProvince(card3.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card4.getCardType()
								&& card1.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card3.getCardType()
								&& card3.getCardType() != card4.getCardType()
								&& card1.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card2.getCardType() != card3.getCardType()
								&& card3.getCardType() != card4.getCardType()
								&& card2.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();

						}

					} else if (i == 4) {
						card5 = playercards.get(i);

						if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card3.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card4.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() == card3.getCardType()
								&& card3.getCardType() == card4.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() == card2.getCardType()
								&& card2.getCardType() == card5.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() == card3.getCardType()
								&& card3.getCardType() == card5.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() == card4.getCardType()
								&& card4.getCardType() == card5.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() == card3.getCardType()
								&& card3.getCardType() == card4.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() == card3.getCardType()
								&& card3.getCardType() == card5.getCardType()) {
							if (card1.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card1.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card1.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card5.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() == card4.getCardType()
								&& card4.getCardType() == card5.getCardType()) {
							if (card2.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card2.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card2.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(8);
							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card3.getCardType() == card4.getCardType()
								&& card4.getCardType() == card5.getCardType()) {
							if (card3.getCardType() == CardType.CANNON) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three cannons, you get 4 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(4);
							} else if (card3.getCardType() == CardType.SOLDIER) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three soldiers, you get 6 armies!",
										"", JOptionPane.INFORMATION_MESSAGE);
								GameData.CURRENT_PLAYER.setUnplacedArmies(6);
							} else if (card3.getCardType() == CardType.HORSE) {
								JOptionPane.showInternalMessageDialog(
										cardBoard,
										"Three horses, you get 8 armies!", "",
										JOptionPane.INFORMATION_MESSAGE);

							}
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card3.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card3.getCardType()
								&& card1.getCardType() != card3.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card3.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							RiskGame.updateStatistics();

						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card4.getCardType()
								&& card1.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() != card3.getCardType()
								&& card3.getCardType() != card4.getCardType()
								&& card1.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() != card3.getCardType()
								&& card3.getCardType() != card4.getCardType()
								&& card2.getCardType() != card4.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card4.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() != card2.getCardType()
								&& card2.getCardType() != card5.getCardType()
								&& card1.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card2.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardtwo.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() != card3.getCardType()
								&& card3.getCardType() != card5.getCardType()
								&& card1.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card3.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardthree.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card1.getCardType() != card4.getCardType()
								&& card4.getCardType() != card5.getCardType()
								&& card1.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card1
									.getCardProvince()) == true) {
								card1.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card1.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardone.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() != card3.getCardType()
								&& card3.getCardType() != card5.getCardType()
								&& card2.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card3.setPlayer(null);
							card5.setPlayer(null);
							cardtwo.setEnabled(false);
							cardthree.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card2.getCardType() != card4.getCardType()
								&& card4.getCardType() != card5.getCardType()
								&& card2.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card2
									.getCardProvince()) == true) {
								card2.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card2.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardtwo.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						} else if (count == 0
								&& card3.getCardType() != card4.getCardType()
								&& card4.getCardType() != card5.getCardType()
								&& card3.getCardType() != card5.getCardType()) {
							JOptionPane
									.showInternalMessageDialog(
											cardBoard,
											"Three different cards, you get 10 armies!",
											"", JOptionPane.INFORMATION_MESSAGE);
							GameData.CURRENT_PLAYER.setUnplacedArmies(10);
							count++;
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card3
									.getCardProvince()) == true) {
								card3.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card4
									.getCardProvince()) == true) {
								card4.getCardProvince().addArmy();
							}
							if (GameData.CURRENT_PLAYER.isPlayerProvince(card5
									.getCardProvince()) == true) {
								card5.getCardProvince().addArmy();
							}
							card3.setPlayer(null);
							card4.setPlayer(null);
							card5.setPlayer(null);
							cardthree.setEnabled(false);
							cardfour.setEnabled(false);
							cardfive.setEnabled(false);
							RiskGame.updateStatistics();
						}

					}
				}

			}
		});

		cardBoard.add(cardone);
		cardBoard.add(cardtwo);
		cardBoard.add(cardthree);
		cardBoard.add(cardfour);
		cardBoard.add(cardfive);
		cardBoard.add(cardTradeButton);

		this.setVisible(true);

	}

	/**
	 * Shows the cards that the player is currently holding
	 */
	public void showCards() {

		playercards = GameData.CURRENT_PLAYER.getPlayerCards();

		for (int i = 0; i < playercards.size(); i++) {

			if (i == 0) {
				cardone.setBounds(10, 10, 125, 195);
				cardone.setIcon(playercards.get(i).getCardIcon());
			} else if (i == 1) {

				cardtwo.setBounds(135, 10, 125, 195);
				cardtwo.setIcon(playercards.get(i).getCardIcon());
			} else if (i == 2) {

				cardthree.setBounds(255, 10, 125, 195);
				cardthree.setIcon(playercards.get(i).getCardIcon());
			} else if (i == 3) {

				cardfour.setBounds(380, 10, 125, 195);
				cardfour.setIcon(playercards.get(i).getCardIcon());
			} else if (i == 4) {

				cardfive.setBounds(505, 10, 125, 195);
				cardfive.setIcon(playercards.get(i).getCardIcon());
			} else if (i == 5) {
				System.out
						.println("You have too many cards, please trade some in for armies!");
			}

		}
	}

	/**
	 * Checks whether the playing is holding three or more cards - in the case
	 * of a lower amount of cards, the button will not be enabled
	 */
	public void checkIfEnoughCards() {
		if (playercards.size() >= 3) {

			cardTradeButton.setEnabled(true);
		}
	}

	public void removeUsedCards() {
		// Under development - add code her so that the submitted cards are
		// returned on the bottom of the pile
	}
}
