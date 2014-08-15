package data;

import game.Province;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Class contains database of all the provinces - for each province border
 * provinces are created to which can be moved/ attacked.
 * 
 * @author rogier_konings
 * 
 */
public class NedMapData extends CountryData {

	private static int circlesize = 20;

	// creates an array of possible provinces to move/ attack
	private static ArrayList<Province> desgroningen = new ArrayList<Province>();
	private static ArrayList<Province> desfriesland = new ArrayList<Province>();
	private static ArrayList<Province> desdrenthe = new ArrayList<Province>();
	private static ArrayList<Province> desoverijssel = new ArrayList<Province>();
	private static ArrayList<Province> desgelderland = new ArrayList<Province>();
	private static ArrayList<Province> desutrecht = new ArrayList<Province>();
	private static ArrayList<Province> desholland = new ArrayList<Province>();
	private static ArrayList<Province> desnoordbrabant = new ArrayList<Province>();
	private static ArrayList<Province> deszeeland = new ArrayList<Province>();
	private static ArrayList<Province> deswestvlaanderen = new ArrayList<Province>();
	private static ArrayList<Province> desoostvlaanderen = new ArrayList<Province>();
	private static ArrayList<Province> desantwerpen = new ArrayList<Province>();
	private static ArrayList<Province> deslimburg = new ArrayList<Province>();
	private static ArrayList<Province> deszuidbrabant = new ArrayList<Province>();
	private static ArrayList<Province> desluik = new ArrayList<Province>();
	private static ArrayList<Province> deshenegouwen = new ArrayList<Province>();
	private static ArrayList<Province> desnamen = new ArrayList<Province>();
	private static ArrayList<Province> desluxemburg = new ArrayList<Province>();

	ArrayList<Province> provinces;

	// Creates the provicne objects
	public static Province GRONINGEN = new Province(1, null, "Groningen",
			"Groningen", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(497,
					84, circlesize, circlesize), false, desgroningen,
			new Color(0x40a837));
	public static Province FRIESLAND = new Province(2, null, "Friesland",
			"Leeuwarden", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(405,
					90, circlesize, circlesize), false, desfriesland,
			new Color(0xfc0d0a));
	public static Province DRENTHE = new Province(3, null, "Drenthe", "Assen",
			Nationality.NEDERLANDS, 1, new Ellipse2D.Double(500, 122,
					circlesize, circlesize), false, desdrenthe, new Color(
					0xccfe07));
	public static Province OVERIJSSEL = new Province(4, null, "Overijssel",
			"Zwolle", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(455, 232,
					circlesize, circlesize), false, desoverijssel, new Color(
					0xc8ab36));
	public static Province GELDERLAND = new Province(5, null, "Gelderland",
			"Arnhem", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(442, 325,
					circlesize, circlesize), false, desgelderland, new Color(
					0xa368f0));
	public static Province UTRECHT = new Province(6, null, "Utrecht",
			"Utrecht", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(355,
					320, circlesize, circlesize), false, desutrecht, new Color(
					0xff6b2f));
	public static Province HOLLAND = new Province(7, null, "Holland",
			"Den Haag", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(234,
					337, circlesize, circlesize), false, desholland, new Color(
					0xfefe08));
	public static Province NOORD_BRABANT = new Province(8, null,
			"Noord-Brabant", "Den Bosch", Nationality.NEDERLANDS, 1,
			new Ellipse2D.Double(363, 402, circlesize, circlesize), false,
			desnoordbrabant, new Color(0xa96744));
	public static Province ZEELAND = new Province(9, null, "Zeeland",
			"Middelburg", Nationality.NEDERLANDS, 1, new Ellipse2D.Double(157,
					452, circlesize, circlesize), false, deszeeland, new Color(
					0x00f954));
	public static Province WEST_VLAANDEREN = new Province(10, null,
			"West-Vlaanderen", "Brugge", Nationality.VLAAMS, 1,
			new Ellipse2D.Double(114, 527, circlesize, circlesize), false,
			deswestvlaanderen, new Color(0x9a7b92));
	public static Province OOST_VLAANDEREN = new Province(11, null,
			"Oost-Vlaanderen", "Gent", Nationality.VLAAMS, 1,
			new Ellipse2D.Double(180, 542, circlesize, circlesize), false,
			desoostvlaanderen, new Color(0xfd3d86));
	public static Province ANTWERPEN = new Province(12, null, "Antwerpen",
			"Antwerpen", Nationality.VLAAMS, 1, new Ellipse2D.Double(268, 505,
					circlesize, circlesize), false, desantwerpen, new Color(
					0xc0d671));
	public static Province LIMBURG = new Province(13, null, "Limburg",
			"Maastricht", Nationality.VLAAMS, 1, new Ellipse2D.Double(422, 562,
					circlesize, circlesize), false, deslimburg, new Color(
					0x6f9070));
	public static Province ZUID_BRABANT = new Province(14, null,
			"Zuid-Brabant", "Brussel", Nationality.VLAAMS, 1,
			new Ellipse2D.Double(260, 580, circlesize, circlesize), false,
			deszuidbrabant, new Color(0xfdcb49));
	public static Province LUIK = new Province(15, null, "Luik", "Luik",
			Nationality.WAALS, 1, new Ellipse2D.Double(420, 615, circlesize,
					circlesize), false, desluik, new Color(0xfd5555));
	public static Province HENEGOUWEN = new Province(16, null, "Henegouwen",
			"Bergen", Nationality.WAALS, 1, new Ellipse2D.Double(217, 672,
					circlesize, circlesize), false, deshenegouwen, new Color(
					0x89a02b));
	public static Province NAMEN = new Province(17, null, "Namen", "Namen",
			Nationality.WAALS, 1, new Ellipse2D.Double(349, 657, circlesize,
					circlesize), false, desnamen, new Color(0xaa0187));
	public static Province LUXEMBURG = new Province(18, null, "Luxemburg",
			"Luxemburg", Nationality.WAALS, 1, new Ellipse2D.Double(521, 813,
					circlesize, circlesize), false, desluxemburg, new Color(
					0xa9fed2));

