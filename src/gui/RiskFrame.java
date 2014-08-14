package gui;

import game.Player;
import game.RiskGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import data.GameData;
import data.NedMapData;
import data.Scenario;

public class RiskFrame extends JFrame {

	private GameData data;
	private static RiskBoard board;

	private JButton startNewGameButton;
	private JTextField playerOneField;
	private JTextField playerTwoField;
	private JTextField playerThreeField;
	private JLabel informationLabel;
	private JComboBox scenarioComboBox;

	public RiskFrame() {

		loadData();
		// loadBoard();
		// loadPlayers(2);
		// loadScenario("historical");
		// RiskBoard.updateStatistics();

		getContentPane().setLayout(null);

		startNewGameButton = new JButton("Start New Game");
		startNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// RiskGame game = new RiskGame();

				if (playerOneField.getText().equals("")) {

					System.out.println("Please enter a name for player 1!");

				} else {

					String playerone = playerOneField.getText();
					GameData.PLAYER_ONE = new Player(1, playerone,
							GameData.STARTING_ARMIES, 0, Color.BLUE, null);
				}

				if (playerTwoField.getText().equals("")) {

					System.out.println("Please enter a name for player 2!");

				} else {
					String playertwo = playerTwoField.getText();
					GameData.PLAYER_TWO = new Player(2, playertwo,
							GameData.STARTING_ARMIES, 0, Color.RED, null);
				}

				if (playerThreeField.getText().equals("")) {

					GameData.PLAYER_AMOUNT = 2;
					System.out.println("Two players selected!");

				} else {

					GameData.PLAYER_AMOUNT = 3;
					System.out.println("Three players selected!");
					String playerthree = playerThreeField.getText();
					GameData.PLAYER_THREE = new Player(3, playerthree,
							GameData.STARTING_ARMIES, 0, Color.MAGENTA, null);

				}

				RiskGame newgame = new RiskGame();
				loadData();
				loadBoard();
				loadPlayers(GameData.PLAYER_AMOUNT);
				loadScenario(((String) scenarioComboBox.getSelectedItem()));
				RiskGame.updateStatistics();
			}
		});
		startNewGameButton.setBounds(104, 220, 230, 41);
		getContentPane().add(startNewGameButton);

		informationLabel = new JLabel();
		informationLabel.setBounds(22, 140, 400, 70);
		informationLabel
				.setText("<html>*** Please type the name of you players in the boxes <br><br> If you want to select two players, leave the 3rd player box empty! ***</html>");
		getContentPane().add(informationLabel);

		scenarioComboBox = new JComboBox();
		scenarioComboBox.setBounds(279, 96, 118, 27);
		scenarioComboBox.setSelectedItem(-1);
		scenarioComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				
				JComboBox cb = (JComboBox)e.getSource();
				String scenariodescription = (String) cb
						.getSelectedItem();
				//informationLabel.setText(scenariodescription);

			}


		});

		getContentPane().add(scenarioComboBox);

		for (int i = 0; i < GameData.scenarios.size(); i++) {

			scenarioComboBox.addItem(GameData.scenarios.get(i).getScenario());

		}

		JLabel playerOneLabel = new JLabel("Player 1");
		playerOneLabel.setBounds(22, 51, 61, 16);
		getContentPane().add(playerOneLabel);

		JLabel playerTwoLabel = new JLabel("Player 2");
		playerTwoLabel.setBounds(22, 79, 61, 16);
		getContentPane().add(playerTwoLabel);

		JLabel playerThreeLabel = new JLabel("Player 3");
		playerThreeLabel.setBounds(22, 107, 61, 16);
		getContentPane().add(playerThreeLabel);

		playerOneField = new JTextField();
		playerOneField.setBounds(95, 45, 134, 28);
		getContentPane().add(playerOneField);
		playerOneField.setColumns(10);

		playerTwoField = new JTextField();
		playerTwoField.setColumns(10);
		playerTwoField.setBounds(95, 73, 134, 28);
		getContentPane().add(playerTwoField);

		playerThreeField = new JTextField();
		playerThreeField.setColumns(10);
		playerThreeField.setBounds(95, 101, 134, 28);
		getContentPane().add(playerThreeField);

		JLabel scenarioLabel = new JLabel("Scenario");
		scenarioLabel.setBounds(287, 73, 61, 16);
		getContentPane().add(scenarioLabel);

		this.setSize(408, 300);
		this.setLocation(200, 200);
		this.setTitle("RISK - New Game Screen ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * Loads all the necessary data
	 */
	public static void loadData() {
		GameData data = new GameData(new NedMapData());
	}

	/**
	 * Loads the selected map
	 */
	public static void loadBoard() {
		board = new RiskBoard();
	}

	/**
	 * Sets the current players
	 * 
	 * @param amount
	 *            the number of players
	 */
	public void loadPlayers(int amount) {

		GameData.CURRENT_PLAYER = GameData.PLAYER_ONE;
		GameData.PLAYER_AMOUNT = amount;
	}

	/**
	 * Loads a scenario
	 * 
	 * @param scenario
	 *            the String representation of the different scenarios eg.
	 *            historical, random, germaninvasion
	 */
	public void loadScenario(String scenario) {
		Scenario scen = new Scenario(scenario);
	}

	public static void main(String[] args) {

		RiskFrame fram = new RiskFrame();
		// GameData data = new GameData(new NedMapData());

	}
}
