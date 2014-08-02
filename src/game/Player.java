package game;

import java.util.ArrayList;

import data.Province;

/**
 * 
 * @author rogier_konings
 *
 */
public class Player {

	private int playerid;
	private int unplaced_armies;

	private ArrayList<Province> player_provinces;

	/**
	 * Creates a new player
	 * @param playerid the number by which to identify the player
	 * @param unplaced_armies the armies that this player still will have to place on their provinces
	 * @param score the score of the player
	 */
	public Player(int playerid, int unplaced_armies, int score) {
		this.playerid = playerid;
		this.unplaced_armies = unplaced_armies;
	}

	public int getPlayerId() {
		return playerid;
	}

	public int getUnplacedArmies() {
		return unplaced_armies;
	}

	public void setUnplacedArmies(int armies) {
		unplaced_armies = armies;
	}

	public ArrayList<Province> getPlayerProvince() {
		return player_provinces;
	}
	
	public void setPlayerProvinces(ArrayList<Province> prov) {
		player_provinces = prov;
	}
}
