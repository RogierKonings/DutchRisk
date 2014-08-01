package data;

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


public class NedData extends GameData{
	
	ArrayList<Province> nedprovinces;
	
	private static Province GRONINGEN = new Province(1, 0, "Groningen", "Groningen", 0, new Ellipse2D.Double(503, 84, 14, 14), false);
	private static Province FRIESLAND = new Province(2, 0, "Friesland", "Leeuwarden", 0, new Ellipse2D.Double(406, 99, 14, 14), false);
	private static Province DRENTHE = new Province(3, 0, "Drenthe", "Assen", 0, new Ellipse2D.Double(503, 130, 14, 14), false);
	private static Province OVERIJSSEL = new Province(4, 0, "Overijssel", "Zwolle", 0, new Ellipse2D.Double(457, 230, 14, 14), false);
	private static Province GELDERLAND = new Province(5, 0, "Gelderland", "Arnhem", 0, new Ellipse2D.Double(442, 334, 14, 14), false);
	private static Province UTRECHT = new Province(6, 0, "Utrecht", "Utrecht", 0, new Ellipse2D.Double(355, 325, 14, 14), false);
	private static Province HOLLAND = new Province(7, 0, "Holland", "Den Haag", 0, new Ellipse2D.Double(234, 342, 14, 14), false);
	private static Province NOORD_BRABANT = new Province(8, 0, "Noord-Brabant", "Den Bosch", 0, new Ellipse2D.Double(370, 402, 14, 14), false);
	private static Province ZEELAND = new Province(9, 0, "Zeeland", "Middelburg", 0, new Ellipse2D.Double(157, 460, 14, 14), false);
	private static Province WEST_VLAANDEREN = new Province(10, 0, "West-Vlaanderen", "Brugge", 0, new Ellipse2D.Double(112, 530, 14, 14), false);
	private static Province OOST_VLAANDEREN = new Province(11, 0, "Oost-Vlaanderen", "Gent", 0, new Ellipse2D.Double(182, 541, 14, 14), false);
	private static Province ANTWERPEN = new Province(12, 0, "Antwerpen", "Antwerpen", 0, new Ellipse2D.Double(268, 505, 14, 14), false);
	private static Province LIMBURG = new Province(13, 0, "Limburg", "Maastricht", 0, new Ellipse2D.Double(422, 568, 14, 14), false);
	private static Province ZUID_BRABANT = new Province(14, 0, "Zuid-Brabant", "Brussel", 0, new Ellipse2D.Double(262, 587, 14, 14), false);
	private static Province LUIK = new Province(15, 0, "Luik", "Luik", 0, new Ellipse2D.Double(420, 615, 14, 14), false);
	private static Province HENEGOUWEN = new Province(16, 0, "Henegouwen", "Bergen", 0, new Ellipse2D.Double(223, 672, 14, 14), false);
	private static Province NAMEN = new Province(17, 0, "Namen", "Namen", 0, new Ellipse2D.Double(349, 665, 14, 14), false);
	private static Province LUXEMBURG = new Province(18, 0, "Luxemburg", "Luxemburg", 0, new Ellipse2D.Double(521, 813, 14, 14), false);
	
	public static Dimension NL_DIMENSIONS = new Dimension(742, 1042);
	
	
	public NedData() {
		
		createProvinces();
		
	}
	/**
	 * Adds the different Dutch provinces of 1815 to the database
	 * @return the arraylist with the provinces of this current pack
	 */
	public ArrayList<Province> createProvinces() {
		
		nedprovinces = new ArrayList<Province>();
		nedprovinces.add(GRONINGEN);
		nedprovinces.add(FRIESLAND);
		nedprovinces.add(DRENTHE);
		nedprovinces.add(OVERIJSSEL);
		nedprovinces.add(GELDERLAND);
		nedprovinces.add(UTRECHT);
		nedprovinces.add(HOLLAND);
		nedprovinces.add(NOORD_BRABANT);
		nedprovinces.add(ZEELAND);
		nedprovinces.add(WEST_VLAANDEREN);
		nedprovinces.add(OOST_VLAANDEREN);
		nedprovinces.add(ANTWERPEN);
		nedprovinces.add(LIMBURG);
		nedprovinces.add(ZUID_BRABANT);
		nedprovinces.add(LUIK);
		nedprovinces.add(HENEGOUWEN);
		nedprovinces.add(NAMEN);
		nedprovinces.add(LUXEMBURG);
		
		return nedprovinces;
		
	}
	
	public ArrayList<Province> getProvinces() {
		
		return nedprovinces;
		
	}
	

}
	
