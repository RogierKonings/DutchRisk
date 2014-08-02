package game;

import java.util.ArrayList;

import data.Province;

public class Player {

	private int playerid;
	private int unplaced_armies;

	private ArrayList<Province> player_provinces;


	public Player(int playerid, int unplaced_armies) {
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
