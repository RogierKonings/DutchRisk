package data;

import game.Province;

import java.util.ArrayList;

/**
 * Parent class of NedMapData - this class is used to generalize the loading
 * process of maps. This enables other maps to get loaded without changing the
 * main run files.
 * 
 * @author rogier_konings
 * 
 */
public class CountryData {

	private ArrayList<Province> provinces;

	public CountryData() {

	}

	public ArrayList<Province> getProvinces() {
		return provinces;
	}

}
