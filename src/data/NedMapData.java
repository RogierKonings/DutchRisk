package data;

import game.Province;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * 
 * @author rogier_konings
 * 
 */
public class NedMapData extends CountryData{
	
	private static int circlesize = 20;

	// creates an array of possible provinces to attack
	private static Province[] desgroningen = new Province[2];
	private static Province[] desfriesland = new Province[3];
	private static Province[] desdrenthe = new Province[3];
	private static Province[] desoverijssel = new Province[3];
	private static Province[] desgelderland = new Province[5];
	private static Province[] desutrecht = new Province[2];
	private static Province[] desholland = new Province[5];
	private static Province[] desnoordbrabant = new Province[5];
	private static Province[] deszeeland = new Province[5];
	private static Province[] deswestvlaanderen = new Province[3];
	private static Province[] desoostvlaanderen = new Province[5];
	private static Province[] desantwerpen = new Province[5];
	private static Province[] deslimburg = new Province[5];
	private static Province[] deszuidbrabant = new Province[6];
	private static Province[] desluik = new Province[4];
	private static Province[] deshenegouwen = new Province[4];
	private static Province[] desnamen = new Province[4];
	private static Province[] desluxemburg = new Province[2];

	// creates an array with all the provinces
	ArrayList<Province> provinces;

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
			"Maastricht", Nationality.VLAAMS, 1, new Ellipse2D.Double(422,
					562, circlesize, circlesize), false, deslimburg, new Color(
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
	

	

	//public Dimension NL_DIMENSIONS = new Dimension(742, 1042);

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
		desgroningen[0] = DRENTHE;
		desgroningen[1] = FRIESLAND;

		desfriesland[0] = GRONINGEN;
		desfriesland[1] = DRENTHE;
		desfriesland[2] = OVERIJSSEL;

		desdrenthe[0] = GRONINGEN;
		desdrenthe[1] = FRIESLAND;
		desdrenthe[2] = OVERIJSSEL;

		desoverijssel[0] = DRENTHE;
		desoverijssel[1] = GELDERLAND;
		desoverijssel[2] = FRIESLAND;

		desgelderland[0] = OVERIJSSEL;
		desgelderland[1] = UTRECHT;
		desgelderland[2] = HOLLAND;
		desgelderland[3] = NOORD_BRABANT;
		desgelderland[4] = LIMBURG;

		desutrecht[0] = GELDERLAND;
		desutrecht[1] = HOLLAND;

		desholland[0] = UTRECHT;
		desholland[1] = NOORD_BRABANT;
		desholland[2] = ZEELAND;
		desholland[3] = FRIESLAND;
		desholland[4] = GELDERLAND;

		deszeeland[0] = HOLLAND;
		deszeeland[1] = NOORD_BRABANT;
		deszeeland[2] = ANTWERPEN;
		deszeeland[3] = OOST_VLAANDEREN;
		deszeeland[4] = WEST_VLAANDEREN;

		desnoordbrabant[0] = GELDERLAND;
		desnoordbrabant[1] = HOLLAND;
		desnoordbrabant[2] = LIMBURG;
		desnoordbrabant[3] = ANTWERPEN;
		desnoordbrabant[4] = ZEELAND;

		deswestvlaanderen[0] = ZEELAND;
		deswestvlaanderen[1] = OOST_VLAANDEREN;
		deswestvlaanderen[2] = HENEGOUWEN;

		desoostvlaanderen[0] = ZEELAND;
		desoostvlaanderen[1] = WEST_VLAANDEREN;
		desoostvlaanderen[2] = ANTWERPEN;
		desoostvlaanderen[3] = ZUID_BRABANT;
		desoostvlaanderen[4] = HENEGOUWEN;

		desantwerpen[0] = ZEELAND;
		desantwerpen[1] = NOORD_BRABANT;
		desantwerpen[2] = LIMBURG;
		desantwerpen[3] = ZUID_BRABANT;
		desantwerpen[4] = OOST_VLAANDEREN;

		deslimburg[0] = GELDERLAND;
		deslimburg[1] = NOORD_BRABANT;
		deslimburg[2] = ANTWERPEN;
		deslimburg[3] = ZUID_BRABANT;
		deslimburg[4] = LUIK;

		deszuidbrabant[0] = OOST_VLAANDEREN;
		deszuidbrabant[1] = ANTWERPEN;
		deszuidbrabant[2] = LIMBURG;
		deszuidbrabant[3] = NAMEN;
		deszuidbrabant[4] = HENEGOUWEN;
		deszuidbrabant[5] = LUIK;

		deshenegouwen[0] = WEST_VLAANDEREN;
		deshenegouwen[1] = OOST_VLAANDEREN;
		deshenegouwen[2] = ZUID_BRABANT;
		deshenegouwen[3] = NAMEN;

		desnamen[0] = HENEGOUWEN;
		desnamen[1] = ZUID_BRABANT;
		desnamen[2] = LUIK;
		desnamen[3] = LUXEMBURG;

		desluik[0] = LIMBURG;
		desluik[1] = ZUID_BRABANT;
		desluik[2] = NAMEN;
		desluik[3] = LUXEMBURG;

		desluxemburg[0] = NAMEN;
		desluxemburg[1] = LUIK;
	}

}
