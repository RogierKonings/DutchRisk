package game;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import data.GameData;
import data.Nationality;

/**
 * Class that creates the Province objects
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
	 * 
	 * @param id
	 *            number by which to identify the province
	 * @param player
	 *            the current owner of this province
	 * @param name
	 *            the name of the province
	 * @param capital
	 *            the capital of the province
	 * @param nation
	 *            ENUM nationality to which this province historically belongs
	 * @param army
	 *            the size of the army currently residing on this province
	 * @param capitallocation
	 *            location of the capital - the shape is also used to display
	 *            the army amount
	 * @param SELECTED
	 *            checks whether the province is currently selected
	 * @param destinations
	 *            a list of the possible destinations to move/ attack to from
	 *            this province
	 * @param color
	 *            the current color of this province
	 */
	public Province(int id, Player player, String name, String capital,
			Nationality nation, int army, Ellipse2D capitallocation,
			boolean SELECTED, Province[] destinations, Color color) {
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
