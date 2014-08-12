package data;

import game.Card;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class NedCardData {
	
	public static ImageIcon cannonantwerpen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Antwerpen.png"));
	public static ImageIcon cannongroningen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Groningen.png"));
	public static ImageIcon cannonlimburg = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Limburg.png"));
	public static ImageIcon cannonluik = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Luik.png"));
	public static ImageIcon cannonoostvlaanderen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Oost-Vlaanderen.png"));
	public static ImageIcon cannonzeeland = new ImageIcon(GameData.class.getClass().getResource("/img/cards/cannon-Zeeland.png"));
	
	public static ImageIcon horsedrenthe = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Drenthe.png"));
	public static ImageIcon horsegelderland = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Gelderland.png"));
	public static ImageIcon horsehenegouwen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Henegouwen.png"));
	public static ImageIcon horsenamen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Namen.png"));
	public static ImageIcon horsenoordbrabant = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Noord-Brabant.png"));
	public static ImageIcon horsezuidbrabant = new ImageIcon(GameData.class.getClass().getResource("/img/cards/horse-Zuid-Brabant.png"));
	
	public static ImageIcon soldierfriesland = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-Friesland.png"));
	public static ImageIcon soldierholland = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-Holland.png"));
	public static ImageIcon soldierluxemburg = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-Luxemburg.png"));
	public static ImageIcon soldieroverijssel = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-Overijssel.png"));
	public static ImageIcon soldierutrecht = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-Utrecht.png"));
	public static ImageIcon soldierwestvlaanderen = new ImageIcon(GameData.class.getClass().getResource("/img/cards/soldier-West-Vlaanderen.png"));
	
	
	
	private static Card cardantwerpen = new Card(1, CardType.CANNON, NedMapData.ANTWERPEN, cannonantwerpen, null);
	private static Card cardgroningen = new Card(2, CardType.CANNON, NedMapData.GRONINGEN, cannongroningen, null);
	private static Card cardlimburg = new Card(3, CardType.CANNON, NedMapData.LIMBURG, cannonlimburg, null);
	private static Card cardluik = new Card(4, CardType.CANNON, NedMapData.LUIK, cannonluik, null);
	private static Card cardoostvlaanderen = new Card(5, CardType.CANNON, NedMapData.OOST_VLAANDEREN, cannonoostvlaanderen, null);
	private static Card cardzeeland = new Card(6, CardType.CANNON, NedMapData.ZEELAND, cannonzeeland, null);
	
	private static Card carddrenthe = new Card(7, CardType.HORSE, NedMapData.ZEELAND, horsedrenthe, null);
	private static Card cardgelderland = new Card(8, CardType.HORSE, NedMapData.GELDERLAND, horsegelderland, null);
	private static Card cardhenegouwen = new Card(9, CardType.HORSE, NedMapData.HENEGOUWEN, horsehenegouwen, null);
	private static Card cardnamen = new Card(10, CardType.HORSE, NedMapData.NAMEN, horsenamen, null);
	private static Card cardnoordbrabant = new Card(11, CardType.HORSE, NedMapData.NOORD_BRABANT, horsenoordbrabant, null);
	private static Card cardzuidbrabant = new Card(12, CardType.HORSE, NedMapData.ZUID_BRABANT, horsezuidbrabant, null);
	
	private static Card cardfriesland = new Card(13, CardType.SOLDIER, NedMapData.FRIESLAND, soldierfriesland, null);
	private static Card cardholland = new Card(14, CardType.SOLDIER, NedMapData.HOLLAND, soldierholland, null);
	private static Card cardluxemburg = new Card(15, CardType.SOLDIER, NedMapData.LUXEMBURG, soldierluxemburg, null);
	private static Card cardoverijssel = new Card(16, CardType.SOLDIER, NedMapData.OVERIJSSEL, soldieroverijssel, null);
	private static Card cardutrecht = new Card(17, CardType.SOLDIER, NedMapData.UTRECHT, soldierutrecht, null);
	private static Card cardwestvlaanderen = new Card(18, CardType.SOLDIER, NedMapData.WEST_VLAANDEREN, soldierwestvlaanderen, null);
	
	private static ArrayList<Card> gamecards;
	
	public NedCardData() {
		
	}
	
	public static ArrayList<Card> getGameCards() {
		
		gamecards = new ArrayList<Card>();
		gamecards.add(cardantwerpen);
		gamecards.add(cardgroningen);
		gamecards.add(cardlimburg);
		gamecards.add(cardluik);
		gamecards.add(cardoostvlaanderen);
		gamecards.add(cardzeeland);
		gamecards.add(carddrenthe);
		gamecards.add(cardgelderland);
		gamecards.add(cardhenegouwen);
		gamecards.add(cardnamen);
		gamecards.add(cardnoordbrabant);
		gamecards.add(cardzuidbrabant);
		gamecards.add(cardfriesland);
		gamecards.add(cardholland);
		gamecards.add(cardluxemburg);
		gamecards.add(cardoverijssel);
		gamecards.add(cardutrecht);
		gamecards.add(cardwestvlaanderen);
		
		return gamecards;
	}
	
	
}
