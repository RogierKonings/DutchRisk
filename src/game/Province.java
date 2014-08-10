package game;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import data.GameData;
import data.Nationality;

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
	private Nationality nation;
	private Ellipse2D capitallocation;
	public boolean SELECTED = false;
	private Province[] destinations;
	private Color color;

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
	public Province(int id, Player player, String name, String capital, Nationality nation, int army,
			Ellipse2D capitallocation, boolean SELECTED, Province[] destinations, Color color) {
		this.id = id;
		this.player = player;
		this.name = name;
		this.capital = capital;
		this.nation = nation;
		this.army = army;
		this.capitallocation = capitallocation;
		this.SELECTED = SELECTED;
		this.destinations = destinations;
		this.color = color;
	}
	

	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public Nationality getNation() {
		return nation;
	}

	public int getArmy() {
		return army;
	}
	
	public void addArmy() {
		army++;
	}

	public void removeArmy() {
		army--;
	}
	
	public Ellipse2D getCapitalLocation() {
		return capitallocation;
	}
	
	public Province[] getDestinations() {
		return destinations;
	}
	
	public Color getColor() {
		return color;
	}
	
}
