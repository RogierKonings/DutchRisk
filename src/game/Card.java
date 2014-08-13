package game;

import javax.swing.ImageIcon;

import data.CardType;

/**
 * Class that creates a Card object
 * 
 * @author rogier_konings
 * 
 */
public class Card {

	private int id;
	private CardType type;
	private Province province;
	private ImageIcon icon;
	private Player player;

	/**
	 * 
	 * @param id
	 *            number to identify the card
	 * @param type
	 *            ENUM to identify the type of card
	 * @param province
	 *            to which province this card belongs - useful for deciding
	 *            whether the player will receive additional armies when they
	 *            possess this province
	 * @param icon
	 *            image of the card
	 * @param player
	 *            the player the currently holds the card
	 */
	public Card(int id, CardType type, Province province, ImageIcon icon,
			Player player) {

		this.id = id;
		this.type = type;
		this.province = province;
		this.icon = icon;
		this.player = player;

	}

	public int getId() {
		return id;
	}

	public CardType getCardType() {
		return type;
	}

	public Province getCardProvince() {
		return province;
	}

	public ImageIcon getCardIcon() {
		return icon;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player plr) {
		player = plr;
	}

}
