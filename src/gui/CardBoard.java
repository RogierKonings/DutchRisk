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
		this.setTitle("CARDS from " + GameData.CURRENT_PLAYER.getName());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		cardBoard = getContentPane();
		cardBoard.setLayout(null);



		cardTradeButton.setBounds(160, 210, 300, 100);
		cardTradeButton.setText("Trade your cards");
		
		cardTradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
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
	
	public void showCards() {
		
		ArrayList<Card> playercards = GameData.CURRENT_PLAYER.getPlayerCards();


		for(int i = 0; i < playercards.size(); i++) {
			
		if(i == 0) {
			cardone.setBounds(10, 10, 125, 195);
			cardone.setIcon(playercards.get(i).getCardIcon());
		} else if(i == 1) {

			cardtwo.setBounds(135, 10, 125, 195);
			cardtwo.setIcon(playercards.get(i).getCardIcon());
		} else if(i == 2) {

			cardthree.setBounds(255, 10, 125, 195);
			cardthree.setIcon(playercards.get(i).getCardIcon());
		} else if(i == 3) {

			cardfour.setBounds(380, 10, 125, 195);
			cardfour.setIcon(playercards.get(i).getCardIcon());
		} else if(i == 4) {

			cardfive.setBounds(505, 10, 125, 195);
			cardfive.setIcon(playercards.get(i).getCardIcon());
		} else if(i == 5) {
			System.out.println("You have too many cards, please trade some in for armies!");
		}

		}
	}
}
