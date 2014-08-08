package data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * 
 * @author rogier_konings
 * 
 */
public class NedData extends GameData {

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

	private static int circlesize = 14;

	// creates an array with all the provinces
	ArrayList<Province> nedprovinces;

	private static Province GRONINGEN = new Province(1, null, "Groningen",
			"Groningen", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(503,
					84, circlesize, circlesize), false, desgroningen,
			new Color(0x40a837));
	private static Province FRIESLAND = new Province(2, null, "Friesland",
			"Leeuwarden", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(406,
					99, circlesize, circlesize), false, desfriesland,
			new Color(0xfc0d0a));
	private static Province DRENTHE = new Province(3, null, "Drenthe", "Assen",
			Nationality.NEDERLANDS, 0, new Ellipse2D.Double(503, 130,
					circlesize, circlesize), false, desdrenthe, new Color(
					0xccfe07));
	private static Province OVERIJSSEL = new Province(4, null, "Overijssel",
			"Zwolle", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(457, 230,
					circlesize, circlesize), false, desoverijssel, new Color(
					0xc8ab36));
	private static Province GELDERLAND = new Province(5, null, "Gelderland",
			"Arnhem", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(442, 334,
					circlesize, circlesize), false, desgelderland, new Color(
					0xa368f0));
	private static Province UTRECHT = new Province(6, null, "Utrecht",
			"Utrecht", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(355,
					325, circlesize, circlesize), false, desutrecht, new Color(
					0xff6b2f));
	private static Province HOLLAND = new Province(7, null, "Holland",
			"Den Haag", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(234,
					342, circlesize, circlesize), false, desholland, new Color(
					0xfefe08));
	private static Province NOORD_BRABANT = new Province(8, null,
			"Noord-Brabant", "Den Bosch", Nationality.NEDERLANDS, 0,
			new Ellipse2D.Double(370, 402, circlesize, circlesize), false,
			desnoordbrabant, new Color(0xa96744));
	private static Province ZEELAND = new Province(9, null, "Zeeland",
			"Middelburg", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(157,
					460, circlesize, circlesize), false, deszeeland, new Color(
					0x00f954));
	private static Province WEST_VLAANDEREN = new Province(10, null,
			"West-Vlaanderen", "Brugge", Nationality.VLAAMS, 0,
			new Ellipse2D.Double(112, 530, circlesize, circlesize), false,
			deswestvlaanderen, new Color(0x9a7b92));
	private static Province OOST_VLAANDEREN = new Province(11, null,
			"Oost-Vlaanderen", "Gent", Nationality.VLAAMS, 0,
			new Ellipse2D.Double(182, 541, circlesize, circlesize), false,
			desoostvlaanderen, new Color(0xfd3d86));
	private static Province ANTWERPEN = new Province(12, null, "Antwerpen",
			"Antwerpen", Nationality.VLAAMS, 0, new Ellipse2D.Double(268, 505,
					circlesize, circlesize), false, desantwerpen, new Color(
					0xc0d671));
	private static Province LIMBURG = new Province(13, null, "Limburg",
			"Maastricht", Nationality.NEDERLANDS, 0, new Ellipse2D.Double(422,
					568, circlesize, circlesize), false, deslimburg, new Color(
					0x6f9070));
	private static Province ZUID_BRABANT = new Province(14, null,
			"Zuid-Brabant", "Brussel", Nationality.VLAAMS, 0,
			new Ellipse2D.Double(262, 587, circlesize, circlesize), false,
			deszuidbrabant, new Color(0xfdcb49));
	private static Province LUIK = new Province(15, null, "Luik", "Luik",
			Nationality.WAALS, 0, new Ellipse2D.Double(420, 615, circlesize,
					circlesize), false, desluik, new Color(0xfd5555));
	private static Province HENEGOUWEN = new Province(16, null, "Henegouwen",
			"Bergen", Nationality.WAALS, 0, new Ellipse2D.Double(223, 672,
					circlesize, circlesize), false, deshenegouwen, new Color(
					0x89a02b));
	private static Province NAMEN = new Province(17, null, "Namen", "Namen",
			Nationality.WAALS, 0, new Ellipse2D.Double(349, 665, circlesize,
					circlesize), false, desnamen, new Color(0xaa0187));
	private static Province LUXEMBURG = new Province(18, null, "Luxemburg",
			"Luxemburg", Nationality.WAALS, 0, new Ellipse2D.Double(521, 813,
					circlesize, circlesize), false, desluxemburg, new Color(
					0xa9fed2));

	public static Dimension NL_DIMENSIONS = new Dimension(742, 1042);

	public NedData() {

		createProvinces();
		createDestinations();

	}

	/**
	 * Adds the different Dutch provinces of 1815 to the database
	 * 
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

	/**
	 * Gets the list of provinces
	 * 
	 * @return ArrayList of provines
	 */
	public ArrayList<Province> getProvinces() {

		return nedprovinces;

	}

	/**
	 * Adds the possible destinations to an array for each province
	 */
	public void createDestinations() {
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
