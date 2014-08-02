package data;

import game.Player;

import java.awt.Shape;

import javax.swing.JPanel;

public class Province extends JPanel {

	private static final long serialVersionUID = -1513276616999805747L;
	private int id;
	private Player player;
	private int army = 0;
	private String name;
	private String capital;
	private Shape province;
	public boolean SELECTED = false;

	public Province(int id, Player player, String name, String capital, int army,
			Shape province, boolean SELECTED) {
		this.id = id;
		this.player = player;
		this.name = name;
		this.capital = capital;
		this.army = army;
		this.province = province;
		this.SELECTED = SELECTED;

	}

	public int getId() {
		return id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player plr) {
		player = plr;
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	public int getArmy() {
		return army;
	}
	
	public void setArmy(int amount) {
		army = amount;
	}

	public Shape getShapeProvince() {
		return province;
	}

	public void addArmy() {
		army++;
	}

	public void removeArmy() {
		army--;
	}

}
