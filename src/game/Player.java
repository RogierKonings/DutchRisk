package game;

import java.awt.Color;
import java.util.ArrayList;

import data.GameData;

/**
 * Class that creates player objects
 * 
 * @author rogier_konings
 * 
 */
public class Player {

	private int id;
	private String name;
	private int unplaced_armies;
	private int score;
	private Color playercolor;
	private Player player;
	private ArrayList<Card> playercards;

	/**
	 * 
	 * @param id
	 *            number used to identify the player
	 * @param name
	 *            the name of the player
	 * @param unplaced_armies
	 *            the amount of armies that the player can still place of the
	 *            board
	 * @param score
	 *            the current score of the player
	 * @param playercolor
	 *            the colour the the player has currently chosen
	 * @param playercards
	 *            the cards that the player currently has
	 */
	public Player(int id, String name, int unplaced_armies, int score,
			Color playercolor, ArrayList<Card> playercards) {

		this.id = id;
		this.name = name;
		this.unplaced_armies = unplaced_armies;
		this.playercolor = playercolor;
		this.playercards = playercards;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Color getPlayerColor() {
		return playercolor;
	}

	public int getUnplacedArmies() {
		return unplaced_armies;
	}

	public void setUnplacedArmies(int armies) {
		unplaced_armies = armies;
	}

	public void addUnplacedArmies(int armies) {
		unplaced_armies = unplaced_armies + armies;
	}

	/**
	 * 
	 * @return an ArrayList with the provinces that the player currently
	 *         possesses
	 */
	public ArrayList<Province> getPlayerProvince() {

		ArrayList<Province> playerprovinces = new ArrayList<Province>();

		for (Province province : GameData.provinces) {

			if (province.getPlayer().getId() == getId()) {
				playerprovinces.add(province);
			}

		}
		return playerprovinces;
	}

	/**
	 * Check whether the player has this specific province
	 * 
	 * @param prov
	 *            the province that is being checked
	 * @return true in case of a possession, false otherwise
	 */
	public boolean isPlayerProvince(Province prov) {

		if (getId() == prov.getPlayer().getId()) {
			return true;
		}

		return false;
	}

	/**
	 * Counts the provinces that the player currently possesses
	 * 
	 * @return the number of provinces that the player possesses
	 */
	public int countPlayerProvinces() {

		int count = 0;

		for (Province province : GameData.provinces) {

			if (province.getPlayer().getId() == getId()) {
				count++;
			}

		}
		return count;
	}

	/**
	 * Counts the total amount of armies that the player currentl possesses
	 * 
	 * @return the number of armies that the player possesses
	 */
	public int countPlayerArmies() {

		int count = 0;

		for (Province province : GameData.provinces) {

			if (province.getPlayer().getId() == getId()) {
				count = count + province.getArmy();
			}

		}
		return count;
	}

	/**
	 * Returns a list of the player's cards
	 * 
	 * @return an ArrayList of the player's cards
	 */
	public ArrayList<Card> getPlayerCards() {

		ArrayList<Card> playercards = new ArrayList<Card>();

		for (Card card : GameData.gamecards) {

			if (card.getPlayer() != null
					&& card.getPlayer().getName().equals(getName())) {

				playercards.add(card);
			}

		}
		return playercards;
	}

	/**
	 * Counts the number of cards currently in the possession of the player
	 * 
	 * @return the number of cards
	 */
	public int getNumberOfCards() {

		int numberofcards = 0;

		for (Card card : GameData.gamecards) {

			if (card.getPlayer() != null
					&& card.getPlayer() == GameData.CURRENT_PLAYER) {
				numberofcards++;
			}

		}
		return numberofcards;
	}

}