	// public Dimension NL_DIMENSIONS = new Dimension(742, 1042);

	public NedMapData() {

		addProvinces();
		addDestinations();

	}

	/**
	 * Adds the different Dutch provinces of 1815 to the database
	 * 
	 * @return the arraylist with the provinces of this current pack
	 */
	public void addProvinces() {

		provinces = new ArrayList<Province>();
		provinces.add(GRONINGEN);
		provinces.add(FRIESLAND);
		provinces.add(DRENTHE);
		provinces.add(OVERIJSSEL);
		provinces.add(GELDERLAND);
		provinces.add(UTRECHT);
		provinces.add(HOLLAND);
		provinces.add(NOORD_BRABANT);
		provinces.add(ZEELAND);
		provinces.add(WEST_VLAANDEREN);
		provinces.add(OOST_VLAANDEREN);
		provinces.add(ANTWERPEN);
		provinces.add(LIMBURG);
		provinces.add(ZUID_BRABANT);
		provinces.add(LUIK);
		provinces.add(HENEGOUWEN);
		provinces.add(NAMEN);
		provinces.add(LUXEMBURG);

	}

	/**
	 * Gets the list of provinces
	 * 
	 * @return ArrayList of provines
	 */
	public ArrayList<Province> getProvinces() {

		return provinces;

	}

	/**
	 * Adds the possible destinations to an array for each province
	 */
	public void addDestinations() {
		desgroningen.add(DRENTHE);
		desgroningen.add(FRIESLAND);

		desfriesland.add(GRONINGEN);
		desfriesland.add(DRENTHE);
		desfriesland.add(OVERIJSSEL);

		desdrenthe.add(GRONINGEN);
		desdrenthe.add(FRIESLAND);
		desdrenthe.add(OVERIJSSEL);

		desoverijssel.add(DRENTHE);
		desoverijssel.add(GELDERLAND);
		desoverijssel.add(FRIESLAND);

		desgelderland.add(OVERIJSSEL);
		desgelderland.add(UTRECHT);
		desgelderland.add(HOLLAND);
		desgelderland.add(NOORD_BRABANT);
		desgelderland.add(LIMBURG);

		desutrecht.add(GELDERLAND);
		desutrecht.add(HOLLAND);

		desholland.add(UTRECHT);
		desholland.add(NOORD_BRABANT);
		desholland.add(ZEELAND);
		desholland.add(FRIESLAND);
		desholland.add(GELDERLAND);

		deszeeland.add(HOLLAND);
		deszeeland.add(NOORD_BRABANT);
		deszeeland.add(ANTWERPEN);
		deszeeland.add(OOST_VLAANDEREN);
		deszeeland.add(WEST_VLAANDEREN);

		desnoordbrabant.add(GELDERLAND);
		desnoordbrabant.add(HOLLAND);
		desnoordbrabant.add(LIMBURG);
		desnoordbrabant.add(ANTWERPEN);
		desnoordbrabant.add(ZEELAND);

		deswestvlaanderen.add(ZEELAND);
		deswestvlaanderen.add(OOST_VLAANDEREN);
		deswestvlaanderen.add(HENEGOUWEN);

		desoostvlaanderen.add(ZEELAND);
		desoostvlaanderen.add(WEST_VLAANDEREN);
		desoostvlaanderen.add(ANTWERPEN);
		desoostvlaanderen.add(ZUID_BRABANT);
		desoostvlaanderen.add(HENEGOUWEN);

		desantwerpen.add(ZEELAND);
		desantwerpen.add(NOORD_BRABANT);
		desantwerpen.add(LIMBURG);
		desantwerpen.add(ZUID_BRABANT);
		desantwerpen.add(OOST_VLAANDEREN);

		deslimburg.add(GELDERLAND);
		deslimburg.add(NOORD_BRABANT);
		deslimburg.add(ANTWERPEN);
		deslimburg.add(ZUID_BRABANT);
		deslimburg.add(LUIK);

		deszuidbrabant.add(OOST_VLAANDEREN);
		deszuidbrabant.add(ANTWERPEN);
		deszuidbrabant.add(LIMBURG);
		deszuidbrabant.add(NAMEN);
		deszuidbrabant.add(HENEGOUWEN);
		deszuidbrabant.add(LUIK);

		deshenegouwen.add(WEST_VLAANDEREN);
		deshenegouwen.add(OOST_VLAANDEREN);
		deshenegouwen.add(ZUID_BRABANT);
		deshenegouwen.add(NAMEN);

		desnamen.add(HENEGOUWEN);
		desnamen.add(ZUID_BRABANT);
		desnamen.add(LUIK);
		desnamen.add(LUXEMBURG);

		desluik.add(LIMBURG);
		desluik.add(ZUID_BRABANT);
		desluik.add(NAMEN);
		desluik.add(LUXEMBURG);

		desluxemburg.add(NAMEN);
		desluxemburg.add(LUIK);
	}

}
