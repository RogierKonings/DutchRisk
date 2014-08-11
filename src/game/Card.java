package game;

import javax.swing.ImageIcon;

import data.CardType;

public class Card {
	
	private int id;
	private CardType type;
	private Province province;
	private ImageIcon icon;
	private Player player;
	
	public Card(int id, CardType type, Province province, ImageIcon icon, Player player) {
		
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
