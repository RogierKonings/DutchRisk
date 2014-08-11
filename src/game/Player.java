package game;

import java.awt.Color;
import java.util.ArrayList;

import data.GameData;

/**
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
	 * Creates a new player
	 * 
	 * @param playerid
	 *            the number by which to identify the player
	 * @param unplaced_armies
	 *            the armies that this player still will have to place on their
	 *            provinces
	 * @param score
	 *            the score of the player
	 */
	public Player(int id, String name, int unplaced_armies, int score, Color playercolor, ArrayList<Card> playercards) {

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

	public ArrayList<Province> getPlayerProvince() {

		ArrayList<Province> playerprovinces = new ArrayList<Province>();

		for (Province province : GameData.provinces) {

			if (province.getPlayer().getId() == getId()) {
				playerprovinces.add(province);
			}

		}
		return playerprovinces;
	}

	public boolean isPlayerProvince(Province prov) {

		if (getId() == prov.getPlayer().getId()) {
			return true;
		}

		return false;
	}

	public ArrayList<Card> getPlayerCards() {
		
		ArrayList<Card> playercards = new ArrayList<Card>();
		
		for(Card card : GameData.gamecards) {
			
			if(card.getPlayer() != null && card.getPlayer().getName().equals(getName())) {
			
				playercards.add(card);
			}
			
		}
		return playercards;
	}
}
