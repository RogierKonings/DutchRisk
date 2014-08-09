package game;

import java.awt.Color;
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
	private int[] playerdicethrow = null;
	private Color playercolor;

	/**
	 * Creates a new player
	 * @param playerid the number by which to identify the player
	 * @param unplaced_armies the armies that this player still will have to place on their provinces
	 * @param score the score of the player
	 */
	public Player(int playerid, int unplaced_armies, int score, Color playercolor) {
		this.playerid = playerid;
		this.unplaced_armies = unplaced_armies;
		this.playercolor = playercolor;
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
	
	public int[] getPlayerDiceThrow() {
		return playerdicethrow;
	}
	
	public void setPlayerDiceThrow(int[] dicethrow) {
		playerdicethrow = dicethrow;
	}
	
	public Color getPlayerColor() {
		return playercolor;
	}
	
	public boolean isPlayerProvince(Province province) {
		
		for(Province prov : player_provinces) {
			
			if( prov.equals(province)) {
				return true;
			}
			
		}
		return false;
	}
}
