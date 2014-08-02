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
import data.Province;

/**
 * 
 * @author rogier_konings
 *
 */
public class RiskBoard extends JFrame {

	private static final long serialVersionUID = 9197101390756616661L;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int BORDER = 50;
	private int ATTACK_ANSWER;

	private Container game;
	private JPanel boardPanel;
	private static JLabel statisticsLabel;
	private static JLabel gameLabel;
	private JLabel attackLabel;
	private JLabel defenceLabel;
	private JSpinner attackSpinner;
	private JSpinner defenceSpinner;
	private JButton attackThrowButton;
	private JButton defenceThrowButton;
	private static JButton attackButton;
	//private JButton defenceButton;
	private JLabel attackResultLabel;
	private JLabel defenceResultLabel;
	private static JButton addArmyButton;
	private static JButton removeArmyButton;
	private JButton nextPlayerButton;
	private static JComboBox destinationBox;

	GameData gamedata;
	ArrayList<Province> countrydata;

	int[] attackResultArray;
	int[] defenceResultArray;

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

		statisticsLabel = new JLabel();
		statisticsLabel.setBounds(20, 100, 300, 800);
		statisticsLabel.setVerticalAlignment(JLabel.TOP);

		game.add(statisticsLabel);

		boardPanel = new JPanel();
		boardPanel.setBounds(5, 5, SCREEN_WIDTH - 320, SCREEN_HEIGHT - 10);
		game.add(boardPanel);

		RiskMap riskmap = new RiskMap(
				new ImageIcon("../Risk/src/img/NL.jpg").getImage());
		boardPanel.add(riskmap);

		gameLabel = new JLabel("Game Label", SwingConstants.CENTER);
		gameLabel.setBounds(SCREEN_WIDTH - 300, 5, 300, 220);
		gameLabel.setText("Game Label");
		game.add(gameLabel);

		attackButton = new JButton("Attack");
		attackButton.setEnabled(false);
		attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String result = (String)destinationBox.getSelectedItem();
				RiskGame.setTargetProvince(result);
				
				//returns 0 in case of a 'Yes' answer, 1 in case of a 'No' answer
				ATTACK_ANSWER = JOptionPane.showConfirmDialog(game, "Do you want to attack from " + RiskGame.getSelectedProvince().getName() + " to " + RiskGame.getTargetProvince().getName() + "?", "Confirm Attack", JOptionPane.YES_NO_OPTION);
				
				if(ATTACK_ANSWER == 0) {
					RiskGame.setAttack(true);
					gameLabel.setText("You may now select the amount of armies!");
					attackSpinner.setEnabled(true);
					defenceSpinner.setEnabled(true);
					attackThrowButton.setEnabled(true);
					defenceThrowButton.setEnabled(true);
				}
			}
		});
		attackButton.setBounds(SCREEN_WIDTH - 250, 310, 190, 50);
		game.add(attackButton);

		//defenceButton = new JButton("Defend");
		//defenceButton.setBounds(SCREEN_WIDTH - 150, 310, 140, 50);
		//game.add(defenceButton);
		
		destinationBox = new JComboBox();
		destinationBox.setBounds(SCREEN_WIDTH - 225, 370, 140, 50);
		game.add(destinationBox);

		attackLabel = new JLabel("Attack");
		attackLabel.setBounds(SCREEN_WIDTH - 260, 460, 60, 15);
		game.add(attackLabel);

		defenceLabel = new JLabel("Defence");
		defenceLabel.setBounds(SCREEN_WIDTH - 110, 460, 60, 15);
		game.add(defenceLabel);

		SpinnerNumberModel attackdice = new SpinnerNumberModel(1, 1, 3, 1);
		attackSpinner = new JSpinner(attackdice);
		attackSpinner.setBounds(SCREEN_WIDTH - 260, 485, 40, 30);
		attackSpinner.setEnabled(false);
		game.add(attackSpinner);

		SpinnerNumberModel defenddice = new SpinnerNumberModel(1, 1, 2, 1);
		defenceSpinner = new JSpinner(defenddice);
		defenceSpinner.setBounds(SCREEN_WIDTH - 110, 485, 40, 30);
		defenceSpinner.setEnabled(false);
		game.add(defenceSpinner);

		attackThrowButton = new JButton("Throw");
		attackThrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dice = (Integer) attackSpinner.getValue();
				attackResultArray = RiskGame.diceThrow(dice);
				String result = "";

				for (int i = 0; i < attackResultArray.length; i++) {
					result = result + " " + attackResultArray[i];
				}
				attackResultLabel.setText(result);
			}

		});
		attackThrowButton.setBounds(SCREEN_WIDTH - 280, 550, 100, 100);
		attackThrowButton.setEnabled(false);
		game.add(attackThrowButton);

		defenceThrowButton = new JButton("Throw");
		defenceThrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dice = (Integer) defenceSpinner.getValue();
				defenceResultArray = RiskGame.diceThrow(dice);
				String result = "";

				for (int i = 0; i < defenceResultArray.length; i++) {
					result = result + " " + defenceResultArray[i];
				}
				defenceResultLabel.setText(result);
			}
		});
		defenceThrowButton.setBounds(SCREEN_WIDTH - 130, 550, 100, 100);
		defenceThrowButton.setEnabled(false);
		game.add(defenceThrowButton);

		attackResultLabel = new JLabel("result");
		attackResultLabel.setBounds(SCREEN_WIDTH - 255, 660, 60, 20);
		game.add(attackResultLabel);

		defenceResultLabel = new JLabel("result");
		defenceResultLabel.setBounds(SCREEN_WIDTH - 105, 660, 60, 20);
		game.add(defenceResultLabel);

		addArmyButton = new JButton("Add Army");

		addArmyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RiskGame.addUnit();

			}
		});
		addArmyButton.setEnabled(false);
		addArmyButton.setBounds(SCREEN_WIDTH - 300, 755, 140, 65);
		game.add(addArmyButton);

		removeArmyButton = new JButton("Remove Army");

		removeArmyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RiskGame.removeUnit();

			}
		});
		//removeArmyButton.setEnabled(false);
		removeArmyButton.setBounds(SCREEN_WIDTH - 150, 755, 140, 65);
		game.add(removeArmyButton);

		nextPlayerButton = new JButton("Next Player");

		nextPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RiskGame.nextPlayer();
				addArmyButton.setEnabled(true);

			}
		});

		nextPlayerButton.setBounds(SCREEN_WIDTH - 300, 830, 290, 65);
		game.add(nextPlayerButton);

		this.setVisible(true);

	}

	public static JLabel getGameLabel() {
		return gameLabel;
	}

	public static JLabel getStatisticsLabel() {
		return statisticsLabel;
	}
	
	public static JButton getAttackButton() {
		return attackButton;
	}

	public static JButton getAddArmyButton() {
		return addArmyButton;
	}
	
	public static JButton getRemoveArmyButton() {
		return removeArmyButton;
	}
	
	public static JComboBox getDestinationBox() {
		return destinationBox;
	}

	public static void main(String[] args) {

		// RiskBoard spelletje = new RiskBoard();
		RiskGame game = new RiskGame();
		game.newGame();

		/**
		 * game.divideProvinces(2); game.setUpPlayers(2);
		 * 
		 * ArrayList<Province> playerprov =
		 * RiskGame.player_one.getPlayerProvince();
		 * 
		 * for(Province province : playerprov) {
		 * System.out.println(province.getName()); }
		 * 
		 * System.out.println(RiskGame.player_one.getUnplacedArmies());
		 **/

	}
}
