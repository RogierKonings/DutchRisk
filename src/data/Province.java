package data;

import game.Player;

import java.awt.Shape;

import javax.swing.JPanel;

/**
 * 
 * @author rogier_konings
 *
 */
public class Province extends JPanel {

	private static final long serialVersionUID = -1513276616999805747L;
	private int id;
	private Player player;
	private int army = 0;
	private String name;
	private String capital;
	private Shape province;
	public boolean SELECTED = false;
	private Province[] destinations;

	/**
	 * Creates a new province
	 * @param id unique number by which to identify the province
	 * @param player the current owner
	 * @param name signifies the name of the province
	 * @param capital the capital city of the province
	 * @param army the size of the army residing in the province
	 * @param province the shape on which to click on in order to make the province selectable
	 * @param SELECTED whether or not the province is selected
	 * @param MOVETO whether or not the province is a target
	 */
	public Province(int id, Player player, String name, String capital, int army,
			Shape province, boolean SELECTED, Province[] destinations) {
		this.id = id;
		this.player = player;
		this.name = name;
		this.capital = capital;
		this.army = army;
		this.province = province;
		this.SELECTED = SELECTED;
		this.destinations = destinations;

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
	
	public Province[] getDestinations() {
		return destinations;
	}
	
}
