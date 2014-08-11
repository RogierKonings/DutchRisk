package gui;

import game.Card;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import data.GameData;
import data.NedCardData;

public class CardBoard extends JFrame {

	private static Container cardBoard;
	private final JLabel cardone = new JLabel();
	private final JLabel cardtwo = new JLabel();
	private final JLabel cardthree = new JLabel();
	private final JLabel cardfour = new JLabel();
	private final JLabel cardfive = new JLabel();

	private final JButton cardTradeButton = new JButton();

	public CardBoard() {

		initialize();
		showCards();

	}

	public void initialize() {

		this.setSize(640, 350);
		this.setLocation(500, 200);
		this.setTitle("CARDS");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		cardBoard = getContentPane();
		cardBoard.setLayout(null);



		cardTradeButton.setBounds(160, 210, 300, 100);
		cardTradeButton.setText("Trade your cards");

		cardBoard.add(cardone);
		cardBoard.add(cardtwo);
		cardBoard.add(cardthree);
		cardBoard.add(cardfour);
		cardBoard.add(cardfive);
		cardBoard.add(cardTradeButton);

		this.setVisible(true);

	}
	
	public void showCards() {
		
		ArrayList<Card> playercards = GameData.CURRENT_PLAYER.getPlayerCards();


		for(int i = 0; i < playercards.size(); i++) {
			
		
			cardone.setBounds(10, 10, 125, 195);
			cardone.setIcon(playercards.get(0).getCardIcon());

			cardtwo.setBounds(135, 10, 125, 195);
			cardtwo.setIcon(playercards.get(1).getCardIcon());

			cardthree.setBounds(255, 10, 125, 195);
			cardthree.setIcon(playercards.get(2).getCardIcon());

			cardfour.setBounds(380, 10, 125, 195);
			cardfour.setIcon(playercards.get(3).getCardIcon());

			cardfive.setBounds(505, 10, 125, 195);
			cardfive.setIcon(playercards.get(4).getCardIcon());

		}
	}
}
